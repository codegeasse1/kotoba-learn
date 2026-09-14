package com.nexo.kotoba

import android.content.Context

/**
 * Extra example sentences that ship inside the APK, for every language the app
 * can teach.
 *
 * Assets (all two-column TSV, built by `tools/build-sentences.mjs` from the
 * Tatoeba corpus (CC-BY 2.0 FR — see docs/DATA-LICENSES.md) plus the AI-generated
 * top-up produced at build time):
 *
 *  - `sentences.tsv`          `japanese \t english` — the original bundled corpus;
 *                             also supplies English-side sentences for an English track.
 *  - `sentences_gen_<lang>.tsv` `<target> \t english` — AI-written examples, two per
 *                             taught word, one per non-Japanese target. Read first:
 *                             every line is guaranteed to use the word being studied.
 *  - `sentences_<lang>.tsv`   `<target> \t english` — the matching Tatoeba pairs (real
 *                             human sentences), read afterwards to keep the list going.
 *
 * Everything is bundled, so this keeps working in airplane mode: no network, no
 * API key, no model.
 *
 * Translations are only ever shown when the bundle actually contains one for the
 * exact sentence: for an English track whose native language has its own pair
 * file the sentence and its translation are the two columns of the same row, and
 * every other combination looks the sentence up in the native tables (through the
 * English column as a pivot). We never compose a word-by-word "translation" — a
 * confident-looking wrong gloss is worse than none.
 *
 * [extra] is called lazily — a language's tables are only read the first time a
 * learner actually taps "More examples", and only one language's tables are kept
 * in memory at once (the Japanese/English file is the big one).
 */
object Corpus {

    private const val JAPANESE_ASSET = "sentences.tsv"

    private val OTHER_LANGS = listOf("hi", "es", "ar", "fr", "de", "bn", "ta", "te", "ur", "kn")

    private val ASSETS_FOR: Map<String, List<String>> = buildMap {
        put("ja", listOf(JAPANESE_ASSET))
        put("en", listOf(JAPANESE_ASSET))
        for (l in OTHER_LANGS) put(l, listOf("sentences_gen_$l.tsv", "sentences_$l.tsv"))
    }

    @Volatile
    private var loadedFor: String? = null

    private var lines: List<String> = emptyList()

    @Volatile
    private var nativeLoadedFor: String? = null

    /** Lower-case English sentence → its translation, for the native-language tables. */
    private var nativeByEnglish: Map<String, String> = emptyMap()

    /** Number of bundled sentence pairs currently in memory (0 until first read). */
    fun size(): Int = lines.size

    @Synchronized
    private fun ensureLoaded(ctx: Context, lang: String) {
        if (loadedFor == lang) return
        val app = ctx.applicationContext
        val out = ArrayList<String>(80_000)
        val assets = ASSETS_FOR[lang] ?: emptyList()
        for (asset in assets) {
            try {
                app.assets.open(asset).bufferedReader().use { r ->
                    r.forEachLine { line ->
                        if (line.length > 2 && line.indexOf('\t') > 0) out.add(line)
                    }
                }
            } catch (_: Exception) {
                // Language simply has no bundled corpus (yet) — fall through.
            }
        }
        lines = out
        loadedFor = lang
    }

    @Synchronized
    private fun ensureNativeLoaded(ctx: Context, native: String) {
        if (nativeLoadedFor == native) return
        val app = ctx.applicationContext
        val map = HashMap<String, String>(40_000)
        for (asset in ASSETS_FOR[native] ?: emptyList()) {
            try {
                app.assets.open(asset).bufferedReader().use { r ->
                    r.forEachLine { line ->
                        val tab = line.indexOf('\t')
                        if (tab <= 0) return@forEachLine
                        val left = line.substring(0, tab).trim()
                        val right = line.substring(tab + 1).trim()
                        if (left.isEmpty() || right.isEmpty()) return@forEachLine
                        // The bundled pair files always have the native language on
                        // the left and English on the right.
                        map.putIfAbsent(right.lowercase(), left)
                    }
                }
            } catch (_: Exception) {
                // No native tables for this language — nothing to look up.
            }
        }
        nativeByEnglish = map
        nativeLoadedFor = native
    }

