package com.nexo.kotoba

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class Speaker(context: Context) {

    private var tts: TextToSpeech? = null
    private var ready = false
    private var rate = 0.85f

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            ready = status == TextToSpeech.SUCCESS
        }
    }

    fun setRate(r: Float) {
        rate = r
    }

    fun speak(text: String, japanese: Boolean) {
        val t = tts ?: return
        if (!ready || text.isBlank()) return
        t.language = if (japanese) Locale.JAPANESE else Locale.US
        t.setSpeechRate(rate)
        t.speak(text, TextToSpeech.QUEUE_FLUSH, null, "kotoba")
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
