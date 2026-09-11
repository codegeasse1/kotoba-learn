package com.nexo.kotoba

/**
 * Hand-written extra example sentences for the Japanese grammar patterns whose
 * own list (or a close relative) can't reach ten sentences. Each line is:
 *
 *     emoji|japanese|romaji|english|hindi
 *
 * `GrammarPacks.parse` splits on `|` and trims every field. Keep one entry per
 * pattern id.
 */
internal object GrammarExtraJa {
    val raw: Map<String, String> = mapOf(

        "jp2" to """
            🚫|これはほんではありません。|kore wa hon dewa arimasen|This is not a book.|यह किताब नहीं है।
            🧑|かれはせんせいではありません。|kare wa sensei dewa arimasen|He is not a teacher.|वह शिक्षक नहीं है।
            🐕|あれはいぬではありません。|are wa inu dewa arimasen|That is not a dog.|वह कुत्ता नहीं है।
            🇯🇵|わたしはにほんじんではありません。|watashi wa nihonjin dewa arimasen|I am not Japanese.|मैं जापानी नहीं हूँ।
            🍵|これはおちゃではありません。|kore wa ocha dewa arimasen|This is not tea.|यह चाय नहीं है।
            🎒|それはわたしのかばんではありません。|sore wa watashi no kaban dewa arimasen|That is not my bag.|वह मेरा बैग नहीं है।
            📱|これはあなたのけいたいではありません。|kore wa anata no keitai dewa arimasen|This is not your phone.|यह तुम्हारा फ़ोन नहीं है।
            🏫|あそこはがっこうではありません。|asoko wa gakkou dewa arimasen|That place is not a school.|वह जगह स्कूल नहीं है।
        """,

        "jp4" to """
            🍎|りんごがすきです。|ringo ga suki desu|I like apples.|मुझे सेब पसंद हैं।
            🐕|いぬがすきです。|inu ga suki desu|I like dogs.|मुझे कुत्ते पसंद हैं।
            🎵|おんがくがすきです。|ongaku ga suki desu|I like music.|मुझे संगीत पसंद है।
            ⚽|サッカーがすきです。|sakkaa ga suki desu|I like football.|मुझे फ़ुटबॉल पसंद है।
            📚|ほんをよむのがすきです。|hon o yomu no ga suki desu|I like reading books.|मुझे किताबें पढ़ना पसंद है।
            🍜|ラーメンがだいすきです。|raamen ga daisuki desu|I love ramen.|मुझे रामेन बहुत पसंद है।
            🐟|さかなはあまりすきではありません。|sakana wa amari suki dewa arimasen|I don't really like fish.|मुझे मछली ज़्यादा पसंद नहीं है।
            🇯🇵|にほんのぶんかがすきです。|nihon no bunka ga suki desu|I like Japanese culture.|मुझे जापानी संस्कृति पसंद है।
        """,

        "jp10" to """
            🐈|いえにねこがいます。|ie ni neko ga imasu|There is a cat in the house.|घर में एक बिल्ली है।
            📖|つくえのうえにほんがあります。|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर एक किताब है।
            🧑|こうえんにこどもがいます。|kouen ni kodomo ga imasu|There are children in the park.|पार्क में बच्चे हैं।
            🚗|そとにくるまがあります。|soto ni kuruma ga arimasu|There is a car outside.|बाहर एक कार है।
            🐕|にわにいぬがいます。|niwa ni inu ga imasu|There is a dog in the garden.|बगीचे में एक कुत्ता है।
            🏪|えきのちかくにスーパーがあります。|eki no chikaku ni suupaa ga arimasu|There is a supermarket near the station.|स्टेशन के पास एक सुपरमार्केट है।
            ❓|へやにだれがいますか。|heya ni dare ga imasu ka|Who is in the room?|कमरे में कौन है?
            ❌|ここにコンビニはありません。|koko ni konbini wa arimasen|There is no convenience store here.|यहाँ कोई सुविधा-स्टोर नहीं है।
        """,

        "jp11" to """
            🚉|えきからいえまであるきます。|eki kara ie made arukimasu|I walk from the station to my house.|मैं स्टेशन से घर तक पैदल चलता हूँ।
            🕘|くじからごじまでべんきょうします。|kuji kara goji made benkyou shimasu|I study from nine to five.|मैं नौ से पाँच बजे तक पढ़ता हूँ।
            🗾|とうきょうからおおさかまでいきます。|toukyou kara oosaka made ikimasu|I go from Tokyo to Osaka.|मैं टोक्यो से ओसाका जाता हूँ।
            📅|げつようびからきんようびまでしごとです。|getsuyoubi kara kinyoubi made shigoto desu|I work from Monday to Friday.|मैं सोमवार से शुक्रवार तक काम करता हूँ।
            🏫|がっこうははちじからさんじまでです。|gakkou wa hachiji kara sanji made desu|School is from eight to three.|स्कूल आठ से तीन बजे तक है।
            🚌|ここからえきまでバスでじゅっぷんです。|koko kara eki made basu de juppun desu|It is ten minutes by bus from here to the station.|यहाँ से स्टेशन तक बस से दस मिनट हैं।
            🌙|よるからあさまでねます。|yoru kara asa made nemasu|I sleep from night until morning.|मैं रात से सुबह तक सोता हूँ।
            ❓|なんじからなんじまでですか。|nanji kara nanji made desu ka|From what time to what time is it?|कितने बजे से कितने बजे तक है?
        """,

        "jp12" to """
            📕|これはわたしのほんです。|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है।
            🖊️|それはなんですか。|sore wa nan desu ka|What is that?|वह क्या है?
            🏠|あれはがっこうです。|are wa gakkou desu|That over there is a school.|वह दूर वाला स्कूल है।
            👞|このくつはたかいです。|kono kutsu wa takai desu|These shoes are expensive.|ये जूते महँगे हैं।
            📱|そのけいたいはあたらしいです。|sono keitai wa atarashii desu|That phone is new.|वह फ़ोन नया है।
            🐕|あのいぬはかわいいです。|ano inu wa kawaii desu|That dog over there is cute.|वह कुत्ता प्यारा है।
            ❓|どれがあなたのペンですか。|dore ga anata no pen desu ka|Which one is your pen?|तुम्हारा पेन कौन सा है?
        """,

        "jp14" to """
            🍎|このりんごはあまいです。|kono ringo wa amai desu|This apple is sweet.|यह सेब मीठा है।
            🏔️|ふじさんはたかいです。|fujisan wa takai desu|Mount Fuji is high.|माउंट फ़ूजी ऊँचा है।
            🎓|かれはゆうめいなせんせいです。|kare wa yuumei na sensei desu|He is a famous teacher.|वह एक प्रसिद्ध शिक्षक हैं।
            🏙️|とうきょうはにぎやかなまちです。|toukyou wa nigiyaka na machi desu|Tokyo is a lively city.|टोक्यो एक जीवंत शहर है।
            🍜|このラーメンはおいしいです。|kono raamen wa oishii desu|This ramen is delicious.|यह रामेन स्वादिष्ट है।
            🚗|これはべんりなくるまです。|kore wa benri na kuruma desu|This is a convenient car.|यह एक सुविधाजनक कार है।
            📚|このほんはおもしろいです。|kono hon wa omoshiroi desu|This book is interesting.|यह किताब रोचक है।
            🧑|かのじょはしずかなひとです。|kanojo wa shizuka na hito desu|She is a quiet person.|वह एक शांत व्यक्ति है।
        """,

        "jp15" to """
            🐱|わたしはねこがすきです。いぬもすきです。|watashi wa neko ga suki desu. inu mo suki desu|I like cats. I like dogs too.|मुझे बिल्लियाँ पसंद हैं। कुत्ते भी पसंद हैं।
            ☕|コーヒーもおちゃもすきです。|koohii mo ocha mo suki desu|I like both coffee and tea.|मुझे कॉफ़ी और चाय दोनों पसंद हैं।
            🧑|たなかさんはがくせいです。わたしもがくせいです。|Tanaka-san wa gakusei desu. watashi mo gakusei desu|Tanaka is a student. I am a student too.|तनाका विद्यार्थी हैं। मैं भी विद्यार्थी हूँ।
            🇯🇵|にほんごもえいごもべんきょうします。|nihongo mo eigo mo benkyou shimasu|I study both Japanese and English.|मैं जापानी और अंग्रेज़ी दोनों पढ़ता हूँ।
            🍺|わたしもいきます。|watashi mo ikimasu|I will go too.|मैं भी जाऊँगा।
            🚫|かれはおさけをのみません。わたしものみません。|kare wa osake o nomimasen. watashi mo nomimasen|He doesn't drink alcohol. I don't either.|वह शराब नहीं पीता। मैं भी नहीं पीता।
            👩|かのじょもせんせいです。|kanojo mo sensei desu|She is a teacher too.|वह भी शिक्षिका हैं।
            🍣|すしもてんぷらもたべました。|sushi mo tenpura mo tabemashita|I ate both sushi and tempura.|मैंने सुशी और टेम्पुरा दोनों खाए।
        """,

        "jp17" to """
            🚪|ここでしゃしんをとってもいいですか。|koko de shashin o totte mo ii desu ka|May I take a photo here?|क्या मैं यहाँ फ़ोटो ले सकता हूँ?
            🪑|すわってもいいですよ。|suwatte mo ii desu yo|You may sit down.|आप बैठ सकते हैं।
            📖|このほんをかりてもいいですか。|kono hon o karite mo ii desu ka|May I borrow this book?|क्या मैं यह किताब उधार ले सकता हूँ?
            🍽️|ここでたべてもいいですか。|koko de tabete mo ii desu ka|May I eat here?|क्या मैं यहाँ खा सकता हूँ?
            🚗|わたしのくるまをつかってもいいです。|watashi no kuruma o tsukatte mo ii desu|You may use my car.|आप मेरी कार इस्तेमाल कर सकते हैं।
            🚬|ここでタバコをすってはいけません。|koko de tabako o sutte wa ikemasen|You must not smoke here.|यहाँ धूम्रपान नहीं कर सकते।
            🕐|はやくかえってもいいですよ。|hayaku kaette mo ii desu yo|You may go home early.|आप जल्दी घर जा सकते हैं।
            ❓|エアコンをけしてもいいですか。|eakon o keshite mo ii desu ka|May I turn off the air conditioner?|क्या मैं एयर कंडीशनर बंद कर सकता हूँ?
        """,

        "jp18" to """
            📚|まいにちべんきょうしなければなりません。|mainichi benkyou shinakereba narimasen|I must study every day.|मुझे हर दिन पढ़ना पड़ता है।
            💼|あしたしごとにいかなければなりません。|ashita shigoto ni ikanakereba narimasen|I must go to work tomorrow.|मुझे कल काम पर जाना है।
            🏥|くすりをのまなければなりません。|kusuri o nomanakereba narimasen|I must take medicine.|मुझे दवा लेनी है।
            📝|しゅくだいをしなければなりません。|shukudai o shinakereba narimasen|I must do my homework.|मुझे गृहकार्य करना है।
            🕗|はちじまでにいかなければなりません。|hachiji made ni ikanakereba narimasen|I must go by eight o'clock.|मुझे आठ बजे तक जाना है।
            🧾|おかねをはらわなければなりません。|okane o harawanakereba narimasen|I must pay the money.|मुझे पैसे देने होंगे।
            👔|せんたくをしなければなりません。|sentaku o shinakereba narimasen|I must do the laundry.|मुझे कपड़े धोने हैं।
            ❓|いまかえらなければなりませんか。|ima kaeranakereba narimasen ka|Must I go home now?|क्या मुझे अब घर जाना है?
        """,

        "jp19" to """
            🍽️|ごはんをたべてから、さんぽします。|gohan o tabete kara, sanpo shimasu|After eating, I take a walk.|खाना खाने के बाद मैं टहलने जाता हूँ।
            🚿|シャワーをあびてから、でかけます。|shawaa o abite kara, dekakemasu|After taking a shower, I go out.|स्नान करने के बाद मैं बाहर जाता हूँ।
            📚|べんきょうしてから、ねます。|benkyou shite kara, nemasu|After studying, I sleep.|पढ़ाई करने के बाद मैं सोता हूँ।
            ☕|コーヒーをのんでから、しごとをします。|koohii o nonde kara, shigoto o shimasu|After drinking coffee, I work.|कॉफ़ी पीने के बाद मैं काम करता हूँ।
            🧹|へやをそうじしてから、テレビをみます。|heya o souji shite kara, terebi o mimasu|After cleaning the room, I watch TV.|कमरा साफ़ करने के बाद मैं टीवी देखता हूँ।
            💌|てがみをよんでから、へんじをかきます。|tegami o yonde kara, henji o kakimasu|After reading the letter, I write a reply.|पत्र पढ़ने के बाद मैं जवाब लिखता हूँ।
            🏫|がっこうがおわってから、あそびます。|gakkou ga owatte kara, asobimasu|After school ends, I play.|स्कूल खत्म होने के बाद मैं खेलता हूँ।
            🛒|かいものをしてから、うちへかえります。|kaimono o shite kara, uchi e kaerimasu|After shopping, I go home.|खरीदारी करने के बाद मैं घर जाता हूँ।
        """,

        "jp21" to """
            💰|おかねがほしいです。|okane ga hoshii desu|I want money.|मुझे पैसे चाहिए।
            🚗|あたらしいくるまがほしいです。|atarashii kuruma ga hoshii desu|I want a new car.|मुझे नई कार चाहिए।
            📱|あたらしいけいたいがほしいです。|atarashii keitai ga hoshii desu|I want a new phone.|मुझे नया फ़ोन चाहिए।
            🏠|おおきいいえがほしいです。|ookii ie ga hoshii desu|I want a big house.|मुझे बड़ा घर चाहिए।
            🐕|いぬがほしいです。|inu ga hoshii desu|I want a dog.|मुझे कुत्ता चाहिए।
            ❌|なにもほしくないです。|nani mo hoshikunai desu|I don't want anything.|मुझे कुछ नहीं चाहिए।
            ❓|なにがほしいですか。|nani ga hoshii desu ka|What do you want?|तुम्हें क्या चाहिए?
            ⌚|いいとけいがほしいです。|ii tokei ga hoshii desu|I want a good watch.|मुझे अच्छी घड़ी चाहिए।
        """,

        "jp23" to """
            🍜|このラーメンをたべてみます。|kono raamen o tabete mimasu|I'll try this ramen.|मैं यह रामेन खाकर देखता हूँ।
            👕|このシャツをきてみます。|kono shatsu o kite mimasu|I'll try on this shirt.|मैं यह शर्ट पहनकर देखता हूँ।
            🇯🇵|にほんごでいってみます。|nihongo de itte mimasu|I'll try saying it in Japanese.|मैं जापानी में कहकर देखता हूँ।
            🏃|あたらしいスポーツをやってみます。|atarashii supootsu o yatte mimasu|I'll try a new sport.|मैं नया खेल करके देखता हूँ।
            📖|このほんをよんでみます。|kono hon o yonde mimasu|I'll try reading this book.|मैं यह किताब पढ़कर देखता हूँ।
            🧑|たなかさんにきいてみます。|Tanaka-san ni kiite mimasu|I'll try asking Tanaka.|मैं तनाका से पूछकर देखता हूँ।
            🎮|あのゲームをやってみたいです。|ano geemu o yatte mitai desu|I want to try that game.|मैं वह गेम आज़माना चाहता हूँ।
            🚫|たべてみましたが、おいしくなかったです。|tabete mimashita ga, oishikunakatta desu|I tried it, but it wasn't tasty.|मैंने खाकर देखा, पर स्वादिष्ट नहीं था।
        """,

        "jp24" to """
            🌧️|あめですから、いきません。|ame desu kara, ikimasen|Because it's raining, I won't go.|क्योंकि बारिश हो रही है, मैं नहीं जाऊँगा।
            😴|ねむいですから、ねます。|nemui desu kara, nemasu|Because I'm sleepy, I'll sleep.|क्योंकि मुझे नींद आ रही है, मैं सोता हूँ।
            🕐|じかんがありませんから、いそぎます。|jikan ga arimasen kara, isogimasu|Because I have no time, I'll hurry.|क्योंकि समय नहीं है, मैं जल्दी करता हूँ।
            🍽️|おなかがすきましたから、たべます。|onaka ga sukimashita kara, tabemasu|Because I'm hungry, I'll eat.|क्योंकि मुझे भूख लगी है, मैं खाता हूँ।
            ❄️|さむいですから、コートをきます。|samui desu kara, kooto o kimasu|Because it's cold, I'll wear a coat.|क्योंकि ठंड है, मैं कोट पहनता हूँ।
            📚|テストがありますから、べんきょうします。|tesuto ga arimasu kara, benkyou shimasu|Because there's a test, I'll study.|क्योंकि परीक्षा है, मैं पढ़ता हूँ।
            💰|たかいですから、かいません。|takai desu kara, kaimasen|Because it's expensive, I won't buy it.|क्योंकि महँगा है, मैं नहीं खरीदूँगा।
            🚗|くるまがありませんから、あるきます。|kuruma ga arimasen kara, arukimasu|Because I don't have a car, I'll walk.|क्योंकि कार नहीं है, मैं पैदल चलूँगा।
        """,

        "jpN1-a" to """
            🎤|その歌手は東京公演を皮切りに、全国ツアーを始めた。|sono kashu wa Toukyou kouen o kawakiri ni, zenkoku tsuaa o hajimeta|Starting with the Tokyo show, the singer began a nationwide tour.|उस गायक ने टोक्यो शो से शुरुआत करके देशव्यापी दौरा शुरू किया।
            🏢|A社を皮切りに、次々と企業が新制度を導入した。|A-sha o kawakiri ni, tsugitsugi to kigyou ga shin seido o dounyuu shita|Starting with Company A, companies introduced the new system one after another.|कंपनी A से शुरुआत करके कई कंपनियों ने नई व्यवस्था अपनाई।
            🍜|この店を皮切りに、彼はチェーンを広げた。|kono mise o kawakiri ni, kare wa cheen o hirogeta|Starting with this shop, he expanded the chain.|इस दुकान से शुरुआत करके उसने चेन फैलाई।
            🎆|記念祭は花火を皮切りに幕を開けた。|kinensai wa hanabi o kawakiri ni maku o aketa|The festival opened, starting with fireworks.|समारोह आतिशबाज़ी से शुरुआत करके शुरू हुआ।
            📚|まずこの本を皮切りに、彼の作品を全部読もうと思う。|mazu kono hon o kawakiri ni, kare no sakuhin o zenbu yomou to omou|Starting with this book, I plan to read all his works.|पहले इस किताब से शुरुआत करके मैं उनकी सभी रचनाएँ पढ़ूँगा।
            🏗️|新空港を皮切りに、地域の開発が進んだ。|shin kuukou o kawakiri ni, chiiki no kaihatsu ga susunda|Starting with the new airport, development of the region advanced.|नए हवाई अड्डे से शुरुआत करके क्षेत्र का विकास हुआ।
            🎓|入学式を皮切りに、学校行事が続く。|nyuugakushiki o kawakiri ni, gakkou gyouji ga tsuzuku|Starting with the entrance ceremony, school events continue.|प्रवेश समारोह से शुरू होकर स्कूल के कार्यक्रम चलते रहते हैं।
            🌸|三月を皮切りに、観光客が増え始める。|sangatsu o kawakiri ni, kankoukyaku ga fuehajimeru|Starting in March, tourists begin to increase.|मार्च से शुरुआत करके पर्यटक बढ़ने लगते हैं।
            🎵|この曲を皮切りに、彼女は人気になった。|kono kyoku o kawakiri ni, kanojo wa ninki ni natta|Starting with this song, she became popular.|इस गाने से शुरुआत करके वह लोकप्रिय हो गई।
        """,

        "jpN1-b" to """
            ⚠️|事故に至って、初めて危険に気づいた。|jiko ni itatte, hajimete kiken ni kizuita|Only when the accident happened did they first notice the danger.|दुर्घटना होने पर ही पहली बार ख़तरा समझ आया।
            🩺|病気に至って、健康の大切さを知った。|byouki ni itatte, kenkou no taisetsusa o shitta|Only after falling ill did I learn the value of health.|बीमार पड़ने पर ही स्वास्थ्य का महत्व समझ आया।
            💸|破産に至って、彼は後悔した。|hasan ni itatte, kare wa koukai shita|Only when he went bankrupt did he regret it.|दिवालिया होने पर ही उसे पछतावा हुआ।
            📉|今に至って、その誤りが明らかになった。|ima ni itatte, sono ayamari ga akiraka ni natta|Only now has that mistake become clear.|अब आकर वह गलती स्पष्ट हुई।
            🔥|大事に至って、みんなが動き出した。|daiji ni itatte, minna ga ugokidashita|Only when it became serious did everyone start acting.|बात गंभीर होने पर ही सब हरकत में आए।
            🎓|卒業に至って、先生の言葉を思い出した。|sotsugyou ni itatte, sensei no kotoba o omoidashita|Only upon graduating did I recall the teacher's words.|स्नातक होते समय ही शिक्षक की बातें याद आईं।
            🧪|実験に至って、理論の誤りがわかった。|jikken ni itatte, riron no ayamari ga wakatta|Only upon experimenting did the error in the theory become clear.|प्रयोग करने पर ही सिद्धांत की गलती पता चली।
            🏢|この段階に至って、方針を変えるしかなかった。|kono dankai ni itatte, houshin o kaeru shika nakatta|At this stage, there was no choice but to change policy.|इस चरण पर पहुँचकर नीति बदलने के अलावा कोई रास्ता नहीं था।
            🌊|洪水に至って、対策の遅れが問題になった。|kouzui ni itatte, taisaku no okure ga mondai ni natta|Only with the flood did the delayed measures become an issue.|बाढ़ आने पर ही देर से उठाए कदम मुद्दा बने।
        """,

        "jpN1-c" to """
            😂|おかしくて、笑わずにはいられない。|okashikute, warawazu ni wa irarenai|It's so funny I can't help but laugh.|यह इतना मज़ेदार है कि हँसे बिना नहीं रह सकता।
            😢|その映画を見ると、泣かずにはいられない。|sono eiga o miru to, nakazu ni wa irarenai|Whenever I see that film, I can't help but cry.|वह फ़िल्म देखते ही रोए बिना नहीं रहता।
            🍰|このケーキはおいしくて、食べずにはいられない。|kono keeki wa oishikute, tabezu ni wa irarenai|This cake is so good I can't help but eat it.|यह केक इतना स्वादिष्ट है कि खाए बिना नहीं रह सकता।
            😊|彼女の笑顔を見ると、こちらも笑わずにはいられない。|kanojo no egao o miru to, kochira mo warawazu ni wa irarenai|Seeing her smile, I can't help but smile too.|उसकी मुस्कान देखकर मैं भी मुस्कुराए बिना नहीं रहता।
            📢|その知らせを聞いて、喜ばずにはいられなかった。|sono shirase o kiite, yorokobazu ni wa irarenakatta|Hearing the news, I couldn't help but rejoice.|वह ख़बर सुनकर खुश हुए बिना नहीं रहा।
            🤔|彼の話を聞くと、疑わずにはいられない。|kare no hanashi o kiku to, utagawazu ni wa irarenai|Listening to him, I can't help but doubt.|उसकी बातें सुनकर शक किए बिना नहीं रहता।
            😤|不公平なのを見て、怒らずにはいられない。|fukouhei na no o mite, okorazu ni wa irarenai|Seeing the unfairness, I can't help but get angry.|अन्याय देखकर गुस्सा आए बिना नहीं रहता।
            🎵|その歌を聞くと、歌わずにはいられない。|sono uta o kiku to, utawazu ni wa irarenai|Hearing that song, I can't help but sing along.|वह गाना सुनकर गाए बिना नहीं रहता।
            🐶|かわいい子犬を見ると、だきしめずにはいられない。|kawaii koinu o miru to, dakishimezu ni wa irarenai|When I see a cute puppy, I can't help but hug it.|प्यारा पिल्ला देखते ही गले लगाए बिना नहीं रहता।
        """,

        "jpN1-d" to """
            🎓|大学を出たとはいえ、まだまだ勉強が必要だ。|daigaku o deta to wa ie, madamada benkyou ga hitsuyou da|Although I graduated from university, I still need to study a lot.|हालाँकि मैंने विश्वविद्यालय पूरा किया, फिर भी बहुत पढ़ाई बाकी है।
            📅|春とはいえ、まだ寒い日が続く。|haru to wa ie, mada samui hi ga tsuzuku|Although it's spring, cold days continue.|हालाँकि वसंत है, अभी भी ठंडे दिन चल रहे हैं।
            💼|有名な会社とはいえ、給料は高くない。|yuumei na kaisha to wa ie, kyuuryou wa takakunai|Although it's a famous company, the salary isn't high.|हालाँकि यह प्रसिद्ध कंपनी है, वेतन ज़्यादा नहीं है।
            👨|彼はプロとはいえ、失敗することもある。|kare wa puro to wa ie, shippai suru koto mo aru|Even though he's a pro, he sometimes fails.|हालाँकि वह पेशेवर है, कभी-कभी गलती भी करता है।
            🌍|英語とはいえ、方言が強いと通じない。|eigo to wa ie, hougen ga tsuyoi to tsuujinai|Even though it's English, a strong dialect isn't understood.|हालाँकि यह अंग्रेज़ी है, तेज़ बोली समझ नहीं आती।
            🏠|新築とはいえ、値段は手ごろだ。|shinchiku to wa ie, nedan wa tegoro da|Although it's newly built, the price is reasonable.|हालाँकि यह नया बना है, कीमत वाजिब है।
            🎉|休みとはいえ、仕事のメールが来る。|yasumi to wa ie, shigoto no meeru ga kuru|Even though it's a holiday, work emails arrive.|हालाँकि छुट्टी है, काम के ईमेल आते रहते हैं।
            ✈️|安いとはいえ、品質は悪くない。|yasui to wa ie, hinshitsu wa warukunai|Although cheap, the quality isn't bad.|हालाँकि सस्ता है, गुणवत्ता ख़राब नहीं है।
            🧑|若いとはいえ、彼はとても頼りになる。|wakai to wa ie, kare wa totemo tayori ni naru|Although young, he is very reliable.|हालाँकि युवा है, वह बहुत भरोसेमंद है।
        """,

        "jpN1-e" to """
            📱|スマホを手にしたが最後、彼は一日中ずっと見ている。|sumaho o te ni shita ga saigo, kare wa ichinichijuu zutto mite iru|Once he picks up his phone, he stares at it all day.|एक बार फ़ोन उठाया तो वह सारा दिन देखता रहता है।
            🎮|ゲームを始めたが最後、やめられない。|geemu o hajimeta ga saigo, yamerarenai|Once you start the game, you can't stop.|एक बार गेम शुरू किया तो रुक नहीं सकते।
            🍫|チョコを食べたが最後、全部食べてしまう。|choko o tabeta ga saigo, zenbu tabete shimau|Once you eat one chocolate, you end up eating them all.|एक बार चॉकलेट खाई तो सब खत्म।
            💤|寝たが最後、朝まで起きない。|neta ga saigo, asa made okinai|Once he falls asleep, he won't wake until morning.|एक बार सोया तो सुबह तक नहीं उठता।
            🛍️|あの店に入ったが最後、お金を使い果たす。|ano mise ni haitta ga saigo, okane o tsukaihatasu|Once you enter that shop, you spend all your money.|उस दुकान में घुसे तो पूरे पैसे खर्च हो जाते हैं।
            🗣️|彼に話したが最後、秘密は広まる。|kare ni hanashita ga saigo, himitsu wa hiromaru|Once you tell him, the secret spreads.|एक बार उसे बताया तो राज़ फैल जाएगा।
            📺|ドラマを見始めたが最後、夜更かししてしまう。|dorama o mihajimeta ga saigo, yofukashi shite shimau|Once you start the drama, you end up staying up late.|एक बार ड्रामा शुरू किया तो देर रात तक जागते हैं।
            🚗|高速に乗ったが最後、降りるまで一時間かかる。|kousoku ni notta ga saigo, oriru made ichijikan kakaru|Once you get on the highway, it takes an hour to get off.|एक बार हाईवे पर चढ़े तो उतरने में घंटा लगता है।
            😴|布団に入ったが最後、すぐ眠ってしまう。|futon ni haitta ga saigo, sugu nemutte shimau|Once you get into bed, you fall asleep at once.|एक बार बिस्तर में घुसे तो तुरंत सो जाते हैं।
        """,

        "jpN1-f" to """
            👏|会場は割れんばかりの拍手に包まれた。|kaijou wa waren bakari no hakushu ni tsutsumareta|The hall was filled with applause as if it would burst.|सभागार फटने जैसी तालियों से गूँज उठा।
            😤|彼は泣き出さんばかりの顔をしていた。|kare wa nakidasan bakari no kao o shite ita|He looked as if he was about to cry.|वह रोने ही वाला चेहरा बनाए था।
            🌊|波が今にも船を飲み込まんばかりだった。|nami ga ima ni mo fune o nomikoman bakari datta|The waves looked as if they would swallow the ship any moment.|लहरें किसी भी पल नाव को निगलने वाली लग रही थीं।
            🏆|彼は飛び上がらんばかりに喜んだ。|kare wa tobiagaran bakari ni yorokonda|He rejoiced as if he would jump up.|वह उछल पड़ने जैसी खुशी से झूम उठा।
            🗣️|彼女は言葉を飲み込まんばかりに黙っていた。|kanojo wa kotoba o nomikoman bakari ni damatte ita|She stayed silent as if about to swallow her words.|वह शब्द निगलने वाली मुद्रा में चुप रही।
            😡|今にも怒り出さんばかりの表情だった。|ima ni mo okoridasan bakari no hyoujou datta|His expression was as if he would burst out in anger any moment.|उसका चेहरा अभी गुस्से से फट पड़ने वाला था।
            💔|胸が張り裂けんばかりの悲しみだった。|mune ga harisaken bakari no kanashimi datta|It was a grief as if my chest would burst.|यह ऐसा दुःख था जैसे सीना फट जाए।
            🎉|会場は揺れんばかりに盛り上がった。|kaijou wa yuren bakari ni moriagatta|The venue got so excited it seemed to shake.|सभागार हिल उठने जैसा उत्साहित हो गया।
            🥇|彼は今にも倒れんばかりに走った。|kare wa ima ni mo taoren bakari ni hashitta|He ran as if about to collapse.|वह गिर पड़ने वाली हालत में दौड़ा।
        """,

        "jpN1-g" to """
            🎓|先生ともあろう人が、そんなミスをするとは。|sensei to mo arou hito ga, sonna misu o suru to wa|For a person of the caliber of a teacher to make such a mistake…|शिक्षक जैसे व्यक्ति से ऐसी गलती?
            🏢|社長ともあろう者が、約束を破るなんてありえない。|shachou to mo arou mono ga, yakusoku o yaburu nante arienai|It's unthinkable that a president would break a promise.|अध्यक्ष जैसा व्यक्ति वादा तोड़े, यह असंभव है।
            👑|王ともあろう者が、民を見捨てるのか。|ou to mo arou mono ga, tami o misuteru no ka|Would a king abandon his people?|राजा जैसा व्यक्ति प्रजा को छोड़ देगा?
            ⚖️|弁護士ともあろう者が、法を無視するとは。|bengoshi to mo arou mono ga, hou o mushi suru to wa|For a lawyer to ignore the law…|वकील जैसा व्यक्ति कानून की अनदेखी करे?
            🩺|医者ともあろう者が、そんなことを言うべきではない。|isha to mo arou mono ga, sonna koto o iu beki dewa nai|A doctor of all people should not say such things.|डॉक्टर जैसे व्यक्ति को ऐसा नहीं कहना चाहिए।
            🎖️|将軍ともあろう者が、作戦を間違えるとは。|shougun to mo arou mono ga, sakusen o machigaeru to wa|For a general to make a mistake in strategy…|जनरल जैसा व्यक्ति रणनीति में गलती करे?
            🧑‍🏫|プロともあろう者が、こんな簡単なことを知らないのか。|puro to mo arou mono ga, konna kantan na koto o shiranai no ka|A pro doesn't know something this simple?|पेशेवर को इतनी आसान बात नहीं पता?
            🏛️|政治家ともあろう者が、国民をだますとは許されない。|seijika to mo arou mono ga, kokumin o damasu to wa yurusarenai|A politician must not deceive the people.|राजनेता का जनता को धोखा देना स्वीकार्य नहीं।
            📰|記者ともあろう者が、事実を確認しないとは。|kisha to mo arou mono ga, jijitsu o kakunin shinai to wa|For a journalist not to verify the facts…|पत्रकार जैसा व्यक्ति तथ्य जाँचे बिना?
        """,

        "jpN1-h" to """
            🚫|これは教師にあるまじき行為だ。|kore wa kyoushi ni aru majiki koui da|This is conduct unbecoming of a teacher.|यह शिक्षक के योग्य नहीं है।
            ⚖️|許すまじき犯罪だ。|yurusu majiki hanzai da|It is an unforgivable crime.|यह अक्षम्य अपराध है।
            🏢|リーダーにあるまじき発言だった。|riidaa ni aru majiki hatsugen datta|It was a remark unbecoming of a leader.|यह नेता के योग्य नहीं था।
            🩺|医者にあるまじき態度だ。|isha ni aru majiki taido da|An attitude unbecoming of a doctor.|डॉक्टर के योग्य नहीं रवैया।
            🎓|学生にあるまじき遅刻だ。|gakusei ni aru majiki chikoku da|Tardiness unbecoming of a student.|विद्यार्थी के योग्य नहीं देरी।
            🏛️|政治家にあるまじき失言だった。|seijika ni aru majiki shitsugen datta|A gaffe unbecoming of a politician.|राजनेता के योग्य नहीं बयान।
            🚗|プロにあるまじきミスだ。|puro ni aru majiki misu da|A mistake unbecoming of a pro.|पेशेवर के योग्य नहीं गलती।
            🙅|あってはならない、許すまじきことだ。|atte wa naranai, yurusu majiki koto da|It must not happen; it is unforgivable.|यह नहीं होना चाहिए, अक्षम्य है।
            📰|記者にあるまじき行動だ。|kisha ni aru majiki koudou da|Conduct unbecoming of a journalist.|पत्रकार के योग्य नहीं व्यवहार।
        """,

        "jpN2-a" to """
            🌙|この店は昼夜を問わず開いている。|kono mise wa chuuya o towazu aite iru|This shop is open regardless of day or night.|यह दुकान दिन-रात खुली रहती है।
            📅|経験の有無を問わず、応募できます。|keiken no umu o towazu, oubo dekimasu|You can apply regardless of experience.|तजुर्बे की परवाह किए बिना आवेदन कर सकते हैं।
            🧑|年齢を問わず、参加は自由です。|nenrei o towazu, sanka wa jiyuu desu|Participation is free regardless of age.|उम्र की परवाह किए बिना भाग लेना स्वतंत्र है।
            🌍|国籍を問わず、社員を募集しています。|kokuseki o towazu, shain o boshuu shite imasu|We are hiring regardless of nationality.|राष्ट्रीयता की परवाह किए बिना कर्मचारी चाहिए।
            🎓|学歴を問わず、実力が大切だ。|gakureki o towazu, jitsuryoku ga taisetsu da|Regardless of education, ability matters.|शिक्षा की परवाह किए बिना योग्यता मायने रखती है।
            👕|サイズを問わず、この色が人気だ。|saizu o towazu, kono iro ga ninki da|Regardless of size, this color is popular.|साइज़ की परवाह किए बिना यह रंग लोकप्रिय है।
            🚗|天候を問わず、試合は行われます。|tenkou o towazu, shiai wa okonawaremasu|The match will be held regardless of the weather.|मौसम की परवाह किए बिना मैच होगा।
        """,

        "jpN2-b" to """
            🐕|犬に限らず、猫も人気があります。|inu ni kagirazu, neko mo ninki ga arimasu|Not only dogs, but cats are also popular.|कुत्तों ही नहीं, बिल्लियाँ भी लोकप्रिय हैं।
            🎓|学生に限らず、社会人も学べます。|gakusei ni kagirazu, shakaijin mo manabemasu|Not only students, working people can learn too.|विद्यार्थियों ही नहीं, कामकाजी लोग भी सीख सकते हैं।
            🇯🇵|東京に限らず、地方でも人口が減っている。|Toukyou ni kagirazu, chihou demo jinkou ga hette iru|Not only Tokyo, the population is falling in rural areas too.|टोक्यो ही नहीं, ग्रामीण इलाकों में भी आबादी घट रही है।
            🍜|ラーメンに限らず、日本の料理は人気だ。|raamen ni kagirazu, nihon no ryouri wa ninki da|Not only ramen, Japanese food in general is popular.|रामेन ही नहीं, जापानी खाना भी लोकप्रिय है।
            📱|若者に限らず、お年寄りもスマホを使う。|wakamono ni kagirazu, toshiyori mo sumaho o tsukau|Not only young people, the elderly use smartphones too.|युवाओं ही नहीं, बुज़ुर्ग भी स्मार्टफ़ोन इस्तेमाल करते हैं।
            🎵|クラシックに限らず、どんな音楽も好きだ。|kurashikku ni kagirazu, donna ongaku mo suki da|Not only classical, I like all kinds of music.|क्लासिकल ही नहीं, मुझे हर तरह का संगीत पसंद है।
            ⚽|サッカーに限らず、スポーツは体にいい。|sakkaa ni kagirazu, supootsu wa karada ni ii|Not only football, sports in general are good for you.|फ़ुटबॉल ही नहीं, खेल आम तौर पर सेहत के लिए अच्छे हैं।
            🚉|この問題は都会に限らず、田舎でも起きている。|kono mondai wa tokai ni kagirazu, inaka demo okite iru|This problem occurs not only in cities but in the countryside too.|यह समस्या शहरों ही नहीं, गाँवों में भी होती है।
        """,

        "jpN2-c" to """
            📈|経済が発展するにしたがって、生活も豊かになった。|keizai ga hatten suru ni shitagatte, seikatsu mo yutaka ni natta|As the economy developed, life became richer too.|जैसे-जैसे अर्थव्यवस्था बढ़ी, जीवन भी समृद्ध हुआ।
            🌡️|春になるにつれて、暖かくなってきた。|haru ni naru ni tsurete, atatakaku natte kita|As spring came, it got warmer.|जैसे-जैसे वसंत आया, मौसम गर्म होता गया।
            👶|子供が大きくなるにつれて、心配も増える。|kodomo ga ookiku naru ni tsurete, shinpai mo fueru|As children grow, worries increase too.|जैसे-जैसे बच्चे बड़े होते हैं, चिंताएँ बढ़ती हैं।
            📚|勉強が進むにしたがって、難しくなる。|benkyou ga susumu ni shitagatte, muzukashiku naru|As the studies progress, it gets harder.|जैसे-जैसे पढ़ाई आगे बढ़ती है, कठिन होती जाती है।
            🏙️|人口が増えるにしたがって、家賃も上がった。|jinkou ga fueru ni shitagatte, yachin mo agatta|As the population grew, rents rose too.|जैसे-जैसे आबादी बढ़ी, किराया भी बढ़ा।
            🌙|夜が更けるにつれて、静かになった。|yoru ga fukeru ni tsurete, shizuka ni natta|As the night deepened, it became quiet.|जैसे-जैसे रात गहरी हुई, शांति छा गई।
            💪|練習を重ねるにつれて、上手になった。|renshuu o kasaneru ni tsurete, jouzu ni natta|As I practiced more, I got better.|जैसे-जैसे अभ्यास बढ़ा, मैं बेहतर होता गया।
            ⏳|時がたつにしたがって、記憶も薄れた。|toki ga tatsu ni shitagatte, kioku mo usureta|As time passed, the memory faded too.|जैसे-जैसे समय बीता, यादें भी धूमिल हुईं।
        """,

        "jpN2-d" to """
            📝|契約する上で、よく確認してください。|keiyaku suru ue de, yoku kakunin shite kudasai|When signing the contract, please check carefully.|अनुबंध करते समय ध्यान से जाँचें।
            🎓|留学する上で、語学力は必要だ。|ryuugaku suru ue de, gogakuryoku wa hitsuyou da|In studying abroad, language ability is necessary.|विदेश पढ़ाई के लिए भाषा-ज्ञान ज़रूरी है।
            🏢|決めた上は、最後までやりなさい。|kimeta ue wa, saigo made yarinasai|Now that you've decided, see it through.|तय कर लिया है तो अंत तक करो।
            💼|約束した上は、守らなければならない。|yakusoku shita ue wa, mamoranakereba naranai|Now that you promised, you must keep it.|वादा किया है तो निभाना पड़ेगा।
            📖|本を選ぶ上で、表紙だけで決めないほうがいい。|hon o erabu ue de, hyoushi dake de kimenai hou ga ii|When choosing a book, don't decide by the cover alone.|किताब चुनते समय सिर्फ़ कवर से तय न करें।
            🚗|車を買う上で、保険も考えなければならない。|kuruma o kau ue de, hoken mo kangaenakereba naranai|When buying a car, you must consider insurance too.|कार खरीदते समय बीमा भी सोचना पड़ता है।
            🩺|手術を受ける上では、家族の同意が必要だ。|shujutsu o ukeru ue de wa, kazoku no doui ga hitsuyou da|In having surgery, family consent is needed.|ऑपरेशन के लिए परिवार की सहमति ज़रूरी है।
            📜|引き受けた上は、途中でやめられない。|hikiuketa ue wa, tochuu de yamerarenai|Once you've taken it on, you can't quit midway.|एक बार काम लिया तो बीच में छोड़ नहीं सकते।
        """,

        "jpN2-e" to """
            🧑‍🏫|彼は教師として働いている。|kare wa kyoushi to shite hataraite iru|He works as a teacher.|वह शिक्षक के रूप में काम करता है।
            🎁|これは誕生日プレゼントとしてもらった。|kore wa tanjoubi purezento to shite moratta|I received this as a birthday present.|मुझे यह जन्मदिन के उपहार के रूप में मिला।
            🌍|日本語は外国語として人気がある。|nihongo wa gaikokugo to shite ninki ga aru|Japanese is popular as a foreign language.|जापानी विदेशी भाषा के रूप में लोकप्रिय है।
            💼|彼女は代表として会議に出た。|kanojo wa daihyou to shite kaigi ni deta|She attended the meeting as a representative.|वह प्रतिनिधि के रूप में बैठक में गई।
            🏆|この寺は文化財として保護されている。|kono tera wa bunkazai to shite hogo sarete iru|This temple is protected as a cultural asset.|यह मंदिर सांस्कृतिक धरोहर के रूप में संरक्षित है।
            📚|参考書としてこの本を使っています。|sankousho to shite kono hon o tsukatte imasu|I use this book as a reference.|मैं इस किताब को संदर्भ के रूप में इस्तेमाल करता हूँ।
            🎓|学生として、まず勉強が本分だ。|gakusei to shite, mazu benkyou ga honbun da|As a student, studying comes first.|विद्यार्थी के रूप में पहले पढ़ाई कर्तव्य है।
            ⚽|彼はキャプテンとしてチームをまとめた。|kare wa kyaputen to shite chiimu o matometa|He led the team as captain.|उसने कप्तान के रूप में टीम संभाली।
        """,

        "jpN2-f" to """
            🧑|私にとって、家族が一番大切です。|watashi ni totte, kazoku ga ichiban taisetsu desu|For me, family is the most important.|मेरे लिए परिवार सबसे अहम है।
            🎓|学生にとって、試験は大きなストレスだ。|gakusei ni totte, shiken wa ookina sutoresu da|For students, exams are a big stress.|विद्यार्थियों के लिए परीक्षा बड़ा तनाव है।
            🇯🇵|外国人にとって、漢字は難しい。|gaikokujin ni totte, kanji wa muzukashii|For foreigners, kanji is difficult.|विदेशियों के लिए कांजी कठिन है।
            🌍|地球にとって、二酸化炭素は脅威だ。|chikyuu ni totte, nisanka tanso wa kyoui da|For the Earth, carbon dioxide is a threat.|पृथ्वी के लिए कार्बन डाइऑक्साइड ख़तरा है।
            🏢|会社にとって、人材が一番の財産だ。|kaisha ni totte, jinzai ga ichiban no zaisan da|For a company, people are its greatest asset.|कंपनी के लिए लोग सबसे बड़ी संपत्ति हैं।
            🐕|犬にとって、散歩は楽しみだ。|inu ni totte, sanpo wa tanoshimi da|For a dog, walks are a joy.|कुत्ते के लिए टहलना आनंद है।
            📱|私にとって、スマホは欠かせない。|watashi ni totte, sumaho wa kakasenai|For me, a smartphone is indispensable.|मेरे लिए स्मार्टफ़ोन अनिवार्य है।
            ❄️|北の人にとって、雪は普通のことだ。|kita no hito ni totte, yuki wa futsuu no koto da|For northern people, snow is normal.|उत्तर के लोगों के लिए बर्फ़ सामान्य है।
        """,

        "jpN2-g" to """
            📋|この件に関して、後で連絡します。|kono ken ni kanshite, ato de renraku shimasu|Regarding this matter, I'll contact you later.|इस मामले के संबंध में बाद में संपर्क करूँगा।
            🌍|環境問題に関して、会議が開かれた。|kankyou mondai ni kanshite, kaigi ga hirakareta|A meeting was held regarding environmental issues.|पर्यावरण मुद्दों पर बैठक हुई।
            📊|売上に関して、報告書を提出してください。|uriage ni kanshite, houkokusho o teishutsu shite kudasai|Please submit a report regarding sales.|बिक्री के संबंध में रिपोर्ट जमा करें।
            🩺|健康に関して、医者に相談した。|kenkou ni kanshite, isha ni soudan shita|I consulted a doctor regarding my health.|सेहत के बारे में डॉक्टर से सलाह ली।
            📚|この本に関して、質問がありますか。|kono hon ni kanshite, shitsumon ga arimasu ka|Do you have questions regarding this book?|इस किताब के बारे में कोई सवाल?
            ⚖️|法律に関して、専門家に聞くべきだ。|houritsu ni kanshite, senmonka ni kiku beki da|Regarding the law, you should ask an expert.|कानून के बारे में विशेषज्ञ से पूछें।
            🚉|工事に関して、お知らせがあります。|kouji ni kanshite, oshirase ga arimasu|There is an announcement regarding the construction.|निर्माण के संबंध में सूचना है।
            🎓|留学に関して、先輩に話を聞いた。|ryuugaku ni kanshite, senpai ni hanashi o kiita|I asked a senior about studying abroad.|विदेश पढ़ाई के बारे में सीनियर से पूछा।
        """,

        "jpN2-h" to """
            📚|彼は英語ばかりか、中国語も話せる。|kare wa eigo bakari ka, chuugokugo mo hanaseru|He can speak not only English but Chinese too.|वह अंग्रेज़ी ही नहीं, चीनी भी बोल सकता है।
            🌧️|雨ばかりか、風も強くなってきた。|ame bakari ka, kaze mo tsuyoku natte kita|Not only rain, the wind has gotten stronger too.|बारिश ही नहीं, हवा भी तेज़ हो गई।
            🍜|彼は料理がうまいばかりか、掃除も得意だ。|kare wa ryouri ga umai bakari ka, souji mo tokui da|He's not only good at cooking, he's good at cleaning too.|वह खाना बनाने ही नहीं, सफ़ाई में भी माहिर है।
            📱|そのスマホは安いばかりか、性能もいい。|sono sumaho wa yasui bakari ka, seinou mo ii|That phone is not only cheap but performs well.|वह फ़ोन सस्ता ही नहीं, बेहतर भी है।
            🏆|彼女は歌ばかりか、ダンスも上手だ。|kanojo wa uta bakari ka, dansu mo jouzu da|She's not only good at singing, she dances well too.|वह गाने ही नहीं, नाचने में भी अच्छी है।
            🩺|運動不足は体ばかりか、心にも悪い。|undou busoku wa karada bakari ka, kokoro ni mo warui|Lack of exercise is bad not only for the body but the mind.|व्यायाम की कमी शरीर ही नहीं, मन के लिए भी हानिकारक है।
            🚗|その車は速いばかりか、燃費もいい。|sono kuruma wa hayai bakari ka, nenpi mo ii|That car is not only fast but fuel-efficient too.|वह कार तेज़ ही नहीं, ईंधन-कुशल भी है।
            🎓|彼は頭がいいばかりか、努力もする。|kare wa atama ga ii bakari ka, doryoku mo suru|He's not only smart but hardworking too.|वह बुद्धिमान ही नहीं, मेहनती भी है।
        """,

        "jpN3-a" to """
            ☂️|雨が降れば、試合は中止です。|ame ga fureba, shiai wa chuushi desu|If it rains, the match is cancelled.|अगर बारिश होगी तो मैच रद्द होगा।
            💰|お金があれば、旅行します。|okane ga areba, ryokou shimasu|If I have money, I'll travel.|अगर पैसे होंगे तो यात्रा करूँगा।
            🕐|時間があれば、手伝います。|jikan ga areba, tetsudaimasu|If I have time, I'll help.|अगर समय हुआ तो मदद करूँगा।
            📚|もっと勉強すれば、受かりますよ。|motto benkyou sureba, ukarimasu yo|If you study more, you'll pass.|और पढ़ोगे तो पास हो जाओगे।
            🚗|車があれば、便利です。|kuruma ga areba, benri desu|If you have a car, it's convenient.|अगर कार हो तो सुविधा रहती है।
            🍎|安ければ、買います。|yasukereba, kaimasu|If it's cheap, I'll buy it.|अगर सस्ता होगा तो खरीदूँगा।
            🧑|彼がいなければ、困ります。|kare ga inakereba, komarimasu|If he weren't here, I'd be in trouble.|अगर वह न हो तो मुश्किल होगी।
        """,

        "jpN3-b" to """
            🍰|ケーキを全部食べてしまいました。|keeki o zenbu tabete shimaimashita|I ended up eating the whole cake.|मैंने पूरा केक खा लिया।
            📱|スマホを落としてしまった。|sumaho o otoshite shimatta|I dropped my phone (oops).|मैंने फ़ोन गिरा दिया।
            💸|お金を使い果たしてしまった。|okane o tsukaihatashite shimatta|I ended up spending all my money.|मैंने सारे पैसे खर्च कर दिए।
            😴|テレビを見ながら寝てしまった。|terebi o minagara nete shimatta|I fell asleep while watching TV.|टीवी देखते-देखते सो गया।
            📚|宿題を忘れてしまいました。|shukudai o wasurete shimaimashita|I forgot my homework (unfortunately).|मैं गृहकार्य भूल गया।
            🚃|電車に乗り遅れてしまった。|densha ni noriokurete shimatta|I ended up missing the train.|मैं ट्रेन से छूट गया।
            🧹|部屋をきれいに片づけてしまった。|heya o kirei ni katadzukete shimatta|I finished cleaning up the room completely.|मैंने कमरा पूरी तरह साफ़ कर दिया।
        """,

        "jpN3-c" to """
            🎓|留学するために、お金をためています。|ryuugaku suru tame ni, okane o tamete imasu|I'm saving money in order to study abroad.|विदेश पढ़ने के लिए मैं पैसे जोड़ रहा हूँ।
            🏃|健康のために、毎朝走っています。|kenkou no tame ni, maiasa hashitte imasu|I run every morning for my health.|सेहत के लिए मैं हर सुबह दौड़ता हूँ।
            🌧️|台風のために、電車が止まった。|taifuu no tame ni, densha ga tomatta|Because of the typhoon, the trains stopped.|तूफ़ान के कारण ट्रेनें रुक गईं।
            📚|試験に合格するために、勉強しています。|shiken ni goukaku suru tame ni, benkyou shite imasu|I'm studying in order to pass the exam.|परीक्षा पास करने के लिए मैं पढ़ रहा हूँ।
            💼|家族のために、働いています。|kazoku no tame ni, hataraite imasu|I work for my family.|मैं परिवार के लिए काम करता हूँ।
            🚗|事故のために、道が混んでいる。|jiko no tame ni, michi ga konde iru|Because of an accident, the road is crowded.|दुर्घटना के कारण सड़क जाम है।
            🇯🇵|日本語を学ぶために、日本へ行きます。|nihongo o manabu tame ni, nihon e ikimasu|I'll go to Japan in order to learn Japanese.|जापानी सीखने के लिए मैं जापान जाऊँगा।
        """,

        "jpN3-d" to """
            🚌|彼はもう着いているはずです。|kare wa mou tsuite iru hazu desu|He should have arrived already.|वह अब तक पहुँच चुका होगा।
            📦|荷物は今日届くはずです。|nimotsu wa kyou todoku hazu desu|The package should arrive today.|पैकेज आज पहुँचना चाहिए।
            🕐|彼女は時間どおりに来るはずだ。|kanojo wa jikan doori ni kuru hazu da|She should come on time.|वह समय पर आनी चाहिए।
            ❓|そんなはずはない。|sonna hazu wa nai|That can't be true.|ऐसा नहीं हो सकता।
            ✈️|飛行機は九時に出るはずです。|hikouki wa kuji ni deru hazu desu|The plane should leave at nine.|विमान नौ बजे उड़ना चाहिए।
            📝|答えはこの本に書いてあるはずだ。|kotae wa kono hon ni kaite aru hazu da|The answer should be written in this book.|जवाब इस किताब में लिखा होना चाहिए।
            🧑|彼は知っているはずです。|kare wa shitte iru hazu desu|He should know.|उसे पता होना चाहिए।
        """,

        "jpN3-e" to """
            🇯🇵|日本語が話せるようになりました。|nihongo ga hanaseru you ni narimashita|I've become able to speak Japanese.|मैं जापानी बोलने लगा हूँ।
            🏃|毎朝走るようになりました。|maiasa hashiru you ni narimashita|I've started running every morning.|मैं हर सुबह दौड़ने लगा हूँ।
            🍵|お茶を飲むようになりました。|ocha o nomu you ni narimashita|I've come to drink tea.|मैं चाय पीने लगा हूँ।
            📚|本をよく読むようになった。|hon o yoku yomu you ni natta|I've come to read books often.|मैं अब अक्सर किताबें पढ़ने लगा हूँ।
            🥢|箸が使えるようになりました。|hashi ga tsukaeru you ni narimashita|I've become able to use chopsticks.|मैं चॉपस्टिक चलाने लगा हूँ।
            🌙|早く寝るようになりました。|hayaku neru you ni narimashita|I've started going to bed early.|मैं जल्दी सोने लगा हूँ।
            🎵|音楽を作るようになった。|ongaku o tsukuru you ni natta|I've come to make music.|मैं संगीत बनाने लगा हूँ।
        """,

        "jpN3-f" to """
            📖|この本は多くの人に読まれている。|kono hon wa ooku no hito ni yomarete iru|This book is read by many people.|यह किताब बहुत लोग पढ़ते हैं।
            🏠|家は祖父によって建てられました。|ie wa sofu ni yotte tateraremashita|The house was built by my grandfather.|घर मेरे दादा ने बनाया था।
            🍰|ケーキが子供たちに食べられた。|keeki ga kodomotachi ni taberareta|The cake was eaten by the children.|केक बच्चों ने खा लिया।
            😅|彼に笑われました。|kare ni warawaremashita|I was laughed at by him.|वह मुझ पर हँसा।
            🏛️|この寺は百年以上前に建てられた。|kono tera wa hyakunen ijou mae ni taterareta|This temple was built over a hundred years ago.|यह मंदिर सौ साल से पहले बना था।
            📱|スマホは世界中で使われている。|sumaho wa sekaijuu de tsukawarete iru|Smartphones are used all over the world.|स्मार्टफ़ोन पूरी दुनिया में इस्तेमाल होते हैं।
            🗣️|その話はみんなに知られている。|sono hanashi wa minna ni shirarete iru|That story is known to everyone.|वह कहानी सबको पता है।
        """,

        "jpN3-g" to """
            📈|人口はこれからも増えていくでしょう。|jinkou wa kore kara mo fuete iku deshou|The population will keep increasing from now on.|आबादी आगे भी बढ़ती जाएगी।
            🌙|だんだん暗くなってきた。|dandan kuraku natte kita|It has gradually gotten dark.|धीरे-धीरे अंधेरा होने लगा।
            🏃|走っていった。|hashitte itta|He ran off (away).|वह दौड़कर चला गया।
            🚶|友達が歩いてきた。|tomodachi ga aruite kita|My friend came walking (toward me).|दोस्त पैदल आया।
            📚|これからも勉強を続けていきます。|kore kara mo benkyou o tsudzukete ikimasu|I'll keep studying from now on.|मैं आगे भी पढ़ता रहूँगा।
            🌸|春になると、花が咲いてくる。|haru ni naru to, hana ga saite kuru|When spring comes, flowers come into bloom.|वसंत आते ही फूल खिलने लगते हैं।
            🍲|料理ができてきた。|ryouri ga dekite kita|The food has been getting ready.|खाना बनकर तैयार होने लगा।
        """,

        "jpN3-h" to """
            🍬|彼はお菓子ばかり食べている。|kare wa okashi bakari tabete iru|He eats nothing but sweets.|वह सिर्फ़ मिठाइयाँ खाता है।
            📱|一日中スマホばかり見ている。|ichinichijuu sumaho bakari mite iru|I stare at my phone all day.|मैं सारा दिन बस फ़ोन देखता हूँ।
            🚗|さっき帰ったばかりです。|sakki kaetta bakari desu|He just went home a moment ago.|वह अभी थोड़ी देर पहले गया।
            😢|泣いてばかりでは、何も変わらない。|naite bakari de wa, nanimo kawaranai|Just crying won't change anything.|सिर्फ़ रोने से कुछ नहीं बदलेगा।
            🎮|彼はゲームばかりしている。|kare wa geemu bakari shite iru|He does nothing but play games.|वह बस गेम खेलता रहता है।
            ☕|コーヒーばかり飲んでいると、体に悪い。|koohii bakari nonde iru to, karada ni warui|Drinking only coffee is bad for you.|सिर्फ़ कॉफ़ी पीना सेहत के लिए बुरा है।
            🎓|今、大学を卒業したばかりです。|ima, daigaku o sotsugyou shita bakari desu|I just graduated from university.|मैंने अभी-अभी विश्वविद्यालय पूरा किया।
        """,

        "jpN3-i" to """
            😊|うれしいことに、試験に合格した。|ureshii koto ni, shiken ni goukaku shita|To my joy, I passed the exam.|खुशी की बात है कि मैं परीक्षा में पास हुआ।
            😢|残念なことに、試合は中止になった。|zannen na koto ni, shiai wa chuushi ni natta|Unfortunately, the match was cancelled.|दुख की बात है कि मैच रद्द हो गया।
            😮|驚いたことに、彼は一人で来た。|odoroita koto ni, kare wa hitori de kita|To my surprise, he came alone.|आश्चर्य की बात है कि वह अकेला आया।
            😊|幸いなことに、けがはなかった。|saiwai na koto ni, kega wa nakatta|Fortunately, there were no injuries.|अच्छी बात है कि कोई चोट नहीं थी।
            😞|悲しいことに、彼は引っ越してしまった。|kanashii koto ni, kare wa hikkoshite shimatta|Sadly, he moved away.|दुखद बात है कि वह चला गया।
            😲|不思議なことに、鍵が開いていた。|fushigi na koto ni, kagi ga aite ita|Strangely, the lock was open.|अजीब बात है कि ताला खुला था।
            😊|ありがたいことに、みんな手伝ってくれた。|arigatai koto ni, minna tetsudatte kureta|Thankfully, everyone helped me.|शुक्र की बात है कि सबने मदद की।
        """,

        "jpN3-j" to """
            🏃|毎朝走ることにしています。|maiasa hashiru koto ni shite imasu|I make it a rule to run every morning.|मैं हर सुबह दौड़ने का नियम रखता हूँ।
            ☕|朝はコーヒーを飲むことにしている。|asa wa koohii o nomu koto ni shite iru|I make it a rule to drink coffee in the morning.|मैं सुबह कॉफ़ी पीने का नियम रखता हूँ।
            📱|寝る前にスマホを見ないことにしています。|neru mae ni sumaho o minai koto ni shite imasu|I make it a rule not to look at my phone before bed.|मैं सोने से पहले फ़ोन न देखने का नियम रखता हूँ।
            🍎|毎日果物を食べることにしています。|mainichi kudamono o taberu koto ni shite imasu|I make it a rule to eat fruit every day.|मैं हर दिन फल खाने का नियम रखता हूँ।
            💰|毎月お金をためることにしている。|maitsuki okane o tameru koto ni shite iru|I make it a rule to save money every month.|मैं हर महीने पैसे बचाने का नियम रखता हूँ।
            📚|寝る前に本を読むことにしています。|neru mae ni hon o yomu koto ni shite imasu|I make it a rule to read before sleeping.|मैं सोने से पहले पढ़ने का नियम रखता हूँ।
            🚭|たばこを吸わないことにしている。|tabako o suwanai koto ni shite iru|I make it a rule not to smoke.|मैं धूम्रपान न करने का नियम रखता हूँ।
        """,

        "jpN4-a" to """
            🇯🇵|日本へ行ったことがあります。|nihon e itta koto ga arimasu|I have been to Japan.|मैं जापान जा चुका हूँ।
            🍣|すしを食べたことがあります。|sushi o tabeta koto ga arimasu|I have eaten sushi.|मैं सुशी खा चुका हूँ।
            🗻|富士山に登ったことがあります。|fujisan ni nobotta koto ga arimasu|I have climbed Mount Fuji.|मैं माउंट फ़ूजी पर चढ़ चुका हूँ।
            🐘|動物園で象を見たことがあります。|doubutsuen de zou o mita koto ga arimasu|I have seen an elephant at the zoo.|मैंने चिड़ियाघर में हाथी देखा है।
            ❌|一度も海外へ行ったことがありません。|ichido mo kaigai e itta koto ga arimasen|I have never been abroad.|मैं कभी विदेश नहीं गया।
            🎤|カラオケで歌ったことがありますか。|karaoke de utatta koto ga arimasu ka|Have you ever sung at karaoke?|क्या तुमने कभी कराओके में गाया है?
            🚗|この車に乗ったことがあります。|kono kuruma ni notta koto ga arimasu|I have ridden in this car before.|मैं इस कार में बैठ चुका हूँ।
        """,

        "jpN4-b" to """
            🚭|ここでたばこを吸ってはいけません。|koko de tabako o sutte wa ikemasen|You must not smoke here.|यहाँ धूम्रपान नहीं करना चाहिए।
            🚫|ここに入ってはいけません。|koko ni haitte wa ikemasen|You must not enter here.|यहाँ अंदर नहीं जाना चाहिए।
            🍽️|授業中に食べてはいけません。|jugyouchuu ni tabete wa ikemasen|You must not eat during class.|कक्षा के दौरान नहीं खाना चाहिए।
            📱|運転中に電話してはいけません。|untenchuu ni denwa shite wa ikemasen|You must not talk on the phone while driving.|गाड़ी चलाते समय फ़ोन नहीं करना चाहिए।
            🏃|廊下を走ってはいけません。|rouka o hashitte wa ikemasen|You must not run in the hallway.|गलियारे में नहीं दौड़ना चाहिए।
            📷|ここで写真を撮ってはいけません。|koko de shashin o totte wa ikemasen|You must not take photos here.|यहाँ फ़ोटो नहीं लेनी चाहिए।
            🗑️|ここにごみを捨ててはいけません。|koko ni gomi o sutete wa ikemasen|You must not throw garbage here.|यहाँ कूड़ा नहीं डालना चाहिए।
        """,

        "jpN4-c" to """
            📝|今日は来なくてもいいです。|kyou wa konakute mo ii desu|You don't have to come today.|आज आने की ज़रूरत नहीं है।
            💰|お金を払わなくてもいいです。|okane o harawanakute mo ii desu|You don't have to pay.|पैसे देने की ज़रूरत नहीं है।
            🍽️|全部食べなくてもいいです。|zenbu tabenakute mo ii desu|You don't have to eat everything.|सब खाने की ज़रूरत नहीं है।
            🕐|早く起きなくてもいいです。|hayaku okinakute mo ii desu|You don't have to get up early.|जल्दी उठने की ज़रूरत नहीं है।
            📚|宿題をしなくてもいいですか。|shukudai o shinakute mo ii desu ka|Do I not have to do my homework?|क्या मुझे गृहकार्य नहीं करना है?
            🧹|掃除しなくてもいいですよ。|souji shinakute mo ii desu yo|You don't need to clean.|सफ़ाई की ज़रूरत नहीं है।
            👔|スーツを着なくてもいいです。|suutsu o kinakute mo ii desu|You don't have to wear a suit.|सूट पहनने की ज़रूरत नहीं है।
        """,

        "jpN4-d" to """
            🇯🇵|私は日本語を話すことができます。|watashi wa nihongo o hanasu koto ga dekimasu|I can speak Japanese.|मैं जापानी बोल सकता हूँ।
            🏊|彼は泳ぐことができます。|kare wa oyogu koto ga dekimasu|He can swim.|वह तैर सकता है।
            🎹|ピアノが弾けます。|piano ga hikemasu|I can play the piano.|मैं पियानो बजा सकता हूँ।
            🚗|車を運転できますか。|kuruma o unten dekimasu ka|Can you drive?|क्या तुम गाड़ी चला सकते हो?
            📚|漢字が読めます。|kanji ga yomemasu|I can read kanji.|मैं कांजी पढ़ सकता हूँ।
            🥢|箸を使うことができません。|hashi o tsukau koto ga dekimasen|I can't use chopsticks.|मैं चॉपस्टिक नहीं चला सकता।
            🍳|料理ができます。|ryouri ga dekimasu|I can cook.|मैं खाना बना सकता हूँ।
        """,

        "jpN4-e" to """
            🎵|音楽を聞きながら、勉強します。|ongaku o kikinagara, benkyou shimasu|I study while listening to music.|मैं संगीत सुनते हुए पढ़ता हूँ।
            ☕|コーヒーを飲みながら、話しましょう。|koohii o nominagara, hanashimashou|Let's talk while drinking coffee.|कॉफ़ी पीते-पीते बात करें।
            🚶|歩きながらスマホを見ないでください。|arukinagara sumaho o minaide kudasai|Please don't look at your phone while walking.|चलते-चलते फ़ोन न देखें।
            📺|テレビを見ながら、ご飯を食べます。|terebi o minagara, gohan o tabemasu|I eat while watching TV.|मैं टीवी देखते हुए खाना खाता हूँ।
            🎤|歌いながら、踊る。|utainagara, odoru|To dance while singing.|गाते-गाते नाचना।
            🚗|運転しながら、電話しないでください。|unten shinagara, denwa shinaide kudasai|Please don't call while driving.|गाड़ी चलाते-चलाते फ़ोन न करें।
            🍳|料理をしながら、音楽を聞くのが好きです。|ryouri o shinagara, ongaku o kiku no ga suki desu|I like listening to music while cooking.|मुझे खाना बनाते-बनाते संगीत सुनना पसंद है।
        """,

        "jpN4-f" to """
            🇯🇵|来年、日本へ行くつもりです。|rainen, nihon e iku tsumori desu|I intend to go to Japan next year.|मैं अगले साल जापान जाने का इरादा रखता हूँ।
            📚|毎日日本語を勉強するつもりです。|mainichi nihongo o benkyou suru tsumori desu|I intend to study Japanese every day.|मैं हर दिन जापानी पढ़ने का इरादा रखता हूँ।
            🚗|新しい車を買うつもりです。|atarashii kuruma o kau tsumori desu|I intend to buy a new car.|मैं नई कार खरीदने का इरादा रखता हूँ।
            ❌|今日は行かないつもりです。|kyou wa ikanai tsumori desu|I intend not to go today.|आज न जाने का इरादा है।
            🏃|明日から走るつもりです。|ashita kara hashiru tsumori desu|I intend to run starting tomorrow.|कल से दौड़ने का इरादा है।
            ❓|いつ留学するつもりですか。|itsu ryuugaku suru tsumori desu ka|When do you intend to study abroad?|विदेश कब पढ़ने का इरादा है?
            🍳|晩ご飯を作るつもりです。|bangohan o tsukuru tsumori desu|I intend to cook dinner.|मैं रात का खाना बनाने का इरादा रखता हूँ।
        """,

        "jpN4-g" to """
            ☁️|雨が降りそうですね。|ame ga furisou desu ne|It looks like it's going to rain.|लगता है बारिश होगी।
            🍰|このケーキはおいしそうですね。|kono keeki wa oishisou desu ne|This cake looks delicious.|यह केक स्वादिष्ट लगता है।
            😴|彼は眠そうな顔をしています。|kare wa nemusou na kao o shite imasu|He looks sleepy.|वह नींद में लगता है।
            🏃|彼女は元気そうですね。|kanojo wa genkisou desu ne|She looks healthy, doesn't she.|वह स्वस्थ लगती है।
            💔|今にも泣きそうでした。|ima ni mo nakisou deshita|He looked about to cry.|वह रोने वाला लग रहा था।
            🏠|この家は古そうですね。|kono ie wa furusou desu ne|This house looks old.|यह घर पुराना लगता है।
            🍜|ラーメンはとても熱そうでした。|raamen wa totemo atsusou deshita|The ramen looked very hot.|रामेन बहुत गर्म लग रहा था।
        """,

        "jpN4-h" to """
            ☂️|雨が降ったら、行きません。|ame ga futtara, ikimasen|If it rains, I won't go.|अगर बारिश हुई तो मैं नहीं जाऊँगा।
            🕐|時間があったら、来てください。|jikan ga attara, kite kudasai|If you have time, please come.|अगर समय हो तो आना।
            💰|お金があったら、旅行します。|okane ga attara, ryokou shimasu|If I had money, I'd travel.|अगर पैसे होते तो यात्रा करता।
            📚|勉強したら、休みましょう。|benkyou shitara, yasumimashou|After studying, let's rest.|पढ़ाई के बाद आराम करें।
            🏠|家に着いたら、電話します。|ie ni tsuitara, denwa shimasu|I'll call when I arrive home.|घर पहुँचकर फ़ोन करूँगा।
            🍽️|安かったら、買います。|yasukattara, kaimasu|If it's cheap, I'll buy it.|अगर सस्ता हुआ तो खरीदूँगा।
            😊|彼に会ったら、よろしく伝えてください。|kare ni attara, yoroshiku tsutaete kudasai|If you meet him, please say hello.|अगर उससे मिलो तो नमस्ते कहना।
        """,

        "jpN4-i" to """
            🎁|友達にプレゼントをあげました。|tomodachi ni purezento o agemashita|I gave a present to my friend.|मैंने दोस्त को उपहार दिया।
            📖|彼は私に本をくれました。|kare wa watashi ni hon o kuremashita|He gave me a book.|उसने मुझे किताब दी।
            🚲|私は友達に自転車を借りてもらいました。|watashi wa tomodachi ni jitensha o karite moraimashita|I had my friend lend me a bicycle.|मैंने दोस्त से साइकिल उधार ली।
            🧑|母が私に料理を作ってくれました。|haha ga watashi ni ryouri o tsukutte kuremashita|My mother cooked for me.|मेरी माँ ने मेरे लिए खाना बनाया।
            🎓|私は妹に宿題を教えてあげました。|watashi wa imouto ni shukudai o oshiete agemashita|I taught my little sister her homework.|मैंने छोटी बहन को गृहकार्य सिखाया।
            🚗|駅まで車で送ってもらいました。|eki made kuruma de okutte moraimashita|I was driven to the station.|मुझे गाड़ी से स्टेशन छोड़ा गया।
            🎂|友達がケーキを買ってくれました。|tomodachi ga keeki o katte kuremashita|My friend bought me a cake.|दोस्त ने मेरे लिए केक खरीदा।
        """,

        "jpN4-j" to """
            📖|この本は読みやすいです。|kono hon wa yomiyasui desu|This book is easy to read.|यह किताब पढ़ने में आसान है।
            ✍️|この字は書きにくいです。|kono ji wa kakinikui desu|This character is hard to write.|यह अक्षर लिखने में कठिन है।
            🍞|このパンは食べやすいです。|kono pan wa tabeyasui desu|This bread is easy to eat.|यह ब्रेड खाने में आसान है।
            🚗|この車は運転しやすいです。|kono kuruma wa unten shiyasui desu|This car is easy to drive.|यह कार चलाने में आसान है।
            🗣️|彼の日本語は聞きにくいです。|kare no nihongo wa kikinikui desu|His Japanese is hard to understand.|उसकी जापानी सुनने में कठिन है।
            💻|このアプリは使いやすいです。|kono apuri wa tsukaiyasui desu|This app is easy to use.|यह ऐप इस्तेमाल में आसान है।
            ❄️|雪の日は歩きにくいです。|yuki no hi wa arukinikui desu|It's hard to walk on snowy days.|बर्फ़ वाले दिन चलना कठिन है।
        """,

        "jpN5-a" to """
            💧|みずをください。|mizu o kudasai|Please give me water.|कृपया मुझे पानी दीजिए।
            ☕|コーヒーをください。|koohii o kudasai|Please give me a coffee.|कृपया मुझे कॉफ़ी दीजिए।
            🍰|このケーキをください。|kono keeki o kudasai|Please give me this cake.|कृपया मुझे यह केक दीजिए।
            📄|メニューをください。|menyuu o kudasai|Please give me the menu.|कृपया मुझे मेनू दीजिए।
            🍵|おちゃをください。|ocha o kudasai|Please give me tea.|कृपया मुझे चाय दीजिए।
            🍱|おべんとうをください。|obentou o kudasai|Please give me a lunch box.|कृपया मुझे टिफ़िन दीजिए।
            🎫|チケットをください。|chiketto o kudasai|Please give me a ticket.|कृपया मुझे टिकट दीजिए।
        """,

        "jpN5-b" to """
            🏦|ぎんこうはえきのまえにあります。|ginkou wa eki no mae ni arimasu|The bank is in front of the station.|बैंक स्टेशन के सामने है।
            🐈|ねこはつくえのしたにいます。|neko wa tsukue no shita ni imasu|The cat is under the desk.|बिल्ली मेज़ के नीचे है।
            🏪|スーパーはえきのちかくにあります。|suupaa wa eki no chikaku ni arimasu|The supermarket is near the station.|सुपरमार्केट स्टेशन के पास है।
            🧑|せんせいはきょうしつにいます。|sensei wa kyoushitsu ni imasu|The teacher is in the classroom.|शिक्षक कक्षा में हैं।
            📱|けいたいはかばんのなかにあります。|keitai wa kaban no naka ni arimasu|The phone is inside the bag.|फ़ोन बैग के अंदर है।
            🐕|いぬはにわにいます。|inu wa niwa ni imasu|The dog is in the garden.|कुत्ता बगीचे में है।
            🍎|りんごはれいぞうこのなかにあります。|ringo wa reizouko no naka ni arimasu|The apples are in the fridge.|सेब फ्रिज में हैं।
        """,

        "jpN5-c" to """
            🕐|わたしはじかんがあります。|watashi wa jikan ga arimasu|I have time.|मेरे पास समय है।
            🚗|ちちはくるまがあります。|chichi wa kuruma ga arimasu|My father has a car.|पिताजी के पास कार है।
            💰|おかねがありますか。|okane ga arimasu ka|Do you have money?|क्या आपके पास पैसे हैं?
            👩|かのじょはペットがあります。|kanojo wa petto ga arimasu|She has a pet.|उसके पास पालतू है।
            📚|わたしはたくさんほんがあります。|watashi wa takusan hon ga arimasu|I have many books.|मेरे पास बहुत किताबें हैं।
            ❌|じかんがありません。|jikan ga arimasen|I don't have time.|मेरे पास समय नहीं है।
            🏠|かれらはおおきいいえがあります。|karera wa ookii ie ga arimasu|They have a big house.|उनका बड़ा घर है।
        """,

        "jpN5-d" to """
            ❄️|きのうはさむかったです。|kinou wa samukatta desu|It was cold yesterday.|कल ठंड थी।
            🍜|ラーメンはおいしかったです。|raamen wa oishikatta desu|The ramen was delicious.|रामेन स्वादिष्ट था।
            🎬|その映画はおもしろかったです。|sono eiga wa omoshirokatta desu|That movie was interesting.|वह फ़िल्म रोचक थी।
            📝|テストはむずかしかったです。|tesuto wa muzukashikatta desu|The test was difficult.|परीक्षा कठिन थी।
            ❌|その本はたかくなかったです。|sono hon wa takakunakatta desu|That book was not expensive.|वह किताब महँगी नहीं थी।
            ☀️|きょうはあつかったです。|kyou wa atsukatta desu|Today was hot.|आज गर्मी थी।
            🎉|パーティーはたのしかったです。|paatii wa tanoshikatta desu|The party was fun.|पार्टी मज़ेदार थी।
        """,

        "jpN5-e" to """
            🚪|ドアをあけましょうか。|doa o akemashou ka|Shall I open the door?|क्या मैं दरवाज़ा खोलूँ?
            🍽️|いっしょにたべましょうか。|issho ni tabemashou ka|Shall we eat together?|क्या हम साथ खाएँ?
            🧹|そうじをてつだいましょうか。|souji o tetsudaimashou ka|Shall I help with the cleaning?|क्या मैं सफ़ाई में मदद करूँ?
            ☕|コーヒーをいれましょうか。|koohii o iremashou ka|Shall I make coffee?|क्या मैं कॉफ़ी बनाऊँ?
            🚗|えきまでおくりましょうか。|eki made okurimashou ka|Shall I drive you to the station?|क्या मैं स्टेशन तक छोड़ दूँ?
            🪟|まどをしめましょうか。|mado o shimemashou ka|Shall I close the window?|क्या मैं खिड़की बंद करूँ?
            📱|でんわしましょうか。|denwa shimashou ka|Shall I call?|क्या मैं फ़ोन करूँ?
        """,

        "jpN5-f" to """
            🍽️|もう食べました。|mou tabemashita|I have already eaten.|मैं खा चुका हूँ।
            📝|まだ宿題をしていません。|mada shukudai o shite imasen|I haven't done my homework yet.|मैंने अभी गृहकार्य नहीं किया।
            🕐|もう九時です。|mou kuji desu|It's already nine o'clock.|अब नौ बज गए।
            🚃|電車はまだ来ていません。|densha wa mada kite imasen|The train hasn't come yet.|ट्रेन अभी नहीं आई।
            🎓|もう卒業しました。|mou sotsugyou shimashita|I have already graduated.|मैं स्नातक हो चुका हूँ।
            📱|まだスマホを買っていません。|mada sumaho o katte imasen|I haven't bought a phone yet.|मैंने अभी फ़ोन नहीं खरीदा।
            ❓|もう昼ご飯を食べましたか。|mou hirugohan o tabemashita ka|Have you eaten lunch already?|क्या तुमने दोपहर का खाना खा लिया?
        """,

        "jpN5-g" to """
            🧑|友達といっしょに映画を見ます。|tomodachi to issho ni eiga o mimasu|I watch movies together with my friend.|मैं दोस्त के साथ फ़िल्म देखता हूँ।
            👨‍👩‍👧|家族といっしょに旅行します。|kazoku to issho ni ryokou shimasu|I travel together with my family.|मैं परिवार के साथ यात्रा करता हूँ।
            🚶|彼といっしょに行きます。|kare to issho ni ikimasu|I'll go together with him.|मैं उसके साथ जाऊँगा।
            🍽️|みんなといっしょに食べましょう。|minna to issho ni tabemashou|Let's eat together with everyone.|सबके साथ खाएँ।
            🐕|犬といっしょに散歩します。|inu to issho ni sanpo shimasu|I take a walk together with my dog.|मैं कुत्ते के साथ टहलता हूँ।
            ☕|いっしょにお茶を飲みませんか。|issho ni ocha o nomimasen ka|Would you like to have tea together?|क्या साथ चाय पिएँ?
            🎓|友達といっしょに勉強しました。|tomodachi to issho ni benkyou shimashita|I studied together with my friend.|मैंने दोस्त के साथ पढ़ाई की।
        """,

        "jpN5-h" to """
            ☕|コーヒーをおねがいします。|koohii o onegaishimasu|Coffee, please.|कृपया कॉफ़ी दीजिए।
            📄|メニューをおねがいします。|menyuu o onegaishimasu|The menu, please.|कृपया मेनू दीजिए।
            🍜|ラーメンをおねがいします。|raamen o onegaishimasu|Ramen, please.|कृपया रामेन दीजिए।
            🍺|ビールをふたつおねがいします。|biiru o futatsu onegaishimasu|Two beers, please.|कृपया दो बियर दीजिए।
            🧾|おかいけいをおねがいします。|okaikei o onegaishimasu|The bill, please.|कृपया बिल दीजिए।
            🚕|タクシーをおねがいします。|takushii o onegaishimasu|A taxi, please.|कृपया टैक्सी दीजिए।
            🛏️|よやくをおねがいします。|yoyaku o onegaishimasu|A reservation, please.|कृपया आरक्षण दीजिए।
        """,

        "genki-2" to """
            📕|これは私の本です。|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है।
            🖊️|それは何ですか。|sore wa nan desu ka|What is that?|वह क्या है?
            🏫|あれは学校です。|are wa gakkou desu|That over there is a school.|वह दूर वाला स्कूल है।
            👟|この靴は新しいです。|kono kutsu wa atarashii desu|These shoes are new.|ये जूते नए हैं।
            📱|その電話は高いですね。|sono denwa wa takai desu ne|That phone is expensive, isn't it.|वह फ़ोन महँगा है ना।
            ❓|あの人は誰ですか。|ano hito wa dare desu ka|Who is that person over there?|वह दूर वाला व्यक्ति कौन है?
        """,

        "genki-4" to """
            🐈|部屋に猫がいます。|heya ni neko ga imasu|There is a cat in the room.|कमरे में बिल्ली है।
            📚|机の上に本があります。|tsukue no ue ni hon ga arimasu|There is a book on the desk.|मेज़ पर किताब है।
            🧑|公園に子供がいます。|kouen ni kodomo ga imasu|There are children in the park.|पार्क में बच्चे हैं।
            🏪|駅の近くに店があります。|eki no chikaku ni mise ga arimasu|There is a shop near the station.|स्टेशन के पास दुकान है।
            🐕|庭に犬がいます。|niwa ni inu ga imasu|There is a dog in the garden.|बगीचे में कुत्ता है।
            🚗|外に車があります。|soto ni kuruma ga arimasu|There is a car outside.|बाहर कार है।
            ❓|冷蔵庫に何がありますか。|reizouko ni nani ga arimasu ka|What is in the fridge?|फ्रिज में क्या है?
        """,

        "genki-5" to """
            🍎|このりんごは甘いです。|kono ringo wa amai desu|This apple is sweet.|यह सेब मीठा है।
            🏙️|東京はにぎやかな町です。|toukyou wa nigiyaka na machi desu|Tokyo is a lively city.|टोक्यो जीवंत शहर है।
            📖|この本はおもしろいです。|kono hon wa omoshiroi desu|This book is interesting.|यह किताब रोचक है।
            🧑|彼女は静かな人です。|kanojo wa shizuka na hito desu|She is a quiet person.|वह शांत व्यक्ति है।
            🏔️|あの山は高いです。|ano yama wa takai desu|That mountain is high.|वह पहाड़ ऊँचा है।
            🎓|彼は有名な先生です。|kare wa yuumei na sensei desu|He is a famous teacher.|वह प्रसिद्ध शिक्षक हैं।
            ❄️|今日は寒いです。|kyou wa samui desu|Today is cold.|आज ठंड है।
        """,

        "genki-7" to """
            🍽️|ご飯を食べてから、出かけます。|gohan o tabete kara, dekakemasu|After eating, I go out.|खाना खाने के बाद बाहर जाता हूँ।
            📚|勉強してから、寝ます。|benkyou shite kara, nemasu|After studying, I sleep.|पढ़ाई के बाद सोता हूँ।
            ☂️|雨が降っても、行きます。|ame ga futte mo, ikimasu|Even if it rains, I'll go.|बारिश होने पर भी जाऊँगा।
            💰|高くても、買います。|takakute mo, kaimasu|Even if it's expensive, I'll buy it.|महँगा होने पर भी खरीदूँगा।
            🚿|シャワーを浴びてから、寝ます。|shawaa o abite kara, nemasu|After taking a shower, I sleep.|स्नान के बाद सोता हूँ।
            😴|眠くても、勉強します。|nemukute mo, benkyou shimasu|Even if sleepy, I study.|नींद आने पर भी पढ़ता हूँ।
            🚶|家に帰ってから、電話します。|ie ni kaette kara, denwa shimasu|After going home, I'll call.|घर लौटकर फ़ोन करूँगा।
            🍵|お茶を飲んでから、出かけましょう。|ocha o nonde kara, dekakemashou|After drinking tea, let's go out.|चाय पीकर बाहर चलें।
        """,

        "genki-8" to """
            🍽️|ご飯食べた？|gohan tabeta?|Did you eat? (casual)|खाना खाया?
            🏃|明日、学校行く。|ashita, gakkou iku|I'm going to school tomorrow. (casual)|कल स्कूल जाऊँगा।
            🎬|映画、見た？|eiga, mita?|Did you watch the movie? (casual)|फ़िल्म देखी?
            ☕|コーヒー飲む？|koohii nomu?|Want coffee? (casual)|कॉफ़ी पिएगा?
            😴|もう寝る。|mou neru|I'm going to sleep now. (casual)|अब सोता हूँ।
            📚|勉強しない。|benkyou shinai|I'm not studying. (casual)|नहीं पढ़ रहा।
            🚗|車で行こう。|kuruma de ikou|Let's go by car. (casual)|गाड़ी से चलें।
            ❓|元気？|genki?|You okay? (casual)|ठीक हो?
        """,

        "genki-9" to """
            💰|高いですが、買います。|takai desu ga, kaimasu|It's expensive, but I'll buy it.|महँगा है, पर खरीदूँगा।
            📚|本を読みましたが、おもしろくなかったです。|hon o yomimashita ga, omoshirokunakatta desu|I read the book, but it wasn't interesting.|किताब पढ़ी, पर रोचक नहीं थी।
            🍽️|もう食べました。|mou tabemashita|I already ate.|मैं खा चुका हूँ।
            ⏳|まだ食べていません。|mada tabete imasen|I haven't eaten yet.|मैंने अभी नहीं खाया।
            ☂️|雨ですが、出かけます。|ame desu ga, dekakemasu|It's raining, but I'll go out.|बारिश है, पर बाहर जाऊँगा।
            🎓|学生ですが、働いています。|gakusei desu ga, hataraite imasu|I'm a student, but I work.|मैं विद्यार्थी हूँ, पर काम करता हूँ।
            🚃|電車はまだ来ていません。|densha wa mada kite imasen|The train hasn't come yet.|ट्रेन अभी नहीं आई।
            ❓|もう宿題をしましたか。|mou shukudai o shimashita ka|Have you done your homework yet?|क्या तुमने गृहकार्य कर लिया?
        """,

        "genki-12" to """
            ☁️|雨が降りそうです。|ame ga furisou desu|It looks like it will rain.|लगता है बारिश होगी।
            🍰|このケーキはおいしそうです。|kono keeki wa oishisou desu|This cake looks delicious.|यह केक स्वादिष्ट लगता है।
            🍽️|食べすぎました。|tabesugimashita|I ate too much.|मैंने ज़्यादा खा लिया।
            💰|高すぎます。|takasugimasu|It's too expensive.|यह बहुत महँगा है।
            🎵|音楽を聞きながら、勉強します。|ongaku o kikinagara, benkyou shimasu|I study while listening to music.|संगीत सुनते-सुनते पढ़ता हूँ।
            🏃|走りすぎて、疲れました。|hashirisugite, tsukaremashita|I ran too much and got tired.|बहुत दौड़ा और थक गया।
            😴|彼は眠そうですね。|kare wa nemusou desu ne|He looks sleepy, doesn't he.|वह नींद में लगता है।
        """,

        "jfz-2" to """
            📕|これは私の本です。|kore wa watashi no hon desu|This is my book.|यह मेरी किताब है।
            🖊️|それは何ですか。|sore wa nan desu ka|What's that?|वह क्या है?
            🏫|あれは学校です。|are wa gakkou desu|That over there is a school.|वह दूर वाला स्कूल है।
            📱|この電話は新しいです。|kono denwa wa atarashii desu|This phone is new.|यह फ़ोन नया है।
            🚗|あの車は私のです。|ano kuruma wa watashi no desu|That car over there is mine.|वह दूर वाली कार मेरी है।
            ❓|どれがあなたのですか。|dore ga anata no desu ka|Which one is yours?|कौन सा तुम्हारा है?
            👟|その靴は高いですね。|sono kutsu wa takai desu ne|Those shoes are expensive, aren't they.|वे जूते महँगे हैं ना।
        """,

        "jfz-4" to """
            🍎|このりんごは赤いです。|kono ringo wa akai desu|This apple is red.|यह सेब लाल है।
            🌊|海は青いです。|umi wa aoi desu|The sea is blue.|समुद्र नीला है।
            🐈|この猫は黒いです。|kono neko wa kuroi desu|This cat is black.|यह बिल्ली काली है।
            ❄️|雪は白いです。|yuki wa shiroi desu|Snow is white.|बर्फ़ सफ़ेद है।
            ❓|何色が好きですか。|nani iro ga suki desu ka|What color do you like?|तुम्हें कौन सा रंग पसंद है?
            🚗|あの車は新しいです。|ano kuruma wa atarashii desu|That car is new.|वह कार नई है।
            🏠|大きい家に住んでいます。|ookii ie ni sunde imasu|I live in a big house.|मैं बड़े घर में रहता हूँ।
        """,

        "jfz-5" to """
            🐕|私は犬が好きです。|watashi wa inu ga suki desu|I like dogs.|मुझे कुत्ते पसंद हैं।
            🐍|私は蛇がきらいです。|watashi wa hebi ga kirai desu|I dislike snakes.|मुझे साँप नापसंद हैं।
            ☕|コーヒーが大好きです。|koohii ga daisuki desu|I love coffee.|मुझे कॉफ़ी बहुत पसंद है।
            🍜|ラーメンが好きです。|raamen ga suki desu|I like ramen.|मुझे रामेन पसंद है।
            🎵|音楽が好きです。|ongaku ga suki desu|I like music.|मुझे संगीत पसंद है।
            ❓|何が好きですか。|nani ga suki desu ka|What do you like?|तुम्हें क्या पसंद है?
            ⚽|スポーツが好きではありません。|supootsu ga suki dewa arimasen|I don't like sports.|मुझे खेल पसंद नहीं हैं।
        """,

        "jfz-6" to """
            🚗|新しい車がほしいです。|atarashii kuruma ga hoshii desu|I want a new car.|मुझे नई कार चाहिए।
            📱|新しい電話がほしいです。|atarashii denwa ga hoshii desu|I want a new phone.|मुझे नया फ़ोन चाहिए।
            🏠|大きい家がほしいです。|ookii ie ga hoshii desu|I want a big house.|मुझे बड़ा घर चाहिए।
            🐈|猫がほしいです。|neko ga hoshii desu|I want a cat.|मुझे बिल्ली चाहिए।
            ❓|何がほしいですか。|nani ga hoshii desu ka|What do you want?|तुम्हें क्या चाहिए?
            ❌|お金はほしくないです。|okane wa hoshikunai desu|I don't want money.|मुझे पैसे नहीं चाहिए।
            ⌚|いい時計がほしいです。|ii tokei ga hoshii desu|I want a good watch.|मुझे अच्छी घड़ी चाहिए।
        """,

        "jfz-7" to """
            🚻|トイレはどこですか。|toire wa doko desu ka|Where is the restroom?|शौचालय कहाँ है?
            🏫|学校はここです。|gakkou wa koko desu|The school is here.|स्कूल यहाँ है।
            🏪|店はあそこです。|mise wa asoko desu|The shop is over there.|दुकान वहाँ है।
            🐈|猫はそこにいます。|neko wa soko ni imasu|The cat is there.|बिल्ली वहाँ है।
            📚|本は机の上にあります。|hon wa tsukue no ue ni arimasu|The book is on the desk.|किताब मेज़ पर है।
            🧑|先生は教室にいます。|sensei wa kyoushitsu ni imasu|The teacher is in the classroom.|शिक्षक कक्षा में हैं।
            ❓|駅はどこにありますか。|eki wa doko ni arimasu ka|Where is the station?|स्टेशन कहाँ है?
        """,

        "jfz-9" to """
            📅|今日は月曜日です。|kyou wa getsuyoubi desu|Today is Monday.|आज सोमवार है।
            🗓️|明日は火曜日です。|ashita wa kayoubi desu|Tomorrow is Tuesday.|कल मंगलवार है।
            🕐|月曜日から金曜日まで働きます。|getsuyoubi kara kinyoubi made hatarakimasu|I work from Monday to Friday.|सोमवार से शुक्रवार तक काम करता हूँ।
            ❓|今日は何曜日ですか。|kyou wa nanyoubi desu ka|What day is it today?|आज कौन सा दिन है?
            🌸|春は三月から五月までです。|haru wa sangatsu kara gogatsu made desu|Spring is from March to May.|वसंत मार्च से मई तक है।
            🎂|私の誕生日は七月十日です。|watashi no tanjoubi wa shichigatsu tooka desu|My birthday is July tenth.|मेरा जन्मदिन दस जुलाई है।
            📖|一週間に三回日本語を勉強します。|isshuukan ni sankai nihongo o benkyou shimasu|I study Japanese three times a week.|मैं हफ़्ते में तीन बार जापानी पढ़ता हूँ।
        """,

        "jfz-12" to """
            📚|私は日本語を勉強します。|watashi wa nihongo o benkyou shimasu|I study Japanese.|मैं जापानी पढ़ता हूँ।
            🎬|映画を見ません。|eiga o mimasen|I don't watch movies.|मैं फ़िल्म नहीं देखता।
            🍽️|昨日、すしを食べました。|kinou, sushi o tabemashita|I ate sushi yesterday.|मैंने कल सुशी खाई।
            ☕|毎朝コーヒーを飲みます。|maiasa koohii o nomimasu|I drink coffee every morning.|मैं हर सुबह कॉफ़ी पीता हूँ।
            🏃|毎日走ります。|mainichi hashirimasu|I run every day.|मैं हर दिन दौड़ता हूँ।
            📺|テレビを見ましたか。|terebi o mimashita ka|Did you watch TV?|क्या तुमने टीवी देखा?
            🎵|音楽を聞きませんでした。|ongaku o kikimasen deshita|I didn't listen to music.|मैंने संगीत नहीं सुना।
        """,

        "jfz-13" to """
            🕐|今、三時です。|ima, sanji desu|It's three o'clock now.|अभी तीन बजे हैं।
            🕜|今、三時半です。|ima, sanji han desu|It's half past three.|अभी साढ़े तीन बजे हैं।
            🌅|七時に起きます。|shichiji ni okimasu|I get up at seven.|मैं सात बजे उठता हूँ।
            🌙|十一時に寝ます。|juuichiji ni nemasu|I sleep at eleven.|मैं ग्यारह बजे सोता हूँ।
            ❓|今、何時ですか。|ima, nanji desu ka|What time is it now?|अभी कितने बजे हैं?
            🏫|九時から五時まで働きます。|kuji kara goji made hatarakimasu|I work from nine to five.|मैं नौ से पाँच तक काम करता हूँ।
            🍽️|七時半に晩ご飯を食べます。|shichiji han ni bangohan o tabemasu|I eat dinner at seven thirty.|मैं साढ़े सात बजे रात का खाना खाता हूँ।
        """
    )
}
