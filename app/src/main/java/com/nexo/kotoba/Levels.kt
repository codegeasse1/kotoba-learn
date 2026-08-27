package com.nexo.kotoba

object Levels {

    val ORDER = listOf("N5", "N4", "N3", "N2", "N1", "A1", "A2", "B1", "B2", "C1", "C2")

    val LABEL = mapOf(
        "N5" to "N5 · Beginner",
        "N4" to "N4 · Upper-Beginner",
        "N3" to "N3 · Intermediate",
        "N2" to "N2 · Upper-Intermediate",
        "N1" to "N1 · Advanced",
        "A1" to "A1 · Beginner",
        "A2" to "A2 · Elementary",
        "B1" to "B1 · Pre-Intermediate",
        "B2" to "B2 · Upper-Intermediate",
        "C1" to "C1 · Advanced · IELTS 6.5–7.5",
        "C2" to "C2 · Proficient · IELTS 8+"
    )

    val EMOJI = mapOf(
        "N5" to "🌱", "N4" to "🌿", "N3" to "🌳", "N2" to "🏔️", "N1" to "🗻",
        "A1" to "🐣", "A2" to "🐥", "B1" to "🦆", "B2" to "🦅", "C1" to "🦉", "C2" to "🐉"
    )

    fun label(code: String) = LABEL[code] ?: code

    fun order(code: String) = ORDER.indexOf(code).let { if (it < 0) ORDER.size else it }

    val LESSON_LEVELS = mapOf(
        "greetings" to "N5", "numbers" to "N5", "colors" to "N5", "family" to "N5",
        "food" to "N5", "animals" to "N5", "actions" to "N5", "adjectives" to "N5",
        "time" to "N5", "places" to "N5", "nature" to "N5", "conversation" to "N5",
        "intro" to "N5", "routine" to "N5", "travel" to "N5", "shopping" to "N5",
        "restaurant" to "N5", "hobbies" to "N5", "home" to "N5", "body" to "N5",
        "city" to "N5", "dates" to "N5", "feelings" to "N5", "work" to "N5",
        "en-greet" to "A1", "en-num" to "A1", "en-time" to "A1", "en-family" to "A1",
        "en-food" to "A1", "en-body" to "A1", "en-clothes" to "A1", "en-house" to "A1",
        "en-work" to "A1", "en-actions" to "A1", "en-shop" to "A1", "en-feel" to "A1"
    )

    val PATTERN_LEVELS = mapOf(
        "jp1" to "N5", "jp2" to "N5", "jp3" to "N5", "jp4" to "N5", "jp5" to "N5",
        "jp6" to "N5", "jp7" to "N5", "jp8" to "N5", "jp9" to "N5", "jp10" to "N5",
        "jp11" to "N5", "jp12" to "N5", "jp13" to "N5", "jp14" to "N5",
        "jp15" to "N5", "jp16" to "N5", "jp17" to "N5", "jp18" to "N5",
        "jp19" to "N4", "jp20" to "N5", "jp21" to "N5", "jp22" to "N5",
        "jp23" to "N4", "jp24" to "N4", "jp25" to "N5", "jp26" to "N5",
        "en1" to "A1", "en2" to "A1", "en3" to "A1", "en4" to "A1", "en5" to "A1",
        "en6" to "A1", "en7" to "A2", "en8" to "A1", "en9" to "A1", "en10" to "A1",
        "en11" to "A2", "en12" to "A1",
        "en13" to "A1", "en14" to "B1", "en15" to "B1", "en16" to "B1",
        "en17" to "B2", "en18" to "A2", "en19" to "A2", "en20" to "A2",
        "en21" to "A2", "en22" to "A2", "en23" to "B1", "en24" to "B1",
        "en25" to "B2", "en26" to "B1", "en27" to "B1", "en28" to "B1",
        "en29" to "B2", "en30" to "B1"
    )

    fun ofLesson(l: Lesson): String = l.level.ifEmpty { LESSON_LEVELS[l.id] ?: "" }
    fun ofPattern(p: Pattern): String = p.level.ifEmpty { PATTERN_LEVELS[p.id] ?: "" }
}

object L {
    private var wid = 0

    fun ja(id: String, title: String, emoji: String, desc: String, level: String, raw: String): Lesson =
        Lesson(id, title, emoji, desc, jaWords(raw), "ja", level)

    fun en(id: String, title: String, emoji: String, desc: String, level: String, raw: String): Lesson =
        Lesson(id, title, emoji, desc, enWords(raw), "en", level)

    private fun jaWords(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("|")
            Word("w${wid++}", "•", c[0], c[1], c.getOrElse(2) { "" }, c.getOrElse(3) { "" }, "", c.getOrElse(4) { "" })
        }.toList()

    private fun enWords(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("|")
            Word("w${wid++}", "•", "", "", "", c[0], c.getOrElse(1) { "" }, c.getOrElse(2) { "" })
        }.toList()

    fun jp(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleJa: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "ja", ruleEn, ruleJa, ex(raw), ruleHi, level)

    fun ep(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "en", ruleEn, "", ex(raw), ruleHi, level)

    private fun ex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("|")
            PatternExample("•", c[0], c[1], c[2], c.getOrElse(3) { "" })
        }.toList()

    fun ph(id: String, emoji: String, ja: String, romaji: String, en: String, hi: String): Phrase =
        Phrase(id, emoji, ja, romaji, en, en, hi)
}
