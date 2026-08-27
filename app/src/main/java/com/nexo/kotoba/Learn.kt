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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
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
import kotlin.math.min

data class QuizQuestion(
    val promptText: String?,
    val promptAudio: String,
    val promptIsJa: Boolean,
    val options: List<QuizOption>,
    val correct: Int
)

data class QuizOption(val emoji: String, val label: String)

@Composable
fun LearnScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var showKana by remember { mutableStateOf(false) }
    var showKanji by remember { mutableStateOf(false) }
    var showAlphabet by remember { mutableStateOf(false) }
    var openLesson by remember { mutableStateOf<Lesson?>(null) }
    var openCat by remember { mutableStateOf<SentenceCategory?>(null) }
    var openRoleplay by remember { mutableStateOf<Roleplay?>(null) }
    val scroll = rememberScrollState()

    val learningJa = store.direction != Direction.ENGLISH
    val learningEn = store.direction != Direction.JAPANESE

    when {
        showKana -> KanaScreen(store, speaker, modifier, onClose = { showKana = false })
        showKanji -> KanjiScreen(store, speaker, modifier, onClose = { showKanji = false })
        showAlphabet -> AlphabetScreen(store, speaker, modifier, onClose = { showAlphabet = false })
        openCat != null -> SentenceCategoryScreen(openCat!!, store, speaker, onClose = { openCat = null })
        openRoleplay != null -> RoleplayScreen(openRoleplay!!, store, speaker, onClose = { openRoleplay = null })
        openLesson != null -> LessonExplore(store, speaker, openLesson!!, modifier, onClose = { openLesson = null })
        else -> Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scroll)
                .padding(20.dp)
        ) {
        Text("Learn", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        Text(
            "Master the writing system, then build vocabulary by topic.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(20.dp))

        if (learningJa) {
            KanaModuleCard(store, onClick = { showKana = true })
            Spacer(Modifier.height(12.dp))
            KanjiModuleCard(store, onClick = { showKanji = true })
        }
        if (learningEn) {
            Spacer(Modifier.height(12.dp))
            AlphabetModuleCard(store, onClick = { showAlphabet = true })
        }
        Spacer(Modifier.height(24.dp))

        val jaLessons = Data.allLessons.filter { it.lang == "ja" && it.source.isEmpty() }
        val enLessons = Data.allLessons.filter { it.lang == "en" && it.source.isEmpty() }
        val jaExtra = if (learningJa) Genki.lessons + Jfz.lessons + KanjiWords.categories else emptyList()
        val enExtra = if (learningEn) Oxford.lessons else emptyList()
        val visible = (if (learningJa) jaLessons else emptyList()) + (if (learningEn) enLessons else emptyList()) + jaExtra + enExtra

        fun levelGroups(lang: String): List<Pair<String, List<Lesson>>> {
            val byLevel = (if (lang == "ja") jaLessons else enLessons).groupBy { Levels.ofLesson(it) }
            return Levels.ORDER.mapNotNull { lv -> byLevel[lv]?.let { lv to it } }
        }

        Text("Lessons", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(
            "${store.completedLessons.size}/${visible.size} completed",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(10.dp))
        if (learningJa) {
            levelGroups("ja").forEach { (lv, lessons) ->
                LevelHeader(lv, "${lessons.size} lessons")
                lessons.forEach { lesson ->
                    LessonRow(
                        lesson = lesson,
                        done = lesson.id in store.completedLessons,
                        onClick = { openLesson = lesson }
                    )
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(8.dp))
            }
        }
        if (learningEn && enLessons.isNotEmpty()) {
            Spacer(Modifier.height(10.dp))
            levelGroups("en").forEach { (lv, lessons) ->
                LevelHeader(lv, "${lessons.size} lessons")
                lessons.forEach { lesson ->
                    LessonRow(
                        lesson = lesson,
                        done = lesson.id in store.completedLessons,
                        onClick = { openLesson = lesson }
                    )
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(8.dp))
            }
        }

        if (learningJa) {
            Spacer(Modifier.height(12.dp))
            SectionHeader("📗 Genki Textbook 1", "Official Genki 1 vocabulary — 12 lessons with grammar notes")
            Genki.lessons.forEach { lesson ->
                LessonRow(lesson = lesson, done = lesson.id in store.completedLessons, onClick = { openLesson = lesson })
                Spacer(Modifier.height(8.dp))
            }
            Spacer(Modifier.height(12.dp))
            SectionHeader("📖 Japanese From Zero", "Book 1 vocabulary — pre-lessons plus 13 lessons")
            Jfz.lessons.forEach { lesson ->
                LessonRow(lesson = lesson, done = lesson.id in store.completedLessons, onClick = { openLesson = lesson })
                Spacer(Modifier.height(8.dp))
            }
            Spacer(Modifier.height(12.dp))
            SectionHeader("🗾 5000 Kanji Words", "Kanji vocabulary by theme — 20 categories, daily life to advanced")
            KanjiWords.categories.forEach { lesson ->
                LessonRow(lesson = lesson, done = lesson.id in store.completedLessons, onClick = { openLesson = lesson })
                Spacer(Modifier.height(8.dp))
            }
        }
        if (learningEn && enExtra.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            SectionHeader("🇬🇧 Oxford 5000", "The official Oxford 5000 word list — A1 to C1, with Hindi meanings")
            Oxford.lessons.forEach { lesson ->
                LessonRow(lesson = lesson, done = lesson.id in store.completedLessons, onClick = { openLesson = lesson })
                Spacer(Modifier.height(8.dp))
            }
        }

        val wbLessons = WordBank.lessons.filter { (it.lang == "ja" && learningJa) || (it.lang == "en" && learningEn) }
        if (wbLessons.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            SectionHeader("🔥 Vocabulary Bank", "1,100+ everyday words in 14 topics plus numbers 1-100 — most frequent words first")
            wbLessons.forEach { lesson ->
                LessonRow(lesson = lesson, done = lesson.id in store.completedLessons, onClick = { openLesson = lesson })
                Spacer(Modifier.height(8.dp))
            }
        }
        Spacer(Modifier.height(12.dp))
        SectionHeader("🎭 Roleplay Conversations", "Practice real two-person dialogues with translations and native audio")
        Roleplay.all.filter { (it.lang == "ja" && learningJa) || (it.lang == "en" && learningEn) }.forEach { rp ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { openRoleplay = rp },
                shape = RoundedCornerShape(18.dp)
            ) {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(rp.emoji, fontSize = 30.sp)
                    Spacer(Modifier.width(14.dp))
                    Column(Modifier.weight(1f)) {
                        Text(rp.title, fontWeight = FontWeight.Bold)
                        Text(
                            rp.desc,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
                        )
                        Text(
                            "${rp.turns.size} stages · ${rp.lang.uppercase()}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text("▶", fontSize = 18.sp)
                }
            }
            Spacer(Modifier.height(8.dp))
        }
        Spacer(Modifier.height(24.dp))

        Text("Chunks — say whole sentences", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(
            "Learn in phrases, not single words — that's how fluent speakers actually talk.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(10.dp))
        PhraseList(store, speaker)
        Spacer(Modifier.height(24.dp))

        Text("💬 Conversations & Sentences", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(
            "Thousands of real sentences by category, with native audio and translations.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(10.dp))
        Sentences.categories
            .filter { (it.lang == "ja" && learningJa) || (it.lang == "en" && learningEn) }
            .forEach { cat ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { openCat = cat },
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(cat.emoji, fontSize = 30.sp)
                        Spacer(Modifier.width(14.dp))
                        Column(Modifier.weight(1f)) {
                            Text(cat.title, fontWeight = FontWeight.Bold)
                            Text(
                                cat.desc,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1
                            )
                            Text(
                                "${cat.sentences.size} sentences · ${if (cat.lang == "ja") "Japanese" else "English"}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(cat.sentences.size.toString(), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun KanaModuleCard(store: Store, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(72.dp)) {
                androidx.compose.material3.CircularProgressIndicator(
                    progress = { store.kanaProgress() / 100f },
                    modifier = Modifier.size(72.dp),
                    strokeWidth = 8.dp,
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surface
                )
                Text("${store.kanaProgress()}%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text("Hiragana & Katakana", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "46 characters each, with picture mnemonics and sound practice.",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "Start kana →",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun KanjiModuleCard(store: Store, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Row(
            Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(72.dp)) {
                androidx.compose.material3.CircularProgressIndicator(
                    progress = { store.kanjiProgress() / 100f },
                    modifier = Modifier.size(72.dp),
                    strokeWidth = 8.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surface
                )
                Text("${store.kanjiProgress()}%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text("Kanji (N5)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "47 essential kanji with readings and picture stories.",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "Start kanji →",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
private fun AlphabetModuleCard(store: Store, onClick: () -> Unit) {
    val learned = AlphabetData.alphabet.count { it.letter in store.learnedKana }
    val pct = if (AlphabetData.alphabet.isEmpty()) 0 else learned * 100 / AlphabetData.alphabet.size
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Row(
            Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(72.dp)) {
                androidx.compose.material3.CircularProgressIndicator(
                    progress = { pct / 100f },
                    modifier = Modifier.size(72.dp),
                    strokeWidth = 8.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    trackColor = MaterialTheme.colorScheme.surface
                )
                Text("$pct%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text("English Alphabet", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "A to Z with sounds and example words — perfect for beginners.",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "Start ABC →",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
private fun LevelHeader(level: String, subtitle: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(Levels.EMOJI[level] ?: "📘", fontSize = 20.sp)
        Spacer(Modifier.width(8.dp))
        Column {
            Text(Levels.label(level), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(
                subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
    Spacer(Modifier.height(6.dp))
}

@Composable
private fun SectionHeader(title: String, subtitle: String) {
    Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
    Text(
        subtitle,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(6.dp))
}

@Composable
private fun LessonRow(lesson: Lesson, done: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(lesson.emoji, fontSize = 30.sp)
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(lesson.title, fontWeight = FontWeight.Bold)
                Text(
                    lesson.desc,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
                Text(
                    "${lesson.words.size} words",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            if (done) {
                Icon(Icons.Filled.CheckCircle, contentDescription = "Done", tint = MaterialTheme.colorScheme.tertiary)
            } else {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Start")
            }
        }
    }
}

@Composable
private fun PhraseList(store: Store, speaker: Speaker) {
    var expanded by remember { mutableStateOf<String?>(null) }
    Data.allPhrases.forEach { p ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = if (expanded == p.id) null else p.id },
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(p.emoji, fontSize = 22.sp)
                    Spacer(Modifier.width(10.dp))
                    Column(Modifier.weight(1f)) {
                        Text(p.ja, fontWeight = FontWeight.Bold)
                        if (store.showRomaji) {
                            Text(p.romaji, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    FilledIconButton(
                        onClick = { speak(store, speaker, p.ja, true) },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(Icons.Filled.VolumeUp, contentDescription = "Play", modifier = Modifier.size(18.dp))
                    }
                }
                if (expanded == p.id) {
                    Spacer(Modifier.height(10.dp))
                    Text(p.glossFor(store.nativeLang), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.height(6.dp))
                    Text(
                        p.chunks,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun LessonFlow(store: Store, speaker: Speaker, lesson: Lesson, modifier: Modifier = Modifier, onClose: () -> Unit) {
    val words = lesson.words
    var introIndex by remember { mutableStateOf(0) }
    var quiz by remember { mutableStateOf<List<QuizQuestion>?>(null) }
    var qIndex by remember { mutableStateOf(0) }
    var picked by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }
    var finished by remember { mutableStateOf(false) }

    val targetJa = lesson.lang != "en"

    fun buildQuiz(): List<QuizQuestion> {
        val rnd = java.util.Random()
        val pool = if (words.size >= 4) words else Data.allWords
        val count = min(10, words.size)
        val targets = words.shuffled(rnd).take(count)
        return targets.map { w ->
            val audioOnly = rnd.nextBoolean()
            val distractors = pool.filter { it.id != w.id }.shuffled(rnd).take(3)
            val options = (distractors + w).shuffled(rnd)
            val correct = options.indexOf(w)
            QuizQuestion(
                promptText = if (audioOnly) null else {
                    if (targetJa) w.kana + (if (store.showRomaji) "\n" + w.romaji else "")
                    else w.en + "\n" + w.ipa
                },
                promptAudio = if (targetJa) w.kana else w.en,
                promptIsJa = targetJa,
                options = options.map { o ->
                    QuizOption(
                        emoji = o.emoji,
                        label = when {
                            store.showTranslations -> o.glossFor(store.nativeLang)
                            targetJa -> o.romaji
                            else -> ""
                        }
                    )
                },
                correct = correct
            )
        }
    }

    Box(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
    when {
        finished -> {
            ResultStage(
                score = score,
                total = quiz?.size ?: 0,
                lesson = lesson,
                store = store,
                onClose = onClose,
                onAgain = {
                    quiz = buildQuiz()
                    qIndex = 0
                    picked = null
                    score = 0
                    finished = false
                }
            )
        }

        quiz == null -> {
            val w = words[introIndex]
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(onClick = onClose) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                    Text("${introIndex + 1}/${words.size}", style = MaterialTheme.typography.labelLarge)
                    Spacer(Modifier.weight(1f))
                    TextButton(onClick = { quiz = buildQuiz() }) { Text("Skip intro") }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp, horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(w.emoji, fontSize = 88.sp)
                        Spacer(Modifier.height(16.dp))
                        if (targetJa) {
                            Text(w.kana, fontSize = 42.sp, fontWeight = FontWeight.ExtraBold)
                            if (store.showRomaji) {
                                Spacer(Modifier.height(4.dp))
                                Text(w.romaji, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        } else {
                            Text(w.en, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                            Spacer(Modifier.height(4.dp))
                            Text(w.ipa, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        if (store.showTranslations) {
                            Spacer(Modifier.height(14.dp))
                            Text(
                                "= ${w.glossFor(store.nativeLang)}",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
                Spacer(Modifier.height(14.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledIconButton(onClick = { speak(store, speaker, if (targetJa) w.kana else w.en, targetJa) }) {
                        Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
                    }
                    Spacer(Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (introIndex == words.lastIndex) quiz = buildQuiz() else introIndex++
                        }
                    ) {
                        Text(if (introIndex == words.lastIndex) "Start quiz" else "Next")
                    }
                }
                Spacer(Modifier.height(16.dp))
            }
        }

        else -> {
            val q = quiz!![qIndex]
            LaunchedEffect(quiz, qIndex) {
                speak(store, speaker, q.promptAudio, q.promptIsJa)
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(onClick = onClose) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                    Text("Quiz ${qIndex + 1}/${quiz!!.size}", style = MaterialTheme.typography.labelLarge)
                    Spacer(Modifier.weight(1f))
                    Text("⭐ $score", style = MaterialTheme.typography.labelLarge)
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 28.dp, horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (q.promptText == null) {
                            Text("🔊 Listen", fontSize = 26.sp)
                            Spacer(Modifier.height(8.dp))
                            FilledIconButton(onClick = { speak(store, speaker, q.promptAudio, q.promptIsJa) }) {
                                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear again")
                            }
                        } else {
                            Text(q.promptText, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))

                q.options.forEachIndexed { i, opt ->
                    val isCorrect = i == q.correct
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
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (picked != null && isCorrect) Color(0xFFE4F6EA)
                            else if (picked != null && isPicked) Color(0xFFFBE5E5)
                            else MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(opt.emoji, fontSize = 26.sp)
                            Spacer(Modifier.width(12.dp))
                            Text(
                                opt.label,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = if (opt.label.isNotEmpty()) FontWeight.Medium else FontWeight.Normal
                            )
                        }
                    }
                }

                if (picked != null) {
                    Spacer(Modifier.height(10.dp))
                    val correctOpt = q.options[q.correct]
                    Text(
                        if (picked == q.correct) "✅ Correct!" else "→ ${correctOpt.emoji} ${correctOpt.label}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = {
                            if (qIndex == quiz!!.lastIndex) {
                                store.completeLesson(lesson.id, words.map { it.id })
                                finished = true
                            } else {
                                qIndex++
                                picked = null
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (qIndex == quiz!!.lastIndex) "Finish" else "Next question")
                    }
                }
            }
        }
    }
    }
}

@Composable
private fun ResultStage(
    score: Int,
    total: Int,
    lesson: Lesson,
    store: Store,
    onClose: () -> Unit,
    onAgain: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🎉", fontSize = 72.sp)
        Spacer(Modifier.height(16.dp))
        Text("Lesson complete!", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(8.dp))
        Text(
            "Score: $score / $total",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "+${lesson.words.size * 5} XP · ${lesson.words.size} new words added to your reviews",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = onClose, modifier = Modifier.fillMaxWidth()) { Text("Done") }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onAgain, modifier = Modifier.fillMaxWidth()) { Text("Practice again") }
    }
}

@Composable
fun SentenceCategoryScreen(cat: SentenceCategory, store: Store, speaker: Speaker, onClose: () -> Unit) {
    val isJa = cat.lang != "en"
    BackHandler(onBack = onClose)
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column(Modifier.weight(1f)) {
                Text(cat.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.ExtraBold)
                Text(
                    "${cat.sentences.size} sentences · ${cat.desc}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }
            Text(cat.emoji, fontSize = 26.sp)
        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp)
        ) {
            items(cat.sentences, key = { it.id }) { s ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(s.emoji, fontSize = 24.sp)
                        Spacer(Modifier.width(10.dp))
                        Column(Modifier.weight(1f)) {
                            Text(
                                if (isJa) s.ja else s.en,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            if (isJa && store.showRomaji) {
                                Text(
                                    s.romaji,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(Modifier.height(2.dp))
                            Text(s.glossFor(store.nativeLang), style = MaterialTheme.typography.bodyMedium)
                        }
                        FilledIconButton(
                            onClick = { speak(store, speaker, if (isJa) s.ja else s.en, isJa) },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }
        }
    }
}
