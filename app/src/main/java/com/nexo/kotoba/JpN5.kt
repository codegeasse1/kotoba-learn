package com.nexo.kotoba

object JpN5 {

    val lessons = listOf(
        L.ja("j5-01", "Question words", "❓", "Ask everything: what, who, when, where, why, how.", "N5", """
            なに|nani|何|what|क्या
            だれ|dare|誰|who|कौन
            いつ|itsu|いつ|when|कब
            どこ|doko|どこ|where|कहाँ
            どう|dou|どう|how|कैसे
            なぜ|naze|何故|why|क्यों
            いくつ|ikutsu|幾つ|how many / how old|कितने / कितनी उम्र
            いくら|ikura|幾ら|how much (money)|कितना (पैसा)
            どの|dono|どの|which (of these)|कौन सा
            どれ|dore|どれ|which one|कौन-सा
        """),
        L.ja("j5-02", "Days of the week", "📅", "Monday to Sunday — plan your week in Japanese.", "N5", """
            げつようび|getsuyoubi|月曜日|Monday|सोमवार
            かようび|kayoubi|火曜日|Tuesday|मंगलवार
            すいようび|suiyoubi|水曜日|Wednesday|बुधवार
            もくようび|mokuyoubi|木曜日|Thursday|गुरुवार
            きんようび|kinyoubi|金曜日|Friday|शुक्रवार
            どようび|doyoubi|土曜日|Saturday|शनिवार
            にちようび|nichiyoubi|日曜日|Sunday|रविवार
            なんようび|nanyoubi|何曜日|what day|कौन-सा दिन
            きょう|kyou|今日|today|आज
            あした|ashita|明日|tomorrow|कल (आने वाला)
        """),
        L.ja("j5-03", "Months & dates", "🗓️", "January to December and the days of the month.", "N5", """
            いちがつ|ichigatsu|一月|January|जनवरी
            にがつ|nigatsu|二月|February|फ़रवरी
            さんがつ|sangatsu|三月|March|मार्च
            しがつ|shigatsu|四月|April|अप्रैल
            ごがつ|gogatsu|五月|May|मई
            ろくがつ|rokugatsu|六月|June|जून
            なのか|nanoka|七日|7th (of the month)|७ तारीख़
            とおか|tooka|十日|10th (of the month)|१० तारीख़
            じゅうごにち|juugonichi|十五日|15th|१५ तारीख़
            なんにち|nannichi|何日|what date|कौन-सी तारीख़
        """),
        L.ja("j5-04", "Time of day", "⏰", "Hours, half-hours and morning/afternoon/evening.", "N5", """
            いま|ima|今|now|अभी
            じ|ji|時|o'clock|बजे
            ふん|fun|分|minutes|मिनट
            はん|han|半|half past|साढ़े
            ごぜん|gozen|午前|a.m. / morning|पूर्वाह्न / सुबह
            ごご|gogo|午後|p.m. / afternoon|अपराह्न / दोपहर बाद
            あさ|asa|朝|morning|सुबह
            ひる|hiru|昼|noon / daytime|दोपहर
            よる|yoru|夜|night|रात
            ばん|ban|晩|evening|शाम
        """),
        L.ja("j5-05", "Counting people & things", "🧮", "The essential counters: 人, つ, 個, 本, 枚.", "N5", """
            ひとり|hitori|一人|one person|एक व्यक्ति
            ふたり|futari|二人|two people|दो व्यक्ति
            さんにん|sannin|三人|three people|तीन व्यक्ति
            よにん|yonin|四人|four people|चार व्यक्ति
            ひとつ|hitotsu|一つ|one (thing)|एक
            ふたつ|futatsu|二つ|two (things)|दो
            みっつ|mittsu|三つ|three (things)|तीन
            よっつ|yottsu|四つ|four (things)|चार
            いつつ|itsutsu|五つ|five (things)|पाँच
            なんにん|nannin|何人|how many people|कितने लोग
        """),
        L.ja("j5-06", "Places in town", "🏙️", "School, hospital, bank, station — find your way around.", "N5", """
            がっこう|gakkou|学校|school|स्कूल
            びょういん|byouin|病院|hospital|अस्पताल
            こうえん|kouen|公園|park|पार्क
            ぎんこう|ginkou|銀行|bank|बैंक
            ゆうびんきょく|yuubinkyoku|郵便局|post office|डाकघर
            としょかん|toshokan|図書館|library|पुस्तकालय
            えき|eki|駅|train station|स्टेशन
            くうこう|kuukou|空港|airport|हवाई अड्डा
            みせ|mise|店|shop|दुकान
            トイレ|toire|トイレ|toilet|शौचालय
        """),
        L.ja("j5-07", "Family & people", "👨‍👩‍👧‍👦", "Talk about your family with the humble forms.", "N5", """
            ちち|chichi|父|my father|मेरे पिता
            はは|haha|母|my mother|मेरी माँ
            あに|ani|兄|my older brother|मेरा बड़ा भाई
            あね|ane|姉|my older sister|मेरी बड़ी बहन
            おとうと|otouto|弟|younger brother|छोटा भाई
            いもうと|imouto|妹|younger sister|छोटी बहन
            そふ|sofu|祖父|grandfather|दादा
            そぼ|sobo|祖母|grandmother|दादी
            きょうだい|kyoudai|兄弟|siblings|भाई-बहन
            こども|kodomo|子供|child|बच्चा
        """),
        L.ja("j5-08", "Everyday verbs II", "🏃", "Wake up, leave, work, rest — the verbs of daily life.", "N5", """
            おきる|okiru|起きる|to wake up / get up|उठना
            でかける|dekakeru|出かける|to go out|बाहर जाना
            かえる|kaeru|帰る|to return home|घर लौटना
            はたらく|hataraku|働く|to work|काम करना
            やすむ|yasumu|休む|to rest / take a day off|आराम करना
            あそぶ|asobu|遊ぶ|to play|खेलना
            およぐ|oyogu|泳ぐ|to swim|तैरना
            あるく|aruku|歩く|to walk|चलना
            つとめる|tsutomeru|勤める|to work (for a company)|नौकरी करना
            ならう|narau|習う|to learn (from someone)|सीखना
        """),
        L.ja("j5-09", "Food & taste", "🍜", "Vegetables, fruit and the five basic tastes.", "N5", """
            やさい|yasai|野菜|vegetables|सब्ज़ियाँ
            くだもの|kudamono|果物|fruit|फल
            たまご|tamago|卵|egg|अंडा
            あまい|amai|甘い|sweet|मीठा
            からい|karai|辛い|spicy / hot|तीखा
            すっぱい|suppai|酸っぱい|sour|खट्टा
            にがい|nigai|苦い|bitter|कड़वा
            しょっぱい|shoppai|しょっぱい|salty|नमकीन
            おいしい|oishii|美味しい|delicious|स्वादिष्ट
            まずい|mazui|不味い|tastes bad|बेस्वाद
        """),
        L.ja("j5-10", "Weather & seasons", "🌦️", "Spring, summer, autumn, winter — and the forecast.", "N5", """
            てんき|tenki|天気|weather|मौसम
            きせつ|kisetsu|季節|season|ऋतु
            はる|haru|春|spring|वसंत
            なつ|natsu|夏|summer|गर्मी
            あき|aki|秋|autumn|शरद
            ふゆ|fuyu|冬|winter|सर्दी
            はれ|hare|晴れ|sunny|धूप
            くもり|kumori|曇り|cloudy|बादल
            あつい|atsui|暑い|hot (weather)|गर्म
            さむい|samui|寒い|cold (weather)|ठंडा
        """),
        L.ja("j5-11", "Adjectives II", "🌟", "Expensive, cheap, near, far, easy, difficult.", "N5", """
            たかい|takai|高い|expensive / high|महँगा / ऊँचा
            やすい|yasui|安い|cheap|सस्ता
            ちかい|chikai|近い|near|पास
            とおい|tooi|遠い|far|दूर
            あたらしい|atarashii|新しい|new|नया
            ふるい|furui|古い|old (things)|पुराना
            むずかしい|muzukashii|難しい|difficult|कठिन
            かんたん|kantan|簡単|easy / simple|आसान
            つよい|tsuyoi|強い|strong|मज़बूत
            よわい|yowai|弱い|weak|कमज़ोर
        """),
        L.ja("j5-12", "Numbers 11–100", "🔢", "Two-digit numbers — the key to prices and ages.", "N5", """
            じゅういち|juuichi|十一|eleven|ग्यारह
            じゅうに|juuni|十二|twelve|बारह
            にじゅう|nijuu|二十|twenty|बीस
            にじゅうご|nijuugo|二十五|twenty-five|पच्चीस
            さんじゅう|sanjuu|三十|thirty|तीस
            よんじゅう|yonjuu|四十|forty|चालीस
            ごじゅう|gojuu|五十|fifty|पचास
            ひゃく|hyaku|百|hundred|सौ
            せん|sen|千|thousand|हज़ार
            まん|man|万|ten thousand|दस हज़ार
        """)
    )

