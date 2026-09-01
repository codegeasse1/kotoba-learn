package com.nexo.kotoba

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import kotlin.math.min

@Composable
fun LessonExplore(
    store: Store,
    speaker: Speaker,
    lesson: Lesson,
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    var mode by remember { mutableStateOf(0) }
    var openIndex by remember { mutableStateOf<Int?>(null) }
    var openQuiz by remember { mutableStateOf(false) }

    BackHandler {
        when {
            openIndex != null -> openIndex = null
            openQuiz -> openQuiz = false
            else -> onClose()
        }
    }

    when {
        openIndex != null -> WordDetail(
            store, speaker, lesson.words, lesson.lang, openIndex!!,
            onNavigate = { openIndex = it },
            onClose = { openIndex = null }
        )
        openQuiz -> LessonFlow(store, speaker, lesson, modifier, onClose = { openQuiz = false })
        else -> Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onClose) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
                Column(Modifier.weight(1f)) {
                    Text(lesson.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.ExtraBold)
                    Text(
                        "${lesson.words.size} words",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(Modifier.height(6.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ModeChip("🃏", "Flashcards", mode == 0, Modifier.weight(1f)) { mode = 0 }
                ModeChip("📋", "List", mode == 1, Modifier.weight(1f)) { mode = 1 }
                ModeChip("🧩", "Tiles", mode == 2, Modifier.weight(1f)) { mode = 2 }
            }
            Spacer(Modifier.height(12.dp))

            when (mode) {
                0 -> FlashcardBrowse(store, speaker, lesson, onStartQuiz = { openQuiz = true })
                1 -> WordListBrowser(store, speaker, lesson, onOpen = { openIndex = it })
                else -> WordGridBrowser(store, speaker, lesson, onOpen = { openIndex = it })
            }

            Spacer(Modifier.height(10.dp))
            Button(
                onClick = { openQuiz = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.PlayArrow, contentDescription = null)
                Spacer(Modifier.width(6.dp))
                Text("Start quiz")
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ModeChip(emoji: String, label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(emoji, fontSize = 20.sp)
            Text(
                label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

@Composable
private fun FlashcardBrowse(store: Store, speaker: Speaker, lesson: Lesson, onStartQuiz: () -> Unit) {
    val words = lesson.words
    var i by remember { mutableStateOf(0) }
    var flipped by remember { mutableStateOf(false) }
    var exampleWord by remember { mutableStateOf<Word?>(null) }
    val w = words[min(i, words.lastIndex)]
    val targetJa = lesson.lang != "en"

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = { if (i > 0) { i--; flipped = false } }, enabled = i > 0) {
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Previous")
                Text("Prev")
            }
            Spacer(Modifier.weight(1f))
            Text(
                "${i + 1}/${words.size}",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
            TextButton(onClick = { if (i < words.lastIndex) { i++; flipped = false } }, enabled = i < words.lastIndex) {
                Text("Next")
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Next")
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .clickable { flipped = !flipped },
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (flipped) MaterialTheme.colorScheme.secondaryContainer
                else MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(w.emoji, fontSize = 84.sp)
                Spacer(Modifier.height(14.dp))
                if (!flipped) {
                    if (targetJa) {
                        Text(w.kana, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                        if (store.showRomaji) {
                            Spacer(Modifier.height(4.dp))
                            Text(w.romaji, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    } else {
                        Text(w.en, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                        Spacer(Modifier.height(4.dp))
                        Text(w.ipa, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                } else {
                    Text(
                        w.glossFor(store.nativeLang),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    if (targetJa && w.kanji.isNotEmpty()) {
                        Spacer(Modifier.height(8.dp))
                        Text(w.kanji, fontSize = 20.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
                    }
                    if (!targetJa && w.hi.isNotEmpty()) {
                        Spacer(Modifier.height(8.dp))
                        Text(w.hi, fontSize = 20.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
                    }
                }
                Spacer(Modifier.height(10.dp))
                Text(
                    if (flipped) "Tap to flip back" else "Tap to reveal translation",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            FilledIconButton(onClick = { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) }) {
                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
            }
            TextButton(
                onClick = { exampleWord = w },
                modifier = Modifier.size(width = 52.dp, height = 44.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("💬", fontSize = 18.sp)
            }
        }

        if (exampleWord != null) {
            ExampleSheet(
                word = exampleWord!!,
                store = store,
                speaker = speaker,
                lang = lesson.lang,
                onDismiss = { exampleWord = null }
            )
        }
    }
}

@Composable
private fun WordListBrowser(
    store: Store,
    speaker: Speaker,
    lesson: Lesson,
    onOpen: (Int) -> Unit
) {
    val words = lesson.words
    var q by remember { mutableStateOf("") }
    var exampleWord by remember { mutableStateOf<Word?>(null) }
    val listState = rememberLazyListState()
    val query = q.trim().lowercase()
    val filtered = remember(query, words) {
        if (query.isEmpty()) words else words.filter { w ->
            w.kana.lowercase().contains(query) || w.romaji.lowercase().contains(query) ||
                w.kanji.lowercase().contains(query) || w.en.lowercase().contains(query) ||
                w.hi.lowercase().contains(query) || w.ipa.lowercase().contains(query)
        }
    }
    val targetJa = lesson.lang != "en"

    Column(Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = q,
            onValueChange = { q = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("Search ${words.size} words…") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            if (query.isEmpty()) "Showing all ${words.size} words — tap one to jump to it"
            else "${filtered.size} results",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(6.dp))

        LazyColumn(state = listState, modifier = Modifier.fillMaxWidth()) {
            items(filtered, key = { it.id }) { w ->
                val idx = words.indexOf(w)
                val isLearned = w.id in store.srs
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .clickable { onOpen(idx) },
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
                                    if (store.showRomaji) w.romaji + (if (w.kanji.isNotEmpty()) " · " + w.kanji else "") else w.kanji
                                } else {
                                    w.ipa
                                },
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        if (isLearned) {
                            Icon(
                                Icons.Filled.CheckCircle,
                                contentDescription = "Learned",
                                tint = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                        }
                        FilledIconButton(
                            onClick = { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) },
                            modifier = Modifier.size(34.dp)
                        ) {
                            Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
                        }
                        TextButton(
                            onClick = { exampleWord = w },
                            modifier = Modifier.size(width = 40.dp, height = 34.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("💬", fontSize = 15.sp)
                        }
                    }
                }
            }
        }

        if (exampleWord != null) {
            ExampleSheet(
                word = exampleWord!!,
                store = store,
                speaker = speaker,
                lang = lesson.lang,
                onDismiss = { exampleWord = null }
            )
        }
    }
}

@Composable
private fun WordGridBrowser(
    store: Store,
    speaker: Speaker,
    lesson: Lesson,
    onOpen: (Int) -> Unit
) {
    val words = lesson.words
    val targetJa = lesson.lang != "en"
    var exampleWord by remember { mutableStateOf<Word?>(null) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(words, key = { it.id }) { w ->
            val idx = words.indexOf(w)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpen(idx) },
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                        .clickable { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(w.emoji, fontSize = 34.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        if (targetJa) w.kana else w.en,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        if (targetJa) {
                            if (store.showRomaji) w.romaji else w.kanji
                        } else w.ipa,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(2.dp))
                    TextButton(
                        onClick = { exampleWord = w },
                        modifier = Modifier.size(width = 40.dp, height = 30.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("💬", fontSize = 14.sp)
                    }
                }
            }
        }
    }

    if (exampleWord != null) {
        ExampleSheet(
            word = exampleWord!!,
            store = store,
            speaker = speaker,
            lang = lesson.lang,
            onDismiss = { exampleWord = null }
        )
    }
}

@Composable
private fun WordDetail(
    store: Store,
    speaker: Speaker,
    words: List<Word>,
    lang: String,
    index: Int,
    onNavigate: (Int) -> Unit,
    onClose: () -> Unit
) {
    val w = words[index]
    val targetJa = w.kana.isNotEmpty()
    val isLearned = w.id in store.srs
    var showExamples by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(
                "${index + 1}/${words.size}",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(6.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 36.dp, horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(w.emoji, fontSize = 76.sp)
                Spacer(Modifier.height(12.dp))
                if (targetJa) {
                    if (w.kanji.isNotEmpty()) {
                        Text(w.kanji, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(2.dp))
                    }
                    Text(w.kana, fontSize = 38.sp, fontWeight = FontWeight.ExtraBold)
                    if (store.showRomaji) {
                        Spacer(Modifier.height(4.dp))
                        Text(w.romaji, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                } else {
                    Text(w.en, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(4.dp))
                    Text(w.ipa, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Spacer(Modifier.height(18.dp))
                Text(
                    w.glossFor(store.nativeLang),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(16.dp))
                FilledIconButton(onClick = { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) }) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
                }
            }
        }
        Spacer(Modifier.height(14.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .clickable { if (index > 0) onNavigate(index - 1) },
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(Modifier.padding(vertical = 14.dp), horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Previous")
                    Text("Previous", fontWeight = FontWeight.Bold)
                }
            }
            Card(
                modifier = Modifier
                    .weight(1f)
                    .clickable { if (index < words.lastIndex) onNavigate(index + 1) },
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(Modifier.padding(vertical = 14.dp), horizontalArrangement = Arrangement.Center) {
                    Text("Next", fontWeight = FontWeight.Bold)
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Next")
                }
            }
        }
        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = { showExamples = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("💬 See example sentences")
        }
        Spacer(Modifier.height(8.dp))

        Button(
            onClick = { store.toggleCard(w.id) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(if (isLearned) "Learned — remove from reviews" else "Learn this word")
        }
        Spacer(Modifier.height(8.dp))
        Text(
            if (isLearned) "In your review queue ✓" else "Adds it to your spaced-repetition reviews.",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        if (showExamples) {
            ExampleSheet(
                word = w,
                store = store,
                speaker = speaker,
                lang = lang,
                onDismiss = { showExamples = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExampleSheet(
    word: Word,
    store: Store,
    speaker: Speaker,
    lang: String = "en",
    onDismiss: () -> Unit
) {
    val isJa = lang == "ja"
    val jaEx = if (isJa) remember(word.kana) { Examples.jaForWord(word) } else emptyList()
    val examples = if (isJa) emptyList() else remember(word.en) { Examples.forWord(word) }
    val hindi = if (isJa) emptyList() else remember(word.en) { Examples.hindiFor(word) }
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 28.dp)
        ) {
            Text(
                if (isJa) word.kana.ifEmpty { word.en } else word.en,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                if (isJa) "日本語の例文 + हिंदी अर्थ" else "Example sentences with translations",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            if (isJa) {
                jaEx.forEach { ex ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("💬", fontSize = 14.sp)
                                Spacer(Modifier.width(10.dp))
                                Text(
                                    ex.ja,
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                IconButton(onClick = { speak(store, speaker, ex.ja, true) }) {
                                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear sentence")
                                }
                            }
                            if (ex.romaji.isNotBlank()) {
                                Spacer(Modifier.height(2.dp))
                                Text(
                                    ex.romaji,
                                    modifier = Modifier.padding(start = 24.dp),
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            if (ex.hi.isNotBlank()) {
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    ex.hi,
                                    modifier = Modifier.padding(start = 24.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            } else {
                examples.forEachIndexed { i, ex ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("💬", fontSize = 14.sp)
                                Spacer(Modifier.width(10.dp))
                                Text(
                                    ex,
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                IconButton(onClick = { speak(store, speaker, ex, false) }) {
                                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear sentence")
                                }
                            }
                            if (i < hindi.size && hindi[i].isNotBlank()) {
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    hindi[i],
                                    modifier = Modifier.padding(start = 24.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
