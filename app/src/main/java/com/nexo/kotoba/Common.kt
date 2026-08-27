package com.nexo.kotoba

fun speak(store: Store, speaker: Speaker, text: String, japanese: Boolean) {
    speaker.setRate(store.speechRate)
    speaker.speak(text, japanese)
}
