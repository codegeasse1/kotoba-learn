package com.nexo.kotoba

object JapaneseGrammar {

    private fun jp(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleJa: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "ja", ruleEn, ruleJa, gex(raw), ruleHi, level, "japanese")

    private fun gex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("|")
            PatternExample("💬", c[0], c[1], c[2], c.getOrElse(3) { "" })
        }.toList()

    val patterns: List<Pattern> = listOf(

        jp("jg1", "です / ます — polite endings", "です・ます（丁寧形）", "N5",
            "です = polite 'is/am/are' for nouns and adjectives. ます = polite verb ending. Add か for questions. This is the polite form used with strangers and in business.",
            "です＝名詞・形容詞の丁寧形。ます＝動詞の丁寧形。文末に「か」で質問文になります。",
            "です/ます = विनम्र रूप। संज्ञा के साथ です, क्रिया के साथ ます। अंत में か = प्रश्न।",
            """わたしはがくせいです。|watashi wa gakusei desu|I am a student.|मैं विद्यार्थी हूँ।
きょうはあめです。|kyou wa ame desu|Today is rainy.|आज बारिश है।
これはほんです。|kore wa hon desu|This is a book.|यह किताब है।
あしたはいきます。|ashita wa ikimasu|I will go tomorrow.|कल मैं जाऊँगा।
わたしはコーヒーをのみます。|watashi wa koohii o nomimasu|I drink coffee.|मैं कॉफ़ी पीता हूँ。
おげんきですか。|ogenki desu ka|How are you?|आप कैसे हैं?
これはなんですか。|kore wa nan desu ka|What is this?|यह क्या है?
あさのいちばんばんですか。|asa no ichibanban desu ka|Is this the first train?|क्या यह पहली ट्रेन है?
すきやきをたべます。|sukiyaki o tabemasu|I eat sukiyaki.|मैं सुकियाकी खाता हूँ।
にほんごをべんきょうします。|nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ।
きれいなはなです。|kirei na hana desu|It is a pretty flower.|यह सुंदर फूल है।
とうきょうにすんでいます。|toukyou ni sunde imasu|I live in Tokyo.|मैं टोक्यो में रहता हूँ।"""),

        jp("jg2", "は — topic marker", "は（主題）", "N5",
            "は (pronounced 'wa') marks the TOPIC of the sentence — what we are talking about. The rest of the sentence says something about it.",
            "「は」は文の主題を示します。話題について説明を加えます。",
            "は = वाक्य का विषय दिखाता है (wa उच्चारण)।",
            """わたしはにほんじんです。|watashi wa nihonjin desu|I am Japanese.|मैं जापानी हूँ।
ねこはすきです。|neko wa suki desu|I like cats. (As for cats, I like them)|बिल्लियाँ मुझे पसंद हैं।
きょうははれです。|kyou wa hare desu|Today is sunny.|आज धूप है।
このほんはおもしろいです。|kono hon wa omoshiroi desu|This book is interesting.|यह किताब दिलचस्प है।
たなかさんはせんせいです。|tanaka san wa sensei desu|Mr. Tanaka is a teacher.|तनाका-सान शिक्षक हैं।
みずはつめたいです。|mizu wa tsumetai desu|The water is cold.|पानी ठंडा है。
らいしゅうはやすみます。|raishuu wa yasumimasu|Next week, I will rest.|अगले हफ्ते मैं आराम करूँगा।
これはわたしのペンです。|kore wa watashi no pen desu|This is my pen.|यह मेरी कलम है。
いぬはかわいいです。|inu wa kawaii desu|Dogs are cute.|कुत्ते प्यारे होते हैं。
はははぶようですか。|haha wa buyou desu ka|Is your mother well?|क्या आपकी माँ ठीक हैं?"""),

        jp("jg3", "が — subject marker", "が（主語）", "N5",
            "が marks the SUBJECT — who or what does the action, or is described. Often used with すき/きらい (like/dislike), わかる (understand), and to introduce new information.",
            "「が」は動作・状態の主語を示します。すき・きらい・わかる などと一緒によく使います。",
            "が = कर्म/कर्ता दिखाता है। すき/きらい/わかる के साथ आम।",
            """ねこがいます。|neko ga imasu|There is a cat.|बिल्ली है।
さくらがきれいです。|sakura ga kirei desu|The cherry blossoms are pretty.|चेरी के फूल सुंदर हैं।
すしがすきです。|sushi ga suki desu|I like sushi.|मुझे सुशी पसंद है।
にほんごがわかります。|nihongo ga wakarimasu|I understand Japanese.|मुझे जापानी समझ आती है।
だれがきましたか。|dare ga kimashita ka|Who came?|कौन आया?
わたしがやります。|watashi ga yarimasu|I will do it.|मैं करूँगा।
えきはどこにありますか。|eki wa doko ni arimasu ka|Where is the station?|स्टेशन कहाँ है?
おちゃがのみたいです。|ocha ga nomitai desu|I want to drink tea.|मुझे चाय पीनी है।
あめがふっています。|ame ga futte imasu|It is raining.|बारिश हो रही है।
かぎがみつかりません。|kagi ga mitsukarimasen|I can't find the key.|चाबी नहीं मिल रही।"""),

        jp("jg4", "を — object marker", "を（目的語）", "N5",
            "を marks the direct object — the thing the action happens to: ごはんをたべます = eat rice.",
            "「を」は動作の対象（目的語）を示します。",
            "를 = क्रिया का उद्देश्य/कर्म।",
            """ごはんをたべます。|gohan o tabemasu|I eat rice.|मैं चावल खाता हूँ।
ほんをよみます。|hon o yomimasu|I read a book.|मैं किताब पढ़ता हूँ。
えいがをみます。|eiga o mimasu|I watch a movie.|मैं फ़िल्म देखता हूँ。
おんがくをききます。|ongaku o kikimasu|I listen to music.|मैं संगीत सुनता हूँ。
てがみをかきます。|tegami o kakimasu|I write a letter.|मैं पत्र लिखता हूँ。
コーヒーをのみます。|koohii o nomimasu|I drink coffee.|मैं कॉफ़ी पीता हूँ।
かいものをする。|kaimono o suru|I go shopping.|मैं खरीदारी करता हूँ।
なにをしていますか。|nani o shite imasu ka|What are you doing?|तुम क्या कर रहे हो?
にほんごをべんきょうします。|nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ।
パンをかいました。|pan o kaimashita|I bought bread.|मैंने रोटी खरीदी।"""),

        jp("jg5", "に — time & destination", "に（時間・目的）", "N5",
            "に marks a point in TIME (七時に at 7 o'clock) and a DESTINATION or direction (学校に行きます = go to school). Also marks the target of もらう/会う.",
            "「に」は時刻や目的地、方向を示します。",
            "に = समय बिंदु (7 बजे) और गंतव्य (स्कूल जाना)।",
            """しちじにおきます。|shichiji ni okimasu|I get up at 7.|मैं सात बजे उठता हूँ。
がっこうにいきます。|gakkou ni ikimasu|I go to school.|मैं स्कूल जाता हूँ।
とうきょうにすんでいます。|toukyou ni sunde imasu|I live in Tokyo.|मैं टोक्यो में रहता हूँ。
げつようびにかいしゃにいきます。|getsuyoubi ni kaisha ni ikimasu|I go to the office on Monday.|मैं सोमवार को ऑफिस जाता हूँ。
ともだちにあいます。|tomodachi ni aimasu|I meet my friend.|मैं दोस्त से मिलता हूँ。
しんぶんをよみます。|shinbun o yomimasu|I read a newspaper.|मैं अख़बार पढ़ता हूँ।
びょういんにいきます。|byouin ni ikimasu|I go to the hospital.|मैं अस्पताल जाता हूँ।
よじにばんごはんをたべます。|yoji ni bangohan o tabemasu|I eat dinner at 4.|मैं चार बजे रात का खाना खाता हूँ。
くるまでがっこうにいきます。|kuruma de gakkou ni ikimasu|I go to school by car.|मैं कार से स्कूल जाता हूँ।"""),

        jp("jg6", "で — place of action & means", "で（場所・手段）", "N5",
            "で = the place where an action happens (レストランで食べます = eat AT a restaurant) or the MEANS/tool (電車で行きます = go BY train, ペンで書きます = write WITH a pen).",
            "「で」は動作の場所や手段・道具を示します。",
            "で = क्रिया का स्थान (रेस्तराँ में) या साधन (ट्रेन से)।",
            """レストランでたべます。|resutoran de tabemasu|I eat at a restaurant.|मैं रेस्तराँ में खाता हूँ।
でんしゃでいきます。|densha de ikimasu|I go by train.|मैं ट्रेन से जाता हूँ。
としょかんでべんきょうします。|toshokan de benkyou shimasu|I study at the library.|मैं पुस्तकालय में पढ़ता हूँ。
ペンでかきます。|pen de kakimasu|I write with a pen.|मैं कलम से लिखता हूँ。
うちでごはんをたべます。|uchi de gohan o tabemasu|I eat at home.|मैं घर पर खाना खाता हूँ。
バスでかいしゃにいきます。|basu de kaisha ni ikimasu|I go to the office by bus.|मैं बस से ऑफिस जाता हूँ。
こうえんであそびます。|kouen de asobimasu|I play in the park.|मैं पार्क में खेलता हूँ。
テレビでニュースをみます。|terebi de nyuusu o mimasu|I watch the news on TV.|मैं टीवी पर समाचार देखता हूँ。
にほんごではなします。|nihongo de hanashimasu|I speak in Japanese.|मैं जापानी में बोलता हूँ।"""),

        jp("jg7", "へ — direction", "へ（方向）", "N5",
            "へ (pronounced 'e') marks the direction or destination, like に. 日本へ行きます = go to Japan.",
            "「へ」は方向・目的地を示します。「に」と似ています。",
            "へ = दिशा/गंतव्य (उच्चारण 'e')।",
            """にほんへいきます。|nihon e ikimasu|I go to Japan.|मैं जापान जाता हूँ।
うちへかえります。|uchi e kaerimasu|I return home.|मैं घर लौटता हूँ。
みぎへまがってください。|migi e magatte kudasai|Please turn right.|कृपया दाएँ मुड़िए।
ひだりへいきます。|hidari e ikimasu|I go left.|मैं बाएँ जाता हूँ।
ここへきてください。|koko e kite kudasai|Please come here.|कृपया यहाँ आइए।
そちらへむかっています。|sochira e mukatte imasu|I am heading over there.|मैं वहाँ जा रहा हूँ।"""),

        jp("jg8", "と — with / together with", "と（一緒に）", "N5",
            "と = 'with' someone or something (友達と = with a friend), and 'and' for nouns (パンとチーズ = bread and cheese).",
            "「と」は「〜と一緒に」や名詞と名詞をつなぐ「〜と〜」を表します。",
            "तो = 'के साथ' और संज्ञाओं को जोड़ने के लिए 'और'।",
            """ともだちとえいがをみます。|tomodachi to eiga o mimasu|I watch a movie with a friend.|मैं दोस्त के साथ फ़िल्म देखता हूँ।
かぞくとにほんへいきます。|kazoku to nihon e ikimasu|I go to Japan with my family.|मैं परिवार के साथ जापान जाता हूँ।
パンとチーズをかいました。|pan to chiizu o kaimashita|I bought bread and cheese.|मैंने रोटी और चीज़ खरीदी।
だれとしゃべっていますか。|dare to shabette imasu ka|Who are you talking with?|तुम किससे बात कर रहे हो?
かれとけっこんしました。|kare to kekkon shimashita|I married him.|मैंने उससे शादी की।"""),

        jp("jg9", "の — possession", "の（所有）", "N5",
            "の = 'of'/'s'. A の B = B of A (わたしの本 = my book, たなかさんの車 = Mr. Tanaka's car). Also used in explanations.",
            "「の」は所有や所属を表します。AのB＝AのB。",
            "の = संबंध/स्वामित्व (मेरा किताब)।",
            """これはわたしのほんです。|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है。
たなかさんのかばんです。|tanaka san no kaban desu|It is Mr. Tanaka's bag.|यह तनाका-सान का बैग है。
にほんごのせんせいです。|nihongo no sensei desu|He is my Japanese teacher.|वह जापानी के शिक्षक हैं।
きょうとのおてらです。|kyouto no otera desu|It is a temple of Kyoto.|यह क्योटो का मंदिर है।
あねのこどもです。|ane no kodomo desu|It is my older sister's child.|यह मेरी बड़ी बहन का बच्चा है।
とまととなすのサラダです。|tomato to nasu no sarada desu|It is a tomato and eggplant salad.|यह टमाटर और बैंगन का सलाद है।"""),

        jp("jg10", "て-form — connecting & requesting", "て形（接続・依頼）", "N5",
            "The て-form connects verbs and is the basis of many patterns: 〜てください (please do), 〜ています (doing now), 〜てもいいです (may do). Verb endings: たべる→たべて, のむ→のんで, いく→いって.",
            "「て形」は動詞を接続し、ください・います・もいいです などの基礎になります。",
            "て-form क्रियाओं को जोड़ता है: てください = कृपया करें।",
            """ここにすわってください。|koko ni suwatte kudasai|Please sit here.|कृपया यहाँ बैठिए।
まってください。|matte kudasai|Please wait.|कृपया रुकिए।
ちょっとまってください。|chotto matte kudasai|Please wait a moment.|कृपया एक पल रुकिए।
いまテレビをみています。|ima terebi o mite imasu|I am watching TV now.|मैं अभी टीवी देख रहा हूँ。
にほんにすんでいます。|nihon ni sunde imasu|I live in Japan (living).|मैं जापान में रहता हूँ।
しゃしんをとってもいいですか。|shashin o totte mo ii desu ka|May I take a photo?|क्या मैं फ़ोटो ले सकता हूँ?
これをつかってもいいです。|kore o tsukatte mo ii desu|You may use this.|तुम यह इस्तेमाल कर सकते हो。
あしたまでにしゅくだいをやってください。|ashita made ni shukudai o yatte kudasai|Please do your homework by tomorrow.|कृपया कल तक होमवर्क करो।
まいにちうんどうしています。|mainichi undou shite imasu|I exercise every day.|मैं रोज़ कसरत करता हूँ।
りんごをあらってください。|ringo o aratte kudasai|Please wash the apple.|कृपया सेब धो दो।"""),

        jp("jg11", "ない-form — negatives", "ない形（否定）", "N5",
            "The ない-form makes verbs negative: たべない = don't eat, いかない = don't go. In polite speech: たべません / いきません. Adjectives: いい→よくない, たかい→たかくない.",
            "「ない形」で否定を表します。動詞：たべない、いかない。丁寧形：たべません。形容詞：よくない・たかくない。",
            "ない-form नकारात्मक: たべない = नहीं खाता। विनम्र: たべません।",
            """あさごはんをたべません。|asagohan o tabemasen|I don't eat breakfast.|मैं नाश्ता नहीं करता।
きょうはがっこうにいきません。|kyou wa gakkou ni ikimasen|I don't go to school today.|आज मैं स्कूल नहीं जाता।
おさけをのみません。|osake o nomimasen|I don't drink alcohol.|मैं शराब नहीं पीता।
これはたかくないです。|kore wa takakunai desu|This is not expensive.|यह महँगा नहीं है。
じかんがありません。|jikan ga arimasen|I don't have time.|मेरे पास समय नहीं है。
ほんをよみません。|hon o yomimasen|I don't read books.|मैं किताबें नहीं पढ़ता।
ここでたばこをすってはいけません。|koko de tabako o sutte wa ikemasen|You must not smoke here.|यहाँ धूम्रपान मना है।
わかりません。|wakarimasen|I don't understand.|मुझे समझ नहीं आया。
きのうはやすみませんでした。|kinou wa yasumimasen deshita|I didn't rest yesterday.|कल मैंने आराम नहीं किया।
まだたべてないです。|mada tabetenai desu|I haven't eaten yet.|मैंने अभी खाया नहीं है।"""),

        jp("jg12", "た-form — past tense", "た形（過去）", "N5",
            "The た-form is past tense: たべた = ate, いった = went, みた = saw. Polite past: たべました. Adjectives: たかかった (was expensive), よかった (was good).",
            "「た形」は過去を表します。たべた・いった・みた。丁寧形：たべました。形容詞：たかかった・よかった。",
            "ta-form = भूतकाल: たべた = खाया। विनम्र: たべました।",
            """きのうすしをたべました。|kinou sushi o tabemashita|I ate sushi yesterday.|कल मैंने सुशी खाई।
にほんにいったことがあります。|nihon ni itta koto ga arimasu|I have been to Japan.|मैं जापान गया हूँ।
えいがをみました。|eiga o mimashita|I watched a movie.|मैंने फ़िल्म देखी।
きのうはあつかったです。|kinou wa atsukatta desu|It was hot yesterday.|कल गरमी थी।
たべたあとではをみがきます。|tabeta ato de ha o migakimasu|I brush my teeth after eating.|खाने के बाद मैं दाँत साफ़ करता हूँ।
もうしゅくだいをしました。|mou shukudai o shimashita|I already did my homework.|मैंने होमवर्क पहले ही कर लिया।
テストはかんたんでした。|tesuto wa kantandeshita|The test was easy.|परीक्षा आसान थी।
にほんのたべものはおいしかったです。|nihon no tabemono wa oishikatta desu|Japanese food was delicious.|जापानी खाना स्वादिष्ट था।
きのうはなにをしましたか。|kinou wa nani o shimashita ka|What did you do yesterday?|कल तुमने क्या किया?
おんがくをききました。|ongaku o kikimashita|I listened to music.|मैंने संगीत सुना।"""),

        jp("jg13", "〜ている — ongoing actions & states", "〜ている（進行・状態）", "N5",
            "て-form + いる = an action in progress (たべている = is eating) or a resulting state (すんでいる = live, おしえている = teach).",
            "「〜ている」は進行中の動作や状態を表します。たべている＝食べている。",
            "~teiru = चल रही क्रिया या स्थिति। たべている = खा रहा है।",
            """ごはんをたべています。|gohan o tabete imasu|I am eating.|मैं खा रहा हूँ।
べんきょうしています。|benkyou shite imasu|I am studying.|मैं पढ़ रहा हूँ।
なにをしていますか。|nani o shite imasu ka|What are you doing?|तुम क्या कर रहे हो?
とうきょうにすんでいます。|toukyou ni sunde imasu|I live in Tokyo.|मैं टोक्यो में रहता हूँ。
あめがふっています。|ame ga futte imasu|It is raining.|बारिश हो रही है。
かれはねています。|kare wa nete imasu|He is sleeping.|वह सो रहा है。
いまかいしゃにむかっています。|ima kaisha ni mukatte imasu|I am on my way to the office now.|मैं अभी ऑफिस जा रहा हूँ।
このまちにすんでいます。|kono machi ni sunde imasu|I live in this town.|मैं इस शहर में रहता हूँ।
しゃしんをみています。|shashin o mite imasu|I am looking at photos.|मैं फ़ोटो देख रहा हूँ।
あなたはにほんごをべんきょうしていますか。|anata wa nihongo o benkyou shite imasu ka|Are you studying Japanese?|क्या तुम जापानी सीख रहे हो?"""),

        jp("jg14", "Potential — can do (〜られる / 〜える)", "可能形（できる）", "N4",
            "Potential verbs express ability: たべる→たべられる (can eat), のむ→のめる (can drink), いく→いける (can go). Also できる = can do. わたしはすしがたべられます = I can eat sushi.",
            "可能形は能力を表します。たべる→たべられる、のむ→のめる、いく→いける。",
            "Potential रूप = क्षमता: たべられる = खा सकता हूँ।",
            """にほんごがはなせます。|nihongo ga hanasemasu|I can speak Japanese.|मैं जापानी बोल सकता हूँ।
およげますか。|oyogemasu ka|Can you swim?|क्या तुम तैर सकते हो?
すしがたべられます。|sushi ga taberaremasu|I can eat sushi.|मैं सुशी खा सकता हूँ。
ここでしゃしんがとれます。|koko de shashin ga toremasu|You can take photos here.|यहाँ फ़ोटो ली जा सकती है।
にほんへいけます。|nihon e ikemasu|I can go to Japan.|मैं जापान जा सकता हूँ。
うんてんできますか。|unten dekimasu ka|Can you drive?|क्या तुम गाड़ी चला सकते हो?
にほんごがよめるようになりました。|nihongo ga yomeru you ni narimashita|I have become able to read Japanese.|मैं जापानी पढ़ने लायक़ हो गया हूँ।
このアプリはスマホでつかえます。|kono apuri wa sumaho de tsukaemasu|This app can be used on a smartphone.|यह ऐप स्मार्टफ़ोन पर चल सकता है।
どこでのれるんですか。|doko de noeru n desu ka|Where can I get on?|मैं कहाँ से चढ़ सकता हूँ?"""),

        jp("jg15", "〜たい — want to", "〜たい（願望）", "N5",
            "Verb ます-stem + たい = want to do: たべます→たべたい (want to eat), いきます→いきたい (want to go). Object often takes が: すしがたべたい.",
            "「ます形」の語幹＋たいで願望を表します。たべたい・いきたい。対象は「が」を使います。",
            "~tai = करना चाहता हूँ: たべたい = खाना चाहता हूँ।",
            """すしがたべたいです。|sushi ga tabetai desu|I want to eat sushi.|मुझे सुशी खानी है।
にほんにいきたいです。|nihon ni ikitai desu|I want to go to Japan.|मैं जापान जाना चाहता हूँ।
みずがのみたいです。|mizu ga nomitai desu|I want to drink water.|मुझे पानी पीना है。
ねむいです。ねたいです。|netai desu|I want to sleep.|मुझे सोना है।
なにがたべたいですか。|nani ga tabetai desu ka|What do you want to eat?|तुम क्या खाना चाहते हो?
しごとをやめたいです。|shigoto o yametai desu|I want to quit my job.|मैं नौकरी छोड़ना चाहता हूँ।
えいごをならいたいです。|eigo o naraitai desu|I want to learn English.|मैं अंग्रेज़ी सीखना चाहता हूँ।
りょこうしたいです。|ryokou shitai desu|I want to travel.|मैं यात्रा करना चाहता हूँ।
かれにあいたいです。|kare ni aitai desu|I want to meet him.|मैं उससे मिलना चाहता हूँ।
はやくかえりたいです。|hayaku kaeritai desu|I want to go home soon.|मुझे जल्दी घर जाना है।"""),

        jp("jg16", "〜てください — please do", "〜てください（依頼）", "N5",
            "て-form + ください = a polite request: まってください (please wait), みてください (please look).",
            "「て形」＋ください＝丁寧な依頼。まってください・みてください。",
            "~te kudasai = विनम्र अनुरोध: कृपया करें।",
            """ちょっとまってください。|chotto matte kudasai|Please wait a moment.|कृपया एक पल रुकिए।
ここにきてください。|koko ni kite kudasai|Please come here.|कृपया यहाँ आइए。
ドアをしめてください。|doa o shimete kudasai|Please close the door.|कृपया दरवाज़ा बंद कीजिए。
もういちどいってください。|mou ichido itte kudasai|Please say it again.|कृपया फिर से कहिए。
ゆっくりはなしてください。|yukkuri hanashite kudasai|Please speak slowly.|कृपया धीरे बोलिए。
しゃしんをとってください。|shashin o totte kudasai|Please take a photo.|कृपया फ़ोटो लीजिए。
これをつかってください。|kore o tsukatte kudasai|Please use this.|कृपया यह इस्तेमाल कीजिए。
まいにちれんしゅうしてください。|mainichi renshuu shite kudasai|Please practice every day.|कृपया रोज़ अभ्यास कीजिए।
あしたもってきてください。|ashita motte kite kudasai|Please bring it tomorrow.|कृपया इसे कल लाइए।"""),

        jp("jg17", "〜ましょう — let's / shall we", "〜ましょう（勧誘）", "N5",
            "Verb ます-stem + ましょう = 'let's do': いきましょう (let's go), たべましょう (let's eat). Question 〜ませんか = 'won't you...?' invitation.",
            "「〜ましょう」で誘い・提案を表します。「〜ませんか」は丁寧な誘い。",
            "~mashou = 'चलो करें'। ~masenka = विनम्र निमंत्रण।",
            """いっしょにいきましょう。|issho ni ikimashou|Let's go together.|चलो साथ चलते हैं।
たべましょう。|tabemashou|Let's eat.|चलो खाते हैं。
うちにかえりましょう。|uchi ni kaerimashou|Let's go home.|चलो घर चलते हैं。
コーヒーをのみませんか。|koohii o nomimasen ka|Won't you have some coffee?|क्या आप कॉफ़ी लेंगे?
えいがをみませんか。|eiga o mimasen ka|Shall we watch a movie?|क्या हम फ़िल्म देखें?
あしたまたあいましょう。|ashita mata aimashou|Let's meet again tomorrow.|चलो कल फिर मिलते हैं。
やすみましょう。|yasumimashou|Let's take a break.|चलो आराम करते हैं。
はじめましょう。|hajimemashou|Let's begin.|चलो शुरू करते हैं।
いっしょにべんきょうしませんか。|issho ni benkyou shimasen ka|Won't you study together?|क्या आप साथ पढ़ेंगे?"""),

        jp("jg18", "Conditionals — ば / たら / と", "条件（ば・たら・と）", "N4",
            "ば (if): 行けば if (I) go. たら (when/if, after): 行ったら. と (whenever, natural result): 行くと. 雨が降ったら、うちにいます = If it rains, I'll stay home.",
            "「ば」「たら」「と」は条件を表します。たら＝〜したら、と＝〜すると。",
            "शर्तें: ば/たら/と = 'अगर/जब'।",
            """あめがふったら、うちにいます。|ame ga futtara, uchi ni imasu|If it rains, I will stay home.|अगर बारिश हुई तो मैं घर पर रहूँगा।
じかんがあれば、いきます。|jikan ga areba, ikimasu|If I have time, I will go.|अगर समय मिला तो जाऊँगा。
あさになると、おきる。|asa ni naru to, okiru|When morning comes, I get up.|सुबह होते ही मैं उठता हूँ।
やすみだったら、あそびましょう。|yasumi dattara, asobimashou|If it is a holiday, let's play.|अगर छुट्टी हो तो चलो खेलें।
ねむかったら、ねてください。|nemukattara, nete kudasai|If you are sleepy, please sleep.|अगर नींद आए तो सो जाइए।
これをよめば、わかります。|kore o yomeba, wakarimasu|If you read this, you will understand.|अगर यह पढ़ोगे तो समझ आ जाएगा।
ボタンをおすと、でんきがつきます。|botan o osu to, denki ga tsukimasu|When you press the button, the light comes on.|बटन दबाते ही बत्ती जल जाती है।
にほんにいったら、すしをたべます。|nihon ni ittara, sushi o tabemasu|When I go to Japan, I'll eat sushi.|जापान जाऊँ तो सुशी खाऊँगा।"""),

        jp("jg19", "Comparison — より & いちばん", "比較（より・いちばん）", "N4",
            "A は B より... = A is more ... than B (ねこは いぬより 小さい). いちばん = the most (いちばん好き). 〜と〜と どちらが = which of A and B.",
            "「AはBより〜」＝BよりAの方が〜。「いちばん」＝一番。",
            "तुलना: A は B より = A, B से ज़्यादा; いちばん = सबसे।",
            """ねこはいぬよりちいさいです。|neko wa inu yori chiisai desu|Cats are smaller than dogs.|बिल्लियाँ कुत्तों से छोटी होती हैं।
にほんごはえいごよりむずかしいです。|nihongo wa eigo yori muzukashii desu|Japanese is harder than English.|जापानी अंग्रेज़ी से कठिन है।
さくらがいちばんすきです。|sakura ga ichiban suki desu|I like cherry blossoms the most.|मुझे चेरी फूल सबसे पसंद हैं。
とうきょうはおおさかよりおおきいです。|toukyou wa oosaka yori ookii desu|Tokyo is bigger than Osaka.|टोक्यो ओसाका से बड़ा है。
どちらがすきですか。|dochira ga suki desu ka|Which do you prefer?|कौन सा पसंद है?
でんしゃとバスとどちらがはやいですか。|densha to basu to dochira ga hayai desu ka|Which is faster, the train or the bus?|ट्रेन और बस में से कौन तेज़ है?
きのうよりあついです。|kinou yori atsui desu|It is hotter than yesterday.|कल से ज़्यादा गरम है।
いちばんちかいえきはどこですか。|ichiban chikai eki wa doko desu ka|Where is the nearest station?|सबसे नज़दीकी स्टेशन कहाँ है?"""),

        jp("jg20", "Counters — counting things", "助数詞（数え方）", "N4",
            "Different suffixes count different things: 人 (にん) people (三人 = 3 people), つ general objects (みっつ = 3 things), 本 (ほん) long thin things (3 books/pen), 枚 (まい) flat things (3 sheets), 回 (かい) times.",
            "物の種類によって数え方が変わります。人＝にん、本＝ほん、枚＝まい、回＝かい。",
            "गिनती के अलग-अलग शब्द: にん (लोग), ほん (लंबी चीज़ें), まい (पतली चीज़ें)।",
            """ともだちがさんにんいます。|tomodachi ga sannin imasu|I have three friends.|मेरे तीन दोस्त हैं。
りんごをよっつかいました。|ringo o yottsu kaimashita|I bought four apples.|मैंने चार सेब खरीदे。
ほんをさんさつよみました。|hon o sansatsu yomimashita|I read three books.|मैंने तीन किताबें पढ़ीं。
ボールペンをいっぽんください。|boorupen o ippon kudasai|Please give me one pen.|कृपया मुझे एक कलम दीजिए。
かみをごまいください。|kami o gomai kudasai|Please give me five sheets of paper.|कृपया मुझे पाँच कागज़ दीजिए।
にほんににかいきました。|nihon ni nikai ikimashita|I have been to Japan twice.|मैं दो बार जापान गया हूँ。
きょうはひとつもたべていません。|kyou wa hitotsu mo tabete imasen|I haven't eaten anything today.|आज मैंने कुछ भी नहीं खाया।
ねこがごひきいます。|neko ga gohiki imasu|There are five cats.|पाँच बिल्लियाँ हैं।
じゅうにじかんはたらきました。|juunijikan hatarakimashita|I worked for twelve hours.|मैंने बारह घंटे काम किया।
なんにんできましたか。|nannin de kimashita ka|How many people came?|कितने लोग आए?""")
    )
}
