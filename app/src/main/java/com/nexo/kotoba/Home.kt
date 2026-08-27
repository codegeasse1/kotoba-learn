package com.nexo.kotoba

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun HomeScreen(
    store: Store,
    speaker: Speaker,
    modifier: Modifier = Modifier,
    onNav: (Screen) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text(
            "こんにちは 👋",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            "Kotoba",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            "Learn Japanese & English — no bridge language needed",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(96.dp)) {
                    CircularProgressIndicator(
                        progress = { store.levelProgress() },
                        modifier = Modifier.size(96.dp),
                        strokeWidth = 10.dp,
                        strokeCap = StrokeCap.Round,
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surface
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("LV ${store.level()}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("${store.xp} XP", fontSize = 11.sp)
                    }
                }
                Spacer(Modifier.width(20.dp))
                Column {
                    Text(
                        "🔥 ${store.streak} day streak",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Best: ${store.bestStreak} days", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(6.dp))
                    Text(
                        if (store.streak == 0) "Start today to begin a streak!"
                        else "Keep it alive — review a few words.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        Spacer(Modifier.height(16.dp))

        val due = store.dueCount()
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(Modifier.padding(20.dp)) {
                Text("Continue learning", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))
                Text(
                    if (due > 0) "You have $due words ready for review."
                    else "No reviews due — time to learn something new!",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(14.dp))
                Button(onClick = { onNav(if (due > 0) Screen.REVIEW else Screen.LEARN) }) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = null)
                    Spacer(Modifier.width(6.dp))
                    Text(if (due > 0) "Review now" else "Start a lesson")
                }
            }
        }
        Spacer(Modifier.height(16.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("📚", "${store.wordsLearnedCount()}", "words")
            StatCard("✅", "${store.completedLessons.size}", "lessons")
            StatCard("あ", "${store.learnedKana.size}", "kana")
        }
        Spacer(Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.AutoAwesome,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Study tip", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondaryContainer)
                }
                Spacer(Modifier.height(8.dp))
                Text(Tips.tipOfTheDay(), color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
        }
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun StatCard(emoji: String, value: String, label: String) {
    Card(
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(emoji, fontSize = 22.sp)
            Spacer(Modifier.height(4.dp))
            Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

object Tips {
    private val tips = listOf(
        "Spaced repetition beats cramming: short daily reviews make memories stick.",
        "Say words ALOUD — hearing yourself speak doubles the memory.",
        "Link new words to a picture, not a translation. That's how kids learn.",
        "Learn words in chunks ('I like ~') — you'll speak in sentences faster.",
        "A 5-minute review today saves an hour of re-learning next week.",
        "The first 100 words of any language cover ~50% of daily speech.",
        "Don't memorize kanji alone — meet them inside words you already know.",
        "Mistakes are data, not failure. Every wrong answer schedules a helpful review.",
        "Shadow the audio: repeat right after the speaker, matching their rhythm.",
        "Consistency beats intensity. 10 minutes every day wins.",
        "Learn sounds first. In Japanese that's kana — 46 characters unlock everything.",
        "Interleave skills: read, then listen, then speak. Variety strengthens recall."
    )

    fun tipOfTheDay(): String {
        val day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return tips[day % tips.size]
    }
}