    val patterns = listOf(
        L.jp("jpN5-a", "～を ください — 'please give me ~'", "〜をください", "N5",
            "Add をください to a noun to ask for it politely. It is a fixed phrase used with shopping and ordering — the verb 'give' is hidden inside ください.",
            "名詞＋をください。店やレストランで、物を丁寧に頼む表現。",
            "「〜をください」= कृपया मुझे ~ दीजिए। दुकान/रेस्तराँ में चीज़ माँगने का विनम्र तरीक़ा।",
            """
                ★コーヒーをください。|koohii wo kudasai|Please give me a coffee.|कृपया मुझे कॉफ़ी दीजिए।
                ★この 本を ください。|kono hon wo kudasai|Please give me this book.|कृपया यह किताब दीजिए।
                ★みずを ください。|mizu wo kudasai|Please give me some water.|कृपया मुझे पानी दीजिए।
            """),
        L.jp("jpN5-b", "～に あります / います — location of things", "〜にあります・います",
            "N5", "For the location of a thing (あります) or a person/animal (います): ［place］に ［thing/person］が あります/います. The particle に marks where.",
            "［場所］に［物・人］が あります／います。存在の場所を示す。",
            "「〜に…があります/います」= ~ में … है (चीज़ के लिए あります, व्यक्ति/जानवर के लिए います)।",
            """
                ★つくえの うえに ほんが あります。|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर किताब है।
                ★こうえんに こどもが います。|kouen ni kodomo ga imasu|There are children in the park.|पार्क में बच्चे हैं।
                ★ぎんこうは えきの となりに あります。|ginkou wa eki no tonari ni arimasu|The bank is next to the station.|बैंक स्टेशन के बगल में है।
            """),
        L.jp("jpN5-c", "～が あります — 'I have ~'", "〜があります",
            "N5", "The same あります, but with the owner first: ［person］は ［thing］が あります. Use が with the thing you have, not を.",
            "［人］は［物］が あります。「持っている」の意味。",
            "「〜が あります」= मेरे पास ~ है (चीज़ रखना)। यहाँ を की जगह が लगता है।",
            """
                ★わたしは じかんが あります。|watashi wa jikan ga arimasu|I have time.|मेरे पास समय है।
                ★かれは くるまが あります。|kare wa kuruma ga arimasu|He has a car.|उसके पास कार है।
                ★おかねが ありますか。|okane ga arimasu ka|Do you have money?|क्या आपके पास पैसे हैं?
            """),
        L.jp("jpN5-d", "い-adjective past — ～かったです", "〜かったです",
            "N5", "To make an い-adjective past/affirmative, drop い and add かったです: たかい → たかかったです (was expensive). Negative past: たかく なかったです.",
            "い形容詞の過去形。語尾の「い」を取って「かったです」を付ける。",
            "い-विशेषण का भूतकाल: अंत का い हटाकर かったです जोड़ें। जैसे たかい→たかかったです (महँगा था)।",
            """
                ★きのうは さむかったです。|kinou wa samukatta desu|It was cold yesterday.|कल ठंड थी।
                ★あの テストは むずかしかったです。|ano tesuto wa muzukashikatta desu|That test was difficult.|वह परीक्षा कठिन थी।
                ★その ほんは たかく なかったです。|sono hon wa takaku nakatta desu|That book was not expensive.|वह किताब महँगी नहीं थी।
            """),
        L.jp("jpN5-e", "～ましょうか — 'shall I ~?'", "〜ましょうか",
            "N5", "Offer help or suggest doing something together. ドアを あけましょうか = 'Shall I open the door?'",
            "相手に申し出る・誘う表現。「〜しましょうか」。",
            "「〜ましょうか」= क्या मैं ~ करूँ? / क्या हम ~ करें? (मदद की पेशकश या सुझाव)।",
            """
                ★ドアを あけましょうか。|doa wo akemashou ka|Shall I open the door?|क्या मैं दरवाज़ा खोलूँ?
                ★いっしょに たべましょうか。|issho ni tabemashou ka|Shall we eat together?|क्या हम साथ खाएँ?
                ★てつだいましょうか。|tetsudaimashou ka|Shall I help?|क्या मैं मदद करूँ?
            """),
        L.jp("jpN5-f", "もう / まだ — 'already' and 'not yet'", "もう・まだ",
            "N5", "もう + past = already done. まだ + negative present = not yet. They are almost always the first word of the sentence.",
            "「もう」= すでに、「まだ」= まだ〜していない。",
            "「もう」+ भूतकाल = पहले ही हो चुका। 「まだ」+ नकारात्मक = अभी तक नहीं।",
            """
                ★もう たべました。|mou tabemashita|I already ate.|मैं पहले ही खा चुका हूँ।
                ★まだ たべていません。|mada tabete imasen|I haven't eaten yet.|मैंने अभी तक नहीं खाया।
                ★もう おわりましたか。|mou owarimashita ka|Is it already over?|क्या यह पहले ही ख़त्म हो गया?
            """),
        L.jp("jpN5-g", "～と いっしょに — 'together with ~'", "〜といっしょに",
            "N5", "いっしょに (together) plus と (with): ［person］と いっしょに + verb. If the companion is clear, いっしょに alone works.",
            "「〜と一緒に」で「〜と共に」の意味。",
            "「〜と いっしょに」= ~ के साथ (एक साथ)।",
            """
                ★ともだちと いっしょに いきます。|tomodachi to issho ni ikimasu|I'll go together with my friend.|मैं दोस्त के साथ जाऊँगा।
                ★かぞくと いっしょに たべました。|kazoku to issho ni tabemashita|I ate with my family.|मैंने परिवार के साथ खाया।
                ★いっしょに かえりましょう。|issho ni kaerimashou|Let's go home together.|चलो साथ में घर चलें।
            """),
        L.jp("jpN5-h", "～を おねがいします — 'I'd like ~ (please)'", "〜をおねがいします",
            "N5", "Softer than ください for ordering or requesting at shops/restaurants. みずを おねがいします = 'I'd like water, please.'",
            "丁寧に注文・依頼する表現。",
            "「〜を おねがいします」= कृपया ~ चाहिए (आदेश/अनुरोध का विनम्र तरीक़ा)।",
            """
                ★ビールを おねがいします。|biiru wo onegaishimasu|I'd like a beer, please.|कृपया एक बियर दीजिए।
                ★かいだんを おねがいします。|kaidan wo onegaishimasu|Stairs, please (to the stairs).|कृपया सीढ़ियाँ (की ओर)।
                ★おかんじょうを おねがいします。|okanjou wo onegaishimasu|The bill, please.|कृपया बिल दीजिए।
            """)
    )
}