    /** A real translation of [english] in [native], or null when the bundle has none. */
    private fun nativeLookup(ctx: Context, native: String, english: String): String? {
        if (native.isBlank() || native == "en") return null
        ensureNativeLoaded(ctx, native)
        return nativeByEnglish[english.trim().lowercase()]
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
        val needles = needlesFor(word, target)
        if (needles.isEmpty()) return emptyList()

        val englishSide = target == "en"
        // When the learner studies English and their native language has its own
        // pair file, that file is the perfect source: (native, English) columns, so
        // the sentence and its real translation share a row.
        val directNative = englishSide && native.isNotBlank() && native != "en" &&
            ASSETS_FOR[native].orEmpty().isNotEmpty()

        // Pools are tried in order; a pool is (table, match the English column?,
        // gloss kind). Gloss kind 1 = the other column is the translation,
        // 2 = translate the English column through the native tables, 0 = no gloss.
        val pools = ArrayList<Triple<String, Boolean, Int>>(2)
        if (directNative) {
            pools.add(Triple(native, true, 1))
            pools.add(Triple("en", true, 0)) // more English sentences, just no native line
        } else {
            val kind = when {
                native.isBlank() || native == target -> 0
                native == "en" -> 1
                else -> 2
            }
            pools.add(Triple(target, englishSide, kind))
        }

        val out = ArrayList<Examples.ExLine>(limit)
        val seen = HashSet<String>(limit * 2)
        var skipped = 0
        for ((tableKey, matchEnglish, glossKind) in pools) {
            ensureLoaded(ctx, tableKey)
            if (lines.isEmpty()) continue
            for (raw in lines) {
                val tab = raw.indexOf('\t')
                if (tab <= 0) continue
                val left = raw.substring(0, tab)
                val right = raw.substring(tab + 1)
                val sentence = if (matchEnglish) right else left

                val hit = needles.any { needle ->
                    if (matchEnglish) containsWord(sentence, needle) else containsStem(sentence, needle)
                }
                if (!hit) continue
                if (!seen.add(sentence.lowercase())) continue
                if (skipped < offset) {
                    skipped++
                    continue
                }
                if (out.size >= limit) return out

                val gloss = when (glossKind) {
                    // The column that is not the sentence is the native translation.
                    1 -> if (matchEnglish) left else right
                    // English pivot: the exact English sentence, translated by the
                    // native-language tables when they contain it.
                    2 -> Examples.exactGloss(right, native) ?: nativeLookup(ctx, native, right) ?: ""
                    else -> ""
                }
                val sub = if (target == "ja" && romaji) DictionaryData.kanaToRomaji(sentence) else ""
                out.add(Examples.ExLine(sentence, sub, gloss))
            }
        }
        return out
    }

    /**
     * The words we look for in a sentence. Japanese matches the script itself;
     * English matches the English column; every other language matches the
     * translated headword plus its other dictionary senses, which raises the hit
     * rate a lot for languages where the bundle is thin.
     */
    private fun needlesFor(word: Word, target: String): List<String> {
        val raw: List<String> = when (target) {
            "ja" -> listOf(word.kanji, word.kana)
            "en" -> listOf(word.en)
            else -> {
                val senses = ArrayList<String>(4)
                if (word.kana.isNotBlank()) senses.add(word.kana)
                val table = Gloss.lookupTarget(word.en)
                if (!table.isNullOrBlank()) {
                    table.split(';', '；').forEach { s -> cleanGloss(s)?.let { senses.add(it) } }
                }
                if (senses.isEmpty()) senses.add(word.en)
                senses
            }
        }
        return raw.map { it.trim() }.filter { it.isNotEmpty() }.distinct()
    }

    /** Whole-word match, so "act" does not match "actor" or "exactly". */
    private fun containsWord(text: String, word: String): Boolean {
        val t = fold(text.lowercase())
        val w = fold(word.lowercase().trim())
        if (w.isEmpty()) return false
        if (w.length > t.length) return false
        var from = 0
        while (true) {
            val i = t.indexOf(w, from)
            if (i < 0) return false
            val beforeOk = startsWord(t, i)
            val end = i + w.length
            val afterOk = end >= t.length || !isWordChar(t[end])
            if (beforeOk && afterOk) return true
            from = i + 1
        }
    }

    /**
     * Match a word or an inflected form of it: the match must start at a word
     * boundary but may be followed by more of the same word ("madre" matches
     * "madres", "வா" matches "வாருங்கள்" only when it is long enough to be safe).
     */
    private fun containsStem(text: String, word: String): Boolean {
        val w = fold(word.lowercase().trim())
        if (w.isEmpty()) return false
        if (w.length < 4) return containsWord(text, w)
        val t = fold(text.lowercase())
        if (w.length > t.length) return false
        var from = 0
        while (true) {
            val i = t.indexOf(w, from)
            if (i < 0) return false
            if (startsWord(t, i)) return true
            from = i + 1
        }
    }

    /**
     * True when position [i] in [t] starts a word. An apostrophe also counts as a
     * boundary so the elided forms Spanish/French write ("l'économie", "d'autobus")
     * still match.
     */
    private fun startsWord(t: String, i: Int): Boolean =
        i == 0 || !isWordChar(t[i - 1]) || t[i - 1] == '\'' || t[i - 1] == '\u2019'

    private fun isWordChar(c: Char): Boolean = c.isLetterOrDigit() || c == '\'' || c == '\u2019'

    /**
     * Strips the accents from Latin letters ("tráfico" → "trafico", "économie" →
     * "economie") so a gloss-table headword matches the corpus even when one side
     * is written without diacritics. Scripts without Latin-1/Latin-Extended
     * letters are returned untouched, so Indic and Arabic text is never altered.
     */
    private fun fold(s: String): String {
        var latin = false
        for (c in s) if (c.code in 0xC0..0x24F) { latin = true; break }
        if (!latin) return s
        val sb = StringBuilder(s.length)
        for (c in s) {
            if (c.code in 0xC0..0x24F) {
                val d = java.text.Normalizer.normalize(c.toString(), java.text.Normalizer.Form.NFD)
                for (ch in d) if (ch.code !in 0x0300..0x036F) sb.append(ch)
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
