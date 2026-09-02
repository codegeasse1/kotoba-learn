package com.nexo.kotoba

object KanjiWords {
    private var kid = 0
    private fun kw(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Word("k${kid++}", "•", c[0], c[1], c[2], c[3], "", c.getOrElse(4) { "" })
        }.toList()

    val categories: List<Lesson> = listOf(

        Lesson("kw-daily", "🌅 Daily Life · 日々の生活", "🌅", "11 kanji words", kw("""
しゅうかん|shuukan|習慣|custom; manners|दर्ज़ी से सिली हुई; रीति; प्रथा; शिष्टाचार; रीति रिवाज; रंगढंग
よやく|yoyaku|予約|reservation|रक्षण खंडअ; कारण; आरक्षित भूमि
ようじ|youji|用事|things to do|वस्ट्र; काम; सामान
かじ|kaji|家事|housework; domestic chores|घरेलु काम काज; घरेलू नौकर; पालतू; चाकर/घर का नौकर
したく|shitaku|支度|preparation|खाना; सम्पाक; अभ्यासकार्य
じゅんび|junbi|準備|preparation; arrangements; provision; reserve|खाना; सम्पाक; अभ्यासकार्य; खाद्य सामग्री; व्यवस्था; विधान
せわ|sewa|世話|looking after; help; aid; assistance|एक दृष्टि; मदद; सहायता; मदद; मदद करना
くせ|kuse|癖|a habit (often a bad habit); peculiarity|प्रवृत्ति; पोशाक; स्वभाव; विशिष्टता; खासियत; अनूठापन
くらし|kurashi|暮らし|living; livelihood; subsistence; circumstances|जीवित; आजीविका; क्रियाशील; आजीविका; जीविका; जीवननिर्वाह; निर्वाह; गुज़र बसर
くれ|kure|暮れ|year end; sunset; nightfall; end|वर्ष समाप्ति; वर्ष समाप्ति का; सूर्यास्त; समापक; डूबता; शाम; सन्ध्या समय
げんさん|gensan|原産|place of origin; habitat|उद्गमस्थल; उद्गम; पशु व पौधों का प्राकृतिक वास; निवास् स्थान; प्राकृतिक
"""), "ja", "N4", "kanji"),

        Lesson("kw-food", "🍜 Food & Drink · 食べ物・飲み物", "🍜", "151 kanji words", kw("""
おかし|okashi|お菓子|sweets; candy|मिश्री; टफ़ी; कैन्डी
おさら|osara|お皿|plate; dish|थाली; भोजन; सुन्दर लड़की; परोसना
おさけ|osake|お酒|alcohol; rice wine|अल्कोहल; मद्य; मद्यसार{अलकोहल}; चावल
おちゃ|ocha|お茶|green tea|हरी चाय
おべんとう|obentou|お弁当|boxed lunch|
とりにく|toriniku|とり肉|chicken meat|मुर्गी
あめ|ame|飴|candy|मिश्री; टफ़ी; कैन्डी
いみ|imi|意味|meaning|उद्देश्य; अर्थपूर्ण; मतलब
のみもの|nomimono|飲み物|a drink|पीना
しお|shio|塩|salt|नमक
くだもの|kudamono|果物|fruit|फल
あまい|amai|甘い|sweet|मीठा
きっさてん|kissaten|喫茶店|coffee lounge|कॉफी
ぎゅうにく|gyuuniku|牛肉|beef|गोमांस
ぎゅうにゅう|gyuunyuu|牛乳|milk|दूध
さかな|sakana|魚|fish|मछली
ごはん|gohan|御飯|cooked rice; meal|भोजन
こうちゃ|koucha|紅茶|black tea|काला
たべもの|tabemono|食べ物|food|खाना
しょくどう|shokudou|食堂|dining hall|
からい|karai|辛い|spicy|मसालेदार; उत्तेजक; रोचक
はれ|hare|晴れ|clear weather|स्पष्ट
おおぜい|oozei|大勢|great number of people|महान
ひるごはん|hirugohan|昼御飯|midday meal|मध्याह्न; दोपहर का; दोपहर
あさごはん|asagohan|朝御飯|breakfast|नाश्ता
ぶたにく|butaniku|豚肉|pork|सुअर का गोश्त; सुअर का मांस
にく|niku|肉|meat|मांस
ばんごはん|bangohan|晩御飯|evening meal|शाम
やさい|yasai|野菜|vegetable|सब्ज़ी
ゆうはん|yuuhan|夕飯|dinner|रात का खाना
たまご|tamago|卵|egg|अंडा
りょうり|ryouri|料理|cuisine|भोजन; पाक प्रणाली; पाक शैली
きょうみ|kyoumi|興味|an interest|रुचि
しゅみ|shumi|趣味|hobby|अभिरुचि; शौक; दोलन घोड़ा
めしあがる|meshiagaru|召し上がる|(polite) to eat|खाना
せき|seki|席|seat|सीट
だんぼう|danbou|暖房|heating|ताप; गरम करने की पद्धति; तापक
こめ|kome|米|uncooked rice|कच्चा; पकाया न हुआ; अनपका
あじ|aji|味|flavour|स्वाद; रंग; अनुमान
みそ|miso|味噌|bean paste|सिक्का; कुछ; पैसा
いだい|idai|偉大|greatness|विशालता; महत्ता; ऊँचाई
いね|ine|稲|rice-plant|
した|shita|下|under; below; beneath|नीचे; नीचे; नीचे की और; के योग्य; के नीचे
かし|kashi|菓子|pastry|पेस्ट्री; मिष्टान्न; समोसा
かわ|kawa|革|leather|फुटबाल; मूर्ख; सख्त
さかな|sakana|魚|fish|मछली
きんにく|kinniku|筋肉|muscle; sinew|ताकत; जबरदस्ती करना; पेशी; स्नायु
こきゅう|kokyuu|呼吸|breath; respiration|विराम; संकेत; झोंका; श्वास; श्वसन
ざせき|zaseki|座席|seat|सीट
さら|sara|皿|plate; dish|थाली; भोजन; सुन्दर लड़की; परोसना
しぼう|shibou|死亡|death; mortality|मृत्यु; मृत्यु/मरण; आकस्मिक; नश्वरता; मृत्यु संख्या
み|mi|実|fruit; nut; seed; content; good result|फल; पागल; सिर; एकट्र करना; बीज; छाँटना; दाना
さけ|sake|酒|alcohol; sake|अल्कोहल; मद्य; मद्यसार{अलकोहल}; के लिये; साके{चावलों की बनी जापानी शराब}; साकी
しょり|shori|処理|processing; dealing with; treatment; disposition; disposal|संसाधन; प्रसंस्करण; लेन  देन; क्रय विक्रय; निरूपण; बर्ताव; बहस
こむぎ|komugi|小麦|wheat|गेहूँ
くう|kuu|食う|(male) (vulg) to eat|खाना
しょくじ|shokuji|食事|meal|भोजन
しょくたく|shokutaku|食卓|dining table|भोजन मेज
しょくひん|shokuhin|食品|commodity; foodstuff|माल; उपयोगी; सामग्री; खाद्य पदार्थ
しょくもつ|shokumotsu|食物|food; foodstuff|खाना; खाद्य पदार्थ
しょくよく|shokuyoku|食欲|appetite (for food)|इच्छा; रुचि; भूख
しょくりょう|shokuryou|食料|food|खाना
しょくりょう|shokuryou|食糧|provisions; rations|शर्त; खाद्य; खाद्य आपूर्ती; रसद
からい|karai|辛い|painful; heart-breaking|भद्दा; कठिन; दर्दीला
せいぶつ|seibutsu|生物|raw food|अनुचित व्यवहार; कच्चा; फूहड़
ふね|fune|船|ship; boat; watercraft; shipping; vessel; steamship|जहाज़; नाव; नौका; नाव; नौकौशल
くみ|kumi|組|class; group; team; set|कक्षा; समूह; टीम
いき|iki|息|breath; tone|विराम; संकेत; झोंका; स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल
たば|taba|束|handbreadth; bundle|भरना; बहुत ज़्यादा; गट्ठा
たいした|taishita|大した|considerable; great; important; significant; a big deal|बहुत अधिक; महत्वपूर्ण; बहुत; महान; महत्वपूर्ण
たいせん|taisen|大戦|great war; great battle|प्रथम विश्वयुद्ध; महान
ちゃ|cha|茶|tea|चाय
ちゅうしょく|chuushoku|昼食|lunch; midday meal|दोपहर का खाना; मध्याह्न; दोपहर का; दोपहर
てんこう|tenkou|天候|weather|मौसम
はく|haku|吐く|(1) to breathe; (2) to tell (lies); (3) to vomit; to disgorge|आराम करना; बहना; साँस लेना; बताना; उलटी करना; ओक; कै
どりょく|doryoku|努力|great effort; exertion; endeavour; effort|महान; प्रयास; परिश्रम; श्रम; प्रयत्न; प्रयत्न करना; यत्न करना
とくちょう|tokuchou|特徴|feature; characteristic|दिखाना; प्रकट करना; विशेषता; विशिष्ट लक्षण; लक्षण; विशिष्टता
むしろ|mushiro|寧ろ|rather; better; instead|अधिक; निःसन्देह; अपेक्षाकृत; बेहतर; उसके स्थान पर; बजाय; बदल में
めし|meshi|飯|(sl) meals; food|खाना
かわ|kawa|皮|skin; hide; leather; fur; pelt; bark; shell|छिलना; छिलका निकालना; छिलका; गुप्त रखना; छिपने की जगह; छिपा देना; फुटबाल; मूर्ख; सख्त
ひっし|hisshi|必死|inevitable death; desperation; frantic; inevitable result|अनिवार्य; निश्चित; अपरिहार्य/अनिवार्य; निराशा; उत्तेजित; व्यग्र; उन्मत्त/उत्तेजित
ふこう|fukou|不幸|unhappiness; sorrow; misfortune; disaster; accident; death|खेद; दुःख; रंज; शोक; दुःखी होना; शोक करना; दुर्भाग्य; बदकिस्मती; अवदशा
はば|haba|幅|width; breadth|उदारता; चौड़ाई; फ़ासला; विशालता; विस्तार
ぶっか|bukka|物価|prices of commodities; prices (in general)|
こな|kona|粉|flour; meal; powder|पीस; पीसना; आटा; भोजन; पाउडार; पीसना; चूर्ण
べんとう|bentou|弁当|box lunch|डिब्बा
みかた|mikata|味方|friend; ally; supporter|दोस्त; मिलाना; मित्रपक्ष; मित्र; सहायक; समर्थक; इलास्टिक बंद
めん|men|面|face; mug; surface; facial features; mask; face guard; side or facet; corner; page|चेहरा; भोला भाला; प्याला; चेहरा; प्रकट होना; दिखाई देना; भू सतह का
りょう|ryou|量|quantity; amount; volume; portion (of food)|परिमाण; मात्रा; संख्या; कुछ हद तक; मात्रा; राशि; प्रबलता; घनफल; अंक
えらい|erai|偉い|great; celebrated; eminent; terrible; awful; famous; remarkable; excellent|महान; प्रसिद्ध; प्रख्यात; प्रमुख; उत्तुंग; उत्कृष्ट
いしょくじゅう|ishokujuu|衣食住|necessities of life (food; clothing; etc.)|पहनावा; परिधान; वस्त्र; आदि
しおからい|shiokarai|塩辛い|salty (taste)|उत्तेजक; लवणयुक्त; नमकीन
よごす|yogosu|汚す|(1) to disgrace; to dishonour; (2) to pollute; to contaminate; to soil; to make dirty; to stain|कलंकित करना; कलंकित; अपमान; मुकर जाना; कलंकित करना; कलंकित; दूषित करना; अपवित्र करना; दूषित
おうべい|oubei|欧米|Europe and America; the West|यूरोपीय संघ; यूरोपीय; यूरोप; पश्चिम
かじつ|kajitsu|果実|fruit; nut; berry.|फल; पागल; सिर; एकट्र करना; बेर चुनना; चुनना; बीज
かんぱい|kanpai|乾杯|toast (drink)|सलामती का जाम; शुभकामना करना; टोस्ट बनाना
きゅうよう|kyuuyou|休養|rest; break; recreation|आराम; तोड़ना; मनोरंजन; विहार; मनोरंजन आराम
そば|soba|蕎麦|soba (buckwheat noodles)|
きんぎょ|kingyo|金魚|goldfish|स्वर्ण मछली; स्वर्ण; एक् मछली
かたい|katai|堅い|hard (esp. wood); steadfast; honorable; stuffy writing|कठिन; स्थिर; कट्टर; अविचल; माननीय; सम्मान योग्य; इज्जतदार
こんだて|kondate|献立|menu; program; schedule|मेनू/आहारिका; मेन्यू; व्यंजन सूची; कार्यक्रम; अनुसूची; योजना लेख; सूची
さいさん|saisan|再三|again and again; repeatedly|फिर; कई बार; बार बार; कई
とる|toru|採る|(1) to adopt (measure; proposal); (2) to pick (fruit)|सुझाव; प्रस्ताव; विवाह; उकसाना; खाना; हटाना
さしみ|sashimi|刺身|sliced raw fish|
さかば|sakaba|酒場|bar; bar-room|रोकना; अदालत; सिटकिनी
しる|shiru|汁|juice; sap; soup; broth|शक्ति; रस; गपशप; मूर्ख; ज़मीन खोदना; रस; सूप
しょくえん|shokuen|食塩|table salt|मेज़
しょっき|shokki|食器|tableware|भोजन पात्र; मेज़ पर खाने के बर्तन इत्यादि
しょうみ|shoumi|正味|net (weight)|पाना; निर्धारित; दाम
もる|moru|盛る|(1) to serve (food; etc.); (2) to fill up; (3) to prescribe|आदि; भरना; पूरा भरा होना; भरा हुआ होना
せっかく|sekkaku|折角|with trouble; at great pains; long-awaited|
そうさく|sousaku|創作|production; literary creation; work|प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन; साहित्यिक; साहित्य; काम
どく|doku|退く|(1) to retreat; to recede; to withdraw|गिरना; पीछे हटना; भागना; घटना; पीछे हटना; कम होना; हटाना; अलग करना; हटा लेना
ちしつ|chishitsu|地質|geological features|भूगर्भीय; भूविज्ञानी; भौमकीय
じみ|jimi|地味|plain; simple|सरल; समतल; सीधा; सरल
ちゃわん|chawan|茶碗|rice bowl; tea cup; teacup|चावल; चाय; चाय का कप; चाय का प्याला
なかみ|nakami|中味|contents; interior; substance; filling; (sword) blade|सार; वस्तु; विषय; भीतरी; भीतर; तटवर्ती; सार; वस्तु; पदार्थ
ちょうみりょう|choumiryou|調味料|condiment; seasoning|मसाला; मसाला; मसाला/नमक मिर्च
ていか|teika|定価|established price|प्रमाणित; प्रतिष्ठित; सिद्ध
ゆのみ|yunomi|湯飲み|teacup|चाय का कप; चाय का प्याला
なんべい|nanbei|南米|South America|दक्षिण
はがす|hagasu|剥す|(v5s) to tear off; to peel off; to rip off|उतारना; मुड़ना; हटाना; चुराना; ठगाना
ひにく|hiniku|皮肉|cynicism; sarcasm|निराशावाद; दोषदर्षिता; असूया; व्यंग्योक्ति; व्यंग्य
もち|mochi|餅|sticky rice cake|कठिन; कंजूस; चिपचिपा
ようち|youchi|幼稚|infancy; childish; infantile|बचपन; शैशव; आरम्भिक अवस्था; बचकाना; लड़कपन की सी; बच्चौं; बचकाना; शिशु संबंधी
よくばり|yokubari|欲張り|avarice; covetousness; greed|लालच; लोभ; धनलोलुपता; लालच; तृष्णा; लालच; लालसा
わん|wan|椀|Japanese soup bowl; wooden bowl|जापानवासी; जापानी; भद्दा; भावशून्य; लकड़ी
どんぶり|donburi|丼|porcelain bowl; bowl of rice with food on top|चीनी मिट्टी; चीनी मिट्टी की बनी; चीनी मिट्टी के बरतन; प्राप्त करना; प्याला; आउट
おかず|okazu|お菜|side dish; accompaniment for rice dishes|सलाद; अतिरिक्त व्यंजन; साथ; संगत; {संगीत संबंधी)संगत
おやつ|oyatsu|お八|1.  (uk) between meal snack; afternoon refreshment; afternoon tea; 2.  mid-day snack|एक; दोपहर; दोपहर
いたずら|itazura|悪戯|tease; prank; trick; practical joke; mischief|शरारत; परेशान करना; शरारती; सँवरना; भड़कीले; भड़कीले ढंग से सजाना; शरारत; बहकाना; धोखा
あつかい|atsukai|扱い|treatment; service|निरूपण; बर्ताव; बहस; कार्य; कर्मचारी; सहायता
ひといき|hitoiki|一息|puffy; a breath; a pause; an effort|हाँफ़ता हुआ; उभरा हुआ; सूजा हुआ; विराम; संकेत; झोंका; विराम; रूकना; ठहराव
いっぱい|ippai|一敗|one defeat|
えいゆう|eiyuu|英雄|hero; great man|अभिनेता; नायक; वीर; महान
しお|shio|塩|salt|नमक
おつ|otsu|乙|1.  strange; quaint; stylish; chic; spicy; queer; witty; tasty; romantic; 2.  2nd in rank; second sign of the|एक; निराला; अनोखा; विलक्षण; सुरुचिपूर्ण; भव्य; बना ठना
かこう|kakou|加工|manufacturing; processing; treatment|निर्माण; उत्पादन; विनिर्माण; संसाधन; प्रसंस्करण; निरूपण; बर्ताव; बहस
かみ|kami|加味|seasoning; flavoring|मसाला; मसाला/नमक मिर्च; सुवासकारी पदार्थ
がち|gachi|雅致|artistry; good taste; elegance; grace|कौशल; कला कौशल; कला  कौशल; अच्छा; शिष्टता; रमणीयता; लालित्य
かゆ|kayu|粥|(rice) gruel|दलिया
あまい|amai|甘い|delicious|स्वादिष्ट
あまくち|amakuchi|甘口|sweet flavour; mildness; flattery; stupidity|मीठा; उदारता; कोमलता; सुहावना; चापलूसी; चमचागिरी
きせん|kisen|汽船|steamship|वाष्पचालित पोत
たっとい|tattoi|貴い|precious; valuable; priceless; noble; exalted; sacred|बहुमूल्य; उत्कृष्ट; नितान्त; बहुमूल्य; जेवर; अनमोल; अनमोल; अमूल्य; कमाल
きっさ|kissa|喫茶|tea drinking; tea house|चाय; चाय
きゅうしょく|kyuushoku|給食|school lunch; providing a meal|विद्यालय; बशर्ते कि; बशर्ते
こ|ko|巨|big; large; great|बड़ा; बड़ा; महान
きょう|kyou|供|offer; present; submit; serve (a meal); supply|देना; अर्पण करना; बलि देना; उपहार; सामने रखना; जमा; पेश करना
きょうはく|kyouhaku|脅迫|threat; menace; coercion; terrorism|डर; भय; धमकी देना; हानिकारक; धमकी; कष्टकारी; ज़ोर ज़बर्दस्ती; जोर जबरदस्ती; प्रपीडन
ぎんみ|ginmi|吟味|testing; scrutiny; careful investigation|परीक्षण; जाँच; परीक्षा; सूक्ष्म; सूक्ष्म परीक्षण; सावधान
"""), "ja", "N4", "kanji"),

        Lesson("kw-time", "🕐 Time & Schedule · 時間・予定", "🕐", "394 kanji words", kw("""
さらいねん|sarainen|さ来年|year after next|साल
ひとつき|hitotsuki|一月|one month|
おととい|ototoi|一昨日|day before yesterday|दिन
おととし|ototoshi|一昨年|year before last|साल
ついたち|tsuitachi|一日|(1) one day; (2) first of month|एक न एक दिन; पहला
なつ|natsu|夏|summer|गर्मी
なつやすみ|natsuyasumi|夏休み|summer holiday|गर्मी
ひま|hima|暇|free time|मुक्त
かようび|kayoubi|火曜日|Tuesday|मंगलवार
やすみ|yasumi|休み|rest; holiday|आराम; छुट्टी
きょねん|kyonen|去年|last year|आखिरी
きんようび|kinyoubi|金曜日|Friday|शुक्रवार
ここのか|kokonoka|九日|nine days; ninth day|नौ; नवाँ अंश; नौवाँ भाग; नौंवीं
けっこん|kekkon|結婚|marriage|शादी; विवाह; पाणि ग्रहन् संस्कार
げつようび|getsuyoubi|月曜日|Monday|सोमवार
いつか|itsuka|五日|five days; fifth day|पाँच; पंचमांग; पंचम स्वर; पंचम
ごご|gogo|午後|afternoon|दोपहर
ごぜん|gozen|午前|morning|सुबह
あと|ato|後|afterwards|तत्पश्चात; बाद में; बाद
うしろ|ushiro|後ろ|behind|पीछे
いま|ima|今|now|अब
こんげつ|kongetsu|今月|this month|
こんしゅう|konshuu|今週|this week|इस सप्ताह
けさ|kesa|今朝|this morning|
きょう|kyou|今日|today|आज
ことし|kotoshi|今年|this year|
こんばん|konban|今晩|this evening|
きのう|kinou|昨日|yesterday|कल
ゆうべ|yuube|昨夜|last night|आखिरी
みっか|mikka|三日|three days; third day of the month|तीन; तीसरा
よっか|yokka|四日|four days; fouth day of the month|चार
じかん|jikan|時間|time|समय
とけい|tokei|時計|watch; clock|देखना; घड़ी
じぶん|jibun|自分|oneself|अपने आप; खुद; स्वयं/खुद
なのか|nanoka|七日|seven days; the seventh day|सात
あき|aki|秋|autumn|पतझड़
とおか|tooka|十日|ten days; the tenth day|दस
はる|haru|春|spring|वसंत
すいようび|suiyoubi|水曜日|Wednesday|बुधवार
さき|saki|先|the future; previous|भविष्य; पिछला; पूर्व; पूर्ववर्ती
せんげつ|sengetsu|先月|last month|गत मास
せんしゅう|senshuu|先週|last week|पिछला सप्ताह
まえ|mae|前|before|पहले
むら|mura|村|village|गाँव
たんじょうび|tanjoubi|誕生日|birthday|जन्मदिन
ひる|hiru|昼|noon; daytime|मध्याह्न; दोपहर; दिन; दिन के समय; दिन के
あさ|asa|朝|morning|सुबह
どようび|doyoubi|土曜日|Saturday|शनिवार
ふゆ|fuyu|冬|winter|सर्दी
はたち|hatachi|二十歳|20 years old; 20th year|२०; २०वाँ
はつか|hatsuka|二十日|twenty days; twentieth|बीस; बीसवाँ अंश; बीसवाँ
ふつか|futsuka|二日|two days; second day of the month|दूसरा
にちようび|nichiyoubi|日曜日|Sunday|रविवार
とし|toshi|年|year|साल
ようか|youka|八日|eight days; eighth day of the month|आठ; आठवाँ; आठ; आठवाँ भाग
はんぶん|hanbun|半分|half minute|आधा
ばん|ban|晩|evening|शाम
まいつき|maitsuki|毎月|every month|हर
まいしゅう|maishuu|毎週|every week|प्रति सप्ताह
まいあさ|maiasa|毎朝|every morning|प्रतिदिन सुबह
まいにち|mainichi|毎日|every day|हर दिन; नित्यप्रति
まいとし|maitoshi|毎年|every year|हर साल; प्रति वर्ष
まいばん|maiban|毎晩|every night|हर रात
まんねんひつ|mannenhitsu|万年筆|fountain pen|कलम
なまえ|namae|名前|name|नाम
あした|ashita|明日|tomorrow|कल
もくようび|mokuyoubi|木曜日|Thursday|गुरुवार
よる|yoru|夜|evening; night|शाम; रात
らいげつ|raigetsu|来月|next month|अगला
らいしゅう|raishuu|来週|next week|अगला सप्ताह
らいねん|rainen|来年|next year|अगला साल
れいぞうこ|reizouko|冷蔵庫|refrigerator|रेफ्रिजरेटर
むいか|muika|六日|six days; sixth day of the month|छह; सिक्स्थ; छठा; छठवाँ
ごぞんじ|gozonji|ご存じ|knowing; acquaintance|सुशिक्षित; जानकार; जानना; ज्ञान; पहचान; परिचित
さらいげつ|saraigetsu|さ来月|the month after next|
さらいしゅう|saraishuu|さ来週|the week after next|
わりあい|wariai|割合|rate; ratio; percentage|इसी रफ्तार से; दर्जा; कोटि; संबन्ध; अनुपात; अंश; अनुपात; प्रतिशतता
あいだ|aida|間|a space|आकाशीय; आकाश; अन्तरिक्ष
きせつ|kisetsu|季節|season|मौसम
ひさしぶり|hisashiburi|久しぶり|after a long time|बाद
こんど|kondo|今度|now; next time|अब; अगला
こんや|konya|今夜|tonight|आज रात
さいきん|saikin|最近|latest; nowadays|नया; नवीनतम; आधुनिकतम; आजकल
じだい|jidai|時代|era|कालअ; युग; युग/संवत कल्प
けしゴム|keshigomu|消しゴム|eraser|रबर
むかし|mukashi|昔|olden days; former|प्राचीन; अब तक; पुराना; भूतपूर्व
ひるま|hiruma|昼間|daytime; during the day|दिन; दिन के समय; दिन के; के दौरान
ひるやすみ|hiruyasumi|昼休み|noon break|मध्याह्न; दोपहर
ひ|hi|日|day; sun|दिन; सूरज
にっき|nikki|日記|journal|पत्रिका; डायरी; समाचार पत्र{साप्ताहिक या मासिक}
あした|ashita|明日|tomorrow|कल
よてい|yotei|予定|arrangement|सजावट; प्रक्रिया; व्यवस्थापन
おひる|ohiru|お昼|lunch; noon|दोपहर का खाना; मध्याह्न; दोपहर
いぜん|izen|以前|ago; since; before; previous|पहले; से; पहले
いちじ|ichiji|一時|moment; time|महत्व; क्षण; पल; समय
いっしょう|isshou|一生|whole life; a lifetime; all through life|पूरी तरह से; पूर्णतया; पूरा; जीवन काल; जीवनकाल
いっぱん|ippan|一般|general; liberal; universal; ordinary; average|साधारण; आम; सामान्य; उदार; दान शील; उदारचरित; सामान्य; मशीन का सर्वक्षम; सामान्य प्रत्यय
おんど|ondo|温度|temperature|ताप; तापमान
かよう|kayou|火曜|(abbr) Tuesday|मंगलवार
かこ|kako|過去|the past; bygone days; the previous|गत काल; विगत; पिछला; पूर्व; पूर्ववर्ती
がまん|gaman|我慢|patience; endurance; perseverance|संयम; धैर्य; सहनशीलता; सहनशीलता; सहन; तितिक्षा; अध्यवसाय; निरन्तर प्रयत्न/दृढता; दृढ़ता
がい|gai|害|injury; harm; evil influence; damage|घाव; क्षति; आकस्मिक चोट; अनिष्ट; क्षति; हानि; दुष्ट; बुरा; दुष्टता
かんり|kanri|管理|control; management (e.g. of a business)|शासन; संचालन करना; निपुणता; व्यवस्था; प्रबंध; प्रबन्धन
あいだ|aida|間|space; room; time; pause|आकाशीय; आकाश; अन्तरिक्ष; कमरा; समय
まちがい|machigai|間違い|mistake|गलती
まる|maru|丸|circle; full (month); perfection; purity; suffix for ship names|वृत्त; पंक्ति; घेरना; भरा; निपुणता; सब प्रकार से संतोषप्रद; संपूर्णता/निर्दोषता
きかん|kikan|期間|period; term|दौर; काल; युग; पद; अवधि; शब्द
きろく|kiroku|記録|record; minutes; document|अभिलेखबद्ध; लिखित प्रमाण; जीवन इतिहास; लिखित ब्योरा; लिखना; प्रपत्र; वृत्तचित्रित
きゅうか|kyuuka|休暇|holiday; day off; furlough|छुट्टी; छुट्टी का दिन; गैरहाजिरी की छुट्टी
きょうどう|kyoudou|共同|cooperation; association; collaboration; joint|सहकारिता/सहोद्योग; सहयोग; संबंध; संघ; समिति; सहयोग
きょうりょく|kyouryoku|協力|cooperation; collaboration|सहकारिता/सहोद्योग; सहयोग; सहयोग
きんだい|kindai|近代|present day|आधुनिक
きんよう|kinyou|金曜|(abbr) Friday|शुक्रवार
つき|tsuki|月|moon; month|चाँद; महीना
げつよう|getsuyou|月曜|Monday|सोमवार
げんざい|genzai|現在|present; up to now; nowadays; modern times; current|उपहार; अब तक; अभी तक; आजकल
げんだい|gendai|現代|nowadays; modern times; present-day|आजकल; आधुनिक; नया; वर्तमान
こきょう|kokyou|故郷|home town; birthplace; old village; historic village|घर; उद्गमस्थल; उद्गम; जन्मस्थान; पुराना
あと|ato|後|afterwards; since then; in the future|तत्पश्चात; बाद में; बाद; से
こうしゃ|kousha|後者|the latter|अनुवर्ती; दूसरा
こうりょ|kouryo|考慮|consideration; taking into account|ध्यान; विचार; मुआवजा; मनोहर; आसानी से मिलना; आकर्षक
ころ|koro|頃|time; about; toward; approximately (time)|समय; के बारे में; के निकट; की तरफ़; के लिए
いまに|imani|今に|before long; even now|पहले; इस समय; अब भी
いまにも|imanimo|今にも|at any time; soon|जल्द ही
こんかい|konkai|今回|now; this time; lately|अब; हाल में; हाल ही में
こんご|kongo|今後|from now on; hereafter|भविष्य में; मरणोत्तर जीवन; मरनोपरांत
きょう|kyou|今日|today; this day|आज
こんやく|konyaku|婚約|engagement; betrothal|वचन; सगाई; वाग्दान; सगाई; वागदान
さく|saku|昨|last (year); yesterday|आखिरी; कल
し|shi|氏|family name; lineage; birth|कुलनाम; कुल; जाति; गौत्र; जन्म
とき|toki|時|(1) time; hour; (2) occasion; moment|समय; घंटा; घटना; अवसर; कारण बनना
じき|jiki|時期|time; season; period|समय; मौसम; दौर; काल; युग
じこく|jikoku|時刻|instant; time; moment|तुरंत; क्षण; क्षणिक; समय; महत्व; क्षण; पल
じっし|jisshi|実施|enforcement; enact; put into practice; carry out; operation|प्रवर्तन; कानून बनाना; अभिनय करना; कानून; रखना
てま|tema|手間|time; labour|समय; जी तोड़ कोशिश करना; मजदूर वर्ग; श्रमजीवी वर्ग
しゅう|shuu|週|week|सप्ताह
しゅうかん|shuukan|週間|week; weekly|सप्ताह; साप्ताहिक पत्र; साप्ताहिक समाचार पत्र; साप्ताहिक
じゅうし|juushi|重視|importance; stress; serious consideration|प्रतिष्ठा; महत्व; गुरुत्व; दबाव; महत्त्व; जोर; जटिल; महत्वपूर्ण; रहस्यमय
しゅんかん|shunkan|瞬間|moment; second; instant|महत्व; क्षण; पल; दूसरा; तुरंत; क्षण; क्षणिक
こづつみ|kozutsumi|小包|parcel; package|पार्सल; गठरी; टुअक्ड़े टुकड़े करना; भरना; पैकेज; पैकेट
しょうねん|shounen|少年|boys; juveniles|
しょうにん|shounin|承認|recognition; acknowledgement; approval; consent; agreement|मान्यता; पहचान; स्वीकार; स्वीकृति; अभिस्वीकृति; पावती; स्वीकृति; पसंदगी; समर्थन
しょうがい|shougai|障害|obstacle; impediment (fault); damage|अवरोध; रुकावट; अवरोध/अटकाव; बाधा; हकलाहट; विघ्न; क्षति; क्षति पहुँजाना; बिगाड़ना
よのなか|yononaka|世の中|society; the world; the times|वर्ग; साथ; सभा; दुनिया; परिस्थिति; समय; बार
せけん|seken|世間|world; society|दुनिया; वर्ग; साथ; सभा
せいき|seiki|世紀|century; era|शताब्दी; शैली; सौ गज की दौड़; कालअ; युग; युग/संवत कल्प
しょうご|shougo|正午|noon; mid-day|मध्याह्न; दोपहर
せいねん|seinen|青年|youth; young man|ताज़गी; नवयुवक; युवावस्था; नवयुवक; प्रेमी; किशोर
せんじつ|senjitsu|先日|the other day; a few days ago|हाल ही में
いずみ|izumi|泉|spring; fountain|वसंत; झरना; फव्वारा; जलयंत्र
ぜんしゃ|zensha|前者|the former|पहला
ぜんしん|zenshin|前進|advance; drive; progress|अग्रसर होना; आगे बढना; प्रयास; चलाना; आगे बढना; विकास करना; चलना
そうさ|sousa|操作|operation; management; processing|कार्य; आपरेशन; काम; व्यवस्था; प्रबंध; प्रबन्धन; संसाधन; प्रसंस्करण
そうとう|soutou|相当|suitable; fair; tolerable; proper|योग्य; ठीक; उपयुक्त; न्याय; सुन्दर; सीधा; सहनीय; कामचलाऊ; औसत दर्जे का
そん|son|損|loss; disadvantage|नष्ट करना; असफल; हानि; प्रतिकूल; नुक्सान; प्रतिकूल परिस्थिति
そんがい|songai|損害|damage; injury; loss|क्षति; क्षति पहुँजाना; बिगाड़ना; घाव; क्षति; आकस्मिक चोट; नष्ट करना; असफल; हानि
だいり|dairi|代理|representation; agency; proxy; deputy; agent|अभ्यावेदन; मूर्ति; चिट्रण; माध्यम; संस्था; संस्था {कर्तृत्व}; मुख्तारी; प्रतिनिधि; प्रतिनिधित्व
だいぶぶん|daibubun|大部分|most part; greater part; majority|अधिक; और; और अधिक; बहुमत; अधिकांश; वयस्कता
ちしき|chishiki|知識|knowledge; information|जानकारी; अवबोधन; ज्ञान; जानकारी
ちゅうこ|chuuko|中古|(1) used; second-hand; old|पुराना; आदी; प्रयुक्त; पुराना
ちゅうし|chuushi|中止|suspension; stoppage; discontinuance; interruption|स्थगन; निलम्बन; थोड़े समय के लिये रुकावट; विराम; अवरोध; रुकावट
なかま|nakama|仲間|company; fellow; colleague; associate|कंपनी; सभासद; व्यक्ति; आदमी; सहकार्यकर्ता; सहकर्मी
てきど|tekido|適度|moderate|औसत दर्जे; कम; कम होना
てつや|tetsuya|徹夜|all night; all night vigil; sleepless night|पूरी रात चलनेवाला; निद्रारहित
とたん|totan|途端|just (now; at the moment; etc.)|इस समय; अब; अभी अभी; इस समय; आदि
どよう|doyou|土曜|Saturday|शनिवार
とうじ|touji|当時|at that time; in those days|
など|nado|等|et cetera; etc.; and the like|आदि; आदि
どくりつ|dokuritsu|独立|independence (e.g. Ind. Day); self-support|स्वतंत्र; स्वतंत्रता; स्वाधीनता
はたち|hatachi|二十|20 years old; 20th year|२०; २०वाँ
ひ|hi|日|sun; sunshine; day|सूरज; खुशीई; धूपअ; प्रसन्न; दिन
にっこう|nikkou|日光|sunlight|धूप
にっちゅう|nicchuu|日中|daytime; broad daylight|दिन; दिन के समय; दिन के; दिन दहाड़े
ひづけ|hizuke|日付|date; dating|तारीख
にほん|nihon|日本|Japan|एक प्रकार की वार्निश; रोग़न करके चमकाना; जापान
にちよう|nichiyou|日曜|Sunday|रविवार
ねんかん|nenkan|年間|year|साल
としより|toshiyori|年寄|old people; the aged|पुराना; बूढ़े लोग
ねんげつ|nengetsu|年月|months and years|
ねんだい|nendai|年代|age; era; period; date|उम्र; कालअ; युग; युग/संवत कल्प; दौर; काल; युग
ねんじゅう|nenjuu|年中|whole year; always; everyday|पूरी तरह से; पूर्णतया; पूरा; हमेशा; साधारण; प्रतिदिन; एक
ねんれい|nenrei|年齢|age; years|उम्र; बहुत समय; बढ़ती उम्र; लम्बा समय
ひがい|higai|被害|damage|क्षति; क्षति पहुँजाना; बिगाड़ना
びょう|byou|秒|second (60th min)|दूसरा
ふり|furi|不利|disadvantage; handicap; unfavorable; drawback|प्रतिकूल; नुक्सान; प्रतिकूल परिस्थिति; कठिनाई; स्प्रतिबंद्ध; असमर्थ; प्रतिकूल; नकारात्मक
ぶぶん|bubun|部分|portion; section; part|हिस्सा; भाग; खुराक; वर्ग; दल; काटना; भाग
ぶん|bun|分|dividing; part|द्वैधीकरण; भाग
ぶんせき|bunseki|分析|analysis|विश्लेषण; समीक्षा
ぶんや|bunya|分野|field; sphere; realm; division; branch|कार्य क्षेत्र; आधार; खेलनेवाल दल; वृत्त; गोला; क्षेत्र; क्षेत्र; राज्य
へいきん|heikin|平均|equilibrium; balance; average; mean|संतुलन; साम्य; बराबर करना; हिचकिचाना; सँभालना; सामान्य; औसत; औसत निकालना
へんこう|henkou|変更|change; modification; alteration|बदलना; सुधार; उपांतरण; परिवर्तन; फेरबदल; प्रत्यावर्तन
ほぞん|hozon|保存|preservation; conservation; storage; maintenance|संरक्षण; परिरक्षित फल या सुरक्षित स्थान; परिरक्षण; संरक्षण; प्राकृतिक संरक्षण; संरक्षन; संचयन; भखाई का खार्चा; संग्रहअ
つつみ|tsutsumi|包み|bundle; package; parcel; bale|भरना; बहुत ज़्यादा; गट्ठा; भरना; पैकेज; पैकेट; पार्सल; गठरी; टुअक्ड़े टुकड़े करना
みらい|mirai|未来|future (life; tense)|भविष्य; गुस्सा; कठिन; काल
あかり|akari|明かり|lamplight; light (in general); brightness|दीपक की; दीपक की रोशनी; दीप प्रकाश/लैम्प की रौशनी; रोशनी; चमक; कीर्ति; जगमगाहट
みょうごにち|myougonichi|明後日|day after tomorrow|दिन
もくよう|mokuyou|木曜|Thursday|गुरुवार
よる|yoru|夜|evening; night|शाम; रात
よなか|yonaka|夜中|midnight; dead of night|मध्यरात्री; आधी रात; अर्द्धरात्री; मृत
よあけ|yoake|夜明け|dawn; daybreak|होना; निकलना; सामने आना; भोर; अरुणोदय/प्रातःकाल/सबेरा/तड़के; ऊषा
ゆうり|yuuri|有利|advantageous; better; profitable; lucrative|लाभकारी; लाभदायक; लाभप्रद; बेहतर; लाभदायक; फायदेमंद
ゆうべ|yuube|夕べ|evening|शाम
よぶん|yobun|余分|extra; excess; surplus|अधिक; अतिरिक्त; अतिरिक्त वस्तु; बहुत अधिक; अधिशेष; अधिकता; आवश्यकता से अधिक; अधिशेष; अतिरिक्त
よゆう|yoyuu|余裕|surplus; composure; margin; room; time; allowance; scope; rope|आवश्यकता से अधिक; अधिशेष; अतिरिक्त; आत्मसंयम; धैर्य; हद; हाशिया; अतिरिक्त राशि
ようび|youbi|曜日|day of the week|दिन
りつ|ritsu|率|rate; ratio; proportion; percentage|इसी रफ्तार से; दर्जा; कोटि; संबन्ध; अनुपात; अंश; अनुपात; समानुपात
かご|kago|籠|basket; cage|अंक; डलिया; टोकरी; पिंजरा; बन्द करना; कटघरा
おかわり|okawari|お代わり|second helping; another cup|दूसरा; भिन्न; दूसरा; एक अन्य
いご|igo|以後|after this; from now on; hereafter; thereafter|बाद; भविष्य में; मरणोत्तर जीवन; मरनोपरांत
おととい|ototoi|一昨日|day before yesterday|दिन
おととし|ototoshi|一昨年|year before last|साल
いったん|ittan|一旦|once; for a moment; one morning; temporarily|एक बार
ひきわけ|hikiwake|引分け|a draw (in competition); tie game|चित्र बनाना; मिलाना; संबंध; लटकाना
おんせん|onsen|温泉|spa; hot spring; onsen|खनिज जल स्रोत; स्वास्थ्य प्रशिक्षण केंद्र; स्वास्थ्य केंद्र; गरम; गरम सोता; गरम पानी का सोता
おんたい|ontai|温帯|temperate zone|समशीतोष्ण; सम शीतोष्ण; संतुलित
げじゅん|gejun|下旬|month (last third of)|महीना
なにぶん|nanibun|何分|what minute?; how many minutes?|क्या; कैसे
かそく|kasoku|加速|acceleration|गति वर्धन; बढ़ोतरी; गतिवृद्धि
かそくど|kasokudo|加速度|acceleration|गति वर्धन; बढ़ोतरी; गतिवृद्धि
かけつ|kaketsu|可決|approval; adoption (e.g. motion; bill); passage|स्वीकृति; पसंदगी; समर्थन; स्वीकार करना[होना]; स्वीकार; अंगीकार करना; घोषित; घोषित करना; बिल
かいほう|kaihou|解放|release; liberation; emancipation|बताना; प्रदर्शन; निकालना; मुक्ति; आज़ादी; अपवर्ग; आज़ादी; असवर्ग
かいせい|kaisei|改正|revision; amendment; alteration|सुधार; पुनर्लेखन; दोहराई; सुधार; संशोधन; संशौधन्; परिवर्तन; फेरबदल; प्रत्यावर्तन
かいほう|kaihou|開放|open; throw open; liberalization|खोलना; खोल देना; उदारीकरण
がいろん|gairon|概論|intro; outline; general remarks|रूपरेखा; दर्शाना; खाका; साधारण; आम; सामान्य
がくねん|gakunen|学年|year in school; grade in school|साल; कोटि; पद; वर्गीकृत करना
かんかく|kankaku|間隔|space; interval; SPC|आकाशीय; आकाश; अन्तरिक्ष; विराम; अंतराल; अन्तराल
かんせつ|kansetsu|間接|indirection; indirectness|
いくぶん|ikubun|幾分|somewhat|कुछ; किंचित; थोड़ा बहुत
きげん|kigen|期限|term; period|पद; अवधि; शब्द; दौर; काल; युग
きゃくま|kyakuma|客間|parlor; guest room|बैठक; स्वागत कक्ष; अतिथि कक्ष
ひびき|hibiki|響き|echo; sound; reverberation; noise|हाँ में हाँ मिलाना; गूँज; छाया झलकना; आवाज़; गूँज; प्रतिध्वनि
くぶん|kubun|区分|division; section; classification|वर्ग; हिस्सा; श्रेणी; वर्ग; दल; काटना; वर्गीकरण; श्रेणीविभाजन
すきま|sukima|隙間|crevice; crack; gap; opening|दरार; करना; पता; मौका; कमी; अन्तर; दरार
げっきゅう|gekkyuu|月給|monthly salary|मासिक; प्रतिमास; मसिक
つきひ|tsukihi|月日|time; years; days|समय; बहुत समय; बढ़ती उम्र; लम्बा समय
げつまつ|getsumatsu|月末|end of the month|अंत
のり|nori|糊|paste; starch|चिपकाना; लेई; सटाना; श्वेतसारयुक्त भोज्य पदार्थ; माड़ी; श्वेतसार
こうはい|kouhai|後輩|junior (at work or school)|छोटा; क्निष्ठ; उम्र में छोटा
こうぶつ|koubutsu|鉱物|mineral|धातु; प्राकृतिक; पदार्थ
さらいげつ|saraigetsu|再来月|month after next|महीना
さらいしゅう|saraishuu|再来週|week after next|सप्ताह
さらいねん|sarainen|再来年|year after next|साल
さいじつ|saijitsu|祭日|national holiday; festival day|राष्ट्रजन; देशभक्त; रजवंशी; समारोह; त्योहार; त्यौहार/उत्सव
さくじょ|sakujo|削除|elimination; cancellation; deletion; erasure|निष्कासन; मलत्याग; निरस्तीकरण; मिटा हुआ; अपमार्जन
みかづき|mikazuki|三日月|new moon; crescent moon|अमावस्या; नव्चन्द्र; दूज का चाँद; नवचन्द्र; वर्धमान/बढ़नेवाला; अर्धेन्दु
しき|shiki|四季|four seasons|चार
じかんわり|jikanwari|時間割|timetable; schedule|समयसारिणी; समयसारिणी के अनुसार योजना करना; टाइमटेबल; अनुसूची; योजना लेख; सूची
じそく|jisoku|時速|speed (per hour)|चलाना; जल्दी करना; भगाना
おさめる|osameru|治める|(1) to govern; to manage; (2) to subdue|प्रभावित करना; संचालन करना; निर्धारित करना; देखभाल करना; रखना; लेना; रोकना; शान्त करना; वस में लाना
てまえ|temae|手前|before; this side; we; you|पहले; हम
しゅうへん|shuuhen|周辺|circumference; outskirts; environs; (computer) peripheral|परिधि; घेरा; मंडल; उपांत; बाहरी इलाका; परिप्रदेश
しゅくじつ|shukujitsu|祝日|national holiday|राष्ट्रजन; देशभक्त; रजवंशी
とこのま|tokonoma|床の間|alcove|आला; आला{कुँज}
うけたまわる|uketamawaru|承る|(hum) to hear; to be told; to know|सुनना; पहचान
じょうじゅん|joujun|上旬|first 10 days of month|पहला
ねまき|nemaki|寝間着|sleep-wear; nightclothes; pyjamas; nightgown; nightdress|राट्रि पोशाक; सोने के कपड़े; पायजामा
しんや|shinya|深夜|late at night|देर
みぶん|mibun|身分|social position; social status|सामाजिक; समाजपरक; सम्मिलित; सामाजिक; समाजपरक; सम्मिलित
すいぶん|suibun|水分|moisture|नमी; सीलन; आर्द्रता
すいよう|suiyou|水曜|Wednesday|बुधवार
せいぶん|seibun|成分|ingredient; component; composition|उपादान; घटक; संघटक; अंश; घटक; आंशिक; बनावट; लेखन; संरचना
はえる|haeru|生える|(1) to grow; to spring up; (2) to cut (teeth)|उगना; उत्पन्न होना; उगना; निर्माण; काटना
せいねんがっぴ|seinengappi|生年月日|birth date|जन्म
せいれき|seireki|西暦|Christian Era; anno domini (A.D.)|ईस्वी; ईस्वी
せいしょうねん|seishounen|青少年|youth; young person|ताज़गी; नवयुवक; युवावस्था; जवान
せんせんげつ|sensengetsu|先々月|month before last|महीना
さきほど|sakihodo|先程|some time ago|
ぜんご|zengo|前後|around; throughout; front and back; before and behind; before and after|आस पास; लगभग; तक; में; पूर्णतया; भर में; सामने
そうしき|soushiki|葬式|funeral|दफन; क्रिया कर्म; अन्त्येष्टि
ぞんじる|zonjiru|存じる|(hum) to know|पहचान
そんとく|sontoku|損得|loss and gain; advantage and disadvantage|नष्ट करना; असफल; हानि; एडवांटेज{टैनिस के केल में ड्युस उपरांत अर्जित पहला प्वाइंट}; सहायता करना; लाभ
かしま|kashima|貸間|room to let|कमरा
だっせん|dassen|脱線|derailment; digression|पटरी से उतरना; अवपथन; व्यतिक्रम; भटकाव
ちゅうかん|chuukan|中間|middle; midway; interim|बीच; बीच; मिडवे; बीच का; अंतरिम; अन्तरिम अवधि; अल्पकालीन
ちゅうじゅん|chuujun|中旬|second third of a month|दूसरा
ちゅうせい|chuusei|中世|Middle Ages; mediaeval times|मध्य युग; मध्य; मध्यकालीन
ちゅうねん|chuunen|中年|middle-aged|
ひるね|hirune|昼寝|nap (at home); siesta|झपकी; अल्प निद्रा; झपकी लेना; दोपहर का आराम
ちょぞう|chozou|貯蔵|storage; preservation|संचयन; भखाई का खार्चा; संग्रहअ; संरक्षण; परिरक्षित फल या सुरक्षित स्थान; परिरक्षण
ちょくご|chokugo|直後|immediately following|ठीक; उसी समय; तत्काल
ちょくぜん|chokuzen|直前|just before|बस
ていし|teishi|停止|suspension; interruption; stoppage; ban|स्थगन; निलम्बन; थोड़े समय के लिये रुकावट; बाधा; अवरोध; रुकावट; विराम; अवरोध; रुकावट
ていきけん|teikiken|定期券|commuter pass; season ticket|आना जाना करने; आना जाना करने वाला; मौसमी टिकट; मियादी टिकट
ていきゅうび|teikyuubi|定休日|regular holiday|रोज का ग्राहक; योग्य; मठजीवी
とうじつ|toujitsu|当日|appointed day; very day|नियत
とうぶん|toubun|等分|division into equal parts|वर्ग; हिस्सा; श्रेणी
ひので|hinode|日の出|sunrise|नवोदित और विकासशील; सूर्योदय
ひのいり|hinoiri|日の入り|sunset|सूर्यास्त; समापक; डूबता
ひかげ|hikage|日陰|shadow|सितारा मछली; सूट्र; शरण
にっか|nikka|日課|daily lesson; daily work; daily routine|दिन; दैनिक; हमेशा; दिन; दैनिक; हमेशा; दिन; दैनिक; हमेशा
ひがえり|higaeri|日帰り|day trip|एक दिवसीय; एक दिवसीय यात्रा
にちじ|nichiji|日時|date and time|तारीख
にってい|nittei|日程|agenda|करने वाली कार्यवाही; कार्यसूची
ひあたり|hiatari|日当たり|exposure to the sun; sunny place|प्रदर्शन; विवरण; दिशा; हँसमुख; उजला/धूपवाला; धूपदार
ひにち|hinichi|日日|every day; daily; day after day|हर दिन; नित्यप्रति; दिन; दैनिक; हमेशा; कई दिनों तक लगातार
にちようひん|nichiyouhin|日用品|daily necessities|दिन; दैनिक; हमेशा
ねんど|nendo|年度|year; fiscal year; school year; term|साल; वित्तीय वर्ष; वित्त वर्ष; अकादमिक वर्ष; शालीय वर्ष
のうそん|nouson|農村|agricultural community; farm village; rural|कृषि; कृषिक; खेती बारी का; खेत; देहाती; ग्रामीण; ग्राम्य
はつでん|hatsuden|発電|generation (e.g. power)|युग; प्रजनन; युगअ
はんせい|hansei|反省|reflection; reconsideration; introspection; meditation; contemplation|झलक; परछाई; आरोप; पुनर्विचार; आत्मविश्लेषण; अंतरावलोकन; आत्ममंथन
ものおき|monooki|物置|storage room|संचयन; भखाई का खार्चा; संग्रहअ
ぶんかい|bunkai|分解|analysis; disassembly|विश्लेषण; समीक्षा
ぶんすう|bunsuu|分数|fraction (in math)|भिन्न; थोड़ा; खंड
ぶんぷ|bunpu|分布|distribution|वितरण; विभाजन; वितरनअ
ぶんりょう|bunryou|分量|amount; quantity|कुछ हद तक; मात्रा; राशि; परिमाण; मात्रा; संख्या
ぶんるい|bunrui|分類|classification|वर्गीकरण; श्रेणीविभाजन
へいじつ|heijitsu|平日|weekday; ordinary days|कार्य दिवस; कार्य दिवसीय; रविवार को छोड़कर कोई दिवस; साधारण; स्वाभाविक; सामान्य
べっそう|bessou|別荘|holiday house; villa|छुट्टी; देहाती; गृह; देहाती बँगला
ほうたい|houtai|包帯|bandage; dressing|पट्टी लगाना; पट्टी; पट्टी बाँधना; सजावट; मसाला; कपड़े पहनना
まいど|maido|毎度|each time; common service-sector greeting|सामान्य
みんかん|minkan|民間|private; civilian; civil; popular; folk; unofficial|गुप्त; साधारण; आत्मीय; असैनिक कर्मचारी; असैनिक; असैनिक नागरिक; सभ्य; नम्र; नागरिक
あき|aki|明き|room; time to spare; emptiness|कमरा; समय; शून्य; खालीपन; शून्यता
やかん|yakan|夜間|at night; nighttime|निशा; रात्रिकालीन; निशा काल
やこう|yakou|夜行|walking around at night; night train; night travel|चलना; पैदल चल कर; टहलना; रात; रात
いさましい|isamashii|勇ましい|brave; valiant; gallant; courageous|ललकार; ललकारना; सामना करना; वीरतापूर्ण; साहसी; वीर; शानदार; साहसिक; बहादुर
ゆうかん|yuukan|夕刊|evening paper|सायंकालिन अखबार; सायंकालिन
ゆうひ|yuuhi|夕日|(in) the evening sun; setting sun|जड़ा; समायोजन; स्थान
ゆうだち|yuudachi|夕立|(sudden) evening shower (rain)|शाम
ようぶん|youbun|養分|nourishment; nutrient|पालन; पुष्टिकारक पदार्थ; पोषण; पोषक; पोषक तत्व
ゆかた|yukata|浴衣|bathrobe; informal summer kimono; yukata|ढीला वस्ट्र; ड्रेसिंग गाऊन; ढीला ढाला; अनौपचारिक; सदा; अनाधिकारिक
りがい|rigai|利害|advantages and disadvantages; interest|रुचि
りんじ|rinji|臨時|temporary; special; extraordinary|अल्पकालीन; अस्थायी कर्मचारी; अस्थायी; विशेष; असाधारण; विशेष; अनोखी
れいとう|reitou|冷凍|freezing; cold storage; refrigeration|बहुत; हिमतापी; बहुत ठंडा; शीत संग्रहागार; शीतागार; शीत संग्रहण; प्रशीतन; ठण्डा करना
おやすみ|oyasumi|お休み|holiday; absence; rest; Good night|छुट्टी; अनुपस्थिति; अभाव; मृदु अपस्मार; आराम
おはよう|ohayou|お早う|Good morning|सुप्रभात
かげつ|kagetsu|ヶ月|#NAME?|
このあいだ|konoaida|この間|the other day; lately; recently|हाल ही में; हाल में; हाल ही में; हाल ही में; अभी अभी; हाल मेँ
あっか|akka|悪化|deterioration; growing worse; aggravation; degeneration; corruption|कमी; विकृति; अवनति; बढ़ता; प्रगतिशील; परेशानी; क्रोध; क्षोभ
あくび|akubi|悪日|unlucky day|अशुभ; अभागा/दुखी/मंदभाग्य; दुर्भाग्यशाली
ひところ|hitokoro|一頃|once; some time ago|एक बार
さきおととい|sakiototoi|一昨昨日|two days before yesterday|
ちょっと|chotto|一寸|(ateji) (adv int) (uk) just a minute; a short time; a while; just a little; somewhat; easily; readily; rath|एक मिनट रुकिए; अल्पावधि; अल्प अवधि; अल्पकाल; काल; समय; यद्यपि
ついたち|tsuitachi|一日|(1) one day; (2) first of month|एक न एक दिन; पहला
いちぶぶん|ichibubun|一部分|a part|भाग
ひきわけ|hikiwake|引き分け|a draw (in competition); tie game|चित्र बनाना; मिलाना; संबंध; लटकाना
うんえい|unei|運営|management; administration; operation|व्यवस्था; प्रबंध; प्रबन्धन; देना; दवा; दवा देना; कार्य; आपरेशन; काम
えいぞう|eizou|映像|reflection; image|झलक; परछाई; आरोप; कल्पना करना; चित्र; धारणा
のべ|nobe|延べ|futures; credit (buying); stretching; total|वायदे के सौदे; विश्वास दिलाना; जमा; मान्यता
えんがわ|engawa|縁側|veranda; porch; balcony; open corridor|बरामदा; बरामदा; द्वारमण्डप; प्रकोष्ठ; बरामदा; छज्जा; बाल्कनी
えんだん|endan|縁談|marriage proposal; engagement|शादी; विवाह; पाणि ग्रहन् संस्कार; वचन; सगाई; वाग्दान
おんわ|onwa|温和|gentle; mild; moderate|धीमा; हल्की; हल्का; हल्का; सुहावना; विनम्र; औसत दर्जे; कम; कम होना
したじ|shitaji|下地|groundwork; foundation; inclination; aptitude; elementary knowledge of; grounding in; prearrangement; spade|आधारकर्म; आधार; प्रतिष्ठान; संस्था; रुचि; झुकाव; शौक
いつ|itsu|何時|when; how soon|कब; कैसे
いつか|itsuka|何時か|sometime; someday; one day; some time or other; the other day; in due course; in time|कुछ समय; एक दिन; कभी भविष्य में; एक न एक दिन
いつでも|itsudemo|何時でも|(at) any time; always; at all times; never (neg); whenever|किसी भी समय; हमेशा; हमेशा
いつのまにか|itsunomanika|何時の間にか|before one knows; unnoticed; unawares|पहले; अदृष्ट/बेखबर/अज्ञात/अचानक; अलक्षित; अचानक; एकाएक; अकस्मात्
いつまでも|itsumademo|何時までも|forever; for good; eternally; as long as one likes; indefinitely|हमेशा; हमेशा के लिए; सदैव; सदा के लिए; अनन्तकाल; अनन्तकाल तक
かく|kaku|佳句|beautiful passage of literature|सुंदर
ひま|hima|暇|free time; leisure; leave; spare time; farewell|मुक्त; खाली समय/फुरसत; फुरसत; छोड़ना
はかない|hakanai|果ない|fleeting; transient; short-lived; momentary; vain; fickle; miserable; empty; ephemeral|अस्थिर; क्षणिक; क्षणभंगुर; अस्थिर; क्षणिक; चलायमान
に|ni|荷|load; baggage; cargo|भारी; मिश्रण; भरना; वेश्या; सामान; यात्री का सामान/सामान; माल; जहाज मे लदा; जहाज़ का बोझ/खेप
かへい|kahei|貨幣|money; currency; coinage|पैसा; मुद्रा; लोकप्रियता; व्यापकता; सितारा मछली; गढ़ना; सिक्का
すぎ|sugi|過ぎ|past; after|अतीत; बाद
がいせつ|gaisetsu|概説|general statement; outline|साधारण; आम; सामान्य; रूपरेखा; दर्शाना; खाका
がいねん|gainen|概念|general idea; concept; notion|साधारण; आम; सामान्य; विचार; प्रत्यय; संकल्पना; इच्छा; धारणा; विचार
かくしゅう|kakushuu|隔週|every other week|हर
かんむり|kanmuri|冠|crown; diadem; first; best; peerless; cap; naming; designating; initiating on coming of age; top character ra|शिखर; सिर पर मारना; सिर; पहला
すすめ|susume|勧め|recommendation; advice; encouragement|विशेषता; समझौता; सिफ़ारिश; सलाह; हौसला; प्रोत्साहन
かんゆう|kanyuu|勧誘|invitation; solicitation; canvassing; inducement; persuasion; encouragement|संदेश पत्र; दावत; उपहार
たまらない|tamaranai|堪らない|intolerable; unbearable; unendurable|असहनीय; असह्य; असहनीय; असह्य; असहनीय
かんよう|kanyou|寛容|forbearance; tolerance; generosity|धैर्य; सहिष्णुता; उदारता; सहिष्णुता; सहनशीलता; उदारता
かんぶ|kanbu|幹部|management; (executive) staff; leaders|व्यवस्था; प्रबंध; प्रबन्धन; कर्मचारी; शिक्षक; भरा हुआ होना
かんれき|kanreki|還暦|60th birthday|६०वाँ
あいだがら|aidagara|間柄|relation(ship)|नाता; संबंध; रिश्तेदारी
きこん|kikon|既婚|marriage; married|शादी; विवाह; पाणि ग्रहन् संस्कार; विवाहित; ब्याहता
き|ki|期|period; time|दौर; काल; युग; समय
きじつ|kijitsu|期日|fixed date; settlement date|स्थिर; निर्धारित; स्थायी; निपटारा; समझौता; भुगतान
ぎだい|gidai|議題|topic of discussion; agenda|विषय; प्रसंग; करने वाली कार्यवाही; कार्यसूची
ひさしぶり|hisashiburi|久し振り|after a long time|बाद
ぎょそん|gyoson|漁村|fishing village|मछली पकड़ना; मछली; मछली मारना
きょうわ|kyouwa|共和|republicanism; cooperation|गणतंत्रवाद; गणतंत्र प्रणाली; सहकारिता/सहोद्योग; सहयोग
きょうちょう|kyouchou|協調|co-operation; conciliation; harmony; firm (market) tone|शान्त करना; समाधान; मधुर सम्बन्ध; तालमेल; समानता
まちまち|machimachi|区々|1.  several; various; divergent; conflicting; different; diverse; 2.  trivial|एक; भिन्न; कई; अनेक; भिन्न; अपसारी
くかん|kukan|区間|section (of track  etc)|वर्ग; दल; काटना
あきま|akima|空間|vacancy; room for rent or lease|खाली जगह; अवकाश; खाली स्थान; कमरा
けい|kei|系|system; lineage; group|शरीर; व्यवस्था; पद्धति; कुल; जाति; गौत्र; समूह
けいか|keika|経過|passage; expiration; progress|परिवर्तन; स्वीकृति; किराया; समाप्ति; मृत्यु; अवसान; आगे बढना; विकास करना; चलना
げきれい|gekirei|激励|encouragement|हौसला; प्रोत्साहन
けつぼう|ketsubou|欠乏|want; shortage; famine|चाहना; कमी; अकाल; दुर्भिक्ष
げっしゃ|gessha|月謝|monthly tuition fee|मासिक; प्रतिमास; मसिक
つきひ|tsukihi|月日|(the) date|तारीख
げっぷ|geppu|月賦|monthly installment|मासिक; प्रतिमास; मसिक
つきなみ|tsukinami|月並み|every month; common|हर; सामान्य
たてまえ|tatemae|建前|face; official stance; public position or attitude (as opposed to private thoughts)|चेहरा; प्रामाणिक; अधिकारी; सरकारी; प्रजा; लोग; आम
みあい|miai|見合い|formal marriage interview|शिष्टाचार के अनुकूल; सुव्यवस्थित; औपचारिक
がんねん|gannen|元年|first year (of a specific reign)|पहला
げんそく|gensoku|原則|principle; general rule|मर्यादा; विधि; सूट्र; साधारण; आम; सामान्य
いにしえ|inishie|古|antiquity; ancient times|प्राचीन काल; पुरावस्तु; पुरातनता; पुराना; प्राचीन; बहुत पुराना
こだい|kodai|古代|ancient times|पुराना; प्राचीन; बहुत पुराना
こちょう|kochou|誇張|exaggeration|अतिशयोक्ति; विस्तार; अतिशयोक्तिपूर्ण
うるさい|urusai|五月蝿い|noisy; loud; fussy|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला; तीव्र; ऊँचा; प्रबल; हड़बड़ाहट भरा; अति; मीन मेख निकालने वाला
あとまわし|atomawashi|後回し|putting off; postponing|मारना
こうかい|koukai|後悔|regret; repentance|दुःखी होना; खेद होना; पश्चाताप करना; पश्चात्ताप; पछतावा
こうたい|koutai|後退|retreat; backspace (BS)|गिरना; पीछे हटना; भागना; एक स्थान से पीछे जाना
"""), "ja", "N4", "kanji"),

        Lesson("kw-family", "👨‍👩‍👧 Family & People · 家族・人", "👨‍👩‍👧", "206 kanji words", kw("""
おにいさん|oniisan|お兄さん|(honorable) older brother|बड़ा भाई
おねえさん|oneesan|お姉さん|(honorable) older sister|बड़ी बहन
おとうさん|otousan|お父さん|(honorable) father|पिता
おかあさん|okaasan|お母さん|(honorable) mother|माँ
ひとり|hitori|一人|one person|
おくさん|okusan|奥さん|(honorable) wife|पत्नी
かぞく|kazoku|家族|family|परिवार
あに|ani|兄|(humble) older brother|बड़ा भाई
きょうだい|kyoudai|兄弟|(humble) siblings|सगे भाई बहन
けいかん|keikan|警官|policeman|सिपाही
ふるい|furui|古い|old (not used for people)|पुराना
あね|ane|姉|(humble) older sister|बड़ी बहन
こども|kodomo|子供|child|बच्चा
おんな|onna|女|woman|महिला
おんなのこ|onnanoko|女の子|girl|लड़की
じょうぶ|joubu|丈夫|strong; durable|मजबूत; टिकाऊ
ひと|hito|人|person|व्यक्ति
だいじょうぶ|daijoubu|大丈夫|all right|ठीक; स्वस्थ; निःसन्देह
おとな|otona|大人|adult|वयस्क
おとこ|otoko|男|man|आदमी
おとこのこ|otokonoko|男の子|boy|लड़का
おとうと|otouto|弟|younger brother|सहोदर; अनुज
ふたり|futari|二人|two people|
伯父/叔父||伯父/叔父|grandfather; male senior citizen|दादा; पुलिंग; पुरुष; प्रेमी
伯母さん/叔母さん||伯母さん/叔母さん|aunt|चाची
ぼうし|boushi|帽子|hat|टोपी
いもうと|imouto|妹|(humble) younger sister|छोटी बहन
ともだち|tomodachi|友達|friend|दोस्त
りょうしん|ryoushin|両親|both parents|दोनों
かない|kanai|家内|housewife|गृहिणी; घर की संचालिका; गृहस्वामिनी
きゃく|kyaku|客|guest; customer|मेहमान; ग्राहक; असामी; खरीदनेवाला
ごしゅじん|goshujin|御主人|(honorable) your husband|तुम्हारा
つま|tsuma|妻|(humble) wife|पत्नी
こ|ko|子|child|बच्चा
じょせい|josei|女性|woman|महिला
おや|oya|親|parents|अभिभावक
にんぎょう|ningyou|人形|doll; figure|सुन्दरी; गुड़िया; नमूना; विचार करना; कल्पना करना
じんこう|jinkou|人口|population|लोग; जन; जनता
そふ|sofu|祖父|grandfather|दादा
そぼ|sobo|祖母|grandmother|दादी
むすこ|musuko|息子|(humble) son|बेटा
だんせい|dansei|男性|male|पुलिंग; पुरुष; प्रेमी
かれ|kare|彼|he; boyfriend|वह; सनम; प्रेमी; पुरूष मित्र
かのじょ|kanojo|彼女|she; girlfriend|वह; संगिनी; सखी; सहेली
おっと|otto|夫|husband|पति
むすめ|musume|娘|(humble) daughter|बेटी
わけ|wake|訳|meaning; reason|उद्देश्य; अर्थपूर्ण; मतलब; कारण
りゆう|riyuu|理由|reason|कारण
いす|isu|椅子|chair|कुर्सी
ひとりひとり|hitorihitori|一人一人|one by one; each; one at a time|एक एक करके; प्रत्येक
えいえん|eien|永遠|eternity; perpetuity; immortality; permanence|अनंत; अनन्तकाल; अमरत्व; निरन्तरता; स्थायित्व; सितारा मछली; अमरत्व
えんぎ|engi|演技|acting; performance|कार्यकारी; अभिनय; अंग लीला; कार्य; प्रदर्शन; क्रिया
えんそう|ensou|演奏|musical performance|मधुर; संगीत; संगीत नाटिका
おうじ|ouji|王子|prince|युवराज; सामन्त; राजा
よめ|yome|嫁|bride; daughter-in-law|नववधू/दुल्हन; दुल्हन; नववधू
かんきゃく|kankyaku|観客|audience; spectator(s)|श्रोतागण; श्रोता; औपचारिक बैठक; प्रेक्षक; दर्शक; स्पेक्टेटर
たま|tama|偶|even number; couple; man and wife; friend|यहाँ तक; संलग्न; संलग्न करना; कुछ; आदमी
かかり|kakari|係|official; duty; person in charge|प्रामाणिक; अधिकारी; सरकारी; काम; कर्तव्य; कर; व्यक्ति
むかえ|mukae|迎え|meeting; person sent to pick up an arrival|बैठक; व्यक्ति
こじん|kojin|個人|individual; private person; personal; private|विशिष्ट; व्यक्ति; अलग अलग; गुप्त; साधारण; आत्मीय; स्वयं; व्यक्तित्व; अपना
さほう|sahou|作法|manners; etiquette; propriety|शिष्टाचार; रीति रिवाज; रंगढंग; शिष्टाचार; शिष्टाचार/सभ्यता; मर्यादा; औचित्यअ; शिष्टाचार
しまい|shimai|姉妹|sisters|
しじん|shijin|詩人|poet|पद्यकार; शायर; कवि
じしん|jishin|自身|by oneself; personally|खुद; स्वयं; खुद; व्यक्तिगत रूप से
しつ|shitsu|質|quality; nature (of person)|प्रकार; कोटि; गुण; प्रकार; गुण; वर्ग
もの|mono|者|person|व्यक्ति
しゅふ|shufu|主婦|housewife; mistress|गृहिणी; घर की संचालिका; गृहस्वामिनी; प्रेमिका; मालकिन; उपपत्नी
じゅよう|juyou|需要|demand; request|दावा करना; मांग; चाह; विनती करना; अनुरोध करना; आवेदन
いとこ|itoko|従兄弟|cousin (male)|चचेरा भाई
じょおう|joou|女王|queen|रानी
じょし|joshi|女子|woman; girl|महिला; लड़की
じょゆう|joyuu|女優|actress|अभिनेत्री
しょうじょ|shoujo|少女|daughter; young lady; virgin; maiden; little girl|बेटी; नवयुवती; युवती; विशुद्ध; प्राकृतिक; कन्या राशि में उत्पन्न व्यक्ति
じょうきゃく|joukyaku|乗客|passenger|कर्मी दल; याट्री; पथिक
したしい|shitashii|親しい|intimate; close (e.g. friend)|बताना; घनिष्ठ; आत्मीय; बंद करना
しんせき|shinseki|親戚|relative|अनुरूप; तुलनात्मक; सगा
しんゆう|shinyuu|親友|close friend; buddy|घनिष्ठ मित्र; अंगचारी; यार
にんげん|ningen|人間|human being; man; person|मानव; इंसानियत/इंसान; आदमी; व्यक्ति
にんき|ninki|人気|sign of life|देना; सौंपना; संकेत
じんこう|jinkou|人工|artificial; manmade; human work; human skill; artificiality|कृत्रिम; झूठा; बनावटी; अच्छा; मानव; इंसान
ひとごみ|hitogomi|人込み|crowd of people|भीड़
じんしゅ|jinshu|人種|race (of people)|प्रजाति; स्वाद; दौड़
じんせい|jinsei|人生|(human) life (i.e. conception to death)|जीवन
じんぶつ|jinbutsu|人物|character; personality; person; man; personage; talented man|दर्जा; प्रतिष्ठा; गुण; व्यक्तित्व; चरिट्र; विशेष चरित्र; व्यक्ति
じんるい|jinrui|人類|mankind; humanity|मानव जाति; मानवता; मानव जाति; इंसानियत
せいじん|seijin|成人|adult|वयस्क
せいさん|seisan|生産|production; manufacture|प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन; बनाना; उत्पादन; गढना
せいぞう|seizou|製造|manufacture; production|बनाना; उत्पादन; गढना; प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन
ふたご|futago|双子|twins; a twin|जुड़वाँ; यमज; एक सा; समरूप होना; अनुलिपि
そば|soba|側|side; edge; third person|किनारा; किनारा; उकसाना; किनारा लगाना; अन्य पुरुष[व्याकरण के अनुसार]; अन्य पुरुष
まご|mago|孫|grandchild|नतिनी; पोता; पोती
たにん|tanin|他人|another person; unrelated person; outsider; stranger|भिन्न; दूसरा; एक अन्य; असंबद्ध; असंबंधी; पराया; बाहर का; बाहर का आदमी
たい|tai|対|pair; couple; set|मिलाना; जोड़ो में किस्त होना; जोड़ा लगाना; संलग्न; संलग्न करना; कुछ; घटना; करना; अटल
たいど|taido|態度|attitude; manner|मुद्रा; रवैया; प्रवृति; आचरण; प्रक्रिया; शैली
おとこのひと|otokonohito|男の人|man|आदमी
だんし|danshi|男子|youth; young man|ताज़गी; नवयुवक; युवावस्था; नवयुवक; प्रेमी; किशोर
ちょうし|choushi|調子|tune; tone; key|ठीक करना; ठिक करना; तालमेल; स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल; चाबी
ただちに|tadachini|直ちに|at once; immediately; directly; in person|तुरन्त; एक ही समय; एक ही समय में; ठीक; उसी समय; तत्काल; सीधे; जल्दी; तुरन्त
ちょくせつ|chokusetsu|直接|direct; immediate; personal; firsthand|सरल; सीधा; ठीक; मूल; सन्निहित; तत्काल; स्वयं; व्यक्तित्व; अपना
でんし|denshi|電子|electron|अतिसूक्ष्म परमाणु; इलेक्ट्रन
どく|doku|毒|poison; toxicant|ज़हर देना; घातक; दूषित आहार
のうか|nouka|農家|farmer; farm family|किसान; खेत
はさん|hasan|破産|(personal) bankruptcy|दिवालियापन; दिवाला; दीवाला
はんにん|hannin|犯人|offender; criminal|अपराधी; उल्लंघन करने वाला; पापी; अपराधी; दण्ड
ひかく|hikaku|比較|comparison|तुलनात्मक; समानता; तुलना
びじん|bijin|美人|beautiful person (woman)|सुंदर
ふじん|fujin|夫人|wife; Mrs; madam|पत्नी; श्रीमती; मैडम; श्रीमती; महोदया
ふうふ|fuufu|夫婦|married couple; husband and wife|विवाहित दम्पती; पति और पत्नि
ふじん|fujin|婦人|woman; female|महिला; महिला; औरत; स्त्री जाति
ちちおや|chichioya|父親|father|पिता
ほとけ|hotoke|仏|Buddha; merciful person; Buddhist image; the dead|बुद्ध; दयालु; सौभाग्यपूर्ण
ははおや|hahaoya|母親|mother|माँ
ほんにん|honnin|本人|the person himself|
めいじん|meijin|名人|master; expert|मालिक; विशारद; शिक्षक; धुरंधर; विशेषज्ञ; निपुण
いのち|inochi|命|command; decree; life; destiny|पाना; प्राप्त करना; देना; आदेश देना; आदेश; अदालती हुक्म; जीवन
めいれい|meirei|命令|order; command; decree; directive; (software) instruction|आदेश; पाना; प्राप्त करना; देना; आदेश देना; आदेश; अदालती हुक्म
まいご|maigo|迷子|lost (stray) child|गुम; गुमराह; डूबा हुआ
わけ|wake|訳|meaning; reason; circumstances; can be deduced; situation|उद्देश्य; अर्थपूर्ण; मतलब; कारण; परिस्थिति; परिस्थितियाँ
とも|tomo|友|friend; companion; pal|दोस्त; साथी; छोटी पुस्तक; मिट्र; मित्र
ゆうじょう|yuujou|友情|friendship; fellowship|मैत्री; दोस्ती; अनुदान; संघ; अध्येतावृत्ति
ゆうじん|yuujin|友人|friend|दोस्त
よう|you|様|way; manner; kind|रास्ता; आचरण; प्रक्रिया; शैली; दयालु
ようす|yousu|様子|aspect; state; appearance|दृष्टिकोण; गुण; रूप; बताना; व्यक्त करना; अभिव्यक्त करना; उपस्थिति; पेशी; रूप रंग
ようきゅう|youkyuu|要求|request; demand; requisition|विनती करना; अनुरोध करना; आवेदन; दावा करना; मांग; चाह; माँग पत्र; अधियाचन करना; अधिग्रहण
れいぎ|reigi|礼儀|manners; courtesy; etiquette|शिष्टाचार; रीति रिवाज; रंगढंग; शालीनता; कृपा; विनय; शिष्टाचार; शिष्टाचार/सभ्यता
こいびと|koibito|恋人|lover; sweetheart|प्रेमिका; प्रेमी; आशिक; प्रेमिका; प्रेयसी; प्रेमी
おい|oi|老い|old age; old person; the old; the aged|वृद्धावस्था; बुढ़ापा; वृद्ध व्यक्ति; बुढ़े; बुढे लोग
ろうじん|roujin|老人|the aged; old person|बूढ़े लोग; वृद्ध व्यक्ति
いくじ|ikuji|育児|childcare; nursing; upbringing|परिचर्या; शिक्षा दीक्षा; पालन पोषण
おうじょ|oujo|王女|princess|राजकुमारी; राजपत्नी
かっこ|kakko|括弧|parenthesis; brackets|कोष्ठक; निक्षिप्त वाक्यअ; निक्षिप्त
きゃくせき|kyakuseki|客席|guest seating|मेहमान
りょうし|ryoushi|漁師|fisherman|मछुआरा; मछियारा; मछुआ
けいとう|keitou|系統|system; family line; geological formation|शरीर; व्यवस्था; पद्धति; परिवार; भूगर्भीय; भूविज्ञानी; भौमकीय
けいこうとう|keikoutou|蛍光灯|fluorescent lamp; person who is slow to react|प्रतिदीप्त दीप; प्रतिदीप्त; व्यक्ति
げんこう|genkou|原稿|manuscript; copy|हस्तलिपि; पांडुलिपि; हस्तलिखित; प्रति; कपी; अनुकरण
くふう|kufuu|工夫|labourer; worker|कामगार/मजदूरी करने वाला; मजदूर; कर्मचारी; श्रमजीवी; कर्ता
さいそく|saisoku|催促|request; demand; claim; urge (action); press for|विनती करना; अनुरोध करना; आवेदन; दावा करना; मांग; चाह; दावा करना; का पात्र होना; लेना
さくせい|sakusei|作製|manufacture|बनाना; उत्पादन; गढना
しかい|shikai|司会|chairmanship|अध्यक्षता
しそん|shison|子孫|descendants; posterity; offspring|उत्तरकालीनता; भावी; भावी पीढ़ी; परिणाम; सन्तान; शावक
じどう|jidou|児童|children; juvenile|बच्चे; बचकाना; किशोर; तरुण संबंधी
いとこ|itoko|従姉妹|cousin (female)|चचेरा भाई
おじさん|ojisan|叔父さん|middle-aged gentleman; uncle|चाचा
おばさん|obasan|叔母さん|(1) aunt; (2) middle-aged lady|चाची
じゅんさ|junsa|巡査|police; policeman|पुलिस; सिपाही
おんなのひと|onnanohito|女の人|woman|महिला
にょうぼう|nyoubou|女房|wife|पत्नी
こづかい|kozukai|小遣い|personal expenses; pocket money; spending money; incidental expenses; allowance|स्वयं; व्यक्तित्व; अपना; जेब ख़र्च; जेब खर्च; जेब; जेब खर्च
おじさん|ojisan|小父さん|middle-aged gentleman; uncle|चाचा
しょくにん|shokunin|職人|worker; mechanic; artisan; craftsman|कर्मचारी; श्रमजीवी; कर्ता; प्रक्रिया; मैकैनिक/कारीगर; यंत्रविज्ञान; कारीगर; दस्तकार; शिल्पी/शिल्पकार/कारीगर
おやゆび|oyayubi|親指|thumb|दबाना; देखना; अंगूठा लगाकर पलटना{गन्दा करना}
しんるい|shinrui|親類|relation; kin|नाता; संबंध; रिश्तेदारी; संबंधी
ひとさしゆび|hitosashiyubi|人差指|index finger|तर्जनी
じんぞう|jinzou|人造|man-made; synthetic; artificial|अवास्तविक; कृत्रिम; जाली/बनावटी; कृत्रिम; झूठा; बनावटी
じんめい|jinmei|人命|(human) life|जीवन
せい|sei|姓|surname; family name|कुलनाम; कुल नाम; कुलनाम
せいさく|seisaku|製作|manufacture; production|बनाना; उत्पादन; गढना; प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन
せんぞ|senzo|先祖|ancestor|पूर्वज; रूप
せんす|sensu|扇子|folding fan|
そせん|sosen|祖先|ancestor|पूर्वज; रूप
しろうと|shirouto|素人|amateur; novice|अव्यवसायी; नौसिखुआ; शौकिया; नया; नौसिखिया; नया घोड़ा
たいしょう|taishou|対照|contrast; antithesis; comparison|फर्क; विरोध; फर्क दिखाना; विपरीत; विलोम; विपर्यय; तुलनात्मक; समानता; तुलना
ちじん|chijin|知人|friend; acquaintance|दोस्त; ज्ञान; पहचान; परिचित
なかよし|nakayoshi|仲良し|intimate friend; bosom buddy; chum|बताना; घनिष्ठ; आत्मीय; मन में रखना; छाती; साथी; यार
ちょうじょ|choujo|長女|eldest daughter|सबसे बड़ा; सबसे; वय में सबसे बडा
ちょうなん|chounan|長男|eldest son|सबसे बड़ा; सबसे; वय में सबसे बडा
はしご|hashigo|梯子|ladder; stairs|सीढी से; चडना; उधड़न; सीढ़ी
どうさ|dousa|動作|action; movements; motions; bearing; behaviour; manners|कार्य
おじさん|ojisan|伯父さん|middle-aged gentleman; uncle|चाचा
おばさん|obasan|伯母さん|(hon) aunt|चाची
はんこ|hanko|判子|seal (used for signature)|मुद्रांकित; छाप; सील मछली
ふさい|fusai|夫妻|man and wife; married couple|आदमी; विवाहित दम्पती
ふぼ|fubo|父母|father and mother; parents|पिता; अभिभावक
ぼっちゃん|bocchan|坊っちゃん|son (of others)|बेटा
ぼうや|bouya|坊や|boy|लड़का
すえっこ|suekko|末っ子|youngest child|अंत भव
みんよう|minyou|民謡|folk song; popular song|लोक गीत; लोकगीत; लोकप्रिय
やくにん|yakunin|役人|government official|सरकार
ゆうこう|yuukou|友好|friendship|मैत्री; दोस्ती
ようじ|youji|幼児|infant; baby; child|बच्चा; लाल; शिशु; शिशु; बच्चा
らんぼう|ranbou|乱暴|rude; violent; rough; lawless; unreasonable; reckless|कच्चा; असभ्य; भद्दा; तीव्र; उग्र; प्रबल; कच्चा; कर्कश; कठोर
おまわりさん|omawarisan|お巡りさん|policeman (friendly term)|सिपाही
おじいさん|ojiisan|お祖父さん|grandfather; male senior-citizen|दादा; पुलिंग; पुरुष; प्रेमी
おばあさん|obaasan|お祖母さん|grandmother; female senior-citizen|दादी; महिला; औरत; स्त्री जाति
そのため|sonotame|その為|hence; for that reason|अतः; इस कारण से
いたく|itaku|委託|consign (goods (for sale) to a firm); entrust (person with something); commit|अर्पण करना; भेजना; हवाले कर देना; सौंपना; सौंप देना; करना; लिखना; वचनबद्ध होना
ひとり|hitori|一人|one person|
ひとりでに|hitorideni|一人でに|by itself; automatically; naturally|अपने आप; अपने; अपने आप; प्राकृतिक रुप से; बेशक; स्वभाविक रूप से
いんきょ|inkyo|隠居|retirement; retired person|सेवा निवृत्ति; सेवानिवृत्ति; सेवानिवृत्ति के बाद का समय; अवकाश प्राप्त; सेवानिवृत्त
その|sono|園|garden (esp. man-made)|बगीचा
おれ|ore|俺|I (ego) (boastful first-person pronoun)|मैं
なんとなく|nantonaku|何となく|somehow or other; for some reason or another|किसी भी तरह; किसी कारण से; जैसे तैसे
かけい|kakei|家計|household economy; family finances|घर के सभी लोग; परिवार; घरेलु; परिवार
あなた|anata|貴女|you; lady|तुम; प्रेमिका; महिला; कुलीन महिला
きゃっかん|kyakkan|客観|objective|सामान्य; उद्देश्य; लक्ष्य
きゅうち|kyuuchi|旧知|old friend; old friendship|पुराना; पुराना
ともかせぎ|tomokasegi|共稼ぎ|working together; (husband and wife) earning a living together|कार्य; कामचलाऊ; तर्कसंगत; आजीविका; कमाई; रोज़गार
きょうめい|kyoumei|共鳴|resonance; sympathy|गूँज; प्रतिध्वनि; जीवंतता; संवेदना; सहमति; सहानुभूति
かかり|kakari|係り|official; duty; person in charge|प्रामाणिक; अधिकारी; सरकारी; काम; कर्तव्य; कर; व्यक्ति
けいれき|keireki|経歴|personal history; career|स्वयं; व्यक्तित्व; अपना; जीवन; वेग; विकास
くろうと|kurouto|玄人|expert; professional; geisha; prostitute|धुरंधर; विशेषज्ञ; निपुण; व्यावसायिक; अनुभवी व्यक्ति; पेशेवर; गेशा
こせい|kosei|個性|individuality; personality; idiosyncrasy|विशिष्टता; व्यक्तित्व; व्यक्तित्व; चरिट्र; विशेष चरित्र; सनक; मानसिक घटना या प्रवृत्ति की विशेषावस्था; अवांछनीय आदत
こじん|kojin|故人|the deceased; old friend|मृतक; दिवंगत; मृत; पुराना
こうえん|kouen|公演|public performance|प्रजा; लोग; आम
こうさく|kousaku|工作|work; construction; handicraft; maneuvering|काम; संरचना; निर्माण; अभिप्राय; हस्तशिल्प; हस्तकला; हस्त शिल्प
"""), "ja", "N4", "kanji"),

        Lesson("kw-school", "🎓 School & Study · 学校・勉強", "🎓", "210 kanji words", kw("""
えいご|eigo|英語|English language|अंग्रेजी भाषा; अंग्रेज का; अंग्रेजीअ
がっこう|gakkou|学校|school|विद्यालय
がくせい|gakusei|学生|student|छात्र
かんじ|kanji|漢字|Chinese character|चीनी; चीन; चीनी भाषा
きょうしつ|kyoushitsu|教室|classroom|कक्षा
ことば|kotoba|言葉|word; language|शब्द; भाषा
さくぶん|sakubun|作文|composition; writing|बनावट; लेखन; संरचना; लिखने का काम; लिखना; लेखन
じびき|jibiki|字引|dictionary|शब्दकोष
じしょ|jisho|辞書|dictionary|शब्दकोष
しつもん|shitsumon|質問|question|प्रश्न
じゅぎょう|jugyou|授業|lesson; class work|पाठ; कक्षा
しゅくだい|shukudai|宿題|homework|गृहकार्य
としょかん|toshokan|図書館|library|पुस्तकालय
せいと|seito|生徒|pupil|आँख की; पुतली; किशोर
せんせい|sensei|先生|teacher; doctor|शिक्षक; डॉक्टर
だいがく|daigaku|大学|university|विश्वविद्यालय; किसी विश्वविद्यालय का दल; किसी विश्वविद्यालय का
ぶんしょう|bunshou|文章|sentence; text|वाक्य; अवतरण; पाठ्य; पाठ्य पुस्तक
ほん|hon|本|book|किताब
ほんだな|hondana|本棚|bookshelves|
はがき|hagaki|葉書|postcard|पोस्टचार्ड
りゅうがくせい|ryuugakusei|留学生|overseas student|बाहरी; विदेशी; समुद्र पार
いがく|igaku|医学|medical science|चिकित्सीय परीक्षा; चिकित्सीय; चिकित्सा
きょういく|kyouiku|教育|education|शिक्षा; शिक्षण; पढाई
きょうかい|kyoukai|教会|church|गिरजाघर
こうぎょう|kougyou|工業|the manufacturing industry|
こうちょう|kouchou|校長|headmaster|प्रधानाध्यापक; प्रधान अध्यापक; प्रधान
こうぎ|kougi|講義|lecture|फटकारना; आलोचना करना; व्याख्यान
こうこう|koukou|高校|high school|उच्च विद्यालय
こうこうせい|koukousei|高校生|high school student|हाई स्कूल छात्र
こうとうがっこう|koutougakkou|高等学校|high school|उच्च विद्यालय
さんぎょう|sangyou|産業|industry|उद्योग; परिश्रम; मेहनत
いと|ito|糸|thread|निकालना; घुमावदार मार्ग से हो कर आगे बढ़ना; वस्ट्र
しけん|shiken|試験|examination|परीक्षण; जाँच; परीक्षा
じ|ji|字|character|दर्जा; प्रतिष्ठा; गुण
じてん|jiten|辞典|dictionary|शब्दकोष
しょうがっこう|shougakkou|小学校|elementary school|प्राथमिक; प्राथमिक पाठशाला; प्रारम्भिक विद्यालय
そつぎょう|sotsugyou|卒業|graduation|क्रम; क्रमस्थापन
だいがくせい|daigakusei|大学生|university student|विश्वविद्यालयीन; विश्वविद्यालयीन छात्र
ちゅうがっこう|chuugakkou|中学校|junior high school; middle school|लघु माध्यमिक विद्यालय; माध्यमिक विद्यालय
こたえ|kotae|答|response|प्रतिक्रिया; ईसाइयों मे प्रार्थना  पाठ के उत्तर मे गाया जाने वाला भजन; धार्मिक
ふくしゅう|fukushuu|復習|revision|सुधार; पुनर्लेखन; दोहराई
ぶんか|bunka|文化|culture|समूह; संवर्धन; शिष्टता
ぶんがく|bungaku|文学|literature|साहित्यिक; साहित्यिक सामग्री; रचना
ぶんぽう|bunpou|文法|grammar|व्याकरण भाषा; व्याकरण; व्याकरण की पुस्तक
ほんやく|honyaku|翻訳|translation|स्थानांतरण; परिक्रमणहीन एक समान गतिविधि; भाषांतर
よしゅう|yoshuu|予習|preparation for a lesson|खाना; सम्पाक; अभ्यासकार्य
たとえば|tatoeba|例えば|for example|उदाहरण; उदाहरण स्वरूप; उदाहरण के लिए
ひとこと|hitokoto|一言|single word|ऐकल; अकेला; एक
か|ka|課|counter for chapters (of a book)|विरोध करना; गिनने का यंत्र; काउंटर
かくご|kakugo|覚悟|resolution; resignation; readiness; preparedness|विश्लेषण; इरादा/संकल्प; प्रस्ताव; स्वेच्छा; इश्तीफा; इस्तीफा; इच्छा; उत्सुकता; औत्सुक्य
がく|gaku|学|learning; scholarship; erudition; knowledge|ज्ञान; अधिगम; ज्ञान/विद्या; छात्रवृत्ति; विद्वत्ता; पाण्डित्य; विद्वत्ता; पाण्डित्य; व्यापक ज्ञान
がっき|gakki|学期|term (school)|पद; अवधि; शब्द
がくしゃ|gakusha|学者|scholar|विद्वान; शोध छात्र; शोध
がくしゅう|gakushuu|学習|study; learning|पढ़ाई; ज्ञान; अधिगम; ज्ञान/विद्या
がくもん|gakumon|学問|scholarship; study; learning|छात्रवृत्ति; विद्वत्ता; पाण्डित्य; पढ़ाई; ज्ञान; अधिगम; ज्ञान/विद्या
きぎょう|kigyou|企業|enterprise; undertaking|उद्योग; उद्यम; साहसिक कार्य; कार्य; वचन; उपक्रम
ぎもん|gimon|疑問|question; problem; doubt; guess|प्रश्न; समस्या; संदेह करना; पर संदेह करना; पर शंका होना
きゅう|kyuu|級|class; grade; rank; school class; grade|कक्षा; कोटि; पद; वर्गीकृत करना; समादर करना; जत्था; पद
おそろしい|osoroshii|恐ろしい|terrible; dreadful|भयानक; भद्दा; शोचनीय; डरावना
きょうかしょ|kyoukasho|教科書|text book|फाठ्य पुस्तक
きょうし|kyoushi|教師|teacher (classroom)|शिक्षक
きょうじゅ|kyouju|教授|teaching; instruction; professor|शिक्षा; शिक्षण; अध्यापन; सूचना; शिक्षा; जानकारी; प्राध्यापक; प्रोफ़ेसर
く|ku|句|sentence|वाक्य
くべつ|kubetsu|区別|distinction; differentiation; classification|प्रतिष्ठा; पार्थक्य; अन्तर; विशिष्टीकरण; अवकलन; विभेदन; वर्गीकरण; श्रेणीविभाजन
くん|kun|訓|native Japanese reading of a Chinese character|मूल; जन्मजात; देशी
けいけん|keiken|経験|experience|अनुभव करना; अनुभव; अनुभूति
けんさ|kensa|検査|inspection (e.g. customs; factory); examination|निरीक्षण; कारखाना; परीक्षण; जाँच; परीक्षा
けんとう|kentou|検討|consideration; examination; investigation; study; scrutiny|ध्यान; विचार; मुआवजा; परीक्षण; जाँच; परीक्षा; अनुसन्धान; जाँच; अन्वेषण
げんご|gengo|言語|language|भाषा
ご|go|語|language; word|भाषा; शब्द
ごがく|gogaku|語学|language study|भाषा
こうえん|kouen|講演|lecture; address|फटकारना; आलोचना करना; व्याख्यान; पता
ごうかく|goukaku|合格|success; passing (e.g. exam); eligibility|सफल व्यक्ति; सौभाग्य; सफलता; समाप्ति; मृत्यु; क्षणिक; पात्रता; निर्वाह्य योग्यता
こくご|kokugo|国語|national language|राष्ट्रजन; देशभक्त; रजवंशी
さっか|sakka|作家|author; writer; novelist; artist|जड़; लिखना; प्रवर्तक; साक्षर; लेखक; रचयिता; उपन्यासकार
ためし|tameshi|試し|trial; test|पूर्व परीक्षण; परीक्षण; विचार; परीक्षा
しゅうきょう|shuukyou|宗教|religion|भक्ति; परमात्मा के अस्तित्व में विश्वास; धर्म
しょさい|shosai|書斎|study|पढ़ाई
しょもつ|shomotsu|書物|books|
しょるい|shorui|書類|documents; official papers|प्रामाणिक; अधिकारी; सरकारी
しょうがくきん|shougakukin|奨学金|scholarship|छात्रवृत्ति; विद्वत्ता; पाण्डित्य
み|mi|身|body; main part; oneself; sword|शरीर; प्रमुख; कुलमिलाकर; मुख्य; अपने आप; खुद; स्वयं/खुद
しんがく|shingaku|進学|going on to university|जाना; जाने वाला; जाने
としょ|tosho|図書|books|
すうじ|suuji|数字|numeral; figure|संख्यावाचक; अंक; नमूना; विचार करना; कल्पना करना
せんこう|senkou|専攻|major subject; special study|प्रमुख; मुख्य; महत्वपूर्ण; विशेष
たいしょう|taishou|対象|target; object (of worship; study; etc); subject (of taxation; etc)|निशाना; क्षेत्र; लक्ष्य; पिण्ड; विरोध करना; आपत्ति; पढ़ाई
だいひょう|daihyou|代表|representative; representation; delegation; type; example; model|नमूना; नमूने के तौर पर; प्रतिरूप; अभ्यावेदन; मूर्ति; चिट्रण; प्रतिनिधि; प्रतिनिधि मंडल; कर्तव्यो की व्याख्या
たんい|tani|単位|unit; denomination; credit (in school)|एक; विभाग; ईकाई; नाम; संप्रदाय; मूल्यवर्ग; विश्वास दिलाना; जमा; मान्यता
たんご|tango|単語|word; vocabulary; (usually) single-character word|शब्द; शब्दावली; शब्दकोश
ちゅうがく|chuugaku|中学|middle school; junior high school|माध्यमिक विद्यालय; लघु माध्यमिक विद्यालय
ちゅうもん|chuumon|注文|order; request|आदेश; विनती करना; अनुरोध करना; आवेदन
ちょしゃ|chosha|著者|author; writer|जड़; लिखना; प्रवर्तक; साक्षर; लेखक; रचयिता
ちょうさ|chousa|調査|investigation; examination; inquiry; survey|अनुसन्धान; जाँच; अन्वेषण; परीक्षण; जाँच; परीक्षा; जाँच; सर्वेक्षण; अन्वेषण
つうがく|tsuugaku|通学|commuting to school|
てつがく|tetsugaku|哲学|philosophy|धारणा; सिद्धांत; दर्शन शास्त्र
かたな|katana|刀|sword; saber; knife; engraving tool|तलवार; खङ्ग; शमशीर; कटार; तलवार; तलवार से घायल कर; चाकू से काटना; छुरी; चाकू से
とうあん|touan|答案|examination paper; examination script|परीक्षण; जाँच; परीक्षा; परीक्षण; जाँच; परीक्षा
よみ|yomi|読み|reading|पढ़ना; व्याख्या; अध्ययन
どくしょ|dokusho|読書|reading|पढ़ना; व्याख्या; अध्ययन
にゅうがく|nyuugaku|入学|entry to school or university; matriculation|दहलीज; प्रवेशाधिकार; द्वार; मैट्रिक परीक्षा; मैट्रिक
のうぎょう|nougyou|農業|agriculture|कृषि; कृषि वर्ग; कृषि उद्योग
ものがたり|monogatari|物語|tale; story; legend|झूठ; कहानी; किस्सा; कहानी; आलेख; अपूर्व कहानी; दन्तकथा
ぶん|bun|文|sentence|वाक्य
もんく|monku|文句|phrase; complaint|वचन; व्यक्त करना; कहना; शिकायत; झगड़ा; रोग
もんじ|monji|文字|letter (of alphabet); character|पत्र; दर्जा; प्रतिष्ठा; गुण
ぶんめい|bunmei|文明|civilization; culture|शिष्टता; सामाजिक; संस्कृत्; समूह; संवर्धन; शिष्टता
べんきょうする|benkyousuru|勉強|study; diligence; discount; reduction|पढ़ाई; परिश्रम; कर्मठता; कम करना; खंडन करना; छूट
とい|toi|問い|question; query|प्रश्न; के बारे में पूछताछ करना; पूछना; प्रश्न
ようするに|yousuruni|要するに|in a word; after all; the point is ..; in short ..|संक्षेप में; आख़िर; आख़िरकार
りゅうがく|ryuugaku|留学|studying abroad|
れい|rei|例|instance; example; case|घटना; अवसर; वारदात; उदाहरण; घटना; समस्या; नमूना
ろんぶん|ronbun|論文|thesis; essay; treatise; paper|शोध प्रबन्ध; शोध प्रबंध; अभिधारणा; कोशिश करना; लेख; प्रयत्न करना/परिश्रम करना/जाँचना; प्रबंध; प्रबन्ध
えいぶん|eibun|英文|sentence in English|वाक्य
えいわ|eiwa|英和|English-Japanese (e.g. dictionary)|
したがき|shitagaki|下書き|rough copy; draft|कच्चा; कर्कश; कठोर; झोंका; अनिवार्य भर्ती होना; भरती करना
かいとう|kaitou|解答|answer; solution|जवाब; उपाय; समस्या का समाधान करने का तरीका; घोल
かいさつ|kaisatsu|改札|examination of tickets|परीक्षण; जाँच; परीक्षा
がっか|gakka|学科|study subject; course of study|पढ़ाई; पाठ्यक्रम
がっかい|gakkai|学会|scientific society; academic meeting|वैज्ञानिक; विज्ञान संबंधी; विज्ञान; विद्वान; पण्डिताऊ; अव्यावहारिक
がっきゅう|gakkyuu|学級|grade in school|कोटि; पद; वर्गीकृत करना
がくじゅつ|gakujutsu|学術|science; learning; scholarship|प्रक्रिया; कौशल; विषय; ज्ञान; अधिगम; ज्ञान/विद्या; छात्रवृत्ति; विद्वत्ता; पाण्डित्य
がくぶ|gakubu|学部|department of a university; undergraduate|विभाग; पूर्वस्नातक
がくりょく|gakuryoku|学力|scholarship; knowledge; literary ability|छात्रवृत्ति; विद्वत्ता; पाण्डित्य; जानकारी; अवबोधन; ज्ञान; साहित्यिक; साहित्य
かつじ|katsuji|活字|printing type|छपाई; संसकरण
かんわ|kanwa|漢和|Chinese Character-Japanese (e.g. dictionary)|चीनी; चीन; चीनी भाषा
きゅうこう|kyuukou|休講|lecture cancelled|फटकारना; आलोचना करना; व्याख्यान
ぎょぎょう|gyogyou|漁業|fishing (industry)|मछली पकड़ना; मछली; मछली मारना
きょうよう|kyouyou|教養|culture; education; refinement; cultivation|समूह; संवर्धन; शिष्टता; शिक्षा; शिक्षण; पढाई; सुधार; सुसंस्कृति; साफ़ करने का काम
くとうてん|kutouten|句読点|punctuation marks|विरामादि चिह्न
けいご|keigo|敬語|honorific; term of respect|आदरसूचक; सम्मानप्रद; पद; अवधि; शब्द
けんがく|kengaku|見学|inspection; study by observation; field trip|निरीक्षण; पढ़ाई; क्षेट्र याट्रा; अध्ययन यात्रा
ことばづかい|kotobazukai|言葉遣い|speech; expression; wording|पंक्ति; भाषा; बोली; वचन; पदसंहति; अभिव्यक्ति; शब्द विन्यास; शब्दों में प्रकट करना
こてん|koten|古典|old book; classics; classic|पुराना; ग्रीक रोमईय भाषा साहित्य का अध्ययन; ग्रीक रोमईय भाषा साहित्य का; उत्कृष्ट; अनलंकृत; आदर्श
こうしゃ|kousha|校舎|school building|विद्यालय
こうてい|koutei|校庭|campus|परिसर
こうし|koushi|講師|lecturer|व्याख्याता; लेक्चरर
ざいがく|zaigaku|在学|(enrolled) in school|
じしゅう|jishuu|自習|self-study|
じっしゅう|jisshuu|実習|practice; training|अभ्यास; कार्यप्रणाली; वकालत करना; प्रशिक्षण; शारीरिक प्रशिक्षण
じつれい|jitsurei|実例|example; illustration|उदाहरण; स्पष्टीकरण; व्यख्या; उदाहरन
しゅご|shugo|主語|(gram) subject|विषय
じゅけん|juken|受験|taking an examination|मनोहर; आसानी से मिलना; आकर्षक
しゅうじ|shuuji|習字|penmanship|लेखन चातुर्य; सुंदर लिखने की कला; लेखन कला
じゅくご|jukugo|熟語|idiom; idiomatic phrase; kanji compound|शैली; बोली; मुहावरा; मुहावरेदार
じゅつご|jutsugo|述語|predicate|निश्चयपूर्वक कहना; विधेय होना; विधेय
かきとり|kakitori|書取|dictation|श्रुतलेखन गति; श्रुतलेख
しょせき|shoseki|書籍|book; publication|किताब; प्रकाशन; प्रकाशनअ; प्रख्यापन
しょてん|shoten|書店|bookshop|किताब खी दुकान; किताब खी
しょどう|shodou|書道|calligraphy|सुलेखन; सुलेख
かきとめ|kakitome|書留|writing down; putting on record; recording; making a note of; registration (of mail)|लिखने का काम; लिखना; लेखन; मारना; ध्वन्यालेखन; अभिलेकन
じょきょうじゅ|jokyouju|助教授|assistant professor|सहायक; सहायक प्राध्यापक
しょうがくせい|shougakusei|小学生|grade school student|कोटि; पद; वर्गीकृत करना
ずかん|zukan|図鑑|picture book|तश्बीर का किताबअ
せいさく|seisaku|制作|work (film; book)|काम; किताब
せいしょ|seisho|清書|clean copy|साफ
おくりがな|okurigana|送り仮名|part of word written in kana|भाग
だいがくいん|daigakuin|大学院|graduate school|स्नातक विद्यालय
なかみ|nakami|中身|contents; interior; substance; filling; (sword) blade|सार; वस्तु; विषय; भीतरी; भीतर; तटवर्ती; सार; वस्तु; पदार्थ
とうしょ|tousho|投書|letter to the editor; letter from a reader; contribution|पत्र; पत्र; सहायता; चंदा; लेख
ひっしゃ|hissha|筆者|writer; author|साक्षर; लेखक; रचयिता; जड़; लिखना; प्रवर्तक
ひょうほん|hyouhon|標本|example; specimen|उदाहरण; नमूना; आदर्श; अजीब आदमी
ふきゅう|fukyuu|普及|diffusion; spread|फैलाव; फैलना; प्रकार; फैलाना
ぶんげい|bungei|文芸|literature; art and literature; belles-lettres|साहित्यिक; साहित्यिक सामग्री; रचना; कला
ぶんけん|bunken|文献|literature; books (reference)|साहित्यिक; साहित्यिक सामग्री; रचना
ぶんたい|buntai|文体|literary style|साहित्यिक; साहित्य
ぶんぼうぐ|bunbougu|文房具|stationery|लेखन सामग्री; पत्र लेखन कागज़; कागज़ आदी सामग्री
ぶんみゃく|bunmyaku|文脈|context|परिस्थिति; प्रसंग; सन्दर्भ
みょうじ|myouji|名字|surname; family name|कुलनाम; कुल नाम; कुलनाम
もんどう|mondou|問答|questions and answers; dialogue|विचार; बातचीत; संवाद
ようご|yougo|用語|term; terminology|पद; अवधि; शब्द; शब्दावली
らくだい|rakudai|落第|failure; dropping out of a class|असफलता; गिरना; गिरावट; तेज़ी से; तेज़ी से गिरता
ローマじ|romaji|ローマ字|romanization; Roman letters|रोमन अक्षर
いぎ|igi|異議|objection; dissent; protest|विरोध; आपत्ति; एतराज़; मतभेद; अस्वीकृति; असहमति; विरोध करना; विरोध; प्रतिवाद
ひとこと|hitokoto|一言|single word|ऐकल; अकेला; एक
えいじ|eiji|英字|English letter (character)|अंग्रेजी भाषा; अंग्रेज का; अंग्रेजीअ
えつらん|etsuran|閲覧|inspection; reading|निरीक्षण; पढ़ना; व्याख्या; अध्ययन
いやらしい|iyarashii|厭やらしい|detestable; disagreeable|घृणित; घिनौना; घृणास्पद; अप्रिय; झगड़ालू
えんしゅう|enshuu|演習|practice; exercises; manoeuvers|अभ्यास; कार्यप्रणाली; वकालत करना
たとえ|tatoe|仮令|example; even if; if; though; although|उदाहरण; भी; भले ही; अगर
かじょうがき|kajougaki|箇条書き|itemized form; itemization|मदवार
がいとう|gaitou|該当|corresponding; answering to; coming under|समरूपी; चिट्ठी/पत्री; जो समतुल्य हो; उत्तर में प्राप्त; आनेवाला; भावी; आगमन
がくげい|gakugei|学芸|arts and sciences; liberal arts|उदार; दान शील; उदारचरित
がくし|gakushi|学士|university graduate|विश्वविद्यालय; किसी विश्वविद्यालय का दल; किसी विश्वविद्यालय का
がくせつ|gakusetsu|学説|theory|सिद्धांत; सिद्धान्त; परिकल्पना
がくれき|gakureki|学歴|academic background|विद्वान; पण्डिताऊ; अव्यावहारिक
かんしゅう|kanshuu|慣習|usual (historical) custom|हमेशा; हमेशा का; आम
かんご|kango|漢語|Chinese word; Sino-Japanese word|चीनी; चीन; चीनी भाषा
がんしょ|gansho|願書|written application or petition|लिखित; लिखा हुआ
きはん|kihan|規範|model; standard; pattern; norm; criterion; example|नमूना; मडल; तैयार करना; दर्जा; शिष्ट; मान; नमूना; चित्र; उदाहरण
つまり|tsumari|詰まり|in short; in brief; in other words; that is to say; in the long run; after all; blockade; stuffing; ultimate|संक्षेप में; संक्षेप में; अर्थात्
きゅうがく|kyuugaku|休学|temporary absence from school; suspension|अल्पकालीन; अस्थायी कर्मचारी; अस्थायी; स्थगन; निलम्बन; थोड़े समय के लिये रुकावट
きょうがく|kyougaku|共学|coeducation|सहशिक्षा
おしえ|oshie|教え|teachings; precept; lesson; doctrine|वचन; रस्म; नियम; पाठ
きょういん|kyouin|教員|teaching staff|शिक्षा; शिक्षण; अध्यापन
きょうか|kyouka|教科|subject; curriculum|विषय; पाठ्यक्रम
きょうくん|kyoukun|教訓|lesson; precept; moral instruction|पाठ; वचन; रस्म; नियम; नैतिक; नैतिकअ; नीतिशास्ट्र
きょうざい|kyouzai|教材|teaching materials|शिक्षा; शिक्षण; अध्यापन
きょうしゅう|kyoushuu|教習|training; instruction|प्रशिक्षण; शारीरिक प्रशिक्षण; सूचना; शिक्षा; जानकारी
こうぎょう|kougyou|興業|industrial enterprise|उद्योग संबंधी; उद्योगी; औद्योगिक
ごう|gou|業|Buddhist karma; actions committed in a former life|
ぎょうしゃ|gyousha|業者|trader; merchant|व्यापारी; पणिता; व्यापारी; सौदागर; पणिता
けい|kei|刑|penalty; sentence; punishment|दंड; जुर्माना; दण्ड/सज़ा; वाक्य; शासन; दंड; ताड़ना
くだん|kudan|件|example; precedent; the usual; the said; the above-mentioned; (man) in question|उदाहरण; नमूना; उदाहरण; पूर्ववर्ती; हमेशा; हमेशा का; आम
げんしょ|gensho|原書|original document|असली; प्रारंभिक; मूल
げんぶん|genbun|原文|the text; original|अवतरण; पाठ्य; पाठ्य पुस्तक; असली; प्रारंभिक; मूल
ごく|goku|語句|words; phrases|झगड़ा; शब्द; बोल
ごげん|gogen|語源|word root; word derivation; etymology|शब्द; शब्द; व्युत्पत्ति विज्ञान; शब्द व्युत्पत्ति; शब्दों का इतिहास/मतलब
ごい|goi|語彙|vocabulary; glossary|शब्दावली; शब्दकोश; शब्दावली; शब्द संग्रह
こうがく|kougaku|工学|engineering|अभियान्त्रिकी; कल बनाने की विद्या; अभियांत्रिकी
"""), "ja", "N4", "kanji"),

        Lesson("kw-work", "💼 Work & Business · 仕事・会社", "💼", "115 kanji words", kw("""
かいしゃ|kaisha|会社|company|कंपनी
しごと|shigoto|仕事|job|नौकरी
ながい|nagai|長い|long|लंबा
かじ|kaji|火事|fire|आग
かちょう|kachou|課長|section manager|वर्ग; दल; काटना
かいぎ|kaigi|会議|meeting|बैठक
かいぎしつ|kaigishitsu|会議室|meeting room|बैठक
こうむいん|koumuin|公務員|government worker|सरकार
こうじょう|koujou|工場|factory|कारखाना
しかた|shikata|仕方|method|क्रमबद्ध्ता; पद्धति; प्रणाली/तरीका
じこ|jiko|事故|accident|दुर्घटना
じむしょ|jimusho|事務所|office|कार्यालय
しゃちょう|shachou|社長|company president|कंपनी
しんぶんしゃ|shinbunsha|新聞社|newspaper company|कला और विज्ञापन; विज्ञापन; कागज़
だいじ|daiji|大事|important; valuable; serious matter|महत्वपूर्ण; बहुमूल्य; जेवर; अनमोल; जटिल; महत्वपूर्ण; रहस्यमय
ぶちょう|buchou|部長|head of a section|सिर
いいん|iin|委員|committee member|कमेटी; समिति; संसद
えいぎょう|eigyou|営業|business; trade; management|व्यापार; उद्योग; व्यापार करना; कारोबार; व्यवस्था; प्रबंध; प्रबन्धन
かい|kai|会|meeting; assembly; party; association; club|बैठक; जमघट; सभा; फिटिंग; पार्टी
かいいん|kaiin|会員|member; the membership|सदस्य; सदस्य संख्या; सदस्य वर्ग; सदस्यता
かいごう|kaigou|会合|meeting; assembly|बैठक; जमघट; सभा; फिटिंग
きじ|kiji|記事|article; news story; report; account|सामान; वस्तु; दफ़ा/धारा; समाचार; बताना; विवरण; सूचना
ぎいん|giin|議員|member of the Diet; congress or parliament|सदस्य; प्रतिनिधि; व्यवस्थापिका सभा; प्रतिनिधि सभा
ぎちょう|gichou|議長|chairman|अध्यक्ष; सभापति
きゅうりょう|kyuuryou|給料|salary; wages|मेहनताना; वेतन; वेतन/तनखाह; प्रतिदान; वेतन; तनख्वाह
つとめ|tsutome|勤め|(1) service; duty; business; responsibility; task; (2) Buddhist religious services|कार्य; कर्मचारी; सहायता; काम; कर्तव्य; कर; व्यापार
けいじ|keiji|刑事|criminal case; (police) detective|पापी; अपराधी; दण्ड; खूफिया; गुप्तचर; जासूसी
けいやく|keiyaku|契約|contract; compact; agreement|करना; होना; प्राप्त करना; सघन; वचन; संक्षिप्त; वचन; सहमति; करार
けいえい|keiei|経営|management; administration|व्यवस्था; प्रबंध; प्रबन्धन; देना; दवा; दवा देना
みごと|migoto|見事|splendid; magnificent; beautiful; admirable|शानदार; बहुत बढ़िया; उजागर; शानदार; भव्य; सुंदर
こうじょう|koujou|工場|factory; plant; mill; workshop|कारखाना; पौधा; चक्की; पीसना; मिल
さぎょう|sagyou|作業|work; operation; manufacturing; fatigue duty|काम; कार्य; आपरेशन; काम; निर्माण; उत्पादन; विनिर्माण
しよう|shiyou|使用|use; application; employment; utilization|उपयोग; संबंध; लागू; परिश्रम; काम; आजीविका; नौकरी
こと|koto|事|thing; matter; fact; circumstances|चीज़; मामला; तथ्य
じけん|jiken|事件|event; affair; incident|घटना; वारदात; प्रतियोगिता; घटना; समस्या; झगड़ा; घटना; वारदात; घट्
じじつ|jijitsu|事実|fact; truth; reality|तथ्य; वास्त्विकता; सत्यता; वास्तविकता; असलियत; ह्कीकत; वास्तविकता
じじょう|jijou|事情|circumstances; consideration; conditions; situation; reasons|परिस्थिति; परिस्थितियाँ; ध्यान; विचार; मुआवजा; शर्तें
じたい|jitai|事態|situation; present state of affairs|समस्या; दृश्य; स्थिति; उपहार
じむ|jimu|事務|business; office work|व्यापार; कार्यालय
しつぎょう|shitsugyou|失業|unemployment|बेरोजगारी/बेकारी/अनुद्योग; बेरोज़गारी; अवृति
しゅうにゅう|shuunyuu|収入|income; receipts; revenue|फ़ायदा; आय; कमाई; प्राप्तिय्; राजस्व; कर
しゅうしょく|shuushoku|就職|finding employment; inauguration|निष्कर्ष; निर्णय; जाँच परिणाम; उद्घाटन; विमोचन; प्रतिष्ठापन/शुभारम्भ
あつまり|atsumari|集まり|gathering; meeting; assembly; collection|सभा; संग्रहण; सभाआ; बैठक; जमघट; सभा; फिटिंग
であい|deai|出会い|meeting; rendezvous; encounter|बैठक; पूर्वनिश्चित समय और स्थान पर मिलना; मनोरंजन स्थल; पूर्वनिश्चित मुलाकात; सामना करना; मुठभेड़; मुठभेड़ करना
できごと|dekigoto|出来事|incident; affair; happening; event|घटना; वारदात; घट्; घटना; समस्या; झगड़ा; घटना; अनौपचारिक; अनौपचारिक कलात्मक अभिनय
しょく|shoku|職|employment|काम; आजीविका; नौकरी
しょくぎょう|shokugyou|職業|occupation; business|आक्रमण; धंधा; अधिकार; व्यापार
ふる|furu|振る|(1) to wave; to shake; to swing; (2) to sprinkle; (3) to cast (actor); to allocate (work)|करना; दल; घुमाना; झटका; घुमाना; मिलाना; परिवर्तन; लटकना; बदलना
しんちょう|shinchou|身長|height (of body); stature|शिखर; चरम; पराकाष्ठा; महत्ता; क्षमता या उपलब्धि से कमाई हुई इज्जत और रूतबा; तन की प्राकृतिक लम्बाई
せいちょう|seichou|成長|growth; grow to adulthood|पौधा; सूजन; वृध्दि; उगना
たいかい|taikai|大会|convention; tournament; mass meeting; rally|करार; चलन; समझौता; खेल प्रतियोगिता; टूर्नामेंट; परिमाण; समूह; ढेर
ちじ|chiji|知事|prefectural governor|
ちょうき|chouki|長期|long time period|लंबा
はたらき|hataraki|働き|work; labor|काम; जी तोड़ कोशिश करना; मजदूर वर्ग; श्रमजीवी वर्ग
どうりょう|douryou|同僚|coworker; colleague; associate|सहकार्यकर्ता; सहकर्मी; मिलना; मिलाना; सहयोगी
ものごと|monogoto|物事|things; everything|वस्ट्र; काम; सामान; सब कुछ
ぶじ|buji|無事|safety; peace; quietness|सुरक्षा; अहानिकारकता; सुरक्षित स्थान; शांति; शान्ति; शांति; नीरवता
つれ|tsure|連れ|companion; company|साथी; छोटी पुस्तक; मिट्र; कंपनी
ろうどう|roudou|労働|manual labor; toil; work|नियमावली; पुस्तिका; हाथ का; कठिन परिश्रम करना; परिश्रम; कठिन; काम
えんちょう|enchou|延長|extension; elongation; prolongation; lengthening|विस्तार; फैलाव; शिक्षा; दीर्घीकरण; दीर्धीकरण; तन्नता; दीर्घीकरण; प्रवर्धन
かいかん|kaikan|会館|meeting hall; assembly hall|बैठक; जमघट; सभा; फिटिंग
かいかい|kaikai|開会|opening of a meeting|मौका; शुरुआत; प्रारंभ
かんちょう|kanchou|官庁|government office; authorities|सरकार
きゅうぎょう|kyuugyou|休業|closed (e.g. store); business suspended; shutdown; holiday|सीमित; बंद; संकीर्ण; व्यापार; बन्द करना
けっさく|kessaku|傑作|masterpiece; best work; boner; blunder|उत्कृष्ट कृति; सर्वश्रेष्ठ
けんちょう|kenchou|県庁|prefectural office|
おんちゅう|onchuu|御中|and Company; Messrs.|सर्वश्री
こうむ|koumu|公務|official business; public business|प्रामाणिक; अधिकारी; सरकारी; प्रजा; लोग; आम
こういん|kouin|工員|factory worker|कारखाना
こうじ|kouji|工事|construction work|संरचना; निर्माण; अभिप्राय
ぎょうじ|gyouji|行事|event; function|घटना; वारदात; प्रतियोगिता; कार्य; प्रकार्य; कार्य करना
しゅうにん|shuunin|就任|inauguration; assumption of office|उद्घाटन; विमोचन; प्रतिष्ठापन/शुभारम्भ; मान्यता; पुर्वानुमान; कल्पना
しゅうかい|shuukai|集会|meeting; assembly|बैठक; जमघट; सभा; फिटिंग
しゅうごう|shuugou|集合|gathering; assembly; meeting; set (math)|सभा; संग्रहण; सभाआ; जमघट; सभा; फिटिंग; बैठक
しゅっきん|shukkin|出勤|going to work; at work|जाना; जाने वाला; जाने; चालू; काम में संलग्न
でむかえ|demukae|出迎え|meeting; reception|बैठक; स्वीकृति; स्वागत; स्वागत समारोह
しょうぎょう|shougyou|商業|commerce; trade; business|वाणिज्य; उद्योग; व्यापार करना; कारोबार; व्यापार
すいじ|suiji|炊事|cooking; culinary arts|खाना; पाकविधि; पकाने योग्य; पाक विषयक; पाक शाला संबंधी
せいちょう|seichou|生長|growth; increment|पौधा; सूजन; वृध्दि; वेतन वृद्धि; वृद्धि
うちあわせ|uchiawase|打合せ|business meeting; previous arrangement; appointment|व्यापार; पिछला; पूर्व; पूर्ववर्ती; वचन; नियुक्ति; नौकरी
ちょうしょ|chousho|長所|(1) strong point; merit; (2) advantage|मजबूत; विशेषता; योग्यता; सराहना; एडवांटेज{टैनिस के केल में ड्युस उपरांत अर्जित पहला प्वाइंट}; सहायता करना; लाभ
ちょうたん|choutan|長短|length; long and short; +-|बढ्ना; विस्तार; हद; लंबा
ちょうほうけい|chouhoukei|長方形|rectangle; oblong|समकोण समानान्तर चतुर्भुज; आयत; आयताकार; अंडाकार आकृति; आयन
ていいん|teiin|定員|fixed number of regular personnel; capacity (of boat; etc.)|स्थिर; निर्धारित; स्थायी; सामर्थ्य; क्षमता; धारण शक्ति; आदि
つとめる|tsutomeru|努める|(1) to serve; to fill a post; to serve under; to work (for)|बदला लेना; देना; सहायता करना
とくちょう|tokuchou|特長|forte; merit|विशिष्टता; उच्च; उच्च स्वर में; विशेषता; योग्यता; सराहना
にゅうしゃ|nyuusha|入社|entry to a company|दहलीज; प्रवेशाधिकार; द्वार
はんじ|hanji|判事|judge; judiciary|निर्णायक; अस्थाई न्यायाधिकारी; फ़ैसला सुनाना; न्यायिक; न्यायपालिका
まんいん|manin|満員|full house; no vacancy; sold out|फुल हाउस; बिका हुआ; बेचा
つとめる|tsutomeru|務める|(1) to serve; to fill a post; to serve under; to work (for)|बदला लेना; देना; सहायता करना
めんせつ|mensetsu|面接|interview|इंटरव्यू लेना; बातचीत; साक्षात्कार
りょうじ|ryouji|領事|consul|वाणिज्य दूत; राजदूत; दंडाधिकारी
おだいじに|odaijini|お大事に|Take care of yourself|लेना
じょう|jou|尉|jailer; old man; rank; company officer|जेलर; मालिक; दोस्त; बूढा आदमी; समादर करना; जत्था; पद
いん|in|員|member|सदस्य
かろう|karou|過労|overwork; strain|ज़्यादा मेहनत; अत्यन्त परिश्रम करना; अत्यधिक कार्य या परिश्रम; थकाना; गाना; मोच
かいけん|kaiken|会見|interview; audience|इंटरव्यू लेना; बातचीत; साक्षात्कार; श्रोतागण; श्रोता; औपचारिक बैठक
かいだん|kaidan|会談|conversation; conference; discussion; interview|बातचीत; नाजायज़; नाजायज़ ताल्लुकात; सम्मेलन; अधिवेशन; चर्चा; बहस; आलोचनाआ
かいさい|kaisai|開催|holding a meeting; open an exhibition|अधिसंपत्ति; जोत; स्वामित्व; खोलना
かぶしき|kabushiki|株式|stock (company)|प्रतिष्ठा; लगाना; नाम
きかく|kikaku|企画|planning; project|आयोजन; योजना; नगर योजना; योजना बनाना; डालना; योजना
ぎじどう|gijidou|議事堂|Diet building|अल्पाहार; भोजन; आहार
きゅうじ|kyuuji|給仕|office boy (girl); page; waiter|बाल कर्मचारी; बाल; पृष्ठ; बैरा; इंतज़ार करने; वेटर
くじ|kuji|旧事|past events; bygones|अतीत
ともばたらき|tomobataraki|共働き|dual income|दोहरा; द्विक/दोनों; द्वैध
きょうしょく|kyoushoku|教職|teaching certificate; the teaching profession|शिक्षा; शिक्षण; अध्यापन
ぎょうせき|gyouseki|業績|achievement; performance; results; work; contribution|कार्यसिद्धि; उपलब्धि; निष्पादन; कार्य; प्रदर्शन; क्रिया
ぎょうむ|gyoumu|業務|business; affairs; duties; work|व्यापार; कार्य; कारोबार; घटनाक्रम
つとめさき|tsutomesaki|勤め先|place of work|स्थान
きんむ|kinmu|勤務|service; duty; work|कार्य; कर्मचारी; सहायता; काम; कर्तव्य; कर; काम
ぐんじ|gunji|軍事|military affairs|सेना; सैनिक; फौज
けんぎょう|kengyou|兼業|side line; second business|सीमारेखा; उपजीविका; दूसरा
けんじ|kenji|検事|public prosecutor|अभियोगपक्ष का वकील; सरकारी वकील; लोकअभियोजक
げんさく|gensaku|原作|original work|असली; प्रारंभिक; मूल
こよう|koyou|雇用|employment (long term); hire|काम; आजीविका; नौकरी; किराया/भाड़ा; भाड़ेपर देना; मजदूरी पर रखना/किराये पर लेना
"""), "ja", "N4", "kanji"),

        Lesson("kw-home", "🏠 Home & Housing · 家・住まい", "🏠", "99 kanji words", kw("""
おふろ|ofuro|お風呂|bath|स्नान
いえ|ie|家|house|घर
かてい|katei|家庭|household|घर के सभी लोग; परिवार; घरेलु
かいだん|kaidan|階段|stairs|सीढ़ी
げんかん|genkan|玄関|entry hall|दहलीज; प्रवेशाधिकार; द्वार
と|to|戸|Japanese style door|जापानवासी; जापानी
まど|mado|窓|window|खिड़की
だいどころ|daidokoro|台所|kitchen|रसोई
にわ|niwa|庭|garden|बगीचा
やおや|yaoya|八百屋|greengrocer|सब्ज़ी तरकारी बेचनेवाला; सब्ज़ी तरकारी
へや|heya|部屋|room|कमरा
もん|mon|門|gate|द्वार
となり|tonari|隣|next door to|अगला
ろうか|rouka|廊下|corridor|सीमांत; गलियारा; सीमांत गलियारा
おたく|otaku|お宅|(polite) your house|तुम्हारा
おくじょう|okujou|屋上|rooftop|छत का ऊपरी भाग
たたみ|tatami|畳|Japanese straw mat|जापानवासी; जापानी
あさい|asai|浅い|shallow; superficial|हल्की; उथला; उथला करना; स्पष्ट; सामान्य; बाहरी
にかいだて|nikaidate|二階建て|two storied|
ふとん|futon|布団|Japanese bedding; futon|जापानवासी; जापानी; छोटा और मोटा गद्दा
かべ|kabe|壁|wall|दीवार
べつ|betsu|別|different|अलग
いっか|ikka|一家|a house; a home; a family; a household|घर; घर; परिवार
やね|yane|屋根|roof|छत; छाना; शीर्ष
かぐ|kagu|家具|furniture|उपस्कर; फर्नीचर
やちん|yachin|家賃|rent|किराया
いま|ima|居間|living room (western style)|कमरा; बैठक कक्ष; भैठकखाना
さべつ|sabetsu|差別|discrimination; distinction; differentiation|पक्षपात; विवेक; भेदभाव; प्रतिष्ठा; पार्थक्य; अन्तर; विशिष्टीकरण; अवकलन; विभेदन
じゅうたく|juutaku|住宅|resident; housing|निवासी; आवासी; घर; गृह; घोड़े का साज़ सामान
じゅうみん|juumin|住民|citizens; inhabitants; residents; population|
こや|koya|小屋|hut; cabin; shed; (animal) pen|झोपड़ी; झोंपड़ी.छोटा घर; मड़ई; कोठरी; कक्ष; झोंपड़ी; फैलाना; निकालना; घटाना
ゆか|yuka|床|floor|फर्श
しょうめい|shoumei|証明|proof; verification|प्रमाण; जाँच; अभेद्य; सत्यापन; प्रमाणन
たく|taku|宅|house; home; husband|घर; घर; पति
ふろ|furo|風呂|bath|स्नान
へい|hei|塀|wall; fence|दीवार; बाड़ा; उत्तर देने से बचना; घेरना
ながれ|nagare|流れ|stream; current|बहना; वर्ग; प्रवाह; प्रवृत्ति; प्रवाह; धारा
いど|ido|井戸|water well|पानी
あまど|amado|雨戸|sliding storm door|
えんげい|engei|園芸|horticulture; gardening|उद्यानकृषि; बागवानी; बागबानी
おくがい|okugai|屋外|outdoors|बाहर; खुले मैदान; गाँव का माहौल
おんしつ|onshitsu|温室|greenhouse|छोटे पेड़ों को हरा रखने का घर; काँच का घरअ
かおく|kaoku|家屋|house; building|घर; इमारत
かわら|kawara|瓦|roof tile|छत; छाना; शीर्ष
かんばん|kanban|看板|sign; signboard; doorplate; poster|देना; सौंपना; संकेत; नामपट्ट; सूचना पट्ट
きしょう|kishou|起床|rising; getting out of bed|आने वाला; बढ़ता हुआ; उत्प्रवण; मिलना
とだな|todana|戸棚|cupboard; locker; closet; wardrobe|अलमारी; लॉकर; लकर; गुप्त; गोपनीय; अलमारी
ざぶとん|zabuton|座布団|cushion (Japanese)|गद्दी; बचाना; दूर रखना
ざしき|zashiki|座敷|tatami room|
ぞうきん|zoukin|雑巾|house-cloth; dust cloth|पोंछना; लाश; मिट्टी
すまい|sumai|住まい|dwelling; house; residence; address|आवास; निवास स्थान; निवासस्थान; घर; निवास; निवास स्थान; निवास की अनुमति
じゅうきょ|juukyo|住居|dwelling; house; residence; address|आवास; निवास स्थान; निवासस्थान; घर; निवास; निवास स्थान; निवास की अनुमति
とこや|tokoya|床屋|barber|हज्जाम; नाई
しょうじ|shouji|障子|paper sliding door|कागज़
しんだい|shindai|寝台|bed; couch|बिस्तर; छिपा रहना; चित लेटना
ちりがみ|chirigami|塵紙|tissue paper; toilet paper|महीन कागज़; टिशू पेपर; पतला पारदर्शी कागज; शौच; शौच का कागज़; टइलेट पेपर
せともの|setomono|瀬戸物|earthenware; crockery; china|मिट्टी के बर्तन; मिट्टी के बरतन; चीनी मिट्टी के बर्तन; चीनी; चीनी मिट्टी के बर्तन; चीन; चीनी मिट्टी
せいもん|seimon|正門|main gate; main entrance|प्रमुख; कुलमिलाकर; मुख्य; मुख्यद्वार
ぜいかん|zeikan|税関|customs house|सीमा शुल्क; रीतिरिवाज; सीमाशुल्क विभाग
すなお|sunao|素直|obedient; meek; docile; unaffected|हुक्मबरदार; आज्ञानुवर्ती; आज्ञाकारी; दब्बू; विनम्र; डरपोक; अधीन; विनीत; सीख सकने योग्य
そうこ|souko|倉庫|storehouse; warehouse; godown|ज्ञान का; ज्ञान का भंडार; मालगोदाम; गोदाम; गोदाम में माल रखना; गोदाम में माल; गोदाम
まどぐち|madoguchi|窓口|ticket window|टिकट
まちあいしつ|machiaishitsu|待合室|waiting room|प्रतीक्षालय
かしや|kashiya|貸家|house for rent|घर
だんち|danchi|団地|multi-unit apartments|
だんかい|dankai|段階|gradation; grade; stage|वर्गीकरण; क्रमस्थापन; अश्वश्रुति; कोटि; पद; वर्गीकृत करना; कार्य क्षेत्र; प्रस्तुत करना; चरण
ちょくりゅう|chokuryuu|直流|direct current|एकदिश; एकदिश धारा
でんりゅう|denryuu|電流|electric current|बिजली; बिजली से; बिजली का
とうだい|toudai|灯台|lighthouse|प्रकाश स्तम्भ; प्रकाश स्तंभ
ないせん|naisen|内線|phone extension; indoor wiring; inner line|फ़ोन; भीतरी; आंतरिक; घर; भीतरी; आंतरिक; गुप्त
ばんち|banchi|番地|house number; address|घर; पता
ふろしき|furoshiki|風呂敷|wrapping cloth; cloth wrapper|ओढ़ना; आवरण; लपेटन; पादरी; वस्ट्र; मेज़पोश
ぶっそう|bussou|物騒|dangerous; disturbed; insecure|घमासान; खतरनाक; डरावना; अशांत; व्याकुल; विक्षुब्ध; असुरक्षित; आशंकित
ほうちょう|houchou|庖丁|kitchen knife; carving knife|रसोई; काटने का; माँस काटने का चाक्; काटने का चाकू
まくら|makura|枕|pillow; bolster|रखना; सहारा देना; तकिया; सहारा देना; सहारा; मसनद
るすばん|rusuban|留守番|care-taking; caretaker; house-watching|प्रभारी; कार्यवाहक; रखवाला
りょう|ryou|寮|hostel; dormitory|छात्रावास; धर्मशाला; शयनशाला; शयनगृह
ほうき|houki|箒|(n) broom|पीले और सफेद फुलों वाली; बुहारी; पीले और सफेद फुलों वाली झाड़ी
いけん|iken|異見|different opinion; objection|अलग; विरोध; आपत्ति; एतराज़
いろん|iron|異論|different opinion; objection|अलग; विरोध; आपत्ति; एतराज़
いじゅう|ijuu|移住|migration; immigration|प्रवास; प्रवसन; प्रवर्जन; आप्रवासी; आप्रवासन; आव्रजन
いってい|ittei|一定|fixed; settled; definite; uniform; regularized; defined; standardized; certain; prescribed|स्थिर; निर्धारित; स्थायी; स्थिर; शान्त; शांत; स्पष्ट; निश्चित
やしき|yashiki|屋敷|mansion|हवेली; कोठी
いえで|iede|家出|running away from home; leaving home|एक के बाद एक; लगातार; दौड़
わがまま|wagamama|我がまま|selfishness; egoism; wilfulness; disobedience; whim|स्वार्थ; स्वार्थपरता; अहंभाव; स्वार्थपरता; उच्छृंखलता
かい|kai|階|-floor (counter); stories|
かいきゅう|kaikyuu|階級|class; rank; grade|कक्षा; समादर करना; जत्था; पद; कोटि; पद; वर्गीकृत करना
かいそう|kaisou|階層|class; level; stratum; hierarchy|कक्षा; परत; सपाट; समतल; परत; स्तर; स्तर्
あえて|aete|敢えて|dare (to do); challenge (to do)|ललकार; ललकारना; सामना करना; टोकना; दावा करना; ललकार
たち|tachi|館|house; hall; building; hotel; inn; guesthouse|घर; घर; सभागृह; शयनशाला; इमारत
きょじゅう|kyojuu|居住|residence|निवास; निवास स्थान; निवास की अनुमति
きょうしゅう|kyoushuu|郷愁|nostalgia; homesickness|घटनाओं की यादें; अतीत की ललक; गृहासक्त्ति; गृहवियोग
きょうり|kyouri|郷里|birth-place; home town|घर
のきなみ|nokinami|軒並み|row of houses|चलाना; झिड़की; पंक्ति
こゆう|koyuu|固有|characteristic; tradition; peculiar; inherent; eigen-|विशिष्ट लक्षण; लक्षण; विशिष्टता; प्रथा; परम्परा; परंपरा; निराला; असामान्य; विशेष
と|to|戸|counter for houses|विरोध करना; गिनने का यंत्र; काउंटर
こせき|koseki|戸籍|census; family register|जनगणना; परिवार
とじまり|tojimari|戸締り|closing up; fastening the doors|बंधन; कसनी
おてあらい|otearai|御手洗い|toilet; restroom; lavatory; bathroom (US)|शौचालय; शौचालय; सार्वजनिक; सार्वजनिक शौचघर; शौचालय; सार्वजनिक; सार्वजनिक शौचालय
"""), "ja", "N4", "kanji"),

        Lesson("kw-city", "🚉 City & Transport · 町・交通", "🚉", "150 kanji words", kw("""
えき|eki|駅|station|स्टेशन
はし|hashi|橋|bridge|पुल
こうさてん|kousaten|交差点|intersection|चौराहा; प्रतिच्छेदन
こうばん|kouban|交番|police box|पुलिस
じてんしゃ|jitensha|自転車|bicycle|साइकिल; साइकिल चलाना
じどうしゃ|jidousha|自動車|automobile|मोटर गाड़ी; स्वचालित; वाहन
くるま|kuruma|車|car; vehicle|कार; वाहक; माध्यम; संवाहक
ちかてつ|chikatetsu|地下鉄|underground train|गुप्त; भूमिगत; सुरंग रेल
ちず|chizu|地図|map|नक्शा
まち|machi|町|town; city|कस्बा; शहर
でんしゃ|densha|電車|electric train|बिजली; बिजली से; बिजली का
みち|michi|道|street|गली
にぎやか|nigiyaka|賑やか|bustling; busy|व्यस्त
ひこうき|hikouki|飛行機|aeroplane|विमान; हवाई जहाज; उड़न खटोला
いそがしい|isogashii|忙しい|busy; irritated|व्यस्त; उत्तेजित; उग्र; चिढ़ा हुआ
ゆうびんきょく|yuubinkyoku|郵便局|post office|डाक घर; डाकघर
うんてんしゅ|untenshu|運転手|driver|चालक/गाड़ीवान/कोचवान; चालक; वाहनचालक
きしゃ|kisha|汽車|steam train|भाप चालित रेल; वाष्पचालित रेलगाड़ी
くうこう|kuukou|空港|airport|हवाई अड्डा
こうつう|koutsuu|交通|traffic; transportation|ग़ैरकानूनी व्यापार करना; परिवहन; माल ढोने का व्यापार; किराया; परिवहन विभाग; परिवहन
みなと|minato|港|harbour|बंदरगाह; मन में रखना; शरण देना
し|shi|市|city|शहर
しみん|shimin|市民|citizen|स्थानिक; नागरिक; निवासी
じゅうしょ|juusho|住所|an address; a residence|पता; निवास; निवास स्थान; निवास की अनुमति
じゅうどう|juudou|柔道|judo|जूडो
のりもの|norimono|乗り物|vehicle|वाहक; माध्यम; संवाहक
ちゅうしゃじょう|chuushajou|駐車場|parking lot|कार; कार पार्क
どうぐ|dougu|道具|tool; means|औज़ार; उपाय; आय; साधन
うんてん|unten|運転|operation; motion; driving|कार्य; आपरेशन; काम; गति; प्रस्ताव; इशारा; प्रबल; मूसलाधार; चालन
えんぜつ|enzetsu|演説|speech; address|पंक्ति; भाषा; बोली; पता
えんりょ|enryo|遠慮|diffidence; restraint; reserve|संकोच; संयम; अवरोध; रोक; संचय; अलग छोड़; प्रतिबंध
くだり|kudari|下り|down-train (going away from Tokyo)|
がいこう|gaikou|外交|diplomacy|कूटनीति; राजनीति; व्यवहार कुशलता
まち|machi|街|(1) town; (2) street; road|कस्बा; गली; सड़क
きょうつう|kyoutsuu|共通|commonness; community|जाति; समुदाय; समाज
きょうりょく|kyouryoku|強力|herculean strength; mountain carrier-guide|बलशाली; भागीरथ; पहाड़
こうかん|koukan|交換|exchange; interchange; reciprocity|करना; बदल देना; केन्द्र; बदल देना; इंटरचेंज; अदला बदली करना; पारस्परिकता; पारस्परिक आदान प्रदान; आदान प्रदान
こうさい|kousai|交際|company; friendship; association; society; acquaintance|कंपनी; मैत्री; दोस्ती; संबंध; संघ; समिति
むかい|mukai|向かい|facing; opposite; across the street; other side|सामना; अस्तर; कलर और कफ़; उल्टा; के सामने; विरोधी; पार
さんぽする|sanposuru|散歩|walk; stroll|चलना; टहलना; मंथर गति से चलना; चहल कदमी
いちば|ichiba|市場|(the) market (as a concept)|बाज़ार
じゅうたい|juutai|渋滞|congestion (e.g. traffic); delay; stagnation|भरा हुआ होना; संकुलता; संकुलन; रोकना; रोक देना; रोक; निश्चलता; निष्क्रियता; गतिहीनता
しんごう|shingou|信号|traffic lights; signal; semaphore|यातायात बत्ती; संकेत; उत्कृष्ट; चिन्ह; संकेत से प्रकट; संकेत; संकेत पद्धति
せいげん|seigen|制限|restriction; restraint; limitation|सीमा; रोक; प्रतिबन्ध; संयम; अवरोध; रोक; कमी; हद; सीमा
あと|ato|跡|(1) trace; tracks; mark; sign; (2) remains; ruins; (3) scar|सुराग; संकेत; अवशेष; लिखना; संकेत; छाप
そくど|sokudo|速度|speed; velocity; rate|चलाना; जल्दी करना; भगाना; वेग; गति; इसी रफ्तार से; दर्जा; कोटि
たんじゅん|tanjun|単純|simplicity|सहजता; सरलता; भोलापन
はし|hashi|端|end (e.g. of street); edge; tip; margin; point|अंत; किनारा; उकसाना; किनारा लगाना; गिरना; झुकना; सुझाव
ちえ|chie|知恵|wisdom; wit; sagacity; sense; intelligence; advice|ज्ञान; बुद्धिमत्ता; प्रज्ञा; समझ; विवेक; वाकपटुता; विचक्षणता; बुध्दिमत्ता
ちゅうしゃ|chuusha|駐車|parking (e.g. car)|पार्कींग; गाड़ी स्थान; पड़ाव
とおり|toori|通り|in accordance with ~; following ~; ~ Street; ~ Avenue|सहायक; अनुगामी; निम्नलिखित
つうか|tsuuka|通過|passage through; passing|परिवर्तन; स्वीकृति; किराया; समाप्ति; मृत्यु; क्षणिक
つうこう|tsuukou|通行|passage; passing|परिवर्तन; स्वीकृति; किराया; समाप्ति; मृत्यु; क्षणिक
つうしん|tsuushin|通信|correspondence; communication; news; signal|लिखा; समानता; लिखा पढी; सूचना; संचार; सम्पर्क; समाचार
てつどう|tetsudou|鉄道|railroad|रेलमार्ग; यू. एस.रेलवे
とかい|tokai|都会|city|शहर
とし|toshi|都市|town; city; municipal; urban|कस्बा; शहर; नगरीय; नागर
どうとく|doutoku|道徳|morals|सार; आचरणअ
どうろ|douro|道路|road; highway|सड़क; राजमार्ग; प्रमुख मार्ग
はっしゃ|hassha|発車|departure of a vehicle|हट; रवानगी; प्रस्थान
ひこう|hikou|飛行|aviation|विमान चालन; वायुयान चालन_[विज्ञान]; उड्‌डयन
ほどう|hodou|歩道|footpath; walkway; sidewalk|पगडण्डी; पैदल रास्ता; पगडंडी; पैदल रास्ता; पैदल; पटरी
ほうそう|housou|放送|broadcast; broadcasting|फैलाना; गाना; प्रचार करना; प्रसारण
めんどう|mendou|面倒|trouble; difficulty; care; attention|परेशानी; समस्या; कठिनता; कठिनाई; देखभाल
やっかい|yakkai|厄介|trouble; burden; care; bother|परेशानी; कष्ट देना; पर भार; भार; देखभाल
ゆうびん|yuubin|郵便|mail; postal service|डाक; डाक करना; डाक प्रेषण करना; डाकीय; डाक द्वारा
れっしゃ|ressha|列車|train (ordinary)|रेलगाड़ी
あてな|atena|宛名|address; direction|पता; दिशा
ひととおり|hitotoori|一通り|ordinary; usual; in general; briefly|साधारण; स्वाभाविक; सामान्य; हमेशा; हमेशा का; आम; अधिकतर; साधारणतः
げしゃ|gesha|下車|alighting; getting off|मिलना
したまち|shitamachi|下町|Shitamachi; lower parts of town|छोटा; कम करना; गिरना
かもつ|kamotsu|貨物|cargo; freight|माल; जहाज मे लदा; जहाज़ का बोझ/खेप; भरना; माल; माल ले जाना
まわりみち|mawarimichi|回り道|detour|चक्कर; कहीं जाने के लिए लंबा पथ; चक्करदार मार्ग
かいつう|kaitsuu|開通|opening; open|मौका; शुरुआत; प्रारंभ; खोलना
まちかど|machikado|街角|street corner|गली
きかんしゃ|kikansha|機関車|locomotive; engine|इंजन; रेल का इंजन; गतिशील; इंजन
けんしゅう|kenshuu|研修|training|प्रशिक्षण; शारीरिक प्रशिक्षण
こうさ|kousa|交差|cross|पार करना
こうたい|koutai|交替|alternation; change; relief; relay; shift|प्रत्यावर्तन; बदलना; उभार; राहत; मुक्ति
こうつうきかん|koutsuukikan|交通機関|transportation facilities|किराया; परिवहन विभाग; परिवहन
こうりゅう|kouryuu|交流|alternating current; intercourse; (cultural) exchange; intermingling|प्रत्यावर्ती धारा; प्रत्यावर्ति धारा; संभोग; परस्पर व्यवहर; सम्भोग; करना; बदल देना; केन्द्र
もみじ|momiji|紅葉|(1) (Japanese) maple|मैपिल् की लकड़ी; द्विफ वृक्ष; मैपिल् की
よつかど|yotsukado|四つ角|four corners; crossroads|चार; चौराहा; दोराहा
してつ|shitetsu|私鉄|private railway|गुप्त; साधारण; आत्मीय
じさん|jisan|持参|bringing; taking; carrying|मनोहर; आसानी से मिलना; आकर्षक
しゃこ|shako|車庫|garage; car shed|गैरज में; गाड़ीखाना में; गैरेज; कार
しゃしょう|shashou|車掌|(train) conductor|गार्ड; संवेत गान, वाधादि का निर्देशक; ताप अथवा विद्युत चालक
しゃりん|sharin|車輪|(car) wheel|घुमाना; मोड़ना; पनचक्की
しゅうてん|shuuten|終点|terminus; last stop (e.g train)|अंतिम स्टेशन; अन्तिम स्टेशन; आखिरी
しょうぼうしょ|shoubousho|消防署|fire station|दमकल स्टेशन; दमकल रखने की जगह
のぼり|nobori|上り|up-train (going to Tokyo); ascent|आरोहण; चढ़ाव् अ; चढ़ाई
のりかえ|norikae|乗換|(n) transfer (trains; buses; etc.)|सौंपना; स्थानान्तरित करना; स्थानान्तरण; आदि
じょうしゃ|jousha|乗車|taking a train; entraining|मनोहर; आसानी से मिलना; आकर्षक
しんかんせん|shinkansen|新幹線|bullet train (very high speed); shinkansen|बड़ा निशान; गोली; इक्का
しんろ|shinro|針路|course; direction; compass bearing|पाठ्यक्रम; दिशा; परकार; सीमा; कम्पास/दिशा निरूपण यंत्र
ひとどおり|hitodoori|人通り|pedestrian traffic|नीरस; पैदल चलने वाला; पादचारी
せきどう|sekidou|赤道|equator|भूमध्य रेखा; भूमध्य
せつぞく|setsuzoku|接続|(1) connection; union; join; link; (2) changing trains|नाता; संबन्ध; संपर्क; संयोग; संघ; ग्रेट ब्रिटेन; शामिल होना
せんでん|senden|宣伝|propaganda; publicity|अधिप्रचार; प्रचार; प्रख्याति; विज्ञापन; प्रचार
もぐる|moguru|潜る|(1) to drive; to pass through; (2) to evade; to hide; (3) to dive (into or under water); to go undergroun|चलाना; गुजरना; टाल मटोल करना; टाल; पकड़ में न आना
せんろ|senro|線路|line; track; roadbed|रेखा; पंक्ति; तय करना; फ़ासला
だいく|daiku|大工|carpenter|बढ्ॅअई; बढ़ई
おおどおり|oodoori|大通り|main street|प्रमुख; कुलमिलाकर; मुख्य
ちてん|chiten|地点|site; point on a map|बनाना; घटनास्थल; स्थान; बिंदु
ちょくつう|chokutsuu|直通|direct communication|सरल; सीधा; ठीक
つうか|tsuuka|通貨|currency|मुद्रा; लोकप्रियता; व्यापकता
つうきん|tsuukin|通勤|commuting to work|
つうち|tsuuchi|通知|notice; notification|सूचना; चेतावनी; देखना; अधिसूचन; अधिसूचना
つうちょう|tsuuchou|通帳|passbook|पासबुक
つうやく|tsuuyaku|通訳|interpretation|स्पष्टीकरण; व्याख्या; अर्थ
つうよう|tsuuyou|通用|popular use; circulation|लोकप्रिय; खपत; गर्दिश; प्रचलन
つうろ|tsuuro|通路|passage; pathway|परिवर्तन; स्वीकृति; किराया; पथ
ていしゃ|teisha|停車|stopping (e.g. train)|
ていでん|teiden|停電|failure of electricity|असफलता; गिरना; गिरावट
てっきょう|tekkyou|鉄橋|railway bridge; iron bridge|रेल पथ; रेलवे; रेल की पटरी; कर्कश; कठोर; निर्दय
みちじゅん|michijun|道順|itinerary; route|यात्राविवरण; यात्राक्रम; मार्ग; रास्ता; भेज देना
つきあたり|tsukiatari|突き当たり|end (e.g. of street)|अंत
ふつう|futsuu|不通|suspension; interruption; stoppage; tie-up; cessation|स्थगन; निलम्बन; थोड़े समय के लिये रुकावट; बाधा; अवरोध; रुकावट; विराम; अवरोध; रुकावट
かたみち|katamichi|片道|one-way (trip)|
びんせん|binsen|便箋|writing paper; stationery|लेखन कागज; लेखन सामग्री; पत्र लेखन कागज़; कागज़ आदी सामग्री
めいし|meishi|名刺|business card|परिचय कार्ड; परिचय
ゆそう|yusou|輸送|transport; transportation|पहुँचाना; परिवहन; सवारी; किराया; परिवहन विभाग; परिवहन
ようせき|youseki|容積|capacity; volume|सामर्थ्य; क्षमता; धारण शक्ति; प्रबलता; घनफल; अंक
はなしちゅう|hanashichuu|話中|while talking; the line is busy|काल; समय; यद्यपि
ねじまわし|nejimawashi|ねじ回し|screwdriver|पेंचकश
あて|ate|宛|addressed to|के प्रति; के नाम
いくせい|ikusei|育成|rearing; training; nurture; cultivation; promotion|प्रशिक्षण; शारीरिक प्रशिक्षण; विकसित करना; सिक्षा देना; पालना
うんそう|unsou|運送|shipping; marine transportation|नौपरिवहन; पोत परिवहन; पोत समूह; समुद्री; नौसैनिक; समुद्रीय
うんぱん|unpan|運搬|transport; carriage|पहुँचाना; परिवहन; सवारी; बच्चा गाड़ी; आचरण; चाल
うんゆ|unyu|運輸|transportation|किराया; परिवहन विभाग; परिवहन
えんせん|ensen|沿線|along railway line|साथ
かいろ|kairo|回路|circuit (electric)|चक्कर; घूमना; परिपथ
まち|machi|街|~street; ~quarters|
かいどう|kaidou|街道|highway|राजमार्ग; प्रमुख मार्ग
かんい|kani|簡易|simplicity; easiness; quasi-|सहजता; सरलता; भोलापन
かんけつ|kanketsu|簡潔|brevity; conciseness; simplicity|अल्पता; संक्षिप्तता; लाघव; संक्षिप्तता; सहजता; सरलता; भोलापन
かんそ|kanso|簡素|simplicity; plain|सहजता; सरलता; भोलापन; सरल; समतल; सीधा
きどう|kidou|軌道|orbit; railroad track|कार्यक्षेत्र; कक्षा; नेत्रगुहा; रेलमार्ग; यू. एस.रेलवे
ぎのう|ginou|技能|technical skill; ability; capacity|तकनीकी; कानूनी; पारिभाषिक; प्रतिभा; योग्यता; सामर्थ्य; सामर्थ्य; क्षमता; धारण शक्ति
きゅうくつ|kyuukutsu|窮屈|narrow; tight; stiff; rigid; uneasy; formal; constrained|संकरा; कठिन; तंग; कंजूस; कठोर; कठिन; रूखा
はしわたし|hashiwatashi|橋渡し|bridge building; mediation|पुल; माध्यम; मध्यस्थता; चिन्तन
けいたい|keitai|携帯|carrying something|
けいろ|keiro|経路|course; route; channel|पाठ्यक्रम; मार्ग; रास्ता; भेज देना; पहुं़चाया; पहुं़चाया जाना; नहर
けいそつ|keisotsu|軽率|rash; thoughtless; careless; hasty|अविवेकपूर्ण; अतिशीघ्र; अधिक; लापरवाह; विचारशून्य; बेलिहाज़; कच्चा; आलसी; लापरवाह
みとおし|mitooshi|見通し|perspective; unobstructed view; outlook; forecast; prospect; insight|दृष्टिकोण; दृश्य; यथार्थ; अबाधित; बेरोक; अव्याहत; दृष्टिकोन; दृष्टिकोण; दृश्य
こうえき|koueki|交易|trade; commerce|उद्योग; व्यापार करना; कारोबार; वाणिज्य
こうご|kougo|交互|mutual; reciprocal; alternate|पारस्परिक; आपसी; परस्पर; पारस्परिक; प्रजाति परिवर्तक संकरण; अंतर्बदल; दूसरा; हर दूसरा; एकांतरण
こうしょう|koushou|交渉|negotiations; discussions; connection|नाता; संबन्ध; संपर्क
こうふ|koufu|交付|delivering; furnishing (with copies)|
あわただしい|awatadashii|慌ただしい|busy; hurried; confused; flurried|व्यस्त; असंगत; अस्पष्ट; हैरान
"""), "ja", "N4", "kanji"),

        Lesson("kw-nature", "🌳 Nature & Weather · 自然・天気", "🌳", "208 kanji words", kw("""
あめ|ame|雨|rain|बारिश
はな|hana|花|flower|फूल
かびん|kabin|花瓶|a vase|फूलदान; गुलदान
うみ|umi|海|sea|समुद्र
そら|sora|空|sky|आसमान
さとう|satou|砂糖|sugar|चीनी
やま|yama|山|mountain|पहाड़
みず|mizu|水|water|पानी
ゆき|yuki|雪|snow|बर्फ
せん|sen|千|thousand|हज़ार
川/河||川/河|river|नदी
いけ|ike|池|pond|ताल; पोखरी; तालाब
てんき|tenki|天気|weather|मौसम
くもり|kumori|曇り|cloudy weather|मटमैला; मेघाच्छादित
かぜ|kaze|風|wind|हवा
まん|man|万|ten thousand|दस
き|ki|木|tree; wood|पेड़; पीपा; वन; काष्ठ
おみやげ|omiyage|お土産|souvenir|निशानी; यादगार
くも|kumo|雲|cloud|बादल
ひ|hi|火|fire|आग
はなみ|hanami|花見|cherry-blossom viewing|
かいがん|kaigan|海岸|coast|किनारा; चलाना; व्यापार
くうき|kuuki|空気|air; atmosphere|हवा; वायुमण्डल; परिमण्डल; वातावरण
けしき|keshiki|景色|scene; landscape|घटना; तमाशा; मौका; प्राकृतिक दृश्य; रूचिकर; भूदृश्य
みずうみ|mizuumi|湖|lake|झील
すな|suna|砂|sand|रेत
もり|mori|森|forest|जंगल
ほし|hoshi|星|star|तारा
いし|ishi|石|stone|पत्थर
たいふう|taifuu|台風|typhoon|प्रचंड तूफ़ान; प्रचण्ड तूफान; प्रचंड
じしん|jishin|地震|earthquake|भूचाल; भूकम्प; भुकम्प
てんきよほう|tenkiyohou|天気予報|weather forecast|मौसम; मौसम पूर्वानुमान; मौसम का पूर्वानुमान
いなか|inaka|田舎|countryside|देहात; ग्रामीण क्षेत्र
しま|shima|島|island|द्वीप
もめん|momen|木綿|cotton|धागा; सूती; सूती कपड़ा
はやし|hayashi|林|woods; forester|वन; जंगल; वन रक्षक; वनपाल
えいせい|eisei|衛星|satellite|अनुगामी; उपाश्रित देश; उपग्रह
おき|oki|沖|open sea|खोलना
かわ|kawa|河|river; stream|नदी; बहना; वर्ग; प्रवाह
かさい|kasai|火災|conflagration; fire|अग्निकाण्ड; आग
かいがい|kaigai|海外|foreign; abroad; overseas|विदेशी; बाहरी; प्रचलित; बाहर; बाहरी; विदेशी; समुद्र पार
かいし|kaishi|開始|start; commencement; beginning|शुरू करना; शुरुआत; आरम्भ; प्रक्रम; शुरुआत
かぶ|kabu|株|share; stock; stump (of tree)|साझा करना; प्रतिष्ठा; लगाना; नाम; ठूँठ; पैर घसीट कर चलना; मंच
そら|sora|空|sky|आसमान
あき|aki|空き|room; time to spare; emptiness|कमरा; समय; शून्य; खालीपन; शून्यता
あく|aku|空く|(1) to open; to become empty; (2) to be less crowded|खोलना
くんれん|kunren|訓練|practice; training|अभ्यास; कार्यप्रणाली; वकालत करना; प्रशिक्षण; शारीरिक प्रशिक्षण
けいじ|keiji|掲示|notice; bulletin|सूचना; चेतावनी; देखना; सरकारी समाचार; बुलेटिन
けいこく|keikoku|警告|warning; advice|चेतावनीपूर्ण; चेतावनी; धमकी; सलाह
けんかい|kenkai|見解|opinion; point of view|विचार; मत; अनुमान; दृष्टिकोण
はら|hara|原|field; plain; prairie; tundra; moor; wilderness|कार्य क्षेत्र; आधार; खेलनेवाल दल; सरल; समतल; सीधा; प्रेयरी
ごかい|gokai|誤解|misunderstanding|गलतफहमी; भ्रम; मिथ्याबोध
こうへい|kouhei|公平|fairness; impartial; justice|निष्पक्ष; अपक्षपाती; पक्षपातरहित; न्यायाधीश; औचित्य; कार्रवाई
かたい|katai|硬い|solid; hard (esp. metal; stone); unpolished writing|असली; वास्तविक; सच्चा; कठिन; पत्थर
こうくう|koukuu|航空|aviation; flying|विमान चालन; वायुयान चालन_[विज्ञान]; उड्‌डयन; लहरात हुआ; उड़ने वाला; हवाई यात्रा
こうけん|kouken|貢献|contribution; services|सहायता; चंदा; लेख
こくもつ|kokumotsu|穀物|grain; cereal; corn|कण; स्वभाव; बीज; अन्न/अनाज का पौधा; सीरियल; अन्न; सुरक्षित रखना; मकई; कण
さばく|sabaku|砂漠|desert|त्याग देना; निर्जन; सेना से
さくら|sakura|桜|cherry blossom; cherry tree|गहरा लाल; बदरीरक्त; रक्तिम; चेरी वृक्ष
しぜん|shizen|自然|nature; spontaneous|प्रकार; गुण; वर्ग; सहज; स्वाभाविक; जंगली
しゅう|shuu|州|sandbank|रेतीला तट; रेती/सैकत
しょめい|shomei|署名|signature|अंकित अंक; हस्ताक्षर; दस्तखत
まつ|matsu|松|(1) pine tree; (2) highest (of a three-tier ranking system)|देवदार; उच्चतम
すいじゅん|suijun|水準|(1) water level; (2) level; standard|भौम जलस्तर; जल रेखा; जलस्तर; परत; सपाट; समतल; दर्जा; शिष्ट; मान
せきたん|sekitan|石炭|coal|कोयला भरना; कोयला उपलब्ध करना; अंगार
せきゆ|sekiyu|石油|oil; petroleum; kerosene|तेल; भूतेल; पेट्रोलियम; मिट्टी तेल; मिट्टी का तेल; घासलेट
せつび|setsubi|設備|equipment; device; facilities; installation|उपकरण; तैयारी; उपकरण; योजना; साहित्य में पाठक पर प्रभाव छोड़ने वाली लेखन शैली; सुविधा; सुविधाएँ
かわ|kawa|川|river|नदी
せんたく|sentaku|選択|selection; choice|चुनाव; चयन; संकलन; प्रकार; चारा; चुनाव
素晴らしい||素晴らしい|wonderful; splendid; magnificent|अनोखा; आश्चर्यजनक; अद्भुत; शानदार; बहुत बढ़िया; उजागर; शानदार; भव्य
たいよう|taiyou|太陽|sun; solar|सूरज; सूर्य; सौर
しらせ|shirase|知らせ|notice|सूचना; चेतावनी; देखना
ちのう|chinou|知能|intelligence; brains|सूचना; ज्ञान; गुप्त समाचार
ながめ|nagame|眺め|scene; view; prospect; outlook|घटना; तमाशा; मौका; दृष्टिकोण; विचार करना; समझना; दृश्य; खोज़ना; खोज करना
てんねん|tennen|天然|nature; spontaneity|प्रकार; गुण; वर्ग; सहजता; स्वाभाविकता
た|ta|田|rice field|चावल
とざん|tozan|登山|mountain-climbing|
つち|tsuchi|土|earth; soil|पृथ्वी; मैला करना; कलंकित करना; दूषित करना
みやげ|miyage|土産|present; souvenir|उपहार; निशानी; यादगार
とち|tochi|土地|plot of land; lot; soil|कथानक; भूभाग; षड्यंत्र; बहुत; मैला करना; कलंकित करना; दूषित करना
くもり|kumori|曇|cloudiness; cloudy weather; shadow|मटमैला; मेघाच्छादित; सितारा मछली; सूट्र; शरण
のう|nou|能|being skilled in; nicely; properly|जीवन; स्वभाव; प्राणी; संतोषप्रद; अच्छी तरह से; अच्छे से; ठीक से; उचित ढंग से
なみ|nami|波|wave|करना; दल; घुमाना
うめ|ume|梅|plum; plum-tree; lowest (of a three-tier ranking system)|लाभदायक; एकदम; बेर का फल
ばいう|baiu|梅雨|rainy season; rain during the rainy season|बरसाती; बारिश
はたけ|hatake|畑|field|कार्य क्षेत्र; आधार; खेलनेवाल दल
ひひょう|hihyou|批評|criticism; review; commentary|आलोचना; समीक्षा; आलोचना/समीक्षा; परखना; सर्वेक्षण; पुनःपरीक्षण; कमेंट्री; टिप्पणी; भाष्य
こおり|koori|氷|ice; hail|बर्फ; ओलावृष्टि; बुलाना; अभिवादन
ふせい|fusei|不正|injustice; unfairness|जफा; अन्याय; अनौचित्य; अन्याय; अन्यायपूर्णता
ふうけい|fuukei|風景|scenery|दृश्य; प्राकृतिक दृश्य; मंच सज्जा
ほうせき|houseki|宝石|gem; jewel|लाखों में एक; अमूल्य; सर्वोत्तम; बहुमूल्य वस्तु; रत्नों से सुसज्जित करना; गहना
つとめ|tsutome|務め|(1) service; duty; (2) Buddhist religious services|कार्य; कर्मचारी; सहायता; काम; कर्तव्य; कर
めんきょ|menkyo|免許|license; permit; licence; certificate|स्वच्छंदता; लाइसेंस; अनुज्ञा प्रदान; परमिट; अनुमति देना; अनुमति; अतिशयोक्ति; स्वच्छंदता; लाइसेंस
の|no|野|field|कार्य क्षेत्र; आधार; खेलनेवाल दल
やく|yaku|役|use; service; role; position|उपयोग; कार्य; कर्मचारी; सहायता; कर्तव्य; भूमिका
かみなり|kaminari|雷|thunder|ज़ोर से धमाकाना; गरजना; आलोचना करना
あらし|arashi|嵐|storm; tempest|तूफान; आँधी; तूफ़ान; सागर का तूफ़ान
げすい|gesui|下水|drainage; sewage; ditch; gutter; sewerage|निकास; अपवहन क्षेत्र; पानी का निकास/मोरी/; गन्दा पानी/मल जल; गंदा पानीई; मलजल; नाली; उतारना; खाई
かくう|kakuu|架空|aerial; overhead; fiction; fanciful|आकाशीय; एरियल{रेडियो संकेत पकड़ने वाला यंत्र}; एरियल; ऊपर; बँधा खर्च; अतिरिक्त; कल्पना; कथा; परिकल्पना
かこう|kakou|火口|a burner; origin of a fire|दाहक; चुल्हा; बर्नर; मूल; आरम्भ; उद्गम
かざん|kazan|火山|volcano|ज्वालामुखी पहाड़; ज्वालामुखी
やけど|yakedo|火傷|burn; scald|करना; दाग; ख़र्च करना; जलाना; अच्छी तरह गरम करना; गरम पानी
はなよめ|hanayome|花嫁|bride|नववधू/दुल्हन; दुल्हन; नववधू
はなび|hanabi|花火|fireworks|
かいすいよく|kaisuiyoku|海水浴|sea bathing; seawater bath|समुद्र
かいよう|kaiyou|海洋|ocean|दक्षिण ध्रुव; अत्यधिक; अत्यधिक फैलाव
かんでんち|kandenchi|乾電池|dry cell; battery|सूखा; समूह; तोपखाना; संग्रह
かんちがい|kanchigai|勘違い|misunderstanding; wrong guess|गलतफहमी; भ्रम; मिथ्याबोध; गलत
ぎしき|gishiki|儀式|ceremony; rite; ritual; service|अवसर; अतिशयोक्ति; विधि; धार्मिक संस्कार; रीति; धार्मिक रिवाज; संस्कार; धार्मिक कृत्य; रस्म संबंधी
からっぽ|karappo|空っぽ|empty; vacant; hollow|खाली; खाली; विचार शून्य; रिक्त; मन्द; मिथ्या; निरर्थक
くうそう|kuusou|空想|daydream; fantasy; fancy; vision|ख़याली पुलाव पकाना; दिवास्वप्न; दिवास्वप्न देखना; कल्पना; कोरी कल्पना; स्वैर; चाहना; कल्पना करना; अनोखा
くうちゅう|kuuchuu|空中|sky; air|आसमान; हवा
けいこ|keiko|稽古|practice; training; study|अभ्यास; कार्यप्रणाली; वकालत करना; प्रशिक्षण; शारीरिक प्रशिक्षण; पढ़ाई
こうせい|kousei|公正|justice; fairness; impartiality|न्यायाधीश; औचित्य; कार्रवाई; निष्पक्षता; अपक्षपात
こうせき|kouseki|功績|achievements; merit; meritorious service; meritorious deed|विशेषता; योग्यता; सराहना; सराहनीय; गुणी
こうすい|kousui|香水|perfume|इत्र लगाना; खुशबू से भरपूर करदेना; सुगंधित करना
ざいもく|zaimoku|材木|lumber; timber|इमारती लकड़ी; काठ कबाड़; भद भदते हुए; वन; काष्ठ; इमारती
さくいん|sakuin|索引|index; indices|तालिका; सूचक; के अनुरूप बढ़ाना; सूचियाँ; बीज गणित में प्रयुक्त विशेष चिह्न/इंडॆक्स का बहुवचन
さんりん|sanrin|山林|mountain forest; mountains and forest|पहाड़
じしゃく|jishaku|磁石|magnet|आक्र्षण केंद्र; चुम्बक; चुंबक
しゃせい|shasei|写生|sketching; drawing from nature|रेखाचित्रण; चित्रकारी; चिट्रंकनअ; चिट्रकारी
うえき|ueki|植木|garden shrubs; trees; potted plant|बगीचा; संक्षिप्त; गमले में लगा; गमले में
しんりん|shinrin|森林|forest; woods|जंगल; वन; जंगल
しんくう|shinkuu|真空|vacuum; hollow; empty|खाली जगह; शून्य; खालीपन; मन्द; मिथ्या; निरर्थक; खाली
ふぶき|fubuki|吹雪|snow storm|बर्फ
すいさん|suisan|水産|marine products; fisheries|समुद्री; नौसैनिक; समुद्रीय
すいじょうき|suijouki|水蒸気|water vapour; steam|जलवाष्प; भाप शक्ति से याट्रा; भाप शक्ति; वाष्प
すいそ|suiso|水素|hydrogen|हाइड्रोजन; उदजन
すいてき|suiteki|水滴|drop of water|गिराना
すいとう|suitou|水筒|canteen; flask; water bottle|तामलेट; कैंटीन; छुरी काँटा रखने का; पतले मुंह की बोतल; पानी की बोतली; पानी की बोतल; पानी
すいへい|suihei|水平|water level; horizon|भौम जलस्तर; जल रेखा; जलस्तर; सीमा; क्षितिज
すいへいせん|suiheisen|水平線|horizon|सीमा; क्षितिज
せいしつ|seishitsu|性質|nature; property; disposition|प्रकार; गुण; वर्ग; गुण; स्वभाव; अधिकार; प्रवृत्ति; प्रबंध; स्थिति
いけばな|ikebana|生け花|(1) flower arrangement|फूल
せっけん|sekken|石鹸|soap|साबुन से रगड़ना; साबुन; साबुन लगाना
せんぷうき|senpuuki|扇風機|electric fan|बिजली; बिजली से; बिजली का
たいぼく|taiboku|大木|large tree|बड़ा
たんすい|tansui|淡水|fresh water|ताज़ा
だんすい|dansui|断水|water outage|पानी
ちかすい|chikasui|地下水|underground water|गुप्त; भूमिगत; सुरंग रेल
たんぼ|tanbo|田ぼ|paddy field; farm|धान के; धान का खेत; धान के खेत; खेत
たうえ|taue|田植え|rice planting|चावल
でんち|denchi|電池|battery|समूह; तोपखाना; संग्रह
でんぱ|denpa|電波|electro-magnetic wave|
とうげ|touge|峠|ridge; (mountain) pass; difficult part|ऊपर उठाना; ढालू टीला{ या पहाड़ी}; मंगरा; पास करना; कठिन
にじ|niji|虹|rainbow|ऐरावत; इन्द्र धनुष; मेघधनुष
はんとう|hantou|半島|peninsula|प्रायद्वीप
ひきょう|hikyou|卑怯|cowardice; meanness; unfairness|कायरता; कंजूसी; नीचता; अनौचित्य; अन्याय; अन्यायपूर्णता
ふうせん|fuusen|風船|balloon|गोलक; गुब्बारा
ふんか|funka|噴火|eruption|उद्भेदन; उदभेदन
ふんすい|funsui|噴水|water fountain|पेय जल का सोता
へいや|heiya|平野|plain; open field|सरल; समतल; सीधा; खोलना
なみき|namiki|並木|roadside tree; row of trees|सड़क का किनारा; सड़क के किनारे का; सड़क का; चलाना; झिड़की; पंक्ति
ぼんち|bonchi|盆地|basin (e.g. between mountains)|नदी की; चिलमची; चिलमची/कुण्डी
もくざい|mokuzai|木材|lumber; timber; wood|इमारती लकड़ी; काठ कबाड़; भद भदते हुए; वन; काष्ठ; इमारती; पीपा; वन; काष्ठ
ひざし|hizashi|陽射|sunlight; rays of the sun|धूप
りゅういき|ryuuiki|流域|(river) basin|नदी की; चिलमची; चिलमची/कुण्डी
さすが|sasuga|流石|clever; adept; good; expectations; as one would expect|बुद्धिमान; योग्य; निपुण; दक्ष; प्रवीण; निपुण; अच्छा
つぶ|tsubu|粒|grain|कण; स्वभाव; बीज
れっとう|rettou|列島|chain of islands|बंधन; क्रम; नापना
ふもと|fumoto|麓|the foot; the bottom; the base (of a mountain)|पैर; पता; निम्नतम; नितम्ब; आधार
もって|motte|以て|with; by; by means of; because; in view of|साथ; द्वारा; से; के माध्यम से
しるし|shirushi|印|seal; stamp; mark; print|मुद्रांकित; छाप; सील मछली; प्रकार; छाप; पैर घसीट कर चलना; लिखना; संकेत; छाप
いんかん|inkan|印鑑|stamp; seal|प्रकार; छाप; पैर घसीट कर चलना; मुद्रांकित; छाप; सील मछली
あまぐ|amagu|雨具|rain gear|बारिश
うてん|uten|雨天|rainy weather|बरसाती
したび|shitabi|下火|burning low; waning; declining|जलता हुआ; प्रबल; दाहक; घटाव; घटता हुआ; घटता
かせき|kaseki|化石|fossil; petrifaction; fossilization|जीवाश्म; जीवावशेष; रूढ़िवादि व्यक्ति; जीवाश्मीकरण; जीवावशेषन
かせん|kasen|河川|rivers|
ひばな|hibana|火花|spark|कारण बनना; जोश; चिनगारी
やけど|yakedo|火傷|burn; scald|करना; दाग; ख़र्च करना; जलाना; अच्छी तरह गरम करना; गरम पानी
かせい|kasei|火星|Mars (planet)|मंगल; मंगल ग्रह
こたつ|kotatsu|火燵|table with heater; (orig) charcoal brazier in a floor well|मेज़; लकड़ी का कोयलाआ; चारकोल; लकड़ी का
はなびら|hanabira|花びら|(flower) petal|पंखुड्ॅई; पँखुडी
かだん|kadan|花壇|flower bed|फूलों की क्यारी
かふん|kafun|花粉|pollen|पराग; मधु; पराग केसर
はなばなしい|hanabanashii|華々しい|brilliant; magnificent; spectacular|मेधावी; चमकीला; उत्कृष्ट; शानदार; भव्य; प्रभावशाली; असाधारण; अच्छी प्रदर्शन/शानदार
かいうん|kaiun|海運|maritime; marine transportation|तटवर्ती; समुद्री; समुद्र; समुद्री; नौसैनिक; समुद्रीय
かいきょう|kaikyou|海峡|channel|पहुं़चाया; पहुं़चाया जाना; नहर
かいばつ|kaibatsu|海抜|height above sea level|शिखर; चरम; पराकाष्ठा
かいりゅう|kairyuu|海流|ocean current|दक्षिण ध्रुव; अत्यधिक; अत्यधिक फैलाव
うみじ|umiji|海路|sea route|जलमार्ग
はい|hai|灰|puckery juice|
かんこく|kankoku|勧告|advice; counsel; remonstrance; recommendation|सलाह; राय देना; परामर्श; सुझाव देना; विरोध; आपत्ति/विद्रोह; प्रतिवाद
かん|kan|幹|(tree) trunk|लाइन; धारा; डाली
なれ|nare|慣れ|practice; experience|अभ्यास; कार्यप्रणाली; वकालत करना; अनुभव करना; अनुभव; अनुभूति
かんてん|kanten|観点|point of view|दृष्टिकोण
かんらん|kanran|観覧|viewing|प्रदर्शन; शोक प्रदर्शन
がんせき|ganseki|岩石|rock|कड़ी; हिलना; पत्थर
きれい|kirei|奇麗|pretty; clean; nice; tidy; beautiful; fair|सुंदर; साफ; अच्छा
きよ|kiyo|寄与|contribution; service|सहायता; चंदा; लेख; कार्य; कर्मचारी; सहायता
きふう|kifuu|気風|character; traits; ethos|दर्जा; प्रतिष्ठा; गुण; लोकाचार; सदाचार सम्बन्धी
きめい|kimei|記名|signature; register|अंकित अंक; हस्ताक्षर; दस्तखत; बताना; प्रकट करना; पंजीकृत कराना
きてん|kiten|起点|starting point|प्रारम्भिक मुद्दा; प्रारम्भिक स्थान; शुरू करने का स्थान
ぎせい|gisei|犠牲|sacrifice|त्याग; बलि; कुर्बानी
きゅうせん|kyuusen|休戦|truce; armistice|अस्थायी संधि काल; युद्ध विराम; थोड़े दिन की सन्धि; युद्धविराम
きり|kiri|桐|paulownia tree|
きんろう|kinrou|勤労|labor; exertion; diligent service|जी तोड़ कोशिश करना; मजदूर वर्ग; श्रमजीवी वर्ग; प्रयास; परिश्रम; श्रम; परिश्रमी; सतत; अनवरत/उद्यमी/ उद्योगी/ एकाग्रचित्त/ परिश्रमी/ सावधान
むなしい|munashii|空しい|vacant; futile; vain; void; empty; ineffective; lifeless|खाली; विचार शून्य; रिक्त; व्यर्थ; व्यर्थ; अहंकारी; खोखला
うつろ|utsuro|空ろ|blank; cavity; hollow; empty (space)|खाली; भावशून्य; शून्य; छिद्र; गुहिका; विवर; मन्द; मिथ्या; निरर्थक
くうふく|kuufuku|空腹|hunger|तीव्र इच्छा; भूख
いきさつ|ikisatsu|経緯|1.  details; whole story; sequence of events; particulars; how it started; how things got this way; 2.  c|एक; पूरी तरह से; पूर्णतया; पूरा; दृश्य; क्रम; अनुक्रम
けいぶ|keibu|警部|police inspector|पुलिस
みはらし|miharashi|見晴らし|view|दृष्टिकोण; विचार करना; समझना
けんち|kenchi|見地|point of view|दृष्टिकोण
はらっぱ|harappa|原っぱ|open field; empty lot; plain|खोलना; खाली; सरल; समतल; सीधा
げんてん|genten|原点|origin (coordinates); starting point|मूल; आरम्भ; उद्गम; प्रारम्भिक मुद्दा; प्रारम्भिक स्थान; शुरू करने का स्थान
こうにん|kounin|公認|official recognition; authorization; licence; accreditation|प्रामाणिक; अधिकारी; सरकारी; अधिकार; प्राधिकरण; अनुमति; अतिशयोक्ति; स्वच्छंदता; लाइसेंस
"""), "ja", "N4", "kanji"),

        Lesson("kw-body", "🩺 Body & Health · 体・健康", "🩺", "282 kanji words", kw("""
おてあらい|otearai|お手洗い|bathroom|स्नानघर
いしゃ|isha|医者|medical doctor|चिकित्सीय परीक्षा; चिकित्सीय; चिकित्सा
へた|heta|下手|unskillful|अनाड़ी
さむい|samui|寒い|cold|ठंडा
ちかい|chikai|近い|near|पास
ちかく|chikaku|近く|near|पास
くち|kuchi|口|mouth; opening|मुँह; मौका; शुरुआत; प्रारंभ
ひだり|hidari|左|left hand side|बायाँ
は|ha|歯|tooth|दाँत
みみ|mimi|耳|ear|कान
て|te|手|hand|हाथ
てがみ|tegami|手紙|letter|पत्र
でぐち|deguchi|出口|exit|निकास
じょうず|jouzu|上手|skillful|कुशल; कौशलपूर्ण
こえ|koe|声|voice|आवाज़
きって|kitte|切手|postage stamp|डाक टिकट
はやい|hayai|早い|early|जल्दी
あし|ashi|足|foot; leg|पैर; पैर
からだ|karada|体|body|शरीर
いたい|itai|痛い|painful|भद्दा; कठिन; दर्दीला
あたま|atama|頭|head|सिर
いりぐち|iriguchi|入口|entrance|प्रवेश द्वार
あつい|atsui|熱い|hot to the touch|गर्म
せ|se|背|height; stature|शिखर; चरम; पराकाष्ठा; महत्ता; क्षमता या उपलब्धि से कमाई हुई इज्जत और रूतबा; तन की प्राकृतिक लम्बाई
せびろ|sebiro|背広|business suit|व्यापार
はな|hana|鼻|nose|नाक
びょういん|byouin|病院|hospital|अस्पताल
びょうき|byouki|病気|illness|रोग; बीमारी; अस्वास्थ्य
かぜ|kaze|風邪|a cold|ठंडा
め|me|目|eye|आँख
くすり|kusuri|薬|medicine|दवा
つめたい|tsumetai|冷たい|cold to the touch|ठंडा
あんしん|anshin|安心|relief|उभार; राहत; मुक्ति
おく|oku|億|one hundred million|
したぎ|shitagi|下着|underwear|नीचे पहनने के कपड़े; अंतर्वस्त्र
ぐあい|guai|具合|condition; health|निश्चित करना; उपाधि; ठीक करना; स्वास्थ्य
ち|chi|血|blood|खून
さか|saka|坂|slope; hill|झुकाना; समतल; झुकना; पहाड़ी
ゆび|yubi|指|finger|उंगली
ゆびわ|yubiwa|指輪|finger ring|अंगूठी
はいしゃ|haisha|歯医者|dentist|दाँतों का डाक्टर; दन्त चिकित्सक; दंतकार
てぶくろ|tebukuro|手袋|glove|दस्ताना
くび|kubi|首|neck|गर्दन
ねぼう|nebou|寝坊|sleeping in late|
こころ|kokoro|心|core; heart|बीजकोष; किसी चीज का मुख्य भाग; सब से महत्वपूर्ण भागा; दिल
ねつ|netsu|熱|fever|उत्तेजना; ताप; ज्वर
せなか|senaka|背中|back of the body|पीठ
かみ|kami|髪|hair|बाल
ねむい|nemui|眠い|sleepy|निद्राजनक; शांत; उनींदा
け|ke|毛|hair or fur|बाल
おなか|onaka|お腹|stomach|इच्छा; सहना; उदर
わるくち|warukuchi|悪口|abuse; insult; slander; evil speaking|गाली; दुर्व्यवहार; बरबाद करना; अपमान होना; अपमान; अपमान करना; मानहानिअना; मानहानि; मिथ्यापवाद
あくしゅ|akushu|握手|handshake|हाथ मिलाना; एक दूसरे से हाथ मिलाना
あんき|anki|暗記|memorization; learning by heart|ज्ञान; अधिगम; ज्ञान/विद्या
いし|ishi|意志|will; volition|theres a way,जहाँ चाह है वहाँ राह है,Noun; इच्छा; चाहना; इच्छा; इच्छा शक्ति; इच्छाशक्ति
い|i|胃|stomach|इच्छा; सहना; उदर
いし|ishi|医師|doctor; physician|डॉक्टर; चिकित्सकअ; चिकित्सक/वैद्य; डाक्टरअ
いりょう|iryou|医療|medical care; medical treatment|चिकित्सीय परीक्षा; चिकित्सीय; चिकित्सा; इलाज
いったい|ittai|一体|(1) one object; one body; (2) what on earth?; really?; (3) generally|न जाने क्या?; न जाने
かもく|kamoku|科目|(school) subject; curriculum; course|विषय; पाठ्यक्रम; पाठ्यक्रम
けが|kega|怪我|injury (to animate object); hurt|घाव; क्षति; आकस्मिक चोट; दर्द पहुँचाना; चोट; ज़ख़्मी
ひたい|hitai|額|forehead; brow|मस्तिष्क; माथा; शिखर; मस्तक; भौंह
かんじゃ|kanja|患者|a patient|सहनशील; रोगी; सबर
かんしん|kanshin|感心|admiration; Well done!|प्रशंसा; विस्मय; आभार; अच्छी तरह से पका हुआ; सुपरिपक्व; शाबाश
あせ|ase|汗|sweat; perspiration|परेशान करना; पसीना; मेहनत करना; पसीना; स्वेद
かんしん|kanshin|関心|concern; interest|अभिरुचि; दिलचस्पी; संबंध; रुचि
きよう|kiyou|器用|skillful; handy|कुशल; कौशलपूर्ण; पास; निपुण; आसान
きにゅう|kinyuu|記入|entry; filling in of forms|दहलीज; प्रवेशाधिकार; द्वार; गरिष्ठ; भराई; भरावन
おか|oka|丘|hill; height; knoll; rising ground|पहाड़ी; शिखर; चरम; पराकाष्ठा; टीला; छोटी गोल पहाड़ी
いねむり|inemuri|居眠り|dozing; nodding off|ऊँघता
むね|mune|胸|breast; chest|टकराना; आगे का; झोंका; कोष; तिजोरी; छाती
ぎん|gin|銀|(1) silver; silver coin; silver paint|चमकीला; चाँदी; चाँदी के; चमकीला; चाँदी; चाँदी के; चमकीला; चाँदी; चाँदी के
くつう|kutsuu|苦痛|pain; agony|दर्द; व्यथा; कष्ट
ぐたい|gutai|具体|concrete; tangible; material|रोड़ा; मूर्त; कंक्रीट से भरना; वास्तविक; मूर्त; छूने से जान पड़ने वाला; सामान; महत्वपूर्ण; मूर्त
けっしん|kesshin|決心|determination; resolution|निर्णायक; विचार; इरादा; विश्लेषण; इरादा/संकल्प; प्रस्ताव
けんこう|kenkou|健康|health; sound; wholesome|स्वास्थ्य; आवाज़; स्वस्थ; हितकारी; पौष्टिक
かた|kata|肩|shoulder|कन्धा; आगे बढना; पहाड़
あらわれる|arawareru|現れる|(1) to appear; to come in sight; to become visible; (2) to express oneself|दिखना
こし|koshi|腰|hip|नितम्ब; जंगली गुलाब का लाल फल; गुलाब का फल
ほね|hone|骨|bone|शरीर; हड़्डी; देहावशेष
こっせつ|kossetsu|骨折|bone fracture|शरीर; हड़्डी; देहावशेष
すがた|sugata|姿|figure; shape; appearance|नमूना; विचार करना; कल्पना करना; नमूना; अनुकूल बनाना; बनावट; उपस्थिति; पेशी; रूप रंग
しどう|shidou|指導|leadership; guidance; coaching|नेतृत्व; नेतालोग; नेतृत्व; मार्गदर्शन; मार्ग दर्शन
しゅじゅつ|shujutsu|手術|surgical operation|ऑपरेशन
しゅだん|shudan|手段|means; way; measure|उपाय; आय; साधन; रास्ता; ताल; मर्यादा; काफ़ी
てつだい|tetsudai|手伝い|help; helper; assistant|मदद; सहायक; सहायता करनेवाला; योगदानकर्ता; सहायक
てじな|tejina|手品|sleight of hand; conjuring trick; magic; juggling|छलकपट; हाथ की सफ़ाई; जाडू का; जाडू का खेल; जादुई; माया; जादू करना
しゅしょう|shushou|首相|Prime Minister|प्रधानमंत्री
しゅと|shuto|首都|capital city|उत्कृष्ठ; शिखर; प्रमुख
じょしゅ|joshu|助手|helper; helpmeet; assistant; tutor|सहायक; सहायता करनेवाला; योगदानकर्ता; सहायक
きず|kizu|傷|wound; injury; hurt; cut|घाव; चोट; ज़ख़्मी; घाव; क्षति; आकस्मिक चोट; दर्द पहुँचाना; चोट; ज़ख़्मी
えがお|egao|笑顔|smiling face|स्मिता
うえ|ue|上|upper; outer; surface|उपरी भाग; उपरी; उच्च; बाहरी; सुदूर; बाह्य; प्रकट होना; दिखाई देना; भू सतह का
しんぞう|shinzou|心臓|heart|दिल
しんり|shinri|心理|mentality|मनोवृति; मानसिकता; मानसिक दशा
まっすぐ|massugu|真っ直ぐ|straight (ahead); direct; upright|सीधा; सीधे; लगातार; सरल; सीधा; ठीक; सरल; सीधा; सीधे
しんけん|shinken|真剣|seriousness; earnestness|सितारा मछली; गंभीरता; चिंताजनकता; गंभीरता; ईमानदारी
まじめ|majime|真面目|diligent; serious; honest|परिश्रमी; सतत; अनवरत/उद्यमी/ उद्योगी/ एकाग्रचित्त/ परिश्रमी/ सावधान; जटिल; महत्वपूर्ण; रहस्यमय; खरा; निष्कपट; ईमानदार
しんさつ|shinsatsu|診察|medical examination|चिकित्सीय परीक्षा; चिकित्सीय; चिकित्सा
しんたい|shintai|身体|the body|शरीर
はり|hari|針|needle; hand (e.g. clock)|सीलाई करना; स्फटिक; चोटी; हाथ
すいみん|suimin|睡眠|sleep|सोना
せいしん|seishin|精神|mind; soul; heart; spirit; intention|मन; व्यक्ति; प्रेतात्मा; जीवन; दिल
あいて|aite|相手|companion; partner; company|साथी; छोटी पुस्तक; मिट्र; साथी; पत्नी; सहयोगी; कंपनी
だめ|dame|駄目|useless; no good; hopeless|व्यर्थ; सामान्य; निकम्मा; निराशाजनक; निराश; हताश
たいいく|taiiku|体育|physical education; gymnastics; athletics|शरीर; वास्तविक; शारीरिक; जिमनास्टिक; व्यायाम; कसरत; खेल कूद पर्तियोगिता; खेल कूद
たいおん|taion|体温|temperature (body)|ताप; तापमान
だれか|dareka|誰か|someone; somebody|कोई; कोई; कोई{व्यक्ति}
だんたい|dantai|団体|organization; association|बनावट; संघ; संरचना; संबंध; संघ; समिति
ち|chi|地|earth|पृथ्वी
ちゅうしん|chuushin|中心|center; core; heart; pivot; emphasis; balance|केंद्र; बीजकोष; किसी चीज का मुख्य भाग; सब से महत्वपूर्ण भागा; दिल
ちゅうもく|chuumoku|注目|notice; attention; observation|सूचना; चेतावनी; देखना; ध्यान; विचार; कथन; देखरेख
むしば|mushiba|虫歯|cavity; tooth decay; decayed tooth; caries|छिद्र; गुहिका; विवर; दाँत
いたみ|itami|痛み|pain; ache; sore; grief; distress|दर्द; तरसना; दर्द; तकलीफ़ देना; घाव; त्वचा; नाराज़
ずつう|zutsuu|頭痛|headache|सिरदर्द; सिर दर्द
にゅういん|nyuuin|入院|hospitalization|अस्पतालवास; अस्पताल की भरती
ねっしん|nesshin|熱心|zeal; enthusiasm|उत्सुकता; जोश; औत्सुक्य; उत्साह
ねったい|nettai|熱帯|tropics|
ねっちゅう|necchuu|熱中|nuts!; enthusiasm; zeal; mania|पागल; उत्साह; उत्सुकता; जोश; औत्सुक्य
せ|se|背|height; stature|शिखर; चरम; पराकाष्ठा; महत्ता; क्षमता या उपलब्धि से कमाई हुई इज्जत और रूतबा; तन की प्राकृतिक लम्बाई
はかせ|hakase|博士|doctorate; PhD|डक्टर की; डक्टर की उपाधि; पी एच डी; पी एच
はくしゅ|hakushu|拍手|clapping hands; applause|हर्षध्वनि; वाहवाही; करतल ध्वनि{सराहना}
かみのけ|kaminoke|髪の毛|hair (head)|बाल
つかれ|tsukare|疲れ|tiredness; fatigue|थकान; थकावट; थकाना; थकान; थकावट
ひざ|hiza|膝|knee; lap|घुटना; आगे बढना; टकराना; क्रोड़
ひょうめん|hyoumen|表面|surface; outside; face; appearance|प्रकट होना; दिखाई देना; भू सतह का; बाहर; चेहरा
ふそく|fusoku|不足|insufficiency; shortage; deficiency; lack; dearth|कार्य क्षमता में कमी; कमी; अभाव; कमी; कमी; दोष
はら|hara|腹|abdomen; belly; stomach|उदर; उदर गह्वर; पेट; उदर; तोंद; पेट; इच्छा; सहना; उदर
がら|gara|柄|handle; grip|स्पर्श करना; व्यवहार करना; उपाधि; मजबुत पकड़; थैला; समझ
へんか|henka|変化|goblin; ghost; apparition; bugbear|प्रेत; शैतान; शैतान बौना; भूत; प्रेतात्मा; फीकी; प्रेतात्मा; विचित्र वस्तु; प्रेतछाया
あたり|atari|辺り|vicinity; nearby|इलाका; अड़ोस पड़ोस; पास ही; पास में; पास वाला
あわ|awa|泡|bubble; foam; froth; head on beer|धोखा; धोखा देना; खदबदाना; झाग निकलना; फोम; झाग; झाग उठना; फेन; झाग
ほお|hoo|頬|cheek (of face)|घमंडी; गाल; जबड़ा
まんぞく|manzoku|満足|satisfaction|स्पष्टीकरण; पूर्ति; संतोष
あきらか|akiraka|明らか|obvious; evident; clear|सुस्पष्ट; स्पष्ट; साक्षात्; प्रकट; स्पष्ट; प्रत्यक्ष; स्पष्ट
もくてき|mokuteki|目的|purpose; goal; aim; objective; intention|अभिप्राय; प्रयोजन; उद्देश्य; गोल; उद्देश्य; लक्ष्य; करना; लगाना; लक्ष्य
もくひょう|mokuhyou|目標|mark; objective; target|लिखना; संकेत; छाप; सामान्य; उद्देश्य; लक्ष्य; निशाना; क्षेत्र; लक्ष्य
ゆうのう|yuunou|有能|able; capable; efficient; skill|सक्षम; योग्य; उपयुक्त; सक्षम; प्रभावशाली; दक्ष; कुशल
よき|yoki|予期|expectation; assume will happen; forecast|उम्मीद; चाह; कफोत्सारक; समझना; रूप धारण करना; मानना; बताना; पूर्वानुमान करना; पूर्वानुमान
ようじん|youjin|用心|care; precaution; guarding; caution|देखभाल; गर्भनिरोधक उपाय; एहतियात; सावधानी
りこう|rikou|利口|clever; shrewd; bright; sharp; wise; intelligent|बुद्धिमान; योग्य; निपुण; समझदार; धूर्त; चतुर; चमकीला
りっぱ|rippa|立派|splendid; fine; handsome; elegant; imposing; prominent; legal; legitimate|शानदार; बहुत बढ़िया; उजागर; ठीक; रमणीय; छैला; रूपवान
なみだ|namida|涙|tear|करना; आँसू; खींच लेना
お手伝いさん||お手伝いさん|maid|दासी; नौकरानी; नोकरानी
いじわる|ijiwaru|意地悪|malicious; ill-tempered; unkind|द्वेषी; दुर्भावनापूर्ण; कठोर; दयाहीन; निर्दयी/दुःशील
えきたい|ekitai|液体|liquid; fluid|स्पष्ट; स्वच्छ; प्रवाही; लचीला; अस्थिर; प्रवाही
えんそく|ensoku|遠足|trip; hike; picnic|यात्रा; वृद्धि; पैदल लंबी यात्रा; पदयात्रा; आसान काम; पिकनिक; पिकनिक मनाना
げた|geta|下駄|geta (Japanese footwear); wooden clogs|भद्दा; भावशून्य; लकड़ी
かねつ|kanetsu|加熱|heating|ताप; गरम करने की पद्धति; तापक
にわか|niwaka|俄|sudden; abrupt; unexpected; improvised; offhand|आकस्मिक; अचानक; शीघ्र; उखड़ा उखड़ा; आकस्मिक; असंगत; अविचारित; अनिवार्य; अप्रत्याशित
なつかしい|natsukashii|懐かしい|dear; desired; missed|प्रिय; चाहा
かんびょう|kanbyou|看病|nursing (a patient)|परिचर्या
きたい|kitai|気体|vapour; gas|बकवास; ज़हरीली गैस; बकवास करना
ごういん|gouin|強引|overbearing; coercive; pushy; forcible; high-handed|दबंग; मनमानी करनेवाला; अवपीड़क; बलयुक्त; अति महत्वाकांक्षी; अति
ちかぢか|chikajika|近々|nearness; before long|निकटता; नज़दीकी; पहले
けつあつ|ketsuatsu|血圧|blood pressure|रक्त चाप; रक्तचाप; रक्त दाब
けつえき|ketsueki|血液|blood|खून
みかけ|mikake|見掛け|outward appearance|जाता हुआ; बाहरी; बाहर की ओर
みだし|midashi|見出し|heading; caption; subtitle; index|शीर्षक; सुरखी; अनुशीर्षक; अनुशीर्षक देना; लिखित भाषांतर; उपनाम; लिखित भाषांतर देना
けわしい|kewashii|険しい|inaccessible place; sharp eyes|अगम्य; अवघट; उच्च; कटु; विषम
こたい|kotai|個体|an individual|विशिष्ट; व्यक्ति; अलग अलग
おてあらい|otearai|御手洗|font of purifying water placed at entrance of shrine|पविट्र हौदी; पविट्र; अक्षर
くちべに|kuchibeni|口紅|lipstick|लिपस्टिक
こうじつ|koujitsu|口実|excuse|क्षमा
むかう|mukau|向う|(v5u) to face; to go towards|मुँह पर
こうもく|koumoku|項目|item|अंश; विषय; समाचार
こしかけ|koshikake|腰掛け|seat; bench|सीट; न्यायपीठ; न्यायाधीश; तख्त
きる|kiru|斬る|(v5r) to behead; to murder|सिर काटना; सिर कटवा; सिर कटवा देना; टेढ़ी; बरबाद करना; हत्या करना
してい|shitei|指定|designation; specification; assignment; pointing at|नियुक्ति; औहदा; पद का नाम; विशेष विवरण; नियुक्ति; काम; सौंपा हुआ कार्य
したい|shitai|死体|corpse|लाश; शव
はぐるま|haguruma|歯車|gear; cog-wheel|मशीन के इंजन को पहियों से जोड़ने वाला यंत्र; सामान; गति
はみがき|hamigaki|歯磨き|dentifrice; toothpaste|मंजन; दाँत; दाँत का मंजन
じゃぐち|jaguchi|蛇口|faucet; tap|टोंटी; खटखटाना; निकालना; क्षार निकालना
てごろ|tegoro|手頃|moderate; handy|औसत दर्जे; कम; कम होना; पास; निपुण; आसान
てくび|tekubi|手首|wrist|कलाई; पहुँचा
てぬぐい|tenugui|手拭い|(hand) towel|तौलिये से पोंछना; तौलिया; अंगपोछा
てあらい|tearai|手洗い|restroom; lavatory; hand-washing|शौचालय; सार्वजनिक; सार्वजनिक शौचघर; शौचालय; सार्वजनिक; सार्वजनिक शौचालय
てつづき|tetsuzuki|手続き|procedure; (legal) process; formalities|प्रक्रिया; पद्धति; कार्यप्रणाली; विधि; बढोत्तरी; तैयार करना
てちょう|techou|手帳|notebook|नोट बुक; नोटबुक; बुक
ていれ|teire|手入れ|repairs; maintenance|अनुरक्षण; निर्वाह; रख
じゅうたい|juutai|重体|seriously ill; serious condition; critical state|गंभीर मसला; गंभीरता से; गंभीर रुप से; गंभीर दशा; ठीक; शोचनीय; सूक्ष्म
でいりぐち|deiriguchi|出入口|exit and entrance|निकास
じゅんじょう|junjou|純情|pure heart; naivete; self-sacrificing devotion|प्रांजल; असली; अमिश्रित; सरलता
こゆび|koyubi|小指|little finger|छिंगुली; कानी उंगली; कनिष्टिका
じょうはつ|jouhatsu|蒸発|evaporation; unexplained disappearance|वाष्पीकरण; रहस्यमय; अस्पष्ट
ねまき|nemaki|寝巻|sleep-wear; nightclothes; pyjamas; nightgown; nightdress|राट्रि पोशाक; सोने के कपड़े; पायजामा
しんしん|shinshin|心身|mind and body|मन
こころあたり|kokoroatari|心当たり|having some knowledge of; happening to know|घटना; अनौपचारिक; अनौपचारिक कलात्मक अभिनय
まっさき|massaki|真っ先|the head; the foremost; beginning|सिर; सर्वाधिक; प्रधान; सर्वश्रेष्ठ; शुरुआत
しん|shin|芯|core; heart; wick; marrow|बीजकोष; किसी चीज का मुख्य भाग; सब से महत्वपूर्ण भागा; दिल; पट्टी; बत्ती; दीये की बत्ती
しんだん|shindan|診断|diagnosis|लक्षण; रोग; रोग की पहचान
きよい|kiyoi|清い|clear; pure; noble|स्पष्ट; प्रांजल; असली; अमिश्रित; बहुत अच्छा; उतम; शानदार
せんとう|sentou|先頭|head; lead; vanguard; first|सिर; नमूना; प्रमुख; राय देना; अग्रगामी सैन्य टुकड़ी; नायक; अपने क्षेत्र में अग्रणी समूह
ふなびん|funabin|船便|surface mail (ship)|सतह डाक
はやくち|hayakuchi|早口|fast-talking|
ぞうり|zouri|草履|zoori (Japanese footwear); sandals|
あしあと|ashiato|足跡|footprints|चरणचिन्ह
たび|tabi|足袋|tabi; Japanese socks (with split toe)|जापानवासी; जापानी
そっちょく|socchoku|卒直|frankness; candour; openheartedness|स्पष्टवादिता; मुँहफ़टपना; स्पष्टवादिता; खरापन
たいけい|taikei|体系|system; organization|शरीर; व्यवस्था; पद्धति; बनावट; संघ; संरचना
たいせい|taisei|体制|order; system; structure; set-up; organization|आदेश; शरीर; व्यवस्था; पद्धति; नमूना; संरचना; बनाना
たいせき|taiseki|体積|capacity; volume|सामर्थ्य; क्षमता; धारण शक्ति; प्रबलता; घनफल; अंक
たいいん|taiin|退院|leaving hospital|
なかゆび|nakayubi|中指|middle finger|बीच
としん|toshin|都心|heart (of city)|दिल
ずのう|zunou|頭脳|head; brains; intellect|सिर; प्रज्ञा; अक्लमंद; बुद्दी
ひとみ|hitomi|瞳|pupil (of eye)|आँख की; पुतली; किशोर
のろい|noroi|鈍い|dull (e.g. a knife); thickheaded; slow (opposite of fast); stupid|मंदबुद्धि; नीरस; कम करना; बेवकूफ़; बेवकूफ़ी भरा; धीमा
のうやく|nouyaku|農薬|agricultural chemicals|कृषि; कृषिक; खेती बारी का
はで|hade|派手|showy; loud; gay; flashy; gaudy|दिखावा; तीव्र; ऊँचा; प्रबल; खुश मिजाज; खुश; समलैंगिक
しらが|shiraga|白髪|white or grey hair; trendy hair bleaching|सफेद; फ़ैशनेबल; आधुनिक फ़ैशन का
はだぎ|hadagi|肌着|underwear|नीचे पहनने के कपड़े; अंतर्वस्त्र
ひげ|hige|髭|moustache; beard; whiskers|मूँछ/श्मश्रु; मूँछ; खुलेआम विरोध; दाढी नोचना; गलमुच्छ; मूंछ; दाढ़ी
ぶしゅ|bushu|部首|radical (of a kanji character)|अतिवादी; विलक्षण; सुधारवादी
ほけん|hoken|保健|health preservation; hygiene; sanitation|स्वास्थ्य; स्वास्थ्य विज्ञान; स्वास्थ्य; स्वच्छता; स्वास्थ्य रक्षा; सफ़ाई व्यवस्था
ほんぶ|honbu|本部|headquarters|मुख्यालय
めやす|meyasu|目安|criterion; aim|मानदण्ड/जाँच/कसौटी; कसौटी; करना; लगाना; लक्ष्य
めじるし|mejirushi|目印|mark; sign; landmark|लिखना; संकेत; छाप; देना; सौंपना; संकेत; सीमाचिह्न; थल चिह्न; युगांतकारी घटना
めした|meshita|目下|at present; now|वर्तमान में; अब इस समय; अब
めざまし|mezamashi|目覚し|(abbr) alarm-clock|
もくじ|mokuji|目次|table of contents|मेज़
めうえ|meue|目上|superior(s); senior|उत्कृष्ट; अच्छा; श्रेष्ठ; वरिष्ठ; ज्येष्ठ; अपर
やくめ|yakume|役目|duty; business|काम; कर्तव्य; कर; व्यापार
やかん|yakan|薬缶|kettle|केतली
やっきょく|yakkyoku|薬局|pharmacy; drugstore|फर्मेसी; औषधालय/औषधशाला; औषध विज्ञान; दवा की दुकान
くすりゆび|kusuriyubi|薬指|ring finger|अनामिका
やくひん|yakuhin|薬品|medicine(s); chemical(s)|दवा; रासायनिक पदार्थ; रसायनिक द्रव्य; रासायन संबंधी
ゆけつ|yuketsu|輸血|blood transfusion|रक्ताधान
うらぐち|uraguchi|裏口|backdoor; rear entrance|पीछे का भाग; उठाना; पिछला
いいかげん|iikagen|いい加減|moderate; right; random; not thorough; vague; irresponsible; halfhearted|औसत दर्जे; कम; कम होना; सही; निरुद्देश्य; बेतरतीब; सहसा उत्पन्न
おてあげ|oteage|お手上げ|all over; given in; given up hope; bring to knees|हर जगह; सर्वत्र; सभी जगह; निर्धारित; विशेष; निश्चित; निर्धारित; विशेष; निश्चित
おさきに|osakini|お先に|before; ahead; previously|पहले; आगे; पहले से; पहले; पहले
おしゃべり|oshaberi|お喋り|chattering; talk; idle talk; chat; chitchat; gossip; chatty; talkative; chatterbox; blabbermouth|बात करना; निष्क्रिय; व्यर्थ; आलसी
おめでとう|omedetou|お目出度う|(ateji) (int) (uk) Congratulations!; an auspicious occasion!|
わるくち|warukuchi|悪口|abuse; insult; slander; evil speaking|गाली; दुर्व्यवहार; बरबाद करना; अपमान होना; अपमान; अपमान करना; मानहानिअना; मानहानि; मिथ्यापवाद
やみ|yami|闇|darkness; the dark; black-marketeering; dark; shady; illegal|अंधकार/धुंधलापन/अज्ञानता; अनैतिकता; अँधेरा; अंधेरा
いじ|iji|意地|disposition; spirit; willpower; obstinacy; backbone; appetite|प्रवृत्ति; प्रबंध; स्थिति; भावना; जोश; प्रेतात्मा; संकल्प शक्ति; इच्छा शक्ति
いよく|iyoku|意欲|will; desire; ambition|theres a way,जहाँ चाह है वहाँ राह है,Noun; इच्छा; चाहना; इच्छा; चाहना; तृष्णा; महत्वाकांक्षा; अभिलाषा; उमङ्ग
ひとすき|hitosuki|一筋|a line; earnestly; blindly; straightforwardly|रेखा; ईमानदारी; ईमानदारी से; नम्रतापूर्वक; अंधाधुंध
いっしん|isshin|一心|one mind; wholeheartedness; the whole heart|एकनिष्ठता; हार्दिकता
いっぺん|ippen|一変|complete change; about-face|पूरा
いちめん|ichimen|一面|one side; one phase; front page; the other hand; the whole surface|मुख पृष्ठ; मुख
いちもく|ichimoku|一目|a glance; a look; a glimpse|चमकना; ग्लांस करना; नजर डालना; देखना; झलक; झाँकी; जल्दी से एक नज़र ड़ालना
えいせい|eisei|衛生|health; hygiene; sanitation; medical|स्वास्थ्य; स्वास्थ्य विज्ञान; स्वास्थ्य; स्वच्छता; स्वास्थ्य रक्षा; सफ़ाई व्यवस्था
おくびょう|okubyou|臆病|cowardice; timidity|कायरता; डर; घबराहट; कायरता
したごころ|shitagokoro|下心|secret intention; motive|गुप्त; गोपनीय; रहस्यमय; प्रेरक; प्रयोजन; उद्देश्य
はなやか|hanayaka|華やか|gay; showy; brilliant; gorgeous; florid|खुश मिजाज; खुश; समलैंगिक; दिखावा; मेधावी; चमकीला; उत्कृष्ट
にわか|niwaka|俄か|sudden; abrupt; unexpected; improvised; offhand|आकस्मिक; अचानक; शीघ्र; उखड़ा उखड़ा; आकस्मिक; असंगत; अविचारित; अनिवार्य; अप्रत्याशित
がいかん|gaikan|外観|appearance; exterior; facade|उपस्थिति; पेशी; रूप रंग; बाहरी; बाहर; बहिर्भाग; दिखावा
がいとう|gaitou|街頭|in the street|
かんべん|kanben|勘弁|pardon; forgiveness; forbearance|दुबारा कहना; क्षमा करना; माफी; क्षमा; धैर्य; सहिष्णुता
かんせい|kansei|歓声|cheer; shout of joy|सलामती का जाम; धीरज; हर्षित करना; बुलाना; चीखना; चिल्लाना
かんし|kanshi|監視|observation; guarding; inspection; surveillance|विचार; कथन; देखरेख; निरीक्षण
かんじん|kanjin|肝心|essential; fundamental; crucial; vital; main|अनिवार्य; महत्वपूर्ण; प्रधान; प्रमुख; मुख्य; मूल; निर्णायक; संकटपूर्ण; अत्यंत महत्वपूर्ण
かん|kan|観|look; appearance; spectacle|देखना; उपस्थिति; पेशी; रूप रंग; प्रदर्शन; तमाशा; दृश्य
うがい|ugai|含嗽|gargle; rinse mouth|गरारे; कुल्ला; कुल्ला करने का तरल पदार्थ; खंगालना; साफ करना; धोना
かおつき|kaotsuki|顔付き|(outward) looks; features; face; countenance; expression|रूप; आकृति; चेहरा
きがい|kigai|危害|injury; harm; danger|घाव; क्षति; आकस्मिक चोट; अनिष्ट; क्षति; हानि; खतरा
きかん|kikan|器官|organ (of body); instrument|संस्थान; प्रकाशन; बाजा; मानव यंत्र; प्रपत्र; लिखित
ぎあん|gian|議案|legislative bill|विधि संबंधी; विधि; वैधानिक
さかだち|sakadachi|逆立ち|handstand; headstand|हाथ के बल खड़ा रहने की क्रिया; उलटे खडा होना
きゅうりょう|kyuuryou|丘陵|hill|पहाड़ी
おそれ|osore|恐れ|fear; horror|डर; डर; दहशत; विभीषिका
ちかぢか|chikajika|近々|nearness; before long|निकटता; नज़दीकी; पहले
きんがん|kingan|近眼|nearsightedness; shortsightedness; myopia|कम देखने की बीमारी/अदीर्घ दृष्टि; निकटदृष्टि; अदूरदर्शिता
かけっこ|kakekko|駆けっこ|(foot) race|प्रजाति; स्वाद; दौड़
かけあし|kakeashi|駆け足|running fast; double time|एक के बाद एक; लगातार; दौड़; अतिकालिक वेतन; दुगनी मजदूरी
けいさい|keisai|掲載|appearance (e.g. article in paper)|उपस्थिति; पेशी; रूप रंग
つぎめ|tsugime|継ぎ目|a joint; joining point|मिलाना; संभेद; चूल
けっかん|kekkan|血管|blood vessel|रक्त; रक वाहिका; रक्तवाहिका
すこやか|sukoyaka|健やか|vigorous; healthy; sound|सशक्त; प्रबल; ओजपूर्ण; स्वस्थ; स्वस्त; स्वस्थ्यवऋद्धक; आवाज़
けんざい|kenzai|健在|in good health; well|अच्छी तरह
げんしゅ|genshu|元首|ruler; sovereign|पटरी; शासक; अधिपति; प्रधान; शासक; शासकीय
ことづて|kotozute|言伝|declaration; hearsay|वचन; घोषणा; घोषण पत्र; सुनी सुनाई; अफ़वाह
こたい|kotai|固体|solid (body)|असली; वास्तविक; सच्चा
こうたく|koutaku|光沢|brilliance; polish; lustre; glossy finish (of photographs)|चमक; प्रतिभा; शान; चमकाना; चमक; रोगन करना; चमक; पावक; सौंदर्य
こうねつひ|kounetsuhi|光熱費|cost of fuel and light|कीमत
ききめ|kikime|効き目|effect; virtue; efficacy; impression|प्रभाव; पैदा करना; पैदा; गुण; सद्गुण; नैतिकता; गुण; क्षमता; प्रभाविता
こうじゅつ|koujutsu|口述|verbal statement|शाब्दिक; मौखिक; वाचिक
こうとう|koutou|口頭|oral|मौखिक; मौखिक परीक्षा; मुख
たくみ|takumi|巧み|skill; cleverness|कौशल; योग्यता; प्रवीणता; होशियारी; चुस्ती
こうみょう|koumyou|巧妙|ingenious; skillful; clever; deft|शानदार; प्रवीण; विदग्ध; कुशल; कौशलपूर्ण; बुद्धिमान; योग्य; निपुण
"""), "ja", "N4", "kanji"),

        Lesson("kw-feel", "💗 Feelings & Personality · 気持ち・性格", "💗", "140 kanji words", kw("""
たのしい|tanoshii|楽しい|enjoyable|सुखदायक; सुखद; आनन्ददायक
いや|iya|嫌|unpleasant|बुरा; अप्रिय; अप्रिय/नापसन्द/अरूचिकर
きらい|kirai|嫌い|hate|घृणा करना; घृणा; द्वेष
げんき|genki|元気|health; vitality|स्वास्थ्य; उत्साह; प्राणशक्ति; जीवनक्षमता
あつい|atsui|厚い|kind; deep; thick|दयालु; गहरा; घनिष्ठ; भारी; बहुत अधिक
すき|suki|好き|likeable|आसानी से पसंद आने वाला
たのしみ|tanoshimi|楽しみ|joy|सफलता; प्रसन्न होना; आनन्द
き|ki|気|spirit; mood|भावना; जोश; प्रेतात्मा; मुद्रा; मनोदशा; अवस्था
きもち|kimochi|気持ち|feeling; mood|भावना; मुद्रा; मनोदशा; अवस्था
きぶん|kibun|気分|mood|मुद्रा; मनोदशा; अवस्था
にがい|nigai|苦い|bitter|कटु; कठोर; कड़ुवा करना
しんせつ|shinsetsu|親切|kindness|दयालुता; कृपा
はずかしい|hazukashii|恥ずかしい|embarrassed|लज्जित; शर्मिंदा
かなしい|kanashii|悲しい|sad|उदास
こわい|kowai|怖い|frightening|डरावना; भयानक
ゆめ|yume|夢|dream|सपना
やさしい|yasashii|優しい|kind|दयालु
あい|ai|愛|love|प्यार
あいじょう|aijou|愛情|love; affection|प्यार; स्नेह; लगाव; ममता
いっしゅ|isshu|一種|a species; a kind; a variety|प्रजाति; प्रकार; वर्ग; दयालु; प्रजाति; प्रकार; विविधता
おだやか|odayaka|穏やか|calm; gentle; quiet|शांत करना; ठहराव; निश्चलता; धीमा; हल्की; हल्का; शांत
かいてき|kaiteki|快適|pleasant; agreeable; comfortable|हँसमुख; सुखद; मज़ेदार; अनुरूप; सुखद; अनुकूल; आरामदायक
かっこう|kakkou|格好|shape; form; posture; suitability|नमूना; अनुकूल बनाना; बनावट; दर्जा; प्रकार; विचार करना; मुद्रा; रूख; दिखावा करना
らく|raku|楽|comfort; ease|आराम; सुविधा; सान्त्वना; शांत करना; आराम; हल्का करना
かっき|kakki|活気|energy; liveliness|ऊर्जा; सजीवता
かんじ|kanji|感じ|feeling; sense; impression|भावना; दिशा; होश; ज्ञान; प्रभाव; दिखावा; धारणा
かんじょう|kanjou|感情|emotion(s); feeling(s); sentiment|भावना; उमङ्ग; जज़्बा; भावना; भावना; विचार; मनोभाव
かんどう|kandou|感動|being deeply moved; excitement; impression; deep emotion|जीवन; स्वभाव; प्राणी; बेक़रारी; उत्तेजना; उतावलापन; प्रभाव; दिखावा; धारणा
よろこび|yorokobi|喜び|(a) joy; (a) delight; rapture; pleasure; gratification; rejoicing; congratulations; felicitations|सफलता; प्रसन्न होना; आनन्द; हर्षित करना; हर्षोल्लास; खुशी; अत्यन्त हर्ष; हर्षोन्माद; उमङ्ग
うれしい|ureshii|嬉しい|happy; glad; pleasant|खुश; खुश; हँसमुख; सुखद; मज़ेदार
きぼう|kibou|希望|hope; wish; aspiration|आशा; इच्छा; अभिलाषा/चाह; महत्वाकांक्षा; महाप्राण
きたい|kitai|期待|expectation; anticipation; hope|उम्मीद; चाह; कफोत्सारक; पुर्वानुमान; पहले से ही; आशा
きげん|kigen|機嫌|humour; temper; mood|हास्य; शक्तिअ; हास्यकला; लचकीला बनाना; कम करना; गुस्सा; मुद्रा; मनोदशा; अवस्था
きのどく|kinodoku|気の毒|pitiful; a pity|दयनीय; दीन; दया; खैद का विषय; स्नेह
きおん|kion|気温|temperature|ताप; तापमान
きこう|kikou|気候|climate|जलवायु; वातावरण; आबोहवा
きみ|kimi|気味|-like; -looking; -looked|
きょうふ|kyoufu|恐怖|be afraid; dread; dismay; terror|डर; डरना; से डरना; निराश करना; निराशा; त्रस्त
きんちょう|kinchou|緊張|tension; mental strain; nervousness|दबाव; तानना; तनावग्रस्त; पागल; दिमागी; मनोवृति; घबराहट; तनाव; अधीरता
くるしい|kurushii|苦しい|painful; difficult|भद्दा; कठिन; दर्दीला; कठिन
にがて|nigate|苦手|poor (at); weak (in); dislike (of)|गरीब; कमज़ोर; घृणा; नापसंद करना; द्वेष
くろう|kurou|苦労|troubles; hardships|
けいき|keiki|景気|condition; state; business (condition)|निश्चित करना; उपाधि; ठीक करना; बताना; व्यक्त करना; अभिव्यक्त करना; व्यापार
このみ|konomi|好み|liking; taste; choice|पसंद; पसन्द; स्वाद; प्रकार; चारा; चुनाव
こんなん|konnan|困難|difficulty; distress|समस्या; कठिनता; कठिनाई; दुःख; कठिनाई; दुःख होना
しつぼう|shitsubou|失望|disappointment; despair|आशाभंग; निराशा; क्षोभ; उदास होना; हतासा; निराशा
しゅるい|shurui|種類|variety; kind; type|प्रजाति; प्रकार; विविधता; दयालु; प्रकार; नमूना; वर्ग
わらい|warai|笑い|laugh; laughter; smile|हँसना; ह्ँसी; क़हक़हा; खिलखिलाहट; मुस्कान
しんぱい|shinpai|心配|worry; concern; anxiety; care|चिंता; अभिरुचि; दिलचस्पी; संबंध; उत्सुकता; चिंता; चिन्ता/व्याकुलता
まね|mane|真似|mimicry; imitation; behavior; pretense|नकल करना; नकल; कृत्रिम; नकली/अनुकरण; अनुकरण
せいかく|seikaku|性格|character; personality|दर्जा; प्रतिष्ठा; गुण; व्यक्तित्व; चरिट्र; विशेष चरित्र
たいき|taiki|大気|atmosphere|वायुमण्डल; परिमण्डल; वातावरण
たいし|taishi|大使|ambassador|राजदूत; दूत
どうよう|douyou|同様|identical; equal to; same (kind); like|जैसा; वैसा ही; बिलकुल् वही; की बराबरी; समान; सक्षम; समान
はいゆう|haiyuu|俳優|actor; actress; player; performer|कर्ता; अभिनेता; कलाकार; अभिनेत्री; अभिनेता; वादक; खिलाडी
ひげき|higeki|悲劇|tragedy|थियेटर की; दुखान्त; दुःखद घटना
ふあん|fuan|不安|anxiety; uneasiness; insecurity; suspense|उत्सुकता; चिंता; चिन्ता/व्याकुलता; बेचैनी; व्याकुलता; चिन्ता; असुरक्षा; असुरक्षा की भावना
ふんいき|funiki|雰囲気|atmosphere (e.g. musical); mood; ambience|वायुमण्डल; परिमण्डल; वातावरण; मुद्रा; मनोदशा; अवस्था; माहौल; वातावरण
のぞみ|nozomi|望み|wish; desire; (a) hope|इच्छा; इच्छा; चाहना; तृष्णा; आशा
むちゅう|muchuu|夢中|daze; (in a) trance; ecstasy; delirium; engrossment|घबरा देना; आश्चर्यचकित कर देना; चौंधिया देना/घबरा देना; भाव समाधि; समाधि; तन्मयता; अति आह्लाद; एक्सटेसी; परम आनंद
ゆかい|yukai|愉快|pleasant; happy|हँसमुख; सुखद; मज़ेदार; खुश
ゆうしゅう|yuushuu|優秀|superiority; excellence|वरिष्टता; उत्कृष्टता; श्रेष्ठता; प्रतिष्ठा; विशिष्टता; श्रेष्ठता
ゆうき|yuuki|勇気|courage; bravery; valour; nerve; boldness|साहस; वीरता; धैर्य; साहस; वीरता; वीरता
ようき|youki|陽気|season; weather; cheerfulness|मौसम; मौसम; प्रसन्नता
こい|koi|恋|love; tender passion|प्यार; मुलायम; देना; हल्का
かいせい|kaisei|快晴|good weather|अच्छा मौसम
かんげき|kangeki|感激|deep emotion; impression; inspiration|गहरा; प्रभाव; दिखावा; धारणा; उत्प्रेरणा; प्रेरणा; शानदार विचार
かんき|kanki|換気|ventilation|हवा देना; संवातन; वायु संचार
きあつ|kiatsu|気圧|atmospheric pressure|वायुमण्डलीय दबाव; वायुमण्डलीय
けはい|kehai|気配|indication; market trend; worry|संकेत; लक्षण; सुझाव; बाज़ार; चिंता
つよき|tsuyoki|強気|firm; strong|स्थिर; अटल; मजबूत; मजबूत
くじょう|kujou|苦情|complaint; troubles; objection|शिकायत; झगड़ा; रोग; विरोध; आपत्ति; एतराज़
くしん|kushin|苦心|pain; trouble|दर्द; परेशानी
ごらく|goraku|娯楽|pleasure; amusement|खुशी; हर्ष; सूख; तमाशा; मनोरंजन; आनन्द
すききらい|sukikirai|好き嫌い|likes and dislikes; taste|पसंद करना , अच्छा लगना , भात; स्वाद
すきずき|sukizuki|好き好き|matter of taste|मामला
しつれん|shitsuren|失恋|disappointed love; broken heart; unrequited love; be lovelorn|निराश; हताश; दुख्ःई; खंडित; निराश; टूटा हुआ; एकतरफ़ा; अनुत्तरित; अपुरस्कृत
しっき|shikki|湿気|moisture; humidity; dampness|नमी; सीलन; आर्द्रता; उमस; नमी; नमी
じっかん|jikkan|実感|feelings (actual; true)|भावना; अहसास; जज्बात; सच्चा
じょうき|jouki|蒸気|steam; vapour|भाप शक्ति से याट्रा; भाप शक्ति; वाष्प
なまいき|namaiki|生意気|impertinent; saucy; cheeky; conceit; audacious; brazen|धृष्ट; ढीठ; उद्दंडतापूर्ण; धृष्ट; ध्रृष्ट
にくい|nikui|憎い|hateful; abominable; poor-looking; detestable|घृणित; घटिया; नृशंस; भद्दा
にくらしい|nikurashii|憎らしい|odious; hateful|घृणित; घिनौना; अप्रिय; घृणित
はきけ|hakike|吐き気|nausea; sickness in the stomach|उबकाई; मतली; मिचली; रोग; बीमारी; मिचली
ゆげ|yuge|湯気|steam; vapour|भाप शक्ति से याट्रा; भाप शक्ति; वाष्प
のんき|nonki|呑気|carefree; optimistic; careless; reckless; heedless|लापरवाह; निश्चिंत; आशावादी; कच्चा; आलसी; लापरवाह
へいき|heiki|平気|coolness; calmness; composure; unconcern|शान्ति; धैर्य; रूखापन; आत्मसंयम; धैर्य
ありがたい|arigatai|有難い|grateful; thankful; welcome; appreciated; evoking gratitude|आभारी; सुखद; कृतज्ञ; आभारी; कृतज्ञ; अनुगृहीत; स्वागत
ようちえん|youchien|幼稚園|kindergarten|बालविहार; बालवाड़ी
たのもしい|tanomoshii|頼もしい|reliable; trustworthy; hopeful; promising|भरोसेमंद; विश्वसनीय; अच्छा; विश्वासयोग्य; विश्वसनीय; कर्तव्यनिष्ठ; आशाजनक; आशामय; आशावान
こいしい|koishii|恋しい|(1) dear; beloved; darling; (2) yearned for|प्रिय; प्रेमिका; सनम; प्यारा; प्रिये; चहेता; प्यारा
ごくろうさま|gokurousama|ご苦労様|Thank you very much for your....|धन्यवाद
めでたい|medetai|愛でたい|auspicious|पवित्र; अनुकूल; मंगल
あいそ|aiso|愛想|civility; courtesy; compliments; sociability; graces|नम्रता; शिष्टता; सभ्यता; शालीनता; कृपा; विनय
あいにく|ainiku|愛憎|likes and dislikes|पसंद करना , अच्छा लगना , भात
わるい|warui|悪い|hateful; abominable; poor-looking|घृणित; घटिया; नृशंस; भद्दा
いっき|ikki|一気|drink!(said repeatedly as a party cheer)|पीना
いんき|inki|陰気|gloom; melancholy|अंधकार; उदासी; निराशा; निराशाजनक; उदासी की अवस्था; निराशा
けむたい|kemutai|煙たい|smoky; feeling awkward|धुँधुआता; धुआँ करने; धुएँ से; भावना
なんと|nanto|何と|what; how; whatever|क्या; कैसे; कुछ भी; जो भी; जो कुछ भी
なにげない|nanigenai|何気ない|casual; unconcerned|आकस्मिक; लापरवाह; बेढंगा; उदासीन; बेफ़िक्र; निशिचन्त
なにとぞ|nanitozo|何卒|please; kindly; by all means|कृपया; कृपालु; दयापूर्वक; कृपया; अवश्य
かわいい|kawaii|可愛い|pretty; cute; lovely; charming; dear; darling; pet|सुंदर; चालाक; आकर्षक; अति सुन्दर; मधुर; सुहावना; मनोहर
おかしい|okashii|可笑しい|strange; funny; amusing; ridiculous|निराला; अनोखा; आश्चर्यजनक; मज़ेदार; मनोरंजक; विनोदी/मनोरंजक
いらいら|iraira|苛々|getting nervous; irritation|मिलना; गुस्सा; उत्तेजना; कोप
こころよい|kokoroyoi|快い|pleasant; agreeable|हँसमुख; सुखद; मज़ेदार; अनुरूप; सुखद; अनुकूल
らっかん|rakkan|楽観|optimism|आशावाद
こっけい|kokkei|滑稽|funny; humorous; comical; laughable; ridiculous; joking|मज़ेदार; विनोदी; हास्यकर; हास्यास्पद; ठठोलिया
かんき|kanki|寒気|cold; frost; chill|ठंडा; पाला; केक को चीनी के बुरादे से सजाना; आइसिंग करना; ठंडा; ठण्डा; ठंडा किया हुआ
かんがい|kangai|感慨|strong feelings; deep emotion|मजबूत; गहरा
かんしょく|kanshoku|感触|sense of touch; feeling; sensation|दिशा; होश; ज्ञान; भावना; संवेदना; उत्तेजना; जोश
かんむりょう|kanmuryou|感無量|deep feeling; inexpressible feeling; filled with emotion|गहरा; अकथनीय; अवर्णनीय
きげき|kigeki|喜劇|comedy; funny show|हास्यप्रधान नाटक; विनोदप्रियता; कमेडी; मज़ेदार
きまぐれ|kimagure|気まぐれ|whim; caprice; whimsy; fickle; moody; uneven temper|मौज; सनक; उमंग; सनक; उमंग; लहर; सनकीपन; सनक; खिलवाड
きらく|kiraku|気楽|at ease; comfortable|निश्चिन्त; आरामदायक
きがる|kigaru|気軽|cheerful; buoyant; lighthearted|चमकीला; आनन्दित; प्रसन्न; प्रफुल्लित; तैरता हुआ/बहता हुआ; प्रङुल्ल
きがね|kigane|気兼ね|hesitance; diffidence; feeling constraint; fear of troubling someone; having scruples about doing someth|झेंप; संकोच; भावना
かたぎ|katagi|気質|spirit; character; trait; temperament; disposition|भावना; जोश; प्रेतात्मा; दर्जा; प्रतिष्ठा; गुण; विशेषता
きしょう|kishou|気象|weather; climate|मौसम; जलवायु; वातावरण; आबोहवा
きざ|kiza|気障|affectation; conceit; snobbery|दिखावा; ढोंग; बनावटी; घमण्ड; हास्योक्ति; गुमान; दंभ; वर्गदंभ
けはい|kehai|気配|indication; market trend; worry|संकेत; लक्षण; सुझाव; बाज़ार; चिंता
きひん|kihin|気品|aroma|सुगंध; मीठी सुगन्ध
きだて|kidate|気立て|disposition; nature|प्रवृत्ति; प्रबंध; स्थिति; प्रकार; गुण; वर्ग
きりゅう|kiryuu|気流|atmospheric current|वायुमंडलीय; वातावरण; वातावरण से मेल खाते मूड का
びっくり|bikkuri|吃驚|be surprised; be amazed; be frightened; astonishment|
さけび|sakebi|叫び|shout; scream; outcry|बुलाना; चीखना; चिल्लाना; चीखना; चिल्लाना; ज़बर्दस्त मज़ाक; हो हल्ला; कड़ा; चिल्लाहट
つよき|tsuyoki|強気|great; grand|महान; बहुत अच्छा; अभिमानी; कुल
こうふん|koufun|興奮|excitement; stimulation; agitation; arousal|बेक़रारी; उत्तेजना; उतावलापन; प्रेरणा; उद्दीपन; उत्तेजन; उत्तेजना; अकुला; आंदोलन
おどろき|odoroki|驚き|surprise; astonishment; wonder|अचम्भा; आश्चर्य; चकित करना; आश्चर्य; अचरज; आश्चर्य; विस्मय; भटकना
ごくらく|gokuraku|極楽|paradise|स्वर्ग; अदन वाटिका; आंनद का
けいかい|keikai|軽快|rhythmical (e.g. melody); casual (e.g. dress); light; nimble|लयबद्ध; तालबद्ध; आकस्मिक; लापरवाह; बेढंगा; रोशनी
きまりわるい|kimariwarui|決まり悪い|feeling awkward; being ashamed|भावना; जीवन; स्वभाव; प्राणी
けっしょう|kesshou|結晶|crystal; crystallization|स्फटिक; घड़ी का काँच; स्फटिक कांच पात्र; क्रिस्टलीकरण
みこみ|mikomi|見込み|hope; prospects; expectation|आशा; संभावना; उम्मीद; चाह; कफोत्सारक
よい|yoi|好い|good|अच्छा
このましい|konomashii|好ましい|nice; likeable; desirable|अच्छा; आसानी से पसंद आने वाला; योग्य; वांछित; वांछनीय
こうい|koui|好意|good will; favor; courtesy|अच्छा; पक्षपात करना; सहायता; सहायता देना; शालीनता; कृपा; विनय
こうきょう|koukyou|好況|prosperous conditions; healthy economy|समृद्ध; सम्पन्न; खुशहाल; स्वस्थ; स्वस्त; स्वस्थ्यवऋद्धक
こうちょう|kouchou|好調|favourable; promising; satisfactory; in good shape|हितकारी; अनुकूल; स्विकाराट्मक; आशाजनक; होनहार; संतोषप्रद; सन्तोषजनक; संतोषजनक
こうひょう|kouhyou|好評|popularity; favorable reputation|लोकप्रियता; सर्वमान्यता; अनुकूल; लाभदायक; स्वीकारात्मक
"""), "ja", "N4", "kanji"),

        Lesson("kw-money", "💰 Shopping & Money · 買い物・お金", "💰", "113 kanji words", kw("""
おかね|okane|お金|money|पैसा
やすい|yasui|安い|cheap|सस्ता
丸い/円い||丸い/円い|round; circular|वृत्त; दौर; समाप्त करना; घुमावदार; निरर्थक; गोल
ぎんこう|ginkou|銀行|bank|बैंक
たかい|takai|高い|tall; expensive|लंबा; महंगा
さいふ|saifu|財布|wallet|बटुआ; झोला; पर्स
みせ|mise|店|shop|दुकान
かいもの|kaimono|買い物|shopping|खरीदारी
お金持ち||お金持ち|rich man|अमीर
あんぜん|anzen|安全|safety|सुरक्षा; अहानिकारकता; सुरक्षित स्थान
うけつけ|uketsuke|受付|receipt|पाना; प्राप्ति; पावती
しょくりょうひん|shokuryouhin|食料品|groceries|किराना
てんいん|tenin|店員|shop assistant|दुकान सहायक
しなもの|shinamono|品物|goods|गोदाम; सामान; वस्तु
あんてい|antei|安定|stability; equilibrium|स्थिरता; नियमितता; संतुलन; साम्य
まる|maru|円|circle; money|वृत्त; पंक्ति; घेरना; पैसा
かかく|kakaku|価格|price; value; cost|कीमत; परिमाण; गुण; मान; कीमत
かち|kachi|価値|value; worth; merit|परिमाण; गुण; मान; महत्व; योग्य; लायक; विशेषता; योग्यता; सराहना
かんじょう|kanjou|勘定|calculation; counting; consideration|चाल; गणना; परिकल्पना; ध्यान; विचार; मुआवजा
きし|kishi|岸|bank; coast; shore|बैंक; किनारा; चलाना; व्यापार; किनारा; टेक लगाना; उठाना
きん|kin|金|(1) gold; (2) gold general (shogi) (abbr)|सोना; सोना
きんがく|kingaku|金額|amount of money|कुछ हद तक; मात्रा; राशि
きんこ|kinko|金庫|safe; vault; treasury; provider of funds|सुरक्षित; तहखाना; शव कक्ष; लग्गे के सहारे कूदना; अर्थविभाग; राजकोष; वित्त विभाग
かねもち|kanemochi|金持ち|rich man|अमीर
きんせん|kinsen|金銭|money; cash|पैसा; नक़दी; रोकड़ में बदलना; रोकड़
きんぞく|kinzoku|金属|metal|धातु; रेल की पटरी; पिघला
きんゆう|kinyuu|金融|monetary circulation; credit situation|मुद्रा; वित्तीय; आर्थिक; विश्वास दिलाना; जमा; मान्यता
げんきん|genkin|現金|cash; ready money; mercenary; self-interested|नक़दी; रोकड़ में बदलना; रोकड़; नक़द; लोभी; किराये का; किराये का सैनिक
こうこく|koukoku|広告|advertisement|विज्ञापन
こうか|kouka|高価|high price|ऊँची कीमत
こうそく|kousoku|高速|high speed; high gear|द्रुतगति; तेज़ गति का; तेज़ गति; ऊँचा
さいこう|saikou|最高|highest; supreme; the most|उच्चतम; परम; उच्चतम; सर्वोच्च; सबसे अधिक
ざいりょう|zairyou|材料|ingredients; material|सामान; महत्वपूर्ण; मूर्त
さくひん|sakuhin|作品|work; opus; performance; production|काम; रचना; संगीत रचना; कार्य; प्रदर्शन; क्रिया
しきゅう|shikyuu|支給|payment; allowance|इनाम; भुगतान; प्रतिकार; छूट; भत्ता; वृति
してん|shiten|支店|branch store (office)|ज्ञान विषय; बेलबूटे; बेलबूटे काढना
しはらい|shiharai|支払|payment|इनाम; भुगतान; प्रतिकार
しゃっきん|shakkin|借金|debt; loan; liabilities|आभार; उधार/ऋण; कर्ज; रृण; ऋण पर देना; रृण देना
しょうにん|shounin|商人|trader; shopkeeper; merchant|व्यापारी; पणिता; दुकानदार; व्यापारी; सौदागर; पणिता
しょうばい|shoubai|商売|trade; business; commerce; transaction; occupation|उद्योग; व्यापार करना; कारोबार; व्यापार; वाणिज्य
しょうひん|shouhin|商品|commodity; article of commerce; goods; stock; merchandise|माल; उपयोगी; सामग्री; सामान; वस्तु; दफ़ा/धारा; गोदाम; सामान; वस्तु
せいひん|seihin|製品|manufactured goods; finished goods|परिपूर्ण; पूर्ण; तैयार
せいきゅう|seikyuu|請求|claim; demand; application; request|दावा करना; का पात्र होना; लेना; दावा करना; मांग; चाह; संबंध; लागू; परिश्रम
ぜいきん|zeikin|税金|tax; duty|शुल्क लगाना; दाम; शुल्क; काम; कर्तव्य; कर
だいきん|daikin|代金|price; payment; cost; charge|कीमत; इनाम; भुगतान; प्रतिकार; कीमत
だん|dan|段|step; stair; flight of steps; grade; rank; level|कार्य; कदम; पद; सीढ़ी; सीढी; उड़ान; पलायन; कल्पना की उड़ान
ね|ne|値|value; price; cost|परिमाण; गुण; मान; कीमत; कीमत
ねだん|nedan|値段|price; cost|कीमत; कीमत
ちょきん|chokin|貯金|(bank) savings|बचत; व्यावृत्तियां
うま|uma|馬|(1) horse; (2) promoted bishop (shogi)|घोड़ा; उन्नीत; पदोन्नत
はんばい|hanbai|販売|sale; selling; marketing|बेचना; विक्रय; नीलामी; दुकानदारी; विपणन
ひよう|hiyou|費用|cost; expense|कीमत; लागत; खर्च
ひん|hin|品|thing; article; goods; dignity; article (goods); counter for meal courses|चीज़; सामान; वस्तु; दफ़ा/धारा; गोदाम; सामान; वस्तु
むりょう|muryou|無料|free; no charge|मुक्त
たった|tatta|唯|free of charge; mere; sole; only; usual; common|मुक्त; केवल; मात्र; झील; तल्ला; पूरा; कुकुरजीभी
りょうがえ|ryougae|両替|change; money exchange|बदलना; पैसा
りょうきん|ryoukin|料金|fee; charge; fare|शुल्क; फीस; आक्रमण; लगाना; उत्तरदायी; खाना; किराया; भोजन
あんい|ani|安易|easy-going|
かわせ|kawase|為替|money order; exchange|धनादेश; मनी आर्डर; करना; बदल देना; केन्द्र
いちだんと|ichidanto|一段と|greater; more; further; still more|अधिक; और; और अधिक; अधिक; वृद्धि करना; अधिक; सहायता करना
まるい|marui|円い|round; circular; spherical|वृत्त; दौर; समाप्त करना; घुमावदार; निरर्थक; गोल; गोल; गोलाकार; गोलीय
えんしゅう|enshuu|円周|circumference|परिधि; घेरा; मंडल
げひん|gehin|下品|vulgarity; meanness; indecency; coarseness|घटियापन; अश्लीलता; अशिष्टता; कंजूसी; नीचता; अनौचित्य; अश्लीलता; भद्दी गाली
かぜい|kazei|課税|taxation|कर लगाना; करदेय राशि; करारोपण
わりびき|waribiki|割引|discount; reduction; rebate|कम करना; खंडन करना; छूट; कमी; घटाव; पदावनति; कटौती; छूट; खाँचा बनाना
かんづめ|kanzume|缶詰|packing (in cans); canning; canned goods; tin can|बाँधने के लिये प्रयुक्त पदार्थ; सामान बाँधने का; पैक करने की सामग्री
げんりょう|genryou|原料|raw materials|अनुचित व्यवहार; कच्चा; फूहड़
こうきゅう|koukyuu|高級|high class; high grade|उत्कृष्ट; उच्चवर्गीय; उच्च जाति का; उत्कृष्ट; उत्कृष्ट.
こうそう|kousou|高層|upper|उपरी भाग; उपरी; उच्च
こうど|koudo|高度|altitude; height; advanced|ऊँचाई; ऊँचा; शिखर; चरम; पराकाष्ठा; विकसित; उन्नत; प्रगतिशील
こうとう|koutou|高等|high class; high grade|उत्कृष्ट; उच्चवर्गीय; उच्च जाति का; उत्कृष्ट; उत्कृष्ट.
しへい|shihei|紙幣|paper money; notes; bills|कागज़ी मुद्रा; कागज़ी चलार्थ
しりょう|shiryou|資料|materials; data|आँकड़े; बातें{दी हुई या जानी हुई}/निर्दिष्ट; डेटा
うけとり|uketori|受取|receipt|पाना; प्राप्ति; पावती
しゅうきん|shuukin|集金|money collection|पैसा
しょうしゃ|shousha|商社|trading company; firm|लेन देन; व्यापार; स्थिर; अटल; मजबूत
しょうてん|shouten|商店|shop; business firm|दुकान; व्यापार
しょうきん|shoukin|賞金|prize; monetary award|पुरस्कार; इनाम; धन; मुद्रा; वित्तीय; आर्थिक
しょうひん|shouhin|賞品|prize; trophy|पुरस्कार; इनाम; धन; विजयोपहार; विजयस्मारक; विजय चिन्ह
はりがね|harigane|針金|wire|लाइन; तार लगाना; फीता
よっぱらい|yopparai|酔っ払い|drunkard|पियक्कड़; शराबी
そうりょう|souryou|送料|postage; carriage|डाक व्यय; डाक टिकट; डाक शुल्क; बच्चा गाड़ी; आचरण; चाल
だえん|daen|楕円|ellipse|अंडवृत्त/अण्डवृत्त; अण्डवक्र; दीर्घवृत्त
ただ|tada|只|free of charge; mere; sole; only; usual; common|मुक्त; केवल; मात्र; झील; तल्ला; पूरा; कुकुरजीभी
みせや|miseya|店屋|store; shop|दुकान; दुकान
とくばい|tokubai|特売|special sale|विशेष
うりきれ|urikire|売り切れ|sold-out|
うれゆき|ureyuki|売行き|sales|विक्रय विभाग; बिक्री; सेल
うりあげ|uriage|売上|amount sold; proceeds|कुछ हद तक; मात्रा; राशि; लाभ; फ़ायदा; मुनाफ़ा
ばいてん|baiten|売店|shop; stand|दुकान; खड़ा होना
ばいばい|baibai|売買|trade; buying and selling|उद्योग; व्यापार करना; कारोबार; क्रय
はつばい|hatsubai|発売|sale|बेचना; विक्रय; नीलामी
ひつじゅひん|hitsujuhin|必需品|necessities; necessary article; requisite; essential|आवश्यक; आवश्यक; अपेक्षित; आवश्यक वस्तु
ぶひん|buhin|部品|parts; accessories|भाग
めんぜい|menzei|免税|tax exemption; duty exemption|शुल्क लगाना; दाम; शुल्क; काम; कर्तव्य; कर
ゆうりょう|yuuryou|有料|admission-paid; toll|क्षति; संख्या; कर[मार्गकर]
ようひんてん|youhinten|洋品店|shop which handles Western-style apparel and accessories|दुकान
りょうしゅう|ryoushuu|領収|receipt; voucher|पाना; प्राप्ति; पावती; प्रमाण पत्र; खर्च का पुर्जा; प्रमाणपत्र
やすっぽい|yasuppoi|安っぽい|cheap-looking; tawdry; insignificant|घटिया; सस्ता; भड़कीला; तुच्छ; नगण्य; मामूली
あんせい|ansei|安静|rest|आराम
いしょう|ishou|衣装|clothing; costume; outfit; garment; dress|पहनावा; परिधान; वस्त्र; पोशाक; पहनावा; कस्टयूम; संस्थान; पोशाक; हथियार
いりょう|iryou|衣料|clothing|पहनावा; परिधान; वस्त्र
えんかつ|enkatsu|円滑|harmony; smoothness|मधुर सम्बन्ध; तालमेल; समानता; सहजता; चिकनापन
えんまん|enman|円満|perfection; harmony; peace; smoothness; completeness; satisfaction; integrity|निपुणता; सब प्रकार से संतोषप्रद; संपूर्णता/निर्दोषता; मधुर सम्बन्ध; तालमेल; समानता; शांति
おうごん|ougon|黄金|gold|सोना
げひん|gehin|下品|inferior article|छोटा; घटिया; तुच्छ
がいか|gaika|外貨|imported goods; foreign money|आयातित; बाहर से लायी गई; विदेशी
かど|kado|角|1.  angle; 2.  bishop (shogi)|एक; दो
わりびき|waribiki|割引き|discount; reduction; rebate; tenths discounted|कम करना; खंडन करना; छूट; कमी; घटाव; पदावनति; कटौती; छूट; खाँचा बनाना
ききん|kikin|基金|fund; foundation|भण्डार; धन; नियत ब्याज पर स्थायी ऋण में परावर्तित कर देना; आधार; प्रतिष्ठान; संस्था
きんこ|kinko|金庫|safe; vault; treasury; provider of funds|सुरक्षित; तहखाना; शव कक्ष; लग्गे के सहारे कूदना; अर्थविभाग; राजकोष; वित्त विभाग
かなづち|kanazuchi|金槌|1.  (iron) hammer; 2.  punishment|एक; दो
けいひ|keihi|経費|expenses; cost; outlay|कीमत; खपत; लागत; खर्च
"""), "ja", "N4", "kanji"),

        Lesson("kw-travel", "✈️ Travel & Places · 旅行・場所", "✈️", "158 kanji words", kw("""
にもつ|nimotsu|荷物|luggage|सामान; समानअ
がいこく|gaikoku|外国|foreign country|विदेशी
がいこくじん|gaikokujin|外国人|foreigner|परदेशी; विदेशी
くに|kuni|国|country|देश
ところ|tokoro|所|place|स्थान
きっぷ|kippu|切符|ticket|टिकट
かた|kata|方|person; way of doing|व्यक्ति; रास्ता
ゆうがた|yuugata|夕方|evening|शाम
りょこう|ryokou|旅行|travel|यात्रा
かいじょう|kaijou|会場|assembly hall or meeting place|जमघट; सभा; फिटिंग
かえり|kaeri|帰り|return|लौटना
きゅうこう|kyuukou|急行|speedy; express|तेज़ी से चलने वाला/द्रुतगामी; तेज़ी से चलने वाला; शीघ्र; बताना; प्रकट; प्रकट करना
きんじょ|kinjo|近所|neighbourhood|क्षेत्र; इलाका; पड़ोस
まいる|mairu|参る|(humble) to go; to come|जाना; आना
しょうらい|shourai|将来|future; prospects|भविष्य; संभावना
ばあい|baai|場合|situation|समस्या; दृश्य; स्थिति
ばしょ|basho|場所|location|ठिकाना; स्थान; स्थापन
うりば|uriba|売り場|place where things are sold|स्थान
ひこうじょう|hikoujou|飛行場|airport|हवाई अड्डा
りょかん|ryokan|旅館|Japanese hotel|जापानवासी; जापानी
りょうほう|ryouhou|両方|both sides|दोनों
あんない|annai|案内|information; guidance; leading|जानकारी; नेतृत्व; मार्गदर्शन; मार्ग दर्शन; प्रमुख; प्रथम; मुख्य
いらい|irai|以来|since; henceforth|से; भविष्य में; इसके बाद से
いち|ichi|位置|place; situation; position; location|स्थान; समस्या; दृश्य; स्थिति; दृष्टिकोण; प्रतिष्ठा; पद
いっぽう|ippou|一方|(1) on the other hand; (2) meanwhile; (3) only; simple; in turn|जबकि; इस बीच; इसी दौरान; केवल
うわさ|uwasa|噂|rumour; report; gossip; common talk|गप उड़ाना; चर्चा; अफ़वाह; बताना; विवरण; सूचना; चुगली करना; गप्पी; चुगली
そと|soto|外|other place; the rest|अन्य; आराम
がいしゅつ|gaishutsu|外出|outing; going out|भाग लेना; सैर; जाना; जाने वाला; जाने
かんげい|kangei|歓迎|welcome; reception|स्वागत; स्वीकृति; स्वागत; स्वागत समारोह
かんこう|kankou|観光|sightseeing|दर्शनीय स्थल देखना
きたく|kitaku|帰宅|returning home|
けいゆ|keiyu|経由|go by the way; via|जाना; से होकर; के द्वारा; की राह से
げきじょう|gekijou|劇場|theatre; playhouse|युद्ध क्षेत्र; नाटक; शल्यक्रिया कक्ष; खिलौना घर; रंगशाला
けん|ken|券|ticket; coupon; bond; certificate|टिकट; कूपन; रसीद/परचा; बंधन; अनुबंध पट्र; बन्धन
げんば|genba|現場|actual spot; scene; scene of the crime|वास्तविक; सही; चालू; घटना; तमाशा; मौका; घटना; तमाशा; मौका
しあわせ|shiawase|幸せ|happiness; good fortune; luck; blessing|सौभाग्य; सुख शान्ति; खुशी; खुशकिस्मती; दिष्टि; भाग्य; नसीब या किस्मत; भाग्य होना
こううん|kouun|幸運|good luck; fortune|भाग्य तुम्हारे साथ हो!; संयोग; सौभाग्य; भाग्य
ゆき|yuki|行き|going|जाना; जाने वाला; जाने
ぎょうぎ|gyougi|行儀|manners|शिष्टाचार; रीति रिवाज; रंगढंग
こうどう|koudou|行動|action; conduct; behaviour; mobilization|कार्य; चलाना; आचरण; संचालन करना; आचरण; ढंग; बर्ताव
ごうか|gouka|豪華|wonderful; gorgeous; splendor; pomp; extravagance|अनोखा; आश्चर्यजनक; अद्भुत; सुन्दर; सुहावना; भड़कीला; भव्यता; दीप्ति; शान शौकत
こっかい|kokkai|国会|National Diet; parliament; congress|राष्ट्रजन; देशभक्त; रजवंशी; संसद भवन; संसद; कानून; प्रतिनिधि; व्यवस्थापिका सभा; प्रतिनिधि सभा
こっきょう|kokkyou|国境|national or state border|राष्ट्रजन; देशभक्त; रजवंशी
さつ|satsu|札|(1) token; label; (2) ticket; (3) charm|संकेत; निशानी; चिह्न; नाम; वर्गीकरण करना; उपनाम; टिकट
うかがう|ukagau|伺う|(hon) to visit; to ask; to inquire|दौरा करना; पूछना; पूछना; पता लगाना; छानबीन करना
じっこう|jikkou|実行|practice; performance; execution (e.g. program); realization|अभ्यास; कार्यप्रणाली; वकालत करना; कार्य; प्रदर्शन; क्रिया; फाँसी; सम्पादन करना; कार्यान्वयन
しゅくはく|shukuhaku|宿泊|lodging|आवास; किराये का; निवास
しゅっしん|shusshin|出身|graduate from; come from|स्नातक; डीग्री प्रप्त; स्नातकोत्तर; से होना; से आना; से मिलना
しゅっぱつ|shuppatsu|出発|departure|हट; रवानगी; प्रस्थान
出来るだけ||出来るだけ|if at all possible|
せい|sei|所為|cause; reason; fault|करना; कारण बनना; देना; कारण; त्रुटि; अवगुण; शिकार खो बैठना
しょうたい|shoutai|招待|invitation|संदेश पत्र; दावत; उपहार
しょうぼう|shoubou|消防|fire fighting; fire department|आग; अग्नि शामक दल; अग्निशामक विभाग
ば|ba|場|place; field (physics)|स्थान; कार्य क्षेत्र; आधार; खेलनेवाल दल
ばめん|bamen|場面|scene; setting (e.g. of novel)|घटना; तमाशा; मौका; जड़ा; समायोजन; स्थान
かみ|kami|神|god|भगवान
いきおい|ikioi|勢い|force; vigor; energy; spirit|बल; गुण; दल; प्रबलता; जोश; ताक़त; ऊर्जा
うまれ|umare|生まれ|birth; birth-place|जन्म
きじ|kiji|生地|birthplace|उद्गमस्थल; उद्गम; जन्मस्थान
ぜん|zen|善|good; goodness; right; virtue|अच्छा; गुण; भगवान; दयालुता; सही
ぜんこく|zenkoku|全国|country-wide; nation-wide; whole country; national|पूरी तरह से; पूर्णतया; पूरा
す|su|巣|nest; rookery; breeding place; beehive; cobweb|समूह; नियल बनाना; जमा करना; कौओं का; कौओं का अड्डा; प्रजनन; अभिजाति; उच्चवंश
ほか|hoka|他|other (esp. places and things)|अन्य
たいざい|taizai|滞在|stay; sojourn|रुकना; डेरा डालना; अस्थाई निवास; पड़ाव डालना
ちほう|chihou|地方|area; locality; district; region; the coast|क्षेत्र; इलाका; स्थान; इलाका; जिला/मंडल; जनपद
ていりゅうじょ|teiryuujo|停留所|bus or tram stop|बस
とう|tou|塔|tower; pagoda|मीनार; कर्षण नौका; हावी होना; मेरु; बौद्धमंदिर; मेरु मंदिर
とうちゃく|touchaku|到着|arrival|आने वाला; आगमन; जन्म
にゅうじょう|nyuujou|入場|entrance; admission; entering|प्रवेश द्वार; स्वीकृति; दाखिला; पैठ
はっこう|hakkou|発行|issue (publications)|मिलना; देना; प्रकाशन
かた|kata|方|side|किनारा
ほうぼう|houbou|方々|persons; this and that; here and there; everywhere|बहुत सी चीजें; इधर उधर
ほうこう|houkou|方向|direction; course; way|दिशा; पाठ्यक्रम; रास्ता
ほうほう|houhou|方法|method; manner; way; means; technique|क्रमबद्ध्ता; पद्धति; प्रणाली/तरीका; आचरण; प्रक्रिया; शैली; रास्ता
ほうもん|houmon|訪問|call; visit|बुलाना; दौरा करना
さそう|sasou|誘う|(1) to invite; to ask; (2) to tempt; to lure; to induce|आमंत्रित करना; पूछना; लुभाना; आकर्षित करना; ललचाना
らい|rai|来|for (10 days); next (year)|के लिए; अगला
たちば|tachiba|立場|standpoint; position; situation|दृष्टिकोण; दृष्टिकोण; प्रतिष्ठा; पद; समस्या; दृश्य; स्थिति
りゅうこう|ryuukou|流行|fashionable; fad; in vogue; prevailing|प्रचलित; फैशन परस्त; आधुनिक प्रणाली के; सनक
たび|tabi|旅|travel; trip; journey|यात्रा; यात्रा; प्रवास; प्रवास करना; यात्रा
おかえり|okaeri|お帰り|return; welcome|लौटना; स्वागत
おまいり|omairi|お参り|worship; shrine visit|समादर करना; पूजा करना; सम्मान करना; तीर्थ स्थान; तीर्थ; पुण्य स्थल
おうふく|oufuku|往復|(col) round trip; coming and going; return ticket|फेरा; वापसी; आनेवाला; भावी; आगमन; वापसी टिअक्ट; वापसी
ぐん|gun|郡|country; district|देश; इलाका; जिला/मंडल; जनपद
げんじゅう|genjuu|厳重|strict; rigour; severe; firm|सही; पक्का; सख्त; कठोरता; कठिनाई; सावधानी; भारी; सरल; कठोर
かしょ|kasho|個所|passage; place; point; part|परिवर्तन; स्वीकृति; किराया; स्थान; बिंदु
ご|go|碁|Go (board game of capturing territory)|जाना
こうこう|koukou|孝行|filial piety|बेटा[बेटी] संबंधी; संतानोचित
ひろば|hiroba|広場|plaza|चौक; विक्रय केंद्र; इमारत
ぎょうれつ|gyouretsu|行列|(1) line; procession; (2) matrix (math)|रेखा; शोभायाट्रा; याट्रा का व्यक्ति; जलूस/शोभायात्रा; गर्भाशय; मेट्रिक्स; परिवेशअ
こくおう|kokuou|国王|king|राजा
こくせき|kokuseki|国籍|nationality|राष्ट्रीयता
こくりつ|kokuritsu|国立|national|राष्ट्रजन; देशभक्त; रजवंशी
じち|jichi|自治|self-government; autonomy|स्वायत्तता; स्वशासन
しま|shima|縞|stripe|धारी; फीता; तबका
しゅっちょう|shucchou|出張|official tour; business trip|प्रामाणिक; अधिकारी; सरकारी; व्यापार
でいり|deiri|出入り|in and out; coming and going; free association; income and expenditure; debits and credit|कभी अन्दर कबी बाहर; आनेवाला; भावी; आगमन; मुक्त
できあがり|dekiagari|出来上がり|be finished; ready; made for; cut out|तैयार
できあがる|dekiagaru|出来上がる|(1) to be finished; to be ready; by definition; (2) to be very drunk|
ところどころ|tokorodokoro|所々|here and there; some parts (of something)|इधर उधर
かみさま|kamisama|神様|god|भगवान
せいほうけい|seihoukei|正方形|square|खरा; बराबर करना; वर्गाकार
かわる|kawaru|代る|(v5r; vi) to take the place of; to relieve; to be substituted for|कम करना; सहायता करना; उठाना
たんしょ|tansho|短所|(1) defect; demerit; weak point; (2) disadvantage|दोष; खराबी; छोड़्कर शामील हो जाना; अवगुण; कमज़ोर मुद्दा
ちめい|chimei|地名|place name|स्थानीय; किसी जगह का नाम; स्थानीय नाम
とうじょう|toujou|登場|entry (on stage)|दहलीज; प्रवेशाधिकार; द्वार
とうざい|touzai|東西|East and West; whole country|पूर्व; पूरी तरह से; पूर्णतया; पूरा
へいぼん|heibon|平凡|common; commonplace; ordinary; mediocre|सामान्य; आम; आम बात; साधारण विषय; साधारण; स्वाभाविक; सामान्य
へいこう|heikou|並行|(going) side by side; concurrent; abreast; at the same time|एक साथ; मिलकर; साथ साथ; एक साथ होने वाला; समवर्ती; के प्रति होशियार; क्रमबद्ध; साथ साथ
べんじょ|benjo|便所|toilet; lavatory; rest room; latrine; comfort station|शौचालय; शौचालय; सार्वजनिक; सार्वजनिक शौचालय; शौचालय; पाखाना युक्त विश्राम कक्ष
ほうがく|hougaku|方角|direction; way; compass point|दिशा; रास्ता; परकार; सीमा; कम्पास/दिशा निरूपण यंत्र
ほうげん|hougen|方言|dialect|उपभाषा; बोली; देशी भाषा
ほうしん|houshin|方針|objective; plan; policy|सामान्य; उद्देश्य; लक्ष्य; योजना; नीति; बीमा पत्र; शासन की चाल
ほうていしき|houteishiki|方程式|equation|समीकरण; समता
ほうめん|houmen|方面|direction; district; field (e.g.; of study)|दिशा; इलाका; जिला/मंडल; जनपद; कार्य क्षेत्र; आधार; खेलनेवाल दल
ぼくじょう|bokujou|牧場|(1) farm (livestock); (2) pasture land; meadow; grazing land|खेत; चरना; चरागाह; चराना; चारागाह; घास का मैदान
ぶさた|busata|無沙汰|neglecting to stay in contact|
めいしょ|meisho|名所|famous place|उत्कृष्ट; जाना; विख्यात
あけがた|akegata|明け方|dawn|होना; निकलना; सामने आना
やくしょ|yakusho|役所|government office; public office|सरकार; प्रजा; लोग; आम
よび|yobi|予備|preparation; preliminaries; reserve; spare|खाना; सम्पाक; अभ्यासकार्य; संचय; अलग छोड़; प्रतिबंध
よそ|yoso|余所|another place; somewhere else; strange parts|भिन्न; दूसरा; एक अन्य; कहीं भी; कहिं; कहीं; निराला; अनोखा; आश्चर्यजनक
らいにち|rainichi|来日|arrival in Japan; coming to Japan; visit to Japan|आने वाला; आगमन; जन्म; आनेवाला; भावी; आगमन; दौरा करना
とまる|tomaru|留まる|(1) to be fixed; (2) to abide; to stay (in the one place)|सहना; रहना; निवास करना; रुकना
Ͼ立||Ͼ立|confrontation; opposition; antagonism|सामना; बाधा; विरोध; प्रतिद्वंदी; विरोध; वैर भाव
おかげさまで|okagesamade|お蔭様で|Thanks to god; thanks to you|के कारण; धन्यवाद; शुक्रगुजार; के कारण; धन्यवाद; शुक्रगुजार
いち|ichi|位地|place; situation; position; location|स्थान; समस्या; दृश्य; स्थिति; दृष्टिकोण; प्रतिष्ठा; पद
しきたり|shikitari|為来り|customs|सीमा शुल्क; रीतिरिवाज; सीमाशुल्क विभाग
いこう|ikou|移行|switching over to|
いったい|ittai|一帯|a region; a zone; the whole place|क्षेत्र; प्रदेश; प्रदेश क्षेत्र; क्षेत्र; मेखला; कटिबंध
とおまわり|toomawari|遠回り|detour; roundabout way|चक्कर; कहीं जाने के लिए लंबा पथ; चक्करदार मार्ग; घुमावदार; चक्रिल परिपथ; पेचीदा
えんぽう|enpou|遠方|long way; distant place|लंबा; उदासीन; दूर; सुदूर
くだらない|kudaranai|下らない|good-for-nothing; stupid; trivial; worthless|मूर्ख; बेवकूफ़; फालतू; तुच्छ; साधारण; नगण्य
かばん|kaban|下番|going off duty|जाना; जाने वाला; जाने
どこ|doko|何処|where; what place|कहाँ; क्या
どなた|donata|何方|which; who|कौन सा; कौन
けらい|kerai|家来|retainer; retinue; servant|शुल्क; रखने वाला; प्रतिधारण; परिजन; ठाट बाट; नौकर चाकर; कर्मचारी; नौकर; सेवक
かしょ|kasho|箇所|passage; place; point; part|परिवर्तन; स्वीकृति; किराया; स्थान; बिंदु
かしゃ|kasha|華奢|luxury; pomp; delicate; slender; gorgeous|आराम; आनन्द; समृद्धि; धूमधाम; शान/धूमधाम; स्वादिष्ट; लिहाज रखनेवाला; उत्कृष्ट
がいしょう|gaishou|外相|Foreign Minister|विदेशी
そっぽ|soppo|外方|look (or turn) the other way|दूसरी ओर देखना
がいらい|gairai|外来|imported; outpatient clinic|आयातित; बाहर से लायी गई; बहिरोगी
かっぱつ|kappatsu|活発|vigor; active|प्रबलता; जोश; ताक़त; सक्रिय
かんこう|kankou|刊行|publication; issue|प्रकाशन; प्रकाशनअ; प्रख्यापन; मिलना; देना; प्रकाशन
かんこう|kankou|慣行|customary practice; habit; traditional event|विशिष्ट; हमेशा का; प्रचलित; प्रवृत्ति; पोशाक; स्वभाव; पारंपरिक; परम्परागत; रूढिगत
かんげん|kangen|還元|resolution; reduction; return to origins|विश्लेषण; इरादा/संकल्प; प्रस्ताव; कमी; घटाव; पदावनति; लौटना
ききょう|kikyou|帰京|returning to Tokyo|
きょうぎ|kyougi|協議|conference; consultation; discussion; negotiation|सम्मेलन; अधिवेशन; परामर्श; विचार विमर्श सभा; संमत्रण; चर्चा; बहस; आलोचनाआ
きょうこう|kyoukou|強硬|firm; vigorous; unbending; unyielding; strong; stubborn|स्थिर; अटल; मजबूत; सशक्त; प्रबल; ओजपूर्ण; न झुकने वाला; हठी; अनम्य
きょうこう|kyoukou|強行|forcing; enforcement|प्रवर्तन
けっこう|kekkou|決行|doing (with resolve); carrying out (i.e. a plan)|कार्यकलाप
みかた|mikata|見方|viewpoint|दृष्टिकोण; विचार; नज़रिया
げんこう|genkou|現行|present; current; in operation|उपहार; प्रवृत्ति; प्रवाह; धारा
げんば|genba|現場|actual spot; scene; scene of the crime|वास्तविक; सही; चालू; घटना; तमाशा; मौका; घटना; तमाशा; मौका
げんち|genchi|現地|actual place; local|वास्तविक; सही; चालू; स्थानीय निवासी; सीमित; स्थानिक
お|o|御|go-; honourable|माननीय; माननीय/सम्माननीय
ごめんください|gomenkudasai|御免ください|May I come in?|लेना; सम्भवतः; संभवतः
ごばん|goban|碁盤|Go board|जाना
"""), "ja", "N4", "kanji"),

        Lesson("kw-art", "🎨 Music, Art & Colors · 音楽・芸術", "🎨", "134 kanji words", kw("""
えいが|eiga|映画|movie|फ़िल्म
えいがかん|eigakan|映画館|cinema|चलचित्र; सिनेमा; सिनेमाघर
きいろ|kiiro|黄色|yellow|पीला
きいろい|kiiroi|黄色い|yellow|पीला
おんがく|ongaku|音楽|music|संगीत
うた|uta|歌|song|गाना
え|e|絵|picture|तस्वीर
くろ|kuro|黒|black|काला
くろい|kuroi|黒い|black|काला
しゃしん|shashin|写真|photograph|चित्र; छायाचित्र; फ़ोटो लेना
いろ|iro|色|colour|रंगीन; दिखावा; बहाना
あお|ao|青|blue|नीला
あおい|aoi|青い|blue|नीला
あか|aka|赤|red|लाल
あかい|akai|赤い|red|लाल
ちゃいろ|chairo|茶色|brown|भूरा
しろ|shiro|白|white|सफेद
しろい|shiroi|白い|white|सफेद
ひゃく|hyaku|百|hundred|सौ
みどり|midori|緑|green|हरा
ひきだし|hikidashi|引き出し|drawer; drawing out|चित्रकार; आदेशक; चैक; चित्रकारी; चिट्रंकनअ; चिट्रकारी
おと|oto|音|sound; note|आवाज़; ध्यान; कीर्ति; ध्यान देना
あかんぼう|akanbou|赤ん坊|baby|शिशु
はつおん|hatsuon|発音|pronunciation|उच्चारण; उच्चारण की रीत; उच्चारण विधि
うつくしい|utsukushii|美しい|beautiful|सुंदर
びじゅつかん|bijutsukan|美術館|art gallery|कलादीर्घा
わすれもの|wasuremono|忘れ物|lost article|गुम; गुमराह; डूबा हुआ
まんが|manga|漫画|comic|हास्यप्रद; हास्यजनक; चित्रकथा
おどり|odori|踊り|a dance|नाचना
いがい|igai|意外|unexpected; surprising|अविचारित; अनिवार्य; अप्रत्याशित; आश्चर्यजनक
おく|oku|奥|interior; inner part|भीतरी; भीतर; तटवर्ती; भीतरी; आंतरिक; गुप्त
おうだん|oudan|横断|crossing|क्रसिंग; पारगमन; चौराहा
おと|oto|音|sound; note|आवाज़; ध्यान; कीर्ति; ध्यान देना
かしゅ|kashu|歌手|singer|गायक; गायिका; गवैया
がか|gaka|画家|painter; artist|रस्सी; चित्रकार; पागर; कलाकार; कलाकार/चित्रकार; फ़नकार
かいが|kaiga|絵画|picture|तस्वीर
ともに|tomoni|共に|sharing with; participate in|भाग लेना; भागीदार होना; शरीक होना
けいかく|keikaku|計画|plan; project; schedule; scheme; program|योजना; योजना बनाना; डालना; योजना; अनुसूची; योजना लेख; सूची
げいじゅつ|geijutsu|芸術|(fine) art; the arts|कला
げき|geki|劇|drama; play|नाटक; नाटक/स्वांग; नाट्य रचना; खेलना
けっせき|kesseki|欠席|absence; non-attendance|अनुपस्थिति; अभाव; मृदु अपस्मार
かしこい|kashikoi|賢い|wise; clever; smart|बुद्धिमान; सूचना देना; विद्वान; बुद्धिमान; योग्य; निपुण; बुद्धिमान; अच्छा; स्वच्छ/सुव्यवस्थित
こくばん|kokuban|黒板|blackboard|ब्लैकबोर्ड/श्यामपट्ट; श्यामपट्ट
さっきょく|sakkyoku|作曲|composition; setting (of music)|बनावट; लेखन; संरचना; जड़ा; समायोजन; स्थान
さんか|sanka|参加|participation|सहभागिता; सहयोग
しゅうちゅう|shuuchuu|集中|concentration; focusing the mind|जमाव; तन्मयता; एकाग्रता
しゅっせき|shusseki|出席|attendance; presence|उपस्थिति; संख्या; के सामने; सामना; व्यक्तित्व
しんよう|shinyou|信用|confidence; dependence; credit; faith|भरोसा; दृढ विश्वास; दृढ; सहारा; निर्भर्ता; विश्वास; विश्वास दिलाना; जमा; मान्यता
まっか|makka|真っ赤|deep red; flushed (of face)|गहरा; उत्तेजित; परिपूर्ण; लाल
ず|zu|図|figure (e.g. Fig 1); drawing; picture; illustration|नमूना; विचार करना; कल्पना करना; चित्रकारी; चिट्रंकनअ; चिट्रकारी; तस्वीर
せつやく|setsuyaku|節約|economising; saving|बचाव; बचत
ねずみ|nezumi|鼠|(1) mouse; rat; (2) dark gray; slate color|चुहिया मारना; चोट पहुँचाने; चोरी छिपे जाना; कमीना आदमी; हड़तालभंजक; चूहा; अंधेरा
そうおん|souon|騒音|noise|शोर
たいくつ|taikutsu|退屈|tedium; boredom|अरुचि; ऊब; नीरसता; ऊब; उचाट
とう|tou|党|party (political)|पार्टी
どくしん|dokushin|独身|bachelorhood; single; unmarried; celibate|कुँवारापन; ऐकल; अकेला; एक; अविवाहित; कुंवारी
こい|koi|濃い|thick (as of color; liquid); dense; strong|घनिष्ठ; भारी; बहुत अधिक; स्पष्ट; स्वच्छ; प्रवाही; सघन; मूर्ख; घना
なかば|nakaba|半ば|middle; half; semi; halfway; partly|बीच; आधा; अर्ध; सेमीई
おもて|omote|表|table (e.g. Tab 1); chart; list|मेज़; तालिका; स्थिति अंकित करना; स्थिति अंकित; किनारा; मेंड़; झुकना
ぶたい|butai|舞台|stage (theatre)|कार्य क्षेत्र; प्रस्तुत करना; चरण
ものおと|monooto|物音|sounds|
びょうどう|byoudou|平等|equality (a); impartiality; evenness|समानता; निष्पक्षता; अपक्षपात
わかれ|wakare|別れ|parting; separation; farewell|विभाजन; विदाई; विदाई के समय का; वियुक्ति/विच्छेद; पृथक्करण; अलगाव; बिदाई; विदाई; बिदा का प्रणाम
ほうふ|houfu|豊富|abundance; wealth; plenty; bounty|बहुलता; प्रचुरता; अधिकता/अपार; संपत्ति; बहुलता; धन; बहुत; अनेक; अधिक मात्रा में
ほんもの|honmono|本物|genuine article|असली; सच्चा; अमिश्रित/वास्तविक
やくわり|yakuwari|役割|part; assigning (allotment of) parts; role; duties|भाग; कर्तव्य; भूमिका
よそく|yosoku|予測|prediction; estimation|भविष्य कथन; भविष्यवाणी; विचार; अनुमान; आगणन
よほう|yohou|予報|forecast; prediction|बताना; पूर्वानुमान करना; पूर्वानुमान; भविष्य कथन; भविष्यवाणी
えんかい|enkai|宴会|party; banquet|पार्टी; प्रीतिभोज; भोज
えんげき|engeki|演劇|play (theatrical)|खेलना
おんけい|onkei|恩恵|grace; favor; blessing; benefit|मनोहरता; अदा; दया; पक्षपात करना; सहायता; सहायता देना; सुखकर; अनुमति; आशीष
かよう|kayou|歌謡|song; ballad|गाना; गाथागीत; सादा गाना; प्रेम गीत
はいいろ|haiiro|灰色|grey; gray; ashen|नीरस; भूरा; दुःखी; स्लेटी; विवर्ण; पीला/विवर्ण; रक्तहीन
えのぐ|enogu|絵の具|colors; paints|
がっき|gakki|楽器|musical instrument|वाद्य यंट्र; इकतारा
くむ|kumu|汲む|(1) to draw (water); to dip; to scoop; to pump|चित्र बनाना; झुकाना; कम करना; निकालना; पाना; बनाना; पहले ही खबर देना
きょくせん|kyokusen|曲線|curve|आलेख; झुकाना; मुड़ जाना
ごじゅうおん|gojuuon|五十音|the Japanese syllabary|
こうげい|kougei|工芸|industrial arts|उद्योग कला
こん|kon|紺|navy blue; deep blue|गहरा नीला रंग; गहरा नीला; गाढा नीला रंग; गहरा
さくせい|sakusei|作成|frame; draw up; make; producing|किनारा; तैयार; बनावट; रुकना; आकर रुकना; प्रारूप खींचना; बनाना
さつえい|satsuei|撮影|photographing|
ざつおん|zatsuon|雑音|noise (jarring; grating)|शोर; जाली; सख्त; झंझरी
むらさき|murasaki|紫|purple colour; violet|धर्माचार्य का पद; प्रतापी; बैंगनी; बैंगनी रंग का; बैंगनी; एक प्रकार का फूल
しゃせつ|shasetsu|社説|editorial; leading article|सम्पादकीय लेख; सम्पादकीय; संपादकीय; संपदकीय लेख
しゅやく|shuyaku|主役|leading part; leading actor (actress)|प्रमुख; प्रथम; मुख्य; प्रमुख; प्रथम; मुख्य
しゅくしょう|shukushou|縮小|reduction; curtailment|कमी; घटाव; पदावनति; काट छाँट; काट छांट
じょうげ|jouge|上下|high and low; up and down; unloading and loading; praising and blaming|सर्वट्र; उतार चढाव; आगे पीछे; ऊपर नीचे; माल उतराई
まっくろ|makkuro|真っ黒|pitch black|घोर अँधेरा; घोर; कालाकलूटा
まっさお|massao|真っ青|deep blue; ghastly pale|गहरा; विवर्ण; विकट; भयंकर
まっしろ|masshiro|真っ白|pure white|शुभ्रा
ずひょう|zuhyou|図表|chart; diagram; graph|तालिका; स्थिति अंकित करना; स्थिति अंकित; चित्र; आकृति; आकृतिय़ा; ग्राफ
あおじろい|aojiroi|青白い|pale; pallid|बाल्टी; मुरझाया; घेरना; मुरझाया; पीला; म्लान
たんぺん|tanpen|短編|short (e.g. story; film)|छोटा; फ़िल्म
ちょうこく|choukoku|彫刻|carving; engraving; sculpture|नक्काशी; नक्काशी की कला; तक्षकला,तक्षण,तक्षणकला,नक्काशी; नक्काशी; नक्काशीदार चित्र; धातु लकड़ी आदि पर चित्र खोदने की विद्या; मूर्तिकला; मूर्ति बनाना; मूर्ति
しめきり|shimekiri|締切|closing; cut-off; end; deadline; Closed; No Entrance|अंत
ふみきり|fumikiri|踏切|railway crossing; level crossing; starting line; scratch; crossover|रेल पथ; रेलवे; रेल की पटरी; सम पार; शुरुआत
とくしょく|tokushoku|特色|characteristic; feature|विशिष्ट लक्षण; लक्षण; विशिष्टता; दिखाना; प्रकट करना; विशेषता
とくてい|tokutei|特定|specific; special; particular|विशिष्ट; विशेष; निश्चित; विशेष; निराला; सतर्क; विस्तृत
はっそう|hassou|発想|expression (music); conceptualization|वचन; पदसंहति; अभिव्यक्ति; वैचारिकता
びよう|biyou|美容|beauty of figure or form|सुन्दरता; अच्छी चीज़; सौंदर्य
むじ|muji|無地|plain; unfigured|सरल; समतल; सीधा
ゆだん|yudan|油断|negligence; unpreparedness|लापरवाही; उपेक्षा
ろくおん|rokuon|録音|(audio) recording|ध्वन्यालेखन; अभिलेकन
いつ|itsu|佚|be lost; peace; hide; mistake; beautiful; in turn|शांति; गुप्त रखना; छिपने की जगह; छिपा देना
おしゃれ|oshare|お洒落|smartly dressed; someone smartly dressed; fashion-conscious|जोशीले ढंग से; साफ़ सुथरे ढंग से; चुस्त दुरुस्त ढंग से; कोई
いっきょに|ikkyoni|一挙に|at a stroke; with a single swoop|एक ही वार में
いちぶ|ichibu|一部|1.  one copy  e.g. of a document; 2.  a part; partly; some|एक; दो; कुछ हद तक; कुछ; कुछ अंश
いちべつ|ichibetsu|一別|parting|विभाजन; विदाई; विदाई के समय का
いちよう|ichiyou|一様|uniformity; evenness; similarity; equality; impartiality|एकरूपता; एकसमानता; समानता; समनता; सादृश्य/समानता
きいろ|kiiro|黄色|yellow|पीला
おと|oto|音|sound; note|आवाज़; ध्यान; कीर्ति; ध्यान देना
おんいろ|oniro|音色|tone color; tone quality; timbre; synthesizer patch|स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल; स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल; स्वर विशेषता; बाजे की आवाज
したどり|shitadori|下取り|trade in; part exchange|नयी खरीद के मूल्य के रूप में अपनी पुरानी चीज देना; आंशिक; आंशिक अदायगी; आंशिक शोधन पद्धति; आंशिक शोधन
かび|kabi|華美|pomp; splendor; gaudiness|धूमधाम; शान/धूमधाम; भव्यता; दीप्ति; शान शौकत; भड़कीलापन
かく|kaku|画|stroke|प्रहार करना; अघात; प्रहार
かっき|kakki|画期|epoch-making|
かいご|kaigo|介護|nursing|परिचर्या
かいほう|kaihou|介抱|nursing; looking after|परिचर्या; एक दृष्टि
がくふ|gakufu|楽譜|score (music)|प्राप्त करना; खरोंचना; खरोंच
かけ|kake|掛け|credit|विश्वास दिलाना; जमा; मान्यता
かんご|kango|看護|nursing; (army) nurse|परिचर्या; नर्स
かんよ|kanyo|関与|participation; taking part in; participating in; being concerned in|सहभागिता; सहयोग; मनोहर; आसानी से मिलना; आकर्षक
きかん|kikan|季刊|quarterly (e.g. magazine)|त्रैमासिक पत्रिका; त्रैमासिक; तिमाही
ぎきょく|gikyoku|戯曲|play; drama|खेलना; नाटक; नाटक/स्वांग; नाट्य रचना
わざ|waza|技|art; technique|कला; निपुणता; तकनीक
きゃくしょく|kyakushoku|脚色|dramatization (e.g. film)|नाटकीकरणअ; नाटकीय रूपांतरण
きょく|kyoku|曲|tune; piece of music|ठीक करना; ठिक करना; तालमेल; टुकड़ा
くかく|kukaku|区画|division; section; compartment; boundary; area; block|वर्ग; हिस्सा; श्रेणी; वर्ग; दल; काटना; खाना; विभाग; डिब्बा
めぐみ|megumi|恵み|blessing|सुखकर; अनुमति; आशीष
げきだん|gekidan|劇団|troupe; theatrical company|मण्डली; दल{तमाशा करने वालों का}; नाटकीय; नाटक संबंधी; नाट्यशाला का
げんぞう|genzou|現像|developing (film)|बढ़ता; विकासशील
か|ka|個|article counter|सामान; वस्तु; दफ़ा/धारा
こべつ|kobetsu|個別|particular case|निराला; सतर्क; विस्तृत
"""), "ja", "N4", "kanji"),

        Lesson("kw-sports", "⚽ Sports & Games · スポーツ・遊び", "⚽", "52 kanji words", kw("""
およぎかた|oyogikata|泳ぎ方|way of swimming|रास्ता
おしいれ|oshiire|押し入れ|closet|गुप्त; गोपनीय; अलमारी
きょうそう|kyousou|競争|competition|स्पर्ध्दा; प्रतियोगिता; प्रतिस्पर्ध्दी
しあい|shiai|試合|match; game|मिलना; जोड़िदार; जोड़ा बन्ना; खेल
すいえい|suiei|水泳|swimming|तैराकी
あそび|asobi|遊び|play|खेलना
ひっぱる|hipparu|引っ張る|(1) to pull; to draw; to stretch; to drag; (2) to pull the ball (baseball)|खींचना; चित्र बनाना; फैलाना; फैल जाना; पंक्ति
うんどう|undou|運動|motion; exercise|गति; प्रस्ताव; इशारा; व्यायाम
およぎ|oyogi|泳ぎ|swimming|तैराकी
おに|oni|鬼|ogre; demon; it (i.e.; in a game of tag)|दैत्य; राक्षस; नरभख्षी; भूत; दैत्य; शैतान
たま|tama|球|globe; sphere; ball|गोला; भूमण्ड़ल; पिंड; वृत्त; गोला; क्षेत्र; गेंद
きょうぎ|kyougi|競技|game; match; contest|खेल; मिलना; जोड़िदार; जोड़ा बन्ना; बहस करना; प्रतियोगिता; संघर्ष
たま|tama|玉|ball; sphere; coin|गेंद; वृत्त; गोला; क्षेत्र; बनाना; मुद्रा; गढ़ना
けんか|kenka|喧嘩|quarrel; (drunken) brawl; failure|विवाद करना; शिकायत; झगड़ा; उपद्रव; लड़ाई झगड़ा करना; लड़ाई; असफलता; गिरना; गिरावट
しばい|shibai|芝居|play; drama|खेलना; नाटक; नाटक/स्वांग; नाट्य रचना
かち|kachi|勝ち|win; victory|जीतना; विजय; संजय; जीता
せんしゅ|senshu|選手|(1) player (in game); (2) team|अभिनेता; वादक; खिलाडी; टीम
ちきゅう|chikyuu|地球|the earth|अहि; अबनी; धात्री
ていど|teido|程度|degree; amount; grade; standard; of the order of (following a number)|कोटि; उपाधि; अंश; कुछ हद तक; मात्रा; राशि; कोटि; पद; वर्गीकृत करना
まけ|make|負け|defeat; loss; losing (a game)|विफल कर देना; रोकना; हराना; नष्ट करना; असफल; हानि
いだく|idaku|抱く|(sl) to embrace; to hug; to harbour; to entertain|अंक देना; अंकवार भरना; आलिंगन; आलिंगन करना; सटा लेना; बंदरगाह; मन में रखना; शरण देना
まく|maku|幕|curtain; bunting; act (in play)|बाधा; नाटक; पर्दा; ध्वजपट; पथरचिरटा; झंडी; काम करना
ゆうしょう|yuushou|優勝|overall victory; championship|कुल; सभी; सामान्य; चैम्पियनशिप; सर्वोपरित्व; जोरदार समर्थन
つばさ|tsubasa|翼|wings|
れんしゅうする|renshuusuru|練習|practice|अभ्यास; कार्यप्रणाली; वकालत करना
ごちそう|gochisou|御馳走|feast; treating (someone)|खाना; संतोष; समारोह; सत्कार
さいほう|saihou|裁縫|sewing|सिलाई
しゅうりょう|shuuryou|終了|end; close; termination|अंत; बंद करना; समाप्ति; समापन; गर्भपात
しょうはい|shouhai|勝敗|victory or defeat; issue (of battle)|विजय; संजय; जीता; मिलना; देना; प्रकाशन
しょうぶ|shoubu|勝負|victory or defeat; match; contest; game; bout|विजय; संजय; जीता; मिलना; जोड़िदार; जोड़ा बन्ना; बहस करना; प्रतियोगिता; संघर्ष
せっきん|sekkin|接近|getting closer; drawing nearer; approaching|मिलना; चित्रकारी; चिट्रंकनअ; चिट्रकारी; आनेवाला
すもう|sumou|相撲|sumo wrestling|सूमो कुश्ती
たいそう|taisou|体操|gymnastics; physical exercises; calisthenics|जिमनास्टिक; व्यायाम; कसरत; शरीर; वास्तविक; शारीरिक
でんきゅう|denkyuu|電球|light bulb|बिजली का बल्ब
はっき|hakki|発揮|exhibition; demonstration; utilization; display|प्रदर्शनी; प्रदरशनी; नुमाइश; प्रदर्शन; नमूना; प्रमाण देना; उपयोग; प्रयोग
ゆうえんち|yuuenchi|遊園地|amusement park|मनोरंजन उद्यान; मेला; मनोरंजन
ごちそう|gochisou|ご馳走|feast; treating (someone)|खाना; संतोष; समारोह; सत्कार
ごちそうさま|gochisousama|ご馳走さま|feast|खाना; संतोष; समारोह
じゃんけん|janken|じゃん拳|rock-scissors-paper game|
えんしゅつ|enshutsu|演出|production (e.g. play); direction|प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन; दिशा
けがれ|kegare|汚れ|uncleanness; impurity; disgrace|गंदगी; गंदगी; अशुद्धता; अशौच; कलंकित करना; कलंकित; अपमान
よこづな|yokozuna|横綱|sumo grand champion|एक प्रकार की कुस्ती; सूमो
えもの|emono|獲物|game; spoils; trophy|खेल; विजयोपहार; विजयस्मारक; विजय चिन्ह
かんせん|kansen|幹線|main line; trunk line|मुख्य रेल मार्ग; लाइन; धारा; डाली
がんきゅう|gankyuu|眼球|eyeball|आँख की पुतली
まり|mari|鞠|ball|गेंद
ぎゃくてん|gyakuten|逆転|(sudden) change; reversal; turn-around; coming from behind (baseball)|बदलना; परिवर्तन; पराजय; मत परिवर्तन
きゅうこん|kyuukon|球根|(plant) bulb|कंद; कन्द; घुंडी
けっしょう|kesshou|決勝|decision of a contest; finals (in sports)|निर्णय; निर्णय करना; निर्णय शक्ति
けんしょう|kenshou|懸賞|offering prizes; winning; reward|बलि; भेंट; अर्पित; जीतना; जीत; जिताने वाला; पुरस्कार; पुरस्कृत करना; पारितोषिक देना
げんみつ|genmitsu|厳密|strict; close|सही; पक्का; सख्त; बंद करना
おまけ|omake|御負け|1.  a discount; a prize; 2.  something additional; bonus; an extra; 3.  an exaggeration|एक; पुरस्कार; इनाम; धन; दो
"""), "ja", "N4", "kanji"),

        Lesson("kw-society", "🏛️ Society & Politics · 社会・政治", "🏛️", "111 kanji words", kw("""
みぎ|migi|右|right side|सही
ぬるい|nurui|温い|luke warm|
あたたかい|atatakai|暖かい|warm|गर्म
あかるい|akarui|明い|bright|चमकीला
きそく|kisoku|規則|regulations|
くん|kun|君|(informal) You (used by men towards women)|तुम
けいざい|keizai|経済|finance; economy|आर्थिक; आर्थिक प्रबन्ध; वित्तीय; अर्थ प्रबन्धन; अर्थव्यवस्था; कमखर्ची
けいさつ|keisatsu|警察|police|पुलिस
こくさい|kokusai|国際|international|अंतर्राष्ट्रीय श्रमजीवी संघ; अंतर्राष्ट्रीय संघ; अन्तर्राष्ट्रीय संघटन
じゆう|jiyuu|自由|freedom|स्वतंत्रता; आजादी; छूट
しゃかい|shakai|社会|society; public|वर्ग; साथ; सभा; प्रजा; लोग; आम
せいじ|seiji|政治|politics; government|कूटनीति; राजनीति विज्ञान; राजनीति; सरकार
せつめい|setsumei|説明|explanation|स्पष्टीकरण; व्याख्या; सफ़ाई
せんそう|sensou|戦争|war|युद्ध
ほうりつ|houritsu|法律|law|कानून
いはん|ihan|違反|violation (of law); transgression; infringement; breach|अपराध; उल्लंघन; अतिक्रमण; उल्लंघन; अतिक्रमण; भूभाग तक विस्तार; उल्लंघन; अतिलंघन
おせん|osen|汚染|pollution; contamination|प्रदूषण; दूषण/संदूषण; दूषण
おう|ou|王|king; ruler; sovereign; monarch|राजा; पटरी; शासक; अधिपति; प्रधान; शासक; शासकीय
おんだん|ondan|温暖|warmth|जोश; गर्मी; मिट्रभाव
かいしゃく|kaishaku|解釈|explanation; interpretation|स्पष्टीकरण; व्याख्या; सफ़ाई; स्पष्टीकरण; व्याख्या; अर्थ
きふ|kifu|寄付|contribution; donation|सहायता; चंदा; लेख; दान; इमदाद; अवदान
ぎむ|gimu|義務|duty; obligation; responsibility|काम; कर्तव्य; कर; अनुबंध पट्र; एहसान; आभार; उत्तरदायित्व; ज़िम्मेदारी; दाय
けいこう|keikou|傾向|tendency; trend; inclination|झुकाव; प्रकृति; रूझान; दौर; प्रवृत्ति; प्रवाह; रुचि; झुकाव; शौक
きまり|kimari|決まり|settlement; conclusion; regulation; rule|निपटारा; समझौता; भुगतान; समाप्ति; निष्कर्ष; अंतिम निर्णय; नियम; अधिनियम; नियन्त्रण
けってい|kettei|決定|decision; determination|निर्णय; निर्णय करना; निर्णय शक्ति; निर्णायक; विचार; इरादा
けんり|kenri|権利|right; privilege|सही; सौभाग्य; सुविधा; विशेषाधिकार
こっか|kokka|国家|state; country; nation|बताना; व्यक्त करना; अभिव्यक्त करना; देश; जाति; राज्य; राष्ट्र
こくみん|kokumin|国民|national; people; citizen|राष्ट्रजन; देशभक्त; रजवंशी; लोग; स्थानिक; नागरिक; निवासी
さゆう|sayuu|左右|(1) left and right; (2) influence; control; domination|बायाँ; प्रभाव; प्रभावित करना; प्रेरित करना; शासन; संचालन करना; निपुणता
さいばん|saiban|裁判|trial; judgement|पूर्व परीक्षण; परीक्षण; विचार; धारणा; परख; पहचान
つみ|tsumi|罪|crime; fault; indiscretion|अपराध; पाप; जुर्म; त्रुटि; अवगुण; शिकार खो बैठना; अविवेकपूर्ण; असावधानी; अविवेकपूर्ण कार्य
しはい|shihai|支配|rule; control; direction|निर्णय कर; आधिपत्य; फुट्टा{पैमाना}; शासन; संचालन करना; निपुणता; दिशा
しばふ|shibafu|芝生|lawn|मैदान; लॉन/दूर्वाक्षेत्र; मलमल
しゅぎ|shugi|主義|doctrine; rule; principle|सिद्धांत; मत; विश्वास योग्य नीति; निर्णय कर; आधिपत्य; फुट्टा{पैमाना}; मर्यादा; विधि; सूट्र
しゅっぱん|shuppan|出版|publication|प्रकाशन; प्रकाशनअ; प्रख्यापन
じゅんちょう|junchou|順調|favourable; doing well; O.K.; all right|हितकारी; अनुकूल; स्विकाराट्मक; कार्यकलाप; ठीक
しょう|shou|賞|prize; award|पुरस्कार; इनाम; धन; अनुदान; पुरस्कार; सावधान
せいど|seido|制度|system; institution; organization|शरीर; व्यवस्था; पद्धति; संस्थान; संसथा भवन; संस्थापन; बनावट; संघ; संरचना
せいふ|seifu|政府|government; administration|सरकार; देना; दवा; दवा देना
せきにん|sekinin|責任|duty; responsibility|काम; कर्तव्य; कर; उत्तरदायित्व; ज़िम्मेदारी; दाय
あら|ara|粗|defect; flaw; blemish; weak point|दोष; खराबी; छोड़्कर शामील हो जाना; त्रुटि; कमज़ोरी; दोष; कलंकित करना; दाग़ लगाना; कलंक/दोष/त्रुटि
そうぞう|souzou|想像|imagination; guess|भावना; कल्पना; उपाय कुशलता; अनुमान लगाना
あたたかい|atatakai|暖かい|warm; mild|गर्म; हल्का; सुहावना; विनम्र
ばくはつ|bakuhatsu|爆発|explosion; detonation; eruption|विस्फोट; धमाका; अचानक वृद्धि; विस्फोट; धमाका; उद्भेदन; उदभेदन
はっぴょう|happyou|発表|announcement; publication|सूचना; घोषणा; विज्ञापन; प्रकाशन; प्रकाशनअ; प्रख्यापन
はんざい|hanzai|犯罪|crime|अपराध; पाप; जुर्म
さける|sakeru|避ける|(1) to avoid (physical contact ); (2) to ward off; to avert|रोकना; दूर रहना; टालना; रोकना; से बचना; बचाव; दूर रहना; फेर लेना; टाल देना
ふじゆう|fujiyuu|不自由|discomfort; disability; inconvenience; destitution|घबरा देना; अशांति; असुविधा; विकलांगता; असामर्थ्यता; निर्योग्यता; कष्ट देना; कष्ट; असुविधा
へいわ|heiwa|平和|peace; harmony|शांति; मधुर सम्बन्ध; तालमेल; समानता
ほしょう|hoshou|保証|guarantee; security; assurance; pledge; warranty|आशा करना; निश्चिंत होना; वचन; सुरक्षा; सुरक्षा उपाय; प्रतिभूति; आश्वासन; गारन्टी; विश्वास
ほう|hou|法|Act (law: the X Act)|काम करना
みりょく|miryoku|魅力|charm; fascination; glamour|बहकाना; मनोहरता; आकर्षित करना; आकर्षण; मोह; सम्मोहन; चकाचौंध/आकर्षण; तड़क भड़क; मोहकता
もっとも|mottomo|尤も|quite right; plausible; natural; but then; although|पूर्णतया; नितान्त; अत्यन्त; सच्चा; विश्वसनीय; विश्वसनीय लगने वाला; सहज; स्वाभाविक; प्राकृतिक
かこう|kakou|下降|downward; descent; fall; drop; subsidence|नीचे की ओर; नीचे की ओर का; नीचे की; कुल; वंश; वंशज; गिरना
かいせつ|kaisetsu|解説|explanation; commentary|स्पष्टीकरण; व्याख्या; सफ़ाई; कमेंट्री; टिप्पणी; भाष्य
かんねん|kannen|観念|(1) idea; notion; conception; (2) sense (e.g. of duty)|विचार; इच्छा; धारणा; विचार; धारणा; समझ; गर्भाधान
きりつ|kiritsu|規律|order; rules; law|आदेश; कानून
げいのう|geinou|芸能|public entertainment; accomplishments; attainments|प्रजा; लोग; आम
こうがい|kougai|公害|public nuisance; pollution|लोककंटक कानून; लोककंटक; प्रदूषण
こうきょう|koukyou|公共|public; community; public service; society; communal|प्रजा; लोग; आम; जाति; समुदाय; समाज; प्रजा; लोग; आम
こうしゅう|koushuu|公衆|the public|प्रजा; लोग; आम
ごうどう|goudou|合同|combination; incorporation; union; amalgamation|संगत; संचय; संमिश्रण; समावेशन; निगमन; समावेश; संयोग; संघ; ग्रेट ब्रिटेन
せいとう|seitou|政党|(member of) political party|राजनैतिक दल
くみあわせ|kumiawase|組合せ|combination|संगत; संचय; संमिश्रण
だとう|datou|妥当|valid; proper; right; appropriate|प्रभावशाली; मान्य; वैध; ठीक; उचित; व्यक्ति वाचक; सही
おおよそ|ooyoso|大凡|about; roughly; as a rule; approximately|के बारे में; लगभग; रुखाई से; अशिष्टता से
なかなおり|nakanaori|仲直り|reconciliation; make peace with|पुनर्मेल; सामंजस्य; फिर से मेल या मिलाप; बनाना
ちょっかく|chokkaku|直角|right angle|समकोण
つめ|tsume|爪|fingernail or toenail; claw; talon; hoof|नाखून; खरोंचना; पंजा; सॅड़सी; पंजा; चंगुल
じょうぎ|jougi|定規|(measuring) ruler|पटरी; शासक; अधिपति
とうばん|touban|当番|being on duty|जीवन; स्वभाव; प्राणी
のうど|noudo|濃度|concentration; brightness|जमाव; तन्मयता; एकाग्रता; चमक; कीर्ति; जगमगाहट
ふきそく|fukisoku|不規則|irregularity; unsteadiness; disorderly|अनियमितता; अस्थिरता; असंतुलन; अस्त व्यस्त; उल्टा पुल्टा; उत्पाती
ぶし|bushi|武士|warrior; samurai|सैनिक; प्रयुत्सु; जापान की मिलिटरी; जापान की मिलिटरी का सदस्य; जापानी सैन्य
ものさし|monosashi|物差し|ruler; measure|पटरी; शासक; अधिपति; ताल; मर्यादा; काफ़ी
ほうそく|housoku|法則|law; rule|कानून; निर्णय कर; आधिपत्य; फुट्टा{पैमाना}
ぼうはん|bouhan|防犯|prevention of crime|रोकथाम; रोक थाम
ほがらか|hogaraka|朗らか|brightness; cheerfulness; melodious|चमक; कीर्ति; जगमगाहट; प्रसन्नता; मधुर; सुरीली; सुरीला
あんさつ|ansatsu|暗殺|assassination|हत्या
いこう|ikou|意向|intention; idea; inclination|धारणा; विचार; अंतिम लक्ष्य; विचार; रुचि; झुकाव; शौक
かごう|kagou|化合|chemical combination|रासायनिक पदार्थ; रसायनिक द्रव्य; रासायन संबंधी
かいそう|kaisou|回送|forwarding|
ちょうど|choudo|恰度|just; right; exactly|बस; सही; वास्तव में; ठीक ठीक/यथार्थतः; वास्तव
かんぺき|kanpeki|完璧|perfection; completeness; flawless|निपुणता; सब प्रकार से संतोषप्रद; संपूर्णता/निर्दोषता; संपूर्णता; निर्दोष; दोषरहित; नैसर्गिक
かんぜい|kanzei|関税|customs; duty; tariff|सीमा शुल्क; रीतिरिवाज; सीमाशुल्क विभाग; काम; कर्तव्य; कर; सीमा शुल्क; सीमा शुल्क लगाना; दण्ड विधा
きそう|kisou|寄贈|donation; presentation|दान; इमदाद; अवदान; प्रदर्शन; व्याख्यान; उपहारअ
きけん|kiken|棄権|abstain from voting; renunciation of a right|बचना/से दूर रहना; दूर; मतदान में भाग नहीं लेना; त्याग; परित्याग; संन्यास
きやく|kiyaku|規約|agreement; rules; code|वचन; सहमति; करार; नियमावली; गुप्त भाषा; कूट संकेत में लिखना
ぎり|giri|義理|duty; sense of duty; honor; decency; courtesy; debt of gratitude; social obligation|काम; कर्तव्य; कर; दिशा; होश; ज्ञान; उपाधि; गौरव; सम्मान
きょうかい|kyoukai|協会|association; society; organization|संबंध; संघ; समिति; वर्ग; साथ; सभा; बनावट; संघ; संरचना
く|ku|区|ward; district; section|संरक्षित; रोगीकक्ष; रक्षा करना; इलाका; जिला/मंडल; जनपद; वर्ग; दल; काटना
くんしゅ|kunshu|君主|ruler; monarch|पटरी; शासक; अधिपति; राजा; राजाअ; रानी
ぐん|gun|軍|war; battle; campaign; fight|युद्ध; लड़ाई/युध्द; सामना करना; कोशिश करना; अभियान; अभियान्; अभियान चलाना
ぐんかん|gunkan|軍艦|warship; battleship|युद्ध पोत; युद्ध; जंगी जहाज़; युद्धपोत; रणपोत; जंगी
けいしゃ|keisha|傾斜|inclination; slant; slope; bevel; list; dip|रुचि; झुकाव; शौक; दृष्टिकोण; तिरछा करना; तिरछा; झुकाना; समतल; झुकना
けいかい|keikai|警戒|warning; admonition; vigilance|चेतावनीपूर्ण; चेतावनी; धमकी; चेतावनी; डाँट फटकार; सतर्क दृष्टि; सतर्कता; दक्षता
けつい|ketsui|決意|decision; determination|निर्णय; निर्णय करना; निर्णय शक्ति; निर्णायक; विचार; इरादा
けつだん|ketsudan|決断|decision; determination|निर्णय; निर्णय करना; निर्णय शक्ति; निर्णायक; विचार; इरादा
けつごう|ketsugou|結合|combination; union|संगत; संचय; संमिश्रण; संयोग; संघ; ग्रेट ब्रिटेन
けんやく|kenyaku|倹約|thrift; economy; frugality|किफ़ायत; मितव्ययिता; थ्रिफ़्ट; अर्थ प्रबन्धन; अर्थव्यवस्था; कमखर्ची; मितव्ययिता; मितव्यता
けんよう|kenyou|兼用|multi-use; combined use; combination; serving two purposes|मिश्रित; मिश्र; संगत; संचय; संमिश्रण
けん|ken|権|authority; the right (to do something)|अधिकारी; विशेषज्ञ; अधिकार; सही
いいわけ|iiwake|言い訳|excuse; explanation|क्षमा; स्पष्टीकरण; व्याख्या; सफ़ाई
おおやけ|ooyake|公|official; public; formal; open; governmental|प्रामाणिक; अधिकारी; सरकारी; प्रजा; लोग; आम; शिष्टाचार के अनुकूल; सुव्यवस्थित; औपचारिक
こうかい|koukai|公開|presenting to the public|
こうぜん|kouzen|公然|open (e.g. secret); public; official|खोलना; प्रजा; लोग; आम; प्रामाणिक; अधिकारी; सरकारी
こうだん|koudan|公団|public corporation|प्रजा; लोग; आम
こうぼ|koubo|公募|public appeal; public contribution|प्रजा; लोग; आम; प्रजा; लोग; आम
こうよう|kouyou|公用|government business; public use; public expense|सरकार; प्रजा; लोग; आम; प्रजा; लोग; आम
こうりつ|kouritsu|公立|public (institution)|प्रजा; लोग; आम
むけ|muke|向け|for ~; oriented towards ~|विशेष  प्रकार  की वस्तु मे रुचि रखने  वाला
"""), "ja", "N4", "kanji"),

        Lesson("kw-tech", "🔬 Science & Technology · 科学・技術", "🔬", "46 kanji words", kw("""
でんき|denki|電気|electricity; electric light|विद्युत; उत्तेजना; बिजली; बिजलि की बत्ती
ばんごう|bangou|番号|number|संख्या
かがく|kagaku|科学|science|प्रक्रिया; कौशल; विषय
ぎじゅつ|gijutsu|技術|art; technology; skill|कला; तकनीकी; तकनीक; प्रौद्योगिकी; कौशल; योग्यता; प्रवीणता
けんきゅう|kenkyuu|研究|research|फिर खोज करना; अनुसन्धान; खोज करना
けんきゅうしつ|kenkyuushitsu|研究室|study room; laboratory|पढ़ाई; प्रयोगशाला; प्रयोगस्थल
すうがく|suugaku|数学|mathematics; arithmetic|गणित; गणितकार; अंकगणित; अंकगणितीय
でんとう|dentou|電灯|electric light|बिजलि की बत्ती
ばんぐみ|bangumi|番組|television or radio program|दूरदर्शन; चित्रपटल; दूर वीक्षण
うちゅう|uchuu|宇宙|universe; cosmos; space|ब्रहमाण्ड; संसार; सृष्टि/संसार/विश्व/जगत; जगत्; ब्रह्माण्ड; आकाशीय; आकाश; अन्तरिक्ष
かがく|kagaku|化学|chemistry|प्रक्रिया; रसायन शास्त्र; रहस्यमय
きかい|kikai|機械|machine; mechanism|मशीन; प्रक्रिया; यंत्रविन्यास; तरीका
かた|kata|型|mold; model; style; shape; data-type|साँचे में ढालना; का; शैली; नमूना; मडल; तैयार करना; प्रकार; बनावट; बनाना
けいさん|keisan|計算|calculation; reckoning|चाल; गणना; परिकल्पना; गणना; अनुमान; हिसाब
じっけん|jikken|実験|experiment|परीक्षा; परीक्षण करना; प्रयोग
すう|suu|数|number; figure|संख्या; नमूना; विचार करना; कल्पना करना
ていこう|teikou|抵抗|electrical resistance; resistance; opposition|विद्युत; बिजली का; बाधा; विरोधी संस्था; विरोध; बाधा; विरोध; प्रतिद्वंदी
はっけん|hakken|発見|discovery; detection; finding|आविष्कार; खोज; रहस्य; खोज; निष्कर्ष; निर्णय; जाँच परिणाम
はつめい|hatsumei|発明|invention|प्रतिभा; आविष्कार; काल्पनिक कथा
ぶつり|butsuri|物理|physics|भौतिक; भौतिक विज्ञान
かはんすう|kahansuu|過半数|majority|बहुमत; अधिकांश; वयस्कता
かいすう|kaisuu|回数|number of times; frequency|संख्या; फ्रिक्वेन्सि; आवृति; आवृत्ति
かいすうけん|kaisuuken|回数券|book of tickets|किताब
げか|geka|外科|surgical department|शल्य चिकित्सा सम्बन्धी; शल्यक; सुनिश्चितता के साथ संपादित
ぐうすう|guusuu|偶数|even number|यहाँ तक
さんすう|sansuu|算数|arithmetic|अंकगणित; अंकगणितीय
しぜんかがく|shizenkagaku|自然科学|natural science|प्राकृति विज्ञान
しゃかいかがく|shakaikagaku|社会科学|social science|सामाजिक विज्ञान; समाज विज्ञान/समाज शास्त्र
しょうすう|shousuu|小数|fraction (part of); decimal|भिन्न; थोड़ा; खंड; दशमिक; दशमलव; दशमलव अंकगणित
じんぶんかがく|jinbunkagaku|人文科学|social sciences; humanities|सामाजिक; समाजपरक; सम्मिलित; मानविकी
せいすう|seisuu|整数|integer|पूर्णांक; पूर्ण संख्या; अभिन्न अंक
たんすう|tansuu|単数|singular (number)|अनोखा; अद्वितीय; असामान्य
てんすう|tensuu|点数|marks; points; score; runs|प्राप्त करना; खरोंचना; खरोंच
でんりょく|denryoku|電力|electric power|विद्युत; विद्युत् ऊर्जा
ないか|naika|内科|internist clinic; internal medicine|भीतरी; आंतरिक; गोपनीय
はかり|hakari|秤|scales; weighing machine|तराजू; भारी वजन तौलने की मशीन; तोलने की मशीन; तोलन यंत्र
ふくすう|fukusuu|複数|plural; multiple|अनेक; एकाधिक; बहुवचन; बहुत; विविध; गुणज
まいすう|maisuu|枚数|the number of flat things|
むすう|musuu|無数|countless number; infinite number|असंख्य; असंख्य/अनगणित; बीसों; अनंत; असीम; विशाल
りか|rika|理科|science|प्रक्रिया; कौशल; विषय
あか|aka|亜科|suborder; subfamily|उपपरिवार
か|ka|科|department; section|विभाग; वर्ग; दल; काटना
がんか|ganka|眼科|ophthalmology|नेत्र विज्ञान; नैत्रिकी
きすう|kisuu|奇数|odd number|विषम; असंगत; असामयिक
げんし|genshi|原子|atom|जरा भी; परमाणु
げんばく|genbaku|原爆|atomic bomb|परमाणाविक; आणव
"""), "ja", "N4", "kanji"),

        Lesson("kw-verbs", "🏃 Verbs & Actions · 動詞・動作", "🏃", "949 kanji words", kw("""
ちがう|chigau|違う|to differ|एकमत न होना; भिन्न होना; भिन्न
ひく|hiku|引く|to pull|खींचना
のむ|nomu|飲む|to drink|पीना
およぐ|oyogu|泳ぐ|to swim|तैरना
おす|osu|押す|to push; to stamp something|धकेलना
うたう|utau|歌う|to sing|गाना
あう|au|会う|to meet|मिलना
あく|aku|開く|to open; to become open|खोलना
あける|akeru|開ける|to open|खोलना
おぼえる|oboeru|覚える|to remember|याद रखना
かえる|kaeru|帰る|to go back|बदलना; उठाना; वापस
おきる|okiru|起きる|to get up|उठना
やすむ|yasumu|休む|to rest|आराम
すう|suu|吸う|to smoke; to suck|तम्बाकू; असफलता; धूम्रपान; खींच लेना; दूध पिलाना; सोखना
いる|iru|居る|to be; to have (used for people and animals)|होना; रखना
おしえる|oshieru|教える|to teach; to tell|पढ़ाना; बताना
まがる|magaru|曲る|to turn; to bend|मोड़ना; झुकाना; बदलना; खराब
つとめる|tsutomeru|勤める|to work for someone|
みせる|miseru|見せる|to show|दिखलाना
みる|miru|見る 観る|to see; to watch|देखकर; देखना
いう|iu|言う|to say|कहना
よぶ|yobu|呼ぶ|to call out; to invite|बुलाना; सहायता के लिए बुलाना; काम बंद करने बोलना; आमंत्रित करना
ゆく|yuku|行く|to go|जाना
おりる|oriru|降りる|to get off; to descend|बंद करना; भेजना; बचना; उतरना; उतारना; नीचे उतरना
ふる|furu|降る|to fall; e.g. rain or snow|गिरना
こまる|komaru|困る|to be worried|
さす|sasu|差す|to stretch out hands; to raise an umbrella|
すわる|suwaru|座る|to sit|बैठना
さく|saku|咲く|to bloom|बहार पर आना; अरूणिमा; फूल
つくる|tsukuru|作る|to make|बनाना
とる|toru|撮る|to take a photo or record a film|
さんぽする|sanposuru|散歩|to stroll|टहलना; मंथर गति से चलना; चहल कदमी
つかう|tsukau|使う|to use|उपयोग करना
はじまる|hajimaru|始まる|to begin|शुरू करना
とまる|tomaru|止まる|to come to a halt|
しぬ|shinu|死ぬ|to die|मरना
もつ|motsu|持つ|to hold|पकड़ना
かりる|kariru|借りる|to borrow|उधार लेना
とる|toru|取る|to take something|
おわる|owaru|終る|to finish|खत्म करना
ならう|narau|習う|to learn|सीखना
すむ|sumu|住む|to live in|वहीं रहना
でかける|dekakeru|出かける|to go out|समय व्यतित करना; घायब होना; भेजना
だす|dasu|出す|to put out|अव्यवस्थित करना; उत्पन्न होना; निकलना
でる|deru|出る|to appear; to leave|दिखना; छोड़ना
かく|kaku|書く|to write|लिखना
きえる|kieru|消える|to disappear|खो; अदृश्य होना; खो जाना
けす|kesu|消す|to erase; to turn off power|दूर; निकाल देना; मिटा देना
あげる|ageru|上げる|to give|देना
のる|noru|乗る|to get on; to ride|आगे बढना; लगे रहना; जानना; चलाना; घुड़सवारी करना; चढना
たべる|taberu|食べる|to eat|खाना
ねる|neru|寝る|to go to bed; to sleep|सोना
ふく|fuku|吹く|to blow|प्रस्थान करना; बहना; फैलाना
はれる|hareru|晴れる|to be sunny|
うまれる|umareru|生まれる|to be born|
きる|kiru|切る|to cut|काटना
あらう|arau|洗う|to wash|धोना
そうじする|soujisuru|掃除|to clean; to sweep|साफ; फैलना; आसानी से चड़ना; घुमाव
はしる|hashiru|走る|to run|दौड़ना
まつ|matsu|待つ|to wait|इंतज़ार करना
かす|kasu|貸す|to lend|देना; प्रदान करना; किराये पर देना
だいすき|daisuki|大好き|to be very likeable|
ぬぐ|nugu|脱ぐ|to take off clothes|
ひく|hiku|弾く|to play an instrument with strings; including piano|सम्मिलित करते हुए; सहित
しる|shiru|知る|to know|पहचान
おく|oku|置く|to put|रखना
つく|tsuku|着く|to arrive at|पर पहुँचना; पर; पहुँचना
きる|kiru|着る|to put on from the shoulders down|
しめる|shimeru|締める|to tie|मिलाना; संबंध; लटकाना
はる|haru|貼る|to stick|सथापित करना; टेक लगाना; रखना
わたす|watasu|渡す|to hand over|सौंपना; आपूर्ति करना; आपूर्ति
わたる|wataru|渡る|to go across|
のぼる|noboru|登る|to climb|चढ़ना
こたえる|kotaeru|答える|to answer|जवाब
はたらく|hataraku|働く|to work|काम
よむ|yomu|読む|to read|पढ़ना
くもる|kumoru|曇る|to become cloudy; to become dim|
はいる|hairu|入る|to enter; to contain|प्रवेश करना; होना; रोकना; घेरना
いれる|ireru|入れる|to put in|लगाना; काम लगाना; लिखना
かう|kau|買う|to buy|खरीदना
うる|uru|売る|to sell|बेचना
つかれる|tsukareru|疲れる|to get tired|
とぶ|tobu|飛ぶ|to fly; to hop|उड़ना; एक टांग पर कूदना; कूदना; फुदकना
わかる|wakaru|分かる|to be understood|
きく|kiku|聞く|to hear; to listen to; to ask|सुनना; पूछना
ならぶ|narabu|並ぶ|to line up; to stand in a line|पंक्ति; व्यवस्था करना; शृंखला
ならべる|naraberu|並べる|to line up; to set up|पंक्ति; व्यवस्था करना; शृंखला; लगाना; दावा करना; फँसाना
しまる|shimaru|閉まる|to close; to be closed|मूंदना
しめる|shimeru|閉める|to close something|
かえす|kaesu|返す|to return something|
べんきょうする|benkyousuru|勉強|to study|पढ़ाई करना
あるく|aruku|歩く|to walk|चलना
わすれる|wasureru|忘れる|to forget|बिसराना
みがく|migaku|磨く|to brush teeth; to polish|चमकाना; चमक; रोगन करना
なくす|nakusu|無くす|to lose something|
あそぶ|asobu|遊ぶ|to play; to make a visit|खेलना
いる|iru|要る|to need|ज़रूरत
くる|kuru|来る|to come|आना
たのむ|tanomu|頼む|to ask|पूछना
たつ|tatsu|立つ|to stand|खड़ा होना
れんしゅうする|renshuusuru|練習|to practice|अभ्यास; कार्यप्रणाली; वकालत करना
はなす|hanasu|話す|to speak|बोलना
あんない|annai|案内|to guide|संचालन करना; राह दिखाना; अधिकारक
うつる|utsuru|移る|to move house or transfer|
そだてる|sodateru|育てる|to rear; to bring up|पीछे का भाग; उठाना; पिछला; बुलाना; लाना; उठाना
ひきだす|hikidasu|引き出す|to withdraw|हटाना; अलग करना; हटा लेना
ひっこす|hikkosu|引っ越す|to move house|सितारा मछली; घर बदलना
はこぶ|hakobu|運ぶ|to transport|पहुँचाना; परिवहन; सवारी
うんてん|unten|運転|to drive|चलाना
うんどう|undou|運動|to exercise|व्यायाम
えんりょ|enryo|遠慮|to be reserved; to be restrained|
よごれる|yogoreru|汚れる|to get dirty|
さげる|sageru|下げる|to hang; to lower; to move back|लटकना; टाम्गना; छाना; छोटा; कम करना; गिरना
おりる|oriru|下りる|to get off|बंद करना; भेजना; बचना
さがる|sagaru|下る|to get down; to descend|उतरना; किसी कार्य में ध्यान लगाना; निराशित करना; उतरना; उतारना; नीचे उतरना
すぎる|sugiru|過ぎる|to exceed|अधिक होना; पार कर जाना; अतिक्रमण करना
まわる|mawaru|回る|to go around|
こわす|kowasu|壊す|to break|तोड़ना
こわれる|kowareru|壊れる|to be broken|
あく|aku|開く|to open an event|
たのしむ|tanoshimu|楽む|to enjoy oneself|
かける|kakeru|掛ける|to hang something|
われる|wareru|割れる|to break|तोड़ना
すべる|suberu|滑る|to slide; to slip|खीसकाना; फिसलना; फिसलन; निकालना; गिरना; जाना
かむ|kamu|噛む|to bite; to chew|परेशान करना; स्वीकार करना; व्यक्त करना; सोचना; गोली; चबाना
かわく|kawaku|乾く|to get dry|
なれる|nareru|慣れる|to grow accustomed to|
まにあう|maniau|間に合う|to be in time for|
まちがえる|machigaeru|間違える|to make a mistake|
よろこぶ|yorokobu|喜ぶ|to be delighted|
よる|yoru|寄る|to visit|दौरा करना
いのる|inoru|祈る|to pray|प्रार्थना करना
おこす|okosu|起す|to wake|जागना
いそぐ|isogu|急ぐ|to hurry|जल्दी करना
なく|naku|泣く|to weep|बहना; रोना; विलाप करना
おどろく|odoroku|驚く|to be surprised|
あく|aku|空く|to open; to become empty|खोलना
けいけん|keiken|経験|to experience|अनुभव करना; अनुभव; अनुभूति
けいかく|keikaku|計画|to plan|योजना
むかえる|mukaeru|迎える|to go out to meet|
きめる|kimeru|決める|to decide|निर्णय लेना
きまる|kimaru|決る|to be decided|
たてる|tateru|建てる|to build|बनाना
みえる|mieru|見える|to be in sight|
みつかる|mitsukaru|見つかる|to be discovered|
みつける|mitsukeru|見つける|to discover|पता; समझना; पता लगाना
こしょう|koshou|故障|to break-down|
ひかる|hikaru|光る|to shine; to glitter|चमकाना; चमक; प्रकाशित होना; चमक; चमकना; तड़क भड़क
むかう|mukau|向かう|to face|मुँह पर
かんがえる|kangaeru|考える|to consider|विचार करना; समझना; ग़ौर
おこなう|okonau|行う|to do|करना
ふりだす|furidasu|降り出す|to start to rain|
あう|au|合う|to match|मिलना; जोड़िदार; जोड़ा बन्ना
こむ|komu|込む|to be crowded|
すむ|sumu|済む|to finish|खत्म करना
のこる|nokoru|残る|to remain|रहना; बाकी रहना; भग्नावशेष
はじめる|hajimeru|始める|to begin|शुरू करना
おもいだす|omoidasu|思い出す|to remember|याद रखना
おもう|omou|思う|to think; to feel|विचार करना; महसूस करना
したく|shitaku|支度|to prepare|तैयार करना
やむ|yamu|止む|to stop|रुकना
やめる|yameru|止める|to stop something|
にる|niru|似る|to be similar|
なおる|naoru|治る|to be cured; to heal|भरना; स्वस्थ होना
うつす|utsusu|写す|to copy or photograph|
すてる|suteru|捨てる|to throw away|गँवाना; बर्बाद कर देना; जानबूझकर लापरवाही से बोलना
あやまる|ayamaru|謝る|to apologize|क्षमा मांगना
とりかえる|torikaeru|取り替える|to exchange|करना; बदल देना; केन्द्र
てつだう|tetsudau|手伝う|to assist|मदद करना; सहायता देना; सुविधा देना
うける|ukeru|受ける|to take a lesson or test|
ひろう|hirou|拾う|to pick up; to gather|पाना; रोकना; सुधार आना; प्राप्त करना; समझना; काटना
あつめる|atsumeru|集める|to collect something|
あつまる|atsumaru|集る|to gather|प्राप्त करना; समझना; काटना
しゅっせき|shusseki|出席|to attend|ध्यान केंद्रित करना; साथ जाना; पर ध्यान देना
しゅっぱつ|shuppatsu|出発|to depart|से हटना; प्रस्ठान करना; छूटना
じゅんび|junbi|準備|to prepare|तैयार करना
かつ|katsu|勝つ|to win|जीतना
しょうち|shouchi|承知|to consent|स्वीकृति; सहमति; अनुमति देना
しょうたい|shoutai|招待|to invite|आमंत्रित करना
やく|yaku|焼く|to bake; to grill|गर्म करना; तैयार; तैयार करना; भूनना; जाली; प्रश्न पूछना
やける|yakeru|焼ける|to burn; to be roasted|करना; दाग; ख़र्च करना
わらう|warau|笑う|to laugh; to smile|हँसना; मुस्कान
あがる|agaru|上る|to rise|उदय होना; निकलना; चढना
のりかえる|norikaeru|乗り換える|to change between buses or trains|
かざる|kazaru|飾る|to decorate|पदक प्रदान करना; सजाना; दीवारी कागज़
うえる|ueru|植える|to plant; to grow|पौधा; उगना
さわる|sawaru|触る|to touch|छूना
しょくじ|shokuji|食事|to have a meal|
しんぱい|shinpai|心配|to worry|चिंता
すすむ|susumu|進む|to make progress|
たずねる|tazuneru|尋ねる|to ask|पूछना
せわ|sewa|世話|to look after|देखभाल करना; सँभालना; पर ध्यान रखना
いきる|ikiru|生きる|to live|जीना
せいかつ|seikatsu|生活|to live|जीना
せいさん|seisan|生産|to produce|उत्पादन करना
おる|oru|折る|to break or to fold|
おれる|oreru|折れる|to break or be folded|
えらぶ|erabu|選ぶ|to choose|चुनना
やせる|yaseru|痩せる|to become thin|
そうだん|soudan|相談|to discuss|विचार करना; विचार; बहस करना
おくる|okuru|送る|to send|भेजना
さわぐ|sawagu|騒ぐ|to make noise; to be excited|
ふえる|fueru|増える|to increase|वृद्धि करना; बढ़ाना; विस्तार
たす|tasu|足す|to add a number|
たりる|tariru|足りる|to be enough|
つづく|tsuzuku|続く|to be continued|
つづける|tsuzukeru|続ける|to continue|होना; शुरू; रखना
ふとる|futoru|太る|to become fat|
うつ|utsu|打つ|to hit|मारना
たいいん|taiin|退院|to leave hospital|
さがす|sagasu|探す|to look for|ढूँढना
しらせる|shiraseru|知らせる|to notify|सूचित करना; सूचना देना
おくれる|okureru|遅れる|to be late|में देर लगाना
しらべる|shiraberu|調べる|to investigate|पता लगाना; अनुसंधान करना; सोच विचार करना
なおす|naosu|直す|to fix; to repair|बदला लेना; लगाना; निश्चित करना; जमाव; मरम्मत; सुधार
なおる|naoru|直る|to be fixed; to be repaired|
かよう|kayou|通う|to commute|बदल देना; बस में सवार करना; कम कर देना
とおる|tooru|通る|to go through|सहना; पूरा करना; अच्छी तरह से प्रयोग करना
つける|tsukeru|漬ける|to soak; to pickle|फैल जाना; डुबाव; भिगोना; चटनी; अचार; अचार बनाना
つる|tsuru|釣る|to fish|मछली
つたえる|tsutaeru|伝える|to report|बताना; विवरण; सूचना
ぬる|nuru|塗る|to paint; to plaster|रंग; चिपकाना; प्लास्टर; पलस्तर करना
おこる|okoru|怒る|to get angry; to be angry|
たおれる|taoreru|倒れる|to break down|टूट जाना; खराब हो जाना; तोड़ देना
なげる|nageru|投げる|to throw or cast away|
ぬすむ|nusumu|盗む|to steal|चुराना
ふむ|fumu|踏む|to step on|
にげる|nigeru|逃げる|to escape|राहत; बचाव; भाग जाना
うごく|ugoku|動く|to move|हिलना
とどける|todokeru|届ける|to reach|पाना; फैलना; फैलाना
にゅういん|nyuuin|入院|to hospitalise|अस्पताल में दाखिल करना; अस्पताल
にゅうがく|nyuugaku|入学|to enter school or university|
とまる|tomaru|泊まる|to lodge at|
くらべる|kuraberu|比べる|to compare|वर्णन करना; तुलना करना; विचार विनिमय करना
つく|tsuku|付く|to be attached|
まける|makeru|負ける|to lose|खोना
はらう|harau|払う|to pay|भुगतान करना
わかす|wakasu|沸かす|to boil; to heat|गुस्सा; उबालना; गरम करना; गर्मी
わく|waku|沸く|to boil; to grow hot; to get excited|गुस्सा; उबालना; गरम करना
きこえる|kikoeru|聞こえる|to be heard|
わかれる|wakareru|別れる|to separate|रोकना; निकालना; भिन्न
かえる|kaeru|変える|to change|बदलना
かわる|kawaru|変わる|to change|बदलना
かたづける|katazukeru|片付ける|to tidy up|ठीक ठाक करना
つかまえる|tsukamaeru|捕まえる|to seize|समझना; झपट लेना; पकड़ना
くれる|kureru|暮れる|to get dark; to come to an end|
つつむ|tsutsumu|包む|to wrap|समाप्त करना; गाउन; लपेटना
ほうそう|housou|放送|to broadcast|फैलाना; गाना; प्रचार करना
たずねる|tazuneru|訪ねる|to visit|दौरा करना
なくなる|nakunaru|亡くなる|to die|मरना
ねむる|nemuru|眠る|to sleep|सोना
なくなる|nakunaru|無くなる|to disappear; to get lost|खो; अदृश्य होना; खो जाना; दफा होना
なる|naru|鳴る|to sound|आवाज़
もどる|modoru|戻る|to turn back|वापस आना; पीछे लौटना; पीछे लौटाना
やくにたつ|yakunitatsu|役に立つ|to be helpful|
ゆしゅつ|yushutsu|輸出|to export|निर्यात करना; निर्यात
ゆにゅう|yunyuu|輸入|to import|महत्व; आयात; बुलाया जानाना
ゆれる|yureru|揺れる|to shake; to sway|झटका; घुमाना; मिलाना; आधिपत्य; प्रभाव; प्रभावित करना
おどる|odoru|踊る|to dance|नाचना
おとす|otosu|落す|to drop|गिराना
おちる|ochiru|落る|to fall or drop|
たてる|tateru|立てる|to stand something up|
ひえる|hieru|冷える|to grow cold|
つれる|tsureru|連れる|to lead|नमूना; प्रमुख; राय देना
あいする|aisuru|愛する|to love|प्यार
にぎる|nigiru|握る|to grasp; to seize; to mould sushi|समझना; पाने का प्रयत्न; समझ; समझना; झपट लेना; पकड़ना
あつかう|atsukau|扱う|to handle; to deal with; to treat|स्पर्श करना; व्यवहार करना; उपाधि; व्यापार; व्यापार करना; बर्ताव करना; देना; व्यवहार करना; विवेचन करना
かこむ|kakomu|囲む|to surround; to encircle|किनारा; भरा होना; चारों ओर होना; घेरना
なる|naru|為る|to change; to be of use; to reach to|बदलना
ことなる|kotonaru|異なる|to differ; to vary; to disagree|एकमत न होना; भिन्न होना; भिन्न; बदलना; भिन्न होना; परिवर्तित करना; भिन्न होना; असहमत होना; असहमत
うつす|utsusu|移す|to remove; to transfer; to infect|निकालना; हटाना; श्रेणी; सौंपना; स्थानान्तरित करना; स्थानान्तरण; इनफेक्ट करना; दूषित करना; प्रभावित करना
そだつ|sodatsu|育つ|to raise (child); to be brought up; to grow (up)|करना; निकालना; उत्तेजित करना; उगना
かくす|kakusu|隠す|to hide; to conceal|गुप्त रखना; छिपने की जगह; छिपा देना; छिपाना
かくれる|kakureru|隠れる|to hide; to be hidden; to conceal oneself; to disappear|गुप्त रखना; छिपने की जगह; छिपा देना
こえる|koeru|越える|to exceed; to cross over; to cross|अधिक होना; पार कर जाना; अतिक्रमण करना; बदलना; पार करना
こす|kosu|越す|to go over (e.g. with audience)|बदलना; चलना; छानबीन करना
おうじる|oujiru|応じる|to respond; to satisfy; to accept; to comply with; to apply for|प्रत्युत्तर देना; बदले मे कुछ करना या कहना; उत्तर देना; शांत करना; आपूर्ति करना; पूरा करना; स्वीकार करना
よこぎる|yokogiru|横切る|to cross (e.g. arms); to traverse|पार करना; तय करना; पार करना; फैला होना
おろす|orosu|下す|to lower; to let go down|छोटा; कम करना; गिरना
くわえる|kuwaeru|加える|to append; to sum up; to add (up)|जोड़ना; खुलासा बयान करना; सार होना; सारांश; जोड़ना
くわわる|kuwawaru|加わる|to join in; to accede to; to increase; to gain in (influence)|शामिल होना; शामिल होना होना; वृद्धि करना; बढ़ाना; विस्तार
かせぐ|kasegu|稼ぐ|to earn income; to labor|जी तोड़ कोशिश करना; मजदूर वर्ग; श्रमजीवी वर्ग
すごす|sugosu|過ごす|to pass; to spend; to go through; to tide over|पास करना; खर्च करना; सहना; पूरा करना; अच्छी तरह से प्रयोग करना
とく|toku|解く|to unfasten|खोलना; खुलना
とける|tokeru|解ける|to come untied; to come apart|टुकड़े टुकड़े होकर आना
まわす|mawasu|回す|to turn; to revolve|मोड़ना; घूमना; परिभ्रमण; अच्छी तरह से
はずす|hazusu|外す|to unfasten; to remove|खोलना; खुलना; निकालना; हटाना; श्रेणी
たしかめる|tashikameru|確かめる|to ascertain|पता लगाना; सुनिश्चित करना; जाँच कर पता लगाना
さます|samasu|覚ます|to awaken|उठाना; जगाना; जागना
さめる|sameru|覚める|to wake; to wake up|जागना; उठाना; सतर्क रहना; जगाना
まなぶ|manabu|学ぶ|to study (in depth); to learn; to take lessons in|पढ़ाई करना; सीखना
かかる|kakaru|掛かる|to take (e.g. time; money; etc); to hang|पैसा; आदि
わる|waru|割る|to divide; to cut; to break; to halve|विभाजित; फैल जाना; अलग करना; काटना; तोड़ना
かる|karu|刈る|to cut (hair); to mow (grass); to harvest|काटना; घास काटना; फसल कटाई का समय; फसल; फसल एकत्र
すすめる|susumeru|勧める|to recommend; to advise; to encourage; to offer (wine)|सिफारिश; प्रशंसा करना; आकर्षक बनाना; सूचित करना; सूचना देना; सुझाव देना; प्रोत्साहित; उत्तेजित करना; उकसाना
かんじる|kanjiru|感じる|to feel; to sense; to experience|महसूस करना; दिशा; होश; ज्ञान; अनुभव करना; अनुभव; अनुभूति
かえる|kaeru|換える|to exchange; to interchange; to substitute; to replace|करना; बदल देना; केन्द्र; बदल देना; इंटरचेंज; अदला बदली करना; स्थानापन्न व्यक्ति; स्थानापन्न; एवजी
かんする|kansuru|関する|to concern; to be related|अभिरुचि; दिलचस्पी; संबंध
ふくむ|fukumu|含む|to hold in the mouth; to bear in mind|याद रखना
ねがう|negau|願う|to desire; to wish; to request|इच्छा; चाहना; तृष्णा; इच्छा; विनती करना; अनुरोध करना; आवेदन
もとづく|motozuku|基づく|to be grounded on; to be based on; to be due to; to originate from|
きにいる|kiniiru|気に入る|to be pleased with; to suit|प्रणय निवेदन; सूट; के लिये ठीक होना
きづく|kizuku|気付く|to notice; to recognize; to become aware of|सूचना; चेतावनी; देखना; स्वीकार करना; प्रकट करना; पहचानना
おこる|okoru|起こる|to occur; to happen|घटना; होना; घटित होना; घटित होना
かがやく|kagayaku|輝く|to shine; to glitter; to sparkle|चमकाना; चमक; प्रकाशित होना; चमक; चमकना; तड़क भड़क; चमक; जोश; चमकना
うたがう|utagau|疑う|to doubt; to distrust; to be suspicious of; to suspect|संदेह करना; पर संदेह करना; पर शंका होना; धोखा; शंका; अविश्वास करना/संदेह करना
つめる|tsumeru|詰める|to pack; to shorten; to work out (details)|समूह; दल; वृंद; कम करना; संक्षिप्त करना; छोटा करना; सितारा मछली; समझना; निकलना
さからう|sakarau|逆らう|to go against; to oppose; to disobey; to defy|उल्लंघन करना; प्रतिकूल होना; रोकना; मुकाबले पर रखना; विरोध करना; आज्ञा न मानना; आज्ङा का उल्लंघन करना; आज्ङा
およぼす|oyobosu|及ぼす|to exert; to cause; to exercise|जोर; काम में लाना; बल लगाना; करना; कारण बनना; देना; व्यायाम
すくう|sukuu|救う|to rescue from; to help out of|
もとめる|motomeru|求める|to seek; to request; to demand; to want; to wish for; to search for; to pursue (pleasure); to hunt (a job)|कोशिश करना; की कोशिश करना; पतालगाना; विनती करना; अनुरोध करना; आवेदन; दावा करना; मांग; चाह
さる|saru|去る|to leave; to go away|छोड़ना
いる|iru|居る|to be (animate); to be; to exist|होना; होना; होना; रहना; जीवित रहना
ゆるす|yurusu|許す|to permit; to allow; to approve|परमिट; अनुमति देना; अनुमति; स्वीकार करना; मिलना; देना; स्वीकार करना; पसन्द करना; पसंद करना
さけぶ|sakebu|叫ぶ|to shout; to cry|बुलाना; चीखना; चिल्लाना; रोना
おそれる|osoreru|恐れる|to fear; to be afraid of|डर
くるう|kuruu|狂う|to go mad; to get out of order|
くるしむ|kurushimu|苦しむ|to suffer; to groan; to be worried|भुगतना; कराहना; आह
くりかえす|kurikaesu|繰り返す|to repeat; to do something over again|पुनराव्रत्ति; पहले के समान भेजा हुआ नया; पुनरावृत्ति
たつ|tatsu|経つ|to pass; to lapse|पास करना; समाप्ति; खत्म हो जाना; चूक
つなぐ|tsunagu|繋ぐ|to tie; to fasten; to connect; to transfer (phone call)|मिलाना; संबंध; लटकाना; थोपना; अटकाना; निर्धारित करना; मिलाना; जुड़ा; लगना
はかる|hakaru|計る|to measure; to weigh; to survey|ताल; मर्यादा; काफ़ी; विचार करना; उठाना; नापना; दर्शाना; सर्वेक्षण; सर्वेक्षण करना
うつ|utsu|撃つ|to attack; to defeat; to destroy|हमला; विफल कर देना; रोकना; हराना; दूर; हराना; नष्ट करना
かける|kakeru|欠ける|to be lacking|कम होना
むすぶ|musubu|結ぶ|to tie; to bind; to link|मिलाना; संबंध; लटकाना; लगाना; चिन्ह; भरना; सम्पर्क; सम्बन्ध; शृंखला
きらう|kirau|嫌う|to hate; to dislike; to loathe|घृणा करना; घृणा; द्वेष; घृणा; नापसंद करना; द्वेष; घृणा करना; नफ़रत करना
みる|miru|見る|to see; to watch|देखकर; देखना
へらす|herasu|減らす|to abate; to decrease; to diminish; to shorten|कम करना; शांत करना; समाप्त करना; घटना; कम करना; घटाना; कम करना; घटाना; कम हो जाना
へる|heru|減る|to decrease (in size or number); to diminish; to abate|घटना; कम करना; घटाना; कम करना; घटाना; कम हो जाना; कम करना; शांत करना; समाप्त करना
あらわす|arawasu|現す|to show; to indicate; to display|दिखलाना; दिखाना; सूचित करना; संकेत; बताना; प्रदर्शन; दिखाना
いう|iu|言う|to say|कहना
かぎる|kagiru|限る|to restrict; to limit; to confine|बाधित करना; सीमित करना; परिमित/सीमित करना; मर्यादा; हद; सीमा; कैद रखना; सीमा; सीमीत रखना
やとう|yatou|雇う|to employ; to hire|नियुक्त करना; नौकर; नौकरी; किराया/भाड़ा; भाड़ेपर देना; मजदूरी पर रखना/किराये पर लेना
かたる|kataru|語る|to talk; to tell; to recite|बात करना; बताना; दोहराना
きく|kiku|効く|to be effective|
むく|muku|向く|to face|मुँह पर
むける|mukeru|向ける|to turn towards; to point|बिंदु
このむ|konomu|好む|to like; to prefer|पसंद करना; पसन्द करना; तरक्की देना; पसंद करना
ひろがる|hirogaru|広がる|to spread (out); to extend; to stretch; to reach to; to get around|फैलना; प्रकार; फैलाना; फैलना; फैलाना; देना; फैलाना; फैल जाना; पंक्ति
かまう|kamau|構う|to mind; to care about; to be concerned about|मन
おろす|orosu|降ろす|to take down; to launch; to drop|लिखना; उतारना; नीचे उतारना; प्रारंभ करना; छोडना; आरम्भ करना; गिराना
あわせる|awaseru|合わせる|to join together; to be opposite; to face; to unite|मुँह पर
すませる|sumaseru|済ませる|to be finished|
ころす|korosu|殺す|to kill|मारना
のこす|nokosu|残す|to leave (behind; over); to bequeath; to save; to reserve|पीछे छोड़ना; बहुत उन्नति करना; फीछे छोड़ना; ऊपर; वसीयत करना
さす|sasu|指す|to point; to put up umbrella; to play|बिंदु; खेलना
ささえる|sasaeru|支える|to be blocked; to choke; to be obstructed|चोक; सांस; सांस रूकना
しはらう|shiharau|支払う|to pay|भुगतान करना
よす|yosu|止す|to cease; to abolish; to resign; to give up|बन्द करना; बन्द; अन्त होना; हटाना; मिटा देना; उन्मूलन करना; इस्तीफा देना; सुपुर्द करना; छोड़ देना
いたる|itaru|至る|to come; to arrive|आना; पहुँचना
ためす|tamesu|試す|to attempt; to test|प्रयास; प्रयत्न; कोशिश करना; परीक्षा
かう|kau|飼う|to keep; to raise; to feed|रखना; करना; निकालना; उत्तेजित करना; खिलाना
にあう|niau|似合う|to suit; to match; to become; to be like|प्रणय निवेदन; सूट; के लिये ठीक होना; मिलना; जोड़िदार; जोड़ा बन्ना; बनना
持ち上げる||持ち上げる|to raise; to lift up; to flatter|करना; निकालना; उत्तेजित करना; चापलूसी करना; रौशन होना[करना]; खुश होना
しめす|shimesu|示す|to denote; to show; to point out; to indicate|सूचित करना; सूचित; बतलाना; दिखलाना; दिखाना; निकालना; ध्यान दिलाना
やめる|yameru|辞める|to retire|बाहर निकल; अवकाश लेना; पीछे हटना
しかる|shikaru|叱る|to scold|फटकारना; डाँटना; किसी पर गुस्सा होना या डाटना
うしなう|ushinau|失う|to lose; to part with|खोना; खर्च करना
取り上げる||取り上げる|to take up; to pick up; to disqualify; to confiscate; to deprive|टोकना; स्वीकार करना; उठाना; पाना; रोकना; सुधार आना; अयोग्य; अयोग्य ठहराना; अनर्हकरण
とれる|toreru|取れる|to come off; to be taken off; to be removed|होना; निकलना; सफल एवं प्रभावशाली होना
まもる|mamoru|守る|to protect; to obey; to guard; to abide (by the rules)|रक्षा करना; पालन करना; निभाना; कहना; पहरेदार; बचाव; रक्षण करना
うけとる|uketoru|受け取る|to receive; to get; to accept; to take|प्राप्त करना; पाना; स्वीकार करना
おさめる|osameru|収める|to obtain; to reap; to pay; to supply; to accept|पाना; प्राप्त करना; हाशिल करना; प्राप्त करना; जैसी करनी वैसी भरनी; काटना; भुगतान करना
つく|tsuku|就く|to settle in (place); to take (seat; position); to study (under teacher)|जमना; दृष्टिकोण; प्रतिष्ठा; पद
おえる|oeru|終える|to finish|खत्म करना
したがう|shitagau|従う|to abide (by the rules); to obey; to follow; to accompany|सहना; रहना; निवास करना; पालन करना; निभाना; कहना; लाओ; इसके बाद में
いわう|iwau|祝う|to congratulate; to celebrate|बधाई देना; बधाई; मनाना; पादरी का कार्य; प्रचार करना
であう|deau|出会う|to meet by chance; to come across; to happen to encounter|संयोग से मिलना; अचानक मिलना; समझ में आना
のべる|noberu|述べる|to state; to express; to mention|बताना; व्यक्त करना; अभिव्यक्त करना; बताना; प्रकट; प्रकट करना; चर्चा; कहना; उल्लेख करना
たすける|tasukeru|助ける|to help; to save; to rescue|मदद; बचाना; राहत; बचाना; बचाव
のぞく|nozoku|除く|to remove; to exclude; to except|निकालना; हटाना; श्रेणी; निकालना; छोड़ना; छोड़ देना; सिवाय
まねく|maneku|招く|to invite|आमंत्रित करना
のぼる|noboru|昇る|to arise; to ascend; to go up|उदय होना; उत्पन्न होना; निकलना; चढना; बढना/चढ़ना; उपर उठना; जाना; उठना; नष्ट होना
はぶく|habuku|省く|to omit; to eliminate; to curtail; to economize|हटाना; छोड जाना; छोड़ देना; निकालना; हटाना; हटा देना; कम करना; कम
のせる|noseru|乗せる|to place on (something); to take on board; to give a ride|स्वीकार करना
ゆずる|yuzuru|譲る|to turn over; to assign; to hand over|उलट देना; चालू करना; उलट जाना; निश्चित करना; देना; नियुक्त करना; सौंपना; आपूर्ति करना; आपूर्ति
ふれる|fureru|触れる|to touch; to be touched; to touch on a subject; to feel; to violate (law; copyright; etc.); to perceive; t|छूना
のばす|nobasu|伸ばす|to lengthen; to stretch; to reach out; to grow (beard)|लम्बा करना; लम्बा; फैलाना; फैल जाना; पंक्ति
のびる|nobiru|伸びる|to stretch; to extend; to make progress; to grow (beard; body height)|फैलाना; फैल जाना; पंक्ति; फैलना; फैलाना; देना
しんじる|shinjiru|信じる|to believe; to place trust in|विश्वास करना
もうしこむ|moushikomu|申し込む|to apply for; to make an application|
すすめる|susumeru|進める|to advance; to promote; to hasten|अग्रसर होना; आगे बढना; प्रयास; सहायता करना; प्रचार करना; विक्री करना; जल्दी करना; जल्दी कहना
ふるえる|furueru|震える|to shiver; to shake; to quake|ठिठुरना; झटका; घुमाना; मिलाना; हिलना; कम्पन; थरथराहट
よう|you|酔う|to get drunk; to become intoxicated|
かぞえる|kazoeru|数える|to count|गिनना
なる|naru|成る|to become|बनना
しょうじる|shoujiru|生じる|to produce; to yield; to result from; to arise; to be generated|उत्पादन करना; बताना; स्वीकार करना; देना; के परिणामस्वरूप; के कारण घटिट; के कारण घटिट होना
つもる|tsumoru|積もる|to pile up|जमा करना; दुर्घटना; इकट्ठा करना
せめる|semeru|責める|to condemn; to blame; to criticize|घोषित करना; दोष लगाना; निंदा करना; आरोप; दोष; दोष लगाना; मीन; समीक्षा करना; मीन मेख निकालना
たたかう|tatakau|戦う|to fight; to battle; to combat|लड़ना; लड़ाई/युध्द; सामना करना; कोशिश करना; विरोध करना; युद्ध; युद्ध करना
くむ|kumu|組む|to put together|बनाना; कुल मिलाकर; जोड्ॅअना
うったえる|uttaeru|訴える|to sue (a person); to resort to; to appeal to|औपचारिक रूप से निवेदन करना; नालिश करना; नालिश; की सहायता लेना; ना; सहारा लेना
ます|masu|増す|to increase; to grow|वृद्धि करना; बढ़ाना; विस्तार; उगना
おくる|okuru|贈る|to send; to give to; to award to; to confer on|भेजना
うつ|utsu|打つ|to hit; to strike|मारना; बजना; आक्रमण; निकालना
たいする|taisuru|対する|to face; to confront; to oppose|मुँह पर; सामना होना; सामना; सामना करना; रोकना; मुकाबले पर रखना; विरोध करना
なまける|namakeru|怠ける|to be idle; to neglect|उपेक्षा करना; लापरवाही; उपेक्षा
かえる|kaeru|替える|to exchange; to interchange; to substitute; to replace|करना; बदल देना; केन्द्र; बदल देना; इंटरचेंज; अदला बदली करना; स्थानापन्न व्यक्ति; स्थानापन्न; एवजी
たたく|tataku|叩く|to strike; to clap; to dust; to beat|बजना; आक्रमण; निकालना; ताली; तालियाँ बजाकर अभिनंदन करना; गड़गड़ाहट; पोंछना; लाश; मिट्टी
たっする|tassuru|達する|to reach; to get to|पाना; फैलना; फैलाना
うばう|ubau|奪う|to snatch away|चीलझडप
ことわる|kotowaru|断る|to refuse; to decline; to dismiss|अग्राह्य; अस्वीकार करना; इंकार; घटना; गिरावट; कम; अस्वीकार करना; निकाल देना; बरखास्त करना
つぐ|tsugu|注ぐ|to pour (into); to irrigate; to pay; to fill; to feed (e.g. a fire)|बहना; निकालना; देना; सीँचना; भुगतान करना
はる|haru|張る|to stick; to paste|सथापित करना; टेक लगाना; रखना; चिपकाना; लेई; सटाना
ながめる|nagameru|眺める|to view; to gaze at|दृष्टिकोण; विचार करना; समझना
いただく|itadaku|頂く|to receive; to take food or drink (hum)|प्राप्त करना
しずむ|shizumu|沈む|to sink; to feel depressed|घटना; होना; निकालना
おいつく|oitsuku|追い付く|to overtake; to catch up (with)|में अड़्चन पैदा करना; संख्या का बढ़ना; तेजी से उन्नति करना; पक़अ लेना
おう|ou|追う|to chase; to run after|आखेट; पाना; लंबी; के पीछे दौड़ना; पीछा करना; के पीछे पड़ा रहना
つうじる|tsuujiru|通じる|to run to; to lead to; to communicate; to understand|पैसे के अभाव में होना; पहुँचना; कारण बनना; में परिणत होना; फैलाना; व्यक्त करना; पहुँचाना
とおす|toosu|通す|to let pass; to overlook; to continue|के उपर से दिखना; अन्देकी करना; क्षमा; होना; शुरू; रखना
通り過ぎる||通り過ぎる|to pass; to pass through|पास करना; गुजरना
つかむ|tsukamu|掴む|to seize; to catch; to grasp|समझना; झपट लेना; पकड़ना; पकड़ना; समझना; पाने का प्रयत्न; समझ
あきらめる|akirameru|諦める|to give up; to abandon|त्याग देना; छोडना; हार मान लेना; रोक देना; खाली करना; रोक
てきする|tekisuru|適する|to fit; to suit|संगत; स्वस्थ; उचित; प्रणय निवेदन; सूट; के लिये ठीक होना
おぼれる|oboreru|溺れる|to be drowned; to indulge in|
ころぶ|korobu|転ぶ|to fall down; to fall over|नीचे गिरना; गलत साबित करना; गलत; गिर पड़ना
たおす|taosu|倒す|to throw down; to beat; to bring down; to blow down|खटखटाना; ताल; परास्त कर देना; रोकना; कम करना; मार गिराना
こおる|kooru|凍る|to freeze; to be frozen over; to congeal|जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना
あたる|ataru|当たる|to be hit; to be successful; to be equivalent to|
あてる|ateru|当てる|to hit; to apply a patch|मारना
うごかす|ugokasu|動かす|to move; to shift|हिलना; कार्य पाली; परिवर्तन; लगाना
うる|uru|得る|to get; to gain; to win|पाना; पाना; प्राप्त करना; मिलना; जीतना
とどく|todoku|届く|to reach|पाना; फैलना; फैलाना
まかせる|makaseru|任せる|to entrust to another; to leave to|
みとめる|mitomeru|認める|to recognize; to appreciate; to approve; to admit; to notice|स्वीकार करना; प्रकट करना; पहचानना; क़दर करना; प्रशंसा करना; महसूस करना; स्वीकार करना; पसन्द करना; पसंद करना
ぬれる|nureru|濡れる|to get wet|
もえる|moeru|燃える|to burn|करना; दाग; ख़र्च करना
なやむ|nayamu|悩む|to be worried; to be troubled|
やぶる|yaburu|破る|to tear; to violate; to defeat; to smash; to destroy|करना; आँसू; खींच लेना; अनादर करना; अपवित्र करना; उल्लंघन करना; विफल कर देना; रोकना; हराना
うれる|ureru|売れる|to be sold|
ばっする|bassuru|罰する|to punish; to penalize|दण्ड देना; धावा बोलना; सजा देना; दण्ड़ित करना; दण्ड देना; दण्डनीय ठहराना
ぬく|nuku|抜く|to extract; to omit; to surpass; to draw out; to unplug|निकालना; सार; अवतरण; हटाना; छोड जाना; छोड़ देना; से बेहतर परिणाम देना; के परे होना; मात कर देना
ぬける|nukeru|抜ける|to come out; to fall out; to be omitted|निकालना; निकलना; बनना; झगड़ना; विच्छेद; झड़ना
かなしむ|kanashimu|悲しむ|to be sad; to mourn for; to regret|दुःखी होना; खेद होना; पश्चाताप करना
かぶる|kaburu|被る|to suffer|भुगतना
とばす|tobasu|飛ばす|to skip over; to omit|हटाना; छोड जाना; छोड़ देना
とびだす|tobidasu|飛び出す|to jump out; to rush out; to fly out|थोप देना; छापना
そなえる|sonaeru|備える|to furnish; to provide for; to equip; to install|सुस्सजित करना; प्रस्तुत करना; देना{आवश्यक सामग्री}; भरण पोषण करना; व्यवस्था करना; संभव बनाना; समर्थ बनाना; समर्थ; सज्जित करना
ほほえむ|hohoemu|微笑む|to smile|मुस्कान
あらわす|arawasu|表す|to express; to show; to reveal|बताना; प्रकट; प्रकट करना; दिखलाना; बताना; दिखाना; प्रकट करना
かく|kaku|描く|to draw; to paint; to sketch; to depict; to describe|चित्र बनाना; रंग; खाका; संक्षिप्त विवरण; व्यंग्यचित्र
つける|tsukeru|付ける|to attach; to join; to add; to append|लगाना; देना; संलग्न; शामिल होना; जोड़ना
くさる|kusaru|腐る|to rot; to go bad|सड़ाना; सड़ना
おおう|oou|覆う|to cover; to hide; to conceal; to wrap; to disguise|ढकना; गुप्त रखना; छिपने की जगह; छिपा देना; छिपाना
わける|wakeru|分ける|to divide; to separate|विभाजित; फैल जाना; अलग करना; रोकना; निकालना; भिन्न
とじる|tojiru|閉じる|to close (e.g. book; eyes); to shut|चक्षु; आँखें; नैना; निकाल देना; अटकाना; बन्द करना
つかまる|tsukamaru|捕まる|to be caught; to be arrested|
くらす|kurasu|暮らす|to live; to get along|जीना; आगे बढना; मिलजुल कर रहना
かかえる|kakaeru|抱える|to hold or carry under or in the arms|
はなす|hanasu|放す|to separate; to set free|रोकना; निकालना; भिन्न
ほめる|homeru|褒める|to praise; to admire; to speak well|प्रशंसा; स्तुति; कीर्ति; समादर करना; प्रशंसा करना; सराहना करना
あきる|akiru|飽きる|to get tired of; to lose interest in; to have enough|
のぞむ|nozomu|望む|to desire; to wish for; to see; to command (a view of)|इच्छा; चाहना; तृष्णा; देखकर
ふせぐ|fusegu|防ぐ|to defend (against); to protect; to prevent|चलाना; बचाना; प्रतिवाद; रक्षा करना; प्रतिबन्ध करना
ほえる|hoeru|吠える|to bark; to bay; to howl; to bellow; to roar; to cry|गरजना; चिल्लाना; भूँकना; भोंक; रोना; कुत्तों की एक विशेष प्रकार की भौँक; चिल्लाना; चिल्लाहट; जोर से चीखना
みちる|michiru|満ちる|to be full; to rise (tide); to mature; to expire|उदय होना; निकलना; चढना; पका हुआ; पूर्ण विकसित; परिपक्व
めいじる|meijiru|命じる|to order; to command; to appoint|आदेशानुसार; मंगवाना; पाना; प्राप्त करना; देना; बनाना; नियुक्त करना; निर्धारित करना
あける|akeru|明ける|to dawn; to become daylight|होना; निकलना; सामने आना
だまる|damaru|黙る|to be silent|
もどす|modosu|戻す|to restore; to put back; to return|पुनः स्थापित करना; मरम्मत करना; वापस लौटाना; स्थगित करना; पुनः उसी; के कारण देर होना; लौटना
もらう|morau|貰う|to receive|प्राप्त करना
すぐれる|sugureru|優れる|to surpass; to outstrip; to excel|से बेहतर परिणाम देना; के परे होना; मात कर देना; से अधिक बढ़ जाना; स बढ़ कर होना; पीछे छोड़ देना; बढकर करना; बढकर; उत्तम होना
ある|aru|有る|to be; to have|होना; रखना
あたえる|ataeru|与える|to give; to present; to award|देना; उपहार; अनुदान; पुरस्कार; सावधान
あずける|azukeru|預ける|to give into custody; to entrust; to deposit|सौंपना; सौंप देना; जमा; रखना; जमा करना
もちいる|mochiiru|用いる|to use; to make use of|उपयोग करना; उपयोग करना; इस्तमाल करना
あびる|abiru|浴びる|to bathe; to bask in the sun; to shower|बहना; टकराना; फैल जाना; गिरना; बौछार; फुहार स्नान
たよる|tayoru|頼る|to rely on; to have recourse to; to depend on|पर विश्वास; पर विश्वास रखना; पर निर्भर होना; की सहायता लेना; निर्भर होना; आश्रित रहना; पर भरोसा
はく|haku|履く|to wear; to put on (lower body)|पहनना; चलाना; दिखाना; लगाना
うらぎる|uragiru|裏切る|to betray; to turn traitor to; to double-cross|दिखाना; प्रकट करना; धोखा देना
はなす|hanasu|離す|to part; divide; separate|भाग; विभाजित; फैल जाना; अलग करना; रोकना; निकालना; भिन्न
はなれる|hanareru|離れる|to be separated from; to leave; to go away; to be a long way off|छोड़ना
立ち上がる||立ち上がる|to stand up|धोखा देना; मान्य होना; आमने सामने की
ながす|nagasu|流す|to drain; to float; to shed (blood; tears); to cruise (e.g. taxi)|बहना; नाली; खाली करना; बहना; चलाना; फैलाना
ながれる|nagareru|流れる|to stream; to flow; to run (ink); to be washed away|बहना; वर्ग; प्रवाह; बहना; प्रवाह; चलना; दौड़ना
とめる|tomeru|留める|to fasten; to turn off; to detain|थोपना; अटकाना; निर्धारित करना; बंद करना; सहायक; बंद कर देना; रोकना; फँस जाना; फँस
おとる|otoru|劣る|to fall behind; to be inferior to|पीछे रह जाना; पिछड़ना
ろんじる|ronjiru|論じる|to argue; to discuss; to debate|प्रमाणित करना; सूचित करना; झगड़ना; विचार करना; विचार; बहस करना; सोचना; वाद विवाद करना/बहस करना; बहस
はなしあう|hanashiau|話し合う|to discuss; to talk together|विचार करना; विचार; बहस करना
かかる|kakaru|罹る|to suffer from|से पीड़ित होना
ひく|hiku|轢く|to run somebody over (with vehicle); to knock someone down|
いばる|ibaru|威張る|to be proud; to swagger|अकड़ कर चलना; पोटलीधारी मजदूर; इठलाहट
なぐさめる|nagusameru|慰める|to comfort; to console|आराम; सुविधा; सान्त्वना; दीवारगीर; सान्त्वना देना; सान्त्वनाएना
なす|nasu|為す|to accomplish; to do|पाना; प्राप्त करना; पूरा; करना
それる|soreru|逸れる|to stray (turn) from subject; to get lost; to go astray|दफा होना; खोना
よる|yoru|因る|to come from|से होना; से आना; से मिलना
ひきとめる|hikitomeru|引き止める|to detain; to check; to restrain|रोकना; फँस जाना; फँस; जाँच; रोकना; नियन्ट्रित करना; स्वतंत्रता का हनन करना
ひっかかる|hikkakaru|引っ掛かる|to be caught in; to be stuck in; to be cheated|
引っ繰り返す||引っ繰り返す|to turn over; to overturn; to knock over; to upset; to turn inside out|उलट देना; चालू करना; उलट जाना; उलट देना; के विरुद्ध निर्णय देना; के; गिराना; उलट देना; छलकाना
引っ繰り返る||引っ繰り返る|to be overturned; to be upset; to topple over; to be reversed|
ひっこむ|hikkomu|引っ込む|to draw back; to sink; to cave in|वापस लेना; कमी; वापस; घटना; होना; निकालना; गिरना; ढहना; अन्दर की ओर गिरना
ひきうける|hikiukeru|引受る|to undertake; to take up; to take over|उत्तरदायित्व लेना; वादा करना; बीड़ा उठाना; टोकना; स्वीकार करना; उठाना; हत्याना
ひきだす|hikidasu|引出す|to pull out; to take out; to draw out; to withdraw|निकलना; हटाना; वापस बुलाना; करना; निकालना; भोजन; स्वतंट्र रुप से बात करना; स्वतंट्र; लंबा करना
ひきかえす|hikikaesu|引返す|to repeat; to send back; to bring back|पुनराव्रत्ति; पहले के समान भेजा हुआ नया; पुनरावृत्ति; लाना; लौटाना; लौटा लाना
うつす|utsusu|映す|to project; to reflect; to cast (shadow)|योजना बनाना; डालना; योजना; विचार करना; दर्शाना; प्रतिबिंबित करना; ढालना; डालना; नाटक या फिल्म के कलाकार
うつる|utsuru|映る|to be reflected; to harmonize with; to come out (photo)|निकालना; निकलना; बनना
のばす|nobasu|延ばす|to lengthen; to stretch; to reach out; to grow (beard)|लम्बा करना; लम्बा; फैलाना; फैल जाना; पंक्ति
のびる|nobiru|延びる|to be prolonged|
へこむ|hekomu|凹む|to be dented; to be indented; to yield to; to give; to sink; to collapse; to cave in; to be snubbed|
おうずる|ouzuru|応ずる|to answer; to respond; to meet; to satisfy; to accept|जवाब; प्रत्युत्तर देना; बदले मे कुछ करना या कहना; उत्तर देना; मिलना
おさえる|osaeru|押える|to stop; to restrain; to seize; to repress; to suppress; to press down|रुकना; रोकना; नियन्ट्रित करना; स्वतंत्रता का हनन करना; समझना; झपट लेना; पकड़ना
おろす|orosu|卸す|to sell wholesale; grated (vegetables)|
さがる|sagaru|下る|to get down; to descend|उतरना; किसी कार्य में ध्यान लगाना; निराशित करना; उतरना; उतारना; नीचे उतरना
くやむ|kuyamu|悔やむ|to mourn|विलाप करना; विलाप; शोक करना/दुःखी होना
あらためる|aratameru|改める|to change; to alter; to reform; to revise|बदलना; बदल देना; बदल जाना; सुधार; सुधारना; फिर बनाना
はずれる|hazureru|外れる|to be disconnected; to get out of place; to be off; to be out (e.g. of gear)|
へだてる|hedateru|隔てる|to be shut out|
かわく|kawaku|渇く|to be thirsty|
かわかす|kawakasu|乾かす|to dry (clothes; etc.); to desiccate|आदि
まく|maku|巻く|to wind; to coil; to roll|हवा; मोड़ना; लपेटना; काँयल; बराबर करना; पिण्ड; तरंगित होना
ほす|hosu|干す|to air; to dry; to desiccate; to drain (off); to drink up|हवा; सूखा
かんずる|kanzuru|感ずる|to feel; to sense|महसूस करना; दिशा; होश; ज्ञान
あまやかす|amayakasu|甘やかす|to pamper; to spoil|बहुत लाड प्यार करना; लाभ; दूषित करना; बिगाड़ देना
ふくめる|fukumeru|含める|to include; to instruct; to make one understand|दर्ज़ करना; शामिल होना; मिलाना; बताना; उपदेश देना; सूचित करना
よせる|yoseru|寄せる|to collect; to gather; to add; to put aside|इकट्ठा करना; प्राप्त करना; समझना; काटना; जोड़ना
かえす|kaesu|帰す|to send back|
きをつける|kiotsukeru|気を付ける|to be careful; to pay attention; to take care|अपना; अपना ख्याल रखना
うえる|ueru|飢える|to starve|भूखा मरना; भूख लगना; भूखा होना
つまる|tsumaru|詰まる|to be blocked; to be packed|
あげる|ageru|挙げる|to raise; to fly|करना; निकालना; उत्तेजित करना; उड़ना
はさまる|hasamaru|挟まる|to get between; to be caught in|
はさむ|hasamu|挟む|to interpose; to hold between; to insert|बीच में टोकना; घुसाना; बीच में बोलना; निवेशन; सम्मलित करना; प्रविष्ट करना
おそわる|osowaru|教わる|to be taught|
ひびく|hibiku|響く|to resound|प्रतिध्वनित होना; धूम मचाना; गूँज उठना
おどろかす|odorokasu|驚かす|to surprise; to frighten; to create a stir|अचम्भा; आश्चर्य; चकित करना; भयभीत करना; डराना; भयभीत
まげる|mageru|曲げる|to bend; to crook; to lean|झुकाना; बदलना; खराब; मोड़ना; हुक वाली लाठी; अपराधी; थोड़ा; खाली; दुबला
ちかよる|chikayoru|近寄る|to approach; to draw near|पद्धति; सन्निकर्ष; समीप आना
ちかづける|chikazukeru|近付ける|to bring near; to put close; to let come near; to associate with|
くぎる|kugiru|区切る|to punctuate; to cut off; to mark off; to stop; to put an end to|विराम चिह्न लगा; बीच में रोकना; प्रतिबाधित करना; रोक देना; काटकर निकालना; सीमा; सही का निशान लगाना; नापना; सीमांकन करना
そなえる|sonaeru|具える|to be furnished with|
ほる|horu|掘る|to dig; to excavate|करना; समझना; ढकेलना; खोदकर निकालना; खोदना; खोद कर
かかわる|kakawaru|係わる|to concern oneself in; to have to do with; to affect; to influence; to stick to (opinions)|से सम्बंधित होना; से; बदलना; प्रभावित करना; ढोंग करना
かたむく|katamuku|傾く|to incline toward; to slant; to lurch|दृष्टिकोण; तिरछा करना; तिरछा; झटका; झटका खाना; जहाज़ का यकायक उलट जाना
めぐまれる|megumareru|恵まれる|to be blessed with; to be rich in|सौभाग्यशाली होना; के लिए सौभाग्यशाली होना; सौभाग्यशाली
うやまう|uyamau|敬う|to show respect; to honour|सम्मानित करना; सम्मान; मानना
つながる|tsunagaru|繋がる|to be tied together; to be connected to; to be related to|
つなげる|tsunageru|繋げる|to connect|मिलाना; जुड़ा; लगना
かねる|kaneru|兼ねる|to hold (position); to serve; to be unable|पकड़ना; बदला लेना; देना; सहायता करना
いやがる|iyagaru|嫌がる|to hate; to dislike|घृणा करना; घृणा; द्वेष; घृणा; नापसंद करना; द्वेष
たつ|tatsu|建つ|to erect; to be erected; to be built|निर्माण करना; निर्माण; खड़ा करना
みおろす|miorosu|見下ろす|to overlook; to command a view of; to look down on something|के उपर से दिखना; अन्देकी करना; क्षमा
みなれる|minareru|見慣れる|to become used to seeing; to be familiar with|
みなおす|minaosu|見直す|to look again; to get a better opinion of|
みつかる|mitsukaru|見付かる|to be found; to be discovered|
みつける|mitsukeru|見付ける|to be familiar; to discover; to detect|पता; समझना; पता लगाना; पता; पता लगाना; पकड़ना
みまう|mimau|見舞う|to ask after (health); to visit|का हालचाल पूछना; स्वास्थ्य के बारे में पूछना; स्वास्थ्य के; दौरा करना
いいだす|iidasu|言い出す|to start talking; to speak; to tell; to propose; to suggest; to break the ice|बोलना; बताना
いいつける|iitsukeru|言い付ける|to tell; to tell on (someone); to order|बताना; चुगली करना; आदेशानुसार; मंगवाना
ことづける|kotozukeru|言付ける|to send word; to send a message|
よびかける|yobikakeru|呼び掛ける|to call out to; to accost; to address (crowd); to appeal|टोकना; फँसाना; संबोधन करना; पता
よびだす|yobidasu|呼び出す|to summon; to call (e.g. phone)|बुलाना; इकट्ठा करना; तैयार रखना; बुलाना
かたまる|katamaru|固まる|to harden; to solidify; to become firm; to become certain|द्र्ढ बन्ना; पक्का; पक्का बन्ना; जमना; जमाना; ठोस बनना या बनाना/जमना या जमाना
かれる|kareru|枯れる|to wither; to die (plant); to be blasted (plant)|कुम्हलाना; क्षीण होना; ताज़गी खोना; मरना
まざる|mazaru|交ざる|to be mixed; to be blended with; to associate with; to mingle with; to join|
まじる|majiru|交じる|to be mixed; to be blended with; to associate with|
まぜる|mazeru|交ぜる|to be mixed; to be blended with|
ひろげる|hirogeru|広げる|to spread; to extend; to expand; to enlarge|फैलना; प्रकार; फैलाना; फैलना; फैलाना; देना; फैलना; फैलाना; फैल जाना
ひろめる|hiromeru|広める|to broaden; to propagate|बढ़ाना; चौड़ा होना; चौड़ा; फैलना; फैलाना; प्रचार करना
せめる|semeru|攻める|to attack; to assault|हमला; प्रयास; धावा; हमला करना
ふける|fukeru|更ける|to get late; to advance; to wear on|अग्रसर होना; आगे बढना; प्रयास; धीरे धीरे बीतना; बितना
しぼる|shiboru|絞る|to press; to wring; to squeeze|दबाव; प्रोत्साहित करना; घबराहट; ऐंठना; रूप बिगाड़ना; विकृत करना; दबाव; दबाना; ऐंठना
たがやす|tagayasu|耕す|to till; to plow; to cultivate|तक; खेत जोतना; गोलक; खेत जोतना; हल; करना; तैयार; तैयार करना
たかめる|takameru|高める|to raise; to lift; to boost|करना; निकालना; उत्तेजित करना; धुंध हटना; उठाना; खोदना; बढ़ाना; बढ़ा देना; बढ़ावा देना
きざむ|kizamu|刻む|to mince; to carve; to engrave|ठुमक कर चलना; कीमा बनाना; छोटा छोटा काटना; काट कर चित्र बनाना; नक्काशी करना; तराशना; खोदना; उत्कीर्ण करना; उत्कीर्ण
こしかける|koshikakeru|腰掛ける|to sit (down)|बैठना
うらむ|uramu|恨む|to curse; to feel bitter|निकाल देना; बहिष्कृत करना; निकाल
まざる|mazaru|混ざる|to be mixed; to be blended with; to associate with; to mingle with; to join|
まじる|majiru|混じる|to be mixed; to be blended with; to associate with|
まぜる|mazeru|混ぜる|to mix; to stir|मिलना; मिश्रण; मिलाना; चलाना; उत्तेजित करना; मिलाना
ふさがる|fusagaru|塞がる|to be plugged up; to be shut up|
ふさぐ|fusagu|塞ぐ|to stop up; to close up; to block (up)|देर तक जागना; बंद करना; भरना; बड़ा एवं पास; रोकना; कील; बाधा
くだく|kudaku|砕く|to break; to smash|तोड़ना; टक्कर; टकराना; प्रहार
くだける|kudakeru|砕ける|to break; to be broken|तोड़ना
まつる|matsuru|祭る|to deify; to enshrine|पूजा करना; स्थापित करना; प्रतिष्ठापित करना; बचा रखना
のせる|noseru|載せる|to place on (something); to take on board; to give a ride|स्वीकार करना
のる|noru|載る|to appear (in print); to be recorded|दिखना
ある|aru|在る|to live; to be|जीना; होना
作る/造る||作る/造る|to make; to create|बनाना; बनाना
けずる|kezuru|削る|to cut down little by little; to take a percentage|
する|suru|刷る|to print|लगाना; प्रति; प्रभावित करना
こする|kosuru|擦る|to rub; to chafe; to file; to frost (glass); to strike (match)|घिसना; बजाना; चिढ़; रगड़; रेती; पंक्ति; चिकना करना
さびる|sabiru|錆びる|to rust; to become rusty|मोरचे का रंग; ज़ंग लग; मोरचे का
まく|maku|撒く|to scatter; to sprinkle; to sow|फैलाव; छितराव; तितर बितर करना; फुहार; छिड़कना; छितराना; पैदा करना; शूकरी; सुअरी
ちらかす|chirakasu|散らかす|to scatter around; to leave untidy|
ちらかる|chirakaru|散らかる|to be in disorder; to lie scattered around|
ちらす|chirasu|散らす|to scatter; to disperse; to distribute|फैलाव; छितराव; तितर बितर करना; तितर वितर करना; छितराना; छितरा देना; फैलना; वितरण करना; वितरण
ちる|chiru|散る|to fall; to scatter (e.g. blossoms)|गिरना; फैलाव; छितराव; तितर बितर करना
しあがる|shiagaru|仕上がる|to be finished|
ささる|sasaru|刺さる|to stick; to be stuck|सथापित करना; टेक लगाना; रखना
さす|sasu|刺す|to pierce; to stab; to prick; to thrust|प्रभावित करना; छेद करना; भेदना; घाव; प्रहार करना; दबाना; मूर्ख; छेदना; चुभन
はじめに|hajimeni|始めに|to begin with; first of all|पहले से ही; शुरू शुरू में; पहले; सर्वप्रथम
おもいこむ|omoikomu|思い込む|to be under impression that; to be convinced that|
おもいつく|omoitsuku|思い付く|to think of; to hit upon|विचार करना; समझना; योजना बनाना; सोचना
つぐ|tsugu|次ぐ|to rank next to; to come after|पीछा करना
なおす|naosu|治す|to cure; to heal; to fix; to correct; to repair|दूर; पादरी; ठीक करना; भरना; स्वस्थ होना; बदला लेना; लगाना; निश्चित करना
まく|maku|蒔く|to sow (seeds)|पैदा करना; शूकरी; सुअरी
しめる|shimeru|湿る|to be wet; to become wet; to be damp|
みのる|minoru|実る|to bear fruit; to ripen|सफल होना; पकाना; पकना
うつる|utsuru|写る|to be photographed; to be projected|
さす|sasu|射す|to shine; to strike|चमकाना; चमक; प्रकाशित होना; बजना; आक्रमण; निकालना
にえる|nieru|煮える|to boil; to cook; to be cooked|गुस्सा; उबालना; गरम करना; पकाना
にる|niru|煮る|to boil; to cook|गुस्सा; उबालना; गरम करना; पकाना
くむ|kumu|酌む|to serve sake|
とりだす|toridasu|取り出す|to take out; to produce; to pick out|करना; निकालना; भोजन; उत्पादन करना; समझना; पहचानना; चुनना
とりけす|torikesu|取り消す|to cancel|रद्द; काटना; रद्द करना
とりいれる|toriireru|取り入れる|to harvest; to take in; to adopt|फसल कटाई का समय; फसल; फसल एकत्र; समझना; ले लेना; झाँसे में आना; दत्तक ग्रहण
うけもつ|ukemotsu|受け持つ|to take (be in) charge of|
ける|keru|蹴る|to kick|परेशान करना; चलाना; निकालना
かさなる|kasanaru|重なる|to be piled up; lie on top of one another; overlap each other|झूठ; अतिछादित करना; अतिव्याप्त; एक ही समय होना
かさねる|kasaneru|重ねる|to pile up; to put something on another; to heap up; to add; to repeat|जमा करना; दुर्घटना; इकट्ठा करना
ちぢむ|chijimu|縮む|to shrink; to be contracted|घटना; पीछे हटना; सिकोड़ना
ちぢめる|chijimeru|縮める|to shorten; to reduce; to boil down; to shrink|कम करना; संक्षिप्त करना; छोटा करना; घटना; कम करना; पराजित करना; संक्षेपण करना; खौलते; खौलाकर कम करना
ちぢれる|chijireru|縮れる|to be wavy; to be curled|
でかける|dekakeru|出掛ける|to depart; to set out; to start; to be going out|से हटना; प्रस्ठान करना; छूटना; प्रस्थान करना; बताना; व्यक्त करना; शुरू करना
でむかえる|demukaeru|出迎える|to meet; to greet|मिलना; मिलना; स्वागत; अभिवादन
めぐる|meguru|巡る|to go around|
たすかる|tasukaru|助かる|to be saved; to be rescued; to survive; to be helpful|जीवित रहना; से बच जाना; से बच
こがす|kogasu|焦がす|to burn; to scorch; to singe; to char|करना; दाग; ख़र्च करना; जलना; बरबाद कर देना; जला देना; झुलस जाना; झुलस; झुलसाना
こげる|kogeru|焦げる|to burn; to be burned|करना; दाग; ख़र्च करना
てらす|terasu|照らす|to shine on; to illuminate|प्रकाशयुक्त करना; प्रकाशित; प्रकाशित करना
てる|teru|照る|to shine|चमकाना; चमक; प्रकाशित होना
あがる|agaru|上る|to ascend; to go up; to climb|चढना; बढना/चढ़ना; उपर उठना; जाना; उठना; नष्ट होना; चढ़ना
たたむ|tatamu|畳む|to fold (clothes)|मिलाना; मोड़ना; भेड़ों का बाड़ा
むす|musu|蒸す|to steam; to poultice; to be sultry|भाप शक्ति से याट्रा; भाप शक्ति; वाष्प; पुलटिस; लेप/पुलटिस
ふく|fuku|拭く|to wipe; to dry|गिरना; हटाना; पौंछा लगाना; सूखा
ふえる|fueru|殖える|to increase; to multiply|वृद्धि करना; बढ़ाना; विस्तार; वृद्धि करना; बढ्ना; जनन करना
ふやす|fuyasu|殖やす|to increase; to add to; to augment|वृद्धि करना; बढ़ाना; विस्तार; बढ़ाना; वृद्धि करना; वृद्धि
しんずる|shinzuru|信ずる|to believe; to believe in; to place trust in|विश्वास करना; में विश्वास रखना; पर विश्वास रखना; पर भरोसा रखना
こころえる|kokoroeru|心得る|to be informed; to have thorough knowledge|
ふるまう|furumau|振舞う|to behave; to conduct oneself; to entertain (vt)|व्यवहार करना; चलना; बर्ताव करना; सुनना; विचार करना; विचार
つける|tsukeru|浸ける|to dip in; to soak|फैल जाना; डुबाव; भिगोना
ふかまる|fukamaru|深まる|to deepen; to heighten; to intensify|गहराना; गहरा हो जाना; गहरा होना; बढ़; बढ़ा देना; बढ़ जाना; बढ़ा देना; सशक्त करना; बढ़ जाना
まねる|maneru|真似る|to mimic; to imitate|नकलची; नकल करना; अनुसरण करना; अनुकरण करना; अनुसरण
みる|miru|診る|to examine (medical)|समझना; परखना; पूछना
たく|taku|炊く|to boil; to cook|गुस्सा; उबालना; गरम करना; पकाना
すむ|sumu|澄む|to clear (e.g. weather); to become transparent|स्पष्ट
ととのう|totonou|整う|to be prepared; to be in order; to be put in order; to be arranged|
しょうずる|shouzuru|生ずる|to cause; to arise; to be generated|करना; कारण बनना; देना; उदय होना; उत्पन्न होना; निकलना
なる|naru|生る|to bear fruit|सफल होना
ちかう|chikau|誓う|to swear; to vow; to take an oath; to pledge|गाली देना; कसम; वचन देना; प्रतिज्ञा; वादा; प्रतिज्ञा करना
こう|kou|請う|to ask; to request|पूछना; विनती करना; अनुरोध करना; आवेदन
しずまる|shizumaru|静まる|to quieten down; to calm down; to subside|शांत; घटना; शांत होना; बैठ जाना
つむ|tsumu|積む|to pile up; to stack|जमा करना; दुर्घटना; इकट्ठा करना; ढेर; क्रमबद्ध ढेर लगाना; भरना
せっする|sessuru|接する|to come in contact with; to connect; to attend; to receive|मिलाना; जुड़ा; लगना; ध्यान केंद्रित करना; साथ जाना; पर ध्यान देना
うらなう|uranau|占う|to forecast; to predict|बताना; पूर्वानुमान करना; पूर्वानुमान; पूर्वानुमान करना; भविष्यवाणी करना; भविष्य बतलाना
とがる|togaru|尖る|to taper to a point; to become sharp; to be sour; to look displeased|
あおぐ|aogu|扇ぐ|to fan; to flap|उत्तेजित करना; पंखा; फटकना; चिंतावस्था; उत्तेजना; फ्लैप
いる|iru|煎る|to parch; to fry|झुलसा देना; झुलसा; तलना; मछली के बहुत छोटे छोटे बच्चे; झुलसा देना
うらやむ|urayamu|羨む|to envy|जी में जलना
ねらう|nerau|狙う|to aim at|
くみたてる|kumitateru|組み立てる|to assemble; to set up; to construct|एकत्रित होना; जमा; इकट्ठा; लगाना; दावा करना; फँसाना; बनाना; रचना; खींचना
よみがえる|yomigaeru|蘇る|to be resurrected; to be revived; to be resuscitated; to be rehabilitated|
さかのぼる|sakanoboru|遡る|to go back; to go upstream; to make retroactive|बदलना; उठाना; वापस
さがす|sagasu|捜す|to search; to seek; to look for|टटोलना; परीक्षण; घुसना; कोशिश करना; की कोशिश करना; पतालगाना; ढूँढना
はく|haku|掃く|to sweep; to brush; to gather up|फैलना; आसानी से चड़ना; घुमाव; खरोंच; झगड़ा; रगड़ना
さす|sasu|挿す|to insert; to put in; to graft; to wear in belt|निवेशन; सम्मलित करना; प्रविष्ट करना; लगाना; काम लगाना; लिखना; कलम; रिश्वत; कलम लगाना
かく|kaku|掻く|to scratch; to perspire|खरोंचना; खरोंच; वापस लेना; पसीना; पसीना आना; पसीना बहाना
あらそう|arasou|争う|to dispute; to argue; to be at variance; to compete|विवाद करना; झगड़ना; झगड़ा; प्रमाणित करना; सूचित करना; झगड़ना
あう|au|遭う|to meet; to encounter (undesirable nuance)|मिलना; सामना करना; मुठभेड़; मुठभेड़ करना
ふやす|fuyasu|増やす|to increase; to add to; to augment|वृद्धि करना; बढ़ाना; विस्तार; बढ़ाना; वृद्धि करना; वृद्धि
にくむ|nikumu|憎む|to hate; to detest|घृणा करना; घृणा; द्वेष; घृणा करना; नफ़रत; नफ़रत करना
はかる|hakaru|測る|to measure; to weigh; to survey|ताल; मर्यादा; काफ़ी; विचार करना; उठाना; नापना; दर्शाना; सर्वेक्षण; सर्वेक्षण करना
たる|taru|足る|to be sufficient; to be enough|
ぞくする|zokusuru|属する|to belong to; to come under; to be affiliated with; to be subject to|का होना; को जाना; से संबंधित होना; निशाना बनना; के अंतर्गत; के अंतर्गत आना
そろう|sorou|揃う|to become complete; to be equal; to be all present; to gather|
そろえる|soroeru|揃える|to put things in order; to arrange; to make uniform; to get something ready|निश्चित करना; तय करना; तैयार करना
うちけす|uchikesu|打ち消す|to deny; to negate; to contradict|प्रतिवाड करना; इन्कार करना; वंचित करना; बे असर करना; नकारना; बे असर; विरोध करना; खंडन; विपरीत
待ち合わせる||待ち合わせる|to rendezvous; to meet at a prearranged place and time|पूर्वनिश्चित समय और स्थान पर मिलना; मनोरंजन स्थल; पूर्वनिश्चित मुलाकात
おこたる|okotaru|怠る|to neglect; to be off guard; to be feeling better|उपेक्षा करना; लापरवाही; उपेक्षा
どける|dokeru|退ける|to remove; to take away; to dislodge; to put something out of the way|निकालना; हटाना; श्रेणी; लेना; दूर करना; श्रमिक संघ द्वारा तय; हटाना; निकाक; पूर्व स्थान से हटाना
かえる|kaeru|代える|to exchange; to interchange; to substitute; to replace|करना; बदल देना; केन्द्र; बदल देना; इंटरचेंज; अदला बदली करना; स्थानापन्न व्यक्ति; स्थानापन्न; एवजी
にごる|nigoru|濁る|to become muddy; to get impure|
かつぐ|katsugu|担ぐ|to shoulder; to carry on shoulder|कन्धा; आगे बढना; पहाड़
さぐる|saguru|探る|to search; to look for; to sound out|टटोलना; परीक्षण; घुसना; ढूँढना; विचार जानने की कोशिस करना
あたたまる|atatamaru|暖まる|to warm up; to get warm|अँचवाना
あたためる|atatameru|暖める|to warm; to heat|गर्म; गर्मी
たくわえる|takuwaeru|蓄える|to store; to lay in stock|दुकान
きせる|kiseru|着せる|to put on clothes|
さす|sasu|注す|to pour (drink); to serve (drinks)|बहना; निकालना; देना; बदला लेना; देना; सहायता करना
あらわす|arawasu|著す|to write; to publish|लिखना; लिखना; प्रकाशित होना; पेश करना
はりきる|harikiru|張り切る|to be in high spirits; to be full of vigor|
ほる|horu|彫る|to carve; to engrave; to sculpture; to chisel|काट कर चित्र बनाना; नक्काशी करना; तराशना; खोदना; उत्कीर्ण करना; उत्कीर्ण; मूर्तिकला; मूर्ति बनाना; मूर्ति
こえる|koeru|超える|to exceed; to cross over; to cross|अधिक होना; पार कर जाना; अतिक्रमण करना; बदलना; पार करना
こす|kosu|超す|to cross; to pass; to tide over|पार करना; पास करना; सहायता करना; पार लगाना[आपत्ति आने पर]
はねる|haneru|跳ねる|to jump; to leap|कूदना; छलांग मारना; उछलना; कूदना
とぶ|tobu|跳ぶ|to jump; to fly; to leap|कूदना; उड़ना; छलांग मारना; उछलना; कूदना
ながびく|nagabiku|長引く|to be prolonged; to drag on|
おいこす|oikosu|追い越す|to pass (e.g. car); to outdistance; to outstrip|पास करना; निकल जाना; पीछे छोड़; पीछे छोड़ देना; से अधिक बढ़ जाना; स बढ़ कर होना; पीछे छोड़ देना
おいかける|oikakeru|追い掛ける|to chase or run after someone; to run down; to pursue|पाना; विवरण; ध्वस्त; पाने की कोशिश करना; लगे रहना; पीछा करना
とおりかかる|toorikakaru|通り掛かる|to happen to pass by|
つぶす|tsubusu|潰す|to smash; to waste|टक्कर; टकराना; प्रहार; व्यर्थ; बंजर भूमि; नष्ट करना
つぶれる|tsubureru|潰れる|to be smashed; to go bankrupt|दिवालिया होना
つるす|tsurusu|吊す|to hang|लटकना; टाम्गना; छाना
つる|tsuru|吊る|to hang|लटकना; टाम्गना; छाना
つりあう|tsuriau|釣り合う|to balance; to be in harmony; to suit|बराबर करना; हिचकिचाना; सँभालना; प्रणय निवेदन; सूट; के लिये ठीक होना
そる|soru|剃る|to shave|कम करना; मूड़ना; छीलना
しめきる|shimekiru|締め切る|to shut up|चुप करना; बन्द करना; चुप रहना
まとまる|matomaru|纏まる|to be collected; to be settled; to be in order|
まとめる|matomeru|纏める|to put in order; to collect; to bring to a conclusion|इकट्ठा करना
ころがす|korogasu|転がす|to roll|बराबर करना; पिण्ड; तरंगित होना
ころがる|korogaru|転がる|to roll; to tumble|बराबर करना; पिण्ड; तरंगित होना; गिरावट; भाव गिरना; गिर जाना
つく|tsuku|点く|to catch fire; (electricity) comes on|आग पकड़ लेना; आग पकड़
つける|tsukeru|点ける|to turn on; to switch on; to light up|चलाना; बहकाना; खोलना; चालू करना; प्रकाशित करना; चमक; जालाना
つたわる|tsutawaru|伝わる|to be handed down; to be introduced; to be transmitted|
こごえる|kogoeru|凍える|to freeze; to be chilled; to be frozen|जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना
うつ|utsu|討つ|to attack; to avenge|हमला; बदला लेना; प्रतिशोध; प्रतिशोध लेना
にがす|nigasu|逃がす|to let loose; to set free; to let escape|खुला छोड़ देना
すきとおる|sukitooru|透き通る|to be(come) transparent|
あこがれる|akogareru|憧れる|to long for; to yearn after; to admire|चाहना; समादर करना; प्रशंसा करना; सराहना करना
つきあたる|tsukiataru|突き当たる|to run into; to collide with|संयोग से मिलना; टकराना; दौर से गुजरना
つっこむ|tsukkomu|突っ込む|to plunge into; to go into deeply|
なれる|nareru|馴れる|to become domesticated; to become tame|
におう|niou|匂う|to be fragrant; to smell; to stink|गंध; बदबू; दुर्गंध; दुर्गंध आना
ぬらす|nurasu|濡らす|to wet; to soak; to dip|नीरस; गीला; निर्जीव; फैल जाना; डुबाव; भिगोना; झुकाना; कम करना; निकालना
ねっする|nessuru|熱する|to heat|गर्मी
ひねる|hineru|捻る|to turn (a switch) on or off; to twist; to puzzle over|झटका; मुड़ जाना; मोड़ना; गम्भीर विचार करना
もやす|moyasu|燃やす|to burn|करना; दाग; ख़र्च करना
おさめる|osameru|納める|to obtain; to reap; to pay; to supply; to accept|पाना; प्राप्त करना; हाशिल करना; प्राप्त करना; जैसी करनी वैसी भरनी; काटना; भुगतान करना
のぞく|nozoku|覗く|to peep in; to look in; to peek in; to stick out|मिलने आना; मौक़्; देखने आना
やぶれる|yabureru|破れる|to get torn; to wear out|टूटना; घिस डालना; थकना
おがむ|ogamu|拝む|to worship; to beg; to make a supplication|समादर करना; पूजा करना; सम्मान करना; विनती करना; प्रार्थना करना; बैठना
せおう|seou|背負う|to be burdened with; to carry on back or shoulder|
くばる|kubaru|配る|to distribute; to deliver|फैलना; वितरण करना; वितरण; बताना; करना; प्रकट करना
うりきれる|urikireru|売り切れる|to be sold out|हाउस फुल होना
はう|hau|這う|to creep; to crawl|जाना; डर; छिपकर घुसना; क्राल; रेंगना; रेंगने वाली चीजों से भरा होना
むく|muku|剥く|to peel; to skin; to pare; to hull|गिरना; छिलना; छिलका; छिलना; छिलका निकालना; छिलका; कम करना; घटाना; काटना
とめる|tomeru|泊める|to give shelter to; to lodge|रखना; जमा करना; मकान
うすめる|usumeru|薄める|to dilute; to water down|फ़ीका; फ़ीका करना; कमज़ोर करना; हल्का रूपना; पतला करना; कम कड़क करना
せまる|semaru|迫る|to draw near; to press|दबाव; प्रोत्साहित करना; घबराहट
しばる|shibaru|縛る|to tie; to bind|मिलाना; संबंध; लटकाना; लगाना; चिन्ह; भरना
たつ|tatsu|発つ|to depart (on a plane; train; etc.)|रेलगाड़ी; आदि
かえる|kaeru|反る|to warp; to be warped; to curve|ताना; मोड़ना; आलेख; झुकाना; मुड़ जाना
かぶせる|kabuseru|被せる|to cover (with something)|ढकना
とびこむ|tobikomu|飛び込む|to jump in; to leap in; to plunge into; to dive|विघ्न डालना; कूद पड़ना
つきあう|tsukiau|付合う|to associate with; to keep company with; to get on with|
しく|shiku|敷く|to spread out; to lay out|अलग होना; लगाना; मार गिराना; खाका
うかべる|ukaberu|浮かべる|to float; to express; to look (sad; glad)|बहना; चलाना; फैलाना; बताना; प्रकट; प्रकट करना
うく|uku|浮く|to float; to become merry; to become loose|बहना; चलाना; फैलाना
うかぶ|ukabu|浮ぶ|to float; to rise to surface; to come to mind|बहना; चलाना; फैलाना; दिमाग में आना
なでる|naderu|撫でる|to brush gently; to stroke|प्रहार करना; अघात; प्रहार
はらいこむ|haraikomu|払い込む|to deposit; to pay in|जमा; रखना; जमा करना; जमा करना
はらいもどす|haraimodosu|払い戻す|to repay; to pay back|लौटाना; वापस करना; भुगतान करना; बदला लेना; लौटाना
ものがたる|monogataru|物語る|to tell; to indicate|बताना; दिखाना; सूचित करना; संकेत
わかれる|wakareru|分かれる|to branch off; to diverge from; to fork; to split; to dispense; to scatter; to divide into|मुड़ना; काँटा से खाना; द्विशाखित हो; खाने का काँटा
わかる|wakaru|分る|to be understood|
たく|taku|焚く|to burn; to kindle; to build a fire|करना; दाग; ख़र्च करना; उत्तेजित करना; जाग्रत करना; जलाना
かたよる|katayoru|片寄る|to be one-sided; to incline; to be partial|प्रोत्साहित; प्रोत्साहित करना; प्रेरित करना
かたづく|katazuku|片付く|to put in order; to dispose of; to solve|से छुटकारा पाना; निपटा; निपटा देना; हल करना; किसी प्रश्न को हल करना; सुलझ्जाना
あむ|amu|編む|to knit|जुड़ना; सिकोड़ना; बुनना
とらえる|toraeru|捕える|to seize; to grasp; to capture; to arrest|समझना; झपट लेना; पकड़ना; समझना; पाने का प्रयत्न; समझ; आकर्षित करना; पकड़; बन्दी
とる|toru|捕る|to take; to catch (fish); to capture|लेना; पकड़ना; आकर्षित करना; पकड़; बन्दी
おぎなう|oginau|補う|to compensate for|
ならう|narau|倣う|to imitate; to follow; to emulate|अनुसरण करना; अनुकरण करना; अनुसरण; लाओ; इसके बाद में; की तरह काम; अनुकरण करना; की तरह काम करना
くずす|kuzusu|崩す|to destroy; to pull down; to make change (money)|दूर; हराना; नष्ट करना; ढा देना
くずれる|kuzureru|崩れる|to collapse; to crumble|असफलता; गिरना; गिरावट; चूर चूर होना; टुकड़े टुकड़े होना; कमज़ोर
ほうる|houru|放る|to let go|पकड़ ढीली करना; अपने आप को मुक्त करना; जाने देना
はなれる|hanareru|放れる|to leave; to get free; to cut oneself off|छोड़ना
ぬう|nuu|縫う|to sew|सीलाई करना; सीना; सीकर
あくまで|akumade|飽くまで|to the end; to the last; stubbornly|अंत तक; अड़ियल ढंग से; ज़िद में आ कर; हठधर्मितापूर्वक
なくす|nakusu|亡くす|to lose someone; wife; child; etc|पत्नी; बच्चा
さまたげる|samatageru|妨げる|to disturb; to prevent|परेशान; बाधा; छेड़ना/सताना; प्रतिबन्ध करना
あばれる|abareru|暴れる|to act violently; to rage; to struggle; to be riotous|ज़ोर से चलना; रोष व्यक्त; प्रकोप; आगे बढना; मुश्किल; प्रयत्न
ふくらます|fukuramasu|膨らます|to swell; to expand; to inflate; to bulge|सुन्दर; बढ़ाना; मोड़ना; फैलना; फैलाना; फैल जाना; बढ़ाना; अवमूल्यन करना; बढ़ाना चढ़ाना
ふくらむ|fukuramu|膨らむ|to expand; to swell (out); to get big; to become inflated|फैलना; फैलाना; फैल जाना; सुन्दर; बढ़ाना; मोड़ना
うめる|umeru|埋める|to bury; to fill up; to fill (a seat; a vacant position)|अंत्योष्टि क्रिया करना; डालना; जमीन में गाड़ देना; भरना; पूरा भरा होना; भरा हुआ होना
あじわう|ajiwau|味わう|to taste; to savor; to relish|स्वादानुसार; स्वाद; का स्वाद लेना; का आननद लेना; स्वाद; जोश; उत्साह
めいずる|meizuru|命ずる|to command; to appoint|पाना; प्राप्त करना; देना; बनाना; नियुक्त करना; निर्धारित करना
ならす|narasu|鳴らす|to ring; to sound; to chime; to beat; to snort (nose)|गोला बनाना; बजना; टेलीफोन करना; आवाज़; घंटा बजाना; घंटानाद; झंकार
しげる|shigeru|茂る|to grow thick; to luxuriate; to be luxurious|फ़िज़ूलखर्ची; मज़े; फ़िज़ूलखर्ची करना
もうかる|moukaru|儲かる|to be profitable; to yield a profit|
もうける|moukeru|儲ける|to get; to earn; to gain; to have (bear; beget) a child|पाना; पाना; हासिल करना; कमाना; पाना; प्राप्त करना; मिलना
めざす|mezasu|目指す|to aim at; to have an eye on|
めだつ|medatsu|目立つ|to be conspicuous; to stand out|अड़े रहना; अलग से दिखना; महत्वपूर्ण होना
やくす|yakusu|訳す|to translate|समझना; बदलना; ले जाना
わく|waku|湧く|to boil; to grow hot; to get excited; to gush forth|गुस्सा; उबालना; गरम करना
あまる|amaru|余る|to remain; to be left over; to be in excess; to be too many|रहना; बाकी रहना; भग्नावशेष; बचे हुए होना
あずかる|azukaru|預かる|to keep in custody; to receive on deposit; to take charge of|
あげる|ageru|揚げる|to lift; to fry|धुंध हटना; उठाना; खोदना; तलना; मछली के बहुत छोटे छोटे बच्चे; झुलसा देना
とかす|tokasu|溶かす|to melt; to dissolve|कम होना; पिघलाना[पिघलना]; पिघलना; घुलना; भंग करना; भंग
とく|toku|溶く|to dissolve (paint)|घुलना; भंग करना; भंग
とける|tokeru|溶ける|to melt; to thaw; to fuse; to dissolve|कम होना; पिघलाना[पिघलना]; पिघलना; पिघलना; गलना; पिघलाना; गुस्सा; जुड़ना; मिलाना
とけこむ|tokekomu|溶け込む|to melt into|धीरे धीरे लुप्त होना; क्रमशः बदलना
おちつく|ochitsuku|落着く|to calm down; to settle down|शांत; आराम करना; आराम से; शांत करना
うらがえす|uragaesu|裏返す|to turn inside out; to turn (something) over|पूरी तर्ह से बदल देना; पूरी तर्ह से बदल; पूरी तरह से छान मारना; उलट देना; चालू करना; उलट जाना
たちどまる|tachidomaru|立ち止まる|to stop; to halt; to stand still|रुकना; पड़्व; रूकना; रुकना
りゃくす|ryakusu|略す|to abbreviate|संक्षिप्त करना
はやる|hayaru|流行る|to flourish; to thrive; to be popular; to come into fashion|अलंकरण; हाव भाव से; फलना फूल् होना; फलना फूलना; पनपना; समृद्ध होना
たまる|tamaru|溜まる|to collect; to gather; to save|इकट्ठा करना; प्राप्त करना; समझना; काटना; बचाना
ためる|tameru|溜める|to amass; to accumulate|जमा करना; इकट्ठा करना; ढेर लगना; जमा करना; जमा होना
すずむ|suzumu|涼む|to cool oneself; to cool off; to enjoy evening cool|शांत करना; शांत होना
はかる|hakaru|量る|to measure; to weigh; to survey|ताल; मर्यादा; काफ़ी; विचार करना; उठाना; नापना; दर्शाना; सर्वेक्षण; सर्वेक्षण करना
たとえる|tatoeru|例える|to compare; to liken; to speak figuratively; to illustrate; to use a simile|वर्णन करना; तुलना करना; विचार विनिमय करना; तुलना करना
さます|samasu|冷ます|to cool; to dampen; to let cool|ठंडा; कम करना; नम करना; नम
さめる|sameru|冷める|to become cool; to wear off; to abate; to subside|घिस देना; गायब; खत्म हो होना; कम करना; शांत करना; समाप्त करना
ひやす|hiyasu|冷やす|to cool; to refrigerate|ठंडा; प्रशीतित करना; फ्रिज में; प्रशीतित
さく|saku|裂く|to tear; to split|करना; आँसू; खींच लेना; चीरा; चम्पत; बंटना
ろんずる|ronzuru|論ずる|to argue; to discuss; to debate|प्रमाणित करना; सूचित करना; झगड़ना; विचार करना; विचार; बहस करना; सोचना; वाद विवाद करना/बहस करना; बहस
はなしかける|hanashikakeru|話し掛ける|to accost a person; to talk (to someone)|बात करना
わびる|wabiru|詫びる|to apologize|क्षमा मांगना
かぐ|kagu|嗅ぐ|to sniff; to smell|नाक; भनक; गंध; गंध
ささやく|sasayaku|囁く|to whisper; to murmur|काना फूसी; कानाफूसी; सरसराहट; बड़बड़ाना; सरसराहट; बड़बड़ाहट
ねじる|nejiru|捩る|to twist|झटका; मुड़ जाना; मोड़ना
もむ|momu|揉む|to rub; to crumple (up); to wrinkle|घिसना; सिकोड़ना; ध्वस्त होना; गींजना; सिकोड़ना; छोटी मोटी समस्या; सिलवट
にらむ|niramu|睨む|to glare at; to scowl at; to keep an eye on|पर; पर नज़र रखना; ध्यान रखना
あざわらう|azawarau|あざ笑う|to sneer at; to ridicule|उपहास; हँसी उड़ाना; उपहास करना
おいでになる|oideninaru|お出でになる|to be|होना
くっつく|kuttsuku|くっ付く|to adhere to; to keep close to|के मुताबिक चलना
くっつける|kuttsukeru|くっ付ける|to attach|लगाना; देना; संलग्न
ございます|gozaimasu|ご座います|to be (polite); to exist|होना; होना; रहना; जीवित रहना
すれちがう|surechigau|すれ違う|to pass by one another; to disagree; to miss each other|भिन्न होना; असहमत होना; असहमत
ぶらさげる|burasageru|ぶら下げる|to hang; to suspend; to dangle; to swing|लटकना; टाम्गना; छाना; लटकाना; स्थगित करना; निलम्बित करना; झूलना; झूलना/लटकना; झुलाना
やっつける|yattsukeru|やっ付ける|to beat|खटखटाना; ताल; परास्त कर देना
やりとげる|yaritogeru|やり遂げる|to accomplish|पाना; प्राप्त करना; पूरा
あてる|ateru|宛てる|to address|पता
あんじる|anjiru|案じる|to be anxious; to ponder|विचार करना; सोचना/मनन करना/चिन्तन करना
いきごむ|ikigomu|意気込む|to be enthusiastic about|
なさる|nasaru|為さる|to do|करना
しなびる|shinabiru|萎びる|to wilt; to fade|म्लानि रोग; शिथिल होना; कुम्हलाना; धुंधला पड़; कम होना; मुरझाना
しぼむ|shibomu|萎む|to wither; to fade (away); to shrivel; to wilt|कुम्हलाना; क्षीण होना; ताज़गी खोना; धुंधला पड़; कम होना; मुरझाना; कुम्हलाना; मुरझाना
ちがえる|chigaeru|違える|to change|बदलना
あふれる|afureru|溢れる|to flood; to overflow; to brim over|सैलाब; ज्वार; भरना; उमड़ आना; उपर से बहना; छलकाव; उमड़; उमड़ आना; लबालब भरा होना
そらす|sorasu|逸らす|to turn away; to avert|अस्वीकार करना; लौटाना; दूर रहना; फेर लेना; टाल देना
ひきずる|hikizuru|引きずる|to seduce; to drag along; to pull; to prolong; to support|बहकाना; लुभाना; आकर्षित करना; खींचना
ひきさげる|hikisageru|引き下げる|to pull down; to lower; to reduce; to withdraw|ढा देना; छोटा; कम करना; गिरना; घटना; कम करना; पराजित करना
ひきおこす|hikiokosu|引き起こす|to cause|करना; कारण बनना; देना
ひきとる|hikitoru|引き取る|to take charge of; to take over; to retire to a private place|हत्याना
ひきうける|hikiukeru|引き受ける|to undertake; to take up; to take over; to be responsible for; to guarantee; to contract (disease)|उत्तरदायित्व लेना; वादा करना; बीड़ा उठाना; टोकना; स्वीकार करना; उठाना; हत्याना
ひきあげる|hikiageru|引き上げる|to withdraw; to leave; to pull out; to retire|हटाना; अलग करना; हटा लेना; छोड़ना; निकलना; हटाना; वापस बुलाना
ひっかく|hikkaku|引っ掻く|to scratch|खरोंचना; खरोंच; वापस लेना
のみこむ|nomikomu|飲み込む|to gulp down; to swallow deeply; to understand; to take in; to catch on to; to learn; to digest|समझना
いとなむ|itonamu|営む|to carry on (e.g. in ceremony); to run a business|भाग लेना; बेहूदा बर्ताव; संचालन करना
はえる|haeru|映える|to shine; to look attractive; to look pretty|चमकाना; चमक; प्रकाशित होना
さかえる|sakaeru|栄える|to prosper; to flourish|संपन्न होना; समृद्ध होना; संपन्न; अलंकरण; हाव भाव से; फलना फूल् होना
そう|sou|沿う|to run along; to follow|चलेना; लाओ; इसके बाद में
えんじる|enjiru|演じる|to perform (a play); to play (a part); to act (a part); to commit (a blunder)|करना; दिखाना; गाना; खेलना; काम करना
えんずる|enzuru|演ずる|to perform; to play|करना; दिखाना; गाना; खेलना
けむる|kemuru|煙る|to smoke (e.g. fire)|तम्बाकू; असफलता; धूम्रपान
とおざかる|toozakaru|遠ざかる|to go far off|
よごす|yogosu|汚す|to disgrace; to dishonour|कलंकित करना; कलंकित; अपमान; मुकर जाना; कलंकित करना; कलंकित
よごれる|yogoreru|汚れる|to get dirty; to become dirty|
おさえる|osaeru|押さえる|to stop; to restrain; to seize; to repress; to suppress; to press down|रुकना; रोकना; नियन्ट्रित करना; स्वतंत्रता का हनन करना; समझना; झपट लेना; पकड़ना
おしよせる|oshiyoseru|押し寄せる|to push aside; to advance on|कम होताना
おしこむ|oshikomu|押し込む|to push into; to crowd into|में जमा; भर देना; में जमा हो
なぐる|naguru|殴る|to strike; to hit|बजना; आक्रमण; निकालना; मारना
さがる|sagaru|下がる|to hang down; to abate; to retire; to fall; to step back|कम करना; शांत करना; समाप्त करना; बाहर निकल; अवकाश लेना; पीछे हटना
ばける|bakeru|化ける|to appear in disguise; to take the form of; to change for the worse|
かする|kasuru|化する|to change into; to convert into; to transform; to be reduced; to influence; to improve (someone)|बदल देना; बढ़ाना; घटाना
かわいがる|kawaigaru|可愛がる|to love; to be affectionate|प्यार
はたす|hatasu|果たす|to accomplish; to fulfill; to carry out; to achieve|पाना; प्राप्त करना; पूरा; पूरा; कार्यान्वित करना; पूरा करना; करना; कार्यान्वित करना; पूरा करना
はてる|hateru|果てる|to end; to be finished; to be exhausted; to die; to perish|अंत
いじめる|ijimeru|苛める|to tease; to torment; to persecute; to chastise|शरारत; परेशान करना; शरारती; सताना; मुसीबत; अभिशाप; सताना
かすむ|kasumu|霞む|to grow hazy; to be misty|
とく|toku|解く|to unfasten|खोलना; खुलना
なつく|natsuku|懐く|to become emotionally attached|
さらう|sarau|拐う|to carry off; to run away with; to kidnap; to abduct|सफलतापूर्वक पूरा करना; जीतना; जीत; चुरा लेना; आसानी से जीत लेना; हावी होना; अपहरण करना[होना]; अपहरन करना; अपहरण
あらたまる|aratamaru|改まる|to be renewed|
がいする|gaisuru|害する|to injure; to damage; to harm; to kill; to hinder|घायल; नुकसान पहुच्ना; ज़ख़्मी करना; क्षति; क्षति पहुँजाना; बिगाड़ना; अनिष्ट; क्षति; हानि
へだたる|hedataru|隔たる|to be distant|
たのしむ|tanoshimu|楽しむ|to enjoy oneself|
わりこむ|warikomu|割り込む|to cut in; to thrust oneself into; to wedge oneself in; to muscle in on; to interrupt; to disturb|बीच में टोकना; हिस्सा; आगे बढकर रास्ता काटना
いける|ikeru|活ける|to arrange (flowers)|निश्चित करना; तय करना; तैयार करना
かなう|kanau|叶う|to come true (wish)|सच निकलना
かなえる|kanaeru|叶える|to grant (request  wish)|स्वीकार करना; देना; अनुदान
かみきる|kamikiru|噛み切る|to bite off; to gnaw through|
かじる|kajiru|噛る|to chew; to bite (at); to gnaw; to nibble; to munch; to crunch; to have a smattering of|सोचना; गोली; चबाना; परेशान करना; स्वीकार करना; व्यक्त करना; कुतरना
たえる|taeru|堪える|to bear; to stand; to endure; to put up with; to support; to withstand; to resist; to brave; to be fit for; t|भालू; खड़ा होना; सहना; सहन करना; टिके रहना
ならす|narasu|慣らす|to accustom|आदी बना; साधना; अभ्यस्त करना
あまえる|amaeru|甘える|to behave like a spoiled child; to fawn on|
ゆるむ|yurumu|緩む|to become loose; to slacken|कम करना; घटाना; धीमा करना
ゆるめる|yurumeru|緩める|to loosen; to slow down|ढीला करना; धीमा पड़ जाना; धीमा पड़
つらぬく|tsuranuku|貫く|to go through|सहना; पूरा करना; अच्छी तरह से प्रयोग करना
まちがう|machigau|間違う|to make a mistake; to be incorrect; to be mistaken|
まるめる|marumeru|丸める|to make round; to round off; to roll up; to curl up; to seduce; to cajole; to explain away|समाप्त करना; गोल बनाना; जमा करना; इकट्ठा करना; हाथ से बना सिगरेट
あやぶむ|ayabumu|危ぶむ|to fear; to have misgivings; to be doubtful; to mistrust|डर
よこす|yokosu|寄こす|to send; to forward|भेजना; अग्रसर होना; आगे; प्रस्तुत करना
よりかかる|yorikakaru|寄り掛かる|to lean against; to recline on; to lean on; to rely on|आश्रित रहना; डर ध्मका कर असर डालने की कोशिश करना; आश्रित
かぶれる|kabureru|気触れる|to react to; to be influenced by; to go overboard for|
しるす|shirusu|記す|to note; to write down|ध्यान; कीर्ति; ध्यान देना; लिखना; कम होना; घाट
おこす|okosu|起こす|to raise; to cause; to wake someone|करना; निकालना; उत्तेजित करना; करना; कारण बनना; देना
あざむく|azamuku|欺く|to deceive|धोखा; धोखा देना; विश्वासघात करना
すくう|sukuu|掬う|to scoop; to ladle out|पाना; बनाना; पहले ही खबर देना
なじる|najiru|詰る|to rebuke; to scold; to tell off|डाँट डपट; फटकारना; फटकार; फटकारना; डाँटना; किसी पर गुस्सा होना या डाटना
さかのぼる|sakanoboru|逆上る|to go back; to go upstream; to make retroactive|बदलना; उठाना; वापस
やすめる|yasumeru|休める|to rest; to suspend; to give relief|आराम; लटकाना; स्थगित करना; निलम्बित करना
およぶ|oyobu|及ぶ|to reach; to come up to; to amount to; to befall; to happen to; to extend; to match; to equal|पाना; फैलना; फैलाना; टोकना; चलना; संबोधित करना; बनना; के बराबर होना; का कुल योग होना
せかす|sekasu|急かす|to hurry; to urge on|जल्दी करना; प्रोत्साहित; प्रोत्साहित करना; दबाव डालना
くちる|kuchiru|朽ちる|to rot|सड़ाना; सड़ना
たまう|tamau|給う|to receive; to grant|प्राप्त करना; स्वीकार करना; देना; अनुदान
しいる|shiiru|強いる|to force; to compel; to coerce|बल; गुण; दल; मजबूर; जबरदस्ती कराना; विवश करना; मजबूर करना; जबरदस्ती करना; मजबूर
つよまる|tsuyomaru|強まる|to get strong; to gain strength|
つよめる|tsuyomeru|強める|to strengthen; to emphasize|शक्ति बढ़ना; मजबूत करना; मजबूत होना; महत्त्व; महत्त्व देना; बल देना
ねだる|nedaru|強請る|to tease; to coax; to solicit; to demand|शरारत; परेशान करना; शरारती; मनाना; उकसाना; फँसाना; प्रेम निवेदन करना
おびえる|obieru|怯える|to become frightened; to have a nightmare|
おそれいる|osoreiru|恐れ入る|to be filled with awe; to feel small; to be amazed; to be surprised; to be disconcerted; to be sorry; to b|
おどかす|odokasu|脅かす|to threaten; to coerce|धमकाना; घटित होना; सूचना देना; मजबूर करना; जबरदस्ती करना; मजबूर
おどす|odosu|脅す|to threaten; to menace|धमकाना; घटित होना; सूचना देना; हानिकारक; धमकी; कष्टकारी
きょうじる|kyoujiru|興じる|to amuse oneself; to make merry|मौज मनाना; मौज करना
あおぐ|aogu|仰ぐ|to look up (to); to respect; to depend on; to ask for; to seek; to revere; to drink; to take|मिलना; सुधरना; खोजना; ध्यान; ध्यान रखना; प्रशंसा करना; निर्भर होना; आश्रित रहना; पर भरोसा
おっしゃる|ossharu|仰っしゃる|to say; to speak; to tell; to talk|कहना; बोलना; बताना
こごらす|kogorasu|凝らす|to freeze; to congeal|जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना
こごる|kogoru|凝る|to congeal; to freeze|जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना
まがる|magaru|曲がる|to turn; to bend|मोड़ना; झुकाना; बदलना; खराब
つとまる|tsutomaru|勤まる|to be fit for; to be equal to; to function properly|
きんじる|kinjiru|禁じる|to prohibit|रोकना; मना करना; निषेध करना
きんずる|kinzuru|禁ずる|to forbid; to suppress|रोकना; मना करना; वर्जित करना; रोकना; समाप्त करना; दबाना/दमन करना
ちかづく|chikazuku|近付く|to approach; to get near; to get acquainted with; to get closer|पद्धति; सन्निकर्ष; समीप आना
くるしめる|kurushimeru|苦しめる|to torment; to harass; to inflict pain|सताना; मुसीबत; अभिशाप; परेशान करना; तंग करना; तंग
かける|kakeru|駆ける|to run (race  esp. horse); to gallop; to canter|दौड़ना; सरपट; सरपट दौड़ना; सरपट चाल; सरपट; कदम चाल; कदम चाल चलाना
むらがる|muragaru|群がる|to swarm; to gather|समूह; झुण्ड; भीड़; प्राप्त करना; समझना; काटना
かたむく|katamuku|傾く|to incline toward; to slant; to lurch; to heel over; to be disposed to; to trend toward; to be prone to; to|दृष्टिकोण; तिरछा करना; तिरछा; झटका; झटका खाना; जहाज़ का यकायक उलट जाना
かたむける|katamukeru|傾ける|to incline; to list; to bend; to lean; to tip; to tilt; to slant; to concentrate on; to ruin (a country); to|प्रोत्साहित; प्रोत्साहित करना; प्रेरित करना; किनारा; मेंड़; झुकना; झुकाना; बदलना; खराब
ちぎる|chigiru|契る|to pledge; to promise; to swear|वचन; वादा करना; वादा; वादा; गाली देना; कसम; वचन देना
めぐむ|megumu|恵む|to bless; to show mercy to|सुखसमृध्दिसंपन्न करना; आराधना करना; वरदान
かかげる|kakageru|掲げる|to publish; to print; to carry (an article); to put up; to hang out; to hoist; to fly (a sail); to float (a|लिखना; प्रकाशित होना; पेश करना; लगाना; प्रति; प्रभावित करना; ले जाना
たずさわる|tazusawaru|携わる|to participate; to take part|भाग लेना; भागीदार होना; शरीक होना; भग लेना; तरफ़दारी करना
へる|heru|経る|to pass; to elapse; to experience|पास करना; बीत; बीत जाना; बीतना/व्यतीत होना/गुजर जाना/चला जाना; अनुभव करना; अनुभव; अनुभूति
つぐ|tsugu|継ぐ|to succeed|कामयाबी हासिल करना; का जगह; कामयाब होना
かく|kaku|欠く|to lack; to break; to crack; to chip|कमी; अभाव; कमी के कारण; तोड़ना; करना; पता; मौका
きまる|kimaru|決まる|to be decided; to be settled; to look good in (clothes)|
むすびつく|musubitsuku|結び付く|to be connected or related; to join together|
むすびつける|musubitsukeru|結び付ける|to combine; to join; to tie on; to attach with a knot|मिलना[मिलाना]; जत्था; मिलाना; शामिल होना; चिपका; चिपका हुआ
とぐ|togu|研ぐ|to sharpen; to grind; to scour; to hone; to polish; to wash (rice)|तेज़ हो जाना; तेज़ करना; रगड़ना; चक्की; रगड़ देना; छान डालना; रगड़ कर साफ़ करना; छान मारना
みせびらかす|misebirakasu|見せびらかす|to show off; to flaunt|दिखाना; इतराना; क प्रदर्शन करना; दिखावा; घमण्ड से दिखाना; किसी  बात पर इतराना
みかける|mikakeru|見掛ける|to (happen to) see; to notice; to catch sight of|देखकर; सूचना; चेतावनी; देखना; एक झलक देखना
みあわせる|miawaseru|見合わせる|to exchange glances; to postpone; to suspend operations; to refrain from performing an action|आगे बढाना; स्थगित करना
みわたす|miwatasu|見渡す|to look out over; to survey (scene); to take an extensive view of|दर्शाना; सर्वेक्षण; सर्वेक्षण करना
みのがす|minogasu|見逃す|to miss; to overlook; to leave at large|चूकना; के उपर से दिखना; अन्देकी करना; क्षमा
みおとす|miotosu|見落とす|to overlook; to fail to notice|के उपर से दिखना; अन्देकी करना; क्षमा
へりくだる|herikudaru|謙る|to deprecate oneself and praise the listener|
やりとおす|yaritoosu|遣り通す|to carry through; to achieve; to complete|कार्यान्वित करना; सफलतापूर्वक पूरा करना; कठिन समय में किसी की सहायता करना; पाना; प्राप्त करना; पूरा कर देना; पूरा
やる|yaru|遣る|to do; to have sexual intercourse; to kill; to give (to inferiors  animals  etc.); to dispatch (a letter|करना; मारना
あらわれる|arawareru|現われる|to appear; to come in sight; to become visible; to come out; to embody; to materialize; to express oneself|दिखना
よびとめる|yobitomeru|呼び止める|to challenge; to call somebody to halt|टोकना; दावा करना; ललकार
かためる|katameru|固める|to harden; to freeze; to fortify|द्र्ढ बन्ना; पक्का; पक्का बन्ना; जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना; पुष्ट; सशक्त करना; पुष्ट करना
ほこる|hokoru|誇る|to boast of; to be proud of|
またがる|matagaru|跨がる|to extend over or into; to straddle|दोनों ओर फैला होना; बताने के लिये अनिच्छुक होना; दोनों ओर टाँगें करके बैठना
またぐ|matagu|跨ぐ|to straddle|दोनों ओर फैला होना; बताने के लिये अनिच्छुक होना; दोनों ओर टाँगें करके बैठना
かえりみる|kaerimiru|顧みる|to look back; to turn around; to review|तैयार करना; याट्रा के लिए तैयार होना; कायापलट; परखना; सर्वेक्षण; पुनःपरीक्षण
くれる|kureru|呉れる|to give; to let one have; to do for one; to be given|देना
さとる|satoru|悟る|to attain enlightenment; to perceive; to understand; to discern|अर्थ लगाना; देखना; महसूस करना; समझना
あやまる|ayamaru|誤る|to make a mistake|
ごまかす|gomakasu|誤魔化す|to deceive; to falsify; to misrepresent|धोखा; धोखा देना; विश्वासघात करना; हेरफेर करना; गोलमाल करना; गोलमाल; हेरफेर करना; हेरफेर; गलत ढंग से पेश करना
まじえる|majieru|交える|to mix; to converse with; to cross (swords)|मिलना; मिश्रण; मिलाना; पार करना
かわす|kawasu|交わす|to exchange (messages); to dodge; to parry; to avoid; to turn aside|करना; बदल देना; केन्द्र; झटके से चले जाना; झटके से चले; टाल जाना; बचाव; वार बचाना; टाल मटोल
まじわる|majiwaru|交わる|to cross; to intersect; to associate with; to mingle with; to interest; to join|पार करना; परस्पर काटना; एक दूसरे को काटना; आर पार करके विभाजित करना
くちずさむ|kuchizusamu|口ずさむ|to hum something; to sing to oneself|
ひろまる|hiromaru|広まる|to spread; to be propagated|फैलना; प्रकार; फैलाना
あわてる|awateru|慌てる|to become confused (disconcerted  disorganized)|
"""), "ja", "N4", "kanji"),

        Lesson("kw-adv", "⚡ Adverbs & Quantity · 副詞・量", "⚡", "246 kanji words", kw("""
もういちど|mouichido|もう一度|again|फिर
いっしょ|issho|一緒|together|साथ
みなさん|minasan|皆さん|everyone|हर कोई
けっこう|kekkou|結構|splendid; enough|शानदार; बहुत बढ़िया; उजागर; पर्याप्त
ときどき|tokidoki|時々|sometimes|कभी-कभी
初め/始め||初め/始め|beginning|शुरुआत
はじめて|hajimete|初めて|for the first time|पहली बार
ちいさい|chiisai|小さい|little|छोटा
ちいさな|chiisana|小さな|little|छोटा
すこし|sukoshi|少し|few|अल्प; थोड़ा; कई
すくない|sukunai|少ない|a few|थोड़्; कुछ
ぜんぶ|zenbu|全部|all|सब
おおい|ooi|多い|many|कई
おみまい|omimai|お見舞い|calling on someone who is ill; enquiry|आजीविका; व्यवसाय; जीवन; पूछताछ
いじょう|ijou|以上|more than; this is all|अधिक; अंश तक; की तुलना में
いっしょうけんめい|isshoukenmei|一生懸命|with utmost effort|
みな|mina|皆|everybody|सभ लोग; प्रत्येक व्यक्ति; हर कोई
たしか|tashika|確か|definite|स्पष्ट; निश्चित
きゅう|kyuu|急|urgent; steep|तुरंत; अत्यावश्यक; ताकीदी; अत्यधिक; बेतुका; भिगोना
けっして|kesshite|決して|never|कभी नहीं
さいご|saigo|最後|last; end|आखिरी; अंत
さいしょ|saisho|最初|beginning; first|शुरुआत; पहला
こまかい|komakai|細かい|small; fine|छोटा; ठीक
さびしい|sabishii|寂しい|lonely|शान्त; अकेला; एकांत
じゅうぶん|juubun|十分|enough|पर्याप्त
ことり|kotori|小鳥|small bird|छोटा
もうす|mousu|申す|(humble) to be called; to say|कहना
すいどう|suidou|水道|water supply|जल आपूर्ति; जल संचय
だいたい|daitai|大体|generally|अक्सर; प्रा; व्यापक रुप से
だいぶ|daibu|大分|greatly|अत्यन्त; बहुत ही; बहुत
なかなか|nakanaka|中々|considerably|अत्याधिक; बहुत अधिकता से
とくに|tokuni|特に|particularly; especially|विशेष रुप; खास तौर पर; विशेष रुप से; खास तौर पर; विशेष रूप से; विशेषतः/विशेष रूप से
とっきゅう|tokkyuu|特急|limited express train (faster than an express train)|सीमित; मर्यादित
とくべつ|tokubetsu|特別|special|विशेष
ひじょうに|hijouni|非常に|extremely|अत्यधिक; बहुत ही; बहुत
かならず|kanarazu|必ず|certainly; necessarily|निश्चित रूप से; निःसन्देह; अवश्य; आवश्यक रूप; आवश्यक रूप से; अनिवार्य रूप से
ふつう|futsuu|普通|usually; or a train that stops at every station|आमतौर पर
へんじ|henji|返事|reply|उत्तर देना; जवाब देना; उत्तर
うら|ura|裏|reverse side|बदल देना; उल्टा; विपत्ति
ある|aru|或|a certain...; some...|अनिवार्य; विश्वसनीय; नियत; कुछ
いじょう|ijou|異常|strangeness; abnormality; disorder|अनभिज्ञता; अजनबीपन; सनकीपन; अनियमितता; असामन्यता; विकार; परेशानी; अव्यवस्था
いっそう|issou|一層|much more; still more; all the more|बहुत; और अधिक
いちどに|ichidoni|一度に|all at once|अचानक; एक साथ
いちばん|ichiban|一番|best; first; number one|सर्वश्रेष्ठ; पहला; स्वयंअ; प्रथम कोटि का
なにか|nanika|何か|something|कुछ
なんでも|nandemo|何でも|by all means; everything|अवश्य; सब कुछ
なんとか|nantoka|何とか|somehow; anyhow; one way or another|किसी भी तरह; किसी कारण से; जैसे तैसे; किसी भी तरह; फिर भी; हर हालत; किसी भी तरह
かげん|kagen|加減|addition and subtraction; allowance for|अनुवृद्धि; वृद्धि; जोड़; छूट; भत्ता; वृति
かいふく|kaifuku|回復|recovery (from illness); improvement; rehabilitation; restoration|स्वाथ्य; प्रतिलाभ; स्वास्थ्यलाभ; सुधार; प्रगति; उन्नति; परती; परती ज़मीन का कृषीकरण; पुनः
みな|mina|皆|all; everyone; everybody|सब; हर कोई; सभ लोग; प्रत्येक व्यक्ति; हर कोई
かくじつ|kakujitsu|確実|certainty; reliability; soundness|निश्चय; निश्चितता; विश्वसनीयता; विश्वासयोग्य,विश्वसनीयता,; स्वस्थता; समझदारी; मजबूती
かくにん|kakunin|確認|affirmation; confirmation|प्रतिज्ञापन; दृढ़ वचन; अभिपुष्टि; सत्यापन; पुष्टीकरण; पुष्टिकरण
かんぜん|kanzen|完全|perfection; completeness|निपुणता; सब प्रकार से संतोषप्रद; संपूर्णता/निर्दोषता; संपूर्णता
いくつ|ikutsu|幾つ|how many?; how old?|कैसे; कैसे
いくら|ikura|幾ら|how much?; how many?|कितना; कैसे
すでに|sudeni|既に|already; too late|पहले ही; भी
よろしい|yoroshii|宜しい|(hon) good; OK; all right; fine; very well; will do; may; can|अच्छा; ठीक; ठीक; स्वस्थ; निःसन्देह
ぎゃく|gyaku|逆|reverse; opposite|बदल देना; उल्टा; विपत्ति; उल्टा; के सामने; विरोधी
きゅうげき|kyuugeki|急激|sudden; precipitous; radical|आकस्मिक; अचानक; शीघ्र; त्वरित; उतावली में किया गया; प्रपाती; अतिवादी; विलक्षण; सुधारवादी
きゅうそく|kyuusoku|急速|rapid (e.g. progress)|द्रुतगामी; त्वरित; तत्काल
きょうきゅう|kyoukyuu|供給|supply; provision|आपूर्ति करना; की; पूर्ति; खाद्य सामग्री; व्यवस्था; विधान
ごく|goku|極|quite; very|पूर्णतया; नितान्त; अत्यन्त; बहुत
わずか|wazuka|僅か|only; merely; a little; small quantity|केवल; केवल; मात्र; थोड़ा
ちかごろ|chikagoro|近頃|lately; recently; nowadays|हाल में; हाल ही में; हाल ही में; अभी अभी; हाल मेँ; आजकल
たまたま|tamatama|偶々|casually; unexpectedly; accidentally; by chance|सादे ढंग से; यूँ ही; यूँ; अचानक; अकस्मात; अनपेक्षित ढंग; अचानक; संयोगवश; अचानक ही
ぐうぜん|guuzen|偶然|(by) chance; unexpectedly; suddenly|अवसर; आकस्मिक; मौका; अचानक; अकस्मात; अनपेक्षित ढंग; अचानक
けっきょく|kekkyoku|結局|after all; eventually|आख़िर; आख़िरकार; अंत में; आखिरकार; अंततोगत्वा
さらに|sarani|更に|furthermore; again; after all; more and more; moreover|इसके; इसके अलावा; ऊपर से; फिर; आख़िर; आख़िरकार
ふたたび|futatabi|再び|again; once more; a second time|फिर; एक बार फिर
もっとも|mottomo|最も|most; extremely|सबसे अधिक; अत्यधिक; बहुत ही; बहुत
さいしゅう|saishuu|最終|last; final; closing|आखिरी; अंतिम; अन्तिम; अंतिम चरण
おもに|omoni|主に|mainly; primarily|मुख्य रूप से; प्रमुख रूप से; मुख्य रुप; मुख्यतः; मुख्य रुप से
じょじょに|jojoni|徐々に|slowly; little by little; gradually; steadily; quietly|आहिस्ता; विलंबित में; विलंबित; धीरे धीरे; धीरे धीरे; अल्पाशः
しょうしょう|shoushou|少々|just a minute; small quantity|एक मिनट रुकिए; छोटा
すこしも|sukoshimo|少しも|anything of; not one bit|कुछ; कुछ भी
くわしい|kuwashii|詳しい|knowing very well; detailed; full; accurate|सुशिक्षित; जानकार; जानना; विस्तृत; व्यौरेवार; भरा
じょうとう|joutou|上等|superiority; first class; very good|वरिष्टता; उत्कृष्टता; श्रेष्ठता; उत्कृष्ट; प्रथम श्रेणी का; पहला दर्जा
つねに|tsuneni|常に|always; constantly|हमेशा; लगातार; सदा
じょうしき|joushiki|常識|common sense|व्यावहारिक बुद्धि; व्यावहारिक
ついに|tsuini|遂に|finally; at last|अंत में; आखिरकार; अंततोगत्वा; आखिरकार; अंत मेँ
ずいぶん|zuibun|随分|extremely|अत्यधिक; बहुत ही; बहुत
ぜひ|zehi|是非|certainly; without fail|निश्चित रूप से; निःसन्देह; अवश्य; निःसन्देह; हमेशा
せいかく|seikaku|正確|accurate; punctuality; exactness; authenticity; veracity|ठीक; अचूक; सही; समय की पाबंदी; समय; सटीकपन
せいぜい|seizei|精々|at the most; at best; to the utmost; as much (far) as possible|अधिक से अधिक; बहुत अच्छा; चरमोत्कर्ष पर; ज़्यादा से ज़्यादा; चरम सीमा
ぜったい|zettai|絶対|absolute; unconditional; absoluteness|पूर्णतया; परम; पूर्ण; स्पष्ट; अप्रतिबंधित; बिना शर्त; संपूर्णता; सुनिश्चितता; दृढ़ता
まず|mazu|先ず|first (of all); to start with; about; almost; hardly (with neg. verb)|पहला; प्रारम्भ में; पहली बात तो; के बारे में
ぜん|zen|全|all; whole; entire; complete; overall; pan|सब; पूरी तरह से; पूर्णतया; पूरा; कुल; पूरा; संपूर्ण
まったく|mattaku|全く|really; truly; entirely; completely|वास्तव में; वास्तव में; सचमुच; सही अर्थों में; पूरी तरह से; पूरी तरह; सम्पूर्णतया
すべて|subete|全て|all; the whole; entirely; in general; wholly|सब; पूरी तरह से; पूर्णतया; पूरा; पूरी तरह से; पूरी तरह; सम्पूर्णतया
ぜんいん|zenin|全員|all members (unanimity); all hands; the whole crew|
ぜんぜん|zenzen|全然|(1) wholly; entirely; completely; (2) not at all (with neg. verb)|पूरी तरह से; पूरी तरह; पूरी तरह से; पूरी तरह; सम्पूर्णतया; भरपूर; पूरी तरह से; पूरी तरह
ぜんたい|zentai|全体|whole; entirety; whatever (is the matter)|पूरी तरह से; पूर्णतया; पूरा; संपूर्णता; सम्पूर्णता; अशेषता; कुछ भी; जो भी; जो कुछ भी
そうち|souchi|装置|equipment; installation; apparatus|उपकरण; तैयारी; लगाना; नियुक्ति; प्रतिष्ठापन; सामान; उपकरण; जंतर
そんけい|sonkei|尊敬|respect; esteem; reverence; honour|ध्यान; ध्यान रखना; प्रशंसा करना; सम्मान करना; आदर; आदर/सम्मान; श्रद्धा; आदर
たしょう|tashou|多少|more or less; somewhat; a little; some|लगभग; करीब करीब; कमोवेश; कुछ; किंचित; थोड़ा बहुत; थोड़ा
たぶん|tabun|多分|perhaps; probably|हो; शायद; संभवतः; सम्भवतः; शायद; संभवतः
おおいに|ooini|大いに|very; much; greatly|बहुत; बहुत; अत्यन्त; बहुत ही; बहुत
おおや|ooya|大家|rich family; distinguished family|अमीर; उत्कृष्ट; विलक्षण; विशिष्ट
たいてい|taitei|大抵|usually; generally|आमतौर पर; अक्सर; प्रा; व्यापक रुप से
たいはん|taihan|大半|majority; mostly; generally|बहुमत; अधिकांश; वयस्कता; प्रायः; मूख्य रुप से; अक्सर; प्रा; व्यापक रुप से
たいへん|taihen|大変|awful; dreadful; terrible; very|नृशंस; भद्दा; डरावना; भद्दा; शोचनीय; डरावना; भयानक
たに|tani|谷|valley|दर्रा; घाटी; निम्नभूमि
たんに|tanni|単に|simply; merely; only; solely|पूरी तरह से; आसानी से; केवल; केवल; मात्र; केवल
じき|jiki|直|earnestly; immediately; exactly|ईमानदारी; ईमानदारी से; नम्रतापूर्वक; ठीक; उसी समय; तत्काल; वास्तव में; ठीक ठीक/यथार्थतः; वास्तव
じかに|jikani|直に|immediately; readily; directly|ठीक; उसी समय; तत्काल; तरन्त ही; सरलता से; सरलता; सीधे; जल्दी; तुरन्त
どうじ|douji|同時|simultaneous(ly); concurrent; same time; synchronous|एक; एक साथ हुआ; एक साथ होने वाला; समवर्ती; समान
とつぜん|totsuzen|突然|abruptly; suddenly; unexpectedly; all at once|अचानक; रूखेपन से; अचानक ही; अचानक; अचानक; अकस्मात; अनपेक्षित ढंग
にちじょう|nichijou|日常|ordinary; regular; everyday; usual|साधारण; स्वाभाविक; सामान्य; रोज का ग्राहक; योग्य; मठजीवी; साधारण; प्रतिदिन; एक
はいたつ|haitatsu|配達|delivery; distribution|वितरण; सुपुर्दगी; प्रसव; वितरण; विभाजन; वितरनअ
かれら|karera|彼等|they (usually male)|वे
ひじょう|hijou|非常|emergency; extraordinary; unusual|एमर्जेंसी; आपात; आपात काल; असाधारण; विशेष; अनोखी; अपूर्व; असाधारण; असामान्य
かならずしも|kanarazushimo|必ずしも|(not) always; (not) necessarily; (not) all; (not) entirely|हमेशा; आवश्यक रूप; आवश्यक रूप से; अनिवार्य रूप से; सब
ふだん|fudan|普段|usually; habitually; ordinarily; always|आमतौर पर; आदतन; आदत से; सामान्य रूप से; सामान्यतया
べつに|betsuni|別に|(not) particularly; nothing|विशेष रुप; खास तौर पर; विशेष रुप से; कुछ नहीं
ほんとう|hontou|本当|truth; reality|वास्त्विकता; सत्यता; वास्तविकता; असलियत; ह्कीकत; वास्तविकता
また|mata|又|again; and|फिर; और
まんいち|manichi|万一|by some chance; by some possibility; if by any chance; 10E4:1 odds|
まだ|mada|未だ|yet; still; more; besides|अभी तक; फिर भी; अधिक
めいかく|meikaku|明確|clear up; clarify; define|ठीक होना; साफ़ सुथरा करना; सुलझाना; शुद्ध करना; स्पष्टीकरण देना; स्पष्ट करना; बताना; सीमांकन करना; स्पष्ट करना
めったに|mettani|滅多に|rarely (with neg. verb); seldom|कभी; कदाचित; कभी कभार; बिरले ही/कभी कभार; शायद; कभी कभार
もちろん|mochiron|勿論|of course; certainly; naturally|निस्सन्देह; अवश्य ही; कभी तो; निश्चित रूप से; निःसन्देह; अवश्य; प्राकृतिक रुप से; बेशक; स्वभाविक रूप से
やく|yaku|約|approximately; about; some|लगभग; करीब करीब; तकरीबन रूप से; के बारे में; कुछ
ゆいいつ|yuiitsu|唯一|only; sole; unique|केवल; तल्ला; पूरा; कुकुरजीभी; अनोखा; अद्वितीय; अपूर्व
よぼう|yobou|予防|prevention; precaution; protection against|रोकथाम; रोक थाम; गर्भनिरोधक उपाय; एहतियात; सावधानी; संरक्षण; बचाव; घूस
あまり|amari|余り|not very (used as adverb); not much|ज़्यादा नहीं
おさない|osanai|幼い|very young; childish|बचकाना; लड़कपन की सी; बच्चौं
あんがい|angai|案外|unexpectedly|अचानक; अकस्मात; अनपेक्षित ढंग
いちおう|ichiou|一応|once; tentatively; in outline; for the time being|एक बार; आज़माइशी तौर पर
いっせい|issei|一斉|simultaneous; all at once|एक; एक साथ हुआ; अचानक; एक साथ
いちりゅう|ichiryuu|一流|first class; top grade; foremost; top-notch|उत्कृष्ट; प्रथम श्रेणी का; पहला दर्जा; ऊपर; सर्वाधिक; प्रधान; सर्वश्रेष्ठ
はたして|hatashite|果して|as was expected; really|वास्तव में
かいとう|kaitou|回答|reply; answer|उत्तर देना; जवाब देना; उत्तर; जवाब
あらためて|aratamete|改めて|another time; again; over again; anew; formally|भिन्न; दूसरा; एक अन्य; फिर; एक बार फिर
おのおの|onoono|各々|each; every; either; respectively; severally|प्रत्येक; हर; दोनों में से
かくち|kakuchi|各地|every place; various places|हर; भिन्न; कई; अनेक
かくりつ|kakuritsu|確率|probability|सम्भाविकी; सम्भावना; सम्भाव्यता
わりと|warito|割と|relatively; comparitively|पूर्णतया; अपेक्षाकृत; तुलनात्मक रूप से
かんむり|kanmuri|冠|crown; diadem; first; best|शिखर; सिर पर मारना; सिर; पहला
まもなく|mamonaku|間も無く|soon; before long; in a short time|जल्द ही; पहले
かえって|kaette|却って|on the contrary; rather; all the more; instead|बल्कि; अधिक; निःसन्देह; अपेक्षाकृत
さかさ|sakasa|逆さ|reverse; inversion; upside down|बदल देना; उल्टा; विपत्ति; उलटाव; उल्टा; अस्त व्यस्त; अस्तव्यस्त
きゅうよ|kyuuyo|給与|allowance; grant; supply|छूट; भत्ता; वृति; स्वीकार करना; देना; अनुदान; आपूर्ति करना; की; पूर्ति
きょうしゅく|kyoushuku|恐縮|shame; very kind of you; sorry to trouble|कम दिखाना; बाध्य करना; बदनाम करना; माफ़ करना
もともと|motomoto|元々|originally; by nature; from the start|स्पष्टतः; आदि में; शुरु शुरु में
げんに|genni|現に|actually; really|वास्तव में; वस्तु; सचमुच; वास्तव में
ごめん|gomen|御免|your pardon; declining (something); dismissal; permission|तुम्हारा; घटता; उपेक्षा करना; बरख़ास्तगी
さしひき|sashihiki|差し引き|deduction; subtraction; balance; ebb and flow; rise and fall|घटाना; घटाव; कटौती; घटाना; घटाव; व्यवकलन; बराबर करना; हिचकिचाना; सँभालना
のこらず|nokorazu|残らず|all; entirely; completely; without exception|सब; पूरी तरह से; पूरी तरह; सम्पूर्णतया; भरपूर; पूरी तरह से; पूरी तरह
しじゅう|shijuu|始終|continuously; from beginning to end|लगातार
あぶら|abura|脂|fat; tallow; lard|मोटा; चर्बी लगाना; चर्बी; सुअर की चर्बी; सुअर की चर्बी लगाना
しきゅう|shikyuu|至急|urgent; pressing|तुरंत; अत्यावश्यक; ताकीदी; दबाव; अत्यावश्यक; दबाव डालकर वस्तु बनाना
しょきゅう|shokyuu|初級|elementary level|साधारण; प्रारंभिक; आरंभिक स्तर की
しょじゅん|shojun|初旬|first 10 days of the month|पहला
いきいき|ikiiki|生き生き|vividly; lively|सजीव ढंग से; फुर्तीला; सक्रिय; प्रफुल्ल
たえず|taezu|絶えず|constantly|लगातार; सदा
ようやく|youyaku|漸く|gradually; finally; hardly|धीरे धीरे; अल्पाशः; अंत में; आखिरकार; अंततोगत्वा; मुश्किल; शायद ही; मुश्किल से
ぜんしゅう|zenshuu|全集|complete works|पूरा
ぜんしん|zenshin|全身|the whole body; full-length (portrait)|
ぜんぱん|zenpan|全般|(the) whole; universal; wholly; general|पूरी तरह से; पूर्णतया; पूरा; सामान्य; मशीन का सर्वक्षम; सामान्य प्रत्यय; पूरी तरह से; पूरी तरह
そくたつ|sokutatsu|速達|express; special delivery|बताना; प्रकट; प्रकट करना; विशेष वितरण; विशेष वितरण सेवा
ぞくぞく|zokuzoku|続々|successively; one after another|बारी बारी से; क्रमशः; बारी बारी; एक एक करके
たいして|taishite|大して|(not so) much; (not) very|बहुत; बहुत
たいそう|taisou|大層|very much; exaggerated; very fine|बहुत ही; अतिरंजित
だいぶ|daibu|大分|considerably; greatly; a lot|अत्याधिक; बहुत अधिकता से; अत्यन्त; बहुत ही; बहुत; बहुत सारा; कहीं
たき|taki|滝|waterfall|जलप्रपात; झरना; निर्झर
ただし|tadashi|但し|but; however; provided that|लेकिन; फिर भी; तब भी; जैसे भी; बशर्ते कि
ちゃくちゃく|chakuchaku|着々|steadily|निरंतर; स्थिरतापूर्वक
ちょうか|chouka|超過|excess; being more than|बहुत अधिक; अधिशेष; अधिकता; जीवन; स्वभाव; प्राणी
ていか|teika|低下|fall; decline; lowering; deterioration|गिरना; घटना; गिरावट; कम
てきかく|tekikaku|的確|precise; accurate|ठीक; स्पष्ट; नियत; ठीक; अचूक; सही
てきかく|tekikaku|適確|precise; accurate|ठीक; स्पष्ट; नियत; ठीक; अचूक; सही
てんてん|tenten|点々|here and there; little by little|इधर उधर; धीरे धीरे
ひかくてき|hikakuteki|比較的|comparatively; relatively|तुलनात्मक; तुलनात्मक रूप से; पूर्णतया; अपेक्षाकृत; तुलनात्मक रूप से
ものすごい|monosugoi|物凄い|earth-shattering; staggering; to a very great extent|चौंका देने वाला
べつべつ|betsubetsu|別々|separately; individually|अलग; अलग अलग; स्वतंत्र रूप से; व्यक्तिगत रूप से; एक एक कर के; एक एक
ほんらい|honrai|本来|essentially; naturally; by nature|अनिवार्य रूप से; तत्त्वतः; प्राकृतिक रुप से; बेशक; स्वभाविक रूप से
めんどうくさい|mendoukusai|面倒臭い|bother to do; tiresome|परेशान करना; कष्ट देना; परेशानी; तकलीफ़देह; उबाऊ; थकानेवाला
よけい|yokei|余計|too much; unnecessary; abundance; surplus; excess; superfluity|भी; अनावश्यक/व्यर्थ; अनावश्यक; फ़ुजूल; बहुलता; प्रचुरता; अधिकता/अपार
れんごう|rengou|連合|union; alliance|संयोग; संघ; ग्रेट ब्रिटेन; समझौता; मैत्रीपूर्ण संबंध; गठबंधन
かもしれない|kamoshirenai|かも知れない|may; might; perhaps; may be; possibly|लेना; सम्भवतः; संभवतः; बल; प्रभाव; शक्ति; हो; शायद; संभवतः
このごろ|konogoro|この頃|recently|हाल ही में; अभी अभी; हाल मेँ
そのうえ|sonoue|その上|in addition; furthermore|के अतिरिक्त; इसके; इसके साथ साथ; इसके; इसके अलावा; ऊपर से
そのうち|sonouchi|その内|eventually; sooner or later; of the previously mentioned|अंत में; आखिरकार; अंततोगत्वा; कभी न कभी; आज नहीं तो कल
にもかかわらず|nimokakawarazu|にも拘らず|in spite of; nevertheless|के बावजूद; आशा के विपरीत; फिर भी; तथापि; तब भी
ある|aru|或る|a certain...; some...|अनिवार्य; विश्वसनीय; नियत; कुछ
あんのじょう|annojou|案の定|sure enough; as usual|निश्चित रूप से; सामान्यतः
いぜん|izen|依然|still; as yet|फिर भी; अभी तक
かしこまりました|kashikomarimashita|畏まりました|certainly!|निश्चित रूप से; निःसन्देह; अवश्य
いちがいに|ichigaini|一概に|unconditionally; as a rule|अप्रतिबंधित रूप से; स्पष्ट रूप से; बिना शर्त
いっかつ|ikkatsu|一括|all together; batch; one lump; one bundle; summing up|जत्था; वर्ग; खेप
いちげん|ichigen|一見|unfamiliar; never before met|अपरिचित; अनभिज्ञ; अल्पश्रुत; कभी नहीं
ひたすら|hitasura|一向|earnestly|ईमानदारी; ईमानदारी से; नम्रतापूर्वक
いっさい|issai|一切|all; everything; without exception; the whole; entirely; absolutely|सब; सब कुछ; के बिना; छोड़कर; न
いちどう|ichidou|一同|all present; all concerned; all of us|
ひっかける|hikkakeru|引っ掛ける|1.  to hang (something) on (something); to throw on (clothes); 2.  to hook; to catch; to trap; to ensnar|एक; पर निर्भर; पर निर्भर करना; दो
うそつき|usotsuki|嘘つき|liar (sometimes said with not much seriousness); fibber|झूठा; लबार; लबरा; झूठ बोलने वाला
ますます|masumasu|益々|increasingly; more and more|लगातार; बहुत ही; अधिक मात्रा में; अत्यधिक; उत्तरोत्तर; अधिकाधिक रूप से
いやいや|iyaiya|厭々|unwillingly; grudgingly; shaking head in refusal (to children)|अनिच्छा से; अनिच्छापूर्वक; बेमन से; अनिच्छा से; अनिच्छा; हिचकिचाहट से; कंपन; चंचल; काँपता हुआ
ひいては|hiiteha|延いては|not only...but also; in addition to; consequently|के अतिरिक्त; के साथ; परिणामस्वरूप; इसके; अतः/इसलिये
おうきゅう|oukyuu|応急|emergency|एमर्जेंसी; आपात; आपात काल
なにしろ|nanishiro|何しろ|at any rate; anyhow; anyway; in any case|हर हाल में; जो भी हो; जहां तक सम्भव हो; किसी भी तरह; फिर भी; हर हालत; फिर भी; भी; चाहे जैसे
なんだか|nandaka|何だか|a little; somewhat; somehow|थोड़ा; कुछ; किंचित; थोड़ा बहुत; किसी भी तरह; किसी कारण से; जैसे तैसे
なんとも|nantomo|何とも|nothing (with neg. verb); quite; not a bit|कुछ नहीं; पूर्णतया; नितान्त; अत्यन्त; बिल्कुल नहीं
なんなり|nannari|何なり|any; anything; whatever|कोई; कुछ; कुछ भी; कुछ भी; जो भी; जो कुछ भी
なにより|naniyori|何より|most; best|सबसे अधिक; सर्वश्रेष्ठ
どれ|dore|何れ|where; which; who; anyway; anyhow; at any rate|कहाँ; कौन सा; कौन
いつも|itsumo|何時も|always; usually; every time; never (with neg. verb)|हमेशा; आमतौर पर; जब भी; हर समय
どこか|dokoka|何処か|somewhere; anywhere; in some respects|कहीं भी; कहिं; कहीं; कहीं भी; कहीं
かるた|karuta|加留多|(pt:) (n) playing cards (pt: carta)|वादन
かわいらしい|kawairashii|可愛らしい|lovely; sweet|मधुर; सुहावना; मनोहर; मीठा
かなり|kanari|可成|considerably; fairly; quite|अत्याधिक; बहुत अधिकता से; पूरी तरह से; ठीक से; कामचलाऊ ढंग से; पूर्णतया; नितान्त; अत्यन्त
はたして|hatashite|果たして|as was expected; really|वास्तव में
かた|kata|過多|excess; superabundance|बहुत अधिक; अधिशेष; अधिकता; प्रचुरता
かいじょ|kaijo|解除|cancellation; rescinding; release; calling off|निरस्तीकरण; बताना; प्रदर्शन; निकालना
かいしゅう|kaishuu|回収|collection; recovery|जमाव; समूह; ढेर; स्वाथ्य; प्रतिलाभ; स्वास्थ्यलाभ
おのおの|onoono|各|each; every; either; respectively; severally|प्रत्येक; हर; दोनों में से
おのおの|onoono|各々|each; every; either; respectively; severally|प्रत्येक; हर; दोनों में से
かくしゅ|kakushu|各種|every kind; all sorts|हर
しっかり|shikkari|確り|firmly; tightly; reliable; level-headed; steady|मज़बूती; मज़बूती से; ठसाठस; कस; कस कर; भरोसेमंद; विश्वसनीय; अच्छा
かくしん|kakushin|確信|conviction; confidence|अपराध सिद्धि; दोषसिद्धि; दृढ; भरोसा; दृढ विश्वास; दृढ
かくてい|kakutei|確定|definition (math); decision; settlement|रूपरेखा की; स्पष्ट; व्याख्या; निर्णय; निर्णय करना; निर्णय शक्ति; निपटारा; समझौता; भुगतान
かくほ|kakuho|確保|guarantee; ensure; maintain; insure; secure|आशा करना; निश्चिंत होना; वचन; सुनिश्चित करना; सुनिश्चित; आश्वस्त करना; भरण पोषण करना; मरम्मत करना; निश्चयपूर्वक कहना
かくりつ|kakuritsu|確立|establishment|स्थान; संस्था; नींव
わりあて|wariate|割り当て|allotment; assignment; allocation; quota; rationing|हिस्सा; आवंटनअ; आबंटन; नियुक्ति; काम; सौंपा हुआ कार्य; निर्धारण; निर्धारित; आवंटन
わりあいに|wariaini|割合に|comparatively|तुलनात्मक; तुलनात्मक रूप से
かんど|kando|感度|sensitivity; severity (quake)|भावुकता; संवेदनशीलता; सूक्ष्मग्राहिता; कठोरता; कठिनाई; उग्रता
まま|mama|間々|occasionally; frequently|कभीकभी; बहुधा; प्रायः
まもなく|mamonaku|間もなく|soon; before long; in a short time|जल्द ही; पहले
まるまる|marumaru|丸々|completely|भरपूर; पूरी तरह से; पूरी तरह
まるっきり|marukkiri|丸っきり|completely; perfectly; just as if|भरपूर; पूरी तरह से; पूरी तरह; सितारा मछली; पूर्णतः; अच्छी तरह से; बस
まるで|marude|丸で|quite; entirely; completely; at all; as if; as though; so to speak|पूर्णतया; नितान्त; अत्यन्त; पूरी तरह से; पूरी तरह; सम्पूर्णतया; भरपूर; पूरी तरह से; पूरी तरह
いくた|ikuta|幾多|many; numerous|कई; बहुत से; बहुत ज्यादा
きょう|kyou|共|both; neither (neg); all; and; as well as; including; with; together with; plural ending|दोनों; कोई भी नहीं; न; नहीं; सब
きょうれつ|kyouretsu|強烈|strong; intense; severe|मजबूत; अत्यधिक; तीव्र; भावुक; भारी; सरल; कठोर
おそらく|osoraku|恐らく|perhaps|हो; शायद; संभवतः
まして|mashite|況して|still more; still less (with neg. verb); to say nothing of; not to mention|और अधिक; की बात तो दूर; की बात; साथ ही साथ
きわめて|kiwamete|極めて|exceedingly; extremely|अत्यन्त; बहुत सा; अत्यधिक; बहुत ही; बहुत
きん|kin|僅|a little; small quantity|थोड़ा; छोटा
きんきゅう|kinkyuu|緊急|urgent; pressing; emergency|तुरंत; अत्यावश्यक; ताकीदी; दबाव; अत्यावश्यक; दबाव डालकर वस्तु बनाना; एमर्जेंसी; आपात; आपात काल
たまに|tamani|偶に|occasionally; once in a while|कभीकभी; कभी कभी
けんぜん|kenzen|健全|health; soundness; wholesome|स्वास्थ्य; स्वस्थता; समझदारी; मजबूती; स्वस्थ; हितकारी; पौष्टिक
かねて|kanete|兼ねて|simultaneously|एक साथ
みぐるしい|migurushii|見苦しい|unsightly; ugly|भद्दा; बदसूरत
がんらい|ganrai|元来|originally; primarily; essentially; logically; naturally|स्पष्टतः; आदि में; शुरु शुरु में; मुख्य रुप; मुख्यतः; मुख्य रुप से; अनिवार्य रूप से; तत्त्वतः
げんしょう|genshou|減少|decrease; reduction; decline|घटना; कम करना; घटाना; कमी; घटाव; पदावनति; घटना; गिरावट; कम
くれぐれも|kureguremo|呉れ呉れも|repeatedly; sincerely; earnestly|कई बार; बार बार; कई; सचमुच; भवदीय; ईमनदारी से; ईमानदारी; ईमानदारी से; नम्रतापूर्वक
"""), "ja", "N4", "kanji"),

        Lesson("kw-general", "📚 General Vocabulary · 一般語彙", "📚", "1225 kanji words", kw("""
わるい|warui|悪い|bad|बुरा
くらい|kurai|暗い|gloomy|उदास; अंधकारमय; निराशजनक
やさしい|yasashii|易しい|easy; simple|आसान; सरल
いち|ichi|一|one|एक
ひとつ|hitotsu|一つ|one|एक
とおい|tooi|遠い|far|दूर
えんぴつ|enpitsu|鉛筆|pencil|पेंसिल
きたない|kitanai|汚い|dirty|गंदा
よこ|yoko|横|beside; side; width|पास; अलग; समीप; किनारा; उदारता; चौड़ाई
した|shita|下|below|नीचे
なに|nani|何|what|क्या
はいざら|haizara|灰皿|ashtray|राख दानी; राखदानी; ऐश ट्रे
そと|soto|外|outside|बाहर
かど|kado|角|a corner|कोना
めがね|megane|眼鏡|glasses|चश्मा; काँच; दूरबीन
あぶない|abunai|危ない|dangerous|घमासान; खतरनाक; डरावना
つくえ|tsukue|机|desk|मेज़
つよい|tsuyoi|強い|powerful|प्रभावशाली; सशक्त; शक्तिशाली
せまい|semai|狭い|narrow|संकरा
く|ku|九|nine|नौ
ここのつ|kokonotsu|九つ|nine|नौ
くつ|kutsu|靴|shoes|
くつした|kutsushita|靴下|socks|
かるい|karui|軽い|light|रोशनी
たてもの|tatemono|建物|building|इमारत
いぬ|inu|犬|dog|कुत्ता
ご|go|五|five|पाँच
いつつ|itsutsu|五つ|five|पाँच
こうえん|kouen|公園|park|पार्क
むこう|mukou|向こう|over there|वहाँ
ひろい|hiroi|広い|spacious; wide|विस्तृत; विशाल; बड़ा; चौड़ा
ほそい|hosoi|細い|thin|पतला
ざっし|zasshi|雑誌|magazine|पत्रिका
さん|san|三|three|तीन
みっつ|mittsu|三つ|three|तीन
かさ|kasa|傘|umbrella|छाता
よん|yon|四|four|चार
よっつ|yottsu|四つ|four|चार
わたし|watashi|私|(humble) I; myself|मैं; खुद; स्वतः
かみ|kami|紙|paper|कागज़
つぎ|tsugi|次|next|अगला
なな|nana|七|seven|सात
ななつ|nanatsu|七つ|seven|सात
わかい|wakai|若い|young|जवान
よわい|yowai|弱い|weak|कमज़ोर
じゅう とお|juu too|十|ten|दस
おもい|omoi|重い|heavy|भारी
あつい|atsui|暑い|hot|गर्म
うえ|ue|上|on top of|के ऊपर; के; के पास पास
うわぎ|uwagi|上着|jacket|जैकेट; धातु; दंत टोप
あたらしい|atarashii|新しい|new|नया
しんぶん|shinbun|新聞|newspaper|कला और विज्ञापन; विज्ञापन; कागज़
にし|nishi|西|west|पश्चिम
しずか|shizuka|静か|quiet|शांत
せんたく|sentaku|洗濯|washing|धुलाई; धुलाई के कपड़े
はやい|hayai|速い|quick|तेज़
ふとい|futoi|太い|fat|मोटा
おおきい|ookii|大きい|big|बड़ा
おおきな|ookina|大きな|big|बड़ा
たいしかん|taishikan|大使館|embassy|राजदूत; राजदूतावास
たいせつ|taisetsu|大切|important|महत्वपूर्ण
だれか|dareka|誰|who|कौन
みじかい|mijikai|短い|short|छोटा
おそい|osoi|遅い|late; slow|देर; धीमा
なか|naka|中|middle|बीच
とり|tori|鳥|bird|पक्षी
ひくい|hikui|低い|short; low|छोटा; नीचा
でんわ|denwa|電話|telephone|दूरभाष करना; फोन करना; दूरभाष
ひがし|higashi|東|east|पूर्व
どうぶつ|doubutsu|動物|animal|जानवर
おなじ|onaji|同じ|same|समान
みなみ|minami|南|south|दक्षिण
むずかしい|muzukashii|難しい|difficult|कठिन
に|ni|二|two|दो
ふたつ|futatsu|二つ|two|दो
ねこ|neko|猫|cat|बिल्ली
うすい|usui|薄い|thin; weak|पतला; कमज़ोर
はこ|hako|箱|box|डिब्बा
はち|hachi|八|eight|आठ
やっつ|yattsu|八つ|eight|आठ
はん|han|半|half|आधा
うるさい|urusai|煩い|noisy; annoying|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला; खीझ दिलाने वाला; खिझाऊ; खीझ दिलाने
ふうとう|fuutou|封筒|envelope|थैला; लिफ़ाफ़ा; एनवलप
ふく|fuku|服|clothes|कपड़े
もの|mono|物|thing|चीज़
へん|hen|辺|area|क्षेत्र
べんり|benri|便利|useful; convenient|उपयोगी; सरल; सुविधा; उचित
きた|kita|北|north|उत्तर
なく|naku|鳴く|animal noise. to chirp; roar or croak etc.|जानवर; गरजना; चिल्लाना; शोरगुल
もんだい|mondai|問題|problem|समस्या
ゆうめい|yuumei|有名|famous|उत्कृष्ट; जाना; विख्यात
ようふく|youfuku|洋服|western-style clothes|
ほしい|hoshii|欲しい|want|चाहना
すずしい|suzushii|涼しい|refreshing|स्फूर्तिदायक; ताज़गी देने वाला; ताजा
れい|rei|零|zero|शून्य
ろく|roku|六|six|छह
むっつ|muttsu|六つ|six|छह
はなし|hanashi|話|talk; story|बात करना; कहानी
おまつり|omatsuri|お祭り|festival|समारोह; त्योहार; त्यौहार/उत्सव
おいわい|oiwai|お祝い|congratulation|बधाई; बधाई सूचक वाक्य
おじょうさん|ojousan|お嬢さん|young lady|नवयुवती; युवती
おれい|orei|お礼|expression of gratitude|वचन; पदसंहति; अभिव्यक्ति
いか|ika|以下|less than|छोटा; कम माऋआ मे़; कम
いがい|igai|以外|with the exception of|
いない|inai|以内|within|में; भीतर; अंदर
いけん|iken|意見|opinion|विचार; मत; अनुमान
ため|tame|為|in order to|के लिए; के उद्देश्य से
いちど|ichido|一度|once|एक बार
とおく|tooku|遠く|distant|उदासीन; दूर; सुदूर
げしゅく|geshuku|下宿|lodging|आवास; किराये का; निवास
かいわ|kaiwa|会話|conversation|बातचीत; नाजायज़; नाजायज़ ताल्लुकात
かんごふ|kangofu|看護婦|female nurse|महिला; औरत; स्त्री जाति
かんたん|kantan|簡単|simple|सरल
かんけい|kankei|関係|relationship|नाता; संबंध; सम्बन्ध
きけん|kiken|危険|danger|खतरा
きかい|kikai|機会|opportunity|अवसर; मौका; सुअवसर
かがみ|kagami|鏡|mirror|दर्पण; शीशा; प्रतिबिम्बित करना
すみ|sumi|隅|corner; nook|कोना; कोना
かたち|katachi|形|shape|नमूना; अनुकूल बनाना; बनावट
堅/硬/固い||堅/硬/固い|hard|कठिन
きぬ|kinu|絹|silk|रेशम; रेशमी; रेशा
けんぶつ|kenbutsu|見物|sightseeing|दर्शनीय स्थल देखना
げんいん|genin|原因|cause; source|करना; कारण बनना; देना; सूत्र; जड़; स्रोत
きびしい|kibishii|厳しい|strict|सही; पक्का; सख्त
ひかり|hikari|光|light|रोशनी
こうどう|koudou|講堂|auditorium|प्रेक्षागृह
こうがい|kougai|郊外|outskirts|उपांत; बाहरी इलाका
さしあげる|sashiageru|差し上げる|(polite) to give|देना
ざんねん|zannen|残念|disappointment|आशाभंग; निराशा; क्षोभ
えだ|eda|枝|branch; twig|ज्ञान विषय; बेलबूटे; बेलबूटे काढना; टहनी; समझ में आना; समझ जाना
てら|tera|寺|temple|कनपटी; मोहरा; दिवगृह
しっぱい|shippai|失敗|failure; mistake|असफलता; गिरना; गिरावट; गलती
まわり|mawari|周り|surroundings|प्रतिवेश; परिवेश; पास पड़ोस
おわり|owari|終わり|the end|अंत
ふね|fune|舟|ship|जहाज़
やわらかい|yawarakai|柔らかい|soft|बिखरा हुआ; मुलायम; धीमा
しょうせつ|shousetsu|小説|novel|नया; उपन्यास; अनूठा
しょうかい|shoukai|紹介|introduction|प्रारंभ; प्रस्तावना; समावेशन
ふかい|fukai|深い|deep|गहरा
もうしあげる|moushiageru|申し上げる|(humble) to say; to tell|कहना; बताना
まんなか|mannaka|真中|middle|बीच
じんじゃ|jinja|神社|Shinto shrine|शिन्तो धर्म; शिन्तो
せかい|sekai|世界|the world|दुनिया
すごい|sugoi|凄い|terrific|बहुत सारा; शानदार; ज़बर्दस्त
ただしい|tadashii|正しい|correct|सही
さかん|sakan|盛ん|popularity; prosperous|लोकप्रियता; सर्वमान्यता; समृद्ध; सम्पन्न; खुशहाल
せいよう|seiyou|西洋|western countries|अमरीकी पश्चिमी सम्बधी फिल्म; पश्चिम में स्थित; पश्चिमी हवा का
せんぱい|senpai|先輩|senior|वरिष्ठ; ज्येष्ठ; अपर
せん|sen|線|line|रेखा
くさ|kusa|草|grass|घास
おくりもの|okurimono|贈り物|gift|आसान बात; गुण; प्रतिभा
かわり|kawari|代わり|substitute; alternate|स्थानापन्न व्यक्ति; स्थानापन्न; एवजी; दूसरा; हर दूसरा; एकांतरण
たな|tana|棚|shelves|
ちり|chiri|地理|geography|भूगोल
いたす|itasu|致す|(humble) to do|करना
きもの|kimono|着物|kimono|किमोनो; कीमोनो{जापानी पहनावा}
ちゅうい|chuui|注意|caution|सावधान करना; चेतावनी; आगाह करना
ちゅうしゃ|chuusha|注射|injection|सितारा मछली; इंजेक्शन; अंतःक्षेप
むし|mushi|虫|insect|कीड़ा; कीट; तुच्छ आदमी
ていねい|teinei|丁寧|polite|शिष्ट; विनम्र; सभ्य
めずらしい|mezurashii|珍しい|rare|निराला; असामान्य; दुर्लभ
どろぼう|dorobou|泥棒|thief|चोर; चौर
てきとう|tekitou|適当|suitability|उपयुक्तता
てんらんかい|tenrankai|展覧会|exhibition|प्रदर्शनी; प्रदरशनी; नुमाइश
てん|ten|点|point; dot|बिंदु; चिन्ह; बनाना; परिवहन विभाग
でんぽう|denpou|電報|telegram|तार; तार का समाचार
とちゅう|tochuu|途中|on the way|जाते वक्त; आते वक्त; रास्ते में
と|to|都|metropolitan|महानगर संबंधी; महानगरीय; महानगर वासी
つごう|tsugou|都合|circumstances; convenience|परिस्थिति; परिस्थितियाँ; सुविधा; शौचालय; मशीन
ゆ|yu|湯|hot water|गर्म
どうぶつえん|doubutsuen|動物園|zoo|चिडियाघर; जंतुशाला
はいけん|haiken|拝見|(humble) to look at|देखोगे तो
ばい|bai|倍|double|दुगुना; आना; दोहरा
はんたい|hantai|反対|opposition|बाधा; विरोध; प्रतिद्वंदी
かれら|karera|彼ら|they|वे
ひつよう|hitsuyou|必要|necessary|आवश्यक
おもて|omote|表|the front|सामने
ふべん|fuben|不便|inconvenience|कष्ट देना; कष्ट; असुविधा
ふくざつ|fukuzatsu|複雑|complexity; complication|जटिलता; जटिलता; परेशानी; उलझन
へん|hen|変|strange|निराला; अनोखा; आश्चर्यजनक
ぼうえき|boueki|貿易|trade|उद्योग; व्यापार करना; कारोबार
ぼく|boku|僕|I (used by males)|मैं
むり|muri|無理|impossible|अशिष्ट; निराशाजनक; असंभव
やくそく|yakusoku|約束|promise|वादा
よう|you|用|use|उपयोग
ようい|youi|用意|preparation|खाना; सम्पाक; अभ्यासकार्य
は|ha|葉|leaf|पत्ते निकलना; पन्ना; पत्ता
りよう|riyou|利用|utilization|उपयोग; प्रयोग
るす|rusu|留守|absence|अनुपस्थिति; अभाव; मृदु अपस्मार
ちから|chikara|力|strength; power|बल; गुण; ताकत; शक्ति
れいぼう|reibou|冷房|air conditioning|वातानुकूलक; वातानुकूलन
れきし|rekishi|歴史|history|इतिहास
れんらく|renraku|連絡|contact|सम्पर्क; सम्बन्ध; रोग
うで|ude|腕|arm|बाँह
おたがい|otagai|お互い|mutual; reciprocal; each other|पारस्परिक; आपसी; परस्पर; पारस्परिक; प्रजाति परिवर्तक संकरण; अंतर्बदल; एक; अन्योन्य; एक दूसरे
ジェット機||ジェット機|jet aeroplane|फुहार; धारा; फूट निकलना
あわれ|aware|哀れ|helpless; pity; sorrow; grief|मजबूर; बेचारा; असमर्थ; दया; खैद का विषय; स्नेह; शोक; दुःखी होना; शोक करना
あいさつ|aisatsu|挨拶|greeting; salutation|अभिवादन; अभिवादन पट्र; बधाई; अभिवादन; नमस्कार; अभिवादन शब्द
あくま|akuma|悪魔|devil; demon; evil spirit|शरारती; दुष्ट; व्यक्ति; भूत; दैत्य; शैतान; दुष्ट; बुरा; दुष्टता
あん|an|案|plan; suffix meaning draft|योजना; प्रत्यय; प्रत्यय लगाना
くらい|kurai|位|grade; rank; about|कोटि; पद; वर्गीकृत करना; समादर करना; जत्था; पद; के बारे में
いらい|irai|依頼|(1) request; commission; dispatch; (2) dependence; trust|विनती करना; अनुरोध करना; आवेदन; करना; अधिकार; कमीशन; हराना; प्रेषित करना; भेजना
いし|ishi|意思|intention; purpose|धारणा; विचार; अंतिम लक्ष्य; अभिप्राय; प्रयोजन; उद्देश्य
いしき|ishiki|意識|consciousness; senses|जानकारी; होश; चेतना , होश; इंद्रिय
いどう|idou|移動|removal; migration; movement|स्थानांतरण; निष्कासन; सरकाव; प्रवास; प्रवसन; प्रवर्जन; लय; झुकाव; गति
いじ|iji|維持|maintenance; preservation|अनुरक्षण; निर्वाह; रख; संरक्षण; परिरक्षित फल या सुरक्षित स्थान; परिरक्षण
いふく|ifuku|衣服|clothes|कपड़े
ちがい|chigai|違い|difference; discrepancy|झगड़ा; शेष; असमानता; असहमति; भिन्नता; असंगती
ちがいない|chigainai|違いない|(phrase) sure; no mistaking it; for certain|ज़रूर; निश्चयपूर्वक
いっしゅん|isshun|一瞬|a moment; an instant|महत्व; क्षण; पल; तुरंत; क्षण; क्षणिक
いっち|icchi|一致|(1) coincidence; agreement; (2) conformity|संयोग; संपात; अनुरूपता; वचन; सहमति; करार; सहमति; अनुकूलता; अनुपालन
しるし|shirushi|印|(1) mark; (2) symbol; (3) evidence|लिखना; संकेत; छाप; चिन्ह; संकेताक्षर; चिह्न; प्रमाण; साबित करना; साक्ष्य
いんさつ|insatsu|印刷|printing|छपाई; संसकरण
いんしょう|inshou|印象|impression|प्रभाव; दिखावा; धारणा
いんたい|intai|引退|retire|बाहर निकल; अवकाश लेना; पीछे हटना
いんよう|inyou|引用|quotation; citation|भाव विवरणअ; अवतरण; भाव; अवतरण; सम्मन; सम्मान पत्र
かげ|kage|陰|shade; shadow; other side|छाँव; गहराई; प्रेतात्मा; सितारा मछली; सूट्र; शरण; अन्य
はね|hane|羽|counter for birds; counter for rabbits|विरोध करना; गिनने का यंत्र; काउंटर; विरोध करना; गिनने का यंत्र; काउंटर
うそ|uso|嘘|lie; falsehood; incorrect fact; inappropriate|झूठ; झूठ; असत्यता; अनुचित; गलत; अशुद्ध
うん|un|運|fortune; luck|संयोग; सौभाग्य; भाग्य; भाग्य; नसीब या किस्मत; भाग्य होना
えさ|esa|餌|feed; bait|खिलाना; परेशान करना; चारा; सताना
かげ|kage|影|shade; shadow; other side|छाँव; गहराई; प्रेतात्मा; सितारा मछली; सूट्र; शरण; अन्य
えいきょう|eikyou|影響|influence; effect|प्रभाव; प्रभावित करना; प्रेरित करना; प्रभाव; पैदा करना; पैदा
えいよう|eiyou|栄養|nutrition; nourishment|पोषणअ; पालन; पुष्टिकारक पदार्थ; पोषण
えいきゅう|eikyuu|永久|eternity; perpetuity; immortality|अनंत; अनन्तकाल; अमरत्व; निरन्तरता; स्थायित्व; सितारा मछली; अमरत्व
するどい|surudoi|鋭い|pointed; sharp|नुकीला; सुस्पष्ट; अंकित; उच्च; कटु; विषम
えんき|enki|延期|postponement; adjournment|स्थागन; अवकाश; स्थगन; कार्यस्थगन
えんじょ|enjo|援助|assistance; aid; support|सहायता; मदद; सहायता; मदद; मदद करना; प्रमाणित करना; भरण पोषण; भरण पोषण करना
ほのお|honoo|炎|flame|प्रेमिका; चमकना; आग की ज्वाला
けむり|kemuri|煙|smoke; fumes|तम्बाकू; असफलता; धूम्रपान; भभक
さる|saru|猿|monkey|बंदर
ふち|fuchi|縁|a means; e.g. of living|उपाय; आय; साधन
おうさま|ousama|王様|king|राजा
おん|on|恩|favour; obligation; debt of gratitude|पसन्द करना; साथ देना; साथ; अनुबंध पट्र; एहसान; आभार; आभार; उधार/ऋण; कर्ज
くださる|kudasaru|下さる|(hon) to give; to confer|देना; प्रदान करना; प्रदान; परामर्श करना
けしょう|keshou|化粧|make-up (cosmetic)|
なに|nani|何|what|क्या
なんで|nande|何で|Why?; What for?|क्यों; ज़बर्दस्त फटकार
か|ka|可|passable|स्वीकार्य; कामचलाऊ; पार करने लायक
かのう|kanou|可能|possible; practicable; feasible|संभव; उपयोगी; व्यवहार्य; सुकर; सुकर; संभव/साध्य; संभव
われわれ|wareware|我々|we|हम
め|me|芽|sprout|अंकुरित होना; अंकुर; उगाना
かいけい|kaikei|会計|account; finance; accountant|खाता; आर्थिक; आर्थिक प्रबन्ध; वित्तीय; लेखाकार; मुनीम; लेखापाल
かいけつ|kaiketsu|解決|settlement; solution; resolution|निपटारा; समझौता; भुगतान; उपाय; समस्या का समाधान करने का तरीका; घोल; विश्लेषण; इरादा/संकल्प; प्रस्ताव
かい|kai|回|counter for occurrences|विरोध करना; गिनने का यंत्र; काउंटर
まわり|mawari|回り|circumference; surroundings; circulation|परिधि; घेरा; मंडल; प्रतिवेश; परिवेश; पास पड़ोस; खपत; गर्दिश; प्रचलन
かいぜん|kaizen|改善|betterment; improvement|सुधार; प्रगति; उन्नति; सुधार; प्रगति; उन्नति
はい|hai|灰|ash|ऐश वृक्ष; ऐश वृक्ष की लकड़ी; राख
せき|seki|咳|cough|देना; ध्वनी निकालना; खाँसी
かくだい|kakudai|拡大|magnification; enlargement|आवर्धन; आवर्धन शक्ति; विवर्धन; विस्तारण
かど|kado|角|horn|सींग से मारना; भोंपू; सींग का बना हुआ
かつどう|katsudou|活動|action; activity|कार्य; गतिविधि
かつよう|katsuyou|活用|conjugation; practical use|क्रियारूप; क्रियारूप संयोजन; व्यावहारिक; अभ्यास; उपयोगी
かん|kan|勘|perception; intuition; the sixth sense|अवबोधन; अभिज्ञता; अनुभूति; अन्तर्ज्ञान; अंतर्बोध; सहज ज्ञान; अतीन्द्रिय ज्ञान
かんせい|kansei|完成|(1) complete; completion; (2) perfection; accomplishment|पूरा; समाप्ति; समापन; पूरा; निपुणता; सब प्रकार से संतोषप्रद; संपूर्णता/निर्दोषता
かんりょう|kanryou|完了|completion; conclusion|समाप्ति; समापन; पूरा; समाप्ति; निष्कर्ष; अंतिम निर्णय
かんかく|kankaku|感覚|sense; sensation|दिशा; होश; ज्ञान; संवेदना; उत्तेजना; जोश
かんしゃ|kansha|感謝|thanks; gratitude|के कारण; धन्यवाद; शुक्रगुजार; कृतज्ञता; धन्यवाद
かんきょう|kankyou|環境|environment; circumstance|पर्यावरण; वातावरण; परिमंडल; दशा/अवस्था; स्थिति; परिस्थिति
かんとく|kantoku|監督|supervision; control; superintendence|निरीक्षण; पर्यवेक्षण; जिम्मेदारी; शासन; संचालन करना; निपुणता; अधीक्षण; जिम्मेदारी
くだ|kuda|管|pipe; tube|बोलना; बाँसुरी; गाना; नाली; नल; ट्यूब
かん|kan|缶|can; tin|सकना; टिन प्लेट; टिन कि पन्नी; टिन में सुरक्षित रखना
かんさつ|kansatsu|観察|observation; survey|विचार; कथन; देखरेख; दर्शाना; सर्वेक्षण; सर्वेक्षण करना
かんれん|kanren|関連|relation; connection; relevance|नाता; संबंध; रिश्तेदारी; नाता; संबन्ध; संपर्क; संबद्ध; अनुकूलता; प्रासंगिकता
まるい|marui|丸い|round; circular; spherical|वृत्त; दौर; समाप्त करना; घुमावदार; निरर्थक; गोल; गोल; गोलाकार; गोलीय
いわ|iwa|岩|rock; crag|कड़ी; हिलना; पत्थर; कूटक
ねがい|negai|願い|desire; wish; request|इच्छा; चाहना; तृष्णा; इच्छा; विनती करना; अनुरोध करना; आवेदन
もと|moto|基|basis|आधार
きほん|kihon|基本|foundation; basis; standard|आधार; प्रतिष्ठान; संस्था; आधार; दर्जा; शिष्ट; मान
きみょう|kimyou|奇妙|strange; queer; curious|निराला; अनोखा; आश्चर्यजनक; समलैंगिक पुरुष; समलैंगिक; विचित्र; अनोखा; उत्सुक; विचित्र
はた|hata|旗|flag|लम्बे बालों वाला शिकारी कुत्ता; कमज्ॅओर पड़ जाना; कम होना
きかん|kikan|機関|organ; mechanism; facility; engine|संस्थान; प्रकाशन; बाजा; प्रक्रिया; यंत्रविन्यास; तरीका; सुविधा; कौशल; सुगमता
きのう|kinou|機能|function; faculty|कार्य; प्रकार्य; कार्य करना; शक्ति; संकाय; योग्यता
きおく|kioku|記憶|memory; recollection; remembrance|स्मरण शक्ति; याद; याददाश्त; स्मरण; स्मरण शक्ति; याद; स्मरण; निशानी; याद में/स्मृति में
きしゃ|kisha|記者|reporter|सम्वाददाता; संवाददाता
きねん|kinen|記念|commemoration; memory|स्मृति; स्मरणोत्सव; उत्सव; स्मरण शक्ति; याद; याददाश्त
きちょう|kichou|貴重|precious; valuable|बहुमूल्य; उत्कृष्ट; नितान्त; बहुमूल्य; जेवर; अनमोल
ぎし|gishi|技師|engineer; technician|इंजीनियर; मिस्त्री; प्रविधिज्ञ; शिल्पी
ぎかい|gikai|議会|Diet; congress; parliament|अल्पाहार; भोजन; आहार; प्रतिनिधि; व्यवस्थापिका सभा; प्रतिनिधि सभा; संसद भवन; संसद; कानून
ぎろん|giron|議論|argument; discussion; dispute|तर्क; झगड़ा; विषय; चर्चा; बहस; आलोचनाआ; विवाद करना; झगड़ना; झगड़ा
きゅうけい|kyuukei|休憩|rest; break; recess; intermission|आराम; तोड़ना; खाली जगह; आला; विश्राम
きゅうしゅう|kyuushuu|吸収|absorption; suction; attraction|खपत; अन्यचित्तता; अन्यमनस्कता; खींच कर निकालना; खींच कर खाली करना; सक्शन; आकर्षण
きゅうじょ|kyuujo|救助|relief; aid; rescue|उभार; राहत; मुक्ति; सहायता; मदद; मदद करना; राहत; बचाना; बचाव
きゅう|kyuu|旧|ex-|
うし|ushi|牛|cattle; cow|ढोर; पशु/मवेशी; गाय बैल; गाय
きょだい|kyodai|巨大|huge; gigantic; enormous|बहुत अधिक; बहुत; विशाल; बहुत बड़ा; बहुत; विशाल; बड़ा
きょか|kyoka|許可|permission; approval|अनुमति देना; आज्ञा; मंजूर; स्वीकृति; पसंदगी; समर्थन
さかい|sakai|境|border; boundary; mental state|किनारा; सीमा; पट्टी; सीमा; बाउन्डरी; सीमा/घेरा/मेढ़; पागल; दिमागी; मनोवृति
きょうちょう|kyouchou|強調|emphasis; stress; stressed point|बल; महत्व; जोर; दबाव; महत्त्व; जोर; बलाघातयुक्त; अत्यधिक थका हुआ
ごうとう|goutou|強盗|robbery; burglary|लूट पाट; डकैती; चोरी
きょく|kyoku|局|court lady; lady in waiting|चाहना; अदालत; बुलाना; दासी
きんえん|kinen|禁煙|No Smoking!|
きんし|kinshi|禁止|prohibition; ban|निषेध; निषेधाज्ञा; शराबबन्दी; मना करना; निषेध; निषेध करना
すじ|suji|筋|muscle; string; line|ताकत; जबरदस्ती करना; पेशी; रस्सी; धागा; श्रृंखला; रेखा
く|ku|九|nine|नौ
ぐん|gun|軍|army; force; troops|सेना; बल; गुण; दल; सैन्य दल
ぐんたい|guntai|軍隊|army; troops|सेना; सैन्य दल
けいい|keii|敬意|respect; honour|ध्यान; ध्यान रखना; प्रशंसा करना; सम्मानित करना; सम्मान; मानना
けい|kei|計|plan|योजना
はげしい|hageshii|激しい|violent; vehement; intense|तीव्र; उग्र; प्रबल; तीव्र; प्रबल; प्रचण्ड; अत्यधिक; तीव्र; भावुक
けっかん|kekkan|欠陥|defect; fault; deficiency|दोष; खराबी; छोड़्कर शामील हो जाना; त्रुटि; अवगुण; शिकार खो बैठना; कमी; दोष
けってん|ketten|欠点|faults; defect; weakness|दोष; खराबी; छोड़्कर शामील हो जाना; दोष; शौक; असामर्थ्य
あな|ana|穴|hole|छेद
けっか|kekka|結果|result; consequence|परिणाम; जीत; परिणाम निकालना; परिणाम; नतीजा; सामाजिक
けつろん|ketsuron|結論|conclusion|समाप्ति; निष्कर्ष; अंतिम निर्णय
けんせつ|kensetsu|建設|construction; establishment|संरचना; निर्माण; अभिप्राय; स्थान; संस्था; नींव
けんちく|kenchiku|建築|construction; architecture|संरचना; निर्माण; अभिप्राय; संरचना; शिल्प; वास्तुकला
けんぽう|kenpou|憲法|constitution|बनावट; गठन; शारीरिक गठन
けん|ken|県|prefecture|प्रशासक प्रान्त
みおくり|miokuri|見送り|seeing one off; farewell; escort|दृष्टि बोध; दृष्टि; बिदाई; विदाई; बिदा का प्रणाम; सहचर; मार्गरक्षण; मार्गरक्षण करना
けんとう|kentou|見当|be found; aim; estimate; guess; approx|करना; लगाना; लक्ष्य; अंदाज़ लगाना; आकलन; मूल्य का अनुमान
みまい|mimai|見舞い|enquiry; expression of sympathy; expression of concern|पूछताछ; वचन; पदसंहति; अभिव्यक्ति; वचन; पदसंहति; अभिव्यक्ति
のき|noki|軒|eaves|ओरी
かぎ|kagi|鍵|key|चाबी
もと|moto|元|(1) origin; original; (2) former|मूल; आरम्भ; उद्गम; असली; प्रारंभिक; मूल; अब तक; पुराना; भूतपूर्व
あらわれ|araware|現れ|embodiment; materialization|मूर्त रूप; मूर्त; मूर्त रूप
げんじつ|genjitsu|現実|reality|असलियत; ह्कीकत; वास्तविकता
げんしょう|genshou|現象|phenomenon|तथ्य; अजिबोगरीब; अद्भुत
げんじょう|genjou|現状|present condition; existing state; status quo|उपहार; प्रचलित; वर्तमान; मौजूदा; यथापूर्व स्थिति; यथास्थिति
いわば|iwaba|言わば|so to speak|एक प्राकार से
ことわざ|kotowaza|諺|proverb; maxim|कहावत; मुहावरा; वचन; सूक्ति; नीति वचन
げんかい|genkai|限界|limit; bound|मर्यादा; हद; सीमा; सीमित; सीमित करना; उछलते हुए
こしょう|koshou|故障|break-down; failure; accident; out of order|असफलता; गिरना; गिरावट; दुर्घटना
とら|tora|虎|tiger|शेर; बाघ; बाघ का
ほこり|hokori|誇り|pride|प्रतिष्ठा; आत्माभिमान; गौरव
たがい|tagai|互い|mutual; reciprocal|पारस्परिक; आपसी; परस्पर; पारस्परिक; प्रजाति परिवर्तक संकरण; अंतर्बदल
お|o|御|honourable|माननीय; माननीय/सम्माननीय
あやまり|ayamari|誤り|error|भूल; गलती; गलतियाँ
こうほ|kouho|候補|candidacy|उम्मीदवारी
こうけい|koukei|光景|scene; spectacle|घटना; तमाशा; मौका; प्रदर्शन; तमाशा; दृश्य
こうか|kouka|効果|effect; effectiveness; efficacy; result|प्रभाव; पैदा करना; पैदा; प्रभावकारिता; फल साधना; गुण; क्षमता; प्रभाविता
のど|nodo|喉|throat|कंठ; मार्ग; गला
さいわい|saiwai|幸い|happiness; blessedness|सौभाग्य; सुख शान्ति; खुशी; परमानन्द
こうふく|koufuku|幸福|happiness; blessedness|सौभाग्य; सुख शान्ति; खुशी; परमानन्द
こうげき|kougeki|攻撃|attack; strike; offensive; criticism; censure|हमला; बजना; आक्रमण; निकालना; अपमानजनक; अप्रिय; घृणास्पद
こうせい|kousei|構成|organization; composition|बनावट; संघ; संरचना; बनावट; लेखन; संरचना
こうか|kouka|硬貨|coin|बनाना; मुद्रा; गढ़ना
かんがえ|kangae|考え|thinking; thought; ideas; intention|विचारशील; विचारणा; सोच; विचार; मत; इरादा
かおり|kaori|香り|aroma; fragrance; scent; smell|सुगंध; मीठी सुगन्ध; सुगंध; इत्र; सुगन्ध/खुशबू; अतर; भाँप लेना; इत्र्
ごうけい|goukei|合計|sum total; total amount|योगफल; कुल; पूर्ण; जोड़ लगाना
あいず|aizu|合図|sign; signal|देना; सौंपना; संकेत; संकेत; उत्कृष्ट; चिन्ह
ほり|hori|濠|moat|खाई; खंदक; परिखा
こくふく|kokufuku|克服|subjugation; conquest|दमन; पराधीनता; विजय; जीत; विजित हृदय; विजय
ね|ne|根|root|धातु; खोदना; मूल
こんざつ|konzatsu|混雑|confusion; congestion|अस्तव्यस्तता; संभ्रम; भान्ति; भरा हुआ होना; संकुलता; संकुलन
こんらん|konran|混乱|disorder; chaos; confusion; mayhem|विकार; परेशानी; अव्यवस्था; अव्यवस्था; कोलाहल; विशृंखलता; अस्तव्यस्तता; संभ्रम; भान्ति
さ|sa|差|difference; variation|झगड़ा; शेष; असमानता; परिवर्तन; भिन्नता; विभिन्नता
くさり|kusari|鎖|chain|बंधन; क्रम; नापना
さいちゅう|saichuu|最中|in the middle of|
さいてい|saitei|最低|least; lowest; worst|कम से कम; कम; सब से; जीतना; बुरी तरह से पछाड़ देना; सबसे
さいのう|sainou|才能|talent; ability|गुण; प्रतिभा; प्रतिभावान; प्रतिभा; योग्यता; सामर्थ्य
まつり|matsuri|祭|festival; feast|समारोह; त्योहार; त्यौहार/उत्सव; खाना; संतोष; समारोह
さい|sai|際|on the occasion of; circumstances|परिस्थिति; परिस्थितियाँ
ざいさん|zaisan|財産|property; fortune; assets|गुण; स्वभाव; अधिकार; संयोग; सौभाग्य; भाग्य; सम्पति
さくもつ|sakumotsu|作物|produce (e.g. agricultural); crops|उत्पादन करना
さんこう|sankou|参考|reference; consultation|सम्बन्ध; निर्देश; टिप्पणी; परामर्श; विचार विमर्श सभा; संमत्रण
Uӣ[い|Uӣ[i|賛成|approval; agreement; support; favour|स्वीकृति; पसंदगी; समर्थन; वचन; सहमति; करार; प्रमाणित करना; भरण पोषण; भरण पोषण करना
さんそ|sanso|酸素|oxygen|प्राणवायु; आक्सीजन
のこり|nokori|残り|remnant; residue; remaining; left-over|बचा हुआ टुकड़ा; अवशेष; बचा; शेष; अवशिष्ट; बची हुई संपत्ति; बचा हुआ
しげき|shigeki|刺激|stimulus; impetus; incentive|उत्तेजना; प्रोत्साहन; उद्दीपन; गतिबल; प्रेरना; संवेग; प्रेरणादायक; प्रेरणा
よん|yon|四|four|चार
はじまり|hajimari|始まり|origin; beginning|मूल; आरम्भ; उद्गम; शुरुआत
おもいで|omoide|思い出|memories; recollections; reminiscence|स्मरण; याद करना; समानता
おもわず|omowazu|思わず|unintentional; spontaneous|अनजाने; अनभिप्रेत; अनजाने में किया गया; सहज; स्वाभाविक; जंगली
しそう|shisou|思想|thought; idea|विचार; मत; इरादा; विचार
ししゅつ|shishutsu|支出|expenditure; expenses|खर्च; व्यय
し|shi|詩|poem; verse of poetry|कविता; कृति; रचना; कविता; छंद; पद्य
しげん|shigen|資源|resources|संसाधन
しほん|shihon|資本|funds; capital|पैसा; उत्कृष्ठ; शिखर; प्रमुख
つぎつぎ|tsugitsugi|次々|in succession; one by one|एक एक करके
しだい|shidai|次第|(1) order; precedence; (2) circumstances; (3) immediate(ly)|आदेश; वरीयता; पूर्ववर्तिता; परिस्थिति; परिस्थितियाँ
じさつ|jisatsu|自殺|suicide|आत्मघातक; आत्महत्या; खुदखुशी
じどう|jidou|自動|automatic; self-motion|सहज; अविवेचित; अपने आप
じまん|jiman|自慢|pride; boast|प्रतिष्ठा; आत्माभिमान; गौरव; डींग मारना; डींग; गौरव
しき|shiki|式|equation; formula; ceremony|समीकरण; समता; सूत्र; विधि; नुस्खा; अवसर; अतिशयोक्ति; विधि
なな|nana|七|seven|सात
じつに|jitsuni|実に|indeed; truly; surely|वास्तव में; निश्चित; सचमुच; वास्तव में; सचमुच; सही अर्थों में; निश्चित रूप से; अवश्य; निश्चय ही
じつは|jitsuha|実は|as a matter of fact; by the way|वास्तव में; वैसे
じつげん|jitsugen|実現|implementation; materialization; realization|लागू; लागू करना; परिपालन; मूर्त; मूर्त रूप; बोध; प्राप्ति; वास्तविकताबोधक
じっさい|jissai|実際|practical; actual condition; status quo|व्यावहारिक; अभ्यास; उपयोगी; वास्तविक; सही; चालू; यथापूर्व स्थिति; यथास्थिति
じゃま|jama|邪魔|hindrance; intrusion|अवरोध; अलसेट; पैठ; अनधिकार प्रवेश; अनुचित हस्तक्षेप
しゅちょう|shuchou|主張|claim; request; insistence; assertion|दावा करना; का पात्र होना; लेना; विनती करना; अनुरोध करना; आवेदन; आग्रह
しゅよう|shuyou|主要|chief; main; principal; major|मालिक; प्रमुख; मुख्य; प्रमुख; कुलमिलाकर; मुख्य; मालिक; प्रमुख; मुख्य
たね|tane|種|(1) seed; (2) material; (3) cause; source|बीज; छाँटना; दाना; सामान; महत्वपूर्ण; मूर्त; करना; कारण बनना; देना
しゅうかく|shuukaku|収穫|harvest; crop; ingathering|फसल कटाई का समय; फसल; फसल एकत्र; कतरना; लगाना; समूह
しゅうい|shuui|周囲|surroundings; circumference; environs|प्रतिवेश; परिवेश; पास पड़ोस; परिधि; घेरा; मंडल; परिप्रदेश
しゅうせい|shuusei|修正|amendment; correction; revision; modification|सुधार; संशोधन; संशौधन्; संशोधन; शोधन/सुधार/शुद्धि; जाँचना; सुधार; पुनर्लेखन; दोहराई
しゅうり|shuuri|修理|repairing; mending|मरम्मत; मरम्मती; मरम्मत किये जाने वाए वस्त्र
おわり|owari|終|the end|अंत
くさい|kusai|臭い|odour; scent; smell; stench|दुर्गंध; गन्ध/बास; गंध; अतर; भाँप लेना; इत्र्; गंध
しゅうだん|shuudan|集団|group; mass|समूह; परिमाण; समूह; ढेर
じゅう とお|juu too|十|10; ten|दस; दस
たて|tate|縦|length; height|बढ्ना; विस्तार; हद; शिखर; चरम; पराकाष्ठा
じゅうだい|juudai|重大|serious; important; grave; weighty|जटिल; महत्वपूर्ण; रहस्यमय; महत्वपूर्ण; महत्त्वपूर्ण; महत्वपूर्ण; खोदना
じゅうよう|juuyou|重要|important; momentous; essential; principal; major|महत्वपूर्ण; महत्वपूर्ण; आवश्यक; अनिवार्य; महत्वपूर्ण; प्रधान
じゅう|juu|銃|gun|बंदूक
やど|yado|宿|inn; lodging|सराय; धर्मशाला; पांथशाला; आवास; किराये का; निवास
いわい|iwai|祝い|celebration; festival|समारोह; उत्सव; उत्सव/खुशी मनाना; समारोह; त्योहार; त्यौहार/उत्सव
じゅん|jun|順|order; turn|आदेश; मोड़ना
じゅんばん|junban|順番|turn (in line); order of things|मोड़ना; आदेश
しょうち|shouchi|承知|consent; acceptance; assent; admitting|स्वीकृति; सहमति; अनुमति देना; स्वीकृति; स्वीकार; स्वीकरण; स्वीकृति; सहमति; मान लेना
しょうひ|shouhi|消費|consumption; expenditure|खपत; मिलाना; संयोग; खर्च; व्यय
しょうじょう|shoujou|症状|symptoms; condition|निश्चित करना; उपाधि; ठीक करना
しょう|shou|章|(1) chapter; section; (2) medal|सभा; याजक सभा; अध्याय; वर्ग; दल; काटना; पदक; तमगा
しょうとつ|shoutotsu|衝突|collision; conflict|टक्कर; विचारों में टक्कर; संघर्ष; विरोध करना; सामना करना; मेल न खाना
ぞう|zou|象|elephant|हाथी
じょうきょう|joukyou|上京|proceeding to the capital (Tokyo)|
じょうたつ|joutatsu|上達|improvement; advance; progress|सुधार; प्रगति; उन्नति; अग्रसर होना; आगे बढना; प्रयास; आगे बढना; विकास करना; चलना
じょうだん|joudan|冗談|jest; joke|मजाक; मज़ाक करना; परिहास; हँसी खेल; चुटकुला; हँसी मज़ाक
しろ|shiro|城|castle|भवन; रूख से शह; रूख से शह देना
じょうほう|jouhou|情報|information; (military) intelligence|जानकारी; सूचना; ज्ञान; गुप्त समाचार
じょうけん|jouken|条件|conditions; terms|शर्तें; संबंध; शब्दावली; शर्त्
じょうきょう|joukyou|状況|state of affairs; situation; circumstances|परिस्थिति; हालत; समस्या; दृश्य; स्थिति; परिस्थिति; परिस्थितियाँ
じょうたい|joutai|状態|condition; situation; circumstances; state|निश्चित करना; उपाधि; ठीक करना; समस्या; दृश्य; स्थिति; परिस्थिति; परिस्थितियाँ
しょくぶつ|shokubutsu|植物|plant; vegetation|पौधा; वनस्पति; वनस्पति प्रवर्धन; पौधों की वृद्धि
しり|shiri|尻|buttocks; bottom|नितम्ब; कूल्हे; पता; निम्नतम; नितम्ब
しんこう|shinkou|信仰|(religious) faith; belief; creed|भरोसेमंद; भरोसा; विचारधारा; भावना; भरोसा; दृढ विश्वास; धर्म; धर्म मत/स्वीकृत मत
しんらい|shinrai|信頼|reliance; trust; confidence|आसरा; जिस पर विश्वास किया जाए /निर्भर किया जाए/निर्भरता; विश्वास; आशा करना; सहारा; ईमानदारी से; भरोसा; दृढ विश्वास; दृढ
しんぱん|shinpan|審判|refereeing; trial; judgement; umpire; referee|पूर्व परीक्षण; परीक्षण; विचार; धारणा; परख; पहचान
しんちょう|shinchou|慎重|discretion; prudence|समझदारी; विचार; विवेक; समझदारी; सावधानी; बुद्धिमानी
あらた|arata|新た|new; fresh; novel|नया; ताज़ा; नया; उपन्यास; अनूठा
しんせん|shinsen|新鮮|fresh|ताज़ा
しんこく|shinkoku|深刻|serious|जटिल; महत्वपूर्ण; रहस्यमय
もうしわけ|moushiwake|申し訳|apology; excuse|क्षमा प्रार्थना; स्पष्टीकरण; माफ़ी मांगना; क्षमा
しんけい|shinkei|神経|nerve; sensitivity|बल; नस; शक्ति; भावुकता; संवेदनशीलता; सूक्ष्मग्राहिता
しんぽ|shinpo|進歩|progress; development|आगे बढना; विकास करना; चलना; सुधार; विस्तार; आविष्कार
ごみ|gomi|塵|dust; dirt|पोंछना; लाश; मिट्टी; पखाना; मिट्टी; कचरा
すいせん|suisen|推薦|recommendation|विशेषता; समझौता; सिफ़ारिश
せい|sei|性|sex; gender|उत्तेजित करना; वर्ग; काम; लिंग
せいこう|seikou|成功|success; hit|सफल व्यक्ति; सौभाग्य; सफलता; मारना
せいせき|seiseki|成績|results; record|अभिलेखबद्ध; लिखित प्रमाण; जीवन इतिहास
せいり|seiri|整理|sorting; arrangement; adjustment; regulation|सजावट; प्रक्रिया; व्यवस्थापन; सुधार; तालमेल; अनुकूलन
せい|sei|正|(logical) true; regular|सच्चा; रोज का ग्राहक; योग्य; मठजीवी
せいしき|seishiki|正式|due form; official; formality|सीधे; उचित; उप्युक्त; प्रामाणिक; अधिकारी; सरकारी; शिष्टाचार; औपचारिकता; बाह्याचार
しょうじき|shoujiki|正直|honesty; integrity; frankness|सत्यनिष्ठा; सच्चरित्रता; ईमानदारी; सत्यनिष्ठा; अखंडता; ईमानदारी; स्पष्टवादिता; मुँहफ़टपना
せいけつ|seiketsu|清潔|clean|साफ
なま|nama|生|(1) draft (beer); (2) raw; unprocessed|झोंका; अनिवार्य भर्ती होना; भरती करना; अनुचित व्यवहार; कच्चा; फूहड़; अपरिष्कृत; अपरिवर्तित; असंसाधित
いきもの|ikimono|生き物|living thing; animal|जीवित; आजीविका; क्रियाशील; जानवर
せいめい|seimei|生命|life; existence|जीवन; सत्ता; जीवन; ज़िन्दगी
さかり|sakari|盛り|helping; serving|भोजनांश; एक समय में परोसे जाने वाले भोजन की मात्रा
せっきょくてき|sekkyokuteki|積極的|positive; active; proactive|सत्य; स्पष्ट; पूर्ण; सक्रिय; सितारा मछली; अग्रसक्रिय
きれ|kire|切れ|cloth; piece; cut; chop|पादरी; वस्ट्र; मेज़पोश; टुकड़ा; काटना
きれる|kireru|切れる|(1) to cut well; to be sharp; (2) to break (off)|तोड़ना
せっけい|sekkei|設計|plan; design|योजना; नमूना; बनावट; योजना बनाना
ふし|fushi|節|tune; tone; knot; knob; point|ठीक करना; ठिक करना; तालमेल; स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल; बंधन; समूह; गुच्छा
せつ|setsu|説|theory|सिद्धांत; सिद्धान्त; परिकल्पना
ぜつめつ|zetsumetsu|絶滅|destruction; extinction|विनाश का कारण; विनाश; ध्वंस; विलोपन; नाश; लुप्त
した|shita|舌|tongue|लौ; भाषा; बोली
しめる|shimeru|占める|(1) to comprise; to account for; to make up (of); (2) to hold; to occupy|समाविष्ट करना; सम्मिलित करना; बने हुए होना; बताना; मार गिराना; से; बनाना; सजाना; पूरा करना
たたかい|tatakai|戦い|battle; fight; struggle; conflict|लड़ाई/युध्द; सामना करना; कोशिश करना; लड़ना; आगे बढना; मुश्किल; प्रयत्न
そまつ|somatsu|粗末|crude; rough; plain; humble|अश्लील; अशिष्ट; अपरिष्कृत; कच्चा; कर्कश; कठोर; सरल; समतल; सीधा
もと|moto|素|prime|मुख्य; उत्कृष्ट; महत्वपूर्ण
くみあい|kumiai|組合|association; union|संबंध; संघ; समिति; संयोग; संघ; ग्रेट ब्रिटेन
そしき|soshiki|組織|(1) organization; (2) structure; construction; (3) tissue; (4) system|बनावट; संघ; संरचना; नमूना; संरचना; बनाना; संरचना; निर्माण; अभिप्राय
そうじする|soujisuru|掃除|cleaning; sweeping|सफाई; भारी; महत्त्वपूर्ण; व्यापक
そうぞく|souzoku|相続|succession; inheritance|उत्तराधिकार; सिलसिला; ताँता; उत्तराधिकार; उत्तराधिकारी; पैत्रिक
そうだん|soudan|相談|consultation; discussion|परामर्श; विचार विमर्श सभा; संमत्रण; चर्चा; बहस; आलोचनाआ
しも|shimo|霜|frost|पाला; केक को चीनी के बुरादे से सजाना; आइसिंग करना
さわぎ|sawagi|騒ぎ|uproar; disturbance|शोरगुल; कोलाहल/धूमधाम/बखेड़ा; कटु आलोचना; उत्तेजना; घबराहट; उपद्रव
ぞうか|zouka|増加|increase; addition|वृद्धि करना; बढ़ाना; विस्तार; अनुवृद्धि; वृद्धि; जोड़
つづき|tsuzuki|続き|sequel; continuation|परिणाम; शेष; उत्तर कथा; विस्तार; निरंतरता; उत्तर कथा
そで|sode|袖|sleeve|आवरण; बाँह/आस्तीन; आवरण नली
そんざい|sonzai|存在|existence; being|सत्ता; जीवन; ज़िन्दगी; जीवन; स्वभाव; प्राणी
そんちょう|sonchou|尊重|respect; esteem; regard|ध्यान; ध्यान रखना; प्रशंसा करना; सम्मान करना; आदर; आदर/सम्मान; ध्यान; समझना; संबंध
おび|obi|帯|band (e.g. conduction; valence)|जत्था; दल; संघ; रासायनिक संयोजन; संयोजन क्षमता
ふくろ|fukuro|袋|bag; sack|थैला; निकाल देना; बोरा; लूटना
かし|kashi|貸し|loan; lending|रृण; ऋण पर देना; रृण देना; ऋणदान
たいほ|taiho|逮捕|arrest; apprehension; capture|रोकना; अवरोध; आकर्षित करना; डर; भय; समझ; आकर्षित करना; पकड़; बन्दी
だい|dai|台|stand; rack; table; support|खड़ा होना; होना; ऐंठना; यातना चक्र; मेज़
だいじん|daijin|大臣|cabinet minister|अलमारी; सन्दूकचा; कैबिनेट
だいとうりょう|daitouryou|大統領|president; chief executive|प्रधान; अध्यक्ष; कार्यकारी व्यवस्थापक; मालिक; प्रमुख; मुख्य
たいりく|tairiku|大陸|continent|संयमी; आत्मसंयमी; महाद्वीप
だい|dai|題|title; subject; theme; topic|पद; उपाधि; नाम; विषय; लाक्षणिक; विषय; धुन
たんなる|tannaru|単なる|mere; simple; sheer|केवल; मात्र; झील; सरल; पूर्णतया; विशुद्ध; नितान्त
たんとう|tantou|担当|(in) charge|आक्रमण; लगाना; उत्तरदायी
たんじょう|tanjou|誕生|birth|जन्म
たま|tama|弾|bullet; shot; shell|बड़ा निशान; गोली; इक्का; घाव; चित्र; दृश्य; गोलाबारी करना; खोल; सीप
ちい|chii|地位|(social) position; status|दृष्टिकोण; प्रतिष्ठा; पद; दर्जा; ओहदा; स्थिति
ちいき|chiiki|地域|area; region|क्षेत्र; क्षेत्र; प्रदेश; प्रदेश क्षेत्र
ちか|chika|地下|basement; underground|तहखाना; गुप्त; भूमिगत; सुरंग रेल
ちく|chiku|地区|district; section; sector|इलाका; जिला/मंडल; जनपद; वर्ग; दल; काटना; क्षेत्र; कार्यक्षेत्र; संस्था
ちへいせん|chiheisen|地平線|horizon|सीमा; क्षितिज
ちこく|chikoku|遅刻|lateness; late coming|देर
なか|naka|中|inside; middle; among|अंदर; बीच; में; में से; के बीच
ちゅうおう|chuuou|中央|centre; central; center; middle|जड़; लगाना; ठीक करना; प्रमुख; मुख्य; प्रधान; केंद्र
なか|naka|仲|relation; relationship|नाता; संबंध; रिश्तेदारी; नाता; संबंध; सम्बन्ध
ちゅう|chuu|注|annotation; explanatory note|टिप्पणी; व्याख्यात्मक; बोधक
ちょうじょう|choujou|頂上|top; summit; peak|ऊपर; शीर्ष सम्मेलन; शिखर; सम्मेलन; चोटी; अधिकतम; चोटी पर पहुँचना
ていき|teiki|定期|fixed term|स्थिर; निर्धारित; स्थायी
そこ|soko|底|bottom; sole|पता; निम्नतम; नितम्ब; तल्ला; पूरा; कुकुरजीभी
ていあん|teian|提案|proposal; proposition; suggestion|सुझाव; प्रस्ताव; विवाह; समस्या; वचन; सुझाव; संकेत; सुझाव
ていしゅつ|teishutsu|提出|presentation; submission; filing|प्रदर्शन; व्याख्यान; उपहारअ; जमा करना; आत्मसमर्पण; समर्पण
ほど|hodo|程|degree; extent; bounds; limit|कोटि; उपाधि; अंश; हद; सीमा; आयति; सीमा
どろ|doro|泥|mud|कीचड्ॅअ में; कीचड्ॅअ पोतना; मिट्टी
てき|teki|敵|enemy; rival|दुश्मन; प्रतियोगी; बराबरी करना; प्रतिस्पर्धी
ふえ|fue|笛|flute; pipe|बाँसुरी; मुरली; सानिका; बोलना; बाँसुरी; गाना
てきせつ|tekisetsu|適切|pertinent; appropriate; adequate; relevance|उपयुक्त; प्रासंगिक; ठीक; उचित; उपयुक्त; योग्य; पर्याप्त; समुचित
てきよう|tekiyou|適用|applying|
てってい|tettei|徹底|thoroughness; completeness|संपूर्णता; संपूर्णता
てつ|tetsu|鉄|iron|कर्कश; कठोर; निर्दय
てんけい|tenkei|典型|type; pattern; archetypal|प्रकार; नमूना; वर्ग; नमूना; चित्र; उदाहरण; आद्यप्ररूपीय; आधाररूपीय
でんとう|dentou|伝統|tradition; convention|प्रथा; परम्परा; परंपरा; करार; चलन; समझौता
うさぎ|usagi|兎|rabbit; hare; cony|अनाड़ी; खरगोश का शिकार; खरगोश का शिकार करना; खरगोश; खरहा; खरगोश की तरह द्रुत गति से भागना
と|to|都|capital|उत्कृष्ठ; शिखर; प्रमुख
ど|do|度|counter for occurrences|विरोध करना; गिनने का यंत्र; काउंटर
とうひょう|touhyou|投票|voting; poll|मतदान; मिलना; मत; मतदान
ひ|hi|灯|light|रोशनी
ひとしい|hitoshii|等しい|equal|की बराबरी; समान; सक्षम
まめ|mame|豆|beans; peas|
どうし|doushi|動詞|verb|क्रिया; क्रियापद
どういつ|douitsu|同一|identity; sameness; similarity|पहचान; तादात्म्य; ऐक्य; समानता; नीरसता; समानता; समनता; सादृश्य/समानता
とくい|tokui|得意|pride; triumph; prosperity|प्रतिष्ठा; आत्माभिमान; गौरव; जीतना; सफलता; विजय प्राप्त करना; समृद्धि; दौलत; ऋद्धि
ひとり|hitori|独り|alone; unmarried|अकेला; अविवाहित; कुंवारी
どくとく|dokutoku|独特|peculiarity; uniqueness; characteristic|विशिष्टता; खासियत; अनूठापन; विशिष्टता; विलक्षणता; विशिष्ट लक्षण; लक्षण; विशिष्टता
うち|uchi|内|inside|अंदर
ないよう|naiyou|内容|subject; contents; matter; substance; detail; import|विषय; सार; वस्तु; विषय; मामला
なぞ|nazo|謎|riddle; puzzle; enigma|पहेली; छलनी कर देना; रहस्य; समस्या; हैरान करना; पहेली; पहेली; गूढ़ प्रश्न
なべ|nabe|鍋|saucepan; pot|ढेगची; डेगची; सितारा मछली; बरतन; रखना
なわ|nawa|縄|rope; hemp|रस्सी; डोरी; रस्सी से बाँधना; सन का; भाँग का पौधा; सन
におい|nioi|匂い|odour; scent; smell; stench|दुर्गंध; गन्ध/बास; गंध; अतर; भाँप लेना; इत्र्; गंध
なっとく|nattoku|納得|consent; assent; understanding|स्वीकृति; सहमति; अनुमति देना; स्वीकृति; सहमति; मान लेना; सहमति; तालमेल; समझदार
のうりょく|nouryoku|能力|ability; faculty|प्रतिभा; योग्यता; सामर्थ्य; शक्ति; संकाय; योग्यता
のうみん|noumin|農民|farmers; peasants|
ばか|baka|馬鹿|fool; idiot; trivial matter; folly|मूर्ख; धोखा; फल के रस का शर्बत; जड़; मूर्ख; गधा; तुच्छ; साधारण; नगण्य
はくぶつかん|hakubutsukan|博物館|museum|संग्रहालय; अजायबघर
ばくだい|bakudai|莫大|enormous; vast|बहुत; विशाल; बड़ा; बृहत; बहु; विशाल
はだ|hada|肌|skin|छिलना; छिलका निकालना; छिलका
はったつ|hattatsu|発達|development; growth|सुधार; विस्तार; आविष्कार; पौधा; सूजन; वृध्दि
はってん|hatten|発展|development; growth|सुधार; विस्तार; आविष्कार; पौधा; सूजन; वृध्दि
はんだん|handan|判断|judgement; decision|धारणा; परख; पहचान; निर्णय; निर्णय करना; निर्णय शक्ति
はんこう|hankou|反抗|opposition; resistance|बाधा; विरोध; प्रतिद्वंदी; बाधा; विरोधी संस्था; विरोध
いた|ita|板|board; plank|किनारा; में चढना; तख्ता; मुद्दा; तख्ता; पटकना
はんい|hani|範囲|extent; scope; sphere; range|हद; सीमा; आयति; विस्तार; क्षेत्र; दोलन दर्शी; वृत्त; गोला; क्षेत्र
いや|iya|否|no; the noes|नहीं
ひてい|hitei|否定|negation; denial; repudiation|असहमति; प्रतिवाद; नकार; इंकार; निषेध; परित्याग; परित्याग; अस्वीकरण
ひはん|hihan|批判|criticism; judgement; comment|आलोचना; समीक्षा; आलोचना/समीक्षा; धारणा; परख; पहचान; टीका टिप्पणी करना; टिप्पणी; आलोचना
ひみつ|himitsu|秘密|secret; secrecy|गुप्त; गोपनीय; रहस्यमय; गुप्त; गुप्त रखना; गोपनीयता
びみょう|bimyou|微妙|delicate; subtle|स्वादिष्ट; लिहाज रखनेवाला; उत्कृष्ट; हल्का; जटिल; कुशाग्र
ふで|fude|筆|writing brush|लिखने का काम; लिखना; लेखन
ひも|himo|紐|(1) string; cord; (2) pimp|रस्सी; धागा; श्रृंखला; डोरी; बिजली का तार; काडेआय की पतलून; दलाली करना; भड़ुआ; दलाल
ひょうげん|hyougen|表現|expression; presentation; representation (math)|वचन; पदसंहति; अभिव्यक्ति; प्रदर्शन; व्याख्यान; उपहारअ; अभ्यावेदन; मूर्ति; चिट्रण
ひょうじょう|hyoujou|表情|facial expression|चेहरे का; चेहरे; फ़ेशियल
ひょうか|hyouka|評価|valuation; estimation; assessment; evaluation|मूल्य निर्धारण; मोल लगाना; विचार; अनुमान; आगणन; निर्धारण; राय; आँकलन/मूल्यांकन
ひょうばん|hyouban|評判|fame; reputation; popularity; arrant|प्रतिष्ठा; मान; नाम; प्रतिष्ठा; मर्यादा; मान; लोकप्रियता; सर्वमान्यता
まずしい|mazushii|貧しい|poor; needy|गरीब; निर्धन; ज़रूरतमंद आदमी; ज़रूरतमंद
びん|bin|瓶|bottle|बोतल
ぶ|bu|不|un; non; negative prefix|यू एन; यू; ग़ैर; निगेटिव{फोटो का}; प्रतिकूल; रृणात्मक
ふか|fuka|不可|wrong; bad; improper; unjustifiable; inadvisable|गलत; बुरा; अनुपयुक्त; असंगत; अनुचित
ふしぎ|fushigi|不思議|mystery; curiosity|रहस्यवादी; रहस्यमय; रहस्य; असामान्य; जिज्ञासा; अपूर्व वस्तु
ふへい|fuhei|不平|complaint; discontent; dissatisfaction|शिकायत; झगड़ा; रोग; असंतोष; असंतोष; असन्तोष
ふまん|fuman|不満|dissatisfaction; displeasure; discontent; complaints; unhappiness|असंतोष; असन्तोष; अप्रसन्नता; असह्मत होना, अप्रसन्न होना; असंतोष
つきあい|tsukiai|付き合い|association; socializing; fellowship|संबंध; संघ; समिति; अनुदान; संघ; अध्येतावृत्ति
ぬの|nuno|布|cloth|पादरी; वस्ट्र; मेज़पोश
ぶき|buki|武器|weapon; arms; ordinance|हथियार; हस्तास्त्र; अस्त्र; हथियार; हस्तास्त्र; शस्त्र; नियम; अभिषेक; अध्यादेश
ふくそう|fukusou|服装|garments|
ぶっしつ|busshitsu|物質|material; substance|सामान; महत्वपूर्ण; मूर्त; सार; वस्तु; पदार्थ
たいら|taira|平ら|flatness; level; smooth; calm; plain|समतलता; परत; सपाट; समतल; शिष्ट; मुलायम; समटल करना
びん|bin|便|way; means|रास्ता; उपाय; आय; साधन
たより|tayori|便り|news; tidings; information; correspondence; letter|समाचार; समाचार; ख़बर; जानकारी
はか|haka|墓|grave; tomb|महत्त्वपूर्ण; महत्वपूर्ण; खोदना; कब्र; समाधि
ほうこく|houkoku|報告|report; information|बताना; विवरण; सूचना; जानकारी
たから|takara|宝|treasure|बहुमूल्य; संजोए रखना; खजाना
ゆたか|yutaka|豊か|abundant; wealthy; plentiful; rich|बहुत; प्रचुर; बहुत सारा/प्रचुर/ढेर; समृद्ध; संपन्न; धनवान; प्रचुर; बहुतेरा
ぼう|bou|棒|pole; rod; stick|चलाना; ठेलना; ध्रुव; दण्ड; दंड; जाति; सथापित करना; टेक लगाना; रखना
ぼうけん|bouken|冒険|risk; venture; adventure|जोखिम; ख़तरा; जोखिम उठाना; जाने का साहस करना; करने का साहस; उपक्रम; अभियान; जोखिम; साहस
すえ|sue|末|the end of; powder|पाउडार; पीसना; चूर्ण
みょう|myou|妙|strange; unusual|निराला; अनोखा; आश्चर्यजनक; अपूर्व; असाधारण; असामान्य
む|mu|無|nothing; naught; nil; zero|कुछ नहीं; कुछ नहीं; शूऩ्य़; शून्य; सिफ़र; कुछ नहीं
なし|nashi|無し|without|के बिना; छोड़कर; न
むし|mushi|無視|disregard; ignore|अनादर; अवहेलना; उपेक्षा; ध्यान न देना; अनसुनी करना; अनदेखा
むだ|muda|無駄|futility; uselessness|निरर्थकता; असारता; निरर्थकता; अनुपयोगिता
きり|kiri|霧|fog; mist|भ्रम पैदा होना; कुहरे से ढक जाना; कोहरा; कोहरा; धुँधला; कुहासेकी तरह ढकना
な|na|名|name; reputation|नाम; प्रतिष्ठा; मर्यादा; मान
めいわく|meiwaku|迷惑|trouble; bother; annoyance|परेशानी; परेशान करना; कष्ट देना; परेशानी; चिढ़; मुसीबत; कष्ट
わた|wata|綿|cotton; padding|धागा; सूती; सूती कपड़ा; गद्दीदर भराव; अनावश्यक विस्तार
もよう|moyou|模様|pattern; figure; design|नमूना; चित्र; उदाहरण; नमूना; विचार करना; कल्पना करना; नमूना; बनावट; योजना बनाना
もうふ|moufu|毛布|blanket|परत; आवरण; व्यापक
あぶら|abura|油|oil|तेल
ゆしゅつ|yushutsu|輸出|export|निर्यात करना; निर्यात
ゆにゅう|yunyuu|輸入|importation; import; introduction|आयात; आयातित माल; आयातित; महत्व; आयात; बुलाया जानाना; प्रारंभ; प्रस्तावना; समावेशन
ゆうこう|yuukou|有効|validity; availability; effectiveness|वैधता; मान्यता; उपलब्धता; प्राप्यता; प्रभावकारिता; फल साधना
よさん|yosan|予算|estimate; budget|अंदाज़ लगाना; आकलन; मूल्य का अनुमान; सस्ता; बचाना; राजस्व
ようい|youi|容易|easy; simple; plain|आसान; सरल; सरल; समतल; सीधा
さまざま|samazama|様々|varied; various|विभिन्न; विविध प्रकार का; भिन्न; कई; अनेक
ようそ|youso|要素|element|तत्व; अंश; लोग
ようてん|youten|要点|gist; main point|सार; सारांश; तात्पर्य; प्रमुख; कुलमिलाकर; मुख्य
はだか|hadaka|裸|naked; nude|स्पष्ट; निर्वस्त्र; निरा; नग्न चित्र; नग्नतायुक्त; नग्न
りえき|rieki|利益|profits; gains; (political; economic) interest|विजित वस्तु; शासन विषयक; राजनैतिक; शासन
りかい|rikai|理解|understanding; comprehension|सहमति; तालमेल; समझदार; बोध; समझ; अवगति
りそう|risou|理想|ideal|आदर्श; अनुकूल; उपयुक्त
りこん|rikon|離婚|divorce|पार्थक्य; अलग करना; विवाह विच्छेद
りく|riku|陸|six (used in legal documents)|छह
わ|wa|輪|ring; hoop; circle|गोला बनाना; बजना; टेलीफोन करना; छल्ला; बड़ा छल्ला; बड़ा; वृत्त; पंक्ति; घेरना
れいせい|reisei|冷静|calm; composure; coolness; serenity|शांत करना; ठहराव; निश्चलता; आत्मसंयम; धैर्य; शान्ति; धैर्य; रूखापन
れい|rei|礼|expression of gratitude|वचन; पदसंहति; अभिव्यक्ति
れつ|retsu|列|queue; line; row|पंक्ति; लाइन; चोटी; रेखा; चलाना; झिड़की; पंक्ति
れんそう|rensou|連想|association (of ideas); suggestion|संबंध; संघ; समिति; संकेत; सुझाव
れんぞく|renzoku|連続|serial; consecutive; continuity; continuing|क्रम; धारावाहिक; आनुक्रमिक; लगातार; पूरक; निरंतरता; दृश्यावली
ろんそう|ronsou|論争|controversy; dispute|विवाद; विवाद करना; झगड़ना; झगड़ा
わだい|wadai|話題|topic; subject|विषय; प्रसंग; विषय
わき|waki|脇|side|किनारा
わん|wan|湾|bay; gulf; inlet|भोंक; रोना; कुत्तों की एक विशेष प्रकार की भौँक; गहरी; गहरा; अंतर या भेद; द्वार; पतली खाडी; प्रवेशिका
ほこり|hokori|埃|dust|पोंछना; लाश; मिट्टी
ぜいたく|zeitaku|贅沢|luxury; extravagance|आराम; आनन्द; समृद्धि; अतिव्यय; फ़िज़ूलखर्ची
あっしゅく|asshuku|圧縮|compression; condensation; pressure|दबाव; संपीडन; संक्षेपण; संघनन; घनीकरण; बल; प्रभाव; दबाव
いこう|ikou|以降|on and after; hereafter; thereafter|भविष्य में; मरणोत्तर जीवन; मरनोपरांत; तब से; उसके बाद; उस के बाद
いぎ|igi|意義|meaning; significance|उद्देश्य; अर्थपूर्ण; मतलब; महत्व; महत्त्व; मतलब
いてん|iten|移転|moving; transfer; demise|गतिमान; मर्मस्पर्शी; हृदय स्पर्शी; सौंपना; स्थानान्तरित करना; स्थानान्तरण; मृत्यु; अवसान; मौत
いど|ido|緯度|latitude (nav.)|अक्षांश
ひとやすみ|hitoyasumi|一休み|a rest|आराम
いってい|ittei|一定|fixed; settled; definite|स्थिर; निर्धारित; स्थायी; स्थिर; शान्त; शांत; स्पष्ट; निश्चित
ひっこし|hikkoshi|引越し|moving (dwelling etc.); changing residence|गतिमान; मर्मस्पर्शी; हृदय स्पर्शी
ひきざん|hikizan|引算|subtraction|घटाना; घटाव; व्यवकलन
いんりょく|inryoku|引力|gravity|गुरुत्व; गंभीरता; गुरुत्वाकर्षण
はね|hane|羽根|shuttlecock|शटलकक; चिड़िया
うんが|unga|運河|canal; waterway|नहर; नलिका; कुल्या; जलमार्ग; जलधारा
ながい|nagai|永い|long; lengthy|लंबा; लम्बा; बहुत लंबा; बहुत
けむい|kemui|煙い|smoky|धुँधुआता; धुआँ करने; धुएँ से
えんとつ|entotsu|煙突|chimney|चिमनी; चूल्हा; बर्फ़ का कटाव
つや|tsuya|艶|gloss; glaze|परत; चमक; चमकीला पेंट; मिश्रण; चमकाना; काँच की तह चढ़ाना
おうえん|ouen|応援|aid; assistance; help; reinforcement|सहायता; मदद; मदद करना; सहायता; मदद; मदद
おうせつ|ousetsu|応接|reception|स्वीकृति; स्वागत; स्वागत समारोह
おうたい|outai|応対|receiving; dealing with|परिगृह; लेन  देन; क्रय विक्रय
おうよう|ouyou|応用|application; put to practical use|संबंध; लागू; परिश्रम; रखना
ふすま|fusuma|襖|sliding screen|
かせん|kasen|下線|underline; underscore|अधोरेखांकन; नीचे रेखा खींच; रेखांकित करना; अधोरेखांकन; रेखांकित करना; ज़ोर देना
かてい|katei|仮定|assumption; supposition; hypothesis|मान्यता; पुर्वानुमान; कल्पना; मानना; अनुमान; परिकल्पना; अनुमान; परिकल्पना; अवधारणा
かな|kana|仮名|(n) alias; pseudonym; pen name|उपनाम; उर्फ़; छद्मनाम; कृतकनाम; उपनाम
かなづかい|kanazukai|仮名遣い|kana orthography; syllabary spelling|
なになに|naninani|何々|such and such; What?|फ़लाँ; अमुक; क्या
やぬし|yanushi|家主|landlord|शराबखाने का मालिक; शराबखाने; मकान मालिक
かてい|katei|課程|course; curriculum|पाठ्यक्रम; पाठ्यक्रम
かしつ|kashitsu|過失|error; blunder; accident|भूल; गलती; गलतियाँ; चूक/भारी भूल; दुर्घटना
かじょう|kajou|過剰|excess; over-|बहुत अधिक; अधिशेष; अधिकता
かてい|katei|過程|process|विधि; बढोत्तरी; तैयार करना
か|ka|蚊|mosquito|मच्छर
かいさん|kaisan|解散|breakup; dissolution|छोटे छोटे; छोटे छोटे भागों में वर्गीकरण; संबंध विच्छेद; विच्छेद; विलयन; विघटन
かいてん|kaiten|回転|rotation; revolution; turning|चक्कर; गर्दिश; आवर्तन; नक्षत्र का परिभ्रमण; आमूल परिवर्तन; पूरा चक्कर/परिभ्रमण; परिवर्तन; खरादना; बदलाव
かたまり|katamari|塊|lump; mass; clod; cluster|ढेला; ढेर; मूर्ख; परिमाण; समूह; ढेर; ढेला; मूर्ख व्यक्ति
あやしい|ayashii|怪しい|suspicious; dubious; doubtful|संदेहशील; सन्देह जनक; संदेहास्पद; संदिग्ध; संदेहास्पद; अनिश्चित; संदिग्ध; संदेह
くやしい|kuyashii|悔しい|regrettable; mortifying; vexing|खेदजनक; खेदजनक शोचनीय; लज्जाजनक; खिझाऊ; चिढ़ पैदा करने वाला
かいぞう|kaizou|改造|(1) remodeling; (2) modding (comp)|
かい|kai|貝|shell; shellfish|गोलाबारी करना; खोल; सीप; कवच; शंख मीन; कवच प्राणियों का मांस
がいぶ|gaibu|外部|the outside; external|बाहर; बाहरी; बाह्य
ふた|futa|蓋|cover; lid; cap|ढकना; रोकना; ढक्कन; रूकावट; शिखर; टोपी पहनाना; कुकुरमुत्ता
かきね|kakine|垣根|hedge|हिचकिचाना; बचाव; बाड
かくじ|kakuji|各自|individual; each|विशिष्ट; व्यक्ति; अलग अलग; प्रत्येक
かくじゅう|kakujuu|拡充|expansion|विस्तार; प्रसार
かくちょう|kakuchou|拡張|expansion; extension; enlargement; escape (ESC)|विस्तार; प्रसार; विस्तार; फैलाव; शिक्षा; विवर्धन; विस्तारण
かくべつ|kakubetsu|格別|exceptional|विशिष्ट; असाधारण; असामान्य
から|kara|殻|shell; husk; hull; chaff|गोलाबारी करना; खोल; सीप; छिलका निकालना; छिलका; भूसी निकालना; छिलका; पेटा; छीलना
かくど|kakudo|角度|angle|दृष्टिकोण; कोण; कोना
かけざん|kakezan|掛け算|multiplication|प्रजनन; गुणा; गुणक
わりざん|warizan|割算|division (math)|वर्ग; हिस्सा; श्रेणी
かつやく|katsuyaku|活躍|activity|गतिविधि
かつりょく|katsuryoku|活力|vitality; energy|उत्साह; प्राणशक्ति; जीवनक्षमता; ऊर्जा
かま|kama|釜|iron pot; kettle|कर्कश; कठोर; निर्दय; केतली
かんそう|kansou|乾燥|dry; arid; insipid; dehydrated|सूखा; नीरस; शुष्क; निर्जल; बेस्वाद; रुचिहीन; फीका
かんたい|kantai|寒帯|frigid zone|ठंडा; बहुत; भावरहित
かんそう|kansou|感想|impressions; thoughts|
ゆるい|yurui|緩い|loose; lenient; slow|कामुक; खोलना; लापरवाह; नरम; धीमा
かんそく|kansoku|観測|observation|विचार; कथन; देखरेख
かんしょう|kanshou|鑑賞|appreciation|समालोचना; वृद्धि; आभार
かんとう|kantou|関東|eastern half of Japan; including Tokyo|पूर्व की ओर; पूर्वी; पूर्व; सम्मिलित करते हुए; सहित
あやうい|ayaui|危うい|dangerous; critical; grave|घमासान; खतरनाक; डरावना; ठीक; शोचनीय; सूक्ष्म; महत्त्वपूर्ण; महत्वपूर्ण; खोदना
きかい|kikai|器械|instrument|मानव यंत्र; प्रपत्र; लिखित
きぐ|kigu|器具|utensil|बरतन; बासन
きじゅん|kijun|基準|standard; basis; criteria; norm|दर्जा; शिष्ट; मान; आधार; कसौटी
きそ|kiso|基礎|foundation; basis|आधार; प्रतिष्ठान; संस्था; आधार
きち|kichi|基地|base|आधार
きばん|kiban|基盤|foundation; basis|आधार; प्रतिष्ठान; संस्था; आधार
まれ|mare|稀|rare; seldom|निराला; असामान्य; दुर्लभ; बिरले ही/कभी कभार; शायद; कभी कभार
きじゅん|kijun|規準|standard; basis; criteria; norm|दर्जा; शिष्ट; मान; आधार; कसौटी
きごう|kigou|記号|symbol; code|चिन्ह; संकेताक्षर; चिह्न; नियमावली; गुप्त भाषा; कूट संकेत में लिखना
ききん|kikin|飢饉|famine|अकाल; दुर्भिक्ष
さかさま|sakasama|逆様|inversion; upside down|उलटाव; उल्टा; अस्त व्यस्त; अस्तव्यस्त
きゅうそく|kyuusoku|休息|rest; relief; relaxation|आराम; उभार; राहत; मुक्ति; मनोरंजन; तनाव मुक्ति; विश्राम
けいば|keiba|競馬|horse racing|घुड़दौड़; घुडदौडबाज़ी
きょうかい|kyoukai|境界|boundary|सीमा; बाउन्डरी; सीमा/घेरा/मेढ़
きょうか|kyouka|強化|strengthen; intensify; reinforce; solidify|शक्ति बढ़ना; मजबूत करना; मजबूत होना; बढ़ा देना; सशक्त करना; बढ़ जाना; बढ़ाना; समर्थन करना; मजबूत बनाना
こと|koto|琴|Koto (Japanese harp)|
くいき|kuiki|区域|limits; boundary; domain; zone; sphere; territory|सीमा; बाउन्डरी; सीमा/घेरा/मेढ़; क्षेत्र; प्रांत; कार्यक्षेत्र
くし|kushi|櫛|comb|निकालना; अच्छे से ढूँढना; शहद का छत्ता
くず|kuzu|屑|waste; scrap|व्यर्थ; बंजर भूमि; नष्ट करना; झगड़ा; निकाल देना; रद्दी
むれ|mure|群れ|group; crowd; flock; herd|समूह; भीड़; जमा; शिष्य वृन्द; झुण्ड
けいしき|keishiki|形式|form; formality; format; math expression|दर्जा; प्रकार; विचार करना; शिष्टाचार; औपचारिकता; बाह्याचार; फरमैट; बाह्य रूप; प्रबन्ध
けいようし|keiyoushi|形容詞|true adjective|सच्चा
けいようどうし|keiyoudoushi|形容動詞|adjectival noun; quasi-adjective|विशेषणीय; विशेषण संबंधी; विशेषणात्मक
よろこび|yorokobi|慶び|(n) (a) joy; (a) delight; rapture; pleasure; gratification; rejoicing; congratulations; felicitations|सफलता; प्रसन्न होना; आनन्द; हर्षित करना; हर्षोल्लास; खुशी; अत्यन्त हर्ष; हर्षोन्माद; उमङ्ग
けいど|keido|経度|longitude|देशान्तर रेखा; देशांतर
けいぞく|keizoku|継続|continuation|विस्तार; निरंतरता; उत्तर कथा
つながり|tsunagari|繋がり|connection; link; relationship|नाता; संबन्ध; संपर्क; सम्पर्क; सम्बन्ध; शृंखला; नाता; संबंध; सम्बन्ध
けいび|keibi|警備|defense; guard; policing; security|बचाव; सुरक्षा; रक्षा; पहरेदार; बचाव; रक्षण करना
げきぞう|gekizou|激増|sudden increase|आकस्मिक; अचानक; शीघ्र
けた|keta|桁|column; beam; digit|पंक्ति; कलम; दंड; चमक; झलक; प्रकाश विकिरण; अंक; आँकड़ा; उँगली
みおくる|miokuru|見送る|(1) to see off; to farewell; (2) to escort; (3) to let pass|रोकना; भगाना; विदा करना; बिदाई; विदाई; बिदा का प्रणाम; सहचर; मार्गरक्षण; मार्गरक्षण करना
みほん|mihon|見本|sample|नमूना; प्रति रूप; प्रतिदर्श
けんきょ|kenkyo|謙虚|modesty; humility|लज्जा; विनम्रता; संकोच; नम्रता
けんそん|kenson|謙遜|humble; humility; modesty|विनम्र; नीचा दिखाना; नम्र; नम्रता; लज्जा; विनम्रता; संकोच
けんびきょう|kenbikyou|顕微鏡|microscope|सूक्ष्मदर्शी; सूक्ष्मद्र्शी; अणुदर्शी
げんし|genshi|原始|origin; primeval|मूल; आरम्भ; उद्गम; आदियुगीन; आदिम; आदिकालीन
げんり|genri|原理|principle; theory; fundamental truth|मर्यादा; विधि; सूट्र; सिद्धांत; सिद्धान्त; परिकल्पना; प्रमुख; मुख्य; मूल
げんど|gendo|限度|limit; bounds|मर्यादा; हद; सीमा; सीमा
かたい|katai|固い|stubborn; firm (not viscous or easily moved)|अटल; ढीठ; हठीला; स्थिर; अटल; मजबूत
こしょう|koshou|胡椒|pepper|मीरचा; मीर्च; डालना
おじぎ|ojigi|御辞儀|bow|झुकाना; सिर; गलही
ごぶさた|gobusata|御無沙汰|not writing or contacting for a while|
ごらん|goran|御覧|(hon) look; inspection; try|देखना; निरीक्षण; कोशिश करना
こうせん|kousen|光線|beam; light ray|चमक; झलक; प्रकाश विकिरण; रोशनी
こうしき|koushiki|公式|formula; formality; official|सूत्र; विधि; नुस्खा; शिष्टाचार; औपचारिकता; बाह्याचार; प्रामाणिक; अधिकारी; सरकारी
こうひょう|kouhyou|公表|official announcement; proclamation|प्रामाणिक; अधिकारी; सरकारी; घोषणा; उद्घोषणा; ऐलान
こうりょく|kouryoku|効力|effect; efficacy; validity; potency|प्रभाव; पैदा करना; पैदा; गुण; क्षमता; प्रभाविता; वैधता; मान्यता
あつかましい|atsukamashii|厚かましい|impudent; shameless; brazen|अविवेकी; अक्खड़; निर्लज्ज; निर्लज्जतापूर्ण; बेशर्म; निर्लज/बेशर्म; खुल्लमखुल्ला; पीतल के
ひろびろ|hirobiro|広々|extensive; spacious|विस्तृत; व्यापक; बड़ा/व्यापक; विस्तृत; विशाल; बड़ा
ひろさ|hirosa|広さ|extent|हद; सीमा; आयति
こうぞう|kouzou|構造|structure; construction|नमूना; संरचना; बनाना; संरचना; निर्माण; अभिप्राय
つな|tsuna|綱|rope|रस्सी; डोरी; रस्सी से बाँधना
こうち|kouchi|耕地|arable land|कृषि योग्य; कृष्य
こうてい|koutei|肯定|positive; affirmation|सत्य; स्पष्ट; पूर्ण; प्रतिज्ञापन; दृढ़ वचन; अभिपुष्टि
あらい|arai|荒い|rough; rude; wild|कच्चा; कर्कश; कठोर; कच्चा; असभ्य; भद्दा; कर्कश; असभ्य; अविवेचित
ごうり|gouri|合理|rational|विवेकपूर्ण; चैतन्य; उचित
ごうりゅう|gouryuu|合流|confluence; union; linking up; merge|संगम; मेल; जमावड़ा; संयोग; संघ; ग्रेट ब्रिटेन
うらみ|urami|恨み|resentment|क्रोध; विद्वेष; नाराज़ग्
こんごう|kongou|混合|mixing; mixture|मिश्रण; घोल; मिलावट
さしつかえ|sashitsukae|差し支え|hindrance; impediment|अवरोध; अलसेट; बाधा; हकलाहट; विघ्न
もよおし|moyooshi|催し|event; festivities; function|घटना; वारदात; प्रतियोगिता; कार्य; प्रकार्य; कार्य करना
さいてん|saiten|採点|marking; grading; looking over|अंकन; मार्किंग; चिह्नन; एक दृष्टि
さいなん|sainan|災難|calamity; misfortune|विपत्ति; अशुभ; दुर्घटना; दुर्भाग्य; बदकिस्मती; अवदशा
さくしゃ|sakusha|作者|author; authoress|जड़; लिखना; प्रवर्तक; लेखिका
さじ|saji|匙|spoon|चम्मच
さび|sabi|錆|rust (colour)|मोरचे का रंग; ज़ंग लग; मोरचे का
さんかく|sankaku|三角|triangle; triangular|तीन लोगों की सहमति; त्रिभुजाकार वस्तु; त्रिभुज; त्रिकोणीय; त्रिपक्षीय; त्रिकोणाकार
さんち|sanchi|産地|producing area|
そろばん|soroban|算盤|abacus|गिनतारा; शीर्ष फलक
さんせい|sansei|酸性|acidity|खट्टापन; अम्लता; ऐसिडिटी
しかく|shikaku|四角|square|खरा; बराबर करना; वर्गाकार
しかくい|shikakui|四角い|square|खरा; बराबर करना; वर्गाकार
ししゃごにゅう|shishagonyuu|四捨五入|rounding up (fractions)|
しせい|shisei|姿勢|attitude; posture|मुद्रा; रवैया; प्रवृति; मुद्रा; रूख; दिखावा करना
思い掛けない||思い掛けない|unexpected; casual|अविचारित; अनिवार्य; अप्रत्याशित; आकस्मिक; लापरवाह; बेढंगा
しめい|shimei|氏名|full name; identity|भरा; पहचान; तादात्म्य; ऐक्य
しりつ|shiritsu|私立|private (establishment)|गुप्त; साधारण; आत्मीय
かみくず|kamikuzu|紙屑|wastepaper|
じいん|jiin|寺院|temple|कनपटी; मोहरा; दिवगृह
じえい|jiei|自衛|self-defense|
しっぴつ|shippitsu|執筆|writing|लिखने का काम; लिखना; लेखन
しつど|shitsudo|湿度|level of humidity|परत; सपाट; समतल
じっせき|jisseki|実績|achievements; actual results|वास्तविक; सही; चालू
じつぶつ|jitsubutsu|実物|real thing; original|असली; असली; प्रारंभिक; मूल
じつよう|jitsuyou|実用|practical use; utility|व्यावहारिक; अभ्यास; उपयोगी; उपयोगिता; शुद्ध; उपादेयता
じつりょく|jitsuryoku|実力|merit; efficiency; arms; force|विशेषता; योग्यता; सराहना; दक्षता; कार्यक्षमता; चुस्ती; हथियार; हस्तास्त्र; शस्त्र
ななめ|naname|斜め|obliqueness|तिरछापन; वक्रोक्ति; बंकुरता
わかわかしい|wakawakashii|若々しい|youthful; young|जवान; जवानी का; कम उम्र; जवान
じゃくてん|jakuten|弱点|weak point; weakness|कमज़ोर मुद्दा; दोष; शौक; असामर्थ्य
じゅわき|juwaki|受話器|(telephone) receiver|चोर हटिया; पाने वाला; ग्राहक
じゅみょう|jumyou|寿命|life span|जीवन अवधि; जीवन काल
しゅうぜん|shuuzen|修繕|repair; mending|जमाव; मरम्मत; सुधार; मरम्मत; मरम्मती; मरम्मत किये जाने वाए वस्त्र
みにくい|minikui|醜い|ugly|बदसूरत
おもたい|omotai|重たい|heavy; massive; serious|भारी; भारी; भीमकाय; विशाल; जटिल; महत्वपूर्ण; रहस्यमय
じゅうてん|juuten|重点|important point; lay stress on; colon; emphasis|महत्वपूर्ण; करना; गिरा देना; देना; कोलन; मलाशय
じゅうやく|juuyaku|重役|director; high executive|प्रबंधक; संचालक; अध्यक्ष; ऊँचा
じゅうりょう|juuryou|重量|(1) weight; (2) heavyweight boxer|लगाना; प्रभाव; महत्व; भारी भरकम व्यक्ति; भारी भरकम वस्तु; अत्यधिक महत्वपूर्ण
じゅうりょく|juuryoku|重力|gravity|गुरुत्व; गंभीरता; गुरुत्वाकर्षण
であい|deai|出合い|an encounter|सामना करना; मुठभेड़; मुठभेड़ करना
じゅんかん|junkan|循環|circulation; rotation; cycle|खपत; गर्दिश; प्रचलन; चक्कर; गर्दिश; आवर्तन; वृत्त; दौर; चक्कर
じゅんすい|junsui|純粋|pure; true; genuine; unmixed|प्रांजल; असली; अमिश्रित; सच्चा; असली; सच्चा; अमिश्रित/वास्तविक
じゅんじゅん|junjun|順々|in order; in turn|मान्य; वैध; ठीक ठाक; एक के बाद एक; परिणामस्वरूप; बारी बारी से
じゅんじょ|junjo|順序|order; sequence; procedure|आदेश; दृश्य; क्रम; अनुक्रम; प्रक्रिया; पद्धति; कार्यप्रणाली
しょうぎ|shougi|将棋|Japanese chess|जापानवासी; जापानी
しょうべん|shouben|小便|(col) urine; piss|मूत्र; पेशाब; गंदा पानी; पेशाब करना; ज़ोर से हँसना; पेशाब
しょうか|shouka|消化|digestion|पाचन शक्ति; पचाव; पाचन
しょうきょくて|shoukyokute|消極的|passive|कर्मवाच्य; निष्क्रीय; कर्मप्रधन
しょうどく|shoudoku|消毒|disinfection; sterilization|विसंक्रमण; रोगाणुनाशन; वंध्यीकरण
しょうもう|shoumou|消耗|exhaustion; consumption|समापन; थकान; क्षय; खपत; मिलाना; संयोग
しょうてん|shouten|焦点|focus; point|ध्यान केंद्रित करना; देखने योग्य; केन्द्रित करना; बिंदु
しょうりゃく|shouryaku|省略|omission; abbreviation; abridgment|न लिया जाना; चूक; लोप; संकेताक्षर; संक्षिप्त; संक्षेपण; संक्षेपण
しょうゆ|shouyu|醤油|soy sauce|सोया सस
かね|kane|鐘|bell; chime|बो बो करना; घंटी; घंटी लगाना; घंटा बजाना; घंटानाद; झंकार
じょうきゅう|joukyuu|上級|advanced level; high grade; senior|उच्च स्तरीय; उत्कृष्ट; उत्कृष्ट.; वरिष्ठ; ज्येष्ठ; अपर
むしあつい|mushiatsui|蒸し暑い|humid; sultry|सीलनदार; नम; कामोत्तेजक; उमस; दुःखद
かざり|kazari|飾り|decoration|सजावट; अलंकरण; सम्मान
しんにゅう|shinnyuu|侵入|penetration; invasion; raid; aggression; trespass|प्रवेश; वेधन; भेदन; आक्रमण; हस्तक्षेप; धावा; धावा; छापा; पुलिस की कार्यवाही
くちびる|kuchibiru|唇|lips|अधर
ふりがな|furigana|振り仮名|pronunciation key|उच्चारण; उच्चारण की रीत; उच्चारण विधि
もうしわけない|moushiwakenai|申し訳ない|inexcusable|अक्षम्य
しんせい|shinsei|申請|application; request; petition|संबंध; लागू; परिश्रम; विनती करना; अनुरोध करना; आवेदन; आवेदन पट्रअ; याचिका; निवेदन करना
まっくら|makkura|真っ暗|total darkness; shortsightedness; pitch dark|कुल; पूर्ण; जोड़ लगाना; घोर अँधेरा; बिलकुल अँधेरा
しんわ|shinwa|神話|myth; legend|पौराणिक कथा; कल्पित कथा; कल्पणिक कथ; आलेख; अपूर्व कहानी; दन्तकथा
ごみ|gomi|塵芥|trash; rubbish|बकवास; नष्ट करना; निकम्मा; कटु आलोचना करना; मल; रद्दी
はなはだしい|hanahadashii|甚だしい|extreme; excessive; terrible|कठोर; समशीतोष्ण; तीव्र; अधिक; अत्यधिकआ; बेहद; भयानक
す|su|酢|vinegar|सिरका
ずけい|zukei|図形|figure|नमूना; विचार करना; कल्पना करना
すいちょく|suichoku|垂直|vertical; perpendicular|सीधा; लम्बरूप; लम्ब; सीधा; लम्ब; परपेंडिकुलर शिल्प
すいてい|suitei|推定|presumption; assumption; estimation|धारणा; अनुमान; परिकल्पना; मान्यता; पुर्वानुमान; कल्पना; विचार; अनुमान; आगणन
ずいひつ|zuihitsu|随筆|essays; miscellaneous writings|विविध; अनेक प्रकार के
すぎ|sugi|杉|Japanese cedar|जापानवासी; जापानी
すんぽう|sunpou|寸法|measurement; size; dimension|नाप; लम्बाई; मापन; लगाना; विस्तार; सरेस लगाना; परिमाण; पहलू; आयाम
せいのう|seinou|性能|ability; efficiency|प्रतिभा; योग्यता; सामर्थ्य; दक्षता; कार्यक्षमता; चुस्ती
せいべつ|seibetsu|性別|distinction by sex; sex; gender|प्रतिष्ठा; पार्थक्य; अन्तर; उत्तेजित करना; वर्ग; काम; लिंग
せいりつ|seiritsu|成立|coming into existence; arrangements; establishment; completion|आनेवाला; भावी; आगमन; स्थान; संस्था; नींव
せいび|seibi|整備|adjustment; completion; consolidation|सुधार; तालमेल; अनुकूलन; समाप्ति; समापन; पूरा; जमावट; चक बंदी; दृढ़ीकरण
しょうめん|shoumen|正面|the front; honesty|सामने; सत्यनिष्ठा; सच्चरित्रता; ईमानदारी
せいそう|seisou|清掃|cleaning|सफाई
せいぞん|seizon|生存|existence; being; survival|सत्ता; जीवन; ज़िन्दगी; जीवन; स्वभाव; प्राणी; प्रथा; उत्तरजीविता; [मृत्यु] से बच जाना{उत्तरजीवन}
おしい|oshii|惜しい|regrettable; disappointing; precious|खेदजनक; खेदजनक शोचनीय; निराशाजनक; बहुमूल्य; उत्कृष्ट; नितान्त
せんたん|sentan|先端|pointed end; tip; fine point|नुकीला; सुस्पष्ट; अंकित; गिरना; झुकना; सुझाव; ठीक
せんせい|sensei|専制|despotism; autocracy|निरंकुशता; स्वेच्छाचारिता; निरंकुश शक्ति; तानाशाही; निरंकुशता
せん|sen|栓|stopper; cork; stopcock|प्रभावशाली प्रदर्शन; बंद करना; ऊँचा पत्ता; काग लगाना; काग; कर्क; रोधनी; नल की टोटी
せんざい|senzai|洗剤|detergent; washing material|डिटर्जेंट; डिटर्जन; प्रक्षालक; धुलाई; धुलाई के कपड़े
うらやましい|urayamashii|羨ましい|envious; enviable|ईर्ष्यालु; ईष्यालु/द्वेषी; असूयक; ईर्षा के योग्य; स्पृहणीय
ねらい|nerai|狙い|aim|करना; लगाना; लक्ष्य
あらい|arai|粗い|coarse; rough|घटिया; असभ्य; भद्दा; कच्चा; कर्कश; कठोर
そしつ|soshitsu|素質|character; qualities; genius|दर्जा; प्रतिष्ठा; गुण; प्रतिभा; प्रवीण; निपुण
さっそく|sassoku|早速|at once; immediately; without delay; promptly|तुरन्त; एक ही समय; एक ही समय में; ठीक; उसी समय; तत्काल; के बिना; छोड़कर; न
そうい|soui|相違|difference; discrepancy; variation|झगड़ा; शेष; असमानता; असहमति; भिन्नता; असंगती; परिवर्तन; भिन्नता; विभिन्नता
そうご|sougo|相互|mutual; reciprocal|पारस्परिक; आपसी; परस्पर; पारस्परिक; प्रजाति परिवर्तक संकरण; अंतर्बदल
そうりだいじん|souridaijin|総理大臣|Prime Minister|प्रधानमंत्री
そうべつ|soubetsu|送別|farewell; send-off|बिदाई; विदाई; बिदा का प्रणाम
そうぞうしい|souzoushii|騒々しい|noisy; boisterous|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला; प्रबल; हुल्लड़बाज; कोलाहलपूर्ण
さわがしい|sawagashii|騒がしい|noisy|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला
ぞうげん|zougen|増減|increase and decrease; fluctuation|वृद्धि करना; बढ़ाना; विस्तार; अस्थिरता; बदलाव; उतार चढ़ाव
ぞうだい|zoudai|増大|enlargement|विवर्धन; विस्तारण
ぞうせん|zousen|造船|shipbuilding|पोतनिर्माण
そくてい|sokutei|測定|measurement|नाप; लम्बाई; मापन
そくりょう|sokuryou|測量|measurement; surveying|नाप; लम्बाई; मापन
そくりょく|sokuryoku|速力|speed|चलाना; जल्दी करना; भगाना
たいこ|taiko|太鼓|drum; tambourine|पीपा; थपथपाना; पीटना; डफली; खँजड़ी
たいさく|taisaku|対策|counter-plan; counter-measure|
かしだし|kashidashi|貸し出し|lending; loaning|ऋणदान
だいめいし|daimeishi|代名詞|pronoun|सर्वनाम
だいしょう|daishou|大小|size|लगाना; विस्तार; सरेस लगाना
だいめい|daimei|題名|title|पद; उपाधि; नाम
たんこう|tankou|炭鉱|coal mine; coal pit|कोयला भरना; कोयला उपलब्ध करना; अंगार; कोयला भरना; कोयला उपलब्ध करना; अंगार
たんき|tanki|短期|short term|अल्पावधि; अल्पावधिक
だんてい|dantei|断定|conclusion; decision|समाप्ति; निष्कर्ष; अंतिम निर्णय; निर्णय; निर्णय करना; निर्णय शक्ति
しりあい|shiriai|知合い|acquaintance|ज्ञान; पहचान; परिचित
ちたい|chitai|地帯|area; zone|क्षेत्र; क्षेत्र; मेखला; कटिबंध
じばん|jiban|地盤|(the) ground|ज़मीन
たけ|take|竹|bamboo; middle (of a three-tier ranking system)|बाँस; बीच
つける|tsukeru|着ける|(1) to attach; to join; to add; to append|लगाना; देना; संलग्न; शामिल होना; जोड़ना
きがえ|kigae|着替え|changing clothes; change of clothes|बदलना
ちゅうせい|chuusei|中性|neuter gender; neutral (chem.); indifference; sterility|नपुंसक बनाना; बे असर; नपुंसक; तटस्थ राष्ट्र; निष्पक्ष; तटस्थ; उदासीनता; उपेक्षा
ちゅうと|chuuto|中途|in the middle; half-way|
ちゅうしょう|chuushou|抽象|abstract|निकालना; निकाल देना; संक्षिप्त करना
ちょうせい|chousei|調整|regulation; adjustment; tuning|नियम; अधिनियम; नियन्त्रण; सुधार; तालमेल; अनुकूलन
ちょうせつ|chousetsu|調節|regulation; adjustment; control|नियम; अधिनियम; नियन्त्रण; सुधार; तालमेल; अनुकूलन; शासन; संचालन करना; निपुणता
ちょうてん|chouten|頂点|top; summit|ऊपर; शीर्ष सम्मेलन; शिखर; सम्मेलन
ちょっけい|chokkei|直径|diameter|गुणा; व्यास/मोटाई; व्यास
ちょくせん|chokusen|直線|straight line|सीधा; सीधे; लगातार
ついか|tsuika|追加|addition; supplement; appendix|अनुवृद्धि; वृद्धि; जोड़; वृद्धि करना; पूरक; पूरा करना; परिशिष्ट{जोड़ी हुई वस्तु}; परिशिष्ट; उण्डुपुच्छ
かみそり|kamisori|剃刀|razor|रेज़र; उस्तरा; रेज़र से कटना
くぎ|kugi|釘|nail|लगाना; कील; बंद करना
てっぽう|teppou|鉄砲|gun|बंदूक
てんのう|tennou|天皇|Emperor of Japan|कैसर; सम्राट
てんかい|tenkai|展開|develop; expansion (opposite of compression)|होना; फैलाना; दिखलाना; विस्तार; प्रसार
でんき|denki|伝記|biography; life story|जीवनचरित; जीवनी; जीवनी साहित्य; जीवन वृत्त; जीवनी
でんせん|densen|伝染|contagion|संक्रामक रोग; छूत; छूत/उड़नी बीमारी
でんちゅう|denchuu|電柱|telephone pole; telegraph pole; lightpole|टेलीफ़ोन का खंभा; टेलीफ़ोन का; तार का खंभा
とうよう|touyou|東洋|Orient|पूर्वी गोलार्ध; अनुकूल बनाना; स्थिति निर्धारण करना
とうなん|tounan|盗難|theft; robbery|चोर; चोरी; लूट पाट; डकैती
とうゆ|touyu|灯油|lamp oil; kerosene|लालटेन; टेबल; कंदील; मिट्टी तेल; मिट्टी का तेल; घासलेट
とういつ|touitsu|統一|unity; consolidation; uniformity|एक; एकात्मकता; इकाई; जमावट; चक बंदी; दृढ़ीकरण; एकरूपता; एकसमानता
とうけい|toukei|統計|scattering; a scatter; dispersion|फैलाव; फुहार; फैला हुआ; फैलाव; छितराव; तितर बितर करना; फैलाव; छितराव
とうめい|toumei|透明|transparency; cleanness|खोखलापन; स्पष्टता; पारदर्शिता
どうかく|doukaku|同格|the same rank; equality; apposition|समानता; समानाधिकरण; समानाधिकरण/अतिरीक्तोक्ति
どうわ|douwa|童話|fairy tale|सुखद; परी कथा; काल्पनिक कथा
どう|dou|銅|copper|पुलिस; पुलिसमैन; लाल भूरा रंग
とくしゅ|tokushu|特殊|special; unique|विशेष; अनोखा; अद्वितीय; अपूर्व
ひとりごと|hitorigoto|独り言|a soliloquy; a monologue; speaking to oneself|स्वगतभाषण; स्वगत कथन; एकालाप; स्वगत भाषण; एकपात्री रूपक
でこぼこ|dekoboko|凸凹|unevenness; roughness; ruggedness|असंतुलितता; असमतलता; कर्कशता; असभ्य व्यवहार; असभ्यता; मजबूती
つく|tsuku|突く|(1) to thrust; to strike; (2) to poke|आक्रमण; बल; ठेलना; बजना; आक्रमण; निकालना; निकलना; ढकेलना; चुभोना
なぞなぞ|nazonazo|謎謎|riddle; puzzle; enigma|पहेली; छलनी कर देना; रहस्य; समस्या; हैरान करना; पहेली; पहेली; गूढ़ प्रश्न
なんきょく|nankyoku|南極|south pole; Antarctic|दक्षिणी ध्रुव; दक्षिण ध्रुव; दक्षिणी ध्रुव; दक्षिणी ध्रुव या इसके आस पास के स्थान सम्बन्धी; दक्षिणध्रुवीय
なんぼく|nanboku|南北|south and north|दक्षिण
やわらかい|yawarakai|軟らかい|soft; tender; limp|बिखरा हुआ; मुलायम; धीमा; मुलायम; देना; हल्का; लचीला; कठिनाई से आगे बढ पाना; शिथिल
いれもの|iremono|入れ物|container; case; receptacle|आधान; पात्र; धारक/पात्र; घटना; समस्या; नमूना; पात्र धारक
のうりつ|nouritsu|能率|efficiency|दक्षता; कार्यक्षमता; चुस्ती
のうさんぶつ|nousanbutsu|農産物|agricultural produce|कृषि; कृषिक; खेती बारी का
はへん|hahen|破片|fragment; splinter; broken piece|टुकड़े टुकड़े होना; टुकड़े; तोड़ना; छिपटी; चिरना; अलग हो जाना; खंडित; निराश; टूटा हुआ
はいく|haiku|俳句|haiku poetry|
はいけん|haiken|拝見|(hum) (pol) seeing; look at|दृष्टि बोध; दृष्टि; दिखाना; विचार करना; देखना
うすぐらい|usugurai|薄暗い|dim; gloomy|मंदबुद्धि; कम करना; धीमा; उदास; अंधकारमय; निराशजनक
はし|hashi|箸|chopsticks|
はち|hachi|鉢|a bowl; a pot|प्राप्त करना; प्याला; आउट; सितारा मछली; बरतन; रखना
はっしゃ|hassha|発射|firing; shooting; discharge; catapult|बंदूक चलाना; पदच्युति; नौकरी; शिकार; गोलीबारी; गिरना; स्राव; प्रवाह
はんけい|hankei|半径|radius|घेरा; बहिः प्रकोष्ठिका; जानवरों में अग्र पैर की हड्डी
はんえい|hanei|反映|reflection; influence|झलक; परछाई; आरोप; प्रभाव; प्रभावित करना; प्रेरित करना
ひふ|hifu|皮膚|skin|छिलना; छिलका निकालना; छिलका
ひじ|hiji|肘|elbow|चीर कर जाना; कोना; कोहनी
ひっき|hikki|筆記|(taking) notes; copying|
ひょうしき|hyoushiki|標識|sign; mark|देना; सौंपना; संकेत; लिखना; संकेत; छाप
ひょうじゅん|hyoujun|標準|standard; level|दर्जा; शिष्ट; मान; परत; सपाट; समतल
ひょうし|hyoushi|表紙|front cover; binding|सामने; पट्टी; बाध्यकारी; आवश्यक
ひょうろん|hyouron|評論|criticism; critique|आलोचना; समीक्षा; आलोचना/समीक्षा; प्रत्यालोचना; समीक्षा
びんづめ|binzume|瓶詰|bottling; bottled|
ふうん|fuun|不運|unlucky; misfortune; bad luck; fate|अशुभ; अभागा/दुखी/मंदभाग्य; दुर्भाग्यशाली; दुर्भाग्य; बदकिस्मती; अवदशा; दुर्भाग्य
ふけつ|fuketsu|不潔|unclean; dirty; filthy; impure|अपवित्र; अस्वच्छ; मैला/गंदा/अपावन; गंदा; अश्लील; बहुत ही; मलिन
ふきん|fukin|付近|neighbourhood; vicinity; environs|क्षेत्र; इलाका; पड़ोस; इलाका; अड़ोस पड़ोस; परिप्रदेश
しきち|shikichi|敷地|site|बनाना; घटनास्थल; स्थान
ふごう|fugou|符号|sign; mark; symbol|देना; सौंपना; संकेत; लिखना; संकेत; छाप; चिन्ह; संकेताक्षर; चिह्न
ふぞく|fuzoku|附属|attached; belonging; affiliated|संलग्न; अनुरक्त
ふくし|fukushi|副詞|adverb|क्रिया विशेषण
ふくしゃ|fukusha|複写|copy; duplicate|प्रति; कपी; अनुकरण; अनुलिपि; प्रतिलिपि बनाना; समरूप
へいたい|heitai|兵隊|soldier; sailor|सैनिक; सिपाहगिरी; प्रचारक; नाविक; पनामा टोपी; नौसैनिक
ひらがな|hiragana|平仮名|hiragana; 47 syllables; the cursive syllabary|४७
へいかい|heikai|閉会|closure|मतादेश दे कर समापन; समापन; बंद होना
かたかな|katakana|片仮名|katakana|
へんしゅう|henshuu|編集|editing; compilation; editorial (e.g. committee)|संग्रह; संग्रहण; संकलन; सम्पादकीय लेख; सम्पादकीय; संपादकीय
あみもの|amimono|編物|knitting; web|बुनना; बुनाई; संचार; जाल बनाना; जाल
ぼしゅう|boshuu|募集|recruiting; taking applications|मनोहर; आसानी से मिलना; आकर्षक
ほうそう|housou|包装|packing; wrapping|बाँधने के लिये प्रयुक्त पदार्थ; सामान बाँधने का; पैक करने की सामग्री; ओढ़ना; आवरण; लपेटन
ぼうさん|bousan|坊さん|Buddhist priest; monk|भिक्षु; संन्यासी
ぼうえんきょう|bouenkyou|望遠鏡|telescope|घटाना; दूरबीन; एक् दुसरे में
ぼうだい|boudai|膨大|huge; bulky; enormous; extensive; swelling; expansion|बहुत अधिक; बहुत; विशाल; भारी   भरकम; बड़ा/2.स्थूल; बहुत; विशाल; बड़ा
ぼうし|boushi|防止|prevention; check|रोकथाम; रोक थाम; जाँच
ほっきょく|hokkyoku|北極|North Pole|उत्तरी ध्रुव
すみ|sumi|墨|ink|में स्याही भरना; पर दस्तखत करना; रोशनाई
ぼくちく|bokuchiku|牧畜|stock-farming|
ほり|hori|堀|moat; canal|खाई; खंदक; परिखा; नहर; नलिका; कुल्या
ぼん|bon|盆|Lantern Festival; Festival of the Dead; tray|लालटेन; समारोह; त्योहार; त्यौहार/उत्सव; ट्रे
まさつ|masatsu|摩擦|friction; rubbing; rubdown; chafe|संघर्ष; रगड़; घर्षण
または|mataha|又は|or; otherwise|अन्यथा; या/अथवा; या; अन्यथा; नहीं तो; दूसरे प्रकार
ばんざい|banzai|万歳|hurrah; cheers|हुर्रा!; वाह वाह/खुशी से चिल्लाना
まんてん|manten|満点|perfect score|उतम; निर्दोष; निपुण बनाना
みまん|miman|未満|less than; insufficient|छोटा; कम माऋआ मे़; कम; अपर्याप्त
みさき|misaki|岬|cape (on coast)|बिना बाँह का लबादा; अंतरीप; गरदनी/कंधे का वस्त्र
むげん|mugen|無限|infinite|अनंत; असीम; विशाल
むじゅん|mujun|矛盾|contradiction; inconsistency|प्रतिवाद; विरोधाभास; अन्तर्विरोध; असंगति; भिन्नता
めいさく|meisaku|名作|masterpiece|उत्कृष्ट कृति
めいし|meishi|名詞|noun|नाम; संज्ञा
めいぶつ|meibutsu|名物|famous product; special product; speciality|उत्कृष्ट; जाना; विख्यात; विशेष; विशेषता; खासियत
めいしん|meishin|迷信|superstition|अंधविश्वास; अन्धविश्वास; अंध विश्वास
めいめい|meimei|銘々|each; individual|प्रत्येक; विशिष्ट; व्यक्ति; अलग अलग
めい|mei|姪|niece|भांजी; भतीजी
めんせき|menseki|面積|area|क्षेत्र
けいと|keito|毛糸|knitting wool|बुनना; बुनाई
けがわ|kegawa|毛皮|fur; skin; pelt|लोमदार जानवरों की; रोएँदार; बीमारी में जिह्वा पर होने वाली तह; छिलना; छिलका निकालना; छिलका; खाल; फ़ेंकना/फ़ेंककर मारना; ताबड़तोड़ भागना
といあわせ|toiawase|問い合わせ|enquiry; ENQ|पूछताछ
やじるし|yajirushi|矢印|directing arrow|
やくしゃ|yakusha|役者|actor; actress|कर्ता; अभिनेता; कलाकार; अभिनेत्री
ゆうゆう|yuuyuu|悠々|quiet; calm; leisurely|शांत; शांत करना; ठहराव; निश्चलता; धीरे धीरे; इत्मीनान भरा; इत्मीनान से
うむ|umu|有無|yes or no; existence; flag indicator (comp); presence or absence marker|हाँ; सत्ता; जीवन; ज़िन्दगी; लम्बे बालों वाला शिकारी कुत्ता; कमज्ॅओर पड़ जाना; कम होना
ゆうそう|yuusou|郵送|mailing|डाक; डाक से भेजना
ようき|youki|容器|container; vessel|आधान; पात्र; धारक/पात्र; नस; नलिका; बर्तन
ようがん|yougan|溶岩|lava|लावा
ようと|youto|用途|use; usefulness|उपयोग; उपयोगिता
ようもう|youmou|羊毛|wool|ऊनी कपड़ा; ऊनी; बाल
ようし|youshi|要旨|gist; essentials; summary; fundamentals|सार; सारांश; तात्पर्य; संक्षिप्त; सारांश; सरसरी
ようりょう|youryou|要領|point; gist; essentials; outline|बिंदु; सार; सारांश; तात्पर्य
おとしもの|otoshimono|落し物|lost property|खोयी हुई सम्पत्ति
らん|ran|欄|column of text (e.g. as in a newspaper)|पंक्ति; कलम; दंड
ためいき|tameiki|溜息|a sigh|साँस लेना; तरसना; आह भरना
りょうがわ|ryougawa|両側|both sides|दोनों
ちからづよい|chikarazuyoi|力強い|reassuring; emboldened|आश्वस्त करने वाला
れいがい|reigai|例外|exception|अपवाद; कोई व्यक्ति या चीज को छोड़ना
すず|suzu|鈴|bell|बो बो करना; घंटी; घंटी लगाना
れいてん|reiten|零点|zero; no marks|शून्य
れんが|renga|煉瓦|brick|इष्टिका; खिलौना; मदत करने वाला
ろうそく|rousoku|蝋燭|candle|बत्ती; शमा; ज्योतोर्मयता का एकक
わえい|waei|和英|Japanese-English|
わふく|wafuku|和服|Japanese clothes|जापानवासी; जापानी
はなしあい|hanashiai|話合い|discussion; conference|चर्चा; बहस; आलोचनाआ; सम्मेलन; अधिवेशन
わん|wan|碗|bowl|प्राप्त करना; प्याला; आउट
すり|suri|掏摸|pickpocket|जेबकतरा
しゃれ|share|洒落|joke; pun; witticism|हँसी खेल; चुटकुला; हँसी मज़ाक; श्लेष; हाज़िरजवाबी
ずるい|zurui|狡い|sly; cunning|कपटी; धूर्ततापूर्ण; धूर्त; कपटी; अच्छा; धूर्त
おかげ|okage|お蔭|(your) backing; assistance|संगत; सहायता; सहारा; सहायता; मदद
おねがいします|onegaishimasu|お願いします|please|कृपया
おみや|omiya|お宮|Shinto shrine|शिन्तो धर्म; शिन्तो
おとも|otomo|お供|attendant; companion|संलग्न; जुड़ा हुआ; सहवर्ती घटना; साथी; छोटी पुस्तक; मिट्र
おさん|osan|お産|(giving) birth|जन्म
おつかい|otsukai|お使い|errand|दूतकार्य
おじゃまします|ojamashimasu|お邪魔します|Excuse me for disturbing (interrupting) you|क्षमा
おせじ|oseji|お世辞|flattery; compliment|चापलूसी; चमचागिरी; प्रशंसा; प्रशंसा करना; शुभकामनाएँ
おむつ|omutsu|お襁褓|diaper; nappy|लंगोटी; हीरे जड़ित चद्दर; बच्चों की चड्डी; लंगोटी; लंगोट{छोटे बच्चे का}
ごぶさた|gobusata|ご無沙汰|not writing or contacting for a while|
ずぶぬれ|zubunure|ずぶ濡れ|soaked; dripping wet|नशे में धुत्त; पूरी तरह से भीगा हुआ; पूरी तरह से भीगा; माँस तेल; बहुत; बहुत गीला
そのほか|sonohoka|その外|besides; in addition; the rest|को छोड़कर; इसके अलावा; के अतिरिक्त; के अतिरिक्त; इसके; इसके साथ साथ; आराम
どうぞよろしく|douzoyoroshiku|どうぞ宜しく|pleased to meet you|प्रसन्न; प्रफुल्ल; खुश
あく|aku|悪|evil; wickedness|दुष्ट; बुरा; दुष्टता; दुष्टता; जुगुप्सा; अनैतिकता
わるもの|warumono|悪者|bad fellow; rascal; ruffian; scoundrel|बुरा; शरारती; दुष्ट; कमीना; बदमाश; गुंडा; गुण्डा
よし|yoshi|葦|reed; bulrush|बाँसुरी; कंपिका; नरकट; पटेर
あっぱく|appaku|圧迫|pressure; coercion; oppression|बल; प्रभाव; दबाव; ज़ोर ज़बर्दस्ती; जोर जबरदस्ती; प्रपीडन; दमन; विषाद; उत्पीडन
あつりょく|atsuryoku|圧力|stress; pressure|दबाव; महत्त्व; जोर; बल; प्रभाव; दबाव
あるいは|aruiha|或いは|or; possibly|अन्यथा; या/अथवा; या; संभव हो सकना; सम्भवतः; शायद
あんざん|anzan|暗算|mental arithmetic|मौखिक गणित
あんじ|anji|暗示|hint; suggestion|झलक; संकेत; सुझाव; संकेत; सुझाव
いい|ii|伊井|that one; Italy|वह
い|i|依|depending on|
よって|yotte|依って|therefore; consequently; accordingly; because of|अतः; इसलिए; इस तरह से; परिणामस्वरूप; इसके; अतः/इसलिये; फलस्वरूप; परिस्थिति के अनुसार; तदनुसार
いそん|ison|依存|dependence; dependent; reliance|सहारा; निर्भर्ता; विश्वास; निर्भर; निर्भर करना; आश्रित; आसरा; जिस पर विश्वास किया जाए /निर्भर किया जाए/निर्भरता; विश्वास
いりょく|iryoku|威力|power; might; authority; influence|शक्ति; बल; प्रभाव; शक्ति; अधिकारी; विशेषज्ञ; अधिकार
いと|ito|意図|intention; aim; design|धारणा; विचार; अंतिम लक्ष्य; करना; लगाना; लक्ष्य; नमूना; बनावट; योजना बनाना
やすい|yasui|易い|easy|आसान
いせい|isei|異性|the opposite sex|
いどう|idou|異動|a change|बदलना
いみん|imin|移民|emigration; immigration; emigrant; immigrant|उत्प्रवासन; उत्प्रवास; आप्रवासी; आप्रवासन; आव्रजन; परदेश जानेवाला व्यक्ति; उत्प्रवासी; देशत्यागी
いるい|irui|衣類|clothes; clothing; garments|कपड़े; पहनावा; परिधान; वस्त्र
いせき|iseki|遺跡|historic ruins (remains  relics)|ऐतिहासिक; इतिहास  प्रसिध्द
いきがい|ikigai|域外|outside the area|बाहर
そだち|sodachi|育ち|breeding; growth|प्रजनन; अभिजाति; उच्चवंश; पौधा; सूजन; वृध्दि
いちいち|ichiichi|一々|one by one; separately|एक एक करके; अलग; अलग अलग; स्वतंत्र रूप से
ひとまず|hitomazu|一まず|for the present; once; in outline|अभी के लिए; एक बार
いちりつ|ichiritsu|一律|evenness; uniformity; monotony; equality|एकरूपता; एकसमानता; ऊब; नीरसता; एकस्वरता
いちれん|ichiren|一連|a series; a chain; a ream (of paper)|शृंखला; सीरीज; प्रक्रम; बंधन; क्रम; नापना; रस निकालना; बीस दस्ता काग़ज़ की गड्डी; ताव
いなびかり|inabikari|稲光|(flash of) lightning|बहुत जल्दी; तडित; बिजली
ぼう|bou|卯|fourth sign of Chinese zodiac (The Hare  5am-7am  east  February)|चौथा
うず|uzu|渦|swirl|चक्कर; भँवर में बहना; छल्ला
うんぬん|unnun|云々|and so on; and so forth; comment|इत्यादि; इत्यादि; टीका टिप्पणी करना; टिप्पणी; आलोचना
うんちん|unchin|運賃|freight rates; shipping expenses; fare|भरना; माल; माल ले जाना; नौपरिवहन; पोत परिवहन; पोत समूह; खाना; किराया; भोजन
うんめい|unmei|運命|fate|विधि; भाग्य; निर्धारित करना
うんよう|unyou|運用|making use of; application; investment; practical use|निर्माण; संबंध; लागू; परिश्रम; निवेशन; निवेश; विनीयुक्त धन
えいしゃ|eisha|映写|projection|झुकाव; प्रक्षेपण; चित्र प्रदर्शन
えき|eki|液|liquid; fluid|स्पष्ट; स्वच्छ; प्रवाही; लचीला; अस्थिर; प्रवाही
ぞい|zoi|沿い|along|साथ
えんがん|engan|沿岸|coast; shore|किनारा; चलाना; व्यापार; किनारा; टेक लगाना; उठाना
たばこ|tabako|煙草|(pt:) (n) (uk) tobacco (pt: tabaco); cigarettes|तम्बाकू; तंबाकू; तंबाकू का पौधा
ふち|fuchi|縁|chance; fate; destiny; relation; bonds; connection; karma|अवसर; आकस्मिक; मौका; विधि; भाग्य; निर्धारित करना; नियति; भाग्य; नियत
つや|tsuya|艶|charming; fascinating; voluptuous|रुशील; जादुई; मनोरम; दिलचस्प; आकर्षक; आकर्षक; भारी वक्ष स्थल वाली; विलासी
なまり|namari|鉛|lead (the metal)|नमूना; प्रमुख; राय देना
お|o|於|at; in; on|पर; में; पर
おいて|oite|於いて|at; in; on|पर; में; पर
けがらわしい|kegarawashii|汚らわしい|filthy; unfair|अश्लील; बहुत ही; मलिन; अनुचित; गलत; बेढंगा
おい|oi|甥|nephew|भतीजा; भतीजा[भांजा]
おうぼ|oubo|応募|subscription; application|चंदा; शुल्क; चंदा/अंशदान; संबंध; लागू; परिश्रम
かい|kai|下位|low rank; subordinate; lower order (e.g. byte)|नीचा; अधीन; गौण शब्द; मातहत; छोटा; कम करना; गिरना
したしらべ|shitashirabe|下調べ|preliminary investigation; preparation|प्रारंभिक; प्रारंभिक दौर; प्रारंभिक तैयारी; खाना; सम्पाक; अभ्यासकार्य
かり|kari|下吏|lower official|छोटा; कम करना; गिरना
げり|geri|下痢|diarrhoea|दस्त; अतिसार
かせん|kasen|化繊|synthetic fibres|अवास्तविक; कृत्रिम; जाली/बनावटी
か|ka|仮|tentative; provisional|आज़माइशी; आजमाइशी.; अनिश्चित   सा; अस्थायी
なになに|naninani|何々|which (emphatic)|कौन सा
なんて|nante|何て|how...!; what...!|कैसे; क्या
どの|dono|何の|which; what|कौन सा; क्या
なにも|nanimo|何も|nothing|कुछ नहीं
なぜ|naze|何故|why; how|क्यों; कैसे
なぜなら|nazenara|何故なら|because|क्योंकि
かにゅう|kanyuu|加入|becoming a member; joining; entry; admission; subscription; affiliation; adherence; signing|अच्छा; उचित; जंचनेवाला; दहलीज; प्रवेशाधिकार; द्वार
かわいそう|kawaisou|可哀想|poor; pitiable; pathetic|गरीब; दयनीय; दीन; दयनीय; शोचनीय; भावात्मक
やぬし|yanushi|家主|landlord|शराबखाने का मालिक; शराबखाने; मकान मालिक
かちく|kachiku|家畜|domestic animals; livestock; cattle|घरेलू नौकर; पालतू; चाकर/घर का नौकर; पशुधन; ढोर; पशु/मवेशी; गाय बैल
はて|hate|果て|the end; the extremity; the limit(s); the result|अंत; चरम; पराकाष्ठा; अग्रांग; मर्यादा; हद; सीमा
ここ|koko|箇箇|individual; separate|विशिष्ट; व्यक्ति; अलग अलग; रोकना; निकालना; भिन्न
にづくり|nizukuri|荷造り|packing; baling; crating|बाँधने के लिये प्रयुक्त पदार्थ; सामान बाँधने का; पैक करने की सामग्री
かがい|kagai|課外|extracurricular|पाठ्यक्रमेतर
かだい|kadai|課題|subject; theme; task|विषय; लाक्षणिक; विषय; धुन; काम; हद पार करना; भार
あやまち|ayamachi|過ち|fault; error; indiscretion|त्रुटि; अवगुण; शिकार खो बैठना; भूल; गलती; गलतियाँ; अविवेकपूर्ण; असावधानी; अविवेकपूर्ण कार्य
かそ|kaso|過疎|depopulation|
かみつ|kamitsu|過密|crowded|सघन; भरा हुआ; भरा
かいにゅう|kainyuu|介入|intervention|हस्तक्षेप; मध्यवर्त
かい|kai|会|understanding|सहमति; तालमेल; समझदार
かいぼう|kaibou|解剖|dissection; autopsy|विच्छेदन; विश्लेषण; शोध केलिए लाश या पौधों की चीरफाड़; शव परीक्षा
かいらん|kairan|回覧|circulation|खपत; गर्दिश; प्रचलन
かいじゅう|kaijuu|怪獣|monster|दैत्य; भीमकाय; अति क्रूर
かいあく|kaiaku|改悪|deterioration; changing for the worse|कमी; विकृति; अवनति
かいかく|kaikaku|改革|reform; reformation; innovation|सुधार; सुधारना; फिर बनाना; सुधार; उद्धार; नवीनीकरण; नवीनता; नवाचार
かいしゅう|kaishuu|改修|repair; improvement|जमाव; मरम्मत; सुधार; सुधार; प्रगति; उन्नति
かいてい|kaitei|改定|reform|सुधार; सुधारना; फिर बनाना
かいてい|kaitei|改訂|revision|सुधार; पुनर्लेखन; दोहराई
かいりょう|kairyou|改良|improvement; reform|सुधार; प्रगति; उन्नति; सुधार; सुधारना; फिर बनाना
はいざら|haizara|灰皿|ashtray|राख दानी; राखदानी; ऐश ट्रे
かいたく|kaitaku|開拓|reclamation (of wasteland); cultivation; pioneer|परती ज़मीन; सुधार; भूमि उद्धार; कृषि; खेती; जुताई; मार्ग प्रशस्त करना; आरंभिक; अग्रगामी/पथप्रदर्शक
かいはつ|kaihatsu|開発|development; exploitation|सुधार; विस्तार; आविष्कार; उपयोग; शोषण; दोहन
かいがら|kaigara|貝殻|shell|गोलाबारी करना; खोल; सीप
がけ|gake|崖|cliff|खड़ी चट्टान; प्रपात; खड़ी
がいりゃく|gairyaku|概略|outline; summary; gist; in brief|रूपरेखा; दर्शाना; खाका; संक्षिप्त; सारांश; सरसरी; सार; सारांश; तात्पर्य
ふた|futa|蓋|cover; lid; cap|ढकना; रोकना; ढक्कन; रूकावट; शिखर; टोपी पहनाना; कुकुरमुत्ता
かくさん|kakusan|拡散|scattering; diffusion|फैलाव; फुहार; फैला हुआ; फैलाव
かく|kaku|格|status; character; case|दर्जा; ओहदा; स्थिति; दर्जा; प्रतिष्ठा; गुण; घटना; समस्या; नमूना
かくさ|kakusa|格差|qualitative difference; disparity|गुणात्मक; गुणवाचक; अन्तर; असमानता; विषमता
かく|kaku|核|nucleus; kernel|केन्द्र; नाभि; गूदा; सार; गरी; गिरी/दाना
かくとく|kakutoku|獲得|acquisition; possession|संपत्ति; प्राप्ति; अभिग्रहण; आधिपत्य; अधिकार; सम्पत्ति
おぼえ|oboe|覚え|memory; sense; experience|स्मरण शक्ति; याद; याददाश्त; दिशा; होश; ज्ञान; अनुभव करना; अनुभव; अनुभूति
かくしん|kakushin|革新|reform; innovation|सुधार; सुधारना; फिर बनाना; नवीनीकरण; नवीनता; नवाचार
かくめい|kakumei|革命|revolution|नक्षत्र का परिभ्रमण; आमूल परिवर्तन; पूरा चक्कर/परिभ्रमण
あご|ago|顎|chin|बातचित; ठुड्डी तक उठाना; बातचित करना
かつ|katsu|割|divide; cut; halve; separate; split; rip; break; crack; smash; dilute|विभाजित; फैल जाना; अलग करना; काटना; आधा कर देना; आधा हो जाना; आधा
わりざん|warizan|割り算|division (math)|वर्ग; हिस्सा; श्रेणी
なめらか|nameraka|滑らか|smoothness; glassiness|सहजता; चिकनापन
かつ|katsu|且つ|yet; and|अभी तक; और
ほし|hoshi|乾|heaven; emperor|स्वर्ग; वायुमंडल; भगवान; कैसर; सम्राट
まき|maki|巻|volume|प्रबलता; घनफल; अंक
かんりょう|kanryou|官僚|bureaucrat; bureaucracy|दफ़्तरशह; अधिकारी वर्ग; नौकरशाही; दफ़्तरशाही
ほしもの|hoshimono|干し物|dried washing (clothes)|
かんしょう|kanshou|干渉|interference; intervention|बाधा; हस्तक्षेप; व्यतिकरण; हस्तक्षेप; मध्यवर्त
かんせん|kansen|感染|infection; contagion|स्वर; संक्रामक रोग; छूत; संक्रामक रोग; छूत; छूत/उड़नी बीमारी
かんよう|kanyou|慣用|common; customary|सामान्य; विशिष्ट; हमेशा का; प्रचलित
かんれい|kanrei|慣例|custom; precedent; of convention|दर्ज़ी से सिली हुई; रीति; प्रथा; नमूना; उदाहरण; पूर्ववर्ती
かんさん|kansan|換算|conversion; change; exchange|परिवर्तन; सुधार; रूपांतरण; बदलना; करना; बदल देना; केन्द्र
さお|sao|竿|rod; pole (e.g. for drying laundry)|दण्ड; दंड; जाति; चलाना; ठेलना; ध्रुव
くだ|kuda|管|pipe; tube|बोलना; बाँसुरी; गाना; नाली; नल; ट्यूब
ゆるやか|yuruyaka|緩やか|lenient|नरम
かんわ|kanwa|緩和|relief; mitigation|उभार; राहत; मुक्ति; कमी; गम्भीरता कम कर देना
かんしゅう|kanshuu|観衆|spectators; onlookers; members of the audience|
かんろく|kanroku|貫禄|presence; dignity|के सामने; सामना; व्यक्तित्व; प्रतिष्ठा; मर्यादा; गौरव
まるごと|marugoto|丸ごと|in its entirety; whole; wholly|पूरी तरह से; पूर्णतया; पूरा; पूरी तरह से; पूरी तरह
おもちゃ|omocha|玩具|toy|खिलौना
がん|gan|癌|cancer|कैन्सर; बुराई; कैन्सर का टयूमर
めがね|megane|眼鏡|spectacles; glasses|चश्मा; चश्मा; काँच; दूरबीन
がんぶつ|ganbutsu|贋物|imitation; counterfeit; forgery; sham|कृत्रिम; नकली/अनुकरण; अनुकरण; जाली; जाली/नकली; जाली बनाना; नकली; नकल; जालसाज़ी
がんこ|ganko|頑固|stubbornness; obstinacy|ज़िद; अड़ियलपन; हठधर्मिता; ज़िद
がんじょう|ganjou|頑丈|solid; firm; stout; burly; strong; sturdy|असली; वास्तविक; सच्चा; स्थिर; अटल; मजबूत; मोटा; तेज; दिलेर
きき|kiki|危機|crisis|चरम बिन्दु; संकट; चरम
うつわ|utsuwa|器|bowl; vessel; container|प्राप्त करना; प्याला; आउट; नस; नलिका; बर्तन; आधान; पात्र; धारक/पात्र
もと|moto|基|basis|आधार
きまつ|kimatsu|期末|end of term|अंत
はた|hata|機|loom|अस्पष्ट छाया दीखना; हावी होना; सम्भावना होना
きこう|kikou|機構|mechanism; organization|प्रक्रिया; यंत्रविन्यास; तरीका; बनावट; संघ; संरचना
いのり|inori|祈り|prayer; supplication|पूजारी; मांग; आराधक; अनुनय विनय; प्रार्थना
きかく|kikaku|規格|standard; norm|दर्जा; शिष्ट; मान; प्रकृत; कसौटी; मानदंड
きせい|kisei|規制|regulation|नियम; अधिनियम; नियन्त्रण
きてい|kitei|規定|regulation; provisions|नियम; अधिनियम; नियन्त्रण; शर्त; खाद्य; खाद्य आपूर्ती
きぼ|kibo|規模|scale; scope; plan; structure|परत; मान; पलड़ा; विस्तार; क्षेत्र; दोलन दर्शी; योजना
きさい|kisai|記載|mention; entry|चर्चा; कहना; उल्लेख करना; दहलीज; प्रवेशाधिकार; द्वार
きじゅつ|kijutsu|記述|describing; descriptor|शब्द रूप
きぞく|kizoku|貴族|noble; aristocrat|बहुत अच्छा; उतम; शानदार; अभिजात वर्ग का व्यक्ति; अभिजात
きげん|kigen|起源|origin; beginning; rise|मूल; आरम्भ; उद्गम; शुरुआत; उदय होना; निकलना; चढना
きふく|kifuku|起伏|undulation|नमनोन्नमनशीलता; तरंग; तरंगण
ぎぞう|gizou|偽造|forgery; falsification; fabrication; counterfeiting|नकली; नकल; जालसाज़ी; जालसाज़ी; मिथ्याकरण; रचना; मनगढ़ंत
よろしく|yoroshiku|宜しく|well; properly; suitably; best regards; please remember me|अच्छी तरह; ठीक से; उचित ढंग से; उपयुक्त रूप से
ぎわく|giwaku|疑惑|doubt; misgivings; distrust; suspicion|संदेह करना; पर संदेह करना; पर शंका होना; धोखा; शंका; अविश्वास करना/संदेह करना
ぎけつ|giketsu|議決|resolution; decision; vote|विश्लेषण; इरादा/संकल्प; प्रस्ताव; निर्णय; निर्णय करना; निर्णय शक्ति; राय देना; प्रस्ताव करना; घोषित करना
しゃっくり|shakkuri|吃逆|hiccough; hiccup|हिचकी; हिचकी आना; गड़बड़ी; हिचकी; हिचकी आना; गड़बड़ी
つまらない|tsumaranai|詰らない|insignificant; boring; trifling|तुच्छ; नगण्य; मामूली; उबाऊ; उबाऊ/नीरस; कुपछेदन; तुच्छ; छोटी
きゃくほん|kyakuhon|脚本|scenario|दृश्य; दृश्य लेख; पटकथा
ひさしい|hisashii|久しい|long; long-continued; old (story)|लंबा; पुराना
および|oyobi|及び|and; as well as|और; के अतिरिक्त; के; के साथ साथ
きゅうでん|kyuuden|宮殿|palace|राजमहल; महल; राजभवन
ゆみ|yumi|弓|bow (and arrow)|झुकाना; सिर; गलही
すくい|sukui|救い|help; aid; relief|मदद; सहायता; मदद; मदद करना; उभार; राहत; मुक्ति
きゅうえん|kyuuen|救援|relief; rescue; reinforcement|उभार; राहत; मुक्ति; राहत; बचाना; बचाव; मजबूती; कुमुक; अतिरिक्त लड़ाई का सामान
きゅうさい|kyuusai|救済|relief; aid; rescue; salvation; help|उभार; राहत; मुक्ति; सहायता; मदद; मदद करना; राहत; बचाना; बचाव
きゅうきょく|kyuukyoku|究極|ultimate; final; eventual|परम; सर्वश्रेष्ठ; अंतिम; अंतिम; अन्तिम; अंतिम चरण; संभावित; अन्तिम
きゅうぼう|kyuubou|窮乏|poverty|कमी; अभाव; अनुवर्रता
きょぜつ|kyozetsu|拒絶|refusal; rejection|अस्वीकृति; असम्मति; अस्वीकरणाधिकार; अस्वीकृति; इनकार; नामंजूरी
きょひ|kyohi|拒否|denial; veto; rejection; refusal|इंकार; निषेध; परित्याग; अस्वीकार करना; रोक देना; मना करना; अस्वीकृति; इनकार; नामंजूरी
きょよう|kyoyou|許容|permission; pardon|अनुमति देना; आज्ञा; मंजूर; दुबारा कहना; क्षमा करना; माफी
きょり|kyori|距離|distance; range|प्रक्रिया; दूर रखना; दूर; प्रकार; पंक्ति; श्रेणी
のこぎり|nokogiri|鋸|saw|देखा; आरे से चीरना; आरा चलाना
ぎょせん|gyosen|漁船|fishing boat|मछली पकड़ना; मछली; मछली मारना
きょうじゅ|kyouju|享受|reception; acceptance; enjoyment; being given|स्वीकृति; स्वागत; स्वागत समारोह; स्वीकृति; स्वीकार; स्वीकरण; आस्वादन; मौज मस्ती; खुशी
きょうかん|kyoukan|共感|sympathy; response|संवेदना; सहमति; सहानुभूति; प्रतिक्रिया; ईसाइयों मे प्रार्थना  पाठ के उत्तर मे गाया जाने वाला भजन; धार्मिक
きょうさん|kyousan|共産|communism|साम्यवाद; समष्टिवाद
きょうそん|kyouson|共存|coexistence|मिल जुलकर रहना; सह अस्तित्व
きょうさく|kyousaku|凶作|bad harvest; poor crop|बुरा; गरीब
きょうてい|kyoutei|協定|arrangement; pact; agreement|सजावट; प्रक्रिया; व्यवस्थापन; समझौता; अनुबंध; वचन; सहमति; करार
きょうぐう|kyouguu|境遇|environment; circumstances|पर्यावरण; वातावरण; परिमंडल; परिस्थिति; परिस्थितियाँ
しいて|shiite|強いて|by force|
きょうせい|kyousei|強制|obligation; coercion; compulsion; enforcement|अनुबंध पट्र; एहसान; आभार; ज़ोर ज़बर्दस्ती; जोर जबरदस्ती; प्रपीडन; विवशता; दबाव; अनिवार्यता
きょうい|kyoui|驚異|wonder; miracle|आश्चर्य; विस्मय; भटकना; काशिफ; चमत्कार
きょくげん|kyokugen|局限|limit; localize|मर्यादा; हद; सीमा; स्थान निर्धारित करना; सीमित रखना; परिसीमित करना
きょくたん|kyokutan|極端|extreme; extremity|कठोर; समशीतोष्ण; तीव्र; चरम; पराकाष्ठा; अग्रांग
たま|tama|玉|king (shogi)|राजा
きんべん|kinben|勤勉|industry; diligence|उद्योग; परिश्रम; मेहनत; परिश्रम; कर्मठता
きんこう|kinkou|均衡|equilibrium; balance|संतुलन; साम्य; बराबर करना; हिचकिचाना; सँभालना
きんもつ|kinmotsu|禁物|taboo; forbidden thing|निषिद्ध; निषेध; वर्जित; निषिद्ध; वर्जित
えり|eri|襟|neck; collar; lapel; neckband|गर्दन; झपट लेना; पट्टा; पकड़ना; लौट; खुले गले के कोट कालर
きんこう|kinkou|近郊|suburbs; outskirts|नगर; नगर परिसर; उपांत; बाहरी इलाका
きんし|kinshi|近視|shortsightedness|
くぎり|kugiri|区切り|an end; a stop; punctuation|अंत; रुकना; विरामादि चिह्न
おろか|oroka|愚か|foolish; stupid|मूर्ख; नासमझ; मूर्खतापूर्ण; मूर्ख; बेवकूफ़; फालतू
ぐち|guchi|愚痴|idle complaint; grumble|निष्क्रिय; व्यर्थ; आलसी; शिकायत; गरजना; शिकायत करना
くっせつ|kussetsu|屈折|bending; indentation; refraction|दंतुरण; असमतलता; निशान; अपवर्तन
ぐん|gun|群|group (math)|समूह
ぐんしゅう|gunshuu|群集|(social) group; crowd; throng; mob; multitude|समूह; भीड़; भीड़ लगाना; भीड़; भीड़ करना
ぐんび|gunbi|軍備|armaments; military preparations|सेना; सैनिक; फौज
ぐんぷく|gunpuku|軍服|military or naval uniform|सेना; सैनिक; फौज
けい|kei|傾|lean; incline|थोड़ा; खाली; दुबला; प्रोत्साहित; प्रोत्साहित करना; प्रेरित करना
けいばつ|keibatsu|刑罰|judgement; penalty; punishment|धारणा; परख; पहचान; दंड; जुर्माना; दण्ड/सज़ा; शासन; दंड; ताड़ना
けいき|keiki|契機|opportunity; chance|अवसर; मौका; सुअवसर; अवसर; आकस्मिक; मौका
けいせい|keisei|形勢|condition; situation; prospects|निश्चित करना; उपाधि; ठीक करना; समस्या; दृश्य; स्थिति; संभावना
けいせい|keisei|形成|formation|बनावट; निर्माण; रचना
けいたい|keitai|形態|form; shape; figure|दर्जा; प्रकार; विचार करना; नमूना; अनुकूल बनाना; बनावट; नमूना; विचार करना; कल्पना करना
けいぐ|keigu|敬具|Sincerely yours|भवदीय
くき|kuki|茎|stalk|अकड़ कर चलना; स्टक; रौबदार चाल
けいき|keiki|計器|meter; gauge|मीटर से; मापक; मीटर से नापना; नापना; माप; नाप
けいげん|keigen|軽減|abatement|कमी; घटाव; कम
けいべつ|keibetsu|軽蔑|scorn; disdain|तिरस्कार; तिरस्कार करना; घृणा का पाट्र; उपेक्षा करना; अवहेलना; उपेक्षा
けつ|ketsu|傑|excellence|प्रतिष्ठा; विशिष्टता; श्रेष्ठता
けつぎ|ketsugi|決議|resolution; vote; decision|विश्लेषण; इरादा/संकल्प; प्रस्ताव; राय देना; प्रस्ताव करना; घोषित करना; निर्णय; निर्णय करना; निर्णय शक्ति
けっさん|kessan|決算|balance sheet; settlement of accounts|तुलन पत्र; वित्तीय स्थिति विवरण; निपटारा; समझौता; भुगतान
むすび|musubi|結び|ending; conclusion; union|समाप्ति; प्रत्यय; विभक्ति; समाप्ति; निष्कर्ष; अंतिम निर्णय; संयोग; संघ; ग्रेट ब्रिटेन
むすびつき|musubitsuki|結び付き|connection; relation|नाता; संबन्ध; संपर्क; नाता; संबंध; रिश्तेदारी
けっかく|kekkaku|結核|tuberculosis; tubercule|क्षय; क्षय रोग
けっせい|kessei|結成|formation|बनावट; निर्माण; रचना
けっそく|kessoku|結束|union; unity|संयोग; संघ; ग्रेट ब्रिटेन; एक; एकात्मकता; इकाई
やかましい|yakamashii|喧しい|noisy; strict; fussy|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला; सही; पक्का; सख्त; हड़बड़ाहट भरा; अति; मीन मेख निकालने वाला
けん|ken|圏|sphere; circle; range|वृत्त; गोला; क्षेत्र; वृत्त; पंक्ति; घेरना; प्रकार; पंक्ति; श्रेणी
まくる|makuru|捲る|verb suffix to indicate reckless abandon to the activity|क्रिया; क्रियापद
けんい|keni|権威|authority; power; influence|अधिकारी; विशेषज्ञ; अधिकार; शक्ति; प्रभाव; प्रभावित करना; प्रेरित करना
けんげん|kengen|権限|power; authority; jurisdiction|शक्ति; अधिकारी; विशेषज्ञ; अधिकार; न्याय अधिकार; अधिकार क्षेत्र; न्याय करने का अधिकार
けんりょく|kenryoku|権力|power; authority; influence|शक्ति; अधिकारी; विशेषज्ञ; अधिकार; प्रभाव; प्रभावित करना; प्रेरित करना
みすぼらしい|misuborashii|見すぼらしい|shabby; seedy|अनुचित; जीर्ण शीर्ण; फटा; घटिया; बिजैला; बीमार
みせもの|misemono|見せ物|show; exhibition|दिखाना; प्रदर्शनी; प्रदरशनी; नुमाइश
みっともない|mittomonai|見っともない|shameful; indecent|शर्मनाक; भद्दा; अश्लील; अनुचित
みつもり|mitsumori|見積り|estimation; quotation|विचार; अनुमान; आगणन; भाव विवरणअ; अवतरण; भाव
みまい|mimai|見舞|enquiry; expression of sympathy; expression of concern|पूछताछ; वचन; पदसंहति; अभिव्यक्ति; वचन; पदसंहति; अभिव्यक्ति
けんめい|kenmei|賢明|wisdom; intelligence; prudence|ज्ञान; बुद्धिमत्ता; प्रज्ञा; सूचना; ज्ञान; गुप्त समाचार; समझदारी; सावधानी; बुद्धिमानी
つかい|tsukai|遣い|mission; simple task; doing|कार्य; लक्ष्य; मिशन; सरल; कार्यकलाप
げんそ|genso|元素|chemical element|रासायनिक पदार्थ; रसायनिक द्रव्य; रासायन संबंधी
はら|hara|原|original; primitive; primary; fundamental; raw|असली; प्रारंभिक; मूल; साधारण; आदिम; प्राचीन; मुख्य; मूल; प्रधान
げんけい|genkei|原形|original form; base form|असली; प्रारंभिक; मूल; आधार
げんてん|genten|原典|original (text)|असली; प्रारंभिक; मूल
げんゆ|genyu|原油|crude oil|कच्चा तेल
おごそか|ogosoka|厳か|austere; majestic; dignified; stately; awful; impressive|सख्त; सादा; संयमी; शानदार; तेजस्वी; राजसी; सम्मानित; गौरवशाली
げんてん|genten|減点|subtract; give a demerit|घटाना; देना
みなもと|minamoto|源|source; origin|सूत्र; जड़; स्रोत; मूल; आरम्भ; उद्गम
あらわれ|araware|現われ|embodiment; materialization|मूर्त रूप; मूर्त; मूर्त रूप
げんろん|genron|言論|discussion|चर्चा; बहस; आलोचनाआ
げんてい|gentei|限定|limit; restriction|मर्यादा; हद; सीमा; सीमा; रोक; प्रतिबन्ध
ここ|koko|個々|individual; one by one|विशिष्ट; व्यक्ति; अलग अलग; एक एक करके
こてい|kotei|固定|fixation|असाधारण आसक्ति; ग्रस्तता; यौगिकीकरण
こじ|koji|孤児|orphan|अनाथ करना; अनाथ; यतीम
こどく|kodoku|孤独|isolation; loneliness; solitude|सितारा मछली; एकांत; अलगाव; एकांत; अकेलापन; एकांत; विरानी; अकेलापन
こりつ|koritsu|孤立|isolation; helplessness|सितारा मछली; एकांत; अलगाव; असहायता; निराश्रयता; बेबसी
こ|ko|故|the late (deceased)|देर
また|mata|股|groin; crotch; thigh|कमर; जाँघ एवं धड़ के जोड़ का क्षेत्र; पदसन्धि; जंघा; रान; जाँघ
ごめんなさい|gomennasai|御免なさい|I beg your pardon; excuse me|माफ़ कीजिए; क्षमा; क्षमा करें
ごらんなさい|gorannasai|御覧なさい|(please) look; (please) try to do|देखना; कोशिश करना
ごさ|gosa|誤差|error|भूल; गलती; गलतियाँ
ごえい|goei|護衛|guard; convoy; escort|पहरेदार; बचाव; रक्षण करना; चौकसी से ले जाना; रक्षा दल; रक्षक दल; सहचर; मार्गरक्षण; मार्गरक्षण करना
こうりつ|kouritsu|効率|efficiency|दक्षता; कार्यक्षमता; चुस्ती
むき|muki|向き|direction; situation; exposure; aspect; suitability|दिशा; समस्या; दृश्य; स्थिति; प्रदर्शन; विवरण; दिशा
こうじょう|koujou|向上|elevation; rise; improvement; advancement; progress|ऊँचा स्थान; उन्नति; ऊँचाई; उदय होना; निकलना; चढना; सुधार; प्रगति; उन्नति
あか|aka|垢|dirt; filth|पखाना; मिट्टी; कचरा; गंदगी; अश्लीलता; मल
"""), "ja", "N4", "kanji"),

    )
}
