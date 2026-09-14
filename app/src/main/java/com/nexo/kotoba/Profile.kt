package com.nexo.kotoba

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    var showReset by remember { mutableStateOf(false) }
    var checking by remember { mutableStateOf(false) }
    var upToDate by remember { mutableStateOf(false) }
    var updateInfo by remember { mutableStateOf<UpdateInfo?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text("Profile", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        Text(
            "Your progress, stats and learning preferences.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Level ${store.level()}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.weight(1f))
                    Text("${store.xp} XP", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    "${store.xp % 250}/250 XP to level ${store.level() + 1}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(12.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatBox("🔥", "${store.streak}", "streak")
                    StatBox("👑", "${store.bestStreak}", "best")
                    StatBox("📚", "${store.wordsLearnedCount()}", "words")
                    StatBox("✅", "${store.completedLessons.size}", "lessons")
                    StatBox("あ", "${store.learnedKana.size}", "kana")
                }
            }
        }
        Spacer(Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)) {
            Column(Modifier.padding(20.dp)) {
                Text("My native language", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "Kotoba teaches you with explanations in this language.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(10.dp))
                NATIVE_LANGUAGES.chunked(2).forEach { row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        row.forEach { (code, name) ->
                            FilterChip(
                                selected = store.nativeLang == code,
                                onClick = { store.setNative(code) },
                                label = { Text(name) }
                            )
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
        Spacer(Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)) {
            Column(Modifier.padding(20.dp)) {
                Text("I'm learning…", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "Pick any language to study — vocabulary, example sentences and grammar are all translated into it.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(10.dp))
                NATIVE_LANGUAGES.chunked(2).forEach { row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        row.forEach { (code, name) ->
                            FilterChip(
                                selected = store.target == code,
                                onClick = { store.setTargetLang(code) },
                                label = { Text(name) }
                            )
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                }
                Text(
                    "Learning ${nativeName(store.target)} with ${nativeName(store.nativeLang)} explanations.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(Modifier.height(18.dp))
                SettingSwitch(
                    title = "Show romaji (latin letters)",
                    subtitle = "Helpful at the start, hide it later to read real kana.",
                    checked = store.showRomaji,
                    onCheckedChange = { store.showRomaji = it }
                )
                SettingSwitch(
                    title = "Show translations",
                    subtitle = "Turn off to learn purely from pictures and sound.",
                    checked = store.showTranslations,
                    onCheckedChange = { store.showTranslations = it }
                )

                Spacer(Modifier.height(14.dp))
                Text("Speech speed", fontWeight = FontWeight.Medium)
                Text(
                    "Slower is easier for beginners to catch sounds.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Slider(
                    value = store.speechRate,
                    onValueChange = {
                        store.speechRate = it
                        speaker.setRate(it)
                    },
                    valueRange = 0.5f..1.2f
                )
                Text(
                    "${String.format("%.2f", store.speechRate)}×",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
        Spacer(Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                if (!checking) {
                    checking = true
                    upToDate = false
                    scope.launch {
                        val info = Updater.check(ctx)
                        checking = false
                        if (info != null) updateInfo = info else upToDate = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (checking) "Checking for updates…"
                else "Check for updates  ·  v${Updater.currentVersion(ctx)}"
            )
        }
        if (upToDate) {
            Spacer(Modifier.height(6.dp))
            Text(
                "You're on the latest version 🎉",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(Modifier.height(12.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)) {
            Column(Modifier.padding(20.dp)) {
                Text("Advanced", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "Optional extras. Everything here works fully offline — no account and no API key.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(6.dp))
                SettingSwitch(
                    title = "More example sentences",
                    subtitle = "Adds a bundled sentence bank so words show extra examples. Works in airplane mode.",
                    checked = store.extraExamples,
                    onCheckedChange = {
                        store.extraExamples = it
                        store.save()
                    }
                )
            }
        }
        Spacer(Modifier.height(20.dp))

        Text("About", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(4.dp))
        Text(
            "Kotoba is a free, offline-first language-learning app. Learn Japanese, English, " +
                "Spanish, Hindi and 8 more — with vocabulary, example sentences, grammar " +
                "patterns and conversations explained in your own language.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(4.dp))
        Text(
            "Version ${Updater.currentVersion(ctx)}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            TextButton(onClick = { Updater.openReleasePage(ctx, Updater.REPO_URL) }) {
                Text("Source on GitHub")
            }
            TextButton(onClick = { Updater.openReleasePage(ctx, Updater.RELEASES_PAGE) }) {
                Text("Releases")
            }
        }
        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = { showReset = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset all progress", color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(24.dp))
    }

    updateInfo?.let { info ->
        UpdateAvailableDialog(
            info = info,
            currentVersion = Updater.currentVersion(ctx),
            onDismiss = { updateInfo = null }
        )
    }

    if (showReset) {
        AlertDialog(
            onDismissRequest = { showReset = false },
            title = { Text("Reset everything?") },
            text = { Text("This deletes your XP, streak, learned kana and all review schedules. This cannot be undone.") },
            confirmButton = {
                TextButton(onClick = {
                    store.resetAll()
                    showReset = false
                }) { Text("Reset", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { showReset = false }) { Text("Cancel") }
            }
        )
    }
}

@Composable
private fun RowScope.StatBox(emoji: String, value: String, label: String) {
    Card(
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            Modifier.fillMaxWidth().padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(emoji, fontSize = 18.sp)
            Text(value, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(label, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun SettingSwitch(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        Modifier.fillMaxWidth().padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(title, fontWeight = FontWeight.Medium)
            Text(
                subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}


