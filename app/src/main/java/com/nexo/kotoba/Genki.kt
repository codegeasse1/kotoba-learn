package com.nexo.kotoba

object Genki {
    private var gid = 0
    private fun gw(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Word("g${gid++}", "•", c[0], c[1], c[2], c[3], "", c.getOrElse(4) { "" })
        }.toList()

    private fun gp(id: String, titleEn: String, titleJa: String, ruleEn: String, ruleJa: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "ja", ruleEn, ruleJa, ex(raw), ruleHi, "N4", "genki")

    private fun ex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            PatternExample("•", c[0], c[1], c[2], c.getOrElse(3) { "" })
        }.toList()

    val lessons: List<Lesson> = listOf(
        Lesson("genki-1", "📗 Genki 1 · Lesson 1", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""おはよう|ohayou|お早う|Good morning|सुप्रभात
おはようございます|ohayougozaimasu|お早う御座います|Good morning (polite)|सुप्रभात
こんにちは|konnichiha||Good afternoon|नमस्कार
こんばんは|konbanha||Good evening|शुभ संध्या
さようなら|sayounara||Goodbye (for a long time)|अलविदा; शुभ विदाई
おやすみ|oyasumi||Good night|शुभ रात्रि
おやすみなさい|oyasuminasai||Good night (polite)|शुभ रात्रि
ありがとう|arigatou||Thank you|धन्यवाद; धन्यबाद पट्र; धन्यबाद देना
ありがとうございます|arigatougozaimasu||Thank you (polite)|धन्यवाद; धन्यबाद पट्र; धन्यबाद देना
すみません|sumimasen||Excuse me; I'm sorry|क्षमा; क्षमा करें; माफ़ कीजिए
いいえ|iie||No; Not at all|नहीं; बिल्कुल नहीं
いってきます|ittekimasu||I'm leaving home and coming back|घर से जा रहा हूँ, वापस आऊँगा
いってらしゃい|itterashai||Please leave home and come back|घर जाइए और वापस आइए
ただいま|tadaima||I'm home|मैं घर आ गया
おかえり|okaeri||Welcome home|घर में स्वागत है
おかえりなさい|okaerinasai||Welcome home (polite)|घर में स्वागत है
いただきます|itadakimasu||Thanks for the meal (before eating)|भोजन के लिए धन्यवाद
ごちそうさま|gochisousama||Thanks for the meal (after eating)|भोजन के लिए धन्यवाद
ごちそうさまでした|gochisousamadeshita||Thanks for the meal (after eating) (polite)|भोजन के लिए धन्यवाद
はじめまして|hajimemashite||How do you do?|आपसे मिलकर खुशी हुई
〜です|〜desu||I am...|मैं हूँ
よろしくおねがいします|yoroshikuonegaishimasu||Nice to meet you|आपसे मिलकर खुशी हुई
ゼロ;れい|zero;rei||0|शून्य
いち|ichi|一|1|एक
に|ni|二|2|दो
さん|san|三|3|तीन
よん;し;よ|yon;shi;yo|四|4|चार
ご|go|五|5|पाँच
ろく|roku|六|6|छह
なな;しち|nana;shichi|七|7|सात
はち|hachi|八|8|आठ
きゅう;く|kyuu;ku|九|9|नौ
じゅう|juu|十|10|दस
ひゃく|hyaku|百|100|सौ
あの|ano||um...|अम्म्म...
いま|ima|今|now|अब
えいご|eigo|英語|English (language)|अंग्रेजी भाषा; अंग्रेज का; अंग्रेजीअ
がくせい|gakusei|学生|student|छात्र
〜ご|〜go|〜語|language|भाषा
こうこう|koukou|高校|high school|उच्च विद्यालय
ごご|gogo|午後|P.M.|प्रधान मंत्री
ごぜん|gozen|午前|A.M.|हूँ
〜さい|〜sai|〜歳|...years old|साल का/की उम्र
〜さん|〜san||Mr./Ms....|श्री; स्रीमान; सुश्री; कुमारी
〜じ|〜ji|〜時|o'clock|बजे
〜じん|〜jin|〜人|people|लोग
せんせい|sensei|先生|teacher; Professor ...|शिक्षक; प्राध्यापक; प्रोफ़ेसर
せんもん|senmon|専門|major|प्रमुख; मुख्य; महत्वपूर्ण
そうです|soudesu||That's right.|सही कहा
だいがく|daigaku|大学|college; university|कॉलेज; विश्वविद्यालय; किसी विश्वविद्यालय का दल; किसी विश्वविद्यालय का
でんわ|denwa|電話|telephone|दूरभाष करना; फोन करना; दूरभाष
ともだち|tomodachi|友達|friend|दोस्त
なまえ|namae|名前|name|नाम
なん／なに|nan／nani|何|what|क्या
にほん|nihon|日本|Japan|एक प्रकार की वार्निश; रोग़न करके चमकाना; जापान
〜ねんせい|〜nensei|〜年生|...year student|का/की छात्र
はい|hai||ys|हाँ
はん|han|半|half|आधा
ばんごう|bangou|番号|number|संख्या
りゅうがくせい|ryuugakusei|留学生|international student|विदेशी छात्र
わたし|watashi|私|I|मैं
アメリカ|amerika||U.S.A.|यू एस ए
イギリス|igirisu||Britain|ब्रिटेन
オーストラリア|osutoraria||Australia|ऑस्ट्रेलिया
かんこく|kankoku|韓国|Korea|कोरिया
スウェーデン|suweden||Sweden|स्वीडन
ちゅうごく|chuugoku|中国|China|चीनी मिट्टी के बर्तन; चीन; चीनी मिट्टी
かがく|kagaku|科学|science|प्रक्रिया; कौशल; विषय
アジアけんきゅう|ajiakenkyuu|アジア研究|Asian studies|एशियाई अध्ययन
こくさいかんけい|kokusaikankei|国際関係|international relations|अंतर्राष्ट्रीय संबंध
コンピューター|konpyuta||computer|कंप्यूटर
じんるいがく|jinruigaku|人類学|anthropology|मानव विज्ञान; मानवशास्त्र/नृविज्ञान
せいじ|seiji|政治|politics|कूटनीति; राजनीति विज्ञान; राजनीति
ビジネス|bijinesu||business|व्यापार
ぶんがく|bungaku|文学|literature|साहित्यिक; साहित्यिक सामग्री; रचना
れきし|rekishi|歴史|history|इतिहास
しごと|shigoto|仕事|job; work; occupation|नौकरी; काम; आक्रमण; धंधा; अधिकार
いしゃ|isha|医者|doctor|डॉक्टर
かいしゃいん|kaishain|会社員|office worker|कार्यालय कर्मचारी
こうこうせい|koukousei|高校生|high school student|हाई स्कूल छात्र
しゅふ|shufu|主婦|housewife|गृहिणी; घर की संचालिका; गृहस्वामिनी
だいがくいんせい|daigakuinsei|大学院生|graduate student|स्नातकोत्तर छात्र
だいがくせい|daigakusei|大学生|college student|विश्वविद्यालयीन; विश्वविद्यालयीन छात्र; कलेज का छात्र
べんごし|bengoshi|弁護士|lawyer|कानून का पंडित; वकील; अधिवक्ता
おかあさん|okaasan|お母さん|mother|माँ
おとうさん|otousan|お父さん|father|पिता
おねえさん|oneesan|お姉さん|older sister|बड़ी बहन
おにいさん|oniisan|お兄さん|older brother|बड़ा भाई
いもうと|imouto|妹|younger sister|छोटी बहन
おとうと|otouto|弟|younger brother|सहोदर; अनुज"""), "ja", "N5", "genki"),
        Lesson("genki-2", "📗 Genki 1 · Lesson 2", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""これ|kore||this one|यह
それ|sore||that one|वह
あれ|are||that one (over there)|वह
どれ|dore||which one|कौनसा
この|kono||this ...|यह
その|sono||that ...|वह
あの|ano||that ... (over there)|वह
どの|dono||which ...|कौन सा
あそこ|asoko||over there|वहाँ
どこ|doko||where|कहाँ
だれ|dare||who|कौन
おいしい|oishii||delicious|स्वादिष्ट
さかな|sakana|魚|fish|मछली
とんかつ|tonkatsu||pork cutlet|सूअर का कटलेट
にく|niku|肉|meat|मांस
メニュー|menyu||menu|मेनू/आहारिका; मेन्यू; व्यंजन सूची
やさい|yasai|野菜|vegetable|सब्ज़ी
えんぴつ|enpitsu|鉛筆|pencil|पेंसिल
かさ|kasa|傘|umbrella|छाता
かばん|kaban||bag|थैला
くつ|kutsu|靴|shoes|
さいふ|saifu|財布|wallet|बटुआ; झोला; पर्स
ジーンズ|jinzu||jeans|सूती कपड़ा
じしょ|jisho|辞書|dictionary|शब्दकोष
じてんしゃ|jitensha|自転車|bicycle|साइकिल; साइकिल चलाना
しんぶん|shinbun|新聞|newspaper|कला और विज्ञापन; विज्ञापन; कागज़
テープ|tepu||tape|लगाना; दौड समाप्ति का फीता; पट्टी
とけい|tokei|時計|watch; clock|देखना; घड़ी
トレーナー|torena||sweat shirt|जैकेट
ノート|noto||notebook|नोट बुक; नोटबुक; बुक
ペン|pen||pen|कलम
ぼうし|boushi|帽子|hat; cap|टोपी; शिखर; टोपी पहनाना; कुकुरमुत्ता
ほん|hon|本|book|किताब
おてあらい|otearai|お手洗い|restroom|शौचालय; सार्वजनिक; सार्वजनिक शौचघर
きっさてん|kissaten|喫茶店|cafe|कहवाघर; कैफ़े
ぎんこう|ginkou|銀行|bank|बैंक
としょかん|toshokan|図書館|library|पुस्तकालय
ゆうびんきょく|yuubinkyoku|郵便局|post office|डाक घर; डाकघर
けいざい|keizai|経済|economics|अर्थव्यवस्था; अर्थशास्त्र; अर्थशास्ट्र
いくら|ikura||how much|कितना
〜えん|〜en|〜円|...yen|तरसना; ललक; ललक्
たかい|takai|高い|expensive|महंगा
いらっしゃいませ|irasshaimase||Welcome (to our store)|स्वागत
（〜を）おねがいします|（〜o）onegaishimasu||..., please.|कृपया
（〜を）ください|（〜o）kudasai||Please give me...|कृपया मुझे दीजिए
じゃあ|jaa||then...; if that is the case,...|फिर
（〜を）どうぞ|（〜o）douzo||Here it is.|यह लीजिए
どうも|doumo||Thank you.|धन्यवाद; धन्यबाद पट्र; धन्यबाद देना
えいが|eiga|映画|movie|फ़िल्म
おんがく|ongaku|音楽|music|संगीत
ざっし|zasshi|雑誌|magazine|पत्रिका
スポーツ|supotsu||sports|खेल कूद
デート|deto||date (romantic, not calendar)|तारीख
テニス|tenisu||tennis|टेनिस; टेनिस[एक प्रकार का खेल].
テレビ|terebi||TV|टी वी; टी; दूरदर्शन
ビデオ|bideo||video tape; VCR|वीडियो; वीडियो बनाना; वीडियो{दृश्य}; वी सी आर
あさごはん|asagohan|朝御飯|breakfast|नाश्ता
おさけ|osake|お酒|sake; alcohol|के लिये; साके{चावलों की बनी जापानी शराब}; साकी; अल्कोहल; मद्य; मद्यसार{अलकोहल}
おちゃ|ocha|お茶|green tea|हरी चाय
コーヒー|kohi||coffee|कॉफी
ばんごはん|bangohan|晩御飯|dinner|रात का खाना
ハンバーガー|hanbaga||hamburger|क़ीमा; गोमाँस का कीमा; हैम्बर्जर
ひるごはん|hirugohan|昼御飯|lunch|दोपहर का खाना
みず|mizu|水|water|पानी
いえ|ie|家|home; house|घर; घर
うち|uchi|家|home; house; my place|घर; घर; मेरा
LL（エルエル）|LL（erueru）||language lab|भाषा प्रयोगशाला
がっこう|gakkou|学校|school|विद्यालय
あさ|asa|朝|morning|सुबह
あした|ashita||tomorrow|कल
いつ|itsu||when|कब
きょう|kyou|今日|today|आज
〜ごろ|〜goro||at about|लगभग
こんばん|konban|今晩|tonight|आज रात
しゅうまつ|shuumatsu|週末|weekend|सप्ताहांत
どようび|doyoubi|土曜日|Saturday|शनिवार
にちようび|nichiyoubi|日曜日|Sunday|रविवार
まいにち|mainichi|毎日|every day|हर दिन; नित्यप्रति
まいばん|maiban|毎晩|every night|हर रात
いく|iku|行く|to go|जाना
かえる|kaeru|帰る|to go back; to return|बदलना; उठाना; वापस; लौटना
きく|kiku|聞く|to listen; to hear|सुनना; सुनना
のむ|nomu|飲む|to drink|पीना
はなす|hanasu|話す|to speak; to talk|बोलना; बात करना
よむ|yomu|読む|to read|पढ़ना
おきる|okiru|起きる|to get up|उठना
たべる|taberu|食べる|to eat|खाना
ねる|neru|寝る|to sleep; to go to sleep|सोना; सुन्न होना
みる|miru|見る|to see; to look at; to watch|देखकर; देखोगे तो; देखना
くる|kuru|来る|to come|आना
する|suru||to do|करना
べんきょうする|benkyousuru|勉強する|to study|पढ़ाई करना
いい|ii||good|अच्छा
はやい|hayai|早い|early|जल्दी
あまり+ negative|amari+ negative||not much|ज़्यादा नहीं
ぜんぜん + negative|zenzen + negative|全然|not at all|बिल्कुल नहीं
たいてい|taitei|大抵|usually|आमतौर पर
ちょっと|chotto||a little|थोड़ा
ときどき|tokidoki|時々|sometimes|कभी-कभी
よく|yoku||often; much|अक्सर; बहुत
そうですね|soudesune||That's right.; Let me see.|सही कहा; मुझे याद करने दो
でも|demo||but|लेकिन
どうですか|doudesuka||How about...?; How is...?|कैसा रहेगा; कैसे"""), "ja", "N5", "genki"),
        Lesson("genki-3", "📗 Genki 1 · Lesson 3", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""アルバイト|arubaito||part-time job|अंशकालिक नौकरी
かいもの|kaimono|買い物|shopping|खरीदारी
クラス|kurasu||class|कक्षा
あなた|anata||you|तुम
いぬ|inu|犬|dog|कुत्ता
おみやげ|omiyage|お土産|souvenir|निशानी; यादगार
こども|kodomo|子供|child|बच्चा
ごはん|gohan|御飯|rice; meal|चावल; भोजन
しゃしん|shashin|写真|picture; photograph|तस्वीर; चित्र; छायाचित्र; फ़ोटो लेना
つくえ|tsukue|机|desk|मेज़
てがみ|tegami|手紙|letter|पत्र
ねこ|neko|猫|cat|बिल्ली
パン|pan||bread|रोटी
ひと|hito|人|person|व्यक्ति
おてら|otera|お寺|temple|कनपटी; मोहरा; दिवगृह
こうえん|kouen|公園|park|पार्क
スーパー|supa||supermarket|सुपर बाज़ार; सुपर
デパート|depato||department store|बड़ी; बड़ी दुकान
バスてい|basutei|バス停|bus stop|अल्प बस ठहराव; बस स्थानकअ; बस
びょういん|byouin|病院|hospital|अस्पताल
ホテル|hoteru||hotel|होटल
ほんや|honya|本屋|bookstore|पुस्तक की दुकान
まち|machi|町|town; city|कस्बा; शहर
レストラン|resutoran||restaurant|रेस्तराँ
きのう|kinou|昨日|yesterday|कल
さっき|sakki||a little while ago|थोड़ी देर पहले
〜じかん|〜jikan|〜時間|hour|घंटा
いちじかん|ichijikan|一時間|one hour|एक घंटा
せんしゅう|senshuu|先週|last week|पिछला सप्ताह
とき|toki|時|when...; at the time of...|कब
かようび|kayoubi|火曜日|Tuesday|मंगलवार
すいようび|suiyoubi|水曜日|Wednesday|बुधवार
もくようび|mokuyoubi|木曜日|Thursday|गुरुवार
きんようび|kinyoubi|金曜日|Friday|शुक्रवार
あう|au|会う|to meet; to see (a person)|मिलना; देखकर
ある|aru||there is ...|है/हैं
かう|kau|買う|to buy|खरीदना
かく|kaku|書く|to write|लिखना
とる|toru|撮る|to take (pictures)|लेना
まつ|matsu|待つ|to wait|इंतज़ार करना
わかる|wakaru||to understand|समझना
いる|iru||(a person) is in ...; stays at ...|
〜ぐらい|〜gurai||about (approximate measurement)|के बारे में
ごめんなさい|gomennasai||I'm sorry.|माफ़ कीजिए
だから|dakara||so; therefore|तो; अतः; इसलिए; इस तरह से
たくさん|takusan||many; a lot|कई; बहुत सारा; कहीं
〜と|〜to||together with (a person)|के साथ; के साथ साथ; को मिला कर
どうして|doushite||why|क्यों
ひとりで|hitoride|一人で|alone|अकेला
もしもし|moshimoshi||Hello? (used on the phone)|नमस्ते
みぎ|migi|右|right|सही
ひだり|hidari|左|left|बायाँ
まえ|mae|前|front|सामने
うしろ|ushiro|後ろ|back|पीठ
なか|naka|中|inside|अंदर
うえ|ue|上|on|पर
した|shita|下|under|नीचे
そば|soba||near|पास
となり|tonari|隣|next|अगला
あいだ|aida|間|between|के बीच
そこ|soko||there|वहाँ
ここ|koko||here|यहाँ
げつようび|getsuyoubi|月曜日|Monday|सोमवार
うみ|umi|海|sea|समुद्र
きって|kitte|切手|postal stamps|डाक टिकट
きっぷ|kippu|切符|ticket|टिकट
サーフィン|safin||surfing|तरंग पट्टी पर बहना
しゅくだい|shukudai|宿題|homework|गृहकार्य
たべもの|tabemono|食べ物|food|खाना
たんじょうび|tanjoubi|誕生日|birthday|जन्मदिन
テスト|tesuto||test|परीक्षा
てんき|tenki|天気|weather|मौसम
のみもの|nomimono|飲み物|drink|पीना
はがき|hagaki|葉書|postcard|पोस्टचार्ड
バス|basu||bus|बस
ひこうき|hikouki|飛行機|airplane|विमान; हवाई जहाज
へや|heya|部屋|room|कमरा
ぼく|boku|僕|I (used by men)|मैं
やすみ|yasumi|休み|holiday; day off; absence|छुट्टी; छुट्टी का दिन; अनुपस्थिति; अभाव; मृदु अपस्मार
りょこう|ryokou|旅行|travel|यात्रा
あたらしい|atarashii|新しい|new|नया
あつい|atsui|暑い|hot (weather)|गर्म
あつい|atsui|熱い|hot (objects)|गर्म
いそがしい|isogashii|忙しい|busy (people/days)|व्यस्त
おおきい|ookii|大きい|large|बड़ा
おもしろい|omoshiroi|面白い|interesting|दिलचस्प
こわい|kowai|怖い|frightening|डरावना; भयानक
さむい|samui|寒い|cold (weather-not used for objects)|ठंडा
たのしい|tanoshii|楽しい|fun|मज़ा
ちいさい|chiisai|小さい|small|छोटा
つまらない|tsumaranai||boring|उबाऊ; उबाऊ/नीरस; कुपछेदन
ふるい|furui|古い|old (thing - not used for people)|पुराना
むずかしい|muzukashii|難しい|difficult|कठिन
やさしい|yasashii||easy (problem); kind (person)|आसान; दयालु
やすい|yasui|安い|inexpensive; cheap (thing)|सस्ता; सस्ता
きらい（な）|kirai（na）|嫌い|disgusted with; to dislike|चिढ़ा हुआ; घृणा; नापसंद करना; द्वेष
きれい（な）|kirei（na）||beautiful; clean|सुंदर; साफ
げんき（な）|genki（na）|元気|healthy; energetic|स्वस्थ; स्वस्त; स्वस्थ्यवऋद्धक; बल; चुस्त; ओजस्वी
しずか（な）|shizuka（na）|静か|quiet|शांत
すき（な）|suki（na）|好き|fond of; to like|प्रेमी; शौक; प्रिय; पसंद करना
だいきらい（な）|daikirai（na）|大嫌い|to hate|घृणा करना; घृणा; द्वेष
だいすき（な）|daisuki（na）|大好き|very fond of; to love|प्यार
にぎやか（な）|nigiyaka（na）||lively|फुर्तीला; सक्रिय; प्रफुल्ल
ハンサム（な）|hansamu（na）||handsome|रमणीय; छैला; रूपवान
ひま（な）|hima（na）|暇|not busy; to have a lot of free time|
およぐ|oyogu|泳ぐ|to swim|तैरना
きく|kiku|聞く|to ask|पूछना
のる|noru|乗る|to ride; to board|चलाना; घुड़सवारी करना; चढना; किनारा; में चढना; तख्ता
やる|yaru||to do; to perform|करना; करना; दिखाना; गाना
でかける|dekakeru|出かける|to go out|समय व्यतित करना; घायब होना; भेजना
いっしょに|isshoni|一緒に|together|साथ
それから|sorekara||and then|और फिर
だいじょうぶ|daijoubu|大丈夫|It's okay.; Not to worry.; Everything is under control.|इसका; चिन्ता की कोई बात नहीं; सब कुछ
とても|totemo||very|बहुत
どんな|donna||what kind of...|कैसा/कैसे...
〜まい|〜mai|〜枚|[counter for flat objects]|पतली वस्तुओं का गिनती शब्द
〜まで|〜made||to (a place); as far as (a place); till (a time)|को; उतनी दूर; तक; जहाँ तक कि; तक; खेत जोतना; गोलक"""), "ja", "N5", "genki"),
        Lesson("genki-4", "📗 Genki 1 · Lesson 4", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""おかね|okane|お金|money|पैसा
おばあさん|obaasan||grandmother; old woman|दादी; पत्नी; कायर आदमी; माताआ
おふろ|ofuro|お風呂|bath|स्नान
かんじ|kanji|漢字|kanji; Chinese character|चीनी; चीन; चीनी भाषा
きょうかしょ|kyoukasho|教科書|textbook|पाठ्यपुस्तकीय; पाठ्य पुस्तक; पाठ्य
こんしゅう|konshuu|今週|this week|इस सप्ताह
しみんびょういん|shiminbyouin|市民病院|Municipal Hospital|नगरपालिका अस्पताल
つぎ|tsugi|次|next|अगला
テレビゲーム|terebigemu||video game|वीडियो गेम; वीडियो गेम{परिकलन यन्त्र से खेलने का खेल}
でんき|denki|電気|electricity|विद्युत; उत्तेजना; बिजली
でんしゃ|densha|電車|train|रेलगाड़ी
にもつ|nimotsu|荷物|baggage|वेश्या; सामान; यात्री का सामान/सामान
ページ|peji||page|पृष्ठ
まど|mado|窓|window|खिड़की
よる|yoru|夜|night|रात
らいしゅう|raishuu|来週|next week|अगला सप्ताह
らいねん|rainen|来年|next year|अगला साल
たいへん（な）|taihen（na）|大変|tough (situation)|कठोर; कठिन; उद्दण्ड
あそぶ|asobu|遊ぶ|to play; to spend time pleasantly|खेलना
いそぐ|isogu|急ぐ|to hurry|जल्दी करना
おふろにはいる|ofuronihairu|お風呂に入る|to take a bath|स्नान करना
かえす|kaesu|返す|to return (things)|लौटना
けす|kesu|消す|to turn off; to erase|बंद करना; सहायक; बंद कर देना; दूर; निकाल देना; मिटा देना
しぬ|shinu|死ぬ|to die|मरना
すわる|suwaru|座る|to sit down|बैठना; बैठ हड़ताल; बैठक भोजन परोस
たつ|tatsu|立つ|to stand up|धोखा देना; मान्य होना; आमने सामने की
たばこをすう|tabakoosuu|たばこを吸う|to smoke|तम्बाकू; असफलता; धूम्रपान
つかう|tsukau|使う|to use|उपयोग करना
てつだう|tetsudau|手伝う|to help|मदद
はいる|hairu|入る|to enter|प्रवेश करना
もつ|motsu|持つ|to carry; to hold|ले जाना; पकड़ना
やすむ|yasumu|休む|to be absent (from...); to rest|आराम
あける|akeru|開ける|to open (something)|खोलना
おしえる|oshieru|教える|to teach; to instruct|पढ़ाना; बताना; उपदेश देना; सूचित करना
おりる|oriru|降りる|to get off|बंद करना; भेजना; बचना
かりる|kariru|借りる|to borrow|उधार लेना
しめる|shimeru|閉める|to close (something)|मूंदना
つける|tsukeru||to turn on|चलाना; बहकाना; खोलना
でんわをかける|denwaokakeru|電話をかける|to make a phone call|फोन करना
わすれる|wasureru|忘れる|to forget; to leave behind|बिसराना; पीछे छोड़ना; बहुत उन्नति करना; फीछे छोड़ना
つれてくる|tsuretekuru|連れてくる|to bring (a person)|लाना
もってくる|mottekuru|持ってくる|to bring (a thing)|लाना
あとで|atode|後で|later on|बाद में
おそく|osoku|遅く|(do something) late|देर
〜から|〜kara||because ...|क्योंकि
けっこうです|kekkoudesu|結構です|That would be fine.; That wouldn't be necessary.|
すぐ|sugu||right away|फ़ौरन
ほんとうですか|hontoudesuka|本当ですか|Really?|वास्तव में
ゆっくり|yukkuri||slowly; leisurely; unhurriedly|आहिस्ता; विलंबित में; विलंबित; धीरे धीरे; इत्मीनान भरा; इत्मीनान से; बिना हड़बड़ाए; बिना
あね|ane|姉|(my) older sister|बड़ी बहन
アパート|apato||apartment|अपार्टमेंट
いもうと|imouto|妹|younger sister|छोटी बहन
うた|uta|歌|song|गाना
おとうと|otouto|弟|younger brother|सहोदर; अनुज
おとこのひと|otokonohito|男の人|man|आदमी
おにいさん|oniisan|お兄さん|older brother|बड़ा भाई
おねえさん|oneesan|お姉さん|older sister|बड़ी बहन
おんなのひと|onnanohito|女の人|woman|महिला
かいしゃ|kaisha|会社|company|कंपनी
かぞく|kazoku|家族|family|परिवार
かみ|kami|髪|hair|बाल
きょうだい|kyoudai|兄弟|brothers and sisters|
くに|kuni|国|country; place of origin|देश; उद्गमस्थल; उद्गम
くるま|kuruma|車|car|कार
コンビニ|konbini||convenience store|सुलभ दुकान
しょくどう|shokudou|食堂|cafeteria; dining commons|कहवाखाना; कैफ़ेटेरिया
ちち|chichi|父|(my) father|पिता
Tシャツ|Tshatsu||T-shirt|
め|me|目|eye|आँख
めがね|megane|眼鏡|glasses|चश्मा; काँच; दूरबीन
あたまがいい|atamagaii|頭がいい|bright; smart; clever|चमकीला; बुद्धिमान; अच्छा; स्वच्छ/सुव्यवस्थित; बुद्धिमान; योग्य; निपुण
かっこいい|kakkoii||great-looking|
かわいい|kawaii||cute|चालाक; आकर्षक; अति सुन्दर
せがたかい|segatakai|背が高い|tall|लंबा
せがひくい|segahikui|背が低い|short (stature)|छोटा
ながい|nagai|長い|long|लंबा
はやい|hayai|早い|fast|तेज़
みじかい|mijikai|短い|short (length)|छोटा
しんせつ|shinsetsu|親切|kind|दयालु
べんり|benri|便利|convenient|सरल; सुविधा; उचित
うたう|utau|歌う|to sing|गाना
かぶる|kaburu||to put on (a hat)|चलाना; दिखाना; लगाना
しる|shiru|知る|to get to know|
しっています|shitteimasu|知っています|I know|मैं
しりません|shirimasen|知りません|I do not know|मैं
すむ|sumu|住む|to live|जीना
はく|haku||to put on (items below your waist)|चलाना; दिखाना; लगाना
ふとる|futoru|太る|to gain weight|
ふとっています|futotteimasu|太っています|to be on the heavy side|
めがねをかける|meganeokakeru||to put on glasses|
きる|kiru|着る|to put on (clothes above your waist)|चलाना; दिखाना; लगाना
やせる|yaseru||to lose weight|
やせています|yaseteimasu||to be thin|
けっこんする|kekkonsuru|結婚する|to get married|
が|ga||but|लेकिन
ひとり|hitori|一人|one person|
ふたり|futari|二人|two people|
もちろん|mochiron||of course|निस्सन्देह; अवश्य ही; कभी तो
よかったら|yokattara||if you like|यदि तुम चाहो; यदि तुम चाहते हो; यदि तुम"""), "ja", "N5", "genki"),
        Lesson("genki-5", "📗 Genki 1 · Lesson 5", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""ざんねんですね|zannendesune|残念ですね|That's too bad.|
あさって|asatte||the day after tomorrow|
あめ|ame|雨|rain|बारिश
かいしゃいん|kaishain|会社員|office worker|कार्यालय कर्मचारी
カメラ|kamera||camera|कैमरा
カラオケ|karaoke||karaoke|कैरिओके; रिकार्ड की हुई धुन{लोकप्रिय गाने की}
くうき|kuuki|空気|air|हवा
けさ|kesa|今朝|this morning|
こんげつ|kongetsu|今月|this month|
しごと|shigoto|仕事|job; work; occupation|नौकरी; काम; आक्रमण; धंधा; अधिकार
だいがくせい|daigakusei|大学生|college student|विश्वविद्यालयीन; विश्वविद्यालयीन छात्र; कलेज का छात्र
ディスコ|disuko||disco|डिस्को
てんきよほう|tenkiyohou|天気予報|weather forecast|मौसम; मौसम पूर्वानुमान; मौसम का पूर्वानुमान
ところ|tokoro|所|place|स्थान
トマト|tomato||tomato|टमाटर
なつ|natsu|夏|summer|गर्मी
なにか|nanika|何か|something|कुछ
パーティー|pati||party|पार्टी
バーベキュー|babekyu||barbecue|धातु की छड़; बारबेक्यू; बारबेक्यू व्यंजन
はし|hashi||chopsticks|
ふゆ|fuyu|冬|winter|सर्दी
ホームステイ|homusutei||homestay; living with a local family|जीवित; आजीविका; क्रियाशील
まいしゅう|maishuu|毎週|every week|प्रति सप्ताह
らいげつ|raigetsu|来月|next month|अगला
じょうず|jouzu|上手|skillful; good at...|कुशल; कौशलपूर्ण; अच्छा
へた|heta|下手|clumsy; poor at...|भारी; फूहड़; बेढंगा; गरीब
ゆうめい|yuumei|有名|famous|उत्कृष्ट; जाना; विख्यात
あめがふる|amegafuru|雨が降る|it rains|
あらう|arau|洗う|to wash|धोना
いう|iu|言う|to say|कहना
いる|iru||to need|ज़रूरत
おそくなる|osokunaru|遅くなる|to be late (for ...)|में देर लगाना
おもう|omou|思う|to think|विचार करना
きる|kiru|切る|to cut|काटना
つくる|tsukuru|作る|to make|बनाना
もっていく|motteiku|持っていく|to take (something)|लेना
じろじろみる|jirojiromiru|じろじろ見る|to stare (at ...)|आँख गड़ाकर देखना; नज़र; घूरना
はじめる|hajimeru|始める|to begin|शुरू करना
うんてんする|untensuru|運転する|to drive|चलाना
せんたくする|sentakusuru|洗濯する|to do laundry|
そうじする|soujisuru|掃除する|to clean|साफ
りょうりする|ryourisuru|料理する|to cook|पकाना
ううん|uun||uh-uh; no|नहीं
うん|un||uh-huh; yes|हाँ
かんぱい|kanpai|乾杯|Cheers! (a toast)|
みんなで|minnade||all (of the people) together|
いいこ|iiko|いい子|good child|अच्छा
いろ|iro|色|color|रंग
おべんとう|obentou|お弁当|boxed lunch|
おんせん|onsen|温泉|spa; hot spring|खनिज जल स्रोत; स्वास्थ्य प्रशिक्षण केंद्र; स्वास्थ्य केंद्र; गरम; गरम सोता; गरम पानी का सोता
かぶき|kabuki||Kabuki; traditional Japanese theatrical art|पारंपरिक; परम्परागत; रूढिगत
ギター|gita||guitar|गिटार; गिटार{वाद्य यंत्र)
くすり|kusuri|薬|medicine|दवा
くすりをのむ|kusurionomu|薬を飲む|to take medicine|चुपचाप स्वीकार करना
コンサート|konsato||concert|तालमेल; संगीत गोष्ठी; संगीत
こんど|kondo|今度|near future|पास
さくぶん|sakubun|作文|essay; composition|कोशिश करना; लेख; प्रयत्न करना/परिश्रम करना/जाँचना; बनावट; लेखन; संरचना
しけん|shiken|試験|exam|परीक्षा
しんかんせん|shinkansen|新幹線|Shinkansen;|
スキー|suki||ski|स्कीइंग का; स्की करना; स्की
せんげつ|sengetsu|先月|last month|गत मास
たんご|tango|単語|word; vocabulary|शब्द; शब्दावली; शब्दकोश
ピアノ|piano||piano|धीमा; धीमे से; पियानो/महावाद्य
びょうき|byouki|病気|illness; sickness|रोग; बीमारी; अस्वास्थ्य; रोग; बीमारी; मिचली
あおい|aoi|青い|blue|नीला
あかい|akai|赤い|red|लाल
くろい|kuroi|黒い|black|काला
さびしい|sabishii|寂しい|lonely|शान्त; अकेला; एकांत
しろい|shiroi|白い|white|सफेद
わかい|wakai|若い|young|जवान
いじわる|ijiwaru|意地悪|mean-spirited|
おどる|odoru|踊る|to dance|नाचना
おわる|owaru|終わる|(something) ends|
にんきがある|ninkigaaru|人気がある|to be popular|
はじまる|hajimaru|始まる|(something) begins|
ひく|hiku|弾く|to play (a string instrument or piano)|खेलना
もらう|morau||to get (from somebody)|पाना
おぼえる|oboeru|覚える|to memorize|याद करना; कंठस्थ; याद
でる|deru|出る|(1) to appear; to attend (2) to exit|दिखना
うんどうする|undousuru|運動する|to do physical exercises|
さんぽする|sanposuru|散歩する|to take a walk|
ぜひ|zehi|是非|by all means|अवश्य
みんな|minna||all|सब
もう|mou||already|पहले ही
ひとつ|hitotsu|一つ|one|एक
ふたつ|futatsu|二つ|two|दो
みっつ|mittsu|三つ|three|तीन
よっつ|yottsu|四つ|four|चार
いつつ|itsutsu|五つ|five|पाँच
むっつ|muttsu|六つ|six|छह
ななつ|nanatsu|七つ|seven|सात
やっつ|yattsu|八つ|eight|आठ
ここのつ|kokonotsu|九つ|nine|नौ
とお|too|十|ten|दस"""), "ja", "N5", "genki"),
        Lesson("genki-6", "📗 Genki 1 · Lesson 6", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""あき|aki|秋|fall|गिरना
えき|eki|駅|station|स्टेशन
おかねもち|okanemochi|お金持ち|rich person|अमीर
かお|kao|顔|face|चेहरा
きせつ|kisetsu|季節|season|मौसम
クレジットカード|kurejittokado||credit card|क्रेडिट कार्ड
ことし|kotoshi|今年|this year|
サッカー|sakka||soccer|फुटबाल
シャツ|shatsu||shirt|कमीज़
せいかつ|seikatsu|生活|life; living|जीवन; जीवित; आजीविका; क्रियाशील
せかい|sekai|世界|world|दुनिया
ちかてつ|chikatetsu|地下鉄|subway|भूमिगत मार्ग; तलमार्ग; भूमिगत रेल
てぶくろ|tebukuro|手袋|gloves|
とこや|tokoya|床屋|barber's|
はる|haru|春|spring|वसंत
パンツ|pantsu||pants|पतलून; चड्ढी
びよういん|biyouin|美容院|beauty parlor|प्रसाधनालय; ब्यूटी; ब्यूटी पार्लर
びん|bin|便|flight|उड़ान; पलायन; कल्पना की उड़ान
ふね|fune|船|ship; boat|जहाज़; नाव
やきゅう|yakyuu|野球|baseball|बेस बल; बेस
ゆうめいじん|yuumeijin|有名人|celebrity|प्रतिष्ठा; प्रशंसा; ख्यातिई
よやく|yoyaku|予約|reservation|रक्षण खंडअ; कारण; आरक्षित भूमि
らいがっき|raigakki|来学期|next semester|अगला
りんご|ringo||apple|सेब
あたたかい|atatakai|暖かい|warm|गर्म
おそい|osoi|遅い|slow; late|धीमा; देर
すずしい|suzushii|涼しい|cool (weather)|ठंडा
つめたい|tsumetai|冷たい|cold (thing/people)|ठंडा; लोग
ねむい|nemui|眠い|sleepy|निद्राजनक; शांत; उनींदा
かんたん|kantan|簡単|easy; simple|आसान; सरल
かかる|kakaru||to take (amount of time / money)|पैसा
とまる|tomaru|泊まる|to stay (at a hotel, etc.)|रुकना
なる|naru||to become|बनना
はらう|harau|払う|to pay|भुगतान करना
きめる|kimeru|決める|to decide|निर्णय लेना
れんしゅうする|renshuusuru|練習する|to practice|अभ्यास; कार्यप्रणाली; वकालत करना
あるいて|aruite|歩いて|on foot|पैदल
いちばん|ichiban|一番|best|सर्वश्रेष्ठ
このごろ|konogoro||these days|आजकल
どうやって|douyatte||how; by what means|कैसे
どちら|dochira||which|कौन सा
どのぐらい|donogurai||how much; how long|कितना; कैसे
はやく|hayaku|早く|(do something) early; fast|जल्दी; तेज़
おかし|okashi|お菓子|snack; sweets|अल्पाहार; अल्पाहार/हल्का नाशता; अल्पाहार करना
おしょうがつ|oshougatsu|お正月|New Year's|नववर्ष दिन
おとこのこ|otokonoko|男の子|boy|लड़का
おもちゃ|omocha||toy|खिलौना
おんなのこ|onnanoko|女の子|girl|लड़की
がいこく|gaikoku|外国|foreign country|विदेशी
かしゅ|kashu|歌手|singer|गायक; गायिका; गवैया
キャンプ|kyanpu||camp|डेरा डालना; शिविर लगाना; कैंप
こちら|kochira||this person (polite)|
こんがっき|kongakki|今学期|this semester|
しゃちょう|shachou|社長|president of a company|प्रधान; अध्यक्ष; कार्यकारी व्यवस्थापक
じゅぎょう|jugyou|授業|class|कक्षा
しょうらい|shourai|将来|future|भविष्य
ドライブ|doraibu||drive|चलाना
ビール|biru||beer|शराब; बियर{एक प्रकार की मदिरा}; बियर
びじゅつかん|bijutsukan|美術館|art museum|कला; कला संग्रहालय
ホストファミリー|hosutofamiri||host family|आयोजित करना; आयोजित; समूह
みずうみ|mizuumi|湖|lake|झील
やま|yama|山|mountain|पहाड़
ゆめ|yume|夢|dream|सपना
ルームメート|rumumeto||roommate|कमरा साथी
うそをつく|usootsuku||to tell a lie|
おなかがすく|onakagasuku||to become hungry|
かう|kau|飼う|to own (a pet)|स्वामी होना
サボる|saboru||to cut classes|
とる|toru|取る|to take (a class); to get (a grade)|लेना; पाना
ならう|narau|習う|to learn|सीखना
のぼる|noboru|登る|to climb|चढ़ना
はたらく|hataraku|働く|to work|काम
つかれる|tsukareru|疲れる|to get tired|
やめる|yameru||to quit|छोड़ देना
けんかする|kenkasuru||to have a fight; to quarrel|विवाद करना; शिकायत; झगड़ा
しょうかいする|shoukaisuru|紹介する|to introduce|लगाना; प्रस्तुत करना; पेश करना
ダイエットする|daiettosuru||to go on a diet|
ちこくする|chikokusuru|遅刻する|to be late (for an appointment)|में देर लगाना
りゅうがくする|ryuugakusuru|留学する|to study abroad|
あと|ato|後|after (an event)|बाद
しゅっしん|shusshin|出身|coming from|आनेवाला; भावी; आगमन
すごく|sugoku||very|बहुत
そして|soshite||and then|और फिर
ひさしぶり|hisashiburi|久しぶり|it has been a long time|
まあまあ|maamaa||okay; so-so|ठीक; अनुमति; हाँ
もっと|motto||more|अधिक"""), "ja", "N5", "genki"),
        Lesson("genki-7", "📗 Genki 1 · Lesson 7", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""あし|ashi|足|leg; foot|पैर; पैर
いみ|imi|意味|meaning|उद्देश्य; अर्थपूर्ण; मतलब
おなか|onaka||stomach|इच्छा; सहना; उदर
かぜ|kaze|風|cold|ठंडा
かのじょ|kanojo|彼女|girlfriend|संगिनी; सखी; सहेली
かれ|kare|彼|boyfriend|सनम; प्रेमी; पुरूष मित्र
きおん|kion|気温|temperature (weather)|ताप; तापमान
くもり|kumori|曇り|cloudy weather|मटमैला; मेघाच्छादित
しあい|shiai|試合|match; game|मिलना; जोड़िदार; जोड़ा बन्ना; खेल
ジュース|jusu||juice|शक्ति; रस; गपशप
せいせき|seiseki|成績|grade (on a test, etc.)|कोटि; पद; वर्गीकृत करना
せき|seki|咳|cough|देना; ध्वनी निकालना; खाँसी
のど|nodo||throat|कंठ; मार्ग; गला
は|ha|歯|tooth|दाँत
はな|hana|花|flower|फूल
はれ|hare|晴れ|sunny weather|हँसमुख; उजला/धूपवाला; धूपदार
ふく|fuku|服|clothes|कपड़े
ふつかよい|futsukayoi|二日酔い|hangover|पुराना; खुमार; बुरा नतीजा
プレゼント|purezento||present|उपहार
ホームシック|homushikku||homesickness|गृहासक्त्ति; गृहवियोग
もの|mono|物|thing (concrete object)|चीज़
ゆき|yuki|雪|snow|बर्फ
ようじ|youji|用事|business to take care of|व्यापार
あまい|amai|甘い|sweet|मीठा
いたい|itai|痛い|hurt; painful|दर्द पहुँचाना; चोट; ज़ख़्मी; भद्दा; कठिन; दर्दीला
おおい|ooi|多い|there are many...|
せまい|semai|狭い|narrow; not spacious|संकरा
つごうがわるい|tsugougawarui|都合が悪い|inconvenient; to have a scheduling conflict|असुविधाजनक; असुविधापूर्ण
わるい|warui|悪い|bad|बुरा
すてき|suteki|素敵|fantastic|बहुत अच्छा; शानदार; अत्यधिक
かぜをひく|kazeohiku|風邪をひく|to catch a cold|
きょうみがある|kyoumigaaru|興味がある|to be interested (in ...)|
なくす|nakusu||to lose|खोना
のどがかわく|nodogakawaku|のどが渇く|to become thirsty|
ねつがある|netsugaaru|熱がある|to have a fever|
せきがでる|sekigaderu|せきが出る|to cough|देना; ध्वनी निकालना; खाँसी
わかれる|wakareru|別れる|to break up; to separate|छोटे छोटे हिस्सों में विभाजित करना; छुट्टी शुरू होना; रुकवाना; रोकना; निकालना; भिन्न
きんちょうする|kinchousuru|緊張する|to get nervous|
しんぱいする|shinpaisuru|心配する|to worry|चिंता
いつも|itsumo||always|हमेशा
おだいじに|odaijini|お大事に|Get well soon.|पाना
げんきがない|genkiganai|元気がない|don't look well|
たぶん|tabun|多分|probably; maybe|सम्भवतः; शायद; संभवतः; शायद
できるだけ|dekirudake||as much as possible|
にさんにち|nisannichi|二三日|for two to three days|
はじめて|hajimete|初めて|for the first time|पहली बार
もうすぐ|mousugu||very soon; in a few moments/days|
ウェイター|weita||waiter|बैरा; इंतज़ार करने; वेटर
おじいさん|ojiisan||grandfather; old man|दादा; मालिक; दोस्त; बूढा आदमी
おとな|otona|大人|adult|वयस्क
がいこくご|gaikokugo|外国語|foreign language|विदेशी
がっき|gakki|楽器|musical instrument|वाद्य यंट्र; इकतारा
からて|karate|空手|karate|कराटे
カレー|kare||curry|सालन
きもの|kimono|着物|kimono; Japanese traditional dress|किमोनो; कीमोनो{जापानी पहनावा}; जापानवासी; जापानी
ケーキ|keki||cake|केक
こうこく|koukoku|広告|advertisement|विज्ञापन
こうちゃ|koucha|紅茶|tea (black tea)|चाय
ことば|kotoba|言葉|language|भाषा
ゴルフ|gorufu||golf|गोल्फ़{एक प्रकार का खेल}; गोल्फ
セーター|seta||sweater|स्वेटर; जर्सी
ぞう|zou|象|elephant|हाथी
バイオリン|baiorin||violin|सारंगी; बेला
バイク|baiku||motorbike|मोटरसाइकिल
ぶっか|bukka|物価|(consumer) prices|
ぶんぽう|bunpou|文法|grammar|व्याकरण भाषा; व्याकरण; व्याकरण की पुस्तक
べんごし|bengoshi|弁護士|lawyer|कानून का पंडित; वकील; अधिवक्ता
ぼしゅう|boshuu|募集|recruitment|भरती; नये सिपाहियों की भर्ती
みせ|mise|店|shop; store|दुकान; दुकान
やくざ|yakuza||yakuza; gangster|याकूज़ा; अपराधी; गुण्ड़ा
やくそく|yakusoku|約束|promise; appointment|वादा; वचन; नियुक्ति; नौकरी
レポート|repoto||(term) paper|कागज़
わたくし|watakushi|私|I (formal)|मैं
うれしい|ureshii||glad|खुश
かなしい|kanashii|悲しい|sad|उदास
からい|karai|辛い|hot and spicy; salty|गर्म; उत्तेजक; लवणयुक्त; नमकीन
きびしい|kibishii|厳しい|strict|सही; पक्का; सख्त
ちかい|chikai|近い|close; near|बंद करना; पास
いろいろ|iroiro||various; different kinds of|भिन्न; कई; अनेक; अलग
しあわせ|shiawase|幸せ|happy (lasting happiness)|खुश
だめ|dame||no good|
あむ|amu|編む|to knit|जुड़ना; सिकोड़ना; बुनना
かす|kasu|貸す|to lend; to rent|देना; प्रदान करना; किराये पर देना; किराया
がんばる|ganbaru|頑張る|to do one's best; to try hard|
なく|naku|泣く|to cry|रोना
みがく|migaku|磨く|to brush (teeth); to polish|खरोंच; झगड़ा; रगड़ना; चमकाना; चमक; रोगन करना
やくそくをまもる|yakusokuomamoru|約束を守る|to keep a promise|
かんどうする|kandousuru|感動する|to be moved/touched (by ...)|द्रवित; प्रभावित होना; पागल सा
いらっしゃいます|irasshaimasu||(someone honorable) is present/home|घर
じつは|jitsuha|実は|as a matter of fact, ...|वास्तव में
ぜんぶ|zenbu|全部|all|सब
いちにち|ichinichi|一日|one day|एक न एक दिन
ふつか|futsuka|二日|two days|
みっか|mikka|三日|three days|तीन
よっか|yokka|四日|four days|चार
いつか|itsuka|五日|five days|पाँच
むいか|muika|六日|six days|छह
なのか|nanoka|七日|seven days|सात
ようか|youka|八日|eight days|आठ
ここのか|kokonoka|九日|nine days|नौ
とおか|tooka|十日|ten days|दस
よろしくおねがいします|yoroshikuonegaishimasu|よろしくお願いします|Thank you (in advance)|धन्यवाद; धन्यबाद पट्र; धन्यबाद देना"""), "ja", "N4", "genki"),
        Lesson("genki-8", "📗 Genki 1 · Lesson 8", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""ぬいぐるみ|nuigurumi||stuffed animal (e.g., teddy bear)|भरा हुआ; भरा; ठुँसा हुआ
あに|ani|兄|(my) older brother|बड़ा भाई
おおやさん|ooyasan|大家さん|landlord|शराबखाने का मालिक; शराबखाने; मकान मालिक
おかえし|okaeshi|お返し|return (as a token of gratitude)|लौटना
おくさん|okusan|奥さん|(your/his) wife|तुम्हारा; उसका
おじさん|ojisan||uncle; middle-aged man|चाचा
おばさん|obasan||aunt; middle-aged woman|चाची
クラブ|kurabu||club; student society|मिलना; संघ; एकट्र करना; छात्र
クリスマス|kurisumasu||Christmas|क्रिसमस; बड़ा; बड़ा दिन
ごしゅじん|goshujin||(your/her) husband|तुम्हारा; उसका
コップ|koppu||tumbler; glass|खटका; टंबलर; कलाबाज़ी खाने वाला; गिलास
さら|sara|皿|plate; dish|थाली; भोजन; सुन्दर लड़की; परोसना
じかん|jikan|時間|time|समय
チョコレート|chokoreto||chocolate|चॉकलेट
でんしメール|denshimeru|電子メール|e-mail|
ネクタイ|nekutai||necktie|नेकटाई; गुलुबन्द
はは|haha|母|(my) mother|माँ
バレンタインデー|barentainde||St. Valentine's Day|संत
ビデオカメラ|bideokamera||camcorder|कैमकर्डर
ふうふ|fuufu|夫婦|married couple; husband and wife|विवाहित दम्पती; पति और पत्नि
ホワイトデー|howaitode||White Day|सफेद
マフラー|mafura||winter scarf|सर्दी
まんが|manga|漫画|comic book|हास्यप्रद; हास्यजनक; चित्रकथा
マンション|manshon||multistory apartment; condominium|सहराज्य; कन्डोमिनियम
みかん|mikan||mandarin|नारंगी; चीनी; मंडारिन{चीन की मानक भाषा}
ゆびわ|yubiwa|指輪|ring|गोला बनाना; बजना; टेलीफोन करना
りょうしん|ryoushin|両親|parents|अभिभावक
りれきしょ|rirekisho|履歴書|resume|फिर आरम्भ करना; सार; पुनः प्राप्त करना
ほしい|hoshii|欲しい|to want|चाहना
けち|kechi||stingy; cheap|कंजूस; ज़रा सा; सस्ता
おくる|okuru|送る|to send|भेजना
にあう|niau|似合う|to look good (on somebody)|अच्छा होना
あきらめる|akirameru||to give up|त्याग देना; छोडना; हार मान लेना
あげる|ageru||to give (to others)|देना
くれる|kureru||to give (me)|देना
できる|dekiru||to come into existence; to be made|
そうだんする|soudansuru|相談する|to consult|विचार विमर्श करना; राय; राय लेना
プロポーズする|puropozusuru||to propose marriage|
おなじ|onaji|同じ|same|समान
きょねん|kyonen|去年|last year|आखिरी
わたしたち|watashitachi|私たち|we|हम
ちょうど|choudo||exactly|वास्तव में; ठीक ठीक/यथार्थतः; वास्तव
よく|yoku||well|अच्छी तरह
こ|ko|個|[generic counter for smaller items]|
さつ|satsu|冊|[counter for bound volumes]|
だい|dai|台|[counter for equipment]|
ひき|hiki|匹|[counter for smaller animals]|
ぽん|pon|本|[counter for long objects]|
え|e|絵|painting; picture; drawing|चित्र; चित्रकारी; चित्रकला; तस्वीर; चित्रकारी; चिट्रंकनअ; चिट्रकारी
えいがかん|eigakan|映画館|movie theater|चिट्रालय
がいこくじん|gaikokujin|外国人|foreigner|परदेशी; विदेशी
かぐ|kagu|家具|furniture|उपस्कर; फर्नीचर
かんこう|kankou|観光|sightseeing|दर्शनीय स्थल देखना
けっこんしき|kekkonshiki|結婚式|wedding|विवाह; ब्याह
じしん|jishin|地震|earthquake|भूचाल; भूकम्प; भुकम्प
しめきり|shimekiri|締め切り|deadline|सीमारेखा; अंतिम तिथि
ジャケット|jaketto||jacket|जैकेट; धातु; दंत टोप
しゅうかん|shuukan|習慣|custom|दर्ज़ी से सिली हुई; रीति; प्रथा
ぜいきん|zeikin|税金|tax|शुल्क लगाना; दाम; शुल्क
そつぎょうしき|sotsugyoushiki|卒業式|graduation ceremony|क्रम; क्रमस्थापन
そば|soba||Japanese buckwheat noodle|जापानवासी; जापानी
ちず|chizu|地図|map|नक्शा
でんち|denchi|電池|battery|समूह; तोपखाना; संग्रह
にわ|niwa|庭|garden|बगीचा
はっぴょう|happyou|発表|presentation|प्रदर्शन; व्याख्यान; उपहारअ
ばんぐみ|bangumi|番組|broadcast program|फैलाना; गाना; प्रचार करना
プール|puru||swimming pool|तैरने का तालाब; तरण ताल; तरणताल
ペット|petto||pet|दुलारा; दुलारना; प्रिय व्यक्ति
よてい|yotei|予定|schedule|अनुसूची; योजना लेख; सूची
りょかん|ryokan|旅館|inn|सराय; धर्मशाला; पांथशाला
わりびきけん|waribikiken|割引券|discount coupon|कम करना; खंडन करना; छूट
ひろい|hiroi|広い|spacious; wide|विस्तृत; विशाल; बड़ा; चौड़ा
うる|uru|売る|to sell|बेचना
おろす|orosu|下ろす|to withdraw (money)|हटाना; अलग करना; हटा लेना
かく|kaku||to draw; to paint|चित्र बनाना; रंग
さがす|sagasu|探す|to look for|ढूँढना
さそう|sasou|誘う|to invite|आमंत्रित करना
つきあう|tsukiau|付き合う|(1) to date (someone) (2) to keep company|
つく|tsuku|着く|to arrive|पहुँचना
ほけんにはいる|hokennihairu|保険に入る|to buy insurance|
きをつける|kiotsukeru|気をつける|to be cautious/careful|सावधान
しらべる|shiraberu|調べる|to look into (a matter)|ढूँढ़ना; जाँच पड़ताल करना
すてる|suteru|捨てる|to throw away|गँवाना; बर्बाद कर देना; जानबूझकर लापरवाही से बोलना
みえる|mieru|見える|to be visible|
する|suru||to decide on (an item)|के पक्ष में निर्णय लेना
そつぎょうする|sotsugyousuru|卒業する|to graduate (from ...)|स्नातक; डीग्री प्रप्त; स्नातकोत्तर
よやくする|yoyakusuru|予約する|to reserve|संचय; अलग छोड़; प्रतिबंध
いちにちじゅう|ichinichijuu|一日中|all day long|
さいきん|saikin|最近|recently|हाल ही में; अभी अभी; हाल मेँ"""), "ja", "N4", "genki"),
        Lesson("genki-9", "📗 Genki 1 · Lesson 9", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""えきいん|ekiin|駅員|station attendant|स्टेशन
おや|oya|親|parent|माता-पिता
ごみ|gomi||garbage|बकवास; कूड़ा दानी; कूड़ा
さとう|satou|砂糖|sugar|चीनी
しょうがくきん|shougakukin|奨学金|scholarship|छात्रवृत्ति; विद्वत्ता; पाण्डित्य
しんせき|shinseki|親せき|relatives|
すいせんじょう|suisenjou|推薦状|letter of recommendation|पत्र
だいがくいん|daigakuin|大学院|graduate school|स्नातक विद्यालय
たいふう|taifuu|台風|typhoon|प्रचंड तूफ़ान; प्रचण्ड तूफान; प्रचंड
ひ|hi|日|day|दिन
ファイル|fairu||file; portfolio|रेती; पंक्ति; चिकना करना; वर्ग; श्रेणी; विभाग
みち|michi|道|way; road; directions|रास्ता; सड़क; रास्ता
めざましどけい|mezamashidokei|目覚まし時計|alarm clock|अलार्म घड़ी
きたない|kitanai|汚い|dirty|गंदा
おこす|okosu|起こす|to wake (someone) up|उठाना; सतर्क रहना; जगाना
おごる|ogoru||to treat (someone) to a meal|
おちこむ|ochikomu|落ち込む|to get depressed|
こまる|komaru|困る|to have difficulty|
だす|dasu|出す|to take (something) out; to hand in (something)|करना; निकालना; भोजन; देना
つれていく|tsureteiku|連れていく|to take (someone) to (a place)|शरण लेना; पसन्द आना; पसन्द
なおす|naosu|直す|to correct; to fix|सही; बदला लेना; लगाना; निश्चित करना
みちにまよう|michinimayou|道に迷う|to become lost; to lose one's way|
やくす|yakusu|訳す|to translate|समझना; बदलना; ले जाना
わらう|warau|笑う|to laugh|हँसना
アイロンをかける|aironokakeru||to iron (clothes)|कर्कश; कठोर; निर्दय
あつめる|atsumeru|集める|to collect|इकट्ठा करना
いれる|ireru|入れる|to put (something) in|लगाना; काम लगाना; लिखना
のりおくれる|noriokureru|乗り遅れる|to miss (a train, bus, etc.)|चूकना
みせる|miseru|見せる|to show|दिखलाना
あさねぼうする|asanebousuru|朝寝坊する|to oversleep|अधिक देर तक सोते रहना; देर तक सोया रह जाना
あんないする|annaisuru|案内する|to show (someone) around|
せつめいする|setsumeisuru|説明する|to explain|बताना; विवरण देना; व्यक्त
むかえにくる|mukaenikuru|迎えに来る|to come to pick up (someone)|
ええと|eeto||well...; let me see...|अच्छी तरह; मुझे याद करने दो
きょうじゅうに|kyoujuuni|今日中に|by the end of today|
このあいだ|konoaida|この間|the other day|हाल ही में
このぐらい|konogurai||about this much|
ごめん|gomen||I'm sorry. (casual)|माफ़ कीजिए
しつれいします|shitsureishimasu|失礼します|Excuse me..; Sorry to interrupt you.|क्षमा; क्षमा करें; माफ़ करना
じぶんで|jibunde|自分で|(do something) oneself|अपने आप; खुद; स्वयं/खुद
じゅぎょうちゅうに|jugyouchuuni|授業中に|in class; during the class|के दौरान
ほかの|hokano||other|अन्य
おきゃくさん|okyakusan|お客さん|guest; visitor; client; customer|मेहमान; पर्यटक; मिलनेवाला; दर्शक; उपभोगता; ग्राहक; असामी
おとこ|otoko|男|man|आदमी
おゆ|oyu|お湯|hot water|गर्म
おんな|onna|女|woman|महिला
かぎ|kagi||key|चाबी
かみ|kami|紙|paper|कागज़
きゅうりょう|kyuuryou|給料|salary|मेहनताना; वेतन; वेतन/तनखाह
コンタクト|kontakuto||contact lenses|सम्पर्क; सम्बन्ध; रोग
さいてい|saitei|最低|the lowest; the worst|जीतना; बुरी तरह से पछाड़ देना; सबसे
サラリーマン|sarariman||salaryman; company employee|कंपनी
ざんぎょう|zangyou|残業|overtime work|ओवरटाइम करने से प्राप्त; अतिरिक्त समय; ओवरटाइम
ストーブ|sutobu||heater|तापक; पानी या कमरे को गरम करने वाला यंत्र.; हीटर
たからくじ|takarakuji|宝くじ|lottery|लटरी; लाटरी
ちがい|chigai|違い|difference|झगड़ा; शेष; असमानता
ニュース|nyusu||news|समाचार
ひげ|hige||beard|खुलेआम विरोध; दाढी नोचना; गलमुच्छ
ひみつ|himitsu|秘密|secret|गुप्त; गोपनीय; रहस्यमय
りょう|ryou|寮|dormitory|शयनशाला; शयनगृह
りょこうがいしゃ|ryokougaisha|旅行会社|travel agency|यात्रा अभिकरण; ट्रैवल एजेन्सी
うらやましい|urayamashii||envious|ईर्ष्यालु; ईष्यालु/द्वेषी; असूयक
すくない|sukunai|少ない|a little; a few|थोड़ा; थोड़्; कुछ
つよい|tsuyoi|強い|strong|मजबूत
えらぶ|erabu|選ぶ|to choose; to select|चुनना; विशिष्ट; चुनना; चुनना/छाँटना
かみをとかす|kamiotokasu|髪をとかす|to comb one's hair|
おゆをわかす|oyuowakasu|お湯を沸かす|to boil water|
こむ|komu|込む|to get crowded|
たからくじにあたる|takarakujiniataru|宝くじに当たる|to win a lottery|
ぬぐ|nugu|脱ぐ|to take off (clothes)|निकालना; रोक देना; हटाना
ひげをそる|higeosoru||to shave one's beard|
いれる|ireru||to make tea, coffee, etc.|
かぎをかける|kagiokakeru||to lock|घोड़ा; गुच्छा; बंद करना
たりる|tariru|足りる|to be sufficient; to be enough|
なれる|nareru|慣れる|to get used to...|
けしょうする|keshousuru|化粧する|to put makeup on|
しゅうしょくする|shuushokusuru|就職する|to get a full-time job (at...)|
する|suru||to wear small items (necktie, watch, etc.)|
りこんする|rikonsuru|離婚する|to get a divorce|
おめでとうございます|omedetougozaimasu||Congratulations!|
じぶん|jibun|自分|oneself|अपने आप; खुद; स्वयं/खुद
ずいぶん|zuibun||very|बहुत
そうか|souka||I see. (casual)|मैं
それに|soreni||moreover, ...|इसके; इसके अलावा
たとえば|tatoeba|例えば|for example|उदाहरण; उदाहरण स्वरूप; उदाहरण के लिए
〜にくらべて|〜nikurabete|〜に比べて|compared with ...|
〜によると|〜niyoruto||according to ...|के अनुसार; के अनुरूप
まえ|mae|前|before...|पहले
やっぱり|yappari||after all|आख़िर; आख़िरकार"""), "ja", "N4", "genki"),
        Lesson("genki-10", "📗 Genki 1 · Lesson 10", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""あと|ato|後|the rest|आराम
エアコン|eakon||air conditioner|वातानुकूलक
カーテン|katen||curtain|बाधा; नाटक; पर्दा
ぎゅうにゅう|gyuunyuu|牛乳|milk|दूध
シャンプー|shanpu||shampoo|केश मार्जन; शैंपू करना; शैंपू
スイッチ|suicchi||switch|बदलना; भारी; अदला बदली करना
スカート|sukato||skirt|किनारा; किनारे पर रखना; घेरना
しょうゆ|shouyu|しょう油|soy sauce|सोया सस
そと|soto|外|outside|बाहर
タオル|taoru||towel|तौलिये से पोंछना; तौलिया; अंगपोछा
にっき|nikki|日記|diary|डायरी; दैनिक वृत्त की पुस्तिका; पाकेट
ポップコーン|poppukon||popcorn|पपकर्न
やちん|yachin|家賃|rent|किराया
ゆうがた|yuugata|夕方|evening|शाम
ラジカセ|rajikase||cassette player with a radio|कैसेट; पेटिका
るすばんでんわ|rusubandenwa|留守番電話|answering machine|उत्तर में प्राप्त
れいぞうこ|reizouko|冷蔵庫|refrigerator|रेफ्रिजरेटर
ろうそく|rousoku||candle|बत्ती; शमा; ज्योतोर्मयता का एकक
あかるい|akarui|明るい|bright|चमकीला
きぶんがわるい|kibungawarui|気分が悪い|to feel sick|उल्टी आना
はずかしい|hazukashii|恥ずかしい|embarassing; to feel embarassed|
あく|aku|開く|(something) opens|
あやまる|ayamaru|謝る|to apologize|क्षमा मांगना
おす|osu|押す|to press; to push|दबाव; प्रोत्साहित करना; घबराहट; धकेलना
おとす|otosu|落とす|to drop (something)|गिराना
おゆがわく|oyugawaku|お湯が沸く|water boils|पानी
ころぶ|korobu|転ぶ|to fall down|नीचे गिरना; गलत साबित करना; गलत
こわす|kowasu|壊す|to break (something)|तोड़ना
さく|saku|咲く|to bloom|बहार पर आना; अरूणिमा; फूल
しまる|shimaru|閉まる|(something) closes|
たすかる|tasukaru|助かる|to be saved; to be helped|
たのむ|tanomu|頼む|to ask (a favor)|पूछना
つく|tsuku||(something) turns on|
よごす|yogosu|汚す|to make dirty|
おちる|ochiru|落ちる|(something) drops|
かんがえる|kangaeru|考える|to think (about); to consider|विचार करना; विचार करना; समझना; ग़ौर
きえる|kieru|消える|(something) goes off|
こわれる|kowareru|壊れる|(something) breaks|
よごれる|yogoreru|汚れる|to become dirty|
ちゅうもんする|chuumonsuru|注文する|to place an order|
いますぐ|imasugu|今すぐ|right away|फ़ौरन
おかげで|okagede||thanks to ...|के कारण; धन्यवाद; शुक्रगुजार
おさきにしつれいします|osakinishitsureishimasu|お先に失礼します|See you. (lit., I'm leaving ahead of you.)|फिर मिलेंगे; फिर
おつかれさまでした|otsukaresamadeshita|お疲れ様でした|You must be tired after working so hard. (ritualistic expression)|
ほんとうに|hontouni|本当に|really|वास्तव में
まず|mazu||first of all|सर्वप्रथम
〜までに|〜madeni||by (time/date)|तारीख
どうしよう|doushiyou||What should I/we do?|क्या
しょうたいする|shoutaisuru|招待する|to invite someone (to an event/a place)|स्थान
おくさま|okusama|奥様|(your/his) wife (polite)|तुम्हारा; उसका
おこさん|okosan|お子さん|(your/their) child (polite)|तुम्हारा; उनका
おれい|orei|お礼|expression of gratitude|वचन; पदसंहति; अभिव्यक्ति
けいご|keigo|敬語|honorific language|आदरसूचक; सम्मानप्रद
こちら|kochira||this way (polite)|
しゅっちょう|shucchou|出張|business trip|व्यापार
しゅるい|shurui|種類|a kind; a sort|दयालु; प्रकार; वर्गीकृत करना; पसन्द करना
せいかく|seikaku|性格|personality|व्यक्तित्व; चरिट्र; विशेष चरित्र
ちゅうがくせい|chuugakusei|中学生|junior high school student|छोटा; क्निष्ठ; उम्र में छोटा
どちら|dochira||where (polite)|कहाँ
なまけもの|namakemono|怠け者|lazy person|आलसी
なやみ|nayami|悩み|worry|चिंता
はずかしがりや|hazukashigariya|恥ずかしがり屋|shy person|दूर; कम; शर्मीला
はなし|hanashi|話|chat; talk|बात; बातचीत; गपशप; बात करना
ぶちょう|buchou|部長|department manager|विभाग
ぶんか|bunka|文化|culture|समूह; संवर्धन; शिष्टता
まちがい|machigai|間違い|mistake|गलती
なかがいい|nakagaii|仲がいい|be on good/close terms; to get along well|बंद करना
まじめ|majime||serious; sober; diligent|जटिल; महत्वपूर्ण; रहस्यमय; गंभीर कर देना; गंभीर; सादा; परिश्रमी; सतत; अनवरत/उद्यमी/ उद्योगी/ एकाग्रचित्त/ परिश्रमी/ सावधान
いらっしゃる|irassharu||honorific expression for いく, くる, and いる|आदरसूचक; सम्मानप्रद
おくる|okuru|送る|to walk/drive (someone)|चलना; चलाना
おこる|okoru|怒る|to get angry|
おっしゃる|ossharu||honorific expression for いう|आदरसूचक; सम्मानप्रद
おやすみになる|oyasumininaru|お休みになる|honorific expression for ねる|आदरसूचक; सम्मानप्रद
きまる|kimaru|決まる|to be decided|
くださる|kudasaru|下さる|honorific expression for くれる|आदरसूचक; सम्मानप्रद
ごらんになる|goranninaru|ご覧になる|honorific expression for みる|आदरसूचक; सम्मानप्रद
しりあう|shiriau|知り合う|to get aquainted with|
〜ていらっしゃる|〜teirassharu||honorific expression for 〜ている|आदरसूचक; सम्मानप्रद
なさる|nasaru||honorific expression for する|आदरसूचक; सम्मानप्रद
ひっこす|hikkosu|引っ越す|to move (to another place to live)|हिलना
めしあがる|meshiagaru|召し上がる|honorific expression for たべる and のむ|आदरसूचक; सम्मानप्रद
よぶ|yobu|呼ぶ|to call (one's name); to invite|बुलाना; आमंत्रित करना
よる|yoru|寄る|to stop by|मिलनेना
おくれる|okureru|遅れる|to become late|
かける|kakeru||to sit down|बैठना; बैठ हड़ताल; बैठक भोजन परोस
はれる|hareru|晴れる|to become sunny|
もてる|moteru||to be popular (in terms of romantic interest)|
えんりょする|enryosuru|遠慮する|to hold back for the time being; to refrain from|
ごちそうする|gochisousuru||to treat/invite (someone) to a meal|देना; व्यवहार करना; विवेचन करना; आमंत्रित करना
ちゅういする|chuuisuru|注意する|to watch out; to give warning|सतर्क रहना; देखना; खबरदार रहना
はなしをする|hanashiosuru|話をする|to have a talk|
おととい|ototoi||the day before yesterday|परसों
なぜ|naze||why (=どうして)|क्यों
ほんとうは|hontouha|本当は|in fact; originally|वास्तव में; असल में; स्पष्टतः; आदि में; शुरु शुरु में
まいあさ|maiasa|毎朝|every morning|प्रतिदिन सुबह
まだ|mada||still|फिर भी
〜めいさま|〜meisama|〜名様|party of ... people|पार्टी
ようこそ|youkoso||Welcome.|स्वागत
よろしくおつたえください|yoroshikuotsutaekudasai|よろしくお伝えください|Please give my best regards (to ...)|कृपया"""), "ja", "N4", "genki"),
        Lesson("genki-11", "📗 Genki 1 · Lesson 11", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""あちら|achira||this way (polite)|
うちゅうじん|uchuujin|宇宙人|space alien|आकाशीय; आकाश; अन्तरिक्ष
おと|oto|音|sound|आवाज़
かかりのもの|kakarinomono|係の者|our person in charge|हमारा
かど|kado|角|corner|कोना
かみさま|kamisama|神様|God|भगवान
くうこう|kuukou|空港|airport|हवाई अड्डा
じ|ji|字|letter; character|पत्र; दर्जा; प्रतिष्ठा; गुण
してん|shiten|支店|branch office|ज्ञान विषय; बेलबूटे; बेलबूटे काढना
しゅみ|shumi|趣味|hobby; pastime|अभिरुचि; शौक; दोलन घोड़ा; मनोरंजन; मन्बहलाव; शौक्*अ
しょうせつ|shousetsu|小説|novel|नया; उपन्यास; अनूठा
しんごう|shingou|信号|traffic light|यातायात बत्ती; ट्रैफ़िक लाइट
スニーカー|sunika||sneakers|
せんす|sensu|扇子|fan|उत्तेजित करना; पंखा; फटकना
つき|tsuki|月|moon|चाँद
ハイヒール|haihiru||high heels|ऊँचा
ゆうべ|yuube||last night|आखिरी
おもい|omoi|重い|heavy; serious (illness)|भारी; जटिल; महत्वपूर्ण; रहस्यमय
あるく|aruku|歩く|to walk|चलना
いたす|itasu|致す|extra-modest expression for する|
いただく|itadaku|頂く|extra-modest expression for たべる and のむ|
いただく|itadaku|頂く|humble expression for もらう|विनम्र; नीचा दिखाना; नम्र
うかがう|ukagau|伺う|to humbly visit; to humbly ask|
おる|oru||extra-modest expression for いる|
ござる|gozaru||extra-modest expression for ある|
〜ておる|〜teoru||extra-modest expression for 〜ている|
〜でござる|〜degozaru||extra-modest expression for です|
まいる|mairu|参る|extra-modest expression for いく and くる|
まがる|magaru|曲がる|to turn (right/left)|बायाँ
もうす|mousu|申す|extra-modest expression for いう|
もどる|modoru|戻る|to return; to come back|लौटना; वापस आना; प्रत्युत्तर देना; याद आना
きこえる|kikoeru|聞こえる|to be audible|
さしあげる|sashiageru|差し上げる|humble expression for あげる|विनम्र; नीचा दिखाना; नम्र
つたえる|tsutaeru|伝える|to convey (message)|प्रकट करना; ले; पहुँचाना
またせる|mataseru|待たせる|to keep (someone) waiting|रूकाकर रखना; रूकाकर
こうかんする|koukansuru|交換する|to exchange|करना; बदल देना; केन्द्र
せいかつする|seikatsusuru|生活する|to lead a life|
へんぴんする|henpinsuru|返品する|to return (merchandise)|लौटना
おや|oya||Oh!|आह; ओह
〜かい|〜kai|〜階|...th floor|
かしこまりました|kashikomarimashita||Certainly.|निश्चित रूप से; निःसन्देह; अवश्य
さあ|saa||I am not sure, ...|मैं
しつれいしました|shitsureishimashita|失礼しました|I'm very sorry|
しょうしょう|shoushou|少々|a few seconds|
それでは|soredeha||if that is the case, ...|
できれば|dekireba||if possible|
まことに|makotoni|誠に|really (very polite)|वास्तव में
また|mata||again|फिर
もうしわけありません|moushiwakearimasen|申し訳ありません|You have my apologies.|
よろしかったら|yoroshikattara||if it is okay (polite)|
あかちゃん|akachan|赤ちゃん|baby|शिशु
か|ka|蚊|mosquito|मच्छर
かいぎ|kaigi|会議|business meeting; conference|व्यापार; सम्मेलन; अधिवेशन
ガソリン|gasorin||gasoline|गैसोलीन; गैसोलिन
かんきょう|kankyou|環境|environment|पर्यावरण; वातावरण; परिमंडल
けいさつ|keisatsu|警察|police; police station|पुलिस; थाना
こうじょう|koujou|工場|factory|कारखाना
こと|koto|事|things; matters|वस्ट्र; काम; सामान
しゅうでん|shuuden|終電|last train|आखिरी
スピーチ|supichi||speech|पंक्ति; भाषा; बोली
せいふ|seifu|政府|government|सरकार
ちかん|chikan||sexual offender; lascivious man|कामुक; लैंगिक; मैथुनिक; कामुक; ठरकी
どろぼう|dorobou|泥棒|burgular|
バイト|baito||abbreviation of アルバイト|संकेताक्षर; संक्षिप्त; संक्षेपण
はんにん|hannin|犯人|criminal|पापी; अपराधी; दण्ड
ポスター|posuta||poster|सूचनापत्रक; विज्ञापन; विज्ञापन/इश्तहार
むかし|mukashi|昔|old days; past|पुराना; अतीत
もんく|monku|文句|complaint|शिकायत; झगड़ा; रोग
もんくをいう|monkuoiu|文句を言う|to complain|शिकायत करना; शिकायत; दुखड़ा रोना
るす|rusu|留守|absence; not at home|अनुपस्थिति; अभाव; मृदु अपस्मार
とおい|tooi|遠い|far (away)|दूर
ひどい|hidoi||awful|नृशंस; भद्दा; डरावना
あんぜん|anzen|安全|safe|सुरक्षित
たいせつ|taisetsu|大切|precious; valuable|बहुमूल्य; उत्कृष्ट; नितान्त; बहुमूल्य; जेवर; अनमोल
めちゃくちゃ|mechakucha||messy; disorganized|फैला हुआ; अव्यव्स्थित; गंदा; अव्यवस्थित
おく|oku|置く|to put; to lay; to place|रखना; करना; गिरा देना; देना; स्थान
きがつく|kigatsuku|気が付く|to notice|सूचना; चेतावनी; देखना
ける|keru||to kick|परेशान करना; चलाना; निकालना
さす|sasu|刺す|to sting; to bite (bug); to stab|उकसाना; प्रेरित करना; दर्द होना; परेशान करना; स्वीकार करना; व्यक्त करना; घाव; प्रहार करना; दबाना
さわる|sawaru|触る|to touch|छूना
つかまる|tsukamaru|捕まる|to be arrested; to be caught|
つつむ|tsutsumu|包む|to wrap; to cover|समाप्त करना; गाउन; लपेटना; ढकना
なぐる|naguru|殴る|to strike; to hit; to punch|बजना; आक्रमण; निकालना; मारना; मुक्का मारना; उत्तेजना; दबाना
ぬすむ|nusumu|盗む|to steal; to rob|चुराना; छीनना; छीन लेना; वंचित करना
はる|haru|貼る|to post|पद; केन्द्र; प्रचार करना
ふむ|fumu|踏む|to step on|
ふる|furu||to turn down (somebody); to reject; to jilt|अस्वीकार कर देना; धीमा करना; मद्दिम करना; अस्वीकार करना; निकाल देना; बेकार; ठुकरा देना; छोड़ देना
やく|yaku|焼く|to bake|गर्म करना; तैयार; तैयार करना
やる|yaru||to give (to pets, plants, younger siblings, etc.)|देना
いじめる|ijimeru||to bully|धमकाना; शानदार; धौंस देना
きがえる|kigaeru|着替える|to change clothes|
ためる|tameru||to save money|
つづける|tsuzukeru||to continue|होना; शुरू; रखना
ほめる|homeru||to praise; to say nice things|प्रशंसा; स्तुति; कीर्ति
まちがえる|machigaeru|間違える|to make a mistake|
みつける|mitsukeru|見つける|to find|ढूँढना
じゅんびする|junbisuru|準備する|to prepare|तैयार करना
ばかにする|bakanisuru||to insult; to make a fool of ...|अपमान होना; अपमान; अपमान करना; मूर्ख बनाना; मूर्खतापूर्ण व्यवहार करके सम्मान खो देना; मूर्ख
びっくりする|bikkurisuru||to be surprised|
ひるねをする|hiruneosuru|昼寝をする|to take a nap|
れんらくする|renrakusuru|連絡する|to contact|सम्पर्क; सम्बन्ध; रोग
〜あいだに|〜aidani|〜間に|while...|काल; समय; यद्यपि
ころ|koro||time of...; when...|समय; कब
すこし|sukoshi|少し|a little|थोड़ा
とにかく|tonikaku||anyhow; anyway|किसी भी तरह; फिर भी; हर हालत; फिर भी; भी; चाहे जैसे
どうりょう|douryou|同僚|colleague|सहकार्यकर्ता; सहकर्मी"""), "ja", "N4", "genki"),
        Lesson("genki-12", "📗 Genki 1 · Lesson 12", "📗", "Genki Textbook 1 — vocabulary & phrases", gw("""あいて|aite|相手|partner|साथी; पत्नी; सहयोगी
うけつけ|uketsuke|受付|reception desk|स्वीकृति; स्वागत; स्वागत समारोह
えいかいわ|eikaiwa|英会話|English conversation|अंग्रेजी भाषा; अंग्रेज का; अंग्रेजीअ
おじょうさん|ojousan|お嬢さん|(someone's) daughter (polite)|बेटी
かじ|kaji|家事|household matters|घर के सभी लोग; परिवार; घरेलु
かぜ|kaze|風|wind|हवा
き|ki|木|tree|पेड़
きまつしけん|kimatsushiken|期末試験|final examination|अंतिम; अन्तिम; अंतिम चरण
こうはい|kouhai|後輩|junior members of a group|छोटा; क्निष्ठ; उम्र में छोटा
さる|saru|猿|monkey|बंदर
じゆう|jiyuu|自由|freedom|स्वतंत्रता; आजादी; छूट
じゅく|juku|塾|cram school|रटना; ठूँसना; ठसाठस भरना
しょるい|shorui|書類|document|लिखना; प्रपत्र; वृत्तचित्रित
せんぱい|senpai|先輩|senior members of a group|वरिष्ठ; ज्येष्ठ; अपर
ひとりぐらし|hitorigurashi|一人暮らし|living alone|जीवित; आजीविका; क्रियाशील
ぶか|buka|部下|subordinate|अधीन; गौण शब्द; मातहत
ふくしゅう|fukushuu|復習|review of lessons|परखना; सर्वेक्षण; पुनःपरीक्षण
プロジェクト|purojekuto||project|योजना बनाना; डालना; योजना
ボール|boru||ball|गेंद
むだづかい|mudazukai|無駄遣い|waste (money)|व्यर्थ; बंजर भूमि; नष्ट करना
めんきょ|menkyo|免許|license|स्वच्छंदता; लाइसेंस; अनुज्ञा प्रदान
よしゅう|yoshuu|予習|preparation of lessons|खाना; सम्पाक; अभ्यासकार्य
うるさい|urusai||noisy; annoying|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला; खीझ दिलाने वाला; खिझाऊ; खीझ दिलाने
しんぱい|shinpai|心配|worried about|चिंतित; परेशान; आशंकावान
びんぼう|binbou|貧乏|poor|गरीब
ペラペラ|perapera||fluent|धराप्रवाह; सहज; धाराप्रवाह
へん|hen|変|strange; unusual|निराला; अनोखा; आश्चर्यजनक; अपूर्व; असाधारण; असामान्य
らく|raku|楽|easy; comfortable|आसान; आरामदायक
かつ|katsu|勝つ|to win|जीतना
コピーをとる|kopiotoru|コピーを取る|to make a photocopy|
はこぶ|hakobu|運ぶ|to carry from one place to another; transport|पहुँचाना; परिवहन; सवारी
はしる|hashiru|走る|to run|दौड़ना
ひろう|hirou|拾う|to pick up (something)|पाना; रोकना; सुधार आना
ふく|fuku|吹く|to blow|प्रस्थान करना; बहना; फैलाना
ほうっておく|houtteoku|放っておく|to leave (someone/something) alone; to neglect|कुछ; उपेक्षा करना; लापरवाही; उपेक्षा
まにあう|maniau|間に合う|to be in time for|
むかえにいく|mukaeniiku|迎えに行く|to go to pick up (someone)|
けいかくをたてる|keikakuotateru|計画を立てる|to make a plan|
そだてる|sodateru|育てる|to raise; to bring up|करना; निकालना; उत्तेजित करना; बुलाना; लाना; उठाना
たすける|tasukeru|助ける|to help; to rescue|मदद; राहत; बचाना; बचाव
まける|makeru|負ける|to lose (a match)|खोना
おねがいする|onegaisuru|お願いする|to pray for help|
さんせいする|sanseisuru|賛成する|to agree|सहमत होना
しっぱいする|shippaisuru|失敗する|to fail; to be unsuccessful|असफल होना
てつやする|tetsuyasuru|徹夜する|to stay up all night|
はんたいする|hantaisuru|反対する|to oppose; to object to|रोकना; मुकाबले पर रखना; विरोध करना
ほんやくする|honyakusuru|翻訳する|to translate|समझना; बदलना; ले जाना
こんなふう|konnafuu||in this way|
ずっと|zutto||for a long time; all the time|हमेशा; पूरे समय
ぜったいに|zettaini|絶対に|definitely|निश्चित रूप से; पक्का करना; स्पष्टता से
そんなことはない|sonnakotohanai||I don't think so.|मैं
〜とか|〜toka||...for example|उदाहरण; उदाहरण स्वरूप; उदाहरण के लिए
なんども|nandomo|何度も|many times|कई
のんびり|nonbiri||in a leisurely way|
もうすこし|mousukoshi|もう少し|a little more|
おもいで|omoide|思い出|memory|स्मरण शक्ति; याद; याददाश्त
かいがいりょこう|kaigairyokou|海外旅行|trip to a foreign country|यात्रा
からだ|karada|体|body|शरीर
くつした|kutsushita|靴下|socks|
こくさいでんわ|kokusaidenwa|国際電話|international call|अंतर्राष्ट्रीय श्रमजीवी संघ; अंतर्राष्ट्रीय संघ; अन्तर्राष्ट्रीय संघटन
じゅぎょうりょう|jugyouryou|授業料|tuition|शिक्षण; शिक्षा शुल्क; अध्यापन
しょうがっこう|shougakkou|小学校|elementary school|प्राथमिक; प्राथमिक पाठशाला; प्रारम्भिक विद्यालय
せんきょ|senkyo|選挙|election|चुनाव
タイヤ|taiya||tire|थकाना; उकता देना; थका देना
ただ|tada||free of charge|मुक्त
ばしょ|basho|場所|place|स्थान
べっそう|bessou|別荘|villa; vacation home|देहाती; गृह; देहाती बँगला; अवकाश गृह
ボーナス|bonasu||bonus|सुखकर घटना; बोनस; सुखकर
ぼんおどり|bonodori|盆踊り|Bon dance (Japanese traditional dance)|
めんせつ|mensetsu|面接|interview|इंटरव्यू लेना; बातचीत; साक्षात्कार
ゆうしょく|yuushoku|夕食|dinner|रात का खाना
りそう|risou|理想|ideal|आदर्श; अनुकूल; उपयुक्त
るすばん|rusuban|留守番|looking after a house during one's absence|एक दृष्टि
まずい|mazui||(food is) terrible|भयानक
あめがやむ|amegayamu|雨がやむ|the rain stops|
いなくなる|inakunaru||(someone) is gone; to disappear|खो; अदृश्य होना; खो जाना
おせわになる|osewaninaru|お世話になる|to be in someone's care|
おなかをこわす|onakaokowasu||to have a stomachache|
ちがう|chigau|違う|to be different; wrong|गलत
なくなる|nakunaru||to be lost; to disappear|खो; अदृश्य होना; खो जाना
わるぐちをいう|waruguchioiu|悪口を言う|to talk behind someone's back|
うける|ukeru|受ける|to take (an examination, interview, etc.)|लेना
かえる|kaeru|換える|to change|बदलना
はなれる|hanareru|離れる|(something/someone) separates; parts from|कुछ; कोई; भाग
〜かおをする|〜kaoosuru|〜顔をする|to look ...(facial expression)|देखना
がっかりする|gakkarisuru||to be disappointed|
がまんする|gamansuru|我慢する|to be tolerant/patient|सहनशील; रोगी; सबर
せわをする|sewaosuru|世話をする|to take care of ...|की देखभाल करना
どうじょうする|doujousuru|同情する|to sympathize|समर्थन करना; सहानुभूति रखना; से सहमत होना
パンクする|pankusuru||(tire) goes flat|
もどってくる|modottekuru|戻ってくる|(something/someone) comes back|कुछ; कोई
ゆうしょうする|yuushousuru|優勝する|to win a championship|
いや|iya||no|नहीं
げんきでね|genkidene|元気でね|Take care of yourself.|लेना
そうそう|sousou||You are right.|
そろそろ|sorosoro||it is about time to ...|
そんな〜|sonna〜||such ...; that kind of ...|ऐसा
ものすごく|monosugoku||extremely|अत्यधिक; बहुत ही; बहुत"""), "ja", "N4", "genki")
    )

    val patterns: List<Pattern> = listOf(

        gp("genki-1", "Lesson 1 · XはYです — A is B", "X は Y です", "The basic sentence 'X is Y'. は marks the topic, です means 'is/am'. To say 'X is not Y' use じゃないです. Add か at the end to make a yes/no question. の shows possession: A の B = B of A.", "「XはYです」で「XはYだ」を表します。はが主題を、ですが「〜だ」を表します。「〜じゃないです」で否定、「〜ですか」で疑問文になります。AのBで所有を表します。", "「X है Y」का वाक्य। は विषय दिखाता है, です = 'है'। नकारात्मक के लिए じゃないです, प्रश्न के लिए か। AのB = B, A का।", """わたしはマイクです|watashi wa maiku desu|I am Mike.|मैं माइक हूँ।
マイクじゃないです|maiku ja nai desu|(It) is not Mike.|माइक नहीं हूँ।
せんせいですか|sensei desu ka|Are you a teacher?|क्या आप शिक्षक हैं?
たけしさんのほん|takeshi san no hon|Takeshi's book|ताकेशी की किताब"""),
        gp("genki-2", "Lesson 2 · これ/それ/あれ — this/that", "これ ・ それ ・ あれ", "これ = this (near me), それ = that (near you), あれ = that over there (far from both). With a noun: この/その/あの + noun. For places: ここ (here), そこ (there), あそこ (over there). だれの = whose.", "これ＝話し手の近く、それ＝聞き手の近く、あれ＝両方から遠い。名詞と一緒に使うときはこの・その・あの。場所はここ・そこ・あそこ。だれの＝誰のもの。", "これ = यह (मेरे पास), それ = वह (तुम्हारे पास), あれ = वहाँ वाला। संज्ञा से पहले この/その/あの। स्थान: ここ/そこ/あそこ।", """これはほんですか|kore wa hon desu ka|Is this a book?|क्या यह किताब है?
このかばんはわたしのです|kono kaban wa watashi no desu|This bag is mine.|यह बैग मेरा है।
トイレはあそこです|toire wa asoko desu|The toilet is over there.|शौचालय वहाँ है।
これはだれのじてんしゃですか|kore wa dare no jitensha desu ka|Whose bicycle is this?|यह साइकिल किसकी है?"""),
        gp("genki-3", "Lesson 3 · Particles を・で・に/へ・と", "を ・ で ・ に/へ ・ と", "を marks the direct object (パンを食べます = eat bread). で = place where an action happens (レストランで食べます). に/へ = direction or destination (日本へ行きます). と = together with someone (友達と行きます). Also に = time (７時に).", "を＝目的語、で＝動作の場所、に/へ＝方向・目的地、と＝一緒に。には時刻も表します。", "を = कर्म (object), で = क्रिया का स्थान, に/へ = दिशा/लक्ष्य, と = साथ।", """パンをたべます|pan o tabemasu|(I) eat bread.|मैं रोटी खाता हूँ।
レストランでたべます|resutoran de tabemasu|(I) eat at a restaurant.|मैं रेस्तराँ में खाता हूँ।
にほんへいきます|nihon e ikimasu|(I) go to Japan.|मैं जापान जाता हूँ।
ともだちとえいがをみます|tomodachi to eiga o mimasu|(I) watch a movie with a friend.|मैं दोस्त के साथ फ़िल्म देखता हूँ।"""),
        gp("genki-4", "Lesson 4 · あります/います — to exist", "あります ・ います", "あります = existence of inanimate things, います = living things. Use に for location: つくえのうえにほんがあります (there is a book on the desk). も = 'also'. Position words: うえ (top), した (bottom), まえ (front), うしろ (back), となり (next to), なか (inside), そと (outside).", "物にはあります、生き物にはいます。場所は「に」で表します。も＝〜も。位置の言葉：うえ・した・まえ・うしろ・となり・なか・そと。", "निर्जीव चीज़ों के लिए あります, जीवित के लिए います। स्थान に से।", """ねこがいます|neko ga imasu|There is a cat.|बिल्ली है।
つくえのうえにほんがあります|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर किताब है।
ぎんこうはえきのとなりです|ginkou wa eki no tonari desu|The bank is next to the station.|बैंक स्टेशन के बगल में है।"""),
        gp("genki-5", "Lesson 5 · Adjectives (い & な)", "い-けいようし ・ な-けいようし", "い-adjectives end in い (あたらしい new); negative: drop い → くない (あたらしくない). Past: かった (あたらしかった). な-adjectives (しずか quiet): negative しずかじゃない, past しずかだった. すき/きらい/じょうず/へた take が: すしがすきです.", "い形容詞は「い」で終わり、否定は「くない」、過去は「かった」。な形容詞は否定「じゃない」、過去「だった」。すき・きらい・じょうず・へたは「が」を使います。", "い-विशेषण い पर समाप्त; नकारात्मक くない; भूतकाल かった। な-विशेषण के लिए じゃない/だった।", """このほんはあたらしいです|kono hon wa atarashii desu|This book is new.|यह किताब नई है।
このへやはしずかじゃないです|kono heya wa shizuka ja nai desu|This room is not quiet.|यह कमरा शांत नहीं है。
わたしはすしがすきです|watashi wa sushi ga suki desu|I like sushi.|मुझे सुशी पसंद है।"""),
        gp("genki-6", "Lesson 6 · て-form — please, doing, may", "て-けい", "て-form of verbs: たべる→たべて, のむ→のんで, いく→いって. 〜てください = please do. 〜ています = doing now / state. 〜てもいいです = may do. 〜てはいけません = must not. をください = please give me.", "て形：たべる→たべて、のむ→のんで、いく→いって。てください＝お願い、ています＝進行・状態、てもいいです＝許可、てはいけません＝禁止。", "て-form: たべて, のんで आदि। てください = कृपया करें।", """ここにすわってください|koko ni suwatte kudasai|Please sit here.|कृपया यहाँ बैठिए।
まいあさコーヒーをのんでいます|maiasa koohii o nonde imasu|(I) drink coffee every morning.|मैं हर सुबह कॉफ़ी पीता हूँ।
ここでしゃしんをとってもいいですか|koko de shashin o totte mo ii desu ka|May I take a photo here?|क्या मैं यहाँ फ़ोटो ले सकता हूँ?"""),
        gp("genki-7", "Lesson 7 · て-form + から, 〜ても, verbs", "てから ・ ても", "Verb types: u-verbs (のむ), ru-verbs (たべる), irregular (する, くる). 〜てから = after doing X. 〜ても = even if. 〜ませんか = 'won't you...?' invitation. 〜ましょう = 'let's...'.", "動詞の種類：u-動詞・る-動詞・不規則動詞。てから＝〜した後で。ても＝〜しても。ませんか＝誘い。ましょう＝〜しましょう。", "क्रिया प्रकार: u, ru, अनियमित। てから = करने के बाद।", """おんがくをきいてから、べんきょうします|ongaku o kiite kara, benkyou shimasu|After listening to music, I study.|संगीत सुनने के बाद पढ़ाई करता हूँ।
いっしょにたべませんか|issho ni tabemasen ka|Won't you eat with me?|क्या आप साथ खाना खाएँगे?"""),
        gp("genki-8", "Lesson 8 · Short (casual) forms", "みじかいけい", "Short forms are used in casual speech and before とおもいます (I think that...), といいました (said that...). Dictionary form: たべる. ない-form: たべない. た-form: たべた. い-adj: あたらしい→あたらしくない→あたらしかった. な-adj/noun: しずか→しずかじゃない→しずかだった.", "短い形はくだけた会話や「〜とおもいます・といいました」の前に使います。辞書形・ない形・た形があります。", "Casual रूप: たべる/たべない/たべた; とおもいます = 'मुझे लगता है कि...'।", """あしたはあめだとおもいます|ashita wa ame da to omoimasu|I think it will rain tomorrow.|मुझे लगता है कल बारिश होगी।
かれはくるといいました|kare wa kuru to iimashita|He said he would come.|उसने कहा वह आएगा।"""),
        gp("genki-9", "Lesson 9 · 〜が (but), もう/まだ", "〜が ・ もう ・ まだ", "が can mean 'but': すきですが、じかんがありません (I'd like to, but I have no time). もう + past = already (もうたべました). まだ + negative = not yet (まだたべてない). から = because (at the end: 〜からです).", "が＝〜けれども。もう＝すでに。まだ＋否定＝まだ〜ない。から＝理由。", "が = 'लेकिन'। もう = पहले ही; まだ = अभी तक नहीं।", """すしはすきですが、たかです|sushi wa suki desu ga, takai desu|I like sushi, but it's expensive.|मुझे सुशी पसंद है, पर महँगी है।
もうしゅくだいをしましたか|mou shukudai o shimashita ka|Have you already done your homework?|क्या तुमने होमवर्क पहले ही किया?"""),
        gp("genki-10", "Lesson 10 · Comparison — より/のほうが/いちばん", "ひかく", "A より B のほうが... = B is more ... than A. A と B と どちら が... = which of A and B. いちばん = the most. 〜と 〜と どちらがすきですか.", "AよりBのほうが＝Bの方がAより〜。AとBとどちらが＝AとBのどちら。いちばん＝一番。", "तुलना: B のほうが A より = B, A से ज़्यादा। いちばん = सबसे।", """にほんごはえいごよりむずかしいです|nihongo wa eigo yori muzukashii desu|Japanese is harder than English.|जापानी अंग्रेज़ी से कठिन है।
しゅうまつとへいじつとどちらがすきですか|shuumatsu to heijitsu to dochira ga suki desu ka|Which do you like, weekends or weekdays?|सप्ताहांत और कार्यदिवस में क्या पसंद है?
いちばんすきなゆめはなんですか|ichiban suki na yume wa nan desu ka|What is your favorite dream?|आपका सबसे पसंदीदा सपना क्या है?"""),
        gp("genki-11", "Lesson 11 · 〜たい, 〜たことがある, 〜たり", "〜たい ・ 〜たことがある ・ 〜たり", "〜たい = want to do (たべたい). 〜たことがあります = have done before (にほんにいったことがあります). 〜たり〜たり = do things like... (たべたりのんだりする). 〜ことができます = can do / able to.", "たい＝〜したい。たことがある＝〜した経験がある。たり〜たり＝〜したり〜したり。ことができます＝できる。", "〜たい = करना चाहता हूँ। たことがある = किया हुआ है।", """にほんにいったことがあります|nihon ni itta koto ga arimasu|I have been to Japan.|मैं जापान गया हूँ।
にほんごをはなすことができます|nihongo o hanasu koto ga dekimasu|I can speak Japanese.|मैं जापानी बोल सकता हूँ।
しゅうまつはしょっぴんぐしたり、えいがをみたりします|shuumatsu wa shoppingu shitari, eiga o mitari shimasu|On weekends I do things like shopping and watching movies.|सप्ताहांत में शॉपिंग और फ़िल्में देखता हूँ।"""),
        gp("genki-12", "Lesson 12 · 〜そうです, 〜すぎます, 〜ながら", "〜そうです ・ 〜すぎます ・ 〜ながら", "〜そうです (appearance) = looks like (おいしそうです looks delicious). 〜すぎます = too much (たべすぎます eat too much). 〜ながら = while doing (テレビをみながらたべます eat while watching TV). 〜やすい/にくい = easy/hard to. 〜く/に なります = become.", "そうです＝〜のようだ（見た目）。すぎます＝過ぎる。ながら＝〜しながら。やすい・にくい＝〜しやすい・〜しにくい。なります＝〜になる。", "そうです = 'लगता है'। すぎます = बहुत ज़्यादा। ながら = करते हुए।", """このケーキはおいしそうです|kono keeki wa oishisou desu|This cake looks delicious.|यह केक स्वादिष्ट लग रहा है।
たべすぎました|tabesugimashita|I ate too much.|मैंने बहुत ज़्यादा खा लिया।
おんがくをききながらべんきょうします|ongaku o kikinagara benkyou shimasu|I study while listening to music.|मैं संगीत सुनते हुए पढ़ता हूँ।"""),
    )
}
