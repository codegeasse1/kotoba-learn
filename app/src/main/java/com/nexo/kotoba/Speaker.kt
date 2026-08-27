package com.nexo.kotoba

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class Speaker(context: Context) {

    private var tts: TextToSpeech? = null
    private var ready = false
    private var pending: Pair<String, Boolean>? = null
    private var rate = 0.85f
    private val appCtx = context.applicationContext

    init {
        try {
            tts = TextToSpeech(appCtx) { status ->
                ready = status == TextToSpeech.SUCCESS
                if (!ready) {
                    Log.w("KotobaTTS", "TTS init failed, status=$status")
                }
                tts?.setSpeechRate(rate)
                pending?.let { p ->
                    pending = null
                    speak(p.first, p.second)
                }
            }
        } catch (e: Exception) {
            Log.w("KotobaTTS", "TTS construction failed", e)
        }
    }

    fun setRate(r: Float) {
        rate = r
        tts?.setSpeechRate(r)
    }

    fun speak(text: String, japanese: Boolean) {
        val t = tts ?: return
        if (!ready) {
            if (pending == null) pending = text to japanese
            return
        }
        if (text.isBlank()) return
        try {
            t.setSpeechRate(rate)
            val target = if (japanese) Locale.JAPANESE else Locale.US
            val res = t.setLanguage(target)
            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                val fallback = if (japanese) Locale("ja") else Locale.ENGLISH
                if (t.isLanguageAvailable(fallback) >= TextToSpeech.LANG_AVAILABLE) {
                    t.setLanguage(fallback)
                } else {
                    t.setLanguage(Locale.getDefault())
                }
            }
            val result = t.speak(text, TextToSpeech.QUEUE_FLUSH, null, "kotoba")
            if (result == TextToSpeech.ERROR) {
                Log.w("KotobaTTS", "speak() returned ERROR for '$text'")
            }
        } catch (e: Exception) {
            Log.w("KotobaTTS", "speak failed", e)
        }
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
