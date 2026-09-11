package com.nexo.kotoba

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun UpdateAvailableDialog(
    info: UpdateInfo,
    currentVersion: String,
    onDismiss: () -> Unit
) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    var downloading by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0) }
    var apkFile by remember { mutableStateOf<File?>(null) }
    var status by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    fun install(apk: File) {
        if (Updater.canInstall(ctx)) {
            try {
                Updater.install(ctx, apk)
                onDismiss()
            } catch (e: Exception) {
                error = "Couldn't open the installer: ${e.message ?: "unknown error"}"
            }
        } else {
            status = "Allow \"Install unknown apps\" for Kotoba, then tap \"Install update\" again."
            Updater.openInstallSettings(ctx)
        }
    }

    AlertDialog(
        onDismissRequest = { if (!downloading) onDismiss() },
        title = { Text("🚀 Update available", fontWeight = FontWeight.Bold) },
        text = {
            Column {
                Text("Kotoba ${info.version} is ready — you're on $currentVersion.")
                if (info.notes.isNotBlank()) {
                    Spacer(Modifier.height(8.dp))
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .heightIn(max = 160.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            info.notes.trim(),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                if (downloading) {
                    Spacer(Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { progress / 100f },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(4.dp))
                    Text("Downloading update… $progress%", style = MaterialTheme.typography.labelMedium)
                }
                status?.let {
                    Spacer(Modifier.height(10.dp))
                    Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                }
                error?.let {
                    Spacer(Modifier.height(10.dp))
                    Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error)
                }
                Spacer(Modifier.height(10.dp))
                TextButton(
                    onClick = { Updater.openReleasePage(ctx, info.releaseUrl) },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("Open GitHub release page (manual download)")
                }
            }
        },
        confirmButton = {
            Button(
                enabled = !downloading,
                onClick = {
                    error = null
                    val existing = apkFile
                    if (existing != null) {
                        install(existing)
                    } else {
                        scope.launch {
                            downloading = true
                            progress = 0
                            try {
                                val apk = Updater.download(ctx, info.apkUrl) { progress = it }
                                apkFile = apk
                                downloading = false
                                install(apk)
                            } catch (e: Exception) {
                                downloading = false
                                error = e.message ?: "Download failed"
                            }
                        }
                    }
                }
            ) {
                Text(
                    when {
                        downloading -> "Downloading… $progress%"
                        apkFile != null -> "Install update"
                        else -> "Update now"
                    }
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss, enabled = !downloading) { Text("Later") }
        }
    )
}
