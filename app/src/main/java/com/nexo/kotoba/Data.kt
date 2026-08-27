package com.nexo.kotoba

data class KanaChar(val id: String, val kana: String, val romaji: String, val mnemonic: String)

data class Word(
    val id: String,
    val emoji: String,
    val kana: String,
    val romaji: String,
    val kanji: String = "",
    val en: String,
    val ipa: String,
    val hi: String = ""
)

data class Lesson(
    val id: String,
    val title: String,
    val emoji: String,
    val desc: String,
    val words: List<Word>,
    val lang: String = "ja",
    val level: String = "",
    val source: String = ""
)

data class Phrase(
    val id: String,
    val emoji: String,
    val ja: String,
    val romaji: String,
    val en: String,
    val chunks: String,
    val hi: String = ""
)

data class PatternExample(
    val emoji: String,
    val ja: String,
    val romaji: String,
    val en: String,
    val hi: String = ""
)

data class Pattern(
    val id: String,
    val titleEn: String,
    val titleJa: String,
    val lang: String,
    val ruleEn: String,
    val ruleJa: String,
    val examples: List<PatternExample>,
    val ruleHi: String = "",
    val level: String = "",
    val source: String = ""
)

data class Sentence(
    val id: String,
    val emoji: String,
    val ja: String,
    val romaji: String,
    val en: String,
    val hi: String = ""
)

data class SentenceCategory(
    val id: String,
    val title: String,
    val emoji: String,
    val desc: String,
    val sentences: List<Sentence>,
    val lang: String = "ja"
)

data class KanjiChar(
    val id: String,
    val kanji: String,
    val meaning: String,
    val onyomi: String,
    val kunyomi: String,
    val story: String
)

data class AlphabetChar(
    val letter: String,
    val word: String,
    val emoji: String,
    val ipa: String,
    val kana: String,
    val hi: String
)

object KanaData {

    val hiragana = listOf(
        KanaChar("h-a", "あ", "a", "'A' with a sword through the middle."),
        KanaChar("h-i", "い", "i", "Two elegant italic 'i' strokes standing together."),
        KanaChar("h-u", "う", "u", "An 'u' flipped into a bowl — an 'u'pside-down bowl."),
        KanaChar("h-e", "え", "e", "An 'e'nvelope with its flap open."),
        KanaChar("h-o", "お", "o", "An 'o' wearing a belt — 'oh!' that's a belt."),
        KanaChar("h-ka", "か", "ka", "A 'ka'mel — the right curve is its hump, left is the neck."),
        KanaChar("h-ki", "き", "ki", "A 'key' — the left side is the key teeth, right the loop."),
        KanaChar("h-ku", "く", "ku", "A 'koo'koo bird's beak, open to the left."),
        KanaChar("h-ke", "け", "ke", "A 'ke'y blade — the right side is the handle."),
        KanaChar("h-ko", "こ", "ko", "Two 'ko'ins stacked with a fishing line between."),
        KanaChar("h-sa", "さ", "sa", "'Sa'ndwich — a Z with a bite taken out."),
        KanaChar("h-shi", "し", "shi", "A 'she'ep's curled tail."),
        KanaChar("h-su", "す", "su", "A 'su'spender — the loop of a suspender."),
        KanaChar("h-se", "せ", "se", "A 'se'at — a chair with a back and legs."),
        KanaChar("h-so", "そ", "so", "A 'so'ft surf wave curling to the left."),
        KanaChar("h-ta", "た", "ta", "A 'ta'tami mat with a cross marking it."),
        KanaChar("h-chi", "ち", "chi", "'Chi'cken — a little chick standing up."),
        KanaChar("h-tsu", "つ", "tsu", "A 'tsu'nami wave curling over."),
        KanaChar("h-te", "て", "te", "A 'te'nis racket — cross is the strings, curve the handle."),
        KanaChar("h-to", "と", "to", "A 'to'e — a toe with a nail on top."),
        KanaChar("h-na", "な", "na", "A 'na'il — left is a knee, right a nail with a knot."),
        KanaChar("h-ni", "に", "ni", "A 'ni' (knee) — the top stroke is a kneecap, right is a knee."),
        KanaChar("h-nu", "ぬ", "nu", "A 'nu'dle — a slippery noodle with a loop."),
        KanaChar("h-ne", "ね", "ne", "A 'ne'ck — a long neck curling with a loop."),
        KanaChar("h-no", "の", "no", "'No' — a 'no' sign: a circle with a tail."),
        KanaChar("h-ha", "は", "ha", "'Ha!' — left is hair, right is the face laughing."),
        KanaChar("h-hi", "ひ", "hi", "A 'hi' — a wide grin, like someone saying 'hee hee'."),
        KanaChar("h-fu", "ふ", "fu", "A 'fu' — the slopes of Mount Fuji."),
        KanaChar("h-he", "へ", "he", "A 'he' — a flat 'hey!' wave, like a shrug."),
        KanaChar("h-ho", "ほ", "ho", "'Ho' — a 'ho'ly staff with a cross, right side a halo."),
        KanaChar("h-ma", "ま", "ma", "A 'ma'st — left is a mast with a cross, right a sail."),
        KanaChar("h-mi", "み", "mi", "'Mi' — a person with a big ear bending to hear 'me'."),
        KanaChar("h-mu", "む", "mu", "A 'mu' — a 'moo'ing cow's face (the loop is the mouth)."),
        KanaChar("h-me", "め", "me", "'Me' — like 'mi' but lazier; 'me' also means eye."),
        KanaChar("h-mo", "も", "mo", "'Mo' — like 'ki' but with an extra hook ('mo're fish)."),
        KanaChar("h-ya", "や", "ya", "A 'ya'cht sail."),
        KanaChar("h-yu", "ゆ", "yu", "A 'yu'rt — a round tent, or a fishhook."),
        KanaChar("h-yo", "よ", "yo", "A 'yo'yo on its string."),
        KanaChar("h-ra", "ら", "ra", "A 'ra'bbit's ear (the right stroke is an ear)."),
        KanaChar("h-ri", "り", "ri", "'Ri' — a 'ri'ver cut: two parallel strokes like a valley."),
        KanaChar("h-ru", "る", "ru", "'Ru' — a 'ru'bbing stone: a loop with a tail."),
        KanaChar("h-re", "れ", "re", "'Re' — like 'ne' with a straight back — a 're'd ribbon."),
        KanaChar("h-ro", "ろ", "ro", "'Ro' — like 'ru' but without the loop — a 'ro'ad sign."),
        KanaChar("h-wa", "わ", "wa", "'Wa' — a 'wa'ter slide: right is the slide, left a ladder."),
        KanaChar("h-wo", "を", "wo", "'Wo' — a 'wo'bbly hook (a particle, sounds like 'o')."),
        KanaChar("h-n", "ん", "n", "'N' — an 'n' that's tired, lying down like a snake.")
    )

    val katakana = listOf(
        KanaChar("k-a", "ア", "a", "'A' — an A made of two strokes plus a crossbar."),
        KanaChar("k-i", "イ", "i", "'I' — looks like the letter I."),
        KanaChar("k-u", "ウ", "u", "'U' — a 'u' with a roof on top."),
        KanaChar("k-e", "エ", "e", "'E' — an E made of strokes, like a ladder."),
        KanaChar("k-o", "オ", "o", "'O' — an O with a crossbar, like a price tag."),
        KanaChar("k-ka", "カ", "ka", "'Ka' — the left half of hiragana か, a 'ka'rate chop."),
        KanaChar("k-ki", "キ", "ki", "'Ki' — a 'key' with a loop on top."),
        KanaChar("k-ku", "ク", "ku", "'Ku' — a 'koo'ckoo: a beak with a wing."),
        KanaChar("k-ke", "ケ", "ke", "'Ke' — a 'ke'g with a tap."),
        KanaChar("k-ko", "コ", "ko", "'Ko' — two straight bars, a 'ko'in slot."),
        KanaChar("k-sa", "サ", "sa", "'Sa' — like a 'sa'd face with a slash through it."),
        KanaChar("k-shi", "シ", "shi", "'Shi' — a 'sh'ushing finger: three short strokes."),
        KanaChar("k-su", "ス", "su", "'Su' — a 'su'per speed line, like a skier."),
        KanaChar("k-se", "セ", "se", "'Se' — a 'se'at belt: the line is the belt."),
        KanaChar("k-so", "ソ", "so", "'So' — a 'so'aring bird: two short strokes, one long."),
        KanaChar("k-ta", "タ", "ta", "'Ta' — a 'ta'ble with legs."),
        KanaChar("k-chi", "チ", "chi", "'Chi' — a 'che'ckmark over a smile."),
        KanaChar("k-tsu", "ツ", "tsu", "'Tsu' — a 'tsu'nami: three wave crests."),
        KanaChar("k-te", "テ", "te", "'Te' — a 'te'nt shape."),
        KanaChar("k-to", "ト", "to", "'To' — a 'to'e pointing right."),
        KanaChar("k-na", "ナ", "na", "'Na' — a 'na'il: the cross is the nail head."),
        KanaChar("k-ni", "ニ", "ni", "'Ni' — two parallel strokes, like the number 2."),
        KanaChar("k-nu", "ヌ", "nu", "'Nu' — a 'nu'dge: a hand nudging with a hook."),
        KanaChar("k-ne", "ネ", "ne", "'Ne' — a 'ne'ck: the line runs down like a neck with a cross."),
        KanaChar("k-no", "ノ", "no", "'No' — a single slash, like a quick 'no!' swipe."),
        KanaChar("k-ha", "ハ", "ha", "'Ha' — two legs, like 'ha ha' laughter marks."),
        KanaChar("k-hi", "ヒ", "hi", "'Hi' — a 'hi'gh-heel shoe (the slant)."),
        KanaChar("k-fu", "フ", "fu", "'Fu' — a 'fu'll sail (the top hook is the sail)."),
        KanaChar("k-he", "ヘ", "he", "'He' — like hiragana へ, a 'hey!' wave."),
        KanaChar("k-ho", "ホ", "ho", "'Ho' — like hiragana ほ, a 'ho'ly staff with a cross."),
        KanaChar("k-ma", "マ", "ma", "'Ma' — a 'ma'dman's M (the strokes form an M)."),
        KanaChar("k-mi", "ミ", "mi", "'Mi' — three strokes like a '3' (three 'mi'ddle fingers)."),
        KanaChar("k-mu", "ム", "mu", "'Mu' — a 'mu'scle: a flexed arm (a bicep)."),
        KanaChar("k-me", "メ", "me", "'Me' — a 'me'ssy X with a cross (a saltire)."),
        KanaChar("k-mo", "モ", "mo", "'Mo' — like hiragana も, a 'mo're-fish with a hook."),
        KanaChar("k-ya", "ヤ", "ya", "'Ya' — a 'ya'cht mast (a Y shape)."),
        KanaChar("k-yu", "ユ", "yu", "'Yu' — a 'yu'rt: a U shape with a leg."),
        KanaChar("k-yo", "ヨ", "yo", "'Yo' — three stacked bars, like a shelf ('yo' three times)."),
        KanaChar("k-ra", "ラ", "ra", "'Ra' — a 'ra'dar dish (the top curve is the dish)."),
        KanaChar("k-ri", "リ", "ri", "'Ri' — like hiragana り: two 'ri'ver strokes."),
        KanaChar("k-ru", "ル", "ru", "'Ru' — a 'ru'bbish hook (a rotated L)."),
        KanaChar("k-re", "レ", "re", "'Re' — a 're'd arrow: a bent arrow."),
        KanaChar("k-ro", "ロ", "ro", "'Ro' — a 'ro'bot: a box (a square)."),
        KanaChar("k-wa", "ワ", "wa", "'Wa' — a 'wa'ter well: a wide valley shape."),
        KanaChar("k-wo", "ヲ", "wo", "'Wo' — like ウ with a dash — a 'wo'bbly particle."),
        KanaChar("k-n", "ン", "n", "'N' — like ソ but horizontal — a 'n'apping 'n'.")
    )

    val hiraganaDakuon = listOf(
        KanaChar("hd-ga", "が", "ga", "か + two dots = voiced 'ga'."),
        KanaChar("hd-gi", "ぎ", "gi", "き + two dots = voiced 'gi'."),
        KanaChar("hd-gu", "ぐ", "gu", "く + two dots = voiced 'gu'."),
        KanaChar("hd-ge", "げ", "ge", "け + two dots = voiced 'ge'."),
        KanaChar("hd-go", "ご", "go", "こ + two dots = voiced 'go'."),
        KanaChar("hd-za", "ざ", "za", "さ + two dots = voiced 'za'."),
        KanaChar("hd-ji", "じ", "ji", "し + two dots = voiced 'ji'."),
        KanaChar("hd-zu", "ず", "zu", "す + two dots = voiced 'zu'."),
        KanaChar("hd-ze", "ぜ", "ze", "せ + two dots = voiced 'ze'."),
        KanaChar("hd-zo", "ぞ", "zo", "そ + two dots = voiced 'zo'."),
        KanaChar("hd-da", "だ", "da", "た + two dots = voiced 'da'."),
        KanaChar("hd-dji", "ぢ", "ji", "ち + two dots = 'ji' (rare, mostly in compounds)."),
        KanaChar("hd-dzu", "づ", "zu", "つ + two dots = 'zu' (rare)."),
        KanaChar("hd-de", "で", "de", "て + two dots = voiced 'de'."),
        KanaChar("hd-do", "ど", "do", "と + two dots = voiced 'do'."),
        KanaChar("hd-ba", "ば", "ba", "は + two dots = voiced 'ba'."),
        KanaChar("hd-bi", "び", "bi", "ひ + two dots = voiced 'bi'."),
        KanaChar("hd-bu", "ぶ", "bu", "ふ + two dots = voiced 'bu'."),
        KanaChar("hd-be", "べ", "be", "へ + two dots = voiced 'be'."),
        KanaChar("hd-bo", "ぼ", "bo", "ほ + two dots = voiced 'bo'."),
        KanaChar("hd-pa", "ぱ", "pa", "は + a small circle = 'pa'."),
        KanaChar("hd-pi", "ぴ", "pi", "ひ + a small circle = 'pi'."),
        KanaChar("hd-pu", "ぷ", "pu", "ふ + a small circle = 'pu'."),
        KanaChar("hd-pe", "ぺ", "pe", "へ + a small circle = 'pe'."),
        KanaChar("hd-po", "ぽ", "po", "ほ + a small circle = 'po'.")
    )

