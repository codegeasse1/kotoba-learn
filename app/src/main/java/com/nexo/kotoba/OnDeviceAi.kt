package com.nexo.kotoba

import android.content.Context
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ThreadLocalRandom

/**
 * OPTION 1: an optional on-device language model.
 *
 * Everything here is OFF by default and only runs when the learner enables it in
 * Profile → Advanced and downloads a model. The model lives in the app's private
 * files directory and runs entirely on the phone via MediaPipe LLM Inference, so
 * after the one-time download there is no internet, no account, and no API key —
 * which is what makes it usable in an offline-first app.
 *
 * The models are small (~547 MB / ~1.6 GB) and permissively licensed; the URLs
 * point at public, non-gated Hugging Face files.
 *
 * IMPORTANT: every entry must be a MediaPipe `.task` bundle. LiteRT-LM `.litertlm`
 * files look like the same thing but are NOT loadable by `LlmInference` — they fail
 * with "SentencePiece tokenizer is not found in the model", so don't add one here.
 */
object OnDeviceAi {

    /** Id of the model offered by default (the first entry of [MODELS]). */
    const val DEFAULT_ID = "qwen2.5-0.5b"

    /**
     * Total number of tokens (prompt + reply) the engine accepts. The old value of 256
     * was fine for the one-paragraph prompt this app used to send, but the ChatML prompt
     * with worked examples easily exceeds it — and the native library does not merely
     * truncate an over-long query, it rejects it. The bundled models ship a 1280-token KV
     * cache, so 1024 leaves headroom for the reply while staying inside the cache.
     */
    private const val MAX_TOKENS = 1024

    data class Model(
        val id: String,
        val label: String,
        val sizeMb: Int,
        val bytes: Long,
        val url: String,
        val file: String,
        val note: String
    )

    val MODELS: List<Model> = listOf(
        Model(
            id = "qwen2.5-0.5b",
            label = "Light · Qwen2.5 0.5B",
            sizeMb = 547,
            bytes = 546_660_344L,
            url = "https://huggingface.co/litert-community/Qwen2.5-0.5B-Instruct/resolve/main/Qwen2.5-0.5B-Instruct_multi-prefill-seq_q8_ekv1280.task",
            file = "Qwen2.5-0.5B-Instruct_q8_ekv1280.task",
            note = "Smallest download that works. Best for English, Japanese and other widely-supported languages."
        ),
        Model(
            id = "qwen2.5-1.5b",
            label = "Better · Qwen2.5 1.5B",
            sizeMb = 1598,
            bytes = 1_597_913_616L,
            url = "https://huggingface.co/litert-community/Qwen2.5-1.5B-Instruct/resolve/main/Qwen2.5-1.5B-Instruct_multi-prefill-seq_q8_ekv1280.task",
            file = "Qwen2.5-1.5B-Instruct_q8_ekv1280.task",
            note = "Clearly better sentences, but a very large download."
        )
    )

    fun model(id: String): Model = MODELS.firstOrNull { it.id == id } ?: MODELS[0]

    private fun dir(ctx: Context): File =
        File(ctx.applicationContext.filesDir, "ai-models").apply { if (!exists()) mkdirs() }

    fun fileFor(ctx: Context, id: String): File = File(dir(ctx), model(id).file)

    /**
     * True once a *complete* model file is on disk. The old check was "larger than
     * 1 MB", which called a download that stopped at 40% ready — and handing a
     * truncated model to MediaPipe's native loader is not a graceful failure.
     */
    fun isReady(ctx: Context, id: String): Boolean {
        val f = fileFor(ctx, id)
        if (!f.exists()) return false
        val expected = model(id).bytes
        return f.length() >= expected - expected / 50
    }

    fun delete(ctx: Context, id: String) {
        fileFor(ctx, id).delete()
        synchronized(this) {
            engine?.close()
            engine = null
            enginePath = null
        }
    }

