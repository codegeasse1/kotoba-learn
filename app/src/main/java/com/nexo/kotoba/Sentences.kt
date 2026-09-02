package com.nexo.kotoba

object Sentences {

    private var sid = 0

    private fun sc(raw: String): List<Sentence> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Sentence("s${sid++}", c[0], c[1], c[2], c[3], c.getOrElse(4) { "" })
        }.toList()

    private fun sec(raw: String): List<Sentence> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Sentence("s${sid++}", c[0], c[1], "", c[1], c.getOrElse(2) { "" })
        }.toList()

    val categories = listOf(
        SentenceCategory("sj-greet", "👋 Greetings & Introductions", "👋", "Beginner conversations for meeting people", sc("""
👋|こんにちは。|konnichiwa.|Hello.|नमस्ते।
🌅|おはようございます。|ohayou gozaimasu.|Good morning.|सुप्रभात।
🌙|こんばんは。|konbanwa.|Good evening.|शुभ संध्या।
🌃|おやすみなさい。|oyasuminasai.|Good night.|शुभ रात्रि।
🙏|ありがとうございます。|arigatou gozaimasu.|Thank you very much.|बहुत धन्यवाद।
🙏|どういたしまして。|dou itashimashite.|You're welcome.|कोई बात नहीं।
😊|はじめまして。|hajimemashite.|Nice to meet you.|आपसे मिलकर खुशी हुई।
📛|おなまえはなんですか。|onamae wa nan desu ka.|What is your name?|आपका नाम क्या है?
👤|わたしはたろうです。|watashi wa tarou desu.|I am Tarou.|मैं तारो हूँ।
🌏|どこのしゅっしんですか。|doko no shusshin desu ka.|Where are you from?|आप कहाँ के रहने वाले हैं?
🇮🇳|インドからきました。|indo kara kimashita.|I came from India.|मैं भारत से आया/आई हूँ।
🗣️|にほんごがはなせますか。|nihongo ga hanasemasu ka.|Can you speak Japanese?|क्या आप जापानी बोल सकते हैं?
😌|すこしだけはなせます。|sukoshi dake hanasemasu.|I can speak a little.|मैं थोड़ी-बहुत बोल सकता/सकती हूँ।
👋|またあした。|mata ashita.|See you tomorrow.|कल मिलते हैं।
📅|またらいしゅう。|mata raishuu.|See you next week.|अगले हफ्ते मिलते हैं।
🤝|よろしくおねがいします。|yoroshiku onegaishimasu.|Nice to meet you (please treat me well).|आपसे परिचय पाकर अच्छा लगा।
😃|おげんきですか。|ogenki desu ka.|How are you?|आप कैसे हैं?
😊|げんきです、ありがとう。|genki desu, arigatou.|I'm fine, thanks.|मैं ठीक हूँ, धन्यवाद।
💼|おしごとはなんですか。|oshigoto wa nan desu ka.|What do you do for work?|आप क्या काम करते हैं?
👨‍💻|エンジニアです。|enjinia desu.|I am an engineer.|मैं इंजीनियर हूँ।
"""), "ja"),
        SentenceCategory("sj-talk", "🗣️ Small Talk", "🗣️", "Casual everyday conversations", sc("""
☕|きょうはいいてんきですね。|kyou wa ii tenki desu ne.|It's nice weather today, isn't it.|आज मौसम अच्छा है ना।
🌧️|あめがふりそうですね。|ame ga furisou desu ne.|It looks like it might rain.|बारिश होने वाली है।
🍵|おちゃをのみませんか。|ocha wo nominasen ka.|Would you like some tea?|चाय लेंगे?
🎬|このえいが、みましたか。|kono eiga, mimashita ka.|Have you seen this movie?|क्या आपने यह फिल्म देखी है?
🍜|らーめんがすきですか。|raamen ga suki desu ka.|Do you like ramen?|क्या आपको रामेन पसंद है?
🏞️|しゅうまつはなにをしましたか。|shuumatsu wa nani wo shimashita ka.|What did you do on the weekend?|आपने सप्ताहांत क्या किया?
📺|きのうはテレビをみました。|kinou wa terebi wo mimashita.|I watched TV yesterday.|मैंने कल टीवी देखा।
🏀|スポーツはなにがすきですか。|supootsu wa nani ga suki desu ka.|What sport do you like?|आपको कौन सा खेल पसंद है?
🎵|どんなおんがくがすきですか。|donna ongaku ga suki desu ka.|What kind of music do you like?|आपको कैसा संगीत पसंद है?
🐈|ペットをかっていますか。|petto wo katte imasu ka.|Do you have a pet?|क्या आपके पास पालतू जानवर है?
🐕|いぬをかっています。|inu wo katte imasu.|I have a dog.|मेरे पास कुत्ता है।
😴|きょうはつかれました。|kyou wa tsukaremashita.|I'm tired today.|आज मैं थक गया/गई हूँ।
🍽️|もうごはんをたべましたか。|mou gohan wo tabemashita ka.|Have you already eaten?|क्या आपने खाना खा लिया?
🥤|まだたべていません。|mada tabete imasen.|I haven't eaten yet.|मैंने अभी खाना नहीं खाया।
⏰|ふだんはなんじにおきますか。|fudan wa nanji ni okimasu ka.|What time do you usually wake up?|आप आमतौर पर कितने बजे उठते हैं?
🚃|でんしゃでかいしゃにいきます。|densha de kaisha ni ikimasu.|I go to work by train.|मैं ट्रेन से ऑफिस जाता/जाती हूँ।
🏠|いまどこにすんでいますか。|ima doko ni sunde imasu ka.|Where do you live now?|अभी आप कहाँ रहते हैं?
🗼|とうきょうにすんでいます。|toukyou ni sunde imasu.|I live in Tokyo.|मैं टोक्यो में रहता/रहती हूँ।
🥵|きょうはあついですね。|kyou wa atsui desu ne.|It's hot today, isn't it.|आज गर्मी है ना।
😄|たのしかったです。|tanoshikatta desu.|That was fun.|बहुत मज़ा आया।
"""), "ja"),
        SentenceCategory("sj-food", "🍜 Food & Eating Out", "🍜", "Ordering food and talking about meals", sc("""
🍽️|おなかがすきました。|onaka ga sukimashita.|I'm hungry.|मुझे भूख लगी है।
🥤|のどがかわきました。|nodo ga kawakimashita.|I'm thirsty.|मुझे प्यास लगी है।
🍱|このみせのりょうりはおいしいです。|kono mise no ryouri wa oishii desu.|This restaurant's food is delicious.|इस रेस्तराँ का खाना स्वादिष्ट है।
📖|メニューをみせてください。|menyuu wo misete kudasai.|Please show me the menu.|कृपया मेनू दिखाइए।
🍜|らーめんをください。|raamen wo kudasai.|Ramen, please.|एक रामेन दीजिए।
🥢|これ、おいしいです！|kore, oishii desu!|This is delicious!|यह स्वादिष्ट है!
🌶️|からいものはたべられますか。|karai mono wa taberaremasu ka.|Can you eat spicy food?|क्या आप मसालेदार खाना खा सकते हैं?
🍚|ごはんをもういっぱいください。|gohan wo mou ippai kudasai.|One more bowl of rice, please.|एक और कटोरी चावल दीजिए।
💧|みずをください。|mizu wo kudasai.|Water, please.|पानी दीजिए।
🧾|おかいけいをおねがいします。|okaikei wo onegaishimasu.|The bill, please.|बिल दीजिए।
💳|カードでおねがいします。|kaado de onegaishimasu.|By card, please.|कार्ड से दीजिए।
🍣|おすしはにほんのたべものです。|osushi wa nihon no tabemono desu.|Sushi is Japanese food.|सुशी जापानी खाना है।
🥟|ぎょうざをたべたいです。|gyouza wo tabetai desu.|I want to eat gyoza.|मैं ग्योज़ा खाना चाहता/चाहती हूँ।
🍳|あさごはんはたべました。|asagohan wa tabemashita.|I ate breakfast.|मैंने नाश्ता कर लिया।
🍱|おべんとうをもってきました。|obentou wo motte kimashita.|I brought a lunch box.|मैं टिफिन लाया/लाई हूँ।
🍰|デザートはありますか。|dezaato wa arimasu ka.|Do you have dessert?|क्या मिठाई है?
☕|コーヒー、いかがですか。|koohii, ikaga desu ka.|Would you like some coffee?|कॉफ़ी लेंगे?
🥗|やさいをたくさんたべます。|yasai wo takusan tabemasu.|I eat a lot of vegetables.|मैं बहुत सब्ज़ियाँ खाता/खाती हूँ।
🍖|にくはあまりたべません。|niku wa amari tabemasen.|I don't eat much meat.|मैं ज़्यादा माँस नहीं खाता/खाती।
🥡|もっていっていいですか。|motte itte ii desu ka.|Can I take it to go?|क्या मैं पैक करा सकता/सकती हूँ?
"""), "ja"),
        SentenceCategory("sj-shop", "🛍️ Shopping & Prices", "🛍️", "Buying things, asking prices", sc("""
🛍️|きょうはかいものにいきます。|kyou wa kaimono ni ikimasu.|I'm going shopping today.|आज मैं खरीदारी करने जा रहा/रही हूँ।
🏬|デパートはどこですか。|depaato wa doko desu ka.|Where is the department store?|डिपार्टमेंट स्टोर कहाँ है?
💰|これはいくらですか。|kore wa ikura desu ka.|How much is this?|यह कितने का है?
🧾|それはたかいですね。|sore wa takai desu ne.|That's expensive.|यह महँगा है।
😊|やすいものをさがしています。|yasui mono wo sagashite imasu.|I'm looking for something cheap.|मैं कुछ सस्ता ढूँढ रहा/रही हूँ।
🛒|これをください。|kore wo kudasai.|I'll take this.|यह लेता/लेती हूँ।
📏|サイズはありますか。|saizu wa arimasu ka.|Do you have my size?|क्या मेरा साइज़ मिलेगा?
👗|ちょっとおおきいです。|chotto ookii desu.|It's a little big.|यह थोड़ा बड़ा है।
👕|これ、しちゃくしてもいいですか。|kore, shichaku shite mo ii desu ka.|Can I try this on?|क्या मैं इसे पहनकर देख सकता/सकती हूँ?
🔁|かえすことができますか。|kaesu koto ga dekimasu ka.|Can I return it?|क्या मैं इसे लौटा सकता/सकती हूँ?
🎁|プレゼントようでおねがいします。|purezento you de onegaishimasu.|It's a gift, please.|यह उपहार के लिए है।
🧾|レシートをください。|reshiito wo kudasai.|May I have a receipt?|रसीद दीजिए।
💰|ねだんはいくらですか。|nedan wa ikura desu ka.|What's the price?|कीमत क्या है?
🆓|むりょうですか。|muryou desu ka.|Is it free?|क्या यह मुफ़्त है?
🛍️|さいふをわすれました。|saifu wo wasuremashita.|I forgot my wallet.|मैं पर्स भूल गया/गई।
😥|かねがたりません。|kane ga tarimasen.|I don't have enough money.|मेरे पास पैसे कम हैं।
🧺|ふたつでいくらですか。|futatsu de ikura desu ka.|How much for two?|दो के कितने?
✨|みせのひとがしんせつでした。|mise no hito ga shinsetsu deshita.|The shop staff were kind.|दुकानदार बहुत अच्छे थे।
🏪|こんびにでかいました。|konbini de kaimashita.|I bought it at the convenience store.|मैंने इसे कन्वीनियंस स्टोर से खरीदा।
🧾|カードでもいいですか。|kaado demo ii desu ka.|Is card okay?|क्या कार्ड चलेगा?
"""), "ja"),
        SentenceCategory("sj-train", "🚇 Transport & Directions", "🚇", "Trains, buses, asking directions", sc("""
🚉|えきはどこですか。|eki wa doko desu ka.|Where is the station?|स्टेशन कहाँ है?
🚃|つぎのでんしゃはなんじですか。|tsugi no densha wa nanji desu ka.|What time is the next train?|अगली ट्रेन कितने बजे है?
🗺️|とうきょうえきまでおねがいします。|toukyou eki made onegaishimasu.|To Tokyo Station, please.|टोक्यो स्टेशन चलिए।
🎟️|きっぷはどこでかいますか。|kippu wa doko de kaimasu ka.|Where do I buy a ticket?|टिकट कहाँ मिलेगा?
🚌|このバスはしんじゅくにいきますか。|kono basu wa shinjuku ni ikimasu ka.|Does this bus go to Shinjuku?|क्या यह बस शिंजुकु जाती है?
🧭|ここからとおいですか。|koko kara tooi desu ka.|Is it far from here?|क्या यह यहाँ से दूर है?
🚶|あるいてごふんくらいです。|aruite gofun kurai desu.|It's about a five-minute walk.|पैदल लगभग पाँच मिनट है।
🔄|ここでおりてください。|koko de orite kudasai.|Please get off here.|कृपया यहाँ उतरिए।
🚕|タクシーでいきましょう。|takushii de ikimashou.|Let's go by taxi.|चलो टैक्सी से चलते हैं।
🅿️|くるまをここにとめていいですか。|kuruma wo koko ni tomete ii desu ka.|Can I park here?|क्या मैं यहाँ गाड़ी खड़ी कर सकता/सकती हूँ?
🚲|じてんしゃでいきます。|jitensha de ikimasu.|I go by bicycle.|मैं साइकिल से जाता/जाती हूँ।
⛽|ガソリンをいれてください。|gasorin wo irete kudasai.|Please fill it with gas.|कृपया पेट्रोल भर दीजिए।
🚇|ちかてつがべんりです。|chikatetsu ga benri desu.|The subway is convenient.|मेट्रो बहुत सुविधाजनक है।
⏰|でんしゃがおくれています。|densha ga okurete imasu.|The train is delayed.|ट्रेन लेट है।
🗺️|まちがえました。|machigaemashita.|I made a mistake.|मैंने गलती कर दी।
🧭|みぎにまがってください。|migi ni magatte kudasai.|Please turn right.|दाएँ मुड़िए।
⬅️|ひだりにまがってください。|hidari ni magatte kudasai.|Please turn left.|बाएँ मुड़िए।
⬆️|まっすぐいってください。|massugu itte kudasai.|Please go straight.|सीधे चलिए।
🚏|バスていはどこですか。|basutei wa doko desu ka.|Where is the bus stop?|बस स्टॉप कहाँ है?
🎟️|このきっぷはつかえますか。|kono kippu wa tsukaemasu ka.|Can I use this ticket?|क्या यह टिकट चलेगा?
"""), "ja"),
        SentenceCategory("sj-travel", "🏨 Travel & Hotels", "🏨", "Hotels, airports, sightseeing", sc("""
🏨|よやくがあります。|yoyaku ga arimasu.|I have a reservation.|मेरा आरक्षण है।
📋|チェックインをおねがいします。|chekkuin wo onegaishimasu.|I'd like to check in.|चेक-इन करना है।
🗝️|へやのキーをください。|heya no kii wo kudasai.|Room key, please.|कमरे की चाबी दीजिए।
🛏️|へやはきれいです。|heya wa kirei desu.|The room is clean.|कमरा साफ़ है।
🌅|けしきがすばらしいです。|keshiki ga subarashii desu.|The view is wonderful.|नज़ारा बहुत सुंदर है।
📶|Wi-Fiはつながりますか。|wai fai wa tsunagarimasu ka.|Is there Wi-Fi?|क्या वाई-फ़ाई है?
🕐|チェックアウトはなんじですか。|chekkuauto wa nanji desu ka.|What time is checkout?|चेक-आउट कितने बजे है?
🧳|にもつをあずかってもいいですか。|nimotsu wo azukatte mo ii desu ka.|Can I leave my luggage?|क्या मैं अपना सामान रखवा सकता/सकती हूँ?
🚕|くうこうまでタクシーをおねがいします。|kuukou made takushii wo onegaishimasu.|Please call a taxi to the airport.|हवाई अड्डे के लिए टैक्सी बुलाइए।
🗺️|ちずをもらえますか。|chizu wo moraemasu ka.|Can I get a map?|क्या मुझे नक्शा मिल सकता है?
🔌|チャージャーをわすれました。|chaaJaa wo wasuremashita.|I forgot my charger.|मैं चार्जर भूल गया/गई।
💡|でんきがつきません。|denki ga tsukimasen.|The light doesn't work.|बत्ती नहीं जल रही।
🛠️|なおしてもらえますか。|naoshite moraemasu ka.|Can you fix it?|क्या आप इसे ठीक कर सकते हैं?
🔁|へやをかえてもいいですか。|heya wo kaete mo ii desu ka.|Can I change rooms?|क्या मैं कमरा बदल सकता/सकती हूँ?
🌴|ビーチまでとおいですか。|biichi made tooi desu ka.|Is it far to the beach?|समुद्र तट कितनी दूर है?
📸|しゃしんをとってもいいですか。|shashin wo totte mo ii desu ka.|May I take a photo?|क्या मैं फोटो ले सकता/सकती हूँ?
🏖️|あしたビーチにいきます。|ashita biichi ni ikimasu.|I'm going to the beach tomorrow.|कल मैं समुद्र तट जा रहा/रही हूँ।
🗾|にほんのりょこうはたのしいです。|nihon no ryokou wa tanoshii desu.|Traveling in Japan is fun.|जापान की यात्रा मज़ेदार है।
"""), "ja"),
        SentenceCategory("sj-home", "🏠 Daily Life & Home", "🏠", "Daily routine and home life", sc("""
🛏️|あさのしちじにおきます。|asa no shichiji ni okimasu.|I wake up at 7 in the morning.|मैं सुबह सात बजे उठता/उठती हूँ।
🚿|シャワーをあびます。|shawaa wo abimasu.|I take a shower.|मैं नहाता/नहाती हूँ।
🥪|パンをたべて、コーヒーをのみます。|pan wo tabete, koohii wo nomimasu.|I eat bread and drink coffee.|मैं ब्रेड खाता/खाती हूँ और कॉफ़ी पीता/पीती हूँ।
🚪|はちじにいえをでます。|hachiji ni ie wo demasu.|I leave home at 8.|मैं आठ बजे घर से निकलता/निकलती हूँ।
🏢|ろくじにかえります。|rokuji ni kaerimasu.|I return at 6.|मैं छह बजे लौटता/लौटती हूँ।
🍳|ばんごはんをつくります。|bangohan wo tsukurimasu.|I cook dinner.|मैं रात का खाना बनाता/बनाती हूँ।
📺|テレビをみます。|terebi wo mimasu.|I watch TV.|मैं टीवी देखता/देखती हूँ।
📖|ほんをよみます。|hon wo yomimasu.|I read a book.|मैं किताब पढ़ता/पढ़ती हूँ।
🧹|へやをそうじします。|heya wo souji shimasu.|I clean my room.|मैं कमरा साफ़ करता/करती हूँ।
👕|せんたくをします。|sentaku wo shimasu.|I do the laundry.|मैं कपड़े धोता/धोती हूँ।
🛋️|リビングでくつろぎます。|ribingu de kutsurogimasu.|I relax in the living room.|मैं लिविंग रूम में आराम करता/करती हूँ।
🐈|ねことあそびます。|neko to asobimasu.|I play with the cat.|मैं बिल्ली के साथ खेलता/खेलती हूँ।
🌙|じゅういちじごろねます。|juuichiji goro nemasu.|I go to sleep around 11.|मैं लगभग ग्यारह बजे सोता/सोती हूँ।
🏡|いえのちかくにこうえんがあります。|ie no chikaku ni kouen ga arimasu.|There is a park near my house.|मेरे घर के पास एक पार्क है।
🛒|まいにちスーパーにいきます。|mainichi suupaa ni ikimasu.|I go to the supermarket every day.|मैं रोज़ सुपरमार्केट जाता/जाती हूँ।
☕|あさ、コーヒーをのみます。|asa, koohii wo nomimasu.|I drink coffee in the morning.|मैं सुबह कॉफ़ी पीता/पीती हूँ।
🧻|トイレットペーパーがありません。|toiretto peepaa ga arimasen.|There's no toilet paper.|टॉयलेट पेपर नहीं है।
🚮|ごみをだしてください。|gomi wo dashite kudasai.|Please take out the trash.|कृपया कचरा बाहर निकालिए।
🚪|ドアをしめてください。|doa wo shimete kudasai.|Please close the door.|कृपया दरवाज़ा बंद कीजिए।
🔊|おんりょうをあげてください。|onryou wo agete kudasai.|Please turn up the volume.|कृपया आवाज़ बढ़ाइए।
"""), "ja"),
        SentenceCategory("sj-work", "🏫 Work & Office", "💼", "Work-related conversations", sc("""
💼|なんじからなんじまでしごとですか。|nanji kara nanji made shigoto desu ka.|What are your working hours?|आपके काम के घंटे क्या हैं?
🕘|くじからごじまでです。|kuji kara goji made desu.|From 9 to 5.|सुबह नौ से शाम पाँच बजे तक।
📅|きょうはしごとがやすみです。|kyou wa shigoto ga yasumi desu.|I'm off work today.|आज मेरी छुट्टी है।
🚇|まいにちでんしゃでかよいます。|mainichi densha de kayoimasu.|I commute by train every day.|मैं रोज़ ट्रेन से आता-जाता/आती-जाती हूँ।
👔|スーツをきてしごとにいきます。|suutsu wo kite shigoto ni ikimasu.|I wear a suit to work.|मैं सूट पहनकर काम पर जाता/जाती हूँ।
🤝|しごとのともだちができました。|shigoto no tomodachi ga dekimashita.|I made a friend at work.|काम पर मेरी दोस्ती हो गई।
🍱|ひるごはんはいつもはやめです。|hirugohan wa itsumo hayame desu.|I usually have an early lunch.|मैं आमतौर पर जल्दी दोपहर का खाना खाता/खाती हूँ।
📝|レポートをかきました。|repooto wo kakimashita.|I wrote a report.|मैंने रिपोर्ट लिखी।
📧|メールをおくってください。|meeru wo okutte kudasai.|Please send an email.|कृपया ईमेल भेजिए।
📞|かいぎがあります。|kaigi ga arimasu.|I have a meeting.|मेरी मीटिंग है।
🕒|ざんぎょうします。|zangyou shimasu.|I'll work overtime.|मैं ओवरटाइम करूँगा/करूँगी।
😪|しごとがつらいです。|shigoto ga tsurai desu.|Work is tough.|काम कठिन है।
🎉|しごとがおわって、かえりました。|shigoto ga owatte, kaerimashita.|I finished work and went home.|काम खत्म करके मैं घर लौटा/लौटी।
💰|きゅうりょうはいくらですか。|kyuuryou wa ikura desu ka.|How much is the salary?|वेतन कितना है?
👨‍💼|しゃちょうにあいました。|shachou ni aimashita.|I met the boss.|मैं बॉस से मिला/मिली।
🗣️|プレゼンをしました。|purezen wo shimashita.|I gave a presentation.|मैंने प्रेज़ेंटेशन दिया।
📱|かいぎはらいしゅうです。|kaigi wa raishuu desu.|The meeting is next week.|मीटिंग अगले हफ्ते है।
☕|やすみじかんにコーヒーをのみます。|yasumijikan ni koohii wo nomimasu.|I drink coffee during break.|ब्रेक में मैं कॉफ़ी पीता/पीती हूँ।
🏢|かいしゃはとうきょうにあります。|kaisha wa toukyou ni arimasu.|My company is in Tokyo.|मेरी कंपनी टोक्यो में है।
👋|しごとをやめました。|shigoto wo yamemashita.|I quit my job.|मैंने नौकरी छोड़ दी।
"""), "ja"),
        SentenceCategory("sj-school", "🎓 School & Study", "🎓", "School, tests, studying", sc("""
🏫|がっこうはなんじからですか。|gakkou wa nanji kara desu ka.|What time does school start?|स्कूल कितने बजे शुरू होता है?
🕘|くじからです。|kuji kara desu.|From 9 o'clock.|नौ बजे से।
📚|にほんごをべんきょうしています。|nihongo wo benkyou shite imasu.|I'm studying Japanese.|मैं जापानी पढ़ रहा/रही हूँ।
✏️|しゅくだいがたくさんあります。|shukudai ga takusan arimasu.|I have a lot of homework.|मेरे पास बहुत सारा होमवर्क है।
📖|テストがあしたです。|tesuto ga ashita desu.|The test is tomorrow.|कल परीक्षा है।
🎓|だいがくせいです。|daigakusei desu.|I'm a university student.|मैं विश्वविद्यालय का विद्यार्थी हूँ।
👩‍🏫|せんせいはやさしいです。|sensei wa yasashii desu.|The teacher is kind.|शिक्षक बहुत दयालु हैं।
🗣️|にほんごのじゅぎょうはたのしいです。|nihongo no jugyou wa tanoshii desu.|Japanese class is fun.|जापानी कक्षा मज़ेदार है।
📝|ノートをとります。|nooto wo torimasu.|I take notes.|मैं नोट्स लेता/लेती हूँ।
❓|しつもんがあります。|shitsumon ga arimasu.|I have a question.|मेरा एक प्रश्न है।
🙋|こたえがわかります。|kotae ga wakarimasu.|I know the answer.|मुझे उत्तर पता है।
🤔|よくわかりません。|yoku wakarimasen.|I don't understand well.|मुझे अच्छी तरह समझ नहीं आया।
🔁|もういちどいってください。|mou ichido itte kudasai.|Please say it again.|कृपया फिर से बोलिए।
✍️|かんじをれんしゅうします。|kanji wo renshuu shimasu.|I practice kanji.|मैं कांजी का अभ्यास करता/करती हूँ।
🎧|にほんごのCDをききます。|nihongo no shiidii wo kikimasu.|I listen to Japanese CDs.|मैं जापानी सीडी सुनता/सुनती हूँ।
📚|としょかんでべんきょうします。|toshokan de benkyou shimasu.|I study at the library.|मैं पुस्तकालय में पढ़ता/पढ़ती हूँ।
🏆|せいせきがよくなりました。|seiseki ga yoku narimashita.|My grades improved.|मेरे अंक बेहतर हो गए।
🎒|かばんにほんをいれました。|kaban ni hon wo iremashita.|I put the book in my bag.|मैंने किताब बैग में रखी।
🕛|ひるやすみにともだちとあそびます。|hiruyasumi ni tomodachi to asobimasu.|I play with friends during lunch break.|दोपहर के अवकाश में मैं दोस्तों के साथ खेलता/खेलती हूँ।
🎓|そつぎょうしました。|sotsugyou shimashita.|I graduated.|मैं स्नातक हुआ/हुई।
"""), "ja"),
        SentenceCategory("sj-health", "🏥 Health & Doctor", "🏥", "Illness, doctors, medicine", sc("""
🤒|かぜをひきました。|kaze wo hikimashita.|I caught a cold.|मुझे सर्दी लग गई।
🤕|あたまがいたいです。|atama ga itai desu.|I have a headache.|मेरे सिर में दर्द है।
😷|のどがいたいです。|nodo ga itai desu.|My throat hurts.|मेरे गले में दर्द है।
🤢|おなかがいたいです。|onaka ga itai desu.|My stomach hurts.|मेरे पेट में दर्द है।
🌡️|ねつがあります。|netsu ga arimasu.|I have a fever.|मुझे बुखार है।
🦷|はがいたいです。|ha ga itai desu.|I have a toothache.|मेरे दाँत में दर्द है।
🏥|びょういんにいきます。|byouin ni ikimasu.|I'm going to the hospital.|मैं अस्पताल जा रहा/रही हूँ।
👨‍⚕️|いしゃにみてもらいます。|isha ni mite moraimasu.|I'll see a doctor.|मैं डॉक्टर से मिलूँगा/मिलूँगी।
💊|くすりをのんでください。|kusuri wo nonde kudasai.|Please take this medicine.|कृपया यह दवा लीजिए।
🛌|きょうはやすんでください。|kyou wa yasunde kudasai.|Please rest today.|आज आराम कीजिए।
🚑|たすけてください！|tasukete kudasai!|Please help me!|कृपया मेरी मदद कीजिए!
🩹|けがをしました。|kega wo shimashita.|I got injured.|मुझे चोट लगी।
😴|あまりねられませんでした。|amari neraremasen deshita.|I couldn't sleep much.|मुझे नींद नहीं आई।
🥗|けんこうにいいです。|kenkou ni ii desu.|It's good for health.|यह सेहत के लिए अच्छा है।
🏃|まいにちさんぽします。|mainichi sanpo shimasu.|I walk every day.|मैं रोज़ टहलता/टहलती हूँ।
😌|からだのちょうしがいいです。|karada no choushi ga ii desu.|I feel good.|मैं अच्छा महसूस कर रहा/रही हूँ।
🥛|みずをたくさんのんでください。|mizu wo takusan nonde kudasai.|Please drink lots of water.|कृपया खूब पानी पीजिए।
🩺|けんさをします。|kensa wo shimasu.|I'll do a check-up.|मैं जाँच करूँगा/करूँगी।
"""), "ja"),
        SentenceCategory("sj-time", "⏰ Time & Schedules", "⏰", "Time, schedules, daily timing", sc("""
⏰|いまなんじですか。|ima nanji desu ka.|What time is it now?|अभी कितने बजे हैं?
🕒|いまごじです。|ima goji desu.|It's 5 o'clock now.|अभी पाँच बजे हैं।
⏳|じゅうごふんまえです。|juugofun mae desu.|It's 15 minutes before.|पंद्रह मिनट पहले।
⏭️|はんじかんあとです。|hanjikan ato desu.|It's half an hour later.|आधे घंटे बाद।
🌅|あさのろくじにおきます。|asa no rokuji ni okimasu.|I get up at 6 in the morning.|मैं सुबह छह बजे उठता/उठती हूँ।
🛌|まいにちなんじにねますか。|mainichi nanji ni nemasu ka.|What time do you sleep every day?|आप रोज़ कितने बजे सोते हैं?
🕚|じゅういちじにねます。|juuichiji ni nemasu.|I sleep at 11.|मैं ग्यारह बजे सोता/सोती हूँ।
📅|きょうはなんようびですか。|kyou wa nan youbi desu ka.|What day is it today?|आज कौन सा दिन है?
📅|あしたはすいようびです。|ashita wa suiyoubi desu.|Tomorrow is Wednesday.|कल बुधवार है।
⏱️|あとごふんで出ます。|ato gofun de demasu.|I'm leaving in 5 minutes.|मैं पाँच मिनट में निकलता/निकलती हूँ।
🚪|かいしゃにちこくしました。|kaisha ni chikoku shimashita.|I was late for work.|मुझे काम पर देर हो गई।
🕰️|じかんがありますか。|jikan ga arimasu ka.|Do you have time?|क्या आपके पास समय है?
😅|じかんがありません。|jikan ga arimasen.|I don't have time.|मेरे पास समय नहीं है।
⏰|めざましをかけました。|mezamashi wo kakemashita.|I set the alarm.|मैंने अलार्म लगाया।
📆|らいげつのよていは？|raigetsu no yotei wa?|Any plans next month?|अगले महीने कोई योजना?
🌙|きのうはおそくまでおきました。|kinou wa osoku made okimashita.|Yesterday I stayed up late.|कल मैं देर तक जागा/जागी।
🕓|よじにともだちに会います。|yoji ni tomodachi ni aimasu.|I'm meeting a friend at 4.|मैं चार बजे दोस्त से मिलूँगा/मिलूँगी।
⏳|ちょっとまってください。|chotto matte kudasai.|Wait a moment, please.|थोड़ा रुकिए।
"""), "ja"),
        SentenceCategory("sj-plan", "📅 Dates & Plans", "📅", "Making plans, dates, invitations", sc("""
📅|きょうはなんがつですか。|kyou wa nangatsu desu ka.|What month is it now?|यह कौन सा महीना है?
🎂|たんじょうびはいつですか。|tanjoubi wa itsu desu ka.|When is your birthday?|आपका जन्मदिन कब है?
🎂|くがつじゅうごにちです。|kugatsu juugonichi desu.|It's September 15th.|पंद्रह सितंबर को।
📆|らいしゅう、きょうとへいきます。|raishuu, kyouto e ikimasu.|I'm going to Kyoto next week.|अगले हफ्ते मैं क्योटो जा रहा/रही हूँ।
🗓️|しごとはなんにちまでですか。|shigoto wa nannichi made desu ka.|Until what date is your work?|आपका काम किस तारीख तक है?
✈️|ロンドンへのこうくうけんをかいました。|rondon e no koukuuken wo kaimashita.|I bought a flight ticket to London.|मैंने लंदन की हवाई टिकट खरीदी।
🎉|こんしゅうまつ、パーティーがあります。|konshuumatsu, paatii ga arimasu.|There's a party this weekend.|इस सप्ताहांत एक पार्टी है।
🤔|なにをしましょうか。|nani wo shimashou ka.|What shall we do?|हम क्या करें?
🎬|えいがをみにいきませんか。|eiga wo mi ni ikimasen ka.|Shall we go watch a movie?|चलो फिल्म देखने चलते हैं?
😊|いいですね。|ii desu ne.|That sounds good.|बहुत अच्छा लगा।
❌|すみません、いそがしいです。|sumimasen, isogashii desu.|Sorry, I'm busy.|माफ़ कीजिए, मैं व्यस्त हूँ।
🔄|じゃ、べつのひにしましょう。|ja, betsu no hi ni shimashou.|Let's do it another day.|चलो किसी और दिन करते हैं।
⏰|なんじにあいましょうか。|nanji ni aimashou ka.|What time shall we meet?|हम कितने बजे मिलें?
📍|えきのまえであいましょう。|eki no mae de aimashou.|Let's meet in front of the station.|स्टेशन के सामने मिलते हैं।
🎊|あたらしいとしをむかえます。|atarashii toshi wo mukaemasu.|We'll welcome the new year.|हम नया साल मनाएँगे।
🎁|プレゼントをあげます。|purezento wo agemasu.|I'll give a present.|मैं उपहार दूँगा/दूँगी।
📅|いつひまですか。|itsu hima desu ka.|When are you free?|आप कब खाली होते हैं?
☀️|てんきのいいひにいきましょう。|tenki no ii hi ni ikimashou.|Let's go on a nice day.|अच्छे दिन चलेंगे।
"""), "ja"),
        SentenceCategory("sj-family", "👨‍👩‍👧 Family & Friends", "👨‍👩‍👧", "Family and friends", sc("""
👨‍👩‍👧|かぞくはなんにんですか。|kazoku wa nannin desu ka.|How many people are in your family?|आपके परिवार में कितने लोग हैं?
👨‍👩‍👧|よにんです。|yonin desu.|There are four.|चार लोग हैं।
👨|ちちはしごとをしています。|chichi wa shigoto wo shite imasu.|My father works.|मेरे पिता काम करते हैं।
👩|はははやさしいです。|haha wa yasashii desu.|My mother is kind.|मेरी माँ दयालु हैं।
👦|あにがいます。|ani ga imasu.|I have an older brother.|मेरा बड़ा भाई है।
👧|いもうとがいます。|imouto ga imasu.|I have a younger sister.|मेरी छोटी बहन है।
👨‍👦|ちちはせがたかくないです。|chichi wa se ga takakunai desu.|My father is not tall.|मेरे पिता लंबे नहीं हैं।
👩‍👧|はははりょうりがじょうずです。|haha wa ryouri ga jouzu desu.|My mother is good at cooking.|मेरी माँ खाना बनाने में माहिर हैं।
🤝|ともだちがおおいです。|tomodachi ga ooi desu.|I have many friends.|मेरे कई दोस्त हैं।
📞|ともだちにでんわしました。|tomodachi ni denwa shimashita.|I called my friend.|मैंने दोस्त को फोन किया।
💌|メールがきました。|meeru ga kimashita.|I got an email.|मुझे ईमेल आया।
🎂|かぞくでパーティーをしました。|kazoku de paatii wo shimashita.|We had a party with family.|परिवार के साथ हमने पार्टी की।
🏠|しゅうまつはかぞくとすごします。|shuumatsu wa kazoku to sugoshimasu.|I spend weekends with family.|मैं सप्ताहांत परिवार के साथ बिताता/बिताती हूँ।
💞|かれしがいます。|kareshi ga imasu.|I have a boyfriend.|मेरा बॉयफ्रेंड है।
💖|かのじょがいます。|kanojo ga imasu.|I have a girlfriend.|मेरी गर्लफ्रेंड है।
🥰|いっしょにしゃしんをとりました。|issho ni shashin wo torimashita.|We took photos together.|हमने साथ में फोटो खींची।
🍜|ともだちとらーめんをたべました。|tomodachi to raamen wo tabemashita.|I ate ramen with a friend.|मैंने दोस्त के साथ रामेन खाई।
😢|ともだちにさようならをいいました。|tomodachi ni sayounara wo iimashita.|I said goodbye to my friend.|मैंने दोस्त को अलविदा कहा।
👵|そぼはかしこいです。|sobo wa kashikoi desu.|My grandmother is wise.|मेरी दादी बुद्धिमान हैं।
👴|そふははんごはんをつくります。|sofu wa hangohan wo tsukurimasu.|My grandfather cooks dinner.|मेरे दादा रात का खाना बनाते हैं।
"""), "ja"),
        SentenceCategory("sj-feel", "💗 Feelings & Opinions", "💗", "Expressing feelings and opinions", sc("""
😊|きょうはうれしいです。|kyou wa ureshii desu.|I'm happy today.|आज मैं खुश हूँ।
😢|かなしいです。|kanashii desu.|I'm sad.|मैं उदास हूँ।
😡|おこっています。|okotte imasu.|I'm angry.|मैं नाराज़ हूँ।
😨|こわいです。|kowai desu.|I'm scared.|मुझे डर लगता है।
😴|ねむいです。|nemui desu.|I'm sleepy.|मुझे नींद आ रही है।
😌|らくになりました。|raku ni narimashita.|I feel relieved.|मुझे राहत मिली।
🥰|だいすきです。|daisuki desu.|I love it.|मुझे बहुत पसंद है।
👍|いいとおもいます。|ii to omoimasu.|I think it's good.|मुझे लगता है यह अच्छा है।
👎|よくないとおもいます。|yokunai to omoimasu.|I don't think it's good.|मुझे नहीं लगता यह अच्छा है।
❓|どうおもいますか。|dou omoimasu ka.|What do you think?|आपको क्या लगता है?
😕|むずかしいとおもいます。|muzukashii to omoimasu.|I think it's difficult.|मुझे लगता है यह कठिन है।
🎉|たのしかったです！|tanoshikatta desu!|That was fun!|बहुत मज़ा आया!
😅|だいじょうぶですか。|daijoubu desu ka.|Are you okay?|क्या आप ठीक हैं?
🆗|だいじょうぶです。|daijoubu desu.|I'm fine.|मैं ठीक हूँ।
🤔|わかりません。|wakarimasen.|I don't know.|मुझे नहीं पता।
💭|かんがえます。|kangaemasu.|I'll think about it.|मैं सोचूँगा/सोचूँगी।
🥳|げんきいっぱいです。|genki ippai desu.|I'm full of energy.|मैं ऊर्जा से भरा/भरी हूँ।
😌|きもちがいいです。|kimochi ga ii desu.|It feels good.|अच्छा लग रहा है।
😰|しんぱいしています。|shinpai shite imasu.|I'm worried.|मुझे चिंता है।
🙏|がんばります。|ganbarimasu.|I'll do my best.|मैं कोशिश करूँगा/करूँगी।
"""), "ja"),
        SentenceCategory("sj-phone", "📱 Phone & Messages", "📱", "Phone calls and messages", sc("""
📱|でんわばんごうをきいてもいいですか。|denwabangou wo kiite mo ii desu ka.|May I ask your phone number?|क्या मैं आपका नंबर ले सकता/सकती हूँ?
📞|でんわをかけます。|denwa wo kakemasu.|I'll make a call.|मैं फोन करता/करती हूँ।
🤙|でんわしてください。|denwa shite kudasai.|Please call me.|कृपया मुझे फोन कीजिए।
💬|ラインでおくります。|rain de okurimasu.|I'll send it by LINE.|मैं लाइन पर भेजूँगा/भेजूँगी।
📷|しゃしんをおくってください。|shashin wo okutte kudasai.|Please send the photo.|कृपया फोटो भेजिए।
📴|でんわがきこえません。|denwa ga kikoemasen.|I can't hear you.|आपकी आवाज़ नहीं आ रही।
🔋|バッテリーがありません。|batterii ga arimasen.|My battery is low.|बैटरी कम है।
📶|しんごうがわるいです。|shingou ga warui desu.|The signal is bad.|नेटवर्क खराब है।
🔁|かけなおします。|kakenaoshimasu.|I'll call back.|मैं फिर से कॉल करूँगा/करूँगी।
📩|メッセージをのこしました。|messeiji wo nokoshimashita.|I left a message.|मैंने संदेश छोड़ा।
📞|またでんわします。|mata denwa shimasu.|I'll call again later.|मैं बाद में फिर कॉल करूँगा/करूँगी।
🔍|インターネットでしらべます。|intaanetto de shirabemasu.|I'll look it up online.|मैं इंटरनेट पर देखूँगा/देखूँगी।
📱|スマホがこわれました。|sumaho ga kowaremashita.|My phone broke.|मेरा फोन खराब हो गया।
💬|かくにんメールをおくります。|kakunin meeru wo okurimasu.|I'll send a confirmation email.|मैं पुष्टि ईमेल भेजूँगा/भेजूँगी।
📵|ここはでんわがつうじません。|koko wa denwa ga tsuujimasen.|There's no signal here.|यहाँ फोन नहीं चलता।
🕒|ゆうがたにでんわします。|yuugata ni denwa shimasu.|I'll call in the evening.|शाम को फोन करूँगा/करूँगी।
"""), "ja"),
        SentenceCategory("sj-weather", "🌦️ Weather", "🌦️", "Weather talk", sc("""
☀️|きょうははれです。|kyou wa hare desu.|It's sunny today.|आज धूप है।
🌧️|あめがふっています。|ame ga futte imasu.|It's raining.|बारिश हो रही है।
❄️|ゆきがふっています。|yuki ga futte imasu.|It's snowing.|बर्फ़ गिर रही है।
☁️|くもりです。|kumori desu.|It's cloudy.|बादल छाए हैं।
🌬️|かぜがつよいです。|kaze ga tsuyoi desu.|The wind is strong.|हवा तेज़ है।
🌈|にじがでています。|niji ga dete imasu.|There's a rainbow.|इंद्रधनुष दिख रहा है।
🔥|きょうはすごくあついですね。|kyou wa sugoku atsui desu ne.|It's really hot today.|आज बहुत गर्मी है।
🥶|さむいですね。|samui desu ne.|It's cold, isn't it.|ठंड है ना।
⛈️|あらしがきます。|arashi ga kimasu.|A storm is coming.|तूफ़ान आ रहा है।
☔|かさをもってきてください。|kasa wo motte kite kudasai.|Please bring an umbrella.|कृपया छाता लाइए।
🧥|うわぎをきてください。|uwagi wo kite kudasai.|Please wear a jacket.|कृपया जैकेट पहनिए।
🌡️|きょうのきおんはなんどですか。|kyou no kion wa nando desu ka.|What's today's temperature?|आज का तापमान कितना है?
🌡️|にじゅうろくどです。|nijuurokudo desu.|It's 26 degrees.|छब्बीस डिग्री है।
🌤️|あしたもはれでしょう。|ashita mo hare deshou.|It will probably be sunny tomorrow too.|कल भी धूप रहेगी।
🌙|こんやはつめたいです。|konya wa tsumetai desu.|Tonight is cold.|आज रात ठंड है।
🌱|はるになるとあたたかくなります。|haru ni naru to atatakaku narimasu.|When spring comes, it gets warm.|वसंत आते ही गर्मी बढ़ती है।
🍂|あきはすずしいです。|aki wa suzushii desu.|Autumn is cool.|पतझड़ में ठंडक होती है।
🌳|このへんはうつくしいです。|kono hen wa utsukushii desu.|This area is beautiful.|यह इलाक़ा सुंदर है।
"""), "ja"),
        SentenceCategory("sj-help", "🗺️ Asking for Help", "🗺️", "Asking for help and directions", sc("""
🆘|すみません、てつだってください。|sumimasen, tetsudatte kudasai.|Excuse me, please help me.|माफ़ कीजिए, कृपया मेरी मदद कीजिए।
🗺️|ちずをみせてもらえますか。|chizu wo misete moraemasu ka.|Can you show me on the map?|क्या आप नक्शे पर दिखा सकते हैं?
📖|これのいみがわかりません。|kore no imi ga wakarimasen.|I don't understand the meaning of this.|मुझे इसका अर्थ समझ नहीं आया।
🗣️|ゆっくりはなしてください。|yukkuri hanashite kudasai.|Please speak slowly.|कृपया धीरे बोलिए।
✍️|かいてください。|kaite kudasai.|Please write it down.|कृपया लिखिए।
🔁|もういちどおねがいします。|mou ichido onegaishimasu.|One more time, please.|एक बार फिर, कृपया।
❓|これはなんですか。|kore wa nan desu ka.|What is this?|यह क्या है?
🇯🇵|えいごがわかりますか。|eigo ga wakarimasu ka.|Do you understand English?|क्या आपको अंग्रेज़ी आती है?
🆚|にほんごでなんといいますか。|nihongo de nan to iimasu ka.|How do you say it in Japanese?|इसे जापानी में क्या कहते हैं?
🤷|どこですか。|doko desu ka.|Where is it?|वह कहाँ है?
🚻|トイレはどこですか。|toire wa doko desu ka.|Where is the restroom?|शौचालय कहाँ है?
🏧|ATMはどこですか。|eieitiiemu wa doko desu ka.|Where is the ATM?|एटीएम कहाँ है?
🏦|ぎんこうはどこですか。|ginkou wa doko desu ka.|Where is the bank?|बैंक कहाँ है?
💊|くすりやはどこですか。|kusuriya wa doko desu ka.|Where is the pharmacy?|दवा की दुकान कहाँ है?
🆘|どうすればいいですか。|dou sureba ii desu ka.|What should I do?|मुझे क्या करना चाहिए?
🤝|おねがいできますか。|onegai dekimasu ka.|Can I ask a favor?|क्या मैं एक एहसान माँग सकता/सकती हूँ?
👍|もちろんです。|mochiron desu.|Of course.|बिल्कुल।
😊|たすかりました。|tasukarimashita.|That helped a lot.|बहुत मदद मिली।
"""), "ja"),
        SentenceCategory("sj-party", "🎉 Celebrations & Parties", "🎉", "Celebrations and parties", sc("""
🎉|おめでとうございます！|omedetou gozaimasu!|Congratulations!|बधाई हो!
🎂|たんじょうびおめでとう！|tanjoubi omedetou!|Happy birthday!|जन्मदिन मुबारक!
🎆|あけましておめでとうございます。|akemashite omedetou gozaimasu.|Happy New Year.|नया साल मुबारक।
🎄|クリスマスはどうでしたか。|kurisumasu wa dou deshita ka.|How was Christmas?|क्रिसमस कैसा रहा?
🍻|かんぱい！|kanpai!|Cheers!|चियर्स!
🎁|プレゼントをひらきます。|purezento wo hirakimasu.|I'll open the present.|मैं उपहार खोलूँगा/खोलूँगी।
🥳|パーティーはたのしかったです。|paatii wa tanoshikatta desu.|The party was fun.|पार्टी बहुत मज़ेदार थी।
🍰|ケーキをたべます。|keeki wo tabemasu.|I'll eat cake.|मैं केक खाऊँगा/खाऊँगी।
🎵|ダンスをおどりましょう。|dansu wo odorimashou.|Let's dance!|चलो नाचते हैं!
🎈|かざりがきれいです。|kazari ga kirei desu.|The decorations are pretty.|सजावट सुंदर है।
🍱|たべものがたくさんあります。|tabemono ga takusan arimasu.|There's lots of food.|खाने की बहुत सारी चीज़ें हैं।
🎶|うたをうたってください。|uta wo utatte kudasai.|Please sing a song.|कृपया एक गाना गाइए।
🥂|みんなでかんぱいしましょう！|minna de kanpai shimashou!|Let's all toast!|चलो सब मिलकर टोस्ट करें!
🎊|しんねんのいわいをします。|shinnen no iwai wo shimasu.|We celebrate the new year.|हम नया साल मनाते हैं।
📸|しゃしんをたくさんとりました。|shashin wo takusan torimashita.|We took lots of photos.|हमने बहुत सारी तस्वीरें लीं।
🍻|おさけをのみすぎました。|osake wo nomisugimashita.|I drank too much.|मैंने बहुत ज़्यादा पी लिया।
"""), "ja"),
        SentenceCategory("sj-money", "💰 Money & Numbers", "💰", "Money and counting", sc("""
💰|これでいくらですか。|kore de ikura desu ka.|How much does this come to?|कुल कितने हुए?
🧾|ごせんえんです。|gosen en desu.|It's 5,000 yen.|पाँच हज़ार येन।
💸|やすいですね。|yasui desu ne.|That's cheap.|सस्ता है ना।
💎|たかいですが、きれいです。|takai desu ga, kirei desu.|It's expensive but beautiful.|महँगा है पर सुंदर है।
💵|げんきんではらいます。|genkin de haraimasu.|I'll pay in cash.|मैं नकद भुगतान करूँगा/करूँगी।
🏦|ぎんこうにいきます。|ginkou ni ikimasu.|I'm going to the bank.|मैं बैंक जा रहा/रही हूँ।
💳|クレジットカードはつかえますか。|kurejitto kaado wa tsukaemasu ka.|Can I use a credit card?|क्या क्रेडिट कार्ड चलेगा?
🤲|こまかいおかねがありますか。|komakai okane ga arimasu ka.|Do you have change?|क्या आपके पास छुट्टे पैसे हैं?
🧮|さんびゃくえんです。|sanbyaku en desu.|It's 300 yen.|तीन सौ येन।
🔢|いち、に、さん…|ichi, ni, san…|One, two, three…|एक, दो, तीन…
🧾|だいたいせんえんです。|daitai sen en desu.|It's about 1,000 yen.|लगभग हज़ार येन।
💼|まいつきいくらつかいますか。|maitsuki ikura tsukaimasu ka.|How much do you spend a month?|आप हर महीने कितना खर्च करते हैं?
🏠|やちんはたかいです。|yachin wa takai desu.|The rent is high.|किराया महँगा है।
💲|かいもののうけつけはどこですか。|kaimono no uketsuke wa doko desu ka.|Where is the cashier?|बिल काउंटर कहाँ है?
🎟️|ぎんこうはなんじにあきますか。|ginkou wa nanji ni akimasu ka.|What time does the bank open?|बैंक कितने बजे खुलता है?
🔒|ぎんこうはごじにしまります。|ginkou wa goji ni shimarimasu.|The bank closes at 5.|बैंक पाँच बजे बंद होता है।
💰|おこづかいをためています。|okodukai wo tamete imasu.|I'm saving up my allowance.|मैं पैसे बचा रहा/रही हूँ।
🏧|ぎんこうでおろします。|ginkou de oroshimasu.|I'll withdraw money at the bank.|मैं बैंक से पैसे निकालूँगा/निकालूँगी।
"""), "ja"),
        SentenceCategory("sj-emerg", "❓ Emergency", "❓", "Emergencies", sc("""
🚨|たすけて！|tasukete!|Help!|बचाओ!
📞|けいさつをよんでください。|keisatsu wo yonde kudasai.|Please call the police.|कृपया पुलिस बुलाइए।
🚑|きゅうきゅうしゃをよんでください。|kyuukyuusha wo yonde kudasai.|Please call an ambulance.|कृपया एम्बुलेंस बुलाइए।
🔥|かじです！|kaji desu!|Fire!|आग लगी है!
🚒|しょうぼうしょはどこですか。|shoubousho wa doko desu ka.|Where is the fire station?|फायर स्टेशन कहाँ है?
😰|さいふをうしないました。|saifu wo ushinaimashita.|I lost my wallet.|मेरा पर्स खो गया।
🛂|パスポートをなくしました。|pasupooto wo nakushimashita.|I lost my passport.|मेरा पासपोर्ट खो गया।
🤕|ここがいたいです。|koko ga itai desu.|It hurts here.|यहाँ दर्द हो रहा है।
🆘|こどもとはぐれました。|kodomo to haguremashita.|I got separated from my child.|मेरा बच्चा बिछड़ गया।
🏥|びょういんにつれていってください。|byouin ni tsurete itte kudasai.|Please take me to the hospital.|कृपया मुझे अस्पताल ले चलिए।
💊|くすりがききません。|kusuri ga kikimasen.|The medicine isn't working.|दवा असर नहीं कर रही।
😵|きぶんがわるいです。|kibun ga warui desu.|I feel sick.|मैं अस्वस्थ महसूस कर रहा/रही हूँ।
📞|だれかにでんわしてください。|dareka ni denwa shite kudasai.|Please call someone.|कृपया किसी को फोन कीजिए।
🚨|あんぜんなばしょはどこですか。|anzen na basho wa doko desu ka.|Where is a safe place?|सुरक्षित जगह कहाँ है?
🤝|あんしんしました。|anshin shimashita.|I feel relieved now.|अब मुझे चैन मिला।
🧯|ここにいます。|koko ni imasu.|I'm here.|मैं यहाँ हूँ।
"""), "ja"),
        SentenceCategory("se-greet", "👋 Greetings & Introductions", "👋", "Beginner conversations for meeting people", sec("""
👋|Hello!|नमस्ते!
👋|Hi there!|हाय!
🌅|Good morning!|सुप्रभात!
🌇|Good evening!|शुभ संध्या!
🌙|Good night!|शुभ रात्रि!
🙏|Nice to meet you.|आपसे मिलकर खुशी हुई।
🙏|Nice to meet you too.|मुझे भी आपसे मिलकर खुशी हुई।
😊|How are you?|आप कैसे हैं?
😊|I'm fine, thanks. And you?|मैं ठीक हूँ, धन्यवाद। और आप?
😴|I'm a little tired today.|आज मैं थोड़ा थका हुआ हूँ।
📛|What's your name?|आपका नाम क्या है?
👤|My name is Alex.|मेरा नाम एलेक्स है।
👤|I am a student.|मैं एक विद्यार्थी हूँ।
💼|I work as an engineer.|मैं इंजीनियर के रूप में काम करता हूँ।
🌏|Where are you from?|आप कहाँ से हैं?
🇮🇳|I'm from India.|मैं भारत से हूँ।
🏠|I live in Mumbai.|मैं मुंबई में रहता हूँ।
🗣️|I'm learning English.|मैं अंग्रेज़ी सीख रहा हूँ।
🗣️|Do you speak English?|क्या आप अंग्रेज़ी बोलते हैं?
😌|Just a little.|बस थोड़ी सी।
👋|See you later!|बाद में मिलते हैं!
👋|See you tomorrow!|कल मिलते हैं!
📅|See you next week!|अगले हफ्ते मिलते हैं!
👍|Have a nice day!|आपका दिन शुभ हो!
🙏|Thank you very much.|बहुत बहुत धन्यवाद।
😊|You're welcome.|आपका स्वागत है।
❓|Excuse me?|माफ़ कीजिए?
😅|Sorry, I didn't catch that.|माफ़ कीजिए, वह समझ नहीं आया।
🔁|Could you say that again?|क्या आप इसे फिर से कहेंगे?
👋|Take care!|अपना ख्याल रखना!
"""), "en"),
        SentenceCategory("se-talk", "☕ Small Talk", "☕", "Casual everyday conversations", sec("""
☕|The weather is nice today.|आज मौसम अच्छा है।
🌧️|It looks like rain.|बारिश जैसा लग रहा है।
🍵|Would you like some tea?|क्या आप चाय लेंगे?
🎬|Did you see that movie?|क्या आपने वह फिल्म देखी?
🍜|I love this restaurant.|मुझे यह रेस्तराँ बहुत पसंद है।
🎵|What kind of music do you like?|आपको कैसा संगीत पसंद है?
🐈|Do you have any pets?|क्या आपके पास पालतू जानवर है?
🐕|I have a dog named Max.|मेरे पास मैक्स नाम का कुत्ता है।
🏞️|Did you have a good weekend?|क्या आपका सप्ताहांत अच्छा रहा?
😴|I was so busy this week.|इस हफ्ते मैं बहुत व्यस्त था।
🍽️|Have you eaten yet?|क्या आपने खाना खाया?
⏰|What time do you usually wake up?|आप आमतौर पर कितने बजे उठते हैं?
🚇|How do you get to work?|आप काम पर कैसे जाते हैं?
🏠|Where do you live?|आप कहाँ रहते हैं?
🌆|I live near the city center.|मैं शहर के केंद्र के पास रहता हूँ।
🎂|How old are you?|आपकी उम्र क्या है?
🎂|I'm twenty-five years old.|मैं पच्चीस साल का हूँ।
☕|Let's grab coffee sometime.|कभी चलकर कॉफ़ी पीते हैं।
🎮|Do you like playing games?|क्या आपको गेम खेलना पसंद है?
📚|I'm reading an interesting book.|मैं एक दिलचस्प किताब पढ़ रहा हूँ।
🏋️|I go to the gym three times a week.|मैं हफ्ते में तीन बार जिम जाता हूँ।
🍿|That sounds fun!|वह मज़ेदार लगता है!
😂|That's really funny!|वह बहुत मज़ेदार है!
🤔|I don't know yet.|मुझे अभी नहीं पता।
💭|Let me think about it.|मुझे इसके बारे में सोचने दीजिए।
👍|I completely agree.|मैं पूरी तरह सहमत हूँ।
👎|I'm not sure about that.|मुझे इस बारे में यकीन नहीं है।
🙌|That's great news!|वह बहुत अच्छी खबर है!
😊|It's been a long day.|आज का दिन लंबा रहा।
🌙|Let's talk tomorrow.|चलो कल बात करते हैं।
"""), "en"),
        SentenceCategory("se-food", "🍳 Food & Restaurants", "🍳", "Ordering food and talking about meals", sec("""
🍽️|I'm hungry.|मुझे भूख लगी है।
🥤|I'm thirsty.|मुझे प्यास लगी है।
🍳|What do you want for breakfast?|नाश्ते में क्या चाहिए?
🥞|I'll have eggs and toast.|मैं अंडे और टोस्ट लूँगा।
☕|Could I get a coffee, please?|क्या मुझे एक कॉफ़ी मिल सकती है?
📖|Can we see the menu?|क्या हम मेनू देख सकते हैं?
🍝|I'd like the pasta, please.|मुझे पास्ता चाहिए, कृपया।
🥗|Is this dish vegetarian?|क्या यह व्यंजन शाकाहारी है?
🌶️|I can't eat very spicy food.|मैं बहुत तीखा नहीं खा सकता।
🍚|One more bowl of rice, please.|एक और कटोरी चावल, कृपया।
💧|Some water, please.|थोड़ा पानी, कृपया।
🍰|What do you recommend for dessert?|मिठाई के लिए क्या सुझाएँगे?
😋|This is delicious!|यह स्वादिष्ट है!
🧂|Could you pass the salt?|क्या आप नमक दे देंगे?
🧾|The bill, please.|बिल, कृपया।
💳|Can I pay by card?|क्या मैं कार्ड से भुगतान कर सकता हूँ?
🥡|Can I get this to go?|क्या मैं इसे पैक करा सकता हूँ?
🍕|Let's order a pizza.|चलो पिज़्ज़ा ऑर्डर करते हैं।
🥘|The soup is too hot.|सूप बहुत गरम है।
🍦|I love ice cream.|मुझे आइसक्रीम बहुत पसंद है।
🍎|An apple a day keeps the doctor away.|एक सेब रोज़ बीमारी दूर भगाता है।
🍽️|We're ready to order.|हम ऑर्डर करने के लिए तैयार हैं।
🥣|I don't want any soup.|मुझे सूप नहीं चाहिए।
🍤|Is the shrimp fresh?|क्या झींगा ताज़ा है?
🥤|I'll have lemonade.|मैं नींबू पानी लूँगा।
🧊|No ice, please.|बिना बर्फ़, कृपया।
🍱|The portions are huge.|मात्रा बहुत बड़ी है।
💰|It's on me today.|आज मेरी तरफ़ से।
🙏|Thank you for the meal.|खाने के लिए धन्यवाद।
😊|We really enjoyed it.|हमें बहुत अच्छा लगा।
"""), "en"),
        SentenceCategory("se-shop", "🛒 Shopping & Money", "🛒", "Buying things, asking prices", sec("""
🛍️|I'm going shopping today.|आज मैं खरीदारी करने जा रहा हूँ।
🏬|Where is the nearest mall?|सबसे नज़दीकी मॉल कहाँ है?
💰|How much is this?|यह कितने का है?
🧾|That's too expensive.|वह बहुत महँगा है।
😊|Is there a discount?|क्या कोई छूट है?
🛒|I'll take this one.|मैं यह लेता हूँ।
📏|Do you have a bigger size?|क्या आपके पास बड़ा साइज़ है?
👕|Can I try this on?|क्या मैं इसे पहनकर देख सकता हूँ?
🚪|Where are the fitting rooms?|फिटिंग रूम कहाँ हैं?
🔁|Can I return this?|क्या मैं इसे वापस कर सकता हूँ?
🎁|It's a gift for my friend.|यह मेरे दोस्त के लिए उपहार है।
🧾|Could I have a receipt?|क्या मुझे रसीद मिल सकती है?
💵|I'll pay in cash.|मैं नकद भुगतान करूँगा।
💳|Do you take credit cards?|क्या आप क्रेडिट कार्ड लेते हैं?
🆓|Is this on sale?|क्या यह बिक्री पर है?
💎|It's a bit over my budget.|यह मेरे बजट से थोड़ा ऊपर है।
🛍️|I'm just looking, thanks.|मैं बस देख रहा हूँ, धन्यवाद।
👗|This color suits you.|यह रंग आप पर जंचता है।
🧦|I need a pair of socks.|मुझे एक जोड़ी मोज़े चाहिए।
🏷️|The price tag is missing.|कीमत का टैग गायब है।
🛒|The total is fifty dollars.|कुल पचास डॉलर हुए।
🧾|Here's your change.|आपके छुट्टे यहाँ हैं।
📦|Could you wrap it, please?|क्या आप इसे लपेट देंगे?
🚚|Do you deliver?|क्या आप डिलीवरी करते हैं?
⏰|The store closes at 9.|दुकान नौ बजे बंद होती है।
🌅|The store opens at 10.|दुकान दस बजे खुलती है।
😞|It's out of stock.|यह स्टॉक में नहीं है।
🔄|Can I exchange it?|क्या मैं इसे बदल सकता हूँ?
👍|That's a good deal.|यह अच्छा सौदा है।
💸|I spent too much today.|आज मैंने बहुत खर्च कर दिया।
"""), "en"),
        SentenceCategory("se-train", "🚌 Getting Around", "🚌", "Buses, trains, directions", sec("""
🚉|Where's the nearest station?|सबसे नज़दीकी स्टेशन कहाँ है?
🚃|When is the next train?|अगली ट्रेन कब है?
🎟️|One ticket to the airport, please.|हवाई अड्डे के लिए एक टिकट, कृपया।
🚌|Does this bus go to downtown?|क्या यह बस शहर के केंद्र जाती है?
🚶|How far is it from here?|यहाँ से कितनी दूर है?
⏱️|It's a ten-minute walk.|यह दस मिनट की पैदल दूरी है।
🗺️|Can you show me on the map?|क्या आप मुझे नक्शे पर दिखा सकते हैं?
🚕|Please take me to this address.|कृपया मुझे इस पते पर ले चलिए।
🔄|I got on the wrong bus.|मैं गलत बस में चढ़ गया।
🅿️|Where can I park?|मैं कहाँ गाड़ी खड़ी कर सकता हूँ?
⚠️|There's a traffic jam.|ट्रैफ़िक जाम है।
🚗|Please drive slowly.|कृपया धीरे चलाइए।
🚦|Turn right at the traffic light.|ट्रैफ़िक लाइट पर दाएँ मुड़िए।
⬅️|Turn left at the corner.|कोने पर बाएँ मुड़िए।
⬆️|Go straight ahead.|सीधे आगे चलिए।
🚇|The subway is faster.|मेट्रो ज़्यादा तेज़ है।
🚴|I usually ride a bike.|मैं आमतौर पर साइकिल चलाता हूँ।
👟|I prefer walking.|मुझे पैदल चलना पसंद है।
🕒|The bus is late again.|बस फिर लेट है।
🎫|I lost my ticket.|मेरा टिकट खो गया।
📍|This is the wrong stop.|यह गलत स्टॉप है।
🧭|I'm completely lost.|मैं पूरी तरह भटक गया हूँ।
🤝|Thank you for the ride.|सवारी के लिए धन्यवाद।
💳|Can I pay by card on the bus?|क्या मैं बस में कार्ड से भुगतान कर सकता हूँ?
🚧|The road is closed.|सड़क बंद है।
🚶|Follow me, it's this way.|मेरे साथ चलिए, यह इस ओर है।
🏁|We're almost there.|हम लगभग पहुँच गए हैं।
🚌|I'll get off at the next stop.|मैं अगले स्टॉप पर उतरूँगा।
🗺️|Is there a shortcut?|कोई छोटा रास्ता है?
🚕|How much is the fare?|किराया कितना है?
"""), "en"),
        SentenceCategory("se-travel", "🏨 Travel & Hotels", "🏨", "Hotels and trips", sec("""
🏨|I have a reservation.|मेरा आरक्षण है।
📋|I'd like to check in, please.|मैं चेक-इन करना चाहता हूँ।
🗝️|May I have a room key?|क्या मुझे कमरे की चाबी मिल सकती है?
🛏️|The room is very clean.|कमरा बहुत साफ़ है।
🌅|The view is amazing.|नज़ारा अद्भुत है।
📶|Is there free Wi-Fi?|क्या मुफ़्त वाई-फ़ाई है?
🕐|What time is check-out?|चेक-आउट कितने बजे है?
🧳|Can I leave my bags here?|क्या मैं अपना सामान यहाँ रख सकता हूँ?
🚕|Can you call a taxi?|क्या आप टैक्सी बुला सकते हैं?
🗺️|Do you have a city map?|क्या आपके पास शहर का नक्शा है?
🔌|I forgot my charger.|मैं चार्जर भूल गया।
💡|The light isn't working.|बत्ती काम नहीं कर रही।
🛠️|Can you fix it, please?|क्या आप इसे ठीक कर सकते हैं?
🔁|Could I change my room?|क्या मैं कमरा बदल सकता हूँ?
🏖️|Is the beach far from here?|क्या समुद्र तट यहाँ से दूर है?
📸|May I take photos here?|क्या मैं यहाँ फोटो ले सकता हूँ?
🧳|I need to check my luggage.|मुझे अपना सामान चेक करना है।
✈️|What time is boarding?|बोर्डिंग कितने बजे है?
🛃|Here is my passport.|मेरा पासपोर्ट यहाँ है।
🏛️|Let's visit the museum.|चलो संग्रहालय देखने चलते हैं।
🛍️|I want to buy souvenirs.|मुझे स्मृति चिन्ह खरीदने हैं।
😋|The local food is amazing.|स्थानीय खाना बहुत बढ़िया है।
🌍|Traveling opens your mind.|यात्रा दिमाग़ खोलती है।
🗓️|I'll stay for three days.|मैं तीन दिन रुकूँगा।
😊|This trip was wonderful.|यह यात्रा अद्भुत रही।
"""), "en"),
        SentenceCategory("se-home", "🏠 Home & Daily Routine", "🏠", "Daily routine and home life", sec("""
🛏️|I wake up at seven every day.|मैं हर दिन सात बजे उठता हूँ।
🚿|I take a shower in the morning.|मैं सुबह नहाता हूँ।
🥪|I have bread and coffee for breakfast.|मैं नाश्ते में ब्रेड और कॉफ़ी लेता हूँ।
🚪|I leave home at eight.|मैं आठ बजे घर से निकलता हूँ।
🏠|I come back home at six.|मैं छह बजे घर लौटता हूँ।
🍳|I cook dinner for my family.|मैं परिवार के लिए रात का खाना बनाता हूँ।
📺|We watch TV after dinner.|हम रात के खाने के बाद टीवी देखते हैं।
📖|I read before sleeping.|मैं सोने से पहले पढ़ता हूँ।
🧹|I clean the house on Sundays.|मैं रविवार को घर साफ़ करता हूँ।
👕|I do laundry twice a week.|मैं हफ्ते में दो बार कपड़े धोता हूँ।
🛋️|I relax on the sofa.|मैं सोफ़े पर आराम करता हूँ।
🐈|My cat sleeps all day.|मेरी बिल्ली पूरे दिन सोती है।
🌙|I go to bed around eleven.|मैं लगभग ग्यारह बजे सोता हूँ।
🏡|There's a park near my house.|मेरे घर के पास एक पार्क है।
🛒|I shop for groceries on Saturday.|मैं शनिवार को किराने का सामान खरीदता हूँ।
🚮|Please take out the trash.|कृपया कचरा बाहर निकालिए।
🚪|Don't forget to lock the door.|दरवाज़ा बंद करना मत भूलना।
🔊|Please turn down the music.|कृपया संगीत धीमा कीजिए।
🌅|I love mornings.|मुझे सुबह बहुत पसंद है।
🍵|Tea time is my favorite.|चाय का समय मेरा पसंदीदा है।
🏋️|I exercise at home.|मैं घर पर कसरत करता हूँ।
🪴|I water the plants every morning.|मैं हर सुबह पौधों को पानी देता हूँ।
📦|There's a package at the door.|दरवाज़े पर एक पार्सल है।
🔑|I can't find my keys.|मुझे मेरी चाबियाँ नहीं मिल रहीं।
🍳|Let's have breakfast together.|चलो साथ में नाश्ता करते हैं।
🧺|The laundry basket is full.|कपड़ों की टोकरी भरी है।
🛁|I take a hot bath at night.|मैं रात में गरम पानी से स्नान करता हूँ।
📅|My schedule is busy this week.|इस हफ्ते मेरा कार्यक्रम व्यस्त है।
😴|I slept well last night.|कल रात मुझे अच्छी नींद आई।
☕|The coffee machine is broken.|कॉफ़ी मशीन खराब है।
"""), "en"),
        SentenceCategory("se-work", "🏢 Work & Meetings", "🏢", "Work-related conversations", sec("""
💼|I have a meeting at ten.|मेरी दस बजे मीटिंग है।
📝|I need to finish this report.|मुझे यह रिपोर्ट पूरी करनी है।
📧|Please email me the file.|कृपया मुझे फ़ाइल ईमेल करें।
📞|I'll call you back.|मैं आपको वापस कॉल करूँगा।
🕒|I usually work from nine to six.|मैं आमतौर पर नौ से छह बजे तक काम करता हूँ।
🚇|My commute takes an hour.|मेरा सफ़र एक घंटे का है।
☕|Let's take a coffee break.|चलो कॉफ़ी का ब्रेक लेते हैं।
🤝|We have a new client today.|आज हमारे पास नया ग्राहक है।
📊|The sales went up this month.|इस महीने बिक्री बढ़ी है।
😪|I'm tired from work.|मैं काम से थक गया हूँ।
💰|I got a salary raise.|मुझे वेतन बढ़ोतरी मिली।
👔|I wear formal clothes at work.|मैं काम पर औपचारिक कपड़े पहनता हूँ।
📅|The deadline is Friday.|समय सीमा शुक्रवार है।
⏰|I was late this morning.|आज सुबह मुझे देर हो गई।
🗣️|I gave a presentation today.|आज मैंने प्रेज़ेंटेशन दिया।
🏢|Our office is in the city center.|हमारा कार्यालय शहर के केंद्र में है।
👥|I work with a great team.|मैं एक बेहतरीन टीम के साथ काम करता हूँ।
📱|We use online meetings.|हम ऑनलाइन मीटिंग करते हैं।
🍱|I have lunch at my desk.|मैं अपनी मेज़ पर दोपहर का खाना खाता हूँ।
🚪|The manager is out today.|मैनेजर आज बाहर हैं।
📋|Please fill out this form.|कृपया यह फ़ॉर्म भरें।
✍️|Sign here, please.|कृपया यहाँ हस्ताक्षर कीजिए।
🔄|I changed my job last year.|मैंने पिछले साल नौकरी बदली।
🎉|We celebrated the success.|हमने सफलता का जश्न मनाया।
💻|I work from home on Fridays.|मैं शुक्रवार को घर से काम करता हूँ।
🙏|Thanks for your help today.|आज की मदद के लिए धन्यवाद।
🧑‍💻|I'm learning new skills at work.|मैं काम पर नए कौशल सीख रहा हूँ।
😅|It was a stressful week.|यह तनाव भरा हफ्ता था।
🌅|I look forward to the weekend.|मुझे सप्ताहांत का इंतज़ार है।
👋|I'm leaving the office now.|मैं अभी कार्यालय से निकल रहा हूँ।
"""), "en"),
        SentenceCategory("se-study", "🎓 Study & School", "🎓", "School, tests, studying", sec("""
🎓|I'm a university student.|मैं विश्वविद्यालय का विद्यार्थी हूँ।
📚|I'm studying for the exam.|मैं परीक्षा की तैयारी कर रहा हूँ।
✏️|I have a lot of homework.|मेरे पास बहुत होमवर्क है।
📖|The test is tomorrow.|परीक्षा कल है।
👩‍🏫|Our teacher is very kind.|हमारे शिक्षक बहुत दयालु हैं।
🗣️|English class is interesting.|अंग्रेज़ी की कक्षा दिलचस्प है।
📝|I take notes in class.|मैं कक्षा में नोट्स लेता हूँ।
❓|I have a question.|मेरा एक प्रश्न है।
🙋|I know the answer.|मुझे उत्तर पता है।
🤔|I don't understand this lesson.|मुझे यह पाठ समझ नहीं आया।
🔁|Please explain it again.|कृपया इसे फिर से समझाइए।
✍️|I practice writing every day.|मैं हर दिन लिखने का अभ्यास करता हूँ।
🎧|I listen to English podcasts.|मैं अंग्रेज़ी पॉडकास्ट सुनता हूँ।
📚|I study at the library.|मैं पुस्तकालय में पढ़ता हूँ।
🏆|My grades improved a lot.|मेरे अंक बहुत सुधरे।
🎒|I forgot my notebook.|मैं अपनी कॉपी भूल गया।
🕛|We have lunch together.|हम साथ में दोपहर का खाना खाते हैं।
🎓|I want to study abroad.|मैं विदेश में पढ़ना चाहता हूँ।
📝|The assignment is due next week.|असाइनमेंट अगले हफ्ते जमा करना है।
👨‍🎓|I graduated last year.|मैंने पिछले साल स्नातक किया।
💪|Keep practicing every day.|हर दिन अभ्यास करते रहो।
🧠|Learning a language takes time.|भाषा सीखने में समय लगता है।
📚|Reading helps me improve.|पढ़ने से मुझे सुधार होता है।
🎯|I set a goal to learn ten words a day.|मैंने रोज़ दस शब्द सीखने का लक्ष्य रखा।
🤝|Let's study together.|चलो साथ में पढ़ते हैं।
🏫|The school starts at nine.|स्कूल नौ बजे शुरू होता है।
🕒|My class ends at three.|मेरी कक्षा तीन बजे खत्म होती है।
📖|I read a chapter every night.|मैं हर रात एक अध्याय पढ़ता हूँ।
😊|I love learning new things.|मुझे नई चीज़ें सीखना पसंद है।
🎉|I passed the exam!|मैं परीक्षा में पास हो गया!
"""), "en"),
        SentenceCategory("se-health", "🏥 Health & Appointments", "🏥", "Illness and doctor visits", sec("""
🤒|I caught a cold.|मुझे सर्दी लग गई।
🤕|I have a headache.|मेरे सिर में दर्द है।
😷|My throat hurts.|मेरे गले में दर्द है।
🤢|I feel sick.|मुझे बीमार महसूस हो रहा है।
🌡️|I have a fever.|मुझे बुखार है।
🦷|I have a toothache.|मेरे दाँत में दर्द है।
🏥|I need to see a doctor.|मुझे डॉक्टर से मिलना है।
💊|Take this medicine twice a day.|यह दवा दिन में दो बार लीजिए।
🛌|You need to rest.|आपको आराम करना है।
🚑|Call an ambulance!|एम्बुलेंस बुलाओ!
🩹|I got hurt.|मुझे चोट लगी।
😴|I didn't sleep well.|मुझे अच्छी नींद नहीं आई।
🥗|Eat healthy food.|स्वस्थ भोजन खाइए।
🏃|I walk every day for health.|मैं सेहत के लिए हर दिन चलता हूँ।
😌|I feel much better now.|अब मैं काफ़ी बेहतर महसूस कर रहा हूँ।
🥛|Drink plenty of water.|खूब पानी पीजिए।
🩺|The doctor checked me.|डॉक्टर ने मेरी जाँच की।
🍎|An apple is good for health.|सेब सेहत के लिए अच्छा है।
😷|Cover your mouth when you cough.|खांसते समय मुँह ढकिए।
🧴|Wash your hands often.|बार-बार हाथ धोइए।
🏋️|Exercise keeps you fit.|व्यायाम आपको तंदुरुस्त रखता है।
🛌|I'm going to bed early tonight.|आज रात मैं जल्दी सोऊँगा।
💆|A massage helps my back.|मालिश से मेरी पीठ ठीक रहती है।
🤧|I keep sneezing.|मुझे बार-बार छींक आ रही है।
🌡️|My temperature is normal.|मेरा तापमान सामान्य है।
"""), "en"),
        SentenceCategory("se-time", "⏰ Time & Schedules", "⏰", "Time and daily timing", sec("""
⏰|What time is it?|कितने बजे हैं?
🕒|It's half past three.|साढ़े तीन बजे हैं।
⏳|It's a quarter to five.|सवा पाँच बजने में पंद्रह मिनट हैं।
⏭️|It's ten past eight.|आठ बजकर दस मिनट हुए।
🌅|I wake up early.|मैं जल्दी उठता हूँ।
🌙|I stayed up late.|मैं देर तक जागा।
📅|What day is today?|आज कौन सा दिन है?
📅|Today is Monday.|आज सोमवार है।
🕒|The meeting is at noon.|मीटिंग दोपहर में है।
⏰|I set my alarm for six.|मैंने अलार्म छह बजे के लिए लगाया।
🕐|I'll be there in an hour.|मैं एक घंटे में वहाँ पहुँचूँगा।
⏱️|We have only five minutes.|हमारे पास सिर्फ़ पाँच मिनट हैं।
🕰️|Time flies fast.|समय तेज़ी से बीतता है।
😅|I'm always late.|मैं हमेशा देर से पहुँचता हूँ।
⏰|Please be on time.|कृपया समय पर आइए।
📆|The party is at eight tonight.|पार्टी आज रात आठ बजे है।
🕒|The store opens at nine.|दुकान नौ बजे खुलती है।
🌇|I work until evening.|मैं शाम तक काम करता हूँ।
⏳|Can you wait a moment?|क्या आप एक पल रुक सकते हैं?
🕐|It takes thirty minutes.|इसमें तीस मिनट लगते हैं।
📅|Next month is busy.|अगला महीना व्यस्त है।
🌅|The morning is the best time.|सुबह का समय सबसे अच्छा है।
⏰|I don't have time today.|आज मेरे पास समय नहीं है।
🗓️|The deadline is next Monday.|समय सीमा अगले सोमवार है।
🌙|It's getting late.|देर हो रही है।
"""), "en"),
        SentenceCategory("se-plan", "📅 Plans & Invitations", "📅", "Making plans, inviting", sec("""
🤔|What are your plans for the weekend?|सप्ताहांत के लिए आपकी क्या योजनाएँ हैं?
🎬|Would you like to watch a movie?|क्या आप फिल्म देखना चाहेंगे?
🍕|Let's go out for dinner.|चलो बाहर खाना खाते हैं।
😊|That sounds great!|वह बहुत अच्छा लगता है!
❌|Sorry, I'm busy then.|माफ़ कीजिए, मैं तब व्यस्त हूँ।
🔄|How about another day?|किसी और दिन कैसा रहेगा?
⏰|What time should we meet?|हम कितने बजे मिलें?
📍|Let's meet at the station.|चलो स्टेशन पर मिलते हैं।
🚶|I'll pick you up at home.|मैं तुम्हें घर से लेने आऊँगा।
🎉|I'm having a party on Saturday.|शनिवार को मेरी पार्टी है।
🎁|Can you come to my birthday?|क्या आप मेरे जन्मदिन पर आ सकते हैं?
✈️|I'm planning a trip next month.|मैं अगले महीने यात्रा की योजना बना रहा हूँ।
🗓️|Let's schedule a call.|चलो एक कॉल तय करते हैं।
🤝|Are you free tomorrow?|क्या आप कल खाली हैं?
🎳|Let's do something fun.|चलो कुछ मज़ेदार करते हैं।
🍵|I'd love to join you.|मुझे आपके साथ आना अच्छा लगेगा।
💭|Let me check my schedule.|मैं अपना कार्यक्रम देखूँ।
✅|Count me in!|मुझे गिन लो!
😅|I'm not sure yet.|मुझे अभी पक्का नहीं पता।
📅|We can decide later.|हम बाद में तय कर सकते हैं।
🚗|The plan is to leave at nine.|योजना है कि नौ बजे निकलें।
🌧️|The plan might change if it rains.|बारिश हुई तो योजना बदल सकती है।
🎂|It's a surprise party!|यह सरप्राइज़ पार्टी है!
🕖|I'll see you at seven.|मैं तुमसे सात बजे मिलूँगा।
😊|I'm really looking forward to it.|मैं इसका बेसब्री से इंतज़ार कर रहा हूँ।
"""), "en"),
        SentenceCategory("se-family", "👪 Family & Relationships", "👪", "Family and friends", sec("""
👨‍👩‍👧|How many people are in your family?|आपके परिवार में कितने लोग हैं?
👨‍👩‍👧|There are four of us.|हम चार लोग हैं।
👨|My father is a doctor.|मेरे पिता डॉक्टर हैं।
👩|My mother is a teacher.|मेरी माँ शिक्षिका हैं।
👦|I have an older brother.|मेरा एक बड़ा भाई है।
👧|She is my younger sister.|वह मेरी छोटी बहन है।
👴|My grandfather is eighty.|मेरे दादा अस्सी साल के हैं।
👵|My grandmother tells great stories.|मेरी दादी बहुत अच्छी कहानियाँ सुनाती हैं।
🏠|We live together.|हम साथ रहते हैं।
🤝|He is my best friend.|वह मेरा सबसे अच्छा दोस्त है।
💞|They are getting married.|उनकी शादी हो रही है।
🎉|The wedding is in December.|शादी दिसंबर में है।
💔|They broke up last year.|पिछले साल उनका ब्रेकअप हो गया।
📞|I call my parents every week.|मैं हर हफ्ते माता-पिता को फोन करता हूँ।
🏡|I visit my family on holidays.|मैं छुट्टियों में परिवार से मिलने जाता हूँ।
👨‍👦|I look like my father.|मैं अपने पिता जैसा दिखता हूँ।
👩‍👧|She looks like her mother.|वह अपनी माँ जैसी दिखती है।
💝|I love my family very much.|मैं अपने परिवार से बहुत प्यार करता हूँ।
🎂|We celebrate birthdays together.|हम साथ में जन्मदिन मनाते हैं।
🍜|Sunday lunch is a family tradition.|रविवार का दोपहर का भोजन परिवार की परंपरा है।
👥|He has three children.|उनके तीन बच्चे हैं।
👶|They have a new baby.|उनका नया बच्चा हुआ है।
🤗|We are very close.|हम बहुत करीबी हैं।
🏠|Family comes first.|परिवार सबसे पहले।
💬|We talk about everything.|हम हर बात करते हैं।
🤝|I trust my best friend.|मुझे अपने सबसे अच्छे दोस्त पर भरोसा है।
📸|We took a family photo.|हमने पारिवारिक फोटो खींची।
🌍|My cousin lives abroad.|मेरा चचेरा भाई विदेश में रहता है।
✈️|I miss my family.|मुझे अपने परिवार की याद आती है।
❤️|Relationships need care.|रिश्तों की देखभाल ज़रूरी है।
"""), "en"),
        SentenceCategory("se-feel", "💗 Feelings & Opinions", "💗", "Expressing feelings and opinions", sec("""
😊|I'm so happy today.|मैं आज बहुत खुश हूँ।
😢|I feel sad.|मुझे उदासी महसूस हो रही है।
😠|I'm angry about it.|मैं इस पर गुस्से में हूँ।
😨|I'm scared of spiders.|मुझे मकड़ियों से डर लगता है।
😌|I feel calm now.|मैं अब शांत महसूस कर रहा हूँ।
😴|I'm sleepy.|मुझे नींद आ रही है।
🤩|I'm excited about the trip.|मैं यात्रा को लेकर उत्साहित हूँ।
😟|I'm worried about the exam.|मैं परीक्षा को लेकर चिंतित हूँ।
😲|That surprised me!|उसने मुझे चौंका दिया!
🙄|I'm annoyed.|मैं नाराज़ हूँ।
😬|I feel embarrassed.|मुझे शर्मिंदगी महसूस हो रही है।
💪|I feel confident.|मैं आत्मविश्वास महसूस कर रहा हूँ।
🥰|I'm in love.|मुझे प्यार हो गया है।
💔|I feel heartbroken.|मेरा दिल टूट गया है।
😅|I'm a little nervous.|मैं थोड़ा घबराया हुआ हूँ।
🤗|I feel grateful.|मैं आभारी महसूस करता हूँ।
😪|I'm bored.|मुझे बोरियत हो रही है।
🥳|I'm in a good mood.|मैं अच्छे मूड में हूँ।
😤|I'm frustrated.|मैं निराश हो रहा हूँ।
😇|I feel relieved.|मुझे राहत महसूस हुई।
🤔|I'm curious about it.|मैं इस बारे में उत्सुक हूँ।
👍|I think it's a good idea.|मुझे लगता है यह अच्छा विचार है।
👎|I don't like that idea.|मुझे वह विचार पसंद नहीं।
🤝|I agree with you.|मैं आपसे सहमत हूँ।
🤷|I disagree completely.|मैं पूरी तरह असहमत हूँ।
🧠|In my opinion, it's too expensive.|मेरी राय में यह बहुत महँगा है।
💬|If you ask me, we should wait.|मुझसे पूछो तो हमें इंतज़ार करना चाहिए।
😌|I'm proud of you.|मुझे तुम पर गर्व है।
❤️|I really like it.|मुझे यह सच में पसंद है।
🙃|I don't care.|मुझे कोई फ़र्क नहीं पड़ता।
"""), "en"),
        SentenceCategory("se-phone", "📱 Phone & Messages", "📱", "Phone calls and messages", sec("""
📞|Hello, this is Alex.|नमस्ते, मैं एलेक्स बोल रहा हूँ।
📞|May I speak to Maria?|क्या मैं मारिया से बात कर सकता हूँ?
📞|Speaking. Who's calling?|मैं ही हूँ। कौन बोल रहा है?
⏳|Please hold on a moment.|कृपया एक पल रुकिए।
🔔|He's not available right now.|वह अभी उपलब्ध नहीं हैं।
📱|Can I take a message?|क्या मैं संदेश ले सकता हूँ?
📝|I'll call back later.|मैं बाद में फिर कॉल करूँगा।
📱|The line is busy.|लाइन व्यस्त है।
📉|We got disconnected.|हमारा कॉल कट गया।
🔋|My battery is dying.|मेरा फोन चार्ज खत्म हो रहा है।
📶|The signal is bad here.|यहाँ नेटवर्क खराब है।
📱|Let's text instead.|चलो बजाय इसके मैसेज करते हैं।
💬|I'll send you a message.|मैं तुम्हें मैसेज भेजूँगा।
👍|Did you get my message?|क्या तुम्हें मेरा मैसेज मिला?
📵|Please turn off your phone.|कृपया अपना फोन बंद कर दीजिए।
🔕|My phone is on silent.|मेरा फोन साइलेंट है।
📱|Call me when you're free.|जब तुम खाली हो तो मुझे कॉल करना।
☎️|What's your number?|तुम्हारा नंबर क्या है?
🔇|I can't hear you well.|मैं तुम्हें ठीक से नहीं सुन पा रहा।
📞|Could you speak up, please?|क्या आप ज़ोर से बोलेंगे?
📱|I missed your call.|मेरा तुम्हारा कॉल छूट गया।
🔙|I'll call you right back.|मैं अभी तुम्हें वापस कॉल करता हूँ।
🔌|Do you have a phone charger?|क्या तुम्हारे पास चार्जर है?
🗓️|Let's talk on video tomorrow.|चलो कल वीडियो कॉल पर बात करते हैं।
📴|I don't pick up unknown numbers.|मैं अनजान नंबरों का फोन नहीं उठाता।
"""), "en"),
        SentenceCategory("se-weather", "🌦️ Weather", "🌦️", "Weather talk", sec("""
☀️|It's sunny today.|आज धूप है।
☁️|It's cloudy.|बादल छाए हुए हैं।
🌧️|It's raining outside.|बाहर बारिश हो रही है।
❄️|It's snowing.|बर्फ़ गिर रही है।
🌫️|It's foggy this morning.|आज सुबह कोहरा है।
💨|The wind is strong.|हवा तेज़ चल रही है।
🌡️|It's very hot today.|आज बहुत गरमी है।
🥶|It's freezing cold.|बहुत ठंड है।
🌤️|The sky is clear.|आसमान साफ़ है।
🌈|There's a rainbow!|इंद्रधनुष है!
⚡|There's lightning.|बिजली चमक रही है।
🌩️|Thunder is scary.|गरज से डर लगता है।
☔|Take an umbrella with you.|अपने साथ छाता ले जाओ।
🧥|Wear a warm coat.|गरम कोट पहनो।
🌡️|It will be 30 degrees today.|आज तीस डिग्री रहेगा।
🌦️|The weather is changing.|मौसम बदल रहा है।
📺|What's the forecast?|मौसम का पूर्वानुमान क्या है?
🌧️|It rained all day.|पूरे दिन बारिश हुई।
☀️|The sun is shining.|धूप चमक रही है।
🍂|It's getting cooler.|ठंड बढ़ रही है।
🌸|Spring is beautiful.|वसंत बहुत सुंदर होता है।
☀️|Summer is my favorite season.|गर्मी मेरा पसंदीदा मौसम है।
❄️|Winter days are short.|सर्दियों के दिन छोटे होते हैं।
🌧️|I got wet in the rain.|मैं बारिश में भीग गया।
😊|I love rainy days.|मुझे बारिश के दिन पसंद हैं।
🏠|Let's stay home because of the rain.|बारिश की वजह से चलो घर पर रहते हैं।
"""), "en"),
        SentenceCategory("se-help", "🗺️ Asking for Help", "🗺️", "Asking for help and directions", sec("""
🆘|Can you help me, please?|क्या आप मेरी मदद कर सकते हैं?
🙏|I need your help.|मुझे आपकी मदद चाहिए।
🗺️|Could you show me the way?|क्या आप मुझे रास्ता दिखा सकते हैं?
📍|Where is the train station?|ट्रेन स्टेशन कहाँ है?
🚻|Where is the restroom?|शौचालय कहाँ है?
🏧|Where can I find an ATM?|एटीएम कहाँ मिलेगा?
💊|Can you recommend a pharmacy?|क्या आप किसी दवा की दुकान की सलाह दे सकते हैं?
📵|Can I use your phone?|क्या मैं आपका फोन इस्तेमाल कर सकता हूँ?
🔋|I need to charge my phone.|मुझे अपना फोन चार्ज करना है।
🧳|Can you watch my bag?|क्या आप मेरा बैग देख लेंगे?
📝|Could you write it down?|क्या आप इसे लिख देंगे?
🤝|I'll do the same for you.|मैं भी आपके लिए यही करूँगा।
😅|Thanks for your help.|आपकी मदद के लिए धन्यवाद।
😊|Glad to help.|मदद करके खुशी हुई।
🕵️|I'm looking for a hotel.|मैं एक होटल ढूँढ रहा हूँ।
🍽️|Where's a good place to eat?|खाने के लिए अच्छी जगह कहाँ है?
🚕|Could you call a cab for me?|क्या आप मेरे लिए टैक्सी बुला सकते हैं?
❓|Can you speak more slowly?|क्या आप धीरे बोल सकते हैं?
🔁|I didn't understand.|मैं समझा नहीं।
📖|Can you explain it simply?|क्या आप इसे आसानी से समझा सकते हैं?
🙋|Does anyone speak English here?|क्या यहाँ कोई अंग्रेज़ी बोलता है?
🗣️|I can't find my friend.|मुझे अपना दोस्त नहीं मिल रहा।
📋|Please wait a moment.|कृपया एक क्षण रुकिए।
🙌|That's very kind of you.|यह आपकी बड़ी कृपा है।
✅|Let me know if you need anything.|अगर कुछ चाहिए तो बताना।
"""), "en"),
        SentenceCategory("se-party", "🎉 Celebrations & Parties", "🎉", "Celebrations and parties", sec("""
🎉|Happy birthday!|जन्मदिन मुबारक हो!
🎊|Congratulations!|बधाई हो!
🎓|Congratulations on graduating!|स्नातक की बधाई हो!
💍|Congratulations on your wedding!|शादी की बधाई हो!
🎁|This gift is for you.|यह उपहार आपके लिए है।
🎂|Let's blow out the candles.|चलो मोमबत्तियाँ बुझाएँ।
🥳|The party starts at seven.|पार्टी सात बजे शुरू होती है।
🎵|We played music all night.|हमने पूरी रात संगीत बजाया।
🍻|Let's make a toast!|चलो टोस्ट करते हैं!
🎉|Cheers!|चियर्स!
🍰|I had two slices of cake.|मैंने केक के दो टुकड़े खाए।
🎈|The balloons are beautiful.|गुब्बारे बहुत सुंदर हैं।
📸|Let's take a group photo.|चलो एक ग्रुप फोटो लेते हैं।
🎤|I sang karaoke.|मैंने कराओके गाया।
🕺|Everyone danced a lot.|सबने खूब नाचा।
🎁|Thank you for the gift.|उपहार के लिए धन्यवाद।
🎉|Happy New Year!|नया साल मुबारक हो!
🎊|May all your wishes come true.|आपकी सभी इच्छाएँ पूरी हों।
🥂|Let's meet again soon.|फिर जल्द मिलते हैं।
😊|It was a wonderful party.|यह बहुत शानदार पार्टी थी।
🎇|The fireworks were amazing.|आतिशबाज़ी अद्भुत थी।
🎃|Happy Diwali!|दिवाली मुबारक हो!
🎄|Merry Christmas!|क्रिसमस की शुभकामनाएँ!
🌙|Happy Eid!|ईद मुबारक!
🎀|The party room is decorated.|पार्टी का कमरा सजाया गया है।
"""), "en"),
        SentenceCategory("se-money", "💰 Money & Numbers", "💰", "Money and counting", sec("""
💵|I need to exchange money.|मुझे पैसे बदलने हैं।
🏦|Where's the nearest bank?|सबसे नज़दीकी बैंक कहाँ है?
💳|I want to withdraw cash.|मैं नकद निकालना चाहता हूँ।
🧾|Can I get a receipt?|क्या मुझे रसीद मिल सकती है?
💸|This is expensive.|यह महँगा है।
🪙|I found a coin on the street.|मुझे सड़क पर एक सिक्का मिला।
💰|How much money do you have?|तुम्हारे पास कितने पैसे हैं?
🏦|I have a savings account.|मेरा बचत खाता है।
💳|I pay with my card.|मैं कार्ड से भुगतान करता हूँ।
📱|I use a payment app.|मैं भुगतान ऐप इस्तेमाल करता हूँ।
💰|Can I borrow some money?|क्या मैं कुछ पैसे उधार ले सकता हूँ?
🔄|I'll pay you back tomorrow.|मैं तुम्हें कल वापस कर दूँगा।
💸|I'm saving for a new phone.|मैं नए फोन के लिए पैसे जमा कर रहा हूँ।
💰|The price has gone up.|कीमत बढ़ गई है।
🏷️|It costs ten dollars.|इसकी कीमत दस डॉलर है।
💵|Do you have change for a twenty?|क्या आपके पास बीस का छुट्टा है?
💳|The payment failed.|भुगतान विफल रहा।
📉|Prices are rising.|कीमतें बढ़ रही हैं।
📈|My salary increased.|मेरा वेतन बढ़ गया।
🛒|I spent a lot this month.|मैंने इस महीने बहुत खर्च किया।
🤝|We split the bill.|हमने बिल बाँट लिया।
💰|Money doesn't grow on trees.|पैसे पेड़ पर नहीं उगते।
🏦|I opened a bank account.|मैंने बैंक खाता खोला।
💸|I'm out of money.|मेरे पास पैसे खत्म हो गए।
🎁|I'll pay for everyone.|मैं सबका भुगतान करूँगा।
"""), "en"),
        SentenceCategory("se-emerg", "🚨 Emergency", "🚨", "Emergencies", sec("""
🆘|Help!|मदद!
🚨|Call the police!|पुलिस को बुलाओ!
🚑|Call an ambulance!|एम्बुलेंस बुलाओ!
🔥|There's a fire!|आग लगी है!
🏃|Run!|भागो!
⚠️|Be careful!|सावधान रहो!
🏥|Where is the hospital?|अस्पताल कहाँ है?
🆘|I need a doctor.|मुझे डॉक्टर चाहिए।
🚪|Get out of here!|यहाँ से निकलो!
📍|What's your address?|आपका पता क्या है?
🗣️|I'm lost.|मैं भटक गया हूँ।
🎒|I lost my wallet.|मेरा बटुआ खो गया।
📱|My phone was stolen.|मेरा फोन चोरी हो गया।
🪪|I lost my passport.|मेरा पासपोर्ट खो गया।
🤕|Someone is hurt.|किसी को चोट लगी है।
💊|I need medicine.|मुझे दवा चाहिए।
🤢|I feel very sick.|मुझे बहुत बीमार महसूस हो रहा है।
🩸|I'm bleeding.|मुझे खून बह रहा है।
🏃|Follow me!|मेरे पीछे आओ!
🚨|Is there a police station nearby?|क्या पास में पुलिस थाना है?
📞|Dial the emergency number.|आपातकालीन नंबर मिलाइए।
😨|Don't panic.|घबराओ मत।
🚑|The ambulance is coming.|एम्बुलेंस आ रही है।
✅|Everything is okay now.|अब सब ठीक है।
🙏|Thank God you're safe.|भगवान का शुक्र है, तुम सुरक्षित हो।
"""), "en"),
    )
}
