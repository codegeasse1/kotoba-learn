package com.nexo.kotoba

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    val query = q.trim()
    var results by remember { mutableStateOf<List<DictEntry>>(emptyList()) }

    LaunchedEffect(query, store.target) {
        if (query.isEmpty()) {
            results = emptyList()
            return@LaunchedEffect
        }
        kotlinx.coroutines.delay(160)
        if (!DictionaryData.loaded) return@LaunchedEffect
        results = DictionaryData.searchRanked(query)
        if (store.target != "ja" && store.target != "en") {
            val t = store.target
            val extra = TargetContent.words(t)
                .filter { key ->
                    key.kana.contains(query, ignoreCase = true) ||
                        key.en.contains(query, ignoreCase = true) ||
                        key.hi.contains(query)
                }
                .take(60)
                .map { DictEntry.App(it) }
            results = extra + results
        }
    }

    Column(modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Dictionary", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
                Text(
                    if (DictionaryData.loaded)
                        "${DictionaryData.enAll.size} English · ${DictionaryData.jaAll.size} 日本語 · offline"
                    else "Loading 240k+ words…",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(Modifier.height(14.dp))

        OutlinedTextField(
            value = q,
            onValueChange = { q = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("Search any word: water, स्कूल, 寿司, sushi…") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(Modifier.height(10.dp))

        if (!DictionaryData.loaded) {
            Box(Modifier.fillMaxWidth().height(220.dp), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Loading the full dictionary…",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            return@Column
        }

        if (query.isEmpty()) {
            Text(
                "Every word, offline. English → Hindi, Japanese → English, plus everything you've learned. Try:",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DictChip("hello", { q = "hello" })
                DictChip("water", { q = "water" })
                DictChip("स्कूल", { q = "स्कूल" })
                DictChip("寿司", { q = "寿司" })
                DictChip("sushi", { q = "sushi" })
            }
        } else if (results.isEmpty()) {
            Text(
                "No matches for \"$q\" — try a different word or spelling.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            Text(
                "${results.size} results for \"$q\"",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(6.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(results, key = { keyOf(it) }) { r ->
                    when (r) {
                        is DictEntry.En -> EnResultCard(r.entry, store, speaker)
                        is DictEntry.Ja -> JaResultCard(r.entry, store, speaker)
                        is DictEntry.App -> AppResultCard(r.word, store, speaker)
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

private fun keyOf(r: DictEntry): String = when (r) {
    is DictEntry.En -> "e:" + r.entry.head + r.entry.hi
    is DictEntry.Ja -> "j:" + r.entry.kanji + "|" + r.entry.kana + r.entry.gloss
    is DictEntry.App -> "w:" + r.word.id
}

@Composable
private fun EnResultCard(e: EnEntry, store: Store, speaker: Speaker) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f))
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(e.head, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    if (e.pos.isNotEmpty()) {
                        Spacer(Modifier.width(8.dp))
                        Surface(shape = RoundedCornerShape(6.dp), color = MaterialTheme.colorScheme.secondaryContainer) {
                            Text(e.pos, Modifier.padding(horizontal = 6.dp, vertical = 1.dp), fontSize = 10.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
                        }
                    }
                }
                Spacer(Modifier.height(3.dp))
                Text(
                    when (store.nativeLang) {
                        "hi" -> e.hi
                        "en" -> e.head
                        else -> Gloss.lookup(e.head) ?: e.hi
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
            FilledIconButton(
                onClick = { speakIn(store, speaker, e.head, "en") },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun JaResultCard(j: JaEntry, store: Store, speaker: Speaker) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(j.kanji.ifEmpty { j.kana }, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                    if (j.common) {
                        Spacer(Modifier.width(8.dp))
                        Surface(shape = RoundedCornerShape(6.dp), color = MaterialTheme.colorScheme.tertiaryContainer) {
                            Text("common", Modifier.padding(horizontal = 6.dp, vertical = 1.dp), fontSize = 10.sp, color = MaterialTheme.colorScheme.onTertiaryContainer)
                        }
                    }
                }
                Text(
                    listOfNotNull(
                        j.kana.ifEmpty { null },
                        j.romaji.ifEmpty { null }
                    ).joinToString(" · "),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    if (store.nativeLang == "en") j.gloss else Gloss.lookup(j.gloss) ?: j.gloss,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2
                )
                if (j.pos.isNotEmpty()) {
                    Spacer(Modifier.height(2.dp))
                    Text(j.pos, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                }
            }
            FilledIconButton(
                onClick = { speakIn(store, speaker, j.kana.ifEmpty { j.kanji }, "ja") },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun AppResultCard(w: Word, store: Store, speaker: Speaker) {
    val targetJa = w.kana.isNotEmpty()
    var showExamples by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f))
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(w.emoji, fontSize = 22.sp)
            Spacer(Modifier.width(10.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    if (targetJa) w.kana else w.en,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    if (targetJa) {
                        listOfNotNull(w.romaji.ifEmpty { null }, w.kanji.ifEmpty { null }, w.en.ifEmpty { null }).joinToString(" · ")
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
                onClick = {
                    speakIn(
                        store,
                        speaker,
                        if (targetJa) w.kana else w.en,
                        if (w.lang != "ja" && w.lang != "en") w.lang else if (targetJa) "ja" else "en"
                    )
                },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
            }
            IconButton(onClick = { showExamples = true }, modifier = Modifier.size(34.dp)) {
                Text("💬", fontSize = 16.sp)
            }
        }
    }

    if (showExamples) {
        ExampleSheet(
            word = w,
            store = store,
            speaker = speaker,
            lang = w.lang.ifEmpty { store.target },
            onDismiss = { showExamples = false }
        )
    }
}

@Composable
private fun DictChip(label: String, onClick: () -> Unit) {
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
