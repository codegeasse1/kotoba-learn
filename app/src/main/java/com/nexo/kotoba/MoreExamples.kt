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
import kotlinx.coroutines.CancellationException
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
                                val already = aiLines.map { it.text }
                                val samples = withContext(Dispatchers.Default) {
                                    Examples.exLines(word, lang, native)
                                        .filter { it.gloss.isNotBlank() }
                                        .take(2)
                                }
                                var parsed = emptyList<Examples.ExLine>()
                                // Small models sometimes answer with one long rambling line,
                                // or simply echo the headword. A second attempt asks about a
                                // different situation with a fresh seed, which is usually
                                // enough to get something usable.
                                for (attempt in 0 until 2) {
                                    val prompt = buildAiPrompt(
                                        word = word,
                                        lang = lang,
                                        native = native,
                                        count = aiCount,
                                        samples = samples,
                                        avoid = already
                                    )
                                    val raw = OnDeviceAi.generate(ctx, store.aiModelId, prompt)
                                    parsed = parseAiLines(
                                        raw = raw,
                                        lang = lang,
                                        native = native,
                                        count = aiCount,
                                        headword = aiHeadword(word, lang),
                                        avoid = already
                                    )
                                    if (parsed.isNotEmpty()) break
                                }
                                if (parsed.isEmpty()) {
                                    aiError = "The model didn't return usable sentences this time. Tap again to retry."
                                } else {
                                    aiLines = aiLines + parsed
                                }
                                onCountChange?.invoke(extra.size + aiLines.size)
                            } catch (e: CancellationException) {
                                throw e
                            } catch (e: Throwable) {
                                aiError = e.message ?: e.toString()
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

/** The string the model is asked to build sentences around. */
internal fun aiHeadword(word: Word, lang: String): String =
    if (lang != "en" && word.kana.isNotEmpty()) word.kana else word.en

/**
 * Prompt for the on-device model.
 *
 * It is wrapped in Qwen's ChatML template (`<|im_start|>` / `<|im_end|>`): both
 * bundled models are instruction-tuned, and handing one a bare paragraph makes it
 * continue the text instead of answering it — which is where the old word-salad
 * came from. The reply is primed by ending on the assistant turn header, and any
 * example sentences the app already has are quoted so the model has the format and
 * the level to imitate.
 *
 * The prompt is also held inside a strict character budget. The engine is created with a
 * 1024-token context and the native library rejects a query that does not fit — the old
 * 256-token context was small enough that this prompt could break it outright. Material is
 * dropped when the budget is tight: the worked examples first, then the "do not repeat" list.
 *
 * A random situation is woven in so two taps never ask for exactly the same thing, which
 * keeps the sentences varied even if a model ignores the sampling seed.
 */
internal fun buildAiPrompt(
    word: Word,
    lang: String,
    native: String,
    count: Int,
    samples: List<Examples.ExLine> = emptyList(),
    avoid: List<String> = emptyList(),
    scenario: String = aiScenario()
): String {
    val langName = languageLabel(lang)
    val w = aiHeadword(word, lang)
    val demos = samples.filter { it.text.isNotBlank() && it.gloss.isNotBlank() }.take(2)
    val repeats = avoid.filter { it.isNotBlank() }.take(2)
    val shaped = listOf(
        demos to repeats,
        emptyList<Examples.ExLine>() to repeats,
        emptyList<Examples.ExLine>() to emptyList<String>()
    )
    for ((d, a) in shaped) {
        val prompt = aiPromptText(langName, lang, w, count, d, a, scenario)
        if (prompt.length <= AI_MAX_PROMPT_CHARS) return prompt
    }
    return aiPromptText(langName, lang, w, count, emptyList(), emptyList(), scenario)
}

/** Hard cap on prompt length; roughly 500–700 tokens for a Latin-script language. */
private const val AI_MAX_PROMPT_CHARS = 1200

/** Everyday situations, so two taps never ask for exactly the same sentences. */
private val AI_SCENARIOS = listOf(
    "greeting a friend in the morning",
    "ordering food or a drink",
    "asking for directions",
    "talking about the weather",
    "shopping at a market",
    "talking about family",
    "at school or at work",
    "making plans for the weekend",
    "describing where you live",
    "meeting someone for the first time",
    "travelling by train or bus",
    "talking about hobbies and free time"
)

private fun aiScenario(): String = AI_SCENARIOS.random()

private fun aiPromptText(
    langName: String,
    lang: String,
    w: String,
    count: Int,
    demos: List<Examples.ExLine>,
    repeats: List<String>,
    scenario: String
): String = buildString {
    append("<|im_start|>system\n")
    append("You are an experienced $langName teacher writing practice sentences for a complete beginner. ")
    append("You always answer with plain $langName sentences, one per line, in exactly the format shown, and nothing else.\n")
    append("<|im_end|>\n")
    append("<|im_start|>user\n")
    append("Word: \"$w\"\n")
    if (scenario.isNotBlank()) append("Situation: $scenario.\n")
    if (demos.isNotEmpty()) {
        append("Two sentences that already exist for this word (do not reuse them):\n")
        demos.forEach { append("${it.text} | ${it.gloss}\n") }
    }
    append("Write $count different $langName sentences that each use the word \"$w\".\n")
    append("Rules:\n")
    append("- One sentence per line, then a pipe symbol \"|\", then the English meaning of that sentence.\n")
    append("- Each sentence is 4 to 12 words long, simple and natural.\n")
    if (lang != "en") append("- Write only in $langName script. Never use Latin letters.\n")
    append("- Every line is a different sentence. Do not number the lines. Do not write anything else.")
    if (repeats.isNotEmpty()) {
        append("\n- Do not write any of these sentences again:\n")
        repeats.forEach { append("  $it\n") }
    }
    append("\n<|im_end|>\n")
    append("<|im_start|>assistant\n")
}

/** Sentence tokens, counting combining marks as part of the word (Devanagari, Arabic, …). */
private fun aiWords(s: String): List<String> =
    Regex("[\\p{L}\\p{M}\\p{N}']+").findAll(s).map { it.value.lowercase() }.toList()

/** Loose key used to spot a sentence that has already been shown. */
private fun aiKey(s: String): String = aiWords(s).joinToString(" ")

private const val AI_MAX_WORDS = 16
private const val AI_MAX_CHARS = 140

/**
 * Rejects what a bad generation looks like: run-on rambles, fragments, text in the
 * wrong script, and "sentences" built from the same two or three words over and
 * over. Small models do all of these, and showing them is worse than showing
 * nothing.
 */
private fun plausibleSentence(text: String, lang: String): Boolean {
    if (text.length < 4 || text.length > AI_MAX_CHARS) return false
    if (!looksLikeTarget(text, lang)) return false
    return plausibleWords(aiWords(text))
}

/** Same idea for the translation half of a line. */
private fun plausibleMeaning(meaning: String, lang: String, native: String): Boolean {
    if (meaning.isEmpty()) return true
    if (meaning.length > AI_MAX_CHARS) return false
    if (native != lang && looksLikeTarget(meaning, lang)) return false
    return plausibleWords(aiWords(meaning))
}

private fun plausibleWords(words: List<String>): Boolean {
    if (words.isEmpty() || words.size > AI_MAX_WORDS) return false
    if (words.size >= 5 && words.toHashSet().size * 2 < words.size) return false
    val counts = HashMap<String, Int>(words.size)
    for (w in words) {
        val n = (counts[w] ?: 0) + 1
        if (n >= 4) return false
        counts[w] = n
    }
    return true
}

/**
 * Turns a model reply into example lines. Anything that isn't a plausible sentence,
 * or that repeats something already on screen (including the headword itself), is
 * dropped.
 */
internal fun parseAiLines(
    raw: String,
    lang: String,
    native: String,
    count: Int,
    headword: String = "",
    avoid: Collection<String> = emptyList()
): List<Examples.ExLine> {
    val out = ArrayList<Examples.ExLine>(count)
    val seen = HashSet<String>()
    val blocked = HashSet<String>()
    avoid.forEach { blocked.add(aiKey(it)) }
    blocked.add(aiKey(headword))
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
        if (!plausibleSentence(text, lang)) continue
        if (!plausibleMeaning(meaning, lang, native)) continue
        val key = aiKey(text)
        if (key.isBlank() || !blocked.add(key)) continue
        if (!seen.add(key)) continue
        val sub = if (lang == "ja") DictionaryData.kanaToRomaji(text) else ""
        out.add(Examples.ExLine(text, sub, aiGloss(meaning, lang, native)))
        if (out.size >= count) break
    }
    return out
}

/**
 * The meaning line under a generated sentence. The model is asked for English (what
 * it is best at) and that is translated through the bundled gloss tables — except
 * for learners whose native language *is* English, who used to get no translation
 * at all even though the model had just written one.
 */
private fun aiGloss(meaning: String, lang: String, native: String): String = when {
    meaning.isBlank() || native.isBlank() || native == lang -> ""
    native == "en" -> meaning
    looksLikeTarget(meaning, native) -> meaning
    else -> Examples.sentenceGloss(meaning, native).ifBlank { meaning }
}

internal fun looksLikeTarget(text: String, lang: String): Boolean = when (lang) {
    "en" -> text.any { it.isLetter() } && text.none { it.isLetter() && it.code > 0x024F }
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
