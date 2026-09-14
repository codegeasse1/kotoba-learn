package com.nexo.kotoba

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * "More examples" for a single word, in three layers:
 *
 *  1. the bundled offline corpus (thousands of real sentences per language — tap
 *     "Load 10 more" to page through them),
 *  2. an optional on-device model that invents extra sentences (Profile → Advanced).
 *
 * This is the single implementation used by every screen that shows a word's
 * examples: the word-detail sheet, the quiz, reviews, the dictionary, grammar
 * patterns and the phrase/sentence screens. The action buttons are deliberately
 * placed *after* the lines they add, so newly loaded examples appear just above
 * the button instead of shoving it off screen.
 */
@Composable
fun MoreExamplesSection(
    word: Word,
    store: Store,
    speaker: Speaker,
    lang: String,
    modifier: Modifier = Modifier,
    aiCount: Int = 5,
    onCountChange: ((Int) -> Unit)? = null
) {
    val native = store.nativeLang
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    val preview = LocalInspectionMode.current

    var extra by remember(word.id, lang, native) { mutableStateOf(listOf<Examples.ExLine>()) }
    var extraOffset by remember(word.id, lang, native) { mutableStateOf(0) }
    var extraDone by remember(word.id, lang, native) { mutableStateOf(false) }
    var extraBusy by remember { mutableStateOf(false) }
    var extraTouched by remember(word.id, lang, native) { mutableStateOf(false) }

    var aiLines by remember(word.id, lang, native) { mutableStateOf(listOf<Examples.ExLine>()) }
    var aiBusy by remember { mutableStateOf(false) }
    var aiError by remember { mutableStateOf<String?>(null) }
    val aiReady = remember(store.aiModelId) { !preview && OnDeviceAi.isReady(ctx, store.aiModelId) }

    Column(modifier.fillMaxWidth()) {
        if (store.extraExamples) {
            Spacer(Modifier.height(6.dp))
            extra.forEach { ex -> SheetLine(ex, store, speaker, lang) }

            if (!extraDone) {
                if (extra.isNotEmpty()) Spacer(Modifier.height(6.dp))
                OutlinedButton(
                    onClick = {
                        extraBusy = true
                        extraTouched = true
                        scope.launch {
                            val more = withContext(Dispatchers.IO) {
                                Corpus.extra(ctx, word, lang, native, extraOffset, 10)
                            }
                            extra = extra + more
                            extraOffset += more.size
                            if (more.isEmpty()) extraDone = true
                            onCountChange?.invoke(extra.size + aiLines.size)
                            extraBusy = false
                        }
                    },
                    enabled = !extraBusy,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        when {
                            extraBusy -> "Loading more…"
                            extra.isEmpty() -> "More examples (offline)"
                            else -> "Load 10 more"
                        }
                    )
                }
            }
            if (extraDone && extra.isEmpty()) {
                Text(
                    if (extraTouched) "No more bundled examples for this word."
                    else "No bundled examples for this word yet.",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (store.aiEnabled) {
            Spacer(Modifier.height(16.dp))
            Text(
                "On-device AI",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Experimental — these sentences are invented by a small model on your phone.",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))

            aiLines.forEach { ex -> SheetLine(ex, store, speaker, lang) }
            if (aiLines.isNotEmpty()) Spacer(Modifier.height(6.dp))

            if (!aiReady) {
                Text(
                    "No model downloaded yet. Open Profile → Advanced to download one.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                OutlinedButton(
                    onClick = {
                        aiBusy = true
                        aiError = null
                        scope.launch {
                            try {
                                val raw = OnDeviceAi.generate(
                                    ctx,
                                    store.aiModelId,
                                    buildAiPrompt(word, lang, native, aiCount)
                                )
                                val parsed = parseAiLines(raw, lang, native, aiCount)
                                if (parsed.isEmpty()) {
                                    aiError = "The model didn't return usable sentences. Try again."
                                } else {
                                    aiLines = aiLines + parsed
                                }
                                onCountChange?.invoke(extra.size + aiLines.size)
                            } catch (e: Exception) {
                                aiError = e.message ?: "AI generation failed."
                            }
                            aiBusy = false
                        }
                    },
                    enabled = !aiBusy,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        when {
                            aiBusy -> "Generating… (this can take a minute)"
                            aiLines.isEmpty() -> "✨ Generate AI examples"
                            else -> "✨ Generate $aiCount more"
                        }
                    )
                }
                aiError?.let {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

/** One example sentence card: target text, optional romanisation, native gloss, audio. */
@Composable
fun SheetLine(
    ex: Examples.ExLine,
    store: Store,
    speaker: Speaker,
    lang: String
) {
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
                Text("\uD83D\uDCAC", fontSize = 14.sp)
                Spacer(Modifier.width(10.dp))
                Text(
                    ex.text,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
                IconButton(onClick = { speak(store, speaker, ex.text, lang != "en") }) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear sentence")
                }
            }
            if (ex.sub.isNotBlank()) {
                Spacer(Modifier.height(2.dp))
                Text(
                    ex.sub,
                    modifier = Modifier.padding(start = 24.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (ex.gloss.isNotBlank()) {
                Spacer(Modifier.height(4.dp))
                Text(
                    ex.gloss,
                    modifier = Modifier.padding(start = 24.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * A tappable "💬 More examples" row that expands into the full
 * [MoreExamplesSection] in place. This is the drop-in used by screens that show a
 * word but have no room for the examples until the learner asks for them.
 */
@Composable
fun ExpandableMoreExamples(
    word: Word,
    store: Store,
    speaker: Speaker,
    lang: String,
    modifier: Modifier = Modifier,
    label: String = "💬 More examples",
    aiCount: Int = 3
) {
    var open by remember(word.id, lang) { mutableStateOf(false) }
    if (open) {
        MoreExamplesSection(
            word = word,
            store = store,
            speaker = speaker,
            lang = lang,
            modifier = modifier,
            aiCount = aiCount
        )
    } else {
        OutlinedButton(onClick = { open = true }, modifier = modifier.fillMaxWidth()) {
            Text(label)
        }
    }
}

/**
 * A [Word] for an arbitrary English headword that isn't part of the lesson data
 * (a verb from the verb table, a dictionary hit, …) so any screen can show the
 * "More examples" block for it.
 */
fun wordForHeadword(en: String, store: Store): Word {
    val target = store.target
    val head = en.trim()
    if (head.isBlank()) return Word("adhoc:blank", "🔤", "", "", "", head, "", "", target)
    if (target == "ja" || target == "en") {
        TargetContent.words(target).firstOrNull { it.en.equals(head, ignoreCase = true) }?.let { return it }
    }
    return Word(
        id = "adhoc:$target:${head.lowercase()}",
        emoji = "🔤",
        kana = if (target == "en") head else (Gloss.lookupTarget(head)?.let { cleanGloss(it) } ?: ""),
        romaji = "",
        en = head,
        ipa = "",
        lang = target
    )
}

internal fun buildAiPrompt(word: Word, lang: String, native: String, count: Int): String {
    val langName = languageLabel(lang)
    val w = when {
        lang != "en" && word.kana.isNotEmpty() -> word.kana
        else -> word.en
    }
    return buildString {
        append("You are an experienced $langName teacher preparing practice material for a complete beginner.\n")
        append("Write $count short, simple, natural $langName sentences that each use the word \"$w\".\n")
        if (lang != "en") append("Write only in $langName script. Never use Latin letters.\n")
        append("After each sentence write a pipe symbol \"|\" and then the English meaning of that sentence.\n")
        append("Output one line per sentence, in this format: <$langName sentence> | <English meaning>\n")
        append("Do not number the lines. Do not add any other text.\n")
        append("The word \"$w\" means \"${word.en}\" in English.")
    }
}

internal fun parseAiLines(
    raw: String,
    lang: String,
    native: String,
    count: Int
): List<Examples.ExLine> {
    val out = ArrayList<Examples.ExLine>(count)
    for (rawLine in raw.split('\n')) {
        var line = rawLine.trim()
        if (line.isEmpty()) continue
        line = line.replace(Regex("^\\s*(?:\\d+[.)]|[-*•])\\s*"), "").trim()
        var text = line
        var meaning = ""
        val bar = line.indexOf('|')
        if (bar > 0) {
            text = line.substring(0, bar)
            meaning = line.substring(bar + 1)
        }
        text = text.trim().trim('"', '\'', '“', '”', '「', '」', '《', '》').trim()
        meaning = meaning.trim().trim('"', '\'', '“', '”', '「', '」').trim()
        if (text.length < 3 || text.length > 200) continue
        if (!looksLikeTarget(text, lang)) continue
        if (out.any { it.text.equals(text, ignoreCase = true) }) continue
        val gloss = when {
            native.isBlank() || native == "en" || native == lang -> ""
            meaning.isNotEmpty() -> Examples.sentenceGloss(meaning, native).ifBlank { meaning }
            else -> ""
        }
        val sub = if (lang == "ja") DictionaryData.kanaToRomaji(text) else ""
        out.add(Examples.ExLine(text, sub, gloss))
        if (out.size >= count) break
    }
    return out
}

internal fun looksLikeTarget(text: String, lang: String): Boolean = when (lang) {
    "en" -> text.any { it.isLetter() } && text.count { it.code > 0x2000 } == 0
    "ja" -> text.count { it.code in 0x3040..0x30FF || it.code in 0x4E00..0x9FFF } >= 1
    else -> {
        val letters = text.count { it.isLetter() }
        val latin = text.count { it.code < 0x0250 && it.isLetter() }
        letters > 0 && latin * 2 < letters
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleSheet(
    word: Word,
    store: Store,
    speaker: Speaker,
    lang: String = "en",
    onDismiss: () -> Unit
) {
    val native = store.nativeLang
    val lines = remember(word.id, lang, native) { Examples.exLines(word, lang, native) }
    val heading = when {
        lang == "en" -> word.en
        word.kana.isNotEmpty() -> word.kana
        else -> word.en
    }
    val targetName = languageLabel(lang)
    var moreCount by remember(word.id, lang, native) { mutableStateOf(0) }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(bottom = 28.dp)
        ) {
            Text(
                heading,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                "${lines.size + moreCount} $targetName example sentences",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))

            lines.forEach { ex -> SheetLine(ex, store, speaker, lang) }

            MoreExamplesSection(
                word = word,
                store = store,
                speaker = speaker,
                lang = lang,
                onCountChange = { moreCount = it }
            )
        }
    }
}
