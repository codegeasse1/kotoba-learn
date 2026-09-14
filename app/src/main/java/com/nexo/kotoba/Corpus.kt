package com.nexo.kotoba

import android.content.Context

/**
 * Extra example sentences that ship inside the APK, for every language the app
 * can teach.
 *
 * Assets (all two-column TSV, built by `tools/build-sentences.mjs` from the
 * Tatoeba corpus (CC-BY 2.0 FR — see docs/DATA-LICENSES.md) plus the AI-written
 * top-up produced at build time):
 *
 *  - `sentences.tsv`          `japanese \t english` — the original bundled corpus;
 *                             also supplies English-side sentences for an English track.
 *  - `sentences_gen_<lang>.tsv` `<target> \t english` — AI-written examples, two per
 *                             taught word, one per non-Japanese target. Read first:
 *                             every line is guaranteed to use the word being studied.
 *  - `sentences_<lang>.tsv`   `<target> \t english` — the matching Tatoeba pairs (real
 *                             human sentences), read afterwards to keep the list going.
 *  - `gloss_<lang>.tsv`       `english \t <lang>` — the meaning table. Its
 *                             single-word/sense rows supply the UI glosses; its
 *                             full-sentence rows are machine-translated and are
 *                             therefore used *only to look a translation up*,
 *                             never shown as an example (they used to leak
 *                             awkward renderings onto the word sheet).
 *
 * Everything is bundled, so this keeps working in airplane mode: no network, no
 * API key, no model.
 *
 * A card is only ever shown when the bundle really contains a translation for
 * that exact sentence:
 *
 *  - On an English track the sentence comes from the native language's own pair
 *    files, so the sentence and its translation are the two halves of the same
 *    curated row.
 *  - On any other track the sentence comes from the language being learned, and
 *    the other column of that row is its real English translation. For a learner
 *    whose native language isn't English, that English sentence is then looked up
 *    in the native tables.
 *
 * Anything we can't translate that way is skipped: a confident-looking word-by-word
 * rendering ("Let's give Tom a surprise welcome party" → "देना ए आश्चर्य स्वागत है
 * पार्टी") is worse than no example at all.
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

    /** Lower-case English sentence → its real translation, for the native-language tables. */
    private var nativeByEnglish: Map<String, String> = emptyMap()

    /** The same pairs in a stable order (best sources first), for paging. */
    private var nativePairs: List<Pair<String, String>> = emptyList()

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

    /**
     * Reads the native language's tables once: the bundled pair files (which have
     * the native language in the first column, English in the second) and the
     * meaning table (English first, native second) whose full-sentence rows are a
     * second supply of real translations.
     */
    @Synchronized
    private fun ensureNativeLoaded(ctx: Context, native: String) {
        if (nativeLoadedFor == native) return
        val app = ctx.applicationContext
        val map = HashMap<String, String>(40_000)
        val list = ArrayList<Pair<String, String>>(40_000)
        fun add(english: String, gloss: String, fromPairs: Boolean) {
            val en = english.trim()
            val g = gloss.trim()
            if (en.isEmpty() || g.isEmpty()) return
            val first = map.putIfAbsent(en.lowercase(), g) == null
            // Only curated sentence pairs (the Tatoeba slice and the checked-in
            // generated top-up) may be *shown* as examples. The meaning table's
            // rows are still recorded so they can translate a sentence, but its
            // machine-translated full sentences are never displayed — that path
            // produced wrong renderings such as
            // "Good evening! Table for how many?" → "शुभ संध्या! कितने के लिए तालिका?".
            if (first && fromPairs && looksLikeExample(en, true)) list.add(en to g)
        }
        if (native != "en") {
            for (asset in ASSETS_FOR[native].orEmpty()) {
                try {
                    app.assets.open(asset).bufferedReader().use { r ->
                        r.forEachLine { line ->
                            val tab = line.indexOf('\t')
                            if (tab > 0) add(line.substring(tab + 1), line.substring(0, tab), true)
                        }
                    }
                } catch (_: Exception) {
                    // No native tables for this language — nothing to look up.
                }
            }
            try {
                app.assets.open("gloss_$native.tsv").bufferedReader().use { r ->
                    r.forEachLine { line ->
                        val tab = line.indexOf('\t')
                        if (tab > 0) add(line.substring(0, tab), line.substring(tab + 1), false)
                    }
                }
            } catch (_: Exception) {
                // No meaning table — the pair files alone still work.
            }
        }
        nativeByEnglish = map
        nativePairs = list
        nativeLoadedFor = native
    }

    /**
     * True when an English table row is something we can show as an example. Rows
     * from the pair files are curated sentences, so a short one ("Welcome.") is
     * fine; rows from the meaning table must look like a sentence, so single words
     * and "aunt; (2) middle-aged lady" style sense lists never appear as examples.
     */
    private fun looksLikeExample(en: String, fromPairs: Boolean): Boolean {
        if (en.length < 2) return false
        if (en.contains('(') || en.contains('/') || en.contains('|')) return false
        var hasCjk = false
        for (c in en) if (c.code in 0x3040..0x9FFF || c.code in 0xF900..0xFAFF) { hasCjk = true; break }
        if (hasCjk) return false
        val terminal = en.last() in ".!?…\"'"
        if (!terminal && en.contains(';')) return false
        val words = en.count { it == ' ' } + 1
        return if (fromPairs) words >= 2 || terminal else words >= 2
    }

    /** A real translation of [english] in [native], or null when the bundle has none. */
    private fun nativeLookup(ctx: Context, native: String, english: String): String? {
        if (native.isBlank() || native == "en") return null
        ensureNativeLoaded(ctx, native)
        return nativeByEnglish[english.trim().lowercase()]
    }

    /**
     * True when [s] reads as a complete example rather than a dictionary
     * fragment.
     *
     * English text (the sentence half of a pair, or the pivot translation) must
     * end in terminal punctuation — our sources otherwise hand back bare labels
     * such as "Good evening greeting" or sense lists. Other languages are judged
     * by length alone, because many of their sentences (Arabic and Tamil
     * especially) carry no sentence-final punctuation at all, and demanding it
     * would throw away thousands of perfectly good examples.
     */
    private fun isShowable(s: String, english: Boolean): Boolean {
        val t = s.trim()
        if (t.length < 3) return false
        if (t.contains('(') || t.contains(')') || t.contains('|')) return false
        if (english) {
            return t.last() in ".\u0021\u003F\u2026\u3002\uFF01\uFF1F\u0964\u0965\u06D4\"'\u2019\u201D"
        }
        return t.count { it == ' ' } >= 2 || t.length >= 12
    }

    /**
     * Dedupe key: the sentence with case, punctuation and extra whitespace
     * removed, so "Good night", "Good night!" and "Good night." count as one
     * example instead of three near-identical ones.
     */
    private fun sentenceKey(s: String): String {
        val sb = StringBuilder(s.length)
        for (c in s) {
            when {
                c.isLetterOrDigit() -> sb.append(c.lowercaseChar())
                c == ' ' -> sb.append(' ')
            }
        }
        return sb.toString().trim().replace(Regex("\\s+"), " ")
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

        val out = ArrayList<Examples.ExLine>(limit)
        val seen = HashSet<String>(limit * 2)
        var skipped = 0
        val wantGloss = native.isNotBlank() && native != target
        // The headword itself, normalized: an "example" that is just the word
        // repeated ("Good night." for the word "good night") adds nothing.
        val headKeys = needles.mapTo(HashSet<String>()) { sentenceKey(it) }

        // English track: the sentence is the English half of a curated pair, and
        // its translation is the other half. No pair, no card.
        if (target == "en") {
            if (wantGloss) {
                ensureNativeLoaded(ctx, native)
                for ((sentence, gloss) in nativePairs) {
                    if (needles.none { containsWord(sentence, it) }) continue
                    if (!isShowable(sentence, true)) continue
                    val key = sentenceKey(sentence)
                    if (key in headKeys || !seen.add(key)) continue
                    if (skipped < offset) {
                        skipped++
                        continue
                    }
                    if (out.size >= limit) return out
                    out.add(Examples.ExLine(sentence, "", gloss))
                }
            } else {
                ensureLoaded(ctx, JAPANESE_ASSET)
                for (raw in lines) {
                    val tab = raw.indexOf('\t')
                    if (tab <= 0) continue
                    val sentence = raw.substring(tab + 1)
                    if (needles.none { containsWord(sentence, it) }) continue
                    if (!isShowable(sentence, true)) continue
                    val key = sentenceKey(sentence)
                    if (key in headKeys || !seen.add(key)) continue
                    if (skipped < offset) {
                        skipped++
                        continue
                    }
                    if (out.size >= limit) return out
                    out.add(Examples.ExLine(sentence, "", ""))
                }
            }
            return out
        }

        // Every other track: the sentence comes from the language being learned and
        // the other column is its real English translation, which a non-English
        // native language then looks up in its own tables.
        ensureLoaded(ctx, target)
        if (lines.isEmpty()) return out
        for (raw in lines) {
            val tab = raw.indexOf('\t')
            if (tab <= 0) continue
            val left = raw.substring(0, tab)
            val right = raw.substring(tab + 1)
            if (needles.none { containsForTarget(left, it, target) }) continue
            if (!isShowable(left, false)) continue
            val key = sentenceKey(left)
            if (key in headKeys || !seen.add(key)) continue
            val gloss = when {
                !wantGloss -> ""
                native == "en" -> right
                // The exact sentence translated into the learner's native language,
                // when the bundle has it; otherwise fall back to the real English
                // translation of the sentence (the app's pivot language), exactly
                // like the authored examples do — never a word-by-word guess.
                else -> Examples.exactGloss(right, native) ?: nativeLookup(ctx, native, right) ?: right
            }
            if (skipped < offset) {
                skipped++
                continue
            }
            if (out.size >= limit) return out
            val sub = if (target == "ja" && romaji) DictionaryData.kanaToRomaji(left) else ""
            out.add(Examples.ExLine(left, sub, gloss))
        }
        return out
    }

    /**
     * The words we look for in a sentence. Japanese matches the script itself;
     * English matches the English column (plus the "leg / foot" style dictionary
     * labels reduced to their first sense); every other language matches the
     * translated headword plus its other dictionary senses, which raises the hit
     * rate a lot for languages where the bundle is thin.
     */
    private fun needlesFor(word: Word, target: String): List<String> {
        val raw: List<String> = when (target) {
            "ja" -> listOf(word.kanji, word.kana)
            "en" -> listOf(word.en, Examples.normalize(word.en))
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
     * Match a word in the language being learned. Latin/Cyrillic-style scripts are
     * space-delimited, so the word-boundary stem match works; Japanese is not, so
     * the word is matched as a substring while making sure a kanji is not just
     * part of a longer kanji compound (母 inside 母国 "motherland" is a different
     * word and must not match). Kana readings of a single mora (日 → ひ) are only
     * accepted when the whole sentence is that word, otherwise they match almost
     * every sentence.
     */
    private fun containsForTarget(text: String, word: String, target: String): Boolean =
        if (target == "ja") containsJa(text, word) else containsStem(text, word)

    private fun containsJa(text: String, needle: String): Boolean {
        val n = needle.trim()
        if (n.isEmpty()) return false
        val kanji = n.any { isKanji(it) }
        if (!kanji) {
            if (n.length >= 2) return text.contains(n)
            return text.trim() == n
        }
        var from = 0
        while (true) {
            val i = text.indexOf(n, from)
            if (i < 0) return false
            val before = if (i == 0) null else text[i - 1]
            val after = if (i + n.length >= text.length) null else text[i + n.length]
            if ((before == null || !isKanji(before)) && (after == null || !isKanji(after))) return true
            from = i + 1
        }
    }

    private fun isKanji(c: Char): Boolean =
        c.code in 0x3400..0x4DBF || c.code in 0x4E00..0x9FFF || c.code in 0xF900..0xFAFF

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
