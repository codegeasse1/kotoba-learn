package com.nexo.kotoba

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KanaScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier, onClose: () -> Unit) {
    BackHandler(onBack = onClose)
    var tab by remember { mutableStateOf(0) }
    var quizMode by remember { mutableStateOf(false) }

    val sets = listOf(
        "Hiragana" to KanaData.hiragana,
        "Katakana" to KanaData.katakana,
        "Hiragana⁺" to KanaData.hiraganaDakuon,
        "Katakana⁺" to KanaData.katakanaDakuon
    )

    if (quizMode) {
        KanaQuiz(store, speaker, sets[tab].second, modifier, onExit = { quizMode = false })
        return
    }

    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text("Kana", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold)
                Text(
                    "Master the Japanese sound system — each character is one sound.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { quizMode = true }) {
                Icon(Icons.Filled.Quiz, contentDescription = "Kana quiz")
            }
        }
        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            sets.forEachIndexed { i, (name, _) ->
                FilterChip(
                    selected = tab == i,
                    onClick = { tab = i },
                    label = { Text(name) }
                )
            }
        }
        Spacer(Modifier.height(12.dp))

        val chars = sets[tab].second
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(chars) { c ->
                val learned = c.id in store.learnedKana
                var showDetail by remember { mutableStateOf(false) }
                Card(
                    modifier = Modifier
                        .aspectRatio(0.85f)
                        .clickable { showDetail = true },
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (learned) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Box(
                        Modifier.fillMaxSize().padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(c.kana, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                            Text(c.romaji, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        if (learned) {
                            Icon(
                                Icons.Filled.CheckCircle,
                                contentDescription = "Learned",
                                modifier = Modifier.size(16.dp).align(Alignment.TopEnd),
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }
                }
                if (showDetail) {
                    KanaDetailDialog(
                        c = c,
                        learned = learned,
                        store = store,
                        speaker = speaker,
                        onDismiss = { showDetail = false }
                    )
                }
            }
        }
    }
}

@Composable
private fun KanaDetailDialog(
    c: KanaChar,
    learned: Boolean,
    store: Store,
    speaker: Speaker,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(c.kana, fontSize = 72.sp, fontWeight = FontWeight.ExtraBold)
                Text(c.romaji, style = MaterialTheme.typography.titleMedium)
            }
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(c.mnemonic, textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium)
            }
        },
        confirmButton = {
            Row {
                FilledIconButton(onClick = { speak(store, speaker, c.kana, true) }) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    store.toggleKana(c.id)
                    onDismiss()
                }) {
                    Icon(Icons.Filled.Check, contentDescription = null)
                    Spacer(Modifier.width(4.dp))
                    Text(if (learned) "Learned ✓" else "Mark learned")
                }
                Spacer(Modifier.width(10.dp))
                TextButton(onClick = onDismiss) { Text("Close") }
            }
        }
    )
}

@Composable
private fun KanaQuiz(store: Store, speaker: Speaker, chars: List<KanaChar>, modifier: Modifier = Modifier, onExit: () -> Unit) {
    BackHandler(onBack = onExit)
    val rnd = remember { java.util.Random() }
    val questions = remember {
        chars.shuffled(rnd).take(10).map { w ->
            val audioOnly = rnd.nextBoolean()
            val distractors = chars.filter { it.id != w.id }.shuffled(rnd).take(3)
            val options = (distractors + w).shuffled(rnd)
            Triple(audioOnly, options, options.indexOf(w))
        }
    }
    var index by remember { mutableStateOf(0) }
    var picked by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }
    var done by remember { mutableStateOf(false) }

    val (audioOnly, options, correct) = questions[index]

    if (!done) {
        LaunchedEffect(index) {
            if (audioOnly) speak(store, speaker, questions[index].second[questions[index].third].kana, true)
        }
    }

    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = onExit) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(if (done) "Done" else "Question ${index + 1}/10", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.weight(1f))
            Text("⭐ $score", style = MaterialTheme.typography.labelLarge)
        }

        if (done) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("🏆", fontSize = 64.sp)
                Spacer(Modifier.height(12.dp))
                Text("Kana quiz finished!", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(6.dp))
                Text("Score: $score / 10", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(20.dp))
                Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Back to kana") }
            }
        } else {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    Modifier.fillMaxWidth().padding(vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (audioOnly) {
                        Text("🔊 Listen", fontSize = 26.sp)
                        Spacer(Modifier.height(6.dp))
                        FilledIconButton(onClick = {
                            speak(store, speaker, questions[index].second[questions[index].third].kana, true)
                        }) {
                            Icon(Icons.Filled.VolumeUp, contentDescription = "Hear again")
                        }
                    } else {
                        Text(
                            options[correct].romaji,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text("which character?", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))

            options.forEachIndexed { i, opt ->
                val isCorrect = i == correct
                val isPicked = i == picked
                val borderColor = when {
                    picked == null -> Color.Transparent
                    isCorrect -> Color(0xFF2E9E5B)
                    isPicked -> Color(0xFFD64545)
                    else -> Color.Transparent
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .border(2.dp, borderColor, RoundedCornerShape(16.dp))
                        .clickable(enabled = picked == null) {
                            if (picked == null) {
                                picked = i
                                if (isCorrect) score++
                            }
                        },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth().padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(opt.kana, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.width(10.dp))
                        Text(opt.romaji, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }

            if (picked != null) {
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {
                        if (index == questions.lastIndex) {
                            store.addXp(score * 2)
                            done = true
                        } else {
                            index++
                            picked = null
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (index == questions.lastIndex) "Finish" else "Next")
                }
            }
        }
    }
}
