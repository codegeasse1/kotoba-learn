package com.nexo.kotoba

data class KanaChar(val id: String, val kana: String, val romaji: String, val mnemonic: String)

data class Word(
    val id: String,
    val emoji: String,
    val kana: String,
    val romaji: String,
    val kanji: String = "",
    val en: String,
    val ipa: String
)

data class Lesson(val id: String, val title: String, val emoji: String, val desc: String, val words: List<Word>)

data class Phrase(
    val id: String,
    val emoji: String,
    val ja: String,
    val romaji: String,
    val en: String,
    val chunks: String
)

data class PatternExample(val emoji: String, val ja: String, val romaji: String, val en: String)

data class Pattern(
    val id: String,
    val titleEn: String,
    val titleJa: String,
    val lang: String,
    val ruleEn: String,
    val ruleJa: String,
    val examples: List<PatternExample>
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
        )
    )

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
        Phrase("p12", "💝", "すきなものはなんですか。", "sukina mono wa nan desu ka", "What's your favorite thing?", "すきな (favorite) もの (thing) は (topic) なん (what) ですか (is?)")
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
        )
    )
}
