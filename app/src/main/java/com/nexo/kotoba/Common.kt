package com.nexo.kotoba

fun speak(store: Store, speaker: Speaker, text: String, japanese: Boolean) {
    speaker.setRate(store.speechRate)
    speaker.speak(text, japanese)
}

fun Word.glossFor(native: String): String = when (native) {
    "ja" -> if (kana.isNotEmpty()) kana + (if (romaji.isNotEmpty()) " ($romaji)" else "") else en
    "hi" -> if (hi.isNotEmpty()) hi else en
    else -> en
}

fun Phrase.glossFor(native: String): String = when (native) {
    "ja" -> ja
    "hi" -> if (hi.isNotEmpty()) hi else en
    else -> en
}

fun Pattern.ruleFor(native: String): String = when (native) {
    "ja" -> ruleJa
    "hi" -> if (ruleHi.isNotEmpty()) ruleHi else ruleEn
    else -> ruleEn
}

fun PatternExample.glossFor(native: String): String = when (native) {
    "hi" -> if (hi.isNotEmpty()) hi else en
    else -> en
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
