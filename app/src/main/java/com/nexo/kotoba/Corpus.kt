package com.nexo.kotoba

import android.content.Context

/**
 * Extra example sentences that ship inside the APK.
 *
 * The asset `sentences.tsv` is a two-column TSV — `<japanese>\t<english>` — built
 * by `tools/build-sentences.mjs` from the Tatoeba corpus (CC-BY 2.0 FR, see
 * docs/DATA-LICENSES.md). It is bundled, so this keeps working in airplane mode:
 * no network, no API key, no model.
 *
 * [extra] is called lazily — the file is only read the first time a learner
 * actually taps "More examples", and the whole thing is a few megabytes.
 */
object Corpus {

    private const val ASSET = "sentences.tsv"

    private val lines = ArrayList<String>(100_000)

    @Volatile
    private var loaded = false

    /** Number of bundled sentence pairs (0 until the file has been read once). */
    fun size(): Int = if (loaded) lines.size else 0

    private fun ensureLoaded(ctx: Context) {
        if (loaded) return
        synchronized(this) {
            if (loaded) return
            try {
                ctx.applicationContext.assets.open(ASSET).bufferedReader().use { r ->
                    r.forEachLine { line ->
                        if (line.isNotEmpty() && line.indexOf('\t') > 0) lines.add(line)
                    }
                }
            } catch (_: Exception) {
                lines.clear()
            }
            loaded = true
        }
    }

    /**
     * Extra examples for [word] in the language being learned, starting at
     * [offset] in the list of matches, up to [limit].
     *
     * Returns an empty list when nothing in the corpus uses the word — callers
     * simply show nothing extra.
     */
    fun extra(
        ctx: Context,
        word: Word,
        target: String,
        native: String,
        offset: Int = 0,
        limit: Int = 10,
        romaji: Boolean = true
    ): List<Examples.ExLine> {
        ensureLoaded(ctx)
        if (lines.isEmpty()) return emptyList()

        val needles: List<String> = when (target) {
            "ja" -> listOf(word.kanji, word.kana).filter { it.isNotEmpty() }.distinct()
            "en" -> listOf(word.en).filter { it.isNotEmpty() }
            else -> return emptyList()
        }
        if (needles.isEmpty()) return emptyList()

        val out = ArrayList<Examples.ExLine>(limit)
        val seen = HashSet<String>(limit * 2)
        var skipped = 0
        for (raw in lines) {
            val tab = raw.indexOf('\t')
            if (tab <= 0) continue
            val jp = raw.substring(0, tab)
            val en = raw.substring(tab + 1)

            if (target == "ja") {
                if (!needles.any { jp.contains(it) }) continue
            } else {
                if (!needles.any { containsWord(en, it) }) continue
            }
            if (!seen.add(if (target == "ja") jp else en)) continue
            if (skipped < offset) {
                skipped++
                continue
            }

            val gloss = if (target == "ja") {
                if (native == "en" || native.isBlank()) en
                else Examples.sentenceGloss(en, native).ifBlank { en }
            } else {
                Examples.sentenceGloss(en, native)
            }
            val sub = if (target == "ja" && romaji) DictionaryData.kanaToRomaji(jp) else ""
            out.add(Examples.ExLine(if (target == "ja") jp else en, sub, gloss))
            if (out.size >= limit) break
        }
        return out
    }

    /** Whole-word match, so "act" does not match "actor" or "exactly". */
    private fun containsWord(text: String, word: String): Boolean {
        val t = text.lowercase()
        val w = word.lowercase().trim()
        if (w.isEmpty()) return false
        if (w.length > t.length) return false
        var from = 0
        while (true) {
            val i = t.indexOf(w, from)
            if (i < 0) return false
            val beforeOk = i == 0 || !t[i - 1].isLetterOrDigit()
            val end = i + w.length
            val afterOk = end >= t.length || !t[end].isLetterOrDigit()
            if (beforeOk && afterOk) return true
            from = i + 1
        }
    }
}