    /**
     * Downloads a model, reporting 0..100 progress. Returns null on success, or a
     * human-readable message on failure. Safe to call from the main thread (it
     * switches to IO itself).
     */
    suspend fun download(ctx: Context, id: String, onProgress: (Int) -> Unit): String? =
        withContext(Dispatchers.IO) {
            val m = model(id)
            val target = fileFor(ctx, id)
            val tmp = File(target.parentFile, target.name + ".part")
            try {
                val conn = (URL(m.url).openConnection() as HttpURLConnection).apply {
                    connectTimeout = 20_000
                    readTimeout = 30_000
                    instanceFollowRedirects = true
                    setRequestProperty("User-Agent", "Kotoba-Android")
                }
                conn.connect()
                val code = conn.responseCode
                if (code !in 200..299) {
                    conn.disconnect()
                    return@withContext "Server returned HTTP $code"
                }
                val total = conn.contentLengthLong
                conn.inputStream.use { input ->
                    FileOutputStream(tmp).use { output ->
                        val buf = ByteArray(256 * 1024)
                        var read = 0L
                        var lastPct = -1
                        while (true) {
                            val n = input.read(buf)
                            if (n <= 0) break
                            output.write(buf, 0, n)
                            read += n
                            if (total > 0) {
                                val pct = ((read * 100) / total).toInt().coerceIn(0, 100)
                                if (pct != lastPct) {
                                    lastPct = pct
                                    onProgress(pct)
                                }
                            }
                        }
                    }
                }
                conn.disconnect()
                val expected = m.bytes
                val got = tmp.length()
                if (got < expected - expected / 50) {
                    tmp.delete()
                    return@withContext "The download stopped early ($got of $expected bytes). Please try again."
                }
                if (target.exists()) target.delete()
                if (!tmp.renameTo(target)) {
                    tmp.delete()
                    return@withContext "Could not save the model (storage full?)."
                }
                null
            } catch (e: Exception) {
                tmp.delete()
                e.message ?: "Download failed."
            }
        }

    private val lock = Mutex()

    @Volatile
    private var engine: LlmInference? = null

    @Volatile
    private var enginePath: String? = null

    /**
     * Runs [prompt] through the on-device model. Blocking, so it is serialised and
     * pushed off the main thread. The model is kept warm between calls.
     *
     * The per-call [seed] matters more than it looks: MediaPipe's session options
     * default to `randomSeed = 0`, which makes sampling fully deterministic — every
     * "generate" tap used to return the exact same sentence.
     */
    suspend fun generate(
        ctx: Context,
        id: String,
        prompt: String,
        seed: Int = randomSeed()
    ): String = lock.withLock {
        withContext(Dispatchers.IO) {
            val app = ctx.applicationContext
            val f = fileFor(app, id)
            require(isReady(app, id)) {
                "The on-device model is missing or incomplete. Download it again in Profile → Advanced."
            }

            val engine = synchronized(this@OnDeviceAi) { engineFor(app, f) }
            try {
                val sessionOptions = LlmInferenceSession.LlmInferenceSessionOptions.builder()
                    .setTopK(40)
                    .setTopP(0.95f)
                    .setTemperature(0.85f)
                    .setRandomSeed(seed)
                    .build()
                val session = LlmInferenceSession.createFromOptions(engine, sessionOptions)
                try {
                    session.addQueryChunk(prompt)
                    session.generateResponse()
                } finally {
                    session.close()
                }
            } catch (e: Exception) {
                // The session-options API is newer than the plain engine call. If it is
                // unavailable or refuses this query, fall back to the classic single-shot
                // call (a fresh session with the engine's default options) rather than
                // failing the whole generation.
                engine.generateResponse(prompt)
            }
        }
    }

    /** Loads the engine for [f] once and keeps it warm between calls. */
    private fun engineFor(app: Context, f: File): LlmInference {
        val current = engine
        if (current != null && enginePath == f.absolutePath) return current
        current?.close()
        engine = null
        val options = LlmInference.LlmInferenceOptions.builder()
            .setModelPath(f.absolutePath)
            .setMaxTopK(40)
            .setMaxTokens(MAX_TOKENS)
            .build()
        return try {
            LlmInference.createFromOptions(app, options).also {
                engine = it
                enginePath = f.absolutePath
            }
        } catch (e: Exception) {
            enginePath = null
            throw IllegalStateException(
                "This model could not be loaded (${e.message ?: "unknown error"}). " +
                    "Try deleting it and downloading another model in Profile → Advanced.",
                e
            )
        }
    }

    /** A fresh seed per call so two generations are never identical. */
    private fun randomSeed(): Int = ThreadLocalRandom.current().nextInt(1, Int.MAX_VALUE)
}
