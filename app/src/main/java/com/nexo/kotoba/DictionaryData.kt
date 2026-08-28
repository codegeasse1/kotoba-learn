package com.nexo.kotoba

import android.content.Context

data class EnEntry(val head: String, val hi: String, val pos: String = "")
data class JaEntry(
    val kanji: String,
    val kana: String,
    val romaji: String,
    val pos: String = "",
    val common: Boolean = false,
    val gloss: String = ""
)

sealed class DictEntry {
    data class En(val entry: EnEntry) : DictEntry()
    data class Ja(val entry: JaEntry) : DictEntry()
    data class App(val word: Word) : DictEntry()
}

object DictionaryData {

    @Volatile private var enCache: List<EnEntry>? = null
    @Volatile private var jaCache: List<JaEntry>? = null

    val enAll: List<EnEntry> get() = enCache ?: emptyList()
    val jaAll: List<JaEntry> get() = jaCache ?: emptyList()
    val loaded: Boolean get() = enCache != null && jaCache != null
    val totalEntries: Int get() = (enCache?.size ?: 0) + (jaCache?.size ?: 0)

    fun init(context: Context) {
        if (enCache == null) synchronized(this) {
            if (enCache == null) {
                enCache = try {
                    context.assets.open("en_hi.tsv").bufferedReader().use { r ->
                        r.lineSequence().drop(1).filter { it.isNotBlank() }.map { line ->
                            val c = line.split("\t")
                            EnEntry(c[0], c.getOrElse(1) { "" }, c.getOrElse(2) { "" })
                        }.toList()
                    }
                } catch (e: Exception) {
                    emptyList()
                }
            }
        }
        if (jaCache == null) synchronized(this) {
            if (jaCache == null) {
                jaCache = try {
                    context.assets.open("ja_en.tsv").bufferedReader().use { r ->
                        r.lineSequence().drop(1).filter { it.isNotBlank() }.map { line ->
                            val c = line.split("\t")
                            val kana = c.getOrElse(1) { "" }
                            JaEntry(
                                kanji = c[0],
                                kana = kana,
                                romaji = kanaToRomaji(kana),
                                pos = c.getOrElse(2) { "" },
                                common = c.getOrElse(3) { "" } == "1",
                                gloss = c.getOrElse(4) { "" }
                            )
                        }.toList()
                    }
                } catch (e: Exception) {
                    emptyList()
                }
            }
        }
    }

    private val KANA_ROM: Map<Char, String> by lazy {
        val m = HashMap<Char, String>()
        for (c in KanaData.all) m[c.kana.first()] = c.romaji
        m['ー'] = ""
        m['っ'] = ""
        m['ッ'] = ""
        m
    }

    fun kanaToRomaji(kana: String): String {
        if (kana.isEmpty()) return ""
        val sb = StringBuilder()
        var i = 0
        while (i < kana.length) {
            val ch = kana[i]
            if (ch == 'っ' || ch == 'ッ') {
                val nxt = if (i + 1 < kana.length) KANA_ROM[kana[i + 1]] ?: "" else ""
                if (nxt.isNotEmpty()) sb.append(nxt[0])
            } else {
                sb.append(KANA_ROM[ch] ?: ch.toString())
            }
            i++
        }
        return sb.toString()
    }

    private fun isHiragana(c: Char) = c.code in 0x3040..0x309F
    private fun isKatakana(c: Char) = c.code in 0x30A0..0x30FF
    private fun isKanji(c: Char) = c.code in 0x4E00..0x9FFF

    fun search(query: String): List<DictEntry> {
        val q = query.trim()
        if (q.isEmpty()) return emptyList()
        val lower = q.lowercase()
        val hasJp = q.any { isHiragana(it) || isKatakana(it) || isKanji(it) }
        val hasDeva = q.any { it.code in 0x0900..0x097F }

        val out = ArrayList<DictEntry>(128)
        val seen = HashSet<String>()
        fun add(d: DictEntry, key: String) {
            if (seen.add(key)) out.add(d)
        }

        if (hasDeva) {
            for (e in enAll) {
                if (e.hi.contains(q)) add(DictEntry.En(e), "en:" + e.head)
                if (out.size > 400) break
            }
            for (w in Data.allWords) {
                if (w.hi.isNotEmpty() && w.hi.contains(q)) add(DictEntry.App(w), "w:" + w.id)
            }
        } else if (hasJp) {
            for (j in jaAll) {
                if (j.kanji.contains(q) || j.kana.contains(q) || j.gloss.contains(q, ignoreCase = true))
                    add(DictEntry.Ja(j), "ja:" + j.kanji + "|" + j.kana)
                if (out.size > 400) break
            }
            for (w in Data.allWords) {
                if (w.kana.contains(q) || w.kanji.contains(q) || w.en.contains(q, ignoreCase = true))
                    add(DictEntry.App(w), "w:" + w.id)
            }
        } else {
            for (j in jaAll) {
                if (j.kanji.contains(lower) || j.kana.contains(lower) || j.romaji.contains(lower) || j.gloss.contains(lower, ignoreCase = true))
                    add(DictEntry.Ja(j), "ja:" + j.kanji + "|" + j.kana)
                if (out.size > 400) break
            }
            for (e in enAll) {
                if (e.head.contains(lower)) add(DictEntry.En(e), "en:" + e.head)
                if (out.size > 600) break
            }
            for (w in Data.allWords) {
                if (w.en.contains(lower, ignoreCase = true) || w.romaji.contains(lower) ||
                    w.kana.contains(lower) || w.hi.contains(lower)
                ) add(DictEntry.App(w), "w:" + w.id)
            }
        }
        return out
    }

    fun rank(d: DictEntry, query: String): Int {
        val q = query.trim()
        val lower = q.lowercase()
        return when (d) {
            is DictEntry.En -> when {
                d.entry.head == lower -> 0
                d.entry.head.startsWith(lower) -> 1
                d.entry.head.contains(lower) -> 2
                else -> 5
            }
            is DictEntry.Ja -> {
                val e = d.entry
                val head = e.kanji.ifEmpty { e.kana }
                when {
                    head == q || e.kana == lower || e.romaji == lower -> 0
                    head.contains(q) || e.kana.contains(q) -> 1
                    e.romaji.contains(lower) -> 2
                    e.gloss.contains(lower, ignoreCase = true) -> 5
                    else -> 6
                }
            }
            is DictEntry.App -> {
                val w = d.word
                when {
                    w.en.equals(lower, ignoreCase = true) || w.kana == q || w.romaji == lower -> 0
                    w.en.contains(lower, ignoreCase = true) || w.kana.contains(q) || w.romaji.contains(lower) -> 1
                    w.hi.contains(lower) -> 4
                    else -> 5
                }
            }
        }
    }

    fun searchRanked(query: String, limit: Int = 80): List<DictEntry> {
        val list = search(query)
        val q = query.trim()
        return list.sortedWith(compareBy(
            { rank(it, q) },
            { if (it is DictEntry.Ja && it.entry.common) 0 else 1 },
            { entryLen(it) }
        )).take(limit)
    }

    private fun entryLen(d: DictEntry): Int = when (d) {
        is DictEntry.En -> d.entry.head.length
        is DictEntry.Ja -> d.entry.kanji.ifEmpty { d.entry.kana }.length
        is DictEntry.App -> d.word.kana.length.coerceAtLeast(d.word.en.length)
    }
}
