package com.nexo.kotoba

/**
 * Guarantees that every grammar pattern shows a useful number of example
 * sentences (at least [TARGET]).
 *
 * The curriculum was authored with a handful of examples per pattern, but
 * learners need more exposure to internalise a rule. Rather than duplicating
 * long lists in every pattern, this object:
 *
 *  1. keeps the pattern's own curated examples,
 *  2. appends hand-written extras from [GrammarExtraEn] / [GrammarExtraJa],
 *  3. if still short, borrows examples from a closely-related rich pattern
 *     (see [relatives]) — e.g. the beginner "am / is / are" pattern pulls from
 *     the full "to be" masterclass,
 *  4. de-duplicates and caps the result.
 *
 * Patterns that already ship ten or more examples (the masterclass libraries)
 * are returned untouched, so their full lists still show.
 *
 * Extra lines use the pipe format `emoji|target|romaji|english|hindi`, where
 * for English patterns `target` is the English sentence and `hindi` its
 * translation, and for Japanese patterns `target` is the Japanese sentence,
 * `romaji` the reading, and `english`/`hindi` the glosses.
 */
object GrammarPacks {

    const val TARGET = 10

    private val extras: Map<String, List<PatternExample>> by lazy {
        val map = HashMap<String, List<PatternExample>>()
        for ((id, raw) in GrammarExtraEn.raw) map[id] = parse(raw)
        for ((id, raw) in GrammarExtraJa.raw) map[id] = parse(raw)
        map
    }

    internal fun parse(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .map { it.trim() }
        .filter { it.isNotEmpty() && !it.startsWith("#") }
        .map { line ->
            val c = line.split("|")
            val target = c.getOrElse(1) { "" }.trim()
            PatternExample(
                c.getOrElse(0) { "" }.trim(),
                target,
                c.getOrElse(2) { "" }.trim(),
                c.getOrElse(3) { "" }.trim().ifEmpty { target },
                c.getOrElse(4) { "" }.trim()
            )
        }.toList()

    private val relatives: Map<String, List<String>> = mapOf(
        "en1" to listOf("eg1"),
        "en2" to listOf("eg25"),
        "en4" to listOf("eg4"),
        "en5" to listOf("eg6"),
        "en6" to listOf("eg5"),
        "en7" to listOf("eg12"),
        "en8" to listOf("eg15"),
        "en10" to listOf("eg22"),
        "en11" to listOf("eg28"),
        "en12" to listOf("eg2"),
        "en13" to listOf("eg3"),
        "en14" to listOf("eg8"),
        "en15" to listOf("eg9"),
        "en16" to listOf("eg7"),
        "en17" to listOf("eg10"),
        "en18" to listOf("eg11"),
        "en19" to listOf("eg19"),
        "en20" to listOf("eg17"),
        "en21" to listOf("eg18"),
        "en22" to listOf("eg28"),
        "en23" to listOf("eg21"),
        "en24" to listOf("eg29"),
        "en25" to listOf("eg32"),
        "en26" to listOf("eg30"),
        "epA1-a" to listOf("eg1"),
        "epA1-b" to listOf("eg25"),
        "epA1-d" to listOf("eg3"),
        "epA1-g" to listOf("eg31"),
        "epA1-i" to listOf("eg23"),
        "epA2-b" to listOf("eg6"),
        "epA2-c" to listOf("eg6"),
        "epA2-d" to listOf("eg4"),
        "epA2-e" to listOf("eg12"),
        "epA2-f" to listOf("eg15"),
        "epA2-g" to listOf("eg28"),
        "epA2-h" to listOf("eg28"),
        "epA2-i" to listOf("eg26"),
        "epA2-j" to listOf("eg17"),
        "epB1-a" to listOf("eg8"),
        "epB1-b" to listOf("eg9"),
        "epB1-c" to listOf("eg7"),
        "epB1-d" to listOf("eg11"),
        "epB1-e" to listOf("eg21"),
        "epB1-f" to listOf("eg20"),
        "epB1-g" to listOf("eg29"),
        "epB1-i" to listOf("eg30"),
        "epB2-c" to listOf("eg10"),
        "epB2-d" to listOf("eg13"),
        "epB2-e" to listOf("eg32"),
        "jp1" to listOf("jg1"),
        "jp3" to listOf("jg1"),
        "jp5" to listOf("jg4"),
        "jp6" to listOf("jg12"),
        "jp7" to listOf("jg16"),
        "jp8" to listOf("jg15"),
        "jp9" to listOf("jg5"),
        "jp13" to listOf("jg13"),
        "jp16" to listOf("jg17"),
        "jp20" to listOf("jg19"),
        "jp22" to listOf("jg12"),
        "jp25" to listOf("jg5"),
        "jp26" to listOf("jg6"),
        "genki-1" to listOf("jg1"),
        "genki-3" to listOf("jg4"),
        "genki-6" to listOf("jg10"),
        "genki-10" to listOf("jg19"),
        "genki-11" to listOf("jg15"),
        "jfz-1" to listOf("jg1"),
        "jfz-3" to listOf("jg9"),
        "jfz-8" to listOf("jg12"),
        "jfz-10" to listOf("jg16"),
        "jfz-11" to listOf("jg20")
    )

    private val index: Map<String, Pattern> by lazy {
        (Data.allPatterns + EnglishGrammar.patterns + JapaneseGrammar.patterns +
            Genki.patterns + Jfz.patterns).associateBy { it.id }
    }

    /**
     * Every example available for [p]: the pattern's own list, the hand-written
     * extras and the examples of a closely-related pattern on the *same* grammar
     * point. De-duplicated and capped at [limit].
     *
     * Nothing is ever borrowed from an unrelated pattern, so a sheet about the
     * past perfect continuous can only ever show present-perfect-continuous
     * sentences — never a stray "I am a teacher" from the verb-to-be topic.
     *
     * The grammar detail screen shows the first ten of this pool and reveals ten
     * more each time the learner taps "Load 10 more".
     */
    fun pool(p: Pattern, limit: Int = 60): List<PatternExample> {
        val out = ArrayList<PatternExample>(limit)
        val seen = HashSet<String>()
        fun add(e: PatternExample) {
            val key = e.ja.trim().lowercase()
            if (key.isEmpty() || seen.add(key)) out.add(e)
        }
        p.examples.forEach { add(it) }
        extras[p.id]?.forEach { add(it) }
        for (rid in relatives[p.id].orEmpty()) index[rid]?.examples?.forEach { add(it) }
        return out
    }

    /** The examples to display for [p]: at least [TARGET] where possible. */
    fun examples(p: Pattern): List<PatternExample> {
        if (p.examples.size >= TARGET) return p.examples
        val out = ArrayList<PatternExample>(TARGET)
        val seen = HashSet<String>()
        fun add(e: PatternExample) {
            val key = e.ja.trim().lowercase()
            if (key.isEmpty() || seen.add(key)) out.add(e)
        }
        p.examples.forEach { add(it) }
        extras[p.id]?.forEach { add(it) }
        if (out.size < TARGET) {
            for (rid in relatives[p.id].orEmpty()) {
                if (out.size >= TARGET) break
                index[rid]?.examples?.forEach { add(it) }
            }
        }
        return out
    }
}
