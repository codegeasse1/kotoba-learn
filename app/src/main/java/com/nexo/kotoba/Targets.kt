package com.nexo.kotoba

/**
 * Content for languages that aren't authored natively (i.e. anything other than
 * Japanese and English).
 *
 * The app's vocabulary, example sentences and grammar are written around an
 * English pivot, and every language ships an `assets/gloss_<lang>.tsv` table
 * mapping English strings to that language. For any target language `T` we can
 * therefore build a full learning track by translating the English curriculum
 * into `T` at runtime:
 *
 *  - lessons: every English lesson becomes a `T` lesson (word = translated text,
 *    meaning = the learner's native language / English)
 *  - sentence categories: every English category becomes a `T` category
 *  - grammar: every English pattern's examples become `T` sentences
 *  - roleplays: every English roleplay becomes a `T` roleplay
 *
 * All ids are prefixed with the language code so progress/review ids never
 * collide with the Japanese or English tracks.
 */
object TargetContent {

    fun isNativeTrack(t: String): Boolean = t == "ja" || t == "en"

    private val lessonCache = HashMap<String, List<Lesson>>()
    private val wordCache = HashMap<String, List<Word>>()
    private val patternCache = HashMap<String, List<Pattern>>()
    private val categoryCache = HashMap<String, List<SentenceCategory>>()
    private val roleplayCache = HashMap<String, List<Roleplay>>()

    private fun tx(text: String, t: String): String {
        if (text.isBlank()) return text
        return Gloss.lookupTarget(text) ?: text
    }

    /**
     * Localize an English title/description for the language being learned. The
     * gloss tables are keyed by the cleaned English title, so strip the
     * "(English)"/"(Japanese)" qualifiers before looking it up.
     */
    private fun localize(t: String, text: String): String {
        if (text.isBlank()) return text
        Gloss.lookupTarget(text)?.let { return it }
        var base = text.replace(Regex("\\s*\\((English|Japanese)\\)"), " ")
        base = base.replace(Regex("^(English|Japanese)\\s+"), "")
        base = base.replace(Regex("\\s+"), " ").trim()
        if (base != text) Gloss.lookupTarget(base)?.let { return it }
        return base
    }

    fun lessons(t: String): List<Lesson> = lessonCache.getOrPut(t) {
        when (t) {
            "ja" -> Data.allLessons.filter { it.lang == "ja" }
            "en" -> Data.allLessons.filter { it.lang == "en" }
            else -> Data.allLessons.filter { it.lang == "en" }.map { lesson ->
                lesson.copy(
                    id = t + "-" + lesson.id,
                    title = localize(t, lesson.title),
                    desc = localize(t, lesson.desc),
                    level = Levels.ofLesson(lesson),
                    lang = t,
                    words = lesson.words.map { word -> translateWord(word, t) }
                )
            }
        }
    }

    private fun translateWord(word: Word, t: String): Word = word.copy(
        id = t + "-" + word.id,
        kana = cleanGloss(tx(word.en, t)) ?: tx(word.en, t),
        romaji = "",
        kanji = "",
        hi = "",
        lang = t
    )

    fun words(t: String): List<Word> = wordCache.getOrPut(t) { lessons(t).flatMap { it.words } }

    fun wordById(t: String, id: String): Word? = words(t).firstOrNull { it.id == id }

    fun patterns(t: String): List<Pattern> = patternCache.getOrPut(t) {
        val all = Data.allPatterns.filter { it.lang == "en" } + EnglishGrammar.patterns
        when (t) {
            "ja", "en" -> all
            else -> EnglishGrammar.patterns.map { p ->
                p.copy(
                    id = t + "-" + p.id,
                    lang = t,
                    ruleJa = "",
                    ruleHi = "",
                    examples = p.examples.take(10).map { ex ->
                        val english = ex.ja
                        PatternExample(ex.emoji, tx(english, t), "", english, "")
                    }
                )
            }
        }
    }

    fun sentenceCategories(t: String): List<SentenceCategory> = categoryCache.getOrPut(t) {
        when (t) {
            "ja" -> Sentences.categories.filter { it.lang == "ja" }
            "en" -> Sentences.categories.filter { it.lang == "en" }
            else -> Sentences.categories.filter { it.lang == "en" }.map { cat ->
                cat.copy(
                    id = t + "-" + cat.id,
                    title = localize(t, cat.title),
                    desc = localize(t, cat.desc),
                    lang = t,
                    sentences = cat.sentences.map { s ->
                        Sentence(s.id, s.emoji, tx(s.ja, t), "", s.ja, "")
                    }
                )
            }
        }
    }

    fun roleplays(t: String): List<Roleplay> = roleplayCache.getOrPut(t) {
        when (t) {
            "ja" -> Roleplays.all.filter { it.lang == "ja" }
            "en" -> Roleplays.all.filter { it.lang == "en" }
            else -> Roleplays.all.filter { it.lang == "en" }.map { rp ->
                rp.copy(
                    id = t + "-" + rp.id,
                    title = localize(t, rp.title),
                    desc = localize(t, rp.desc),
                    lang = t,
                    turns = rp.turns.map { turn ->
                        turn.copy(
                            npc = tx(turn.npc, t),
                            npcHi = turn.npc,
                            options = turn.options.map { o ->
                                o.copy(
                                    text = tx(o.text, t),
                                    textHi = o.text,
                                    feedback = tx(o.feedback, t),
                                    feedbackHi = o.feedback
                                )
                            }
                        )
                    }
                )
            }
        }
    }
}
