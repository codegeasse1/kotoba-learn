package com.nexo.kotoba

object JapaneseGrammar {

    private fun jp(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleJa: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "ja", ruleEn, ruleJa, gex(raw), ruleHi, level, "japanese")

    private fun gex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("|")
            PatternExample("💤", c[0], c[1], c[2], c.getOrElse(3) { "" })
        }.toList()

    val patterns: List<Pattern> = listOf(
        jp("jg1", "です / ます — polite endings", "です・ます（丁寧形）", "N5",
            "USAGE: です makes nouns and adjectives polite ('is/am/are'); ます is the polite ending for verbs. This is the standard polite form used with strangers, at work, and in public.\\nWHEN: Use です with nouns/adjectives (わたしはがくせいです), ます with verbs (コーヒーをのみます). Adding か at the end makes a question.\\nFORM: noun/adjective + です | verb stem + ます. Past: でした / ました. Negative: じゃないです / ません.\\nTIP: In casual talk with friends, です/ます are dropped — but you should use them unless the other person is clearly a friend.",
            "用途: ですは名詞・形容詞を丁寧にし、ますは動詞を丁寧にします。見知らぬ人や仕事で使う標準の丁寧形。\\nいつ: 名詞・形容詞＋です、動詞＋ます。文末に「か」で疑問文。\\n形: 名詞・形容詞＋です｜動詞語幹＋ます。過去：でした／ました。否定：じゃないです／ません。\\nヒント: 友達との会話では省略されることもあります。",
            "उपयोग: です संज्ञा/विशेषण को विनम्र बनाता है; ます क्रिया का विनम्र रूप है। अजनबियों और काम पर प्रयोग।\\nकब: संज्ञा/विशेषण + です, क्रिया + ます। अंत में か = प्रश्न।\\nरूप: です/ます। भूतकाल: でした/ました। नकारात्मक: じゃないです/ません।\\nटिप: दोस्तों के साथ अनौपचारिक बातचीत में छोड़ा जा सकता है।",
            """わたしはがくせいです。|watashi wa gakusei desu|I am a student.|मैं विद्यार्थी हूँ।
きょうはあめです。|kyou wa ame desu|Today is rainy.|आज बारिश है।
これはほんです。|kore wa hon desu|This is a book.|यह किताब है。
あしたはいきます。|ashita wa ikimasu|I will go tomorrow.|कल मैं जाऊँगा।
わたしはコーヒーをのみます。|watashi wa koohii o nomimasu|I drink coffee.|मैं कॉफ़ी पीता हूँ।
おげんきですか。|ogenki desu ka|How are you?|आप कैसे हैं?
これはなんですか。|kore wa nan desu ka|What is this?|यह क्या है?
とうきょうにすんでいます。|toukyou ni sunde imasu|I live in Tokyo.|मैं टोक्यो में रहता हूँ।
すきやきをたべます。|sukiyaki o tabemasu|I eat sukiyaki.|मैं सुकियाकी खाता हूँ।
にほんごをべんきょうします。|nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ。
きれいなはなです。|kirei na hana desu|It is a pretty flower.|यह सुंदर फूल है。
あさごはんをたべました。|asagohan o tabemashita|I ate breakfast.|मैंने नाश्ता किया।
あしたはやすみです。|ashita wa yasumi desu|Tomorrow is a holiday.|कल छुट्टी है।
ここはしずかです。|koko wa shizuka desu|This place is quiet.|यह जगह शांत है।
あのかたはせんせいですか。|ano kata wa sensei desu ka|Is that person a teacher?|क्या वह व्यक्ति शिक्षक है?
わたしはまいばんテレビをみます。|watashi wa maiban terebi o mimasu|I watch TV every night.|मैं हर रात टीवी देखता हूँ。
ねこがすきです。|neko ga suki desu|I like cats.|मुझे बिल्लियाँ पसंद हैं।
そとはさむいです。|soto wa samui desu|Outside is cold.|बाहर ठंड है।
このみせはゆうめいです。|kono mise wa yuumei desu|This shop is famous.|यह दुकान प्रसिद्ध है।
わたしはせんしゅうかいものしました。|watashi wa senshuu kaimono shimashita|I went shopping last week.|पिछले हफ्ते मैंने खरीदारी की।
あなたはどちらからですか。|anata wa dochira kara desu ka|Where are you from?|आप कहाँ से हैं?
これはいくらですか。|kore wa ikura desu ka|How much is this?|यह कितने का है?
わたしはにほんがすきです。|watashi wa nihon ga suki desu|I like Japan.|मुझे जापान पसंद है।
ともだちとあそびます。|tomodachi to asobimasu|I play with friends.|मैं दोस्तों के साथ खेलता हूँ।
ここでまってください。|koko de matte kudasai|Please wait here.|कृपया यहाँ रुकिए।
かぜをひきました。|kaze o hikimashita|I caught a cold.|मुझे सर्दी लग गई।
わたしははたらきます。|watashi wa hatarakimasu|I work.|मैं काम करता हूँ。
このまちはおおきいです。|kono machi wa ookii desu|This town is big.|यह शहर बड़ा है।
あしたまたあいましょう。|ashita mata aimashou|Let's meet again tomorrow.|कल फिर मिलेंगे।
はい、わかりました。|hai, wakarimashita|Yes, I understand.|हाँ, मैं समझ गया।"""),
        jp("jg2", "は — topic marker", "は（主題）", "N5",
            "USAGE: は (pronounced 'wa') marks the TOPIC of the sentence — what we are talking about. Everything after it says something about the topic.\\nWHEN: Use it to introduce or change the subject of discussion: わたしは... (as for me...), きょうは... (as for today...). It often translates as 'as for...'.\\nFORM: topic + は + rest of sentence.\\nTIP: は is the topic, が is the subject. In わたしはねこがすきです, 'I' is the topic but 'cats' is the subject.",
            "用途: は（ワと発音）は文の主題を示します。その後に主題についての説明が続きます。\\nいつ: 話題を出したり変えたりするとき。きょうは…、わたしは…。\\n形: 主題＋は＋文の残り。\\nヒント: はは主題、がは主語。わたしはねこがすきですでは、ねこが主語。",
            "उपयोग: は (wa उच्चारण) वाक्य का विषय दिखाता है। आगे का भाग विषय के बारे में बताता है।\\nकब: विषय शुरू करने या बदलने के लिए।\\nरूप: विषय + は + शेष वाक्य।\\nटिप: は विषय है, が कर्ता है।",
            """わたしはにほんじんです。|watashi wa nihonjin desu|I am Japanese.|मैं जापानी हूँ。
ねこはすきです。|neko wa suki desu|As for cats, I like them.|बिल्लियाँ मुझे पसंद हैं।
きょうははれです。|kyou wa hare desu|As for today, it's sunny.|आज धूप है।
このほんはおもしろいです。|kono hon wa omoshiroi desu|This book is interesting.|यह किताब दिलचस्प है।
たなかさんはせんせいです。|tanaka san wa sensei desu|Mr. Tanaka is a teacher.|तनाका-सान शिक्षक हैं।
みずはつめたいです。|mizu wa tsumetai desu|The water is cold.|पानी ठंडा है।
らいしゅうはやすみます。|raishuu wa yasumimasu|As for next week, I will rest.|अगले हफ्ते मैं आराम करूँगा।
これはわたしのペンです。|kore wa watashi no pen desu|This is my pen.|यह मेरी कलम है。
いぬはかわいいです。|inu wa kawaii desu|Dogs are cute.|कुत्ते प्यारे होते हैं。
はははげんきです。|haha wa genki desu|My mother is well.|मेरी माँ ठीक हैं।
あにははんとうでべんきょうしています。|ani wa hantou de benkyou shite imasu|My brother studies abroad.|मेरा भाई विदेश में पढ़ता है।
このくるまはあたらしいです。|kono kuruma wa atarashii desu|This car is new.|यह गाड़ी नई है।
にほんのたべものはおいしいです。|nihon no tabemono wa oishii desu|Japanese food is delicious.|जापानी खाना स्वादिष्ट है।
きのうはかいものにいきました。|kinou wa kaimono ni ikimashita|As for yesterday, I went shopping.|कल मैं खरीदारी गया था。
わたしはあさはやくおきます。|watashi wa asa hayaku okimasu|I wake up early in the morning.|मैं सुबह जल्दी उठता हूँ。
あのひとはフランスじんです。|ano hito wa furansu jin desu|That person is French.|वह व्यक्ति फ्रांसीसी है।
このじしょはたかいです。|kono jisho wa takai desu|This dictionary is expensive.|यह शब्दकोश महँगा है。
わたしはすしがだいすきです。|watashi wa sushi ga daisuki desu|I love sushi.|मुझे सुशी बहुत पसंद है。
らいねんはにほんにいきます。|rainen wa nihon ni ikimasu|As for next year, I will go to Japan.|अगले साल मैं जापान जाऊँगा।
がっこうはえきのちかくです。|gakkou wa eki no chikaku desu|The school is near the station.|स्कूल स्टेशन के पास है।
わたしはまんががすきです。|watashi wa manga ga suki desu|I like manga.|मुझे मंगा पसंद है।
きょうのてんきはいいです。|kyou no tenki wa ii desu|Today's weather is nice.|आज का मौसम अच्छा है。
ともだちはインドにすんでいます。|tomodachi wa indo ni sunde imasu|My friend lives in India.|मेरा दोस्त भारत में रहता है。
ここはきれいなまちです。|koko wa kirei na machi desu|This is a beautiful town.|यह सुंदर शहर है。
わたしはおちゃがすきじゃないです。|watashi wa ocha ga suki janai desu|I don't like green tea.|मुझे चाय पसंद नहीं।
せんせいはやさしいです。|sensei wa yasashii desu|The teacher is kind.|शिक्षक दयालु हैं।
このくつはちいさいです。|kono kutsu wa chiisai desu|These shoes are small.|ये जूते छोटे हैं।
にほんごはむずかしいですが、おもしろいです。|nihongo wa muzukashii desu ga, omoshiroi desu|Japanese is difficult, but interesting.|जापानी कठिन है, पर दिलचस्प है।
あのレストランはおいしいです。|ano resutoran wa oishii desu|That restaurant is delicious.|वह रेस्तराँ स्वादिष्ट है।
きょうはつかれたです。|kyou wa tsukareta desu|I am tired today.|आज मैं थक गया हूँ।"""),

        jp("jg3", "が — subject marker", "が（主語）", "N5",
            "USAGE: が marks the grammatical SUBJECT — who or what does the action, or who/what is being described.\\nWHEN: Use が after すき/きらい (like/dislike), わかる (understand), ほしい (want), and あります/います (exist). It also marks new information: the answer to だれが...? (who?) uses が.\\nFORM: subject + が + predicate.\\nTIP: With すきです, the liked thing takes が: ねこがすきです. With あります/います, the thing that exists takes が: ペンがあります.",
            "用途: がは文の主語を示します。動作をする人や、説明される対象。\\nいつ: すき・きらい・わかる・ほしい・あります・いますの後に。新情報にも使います。\\n形: 主語＋が＋述語。\\nヒント: すきですの前はが：ねこがすきです。",
            "उपयोग: が वाक्य का कर्ता दिखाता है।\\nकब: すき/きらい/わかる/ほしい/あります/います के साथ।\\nरूप: कर्ता + が + विधेय।\\nटिप: पसंद वाली चीज़ के साथ が: ねこがすきです।",
            """だれがきましたか。|dare ga kimashita ka|Who came?|कौन आया?
たなかさんがきました。|tanaka san ga kimashita|Mr. Tanaka came.|तनाका-सान आए।
わたしはねこがすきです。|watashi wa neko ga suki desu|I like cats.|मुझे बिल्लियाँ पसंद हैं。
にほんごがわかります。|nihongo ga wakarimasu|I understand Japanese.|मुझे जापानी समझ आती है。
ペンがあります。|pen ga arimasu|There is a pen.|एक कलम है।
ねこがいます。|neko ga imasu|There is a cat.|एक बिल्ली है।
だれがこのケーキをつくりましたか。|dare ga kono keeki o tsukurimashita ka|Who made this cake?|यह केक किसने बनाया?
わたしがつくりました。|watashi ga tsukurimashita|I made it.|मैंने बनाया।
みずがほしいです。|mizu ga hoshii desu|I want water.|मुझे पानी चाहिए。
じてんしゃがほしいです。|jitensha ga hoshii desu|I want a bicycle.|मुझे साइकिल चाहिए。
バスがきます。|basu ga kimasu|The bus is coming.|बस आ रही है।
あめがふっています。|ame ga futte imasu|It is raining.|बारिश हो रही है।
かぎがみつかりました。|kagi ga mitsukarimashita|The key was found.|चाबी मिल गई।
ここにほんがあります。|koko ni hon ga arimasu|There is a book here.|यहाँ एक किताब है।
きみがいいです。|kimi ga ii desu|You are the one I want. (You're good.)|तुम ही चाहिए।
これがいいです。|kore ga ii desu|This one is good.|यही अच्छा है。
どれがいちばんすきですか。|dore ga ichiban suki desu ka|Which one do you like best?|कौन-सा सबसे पसंद है?
これがいちばんすきです。|kore ga ichiban suki desu|This one I like best.|यही सबसे पसंद है।
なにがたべたいですか。|nani ga tabetai desu ka|What do you want to eat?|तुम क्या खाना चाहते हो?
おすしがたべたいです。|osushi ga tabetai desu|I want to eat sushi.|मुझे सुशी खानी है।
あたらしいじどうしゃがほしいです。|atarashii jidousha ga hoshii desu|I want a new car.|मुझे नई गाड़ी चाहिए。
ともだちができました。|tomodachi ga dekimashita|I made a friend.|मुझे दोस्त मिल गया।
こえがきこえます。|koe ga kikoemasu|I can hear a voice.|आवाज़ सुनाई देती है。
はながさきました。|hana ga sakimashita|The flower bloomed.|फूल खिल गया।
でんきがついています。|denki ga tsuite imasu|The light is on.|बत्ती जली हुई है。
つくえのうえにほんがあります。|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर एक किताब है।
あたまがいたいです。|atama ga itai desu|I have a headache.|मेरे सिर में दर्द है。
おなかがすきました。|onaka ga sukimashita|I am hungry.|मुझे भूख लगी है。
のどがかわきました。|nodo ga kawakimashita|I am thirsty.|मुझे प्यास लगी है。
えきにでんしゃがとまっています。|eki ni densha ga tomatte imasu|A train is stopped at the station.|स्टेशन पर ट्रेन खड़ी है।"""),
        jp("jg4", "を — object marker", "を（目的語）", "N5",
            "USAGE: を (pronounced 'o') marks the OBJECT of a verb — the thing that the action happens to.\\nWHEN: Use it after the object of transitive verbs: ほんをよみます (read a book), すしをたべます (eat sushi), コーヒーをのみます (drink coffee).\\nFORM: object + を + verb.\\nTIP: を is only used with verbs that take an object. Verbs like いく (go) and ねる (sleep) don't use を — they use に/へ.",
            "用途: を（オ）は動詞の目的語を示します。動作の対象。\\nいつ: 他動詞の目的語の後に。ほんをよみます、すしをたべます。\\n形: 目的語＋を＋動詞。\\nヒント: いく・ねるのような自動詞にはをを使いません。",
            "उपयोग: を (o उच्चारण) क्रिया का कर्म दिखाता है।\\nकब: सकर्मक क्रियाओं के कर्म के साथ।\\nरूप: कर्म + を + क्रिया।\\nटिप: いく/ねる जैसी अकर्मक क्रियाओं के साथ を नहीं आता।",
            """ほんをよみます。|hon o yomimasu|I read a book.|मैं किताब पढ़ता हूँ।
すしをたべます。|sushi o tabemasu|I eat sushi.|मैं सुशी खाता हूँ。
コーヒーをのみます。|koohii o nomimasu|I drink coffee.|मैं कॉफ़ी पीता हूँ。
てがみをかきます。|tegami o kakimasu|I write a letter.|मैं पत्र लिखता हूँ。
えいがをみます。|eiga o mimasu|I watch a movie.|मैं फ़िल्म देखता हूँ。
おんがくをききます。|ongaku o kikimasu|I listen to music.|मैं संगीत सुनता हूँ。
パンをかいます。|pan o kaimasu|I buy bread.|मैं रोटी खरीदता हूँ。
なにをたべますか。|nani o tabemasu ka|What do you eat?|तुम क्या खाते हो?
ごはんをつくります。|gohan o tsukurimasu|I cook rice. (make a meal)|मैं खाना बनाता हूँ。
まどをあけます。|mado o akemasu|I open the window.|मैं खिड़की खोलता हूँ。
ドアをしめます。|doa o shimemasu|I close the door.|मैं दरवाज़ा बंद करता हूँ。
しゅくだいをします。|shukudai o shimasu|I do my homework.|मैं होमवर्क करता हूँ。
にほんごをべんきょうします。|nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ。
テニスをします。|tenisu o shimasu|I play tennis.|मैं टेनिस खेलता हूँ。
ともだちをまちます。|tomodachi o machimasu|I wait for a friend.|मैं दोस्त का इंतज़ार करता हूँ。
でんわばんごうをおしえてください。|denwa bangou o oshiete kudasai|Please tell me the phone number.|कृपया फ़ोन नंबर बताइए।
このしゃしんをみてください。|kono shashin o mite kudasai|Please look at this photo.|कृपया यह तस्वीर देखिए।
りんごをふたつかいました。|ringo o futatsu kaimashita|I bought two apples.|मैंने दो सेब खरीदे।
しんぶんをよみますか。|shinbun o yomimasu ka|Do you read the newspaper?|क्या तुम अख़बार पढ़ते हो?
コートをきます。|kooto o kimasu|I wear a coat.|मैं कोट पहनता हूँ。
くつをぬぎます。|kutsu o nugimasu|I take off my shoes.|मैं जूते उतारता हूँ。
てをあらいます。|te o araimasu|I wash my hands.|मैं हाथ धोता हूँ。
かみをきります。|kami o kirimasu|I cut my hair.|मैं बाल कटवाता हूँ。
しゃしんをとります。|shashin o torimasu|I take a photo.|मैं फ़ोटो लेता हूँ。
じてんしゃをおします。|jitensha o oshimasu|I push the bicycle.|मैं साइकिल धकेलता हूँ。
かばんをもちます。|kaban o mochimasu|I carry a bag.|मैं बैग उठाता हूँ。
おかねをはらいます。|okane o haraimasu|I pay money.|मैं पैसे चुकाता हूँ。
このほんをかります。|kono hon o karimasu|I borrow this book.|मैं यह किताब उधार लेता हूँ。
えをかきます。|e o kakimasu|I draw a picture.|मैं चित्र बनाता हूँ।
まいにちさんぽをします。|mainichi sanpo o shimasu|I take a walk every day.|मैं हर दिन सैर करता हूँ।"""),

        jp("jg5", "に — time & destination", "に（時間・目的地）", "N5",
            "USAGE: に marks a specific TIME and a DESTINATION / point of contact.\\nWHEN: Time: じゅうじに (at 10 o'clock), げつようびに (on Monday), さんがつに (in March). Destination: えきにいく (go to the station), いえにかえる (return home). Also with います/あります for location: ここにあります.\\nFORM: time/destination + に + verb.\\nTIP: に for time is only for specific times — don't use it with まいにち (every day), きのう (yesterday), or らいしゅう (next week).",
            "用途: には具体的な時間と目的地・着点を示します。\\nいつ: 時間（じゅうじに）と目的地（えきにいく）。場所のいます・ありますにも。\\n形: 時間・目的地＋に＋動詞。\\nヒント: まいにち・きのう・らいしゅうのようないつもの表現にはにを使いません。",
            "उपयोग: に विशिष्ट समय और गंतव्य दिखाता है।\\nकब: समय (दस बजे) और गंतव्य (स्टेशन जाना)। स्थान के います/あります के साथ भी।\\nरूप: समय/गंतव्य + に + क्रिया।\\nटिप: まいにち/きのう/らいしゅう के साथ に नहीं आता।",
            """じゅうじにおきます。|juuji ni okimasu|I wake up at 10 o'clock.|मैं दस बजे उठता हूँ।
えきにいきます。|eki ni ikimasu|I go to the station.|मैं स्टेशन जाता हूँ。
いえにかえります。|ie ni kaerimasu|I go back home.|मैं घर लौटता हूँ。
げつようびにべんきょうします。|getsuyoubi ni benkyou shimasu|I study on Monday.|मैं सोमवार को पढ़ता हूँ。
さんがつににほんにいきます。|sangatsu ni nihon ni ikimasu|I go to Japan in March.|मार्च में मैं जापान जाता हूँ。
としょかんにほんがあります。|toshokan ni hon ga arimasu|There is a book in the library.|पुस्तकालय में किताब है。
がっこうにいきます。|gakkou ni ikimasu|I go to school.|मैं स्कूल जाता हूँ。
しごとにいきます。|shigoto ni ikimasu|I go to work.|मैं काम पर जाता हूँ。
はちじにあさごはんをたべます。|hachiji ni asagohan o tabemasu|I eat breakfast at 8.|मैं आठ बजे नाश्ता करता हूँ。
にちようびにこうえんにいきます。|nichiyoubi ni kouen ni ikimasu|I go to the park on Sunday.|रविवार को मैं पार्क जाता हूँ。
かばんのなかにほんがあります。|kaban no naka ni hon ga arimasu|There is a book in the bag.|बैग के अंदर एक किताब है।
くうこうにつきました。|kuukou ni tsukimashita|I arrived at the airport.|मैं हवाई अड्डे पहुँचा।
ホテルにとまります。|hoteru ni tomarimasu|I stay at a hotel.|मैं होटल में ठहरता हूँ。
せんせいにききます。|sensei ni kikimasu|I ask the teacher.|मैं शिक्षक से पूछता हूँ。
ともだちにでんわします。|tomodachi ni denwa shimasu|I call my friend.|मैं दोस्त को फ़ोन करता हूँ。
かぞくにかえります。|kazoku ni kaerimasu|I return to my family.|मैं परिवार के पास लौटता हूँ。
にじにかいぎがあります。|niji ni kaigi ga arimasu|There is a meeting at 2.|दो बजे बैठक है।
あしたのあさにでかけます。|ashita no asa ni dekakemasu|I go out tomorrow morning.|कल सुबह मैं बाहर जाता हूँ।
このいすにすわってください。|kono isu ni suwatte kudasai|Please sit on this chair.|कृपया इस कुर्सी पर बैठिए।
つくえのしたにねこがいます。|tsukue no shita ni neko ga imasu|There is a cat under the desk.|मेज़ के नीचे एक बिल्ली है।
まいにちはちじにねます。|mainichi hachiji ni nemasu|I sleep at 8 every day.|मैं हर दिन आठ बजे सोता हूँ。
ごごさんじにあいましょう。|gogo sanji ni aimashou|Let's meet at 3 pm.|दोपहर तीन बजे मिलेंगे।
きょねんにけっこんしました。|kyonen ni kekkon shimashita|I got married last year.|पिछले साल मैंने शादी की।
バスにのります。|basu ni norimasu|I ride the bus.|मैं बस में चढ़ता हूँ。
でんしゃにおくれました。|densha ni okuremashita|I was late for the train.|मैं ट्रेन के लिए देर हो गया।
しょくじにさそいました。|shokuji ni sasoimashita|I invited (them) to a meal.|मैंने खाने पर बुलाया।
むすめさんにプレゼントをあげます。|musume san ni purezento o agemasu|I give a present to my daughter.|मैं बेटी को उपहार देता हूँ।
かいしゃにつとめています。|kaisha ni tsutomete imasu|I work at a company.|मैं एक कंपनी में काम करता हूँ।
きょうとにすんでいます。|kyouto ni sunde imasu|I live in Kyoto.|मैं क्योटो में रहता हूँ।
あしたにのぼせます。|ashita ni nobosemasu|I will climb it tomorrow. (formal)|कल मैं चढ़ूँगा।"""),
        jp("jg6", "で — place of action & means", "で（場所・手段）", "N5",
            "USAGE: で marks WHERE an action happens and the MEANS / tool used.\\nWHEN: Place of action: としょかんでべんきょうします (study at the library). Means/transport: バスでいきます (go by bus), ペンでかきます (write with a pen). Also for language: にほんごで (in Japanese).\\nFORM: place/means + で + verb.\\nTIP: compare に (destination/existence) with で (action place): こうえんにいく (go to the park) vs こうえんであそぶ (play in the park).",
            "用途: では動作の場所と手段・道具を示します。\\nいつ: 場所（としょかんで）と手段（バスで・ペンで）、言語（にほんごで）。\\n形: 場所・手段＋で＋動詞。\\nヒント: に（目的地）とで（動作の場所）の違いに注意。",
            "उपयोग: で क्रिया का स्थान और साधन दिखाता है।\\nकब: स्थान (पुस्तकालय में) और साधन (बस से, कलम से)।\\nरूप: स्थान/साधन + で + क्रिया।\\nटिप: に (गंतव्य) और で (क्रिया-स्थान) में अंतर।",
            """としょかんでべんきょうします。|toshokan de benkyou shimasu|I study at the library.|मैं पुस्तकालय में पढ़ता हूँ।
バスでいきます。|basu de ikimasu|I go by bus.|मैं बस से जाता हूँ。
ペンでかきます。|pen de kakimasu|I write with a pen.|मैं कलम से लिखता हूँ。
にほんごではなします。|nihongo de hanashimasu|I speak in Japanese.|मैं जापानी में बोलता हूँ。
こうえんであそびます。|kouen de asobimasu|I play in the park.|मैं पार्क में खेलता हूँ。
レストランでたべます。|resutoran de tabemasu|I eat at a restaurant.|मैं रेस्तराँ में खाता हूँ。
でんしゃでかいしゃにいきます。|densha de kaisha ni ikimasu|I go to work by train.|मैं ट्रेन से ऑफ़िस जाता हूँ。
じしょでしらべます。|jisho de shirabemasu|I look it up in the dictionary.|मैं शब्दकोश में देखता हूँ。
きっさてんでおちゃをのみます。|kissaten de ocha o nomimasu|I drink tea at a cafe.|मैं कैफ़े में चाय पीता हूँ。
うちでテレビをみます。|uchi de terebi o mimasu|I watch TV at home.|मैं घर पर टीवी देखता हूँ。
がっこうでにほんごをおしえます。|gakkou de nihongo o oshiemasu|I teach Japanese at school.|मैं स्कूल में जापानी पढ़ाता हूँ。
ぎゅうにゅうでコーヒーをつくります。|gyuunyuu de koohii o tsukurimasu|I make coffee with milk.|मैं दूध से कॉफ़ी बनाता हूँ。
はさみでかみをきります。|hasami de kami o kirimasu|I cut paper with scissors.|मैं कैंची से काग़ज़ काटता हूँ。
びょういんではたらきます。|byouin de hatarakimasu|I work at a hospital.|मैं अस्पताल में काम करता हूँ。
くつやでくつをかいます。|kutsuya de kutsu o kaimasu|I buy shoes at a shoe shop.|मैं जूते की दुकान से जूते खरीदता हूँ。
じゅぎょうでしつもんします。|jugyou de shitsumon shimasu|I ask questions in class.|मैं कक्षा में सवाल पूछता हूँ。
パソコンでレポートをかきます。|pasokon de repooto o kakimasu|I write a report on the computer.|मैं कंप्यूटर पर रिपोर्ट लिखता हूँ。
そらをとぶひこうきでいきます。|sora o tobu hikouki de ikimasu|I go by plane flying in the sky.|मैं हवाई जहाज़ से जाता हूँ।
スーパーでかいものします。|suupaa de kaimono shimasu|I shop at the supermarket.|मैं सुपरमार्केट में खरीदारी करता हूँ。
じむしょでかいぎがあります。|jimusho de kaigi ga arimasu|There is a meeting at the office.|ऑफ़िस में बैठक है।
うちでゆっくりやすみます。|uchi de yukkuri yasumimasu|I rest slowly at home.|मैं घर पर आराम से आराम करता हूँ。
うみでおよぎます。|umi de oyogimasu|I swim in the sea.|मैं समुद्र में तैरता हूँ。
えきでともだちをまちます。|eki de tomodachi o machimasu|I wait for a friend at the station.|मैं स्टेशन पर दोस्त का इंतज़ार करता हूँ。
だいがくでけんきゅうします。|daigaku de kenkyuu shimasu|I do research at university.|मैं विश्वविद्यालय में शोध करता हूँ。
ゆうびんきょくできってをかいます。|yuubinkyoku de kitte o kaimasu|I buy stamps at the post office.|मैं डाकघर से टिकट खरीदता हूँ。
ナイフでパンをきります。|naifu de pan o kirimasu|I cut bread with a knife.|मैं चाकू से रोटी काटता हूँ。
じてんしゃでがっこうにいきます。|jitensha de gakkou ni ikimasu|I go to school by bicycle.|मैं साइकिल से स्कूल जाता हूँ。
こうじょうではたらくひとがおおいです。|koujou de hataraku hito ga ooi desu|Many people work at the factory.|कारखाने में काम करने वाले लोग ज़्यादा हैं।
うみのそばでまちます。|umi no soba de machimasu|I wait by the sea.|मैं समुद्र के पास इंतज़ार करता हूँ।
こんばんうちでべんきょうします。|konban uchi de benkyou shimasu|I will study at home tonight.|आज रात मैं घर पर पढ़ूँगा।"""),

        jp("jg7", "へ — direction", "へ（方向）", "N5",
            "USAGE: へ (pronounced 'e') marks DIRECTION — the direction you move toward.\\nWHEN: Use it with movement verbs: とうきょうへいきます (go to Tokyo), うみへいきます (go to the sea), こっちへきてください (please come this way). It is similar to に for destinations, but へ emphasizes the direction rather than the exact point.\\nFORM: direction + へ + movement verb (いく, くる, かえる, でかける...).\\nTIP: へ is only for movement. You cannot say としょかんへほんがあります — for existence use に.",
            "用途: へ（エ）は進む方向を示します。移動動詞と使います。\\nいつ: とうきょうへいく、うみへいく。目的地より方向を強調します。\\n形: 方向＋へ＋移動動詞（いく・くる・かえる・でかける）。\\nヒント: へは移動専用。存在のありますには使いません。",
            "उपयोग: へ (e उच्चारण) दिशा दिखाता है। गति क्रियाओं के साथ।\\nकब: टोक्यो जाना, समुद्र जाना। に जैसा पर दिशा पर ज़ोर।\\nरूप: दिशा + へ + गति क्रिया।\\nटिप: へ केवल गति के लिए; अस्तित्व के लिए に।",
            """とうきょうへいきます。|toukyou e ikimasu|I go to Tokyo.|मैं टोक्यो जाता हूँ।
うみへいきます。|umi e ikimasu|I go to the sea.|मैं समुद्र जाता हूँ。
こっちへきてください。|kotchi e kite kudasai|Please come this way.|कृपया इस ओर आइए।
うちへかえります。|uchi e kaerimasu|I go back home.|मैं घर लौटता हूँ。
くにへかえります。|kuni e kaerimasu|I return to my country.|मैं अपने देश लौटता हूँ。
えきへむかいます。|eki e mukaimasu|I head toward the station.|मैं स्टेशन की ओर जाता हूँ。
やまへいきます。|yama e ikimasu|I go to the mountains.|मैं पहाड़ जाता हूँ。
かいしゃへつとめにいきます。|kaisha e tsutome ni ikimasu|I go to work at the company.|मैं कंपनी काम पर जाता हूँ。
がっこうへおくれていきます。|gakkou e okurete ikimasu|I go to school late.|मैं देर से स्कूल जाता हूँ।
そとへでかけます。|soto e dekakemasu|I go out.|मैं बाहर जाता हूँ。
まちへかいものにいきます。|machi e kaimono ni ikimasu|I go to town to shop.|मैं शहर खरीदारी जाता हूँ。
としょかんへほんをかりにいきます。|toshokan e hon o kari ni ikimasu|I go to the library to borrow a book.|मैं पुस्तकालय किताब उधार लेने जाता हूँ。
どちらへいきますか。|dochira e ikimasu ka|Where are you going?|आप कहाँ जा रहे हैं?
そちらへいきます。|sochira e ikimasu|I go that way.|मैं उस ओर जाता हूँ。
みぎへまがります。|migi e magarimasu|I turn right.|मैं दाएँ मुड़ता हूँ。
ひだりへまがってください。|hidari e magatte kudasai|Please turn left.|कृपया बाएँ मुड़िए।
あちらへどうぞ。|achira e douzo|Please go that way.|कृपया उस ओर जाइए。
にほんへりょこうします。|nihon e ryokou shimasu|I travel to Japan.|मैं जापान यात्रा करता हूँ。
くうこうへむかっています。|kuukou e mukatte imasu|I am heading to the airport.|मैं हवाई अड्डे की ओर जा रहा हूँ。
うえへあがります。|ue e agarimasu|I go up.|मैं ऊपर जाता हूँ。
したへさがります。|shita e sagarimasu|I go down.|मैं नीचे जाता हूँ。
まえへすすみます。|mae e susumimasu|I move forward.|मैं आगे बढ़ता हूँ。
うしろへさがってください。|ushiro e sagatte kudasai|Please step back.|कृपया पीछे हटिए।
バスはえきへいきますか。|basu wa eki e ikimasu ka|Does the bus go to the station?|क्या बस स्टेशन जाती है?
このでんしゃはおおさかへいきます。|kono densha wa oosaka e ikimasu|This train goes to Osaka.|यह ट्रेन ओसाका जाती है。
あしたきょうとへでかけます。|ashita kyouto e dekakemasu|I go to Kyoto tomorrow.|कल मैं क्योटो जाता हूँ।
ひとりでやまへいきました。|hitori de yama e ikimashita|I went to the mountain alone.|मैं अकेला पहाड़ गया।
ともだちのうちへあそびにいきます。|tomodachi no uchi e asobi ni ikimasu|I go to my friend's house to play.|मैं दोस्त के घर खेलने जाता हूँ。
かえりにスーパーへいきます。|kaeri ni suupaa e ikimasu|On the way back, I go to the supermarket.|लौटते समय मैं सुपरमार्केट जाता हूँ।
だれもいないへやへはいりました。|daremo inai heya e hairimashita|I entered an empty room.|मैं खाली कमरे में घुसा।"""),
        jp("jg8", "と — with / together with", "と（一緒に）", "N5",
            "USAGE: と means 'with' — together with someone, or together with something.\\nWHEN: ともだちと (with a friend), かぞくと (with family), だれと...? (with whom?). It is also the 'and' for listing nouns: ほんとペン (a book and a pen).\\nFORM: person/thing + と + verb (with); noun + と + noun (and).\\nTIP: to say 'with' for tools you use で (ペンで), not と. と is for people/companions and for lists.",
            "用途: とは「一緒に」を表します。人やものと一緒。\\nいつ: ともだちと、かぞくと。名詞を並べる「と」もあります。\\n形: 人・もの＋と＋動詞｜名詞＋と＋名詞。\\nヒント: 道具はで（ペンで）。とは人・仲間と一覧に。",
            "उपयोग: と = 'के साथ'। लोगों/चीज़ों के साथ।\\nकब: दोस्त के साथ, परिवार के साथ; सूची में 'और'।\\nरूप: व्यक्ति/चीज़ + と + क्रिया; संज्ञा + と + संज्ञा।\\nटिप: औज़ार के लिए で; と लोगों/सूची के लिए।",
            """ともだちとあそびます。|tomodachi to asobimasu|I play with a friend.|मैं दोस्त के साथ खेलता हूँ。
かぞくとたべます。|kazoku to tabemasu|I eat with my family.|मैं परिवार के साथ खाता हूँ。
だれとしゃべりましたか。|dare to shaberimashita ka|Who did you talk with?|तुमने किससे बात की?
ははとかいものにいきました。|haha to kaimono ni ikimashita|I went shopping with my mother.|मैं माँ के साथ खरीदारी गया।
ほんとペンをかいました。|hon to pen o kaimashita|I bought a book and a pen.|मैंने किताब और कलम खरीदी।
いぬとさんぽします。|inu to sanpo shimasu|I walk with my dog.|मैं कुत्ते के साथ सैर करता हूँ。
せんせいとはなします。|sensei to hanashimasu|I talk with the teacher.|मैं शिक्षक से बात करता हूँ。
あにといっしょにすんでいます。|ani to issho ni sunde imasu|I live together with my brother.|मैं भाई के साथ रहता हूँ。
コーヒーとケーキをおねがいします。|koohii to keeki o onegai shimasu|Coffee and cake, please.|कॉफ़ी और केक, कृपया।
かれとけっこんしました。|kare to kekkon shimashita|I married him.|मैंने उससे शादी की।
どれとどれをくらべますか。|dore to dore o kurabemasu ka|Which two do you compare?|कौन-कौन से दो तुलना करते हो?
あねとはなをそだてます。|ane to hana o sodatemasu|My sister and I grow flowers.|मैं और बहन फूल उगाते हैं。
パンとみるくでちょうしょくします。|pan to miruku de choushoku shimasu|I have bread and milk for breakfast.|नाश्ते में मैं रोटी और दूध लेता हूँ।
りょうしんとでんわします。|ryoushin to denwa shimasu|I call my parents.|मैं माता-पिता से फ़ोन करता हूँ。
くつとぼうしをえらびます。|kutsu to boushi o erabimasu|I choose shoes and a hat.|मैं जूते और टोपी चुनता हूँ।
うさぎとあそぶのがすきです。|usagi to asobu no ga suki desu|I like playing with rabbits.|मुझे खरगोश के साथ खेलना पसंद है।
たべものとのみものをかいます。|tabemono to nomimono o kaimasu|I buy food and drinks.|मैं खाना और पेय खरीदता हूँ。
でんわとメールでつたえます。|denwa to meeru de tsutaemasu|I tell (them) by phone and email.|मैं फ़ोन और ईमेल से बताता हूँ。
かばんとリュックをもっています。|kaban to ryukku o motte imasu|I have a bag and a backpack.|मेरे पास बैग और बस्ता है।
こどもとボールであそびます。|kodomo to booru de asobimasu|I play ball with the children.|मैं बच्चों के साथ गेंद खेलता हूँ।
せんぱいとごはんをたべました。|senpai to gohan o tabemashita|I ate with my senior.|मैंने सीनियर के साथ खाना खाया。
はなとおんがくがすきです。|hana to ongaku ga suki desu|I like flowers and music.|मुझे फूल और संगीत पसंद है।
やまいもとごはんをたべます。|yamaimo to gohan o tabemasu|I eat yam and rice.|मैं रतालू और चावल खाता हूँ।
かれらとえいがをみました。|karera to eiga o mimashita|I watched a movie with them.|मैंने उनके साथ फ़िल्म देखी।
だれとりょこうしますか。|dare to ryokou shimasu ka|Who will you travel with?|तुम किसके साथ यात्रा करोगे?
とりとねこがいます。|tori to neko ga imasu|There are a bird and a cat.|एक पक्षी और एक बिल्ली है।
あたらしいくつとふくをかいました。|atarashii kutsu to fuku o kaimashita|I bought new shoes and clothes.|मैंने नए जूते और कपड़े खरीदे।
つくえといすをそうじします。|tsukue to isu o souji shimasu|I clean the desk and the chair.|मैं मेज़ और कुर्सी साफ़ करता हूँ。
ともだちとりょうりをつくります。|tomodachi to ryouri o tsukurimasu|I cook with my friend.|मैं दोस्त के साथ खाना बनाता हूँ।
あさパンとたまごをたべます。|asa pan to tamago o tabemasu|I eat bread and eggs in the morning.|सुबह मैं रोटी और अंडे खाता हूँ।"""),

        jp("jg9", "の — possession", "の（所有）", "N5",
            "USAGE: の links two nouns — it shows possession, belonging, or description.\\nWHEN: わたしのほん (my book), にほんのくるま (a Japanese car), がっこうのせんせい (a school teacher). Also noun + の replaces a noun already known: わたしの (mine).\\nFORM: noun1 + の + noun2. noun1 explains or owns noun2.\\nTIP: の works like the opposite order of English 's: ともだちのいえ = 'friend's house' (the house OF the friend).",
            "用途: のは名詞と名詞をつなぎ、所有・所属・説明を示します。\\nいつ: わたしのほん、にほんのくるま。既知の名詞をのだけで置き換えることも。\\n形: 名詞1＋の＋名詞2。\\nヒント: 英語の 's と順序が逆。ともだちのいえ＝友達の家。",
            "उपयोग: の दो संज्ञाओं को जोड़ता है — स्वामित्व, संबंध, विवरण।\\nकब: मेरी किताब, जापानी गाड़ी।\\nरूप: संज्ञा1 + の + संज्ञा2।\\nटिप: अंग्रेज़ी के 's से उल्टा क्रम: ともだちのいえ = दोस्त का घर।",
            """これはわたしのほんです。|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है।
それはともだちのかばんです。|sore wa tomodachi no kaban desu|That is my friend's bag.|वह दोस्त का बैग है。
にほんのくるまはゆうめいです。|nihon no kuruma wa yuumei desu|Japanese cars are famous.|जापानी गाड़ियाँ प्रसिद्ध हैं。
がっこうのせんせいがきました。|gakkou no sensei ga kimashita|The school teacher came.|स्कूल के शिक्षक आए।
きょうのてんきはいいですね。|kyou no tenki wa ii desu ne|Today's weather is nice, isn't it?|आज का मौसम अच्छा है न?
わたしのいえはここです。|watashi no ie wa koko desu|My house is here.|मेरा घर यहाँ है。
あねのこどもがふたりいます。|ane no kodomo ga futari imasu|My sister has two children.|मेरी बहन के दो बच्चे हैं。
このみせのラーメンはおいしいです。|kono mise no raamen wa oishii desu|This shop's ramen is delicious.|इस दुकान का रामेन स्वादिष्ट है。
インドのたべものはからいです。|indo no tabemono wa karai desu|Indian food is spicy.|भारतीय खाना तीखा होता है。
とうきょうのまちはおおきいです。|toukyou no machi wa ookii desu|The city of Tokyo is big.|टोक्यो शहर बड़ा है。
ちちのくるまはあかいです。|chichi no kuruma wa akai desu|My father's car is red.|मेरे पिता की गाड़ी लाल है。
どこのくにのひとですか。|doko no kuni no hito desu ka|What country's person is (he)? (Where is he from?)|वह किस देश का है?
インドじんです。|indo jin desu|He is Indian.|वह भारतीय है।
わたしのはあかいです。|watashi no wa akai desu|Mine is red.|मेरा लाल है。
あなたのはどれですか。|anata no wa dore desu ka|Which one is yours?|तुम्हारा कौन-सा है?
あしたのごごにまちあわせます。|ashita no gogo ni machiawase masu|We meet tomorrow afternoon.|कल दोपहर में मिलेंगे।
にほんごのせんせいになりたいです。|nihongo no sensei ni naritai desu|I want to become a Japanese teacher.|मैं जापानी शिक्षक बनना चाहता हूँ。
まいあさのさんぽがすきです。|maiasa no sanpo ga suki desu|I like the morning walk.|मुझे सुबह की सैर पसंद है।
えきのちかくにホテルがあります。|eki no chikaku ni hoteru ga arimasu|There is a hotel near the station.|स्टेशन के पास एक होटल है।
つくえのうえにほんがあります。|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर एक किताब है。
いえのまえにくるまがとまっています。|ie no mae ni kuruma ga tomatte imasu|A car is parked in front of the house.|घर के सामने गाड़ी खड़ी है।
かいしゃのともだちにあいます。|kaisha no tomodachi ni aimasu|I meet a work friend.|मैं ऑफ़िस के दोस्त से मिलता हूँ。
ふゆのやまはとてもきれいです。|fuyu no yama wa totemo kirei desu|The winter mountain is very beautiful.|सर्दी का पहाड़ बहुत सुंदर है।
このへやのまどがおおきいです。|kono heya no mado ga ookii desu|This room's window is big.|इस कमरे की खिड़की बड़ी है。
ははのつくったりょうりがだいすきです。|haha no tsukutta ryouri ga daisuki desu|I love the food my mother makes.|माँ का बनाया खाना मुझे बहुत पसंद है।
にほんのしゅみはなんですか。|nihon no shumi wa nan desu ka|What is your hobby in Japan?|जापान में तुम्हारा शौक क्या है?
せんしゅうのにちようびにうみへいきました。|senshuu no nichiyoubi ni umi e ikimashita|Last Sunday I went to the sea.|पिछले रविवार मैं समुद्र गया।
にねんまえのしゃしんです。|ninen mae no shashin desu|This is a photo from two years ago.|यह दो साल पहले की तस्वीर है।
がくせいのとき、にほんにすんでいました。|gakusei no toki, nihon ni sunde imashita|When I was a student, I lived in Japan.|छात्र रहते हुए मैं जापान में रहता था。
あかいのとしろいの、どちらがすきですか。|akai no to shiroi no, dochira ga suki desu ka|The red one or the white one — which do you like?|लाल वाला या सफ़ेद वाला — कौन पसंद है?"""),
        jp("jg10", "て-form — connecting & requesting", "て形（接続・依頼）", "N5",
            "USAGE: the て-form connects verbs and is the base for many patterns (ています, てください, てもいい, てはいけない).\\nWHEN: て-form + ください = polite request (まってください). て-form connects two actions in sequence (あさごはんをたべて、がっこうにいきます — I eat breakfast and go to school). Forming: のみます→のんで, かきます→かいて, よみます→よんで, たべます→たべて, きます→きて.\\nFORM: verb て-form + ください / + next verb.\\nTIP: the て-form of verbs ending in み・び・に changes to んで (よむ→よんで).",
            "用途: て形は動詞をつなぎ、多くの表現の基礎になります。\\nいつ: てください（依頼）、動作の順序（たべて、いきます）。変化：のみ→のんで、かき→かいて。\\n形: 動詞て形＋ください｜て形＋次の動詞。\\nヒント: み・び・にで終わる動詞は「んで」になります（よむ→よんで）。",
            "उपयोग: て-रूप क्रियाओं को जोड़ता है और कई पैटर्न का आधार है।\\nकब: てください = विनम्र अनुरोध; क्रम में क्रियाएँ।\\nरूप: क्रिया-て + ください / अगली क्रिया।\\nटिप: मि/बि/नि से समाप्त क्रियाएँ 'んで' बनती हैं।",
            """ちょっとまってください。|chotto matte kudasai|Please wait a moment.|कृपया एक पल रुकिए。
ドアをしめてください。|doa o shimete kudasai|Please close the door.|कृपया दरवाज़ा बंद कीजिए。
ここにかいてください。|koko ni kaite kudasai|Please write here.|कृपया यहाँ लिखिए。
あしたきてください。|ashita kite kudasai|Please come tomorrow.|कृपया कल आइए。
これを見てください。|kore o mite kudasai|Please look at this.|कृपया यह देखिए。
あさごはんをたべて、がっこうにいきます。|asagohan o tabete, gakkou ni ikimasu|I eat breakfast and go to school.|नाश्ता करके मैं स्कूल जाता हूँ。
しょくじして、テレビをみます。|shokuji shite, terebi o mimasu|I eat a meal and watch TV.|खाना खाकर मैं टीवी देखता हूँ。
ゆっくりはなしてください。|yukkuri hanashite kudasai|Please speak slowly.|कृपया धीरे बोलिए。
もういちどおねがいします。|mou ichido onegai shimasu|Please say it once more.|कृपया एक बार फिर।
はい、わかりました。|hai, wakarimashita|Yes, I understand.|हाँ, समझ गया।
まいにちにほんごをべんきょうしています。|mainichi nihongo o benkyou shite imasu|I study Japanese every day.|मैं हर दिन जापानी पढ़ता हूँ。
いまシャワーをあびています。|ima shawaa o abite imasu|I am taking a shower now.|अभी मैं स्नान कर रहा हूँ。
そのしゃしんをとってください。|sono shashin o totte kudasai|Please take that photo.|कृपया वह फ़ोटो लीजिए。
ここですわってください。|koko de suwatte kudasai|Please sit here.|कृपया यहाँ बैठिए。
これをもってください。|kore o motte kudasai|Please carry this.|कृपया यह उठाइए।
またきてください。|mata kite kudasai|Please come again.|कृपया फिर आइए।
はやくねてください。|hayaku nete kudasai|Please sleep early.|कृपया जल्दी सोइए。
あしたはやくおきてください。|ashita hayaku okite kudasai|Please wake up early tomorrow.|कल कृपया जल्दी उठिए।
タバコをすわないでください。|tabako o suwanaide kudasai|Please don't smoke.|कृपया धूम्रपान न करें।
ここではなさないでください。|koko de hanasanaide kudasai|Please don't talk here.|कृपया यहाँ बात न करें。
でんわばんごうをおしえてください。|denwa bangou o oshiete kudasai|Please tell me your phone number.|कृपया फ़ोन नंबर बताइए。
こえをおおきくして、はなしてください。|koe o ookiku shite, hanashite kudasai|Please speak in a loud voice.|कृपया ऊँची आवाज़ में बोलिए।
みずをのんで、やすみました。|mizu o nonde, yasumimashita|I drank water and rested.|पानी पीकर मैंने आराम किया。
本をよんで、レポートをかきます。|hon o yonde, repooto o kakimasu|I read a book and write a report.|किताब पढ़कर मैं रिपोर्ट लिखता हूँ。
バスにのって、かいしゃにいきます。|basu ni notte, kaisha ni ikimasu|I ride the bus and go to work.|बस में चढ़कर मैं ऑफ़िस जाता हूँ।
じてんしゃにのって、こうえんへいきます。|jitensha ni notte, kouen e ikimasu|I ride my bike to the park.|साइकिल पर सवार होकर मैं पार्क जाता हूँ。
あねがケーキをつくって、もってきました。|ane ga keeki o tsukutte, motte kimashita|My sister made a cake and brought it.|बहन ने केक बनाकर लाया।
せんせいがかいて、せいとがよみます。|sensei ga kaite, seito ga yomimasu|The teacher writes and the student reads.|शिक्षक लिखते हैं और विद्यार्थी पढ़ता है।
このかみをきってください。|kono kami o kitte kudasai|Please cut this paper.|कृपया यह काग़ज़ काटिए。
きもちをこめて、はなしてください。|kimochi o komete, hanashite kudasai|Please speak with feeling.|भावना के साथ बोलिए।"""),

        jp("jg11", "ない-form — negatives", "ない形（否定）", "N5",
            "USAGE: the ない-form makes verbs negative. のみます → のまない (don't drink), たべます → たべない (don't eat). With です nouns: じゃないです.\\nWHEN: Use it for present negatives: コーヒーをのまないです (I don't drink coffee). Casual speech just ends with ない; polite adds です or uses ません (のまない → のまないです / のみません).\\nFORM: verb negative stem + ない. Group rules: のみ→のまない, たべ→たべない, する→しない, くる→こない.\\nTIP: ありません and じゃないです are both fine. ない is casual; for politeness add です.",
            "用途: ない形は動詞を否定します。\\nいつ: 現在の否定。のまない、たべない。\\n形: 動詞の否定語幹＋ない。のみ→のまない、たべ→たべない、する→しない、くる→こない。\\nヒント: 丁寧にはですを付けるか、ませんを使います。",
            "उपयोग: ない-रूप क्रिया को नकारात्मक बनाता है।\\nकब: वर्तमान नकारात्मक।\\nरूप: नकारात्मक तना + ない। のみ→のまない, तबे→たべない, सुरु→しない, कुरु→こない।\\nटिप: विनम्रता के लिए です जोड़ें या ません।",
            """コーヒーをのみません。|koohii o nomimasen|I don't drink coffee.|मैं कॉफ़ी नहीं पीता。
すしをたべません。|sushi o tabemasen|I don't eat sushi.|मैं सुशी नहीं खाता。
きょうははたらきません。|kyou wa hatarakimasen|I don't work today.|आज मैं काम नहीं करता।
あしたはいきません。|ashita wa ikimasen|I won't go tomorrow.|कल मैं नहीं जाऊँगा।
これがわかりません。|kore ga wakarimasen|I don't understand this.|मुझे यह समझ नहीं आता。
ねこがすきじゃないです。|neko ga suki janai desu|I don't like cats.|मुझे बिल्लियाँ पसंद नहीं।
ここはしずかじゃないです。|koko wa shizuka janai desu|This place is not quiet.|यह जगह शांत नहीं है。
あしたはやすみじゃないです。|ashita wa yasumi janai desu|Tomorrow is not a holiday.|कल छुट्टी नहीं है。
わたしはせんせいじゃありません。|watashi wa sensei ja arimasen|I am not a teacher.|मैं शिक्षक नहीं हूँ。
これはわたしのではありません。|kore wa watashi no dewa arimasen|This is not mine.|यह मेरा नहीं है。
テレビをみません。|terebi o mimasen|I don't watch TV.|मैं टीवी नहीं देखता।
まいにちうんどうしません。|mainichi undou shimasen|I don't exercise every day.|मैं हर दिन व्यायाम नहीं करता。
おかねがありません。|okane ga arimasen|I have no money.|मेरे पास पैसे नहीं हैं。
じかんがありません。|jikan ga arimasen|I have no time.|मेरे पास समय नहीं है。
まどをあけません。|mado o akemasen|I don't open the window.|मैं खिड़की नहीं खोलता।
タバコをすいません。|tabako o suimasen|I don't smoke.|मैं धूम्रपान नहीं करता।
さけをのみません。|sake o nomimasen|I don't drink alcohol.|मैं शराब नहीं पीता।
にくをたべません。|niku o tabemasen|I don't eat meat.|मैं मांस नहीं खाता。
えいごがはなせません。|eigo ga hanasemasen|I can't speak English.|मैं अंग्रेज़ी नहीं बोल सकता。
じしょがないと、わかりません。|jisho ga nai to, wakarimasen|Without a dictionary, I don't understand.|शब्दकोश के बिना मुझे समझ नहीं आता।
まだたべていません。|mada tabete imasen|I haven't eaten yet.|मैंने अभी खाया नहीं।
もうしごとがおわりましたか。|mou shigoto ga owarimashita ka|Have you finished work?|क्या काम खत्म हो गया?
いいえ、まだです。|iie, mada desu|No, not yet.|नहीं, अभी नहीं।
きょうはつかれていません。|kyou wa tsukarete imasen|I'm not tired today.|आज मैं थका नहीं हूँ。
あのひとはインドじんじゃありません。|ano hito wa indo jin ja arimasen|That person is not Indian.|वह व्यक्ति भारतीय नहीं है。
しゅくだいをしませんでした。|shukudai o shimasen deshita|I didn't do my homework.|मैंने होमवर्क नहीं किया।
きのうはかいものにいきませんでした。|kinou wa kaimono ni ikimasen deshita|I didn't go shopping yesterday.|कल मैं खरीदारी नहीं गया।
かれはきませんでした。|kare wa kimasen deshita|He didn't come.|वह नहीं आया。
わかりません、もういちどいってください。|wakarimasen, mou ichido itte kudasai|I don't understand, please say it again.|समझा नहीं, कृपया फिर कहिए।
わたしにはむずかしすぎて、できません。|watashi ni wa muzukashi sugite, dekimasen|It's too hard for me, I can't do it.|मेरे लिए बहुत कठिन है, मैं नहीं कर सकता।"""),
        jp("jg12", "た-form — past tense", "た形（過去）", "N5",
            "USAGE: the た-form is the past tense of verbs. たべます → たべた (ate), のみます → のんだ (drank), かきます → かいた (wrote).\\nWHEN: For finished actions: きのうえいがをみました (I watched a movie yesterday). In casual speech the た-form alone is the past: たべた. Polite: たべました. The た-form also forms ことがある (have experienced) and たあとで (after).\\nFORM: past stem + た. たべ→たべた, のみ→のんだ, かき→かいた, する→した, くる→きた.\\nTIP: ました is the polite past; the plain た-form is casual. Don't mix them in one sentence.",
            "用途: た形は動詞の過去形です。\\nいつ: 完了した動作。きのうみました。\\n形: 過去語幹＋た。たべた、のんだ、かいた、した、きた。\\nヒント: ましたは丁寧な過去、た形はカジュアル。",
            "उपयोग: た-रूप क्रिया का भूतकाल है।\\nकब: पूर्ण क्रियाओं के लिए।\\nरूप: भूतकाल तना + た। तबेता, नोंदा, कैता, शिता, किता।\\nटिप: ました विनम्र भूतकाल, た-रूप अनौपचारिक।",
            """きのうえいがをみました。|kinou eiga o mimashita|I watched a movie yesterday.|कल मैंने फ़िल्म देखी।
あさごはんをたべました。|asagohan o tabemashita|I ate breakfast.|मैंने नाश्ता किया。
せんしゅうとうきょうへいきました。|senshuu toukyou e ikimashita|I went to Tokyo last week.|पिछले हफ्ते मैं टोक्यो गया।
きのうのよるねました。|kinou no yoru nemashita|I slept last night.|कल रात मैं सोया।
ともだちにでんわしました。|tomodachi ni denwa shimashita|I called my friend.|मैंने दोस्त को फ़ोन किया。
このほんをよみました。|kono hon o yomimashita|I read this book.|मैंने यह किताब पढ़ी。
かばんをかいました。|kaban o kaimashita|I bought a bag.|मैंने बैग खरीदा。
きのうはあめでした。|kinou wa ame deshita|It rained yesterday.|कल बारिश थी।
がっこうはやすみでした。|gakkou wa yasumi deshita|School was closed.|स्कूल छुट्टी था।
せんせいはきょうはいませんでした。|sensei wa kyou wa imasen deshita|The teacher wasn't here today.|शिक्षक आज यहाँ नहीं थे।
にほんのりょうりをつくりました。|nihon no ryouri o tsukurimashita|I made Japanese food.|मैंने जापानी खाना बनाया。
しゃしんをとりました。|shashin o torimashita|I took a photo.|मैंने फ़ोटो ली।
てがみをかきました。|tegami o kakimashita|I wrote a letter.|मैंने पत्र लिखा。
プールでおよぎました。|puuru de oyogimashita|I swam in the pool.|मैंने पूल में तैरा।
きっさてんでコーヒーをのみました。|kissaten de koohii o nomimashita|I drank coffee at a cafe.|मैंने कैफ़े में कॉफ़ी पी।
あたらしいくつをはきました。|atarashii kutsu o hakimashita|I wore new shoes.|मैंने नए जूते पहने。
ともだちとあそびました。|tomodachi to asobimashita|I played with a friend.|मैंने दोस्त के साथ खेला。
かぜをひきました。|kaze o hikimashita|I caught a cold.|मुझे सर्दी लग गई。
びょういんにいきました。|byouin ni ikimashita|I went to the hospital.|मैं अस्पताल गया。
いいニュースをききました。|ii nyuusu o kikimashita|I heard good news.|मैंने अच्छी ख़बर सुनी。
しゅくだいがおわりました。|shukudai ga owarimashita|I finished my homework.|मेरा होमवर्क खत्म हुआ。
きのうはつかれました。|kinou wa tsukaremashita|I was tired yesterday.|कल मैं थका हुआ था।
まいあさはやくおきました。|maiasa hayaku okimashita|I woke up early every morning.|मैं हर सुबह जल्दी उठा।
にほんごをべんきょうしました。|nihongo o benkyou shimashita|I studied Japanese.|मैंने जापानी पढ़ाई।
なにをたべましたか。|nani o tabemashita ka|What did you eat?|तुमने क्या खाया?
どこへいきましたか。|doko e ikimashita ka|Where did you go?|तुम कहाँ गए?
えきでともだちにあいました。|eki de tomodachi ni aimashita|I met a friend at the station.|मैं स्टेशन पर दोस्त से मिला।
きのうはとてもいそがしかったです。|kinou wa totemo isogashikatta desu|Yesterday was very busy.|कल बहुत व्यस्त था。
あたらしいアパートにはいりました。|atarashii apaato ni hairimashita|I moved into a new apartment.|मैं नए फ़्लैट में आया।
てをあらってから、たべました。|te o aratte kara, tabemashita|After washing my hands, I ate.|हाथ धोकर मैंने खाया।"""),

        jp("jg13", "〜ている — ongoing actions & states", "〜ている（進行・状態）", "N5",
            "USAGE: て-form + います shows an action in progress or a continuing state.\\nWHEN: In progress: ほんをよんでいます (I am reading a book). Habit: にほんごをべんきょうしています (I study Japanese — as my ongoing activity). State/result: すんでいます (I live...), しっています (I know).\\nFORM: verb て-form + います (polite) / いる (casual).\\nTIP: しっています means 'I know'; しっていません means 'I don't know'. Note the special て-form: しる→しって.",
            "用途: て形＋いますで動作の進行や状態の継続を表します。\\nいつ: 進行（よんでいます）、習慣（べんきょうしています）、状態（すんでいます・しっています）。\\n形: 動詞て形＋います／いる。\\nヒント: しっています＝知っている。しる→しって。",
            "उपयोग: て-रूप + います चल रही क्रिया या निरंतर अवस्था दिखाता है।\\nकब: प्रगति, आदत, अवस्था।\\nरूप: क्रिया-て + います/いる।\\nटिप: しっています = मैं जानता हूँ।",
            """ほんをよんでいます。|hon o yonde imasu|I am reading a book.|मैं किताब पढ़ रहा हूँ।
テレビをみています。|terebi o mite imasu|I am watching TV.|मैं टीवी देख रहा हूँ。
いまシャワーをあびています。|ima shawaa o abite imasu|I am taking a shower now.|अभी मैं स्नान कर रहा हूँ。
ごはんをつくっています。|gohan o tsukutte imasu|I am cooking.|मैं खाना बना रहा हूँ。
ともだちをまっています。|tomodachi o matte imasu|I am waiting for a friend.|मैं दोस्त का इंतज़ार कर रहा हूँ。
にほんごをべんきょうしています。|nihongo o benkyou shite imasu|I study Japanese (ongoing).|मैं जापानी सीख रहा हूँ।
とうきょうにすんでいます。|toukyou ni sunde imasu|I live in Tokyo.|मैं टोक्यो में रहता हूँ。
にほんごがわかっています。|nihongo ga wakatte imasu|I understand Japanese.|मुझे जापानी समझ आती है。
かれのなまえをしっています。|kare no namae o shitte imasu|I know his name.|मैं उसका नाम जानता हूँ。
あめがふっています。|ame ga futte imasu|It is raining.|बारिश हो रही है。
ゆきがふっています。|yuki ga futte imasu|It is snowing.|बर्फ़ गिर रही है。
でんきがついています。|denki ga tsuite imasu|The light is on.|बत्ती जली हुई है。
まどがあいています。|mado ga aite imasu|The window is open.|खिड़की खुली है。
いすにすわっています。|isu ni suwatte imasu|I am sitting on a chair.|मैं कुर्सी पर बैठा हूँ。
たっています。|tatte imasu|I am standing.|मैं खड़ा हूँ。
ねています。|nete imasu|I am sleeping.|मैं सो रहा हूँ。
しごとをしています。|shigoto o shite imasu|I am working.|मैं काम कर रहा हूँ。
うたをうたっています。|uta o utatte imasu|I am singing.|मैं गा रहा हूँ。
おどっています。|odotte imasu|I am dancing.|मैं नाच रहा हूँ。
はしっています。|hashitte imasu|I am running.|मैं दौड़ रहा हूँ。
あるいています。|aruite imasu|I am walking.|मैं चल रहा हूँ。
かんがえています。|kangaete imasu|I am thinking.|मैं सोच रहा हूँ。
ちちはだいがくではたらいています。|chichi wa daigaku de hataraite imasu|My father works at a university.|मेरे पिता विश्वविद्यालय में काम करते हैं。
けっこんしています。|kekkon shite imasu|I am married.|मैं विवाहित हूँ。
こどもがふたりいます。|kodomo ga futari imasu|I have two children.|मेरे दो बच्चे हैं。
このじしょをもっていますか。|kono jisho o motte imasu ka|Do you have this dictionary?|क्या तुम्हारे पास यह शब्दकोश है?
いいえ、もっていません。|iie, motte imasen|No, I don't have it.|नहीं, मेरे पास नहीं है।
まいにちうんどうしています。|mainichi undou shite imasu|I exercise every day.|मैं हर दिन व्यायाम करता हूँ।
あねはインドにすんでいます。|ane wa indo ni sunde imasu|My older sister lives in India.|मेरी बड़ी बहन भारत में रहती है।
このへやはひろくて、あかるいです。|kono heya wa hirokute, akarui desu|This room is wide and bright.|यह कमरा चौड़ा और रोशन है।"""),
        jp("jg14", "potential — can do (〜られる / 〜える)", "可能形（できる）", "N4",
            "USAGE: the potential form says you CAN do something. たべます → たべられます (can eat), いきます → いけます (can go), みます → みられます (can see).\\nWHEN: にほんごがはなせます (I can speak Japanese), およげますか (Can you swim?). Group rules: う-verbs change final sound to え (いく→いける, はなす→はなせる); る-verbs drop る and add られる (たべる→たべられる). Irregular: する→できる, くる→こられる.\\nFORM: verb potential form + ます. Note the object often takes が instead of を: すしがたべられます.\\nTIP: できる means 'can do' and also 'is made/comes into being' (ともだちができた = I made a friend).",
            "用途: 可能形は「できる」を表します。\\nいつ: にほんごがはなせます。\\n形: う動詞はえ段（いける・はなせる）、る動詞はられる（たべられる）。する→できる、くる→こられる。\\nヒント: 目的語はをよりがを使うことが多い。",
            "उपयोग: संभाव्य रूप 'कर सकना' बताता है।\\nकब: जापानी बोल सकता हूँ, तैर सकते हो?\\nरूप: う-क्रियाएँ → え (いく→いける); る-क्रियाएँ → られる (たべる→たべられる); する→できる, くる→こられる।\\nटिप: कर्म के साथ を की जगह が आ सकता है।",
            """にほんごがはなせます。|nihongo ga hanasemasu|I can speak Japanese.|मैं जापानी बोल सकता हूँ।
およげますか。|oyogemasu ka|Can you swim?|क्या तुम तैर सकते हो?
はい、およげます。|hai, oyogemasu|Yes, I can swim.|हाँ, मैं तैर सकता हूँ。
じてんしゃにのれます。|jitensha ni noremasu|I can ride a bicycle.|मैं साइकिल चला सकता हूँ。
すしがたべられます。|sushi ga taberaremasu|I can eat sushi.|मैं सुशी खा सकता हूँ。
えいごがよめます。|eigo ga yomemasu|I can read English.|मैं अंग्रेज़ी पढ़ सकता हूँ。
このじしょをつかえます。|kono jisho o tsukaemasu|I can use this dictionary.|मैं यह शब्दकोश इस्तेमाल कर सकता हूँ。
うんてんできます。|unten dekimasu|I can drive.|मैं गाड़ी चला सकता हूँ。
りょうりがつくれます。|ryouri ga tsukuremasu|I can cook.|मैं खाना बना सकता हूँ。
ギターがひけます。|gitaa ga hikemasu|I can play the guitar.|मैं गिटार बजा सकता हूँ。
ピアノがひけます。|piano ga hikemasu|I can play the piano.|मैं पियानो बजा सकता हूँ。
にほんのうたがうたえます。|nihon no uta ga utaemasu|I can sing Japanese songs.|मैं जापानी गाने गा सकता हूँ。
かなをかきます。|kana o kakimasu|I can write kana.|मैं काना लिख सकता हूँ。
かんじがよめます。|kanji ga yomemasu|I can read kanji.|मैं कांजी पढ़ सकता हूँ。
ここでしゃしんをとれますか。|koko de shashin o toremasu ka|Can I take photos here?|क्या मैं यहाँ फ़ोटो ले सकता हूँ?
あしたこれますか。|ashita koremasu ka|Can you come tomorrow?|क्या तुम कल आ सकते हो?
はい、あしたこれます。|hai, ashita koremasu|Yes, I can come tomorrow.|हाँ, मैं कल आ सकता हूँ。
にほんにいけます。|nihon ni ikemasu|I can go to Japan.|मैं जापान जा सकता हूँ。
テニスができます。|tenisu ga dekimasu|I can play tennis.|मैं टेनिस खेल सकता हूँ。
サッカーができます。|sakkaa ga dekimasu|I can play soccer.|मैं फ़ुटबॉल खेल सकता हूँ。
やさいがたべられます。|yasai ga taberaremasu|I can eat vegetables.|मैं सब्ज़ियाँ खा सकता हूँ。
おさけがのめます。|osake ga nomemasu|I can drink alcohol.|मैं शराब पी सकता हूँ。
こえがきこえます。|koe ga kikoemasu|I can hear a voice.|मुझे आवाज़ सुनाई देती है。
みえますか。|miemasu ka|Can you see it?|क्या तुम्हें दिख रहा है?
えいごではなせますか。|eigo de hanasemasu ka|Can you speak in English?|क्या तुम अंग्रेज़ी में बोल सकते हो?
すこしだけはなせます。|sukoshi dake hanasemasu|I can speak a little.|मैं थोड़ा-सा बोल सकता हूँ。
にほんごがまだじょうずにできません。|nihongo ga mada jouzu ni dekimasen|I can't speak Japanese well yet.|मैं अभी अच्छी जापानी नहीं बोल सकता।
このパソコンがつかえます。|kono pasokon ga tsukaemasu|I can use this computer.|मैं यह कंप्यूटर चला सकता हूँ。
ここであそべますか。|koko de asobemasu ka|Can we play here?|क्या हम यहाँ खेल सकते हैं?
いつでもれんらくできます。|itsudemo renraku dekimasu|I can contact you anytime.|मैं कभी भी संपर्क कर सकता हूँ।"""),

        jp("jg15", "〜たい — want to", "〜たい（願望）", "N5",
            "USAGE: verb + たい expresses what you WANT to do. たべます → たべたい (want to eat), いきます → いきたい (want to go).\\nWHEN: すしをたべたいです (I want to eat sushi), にほんにいきたいです (I want to go to Japan). To ask: なにをたべたいですか. Negative: いきたくないです (don't want to go).\\nFORM: verb stem + たい + です. Conjugates like an い-adjective: たべたい, たべたくない, たべたかった.\\nTIP: with たい, the object can be を or が: すしをたべたい / すしがたべたい — both are correct.",
            "用途: 動詞＋たいで「～したい」を表します。\\nいつ: たべたい、いきたい。\\n形: 動詞語幹＋たい＋です。い形容詞と同じ変化。\\nヒント: 目的語はをでもがでもOK。",
            "उपयोग: क्रिया + たい = 'करना चाहता हूँ'।\\nकब: सुशी खाना चाहता हूँ, जापान जाना चाहता हूँ।\\nरूप: क्रिया तना + たい + です। い-विशेषण जैसा।\\nटिप: कर्म के साथ を या が दोनों चलते हैं।",
            """すしをたべたいです。|sushi o tabetai desu|I want to eat sushi.|मैं सुशी खाना चाहता हूँ।
にほんにいきたいです。|nihon ni ikitai desu|I want to go to Japan.|मैं जापान जाना चाहता हूँ。
みずがのみたいです。|mizu ga nomitai desu|I want to drink water.|मुझे पानी पीना है।
ねむいです、ねたいです。|nemui desu, netai desu|I'm sleepy, I want to sleep.|मुझे नींद आ रही है, सोना चाहता हूँ।
このほんをよみたいです。|kono hon o yomitai desu|I want to read this book.|मैं यह किताब पढ़ना चाहता हूँ。
えいがをみたいです。|eiga o mitai desu|I want to watch a movie.|मैं फ़िल्म देखना चाहता हूँ。
なにがたべたいですか。|nani ga tabetai desu ka|What do you want to eat?|तुम क्या खाना चाहते हो?
コーヒーがのみたいです。|koohii ga nomitai desu|I want to drink coffee.|मुझे कॉफ़ी पीनी है。
かいものにいきたいですか。|kaimono ni ikitai desu ka|Do you want to go shopping?|क्या तुम खरीदारी जाना चाहते हो?
にほんごをべんきょうしたいです。|nihongo o benkyou shitai desu|I want to study Japanese.|मैं जापानी सीखना चाहता हूँ。
せんせいになりたいです。|sensei ni naritai desu|I want to become a teacher.|मैं शिक्षक बनना चाहता हूँ。
ゆめがあります、ドクターになりたいです。|yume ga arimasu, dokutaa ni naritai desu|I have a dream, I want to become a doctor.|मेरा सपना है, मैं डॉक्टर बनना चाहता हूँ।
ふるさとにかえりたいです。|furusato ni kaeritai desu|I want to return to my hometown.|मैं अपने गाँव लौटना चाहता हूँ。
うみでおよぎたいです。|umi de oyogitai desu|I want to swim in the sea.|मैं समुद्र में तैरना चाहता हूँ。
やまにのぼりたいです。|yama ni noboritai desu|I want to climb a mountain.|मैं पहाड़ चढ़ना चाहता हूँ。
あたらしいくるまをかいたいです。|atarashii kuruma o kaitai desu|I want to buy a new car.|मैं नई गाड़ी खरीदना चाहता हूँ。
りょうりをならいたいです。|ryouri o naraitai desu|I want to learn cooking.|मैं खाना बनाना सीखना चाहता हूँ。
おんがくをききたいです。|ongaku o kikitai desu|I want to listen to music.|मैं संगीत सुनना चाहता हूँ。
ともだちにあいたいです。|tomodachi ni aitai desu|I want to meet my friend.|मैं दोस्त से मिलना चाहता हूँ。
かぞくにあいたいです。|kazoku ni aitai desu|I miss my family.|मुझे परिवार की याद आती है।
はやくねたいです。|hayaku netai desu|I want to sleep early.|मैं जल्दी सोना चाहता हूँ。
あしたはやすみたいです。|ashita wa yasumitai desu|I want to rest tomorrow.|कल मैं आराम करना चाहता हूँ。
このレストランでたべたいです。|kono resutoran de tabetai desu|I want to eat at this restaurant.|मैं इस रेस्तराँ में खाना चाहता हूँ。
プレゼントをあげたいです。|purezento o agetai desu|I want to give a present.|मैं उपहार देना चाहता हूँ。
しごとをやめたいです。|shigoto o yametai desu|I want to quit my job.|मैं नौकरी छोड़ना चाहता हूँ。
もっとべんきょうしたいです。|motto benkyou shitai desu|I want to study more.|मैं और पढ़ना चाहता हूँ。
にほんのたべものをたべたいです。|nihon no tabemono o tabetai desu|I want to eat Japanese food.|मैं जापानी खाना खाना चाहता हूँ。
きれいなところへりょこうしたいです。|kirei na tokoro e ryokou shitai desu|I want to travel to a beautiful place.|मैं खूबसूरत जगह की यात्रा करना चाहता हूँ。
えをかきたいです。|e o kakitai desu|I want to draw a picture.|मैं चित्र बनाना चाहता हूँ。
みんなでたべたいです。|minna de tabetai desu|I want to eat together with everyone.|मैं सबके साथ खाना चाहता हूँ।"""),
        jp("jg16", "〜てください — please do", "〜てください（依頼）", "N5",
            "USAGE: て-form + ください is a polite request: 'please do ...'. まってください (please wait), きてください (please come).\\nWHEN: Requests and instructions: ここにじゅうしょをかいてください (please write your address here). Negative request: ないでください (please don't): ここですわないでください (please don't sit here).\\nFORM: verb て-form + ください | verb ない-form + でください.\\nTIP: ください alone ('kudasai') is used when asking for something: コーヒーをください (coffee, please).",
            "用途: て形＋くださいは丁寧なお願いです。\\nいつ: まってください、きてください。否定はないでください。\\n形: 動詞て形＋ください｜ない形＋でください。\\nヒント: ものをもらう時は「コーヒーをください」。",
            "उपयोग: て-रूप + ください = विनम्र अनुरोध 'कृपया करें'।\\nकब: कृपया रुकिए, कृपया आइए। नकारात्मक: ないでください।\\nरूप: क्रिया-て + ください | ない-रूप + でください।\\nटिप: चीज़ माँगते समय: コーヒーをください।",
            """ちょっとまってください。|chotto matte kudasai|Please wait a moment.|कृपया एक पल रुकिए।
ここにきてください。|koko ni kite kudasai|Please come here.|कृपया यहाँ आइए。
まどをあけてください。|mado o akete kudasai|Please open the window.|कृपया खिड़की खोलिए。
ドアをしめてください。|doa o shimete kudasai|Please close the door.|कृपया दरवाज़ा बंद कीजिए。
なまえをかいてください。|namae o kaite kudasai|Please write your name.|कृपया नाम लिखिए。
ゆっくりはなしてください。|yukkuri hanashite kudasai|Please speak slowly.|कृपया धीरे बोलिए。
もういちどいってください。|mou ichido itte kudasai|Please say it once more.|कृपया एक बार फिर कहिए。
ここでまってください。|koko de matte kudasai|Please wait here.|कृपया यहाँ रुकिए。
あしたきてください。|ashita kite kudasai|Please come tomorrow.|कृपया कल आइए。
これを見てください。|kore o mite kudasai|Please look at this.|कृपया यह देखिए。
このほんをよんでください。|kono hon o yonde kudasai|Please read this book.|कृपया यह किताब पढ़िए。
てつだってください。|tetsudatte kudasai|Please help me.|कृपया मेरी मदद कीजिए。
おしえてください。|oshiete kudasai|Please teach me.|कृपया मुझे सिखाइए。
でんわしてください。|denwa shite kudasai|Please call me.|कृपया फ़ोन कीजिए。
メールをおくってください。|meeru o okutte kudasai|Please send an email.|कृपया ईमेल भेजिए。
バスをまってください。|basu o matte kudasai|Please wait for the bus.|कृपया बस का इंतज़ार कीजिए。
ここにすわってください。|koko ni suwatte kudasai|Please sit here.|कृपया यहाँ बैठिए。
ぎゅうにゅうをかってきてください。|gyuunyuu o katte kite kudasai|Please go buy some milk.|कृपया जाकर दूध खरीदिए।
しゃしんをとってください。|shashin o totte kudasai|Please take a photo.|कृपया फ़ोटो लीजिए。
コーヒーをください。|koohii o kudasai|Coffee, please.|कॉफ़ी दीजिए।
おみずをください。|omizu o kudasai|Water, please.|पानी दीजिए。
メニューをみせてください。|menyuu o misete kudasai|Please show me the menu.|कृपया मेनू दिखाइए。
ここでたばこをすわないでください。|koko de tabako o suwanaide kudasai|Please don't smoke here.|कृपया यहाँ धूम्रपान न करें。
おそくこないでください。|osoku konaide kudasai|Please don't come late.|कृपया देर से न आएँ।
わすれないでください。|wasurenaide kudasai|Please don't forget.|कृपया मत भूलिए।
しんぱいしないでください。|shinpai shinaide kudasai|Please don't worry.|कृपया चिंता न करें。
ここでははなさないでください。|koko de wa hanasanaide kudasai|Please don't talk here.|कृपया यहाँ बात न करें。
このへやにはいらないでください。|kono heya ni hairanaide kudasai|Please don't enter this room.|कृपया इस कमरे में प्रवेश न करें。
こわさないでください。|kowasanaide kudasai|Please don't break it.|कृपया इसे तोड़िए मत।
すぐかえってきてください。|sugu kaette kite kudasai|Please come back soon.|कृपया जल्द लौट आइए।"""),

        jp("jg17", "〜ましょう — let's / shall we", "〜ましょう（勧誘）", "N5",
            "USAGE: ましょう means 'let's ...' or 'shall we ...?'. たべましょう (let's eat), いきましょう (let's go).\\nWHEN: Suggestions and invitations: いっしょにたべましょう (let's eat together), テニスをしましょう (let's play tennis). With か it becomes a suggestion-question: コーヒーをのみましょうか (shall we have coffee?). ましょうか can also offer help: てつだいましょうか (shall I help?).\\nFORM: verb stem + ましょう (polite). Casual: verb + よう (たべよう, いこう).\\nTIP: ましょうか with I as subject = offering help; with 'we' = suggesting an activity.",
            "用途: ましょうは「～しましょう」という勧誘です。\\nいつ: いっしょにたべましょう。\\n形: 動詞語幹＋ましょう。カジュアルは＋よう（たべよう・いこう）。\\nヒント: ましょうかは手伝いの申し出にも使います。",
            "उपयोग: ましょう = 'चलो करें / करेंगे?'।\\nकब: साथ खाएँ, टेनिस खेलें।\\nरूप: क्रिया तना + ましょう। अनौपचारिक: +よう।\\nटिप: ましょうか मदद की पेशकश भी है।",
            """いっしょにたべましょう。|issho ni tabemashou|Let's eat together.|चलो साथ खाएँ।
いきましょう。|ikimashou|Let's go.|चलो चलें।
にほんごをべんきょうしましょう。|nihongo o benkyou shimashou|Let's study Japanese.|चलो जापानी पढ़ें。
テニスをしましょう。|tenisu o shimashou|Let's play tennis.|चलो टेनिस खेलें。
あしたまたあいましょう。|ashita mata aimashou|Let's meet again tomorrow.|कल फिर मिलेंगे।
コーヒーをのみましょう。|koohii o nomimashou|Let's have coffee.|चलो कॉफ़ी पीएँ。
かいものにいきましょう。|kaimono ni ikimashou|Let's go shopping.|चलो खरीदारी चलें।
さんぽしましょう。|sanpo shimashou|Let's take a walk.|चलो सैर करें。
えいがをみましょう。|eiga o mimashou|Let's watch a movie.|चलो फ़िल्म देखें。
うたをうたいましょう。|uta o utaimashou|Let's sing a song.|चलो गाना गाएँ。
おどりましょう。|odorimashou|Let's dance.|चलो नाचें。
あそびましょう。|asobimashou|Let's play.|चलो खेलें。
やすみましょう。|yasumimashou|Let's rest.|चलो आराम करें。
はじめましょう。|hajimemashou|Let's begin.|चलो शुरू करें。
おわりましょう。|owarimashou|Let's finish.|चलो खत्म करें।
てつだいましょうか。|tetsudaimashou ka|Shall I help you?|क्या मैं मदद करूँ?
まどをあけましょうか。|mado o akemashou ka|Shall I open the window?|क्या मैं खिड़की खोलूँ?
おちゃをいれましょうか。|ocha o iremashou ka|Shall I make tea?|क्या मैं चाय बनाऊँ?
かばんをもちましょうか。|kaban o mochimashou ka|Shall I carry your bag?|क्या मैं बैग उठाऊँ?
いっしょにかえりましょう。|issho ni kaerimashou|Let's go home together.|चलो साथ घर चलें。
ここでまちましょう。|koko de machimashou|Let's wait here.|चलो यहाँ इंतज़ार करें।
バスでいきましょう。|basu de ikimashou|Let's go by bus.|चलो बस से चलें。
でんしゃでいきましょう。|densha de ikimashou|Let's go by train.|चलो ट्रेन से चलें。
あしたのあさひろいましょう。|ashita no asa hiroimashou|Let's clean up tomorrow morning.|कल सुबह सफ़ाई करें।
しゅくだいをいっしょにしましょう。|shukudai o issho ni shimashou|Let's do homework together.|चलो साथ होमवर्क करें。
りょうりをつくりましょう。|ryouri o tsukurimashou|Let's cook.|चलो खाना बनाएँ。
これについてはなしあいましょう。|kore ni tsuite hanashiaimashou|Let's discuss this.|चलो इस पर चर्चा करें。
ひるごはんをたべにいきましょう。|hirugohan o tabe ni ikimashou|Let's go eat lunch.|चलो दोपहर का खाना खाएँ।
あたらしいレストランにいきましょう。|atarashii resutoran ni ikimashou|Let's go to a new restaurant.|चलो नए रेस्तराँ चलें。
きょうはここでおわりましょう。|kyou wa koko de owarimashou|Let's stop here for today.|आज यहीं रुकते हैं।"""),
        jp("jg18", "conditionals — ば / たら / と", "条件（ば・たら・と）", "N4",
            "USAGE: Japanese has several ways to say 'if'. ば, たら, と each have their own nuance.\\nWHEN: と = natural cause-and-effect or habits (あめがふると、かさをさします — when it rains, I open an umbrella). たら = after a condition, often one-time (にほんにいったら、すしをたべます — if/when I go to Japan, I'll eat sushi). ば = general condition (あめがふれば、いきません — if it rains, I won't go). ば forms: いけば (go), たべれば (eat), みれば (see). なら = if it's the case that... (あしたなら、いけます — if it's tomorrow, I can go).\\nFORM: verb conditional + と / たら / ば / なら.\\nTIP: と cannot be used when the result is a personal request/desire (おかねがあればいい — not と).",
            "用途: 条件を表す表現は複数あります。\\nいつ: と＝自然な因果・習慣、たら＝条件の後、ば＝一般的条件、なら＝ならば。\\n形: 動詞＋と／たら／ば／なら。\\nヒント: 個人的な願望にはとを使いません（おかねがあればいい）。",
            "उपयोग: जापानी में 'अगर' के कई रूप हैं।\\nकब: と = स्वाभाविक कारण/आदत; たら = शर्त के बाद; ば = सामान्य शर्त; なら = यदि ऐसा है।\\nरूप: क्रिया + と/たら/ば/なら।\\nटिप: व्यक्तिगत इच्छा के साथ と नहीं आता।",
            """あめがふると、かさをさします。|ame ga furu to, kasa o sashimasu|When it rains, I open an umbrella.|बारिश होने पर मैं छाता खोलता हूँ।
あさひがあがると、つめたいです。|asa hi ga agaru to, tsumetai desu|In the morning when the sun rises, it's cold.|सुबह सूरज निकलने पर ठंड होती है。
ボタンをおすと、ドアがあきます。|botan o osu to, doa ga akimasu|If you press the button, the door opens.|बटन दबाने पर दरवाज़ा खुलता है。
にほんにいったら、すしをたべます。|nihon ni ittara, sushi o tabemasu|If I go to Japan, I will eat sushi.|अगर मैं जापान जाऊँ तो सुशी खाऊँगा。
あしたはれたら、こうえんにいきます。|ashita haretara, kouen ni ikimasu|If it's sunny tomorrow, I'll go to the park.|कल धूप निकली तो पार्क जाऊँगा।
じかんがあったら、てつだいます。|jikan ga attara, tetsudaimasu|If I have time, I'll help.|समय मिला तो मदद करूँगा。
おかねがあったら、くるまをかいます。|okane ga attara, kuruma o kaimasu|If I have money, I'll buy a car.|पैसे हों तो गाड़ी खरीदूँगा।
いそがしければ、いきません。|isogashikereba, ikimasen|If I'm busy, I won't go.|व्यस्त रहा तो नहीं जाऊँगा。
あめがふれば、さんぽしません。|ame ga fureba, sanpo shimasen|If it rains, I won't take a walk.|बारिश हुई तो सैर नहीं करूँगा。
やすければ、かいます。|yasukereba, kaimasu|If it's cheap, I'll buy it.|सस्ता हो तो खरीदूँगा।
たかければ、かいません。|takakereba, kaimasen|If it's expensive, I won't buy it.|महँगा हो तो नहीं खरीदूँगा。
べんきょうすれば、じょうずになります。|benkyou sureba, jouzu ni narimasu|If you study, you'll get good at it.|पढ़ोगे तो अच्छे हो जाओगे。
はやくねれば、はやくおきられます。|hayaku nereba, hayaku okiraremasu|If I sleep early, I can wake up early.|जल्दी सोओगे तो जल्दी उठ पाओगे।
みれば、わかります。|mireba, wakarimasu|If you look, you'll understand.|देखोगे तो समझ आएगा।
あしたなら、いけます。|ashita nara, ikemasu|If it's tomorrow, I can go.|अगर कल हो तो मैं जा सकता हूँ。
にほんごなら、すこしわかります。|nihongo nara, sukoshi wakarimasu|If it's Japanese, I understand a little.|जापानी हो तो थोड़ी समझ आती है。
そばにいたら、うれしいです。|soba ni itara, ureshii desu|If you were near me, I'd be happy.|पास होते तो खुश होता।
じかんがあれば、としょかんにいきます。|jikan ga areba, toshokan ni ikimasu|If I have time, I'll go to the library.|समय हो तो पुस्तकालय जाऊँगा।
おなかがすいたら、パンをたべます。|onaka ga suitara, pan o tabemasu|If I get hungry, I'll eat bread.|भूख लगे तो रोटी खाऊँगा。
さむければ、コートをきます。|samukereba, kooto o kimasu|If it's cold, I'll wear a coat.|ठंड हो तो कोट पहनूँगा。
あつければ、エアコンをつけます。|atsukereba, eakon o tsukemasu|If it's hot, I'll turn on the AC.|गरमी हो तो AC चलाऊँगा。
かいしゃについたら、でんわします。|kaisha ni tsuitara, denwa shimasu|When I arrive at work, I'll call.|ऑफ़िस पहुँचते ही फ़ोन करूँगा。
ごはんをたべたら、でかけます。|gohan o tabetara, dekakemasu|After I eat, I'll go out.|खाना खाकर बाहर जाऊँगा。
あたらしいくつをかえったら、はきます。|atarashii kutsu o kaettara, hakimasu|When I buy new shoes, I'll wear them.|नए जूते खरीदते ही पहनूँगा。
じゅうしょがわかったら、おしえます。|juusho ga wakattara, oshiemasu|If I find out the address, I'll tell you.|पता मिलते ही बताऊँगा。
やすみなら、うちにいます。|yasumi nara, uchi ni imasu|If it's a holiday, I'll stay home.|छुट्टी हो तो घर रहूँगा。
かのじょがくれば、はなします。|kanojo ga kureba, hanashimasu|If she comes, I'll talk to her.|वह आए तो बात करूँगा。
これなら、だいじょうぶです。|kore nara, daijoubu desu|If it's this, it's fine.|यह हो तो ठीक है।
わからなければ、きいてください。|wakaranakereba, kiite kudasai|If you don't understand, please ask.|समझ न आए तो पूछिए।
むりなら、やめましょう。|muri nara, yamemashou|If it's too much, let's stop.|मुश्किल हो तो छोड़ देते हैं।"""),

        jp("jg19", "comparison — より & いちばん", "比較（より・いちばん）", "N4",
            "USAGE: より compares two things ('than'), and いちばん picks the best of three or more ('the most').\\nWHEN: AはBより + adjective: とうきょうはきょうとよりおおきいです (Tokyo is bigger than Kyoto). いちばん + adjective: にほんでいちばんたかいやまはふじさんです (Mt. Fuji is the highest mountain in Japan). Ask: どちらが...ですか (which of two?), どれが...ですか (which of many?).\\nFORM: noun1 + は + noun2 + より + adjective | noun + で/のなかで + いちばん + adjective.\\nTIP: with いちばん, use のなかで for a group: かぞくのなかでいちばんせがたかいです (tallest in the family).",
            "用途: よりは比較、いちばんは最上級です。\\nいつ: AはBより＋形容詞。〜のなかでいちばん＋形容詞。\\n形: 名詞1は名詞2より＋形容詞｜〜のなかでいちばん＋形容詞。\\nヒント: グループ内は「のなかで」を使います。",
            "उपयोग: より = 'से बड़ा'; いちばん = 'सबसे'।\\nकब: A, B से बड़ा है; समूह में सबसे।\\nरूप: AはBより + विशेषण | ~のなかでいちばん + विशेषण।\\nटिप: समूह के लिए のなかで।",
            """とうきょうはきょうとよりおおきいです。|toukyou wa kyouto yori ookii desu|Tokyo is bigger than Kyoto.|टोक्यो क्योटो से बड़ा है।
ねこはあうさぎよりおおきいです。|neko wa ausagi yori ookii desu|A cat is bigger than a rabbit.|बिल्ली खरगोश से बड़ी है。
でんしゃはバスよりはやいです。|densha wa basu yori hayai desu|The train is faster than the bus.|ट्रेन बस से तेज़ है。
これはそれよりたかいです。|kore wa sore yori takai desu|This is more expensive than that.|यह उससे महँगा है।
えいごはにほんごよりやさしいです。|eigo wa nihongo yori yasashii desu|English is easier than Japanese.|अंग्रेज़ी जापानी से आसान है。
きょうはきのうよりさむいです。|kyou wa kinou yori samui desu|Today is colder than yesterday.|आज कल से ठंडा है。
わたしはあなたよりせがたかいです。|watashi wa anata yori se ga takai desu|I am taller than you.|मैं तुमसे लंबा हूँ。
このみせはあのみせよりやすいです。|kono mise wa ano mise yori yasui desu|This shop is cheaper than that one.|यह दुकान उससे सस्ती है。
かれはわたしよりわかいです。|kare wa watashi yori wakai desu|He is younger than me.|वह मुझसे छोटा है。
あたらしいほうがいいです。|atarashii hou ga ii desu|The new one is better.|नया वाला बेहतर है。
すしのほうがやきにくよりすきです。|sushi no hou ga yakiniku yori suki desu|I like sushi more than yakiniku.|मुझे सुशी याकिनिकु से ज़्यादा पसंद है।
にほんでいちばんたかいやまはふじさんです。|nihon de ichiban takai yama wa fujisan desu|Mt. Fuji is the highest mountain in Japan.|जापान का सबसे ऊँचा पर्वत फ़ूजी है।
かぞくのなかでいちばんせがたかいです。|kazoku no naka de ichiban se ga takai desu|(I am) the tallest in the family.|परिवार में सबसे लंबा मैं हूँ。
クラスでいちばんせがたかいのはだれですか。|kurasu de ichiban se ga takai no wa dare desu ka|Who is the tallest in the class?|कक्षा में सबसे लंबा कौन है?
これはクラスでいちばんむずかしいです。|kore wa kurasu de ichiban muzukashii desu|This is the hardest in class.|यह कक्षा में सबसे कठिन है।
いちばんすきなたべものはなんですか。|ichiban suki na tabemono wa nan desu ka|What is your favorite food?|तुम्हारा सबसे पसंदीदा खाना क्या है?
いちばんすきなのはラーメンです。|ichiban suki na no wa raamen desu|My favorite is ramen.|सबसे पसंदीदा रामेन है।
どちらがすきですか。|dochira ga suki desu ka|Which one do you like (of two)?|इन दोनों में कौन पसंद है?
どちらがいいですか。|dochira ga ii desu ka|Which is better?|कौन बेहतर है?
みぎとひだり、どちらですか。|migi to hidari, dochira desu ka|Right or left, which one?|दाएँ या बाएँ, कौन?
どれがいちばんやすいですか。|dore ga ichiban yasui desu ka|Which one is the cheapest?|कौन-सा सबसे सस्ता है?
これがいちばんやすいです。|kore ga ichiban yasui desu|This is the cheapest.|यह सबसे सस्ता है。
なつはふゆよりあついです。|natsu wa fuyu yori atsui desu|Summer is hotter than winter.|गर्मी सर्दी से ज़्यादा गरम है。
きょうはきのうよりいそがしいです。|kyou wa kinou yori isogashii desu|Today is busier than yesterday.|आज कल से ज़्यादा व्यस्त है।
このホテルはいちばんゆうめいです。|kono hoteru wa ichiban yuumei desu|This hotel is the most famous.|यह होटल सबसे प्रसिद्ध है。
かのじょはいちばんきれいです。|kanojo wa ichiban kirei desu|She is the most beautiful.|वह सबसे सुंदर है。
かれがいちばんゆうきがあります。|kare ga ichiban yuuki ga arimasu|He has the most courage.|उसमें सबसे ज़्यादा साहस है।
このりんごはあのりんごよりあまいです。|kono ringo wa ano ringo yori amai desu|This apple is sweeter than that one.|यह सेब उससे मीठा है。
くるまはじてんしゃよりはやいです。|kuruma wa jitensha yori hayai desu|A car is faster than a bicycle.|गाड़ी साइकिल से तेज़ है。
わたしはかいものよりさんぽがすきです。|watashi wa kaimono yori sanpo ga suki desu|I like walking more than shopping.|मुझे खरीदारी से ज़्यादा सैर पसंद है।"""),
        jp("jg20", "counters — counting things", "助数詞（数え方）", "N4",
            "USAGE: Japanese uses different counters for different kinds of things. The number + counter comes before the noun or after を/が.\\nWHEN: ほん (hon) for long thin things: ペンをにほん (two pens); まい (mai) for flat things: かみをさんまい (three sheets of paper); さつ (satsu) for books: ほんをいっさつ (one book); にん (nin) for people: ひとがふたり (two people); ひき (hiki) for animals; こ (ko) for small round things. Numbers change sound before counters: いっ, に, さん, よん, ご, ろく, なな, はち, きゅう, じゅう.\\nFORM: number + counter. e.g. ひとつ, ふたつ, みっつ... for general counting up to 10.\\nTIP: ひとり and ふたり are special for 1 and 2 people. For most everyday counting, つ (ひとつ, ふたつ...) works.",
            "用途: 日本語では物の種類によって数え方が変わります。\\nいつ: ほん（細長い）、まい（平たい）、さつ（本）、にん（人）、ひき（動物）、こ（小さいもの）。\\n形: 数＋助数詞。\\nヒント: 一人・二人は特別。日常はつ（ひとつ・ふたつ）で十分。",
            "उपयोग: जापानी में वस्तु के प्रकार से गिनती बदलती है।\\nकब: ほん (लंबी), まい (चपटी), さつ (किताबें), にん (लोग), ひき (जानवर), こ (छोटी)।\\nरूप: संख्या + गिनती-शब्द।\\nटिप: एक-दो लोगों के लिए ひとり/ふたり। सामान्य गिनती के लिए つ।",
            """ペンをにほんください。|pen o nihon kudasai|Two pens, please.|दो कलम दीजिए।
かみをさんまいください。|kami o sanmai kudasai|Three sheets of paper, please.|तीन काग़ज़ दीजिए。
ほんをいっさつかいました。|hon o issatsu kaimashita|I bought one book.|मैंने एक किताब खरीदी。
ひとがふたりきました。|hito ga futari kimashita|Two people came.|दो लोग आए।
ねこがさんびきいます。|neko ga sanbiki imasu|There are three cats.|तीन बिल्लियाँ हैं。
りんごをみっつください。|ringo o mittsu kudasai|Three apples, please.|तीन सेब दीजिए。
たまごをよっつください。|tamago o yottsu kudasai|Four eggs, please.|चार अंडे दीजिए。
えんぴつをよんほんください。|enpitsu o yonhon kudasai|Four pencils, please.|चार पेंसिल दीजिए。
しゃしんをごまいとりました。|shashin o gomai torimashita|I took five photos.|मैंने पाँच फ़ोटो लीं。
パンをいちまいください。|pan o ichimai kudasai|One slice of bread, please.|एक रोटी दीजिए。
くるまをいちだいもちたいです。|kuruma o ichidai mochitai desu|I want one car.|मुझे एक गाड़ी चाहिए。
じてんしゃをにだいかいました。|jitensha o nidai kaimashita|I bought two bicycles.|मैंने दो साइकिलें खरीदीं。
こうえんにこどもがなんにんいますか。|kouen ni kodomo ga nannin imasu ka|How many children are in the park?|पार्क में कितने बच्चे हैं?
こどもがよにんいます。|kodomo ga yonin imasu|There are four children.|चार बच्चे हैं。
ともだちがごにんきてくれました。|tomodachi ga gonin kite kuremashita|Five friends came for me.|पाँच दोस्त आए।
さかなをいっぴきかいました。|sakana o ippiki kaimashita|I bought one fish.|मैंने एक मछली खरीदी。
いぬがにひきいます。|inu ga nihiki imasu|There are two dogs.|दो कुत्ते हैं。
とりがさんわとんでいます。|tori ga sanwa tonde imasu|Three birds are flying.|तीन पक्षी उड़ रहे हैं。
くつをいっそくください。|kutsu o issoku kudasai|One pair of shoes, please.|एक जोड़ी जूते दीजिए。
くつしたをにそくかいました。|kutsushita o nisoku kaimashita|I bought two pairs of socks.|मैंने दो जोड़ी मोज़े खरीदे。
テーブルがいっちゃくあります。|teeburu ga icchaku arimasu|There is one table.|एक मेज़ है。
いすがにきゃくあります。|isu ga nikyaku arimasu|There are two chairs.|दो कुर्सियाँ हैं。
ケーキをひときれください。|keeki o hitokire kudasai|One piece of cake, please.|केक का एक टुकड़ा दीजिए。
みずをいっぱいください。|mizu o ippai kudasai|One glass of water, please.|एक गिलास पानी दीजिए。
ごはんをにはいください。|gohan o nihai kudasai|Two bowls of rice, please.|दो कटोरी चावल दीजिए。
ビールをいっぽんください。|biiru o ippon kudasai|One bottle of beer, please.|एक बोतल बियर दीजिए。
このきょうかしょをにさつください。|kono kyoukasho o nisatsu kudasai|Two copies of this textbook, please.|इस पाठ्यपुस्तक की दो प्रतियाँ दीजिए。
えをいちまいかきました。|e o ichimai kakimashita|I drew one picture.|मैंने एक चित्र बनाया。
ふうとうをじゅうまいください。|fuutou o juumai kudasai|Ten envelopes, please.|दस लिफ़ाफ़े दीजिए。
りんごをひとつたべました。|ringo o hitotsu tabemashita|I ate one apple.|मैंने एक सेब खाया।""")

    )
}
