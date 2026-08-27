package com.nexo.kotoba

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
fun GrammarScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var open by remember { mutableStateOf<Pattern?>(null) }

    when {
        open != null -> PatternDetail(open!!, store, speaker, modifier, onClose = { open = null })
        else -> Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
        Text("Grammar", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        Text(
            "Learn the patterns, not the jargon — each rule gets real sentences with sound.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(20.dp))

        Text("Japanese patterns", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Data.allPatterns.filter { it.lang == "ja" && it.source.isEmpty() }.groupBy { Levels.ofPattern(it) }
            .toSortedMap(compareBy { Levels.order(it) })
            .forEach { (lv, ps) ->
                Text(
                    (Levels.EMOJI[lv] ?: "📘") + "  " + Levels.label(lv),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(6.dp))
                ps.forEach { p ->
                    PatternRow(p, onClick = { open = p })
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(10.dp))
            }

        Spacer(Modifier.height(12.dp))
        Text("Genki Textbook 1 grammar", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(6.dp))
        Genki.patterns.forEach { p ->
            PatternRow(p, onClick = { open = p })
            Spacer(Modifier.height(8.dp))
        }
        Spacer(Modifier.height(12.dp))
        Text("Japanese From Zero grammar", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(6.dp))
        Jfz.patterns.forEach { p ->
            PatternRow(p, onClick = { open = p })
            Spacer(Modifier.height(8.dp))
        }
        Spacer(Modifier.height(12.dp))

        Spacer(Modifier.height(20.dp))
        Text("English patterns", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Data.allPatterns.filter { it.lang == "en" && it.source.isEmpty() }.groupBy { Levels.ofPattern(it) }
            .toSortedMap(compareBy { Levels.order(it) })
            .forEach { (lv, ps) ->
                Text(
                    (Levels.EMOJI[lv] ?: "📘") + "  " + Levels.label(lv),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(6.dp))
                ps.forEach { p ->
                    PatternRow(p, onClick = { open = p })
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(10.dp))
            }
        Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun PatternRow(p: Pattern, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(p.titleEn, fontWeight = FontWeight.Bold)
                Text(
                    p.titleJa,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun PatternDetail(p: Pattern, store: Store, speaker: Speaker, modifier: Modifier = Modifier, onClose: () -> Unit) {
    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text(p.titleEn, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(p.titleJa, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Spacer(Modifier.height(10.dp))

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(Modifier.padding(18.dp)) {
                    if (store.nativeLang != "en") {
                        Text(p.ruleFor(store.nativeLang), style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(p.ruleEn, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    } else {
                        Text(p.ruleEn, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(p.ruleJa, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
            Spacer(Modifier.height(14.dp))

            Text("Examples", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            p.examples.forEach { ex ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(ex.emoji, fontSize = 24.sp)
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text(ex.ja, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                            Text(
                                ex.romaji,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(ex.glossFor(store.nativeLang), style = MaterialTheme.typography.bodyMedium)
                        }
                        FilledIconButton(
                            onClick = { speak(store, speaker, ex.ja, p.lang == "ja") },
                            modifier = Modifier.size(38.dp)
                        ) {
                            Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(18.dp))
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