    val katakanaDakuon = listOf(
        KanaChar("kd-ga", "ガ", "ga", "カ + two dots = voiced 'ga'."),
        KanaChar("kd-gi", "ギ", "gi", "キ + two dots = voiced 'gi'."),
        KanaChar("kd-gu", "グ", "gu", "ク + two dots = voiced 'gu'."),
        KanaChar("kd-ge", "ゲ", "ge", "ケ + two dots = voiced 'ge'."),
        KanaChar("kd-go", "ゴ", "go", "コ + two dots = voiced 'go'."),
        KanaChar("kd-za", "ザ", "za", "サ + two dots = voiced 'za'."),
        KanaChar("kd-ji", "ジ", "ji", "シ + two dots = voiced 'ji'."),
        KanaChar("kd-zu", "ズ", "zu", "ス + two dots = voiced 'zu'."),
        KanaChar("kd-ze", "ゼ", "ze", "セ + two dots = voiced 'ze'."),
        KanaChar("kd-zo", "ゾ", "zo", "ソ + two dots = voiced 'zo'."),
        KanaChar("kd-da", "ダ", "da", "タ + two dots = voiced 'da'."),
        KanaChar("kd-dji", "ヂ", "ji", "チ + two dots = 'ji'."),
        KanaChar("kd-dzu", "ヅ", "zu", "ツ + two dots = 'zu'."),
        KanaChar("kd-de", "デ", "de", "テ + two dots = voiced 'de'."),
        KanaChar("kd-do", "ド", "do", "ト + two dots = voiced 'do'."),
        KanaChar("kd-ba", "バ", "ba", "ハ + two dots = voiced 'ba'."),
        KanaChar("kd-bi", "ビ", "bi", "ヒ + two dots = voiced 'bi'."),
        KanaChar("kd-bu", "ブ", "bu", "フ + two dots = voiced 'bu'."),
        KanaChar("kd-be", "ベ", "be", "ヘ + two dots = voiced 'be'."),
        KanaChar("kd-bo", "ボ", "bo", "ホ + two dots = voiced 'bo'."),
        KanaChar("kd-pa", "パ", "pa", "ハ + a small circle = 'pa'."),
        KanaChar("kd-pi", "ピ", "pi", "ヒ + a small circle = 'pi'."),
        KanaChar("kd-pu", "プ", "pu", "フ + a small circle = 'pu'."),
        KanaChar("kd-pe", "ペ", "pe", "ヘ + a small circle = 'pe'."),
        KanaChar("kd-po", "ポ", "po", "ホ + a small circle = 'po'.")
    )

    val all: List<KanaChar> = hiragana + katakana + hiraganaDakuon + katakanaDakuon
    val allIds: Set<String> = all.map { it.id }.toSet()
}

object KanjiData {

    val kanji = listOf(
        KanjiChar("kj1", "日", "sun / day", "ニチ・ジツ", "ひ・か", "A box with a line through it — the sun shining through a window. 日 also means 'day'."),
        KanjiChar("kj2", "月", "moon / month", "ゲツ・ガツ", "つき", "The crescent moon shape. Two small strokes inside are the moon's shadow."),
        KanjiChar("kj3", "火", "fire", "カ", "ひ", "A person standing between two flames — fire rising on both sides."),
        KanjiChar("kj4", "水", "water", "スイ", "みず", "Four streams of running water, splashing off a surface."),
        KanjiChar("kj5", "木", "tree / wood", "モク・ボク", "き", "A tree: the vertical stroke is the trunk, branches spread above, roots below."),
        KanjiChar("kj6", "金", "gold / money", "キン・コン", "かね", "Gold nuggets ('八' below) under a lid ('人') in the ground — gold, hence money."),
        KanjiChar("kj7", "土", "soil / ground", "ド・ト", "つち", "A seed ('十') planted in the ground (the horizontal bar)."),
        KanjiChar("kj8", "山", "mountain", "サン", "やま", "Three mountain peaks side by side."),
        KanjiChar("kj9", "川", "river", "セン", "かわ", "Three flowing lines of a river — the middle one curves like a stream."),
        KanjiChar("kj10", "人", "person", "ジン・ニン", "ひと", "A person walking: two legs stepping forward."),
        KanjiChar("kj11", "口", "mouth", "コウ", "くち", "An open mouth — a simple square."),
        KanjiChar("kj12", "目", "eye", "モク", "め", "An upright eye: the two inner lines are the pupil lines."),
        KanjiChar("kj13", "耳", "ear", "ジ", "みみ", "An ear seen from the side: the box is the outer ear, the lines the inner fold."),
        KanjiChar("kj14", "手", "hand", "シュ", "て", "A hand from above: the horizontal strokes are fingers, the lower hook is the thumb."),
        KanjiChar("kj15", "足", "foot / leg", "ソク", "あし", "A foot on a leg: the '口' is the knee, the lower strokes the foot."),
        KanjiChar("kj16", "心", "heart", "シン", "こころ", "A stylized heart with three strokes showing its chambers."),
        KanjiChar("kj17", "大", "big", "ダイ・タイ", "おおきい", "A person ('人') stretching arms wide — big!"),
        KanjiChar("kj18", "小", "small", "ショウ", "ちいさい", "Three small strokes — little specks or a tiny tree."),
        KanjiChar("kj19", "中", "middle / inside", "チュウ", "なか", "A line passing through the middle of a box."),
        KanjiChar("kj20", "上", "up / above", "ジョウ", "うえ", "A short line above a baseline — pointing up."),
        KanjiChar("kj21", "下", "down / below", "カ・ゲ", "した", "A short line below a baseline — pointing down."),
        KanjiChar("kj22", "右", "right", "ウ・ユウ", "みぎ", "The right hand ('口') holding something to the mouth — the hand you eat with."),
        KanjiChar("kj23", "左", "left", "サ", "ひだり", "The left hand ('工') holding a tool to build — the hand you work with."),
        KanjiChar("kj24", "一", "one", "イチ", "ひと", "One stroke."),
        KanjiChar("kj25", "二", "two", "ニ", "ふた", "Two strokes."),
        KanjiChar("kj26", "三", "three", "サン", "みっ", "Three strokes."),
        KanjiChar("kj27", "四", "four", "シ", "よん", "A window with four panes."),
        KanjiChar("kj28", "五", "five", "ゴ", "いつ", "Four strokes meeting — the number five's outline."),
        KanjiChar("kj29", "六", "six", "ロク", "むっ", "A point on top and two legs — the number six."),
        KanjiChar("kj30", "七", "seven", "シチ", "なな", "A cross with a bent bottom stroke — like a seven."),
        KanjiChar("kj31", "八", "eight", "ハチ", "やっ", "Two pieces splitting apart — eight."),
        KanjiChar("kj32", "九", "nine", "キュウ", "ここの", "A curved hook — like a nine."),
        KanjiChar("kj33", "十", "ten", "ジュウ", "とお", "A cross — ten."),
        KanjiChar("kj34", "百", "hundred", "ヒャク", "", "One ('一') over 'white' ('白') — a hundred."),
        KanjiChar("kj35", "千", "thousand", "セン", "", "'Ten' ('十') with a slash — a thousand."),
        KanjiChar("kj36", "円", "yen / circle", "エン", "まる", "A circle with a mark inside — the yen symbol made into a character."),
        KanjiChar("kj37", "学", "study / learn", "ガク", "まなぶ", "A child ('子') under a roof, hands up to learn — school."),
        KanjiChar("kj38", "校", "school", "コウ", "", "'Tree' ('木') plus a cross — a school (study place)."),
        KanjiChar("kj39", "生", "life / birth", "セイ・ショウ", "いきる", "A plant growing up out of the ground — life."),
        KanjiChar("kj40", "時", "time / hour", "ジ", "とき", "The sun ('日') next to a temple ('寺') — time marked by the sun."),
        KanjiChar("kj41", "年", "year", "ネン", "とし", "Grain stalks being harvested — a year's cycle."),
        KanjiChar("kj42", "先", "ahead / teacher", "セン", "さき", "'Legs' ('儿') on the ground ahead — what comes before."),
        KanjiChar("kj43", "電", "electricity", "デン", "", "Rain ('雨') over a field with a line — electricity from rain."),
        KanjiChar("kj44", "車", "car / vehicle", "シャ", "くるま", "A car seen from above: body, wheels, and an axle."),
        KanjiChar("kj45", "町", "town", "チョウ", "まち", "A town: a road with small plots on both sides."),
        KanjiChar("kj46", "語", "language / word", "ゴ", "かたる", "Words ('言') with many mouths ('口') — language."),
        KanjiChar("kj47", "本", "book / origin", "ホン", "もと", "A tree with its root marked — the origin, hence a book.")
    )

    val all: List<KanjiChar> = kanji
    val allIds: Set<String> = all.map { it.id }.toSet()
}

object AlphabetData {

    val alphabet = listOf(
        AlphabetChar("A", "Apple", "🍎", "/ˈæpəl/", "アップル", "सेब"),
        AlphabetChar("B", "Ball", "⚽", "/bɔːl/", "ボール", "गेंद"),
        AlphabetChar("C", "Cat", "🐱", "/kæt/", "キャット", "बिल्ली"),
        AlphabetChar("D", "Dog", "🐶", "/dɒɡ/", "ドッグ", "कुत्ता"),
        AlphabetChar("E", "Egg", "🥚", "/ɛɡ/", "エッグ", "अंडा"),
        AlphabetChar("F", "Fish", "🐟", "/fɪʃ/", "フィッシュ", "मछली"),
        AlphabetChar("G", "Goat", "🐐", "/ɡoʊt/", "ゴート", "बकरी"),
        AlphabetChar("H", "Hat", "🎩", "/hæt/", "ハット", "टोपी"),
        AlphabetChar("I", "Ice", "🧊", "/aɪs/", "アイス", "बर्फ़"),
        AlphabetChar("J", "Juice", "🧃", "/dʒuːs/", "ジュース", "जूस"),
        AlphabetChar("K", "Key", "🔑", "/kiː/", "キー", "चाबी"),
        AlphabetChar("L", "Lion", "🦁", "/ˈlaɪən/", "ライオン", "शेर"),
        AlphabetChar("M", "Milk", "🥛", "/mɪlk/", "ミルク", "दूध"),
        AlphabetChar("N", "Nose", "👃", "/noʊz/", "ノーズ", "नाक"),
        AlphabetChar("O", "Orange", "🍊", "/ˈɒrɪndʒ/", "オレンジ", "संतरा"),
        AlphabetChar("P", "Pen", "🖊️", "/pɛn/", "ペン", "कलम"),
        AlphabetChar("Q", "Queen", "👑", "/kwiːn/", "クイーン", "रानी"),
        AlphabetChar("R", "Rabbit", "🐰", "/ˈræbɪt/", "ラビット", "खरगोश"),
        AlphabetChar("S", "Sun", "☀️", "/sʌn/", "サン", "सूरज"),
        AlphabetChar("T", "Tree", "🌳", "/triː/", "ツリー", "पेड़"),
        AlphabetChar("U", "Umbrella", "☂️", "/ʌmˈbrɛlə/", "アンブレラ", "छाता"),
        AlphabetChar("V", "Violin", "🎻", "/ˌvaɪəˈlɪn/", "バイオリン", "वायलिन"),
        AlphabetChar("W", "Water", "💧", "/ˈwɔːtər/", "ウォーター", "पानी"),
        AlphabetChar("X", "Xylophone", "🎶", "/ˈzaɪləfoʊn/", "ザイロフォン", "ज़ाइलोफ़ोन"),
        AlphabetChar("Y", "Yellow", "🟡", "/ˈjɛloʊ/", "イエロー", "पीला"),
        AlphabetChar("Z", "Zebra", "🦓", "/ˈzɛbrə/", "ゼブラ", "ज़ेबरा")
    )
}

object Data {

