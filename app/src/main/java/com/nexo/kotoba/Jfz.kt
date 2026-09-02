package com.nexo.kotoba

object Jfz {
    private var fid = 0
    private fun fw(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Word("f${fid++}", "•", c[0], c[1], c[2], c[3], "", c.getOrElse(4) { "" })
        }.toList()

    private fun fp(id: String, titleEn: String, titleJa: String, ruleEn: String, ruleJa: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "ja", ruleEn, ruleJa, ex(raw), ruleHi, "N5", "jfz")

    private fun ex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            PatternExample("•", c[0], c[1], c[2], c.getOrElse(3) { "" })
        }.toList()

    val lessons: List<Lesson> = listOf(
        Lesson("fz-pre", "Japanese From Zero · Pre-Lessons", "🌱", "Pre-lessons: core vocabulary — body parts, daily objects, greetings in hiragana", fw("""くち|kuchi|口|mouth|मुँह
め|me|目|eye|आँख
みみ|mimi|耳|ear|कान
はな|hana|鼻|nose|नाक
かお|kao|顔|face|चेहरा
て|te|手|hand|हाथ
あし|ashi|足|foot / leg|पैर; पैर
ゆび|yubi|指|finger|उंगली
あたま|atama|頭|head|सिर
は|ha|歯|tooth / teeth|दाँत; रदन
まくら|makura|枕|pillow|रखना; सहारा देना; तकिया
ベッド|beddo||bed|बिस्तर
ふとん|futon|布団|futon|छोटा और मोटा गद्दा
もうふ|moufu|毛布|blanket|परत; आवरण; व्यापक
タオル|taoru||towel|तौलिये से पोंछना; तौलिया; अंगपोछा
おふろ|ofuro|お風呂|bath|स्नान
せっけん|sekken|石けん|soap|साबुन से रगड़ना; साबुन; साबुन लगाना
はブラシ|haburashi|歯ブラシ|toothbrush|दाँत का ब्रश; दाँत साफ करने का ब्रुश
かがみ|kagami|鏡|mirror|दर्पण; शीशा; प्रतिबिम्बित करना
まど|mado|窓|window|खिड़की"""), "ja", "N5", "jfz"),
        Lesson("fz-1", "JFZ Book 1 · Lesson 1 — What is it?", "✏️", "Lesson 1 · これ/それ/あれ — What is it? Core words and the です pattern", fw("""なに|nani|何|what|क्या
はい|hai||yes|हाँ
いいえ|iie||no|नहीं
いぬ|inu|犬|dog|कुत्ता
ねこ|neko|猫|cat|बिल्ली
さん|san||mr./ms./mrs./miss|श्री; स्रीमान; सुश्री; कुमारी; श्रीमती"""), "ja", "N5", "jfz"),
        Lesson("fz-2", "JFZ Book 1 · Lesson 2 — Which one?", "🔍", "Lesson 2 · どれ/どっち — Which one? Choosing between items", fw("""どれ|dore||which one (three of more)|कौनसा
これ|kore||this one|यह
それ|sore||that one|वह
あれ|are||that one over there|वह
どっち|docchi||which one (two items)|कौनसा
こっち|kocchi||this one|यह
そっち|socchi||that one|वह
あっち|acchi||that one over there|वह
レタス|retasu||lettuce|सलाद
バナナ|banana||banana|केला
やさい|yasai|野菜|vegetable|सब्ज़ी
フルーツ|furutsu||fruit|फल
くだもの|kudamono|果物|fruit|फल
すし|sushi|寿司|sushi|सुशी; जापानी भोजन
ペン|pen||pen|कलम
くるま|kuruma|車|car|कार
コンピューター|konpyuta||computer|कंप्यूटर
ほん|hon|本|book|किताब
ざっし|zasshi|雑誌|magazine|पत्रिका"""), "ja", "N5", "jfz"),
        Lesson("fz-3", "JFZ Book 1 · Lesson 3 — Possession", "📦", "Lesson 3 · の possession — Whose is it? わたしの, あなたの", fw("""だれ|dare|誰|who?|कौन
わたし|watashi|私|I, me (male or female)|मैं
ぼく|boku|僕|I, me (males only)|मैं
あなた|anata|貴方|you|तुम
かのじょ|kanojo|彼女|her, she, girlfriend|उसका
かれ|kare|彼|him, he, boyfriend|उसे
なまえ|namae|名前|name|नाम
ともだち|tomodachi|友達|friend|दोस्त
たぶん|tabun|多分|maybe|शायद
がっこう|gakkou|学校|school|विद्यालय
とり|tori|鳥|bird|पक्षी
せんせい|sensei|先生|teacher|शिक्षक
にほんごのせんせい|nihongonosensei|日本語の先生|Japanese teacher|जापानवासी; जापानी"""), "ja", "N5", "jfz"),
        Lesson("fz-4", "JFZ Book 1 · Lesson 4 — Colors & adjectives", "🌈", "Lesson 4 · Colors & adjectives — あか, あお, くろ, しろ and describing things", fw("""なにいろ|naniiro|何色|what color?|कौन सा रंग?
いろ|iro|色|color|रंग
あか|aka|赤|red|लाल
あお|ao|青|blue|नीला
くろ|kuro|黒|black|काला
しろ|shiro|白|white|सफेद
ちゃいろ|chairo|茶色|brown|भूरा
きいろ|kiiro|黄色|yellow|पीला
オレンジ|orenji||orange|संतरा
むらさき|murasaki|紫|purple|धर्माचार्य का पद; प्रतापी; बैंगनी
ピンク|pinku||ｐink|
グレー|gure||gray|स्लेटी
はいいろ|haiiro|灰色|gray|स्लेटी
みずいろ|mizuiro|水色|light blue|रोशनी
みどり|midori|緑|green|हरा
きんいろ|kiniro|金色|gold|सोना
ぎんいろ|giniro|銀色|silver|चमकीला; चाँदी; चाँदी के
とうめい|toumei|透明|clear|स्पष्ट
あかい|akai|赤い|red|लाल
あおい|aoi|青い|blue|नीला
くろい|kuroi|黒い|black|काला
しろい|shiroi|白い|white|सफेद
ちゃいろい|chairoi|茶色い|brown|भूरा
きいろい|kiiroi|黄色い|yellow|पीला
えいご|eigo||English language|अंग्रेजी भाषा; अंग्रेज का; अंग्रेजीअ"""), "ja", "N5", "jfz"),
        Lesson("fz-5", "JFZ Book 1 · Lesson 5 — Likes & dislikes", "💛", "Lesson 5 · すき/きらい — Likes & dislikes", fw("""すき|suki|好き|like|पसंद करना
きらい|kirai|嫌い|dislike, hate|नापसंद; नफ़रत
だいすき|daisuki|大好き|really like, like a lot|बहुत पसंद
だいきらい|daikirai|大嫌い|really dislike, really hate|बहुत नफ़रत
かいもの|kaimono|買い物|shopping|खरीदारी
かんこう|kankou|観光|sightseeing|दर्शनीय स्थल देखना
りょこう|ryokou|旅行|travel|यात्रा
しゅくだい|shukudai|宿題|homework|गृहकार्य
しごと|shigoto|仕事|work|काम
さかな|sakana|魚|fish|मछली
チキン|chikin||chicken|मुर्गी
にほんご|nihongo|日本語|Japanese language|जापानवासी; जापानी
じゃあ|jaa||well then...|अच्छी तरह
おいしい|oishii|美味しい|tastes good, delicious|स्वादिष्ट
おいしくない|oishikunai|美味しくない|doesn't taste good|स्वादिष्ट नहीं
いちご|ichigo||strawberries|स्ट्रॉबेरी"""), "ja", "N5", "jfz"),
        Lesson("fz-6", "JFZ Book 1 · Lesson 6 — Wanting", "🤲", "Lesson 6 · ほしい — Wanting and not wanting things", fw("""ほしい|hoshii|欲しい|want|चाहना
ドル|doru||dollars|
えん|en|円|yen|तरसना; ललक; ललक्
インターネット|intanetto||internet|इंटरनेट; अन्तरजाल; अंतर्जाल/अन्तर्जाल
おかね|okane|お金|money|पैसा
もちろん|mochiron||of course|निस्सन्देह; अवश्य ही; कभी तो
コーラ|kora||cola|
みず|mizu|水|water|पानी
のみもの|nomimono|飲み物|a drink, drinks|
けっこうです。|kekkoudesu。||I'm fine. (No thanks.)|
あたらしい|atarashii|新しい|new|नया
ふるい|furui|古い|old|पुराना
あつい|atsui|暑い|hot|गर्म
さむい|samui|寒い|cold|ठंडा
つめたい|tsumetai|冷たい|cold to the touch|ठंडा
ぬるい|nurui|温い|warm, luke warm|गर्म"""), "ja", "N5", "jfz"),
        Lesson("fz-7", "JFZ Book 1 · Lesson 7 — Locations", "📍", "Lesson 7 · Locations — ここ/そこ/あそこ, where things are", fw("""どこ|doko||where? / what place?|कहाँ; क्या
ここ|koko||here, this place|यहाँ
そこ|soko||there, that place|वहाँ
あそこ|asoko||over there, that place over there|ऊपर
そと|soto|外|outside|बाहर
なか|naka|中|inside|अंदर
レストラン|resutoran||restaurant|रेस्तराँ
にほん|nihon|日本|Japan|एक प्रकार की वार्निश; रोग़न करके चमकाना; जापान
アメリカ|amerika||America|अमरीका
でも|demo||but|लेकिन
いい、よい|ii、yoi|いい、良い|nice, good|अच्छा
おおきい|ookii|大きい|big|बड़ा
ちいさい|chiisai|小さい|small|छोटा
おなかがいっぱいです。|onakagaippaidesu。||I'm full.|"""), "ja", "N5", "jfz"),
        Lesson("fz-8", "JFZ Book 1 · Lesson 8 — Dates & past", "📅", "Lesson 8 · Dates & past — days, months, でした past tense", fw("""あけましておめでとう。|akemashiteomedetou。||Happy New Year.|खुश
おめでとう。|omedetou。||Congratulations.|
いつ|itsu||when?|कब
なんにち|nannichi|何日|what day of the month?|क्या
なんがつ|nangatsu|何月|what month?|क्या
きょう|kyou|今日|today|आज
あした|ashita|明日|tomorrow|कल
きのう|kinou|昨日|yesterday|कल
たんじょうび|tanjoubi|誕生日|birthday|जन्मदिन
クリスマス|kurisumasu||Christmas|क्रिसमस; बड़ा; बड़ा दिन
どくりつきねんび|dokuritsukinenbi|独立記念日|Independence Day|स्वतंत्र; स्वतंत्रता; स्वाधीनता
プレゼント|purezento||present, gift|उपहार
ゴールデンウィーク|gorudenwiku||Golden Week|महतपूर्ण; अच्छा; शुभ
けんぽうきねんび|kenpoukinenbi|憲法記念日|Constitution Day|बनावट; गठन; शारीरिक गठन
こどものひ|kodomonohi|子供の日|Children's Day|
ぶんかのひ|bunkanohi|文化の日|Culture Day|समूह; संवर्धन; शिष्टता
たいいくのひ|taiikunohi|体育の日|Sports Day|क्रीड़ा प्रतियोगिता दिवस; क्रीड़ा प्रतियोगिता
ついたち|tsuitachi|一日|1st|
ふつか|futsuka|二日|2nd|
みっか|mikka|三日|3rd|तीसरा
よっか|yokka|四日|4th|
いつか|itsuka|五日|5th|
むいか|muika|六日|6th|६वाँ
なのか|nanoka|七日|7th|७
ようか|youka|八日|8th|
ここのか|kokonoka|九日|9th|
とおか|tooka|十日|10th|दसवाँ
じゅういちにち|juuichinichi|十一日|11th|
じゅうににち|juuninichi|十二日|12th|
じゅうさんにち|juusannichi|十三日|13th|
じゅうよっか|juuyokka|十四日|14th|
じゅうごにち|juugonichi|十五日|15th|
じゅうろくにち|juurokunichi|十六日|16th|१६वाँ
じゅう(しち/なな)にち|juu(shichi/nana)nichi|十七日|17th|सत्रहवाँ
じゅうはちにち|juuhachinichi|十八日|18th|१८ वाँ; १८
じゅうくにち|juukunichi|十九日|19th|१९वाँ
はつか|hatsuka|二十日|20th|२०वाँ
にじゅういちにち|nijuuichinichi|二十一日|21st|
にじゅうににち|nijuuninichi|二十二日|22nd|
にじゅうさんにち|nijuusannichi|二十三日|23rd|
にじゅうよっか|nijuuyokka|二十四日|24th|
にじゅうごにち|nijuugonichi|二十五日|25th|
にじゅうろくにち|nijuurokunichi|二十六日|26th|
にじゅうしちにち|nijuushichinichi|二十七日|27th|
にじゅうはちにち|nijuuhachinichi|二十八日|28th|
にじゅうくにち|nijuukunichi|二十九日|29th|२९; २९ वाँ
さんじゅうにち|sanjuunichi|三十日|30th|
さんじゅういちにち|sanjuuichinichi|三十一日|31st|
いちがつ|ichigatsu|一月|January|जनवरी
にがつ|nigatsu|二月|February|फरवरी माह; फ़रवरी
さんがつ|sangatsu|三月|March|प्रयाण गीत; चलना; सीमा प्रान्त
しがつ|shigatsu|四月|April|अप्रेल माह; अप्रैल
ごがつ|gogatsu|五月|May|लेना; सम्भवतः; संभवतः
ろくがつ|rokugatsu|六月|June|जून; जून{साल का छटा महीना}; जूनअ
しちがつ|shichigatsu|七月|July|जुलाई
はちがつ|hachigatsu|八月|August|महत्वपूर्ण; अगस्त; गरिमापूर्ण
くがつ|kugatsu|九月|September|सितम्बर
じゅうがつ|juugatsu|十月|October|अक्तूबर; अक्तुबर
じゅういちがつ|juuichigatsu|十一月|November|नवम्बर; नवंबरअ
じゅうにがつ|juunigatsu|十二月|December|दिसम्बर"""), "ja", "N5", "jfz"),
        Lesson("fz-9", "JFZ Book 1 · Lesson 9 — Days, weeks, years", "🗓️", "Lesson 9 · Days, weeks, years — 〜から 〜まで time spans", fw("""なんようび|nanyoubi|何曜日|what day of the week?|क्या
なんねん|nannen|何年|what year?|क्या
いま|ima|今|now|अब
おととい|ototoi|一昨日|day before yesterday|दिन
あさって|asatte|明後日|day after tomorrow|दिन
せんしゅう|senshuu|先週|last week|पिछला सप्ताह
こんしゅう|konshuu|今週|this week|इस सप्ताह
らいしゅう|raishuu|来週|next week|अगला सप्ताह
せんげつ|sengetsu|先月|last month|गत मास
こんげつ|kongetsu|今月|this month|
らいげつ|raigetsu|来月|next month|अगला
きょねん|kyonen|去年|last year|आखिरी
ことし|kotoshi|今年|this year|
らいねん|rainen|来年|next year|अगला साल
せいねんがっぴ|seinengappi|生年月日|date of birth|तारीख
がんたん|gantan|元旦|New Year's Day|नववर्ष दिन
パーティー|pati||party|पार्टी
げつようび|getsuyoubi|月曜日|Monday|सोमवार
かようび|kayoubi|火曜日|Tuesday|मंगलवार
すいようび|suiyoubi|水曜日|Wednesday|बुधवार
もくようび|mokuyoubi|木曜日|Thursday|गुरुवार
きんようび|kinyoubi|金曜日|Friday|शुक्रवार
どようび|doyoubi|土曜日|Saturday|शनिवार
にちようび|nichiyoubi|日曜日|Sunday|रविवार"""), "ja", "N5", "jfz"),
        Lesson("fz-10", "JFZ Book 1 · Lesson 10 — Asking for things", "🙏", "Lesson 10 · Asking for things — をください, polite requests", fw("""なにがいいですか。|nanigaiidesuka。||What would you like?|क्या
がいいです。|gaiidesu。||I would like a .|मैं
ありがとうございました。|arigatougozaimashita。||Thank you very much. (past tense)|धन्यवाद
どうぞ。|douzo。||Here you go. / Go ahead.|उद्यमी; अनुमति; सहमति/अनुमति
いくら|ikura||How much?|कितना
メニュー|menyu||menu|मेनू/आहारिका; मेन्यू; व्यंजन सूची
ポテト|poteto||French fries|चिप्स
チーズバーガー|chizubaga||cheeseburger|चीज़बर्गर
ピザ|piza||pizza|पिज्जा; पीत्ज़ा; पिज्जा{इटालियन खाद्य सामग्री}
スパゲッティー|supagetti||spaghetti|स्फागैटी{इटालियन खाना}
ビーフ|bifu||beef|गोमांस
サンドイッチ|sandoicchi||sandwich|कचौड़ी; मेवा
サンド|sando||sandwich (short version)|कचौड़ी; मेवा
デザート|dezato||dessert|भोजनोपरान्त; भोजनोपरान्त फल; भोजन के बाद मीठा
あっ！|ax！||Oh!|आह; ओह
おつり|otsuri|お釣|change|बदलना
(お)のみもの|(o)nomimono|(お)飲み物|a drink|पीना
たべもの|tabemono|食べ物|food|खाना
おかし|okashi|お菓子|a snack|अल्पाहार; अल्पाहार/हल्का नाशता; अल्पाहार करना
みそしる|misoshiru|味噌汁|miso soup|
おひや|ohiya|お冷|cold drinking water|ठंडा
おちゃ|ocha|お茶|green tea|हरी चाय
きれい|kirei||pretty|सुंदर
わかりました|wakarimashita||understood|समझा गया; समझा
やすい|yasui||cheap, inexpensive|सस्ता"""), "ja", "N5", "jfz"),
        Lesson("fz-11", "JFZ Book 1 · Lesson 11 — Counting", "🔢", "Lesson 11 · Counting — 個/本/枚 counters", fw("""いくつ|ikutsu||How many things?|कितनी चीज़ें?
なんこ|nanko|何個|How many round objects?|कितनी गोल वस्तुएँ?
なんぼん|nanbon|何本|How many cylindrical objects?|कितनी बेलनाकार वस्तुएँ?
なんまい|nanmai|何枚|How many thin/flat objects?|कैसे; नीरस; सितारा मछली; सपाट
かみ|kami|紙|paper|कागज़
チケット|chiketto||tickets|टिकट
はな|hana|花|flowers|
はた|hata|旗|flag|लम्बे बालों वाला शिकारी कुत्ता; कमज्ॅओर पड़ जाना; कम होना
ほし|hoshi|星|star (in the sky)|तारा
カレンダー|karenda||calendar|तालिका; दबानेवाला; कैलन्डर"""), "ja", "N5", "jfz"),
        Lesson("fz-12", "JFZ Book 1 · Lesson 12 — Verbs", "🏃", "Lesson 12 · Verbs — ます/ません/ました", fw("""なにご|nanigo|何語|what language?|क्या
なにじん|nanijin|何人|what nationality?|क्या
ロサンゼルス|rosanzerusu||Los Angeles|
ラスベガス|rasubegasu||Las Vegas|
シカゴ|shikago||Chicago|शिकागो
カリフォルニア|kariforunia||California|कैलिफ़ोर्निया
カナダ|kanada||Canada|कनाडा
かんこく|kankoku|韓国|Korea|कोरिया
ちゅうごく|chuugoku|中国|China|चीनी मिट्टी के बर्तन; चीन; चीनी मिट्टी
ぎんこう|ginkou|銀行|bank|बैंक
ふく|fuku|服|clothing, clothes|पहनावा; परिधान; वस्त्र
～し|～shi|～市|~ City|
～しゅう|～shuu|～州|~ State|
～けん|～ken|～県|~ Prefecture|
～ご|～go|～語|~ language|
～じん|～jin|～人|~ nationality|
おひさしぶりです。|ohisashiburidesu。||It's been a long time.|इसका
なにご は はなせますか。|nanigo ha hanasemasuka。||What languages can you speak?|क्या
「語」がはなせます。|「語」gahanasemasu。|「語」がはなせます。|I can speak 「language」.|मैं
今から|今kara|今から|from now / from now on|
何の？|何no？|何の？|what? / which? / what kind of?|क्या; कौन सा; कैसा/कैसे...
今日は暑いですね。|今日ha暑idesune。|今日は暑いですね。|Today sure is hot.|आज"""), "ja", "N5", "jfz"),
        Lesson("fz-13", "JFZ Book 1 · Lesson 13 — Telling time", "⏰", "Lesson 13 · Telling time — 〜じ, なんじ, AM/PM", fw("""なんじ|nanji|何時|what time?|क्या
はん|han|半|half past (:30)|आधा
ごぜん|gozen|午前|AM (also means morning)|हूँ
ごご|gogo|午後|PM (also means afternoon)|प्रधान मंत्री
くうこう|kuukou|空港|airport|हवाई अड्डा
じゅぎょう|jugyou|授業|class|कक्षा
アルバイト|arubaito||part-time job|अंशकालिक नौकरी
やすみ|yasumi|休み|day off, break|दिन
||一時|one o'clock|
||二時|two o'clock|
||三時|three o'clock|तीन
||四時|four o'clock|चार
||五時|five o'clock|पाँच
||六時|six o'clock|छह
||七時|seven o'clock|सात
||八時|eight o'clock|आठ
||九時|nine o'clock|नौ
||十時|ten o'clock|दस
||十一時|eleven o'clock|ग्यारह
||十二時|twelve o'clock|बारह
||一分|one minute|
||二分|two minutes|
||三分|three minutes|तीन
||四分|four minutes|चार
||五分|five minutes|पाँच
||六分|six minutes|छह
||七分|seven minutes|सात
||八分|eight minutes|आठ
||九分|nine minutes|नौ
||十分|ten minutes|दस"""), "ja", "N5", "jfz")
    )

    val patterns: List<Pattern> = listOf(
        fp("jfz-1", "Lesson 1 · です — What is it?", "です — これはなんですか", "です is the polite sentence-ender meaning 'is/am'. ですか with a rising tone makes a question. ではありません means 'is not'.", "です＝丁寧な断定。ですか＝疑問。ではありません＝否定。", "です = 'है'। ですか = प्रश्न। ではありません = 'नहीं है'।", """これはなんですか|kore wa nan desu ka|What is this?|यह क्या है?
それはほんです|sore wa hon desu|That is a book.|वह किताब है
これはえんぴつではありません|kore wa enpitsu de wa arimasen|This is not a pencil.|यह पेंसिल नहीं है"""),
        fp("jfz-2", "Lesson 2 · これ/それ/あれ — Which one?", "こ・そ・あ・ど", "こ-series (これ/この) = near the speaker, そ-series (それ/その) = near the listener, あ-series (あれ/あの) = far from both, ど-series (どれ/どの) = which.", "これ＝話し手に近い。それ＝聞き手に近い。あれ＝両方から遠い。どれ＝どれ？", "これ=यह, それ=वह, あれ=वहाँ वाला, どれ=कौन सा।", """それはなんですか|sore wa nan desu ka|What is that?|वह क्या है?
あれはでんわです|are wa denwa desu|That (over there) is a phone.|वह (वहाँ) फ़ोन है
どれがあなたのほんです|dore ga anata no hon desu ka|Which one is your book?|कौन सी आपकी किताब है?"""),
        fp("jfz-3", "Lesson 3 · の possession — Whose?", "の — 所有", "の links a person to a thing they own: わたしのほん = my book. だれの? = whose?.", "の＝所有を表す。わたしの＝私の。だれの＝誰の？", "の = का/की (स्वामित्व)।", """これはわたしのほんです|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है
それはだれのかばんですか|sore wa dare no kaban desu ka|Whose bag is that?|वह किसका बैग है?
これはあなたのではありません|kore wa anata no de wa arimasen|This is not yours.|यह आपका नहीं है"""),
        fp("jfz-4", "Lesson 4 · Colors & adjectives", "色と形容詞", "Colors: あか(red), あお(blue), くろ(black), しろ(white). なにいろ? = what color?. Adjectives can come before a noun (あかいほん) or after です (あかいです).", "色の名前。形容詞は名詞の前か、ですの前につく。", "रंग: लाल, नीला, काला, सफेद। विशेषण संज्ञा से पहले या です के साथ।", """このくつはくろです|kono kutsu wa kuro desu|These shoes are black.|ये जूते काले हैं
あのほんはあかいです|ano hon wa akai desu|That book is red.|वह किताब लाल है
あなたのくるまはなにいろですか|anata no kuruma wa naniiro desu ka|What color is your car?|आपकी गाड़ी किस रंग की है?"""),
        fp("jfz-5", "Lesson 5 · すき/きらい — Likes & dislikes", "好き・嫌い", "すきです = like, きらいです = dislike, だいすき = really like, だいきらい = really dislike. The thing liked takes the particle が.", "すき＝好き。きらい＝嫌い。対象には「が」を使う。", "すき=पसंद, きらい=नापसंद। पसंद की चीज़ के साथ कण 'が' आता है।", """わたしはねこがすきです|watashi wa neko ga suki desu|I like cats.|मुझे बिल्लियाँ पसंद हैं
あなたはなにがすきですか|anata wa nani ga suki desu ka|What do you like?|आपको क्या पसंद है?
わたしはきらいです|watashi wa kirai desu|I dislike it.|मुझे नापसंद है"""),
        fp("jfz-6", "Lesson 6 · ほしい — Wanting", "欲しい", "ほしいです = want (for things). なにがほしい? = What do you want?. ほしくない = don't want.", "ほしい＝欲しい。ほしくない＝欲しくない。", "ほしい=चाहिए। ほしくない=नहीं चाहिए।", """わたしはおかねがほしいです|watashi wa okane ga hoshii desu|I want money.|मुझे पैसे चाहिए
あなたはなにがほしいですか|anata wa nani ga hoshii desu ka|What do you want?|आपको क्या चाहिए?
わたしはコーラはほしくないです|watashi wa koora wa hoshikunai desu|I don't want cola.|मुझे कोला नहीं चाहिए"""),
        fp("jfz-7", "Lesson 7 · Locations", "場所", "ここ = here, そこ = there, あそこ = over there. どこ = where. いる/ある = to exist (いる for living things).", "ここ・そこ・あそこ・どこ。いる＝人や動物がいる。ある＝物がある。", "ここ=यहाँ, そこ=वहाँ, あそこ=उधर, どこ=कहाँ।", """トイレはあそこです|toire wa asoko desu|The restroom is over there.|शौचालय वहाँ है
わたしはがっこうにいます|watashi wa gakkou ni imasu|I am at school.|मैं स्कूल में हूँ
ここはどこですか|koko wa doko desu ka|Where is this place?|यह जगह कहाँ है?"""),
        fp("jfz-8", "Lesson 8 · Dates & past", "日付と過去", "Past tense: です becomes でした. Months: がつ. Days: にち. なんにち? = what day of the month?", "過去形：でした。月＝がつ。日＝にち。", "भूतकाल: でした।", """きのうはにちようびでした|kinou wa nichiyoubi deshita|Yesterday was Sunday.|कल रविवार था
きょうはなんにちですか|kyou wa nannichi desu ka|What is today's date?|आज कौन सी तारीख़ है?
せんげつはじゅうにがつでした|sengetsu wa juunigatsu deshita|Last month was December.|पिछला महीना दिसंबर था"""),
        fp("jfz-9", "Lesson 9 · Days, weeks, years", "曜日・週・年", "Days of the week end in ようび: げつようび(Monday)…にちようび(Sunday). から = from, まで = until. なんねん? = what year?", "曜日＝ようび。から＝〜から。まで＝〜まで。", "सप्ताह के दिन, から=से, まで=तक।", """きょうはなんようびですか|kyou wa nanyoubi desu ka|What day of the week is it today?|आज कौन सा दिन है?
げつようびからきんようびまでです|getsuyoubi kara kin'youbi made desu|From Monday to Friday.|सोमवार से शुक्रवार तक
いまなんねんですか|ima nannen desu ka|What year is it now?|अभी कौन सा साल है?"""),
        fp("jfz-10", "Lesson 10 · Asking for things", "〜をください", "ください = please give me. The item takes the particle を. なにがいい? = What would you like?", "ください＝ください。品物には「を」。", "ください=कृपया दीजिए।", """みずをください|mizu o kudasai|Please give me water.|कृपया मुझे पानी दीजिए
メニューをください|menyuu o kudasai|Please give me the menu.|कृपया मुझे मेन्यू दीजिए
コーヒーをください|koohii o kudasai|Please give me coffee.|कृपया मुझे कॉफ़ी दीजिए"""),
        fp("jfz-11", "Lesson 11 · Counting", "数える", "Counters: 個 (round objects), 本 (cylindrical), 枚 (flat), 人 (people). いくつ = how many things? なんこ/なんぼん/なんまい = how many of each type?", "助数詞：個・本・枚・人。", "गिनती शब्द: 個=गोल, 本=लंबी, 枚=पतली।", """りんごをふたつください|ringo o futatsu kudasai|Please give me two apples.|कृपया मुझे दो सेब दीजिए
ボールペンをさんぼんください|boorupen o sanbon kudasai|Please give me three pens.|कृपया मुझे तीन पेन दीजिए
かみをなんまいください|kami o nanmai kudasai|How many sheets of paper, please?|कितनी शीट कागज़ चाहिए?"""),
        fp("jfz-12", "Lesson 12 · Verbs", "動詞", "Polite verbs end in ます (present), ません (negative), ました (past). Example: べんきょうします = study, みます = watch.", "動詞：ます＝現在、ません＝否定、ました＝過去。", "क्रिया: ます=वर्तमान, ません=नकारात्मक, ました=भूतकाल।", """わたしはにほんごをべんきょうします|watashi wa nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ
わたしはテレビをみません|watashi wa terebi o mimasen|I don't watch TV.|मैं टीवी नहीं देखता
きのうえいがをみました|kinou eiga o mimashita|I watched a movie yesterday.|कल मैंने फ़िल्म देखी"""),
        fp("jfz-13", "Lesson 13 · Telling time", "時間", "Times: 〜じ = o'clock, はん = half past. いまなんじですか = What time is it now?. ごぜん = AM, ごご = PM. Use に before a specific time.", "時間：〜じ。はん＝半。なんじ＝何時？", "समय: じ=बजे।", """いまなんじですか|ima nanji desu ka|What time is it now?|अभी कितने बजे हैं?
いまごじはんです|ima goji han desu|It's 5:30 now.|अभी साढ़े पाँच बजे हैं
わたしははちじにおきます|watashi wa hachiji ni okimasu|I get up at 8 o'clock.|मैं आठ बजे उठता हूँ""")
    )
}
