package com.nexo.kotoba

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
fun AlphabetScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier, onClose: () -> Unit) {
    var quizMode by remember { mutableStateOf(false) }

    if (quizMode) {
        AlphabetQuiz(store, speaker, modifier, onExit = { quizMode = false })
        return
    }

    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text("English Alphabet", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold)
                Text(
                    "A to Z with sounds — tap a letter to hear it.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { quizMode = true }) {
                Icon(Icons.Filled.Quiz, contentDescription = "Alphabet quiz")
            }
        }
        Spacer(Modifier.height(12.dp))

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AlphabetData.alphabet.forEach { a ->
                val learned = a.letter in store.learnedKana
                var showDetail by remember { mutableStateOf(false) }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showDetail = true },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(a.letter, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.width(40.dp))
                        Text(a.emoji, fontSize = 22.sp)
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text(a.word, fontWeight = FontWeight.Bold)
                            Text(
                                a.ipa + " · " + a.glossFor(store.nativeLang),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        FilledIconButton(
                            onClick = { speak(store, speaker, a.letter + " for " + a.word, false) },
                            modifier = Modifier.size(38.dp)
                        ) {
                            Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(18.dp))
                        }
                        if (learned) {
                            Spacer(Modifier.width(6.dp))
                            Icon(
                                Icons.Filled.CheckCircle,
                                contentDescription = "Learned",
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
                if (showDetail) {
                    AlphabetDetailDialog(
                        a = a,
                        learned = learned,
                        store = store,
                        speaker = speaker,
                        onDismiss = { showDetail = false }
                    )
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun AlphabetDetailDialog(
    a: AlphabetChar,
    learned: Boolean,
    store: Store,
    speaker: Speaker,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(a.letter, fontSize = 72.sp, fontWeight = FontWeight.ExtraBold)
                Text("${a.emoji} ${a.word}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(a.ipa, style = MaterialTheme.typography.titleLarge)
                Text(
                    a.glossFor(store.nativeLang),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        },
        confirmButton = {
            Row {
                FilledIconButton(onClick = { speak(store, speaker, a.word, false) }) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    store.toggleKana(a.letter)
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
private fun AlphabetQuiz(store: Store, speaker: Speaker, modifier: Modifier = Modifier, onExit: () -> Unit) {
    val rnd = remember { java.util.Random() }
    val questions = remember {
        AlphabetData.alphabet.shuffled(rnd).take(10).map { a ->
            val distractors = AlphabetData.alphabet.filter { it.letter != a.letter }.shuffled(rnd).take(3)
            val options = (distractors + a).shuffled(rnd)
            options to options.indexOf(a)
        }
    }
    var index by remember { mutableStateOf(0) }
    var picked by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }
    var done by remember { mutableStateOf(false) }

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
                Text("Alphabet quiz finished!", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(6.dp))
                Text("Score: $score / 10", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(20.dp))
                Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Back to alphabet") }
            }
        } else {
            val (options, correct) = questions[index]
            val target = options[correct]
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    Modifier.fillMaxWidth().padding(vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🔊", fontSize = 30.sp)
                    Text(
                        "Listen — which letter?",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(Modifier.height(8.dp))
                    FilledIconButton(onClick = { speak(store, speaker, target.letter + " for " + target.word, false) }) {
                        Icon(Icons.Filled.VolumeUp, contentDescription = "Hear again")
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
                        Text(opt.letter, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.width(10.dp))
                        Text(opt.word, style = MaterialTheme.typography.bodyLarge)
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
