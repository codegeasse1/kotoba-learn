package com.nexo.kotoba

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import kotlin.math.max
import kotlin.math.min

enum class Direction { JAPANESE, ENGLISH, BOTH }

data class Card(
    var interval: Int = 0,
    var ease: Double = 2.5,
    var reps: Int = 0,
    var due: Long = 0L,
    var lapses: Int = 0
)

class Store(private val ctx: Context) {

    var xp by mutableStateOf(0)
        private set
    var streak by mutableStateOf(0)
        private set
    var bestStreak by mutableStateOf(0)
        private set
    var lastDay by mutableStateOf(0L)
        private set
    var learnedKana by mutableStateOf(setOf<String>())
        private set
    var completedLessons by mutableStateOf(setOf<String>())
        private set
    var srs by mutableStateOf(mapOf<String, Card>())
        private set

    var direction by mutableStateOf(Direction.JAPANESE)
    var nativeLang by mutableStateOf("en")
    var onboarded by mutableStateOf(false)
    var showRomaji by mutableStateOf(true)
    var showTranslations by mutableStateOf(true)
    var speechRate by mutableStateOf(0.85f)
    var dailyNewLimit by mutableStateOf(20)

    private val file: File = File(ctx.filesDir, "kotoba.json")

    fun load() {
        if (!file.exists()) return
        try {
            val o = JSONObject(file.readText())
            xp = o.optInt("xp", 0)
            streak = o.optInt("streak", 0)
            bestStreak = o.optInt("best", 0)
            lastDay = o.optLong("lastDay", 0)
            direction = runCatching { Direction.valueOf(o.optString("direction", "JAPANESE")) }.getOrDefault(Direction.JAPANESE)
            nativeLang = o.optString("native", "en")
            onboarded = o.optBoolean("onboarded", false)
            showRomaji = o.optBoolean("showRomaji", true)
            showTranslations = o.optBoolean("showTranslations", true)
            speechRate = o.optDouble("rate", 0.85).toFloat()
            learnedKana = strSet(o, "kana")
            completedLessons = strSet(o, "lessons")
            val arr = o.optJSONArray("srs") ?: JSONArray()
            val m = mutableMapOf<String, Card>()
            for (i in 0 until arr.length()) {
                val c = arr.getJSONObject(i)
                m[c.getString("id")] = Card(
                    interval = c.optInt("i", 0),
                    ease = c.optDouble("e", 2.5),
                    reps = c.optInt("r", 0),
                    due = c.optLong("d", 0),
                    lapses = c.optInt("l", 0)
                )
            }
            srs = m
        } catch (_: Exception) {
        }
    }

    private fun strSet(o: JSONObject, k: String): Set<String> {
        val out = mutableSetOf<String>()
        val a = o.optJSONArray(k) ?: JSONArray()
        for (i in 0 until a.length()) out.add(a.getString(i))
        return out
    }

    fun save() {
        try {
            val o = JSONObject()
            o.put("xp", xp)
            o.put("streak", streak)
            o.put("best", bestStreak)
            o.put("lastDay", lastDay)
            o.put("direction", direction.name)
            o.put("native", nativeLang)
            o.put("onboarded", onboarded)
            o.put("showRomaji", showRomaji)
            o.put("showTranslations", showTranslations)
            o.put("rate", speechRate.toDouble())
            o.put("kana", JSONArray(learnedKana.toList()))
            o.put("lessons", JSONArray(completedLessons.toList()))
            val arr = JSONArray()
            for ((id, c) in srs) {
                arr.put(
                    JSONObject()
                        .put("id", id).put("i", c.interval).put("e", c.ease)
                        .put("r", c.reps).put("d", c.due).put("l", c.lapses)
                )
            }
            o.put("srs", arr)
            file.writeText(o.toString())
        } catch (_: Exception) {
        }
    }

    private fun today(): Long = java.time.LocalDate.now().toEpochDay()

