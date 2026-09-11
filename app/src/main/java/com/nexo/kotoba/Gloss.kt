package com.nexo.kotoba

import android.content.Context

/**
 * Multilingual gloss table.
 *
 * The vocabulary data is authored around English (the pivot language) plus
 * hand-written Hindi. To show a meaning in any "native language" the app ships
 * `assets/gloss_<lang>.tsv` files, each mapping an English gloss to that
 * language.
 *
 * Two tables are kept in memory at once: the learner's NATIVE language (used for
 * meanings/translations via [lookup]) and the language they are currently
 * LEARNING (used to build translated content via [lookupTarget]). Call [ensure]
 * and [ensureTarget] before rendering.
 */
object Gloss {

    private var ctx: Context? = null

    @Volatile
    private var nativeLang: String = ""

    @Volatile
    private var nativeTable: Map<String, String> = emptyMap()

    @Volatile
    private var targetLang: String = ""

    @Volatile
    private var targetTable: Map<String, String> = emptyMap()

    fun attach(context: Context) {
        ctx = context.applicationContext
    }

    private fun load(lang: String): Map<String, String> {
        if (lang == "en" || lang.isBlank()) return emptyMap()
        val c = ctx ?: return emptyMap()
        return try {
            c.assets.open("gloss_$lang.tsv").bufferedReader().use { r ->
                val map = HashMap<String, String>(24000)
                r.lineSequence().forEach { line ->
                    if (line.isNotEmpty()) {
                        val i = line.indexOf('\t')
                        if (i > 0) map[line.substring(0, i)] = line.substring(i + 1)
                    }
                }
                map
            }
        } catch (_: Exception) {
            emptyMap()
        }
    }

    /** Load the table for the learner's native language. */
    fun ensure(lang: String) {
        if (lang == nativeLang) return
        nativeTable = load(lang)
        nativeLang = lang
    }

    /**
     * Load the table used to translate English source content into the language
     * the learner is studying. Japanese and English content is authored natively,
     * so nothing is loaded for them.
     */
    fun ensureTarget(lang: String) {
        if (lang == targetLang) return
        targetTable = if (lang == "ja" || lang == "en") emptyMap() else load(lang)
        targetLang = lang
    }

    /** Meaning of an English string in the learner's native language. */
    fun lookup(en: String): String? {
        if (en.isEmpty()) return null
        return nativeTable[en]
    }

    /** Translation of an English string into the language being learned. */
    fun lookupTarget(en: String): String? {
        if (en.isEmpty()) return null
        return targetTable[en]
    }

    fun targetLoaded(): Boolean = targetTable.isNotEmpty()
}

/**
 * Meaning of an English string in the learner's native language, with a
 * caller-supplied fallback when no translation is bundled.
 */
fun nativeMeaning(en: String, fallback: String, native: String): String = when (native) {
    "en" -> en
    "" -> en
    else -> Gloss.lookup(en) ?: fallback
}