    val allLessons = listOf(
        Lesson(
            "greetings", "Greetings & Politeness", "🗣️", "The most important words first — say hello, thank, and ask politely.",
            listOf(
                Word("w1", "👋", "こんにちは", "konnichiwa", "", "hello", "/həˈloʊ/"),
                Word("w2", "🌅", "おはようございます", "ohayou gozaimasu", "", "good morning", "/ɡʊd ˈmɔːrnɪŋ/"),
                Word("w3", "🌙", "こんばんは", "konbanwa", "", "good evening", "/ɡʊd ˈiːvnɪŋ/"),
                Word("w4", "🫡", "さようなら", "sayounara", "", "goodbye", "/ˌɡʊdˈbaɪ/"),
                Word("w5", "🙏", "ありがとうございます", "arigatou gozaimasu", "", "thank you", "/ˈθæŋk juː/"),
                Word("w6", "😅", "すみません", "sumimasen", "", "excuse me / sorry", "/ɪkˈskjuːz miː/"),
                Word("w7", "✅", "はい", "hai", "", "yes", "/jɛs/"),
                Word("w8", "❌", "いいえ", "iie", "", "no", "/noʊ/"),
                Word("w9", "🥺", "おねがいします", "onegaishimasu", "", "please", "/pliːz/"),
                Word("w10", "🤝", "はじめまして", "hajimemashite", "", "nice to meet you", "/naɪs tə miːt juː/")
            )
        ),
        Lesson(
            "numbers", "Numbers 1-10", "🔢", "Count from one to ten — the building blocks of every conversation.",
            listOf(
                Word("w11", "1️⃣", "いち", "ichi", "", "one", "/wʌn/"),
                Word("w12", "2️⃣", "に", "ni", "", "two", "/tuː/"),
                Word("w13", "3️⃣", "さん", "san", "", "three", "/θriː/"),
                Word("w14", "4️⃣", "よん", "yon", "", "four", "/fɔːr/"),
                Word("w15", "5️⃣", "ご", "go", "", "five", "/faɪv/"),
                Word("w16", "6️⃣", "ろく", "roku", "", "six", "/sɪks/"),
                Word("w17", "7️⃣", "なな", "nana", "", "seven", "/ˈsɛvən/"),
                Word("w18", "8️⃣", "はち", "hachi", "", "eight", "/eɪt/"),
                Word("w19", "9️⃣", "きゅう", "kyuu", "", "nine", "/naɪn/"),
                Word("w20", "🔟", "じゅう", "juu", "", "ten", "/tɛn/")
            )
        ),
        Lesson(
            "colors", "Colors", "🌈", "Learn the colors by sight and sound — no translation needed.",
            listOf(
                Word("w21", "🔴", "あか", "aka", "赤", "red", "/rɛd/"),
                Word("w22", "🔵", "あお", "ao", "青", "blue", "/bluː/"),
                Word("w23", "🟢", "みどり", "midori", "緑", "green", "/ɡriːn/"),
                Word("w24", "🟡", "きいろ", "kiiro", "黄色", "yellow", "/ˈjɛloʊ/"),
                Word("w25", "⚫", "くろ", "kuro", "黒", "black", "/blæk/"),
                Word("w26", "⚪", "しろ", "shiro", "白", "white", "/waɪt/"),
                Word("w27", "🟠", "オレンジ", "orenji", "オレンジ", "orange", "/ˈɔːrɪndʒ/"),
                Word("w28", "🟣", "むらさき", "murasaki", "紫", "purple", "/ˈpɜːrpəl/"),
                Word("w29", "🌸", "ピンク", "pinku", "ピンク", "pink", "/pɪŋk/"),
                Word("w30", "🟤", "ちゃいろ", "chairo", "茶色", "brown", "/braʊn/")
            )
        ),
        Lesson(
            "family", "Family", "👨‍👩‍👧", "Talk about the people closest to you.",
            listOf(
                Word("w31", "👩", "おかあさん", "okaasan", "お母さん", "mother", "/ˈmʌðər/"),
                Word("w32", "👨", "おとうさん", "otousan", "お父さん", "father", "/ˈfɑːðər/"),
                Word("w33", "👧", "おねえさん", "oneesan", "お姉さん", "older sister", "/ˈoʊldər ˈsɪstər/"),
                Word("w34", "👦", "おにいさん", "oniisan", "お兄さん", "older brother", "/ˈoʊldər ˈbrʌðər/"),
                Word("w35", "🧒", "いもうと", "imouto", "妹", "younger sister", "/ˈjʌŋɡər ˈsɪstər/"),
                Word("w36", "👶", "おとうと", "otouto", "弟", "younger brother", "/ˈjʌŋɡər ˈbrʌðər/"),
                Word("w37", "👵", "おばあさん", "obaasan", "お祖母さん", "grandmother", "/ˈɡrænmʌðər/"),
                Word("w38", "👴", "おじいさん", "ojiisan", "お祖父さん", "grandfather", "/ˈɡrænfɑːðər/"),
                Word("w39", "👪", "かぞく", "kazoku", "家族", "family", "/ˈfæməli/"),
                Word("w40", "🧑‍🤝‍🧑", "ともだち", "tomodachi", "友達", "friend", "/frɛnd/")
            )
        ),
        Lesson(
            "food", "Food & Drink", "🍜", "Order food, buy groceries, and say 'delicious!'.",
            listOf(
                Word("w41", "🍚", "ごはん", "gohan", "ご飯", "rice / a meal", "/raɪs/"),
                Word("w42", "🍞", "パン", "pan", "パン", "bread", "/brɛd/"),
                Word("w43", "💧", "みず", "mizu", "水", "water", "/ˈwɔːtər/"),
                Word("w44", "🍵", "おちゃ", "ocha", "お茶", "tea", "/tiː/"),
                Word("w45", "🥛", "ぎゅうにゅう", "gyuunyuu", "牛乳", "milk", "/mɪlk/"),
                Word("w46", "🐟", "さかな", "sakana", "魚", "fish", "/fɪʃ/"),
                Word("w47", "🥩", "にく", "niku", "肉", "meat", "/miːt/"),
                Word("w48", "🥚", "たまご", "tamago", "卵", "egg", "/ɛɡ/"),
                Word("w49", "🍎", "りんご", "ringo", "林檎", "apple", "/ˈæpəl/"),
                Word("w50", "🍜", "ラーメン", "raamen", "ラーメン", "ramen", "/ˈrɑːmən/"),
                Word("w51", "🍣", "すし", "sushi", "寿司", "sushi", "/ˈsuːʃi/"),
                Word("w52", "😋", "おいしい", "oishii", "美味しい", "delicious", "/dɪˈlɪʃəs/")
            )
        ),
        Lesson(
            "animals", "Animals", "🐾", "Name the animals — great for pure picture-based learning.",
            listOf(
                Word("w53", "🐱", "ねこ", "neko", "猫", "cat", "/kæt/"),
                Word("w54", "🐶", "いぬ", "inu", "犬", "dog", "/dɔːɡ/"),
                Word("w55", "🐦", "とり", "tori", "鳥", "bird", "/bɜːrd/"),
                Word("w56", "🐴", "うま", "uma", "馬", "horse", "/hɔːrs/"),
                Word("w57", "🐮", "うし", "ushi", "牛", "cow", "/kaʊ/"),
                Word("w58", "🐷", "ぶた", "buta", "豚", "pig", "/pɪɡ/"),
                Word("w59", "🐰", "うさぎ", "usagi", "兎", "rabbit", "/ˈræbɪt/"),
                Word("w60", "🐻", "くま", "kuma", "熊", "bear", "/bɛər/"),
                Word("w61", "🐘", "ぞう", "zou", "象", "elephant", "/ˈɛlɪfənt/"),
                Word("w62", "🦁", "ライオン", "raion", "ライオン", "lion", "/ˈlaɪən/"),
                Word("w63", "🐵", "さる", "saru", "猿", "monkey", "/ˈmʌŋki/"),
                Word("w64", "🐢", "かめ", "kame", "亀", "turtle", "/ˈtɜːrtəl/")
            )
        ),
        Lesson(
            "actions", "Everyday Actions", "⚡", "The most frequent verbs — what you do all day long.",
            listOf(
                Word("w65", "🍽️", "たべる", "taberu", "食べる", "to eat", "/tə iːt/"),
                Word("w66", "🥤", "のむ", "nomu", "飲む", "to drink", "/tə drɪŋk/"),
                Word("w67", "➡️", "いく", "iku", "行く", "to go", "/tə ɡoʊ/"),
                Word("w68", "🏃", "くる", "kuru", "来る", "to come", "/tə kʌm/"),
                Word("w69", "👀", "みる", "miru", "見る", "to look / see", "/tə lʊk/"),
                Word("w70", "👂", "きく", "kiku", "聞く", "to listen / hear", "/tə ˈlɪsən/"),
                Word("w71", "🗣️", "はなす", "hanasu", "話す", "to speak", "/tə spiːk/"),
                Word("w72", "📖", "よむ", "yomu", "読む", "to read", "/tə riːd/"),
                Word("w73", "✍️", "かく", "kaku", "書く", "to write", "/tə raɪt/"),
                Word("w74", "🛒", "かう", "kau", "買う", "to buy", "/tə baɪ/"),
                Word("w75", "⚙️", "する", "suru", "する", "to do", "/tə duː/"),
                Word("w76", "😴", "ねる", "neru", "寝る", "to sleep", "/tə sliːp/")
            )
        ),
        Lesson(
            "adjectives", "Describing Things", "🌟", "Big, small, hot, cold — describe the world around you.",
            listOf(
                Word("w77", "🐘", "おおきい", "ookii", "大きい", "big", "/bɪɡ/"),
                Word("w78", "🐜", "ちいさい", "chiisai", "小さい", "small", "/smɔːl/"),
                Word("w79", "👍", "いい", "ii", "良い", "good", "/ɡʊd/"),
                Word("w80", "👎", "わるい", "warui", "悪い", "bad", "/bæd/"),
                Word("w81", "🆕", "あたらしい", "atarashii", "新しい", "new", "/nuː/"),
                Word("w82", "🕰️", "ふるい", "furui", "古い", "old", "/oʊld/"),
                Word("w83", "🔥", "あつい", "atsui", "暑い", "hot", "/hɑːt/"),
                Word("w84", "❄️", "つめたい", "tsumetai", "冷たい", "cold", "/koʊld/"),
                Word("w85", "🎉", "たのしい", "tanoshii", "楽しい", "fun", "/fʌn/"),
                Word("w86", "😱", "こわい", "kowai", "怖い", "scary", "/ˈskɛri/"),
                Word("w87", "🌸", "きれい", "kirei", "綺麗", "beautiful / pretty", "/ˈbjuːtɪfəl/"),
                Word("w88", "🥰", "かわいい", "kawaii", "可愛い", "cute", "/kjuːt/")
            )
        ),
        Lesson(
            "time", "Time & Days", "📅", "Today, tomorrow, morning and night — talk about when things happen.",
            listOf(
                Word("w89", "📆", "きょう", "kyou", "今日", "today", "/təˈdeɪ/"),
                Word("w90", "🌄", "あした", "ashita", "明日", "tomorrow", "/təˈmɑːroʊ/"),
                Word("w91", "🌆", "きのう", "kinou", "昨日", "yesterday", "/ˈjɛstərdeɪ/"),
                Word("w92", "⏰", "いま", "ima", "今", "now", "/naʊ/"),
                Word("w93", "🌅", "あさ", "asa", "朝", "morning", "/ˈmɔːrnɪŋ/"),
                Word("w94", "🌇", "ゆうがた", "yuugata", "夕方", "evening", "/ˈiːvnɪŋ/"),
                Word("w95", "🌃", "よる", "yoru", "夜", "night", "/naɪt/"),
                Word("w96", "🗓️", "しゅう", "shuu", "週", "week", "/wiːk/"),
                Word("w97", "🎆", "とし", "toshi", "年", "year", "/jɪər/"),
                Word("w98", "⏳", "じかん", "jikan", "時間", "time", "/taɪm/"),
                Word("w99", "🕐", "じ", "ji", "時", "o'clock / hour", "/ˈaʊər/"),
                Word("w100", "☀️", "ひ", "hi", "日", "day / sun", "/deɪ/")
            )
        ),
        Lesson(
            "places", "Places & Directions", "🗺️", "Where things are — and how to get there.",
            listOf(
                Word("w101", "🏠", "いえ", "ie", "家", "house / home", "/haʊs/"),
                Word("w102", "🏫", "がっこう", "gakkou", "学校", "school", "/skuːl/"),
                Word("w103", "🚉", "えき", "eki", "駅", "station", "/ˈsteɪʃən/"),
                Word("w104", "🏪", "みせ", "mise", "店", "shop / store", "/stɔːr/"),
                Word("w105", "🌳", "こうえん", "kouen", "公園", "park", "/pɑːrk/"),
                Word("w106", "🏙️", "まち", "machi", "街", "city / town", "/ˈsɪti/"),
                Word("w107", "🌊", "うみ", "umi", "海", "sea / ocean", "/siː/"),
                Word("w108", "⛰️", "やま", "yama", "山", "mountain", "/ˈmaʊntən/"),
                Word("w109", "⬆️", "うえ", "ue", "上", "up / above", "/ʌp/"),
                Word("w110", "⬇️", "した", "shita", "下", "down / below", "/daʊn/"),
                Word("w111", "⬅️", "ひだり", "hidari", "左", "left", "/lɛft/"),
                Word("w112", "➡️", "みぎ", "migi", "右", "right", "/raɪt/"),
                Word("w113", "📍", "ここ", "koko", "此処", "here", "/hɪər/"),
                Word("w114", "📍", "そこ", "soko", "其処", "there", "/ðɛər/")
            )
        ),
        Lesson(
            "nature", "Weather & Nature", "⛅", "Rain, snow, sun and stars — describe the world outside.",
            listOf(
                Word("w115", "🌧️", "あめ", "ame", "雨", "rain", "/reɪn/"),
                Word("w116", "❄️", "ゆき", "yuki", "雪", "snow", "/snoʊ/"),
                Word("w117", "💨", "かぜ", "kaze", "風", "wind", "/wɪnd/"),
                Word("w118", "☀️", "たいよう", "taiyou", "太陽", "sun", "/sʌn/"),
                Word("w119", "🌙", "つき", "tsuki", "月", "moon", "/muːn/"),
                Word("w120", "⭐", "ほし", "hoshi", "星", "star", "/stɑːr/"),
                Word("w121", "🌸", "はな", "hana", "花", "flower", "/ˈflaʊər/"),
                Word("w122", "🌳", "き", "ki", "木", "tree", "/triː/"),
                Word("w123", "🔥", "ひ", "hi", "火", "fire", "/ˈfaɪər/"),
                Word("w124", "☁️", "くも", "kumo", "雲", "cloud", "/klaʊd/"),
                Word("w125", "🌌", "そら", "sora", "空", "sky", "/skaɪ/")
            )
        ),
        Lesson(
            "conversation", "Survival Kit", "💬", "Real sentences you'll use on day one in Japan.",
            listOf(
                Word("w126", "🫂", "おげんきですか", "ogenki desu ka", "お元気ですか", "how are you?", "/haʊ ɑːr juː/"),
                Word("w127", "🙂", "げんきです", "genki desu", "元気です", "I'm fine", "/aɪm faɪn/"),
                Word("w128", "❓", "これはなんですか", "kore wa nan desu ka", "これは何ですか", "what is this?", "/wʌt ɪz ðɪs/"),
                Word("w129", "😵", "わかりません", "wakarimasen", "分かりません", "I don't understand", "/aɪ doʊnt ˌʌndərˈstænd/"),
                Word("w130", "🐢", "ゆっくりはなしてください", "yukkuri hanashite kudasai", "ゆっくり話してください", "please speak slowly", "/pliːz spiːk ˈsloʊli/"),
                Word("w131", "🚻", "トイレはどこですか", "toire wa doko desu ka", "トイレはどこですか", "where is the restroom?", "/wɛər ɪz ðə ˈbæθruːm/"),
                Word("w132", "💰", "いくらですか", "ikura desu ka", "いくらですか", "how much is this?", "/haʊ mʌtʃ ɪz ðɪs/"),
                Word("w133", "🤲", "～がほしいです", "ga hoshii desu", "～が欲しいです", "I want ~", "/aɪ wɑːnt/"),
                Word("w134", "🆘", "たすけて", "tasukete", "助けて", "help!", "/hɛlp/"),
                Word("w135", "📛", "わたしのなまえは…です", "watashi no namae wa … desu", "私の名前は…です", "my name is …", "/maɪ neɪm ɪz/")
            )
        ),
        Lesson(
            "intro", "Self-Introduction", "🧑‍🎓", "Genki Ch.1 — name, job, nationality and where you're from.",
            listOf(
                Word("w136", "🧑‍🏫", "せんせい", "sensei", "先生", "teacher", "", "शिक्षक"),
                Word("w137", "🎓", "がくせい", "gakusei", "学生", "student", "", "छात्र"),
                Word("w138", "💼", "かいしゃいん", "kaishain", "会社員", "company employee", "", "कंपनी कर्मचारी"),
                Word("w139", "🩺", "いしゃ", "isha", "医者", "doctor", "", "डॉक्टर"),
                Word("w140", "🇯🇵", "にほんじん", "nihonjin", "日本人", "Japanese person", "", "जापानी व्यक्ति"),
                Word("w141", "🗽", "あめりかじん", "amerikajin", "アメリカ人", "American person", "", "अमेरिकी व्यक्ति"),
                Word("w142", "📛", "なまえ", "namae", "名前", "name", "", "नाम"),
                Word("w143", "🧍", "ひと", "hito", "人", "person", "", "व्यक्ति"),
                Word("w144", "☎️", "でんわばんごう", "denwabangou", "電話番号", "phone number", "", "फ़ोन नंबर"),
                Word("w145", "📍", "しゅっしん", "shusshin", "出身", "hometown / from", "", "गृहस्थान"),
                Word("w146", "🗺️", "くに", "kuni", "国", "country", "", "देश")
            )
        ),
        Lesson(
            "routine", "Daily Routine", "⏰", "Genki Ch.4 — wake up, eat, go out, sleep: your whole day.",
            listOf(
                Word("w147", "⏰", "おきる", "okiru", "起きる", "to wake up", "", "जागना"),
                Word("w148", "🥣", "あさごはん", "asagohan", "朝ごはん", "breakfast", "", "नाश्ता"),
                Word("w149", "🪥", "はをみがく", "ha wo migaku", "歯を磨く", "to brush teeth", "", "दाँत साफ़ करना"),
                Word("w150", "🚿", "シャワーをあびる", "shawaa wo abiru", "シャワーを浴びる", "to take a shower", "", "स्नान करना"),
                Word("w151", "🚪", "でかける", "dekakeru", "出かける", "to go out", "", "बाहर जाना"),
                Word("w152", "🏠", "かえる", "kaeru", "帰る", "to return home", "", "लौटना"),
                Word("w153", "🍽️", "ばんごはん", "bangohan", "晩ごはん", "dinner", "", "रात का खाना"),
                Word("w154", "🛁", "おふろにはいる", "ofuro ni hairu", "お風呂に入る", "to take a bath", "", "नहाना"),
                Word("w155", "😴", "ねむる", "nemuru", "眠る", "to sleep", "", "सोना"),
                Word("w156", "🧹", "かじ", "kaji", "家事", "housework", "", "घर का काम"),
                Word("w157", "🧺", "せんたく", "sentaku", "洗濯", "laundry", "", "कपड़े धोना"),
                Word("w158", "👨‍🍳", "りょうり", "ryouri", "料理", "cooking", "", "खाना बनाना")
            )
        ),
        Lesson(
            "travel", "Travel & Transport", "✈️", "Genki Ch.7 — airports, trains, tickets and getting around.",
            listOf(
                Word("w159", "✈️", "くうこう", "kuukou", "空港", "airport", "", "हवाई अड्डा"),
                Word("w160", "✈️", "ひこうき", "hikouki", "飛行機", "airplane", "", "हवाई जहाज़"),
                Word("w161", "🚋", "でんしゃ", "densha", "電車", "train", "", "ट्रेन"),
                Word("w162", "🚌", "バス", "basu", "バス", "bus", "", "बस"),
                Word("w163", "🚕", "タクシー", "takushii", "タクシー", "taxi", "", "टैक्सी"),
                Word("w164", "🚲", "じてんしゃ", "jitensha", "自転車", "bicycle", "", "साइकिल"),
                Word("w165", "🎫", "きっぷ", "kippu", "切符", "ticket", "", "टिकट"),
                Word("w166", "🧳", "りょこう", "ryokou", "旅行", "travel / trip", "", "यात्रा"),
                Word("w167", "🗺️", "ちず", "chizu", "地図", "map", "", "नक्शा"),
                Word("w168", "🙈", "まいご", "maigo", "迷子", "to get lost", "", "खो जाना"),
                Word("w169", "🚄", "しんかんせん", "shinkansen", "新幹線", "bullet train", "", "बुलेट ट्रेन"),
                Word("w170", "⚓", "みなと", "minato", "港", "port / harbor", "", "बंदरगाह")
            )
        ),
        Lesson(
            "shopping", "Shopping", "🛍️", "Genki Ch.6 — prices, cheap and expensive, buying things.",
            listOf(
                Word("w171", "💸", "たかい", "takai", "高い", "expensive", "", "महँगा"),
                Word("w172", "🏷️", "やすい", "yasui", "安い", "cheap", "", "सस्ता"),
                Word("w173", "👛", "さいふ", "saifu", "財布", "wallet", "", "बटुआ"),
                Word("w174", "👜", "かばん", "kaban", "鞄", "bag", "", "बैग"),
                Word("w175", "💰", "おかね", "okane", "お金", "money", "", "पैसा"),
                Word("w176", "💴", "えん", "en", "円", "yen", "", "येन"),
                Word("w177", "🎁", "おみやげ", "omiyage", "お土産", "souvenir", "", "स्मृति चिन्ह"),
                Word("w178", "🪙", "おつり", "otsuri", "お釣り", "change (money)", "", "खुले पैसे"),
                Word("w179", "🏷️", "ねだん", "nedan", "値段", "price", "", "कीमत"),
                Word("w180", "🛒", "かいもの", "kaimono", "買い物", "shopping", "", "खरीदारी"),
                Word("w181", "🪞", "しちゃく", "shichaku", "試着", "trying on clothes", "", "पहनकर देखना"),
                Word("w182", "🧾", "レシート", "reshiito", "レシート", "receipt", "", "रसीद")
            )
        ),
        Lesson(
            "restaurant", "At a Restaurant", "🍱", "Genki Ch.6 — order, eat, and ask for the bill.",
            listOf(
                Word("w183", "📋", "メニュー", "menyuu", "メニュー", "menu", "", "मेन्यू"),
                Word("w184", "⭐", "おすすめ", "osusume", "おすすめ", "recommendation", "", "सिफ़ारिश"),
                Word("w185", "🗣️", "ちゅうもん", "chuumon", "注文", "order (noun)", "", "ऑर्डर"),
                Word("w186", "🍽️", "おさら", "osara", "お皿", "plate", "", "थाली"),
                Word("w187", "🥢", "はし", "hashi", "箸", "chopsticks", "", "चॉपस्टिक"),
                Word("w188", "🥄", "スプーン", "supuun", "スプーン", "spoon", "", "चम्मच"),
                Word("w189", "🍴", "フォーク", "fooku", "フォーク", "fork", "", "काँटा"),
                Word("w190", "🔪", "ナイフ", "naifu", "ナイフ", "knife", "", "चाकू"),
                Word("w191", "🍰", "デザート", "dezaato", "デザート", "dessert", "", "मिठाई"),
                Word("w192", "🧾", "かいけい", "kaikei", "会計", "bill / check", "", "बिल"),
                Word("w193", "🥤", "のみもの", "nomimono", "飲み物", "drink", "", "पेय"),
                Word("w194", "🍱", "たべもの", "tabemono", "食べ物", "food", "", "खाना")
            )
        ),
        Lesson(
            "hobbies", "Hobbies & Sports", "🎯", "Genki Ch.5 — music, sports, photos and free time.",
            listOf(
                Word("w195", "🎵", "おんがく", "ongaku", "音楽", "music", "", "संगीत"),
                Word("w196", "🎤", "うたう", "utau", "歌う", "to sing", "", "गाना"),
                Word("w197", "🏆", "スポーツ", "supootsu", "スポーツ", "sports", "", "खेल"),
                Word("w198", "⚽", "サッカー", "sakkaa", "サッカー", "soccer", "", "फ़ुटबॉल"),
                Word("w199", "🎾", "テニス", "tenisu", "テニス", "tennis", "", "टेनिस"),
                Word("w200", "🏊", "すいえい", "suiei", "水泳", "swimming", "", "तैराकी"),
                Word("w201", "🚶", "さんぽ", "sanpo", "散歩", "walk / stroll", "", "सैर"),
                Word("w202", "📸", "しゃしんをとる", "shashin wo toru", "写真を撮る", "to take photos", "", "फ़ोटो लेना"),
                Word("w203", "🎨", "えをかく", "e wo kaku", "絵を描く", "to draw", "", "चित्र बनाना"),
                Word("w204", "🎬", "えいが", "eiga", "映画", "movie", "", "फ़िल्म"),
                Word("w205", "📖", "ほんをよむ", "hon wo yomu", "本を読む", "to read books", "", "किताब पढ़ना"),
                Word("w206", "💃", "ダンス", "dansu", "ダンス", "dance", "", "नृत्य")
            )
        ),
        Lesson(
            "home", "Home & Rooms", "🏠", "Genki Ch.3 — rooms, furniture and everyday things at home.",
            listOf(
                Word("w207", "🚪", "へや", "heya", "部屋", "room", "", "कमरा"),
                Word("w208", "🍳", "だいどころ", "daidokoro", "台所", "kitchen", "", "रसोई"),
                Word("w209", "🛏️", "ベッド", "beddo", "ベッド", "bed", "", "बिस्तर"),
                Word("w210", "🪟", "まど", "mado", "窓", "window", "", "खिड़की"),
                Word("w211", "🚪", "ドア", "doa", "ドア", "door", "", "दरवाज़ा"),
                Word("w212", "🪑", "いす", "isu", "椅子", "chair", "", "कुर्सी"),
                Word("w213", "🗄️", "つくえ", "tsukue", "机", "desk", "", "डेस्क / मेज़"),
                Word("w214", "📚", "ほんだな", "hondana", "本棚", "bookshelf", "", "किताबों की अलमारी"),
                Word("w215", "💡", "でんき", "denki", "電気", "light / electricity", "", "रोशनी / बिजली"),
                Word("w216", "🛋️", "ソファ", "sofa", "ソファ", "sofa", "", "सोफ़ा"),
                Word("w217", "🔑", "かぎ", "kagi", "鍵", "key", "", "चाबी"),
                Word("w218", "🛁", "おふろ", "ofuro", "お風呂", "bath / bathtub", "", "स्नानघर")
            )
        ),
        Lesson(
            "body", "Body Parts", "🫀", "Genki vocabulary — head to toe, the parts of your body.",
            listOf(
                Word("w219", "🧠", "あたま", "atama", "頭", "head", "", "सिर"),
                Word("w220", "😊", "かお", "kao", "顔", "face", "", "चेहरा"),
                Word("w221", "👀", "め", "me", "目", "eye", "", "आँख"),
                Word("w222", "👂", "みみ", "mimi", "耳", "ear", "", "कान"),
                Word("w223", "👃", "はな", "hana", "鼻", "nose", "", "नाक"),
                Word("w224", "👄", "くち", "kuchi", "口", "mouth", "", "मुँह"),
                Word("w225", "✋", "て", "te", "手", "hand", "", "हाथ"),
                Word("w226", "🦶", "あし", "ashi", "足", "leg / foot", "", "पैर"),
                Word("w227", "🧍", "からだ", "karada", "体", "body", "", "शरीर"),
                Word("w228", "🍽️", "おなか", "onaka", "お腹", "stomach / belly", "", "पेट"),
                Word("w229", "🗣️", "のど", "nodo", "喉", "throat", "", "गला"),
                Word("w230", "💇", "かみ", "kami", "髪", "hair", "", "बाल")
            )
        ),
        Lesson(
            "city", "City Places", "🏙️", "Genki Ch.3 — hospital, bank, library and finding your way.",
            listOf(
                Word("w231", "🏥", "びょういん", "byouin", "病院", "hospital", "", "अस्पताल"),
                Word("w232", "📮", "ゆうびんきょく", "yuubinkyoku", "郵便局", "post office", "", "डाकघर"),
                Word("w233", "🚔", "こうばん", "kouban", "交番", "police box", "", "पुलिस चौकी"),
                Word("w234", "🏦", "ぎんこう", "ginkou", "銀行", "bank", "", "बैंक"),
                Word("w235", "📚", "としょかん", "toshokan", "図書館", "library", "", "पुस्तकालय"),
                Word("w236", "🏨", "ホテル", "hoteru", "ホテル", "hotel", "", "होटल"),
                Word("w237", "🍽️", "レストラン", "resutoran", "レストラン", "restaurant", "", "रेस्तराँ"),
                Word("w238", "🏬", "デパート", "depaato", "デパート", "department store", "", "डिपार्टमेंट स्टोर"),
                Word("w239", "🛒", "スーパー", "suupaa", "スーパー", "supermarket", "", "सुपरमार्केट"),
                Word("w240", "🎬", "えいがかん", "eigakan", "映画館", "movie theater", "", "सिनेमाघर"),
                Word("w241", "☕", "きっさてん", "kissaten", "喫茶店", "cafe", "", "कैफ़े"),
                Word("w242", "⛩️", "じんじゃ", "jinja", "神社", "shrine", "", "शिंटो मंदिर")
            )
        ),
        Lesson(
            "dates", "Time & Days", "📆", "Genki Ch.2 — today, tomorrow, yesterday and every weekday.",
            listOf(
                Word("w243", "📅", "きょう", "kyou", "今日", "today", "", "आज"),
                Word("w244", "🌅", "あした", "ashita", "明日", "tomorrow", "", "कल"),
                Word("w245", "⏪", "きのう", "kinou", "昨日", "yesterday", "", "बीता कल"),
                Word("w246", "🌄", "あさって", "asatte", "明後日", "day after tomorrow", "", "परसों"),
                Word("w247", "🗓️", "しゅうまつ", "shuumatsu", "週末", "weekend", "", "सप्ताहांत"),
                Word("w248", "🗓️", "げつようび", "getsuyoubi", "月曜日", "Monday", "", "सोमवार"),
                Word("w249", "🗓️", "かようび", "kayoubi", "火曜日", "Tuesday", "", "मंगलवार"),
                Word("w250", "🗓️", "すいようび", "suiyoubi", "水曜日", "Wednesday", "", "बुधवार"),
                Word("w251", "🗓️", "もくようび", "mokuyoubi", "木曜日", "Thursday", "", "गुरुवार"),
                Word("w252", "🗓️", "きんようび", "kinyoubi", "金曜日", "Friday", "", "शुक्रवार"),
                Word("w253", "🗓️", "どようび", "doyoubi", "土曜日", "Saturday", "", "शनिवार"),
                Word("w254", "🗓️", "にちようび", "nichiyoubi", "日曜日", "Sunday", "", "रविवार")
            )
        ),
        Lesson(
            "feelings", "Feelings & States", "💗", "Genki Ch.5 — how you feel: happy, tired, hungry, busy.",
            listOf(
                Word("w255", "😄", "うれしい", "ureshii", "嬉しい", "happy", "", "खुश"),
                Word("w256", "😢", "かなしい", "kanashii", "悲しい", "sad", "", "उदास"),
                Word("w257", "🥱", "つかれている", "tsukareteiru", "疲れている", "tired", "", "थका हुआ"),
                Word("w258", "🍽️", "おなかがすいている", "onaka ga suiteiru", "お腹がすいている", "hungry", "", "भूखा"),
                Word("w259", "💧", "のどがかわいている", "nodo ga kawaiteiru", "喉が渇いている", "thirsty", "", "प्यासा"),
                Word("w260", "😴", "ねむい", "nemui", "眠い", "sleepy", "", "नींद में"),
                Word("w261", "🤒", "びょうき", "byouki", "病気", "sick", "", "बीमार"),
                Word("w262", "😣", "いたい", "itai", "痛い", "painful / hurts", "", "दर्द"),
                Word("w263", "🥱", "つまらない", "tsumaranai", "つまらない", "boring", "", "उबाऊ"),
                Word("w264", "🤩", "おもしろい", "omoshiroi", "面白い", "interesting / funny", "", "दिलचस्प"),
                Word("w265", "⏰", "いそがしい", "isogashii", "忙しい", "busy", "", "व्यस्त"),
                Word("w266", "💪", "げんき", "genki", "元気", "energetic / well", "", "तंदुरुस्त")
            )
        ),
        Lesson(
            "work", "Work & Study", "💼", "Genki vocabulary — jobs, meetings, homework and classrooms.",
            listOf(
                Word("w267", "💼", "はたらく", "hataraku", "働く", "to work", "", "काम करना"),
                Word("w268", "📚", "べんきょうする", "benkyou suru", "勉強する", "to study", "", "पढ़ाई करना"),
                Word("w269", "🗣️", "かいぎ", "kaigi", "会議", "meeting", "", "बैठक"),
                Word("w270", "📖", "じしょ", "jisho", "辞書", "dictionary", "", "शब्दकोश"),
                Word("w271", "📘", "きょうかしょ", "kyoukasho", "教科書", "textbook", "", "पाठ्यपुस्तक"),
                Word("w272", "🏫", "じゅぎょう", "jugyou", "授業", "class / lesson", "", "कक्षा"),
                Word("w273", "📝", "しゅくだい", "shukudai", "宿題", "homework", "", "होमवर्क"),
                Word("w274", "📋", "テスト", "tesuto", "テスト", "test", "", "परीक्षा"),
                Word("w275", "🔤", "えいご", "eigo", "英語", "English (language)", "", "अंग्रेज़ी"),
                Word("w276", "🈯", "にほんご", "nihongo", "日本語", "Japanese (language)", "", "जापानी भाषा"),
                Word("w277", "💡", "いみ", "imi", "意味", "meaning", "", "अर्थ"),
                Word("w278", "❓", "しつもん", "shitsumon", "質問", "question", "", "प्रश्न")
            )
        ),
        Lesson(
            "en-greet", "English Greetings", "👋", "ESL starter — say hello, thank people and say goodbye.",
            listOf(
                Word("w279", "👋", "ハロー", "haroo", "", "hello", "/həˈloʊ/", "नमस्ते"),
                Word("w280", "😊", "ハイ", "hai", "", "hi", "/haɪ/", "नमस्ते"),
                Word("w281", "🌅", "グッドモーニング", "guddomooningu", "", "good morning", "/ɡʊd ˈmɔːrnɪŋ/", "शुभ प्रभात"),
                Word("w282", "🌇", "グッドアフタヌーン", "guddoafutanuun", "", "good afternoon", "/ɡʊd ˌæftərˈnuːn/", "शुभ दोपहर"),
                Word("w283", "🌆", "グッドイブニング", "guddoibuningu", "", "good evening", "/ɡʊd ˈiːvnɪŋ/", "शुभ संध्या"),
                Word("w284", "🌙", "グッドナイト", "guddonaito", "", "good night", "/ɡʊd naɪt/", "शुभ रात्रि"),
                Word("w285", "🤗", "ウェルカム", "werukamu", "", "welcome", "/ˈwɛlkəm/", "स्वागत है"),
                Word("w286", "🫂", "ハウアーユー", "hauaa yuu", "", "how are you?", "/haʊ ɑːr juː/", "आप कैसे हैं?"),
                Word("w287", "🙂", "アイムファイン", "aimu fain", "", "I'm fine", "/aɪm faɪn/", "मैं ठीक हूँ"),
                Word("w288", "🙏", "サンキュー", "sankyuu", "", "thank you", "/θæŋk juː/", "धन्यवाद"),
                Word("w289", "👋", "バイ", "bai", "", "bye", "/baɪ/", "अलविदा"),
                Word("w290", "👋", "シーユーレイター", "shii yuu reitaa", "", "see you later", "/siː juː ˈleɪtər/", "फिर मिलेंगे")
            ),
            lang = "en"
        ),
        Lesson(
            "en-num", "English Numbers", "🔢", "ESL numbers — eleven to a million, plus ordinals.",
            listOf(
                Word("w291", "1️⃣1️⃣", "イレブン", "irebun", "", "eleven", "/ɪˈlɛvən/", "ग्यारह"),
                Word("w292", "1️⃣2️⃣", "トゥエルブ", "tuerubu", "", "twelve", "/twɛlv/", "बारह"),
                Word("w293", "1️⃣3️⃣", "サーティーン", "saatiin", "", "thirteen", "/ˌθɜːrˈtiːn/", "तेरह"),
                Word("w294", "2️⃣0️⃣", "トゥエンティ", "tuenti", "", "twenty", "/ˈtwɛnti/", "बीस"),
                Word("w295", "3️⃣0️⃣", "サーティ", "saati", "", "thirty", "/ˈθɜːrti/", "तीस"),
                Word("w296", "💯", "ハンドレッド", "handoreddo", "", "hundred", "/ˈhʌndrəd/", "सौ"),
                Word("w297", "🔟", "サウザンド", "sauzando", "", "thousand", "/ˈθaʊzənd/", "हज़ार"),
                Word("w298", "💹", "ミリオン", "mirion", "", "million", "/ˈmɪljən/", "दस लाख"),
                Word("w299", "0️⃣", "ジロウ", "jirou", "", "zero", "/ˈzɪəroʊ/", "शून्य"),
                Word("w300", "🥇", "ファースト", "faasuto", "", "first", "/fɜːrst/", "पहला"),
                Word("w301", "🥈", "セカンド", "sekando", "", "second", "/ˈsɛkənd/", "दूसरा"),
                Word("w302", "🏁", "ラスト", "rasuto", "", "last", "/læst/", "आख़िरी")
            ),
            lang = "en"
        ),
        Lesson(
            "en-time", "English Time & Days", "⏰", "ESL time — morning, night, today, tomorrow, this week.",
            listOf(
                Word("w303", "🌅", "モーニング", "mooningu", "", "morning", "/ˈmɔːrnɪŋ/", "सुबह"),
                Word("w304", "🌇", "アフタヌーン", "afutanuun", "", "afternoon", "/ˌæftərˈnuːn/", "दोपहर"),
                Word("w305", "🌆", "イブニング", "ibuningu", "", "evening", "/ˈiːvnɪŋ/", "शाम"),
                Word("w306", "🌙", "ナイト", "naito", "", "night", "/naɪt/", "रात"),
                Word("w307", "📅", "トゥデイ", "tudei", "", "today", "/təˈdeɪ/", "आज"),
                Word("w308", "🌅", "トゥモロー", "tumorou", "", "tomorrow", "/təˈmɔːroʊ/", "कल"),
                Word("w309", "⏪", "イエスタデイ", "iesutadei", "", "yesterday", "/ˈjɛstərdeɪ/", "बीता कल"),
                Word("w310", "🗓️", "ウィーク", "wiiku", "", "week", "/wiːk/", "सप्ताह"),
                Word("w311", "📆", "マンス", "mansu", "", "month", "/mʌnθ/", "महीना"),
                Word("w312", "🗓️", "イヤー", "iyaa", "", "year", "/jɪər/", "साल"),
                Word("w313", "⏰", "アワー", "awaa", "", "hour", "/ˈaʊər/", "घंटा"),
                Word("w314", "⏱️", "ミニット", "minitto", "", "minute", "/ˈmɪnɪt/", "मिनट")
            ),
            lang = "en"
        ),
        Lesson(
            "en-family", "English Family", "👨‍👩‍👧", "ESL family — mother, father, brothers, sisters and more.",
            listOf(
                Word("w315", "👩", "マザー", "mazaa", "", "mother", "/ˈmʌðər/", "माँ"),
                Word("w316", "👨", "ファーザー", "faa zaa", "", "father", "/ˈfɑːðər/", "पिता"),
                Word("w317", "👦", "ブラザー", "burazaa", "", "brother", "/ˈbrʌðər/", "भाई"),
                Word("w318", "👧", "シスター", "shisutaa", "", "sister", "/ˈsɪstər/", "बहन"),
                Word("w319", "👦", "サン", "san", "", "son", "/sʌn/", "बेटा"),
                Word("w320", "👧", "ドーター", "dootaa", "", "daughter", "/ˈdɔːtər/", "बेटी"),
                Word("w321", "👵", "グランドマザー", "gurandomazaa", "", "grandmother", "/ˈɡrænmʌðər/", "दादी / नानी"),
                Word("w322", "👴", "グランドファーザー", "gurandofaa zaa", "", "grandfather", "/ˈɡrænfɑːðər/", "दादा / नाना"),
                Word("w323", "👨", "ハズバンド", "hazubando", "", "husband", "/ˈhʌzbənd/", "पति"),
                Word("w324", "👩", "ワイフ", "waifu", "", "wife", "/waɪf/", "पत्नी"),
                Word("w325", "👨", "アンクル", "ankuru", "", "uncle", "/ˈʌŋkəl/", "चाचा"),
                Word("w326", "👩", "アント", "anto", "", "aunt", "/ænt/", "चाची")
            ),
            lang = "en"
        ),
        Lesson(
            "en-food", "English Food & Drink", "🍜", "ESL food — the kitchen basics everyone needs.",
            listOf(
                Word("w327", "🍞", "ブレッド", "bureddo", "", "bread", "/brɛd/", "रोटी / ब्रेड"),
                Word("w328", "🍚", "ライス", "raisu", "", "rice", "/raɪs/", "चावल"),
                Word("w329", "🍗", "チキン", "chikin", "", "chicken", "/ˈtʃɪkɪn/", "मुर्ग़ा / चिकन"),
                Word("w330", "🥚", "エッグ", "eggu", "", "egg", "/ɛɡ/", "अंडा"),
                Word("w331", "🥛", "ミルク", "miruku", "", "milk", "/mɪlk/", "दूध"),
                Word("w332", "🍵", "ティー", "tii", "", "tea", "/tiː/", "चाय"),
                Word("w333", "☕", "コーヒー", "koohii", "", "coffee", "/ˈkɒfi/", "कॉफ़ी"),
                Word("w334", "🧃", "ジュース", "juusu", "", "juice", "/dʒuːs/", "जूस"),
                Word("w335", "🍎", "フルーツ", "furuutsu", "", "fruit", "/fruːt/", "फल"),
                Word("w336", "🥦", "ベジタブル", "bejitaburu", "", "vegetable", "/ˈvɛdʒtəbəl/", "सब्ज़ी"),
                Word("w337", "🍬", "シュガー", "shugaa", "", "sugar", "/ˈʃʊɡər/", "चीनी"),
                Word("w338", "🧂", "ソルト", "soruto", "", "salt", "/sɔːlt/", "नमक")
            ),
            lang = "en"
        ),
        Lesson(
            "en-body", "English Body Parts", "🫀", "ESL body — the parts of your body in English.",
            listOf(
                Word("w339", "🧠", "ヘッド", "heddo", "", "head", "/hɛd/", "सिर"),
                Word("w340", "😊", "フェイス", "feisu", "", "face", "/feɪs/", "चेहरा"),
                Word("w341", "💇", "ヘア", "hea", "", "hair", "/hɛər/", "बाल"),
                Word("w342", "👀", "アイ", "ai", "", "eye", "/aɪ/", "आँख"),
                Word("w343", "👂", "イアー", "iaa", "", "ear", "/ɪər/", "कान"),
                Word("w344", "👃", "ノーズ", "noozu", "", "nose", "/noʊz/", "नाक"),
                Word("w345", "👄", "マウス", "mausu", "", "mouth", "/maʊθ/", "मुँह"),
                Word("w346", "✋", "ハンド", "hando", "", "hand", "/hænd/", "हाथ"),
                Word("w347", "💪", "アーム", "aamu", "", "arm", "/ɑːrm/", "बाँह"),
                Word("w348", "🦵", "レッグ", "reggu", "", "leg", "/lɛɡ/", "टाँग"),
                Word("w349", "🦶", "フット", "futto", "", "foot", "/fʊt/", "पैर"),
                Word("w350", "🧍", "バック", "bakku", "", "back", "/bæk/", "पीठ")
            ),
            lang = "en"
        ),
        Lesson(
            "en-clothes", "English Clothes", "👕", "ESL clothes — shirts, shoes, coats and what you wear.",
            listOf(
                Word("w351", "👕", "シャート", "shaato", "", "shirt", "/ʃɜːrt/", "कमीज़"),
                Word("w352", "👖", "トラウザーズ", "tora uzaazu", "", "trousers", "/ˈtraʊzərz/", "पतलून"),
                Word("w353", "🩳", "ショーツ", "shootsu", "", "shorts", "/ʃɔːrts/", "शॉर्ट्स"),
                Word("w354", "👗", "ドレス", "doresu", "", "dress", "/drɛs/", "पोशाक"),
                Word("w355", "👗", "スカート", "sukaato", "", "skirt", "/skɜːrt/", "स्कर्ट"),
                Word("w356", "👟", "シューズ", "shuuzu", "", "shoes", "/ʃuːz/", "जूते"),
                Word("w357", "🧦", "ソックス", "sokkusu", "", "socks", "/sɒks/", "मोज़े"),
                Word("w358", "🎩", "ハット", "hatto", "", "hat", "/hæt/", "टोपी"),
                Word("w359", "🧥", "コート", "kooto", "", "coat", "/koʊt/", "कोट"),
                Word("w360", "🧥", "ジャケット", "jaketto", "", "jacket", "/ˈdʒækɪt/", "जैकेट"),
                Word("w361", "🧣", "スカーフ", "sukaafu", "", "scarf", "/skɑːrf/", "दुपट्टा"),
                Word("w362", "🧤", "グラブズ", "gurabuzu", "", "gloves", "/ɡlʌvz/", "दस्ताने")
            ),
            lang = "en"
        ),
        Lesson(
            "en-house", "English House & Things", "🏠", "ESL house — rooms, furniture and daily objects.",
            listOf(
                Word("w363", "🏠", "ハウス", "hausu", "", "house", "/haʊs/", "घर"),
                Word("w364", "🍳", "キッチン", "kitchin", "", "kitchen", "/ˈkɪtʃɪn/", "रसोई"),
                Word("w365", "🛏️", "ベッドルーム", "beddoruumu", "", "bedroom", "/ˈbɛdruːm/", "शयनकक्ष"),
                Word("w366", "🛁", "バスルーム", "basuruumu", "", "bathroom", "/ˈbæθruːm/", "स्नानघर"),
                Word("w367", "🪑", "テーブル", "teeburu", "", "table", "/ˈteɪbəl/", "मेज़"),
                Word("w368", "🪑", "チェアー", "cheaa", "", "chair", "/tʃɛər/", "कुर्सी"),
                Word("w369", "🪟", "ウィンドウ", "windou", "", "window", "/ˈwɪndoʊ/", "खिड़की"),
                Word("w370", "🚪", "ドア", "doa", "", "door", "/dɔːr/", "दरवाज़ा"),
                Word("w371", "🪞", "ミラー", "miraa", "", "mirror", "/ˈmɪrər/", "आईना"),
                Word("w372", "💡", "ランプ", "ranpu", "", "lamp", "/læmp/", "लैंप"),
                Word("w373", "🕰️", "クロック", "kurokku", "", "clock", "/klɒk/", "घड़ी"),
                Word("w374", "📱", "フォーン", "foon", "", "phone", "/foʊn/", "फ़ोन")
            ),
            lang = "en"
        ),
        Lesson(
            "en-work", "English Jobs", "👷", "ESL jobs — doctor, teacher, driver and what people do.",
            listOf(
                Word("w375", "🧑‍⚕️", "ナース", "naasu", "", "nurse", "/nɜːrs/", "नर्स"),
                Word("w376", "🧑‍🔧", "エンジニア", "enjinia", "", "engineer", "/ˌɛndʒɪˈnɪər/", "इंजीनियर"),
                Word("w377", "🚗", "ドライバー", "doraibaa", "", "driver", "/ˈdraɪvər/", "चालक"),
                Word("w378", "👨‍🍳", "クック", "kukku", "", "cook", "/kʊk/", "रसोइया"),
                Word("w379", "👮", "ポリスオフィサー", "porisu ofisaa", "", "police officer", "/pəˈliːs ˈɒfɪsər/", "पुलिस अधिकारी"),
                Word("w380", "🏪", "ショップキーパー", "shoppukii paa", "", "shopkeeper", "/ˈʃɒpkiːpər/", "दुकानदार"),
                Word("w381", "👨‍🌾", "ファーマー", "faamaa", "", "farmer", "/ˈfɑːrmər/", "किसान"),
                Word("w382", "🧑‍🍳", "ウェイター", "weitaa", "", "waiter", "/ˈweɪtər/", "वेटर"),
                Word("w383", "🎨", "アーティスト", "aatisuto", "", "artist", "/ˈɑːrtɪst/", "कलाकार"),
                Word("w384", "🎤", "シンガー", "shingaa", "", "singer", "/ˈsɪŋər/", "गायक"),
                Word("w385", "✈️", "パイロット", "pairotto", "", "pilot", "/ˈpaɪlət/", "पायलट"),
                Word("w386", "⚖️", "ロイヤー", "roiyaa", "", "lawyer", "/ˈlɔːjər/", "वकील")
            ),
            lang = "en"
        ),
        Lesson(
            "en-actions", "English Verbs", "🏃", "ESL verbs — the most-used actions in daily life.",
            listOf(
                Word("w387", "🚶", "カム", "kamu", "", "come", "/kʌm/", "आना"),
                Word("w388", "🚶", "ウォーク", "wooku", "", "walk", "/wɔːk/", "चलना"),
                Word("w389", "🏃", "ラン", "ran", "", "run", "/rʌn/", "दौड़ना"),
                Word("w390", "🪑", "シット", "shitto", "", "sit", "/sɪt/", "बैठना"),
                Word("w391", "🧍", "スタンド", "sutando", "", "stand", "/stænd/", "खड़ा होना"),
                Word("w392", "🚪", "オープン", "oopun", "", "open", "/ˈoʊpən/", "खोलना"),
                Word("w393", "🚪", "クローズ", "kuroozu", "", "close", "/kloʊz/", "बंद करना"),
                Word("w394", "🤲", "ギブ", "gibu", "", "give", "/ɡɪv/", "देना"),
                Word("w395", "🤏", "テイク", "teiku", "", "take", "/teɪk/", "लेना"),
                Word("w396", "👀", "シー", "shii", "", "see", "/siː/", "देखना"),
                Word("w397", "🧠", "ノウ", "nou", "", "know", "/noʊ/", "जानना"),
                Word("w398", "💭", "シンク", "shinku", "", "think", "/θɪŋk/", "सोचना"),
                Word("w399", "🙋", "ウォント", "wonto", "", "want", "/wɒnt/", "चाहना"),
                Word("w400", "⚠️", "ニード", "niido", "", "need", "/niːd/", "ज़रूरत होना"),
                Word("w401", "❤️", "ライク", "raiku", "", "like", "/laɪk/", "पसंद करना"),
                Word("w402", "🆘", "ヘルプ", "herupu", "", "help", "/hɛlp/", "मदद करना")
            ),
            lang = "en"
        ),
        Lesson(
            "en-shop", "English Shopping", "🛒", "ESL shopping — buy, sell, pay, prices and shops.",
            listOf(
                Word("w403", "🛒", "バイ", "bai", "", "buy", "/baɪ/", "खरीदना"),
                Word("w404", "🏪", "セル", "seru", "", "sell", "/sɛl/", "बेचना"),
                Word("w405", "💳", "ペイ", "pei", "", "pay", "/peɪ/", "भुगतान करना"),
                Word("w406", "💰", "マネー", "manee", "", "money", "/ˈmʌni/", "पैसा"),
                Word("w407", "🏷️", "プライス", "puraisu", "", "price", "/praɪs/", "कीमत"),
                Word("w408", "💸", "チープ", "chiipu", "", "cheap", "/tʃiːp/", "सस्ता"),
                Word("w409", "💎", "エクスペンシブ", "ekusupenshibu", "", "expensive", "/ɪkˈspɛnsɪv/", "महँगा"),
                Word("w410", "🏪", "ショップ", "shoppu", "", "shop", "/ʃɒp/", "दुकान"),
                Word("w411", "🏬", "マーケット", "maaketto", "", "market", "/ˈmɑːrkɪt/", "बाज़ार"),
                Word("w412", "💵", "キャッシュ", "kyasshu", "", "cash", "/kæʃ/", "नकद"),
                Word("w413", "🧾", "リシート", "rishiito", "", "receipt", "/rɪˈsiːt/", "रसीद"),
                Word("w414", "🛍️", "バッグ", "baggu", "", "bag", "/bæɡ/", "थैला / बैग")
            ),
            lang = "en"
        ),
        Lesson(
            "en-feel", "English Feelings", "💗", "ESL feelings — happy, sad, angry, tired and more.",
            listOf(
                Word("w415", "😄", "ハッピー", "happii", "", "happy", "/ˈhæpi/", "खुश"),
                Word("w416", "😢", "サッド", "saddo", "", "sad", "/sæd/", "उदास"),
                Word("w417", "😠", "アングリー", "angurii", "", "angry", "/ˈæŋɡri/", "गुस्सा"),
                Word("w418", "😴", "タイアド", "taiado", "", "tired", "/ˈtaɪərd/", "थका हुआ"),
                Word("w419", "🍽️", "ハングリー", "hangurii", "", "hungry", "/ˈhʌŋɡri/", "भूखा"),
                Word("w420", "💧", "サースティ", "saasutii", "", "thirsty", "/ˈθɜːrsti/", "प्यासा"),
                Word("w421", "🔥", "ホット", "hotto", "", "hot", "/hɒt/", "गर्म"),
                Word("w422", "❄️", "コールド", "koorudo", "", "cold", "/koʊld/", "ठंडा"),
                Word("w423", "😨", "アフレイド", "afureido", "", "afraid", "/əˈfreɪd/", "डरा हुआ"),
                Word("w424", "😲", "サプライズド", "supuraizudo", "", "surprised", "/səˈpraɪzd/", "हैरान"),
                Word("w425", "🥱", "ボード", "boodo", "", "bored", "/bɔːrd/", "ऊबा हुआ"),
                Word("w426", "🤒", "シック", "shikku", "", "sick", "/sɪk/", "बीमार")
            ),
            lang = "en"
        )
    ) + JpN5.lessons + JpN4.lessons + JpN3.lessons + JpN2.lessons + JpN1.lessons +
        EnA1.lessons + EnA2.lessons + EnB1.lessons + EnB2.lessons + EnC1.lessons + EnC2.lessons +
        Genki.lessons + Jfz.lessons + KanjiWords.categories + Oxford.lessons

