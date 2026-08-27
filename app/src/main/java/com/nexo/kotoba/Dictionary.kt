package com.nexo.kotoba

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DictionaryScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var q by remember { mutableStateOf("") }
    var tts by remember { mutableStateOf("") }
    val query = q.trim().lowercase()
    val results = remember(query) {
        if (query.isEmpty()) emptyList()
        else Data.allWords.filter { w ->
            w.kana.lowercase().contains(query) || w.romaji.lowercase().contains(query) ||
                w.kanji.lowercase().contains(query) || w.en.lowercase().contains(query) ||
                w.hi.lowercase().contains(query) || w.ipa.lowercase().contains(query)
        }.distinctBy { it.en.lowercase() }.take(80)
    }

    Column(modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        Spacer(Modifier.height(16.dp))
        Text("Dictionary", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        Text(
            "Search ${Data.allWords.size}+ words — tap 🔊 to hear any word in both languages.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(14.dp))

        OutlinedTextField(
            value = q,
            onValueChange = { q = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("Search English, 日本語 or हिन्दी…") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(Modifier.height(14.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(Modifier.padding(14.dp)) {
                Text("🔊 Hear any text", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(6.dp))
                OutlinedTextField(
                    value = tts,
                    onValueChange = { tts = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Type any word or sentence…") },
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(Modifier.height(8.dp))
                Row(horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(
                        onClick = { if (tts.isNotBlank()) speak(store, speaker, tts, true) },
                        enabled = tts.isNotBlank()
                    ) {
                        Text("🇯🇵 Say in Japanese")
                    }
                    OutlinedButton(
                        onClick = { if (tts.isNotBlank()) speak(store, speaker, tts, false) },
                        enabled = tts.isNotBlank()
                    ) {
                        Text("🇬🇧 Say in English")
                    }
                }
            }
        }
        Spacer(Modifier.height(12.dp))

        if (query.isNotEmpty()) {
            Text(
                "${results.size} results for \"$q\"",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(6.dp))
        }

        if (query.isEmpty()) {
            Text(
                "Every word in the app, in one search. Try: ありがとう, 猫, dog, 学校, suki, …",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)) {
                ExampleChip("こんにちは", { q = "こんにちは" })
                ExampleChip("cat", { q = "cat" })
                ExampleChip("学校", { q = "学校" })
            }
        } else if (results.isEmpty()) {
            Text(
                "No matches — but you can still type it above and tap 🔊 to hear it.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(results, key = { it.id }) { w ->
                    val targetJa = w.kana.isNotEmpty()
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(w.emoji, fontSize = 24.sp)
                            Spacer(Modifier.width(10.dp))
                            Column(Modifier.weight(1f)) {
                                Text(
                                    if (targetJa) w.kana else w.en,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    if (targetJa) {
                                        listOfNotNull(
                                            w.romaji.ifEmpty { null },
                                            w.kanji.ifEmpty { null },
                                            w.en.ifEmpty { null }
                                        ).joinToString(" · ")
                                    } else {
                                        w.ipa
                                    },
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    w.glossFor(store.nativeLang),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            FilledIconButton(
                                onClick = { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) },
                                modifier = Modifier.size(34.dp)
                            ) {
                                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun ExampleChip(label: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}
