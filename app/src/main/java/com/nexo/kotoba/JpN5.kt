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
        
            どうして|doushite|何で|why / how come|क्यों
            どんな|donna|どんな|what kind of|कैसा
            どちら|dochira|どちら|which (of two)|कौन सा
            どっち|docchi|どっち|which one (casual)|कौन-सा
            どうやって|douyatte|どうやって|how (by what means)|कैसे
            どのくらい|donokurai|どのくらい|how much / how long|कितना
            なんじ|nanji|何時|what time|कितने बजे
            なんさい|nansai|何歳|how old|कितनी उम्र
            なんかい|nankai|何回|how many times|कितनी बार
            なんにん|nannin|何人|how many people|कितने लोग
            なんまい|nanmai|何枚|how many (flat things)|कितने (पन्ने / कागज़)
            なんさつ|nansatsu|何冊|how many (books)|कितनी किताबें
            なんばん|nanban|何番|what number|कौन-सा नंबर
            なんで|nande|何で|why|क्यों
            なぜなら|nazenara|何故なら|because|क्योंकि
            だから|dakara|だから|so / therefore|इसलिए
            でも|demo|でも|but|लेकिन
            そして|soshite|そして|and then|और फिर
            それから|sorekara|それから|after that|उसके बाद
            まず|mazu|先ず|first of all|सबसे पहले
            つぎに|tsugini|次に|next|फिर
            さいごに|saigoni|最後に|lastly|अंत में
            いつも|itsumo|何時も|always|हमेशा
            ときどき|tokidoki|時々|sometimes|कभी-कभी
            たぶん|tabun|多分|maybe|शायद
            もちろん|mochiron|勿論|of course|बिल्कुल
            だれか|dareka|誰か|someone|कोई
            なにか|nanika|何か|something|कुछ
            どこか|dokoka|何処か|somewhere|कहीं
            いつか|itsuka|何時か|someday|किसी दिन
            だれも|daremo|誰も|nobody|कोई नहीं
            なにも|nanimo|何も|nothing|कुछ नहीं
            どこから|dokokara|何処から|from where|कहाँ से
            どこまで|dokomade|何処まで|how far|कहाँ तक
            どのぐらい|donogurai|どの位|about how much|लगभग कितना
            どなた|donata|何方|who (polite)|कौन (विनम्र)
            いかが|ikaga|如何|how (polite)|कैसे (विनम्र)
            なぜか|nazeka|何故か|for some reason|किसी कारण से"""),
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
        
            きのう|kinou|昨日|yesterday|बीता कल
            おととい|ototoi|一昨日|the day before yesterday|परसों (बीता)
            あさって|asatte|明後日|the day after tomorrow|परसों (आने वाला)
            しゅうまつ|shuumatsu|週末|weekend|सप्ताहांत
            へいじつ|heijitsu|平日|weekday|कार्यदिवस
            きゅうじつ|kyuujitsu|休日|holiday / day off|छुट्टी का दिन
            まいにち|mainichi|毎日|every day|रोज़
            まいあさ|maiasa|毎朝|every morning|हर सुबह
            まいばん|maiban|毎晩|every night|हर रात
            まいしゅう|maishuu|毎週|every week|हर हफ़्ते
            こんしゅう|konshuu|今週|this week|इस हफ़्ते
            らいしゅう|raishuu|来週|next week|अगले हफ़्ते
            せんしゅう|senshuu|先週|last week|पिछले हफ़्ते
            こんげつ|kongetsu|今月|this month|इस महीने
            らいげつ|raigetsu|来月|next month|अगले महीने
            せんげつ|sengetsu|先月|last month|पिछले महीने
            こんねん|konnen|今年|this year|इस साल
            らいねん|rainen|来年|next year|अगले साल
            きょねん|kyonen|去年|last year|पिछले साल
            ひる|hiru|昼|noon / daytime|दोपहर
            ひるま|hiruma|昼間|daytime|दिन का समय
            よなか|yonaka|夜中|midnight|आधी रात
            ゆうがた|yuugata|夕方|evening|शाम
            こんや|konya|今夜|tonight|आज रात
            さくや|sakuya|昨夜|last night|बीती रात
            げつよう|getsuyou|月曜|Monday (short)|सोमवार
            かよう|kayou|火曜|Tuesday (short)|मंगलवार
            すいよう|suiyou|水曜|Wednesday (short)|बुधवार
            もくよう|mokuyou|木曜|Thursday (short)|गुरुवार
            きんよう|kinyou|金曜|Friday (short)|शुक्रवार
            どよう|doyou|土曜|Saturday (short)|शनिवार
            にちよう|nichiyou|日曜|Sunday (short)|रविवार
            たんじょうび|tanjoubi|誕生日|birthday|जन्मदिन
            こんしゅうのまつ|konshuu no matsu|今週の末|end of this week|इस हफ़्ते का अंत"""),
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
        
            しちがつ|shichigatsu|七月|July|जुलाई
            はちがつ|hachigatsu|八月|August|अगस्त
            くがつ|kugatsu|九月|September|सितंबर
            じゅうがつ|juugatsu|十月|October|अक्टूबर
            じゅういちがつ|juuichigatsu|十一月|November|नवंबर
            じゅうにがつ|juunigatsu|十二月|December|दिसंबर
            ついたち|tsuitachi|一日|1st of the month|पहली तारीख़
            ふつか|futsuka|二日|2nd of the month|दो तारीख़
            みっか|mikka|三日|3rd of the month|तीन तारीख़
            よっか|yokka|四日|4th of the month|चार तारीख़
            いつか|itsuka|五日|5th of the month|पाँच तारीख़
            むいか|muika|六日|6th of the month|छह तारीख़
            ようか|youka|八日|8th of the month|आठ तारीख़
            ここのか|kokonoka|九日|9th of the month|नौ तारीख़
            じゅうよっか|juuyokka|十四日|14th of the month|चौदह तारीख़
            はつか|hatsuka|二十日|20th of the month|बीस तारीख़
            にじゅうよっか|nijuu yokka|二十四日|24th of the month|चौबीस तारीख़
            さんじゅうにち|sanjuunichi|三十日|30th of the month|तीस तारीख़
            なんがつ|nangatsu|何月|what month|कौन-सा महीना
            ことし|kotoshi|今年|this year|इस साल
            まいつき|maitsuki|毎月|every month|हर महीना
            つき|tsuki|月|month|महीना
            ひ|hi|日|day / date|दिन / तारीख़
            たんじょうび|tanjoubi|誕生日|birthday|जन्मदिन
            きせつ|kisetsu|季節|season|मौसम
            まいとし|maitoshi|毎年|every year|हर साल
            げつまつ|getsumatsu|月末|end of the month|महीने का अंत
            しょじゅん|shojun|月初|beginning of the month|महीने की शुरुआत
            さらいねん|sarainen|再来年|the year after next|अगले-अगले साल
            さらいげつ|saraigetsu|再来月|the month after next|अगले-अगले महीने
            おととし|ototoshi|一昨年|the year before last|पिछले-पिछले साल"""),
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
        
            じゅうにじ|juuniji|十二時|twelve o'clock|बारह बजे
            いちじ|ichiji|一時|one o'clock|एक बजे
            さんじ|sanji|三時|three o'clock|तीन बजे
            ごじ|goji|五時|five o'clock|पाँच बजे
            しちじ|shichiji|七時|seven o'clock|सात बजे
            くじ|kuji|九時|nine o'clock|नौ बजे
            じゅうじ|juuji|十時|ten o'clock|दस बजे
            じゅっぷん|juppun|十分|ten minutes|दस मिनट
            さんじゅっぷん|san juppun|三十分|thirty minutes|तीस मिनट
            いちじかん|ichijikan|一時間|one hour|एक घंटा
            はんじかん|hanjikan|半時間|half an hour|आधा घंटा
            まえ|mae|前|before|पहले
            あと|ato|後|after|बाद में
            すぎ|sugi|過ぎ|past (the hour)|बजकर
            ころ|koro|頃|around (a time)|लगभग
            ちょうど|choudo|丁度|exactly|ठीक
            だいたい|daitai|大体|about / roughly|लगभग
            おそく|osoku|遅く|late|देर से
            はやく|hayaku|早く|early|जल्दी
            びょう|byou|秒|second|सेकंड
            いまなんじ|ima nanji|今何時|what time is it now|अभी कितने बजे हैं
            あさはやく|asahayaku|朝早く|early in the morning|सुबह जल्दी
            よなか|yonaka|夜中|middle of the night|आधी रात
            ひるやすみ|hiruyasumi|昼休み|lunch break|दोपहर का ब्रेक
            ごごさんじ|gogo sanji|午後三時|3 p.m.|दोपहर तीन बजे
            ごぜんくじ|gozen kuji|午前九時|9 a.m.|सुबह नौ बजे
            おひる|ohiru|お昼|noon|दोपहर
            まよなか|mayonaka|真夜中|midnight|गहरी रात
            じかんがありません|jikan ga arimasen|時間がありません|I have no time|मेरे पास समय नहीं है"""),
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
        
            ごにん|gonin|五人|five people|पाँच लोग
            むっつ|muttsu|六つ|six (things)|छह
            ななつ|nanatsu|七つ|seven (things)|सात
            やっつ|yattsu|八つ|eight (things)|आठ
            ここのつ|kokonotsu|九つ|nine (things)|नौ
            とお|too|十|ten (things)|दस
            いっこ|ikko|一個|one (small item)|एक (छोटी वस्तु)
            ふたこ|futako|二個|two (small items)|दो (वस्तुएँ)
            いっさつ|issatsu|一冊|one (book)|एक किताब
            にさつ|nisatsu|二冊|two (books)|दो किताबें
            いっぽん|ippon|一本|one (long object)|एक (लंबी वस्तु)
            にほん|nihon|二本|two (long objects)|दो (लंबी वस्तुएँ)
            さんぼん|sanbon|三本|three (long objects)|तीन (लंबी वस्तुएँ)
            いちまい|ichimai|一枚|one (flat object)|एक (चपटी वस्तु)
            にまい|nimai|二枚|two (flat objects)|दो (चपटी वस्तुएँ)
            いっぴき|ippiki|一匹|one (small animal)|एक (छोटा जानवर)
            にひき|nihiki|二匹|two (small animals)|दो (जानवर)
            さんびき|sanbiki|三匹|three (small animals)|तीन (जानवर)
            いちだい|ichidai|一台|one (machine / vehicle)|एक (मशीन / गाड़ी)
            にだい|nidai|二台|two (machines / vehicles)|दो (मशीनें / गाड़ियाँ)
            いっかい|ikkai|一回|once|एक बार
            にかい|nikai|二回|twice|दो बार
            なんかい|nankai|何回|how many times|कितनी बार
            いちにち|ichinichi|一日|one day|एक दिन
            しゅうかん|shuukan|週間|week (period)|सप्ताह
            ねんかん|nenkan|年間|year (period)|वर्ष"""),
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
        
            スーパー|suupaa|スーパー|supermarket|सुपरमार्केट
            デパート|depaato|デパート|department store|डिपार्टमेंट स्टोर
            コンビニ|konbini|コンビニ|convenience store|कन्वीनियंस स्टोर
            ホテル|hoteru|ホテル|hotel|होटल
            レストラン|resutoran|レストラン|restaurant|रेस्तराँ
            えいがかん|eigakan|映画館|movie theater|सिनेमाघर
            びじゅつかん|bijutsukan|美術館|art museum|कला संग्रहालय
            はくぶつかん|hakubutsukan|博物館|museum|संग्रहालय
            どうぶつえん|doubutsuen|動物園|zoo|चिड़ियाघर
            えきまえ|ekimae|駅前|in front of the station|स्टेशन के सामने
            くすりや|kusuriya|薬屋|pharmacy|दवा की दुकान
            けいさつしょ|keisatsusho|警察署|police station|पुलिस थाना
            しょうぼうしょ|shoubousho|消防署|fire station|अग्निशमन केंद्र
            だいがく|daigaku|大学|university|विश्वविद्यालय
            おてら|otera|お寺|Buddhist temple|बौद्ध मंदिर
            きょうかい|kyoukai|教会|church|चर्च
            とし|toshi|都市|city|शहर
            むら|mura|村|village|गाँव
            やおや|yaoya|八百屋|greengrocer|सब्ज़ी वाला
            さかなや|sakanaya|魚屋|fish shop|मछली की दुकान
            ほんや|honya|本屋|bookstore|किताब की दुकान
            パンや|panya|パン屋|bakery|बेकरी
            にくや|nikuya|肉屋|butcher shop|कसाई की दुकान
            かわ|kawa|川|river|नदी
            はし|hashi|橋|bridge|पुल
            みち|michi|道|road / street|सड़क
            どうろ|douro|道路|road|मार्ग
            まちなか|machinaka|町中|downtown|शहर के बीच
            きっさてん|kissaten|喫茶店|cafe|कैफ़े
            じむしょ|jimusho|事務所|office|कार्यालय
            こうじょう|koujou|工場|factory|कारख़ाना
            ちかてつ|chikatetsu|地下鉄|subway|मेट्रो
            バスてい|basutei|バス停|bus stop|बस स्टॉप"""),
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
        
            りょうしん|ryoushin|両親|parents|माता-पिता
            おじ|oji|伯父|uncle|चाचा
            おば|oba|伯母|aunt|चाची
            いとこ|itoko|従兄弟|cousin|चचेरा भाई / बहन
            まご|mago|孫|grandchild|पोता / पोती
            おっと|otto|夫|husband|पति
            つま|tsuma|妻|wife|पत्नी
            むすこ|musuko|息子|son|बेटा
            むすめ|musume|娘|daughter|बेटी
            しまい|shimai|姉妹|sisters|बहनें
            あかちゃん|akachan|赤ちゃん|baby|शिशु
            おとな|otona|大人|adult|वयस्क
            わかい|wakai|若い|young|जवान
            としより|toshiyori|年寄り|elderly person|बुज़ुर्ग
            かのじょ|kanojo|彼女|girlfriend / she|प्रेमिका
            かれし|kareshi|彼氏|boyfriend|प्रेमी
            なかま|nakama|仲間|companion / peer|साथी
            しんせき|shinseki|親戚|relative|रिश्तेदार
            となりのひと|tonari no hito|隣の人|neighbor|पड़ोसी
            おんなのひと|onna no hito|女の人|woman|महिला
            おとこのひと|otoko no hito|男の人|man|पुरुष
            かんごし|kangoshi|看護師|nurse|नर्स
            けいかん|keikan|警官|police officer|पुलिस अधिकारी
            うんてんしゅ|untenshu|運転手|driver|चालक
            のうか|nouka|農家|farmer|किसान
            しょうぼうし|shouboushi|消防士|firefighter|अग्निशमन कर्मी
            やきゅうせんしゅ|yakyuu senshu|野球選手|baseball player|बेसबॉल खिलाड़ी
            かしゅ|kashu|歌手|singer|गायक
            えいがかんとく|eiga kantoku|映画監督|film director|फ़िल्म निर्देशक
            しょうせつか|shousetsuka|小説家|novelist|उपन्यासकार"""),
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
        
            ねる|neru|寝る|to sleep|सोना
            はしる|hashiru|走る|to run|दौड़ना
            とぶ|tobu|飛ぶ|to fly|उड़ना
            のる|noru|乗る|to ride|सवारी करना
            おりる|oriru|降りる|to get off|उतरना
            のりかえる|norikaeru|乗り換える|to transfer|बदलना
            まつ|matsu|待つ|to wait|इंतज़ार करना
            おしえる|oshieru|教える|to teach|सिखाना
            つくる|tsukuru|作る|to make|बनाना
            なおす|naosu|直す|to fix / repair|ठीक करना
            そうじする|souji suru|掃除する|to clean|सफ़ाई करना
            せんたくする|sentaku suru|洗濯する|to do laundry|कपड़े धोना
            りょうりする|ryouri suru|料理する|to cook|खाना बनाना
            うる|uru|売る|to sell|बेचना
            もつ|motsu|持つ|to hold / carry|पकड़ना
            おくる|okuru|送る|to send|भेजना
            もらう|morau|貰う|to receive|पाना
            あげる|ageru|上げる|to give|देना
            とる|toru|取る|to take|लेना
            あける|akeru|開ける|to open|खोलना
            しめる|shimeru|閉める|to close|बंद करना
            つける|tsukeru|付ける|to turn on|चालू करना
            けす|kesu|消す|to turn off|बंद करना
            でる|deru|出る|to leave / go out|निकलना
            はいる|hairu|入る|to enter|घुसना
            ならぶ|narabu|並ぶ|to line up|कतार में लगना
            はこぶ|hakobu|運ぶ|to carry|ढोना
            さがす|sagasu|探す|to look for|ढूँढ़ना
            きめる|kimeru|決める|to decide|तय करना"""),
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
        
            にく|niku|肉|meat|मांस
            さかな|sakana|魚|fish|मछली
            ぎゅうにゅう|gyuunyuu|牛乳|milk|दूध
            パン|pan|パン|bread|रोटी
            ごはん|gohan|ご飯|rice / meal|चावल / भोजन
            みそしる|misoshiru|味噌汁|miso soup|मिसो सूप
            すし|sushi|寿司|sushi|सुशी
            ラーメン|raamen|ラーメン|ramen|रामेन
            うどん|udon|饂飩|udon noodles|उडोन नूडल्स
            そば|soba|蕎麦|soba noodles|सोबा नूडल्स
            カレー|karee|カレー|curry|करी
            ハンバーガー|hanbaagaa|ハンバーガー|hamburger|हैमबर्गर
            ピザ|piza|ピザ|pizza|पिज़्ज़ा
            ケーキ|keeki|ケーキ|cake|केक
            アイスクリーム|aisukuriimu|アイスクリーム|ice cream|आइसक्रीम
            おかし|okashi|お菓子|sweets / snack|मिठाई
            おなかがすく|onaka ga suku|お腹がすく|to be hungry|भूख लगना
            のどがかわく|nodo ga kawaku|喉が渇く|to be thirsty|प्यास लगना
            いただきます|itadakimasu|頂きます|let's eat (before a meal)|खाने से पहले कहा जाने वाला शब्द
            ごちそうさま|gochisousama|ご馳走様|thanks for the meal|भोजन के लिए धन्यवाद
            ちゃわん|chawan|茶碗|rice bowl|कटोरा
            おさら|osara|お皿|plate|थाली
            コップ|koppu|コップ|glass / cup|गिलास
            はし|hashi|箸|chopsticks|चॉपस्टिक
            スプーン|supuun|スプーン|spoon|चम्मच
            ナイフ|naifu|ナイフ|knife|चाकू
            フォーク|fooku|フォーク|fork|काँटा
            みず|mizu|水|water|पानी
            ジュース|juusu|ジュース|juice|जूस
            ビール|biiru|ビール|beer|बीयर
            おさけ|osake|お酒|alcohol / sake|शराब"""),
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
        
            きおん|kion|気温|temperature|तापमान
            あめ|ame|雨|rain|बारिश
            ゆき|yuki|雪|snow|बर्फ़
            かぜ|kaze|風|wind|हवा
            あらし|arashi|嵐|storm|तूफ़ान
            たいふう|taifuu|台風|typhoon|आँधी तूफ़ान
            かみなり|kaminari|雷|thunder / lightning|बिजली
            にじ|niji|虹|rainbow|इंद्रधनुष
            つゆ|tsuyu|梅雨|rainy season|बरसात का मौसम
            きり|kiri|霧|fog|कोहरा
            ひょう|hyou|雹|hail|ओले
            こおり|koori|氷|ice|जमी हुई बर्फ़
            たいよう|taiyou|太陽|sun|सूरज
            つき|tsuki|月|moon|चाँद
            ほし|hoshi|星|star|तारा
            そら|sora|空|sky|आसमान
            くも|kumo|雲|cloud|बादल
            あたたかい|atatakai|暖かい|warm|गर्म
            すずしい|suzushii|涼しい|cool (weather)|ठंडा
            むしあつい|mushiatsui|蒸し暑い|humid|उमस भरा
            かわく|kawaku|乾く|to dry|सूखना
            ぬれる|nureru|濡れる|to get wet|भीगना
            ふる|furu|降る|to fall (rain / snow)|गिरना (बारिश / बर्फ़)
            てんきよほう|tenki yohou|天気予報|weather forecast|मौसम का पूर्वानुमान
            そと|soto|外|outside|बाहर
            そらがはれている|sora ga hareteiru|空が晴れている|the sky is clear|आसमान साफ़ है"""),
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
        
            ながい|nagai|長い|long|लंबा
            みじかい|mijikai|短い|short|छोटा
            ひくい|hikui|低い|low|नीचा
            ひろい|hiroi|広い|wide / spacious|चौड़ा
            せまい|semai|狭い|narrow / small|तंग
            おもい|omoi|重い|heavy|भारी
            かるい|karui|軽い|light|हल्का
            はやい|hayai|fast / early|तेज़
            おそい|osoi|slow / late|धीमा
            おおい|ooi|多い|many / a lot|बहुत
            すくない|sukunai|少ない|few / little|कम
            やさしい|yasashii|優しい|kind / gentle|दयालु
            うつくしい|utsukushii|美しい|beautiful|सुंदर
            きたない|kitanai|汚い|dirty|गंदा
            きれい|kirei|綺麗|clean / pretty|साफ़
            しずか|shizuka|静か|quiet|शांत
            にぎやか|nigiyaka|賑やか|lively / busy|चहल-पहल वाला
            ゆうめい|yuumei|有名|famous|प्रसिद्ध
            じょうず|jouzu|上手|skilled at|निपुण
            へた|heta|下手|unskilled at|अनाड़ी
            だいじょうぶ|daijoubu|大丈夫|okay / fine|ठीक है
            たいせつ|taisetsu|大切|important|महत्वपूर्ण
            ひつよう|hitsuyou|必要|necessary|ज़रूरी
            じゆう|jiyuu|自由|free (not busy)|स्वतंत्र
            いそがしい|isogashii|忙しい|busy|व्यस्त
            げんき|genki|元気|healthy / energetic|तंदुरुस्त
            ねむい|nemui|眠い|sleepy|नींद में
            さびしい|sabishii|寂しい|lonely|अकेला
            うれしい|ureshii|嬉しい|happy|खुश
            かなしい|kanashii|悲しい|sad|उदास
            おもしろい|omoshiroi|面白い|interesting|दिलचस्प
            つまらない|tsumaranai|つまらない|boring|उबाऊ"""),
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
        
            じゅうさん|juusan|十三|thirteen|तेरह
            じゅうよん|juuyon|十四|fourteen|चौदह
            じゅうご|juugo|十五|fifteen|पंद्रह
            じゅうろく|juuroku|十六|sixteen|सोलह
            じゅうなな|juunana|十七|seventeen|सत्रह
            じゅうはち|juuhachi|十八|eighteen|अठारह
            じゅうきゅう|juukyuu|十九|nineteen|उन्नीस
            ろくじゅう|rokujuu|六十|sixty|साठ
            ななじゅう|nanajuu|七十|seventy|सत्तर
            はちじゅう|hachijuu|八十|eighty|अस्सी
            きゅうじゅう|kyuujuu|九十|ninety|नब्बे
            にひゃく|nihyaku|二百|two hundred|दो सौ
            さんびゃく|sanbyaku|三百|three hundred|तीन सौ
            よんひゃく|yonhyaku|四百|four hundred|चार सौ
            ごひゃく|gohyaku|五百|five hundred|पाँच सौ
            ろっぴゃく|roppyaku|六百|six hundred|छह सौ
            ななひゃく|nanahyaku|七百|seven hundred|सात सौ
            はっぴゃく|happyaku|八百|eight hundred|आठ सौ
            きゅうひゃく|kyuuhyaku|九百|nine hundred|नौ सौ
            おく|oku|億|hundred million|दस करोड़
            いちまん|ichiman|一万|ten thousand|दस हज़ार
            いちおく|ichioku|一億|hundred million|दस करोड़
            すうじ|suuji|数字|number / digit|अंक
            かず|kazu|数|number / count|संख्या
            いくつ|ikutsu|幾つ|how many|कितने
            さんばん|sanban|三番|number three|नंबर तीन
            ばんごう|bangou|番号|number (serial)|नंबर""")
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