    val allWords: List<Word> = allLessons.flatMap { it.words }

    val allPhrases = listOf(
        Phrase("p1", "👋", "こんにちは、おげんきですか。", "konnichiwa, ogenki desu ka", "Hello, how are you?", "こんにちは (hello) + おげんきですか (are you well?)"),
        Phrase("p2", "🙏", "ありがとうございます。", "arigatou gozaimasu", "Thank you very much.", "ありがとう (thank you) + ございます (polite)"),
        Phrase("p3", "🚻", "すみません、トイレはどこですか。", "sumimasen, toire wa doko desu ka", "Excuse me, where is the restroom?", "トイレ (restroom) は (topic) どこ (where) ですか (is?)"),
        Phrase("p4", "💰", "これはいくらですか。", "kore wa ikura desu ka", "How much is this?", "これ (this) は (topic) いくら (how much) ですか (is?)"),
        Phrase("p5", "🐱", "わたしはねこがすきです。", "watashi wa neko ga suki desu", "I like cats.", "わたし (I) は (topic) ねこ (cat) が (subject) すき (like) です (is)"),
        Phrase("p6", "📚", "にほんごをべんきょうしています。", "nihongo wo benkyou shite imasu", "I'm studying Japanese.", "にほんご (Japanese) を (object) べんきょうして (studying) います (ongoing)"),
        Phrase("p7", "🏃", "まいにちうんどうします。", "mainichi undou shimasu", "I exercise every day.", "まいにち (every day) うんどう (exercise) します (do)"),
        Phrase("p8", "🎬", "あしたえいがをみます。", "ashita eiga wo mimasu", "I'll watch a movie tomorrow.", "あした (tomorrow) えいが (movie) を (object) みます (watch)"),
        Phrase("p9", "🍜", "たべものはおいしいです。", "tabemono wa oishii desu", "The food is delicious.", "たべもの (food) は (topic) おいしい (delicious) です (is)"),
        Phrase("p10", "🚆", "でんしゃでいきます。", "densha de ikimasu", "I'll go by train.", "でんしゃ (train) で (by means of) いきます (go)"),
        Phrase("p11", "⏳", "ちょっとまってください。", "chotto matte kudasai", "Please wait a moment.", "ちょっと (a little) まって (wait) ください (please)"),
        Phrase("p12", "💝", "すきなものはなんですか。", "sukina mono wa nan desu ka", "What's your favorite thing?", "すきな (favorite) もの (thing) は (topic) なん (what) ですか (is?)"),
        Phrase("p13", "🌅", "おはようございます。", "ohayou gozaimasu", "Good morning.", "おはよう (morning) + ございます (polite)", "शुभ प्रभात।"),
        Phrase("p14", "🍽️", "いただきます。", "itadakimasu", "Let's eat! (before a meal)", "いただきます = humble form of 'I receive'", "खाने से पहले कहा जाने वाला धन्यवाद।"),
        Phrase("p15", "🙏", "ごちそうさまでした。", "gochisousama deshita", "Thanks for the meal.", "ごちそうさま (feast) + でした (past polite)", "खाने के बाद धन्यवाद।"),
        Phrase("p16", "🌙", "おやすみなさい。", "oyasuminasai", "Good night.", "おやすみ (rest) + なさい (soft command)", "शुभ रात्रि।"),
        Phrase("p17", "👋", "またあした。", "mata ashita", "See you tomorrow.", "また (again) + あした (tomorrow)", "कल मिलते हैं।"),
        Phrase("p18", "📛", "なまえはなんですか。", "namae wa nan desu ka", "What's your name?", "なまえ (name) は (topic) なん (what) ですか (is?)", "आपका नाम क्या है?"),
        Phrase("p19", "📍", "どこからきましたか。", "doko kara kimashita ka", "Where are you from?", "どこ (where) から (from) きました (came) か (?)", "आप कहाँ से हैं?"),
        Phrase("p20", "🗣️", "にほんごがすこしわかります。", "nihongo ga sukoshi wakarimasu", "I understand a little Japanese.", "にほんご (Japanese) が (subject) すこし (a little) わかります (understand)", "मुझे थोड़ी जापानी समझ आती है।"),
        Phrase("p21", "🔁", "もういちどおねがいします。", "mou ichido onegaishimasu", "One more time, please.", "もういちど (once more) おねがいします (please)", "एक बार फिर, कृपया।"),
        Phrase("p22", "🍻", "かんぱい！", "kanpai!", "Cheers!", "かんぱい = dry cup → 'cheers'", "चियर्स!"),
        Phrase("p23", "👍", "それはいいですね。", "sore wa ii desu ne", "That's nice, isn't it.", "それ (that) は (topic) いい (good) ですね (right?)", "यह बहुत अच्छा है।"),
        Phrase("p24", "🌏", "どこでしゅっしんですか。", "doko de shusshin desu ka", "Where are you originally from?", "どこ (where) で (in) しゅっしん (origin) ですか (is?)", "आपका गृहस्थान कहाँ है?")
    )

