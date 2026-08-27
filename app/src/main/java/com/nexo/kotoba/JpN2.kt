package com.nexo.kotoba

object JpN2 {

    val lessons = listOf(
        L.ja("j2-01", "Keigo verbs (respect)", "🎩", "The special respect verbs: go, come, be, say, do, eat.", "N2", """
            いらっしゃる|irassharu|いらっしゃる|to go/come/be (respect)|जाना/आना/होना (सम्मान)
            おっしゃる|ossharu|おっしゃる|to say (respect)|कहना (सम्मान)
            なさる|nasaru|なさる|to do (respect)|करना (सम्मान)
            めしあがる|meshiagaru|召し上がる|to eat/drink (respect)|खाना/पीना (सम्मान)
            ごらんに なる|goran ni naru|ご覧になる|to see (respect)|देखना (सम्मान)
            くださる|kudasaru|下さる|to give (to me, respect)|देना (मुझे, सम्मान)
            おききに なる|okiki ni naru|お聞きになる|to listen/ask (respect)|सुनना/पूछना (सम्मान)
            おこしに なる|okoshi ni naru|お越しになる|to come (respect)|आना (सम्मान)
            おめし になる|omeshi ni naru|お召しになる|to wear (respect)|पहनना (सम्मान)
            いらっしゃい|irasshai|いらっしゃい|welcome / come in|स्वागत है
        """),
        L.ja("j2-02", "Keigo verbs (humble)", "🙇", "Humble verbs to lower yourself politely.", "N2", """
            まいる|mairu|参る|to go/come (humble)|जाना/आना (विनम्र)
            いたす|itasu|致す|to do (humble)|करना (विनम्र)
            いただく|itadaku|頂く|to receive/eat (humble)|पाना/खाना (विनम्र)
            もうしあげる|moushiageru|申し上げる|to say (humble)|कहना (विनम्र)
            うけたまわる|uketamawaru|承る|to hear/receive (humble)|सुनना/स्वीकारना (विनम्र)
            ぞんじる|zonjiru|存じる|to know/think (humble)|जानना/सोचना (विनम्र)
            おめに かかる|ome ni kakaru|お目にかかる|to meet (humble)|मिलना (विनम्र)
            うかがう|ukagau|伺う|to ask/visit (humble)|पूछना/मिलने जाना (विनम्र)
            たてまつる|tatematsuru|奉る|to present (humble)|भेंट करना (विनम्र)
            さしあげる|sashiageru|差し上げる|to give (humble)|देना (विनम्र)
        """),
        L.ja("j2-03", "News & statements", "🗞️", "Announcements, decisions and declarations.", "N2", """
            はっぴょう|happyou|発表|announcement / presentation|घोषणा
            けってい|kettei|決定|decision|निर्णय
            ひょうめい|hyoumei|表明|statement / expression|वक्तव्य
            せいめい|seimei|声明|declaration|घोषणा
            けんかい|kenkai|見解|view / opinion|दृष्टिकोण
            はんだん|handan|判断|judgment|निर्णय / विचार
            ていあん|teian|提案|proposal|प्रस्ताव
            とうひょう|touhyou|投票|vote|मतदान
            ごうい|goui|合意|agreement|सहमति
            ひはん|hihan|批判|criticism|आलोचना
        """),
        L.ja("j2-04", "Formal paperwork", "📄", "Applications, procedures and documents.", "N2", """
            ていしゅつ|teishutsu|提出|submission|जमा करना
            かくにん|kakunin|確認|confirmation|पुष्टि
            しょうさい|shousai|詳細|details|विवरण
            とうじつ|toujitsu|当日|that very day|उसी दिन
            しょるい|shorui|書類|documents|दस्तावेज़
            てつづき|tetsuzuki|手続き|procedure|प्रक्रिया
            もうしこみ|moushikomi|申し込み|application|आवेदन
            きてい|kitei|規定|regulation / rule|विनियम
            むりょう|muryou|無料|free of charge|निःशुल्क
            きんむ|kinmu|勤務|duty / service|ड्यूटी / कार्य
        """),
        L.ja("j2-05", "Abstract & social", "🌐", "Culture, history, environment and cooperation.", "N2", """
            けいけん|keiken|経験|experience|अनुभव
            じんせい|jinsei|人生|life (one's life)|ज़िंदगी
            ぶんか|bunka|文化|culture|संस्कृति
            れきし|rekishi|歴史|history|इतिहास
            かんきょう|kankyou|環境|environment|पर्यावरण
            しぜん|shizen|自然|nature|प्रकृति
            そんちょう|sonchou|尊重|respect|सम्मान
            きょうりょく|kyouryoku|協力|cooperation|सहयोग
            さんか|sanka|参加|participation|भागीदारी
            そち|sochi|措置|measure / step|उपाय
        """),
        L.ja("j2-06", "Feeling & certainty", "🎯", "Adverbs that shape opinion: surely, probably, actually.", "N2", """
            やはり|yahari|やはり|as expected|जैसा सोचा था
            たしかに|tashika ni|確かに|certainly / indeed|निश्चित रूप से
            なるほど|naruhodo|なるほど|I see / indeed|समझा / सचमुच
            もちろん|mochiron|勿論|of course|बेशक
            ぜったいに|zettai ni|絶対に|absolutely|बिल्कुल
            きっと|kitto|きっと|surely|ज़रूर
            たぶん|tabun|多分|probably|शायद
            もし|moshi|もし|if|अगर
            ぜひ|zehi|是非|by all means|ज़रूर / हर हाल में
            いがいに|igai ni|意外に|surprisingly|हैरानी से
        """),
        L.ja("j2-07", "Comparison & change", "⚖️", "Contrast, alternatives and reversal.", "N2", """
            むしろ|mushiro|むしろ|rather / instead|बल्कि
            かえって|kaette|かえって|on the contrary|उल्टे
            あえて|aete|敢えて|dare to / deliberately|जान-बूझकर
            せっかく|sekkaku|せっかく|(it's a pity to waste) the effort|की मेहनत (व्यर्थ न जाए)
            わざわざ|wazawaza|わざわざ|specially / on purpose|जान-बूझकर / ख़ास कर
            まさか|masaka|まさか|surely not|नहीं हो सकता
            せめて|semete|せめて|at least|कम से कम
            いっそ|isso|いっそ|rather (might as well)|बेहतर होगा कि
            やむをえず|yamu wo ezu|やむを得ず|unavoidably|मजबूरी में
            とうとう|toutou|とうとう|finally / in the end|आख़िरकार
        """)
    )

