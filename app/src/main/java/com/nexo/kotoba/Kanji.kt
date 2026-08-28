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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val PAGE_SIZE = 50

@Composable
fun KanjiScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier, onClose: () -> Unit) {
    BackHandler(onBack = onClose)
    val context = LocalContext.current
    KanjiData.init(context)
    var quizMode by remember { mutableStateOf(false) }

    if (quizMode) {
        KanjiQuiz(store, modifier, onExit = { quizMode = false })
        return
    }

    val all = KanjiData.all
    var query by remember { mutableStateOf("") }
    var page by remember { mutableIntStateOf(0) }
    LaunchedEffect(query) { page = 0 }

    val filtered = remember(all, query) {
        val q = query.trim().lowercase()
        if (q.isEmpty()) all
        else all.filter { k ->
            k.kanji.contains(q) || k.meaning.lowercase().contains(q) ||
                k.onyomi.lowercase().contains(q) || k.kunyomi.lowercase().contains(q)
        }
    }
    val pages = maxOf(1, (filtered.size + PAGE_SIZE - 1) / PAGE_SIZE)
    val effPage = minOf(page, pages - 1)
    val pageItems = if (filtered.isEmpty()) emptyList()
    else filtered.subList(effPage * PAGE_SIZE, minOf((effPage + 1) * PAGE_SIZE, filtered.size))

    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text("Kanji", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold)
                Text(
                    "All ${all.size} Jōyō kanji — 50 per page, search any word or reading.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { quizMode = true }) {
                Icon(Icons.Filled.Quiz, contentDescription = "Kanji quiz")
            }
        }
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("Search: water, 水, すい, みず…") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { query = "" }) {
                        Icon(Icons.Filled.Close, contentDescription = "Clear")
                    }
                }
            }
        )
        Spacer(Modifier.height(12.dp))

        if (pageItems.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🔍", fontSize = 48.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("No kanji found", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Try another word or reading.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(pageItems) { k ->
                    val learned = k.id in store.learnedKana
                    var showDetail by remember { mutableStateOf(false) }
                    Card(
                        modifier = Modifier
                            .aspectRatio(1f)
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
                                Text(k.kanji, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                                Text(
                                    k.meaning.substringBefore(';'),
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1
                                )
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
                        KanjiDetailDialog(
                            k = k,
                            learned = learned,
                            store = store,
                            onDismiss = { showDetail = false }
                        )
                    }
                }
            }
            Row(
                Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { page = (effPage - 1).coerceAtLeast(0) },
                    enabled = effPage > 0
                ) { Text("‹ Prev") }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Page ${effPage + 1} of $pages",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "${filtered.size} kanji",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                OutlinedButton(
                    onClick = { page = (effPage + 1).coerceAtMost(pages - 1) },
                    enabled = effPage < pages - 1
                ) { Text("Next ›") }
            }
        }
    }
}

@Composable
private fun KanjiDetailDialog(
    k: KanjiChar,
    learned: Boolean,
    store: Store,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(k.kanji, fontSize = 72.sp, fontWeight = FontWeight.ExtraBold)
                Text(k.meaning, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Text(
                    "ON: ${k.onyomi.ifEmpty { "—" }}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Text(
                    "KUN: ${k.kunyomi.ifEmpty { "—" }}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(10.dp))
                val gradeLabel = if (k.grade in 1..6) "Grade $k.grade" else "Jōyō (secondary)"
                Text(
                    "${k.jlpt.ifEmpty { "JLPT —" }} · $gradeLabel · ${k.strokes} strokes",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        confirmButton = {
            Row {
                Button(onClick = {
                    store.toggleKana(k.id)
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
private fun KanjiQuiz(store: Store, modifier: Modifier = Modifier, onExit: () -> Unit) {
    BackHandler(onBack = onExit)
    val rnd = remember { java.util.Random() }
    val questions = remember {
        KanjiData.all.shuffled(rnd).take(10).map { w ->
            val showMeaning = rnd.nextBoolean()
            val distractors = KanjiData.all.filter { it.id != w.id }.shuffled(rnd).take(3)
            val options = (distractors + w).shuffled(rnd)
            Triple(showMeaning, options, options.indexOf(w))
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
                Text("Kanji quiz finished!", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(6.dp))
                Text("Score: $score / 10", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(20.dp))
                Button(onClick = onExit, modifier = Modifier.fillMaxWidth()) { Text("Back to kanji") }
            }
        } else {
            val (showMeaning, options, correct) = questions[index]
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    Modifier.fillMaxWidth().padding(vertical = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (showMeaning) {
                        Text(
                            options[correct].meaning,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                        Text("which kanji? (ON: ${options[correct].onyomi})", style = MaterialTheme.typography.bodyMedium)
                    } else {
                        Text(options[correct].kanji, fontSize = 56.sp, fontWeight = FontWeight.ExtraBold)
                        Text("what does it mean?", style = MaterialTheme.typography.bodyMedium)
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
                        if (showMeaning) {
                            Text(opt.kanji, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        } else {
                            Text(opt.meaning, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                        }
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