    val allPatterns = listOf(
        Pattern(
            "jp1", "A は B です — 'A is B'", "A は B です — 「AはBです」", "ja",
            "Use は (wa) to mark the topic, then です (desu) means 'is/am/are'. This is the basic sentence skeleton of Japanese.",
            "は で話題（わだい）を示し、です は「〜です」の意味です。日本語の基本文型です。",
            listOf(
                PatternExample("👩", "わたしはせんせいです。", "watashi wa sensei desu", "I am a teacher."),
                PatternExample("📖", "これはほんです。", "kore wa hon desu", "This is a book."),
                PatternExample("🐱", "ねこはかわいいです。", "neko wa kawaii desu", "Cats are cute.")
            )
        ),
        Pattern(
            "jp2", "～ではありません — 'is not'", "～ではありません — 「〜ではありません」", "ja",
            "Add ではありません to the end to negate. じゃないです is the casual version.",
            "文末に ではありません を付けます。くだけた言い方では じゃないです です。",
            listOf(
                PatternExample("🐶", "ねこではありません。", "neko dewa arimasen", "It's not a cat."),
                PatternExample("🎓", "わたしはがくせいではありません。", "watashi wa gakusei dewa arimasen", "I'm not a student.")
            )
        ),
        Pattern(
            "jp3", "～ですか — question", "～ですか — 「〜ですか」", "ja",
            "Just add か (ka) at the end to turn any sentence into a yes/no question.",
            "文末に か を付けるだけで質問文になります。",
            listOf(
                PatternExample("🖊️", "これはペンですか。", "kore wa pen desu ka", "Is this a pen?"),
                PatternExample("🫂", "おげんきですか。", "ogenki desu ka", "How are you? (Are you well?)")
            )
        ),
        Pattern(
            "jp4", "～がすきです — 'I like ~'", "～がすきです — 「〜が好きです」", "ja",
            "好き (suki) means 'like'. Mark what you like with が (ga).",
            "好き は「好き」という意味。好きなものを が で示します。",
            listOf(
                PatternExample("🐟", "さかな が すきです。", "sakana ga suki desu", "I like fish."),
                PatternExample("🇯🇵", "にほんご が すきです。", "nihongo ga suki desu", "I like Japanese.")
            )
        ),
        Pattern(
            "jp5", "～を たべます / のみます — object + action", "～を たべます / のみます — 「〜を食べます・飲みます」", "ja",
            "The object particle を (wo/o) connects a thing to a verb. 食べます = eat, 飲みます = drink.",
            "助詞 を は「動作の対象」を示します。食べます=食べる、飲みます=飲む。",
            listOf(
                PatternExample("🍎", "りんごをたべます。", "ringo wo tabemasu", "I eat an apple."),
                PatternExample("💧", "みずをのみます。", "mizu wo nomimasu", "I drink water.")
            )
        ),
        Pattern(
            "jp6", "～ます / ～ました — present / past", "～ます / ～ました — 「〜ます・〜ました」", "ja",
            "ます = present/future ('I do / will do'), ました = past ('I did'). One of the most useful pairs.",
            "ます=現在・未来、ました=過去。とてもよく使うペアです。",
            listOf(
                PatternExample("📚", "べんきょうします。", "benkyou shimasu", "I study / will study."),
                PatternExample("✅", "べんきょうしました。", "benkyou shimashita", "I studied.")
            )
        ),
        Pattern(
            "jp7", "～てください — polite request", "～てください — 「〜てください」", "ja",
            "Attach てください to the te-form of a verb to say 'please do ~'.",
            "動詞のて形に ください を付けて「〜してください」とお願いします。",
            listOf(
                PatternExample("⏳", "まってください。", "matte kudasai", "Please wait."),
                PatternExample("🐢", "ゆっくりはなしてください。", "yukkuri hanashite kudasai", "Please speak slowly.")
            )
        ),
        Pattern(
            "jp8", "～たいです — 'I want to ~'", "～たいです — 「〜たいです」", "ja",
            "Change a verb to its masu-stem and add たいです to express desire.",
            "動詞のます形（語幹）に たいです を付けて願望を表します。",
            listOf(
                PatternExample("🇯🇵", "にほんにいきたいです。", "nihon ni ikitai desu", "I want to go to Japan."),
                PatternExample("🍜", "ラーメンをたべたいです。", "raamen wo tabetai desu", "I want to eat ramen.")
            )
        ),
        Pattern(
            "jp9", "～に いきます — 'go to ~'", "～に いきます — 「〜に行きます」", "ja",
            "に (ni) marks the destination: go to a place.",
            "行き先は に で示します。行きます=行く。",
            listOf(
                PatternExample("🏫", "がっこうにいきます。", "gakkou ni ikimasu", "I go to school."),
                PatternExample("🚉", "えきにいきます。", "eki ni ikimasu", "I go to the station.")
            )
        ),
        Pattern(
            "jp10", "あります / います — existence", "あります / います — 「あります・います」", "ja",
            "あります for things (books, trees), います for living things (people, animals).",
            "モノには あります、人や動物には います を使います。",
            listOf(
                PatternExample("📖", "ほんがあります。", "hon ga arimasu", "There is a book."),
                PatternExample("🐶", "いぬがいます。", "inu ga imasu", "There is a dog.")
            )
        ),
        Pattern(
            "jp11", "～から ～まで — 'from ~ to ~'", "～から ～まで — 「〜から〜まで」", "ja",
            "から = from (a point), まで = until (a point). Used for time AND places.",
            "から=起点、まで=終点。時間にも場所にも使えます。",
            listOf(
                PatternExample("💼", "あさからばんまではたらきます。", "asa kara ban made hatarakimasu", "I work from morning to night."),
                PatternExample("🕘", "くじからごじまで。", "kuji kara goji made", "From 9 to 5.")
            )
        ),
        Pattern(
            "jp12", "こ・そ・あ — this / that", "こ・そ・あ — 「こそあど」", "ja",
            "これ = this (near me), それ = that (near you), あれ = that over there (away from both).",
            "これ=私の近く、それ=あなたの近く、あれ=遠くのもの。",
            listOf(
                PatternExample("📖", "これはほんです。", "kore wa hon desu", "This is a book."),
                PatternExample("✏️", "それはえんぴつです。", "sore wa enpitsu desu", "That is a pencil."),
                PatternExample("🚗", "あれはくるまです。", "are wa kuruma desu", "That over there is a car.")
            )
        ),
        Pattern(
            "jp13", "～ています — doing right now", "～ています — 「〜ています」", "ja",
            "Te-form + います = an action in progress or a continuing state.",
            "て形+います で「動作進行中」を表します。",
            listOf(
                PatternExample("📚", "べんきょうしています。", "benkyou shite imasu", "I'm studying (right now)."),
                PatternExample("📺", "テレビをみています。", "terebi wo mite imasu", "I'm watching TV.")
            )
        ),
        Pattern(
            "jp14", "い-adj / な-adj — two kinds of adjectives", "い形容詞・な形容詞", "ja",
            "い-adjectives end in い (おいしい, かわいい). な-adjectives don't (きれい, ゆうめい) and take な before a noun.",
            "い形容詞は「い」で終わります。な形容詞は名詞の前に な を付けます。",
            listOf(
                PatternExample("😋", "おいしいです。", "oishii desu", "It's delicious."),
                PatternExample("🌸", "きれいなはなです。", "kirei na hana desu", "It's a pretty flower.")
            )
        ),
        Pattern(
            "en1", "am / is / are — the verb 'be'", "am / is / are — be動詞", "en",
            "I am, you are, he/she/it is, we/they are. The most important verb in English — links a person to a description.",
            "英語の基本動詞。I am（私）、you are（あなた）、he/she is（彼・彼女）と変化します。",
            listOf(
                PatternExample("🎓", "I am a student.", "アイ アム ア スチューデント", "わたしはがくせいです。"),
                PatternExample("💖", "You are kind.", "ユー アー カインド", "あなたはやさしいです。"),
                PatternExample("👩", "She is a teacher.", "シー イズ ア ティーチャー", "かのじょはせんせいです。")
            )
        ),
        Pattern(
            "en2", "a / an / the — articles", "a / an / the — 冠詞", "en",
            "a/an = one (general). Use 'an' before a vowel sound (an apple). the = a specific one.",
            "a/an は「1つの〜」（不特定）、the は「その〜」（特定）です。母音の前は an。",
            listOf(
                PatternExample("🐱", "I have a cat.", "アイ ハヴ ア キャット", "ねこをかっています。"),
                PatternExample("🍎", "Give me an apple.", "ギヴ ミー アン アップル", "りんごをください。"),
                PatternExample("☀️", "The sun is bright.", "ザ サン イズ ブライト", "たいようはあかるいです。")
            )
        ),
        Pattern(
            "en3", "-s plural — more than one", "-s 複数形", "en",
            "Add -s to make most nouns plural: one book → two books. Some are irregular: child → children.",
            "名詞の複数形は普通 -s を付けます。例外もあります（child→children）。",
            listOf(
                PatternExample("📚", "one book, two books", "ワン ブック トゥー ブックス", "いっさつ、にさつ"),
                PatternExample("🐱", "three cats", "スリー キャッツ", "さんびきのねこ"),
                PatternExample("🧒", "five children", "ファイヴ チルドレン", "ごにんのこども")
            )
        ),
        Pattern(
            "en4", "-ing — doing right now", "-ing 現在進行形", "en",
            "am/is/are + verb-ing = happening right now: I am reading.",
            "be動詞+動詞のing形で「今していること」を表します。",
            listOf(
                PatternExample("📖", "I am reading.", "アイ アム リーディング", "よんでいます。"),
                PatternExample("😴", "She is sleeping.", "シー イズ スリーピング", "かのじょはねています。")
            )
        ),
        Pattern(
            "en5", "-ed — simple past", "-ed 過去形", "en",
            "Add -ed for past: walk → walked. Many common verbs are irregular: go → went.",
            "過去形は普通 -ed を付けます。不規則動詞も多いです（go→went）。",
            listOf(
                PatternExample("🚶", "I walked to school.", "アイ ウォークト トゥー スクール", "がっこうまであるきました。"),
                PatternExample("📚", "She studied English.", "シー スタディド イングリッシュ", "かのじょはえいごをべんきょうしました。"),
                PatternExample("🏠", "We went home.", "ウィー ウェント ホーム", "うちにかえりました。")
            )
        ),
        Pattern(
            "en6", "do / does — asking questions", "do / does 疑問文", "en",
            "Start a question with do (I/you/we/they) or does (he/she/it).",
            "疑問文は do / does で始めます。does は三人称単数（he/she/it）で使います。",
            listOf(
                PatternExample("☕", "Do you like coffee?", "ドゥ ユー ライク コーヒー", "コーヒーはすきですか。"),
                PatternExample("⚽", "Does he play soccer?", "ダズ ヒー プレイ サッカー", "かれはサッカーをしますか。")
            )
        ),
        Pattern(
            "en7", "going to — future plans", "going to 未来形", "en",
            "am/is/are + going to + verb = future plan: I am going to study.",
            "be動詞+going to+動詞で未来の予定を表します。",
            listOf(
                PatternExample("📚", "I am going to study.", "アイ アム ゴーイング トゥー スタディ", "べんきょうするつもりです。"),
                PatternExample("✈️", "She is going to travel.", "シー イズ ゴーイング トゥー トラベル", "かのじょはりょこうします。")
            )
        ),
        Pattern(
            "en8", "can / can't — ability", "can / can't 可能", "en",
            "can = able to do. can't = not able to. Same for every person (I can, she can).",
            "can は「できる」、can't は「できない」。主語に関係なく同じ形です。",
            listOf(
                PatternExample("🏊", "I can swim.", "アイ キャン スイム", "およげます。"),
                PatternExample("🚗", "He can't drive.", "ヒー キャント ドライヴ", "かれはうんてんできません。")
            )
        ),
        Pattern(
            "en9", "there is / there are — existence", "there is / there are — 存在", "en",
            "there is + singular, there are + plural: 'There is a book on the table.'",
            "単数には there is、複数には there are を使います。",
            listOf(
                PatternExample("📖", "There is a book on the table.", "ゼア イズ ア ブック オン ザ テーブル", "テーブルのうえにほんがあります。"),
                PatternExample("🐱", "There are three cats.", "ゼア アー スリー キャッツ", "ねこがさんびきいます。")
            )
        ),
        Pattern(
            "en10", "in / on / at — prepositions of place & time", "in / on / at 前置詞", "en",
            "in = inside (in the box, in the morning). on = on top (on the table, on Monday). at = a point (at 3 o'clock, at the station).",
            "in=〜の中、on=〜の上、at=〜の時点・地点。",
            listOf(
                PatternExample("📦", "It's in the box.", "イッツ イン ザ ボックス", "はこのなかにあります。"),
                PatternExample("🪑", "It's on the table.", "イッツ オン ザ テーブル", "テーブルのうえにあります。"),
                PatternExample("🕒", "At 3 o'clock.", "アット スリー オクロック", "さんじに。")
            )
        ),
        Pattern(
            "en11", "comparatives — -er / more", "比較級 -er / more", "en",
            "Short words: -er (big → bigger). Long words: more (beautiful → more beautiful).",
            "短い形容詞は -er、長い形容詞は more を付けます。",
            listOf(
                PatternExample("🐘", "A cat is smaller than a dog.", "ア キャット イズ スモーラー ザン ア ドッグ", "ねこはいぬよりちいさいです。"),
                PatternExample("🌸", "This flower is more beautiful.", "ジス フラワー イズ モア ビューティフル", "このはなはもっときれいです。")
            )
        ),
        Pattern(
            "en12", "have / has — possession", "have / has 所有", "en",
            "have = I/you/we/they have. has = he/she/it has.",
            "所有を表します。三人称単数（he/she/it）では has を使います。",
            listOf(
                PatternExample("📱", "I have a phone.", "アイ ハヴ ア フォン", "けいたいをもっています。"),
                PatternExample("🐶", "She has two dogs.", "シー ハズ トゥー ドッグズ", "かのじょはいぬをにひきかっています。")
            )
        ),
        Pattern(
            "jp15", "も — 'also / too'", "〜も — 「も」", "ja",
            "も (mo) means 'also' or 'too'. Swap は for も to add extra information: 'I drink coffee' → 'I drink coffee TOO'.",
            "は の代わりに も を使うと「〜も」という意味になります。",
            listOf(
                PatternExample("☕", "コーヒーものみます。", "koohii mo nomimasu", "I drink coffee too.", "मैं भी कॉफ़ी पीता हूँ।"),
                PatternExample("🍎", "りんごもたべます。", "ringo mo tabemasu", "I also eat apples.", "मैं सेब भी खाता हूँ।")
            ),
            "も का अर्थ है 'भी'। は के स्थान पर も लगाने से वाक्य में 'भी' का भाव आता है।"
        ),
        Pattern(
            "jp16", "〜ましょう — 'let's ~'", "〜ましょう — 「〜ましょう」", "ja",
            "Change ます to ましょう to suggest doing something together: たべます (I eat) → たべましょう (let's eat).",
            "ます を ましょう に変えて、一緒に何かをする提案をします。",
            listOf(
                PatternExample("🍜", "たべましょう。", "tabemashou", "Let's eat.", "चलो खाते हैं।"),
                PatternExample("📚", "べんきょうしましょう。", "benkyou shimashou", "Let's study.", "चलो पढ़ाई करते हैं।")
            ),
            "ます को ましょう में बदलें — 'चलो करें' का प्रस्ताव।"
        ),
        Pattern(
            "jp17", "〜てもいいです — 'may I / you can ~'", "〜てもいいです — 「〜てもいいです」", "ja",
            "Te-form + もいいです gives permission: はいってもいいですか = May I come in?",
            "て形 + もいいです で許可を表します。",
            listOf(
                PatternExample("🚪", "はいってもいいですか。", "haitte mo ii desu ka", "May I come in?", "क्या मैं अंदर आ सकता हूँ?"),
                PatternExample("📷", "しゃしんをとってもいいですか。", "shashin wo totte mo ii desu ka", "May I take a photo?", "क्या मैं फ़ोटो ले सकता हूँ?")
            ),
            "て-form + もいいです = अनुमति माँगना या देना।"
        ),
        Pattern(
            "jp18", "〜なければなりません — 'must ~'", "〜なければなりません — 「〜なければなりません」", "ja",
            "Verb in negative 〜なければ + なりません = obligation: べんきょうしなければなりません = I must study.",
            "否定形 + なりません で「〜しなければならない」という義務を表します。",
            listOf(
                PatternExample("📚", "べんきょうしなければなりません。", "benkyou shinakereba narimasen", "I must study.", "मुझे पढ़ाई करनी ही होगी।"),
                PatternExample("😴", "ねなければなりません。", "nenakereba narimasen", "I must sleep.", "मुझे सोना ही होगा।")
            ),
            "〜なければなりません = 'करना ही होगा' (बाध्यता)।"
        ),
        Pattern(
            "jp19", "〜てから — 'after doing ~'", "〜てから — 「〜てから」", "ja",
            "Te-form + から = 'after ~': たべてから = after eating.",
            "て形 + から で「〜してから」の意味です。",
            listOf(
                PatternExample("🛁", "おふろにはいってから、ねます。", "ofuro ni haitte kara, nemasu", "I sleep after taking a bath.", "नहाने के बाद सोता हूँ।"),
                PatternExample("🍽️", "たべてから、おさらをあらいます。", "tabete kara, osara wo araimasu", "I wash the dishes after eating.", "खाने के बाद बर्तन धोता हूँ।")
            ),
            "て-form + から = 'करने के बाद'।"
        ),
        Pattern(
            "jp20", "〜より のほうが — comparison", "〜より のほうが — 「〜より〜のほうが」", "ja",
            "X より Y のほうが = Y is more ~ than X. さかなよりにくのほうがすきです = I like meat more than fish.",
            "X より Y のほうが で「X よりも Y の方が」という比較を表します。",
            listOf(
                PatternExample("🍣", "すしよりラーメンのほうがすきです。", "sushi yori raamen no hou ga suki desu", "I like ramen more than sushi.", "मुझे सुशी से ज़्यादा रामेन पसंद है।"),
                PatternExample("🐱", "ねこよりいぬのほうがかわいいです。", "neko yori inu no hou ga kawaii desu", "Dogs are cuter than cats.", "बिल्लियों से कुत्ते ज़्यादा प्यारे हैं।")
            ),
            "X より Y のほうが = Y, X से ज़्यादा / बेहतर।"
        ),
        Pattern(
            "jp21", "〜がほしいです — 'I want (a thing)'", "〜がほしいです — 「〜が欲しいです」", "ja",
            "ほしい (hoshii) = to want [a thing], marked with が: ほんがほしいです = I want a book.",
            "ほしい は「物が欲しい」の意味。欲しいものは が で示します。",
            listOf(
                PatternExample("📖", "ほんがほしいです。", "hon ga hoshii desu", "I want a book.", "मुझे किताब चाहिए।"),
                PatternExample("📱", "あたらしいけいたいがほしいです。", "atarashii keitai ga hoshii desu", "I want a new phone.", "मुझे नया फ़ोन चाहिए।")
            ),
            "〜がほしいです = 'मुझे चाहिए' (किसी चीज़ के लिए)।"
        ),
        Pattern(
            "jp22", "〜でした — past of です", "〜でした — 「〜でした」", "ja",
            "です → でした for the past: きのうはあめでした = Yesterday was rainy. Negative past: ではありませんでした.",
            "です の過去形は でした。否定の過去は ではありませんでした です。",
            listOf(
                PatternExample("☔", "きのうはあめでした。", "kinou wa ame deshita", "Yesterday was rainy.", "कल बारिश थी।"),
                PatternExample("🎉", "たのしかったです。", "tanoshikatta desu", "It was fun.", "बहुत मज़ा आया।")
            ),
            "です का भूतकाल रूप でした है।"
        ),
        Pattern(
            "jp23", "〜てみます — 'try doing ~'", "〜てみます — 「〜てみます」", "ja",
            "Te-form + みます = to try doing: たべてみます = I'll try (eating) it.",
            "て形 + みます で「試しに〜する」という意味です。",
            listOf(
                PatternExample("🍜", "ラーメンをたべてみます。", "raamen wo tabete mimasu", "I'll try ramen.", "मैं रामेन चखूँगा।"),
                PatternExample("👕", "このふくをきてみます。", "kono fuku wo kite mimasu", "I'll try on these clothes.", "मैं ये कपड़े पहनकर देखूँगा।")
            ),
            "て-form + みます = 'कोशिश करके देखना'।"
        ),
        Pattern(
            "jp24", "〜から — 'because ~'", "〜から — 「〜から」", "ja",
            "Put から after the reason clause: あついから = because it's hot. The reason comes first in Japanese.",
            "理由の文の最後に から を付けます。日本語では理由が先に来ます。",
            listOf(
                PatternExample("🔥", "あついから、みずをのみます。", "atsui kara, mizu wo nomimasu", "Because it's hot, I drink water.", "गर्मी है इसलिए पानी पीता हूँ।"),
                PatternExample("🛒", "やすかったから、かいました。", "yasukatta kara, kaimashita", "Because it was cheap, I bought it.", "सस्ता था इसलिए खरीद लिया।")
            ),
            "कारण बताने के लिए वाक्य के अंत में から लगाते हैं।"
        ),
        Pattern(
            "jp25", "〜に — time particle", "〜に — 時間の助詞", "ja",
            "に (ni) marks when something happens: くじにおきます = I wake up at 9. Not used with きょう, あした or every-day words.",
            "時間を表す言葉に に を使います。今日・明日・毎日などには使いません。",
            listOf(
                PatternExample("⏰", "くじにおきます。", "kuji ni okimasu", "I wake up at 9.", "मैं नौ बजे उठता हूँ।"),
                PatternExample("🎂", "ろくがつにたんじょうびです。", "rokugatsu ni tanjoubi desu", "My birthday is in June.", "मेरा जन्मदिन जून में है।")
            ),
            "समय बताने के लिए に लगता है (आज / कल / हर दिन के साथ नहीं)।"
        ),
        Pattern(
            "jp26", "〜で — by means of / at a place", "〜で — 手段・場所の助詞", "ja",
            "で (de) marks the tool, means or place of an action: でんしゃでいきます = go by train; こうえんであそびます = play in the park.",
            "手段（でんしゃで）や場所（こうえんで）を表します。",
            listOf(
                PatternExample("🚋", "でんしゃでいきます。", "densha de ikimasu", "I go by train.", "मैं ट्रेन से जाता हूँ।"),
                PatternExample("⚽", "こうえんでサッカーをします。", "kouen de sakkaa wo shimasu", "I play soccer in the park.", "मैं पार्क में फ़ुटबॉल खेलता हूँ।")
            ),
            "で से साधन ('से') या स्थान ('में') का भाव आता है।"
        ),
        Pattern(
            "en13", "Present Simple — habits & facts", "現在形（習慣・事実）", "en",
            "I/you/we/they + verb, he/she/it + verb-s: I work, she works. Used for habits (I drink tea every day) and facts (The sun rises in the east).",
            "三人称単数（he/she/it）のとき動詞に s を付けます。習慣や事実に使います。",
            listOf(
                PatternExample("☕", "I drink tea every day.", "アイ ドリンク ティー エヴリ デイ", "まいにちおちゃをのみます。", "मैं हर दिन चाय पीता हूँ।"),
                PatternExample("🏫", "She works at a school.", "シー ワークス アット ア スクール", "かのじょはがっこうではたらいています。", "वह स्कूल में काम करती है।")
            ),
            "आदतों और तथ्यों के लिए — he/she/it के साथ क्रिया में -s लगता है।"
        ),
        Pattern(
            "en14", "Present Perfect — have/has + V3", "現在完了形", "en",
            "have/has + past participle (V3): I have eaten, She has finished. Links the past to now — experience, result, or 'just/already/yet'.",
            "過去の出来事が今につながっていることを表します。経験や結果に使います。",
            listOf(
                PatternExample("🍜", "I have eaten sushi.", "アイ ハヴ イートゥン スシ", "すしをたべたことがあります。", "मैंने सुशी खाई है।"),
                PatternExample("✅", "She has finished her work.", "シー ハズ フィニッシュト ハー ワーク", "かのじょはしごとをおえました。", "उसने अपना काम ख़त्म कर लिया है।")
            ),
            "have/has + क्रिया का तीसरा रूप — अतीत का काम जो अब तक प्रासंगिक है ('कर चुका हूँ')।"
        ),
        Pattern(
            "en15", "Present Perfect Continuous — have been + -ing", "現在完了進行形", "en",
            "have/has been + -ing: I have been studying for 2 hours. For actions that started in the past and are still going on.",
            "過去から始まって今も続いている動作に使います。",
            listOf(
                PatternExample("📚", "I have been studying for two hours.", "アイ ハヴ ビーン スタディング フォー トゥー アワーズ", "にじかんべんきょうしています。", "मैं दो घंटे से पढ़ रहा हूँ।"),
                PatternExample("🌧️", "It has been raining all day.", "イット ハズ ビーン レイニング オール デイ", "いちにちじゅうあめがふっています。", "पूरे दिन बारिश हो रही है।")
            ),
            "have been + -ing — अतीत से शुरू होकर अब भी चल रहे काम के लिए।"
        ),
        Pattern(
            "en16", "Past Continuous — was/were + -ing", "過去進行形", "en",
            "was/were + -ing: I was reading when you called. For an action in progress at a past moment.",
            "過去のある時点で進行中だった動作に使います。",
            listOf(
                PatternExample("📖", "I was reading when you called.", "アイ ワズ リーディング ウェン ユー コールド", "あなたがでんわしたときよんでいました。", "जब तुमने फ़ोन किया मैं पढ़ रहा था।"),
                PatternExample("🍳", "She was cooking dinner.", "シー ワズ クッキング ディナー", "かのじょはばんごはんをつくっていました。", "वह रात का खाना बना रही थी।")
            ),
            "was/were + -ing — अतीत के किसी समय चल रहा काम।"
        ),
        Pattern(
            "en17", "Past Perfect — had + V3", "過去完了形", "en",
            "had + V3: I had already eaten before the party. Used for the earlier of two past events.",
            "二つの過去の出来事のうち、より前に起きた方に使います。",
            listOf(
                PatternExample("🎉", "I had already eaten before the party.", "アイ ハド オールレディ イートゥン ビフォー ザ パーティー", "パーティーのまえにすでにたべていました。", "पार्टी से पहले मैं खा चुका था।"),
                PatternExample("🏠", "They had left when we arrived.", "ゼイ ハド レフト ウェン ウィー アライヴド", "ついたときかれらはもうでていました。", "जब हम पहुँचे वे जा चुके थे।")
            ),
            "had + V3 — दो भूतकाल की घटनाओं में से पहली वाली के लिए।"
        ),
        Pattern(
            "en18", "will — future predictions & decisions", "will 未来形", "en",
            "will + verb: I will help you. Used for predictions (It will rain) and instant decisions (I'll take it!).",
            "予測やその場での決断に使います。",
            listOf(
                PatternExample("🛒", "I'll take this one.", "アイ ウィル テイク ジス ワン", "これにします。", "मैं यह लूँगा।"),
                PatternExample("🌧️", "It will rain tomorrow.", "イット ウィル レイン トゥモロー", "あしたはあめでしょう。", "कल बारिश होगी।")
            ),
            "will + क्रिया — भविष्यवाणी और तुरंत फ़ैसले के लिए।"
        ),
        Pattern(
            "en19", "could / would / may — polite requests", "丁寧な依頼（could / would / may）", "en",
            "Could you open the door? Would you help me? May I come in? These are softer and more polite than 'Can you…?'",
            "Could / would / may はとても丁寧なお願いの表現です。",
            listOf(
                PatternExample("🚪", "Could you open the door?", "クッド ユー オウプン ザ ドア", "ドアをあけていただけますか。", "क्या आप दरवाज़ा खोल सकते हैं?"),
                PatternExample("🆘", "Would you help me?", "ウッド ユー ヘルプ ミー", "てつだっていただけますか。", "क्या आप मेरी मदद करेंगे?")
            ),
            "could / would / may से विनम्र अनुरोध — 'Can you…' से ज़्यादा विनम्र।"
        ),
        Pattern(
            "en20", "must / have to — obligation", "must / have to（義務）", "en",
            "must + verb (strong, personal): I must study. have to (everyday): I have to go. Negative: mustn't = not allowed; don't have to = not necessary.",
            "must は強い義務、have to は日常的な義務。",
            listOf(
                PatternExample("💊", "I must take my medicine.", "アイ マスト テイク マイ メディスン", "くすりをのまなければなりません。", "मुझे दवा लेनी ही होगी।"),
                PatternExample("⏰", "I have to go now.", "アイ ハヴ トゥ ゴウ ナウ", "いまいかなくてはなりません。", "मुझे अभी जाना होगा।")
            ),
            "must = 'करना ही होगा' (अपनी ज़िम्मेदारी), have to = 'करना पड़ता है'।"
        ),
        Pattern(
            "en21", "should — advice", "should（助言）", "en",
            "should + verb = good idea: You should rest. You shouldn't worry.",
            "should は「〜するべき」という助言に使います。",
            listOf(
                PatternExample("😴", "You should rest.", "ユー シュッド レスト", "やすむべきです。", "तुम्हें आराम करना चाहिए।"),
                PatternExample("📖", "He should study more.", "ヒー シュッド スタディ モア", "かれはもっとべんきょうすべきです。", "उसे और पढ़ना चाहिए।")
            ),
            "should = 'करना चाहिए' — सलाह के लिए।"
        ),
        Pattern(
            "en22", "Superlatives — the -est / most", "最上級（the -est / most）", "en",
            "Short words: the biggest. Long words: the most beautiful. Always used with 'the'.",
            "短い形容詞は the + est、長い形容詞は the most を使います。",
            listOf(
                PatternExample("🏔️", "This is the highest mountain.", "ジス イズ ザ ハイエスト マウンテン", "これはいちばんたかいやまです。", "यह सबसे ऊँचा पहाड़ है।"),
                PatternExample("🌸", "She is the kindest person I know.", "シー イズ ザ カインデスト パーソン アイ ノウ", "かのじょはいちばんやさしいひとです。", "वह मेरी जानी सबसे दयालु इंसान है।")
            ),
            "सबसे ज़्यादा — छोटे शब्दों में -est, लंबे शब्दों में most।"
        ),
        Pattern(
            "en23", "Conditionals — if sentences", "条件文（if）", "en",
            "1st: If it rains, I will stay home. 2nd (hypothetical): If I were rich, I would travel. 3rd (past): If I had known, I would have come.",
            "if 文で条件を表します。仮定には would を使います。",
            listOf(
                PatternExample("🌧️", "If it rains, I will stay home.", "イフ イット レインズ アイ ウィル ステイ ホーム", "あめならいえにいます。", "अगर बारिश हुई तो मैं घर पर रहूँगा।"),
                PatternExample("💰", "If I were rich, I would travel.", "イフ アイ ワー リッチ アイ ウッド トラベル", "おかねもちならりょこうするのに。", "अगर मैं अमीर होता तो यात्रा करता।")
            ),
            "if = 'अगर'। काल्पनिक बातों के लिए would का प्रयोग।"
        ),
        Pattern(
            "en24", "Passive voice — be + past participle", "受動態", "en",
            "be + V3: The cake was eaten (by the dog). Focuses on the action or receiver, not the doer.",
            "be動詞 + 過去分詞 で受動態を表します。動作を受ける側が主語になります。",
            listOf(
                PatternExample("🍰", "The cake was eaten.", "ザ ケイク ワズ イートゥン", "ケーキはたべられました。", "केक खा लिया गया।"),
                PatternExample("🏗️", "This bridge was built in 2000.", "ジス ブリッジ ワズ ビルト イン トゥー サウザンド", "このはしは2000ねんにつくられました。", "यह पुल सन् 2000 में बनाया गया था।")
            ),
            "कर्मवाच्य — 'किया गया'। be + क्रिया का तीसरा रूप।"
        ),
        Pattern(
            "en25", "Reported speech — 'she said…'", "間接話法", "en",
            "Report what someone said, shifting the tense back: 'I am tired' → She said she was tired.",
            "誰かの発言を伝えるとき、時制を一つ過去にずらします。",
            listOf(
                PatternExample("🗣️", "She said she was tired.", "シー セッド シー ワズ タイアド", "かのじょはつかれたと言いました。", "उसने कहा कि वह थकी हुई थी।"),
                PatternExample("🧑", "He told me he would come.", "ヒー トールド ミー ヒー ウッド カム", "かれはくると言いました。", "उसने मुझसे कहा कि वह आएगा।")
            ),
            "किसी की बात दोहराते समय काल को एक पीछे ले जाते हैं।"
        ),
        Pattern(
            "en26", "Gerunds & infinitives — -ing vs to + verb", "動名詞と不定詞", "en",
            "Some verbs take -ing (enjoy reading), some take to + verb (want to go), and some change meaning (remember doing vs remember to do).",
            "動詞によって -ing か to 不定詞のどちらかを取ります。",
            listOf(
                PatternExample("📚", "I enjoy reading books.", "アイ エンジョイ リーディング ブックス", "ほんをよむのがすきです。", "मुझे किताबें पढ़ना अच्छा लगता है।"),
                PatternExample("✈️", "She wants to travel.", "シー ウォンツ トゥ トラベル", "かのじょはりょこうしたいです。", "वह यात्रा करना चाहती है।")
            ),
            "कुछ क्रियाओं के साथ -ing, कुछ के साथ to + क्रिया।"
        ),
        Pattern(
            "en27", "too / enough", "too / enough", "en",
            "too + adj = more than needed (too hot). adj + enough = sufficient (old enough, big enough).",
            "too は「〜すぎる」、enough は「十分」の意味です。",
            listOf(
                PatternExample("🔥", "This tea is too hot.", "ジス ティー イズ トゥー ホット", "このおちゃはあつすぎます。", "यह चाय बहुत गर्म है।"),
                PatternExample("🎂", "He is old enough to drive.", "ヒー イズ オウルド イナフ トゥ ドライヴ", "かれはうんてんできるおとしです。", "वह गाड़ी चलाने लायक़ है।")
            ),
            "too = बहुत ज़्यादा, enough = काफ़ी।"
        ),
        Pattern(
            "en28", "used to — past habits", "used to（過去の習慣）", "en",
            "used to + verb: I used to play soccer. For past habits that no longer happen.",
            "過去にしていたが今はしていない習慣に使います。",
            listOf(
                PatternExample("⚽", "I used to play soccer.", "アイ ユーストゥ プレイ サッカー", "むかしサッカーをしていました。", "मैं पहले फ़ुटबॉल खेलता था।"),
                PatternExample("🌙", "She used to live here.", "シー ユーストゥ リヴ ヒア", "かのじょはむかしここにすんでいました。", "वह पहले यहाँ रहती थी।")
            ),
            "used to = 'पहले करता था' (अब नहीं करता)।"
        ),
        Pattern(
            "en29", "Question tags — '…, isn't it?'", "付加疑問文", "en",
            "Positive statement + negative tag (You're tired, aren't you?) or negative + positive (It isn't cold, is it?).",
            "肯定文 + 否定の付加疑問、否定文 + 肯定の付加疑問で確認を求めます。",
            listOf(
                PatternExample("🥱", "You're tired, aren't you?", "ヨーア タイアド アーント ユー", "つかれていますね。", "तुम थके हुए हो, है ना?"),
                PatternExample("🌞", "It's a nice day, isn't it?", "イッツ ア ナイス デイ イズント イット", "いいおてんきですね。", "आज अच्छा दिन है, है ना?")
            ),
            "पुष्टि के लिए — 'है ना?' जैसे प्रश्न।"
        ),
        Pattern(
            "en30", "Relative clauses — who / which / that", "関係詞（who / which / that）", "en",
            "The person WHO called, the book WHICH/THAT I bought. Adds a description to a noun.",
            "名詞の後ろに説明を付けます。人は who、物は which / that。",
            listOf(
                PatternExample("📞", "The person who called is my friend.", "ザ パーソン フー コールド イズ マイ フレンド", "でんわしたひとはともだちです。", "जिसने फ़ोन किया वह मेरा दोस्त है।"),
                PatternExample("📖", "The book that I bought is interesting.", "ザ ブック ザット アイ ボート イズ インタレスティング", "かったほんはおもしろいです。", "जो किताब मैंने खरीदी वह दिलचस्प है।")
            ),
            "संज्ञा के बाद विवरण जोड़ने के लिए — who (व्यक्ति), which / that (वस्तु)।"
        )
    ) + JpN5.patterns + JpN4.patterns + JpN3.patterns + JpN2.patterns + JpN1.patterns +
        EnA1.patterns + EnA2.patterns + EnB1.patterns + EnB2.patterns + EnC1.patterns + EnC2.patterns +
        Genki.patterns + Jfz.patterns
}
