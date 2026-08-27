package com.nexo.kotoba

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GrammarScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var open by remember { mutableStateOf<Pattern?>(null) }
    var q by remember { mutableStateOf("") }
    val scroll = rememberScrollState()
    val learningJa = store.direction != Direction.ENGLISH
    val learningEn = store.direction != Direction.JAPANESE
    val query = q.trim().lowercase()

    fun matches(p: Pattern): Boolean {
        if (query.isEmpty()) return true
        return p.titleEn.lowercase().contains(query) || p.titleJa.lowercase().contains(query) ||
            p.ruleEn.lowercase().contains(query) || p.ruleJa.lowercase().contains(query)
    }

    when {
        open != null -> PatternDetail(open!!, store, speaker, modifier, onClose = { open = null })
        else -> Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scroll)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("Grammar", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
            Text(
                "Learn the patterns, not the jargon — search any topic like 'would' or 'have'.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(14.dp))

            OutlinedTextField(
                value = q,
                onValueChange = { q = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Search grammar — e.g. would, have, prepositions…") },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                trailingIcon = if (q.isNotEmpty()) {
                    {
                        IconButton(onClick = { q = "" }) {
                            Icon(Icons.Filled.Close, contentDescription = "Clear")
                        }
                    }
                } else null,
                shape = RoundedCornerShape(16.dp)
            )
            if (query.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))
                Text(
                    "Searching \"$q\"",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(Modifier.height(16.dp))

            val jaCore = Data.allPatterns.filter { it.lang == "ja" && it.source.isEmpty() && matches(it) }
            val enCore = Data.allPatterns.filter { it.lang == "en" && it.source.isEmpty() && matches(it) }
            val genki = Genki.patterns.filter { matches(it) }
            val jfz = Jfz.patterns.filter { matches(it) }
            val jg = JapaneseGrammar.patterns.filter { matches(it) }
            val eg = EnglishGrammar.patterns.filter { matches(it) }
            val total = (if (learningJa) jaCore.size + genki.size + jfz.size + jg.size else 0) +
                (if (learningEn) enCore.size + eg.size else 0)

            if (query.isNotEmpty() && total == 0) {
                Text(
                    "No grammar topics match \"$q\". Try 'would', 'have', 'can', 'prepositions', 'tense'…",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(16.dp))
            } else {
                if (learningJa) {
                    SectionList("Japanese patterns", jaCore, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                    SectionList("Genki Textbook 1", genki, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                    SectionList("Japanese From Zero", jfz, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                    SectionList("Japanese Essentials", jg, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                }
                if (learningEn) {
                    SectionList("English patterns", enCore, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                    SectionList("English Grammar Essentials", eg, query.isNotEmpty(), onClick = { open = it })
                    Spacer(Modifier.height(12.dp))
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun SectionList(title: String, ps: List<Pattern>, isSearch: Boolean, onClick: (Pattern) -> Unit) {
    if (ps.isEmpty()) return
    Text(
        title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = if (isSearch) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
    )
    if (isSearch) {
        Text(
            "${ps.size} match" + (if (ps.size == 1) "" else "es"),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    Spacer(Modifier.height(6.dp))
    ps.forEach { p ->
        PatternRow(p, onClick = { onClick(p) })
        Spacer(Modifier.height(8.dp))
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
    BackHandler(onBack = onClose)
    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(horizontal = 20.dp)) {
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text(p.titleEn, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(p.titleJa, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Spacer(Modifier.height(6.dp))

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            RuleCard(p, store)
            Spacer(Modifier.height(14.dp))

            Text("Examples — ${p.examples.size} sentences", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(
                "Read each one aloud. Tap 🔊 to hear it.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
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

@Composable
private fun RuleCard(p: Pattern, store: Store) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(Modifier.padding(18.dp)) {
            RuleParagraphs(p.ruleFor(store.nativeLang))
            val showEnExtra = (store.nativeLang == "hi") || (store.nativeLang == "ja" && p.ruleJa.isNotEmpty())
            if (showEnExtra) {
                Spacer(Modifier.height(12.dp))
                RuleParagraphs(p.ruleEn)
            }
        }
    }
}

@Composable
private fun RuleParagraphs(text: String) {
    val paragraphs = text.split("\n").filter { it.isNotBlank() }
    paragraphs.forEach { para ->
        val labelMatch = Regex("^([A-Z][A-Z ]{2,20}):").find(para)
        if (labelMatch != null) {
            Text(
                labelMatch.groupValues[1] + ":",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            val rest = para.substring(labelMatch.range.last + 1).trim()
            if (rest.isNotEmpty()) {
                Spacer(Modifier.height(2.dp))
                Text(rest, style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            Text(para, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(8.dp))
    }
}