    val patterns = listOf(
        L.jp("jpN2-a", "～を 問わず — 'regardless of ~'", "〜を問わず",
            "N2", "Something applies regardless of the category: 男女を問わず = regardless of gender; 年齢を問わず = regardless of age.",
            "「〜を問わず」で制限なしを表す。",
            "「〜を 問わず」= ~ की परवाह किए बिना (भेदभाव के बिना)।",
            """
                ★男女を問わず、さんかできます。|danjo wo towazu, sanka dekimasu|Anyone, regardless of gender, can participate.|लिंग की परवाह किए बिना भाग ले सकते हैं।
                ★年齢を問わず、おうぼできます。|nenrei wo towazu, oubo dekimasu|You can apply regardless of age.|उम्र की परवाह किए बिना आवेदन कर सकते हैं।
                ★経験を問わず、けんしゅうがあります。|keiken wo towazu, kenshuu ga arimasu|There is training regardless of experience.|अनुभव चाहे जो भी हो, प्रशिक्षण दिया जाता है।
            """),
        L.jp("jpN2-b", "～に 限らず — 'not limited to ~'", "〜に限らず",
            "N2", "The thing applies beyond the named category: こどもに限らず、おとなも… = not only children but adults too…",
            "「〜に限らず」で範囲の広さを表す。",
            "「〜に 限らず」= केवल ~ ही नहीं, बल्कि (व्यापक)।",
            """
                ★この 店は にほんじんに限らず、がいこくじんにも 人気です。|kono mise wa nihonjin ni kagirazu, gaikokujin ni mo ninki desu|This shop is popular not only with Japanese but also foreigners.|यह दुकान केवल जापानियों ही नहीं, विदेशियों में भी लोकप्रिय है।
                ★しごとに限らず、プライベートでも たいせつです。|shigoto ni kagirazu, puraibeeto demo taisetsu desu|It matters not just at work but in private life too.|सिर्फ़ काम में ही नहीं, निजी ज़िंदगी में भी ज़रूरी है।
            """),
        L.jp("jpN2-c", "～に したがって / ～に つれて — 'as ~'", "〜にしたがって",
            "N2", "Proportional change: ～にしたがって and ～につれて both mean 'as X happens, Y changes'. 時間がたつにつれて、なれてきました = As time passed, I got used to it.",
            "比例変化「〜にしたがって」「〜につれて」。",
            "「〜に したがって/つれて」= जैसे-जैसे ~ होता है, वैसे-वैसे… (आनुपातिक बदलाव)।",
            """
                ★時間がたつにつれて、わすれてしまいます。|jikan ga tatsu ni tsurete, wasurete shimaimasu|As time passes, I end up forgetting.|समय बीतने के साथ भूल जाता हूँ।
                ★料金は 距離にしたがって、たかくなります。|ryoukin wa kyori ni shitagatte, takaku narimasu|The fare rises according to distance.|किराया दूरी के अनुसार बढ़ता है।
            """),
        L.jp("jpN2-d", "～上で / ～上は — 'in terms of ~ / given ~'", "〜上で",
            "N2", "〜上で = 'in terms of / from the standpoint of' (けいけん上で = in terms of experience). ～上は = 'given that'. けいやく上は = contractually.",
            "「〜上で」で観点を表す。",
            "「〜上で」= के दृष्टिकोण से / की दृष्टि से।",
            """
                ★経費の上では、こうつうひが 高いです。|keihi no ue de wa, koutsuuhi ga takai desu|In terms of expenses, transport costs are high.|ख़र्च की दृष्टि से यातायात ख़र्च ज़्यादा है।
                ★きそくの上では だめですが、じつさいは できます。|kisoku no ue de wa dame desu ga, jissai wa dekimasu|By the rules it's not allowed, but in practice you can.|नियमों के अनुसार मना है, पर व्यवहार में हो सकता है।
            """),
        L.jp("jpN2-e", "～として — 'as ~'", "〜として",
            "N2", "Role or capacity: せんせいとして = as a teacher. Often with は/も/の: としての. ひととして たいせつなこと = something important as a human being.",
            "資格・立場「〜として」。",
            "「〜として」= के रूप में / के तौर पर (भूमिका)।",
            """
                ★しんがくの しどういんとして はたらきました。|shingaku no shidouin toshite hatarakimashita|I worked as a career counselor.|मैंने मार्गदर्शक के रूप में काम किया।
                ★せんぱいとして いちごんだけ いわせて ください。|senpai toshite ichigon dake iwasete kudasai|As your senior, let me say one word.|सीनियर होने के नाते एक बात कहने दीजिए।
            """),
        L.jp("jpN2-f", "～に とって — 'for ~ (from ~'s perspective)'", "〜にとって",
            "N2", "Whose perspective: わたしにとって = for me / in my view. こどもにとって たいせつな じかん = time that matters to children.",
            "主観的な立場「〜にとって」。",
            "「〜に とって」= ~ के लिए (उसके दृष्टिकोण से)।",
            """
                ★けんこうにとって、ねむることは だいじです。|kenkou ni totte, nemuru koto wa daiji desu|Sleep is important for health.|स्वास्थ्य के लिए नींद ज़रूरी है।
                ★わたしにとって、かぞくが いちばんです。|watashi ni totte, kazoku ga ichiban desu|For me, family comes first.|मेरे लिए परिवार सबसे पहले है।
            """),
        L.jp("jpN2-g", "～に関して — 'regarding ~'", "〜に関して",
            "N2", "Formal version of について: この問題に関して = regarding this problem. Often に関しての / に関する.",
            "「〜に関して」で「〜について」の硬い言い方。",
            "「〜に 関して」= ~ के संबंध में (औपचारिक)।",
            """
                ★この けいかくに関して、いけんが ありますか。|kono keikaku ni kanshite, iken ga arimasu ka|Do you have any opinions regarding this plan?|क्या इस योजना के संबंध में कोई राय है?
                ★環境に関する けんきゅうを しています。|kankyou ni kansuru kenkyuu wo shite imasu|I'm doing research related to the environment.|मैं पर्यावरण से जुड़ा शोध कर रहा हूँ।
            """),
        L.jp("jpN2-h", "～ばかりか — 'not only ~ but also'", "〜ばかりか",
            "N2", "Stronger than だけでなく: ～ばかりか、～も = not only ~, but also ~. べんきょうが できるばかりか、スポーツも できます = Not only is he good at studies, he's good at sports too.",
            "「〜ばかりか」で添加を強調する。",
            "「〜ばかりか」= केवल ~ ही नहीं, बल्कि… भी।",
            """
                ★あの せんせいは おしえるのが じょうずなばかりか、やさしいです。|ano sensei wa oshieru no ga jouzu na bakari ka, yasashii desu|That teacher is not only good at teaching but also kind.|वह शिक्षक सिखाने में अच्छे ही नहीं, दयालु भी हैं।
                ★まいばん おそくまで はたらくばかりか、しゅうまつも きんむします。|maiban osoku made hataraku bakari ka, shuumatsu mo kinmu shimasu|He not only works late every night but also on weekends.|वह रोज़ रात देर तक काम करता ही है, वीकेंड पर भी ड्यूटी करता है।
            """)
    )
}
