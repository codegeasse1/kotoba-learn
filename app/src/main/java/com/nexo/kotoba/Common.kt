package com.nexo.kotoba

/**
 * Speak text in the learner's current target language (the "learning" language),
 * or in English when [targetAudio] is false.
 */
fun speak(store: Store, speaker: Speaker, text: String, targetAudio: Boolean) {
    speaker.setRate(store.speechRate)
    speaker.speak(text, if (targetAudio) store.target else "en")
}

/** Speak text in one explicit language, ignoring the current target. */
fun speakIn(store: Store, speaker: Speaker, text: String, lang: String) {
    speaker.setRate(store.speechRate)
    speaker.speak(text, lang)
}

fun localeFor(code: String): String = when (code) {
    "ja" -> "ja-JP"
    "hi" -> "hi-IN"
    "es" -> "es-ES"
    "ar" -> "ar-SA"
    "fr" -> "fr-FR"
    "de" -> "de-DE"
    "bn" -> "bn-IN"
    "ta" -> "ta-IN"
    "te" -> "te-IN"
    "ur" -> "ur-PK"
    "kn" -> "kn-IN"
    else -> "en-US"
}

fun Word.glossFor(native: String): String {
    if (lang != "ja" && lang != "en") return nativeMeaning(en, en, native)
    return when (native) {
        "ja" -> if (kana.isNotEmpty()) kana + (if (romaji.isNotEmpty()) " ($romaji)" else "") else nativeMeaning(en, en, native)
        "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
        else -> nativeMeaning(en, en, native)
    }
}

fun Phrase.glossFor(native: String): String = when (native) {
    "ja" -> ja
    "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
    else -> nativeMeaning(en, en, native)
}

fun Pattern.ruleFor(native: String): String {
    if (lang != "ja" && lang != "en") {
        val key = ruleEn.replace("\n", "\\n")
        return nativeMeaning(key, key, native).replace("\\n", "\n")
    }
    return when (native) {
        "ja" -> if (ruleJa.isNotEmpty()) ruleJa else ruleEn
        "hi" -> if (ruleHi.isNotEmpty()) ruleHi else ruleEn
        else -> nativeMeaning(ruleEn, ruleEn, native)
    }
}

fun PatternExample.glossFor(native: String, lang: String): String {
    val english = if (lang == "en") ja else en
    val target = if (lang == "en") en else ja
    if (lang != "ja" && lang != "en") {
        return when (native) {
            "en" -> english
            "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(english, english, native)
            else -> nativeMeaning(english, english, native)
        }
    }
    return when (native) {
        "en" -> if (lang == "en") "" else english
        "ja" -> if (lang == "ja") "" else target.ifEmpty { english }
        "hi" -> if (hi.isNotEmpty()) hi else (Gloss.lookup(english) ?: english)
        else -> if (english.isEmpty()) "" else Gloss.lookup(english) ?: ""
    }
}

fun Sentence.glossFor(native: String): String = when (native) {
    "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
    else -> nativeMeaning(en, en, native)
}

fun AlphabetChar.glossFor(native: String): String = when (native) {
    "ja" -> if (kana.isNotEmpty()) "$kana — ${word.lowercase()}" else word
    "hi" -> if (hi.isNotEmpty()) "$hi — ${word.lowercase()}" else nativeMeaning(word, word, native)
    else -> nativeMeaning(word, word, native)
}

val NATIVE_LANGUAGES = listOf(
    "en" to "🇺🇸 English",
    "hi" to "🇮🇳 Hindi",
    "ja" to "🇯🇵 Japanese",
    "es" to "🇪🇸 Spanish",
    "ar" to "🇸🇦 Arabic",
    "fr" to "🇫🇷 French",
    "de" to "🇩🇪 German",
    "bn" to "🇧🇩 Bengali",
    "ta" to "🇮🇳 Tamil",
    "te" to "🇮🇳 Telugu",
    "ur" to "🇵🇰 Urdu",
    "kn" to "🇮🇳 Kannada"
)

fun nativeName(code: String): String =
    NATIVE_LANGUAGES.firstOrNull { it.first == code }?.second ?: "English"

fun languageLabel(code: String): String = when (code) {
    "ja" -> "Japanese"
    "en" -> "English"
    else -> nativeName(code).substringAfter(' ', nativeName(code))
}
