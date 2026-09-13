package com.nexo.kotoba

import android.content.Context
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * One English verb with its four forms.
 *
 * `1st` is the base form (go), `2nd` the past simple (went), `3rd` the past
 * participle (gone) and `4th` the present participle / -ing form (going).
 */
data class VerbEntry(
    val base: String,
    val v2: String,
    val v3: String,
    val v4: String,
    val irregular: Boolean,
    val hi: String
)

/**
 * The full English verb table (4,400+ verbs), loaded once from
 * `assets/verbs.tsv`. Each line holds `base \t v2 \t v3 \t v4 \t irregular \t
 * hindi`. Native-language meanings come from [Gloss] so every supported learner
 * language works, and the search matches both the English forms and the native
 * meaning (English → native and native → English).
 */
object Verbs {

    @Volatile
    private var cache: List<VerbEntry>? = null

    @Volatile
    private var cachedNative: String = ""

    @Volatile
    private var meaningCache: Map<String, String> = emptyMap()

    val all: List<VerbEntry> get() = cache ?: emptyList()

    val loaded: Boolean get() = cache != null

    fun init(context: Context) {
        if (cache != null) return
        synchronized(this) {
            if (cache != null) return
            cache = try {
                context.assets.open("verbs.tsv").bufferedReader().use { r ->
                    r.lineSequence().filter { it.isNotBlank() }.mapNotNull { line ->
                        val c = line.split("\t")
                        if (c.size < 4) return@mapNotNull null
                        VerbEntry(
                            base = c[0],
                            v2 = c.getOrElse(1) { "" },
                            v3 = c.getOrElse(2) { "" },
                            v4 = c.getOrElse(3) { "" },
                            irregular = c.getOrElse(4) { "0" } == "1",
                            hi = c.getOrElse(5) { "" }
                        )
                    }.toList()
                }
            } catch (_: Exception) {
                emptyList()
            }
        }
    }

    private fun resolve(e: VerbEntry, native: String): String {
        if (native == "en" || native.isBlank()) return ""
        val g = cleanGloss(Gloss.lookup(e.base))
        return if (!g.isNullOrEmpty()) g
        else if (native == "hi") (cleanGloss(e.hi) ?: e.hi)
        else ""
    }

    /** The verb's meaning in [native], or an empty string when unknown. */
    fun meaning(e: VerbEntry, native: String): String {
        if (native == "en" || native.isBlank()) return ""
        if (native == cachedNative) {
            val c = meaningCache[e.base]
            if (c != null) return c
        }
        return resolve(e, native)
    }

    /** Warm the native-meaning cache for [native] so searches stay fast. */
    fun precompute(native: String) {
        if (native == "en" || native.isBlank()) return
        if (native == cachedNative && meaningCache.isNotEmpty()) return
        val m = HashMap<String, String>(5200)
        for (e in all) {
            val r = resolve(e, native)
            if (r.isNotEmpty()) m[e.base] = r
        }
        meaningCache = m
        cachedNative = native
    }

    private fun rank(e: VerbEntry, q: String, native: String): Int = when {
        e.base == q -> 0
        e.base.startsWith(q) -> 1
        e.v2.lowercase() == q || e.v3.lowercase() == q || e.v4.lowercase() == q -> 2
        e.base.contains(q) -> 3
        e.v2.lowercase().startsWith(q) || e.v3.lowercase().startsWith(q) || e.v4.lowercase().startsWith(q) -> 4
        e.v2.lowercase().contains(q) || e.v3.lowercase().contains(q) || e.v4.lowercase().contains(q) -> 5
        native != "en" && meaning(e, native).lowercase().startsWith(q) -> 6
        else -> 7
    }

    /**
     * Case-insensitive search across the four English forms and the native
     * meaning. Exact and prefix matches on the base form come first.
     */
    fun search(query: String, native: String, limit: Int = 200): List<VerbEntry> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return emptyList()
        val hits = ArrayList<VerbEntry>(limit)
        for (e in all) {
            val hasEn = e.base.contains(q) || e.v2.lowercase().contains(q) ||
                e.v3.lowercase().contains(q) || e.v4.lowercase().contains(q)
            val hasNative = native != "en" && meaning(e, native).lowercase().contains(q)
            if (hasEn || hasNative) hits.add(e)
        }
        return hits.sortedWith(
            compareBy(
                { rank(it, q, native) },
                { it.base.length }
            )
        ).take(limit)
    }
}

