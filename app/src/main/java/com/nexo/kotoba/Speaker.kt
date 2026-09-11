package com.nexo.kotoba

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.Locale

/**
 * Speaks text in any of the supported languages.
 *
 * Most devices only ship voice data for the languages the user has actually
 * downloaded, so a plain `setLanguage` silently does nothing for the rest. We:
 *   1. try the exact locale (e.g. `de-DE`),
 *   2. then the bare language (e.g. `de`),
 *   3. then any installed variant of that language,
 * and if none of those exist — or the engine reports an error — we download the
 * phrase from the network TTS service so the learner still hears the word. The
 * network path only runs when the on-device voice can't handle the phrase, and
 * needs an internet connection.
 */
class Speaker(context: Context) {

    private var tts: TextToSpeech? = null
    private var ready = false
    private var initFailed = false
    private var pending: Pair<String, String>? = null
    private var rate = 0.85f
    private val appCtx = context.applicationContext
    private val mainHandler = Handler(Looper.getMainLooper())
    private var warnedNoEngine = false
    private var warnedNoLang = false
    private var warnedPending = false
    private var media: MediaPlayer? = null
    private var speakSeq = 0
    private var lastUtteranceId: String? = null
    private var lastFallback: Pair<String, String>? = null

    init {
        try {
            tts = TextToSpeech(appCtx) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    ready = true
                    tts?.setSpeechRate(rate)
                    tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                        override fun onStart(utteranceId: String?) {}

                        override fun onDone(utteranceId: String?) {}

                        @Deprecated("Deprecated in Java")
                        override fun onError(utteranceId: String?) {
                            fallbackIfCurrent(utteranceId)
                        }

                        override fun onError(utteranceId: String?, errorCode: Int) {
                            fallbackIfCurrent(utteranceId)
                        }
                    })
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

    private fun localeCandidates(t: TextToSpeech, lang: String): List<Locale> {
        val out = LinkedHashSet<Locale>()
        val tag = localeFor(lang)
        out.add(Locale.forLanguageTag(tag))
        val root = tag.substringBefore('-')
        out.add(Locale(root))
        try {
            for (l in t.availableLanguages) {
                if (l.language.equals(root, true)) out.add(l)
            }
        } catch (_: Exception) {
        }
        return out.toList()
    }

    /** Returns true if the engine accepted a locale for [lang]. */
    private fun applyLanguage(t: TextToSpeech, lang: String): Boolean {
        for (loc in localeCandidates(t, lang)) {
            val res = try {
                t.setLanguage(loc)
            } catch (_: Exception) {
                TextToSpeech.LANG_NOT_SUPPORTED
            }
            if (res == TextToSpeech.LANG_AVAILABLE ||
                res == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                res == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
            ) {
                return true
            }
        }
        return false
    }

    /** The engine failed to play the current phrase — try the network voice. */
    private fun fallbackIfCurrent(utteranceId: String?) {
        if (utteranceId == null || utteranceId != lastUtteranceId) return
        val p = lastFallback ?: return
        lastFallback = null
        speakOnline(p.first, p.second)
    }

    private fun releaseMedia() {
        val mp = media ?: return
        media = null
        try {
            mp.stop()
        } catch (_: Exception) {
        }
        try {
            mp.release()
        } catch (_: Exception) {
        }
    }

    /**
     * Downloads and plays [text] from the network TTS service. Used only when the
     * on-device voice can't speak [lang]; requires an internet connection.
     */
    private fun speakOnline(text: String, lang: String) {
        val code = localeFor(lang).substringBefore('-')
        val url = "https://translate.google.com/translate_tts?ie=UTF-8&client=tw-ob&tl=" +
            code + "&q=" + URLEncoder.encode(text, "UTF-8")
        Thread {
            var file: File? = null
            var conn: HttpURLConnection? = null
            try {
                val c = URL(url).openConnection() as HttpURLConnection
                conn = c
                c.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Linux; Android 12) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0 Mobile Safari/537.36"
                )
                c.setRequestProperty("Referer", "https://translate.google.com/")
                c.connectTimeout = 10000
                c.readTimeout = 15000
                if (c.responseCode == 200) {
                    val f = File(appCtx.cacheDir, "tts_" + code + "_" + (text.hashCode() and 0x7fffffff) + ".mp3")
                    c.inputStream.use { input -> f.outputStream().use { output -> input.copyTo(output) } }
                    if (f.length() > 0L) file = f
                }
            } catch (_: Exception) {
                file = null
            } finally {
                try {
                    conn?.disconnect()
                } catch (_: Exception) {
                }
            }
            val downloaded = file
            mainHandler.post {
                if (downloaded == null) {
                    if (!warnedNoLang) {
                        warnedNoLang = true
                        toastIfOnce("No ${nativeName(lang)} voice is installed and online audio failed. Download the voice in Settings → Text-to-speech.")
                    }
                    return@post
                }
                try {
                    releaseMedia()
                    val mp = MediaPlayer()
                    mp.setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build()
                    )
                    mp.setDataSource(downloaded.absolutePath)
                    mp.setOnPreparedListener { player ->
                        try {
                            player.playbackParams = player.playbackParams.setSpeed(rate)
                        } catch (_: Exception) {
                        }
                        player.start()
                    }
                    mp.setOnCompletionListener { releaseMedia() }
                    mp.setOnErrorListener { _, _, _ ->
                        releaseMedia()
                        true
                    }
                    media = mp
                    mp.prepareAsync()
                } catch (_: Exception) {
                    releaseMedia()
                }
            }
        }.start()
    }

    fun speak(text: String, lang: String) {
        if (text.isBlank()) return
        val t = tts
        if (t == null || initFailed) {
            if (!warnedNoEngine) {
                warnedNoEngine = true
                toastIfOnce("Audio isn't ready — install/check Text-to-Speech in device settings.")
            }
            return
        }
        if (!ready) {
            if (!warnedPending) {
                warnedPending = true
                toastIfOnce("Audio is starting up… tap the sound button again in a second.")
            }
            if (pending == null) pending = text to lang
            return
        }
        lastFallback = null
        releaseMedia()
        try {
            t.stop()
        } catch (_: Exception) {
        }
        t.setSpeechRate(rate)
        if (!applyLanguage(t, lang)) {
            speakOnline(text, lang)
            return
        }
        speakSeq += 1
        val id = "k" + speakSeq
        lastUtteranceId = id
        lastFallback = text to lang
        val result = try {
            t.speak(text, TextToSpeech.QUEUE_FLUSH, null, id)
        } catch (e: Exception) {
            TextToSpeech.ERROR
        }
        if (result == TextToSpeech.ERROR) {
            lastFallback = null
            if (!warnedNoEngine) {
                warnedNoEngine = true
                toastIfOnce("Using online audio for ${nativeName(lang)}. Install the device voice in Settings → Text-to-speech for offline use.")
            }
            speakOnline(text, lang)
        }
    }

    fun stop() {
        lastFallback = null
        tts?.stop()
        releaseMedia()
    }

    fun shutdown() {
        lastFallback = null
        tts?.stop()
        tts?.shutdown()
        tts = null
        releaseMedia()
    }
}
