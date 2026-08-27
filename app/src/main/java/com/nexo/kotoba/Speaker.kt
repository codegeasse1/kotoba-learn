package com.nexo.kotoba

import android.content.Context
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.Locale

class Speaker(context: Context) {

    private var tts: TextToSpeech? = null
    private var ready = false
    private var initFailed = false
    private var pending: Pair<String, Boolean>? = null
    private var rate = 0.85f
    private val appCtx = context.applicationContext
    private var warnedNoEngine = false
    private var warnedNoLang = false
    private var warnedPending = false

    init {
        try {
            tts = TextToSpeech(appCtx) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    ready = true
                    tts?.setSpeechRate(rate)
                    pending?.let { p ->
                        pending = null
                        speak(p.first, p.second)
                    }
                } else {
                    initFailed = true
                    toastIfOnce("Audio isn't available on this device. Check that Text-to-Speech is installed (Settings → Accessibility → Text-to-speech).")
                }
            }
        } catch (e: Exception) {
            initFailed = true
            toastIfOnce("Couldn't start audio on this device.")
        }
    }

    private fun toastIfOnce(msg: String) {
        try {
            Toast.makeText(appCtx, msg, Toast.LENGTH_LONG).show()
        } catch (_: Exception) {
        }
    }

    fun setRate(r: Float) {
        rate = r
        tts?.setSpeechRate(r)
    }

    fun speak(text: String, japanese: Boolean) {
        val t = tts
        if (t == null || initFailed) {
            toastIfOnce("Audio isn't ready — install/check Text-to-Speech in device settings.")
            return
        }
        if (text.isBlank()) return
        if (!ready) {
            if (!warnedPending) {
                warnedPending = true
                toastIfOnce("Audio is starting up… tap the sound button again in a second.")
            }
            if (pending == null) pending = text to japanese
            return
        }
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
                    if (!warnedNoLang) {
                        warnedNoLang = true
                        toastIfOnce("No ${if (japanese) "Japanese" else "English"} voice found — using your device's default voice. Download the voice in Text-to-Speech settings for the best sound.")
                    }
                }
            }
            val result = t.speak(text, TextToSpeech.QUEUE_FLUSH, null, "kotoba")
            if (result == TextToSpeech.ERROR && !warnedNoEngine) {
                warnedNoEngine = true
                toastIfOnce("Audio failed to play. Try downloading the voice data in device Text-to-Speech settings.")
            }
        } catch (e: Exception) {
            toastIfOnce("Audio error: ${e.message ?: "unknown"}")
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