/**
 * The "Words" tab: a segmented switch between the dictionary and the verb
 * trainer, so verbs get their own searchable section without squeezing a
 * seventh icon into the bottom bar.
 */
@Composable
fun WordsScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var showVerbs by remember { mutableStateOf(false) }
    Column(modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterChip(
                selected = !showVerbs,
                onClick = { showVerbs = false },
                label = { Text("Dictionary") }
            )
            FilterChip(
                selected = showVerbs,
                onClick = { showVerbs = true },
                label = { Text("Verbs") }
            )
        }
        if (showVerbs) VerbsScreen(store, speaker, Modifier.weight(1f))
        else DictionaryScreen(store, speaker, Modifier.weight(1f))
    }
}

@Composable
fun VerbsScreen(store: Store, speaker: Speaker, modifier: Modifier = Modifier) {
    var q by remember { mutableStateOf("") }
    var ready by remember { mutableStateOf(Verbs.loaded) }
    val query = q.trim()
    val native = store.nativeLang

    LaunchedEffect(native) {
        while (!Verbs.loaded) delay(120)
        withContext(Dispatchers.Default) { Verbs.precompute(native) }
        ready = true
    }

    val results = remember(query, native, ready) {
        if (ready) Verbs.search(query, native) else emptyList()
    }
    val goMeaning = remember(native, ready) {
        if (!ready) "" else Verbs.all.firstOrNull { it.base == "go" }?.let { Verbs.meaning(it, native) } ?: ""
    }

    Column(modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        Spacer(Modifier.height(4.dp))
        Text("Verbs", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        Text(
            if (ready) "${Verbs.all.size} verbs · 1st, 2nd, 3rd & 4th form · offline"
            else "Loading verbs…",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(14.dp))

        OutlinedTextField(
            value = q,
            onValueChange = { q = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("Search any form or meaning: go, went, gone, जाना…") },
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
        Spacer(Modifier.height(10.dp))

        if (!ready) {
            Box(Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Loading the verb table…",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            return@Column
        }

        if (query.isEmpty()) {
            Card(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("The four forms", fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(6.dp))
                    Text(
                        "1st — base (go) · 2nd — past (went) · 3rd — past participle (gone) · 4th — -ing (going).",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Search in English or in your own language to find the verb either way.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(
                "Try:",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                VerbChip("go", { q = "go" })
                VerbChip("carry", { q = "carry" })
                if (goMeaning.isNotEmpty()) VerbChip(goMeaning, { q = goMeaning })
                else VerbChip("write", { q = "write" })
            }
        } else if (results.isEmpty()) {
            Text(
                "No verbs match \"$q\" — try another form or spelling.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            Text(
                "${results.size} result" + (if (results.size == 1) "" else "s") + " for \"$q\"",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(6.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(results, key = { it.base }) { e ->
                    VerbCard(e, native, store, speaker)
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun VerbCard(e: VerbEntry, native: String, store: Store, speaker: Speaker) {
    val meaning = Verbs.meaning(e, native)
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (e.irregular) MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.45f)
            else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(e.base, fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
                    if (e.irregular) {
                        Spacer(Modifier.width(8.dp))
                        Surface(shape = RoundedCornerShape(6.dp), color = MaterialTheme.colorScheme.tertiaryContainer) {
                            Text(
                                "irregular",
                                Modifier.padding(horizontal = 6.dp, vertical = 1.dp),
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }
                if (meaning.isNotEmpty()) {
                    Spacer(Modifier.height(3.dp))
                    Text(meaning, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    "1st " + e.base + "  ·  2nd " + e.v2 + "  ·  3rd " + e.v3 + "  ·  4th " + e.v4,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            FilledIconButton(
                onClick = { speakIn(store, speaker, e.base, "en") },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun VerbChip(label: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}