    fun recordPractice() {
        val t = today()
        if (lastDay == t) return
        streak = if (lastDay == t - 1) streak + 1 else 1
        bestStreak = max(bestStreak, streak)
        lastDay = t
        save()
    }

    fun addXp(n: Int) {
        xp += n
        save()
    }

    fun toggleKana(id: String) {
        learnedKana = if (id in learnedKana) learnedKana - id else learnedKana + id
        save()
    }

    fun completeLesson(id: String, wordIds: List<String>) {
        completedLessons = completedLessons + id
        val now = System.currentTimeMillis()
        val m = srs.toMutableMap()
        for (w in wordIds) {
            if (m[w] == null) m[w] = Card(due = now)
        }
        srs = m
        addXp(wordIds.size * 5)
        recordPractice()
        save()
    }

    fun addNewCards(wordIds: List<String>) {
        val now = System.currentTimeMillis()
        val m = srs.toMutableMap()
        for (w in wordIds) if (m[w] == null) m[w] = Card(due = now)
        srs = m
        save()
    }

    fun toggleCard(id: String) {
        val m = srs.toMutableMap()
        if (m[id] == null) m[id] = Card(due = System.currentTimeMillis()) else m.remove(id)
        srs = m
        save()
    }

    fun dueCount(): Int = srs.values.count { it.due <= System.currentTimeMillis() }

    fun dueCards(limit: Int = 25): List<Pair<String, Card>> =
        srs.filter { it.value.due <= System.currentTimeMillis() }
            .toList()
            .sortedBy { it.second.due }
            .take(limit)

    fun grade(id: String, q: Int) {
        val c = srs[id] ?: return
        val now = System.currentTimeMillis()
        when (q) {
            0 -> {
                c.reps = 0
                c.interval = 0
                c.lapses += 1
                c.ease = max(1.3, c.ease - 0.2)
                c.due = now + 10 * 60 * 1000L
            }
            1 -> {
                c.reps += 1
                c.interval = if (c.reps <= 1) 1 else max(1, (c.interval * 1.2).toInt())
                c.ease = max(1.3, c.ease - 0.15)
                c.due = now + c.interval * 86_400_000L
            }
            2 -> {
                c.reps += 1
                c.interval = if (c.reps == 1) 1 else if (c.reps == 2) 6 else (c.interval * c.ease).toInt()
                c.due = now + max(1, c.interval) * 86_400_000L
            }
            else -> {
                c.reps += 1
                c.interval = if (c.reps == 1) 2 else if (c.reps == 2) 10 else (c.interval * c.ease * 1.3).toInt()
                c.ease = min(3.5, c.ease + 0.15)
                c.due = now + max(1, c.interval) * 86_400_000L
            }
        }
        addXp(if (q == 0) 1 else 5)
        save()
    }

    fun wordsLearnedCount(): Int = srs.size

    fun level(): Int = xp / 250 + 1

    fun levelProgress(): Float = (xp % 250) / 250f

    fun kanaProgress(): Int =
        if (KanaData.all.isEmpty()) 0 else learnedKana.count { it in KanaData.allIds } * 100 / KanaData.all.size

    fun kanjiProgress(): Int =
        if (KanjiData.all.isEmpty()) 0 else learnedKana.count { it in KanjiData.allIds } * 100 / KanjiData.all.size

    fun setNative(lang: String) {
        nativeLang = lang
        save()
    }

    fun setOnboarded() {
        onboarded = true
        save()
    }

    fun finishOnboarding(native: String, dir: Direction) {
        nativeLang = native
        direction = dir
        onboarded = true
        save()
    }

    fun resetAll() {
        xp = 0
        streak = 0
        bestStreak = 0
        lastDay = 0
        learnedKana = emptySet()
        completedLessons = emptySet()
        srs = emptyMap()
        onboarded = false
        file.delete()
    }
}
