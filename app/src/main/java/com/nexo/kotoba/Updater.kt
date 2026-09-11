package com.nexo.kotoba

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

data class UpdateInfo(
    val version: String,
    val apkUrl: String,
    val releaseUrl: String,
    val notes: String
)

object Updater {

    const val REPO = "codegeasse1/kotoba-learn"
    const val REPO_URL = "https://github.com/$REPO"
    const val RELEASES_PAGE = "https://github.com/$REPO/releases/latest"
    private const val API = "https://api.github.com/repos/$REPO/releases/latest"

    fun currentVersion(ctx: Context): String = try {
        ctx.packageManager.getPackageInfo(ctx.packageName, 0).versionName ?: "0"
    } catch (_: Exception) {
        "0"
    }

    /** Non-null when the latest published GitHub release is newer than this build. */
    suspend fun check(ctx: Context): UpdateInfo? = withContext(Dispatchers.IO) {
        try {
            val conn = (URL("$API?cb=${System.currentTimeMillis()}").openConnection() as HttpURLConnection).apply {
                connectTimeout = 10000
                readTimeout = 15000
                setRequestProperty("Accept", "application/vnd.github+json")
                setRequestProperty("User-Agent", "kotoba-app")
            }
            try {
                if (conn.responseCode !in 200..299) return@withContext null
                val body = conn.inputStream.bufferedReader().use { it.readText() }
                val o = JSONObject(body)
                val tag = o.optString("tag_name", "").trim().removePrefix("v").removePrefix("V")
                if (tag.isEmpty()) return@withContext null
                if (!isNewer(tag, currentVersion(ctx))) return@withContext null
                var apk = ""
                val assets = o.optJSONArray("assets")
                if (assets != null) {
                    for (i in 0 until assets.length()) {
                        val a = assets.getJSONObject(i)
                        if (a.optString("name", "").endsWith(".apk", true)) {
                            apk = a.optString("browser_download_url", "")
                            break
                        }
                    }
                }
                UpdateInfo(
                    version = tag,
                    apkUrl = apk,
                    releaseUrl = o.optString("html_url", RELEASES_PAGE),
                    notes = o.optString("body", "")
                )
            } finally {
                conn.disconnect()
            }
        } catch (_: Exception) {
            null
        }
    }

    fun isNewer(latest: String, current: String): Boolean {
        fun parts(s: String) = Regex("\\d+").findAll(s).map { it.value.toIntOrNull() ?: 0 }.toList()
        val a = parts(latest)
        val b = parts(current)
        for (i in 0 until maxOf(a.size, b.size)) {
            val x = a.getOrElse(i) { 0 }
            val y = b.getOrElse(i) { 0 }
            if (x != y) return x > y
        }
        return false
    }

    /** Streams the APK into the cache dir, reporting 0..100 progress. */
    suspend fun download(ctx: Context, url: String, onProgress: (Int) -> Unit): File =
        withContext(Dispatchers.IO) {
            if (url.isEmpty()) throw IllegalStateException("No APK asset in the latest release")
            val dir = File(ctx.cacheDir, "updates").apply { mkdirs() }
            val out = File(dir, "kotoba-update.apk")
            if (out.exists()) out.delete()

            var conn = openFollowing(url)
            var code = conn.responseCode
            var hops = 0
            while (code in 300..399 && hops < 6) {
                val loc = conn.getHeaderField("Location") ?: break
                conn.disconnect()
                conn = openFollowing(URL(loc).toString())
                code = conn.responseCode
                hops++
            }
            if (code !in 200..299) {
                conn.disconnect()
                throw IllegalStateException("Download failed (HTTP $code)")
            }
            val total = conn.contentLengthLong
            conn.inputStream.use { input ->
                out.outputStream().use { output ->
                    val buf = ByteArray(16 * 1024)
                    var done = 0L
                    while (true) {
                        val read = input.read(buf)
                        if (read == -1) break
                        output.write(buf, 0, read)
                        done += read
                        if (total > 0) onProgress(((done * 100) / total).toInt().coerceIn(0, 100))
                    }
                }
            }
            conn.disconnect()
            if (out.length() < 1024) throw IllegalStateException("Downloaded file looks empty")
            onProgress(100)
            out
        }

    private fun openFollowing(url: String): HttpURLConnection =
        (URL(url).openConnection() as HttpURLConnection).apply {
            instanceFollowRedirects = true
            connectTimeout = 15000
            readTimeout = 60000
            setRequestProperty("User-Agent", "kotoba-app")
            setRequestProperty("Accept", "application/octet-stream")
        }

    fun canInstall(ctx: Context): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) ctx.packageManager.canRequestPackageInstalls() else true

    fun openInstallSettings(ctx: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                ctx.startActivity(
                    Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:${ctx.packageName}"))
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            } catch (_: Exception) {
            }
        }
    }

    /** Launches the system package installer for the downloaded APK. */
    fun install(ctx: Context, apk: File) {
        val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", apk)
        ctx.startActivity(
            Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "application/vnd.android.package-archive")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
        )
    }

    fun openReleasePage(ctx: Context, url: String) {
        try {
            ctx.startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse(url.ifBlank { RELEASES_PAGE }))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        } catch (_: Exception) {
        }
    }
}
