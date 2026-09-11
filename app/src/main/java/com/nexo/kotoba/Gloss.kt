package com.nexo.kotoba

import android.content.Context

/**
 * Multilingual gloss table.
 *
 * The vocabulary data is authored around English (the pivot language) plus
 * hand-written Hindi. To show a meaning in any other "native language" the app
 * ships `assets/gloss_<lang>.tsv` files, each mapping an English gloss to that
 * language. Only one language is held in memory at a time; call [ensure] with
 * the current native language before rendering so [lookup] is a cheap map hit.
 */
object Gloss {

    private var ctx: Context? = null

    @Volatile
    private var loadedLang: String = "en"

    @Volatile
    private var table: Map<String, String> = emptyMap()

    fun attach(context: Context) {
        ctx = context.applicationContext
    }

    fun ensure(lang: String) {
        if (lang == loadedLang) return
        if (lang == "en" || lang.isBlank()) {
            table = emptyMap()
            loadedLang = "en"
            return
        }
        val c = ctx ?: return
        val loaded: Map<String, String> = try {
            c.assets.open("gloss_$lang.tsv").bufferedReader().use { r ->
                val map = HashMap<String, String>(20000)
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
        table = loaded
        loadedLang = lang
    }

    fun lookup(en: String): String? {
        if (en.isEmpty()) return null
        return table[en]
    }
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
