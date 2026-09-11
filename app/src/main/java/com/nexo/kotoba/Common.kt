package com.nexo.kotoba

fun speak(store: Store, speaker: Speaker, text: String, japanese: Boolean) {
    speaker.setRate(store.speechRate)
    speaker.speak(text, japanese)
}

fun Word.glossFor(native: String): String = when (native) {
    "ja" -> if (kana.isNotEmpty()) kana + (if (romaji.isNotEmpty()) " ($romaji)" else "") else nativeMeaning(en, en, native)
    "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
    else -> nativeMeaning(en, en, native)
}

fun Phrase.glossFor(native: String): String = when (native) {
    "ja" -> ja
    "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
    else -> nativeMeaning(en, en, native)
}

fun Pattern.ruleFor(native: String): String = when (native) {
    "ja" -> if (ruleJa.isNotEmpty()) ruleJa else ruleEn
    "hi" -> if (ruleHi.isNotEmpty()) ruleHi else ruleEn
    else -> nativeMeaning(ruleEn, ruleEn, native)
}

fun PatternExample.glossFor(native: String): String = when (native) {
    "hi" -> if (hi.isNotEmpty()) hi else nativeMeaning(en, en, native)
    else -> nativeMeaning(en, en, native)
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
