package com.nexo.kotoba

object EnglishGrammar {

    private fun eg(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "en", ruleEn, "", gex(raw), ruleHi, level, "english")

    private fun gex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("||")
            val d = c.getOrElse(1) { "" }.split("|")
            PatternExample("💤", c[0], d.getOrElse(0) { "" }, d.getOrElse(0) { "" }, d.getOrElse(1) { "" })
        }.toList()

    val patterns: List<Pattern> = listOf(
        eg("eg1", "am / is / are — the verb 'to be'", "be動詞（現在）", "A1",
            "USAGE: We use am, is and are to say what something is, how it is, or where it is. This is the most important verb in English — every beginner needs it first.\nWHEN: Use it in the present to describe people, things, feelings, jobs and places: I am a student, She is tired, The book is on the table.\nFORM: I + am | He/She/It + is | You/We/They + are. Negative: am not, isn't, aren't. Question: put the verb first — Am I? Is he? Are you?\nTIP: 'am' is ONLY used with 'I'. Never say 'I is' or 'I are' — always 'I am'.",
            "उपयोग: am/is/are का प्रयोग बताने के लिए करते हैं कि कोई चीज़ क्या है, कैसी है या कहाँ है। यह अंग्रेज़ी की सबसे महत्वपूर्ण क्रिया है।\nकब: वर्तमान में लोगों, चीज़ों, भावनाओं, नौकरियों और स्थानों का वर्णन करने के लिए।\nरूप: I + am | He/She/It + is | You/We/They + are। नकारात्मक: am not, isn't, aren't। प्रश्न: क्रिया को पहले रखें — Am I? Is he? Are you?\nटिप: 'am' केवल 'I' के साथ आता है। 'I is' या 'I are' कभी न कहें।",
            """I am a teacher.||私は教師です。|मैं शिक्षक हूँ।
I am very happy today.||今日はとても幸せです。|आज मैं बहुत खुश हूँ।
I am from India.||私はインド出身です。|मैं भारत से हूँ।
I am tired after work.||仕事の後は疲れます。|काम के बाद मैं थक जाता हूँ।
I am not angry with you.||私はあなたに怒っていません。|मैं तुम पर गुस्सा नहीं हूँ।
Am I late for the meeting?||会議に遅れましたか。|क्या मैं मीटिंग के लिए देर से आया हूँ?
You are my best friend.||あなたは私の親友です。|तुम मेरे सबसे अच्छे दोस्त हो।
You are so kind to me.||あなたは私にとても親切です。|तुम मुझ पर बहुत दयालु हो।
Are you ready to go?||行く準備はできましたか。|क्या तुम जाने के लिए तैयार हो?
Are you from Japan?||日本出身ですか。|क्या तुम जापान से हो?
You are not wrong.||あなたは間違っていません。|तुम गलत नहीं हो।
He is my brother.||彼は私の兄です。|वह मेरा भाई है।
She is a doctor.||彼女は医者です。|वह एक डॉक्टर है।
He is very tall.||彼はとても背が高いです。|वह बहुत लंबा है।
She is not at home.||彼女は家にいません。|वह घर पर नहीं है।
Is he your father?||彼はあなたの父ですか。|क्या वह तुम्हारे पिता हैं?
Is she a student?||彼女は学生ですか。|क्या वह एक छात्रा है?
It is a beautiful day.||今日はいい天気です。|आज बहुत सुंदर दिन है।
It is cold outside.||外は寒いです。|बाहर ठंड है।
It is not expensive.||それは高くないです。|वह महँगा नहीं है।
We are good friends.||私たちは仲の良い友達です。|हम अच्छे दोस्त हैं।
We are from the same city.||私たちは同じ町の出身です。|हम एक ही शहर से हैं।
We are not late.||私たちは遅れていません。|हम देर से नहीं हैं।
Are we on time?||時間どおりですか。|क्या हम समय पर हैं?
They are my colleagues.||彼らは私の同僚です।|वे मेरे सहकर्मी हैं।
They are very smart.||彼らはとても賢いです।|वे बहुत समझदार हैं।
They are not here yet.||彼らはまだ来ていません।|वे अभी तक यहाँ नहीं हैं।
Are they coming today?||彼らは今日来ますか。|क्या वे आज आ रहे हैं?
This is my phone.||これは私の携帯です।|यह मेरा फोन है।
That is your bag.||それはあなたのかばんです।|वह तुम्हारा बैग है।"""),
        eg("eg2", "have / has — possession", "have/has（所有）", "A1",
            "USAGE: We use have and has to say that someone owns something or has something with them.\nWHEN: Use it for possessions (I have a car), family (She has two sisters), body parts (He has blue eyes), feelings (I have a headache) and things you do (We have breakfast).\nFORM: I/You/We/They + have | He/She/It + has. Negative: don't have / doesn't have. Question: Do you have...? / Does she have...?\nTIP: After 'doesn't have' the verb goes back to 'have', never 'has' — 'She doesn't has' is WRONG.",
            "उपयोग: have/has का प्रयोग यह बताने के लिए होता है कि किसी के पास कुछ है।\nकब: संपत्ति, परिवार, शरीर के अंग, भावनाएँ और दैनिक क्रियाएँ।\nरूप: I/You/We/They + have | He/She/It + has। नकारात्मक: don't have / doesn't have। प्रश्न: Do you have...? / Does she have...?\nटिप: 'doesn't' के बाद हमेशा 'have' आता है — 'She doesn't has' गलत है।",
            """I have a car.||私は車を持っています。|मेरे पास एक कार है।
I have two brothers.||私には兄が二人います。|मेरे दो भाई हैं।
I have a headache.||頭が痛いです।|मुझे सिरदर्द है।
I have breakfast at eight.||八時に朝食を食べます।|मैं आठ बजे नाश्ता करता हूँ।
I don't have a phone.||私は携帯を持っていません。|मेरे पास फोन नहीं है।
Do you have a pen?||ペンを持っていますか。|क्या तुम्हारे पास कलम है?
You have a nice smile.||あなたは素敵な笑顔をしています।|तुम्हारी मुस्कान बहुत अच्छी है।
You have my keys.||あなたは私の鍵を持っています।|तुम्हारे पास मेरी चाबियाँ हैं।
Do you have any questions?||質問はありますか।|क्या आपके कोई प्रश्न हैं?
He has a new job.||彼は新しい仕事に就きました।|उसकी नई नौकरी है।
She has long hair.||彼女は長い髪です।|उसके लंबे बाल हैं।
He has a red car.||彼は赤い車を持っています।|उसके पास लाल कार है।
She has three children.||彼女には子供が三人います。|उसके तीन बच्चे हैं।
He doesn't have time.||彼には時間がありません।|उसके पास समय नहीं है।
Does she have a sister?||彼女に妹はいますか。|क्या उसकी बहन है?
Does he have my number?||彼は私の番号を知っていますか।|क्या उसके पास मेरा नंबर है?
It has a big window.||それには大きな窓があります।|उसमें बड़ी खिड़की है।
The dog has four legs.||犬には足が四本あります।|कुत्ते के चार पैर होते हैं।
We have a big house.||私たちは大きな家に住んでいます।|हमारा एक बड़ा घर है।
We have a meeting today.||今日は会議があります।|आज हमारी मीटिंग है।
We don't have sugar.||砂糖がありません。|हमारे पास चीनी नहीं है।
Do we have enough money?||お金は足りますか।|क्या हमारे पास पर्याप्त पैसे हैं?
They have a lovely garden.||彼らには素敵な庭があります।|उनका एक सुंदर बगीचा है।
They have two dogs.||彼らは犬を二匹飼っています।|उनके पास दो कुत्ते हैं।
They don't have a car.||彼らは車を持っていません।|उनके पास कार नहीं है।
I have an idea.||いい考えがあります।|मेरे पास एक विचार है।
She has a good job.||彼女は良い仕事をしています।|उसकी अच्छी नौकरी है।
He has a fever today.||彼は今日熱があります।|आज उसे बुखार है।
Do you have a lighter?||ライターを持っていますか।|क्या तुम्हारे पास लाइटर है?
We have no time to lose.||失う時間はありません।|हमारे पास खोने के लिए समय नहीं है।"""),
        eg("eg3", "present simple — habits & facts", "現在形（習慣・事実）", "A1",
            "USAGE: We use the present simple for habits, routines, and things that are always true.\nWHEN: Use it for daily routines (I wake up at six), facts (Water boils at 100°C), and general truths (Cats like milk).\nFORM: I/You/We/They + base verb. He/She/It + verb-s (works, eats). Negative: don't / doesn't + verb. Question: Do/Does + subject + verb.\nTIP: With he/she/it the verb always takes -s: He workS, She eatS. Don't forget the -s!",
            "उपयोग: present simple का प्रयोग आदतों, दिनचर्या और हमेशा सत्य रहने वाली बातों के लिए होता है।\nकब: दैनिक दिनचर्या, तथ्य और सामान्य सत्य।\nरूप: I/You/We/They + मूल क्रिया। He/She/It + क्रिया-s। नकारात्मक: don't / doesn't + क्रिया। प्रश्न: Do/Does + कर्ता + क्रिया।\nटिप: he/she/it के साथ क्रिया में हमेशा -s जोड़ें: He works, She eats।",
            """I wake up at six every day.||毎日六時に起きます。|मैं रोज़ छह बजे उठता हूँ।
I drink tea in the morning.||朝はお茶を飲みます।|मैं सुबह चाय पीता हूँ।
I go to work by bus.||バスで仕事に行きます।|मैं बस से काम पर जाता हूँ।
I don't eat meat.||私は肉を食べません।|मैं मांस नहीं खाता।
You speak English very well.||あなたは英語がとても上手です।|तुम बहुत अच्छी अंग्रेज़ी बोलते हो।
You play the guitar?||ギターを弾きますか।|क्या तुम गिटार बजाते हो?
He works in a bank.||彼は銀行で働いています।|वह बैंक में काम करता है।
She teaches at a school.||彼女は学校で教えています।|वह स्कूल में पढ़ाती है।
He plays football on Sundays.||彼は日曜日にサッカーをします।|वह रविवार को फुटबॉल खेलता है।
She lives in Mumbai.||彼女はムンバイに住んでいます।|वह मुंबई में रहती है।
He doesn't like coffee.||彼はコーヒーが好きではありません।|उसे कॉफ़ी पसंद नहीं है।
She doesn't work on Fridays.||彼女は金曜日は働きません।|वह शुक्रवार को काम नहीं करती।
Does he speak Hindi?||彼はヒンディー語を話しますか।|क्या वह हिंदी बोलता है?
Does she like pizza?||彼女はピザが好きですか।|क्या उसे पिज़्ज़ा पसंद है?
The sun rises in the east.||太陽は東から昇ります।|सूरज पूर्व में उगता है।
Water boils at 100 degrees.||水は百度で沸騰します।|पानी सौ डिग्री पर उबलता है।
Cats like milk.||猫は牛乳が好きです।|बिल्लियों को दूध पसंद है।
My father works in a hospital.||父は病院で働いています।|मेरे पिता अस्पताल में काम करते हैं।
We eat dinner at eight.||私たちは八時に夕食を食べます।|हम आठ बजे रात का खाना खाते हैं।
We live in a small town.||私たちは小さな町に住んでいます।|हम एक छोटे शहर में रहते हैं।
We don't watch TV much.||私たちはあまりテレビを見ません।|हम ज़्यादा टीवी नहीं देखते।
Do we have class today?||今日は授業がありますか।|क्या आज हमारी कक्षा है?
They study every night.||彼らは毎晩勉強します।|वे हर रात पढ़ाई करते हैं।
They visit us on holidays.||彼らは休日に私たちを訪ねます।|वे छुट्टियों में हमसे मिलने आते हैं।
They don't understand the question.||彼らは質問がわかりません।|वे प्रश्न नहीं समझते।
The shop opens at nine.||店は九時に開きます।|दुकान नौ बजे खुलती है।
The train leaves at noon.||電車は正午に出発します।|ट्रेन दोपहर में चलती है।
I love this song.||この歌が大好きです।|मुझे यह गाना बहुत पसंद है।
She always smiles at me.||彼女はいつも私に微笑みます।|वह हमेशा मुझ पर मुस्कुराती है।
He never eats breakfast.||彼は朝食を食べません。|वह कभी नाश्ता नहीं करता।"""),
        eg("eg4", "present continuous — actions now", "現在進行形", "A1",
            "USAGE: We use the present continuous for things happening right now, at this moment.\nWHEN: Use it for actions in progress (I am cooking), temporary situations (She is staying with us), and near-future plans (We are leaving tomorrow).\nFORM: am/is/are + verb-ing. Negative: am not / isn't / aren't + verb-ing. Question: Am/Is/Are + subject + verb-ing.\nTIP: Some verbs are never used in this form: like, want, know, believe, need. Say 'I like it', not 'I am liking it'.",
            "उपयोग: present continuous का प्रयोग इस समय चल रही क्रियाओं के लिए होता है।\nकब: अभी चल रही क्रिया, अस्थायी स्थिति और निकट भविष्य की योजना।\nरूप: am/is/are + क्रिया-ing। नकारात्मक: am not / isn't / aren't + क्रिया-ing। प्रश्न: Am/Is/Are + कर्ता + क्रिया-ing।\nटिप: like, want, know, believe, need जैसी क्रियाओं के साथ यह रूप नहीं आता।",
            """I am working right now.||今働いています।|मैं अभी काम कर रहा हूँ।
I am drinking coffee.||コーヒーを飲んでいます।|मैं कॉफ़ी पी रहा हूँ।
I am not listening to you.||あなたの話を聞いていません।|मैं तुम्हारी बात नहीं सुन रहा।
Are you coming with us?||一緒に来ますか।|क्या तुम हमारे साथ आ रहे हो?
You are working very hard.||あなたはとても頑張っています।|तुम बहुत मेहनत कर रहे हो।
What are you doing now?||今何をしていますか।|अभी तुम क्या कर रहे हो?
He is sleeping in his room.||彼は自分の部屋で寝ています।|वह अपने कमरे में सो रहा है।
She is cooking dinner.||彼女は夕食を作っています।|वह रात का खाना बना रही है।
He is not studying today.||彼は今日勉強していません।|वह आज पढ़ाई नहीं कर रहा।
Is she watching TV?||彼女はテレビを見ていますか।|क्या वह टीवी देख रही है?
Look! It is raining outside.||見て！外は雨が降っています。|देखो! बाहर बारिश हो रही है।
It is getting dark.||暗くなってきています।|अंधेरा हो रहा है।
We are eating lunch now.||今昼食を食べています。|हम अभी दोपहर का खाना खा रहे हैं।
We are staying at a hotel.||私たちはホテルに泊まっています।|हम होटल में रुके हुए हैं।
We are not going out tonight.||今夜は出かけません。|हम आज रात बाहर नहीं जा रहे।
Are we meeting at five?||五時に会いますか।|क्या हम पाँच बजे मिल रहे हैं?
They are playing in the garden.||彼らは庭で遊んでいます।|वे बगीचे में खेल रहे हैं।
They are coming to the party.||彼らはパーティーに来ています।|वे पार्टी में आ रहे हैं।
They are not sleeping.||彼らは寝ていません।|वे सो नहीं रहे हैं।
Why are you crying?||なぜ泣いているのですか।|तुम क्यों रो रहे हो?
I am learning English.||私は英語を勉強しています।|मैं अंग्रेज़ी सीख रहा हूँ।
She is wearing a red dress.||彼女は赤いドレスを着ています।|उसने लाल ड्रेस पहनी है।
The baby is crying.||赤ちゃんが泣いています।|बच्चा रो रहा है।
The phone is ringing.||電話が鳴っています।|फ़ोन बज रहा है।
I am feeling better now.||今は気分が良くなっています।|अब मैं बेहतर महसूस कर रहा हूँ।
He is talking on the phone.||彼は電話で話しています।|वह फ़ोन पर बात कर रहा है।
She is writing a letter.||彼女は手紙を書いています।|वह पत्र लिख रही है।
We are flying to Delhi tomorrow.||明日デリーに飛びます।|हम कल दिल्ली उड़ान भर रहे हैं।
The children are doing homework.||子供たちは宿題をしています।|बच्चे होमवर्क कर रहे हैं।
I am going to the market now.||今市場に行っています。|मैं अभी बाज़ार जा रहा हूँ।"""),
        eg("eg5", "do / does / did — the helper verb", "do/does/did（助動詞）", "A1",
            "USAGE: We use do, does and did to make questions and negatives when there is no other helping verb.\nWHEN: do + I/you/we/they, does + he/she/it (present), did + everyone (past). Use them for questions (Do you like tea?), negatives (I don't know) and short answers (Yes, I do).\nFORM: Do/Does/Did + subject + base verb. Negative: don't, doesn't, didn't + base verb.\nTIP: After do/does/did the main verb goes back to its base form — never 'She does likes'. Say 'She does like'.",
            "उपयोग: do/does/did का प्रयोग प्रश्न और नकारात्मक वाक्य बनाने के लिए होता है जब कोई अन्य सहायक क्रिया न हो।\nकब: do + I/you/we/they, does + he/she/it, did + सभी (भूतकाल)।\nरूप: Do/Does/Did + कर्ता + मूल क्रिया। नकारात्मक: don't, doesn't, didn't + मूल क्रिया।\nटिप: do/does/did के बाद मुख्य क्रिया हमेशा मूल रूप में आती है।",
            """Do you like tea?||お茶は好きですか。|क्या तुम्हें चाय पसंद है?
Do they live here?||彼らはここに住んでいますか।|क्या वे यहाँ रहते हैं?
Do we need more chairs?||椅子はもっと必要ですか।|क्या हमें और कुर्सियाँ चाहिए?
I don't understand.||わかりません。|मुझे समझ नहीं आया।
I don't like cold weather.||寒い天気は好きではありません।|मुझे ठंडा मौसम पसंद नहीं है।
You don't know the answer.||あなたは答えを知りません।|तुम्हें जवाब नहीं पता।
Does he work here?||彼はここで働いていますか।|क्या वह यहाँ काम करता है?
Does she speak French?||彼女はフランス語を話しますか।|क्या वह फ्रेंच बोलती है?
Does your father drive?||お父さんは運転しますか।|क्या तुम्हारे पिता गाड़ी चलाते हैं?
She doesn't eat fish.||彼女は魚を食べません।|वह मछली नहीं खाती।
He doesn't smoke.||彼はタバコを吸いません।|वह धूम्रपान नहीं करता।
It doesn't matter.||それは重要ではありません।|कोई बात नहीं।
Did you call me?||私に電話しましたか।|क्या तुमने मुझे फ़ोन किया?
Did they come yesterday?||彼らは昨日来ましたか।|क्या वे कल आए थे?
Did she finish her work?||彼女は仕事を終えましたか।|क्या उसने अपना काम खत्म किया?
I didn't see him.||彼に会いませんでした।|मैंने उसे नहीं देखा।
We didn't go to the party.||私たちはパーティーに行きませんでした।|हम पार्टी में नहीं गए।
He didn't say anything.||彼は何も言いませんでした।|उसने कुछ नहीं कहा।
Did you enjoy the movie?||映画は楽しめましたか।|क्या तुम्हें फ़िल्म अच्छी लगी?
Where do you work?||どこで働いていますか।|तुम कहाँ काम करते हो?
What does she do?||彼女は何をしていますか।|वह क्या करती है?
When did he leave?||彼はいつ出発しましたか।|वह कब गया?
Why don't you try again?||もう一度試してみませんか।|तुम दोबारा कोशिश क्यों नहीं करते?
Yes, I do like it.||はい、好きです。|हाँ, मुझे यह पसंद है।
No, she doesn't.||いいえ、彼女はしません।|नहीं, वह नहीं करती।
Did you have breakfast?||朝食を食べましたか।|क्या तुमने नाश्ता किया?
I did my homework last night.||昨夜宿題をしました।|मैंने कल रात होमवर्क किया।
Do you smoke?||タバコを吸いますか।|क्या तुम धूम्रपान करते हो?
She doesn't like loud music.||彼女は大音量の音楽が好きではありません।|उसे तेज़ संगीत पसंद नहीं है।
Don't worry about it.||心配しないでください।|इसकी चिंता मत करो।"""),
        eg("eg6", "past simple — finished actions", "過去形", "A1",
            "USAGE: We use the past simple for actions that started and finished in the past.\nWHEN: Use it with past time words: yesterday, last week, two years ago, in 2020.\nFORM: Regular verbs add -ed (worked, played). Irregular verbs change completely (go → went, see → saw, eat → ate). Negative: didn't + base verb. Question: Did + subject + base verb.\nTIP: With 'didn't' or 'Did...?' the verb returns to its base form — 'I didn't went' is WRONG.",
            "उपयोग: past simple का प्रयोग उन क्रियाओं के लिए होता है जो अतीत में शुरू और समाप्त हो गईं।\nकब: yesterday, last week, two years ago, in 2020 जैसे भूतकालीन समय शब्दों के साथ।\nरूप: नियमित क्रियाएँ + -ed; अनियमित क्रियाएँ बदल जाती हैं। नकारात्मक: didn't + मूल क्रिया। प्रश्न: Did + कर्ता + मूल क्रिया।\nटिप: 'didn't' के बाद क्रिया मूल रूप में आती है।",
            """I worked late yesterday.||昨日は遅くまで働きました।|मैंने कल देर तक काम किया।
I watched a movie last night.||昨夜映画を見ました।|मैंने कल रात फ़िल्म देखी।
I went to Delhi last month.||先月デリーに行きました।|मैं पिछले महीने दिल्ली गया।
I saw her at the station.||駅で彼女を見ました।|मैंने उसे स्टेशन पर देखा।
I didn't sleep well.||よく眠れませんでした।|मुझे अच्छी नींद नहीं आई।
Did you enjoy the trip?||旅行は楽しかったですか।|क्या तुम्हें यात्रा अच्छी लगी?
You came very early.||あなたはとても早く来ました।|तुम बहुत जल्दी आए।
He ate all the food.||彼は食べ物を全部食べました।|उसने सारा खाना खा लिया।
She bought a new phone.||彼女は新しい携帯を買いました।|उसने नया फ़ोन खरीदा।
He drove to work this morning.||彼は今朝車で出勤しました।|वह आज सुबह गाड़ी से काम गया।
She wrote a long email.||彼女は長いメールを書きました।|उसने लंबा ईमेल लिखा।
He didn't call me back.||彼は折り返し電話しませんでした।|उसने मुझे वापस फ़ोन नहीं किया।
Did she pass the exam?||彼女は試験に合格しましたか।|क्या वह परीक्षा में पास हुई?
We visited our grandparents.||私たちは祖父母を訪ねました।|हमने अपने दादा-दादी से मुलाकात की।
We had a great time.||とても楽しい時間を過ごしました।|हमने बहुत मज़ा किया।
We didn't find the place.||場所が見つかりませんでした।|हमें जगह नहीं मिली।
Did we miss the bus?||バスに乗り遅れましたか।|क्या हम बस से चूक गए?
They arrived at eight.||彼らは八時に到着しました।|वे आठ बजे पहुँचे।
They played football all day.||彼らは一日中サッカーをしました।|उन्होंने पूरे दिन फुटबॉल खेला।
They didn't know the way.||彼らは道を知りませんでした।|वे रास्ता नहीं जानते थे।
What did you do last weekend?||先週末は何をしましたか।|तुमने पिछले सप्ताहांत क्या किया?
Where did he go?||彼はどこへ行きましたか।|वह कहाँ गया?
When did the show start?||ショーはいつ始まりましたか।|शो कब शुरू हुआ?
Why did you leave early?||なぜ早く帰りましたか।|तुम जल्दी क्यों चले गए?
I forgot my keys at home.||鍵を家に忘れました।|मैं अपनी चाबियाँ घर भूल गया।
She made a delicious cake.||彼女はおいしいケーキを作りました।|उसने स्वादिष्ट केक बनाया।
He took a taxi to the airport.||彼はタクシーで空港へ行きました।|वह टैक्सी से हवाई अड्डा गया।
We spoke to the manager.||私たちはマネージャーと話しました।|हमने मैनेजर से बात की।
The bus was late again.||バスはまた遅れました।|बस फिर देर से आई।
I read that book last year.||去年その本を読みました।|मैंने वह किताब पिछले साल पढ़ी।"""),
        eg("eg7", "past continuous — actions in the past", "過去進行形", "A2",
            "USAGE: We use the past continuous for an action that was happening at a specific moment in the past.\nWHEN: Use it to set the scene (It was raining), for a longer action interrupted by another (I was sleeping when you called), and for two actions happening together (She was cooking while he was reading).\nFORM: was/were + verb-ing. I/he/she/it + was | you/we/they + were. Negative: wasn't / weren't + verb-ing.\nTIP: Use past continuous for the longer background action and past simple for the short action that interrupts: 'I was eating when the phone rang'.",
            "उपयोग: past continuous का प्रयोग अतीत के किसी क्षण में चल रही क्रिया के लिए होता है।\nकब: दृश्य सेट करने, लंबी क्रिया में रुकावट, और दो समानांतर क्रियाओं के लिए।\nरूप: was/were + क्रिया-ing। नकारात्मक: wasn't / weren't + क्रिया-ing।\nटिप: लंबी पृष्ठभूमि क्रिया के लिए past continuous, छोटी रुकावट के लिए past simple।",
            """I was sleeping when you called.||あなたが電話したとき、私は寝ていました।|जब तुमने फ़ोन किया मैं सो रहा था।
I was watching TV at nine.||九時にテレビを見ていました।|मैं नौ बजे टीवी देख रहा था।
I was driving to work.||車で出勤していました।|मैं काम के लिए गाड़ी चला रहा था।
I wasn't listening carefully.||真剣に聞いていませんでした।|मैं ध्यान से नहीं सुन रहा था।
What were you doing at midnight?||真夜中に何をしていましたか।|आधी रात को तुम क्या कर रहे थे?
You were talking too fast.||あなたは話すのが速すぎました।|तुम बहुत तेज़ बोल रहे थे।
He was reading a book.||彼は本を読んでいました।|वह किताब पढ़ रहा था।
She was cooking when I arrived.||私が着いたとき、彼女は料理をしていました।|जब मैं पहुँचा वह खाना बना रही थी।
He was not paying attention.||彼は注意を払っていませんでした।|वह ध्यान नहीं दे रहा था।
Was she crying?||彼女は泣いていましたか।|क्या वह रो रही थी?
It was raining all night.||一晩中雨が降っていました।|पूरी रात बारिश हो रही थी。
The sun was shining brightly.||太陽が明るく輝いていました।|सूरज चमक रहा था।
We were having dinner together.||私たちは一緒に夕食を食べていました।|हम साथ में खाना खा रहे थे।
We were walking in the park.||公園を歩いていました।|हम पार्क में टहल रहे थे।
We weren't expecting you.||あなたを待っていませんでした।|हमें तुम्हारी उम्मीद नहीं थी।
Were you sleeping?||寝ていましたか।|क्या तुम सो रहे थे?
They were playing outside.||彼らは外で遊んでいました।|वे बाहर खेल रहे थे।
They were arguing about money.||彼らはお金について議論していました।|वे पैसों को लेकर बहस कर रहे थे।
They weren't paying attention.||彼らは注意を払っていませんでした।|वे ध्यान नहीं दे रहे थे।
While I was cooking, he was watching TV.||私が料理している間、彼はテレビを見ていました।|जब मैं खाना बना रही थी, वह टीवी देख रहा था।
I was taking a shower when the power went out.||停電のとき、私はシャワーを浴びていました।|बिजली जाने पर मैं स्नान कर रहा था।
She was wearing a blue dress.||彼女は青いドレスを着ていました।|उसने नीली ड्रेस पहनी हुई थी।
He was waiting at the bus stop.||彼はバス停で待っていました।|वह बस स्टॉप पर इंतज़ार कर रहा था।
The children were laughing loudly.||子供たちは大声で笑っていました।|बच्चे ज़ोर से हँस रहे थे।
I was thinking about you.||あなたのことを考えていました।|मैं तुम्हारे बारे में सोच रहा था।
We were watching the match together.||私たちは一緒に試合を見ていました।|हम साथ में मैच देख रहे थे।
He was running to catch the train.||彼は電車に間に合うように走っていました।|वह ट्रेन पकड़ने दौड़ रहा था।
She was singing in the shower.||彼女はシャワーで歌っていました।|वह स्नान करते हुए गा रही थी।
The dog was barking all night.||犬が一晩中吠えていました।|कुत्ता पूरी रात भौंक रहा था।
What was he doing there?||彼はそこで何をしていましたか।|वह वहाँ क्या कर रहा था? """);
        eg("eg8", "present perfect — have + past participle", "現在完了", "A2",
            "USAGE: We use the present perfect for past actions that connect to the present, or for experiences without saying when.\nWHEN: Use it for life experiences (I have visited Japan), recent events (She has just left), results that matter now (I have lost my keys), and unfinished time (I have worked all day today).\nFORM: have/has + past participle (been, gone, seen, eaten, worked). Negative: haven't / hasn't. Question: Have/Has + subject + participle.\nTIP: Never use present perfect with finished time words like 'yesterday' or 'last year'. Say 'I saw him yesterday', not 'I have seen him yesterday'.",
            "उपयोग: present perfect का प्रयोग उन अतीत की क्रियाओं के लिए होता है जो वर्तमान से जुड़ी हों, या अनुभवों के लिए जब समय न बताया जाए।\nकब: जीवन के अनुभव, हाल की घटनाएँ, वर्तमान पर प्रभाव, अधूरा समय।\nरूप: have/has + past participle। नकारात्मक: haven't / hasn't। प्रश्न: Have/Has + कर्ता + participle।\nटिप: 'yesterday', 'last year' जैसे समाप्त समय शब्दों के साथ present perfect का प्रयोग कभी न करें।",
            """I have visited Japan twice.||日本に二回行ったことがあります。|मैं दो बार जापान गया हूँ।
I have seen this movie before.||この映画は前に見たことがあります।|मैंने यह फ़िल्म पहले देखी है।
I have lost my keys.||鍵をなくしました。|मेरी चाबियाँ खो गई हैं।
I have just finished my work.||ちょうど仕事を終えたところです।|मैंने अभी-अभी अपना काम खत्म किया है।
I haven't eaten today.||今日はまだ何も食べていません।|मैंने आज कुछ नहीं खाया है।
Have you ever been to London?||ロンドンに行ったことがありますか।|क्या तुम कभी लंदन गए हो?
You have grown so much.||あなたはずいぶん大きくなりましたね।|तुम बहुत बड़े हो गए हो।
You have done a great job.||よくやりましたね।|तुमने बहुत अच्छा काम किया है।
Have you seen my glasses?||私の眼鏡を見ましたか।|क्या तुमने मेरा चश्मा देखा है?
He has gone to the market.||彼は市場に行きました।|वह बाज़ार गया है।
She has already left.||彼女はもう出発しました。|वह पहले ही जा चुकी है।
He has never tried sushi.||彼は寿司を食べたことがありません।|उसने कभी सुशी नहीं खाई।
She has written three books.||彼女は三冊の本を書いています।|उसने तीन किताबें लिखी हैं।
He hasn't called me yet.||彼はまだ私に電話していません।|उसने अभी तक मुझे फ़ोन नहीं किया।
Has she arrived?||彼女は到着しましたか।|क्या वह पहुँच गई?
Has he paid the bill?||彼は請求書を支払いましたか।|क्या उसने बिल चुकाया?
It has stopped raining.||雨が止みました。|बारिश रुक गई है।
The train has left.||電車は出発しました।|ट्रेन जा चुकी है।
We have known each other for years.||私たちは何年も知り合いです।|हम वर्षों से एक-दूसरे को जानते हैं।
We have lived here since 2019.||私たちは二〇一九年からここに住んでいます।|हम 2019 से यहाँ रह रहे हैं।
We haven't decided yet.||まだ決めていません।|हमने अभी तय नहीं किया है।
Have we met before?||前に会ったことがありますか।|क्या हम पहले मिले हैं?
They have finished their homework.||彼らは宿題を終えました。|उन्होंने अपना होमवर्क पूरा कर लिया है।
They have bought a new house.||彼らは新しい家を買いました।|उन्होंने नया घर खरीदा है।
They haven't arrived yet.||彼らはまだ到着していません।|वे अभी तक नहीं पहुँचे हैं।
I have been very busy lately.||最近とても忙しいです。|मैं हाल ही में बहुत व्यस्त रहा हूँ।
She has become a great singer.||彼女は素晴らしい歌手になりました।|वह एक बेहतरीन गायिका बन गई है।
He has learned to drive.||彼は運転を覚えました।|उसने गाड़ी चलाना सीख लिया है।
We have eaten at that restaurant many times.||私たちはそのレストランで何度も食事をしました।|हमने उस रेस्तरां में कई बार खाया है।
I have never seen such a beautiful sunset.||こんなに美しい夕日は見たことがありません।|मैंने इतना सुंदर सूर्यास्त कभी नहीं देखा।""");

        eg("eg9", "present perfect continuous — how long", "現在完了進行形", "B1",
            "USAGE: We use the present perfect continuous for an action that started in the past and is still happening now.\nWHEN: Use it to say how long something has been going on: I have been working here for five years, She has been studying since morning.\nFORM: have/has + been + verb-ing. Negative: haven't / hasn't been + verb-ing. Question: Have/Has + subject + been + verb-ing.\nTIP: The main point is the DURATION — you can almost always answer 'How long...?' with this tense.",
            "उपयोग: present perfect continuous का प्रयोग उस क्रिया के लिए होता है जो अतीत में शुरू हुई और अभी भी जारी है।\nकब: यह बताने के लिए कि कोई काम कितने समय से चल रहा है।\nरूप: have/has + been + क्रिया-ing। नकारात्मक: haven't / hasn't been + क्रिया-ing। प्रश्न: Have/Has + कर्ता + been + क्रिया-ing।\nटिप: इस tense का मुख्य बिंदु अवधि है — 'How long...?' के उत्तर में इसका प्रयोग होता है।",
            """I have been working here for five years.||ここで五年間働いています।|मैं यहाँ पाँच साल से काम कर रहा हूँ।
I have been studying English since 2021.||二〇二一年から英語を勉強しています।|मैं 2021 से अंग्रेज़ी पढ़ रहा हूँ।
I have been waiting for an hour.||一時間待っています。|मैं एक घंटे से इंतज़ार कर रहा हूँ।
I have been feeling tired all week.||一週間ずっと疲れを感じています।|मैं पूरे हफ्ते थका हुआ महसूस कर रहा हूँ।
I haven't been sleeping well lately.||最近よく眠れていません。|मैं हाल में अच्छी नींद नहीं ले पा रहा हूँ।
How long have you been learning Japanese?||どのくらい日本語を勉強していますか।|तुम कितने समय से जापानी सीख रहे हो?
You have been talking for two hours!||二時間も話していますね।|तुम दो घंटे से बात कर रहे हो!
Have you been waiting long?||長く待っていましたか।|क्या तुम बहुत देर से इंतज़ार कर रहे हो?
He has been playing games all day.||彼は一日中ゲームをしています।|वह पूरे दिन गेम खेल रहा है।
She has been cooking since morning.||彼女は朝から料理をしています।|वह सुबह से खाना बना रही है।
He has been working out a lot.||彼はたくさん運動しています。|वह बहुत कसरत कर रहा है।
She has been crying.||彼女は泣いていました。|वह रो रही है।
Has it been raining here?||ここでは雨が降っていますか।|क्या यहाँ बारिश हो रही है?
It has been raining all day.||一日中雨が降っています।|पूरे दिन बारिश हो रही है।
We have been living here for ten years.||私たちはここに十年住んでいます।|हम दस साल से यहाँ रह रहे हैं।
We have been saving money for a trip.||旅行のためにお金を貯めています।|हम यात्रा के लिए पैसे बचा रहे हैं।
We have been friends since childhood.||私たちは子供の頃からの友達です।|हम बचपन से दोस्त हैं।
How long have we been waiting?||どのくらい待っていますか।|हम कितनी देर से इंतज़ार कर रहे हैं?
They have been building the house for months.||彼らは何か月も家を建てています।|वे महीनों से घर बना रहे हैं।
They have been practicing all afternoon.||彼らは午後ずっと練習しています।|वे पूरी दोपहर अभ्यास कर रहे हैं।
They haven't been answering my calls.||彼らは私の電話に出ていません。|वे मेरे फ़ोन का जवाब नहीं दे रहे हैं।
I have been reading this novel for weeks.||この小説を何週間も読んでいます।|मैं हफ्तों से यह उपन्यास पढ़ रहा हूँ।
She has been looking for a new job.||彼女は新しい仕事を探しています।|वह नई नौकरी की तलाश कर रही है।
He has been saving to buy a car.||彼は車を買うためにお金を貯めています।|वह कार खरीदने के लिए पैसे बचा रहा है।
The kids have been playing outside all day.||子供たちは一日中外で遊んでいます।|बच्चे पूरे दिन बाहर खेल रहे हैं।
I have been thinking about your offer.||あなたの申し出について考えています।|मैं तुम्हारे प्रस्ताव के बारे में सोच रहा हूँ।
We have been planning this party for a month.||このパーティーを一ヶ月計画しています।|हम एक महीने से इस पार्टी की योजना बना रहे हैं।
Have you been taking your medicine?||薬を飲んでいますか।|क्या तुम दवा ले रहे हो?
She has been learning to cook.||彼女は料理を学んでいます。|वह खाना बनाना सीख रही है।
I have been practicing the piano every day.||毎日ピアノを練習しています।|मैं रोज़ पियानो का अभ्यास कर रहा हूँ।""");
        eg("eg10", "past perfect — the past of the past", "過去完了", "B1",
            "USAGE: We use the past perfect for an action that finished BEFORE another action in the past.\nWHEN: Use it to show order: The train had left before we arrived. Use it with 'by the time', 'after', 'already', 'never'.\nFORM: had + past participle (had gone, had seen, had eaten). Negative: hadn't + participle. Question: Had + subject + participle.\nTIP: Use it only when you need to show that one past event happened before another. For one simple past action, don't use it.",
            "उपयोग: past perfect का प्रयोग उस क्रिया के लिए होता है जो अतीत की किसी अन्य क्रिया से पहले समाप्त हो चुकी थी।\nकब: क्रम दिखाने के लिए — The train had left before we arrived.\nरूप: had + past participle। नकारात्मक: hadn't + participle। प्रश्न: Had + कर्ता + participle।\nटिप: केवल तभी प्रयोग करें जब दो अतीत की घटनाओं का क्रम दिखाना हो।",
            """The train had left before we arrived.||私たちが着く前に電車は出発していました।|हमारे पहुँचने से पहले ट्रेन जा चुकी थी।
I had finished my homework when she came.||彼女が来たとき、宿題を終えていました।|जब वह आई, मैं अपना होमवर्क खत्म कर चुका था।
He had eaten before I got home.||私が家に着く前に彼は食べていました।|मेरे घर पहुँचने से पहले वह खा चुका था।
She had already left when I called.||私が電話したとき、彼女はもう出発していました।|जब मैंने फ़ोन किया, वह पहले ही जा चुकी थी।
I had never seen the ocean before that day.||その日まで海を見たことがありませんでした।|उस दिन से पहले मैंने कभी समुद्र नहीं देखा था।
Had you ever been to Japan before?||以前に日本に行ったことがありましたか।|क्या तुम पहले कभी जापान गए थे?
You had told me not to worry.||あなたは心配するなと言っていました。|तुमने मुझसे चिंता न करने को कहा था।
He had lost his wallet before the trip.||旅行の前に財布をなくしていました।|यात्रा से पहले उसका बटुआ खो गया था।
She had cooked dinner by the time we got home.||私たちが帰るまでに彼女は夕食を作っていました।|हमारे घर पहुँचने तक उसने खाना बना लिया था।
The movie had started when we entered.||私たちが入ったとき映画は始まっていました।|हमारे अंदर जाने पर फ़िल्म शुरू हो चुकी थी।
We had met each other before.||私たちは以前会ったことがありました।|हम पहले मिल चुके थे।
We hadn't planned to stay so long.||こんなに長く滞在する予定ではありませんでした।|हमने इतनी देर रुकने की योजना नहीं बनाई थी।
Had you finished the report?||報告書は終えていましたか।|क्या तुमने रिपोर्ट खत्म कर ली थी?
They had already gone home.||彼らはもう家に帰っていました।|वे पहले ही घर जा चुके थे।
They had never tried Indian food.||彼らはインド料理を食べたことがありませんでした।|उन्होंने कभी भारतीय खाना नहीं खाया था।
By the time I woke up, everyone had left.||私が起きる頃にはみんな去っていました।|जब तक मैं उठा, सब जा चुके थे।
She had forgotten my name.||彼女は私の名前を忘れていました।|वह मेरा नाम भूल चुकी थी।
He had broken his leg before the race.||彼はレースの前に足を骨折していました।|दौड़ से पहले उसका पैर टूट चुका था।
I had seen that place in a dream.||その場所を夢で見たことがありました।|मैंने वह जगह सपने में देखी थी।
We had booked the tickets online.||私たちはチケットをオンラインで予約していました।|हमने टिकट ऑनलाइन बुक कर लिए थे।
After she had left, I felt sad.||彼女が去った後、悲しくなりました।|उसके जाने के बाद मुझे उदासी हुई।
Before he arrived, we had finished eating.||彼が来る前に、私たちは食べ終えていました।|उसके आने से पहले हम खाना खत्म कर चुके थे।
Had they ever visited this city?||彼らはこの街を訪れたことがありましたか।|क्या वे कभी इस शहर आए थे?
The shop had closed by the time we got there.||私たちが着く頃には店は閉まっていました।|हमारे पहुँचने तक दुकान बंद हो चुकी थी।
I hadn't realized how late it was.||こんなに遅いとは気づきませんでした।|मुझे एहसास नहीं था कि इतनी देर हो गई है।
She had studied hard before the exam.||彼女は試験の前に一生懸命勉強していました।|परीक्षा से पहले उसने कड़ी मेहनत की थी।
He had saved enough money for the trip.||彼は旅行のためにお金を十分貯めていました।|उसने यात्रा के लिए पर्याप्त पैसे बचा लिए थे।
We had heard about that restaurant before.||私たちはそのレストランについて前に聞いていました।|हमने उस रेस्तरां के बारे में पहले सुना था।
The guests had arrived before midnight.||客は真夜中前に到着していました।|मेहमान आधी रात से पहले पहुँच चुके थे।
I had never felt so happy.||こんなに幸せを感じたことはありませんでした।|मैंने कभी इतनी खुशी महसूस नहीं की थी।""");
        eg("eg11", "will — future predictions & decisions", "will（未来）", "A2",
            "USAGE: We use will for future predictions, promises, offers, and decisions made at the moment of speaking.\nWHEN: Use it for quick decisions (I'll take the job!), promises (I will call you), offers (I'll help you), and predictions (It will rain tomorrow).\nFORM: will + base verb. Short form: 'll. Negative: won't. Question: Will + subject + verb.\nTIP: For predictions you can use 'will' — for plans already made, use 'going to' instead.",
            "उपयोग: will का प्रयोग भविष्य की भविष्यवाणियों, वादों, प्रस्तावों और बोलते समय लिए गए निर्णयों के लिए होता है।\nकब: तुरंत निर्णय, वादे, प्रस्ताव, भविष्यवाणियाँ।\nरूप: will + मूल क्रिया। संक्षिप्त: 'll। नकारात्मक: won't। प्रश्न: Will + कर्ता + क्रिया।\nटिप: योजना बनाई जा चुकी हो तो 'going to' का प्रयोग करें।",
            """I will call you tomorrow.||明日あなたに電話します。|मैं कल तुम्हें फ़ोन करूँगा।
I'll help you with your bags.||荷物を運ぶのを手伝います。|मैं तुम्हारा सामान ले जाने में मदद करूँगा।
I think it will rain tonight.||今夜は雨が降ると思います。|मुझे लगता है आज रात बारिश होगी।
I won't forget your birthday.||あなたの誕生日を忘れません。|मैं तुम्हारा जन्मदिन नहीं भूलूँगा।
Will you come to the party?||パーティーに来ますか।|क्या तुम पार्टी में आओगे?
You will enjoy this book.||この本は楽しめるでしょう。|तुम्हें यह किताब अच्छी लगेगी।
He will be here soon.||彼はすぐに来ます。|वह जल्द ही यहाँ आएगा।
She will pass the exam.||彼女は試験に合格するでしょう।|वह परीक्षा में पास हो जाएगी।
He won't agree with you.||彼はあなたに同意しないでしょう।|वह तुमसे सहमत नहीं होगा।
Will she come with us?||彼女も一緒に来ますか।|क्या वह हमारे साथ आएगी?
It will be a great day.||素晴らしい一日になるでしょう।|बहुत अच्छा दिन होगा।
We will meet again soon.||またすぐに会いましょう।|हम जल्द ही फिर मिलेंगे।
We'll see what happens.||どうなるか見てみましょう।|हम देखेंगे कि क्या होता है।
We won't give up.||私たちはあきらめません।|हम हार नहीं मानेंगे।
Will we have enough time?||時間は足りますか।|क्या हमारे पास पर्याप्त समय होगा?
They will arrive at seven.||彼らは七時に到着するでしょう।|वे सात बजे पहुँचेंगे।
They won't believe you.||彼らはあなたを信じないでしょう।|वे तुम पर विश्वास नहीं करेंगे।
Will they accept the offer?||彼らは申し出を受け入れますか।|क्या वे प्रस्ताव स्वीकार करेंगे?
I promise I will be careful.||気をつけると約束します।|मैं वादा करता हूँ सावधान रहूँगा।
Don't worry, everything will be fine.||心配しないで、すべてうまくいきます।|चिंता मत करो, सब ठीक हो जाएगा।
She will love this gift.||彼女はこの贈り物を気に入るでしょう।|उसे यह उपहार बहुत पसंद आएगा।
The meeting will start at nine.||会議は九時に始まります।|मीटिंग नौ बजे शुरू होगी।
I'll send you the details later.||後で詳細を送ります।|मैं बाद में विवरण भेजूँगा।
I'll take the blue one, please.||青いのをください।|मैं नीला वाला लूँगा।
You will succeed if you try.||挑戦すれば成功するでしょう।|कोशिश करोगे तो सफल होगे।
He won't be angry with you.||彼はあなたに怒らないでしょう।|वह तुम पर गुस्सा नहीं होगा。
Will you help me with this?||これを手伝ってくれますか।|क्या तुम इसमें मेरी मदद करोगे?
It won't take long.||長くはかかりません।|इसमें ज़्यादा समय नहीं लगेगा।
We'll have dinner at eight.||八時に夕食をとります。|हम आठ बजे खाना खाएँगे।
I think she will agree.||彼女は同意すると思います।|मुझे लगता है वह मान जाएगी।""");
        eg("eg12", "going to — plans & intentions", "going to（予定）", "A2",
            "USAGE: We use going to for future plans and intentions that were already decided, and for predictions based on evidence.\nWHEN: Use it for plans (I am going to visit my parents), intentions (We are going to buy a house), and predictions with evidence (Look at those clouds! It is going to rain).\nFORM: am/is/are + going to + base verb. Negative: am not / isn't / aren't going to. Question: Am/Is/Are + subject + going to + verb.\nTIP: If you decided BEFORE speaking → going to. If you decide at the moment → will.",
            "उपयोग: going to का प्रयोग पहले से तय योजनाओं, इरादों और सबूत पर आधारित भविष्यवाणियों के लिए होता है।\nकब: योजनाएँ, इरादे, और संकेतों से भविष्यवाणी।\nरूप: am/is/are + going to + मूल क्रिया।\nटिप: पहले से तय हो तो going to, बोलते समय तय हो तो will।",
            """I am going to visit my parents next week.||来週両親を訪ねるつもりです।|मैं अगले हफ्ते अपने माता-पिता से मिलने जा रहा हूँ।
I'm going to buy a new phone.||新しい携帯を買うつもりです।|मैं नया फ़ोन खरीदने जा रहा हूँ।
I'm going to start a business.||事業を始めるつもりです।|मैं व्यापार शुरू करने जा रहा हूँ।
I am not going to give up.||あきらめるつもりはありません।|मैं हार मानने वाला नहीं हूँ।
Are you going to come to the meeting?||会議に来るつもりですか।|क्या तुम मीटिंग में आने वाले हो?
You are going to love this place.||この場所が気に入るでしょう।|तुम्हें यह जगह बहुत पसंद आने वाली है।
He is going to study abroad.||彼は留学するつもりです।|वह विदेश में पढ़ने जा रहा है।
She is going to become a doctor.||彼女は医者になるつもりです।|वह डॉक्टर बनने जा रही है।
He isn't going to help us.||彼は私たちを助けるつもりはありません।|वह हमारी मदद नहीं करने वाला।
Is she going to join us?||彼女は私たちに加わりますか।|क्या वह हमारे साथ जुड़ने वाली है?
Look at those clouds — it is going to rain.||あの雲を見て、雨が降りそうです。|उन बादलों को देखो — बारिश होने वाली है।
We are going to travel to Japan.||私たちは日本に旅行するつもりです।|हम जापान की यात्रा करने जा रहे हैं।
We're going to have a party on Saturday.||土曜日にパーティーをするつもりです।|हम शनिवार को पार्टी करने वाले हैं।
We aren't going to sell the house.||家を売るつもりはありません।|हम घर बेचने वाले नहीं हैं।
Are we going to be late?||私たちは遅れますか।|क्या हमें देर होने वाली है?
They are going to get married.||彼らは結婚するつもりです।|वे शादी करने जा रहे हैं।
They are going to build a new school.||彼らは新しい学校を建てるつもりです।|वे नया स्कूल बनाने जा रहे हैं।
They are not going to stay here.||彼らはここに滞在するつもりはありません।|वे यहाँ रुकने वाले नहीं हैं।
What are you going to do tonight?||今夜は何をするつもりですか।|आज रात तुम क्या करने वाले हो?
Where is she going to live?||彼女はどこに住むつもりですか।|वह कहाँ रहने वाली है?
When are you going to leave?||いつ出発するつもりですか।|तुम कब जाने वाले हो?
I'm going to take a short break.||少し休憩を取るつもりです।|मैं थोड़ा ब्रेक लेने जा रहा हूँ।
She is going to call you tonight.||彼女は今夜あなたに電話するつもりです।|वह आज रात तुम्हें फ़ोन करने वाली है।
He is going to work hard this year.||彼は今年一生懸命働くつもりです।|वह इस साल कड़ी मेहनत करने वाला है।
We are going to watch a movie later.||後で映画を見るつもりです।|हम बाद में फ़िल्म देखने वाले हैं।
I'm going to learn to swim this summer.||この夏、泳ぎを覚えるつもりです।|मैं इस गर्मी में तैरना सीखने जा रहा हूँ।
The team is going to win tonight.||チームは今夜勝つでしょう।|टीम आज रात जीतने वाली है।
Are you going to tell her the truth?||彼女に真実を話すつもりですか।|क्या तुम उसे सच बताने वाले हो?
They are going to move to Delhi.||彼らはデリーに引っ越すつもりです।|वे दिल्ली जाने वाले हैं।
I'm going to cook dinner tonight.||今夜は夕食を作るつもりです।|मैं आज रात खाना बनाने जा रहा हूँ।""");
        eg("eg13", "future continuous — will be doing", "未来進行形", "B1",
            "USAGE: We use the future continuous for an action that will be in progress at a specific time in the future.\nWHEN: Use it for actions at a future moment (At 8 PM I will be watching the match), for things that will be happening anyway (I will be passing your office, so I can drop by), and to ask politely about plans (Will you be using the car?).\nFORM: will be + verb-ing. Negative: won't be + verb-ing. Question: Will + subject + be + verb-ing.\nTIP: Use it to sound more natural and polite when asking about someone's future plans.",
            "उपयोग: future continuous का प्रयोग भविष्य के किसी क्षण में जारी रहने वाली क्रिया के लिए होता है।\nकब: भविष्य के क्षण में चल रही क्रिया, वैसे ही होने वाली बातें, विनम्र पूछताछ।\nरूप: will be + क्रिया-ing। नकारात्मक: won't be + क्रिया-ing। प्रश्न: Will + कर्ता + be + क्रिया-ing।\nटिप: भविष्य की योजनाओं के बारे में विनम्रता से पूछने के लिए इसका प्रयोग करें।",
            """At 8 PM I will be watching the match.||八時に試合を見ているでしょう।|रात 8 बजे मैं मैच देख रहा होऊँगा।
I will be sleeping when you arrive.||あなたが着くとき、私は寝ているでしょう।|तुम्हारे आने पर मैं सो रहा होऊँगा।
I will be waiting for you at the station.||駅であなたを待っているでしょう।|मैं स्टेशन पर तुम्हारा इंतज़ार कर रहा होऊँगा।
I won't be using the car tonight.||今夜は車を使わないでしょう।|मैं आज रात कार इस्तेमाल नहीं कर रहा होऊँगा।
Will you be coming to the office tomorrow?||明日オフィスに来ますか।|क्या तुम कल ऑफिस आ रहे होगे?
You will be feeling better soon.||すぐに気分が良くなるでしょう।|तुम जल्द ही बेहतर महसूस कर रहे होगे।
He will be working at that time.||彼はその時間働いているでしょう।|वह उस समय काम कर रहा होगा।
She will be cooking dinner at six.||彼女は六時に夕食を作っているでしょう।|वह छह बजे खाना बना रही होगी।
He won't be joining us for lunch.||彼は昼食に来ないでしょう।|वह दोपहर के खाने में शामिल नहीं हो रहा होगा।
Will she be flying tomorrow?||彼女は明日飛行機に乗りますか।|क्या वह कल उड़ान भर रही होगी?
We will be driving through the night.||私たちは一晩中運転しているでしょう।|हम पूरी रात गाड़ी चला रहे होंगे।
We will be staying at a hotel in Goa.||私たちはゴアのホテルに滞在しているでしょう।|हम गोवा के होटल में रुके होंगे।
We won't be needing this anymore.||もうこれは必要ないでしょう।|हमें अब यह ज़रूरत नहीं होगी।
Will we be seeing you this weekend?||今週末会えますか।|क्या हम इस सप्ताहांत तुमसे मिल पाएँगे?
They will be arriving at noon.||彼らは正午に到着しているでしょう।|वे दोपहर में पहुँच रहे होंगे।
They will be staying for a week.||彼らは一週間滞在するでしょう।|वे एक हफ्ते रुके होंगे।
They won't be taking the train.||彼らは電車に乗らないでしょう।|वे ट्रेन नहीं ले रहे होंगे।
This time tomorrow I will be flying to Tokyo.||明日の今頃、東京へ飛行機で行っているでしょう।|कल इस समय मैं टोक्यो के लिए उड़ान भर रहा होऊँगा।
Soon you will be speaking English fluently.||すぐに流暢に英語を話せるでしょう।|जल्द ही तुम धाराप्रवाह अंग्रेज़ी बोल रहे होगे।
I will be reading a book on the plane.||飛行機で本を読んでいるでしょう।|मैं हवाई जहाज़ में किताब पढ़ रहा होऊँगा।
He will be waiting outside.||彼は外で待っているでしょう।|वह बाहर इंतज़ार कर रहा होगा।
She will be teaching at that school next year.||彼女は来年その学校で教えているでしょう।|वह अगले साल उस स्कूल में पढ़ा रही होगी।
Will you be using this laptop?||このノートパソコンを使いますか।|क्या तुम यह लैपटॉप इस्तेमाल कर रहे होगे?
I won't be staying late tonight.||今夜は遅くまでいないでしょう।|मैं आज रात देर तक नहीं रुकूँगा।
We will be celebrating her birthday next month.||来月、彼女の誕生日を祝っているでしょう।|हम अगले महीने उसका जन्मदिन मना रहे होंगे।
The teacher will be checking our homework.||先生は宿題をチェックしているでしょう।|शिक्षक हमारा होमवर्क जाँच रहे होंगे।
They will be having a meeting at that time.||彼らはその時間会議をしているでしょう।|वे उस समय मीटिंग कर रहे होंगे।
Don't call at ten — I will be sleeping.||十時に電話しないで、寝ているから।|दस बजे फ़ोन मत करना — मैं सो रहा होऊँगा।
I'll be thinking of you.||あなたのことを考えているでしょう।|मैं तुम्हारे बारे में सोच रहा होऊँगा।
By then, he will be driving home.||その頃には彼は家に向かって運転しているでしょう।|तब तक वह घर की ओर गाड़ी चला रहा होगा।""");
        eg("eg14", "future perfect — will have done", "未来完了", "B2",
            "USAGE: We use the future perfect for an action that will be finished before a certain time in the future.\nWHEN: Use it with 'by' (By 2028 I will have graduated), 'by the time' (By the time you arrive, we will have eaten), and 'before' (I will have finished before lunch).\nFORM: will have + past participle. Negative: won't have + participle. Question: Will + subject + have + participle.\nTIP: The key word is 'by' — it marks the deadline. No deadline, no future perfect.",
            "उपयोग: future perfect का प्रयोग उस क्रिया के लिए होता है जो भविष्य के किसी समय से पहले समाप्त हो चुकी होगी।\nकब: by, by the time, before के साथ।\nरूप: will have + past participle। नकारात्मक: won't have + participle। प्रश्न: Will + कर्ता + have + participle।\nटिप: मुख्य शब्द 'by' है — यह समय सीमा दर्शाता है।",
            """By 2028 I will have graduated.||二〇二八年までに卒業しているでしょう।|2028 तक मैं स्नातक हो चुका होऊँगा।
I will have finished the project by Friday.||金曜日までにプロジェクトを終えているでしょう।|मैं शुक्रवार तक प्रोजेक्ट खत्म कर चुका होऊँगा।
I will have saved enough money by summer.||夏までに十分なお金を貯めているでしょう।|मैं गर्मी तक पर्याप्त पैसे बचा चुका होऊँगा।
By the time you arrive, we will have eaten.||あなたが着く頃には私たちは食べ終えているでしょう।|तुम्हारे पहुँचने तक हम खा चुके होंगे।
I won't have finished by then.||それまでには終えていないでしょう।|तब तक मैं खत्म नहीं कर चुका होऊँगा।
Will you have completed the report by Monday?||月曜日までに報告書を完成させていますか।|क्या तुम सोमवार तक रिपोर्ट पूरी कर चुके होगे?
He will have left by now.||彼は今頃出発しているでしょう।|वह अब तक जा चुका होगा।
She will have cooked dinner by seven.||彼女は七時までに夕食を作っているでしょう।|वह सात बजे तक खाना बना चुकी होगी।
They won't have arrived by midnight.||彼らは真夜中までに到着していないでしょう।|वे आधी रात तक नहीं पहुँचे होंगे।
Will they have finished the construction?||彼らは建設を終えているでしょうか।|क्या वे निर्माण पूरा कर चुके होंगे?
We will have lived here for ten years by 2030.||二〇三〇年までに十年ここに住んでいるでしょう।|2030 तक हम दस साल यहाँ रह चुके होंगे।
By next month we will have saved enough.||来月までに十分貯めているでしょう।|अगले महीने तक हम पर्याप्त बचा चुके होंगे।
We won't have spent all our money.||お金を使い切っていないでしょう।|हम सारा पैसा खर्च नहीं कर चुके होंगे।
Will we have arrived before sunset?||日没前に到着しているでしょうか।|क्या हम सूर्यास्त से पहले पहुँच चुके होंगे?
The train will have left by then.||その頃には電車は出発しているでしょう।|तब तक ट्रेन जा चुकी होगी।
She will have finished her degree by then.||その頃には彼女は学位を取得しているでしょう।|तब तक वह अपनी डिग्री पूरी कर चुकी होगी।
I will have read this book by the weekend.||週末までにこの本を読み終えているでしょう।|मैं सप्ताहांत तक यह किताब पढ़ चुका होऊँगा।
By 9 PM we will have watched the whole series.||午後九時までにシリーズ全部を見終えているでしょう।|रात 9 बजे तक हम पूरी सीरीज़ देख चुके होंगे।
He will have repaired the car before dinner.||彼は夕食前に車を修理しているでしょう।|वह खाने से पहले कार ठीक कर चुका होगा।
They will have moved to their new house by then.||その頃には彼らは新しい家に引っ越しているでしょう।|तब तक वे नए घर में जा चुके होंगे।
Will the store have closed by then?||その頃には店は閉まっているでしょうか।|क्या तब तक दुकान बंद हो चुकी होगी?
I will have answered all the emails by noon.||正午までに全部のメールに返事をしているでしょう।|मैं दोपहर तक सभी ईमेल का जवाब दे चुका होऊँगा।
She will have learned enough by the exam.||彼女は試験までに十分学んでいるでしょう।|वह परीक्षा तक पर्याप्त सीख चुकी होगी।
By this time next year, I will have changed my job.||来年の今頃には転職しているでしょう।|अगले साल इस समय तक मैं नौकरी बदल चुका होऊँगा।
We will have tested the machine before using it.||使う前に機械をテストしているでしょう।|हम इस्तेमाल से पहले मशीन का परीक्षण कर चुके होंगे।
They will have built the bridge by 2029.||彼らは二〇二九年までに橋を建てているでしょう।|वे 2029 तक पुल बना चुके होंगे।
By then, I will have forgotten his name.||その頃には彼の名前を忘れているでしょう।|तब तक मैं उसका नाम भूल चुका होऊँगा।
He won't have finished his homework yet.||彼はまだ宿題を終えていないでしょう।|वह अभी तक होमवर्क खत्म नहीं कर चुका होगा।
Will you have decided by tomorrow?||明日までに決めていますか।|क्या तुम कल तक तय कर चुके होगे?
By the end of the year, we will have visited five countries.||年末までに五か国を訪れているでしょう।|साल के अंत तक हम पाँच देशों की यात्रा कर चुके होंगे।""");
        eg("eg15", "can / could — ability & permission", "can/could（能力・許可）", "A1",
            "USAGE: We use can and could to talk about ability, permission, and possibility.\nWHEN: can = present ability (I can swim), permission (Can I go?), informal requests (Can you help me?). could = past ability (I could run fast when I was young), polite requests (Could you open the door?), polite permission (Could I leave early?).\nFORM: can/could + base verb. Negative: can't, couldn't. Question: Can/Could + subject + verb.\nTIP: For POLITE requests, 'could' is softer than 'can'. 'Could you...?' is very polite and common.",
            "उपयोग: can/could का प्रयोग क्षमता, अनुमति और संभावना के लिए होता है।\nकब: can = वर्तमान क्षमता, अनुमति, सामान्य अनुरोध। could = अतीत की क्षमता, विनम्र अनुरोध।\nरूप: can/could + मूल क्रिया। नकारात्मक: can't, couldn't। प्रश्न: Can/Could + कर्ता + क्रिया।\nटिप: विनम्र अनुरोध के लिए 'could' अधिक नरम और विनम्र होता है।",
            """I can swim very well.||私はとても上手に泳げます।|मैं बहुत अच्छी तरह तैर सकता हूँ।
I can speak three languages.||私は三か国語を話せます।|मैं तीन भाषाएँ बोल सकता हूँ।
Can I come in?||入ってもいいですか।|क्या मैं अंदर आ सकता हूँ?
Can you help me with this box?||この箱を手伝ってくれますか।|क्या तुम इस डिब्बे में मेरी मदद कर सकते हो?
I can't find my keys.||鍵が見つかりません।|मुझे अपनी चाबियाँ नहीं मिल रहीं।
He can run very fast.||彼はとても速く走れます।|वह बहुत तेज़ दौड़ सकता है।
She can play the piano.||彼女はピアノを弾けます।|वह पियानो बजा सकती है।
He can't come to the party.||彼はパーティーに来られません।|वह पार्टी में नहीं आ सकता।
Can she cook?||彼女は料理ができますか।|क्या वह खाना बना सकती है?
We can meet tomorrow.||明日会えます。|हम कल मिल सकते हैं।
We can't go out tonight.||今夜は出かけられません।|हम आज रात बाहर नहीं जा सकते।
Can we pay by card?||カードで払えますか।|क्या हम कार्ड से भुगतान कर सकते हैं?
They can speak both languages.||彼らは両方の言語を話せます।|वे दोनों भाषाएँ बोल सकते हैं।
They can't afford that house.||彼らにはその家を買う余裕がありません।|वे वह घर खरीद नहीं सकते।
I could swim when I was five.||五歳のとき泳げました।|मैं पाँच साल की उम्र में तैर सकता था।
I could run fast in my youth.||若い頃は速く走れました।|जवानी में मैं तेज़ दौड़ सकता था।
Could you open the window, please?||窓を開けていただけますか।|क्या तुम कृपया खिड़की खोल सकते हो?
Could I borrow your pen?||ペンを借りてもいいですか।|क्या मैं तुम्हारा पेन उधार ले सकता हूँ?
Could you speak a little slower?||もう少しゆっくり話していただけますか।|क्या तुम थोड़ा धीरे बोल सकते हो?
She couldn't come to class yesterday.||彼女は昨日授業に来られませんでした।|वह कल कक्षा में नहीं आ सकी।
He couldn't answer the question.||彼は質問に答えられませんでした।|वह प्रश्न का उत्तर नहीं दे सका।
I couldn't sleep last night.||昨夜眠れませんでした।|मैं कल रात सो नहीं सका।
Could we have the bill, please?||お会計をお願いできますか।|क्या हमें बिल मिल सकता है?
Can I try this on?||これを試着してもいいですか।|क्या मैं इसे पहनकर देख सकता हूँ?
You can sit here.||ここに座っていいですよ।|तुम यहाँ बैठ सकते हो।
You can't smoke in here.||ここではタバコを吸えません।|तुम यहाँ धूम्रपान नहीं कर सकते।
It can get very cold here in winter.||ここは冬はとても寒くなることがあります।|यहाँ सर्दियों में बहुत ठंड पड़ सकती है।
Anyone can learn to cook.||誰でも料理を学べます।|कोई भी खाना बनाना सीख सकता है।
Can you hear that noise?||あの音が聞こえますか।|क्या तुम वह आवाज़ सुन सकते हो?
I could help you with that.||それを手伝うことができます。|मैं उसमें तुम्हारी मदद कर सकता था।""");
        eg("eg16", "may / might — possibility", "may/might（可能性）", "B1",
            "USAGE: We use may and might to talk about possibility — something that is possible but not certain.\nWHEN: Use them for guesses (He may be at home), future possibility (It might rain later), and permission (May I come in? — formal). 'may' is slightly more certain than 'might'.\nFORM: may/might + base verb. Negative: may not / might not. There is no 'mayn't' for possibility.\nTIP: For POLITE PERMISSION use 'may': 'May I use your phone?' For guesses about the present, also use may/might: 'She might be at work now'.",
            "उपयोग: may/might का प्रयोग संभावना बताने के लिए होता है — कुछ संभव है पर निश्चित नहीं।\nकब: अनुमान, भविष्य की संभावना, और औपचारिक अनुमति। 'may' 'might' से थोड़ा अधिक निश्चित है।\nरूप: may/might + मूल क्रिया। नकारात्मक: may not / might not।\nटिप: विनम्र अनुमति के लिए 'may' का प्रयोग करें।",
            """He may be at home right now.||彼は今家にいるかもしれません।|वह अभी घर पर हो सकता है।
She may come to the party.||彼女はパーティーに来るかもしれません।|वह पार्टी में आ सकती है।
It might rain later.||後で雨が降るかもしれません।|बाद में बारिश हो सकती है।
I might be late for the meeting.||会議に遅れるかもしれません।|मैं मीटिंग के लिए देर से आ सकता हूँ।
You may be right.||あなたは正しいかもしれません।|तुम सही हो सकते हो।
He might not agree with us.||彼は私たちに同意しないかもしれません।|वह हमसे सहमत नहीं हो सकता।
She may not come today.||彼女は今日来ないかもしれません।|वह आज नहीं आ सकती।
May I use your phone?||電話を使ってもいいですか।|क्या मैं तुम्हारा फ़ोन इस्तेमाल कर सकता हूँ?
May I ask a question?||質問してもいいですか।|क्या मैं एक प्रश्न पूछ सकता हूँ?
They might arrive early.||彼らは早く着くかもしれません।|वे जल्दी पहुँच सकते हैं।
We might go out for dinner.||外で夕食を食べるかもしれません。|हम बाहर खाना खाने जा सकते हैं।
It may take some time.||少し時間がかかるかもしれません।|इसमें कुछ समय लग सकता है।
The road might be closed.||道路が閉鎖されているかもしれません।|सड़क बंद हो सकती है।
She might be sleeping now.||彼女は今寝ているかもしれません।|वह अभी सो रही हो सकती है।
I may have left my wallet at home.||財布を家に忘れたかもしれません।|मैंने अपना बटुआ घर पर छोड़ा हो सकता है।
They may not have received the message.||彼らはメッセージを受け取っていないかもしれません।|हो सकता है उन्हें संदेश न मिला हो।
You might want to try this restaurant.||このレストランを試してみてはいかがでしょう।|तुम शायद यह रेस्तरां आज़माना चाहो।
We may have to cancel the trip.||旅行をキャンセルしなければならないかもしれません।|हमें शायद यात्रा रद्द करनी पड़े।
The meeting might be postponed.||会議は延期されるかもしれません।|मीटिंग स्थगित हो सकती है।
He might know the answer.||彼は答えを知っているかもしれません।|वह जवाब जानता हो सकता है।
She may call you later.||彼女は後で電話するかもしれません।|वह बाद में फ़ोन कर सकती है।
I might visit my grandmother this weekend.||今週末祖母を訪ねるかもしれません।|मैं इस सप्ताहांत दादी से मिलने जा सकता हूँ।
It may be difficult at first.||最初は難しいかもしれません।|शुरू में यह कठिन हो सकता है।
They might be at the airport now.||彼らは今空港にいるかもしれません।|वे अभी हवाई अड्डे पर हो सकते हैं।
We may not have enough time.||時間が足りないかもしれません।|हो सकता है हमारे पास पर्याप्त समय न हो।
She might not be feeling well.||彼女は気分が良くないかもしれません।|वह शायद ठीक महसूस नहीं कर रही।
You may borrow my book.||私の本を借りていいですよ।|तुम मेरी किताब उधार ले सकते हो।
It might snow tonight.||今夜は雪が降るかもしれません।|आज रात बर्फबारी हो सकती है।
I may be a little late to the party.||パーティーに少し遅れるかもしれません।|मैं पार्टी में थोड़ा देर से आ सकता हूँ।
He might be the new manager.||彼が新しいマネージャーかもしれません।|वह नया मैनेजर हो सकता है।""");

        eg("eg17", "must / have to — obligation", "must / have to（義務）", "A2",
            "USAGE: Both 'must' and 'have to' express obligation or necessity — something you are required to do.\\nWHEN: 'must' is often personal or strong (I must study hard); 'have to' often comes from outside rules (We have to wear a uniform at school). 'must not' = forbidden, 'don't have to' = not necessary.\\nFORM: must / have to + base verb, for all persons. Past: had to. Negative: must not (mustn't) / don't have to. Question: Do you have to...? / Must I...?\\nTIP: 'don't have to' and 'mustn't' are opposites: 'You don't have to go' = optional; 'You mustn't go' = forbidden.",
            "उपयोग: 'must' और 'have to' दोनों अनिवार्यता बताते हैं — कुछ ऐसा जो करना ज़रूरी है।\\nकब: 'must' अक्सर व्यक्तिगत/मज़बूत होता है (मुझे कड़ी मेहनत करनी चाहिए); 'have to' बाहरी नियमों से (स्कूल में वर्दी पहननी पड़ती है)। 'must not' = मना, 'don't have to' = ज़रूरी नहीं।\\nरूप: must / have to + क्रिया का मूल रूप, सभी कर्ताओं के लिए। भूतकाल: had to। नकारात्मक: mustn't / don't have to। प्रश्न: Do you have to...? / Must I...?\\nटिप: 'don't have to' और 'mustn't' विपरीत हैं: 'तुम्हें जाना ज़रूरी नहीं' बनाम 'तुम्हें जाना मना है'।",
            """You must wear a seatbelt.||シートベルトを着用しなければなりません。|तुम्हें सीटबेल्ट पहनना ज़रूरी है।
I must finish this today.||今日これを終えなければなりません。|मुझे यह आज खत्म करना है।
She must see a doctor.||彼女は医者に診てもらわなければなりません।|उसे डॉक्टर से मिलना ज़रूरी है।
We must leave now.||今出発しなければなりません。|हमें अभी निकलना होगा।
They must be careful.||彼らは注意しなければなりません।|उन्हें सावधान रहना चाहिए।
You must not smoke here.||ここで喫煙してはいけません।|यहाँ धूम्रपान करना मना है।
Visitors must show their ID.||来館者は身分証明書を見せなければなりません।|आगंतुकों को पहचान पत्र दिखाना अनिवार्य है।
I have to get up early.||早く起きなければなりません。|मुझे जल्दी उठना है।
She has to work on Saturday.||彼女は土曜日に働かなければなりません।|उसे शनिवार को काम करना है।
We have to pay the bill.||私たちは請求書を支払わなければなりません।|हमें बिल चुकाना है।
He has to wear a uniform.||彼は制服を着なければなりません।|उसे वर्दी पहननी है।
Do you have to wear a uniform?||制服を着なければなりませんか。|क्या तुम्हें वर्दी पहननी है?
You don't have to come if you're busy.||忙しければ来なくていいですよ。|अगर तुम व्यस्त हो तो आने की ज़रूरत नहीं है।
I don't have to work tomorrow.||明日は働かなくていいです。|मुझे कल काम नहीं करना है।
We didn't have to wait long.||私たちは長く待つ必要はありませんでした।|हमें ज़्यादा इंतज़ार नहीं करना पड़ा।
He had to wait an hour.||彼は一時間待たなければなりませんでした।|उसे एक घंटे इंतज़ार करना पड़ा।
She had to take a taxi.||彼女はタクシーに乗らなければなりませんでした।|उसे टैक्सी लेनी पड़ी।
You must be quiet in the library.||図書館では静かにしなければなりません।|पुस्तकालय में चुप रहना ज़रूरी है।
We must respect our parents.||私たちは両親を敬わなければなりません।|हमें अपने माता-पिता का सम्मान करना चाहिए।
Students must do their homework.||生徒は宿題をしなければなりません।|विद्यार्थियों को होमवर्क करना ज़रूरी है।
Passengers must fasten their belts.||乗客はベルトを締めなければなりません।|यात्रियों को बेल्ट बाँधना ज़रूरी है।
You must not tell anyone.||誰にも言ってはいけません।|तुम्हें किसी को नहीं बताना चाहिए।
I have to study for the exam.||試験のために勉強しなければなりません।|मुझे परीक्षा के लिए पढ़ना है।
She has to cook dinner.||彼女は夕食を作らなければなりません।|उसे रात का खाना बनाना है।
They have to clean their room.||彼らは部屋を掃除しなければなりません।|उन्हें अपना कमरा साफ़ करना है।
Do we have to sign here?||ここにサインしなければなりませんか।|क्या हमें यहाँ हस्ताक्षर करना है?
You don't have to bring anything.||何も持って来なくていいです。|तुम्हें कुछ लाने की ज़रूरत नहीं है।
I must remember this.||これを覚えなければなりません।|मुझे यह याद रखना है।
Everyone must follow the rules.||みんな規則に従わなければなりません।|सबको नियमों का पालन करना चाहिए।
You must be here at nine.||九時にはここにいなければなりません।|तुम्हें नौ बजे यहाँ होना चाहिए।"""),
        eg("eg18", "should — advice", "should（助言）", "A2",
            "USAGE: 'should' gives advice, suggestions and opinions — what is a good idea to do.\\nWHEN: Use it to recommend (You should rest), to say what is right (We should be honest), and to ask for advice (What should I do?).\\nFORM: should + base verb, same for all persons. Negative: shouldn't. Question: Should I...?\\nTIP: 'should' is softer than 'must' — it is advice, not an order.",
            "उपयोग: 'should' सलाह, सुझाव और राय देता है — क्या करना अच्छा रहेगा।\\nकब: सिफ़ारिश के लिए (तुम्हें आराम करना चाहिए), सही बात बताने के लिए, और सलाह पूछने के लिए (मुझे क्या करना चाहिए?)।\\nरूप: should + क्रिया का मूल रूप, सभी कर्ताओं के लिए एक जैसा। नकारात्मक: shouldn't। प्रश्न: Should I...?\\nटिप: 'should' 'must' से नरम है — यह आदेश नहीं, सलाह है।",
            """You should rest.||休むべきです。|तुम्हें आराम करना चाहिए।
You should drink more water.||もっと水を飲むべきです।|तुम्हें और पानी पीना चाहिए।
He should apologize.||彼は謝るべきです।|उसे माफ़ी माँगनी चाहिए।
She should eat healthier food.||彼女はもっと健康的な食べ物を食べるべきです।|उसे स्वस्थ भोजन खाना चाहिए।
We should leave early.||早く出発すべきです।|हमें जल्दी निकलना चाहिए।
They should see that movie.||彼らはその映画を見るべきです।|उन्हें वह फ़िल्म देखनी चाहिए।
I should call my mother.||母に電話すべきです।|मुझे अपनी माँ को फ़ोन करना चाहिए।
You shouldn't worry so much.||そんなに心配すべきではありません。|तुम्हें इतनी चिंता नहीं करनी चाहिए।
He shouldn't drive so fast.||彼はそんなに速く運転すべきではありません।|उसे इतनी तेज़ गाड़ी नहीं चलानी चाहिए।
We shouldn't waste food.||食べ物を無駄にすべきではありません।|हमें खाना बर्बाद नहीं करना चाहिए।
They shouldn't be late.||彼らは遅れるべきではありません।|उन्हें देर नहीं करनी चाहिए।
Should I wear a jacket?||ジャケットを着るべきですか。|क्या मुझे जैकेट पहननी चाहिए?
What should we do now?||今何をすべきですか。|अब हमें क्या करना चाहिए?
You should try the local food.||地元の料理を試すべきです。|तुम्हें स्थानीय खाना ज़रूर आज़माना चाहिए।
I think you should take the job.||その仕事を引き受けるべきだと思います。|मुझे लगता है तुम्हें नौकरी ले लेनी चाहिए।
Students should do their homework.||生徒は宿題をすべきです।|विद्यार्थियों को होमवर्क करना चाहिए।
We should save money.||お金を貯めるべきです।|हमें पैसे बचाने चाहिए।
She should study harder.||彼女はもっと真剣に勉強すべきです।|उसे और मेहनत से पढ़ना चाहिए।
He should see a dentist.||彼は歯医者に行くべきです।|उसे दंत चिकित्सक के पास जाना चाहिए।
You should wear a helmet.||ヘルメットをかぶるべきです।|तुम्हें हेलमेट पहनना चाहिए।
I should go to bed early.||早く寝るべきです।|मुझे जल्दी सो जाना चाहिए।
We shouldn't talk in the library.||図書館で話すべきではありません।|हमें पुस्तकालय में बात नहीं करनी चाहिए।
Should we call him now?||今彼に電話すべきですか।|क्या हमें अभी उसे फ़ोन करना चाहिए?
Where should I put this?||これはどこに置くべきですか।|मुझे यह कहाँ रखना चाहिए?
You should check the weather.||天気を確認すべきです।|तुम्हें मौसम जाँचना चाहिए।
They should arrive on time.||彼らは時間どおりに着くべきです।|उन्हें समय पर पहुँचना चाहिए।
She should bring an umbrella.||彼女は傘を持ってくるべきです।|उसे छाता लाना चाहिए।
You should apologize to her.||彼女に謝るべきです।|तुम्हें उससे माफ़ी माँगनी चाहिए।
He should stop smoking.||彼はタバコをやめるべきです।|उसे धूम्रपान छोड़ देना चाहिए।
We should be kind to animals.||動物に優しくすべきです।|हमें जानवरों पर दया करनी चाहिए।"""),

        eg("eg19", "would — polite requests & past habits", "would（丁寧な依頼・過去の習慣）", "B1",
            "USAGE: 'would' makes requests, invitations and offers polite, and describes repeated actions in the past.\\nWHEN: 'Would you like...?' is a polite offer; 'I would like' is a polite want; 'Would you...?' is a polite request. In the past, 'would often' describes habits: When I was a child, I would often visit my grandmother.\\nFORM: would + base verb. Short form: I'd, you'd, he'd, she'd, we'd, they'd. Negative: wouldn't.\\nTIP: 'Would you like some tea?' is more polite than 'Do you want some tea?'",
            "उपयोग: 'would' अनुरोध, निमंत्रण और प्रस्ताव को विनम्र बनाता है, और भूतकाल की आदतों को बताता है।\\nकब: 'Would you like...?' विनम्र प्रस्ताव है; 'I would like' विनम्र इच्छा; 'Would you...?' विनम्र अनुरोध। भूतकाल में 'would often' = बार-बार होने वाली आदतें।\\nरूप: would + क्रिया का मूल रूप। संक्षिप्त: I'd, you'd... नकारात्मक: wouldn't।\\nटिप: 'Would you like some tea?' 'Do you want some tea?' से अधिक विनम्र है।",
            """Would you like some tea?||お茶はいかがですか。|क्या आप चाय लेंगे?
Would you like some coffee?||コーヒーはいかがですか।|क्या आप कॉफ़ी लेंगे?
I would like a cup of coffee.||コーヒーを一杯お願いします।|मैं एक कप कॉफ़ी लेना चाहूँगा।
She would like to join us.||彼女は私たちに加わりたいと思っています।|वह हमारे साथ जुड़ना चाहेगी।
Would you like to dance?||踊りませんか。|क्या आप नृत्य करना चाहेंगे?
Would you open the window, please?||窓を開けていただけますか。|कृपया क्या आप खिड़की खोलेंगे?
Would you help me with this?||これを手伝っていただけますか।|क्या आप इसमें मेरी मदद करेंगे?
Would you mind closing the door?||ドアを閉めていただけますか।|क्या आप दरवाज़ा बंद करेंगे?
I would like to book a room.||部屋を予約したいのですが।|मैं एक कमरा बुक करना चाहूँगा।
He said he would come.||彼は来ると言いました।|उसने कहा वह आएगा।
She told me she would call.||彼女は電話すると言いました।|उसने कहा वह फ़ोन करेगी।
I wouldn't do that if I were you.||私ならそんなことはしません。|अगर मैं तुम होता तो ऐसा नहीं करता।
When I was young, I would play outside.||子供の頃、外でよく遊んだものです।|जब मैं छोटा था, मैं बाहर खेलता था।
He would often sing in the shower.||彼はシャワー中によく歌ったものです।|वह अक्सर नहाते समय गाता था।
We would visit them every summer.||私たちは毎年夏に彼らを訪ねたものです।|हम हर गर्मी उनसे मिलने जाते थे।
Would you be free tomorrow?||明日はご都合はいかがですか।|क्या आप कल खाली होंगे?
I would prefer to walk.||歩きたいです。|मैं पैदल चलना पसंद करूँगा।
Would you like anything else?||ほかには何かありますか।|क्या आपको और कुछ चाहिए?
What would you like to drink?||何を飲みたいですか।|आप क्या पीना चाहेंगे?
I would love to visit Japan.||日本を訪れたいです।|मैं जापान जाना बहुत चाहूँगा।
She would never lie to me.||彼女は私に決して嘘をつかないだろう।|वह मुझसे कभी झूठ नहीं बोलेगी।
They would help if they could.||できれば彼らは助けるだろう।|अगर वे कर सकते तो मदद करते।
Would it be okay if I left early?||早退してもよろしいですか।|क्या मैं जल्दी जाऊँ तो ठीक रहेगा?
I would rather stay home.||むしろ家にいたいです।|मैं घर पर रहना पसंद करूँगा।
He would always tell funny stories.||彼はいつも面白い話をしたものです।|वह हमेशा मज़ेदार कहानियाँ सुनाता था।
We would have dinner at seven.||私たちは七時に夕食をとったものです।|हम सात बजे खाना खाते थे।
Would you like me to help?||手伝いましょうか।|क्या आप चाहेंगे कि मैं मदद करूँ?
I would like to thank you.||お礼を申し上げたいです।|मैं आपका धन्यवाद करना चाहूँगा।
Would you recommend this hotel?||このホテルをおすすめしますか।|क्या आप इस होटल की सिफ़ारिश करेंगे?
That would be wonderful.||それは素晴らしいでしょう。|वह बहुत अच्छा होगा।"""),
        eg("eg20", "imaginary situations — 'If I were...'", "仮定法（If I were...）", "B1",
            "USAGE: we use the subjunctive 'were' for imaginary, unreal or hypothetical situations.\\nWHEN: 'If I were you...' introduces advice; 'If I were rich...' is an unreal wish; 'I wish I were...' expresses regret. With 'were' we use it for ALL subjects — I, he, she, it, we, they.\\nFORM: If + subject + were + noun/adjective, subject + would + base verb. e.g. If I were you, I would rest.\\nTIP: 'If I was' is common informally, but 'If I were' is the correct unreal form and is what exams expect.",
            "उपयोग: काल्पनिक, अवास्तविक या परिकल्पित स्थितियों के लिए 'were' का प्रयोग।\\nकब: 'If I were you' = सलाह; 'If I were rich' = अवास्तविक इच्छा; 'I wish I were' = अफ़सोस। सभी कर्ताओं के साथ 'were'।\\nरूप: If + कर्ता + were + संज्ञा/विशेषण, कर्ता + would + क्रिया।\\nटिप: अनौपचारिक में 'If I was' चलता है, पर सही काल्पनिक रूप 'If I were' है।",
            """If I were you, I would rest.||私なら休むでしょう।|अगर मैं तुम होता तो आराम करता।
If I were rich, I would travel the world.||私が金持ちなら、世界を旅するでしょう।|अगर मैं अमीर होता तो दुनिया घूमता।
If I were a bird, I would fly high.||私が鳥なら、高く飛ぶでしょう।|अगर मैं पक्षी होता तो ऊँचा उड़ता।
If I were you, I would apologize.||私なら謝るでしょう।|अगर मैं तुम होता तो माफ़ी माँगता।
I wish I were taller.||もっと背が高ければいいのに।|काश मैं लंबा होता।
I wish I were at the beach now.||今海にいればいいのに।|काश मैं अभी समुद्र तट पर होता।
If he were here, he would help us.||彼がここにいれば、助けてくれるでしょう।|अगर वह यहाँ होता तो हमारी मदद करता।
If she were the boss, things would change.||彼女が上司なら、状況は変わるでしょう।|अगर वह बॉस होती तो हालात बदल जाते।
If it were sunny, we would go out.||晴れなら、出かけるでしょう।|अगर धूप होती तो हम बाहर जाते।
If I were a doctor, I would help people.||私が医者なら、人を助けるでしょう।|अगर मैं डॉक्टर होता तो लोगों की मदद करता।
If we were rich, we would buy a house.||私たちが金持ちなら、家を買うでしょう।|अगर हम अमीर होते तो घर खरीदते।
If they were here, they would enjoy it.||彼らがここにいれば、楽しむでしょう।|अगर वे यहाँ होते तो मज़ा आता।
I wish I were good at math.||数学が得意ならいいのに。|काश मुझे गणित अच्छी आती।
If I were you, I wouldn't worry.||私なら心配しないでしょう।|अगर मैं तुम होता तो चिंता नहीं करता।
If he were smarter, he would pass.||彼がもっと賢ければ、合格するでしょう।|अगर वह और समझदार होता तो पास हो जाता।
Suppose you were the president, what would you do?||もしあなたが大統領なら、何をしますか।|मान लो तुम राष्ट्रपति होते तो क्या करते?
If I were in your shoes, I would quit.||あなたの立場なら、辞めるでしょう।|अगर मैं तुम्हारी जगह होता तो छोड़ देता।
I wish it were summer all year.||一年中夏ならいいのに।|काश साल भर गर्मी रहती।
If the price were lower, I would buy it.||値段が安ければ、買うでしょう।|अगर दाम कम होता तो मैं खरीदता।
If I were younger, I would learn to sing.||若ければ、歌を習うでしょう।|अगर मैं जवान होता तो गाना सीखता।
If there were more time, we could rest.||時間がもっとあれば、休めるでしょう।|अगर और समय होता तो हम आराम कर सकते थे।
I wish I were not so tired.||こんなに疲れていなければいいのに।|काश मैं इतना थका न होता।
If she were here, she would laugh.||彼女がここにいれば、笑うでしょう।|अगर वह यहाँ होती तो हँसती।
If I were famous, people would know me.||私が有名人なら、みんなが知るでしょう।|अगर मैं मशहूर होता तो लोग मुझे पहचानते।
If it were colder, we would need coats.||もっと寒ければ、コートが必要でしょう।|अगर और ठंड होती तो हमें कोट चाहिए होते।
He acts as if he were the king.||彼は自分が王であるかのように振る舞います।|वह ऐसा करता है जैसे वह राजा हो।
If I were an artist, I would paint.||私が画家なら、絵を描くでしょう।|अगर मैं कलाकार होता तो पेंटिंग बनाता।
I wish I were with my family.||家族と一緒にいればいいのに।|काश मैं अपने परिवार के साथ होता।
If you were me, what would you say?||あなたが私なら、何と言いますか।|अगर तुम मैं होते तो क्या कहते?
If I were a millionaire, I would donate.||私が大金持ちなら、寄付するでしょう।|अगर मैं करोड़पति होता तो दान करता।"""),

        eg("eg21", "conditionals — if... then...", "条件文（if）", "B1",
            "USAGE: conditionals join a condition (if...) with a result. There are three common types: zero, first and second.\\nWHEN: Zero = always-true facts (If you heat water, it boils). First = real future possibility (If it rains, I will stay home). Second = unreal or hypothetical (If I had money, I would travel).\\nFORM: if + present, present | if + present, will + verb | if + past, would + verb.\\nTIP: the if-clause can come first or last. When it comes first, put a comma after it.",
            "उपयोग: सशर्त वाक्य एक शर्त (if...) और उसके परिणाम को जोड़ते हैं। तीन मुख्य प्रकार: zero, first, second।\\nकब: Zero = सदा सत्य तथ्य (गर्म करने पर पानी उबलता है)। First = वास्तविक भविष्य की संभावना (बारिश हुई तो घर रहूँगा)। Second = अवास्तविक/काल्पनिक (पैसे होते तो यात्रा करता)।\\nरूप: if + वर्तमान, वर्तमान | if + वर्तमान, will + क्रिया | if + भूतकाल, would + क्रिया।\\nटिप: if-उपवाक्य आगे या पीछे आ सकता है; आगे आने पर उसके बाद अल्पविराम लगाएँ।",
            """If you heat water, it boils.||水を熱すると沸騰します।|अगर आप पानी गर्म करें तो वह उबलता है।
If you freeze water, it becomes ice.||水を凍らせると氷になります।|अगर पानी जमाएँ तो वह बर्फ़ बन जाता है।
If it rains, I will stay home.||雨が降ったら、家にいます।|अगर बारिश हुई तो मैं घर पर रहूँगा।
If you study hard, you will pass.||一生懸命勉強すれば、合格します。|अगर तुम मेहनत से पढ़ोगे तो पास हो जाओगे।
If we miss the train, we will be late.||電車を逃したら、遅れます।|अगर हम ट्रेन चूक गए तो देर हो जाएगी।
If she calls, tell her I'm busy.||彼女が電話してきたら、忙しいと伝えてください।|अगर वह फ़ोन करे तो उसे बताना कि मैं व्यस्त हूँ।
If you eat too much, you will feel sick.||食べ過ぎると気分が悪くなります।|अगर तुम बहुत खाओगे तो बीमार महसूस करोगे।
If I had money, I would travel.||お金があれば、旅行するでしょう।|अगर मेरे पास पैसे होते तो मैं यात्रा करता।
If I had a car, I would drive to work.||車があれば、車で通勤するでしょう।|अगर मेरे पास गाड़ी होती तो मैं काम पर गाड़ी चला कर जाता।
If she had time, she would help.||彼女に時間があれば、手伝うでしょう।|अगर उसके पास समय होता तो वह मदद करती।
If we won the lottery, we would buy a house.||宝くじに当たれば、家を買うでしょう।|अगर हम लॉटरी जीतते तो घर खरीदते।
If I were you, I would see a doctor.||私なら医者に行くでしょう।|अगर मैं तुम होता तो डॉक्टर से मिलता।
If you don't hurry, you will miss the bus.||急がないとバスに乗り遅れます।|अगर तुम जल्दी नहीं करोगे तो बस छूट जाएगी।
If it snows, we will make a snowman.||雪が降ったら、雪だるまを作ります।|अगर बर्फ़ गिरी तो हम स्नोमैन बनाएँगे।
If I have time, I will visit you.||時間があれば、あなたを訪ねます।|अगर मेरे पास समय होगा तो मैं तुमसे मिलने आऊँगा।
If you press this button, the machine stops.||このボタンを押すと、機械が止まります।|यह बटन दबाओ तो मशीन रुक जाती है।
If we leave now, we will catch the train.||今出発すれば、電車に間に合います।|अगर हम अभी निकले तो ट्रेन पकड़ लेंगे।
If he practiced, he would play well.||彼が練習すれば、上手に弾くでしょう।|अगर वह अभ्यास करता तो अच्छा खेलता।
If you mix red and white, you get pink.||赤と白を混ぜるとピンクになります।|लाल और सफ़ेद मिलाओ तो गुलाबी बनता है।
If I felt better, I would come.||気分がよければ、来るでしょう।|अगर मैं अच्छा महसूस करता तो आता।
If it is sunny tomorrow, we will go to the park.||明日晴れなら、公園に行きます।|अगर कल धूप निकली तो हम पार्क जाएँगे।
If you touch fire, you get burned.||火に触れるとやけどします।|आग छुओगे तो जल जाओगे।
If she won, she would be happy.||彼女が勝てば、幸せになるでしょう।|अगर वह जीतती तो खुश होती।
If I had wings, I would fly.||翼があれば、飛ぶでしょう।|अगर मेरे पंख होते तो मैं उड़ता।
If you don't sleep, you will be tired.||眠らなければ、疲れます।|अगर तुम सोओगे नहीं तो थक जाओगे।
If we work together, we can finish.||一緒に働けば、終わらせられます。|अगर हम साथ मिलकर काम करें तो खत्म कर सकते हैं।
If I knew the answer, I would tell you.||答えを知っていれば、教えるでしょう।|अगर मुझे उत्तर पता होता तो बता देता।
If it doesn't rain, the game will go on.||雨が降らなければ、試合は続きます।|अगर बारिश न हुई तो खेल जारी रहेगा।
If you are hungry, have some bread.||お腹が空いていたら、パンを食べてください।|अगर तुम भूखे हो तो रोटी खा लो।
If they come early, we will start.||彼らが早く来れば、始めます।|अगर वे जल्दी आएँ तो हम शुरू करेंगे।"""),
        eg("eg22", "prepositions of place — in / on / at / under / above...", "場所の前置詞", "A1",
            "USAGE: prepositions of place say where something or someone is.\\nWHEN: 'in' = inside a space (in the room); 'on' = on a surface (on the table); 'at' = a specific point (at the station); 'under' = below; 'above' = higher than; 'next to' = beside; 'between' = with one thing on each side.\\nFORM: subject + verb + preposition + place. e.g. The cat is on the sofa.\\nTIP: we say 'in the bed' (inside the covers) but 'on the bed' (on top of it).",
            "उपयोग: स्थान की पूर्वसर्ग बताते हैं कि कोई चीज़ कहाँ है।\\nकब: 'in' = स्थान के अंदर; 'on' = सतह पर; 'at' = विशेष बिंदु पर; 'under' = नीचे; 'above' = ऊपर; 'next to' = बगल में; 'between' = दोनों के बीच।\\nरूप: कर्ता + क्रिया + पूर्वसर्ग + स्थान।\\nटिप: 'in the bed' (रज़ाई के अंदर) बनाम 'on the bed' (ऊपर)।",
            """The cat is on the sofa.||猫はソファの上にいます।|बिल्ली सोफ़े पर है।
The book is on the table.||本はテーブルの上にあります।|किताब मेज़ पर है।
The keys are in my bag.||鍵は私のかばんの中にあります।|चाबियाँ मेरे बैग में हैं।
She lives in Tokyo.||彼女は東京に住んでいます।|वह टोक्यो में रहती है।
He is at the station.||彼は駅にいます।|वह स्टेशन पर है।
They are at the bus stop.||彼らはバス停にいます।|वे बस स्टॉप पर हैं।
The ball is under the chair.||ボールは椅子の下にあります।|गेंद कुर्सी के नीचे है।
The picture is above the sofa.||絵はソファの上に掛かっています।|तस्वीर सोफ़े के ऊपर है।
The school is next to the park.||学校は公園の隣にあります।|स्कूल पार्क के बगल में है।
The bank is between the shop and the cafe.||銀行は店とカフェの間にあります।|बैंक दुकान और कैफ़े के बीच है।
The lamp is on the desk.||ランプは机の上にあります।|लैंप मेज़ पर है。
The dog is in the garden.||犬は庭にいます।|कुत्ता बगीचे में है।
The cup is near the window.||コップは窓の近くにあります।|प्याला खिड़की के पास है।
My phone is in my pocket.||私の電話はポケットの中にあります।|मेरा फ़ोन जेब में है।
She is standing at the door.||彼女はドアのところに立っています।|वह दरवाज़े पर खड़ी है।
The birds are above the trees.||鳥は木の上を飛んでいます।|पक्षी पेड़ों के ऊपर हैं।
The cat is under the bed.||猫はベッドの下にいます।|बिल्ली बिस्तर के नीचे है।
We met at the cafe.||私たちはカフェで会いました।|हम कैफ़े में मिले।
The supermarket is on this street.||スーパーはこの通りにあります।|सुपरमार्केट इसी गली में है।
There is a mirror on the wall.||壁に鏡があります।|दीवार पर आईना है।
The river flows through the city.||川は街を通って流れています।|नदी शहर से होकर बहती है।
He lives near the station.||彼は駅の近くに住んでいます।|वह स्टेशन के पास रहता है।
The box is behind the door.||箱はドアの後ろにあります।|डिब्बा दरवाज़े के पीछे है।
She sat in front of the TV.||彼女はテレビの前に座りました।|वह टीवी के सामने बैठी।
The shoes are in the cupboard.||靴は戸棚の中にあります।|जूते अलमारी में हैं।
There is a park across the road.||道の向かいに公園があります।|सड़क के उस पार एक पार्क है।
The restaurant is on the corner.||レストランは角にあります।|रेस्तराँ कोने पर है।
He put the money in his wallet.||彼は財布にお金を入れました।|उसने पैसे बटुए में रखे।
The children are playing in the park.||子どもたちは公園で遊んでいます।|बच्चे पार्क में खेल रहे हैं।
Your keys are on the counter.||あなたの鍵はカウンターの上にあります।|तुम्हारी चाबियाँ काउंटर पर हैं।"""),

        eg("eg23", "prepositions of time — at / on / in / for / since", "時間の前置詞", "A1",
            "USAGE: prepositions of time say WHEN something happens.\\nWHEN: 'at' + clock times (at 6 o'clock); 'on' + days and dates (on Monday, on 5 May); 'in' + months, years and seasons (in July, in 2020, in summer); 'for' + duration (for two hours); 'since' + a starting point (since 2020).\\nFORM: at / on / in / for / since + time word.\\nTIP: use NO preposition before today, tomorrow, yesterday, this week, next year, last month.",
            "उपयोग: समय की पूर्वसर्ग बताते हैं कि कोई काम कब होता है।\\nकब: 'at' + घड़ी का समय; 'on' + दिन और तारीख़; 'in' + महीना, साल, मौसम; 'for' + अवधि; 'since' + आरंभ बिंदु।\\nरूप: at / on / in / for / since + समय शब्द।\\nटिप: today, tomorrow, yesterday, this week, next year के पहले कोई पूर्वसर्ग नहीं लगता।",
            """I wake up at 6 o'clock.||私は六時に起きます。|मैं छह बजे उठता हूँ।
The meeting is at 3 pm.||会議は午後三時です。|मीटिंग दोपहर तीन बजे है।
We eat lunch at noon.||私たちは正午に昼食を食べます।|हम दोपहर में खाना खाते हैं।
She goes to bed at night.||彼女は夜に寝ます।|वह रात को सोती है।
The class starts on Monday.||授業は月曜日に始まります।|कक्षा सोमवार को शुरू होती है।
My birthday is on 5 May.||私の誕生日は五月五日です।|मेरा जन्मदिन पाँच मई को है।
We go shopping on Saturday.||私たちは土曜日に買い物に行きます।|हम शनिवार को खरीदारी जाते हैं।
I was born in July.||私は七月生まれです।|मेरा जन्म जुलाई में हुआ।
They moved here in 2020.||彼らは二〇二〇年にここに引っ越しました।|वे 2020 में यहाँ आए।
The flowers bloom in spring.||花は春に咲きます।|फूल वसंत में खिलते हैं।
We go to the beach in summer.||私たちは夏に海へ行きます।|हम गर्मी में समुद्र तट जाते हैं。
It often rains in October.||十月にはよく雨が降ります।|अक्टूबर में अक्सर बारिश होती है।
She studied for two hours.||彼女は二時間勉強しました।|उसने दो घंटे पढ़ाई की।
We waited for an hour.||私たちは一時間待ちました।|हमने एक घंटे इंतज़ार किया।
I have lived here since 2019.||私は二〇一九年からここに住んでいます।|मैं 2019 से यहाँ रह रहा हूँ।
He has worked here since March.||彼は三月からここで働いています।|वह मार्च से यहाँ काम कर रहा है।
She has been sick since Monday.||彼女は月曜日から病気です।|वह सोमवार से बीमार है।
We have known each other since childhood.||私たちは子供の頃から知り合いです।|हम बचपन से एक-दूसरे को जानते हैं।
The store opens at nine.||店は九時に開きます।|दुकान नौ बजे खुलती है।
I will call you on Friday.||金曜日に電話します।|मैं शुक्रवार को फ़ोन करूँगा।
They arrived in the morning.||彼らは朝に着きました।|वे सुबह पहुँचे।
We watch TV in the evening.||私たちは夕方にテレビを見ます।|हम शाम को टीवी देखते हैं।
The baby sleeps at night.||赤ちゃんは夜に寝ます।|बच्चा रात को सोता है।
She was born on a Sunday.||彼女は日曜日に生まれました।|वह रविवार को पैदा हुई।
The train leaves at 7:30.||電車は七時半に出発します।|ट्रेन साढ़े सात बजे निकलती है।
We stayed there for a week.||私たちは一週間そこにいました।|हम एक हफ्ते वहाँ रहे।
I haven't seen him since last year.||昨年から彼に会っていません।|मैंने उसे पिछले साल से नहीं देखा।
The party is on New Year's Eve.||パーティーは大晦日にあります।|पार्टी नए साल की पूर्व संध्या पर है।
He drinks coffee in the afternoon.||彼は午後にコーヒーを飲みます।|वह दोपहर में कॉफ़ी पीता है।
We go on holiday in August.||私たちは八月に休暇に行きます।|हम अगस्त में छुट्टी पर जाते हैं।"""),
        eg("eg24", "prepositions of movement — to / into / through / across...", "移動の前置詞", "A2",
            "USAGE: prepositions of movement show direction or motion from one place to another.\\nWHEN: 'to' = towards a place; 'into' = entering; 'out of' = leaving; 'through' = from one side to the other; 'across' = to the other side of a surface; 'along' = following a line; 'up' / 'down'; 'over' / 'under'.\\nFORM: verb of movement + preposition + place. e.g. She walked into the room.\\nTIP: say 'arrive at/in' but 'get to'. Say 'arrive home' with no preposition.",
            "उपयोग: गति की पूर्वसर्ग दिशा या एक स्थान से दूसरे स्थान की गति बताते हैं।\\nकब: 'to' = की ओर; 'into' = के अंदर प्रवेश; 'out of' = बाहर निकलना; 'through' = आर-पार; 'across' = पार; 'along' = किनारे-किनारे; 'up' / 'down'; 'over' / 'under'।\\nरूप: गति क्रिया + पूर्वसर्ग + स्थान।\\nटिप: 'arrive at/in' लेकिन 'get to'; 'arrive home' बिना पूर्वसर्ग।",
            """She walked into the room.||彼女は部屋に入りました।|वह कमरे में चली गई।
He ran out of the house.||彼は家から飛び出しました।|वह घर से बाहर भागा।
We went to the station.||私たちは駅へ行きました।|हम स्टेशन गए।
The train goes through the tunnel.||電車はトンネルを通ります।|ट्रेन सुरंग से होकर जाती है।
They swam across the river.||彼らは川を泳いで渡りました।|वे नदी तैरकर पार कर गए।
We walked along the beach.||私たちは浜辺を歩きました।|हम समुद्र तट के किनारे चले।
She climbed up the stairs.||彼女は階段を上りました।|वह सीढ़ियाँ चढ़ी।
He came down the hill.||彼は丘を下りてきました।|वह पहाड़ी से नीचे आया।
The bird flew over the house.||鳥は家の上を飛びました।|पक्षी घर के ऊपर से उड़ा।
The dog jumped over the fence.||犬は柵を跳び越えました।|कुत्ता बाड़े के ऊपर कूद गया।
She fell under the table.||彼女はテーブルの下に落ちました।|वह मेज़ के नीचे गिर गई।
We drove to the airport.||私たちは空港へ車で行きました।|हम हवाई अड्डे गाड़ी से गए।
He threw the ball into the basket.||彼はボールをかごに投げ入れました।|उसने गेंद टोकरी में फेंकी।
The cat jumped onto the table.||猫はテーブルの上に跳びました।|बिल्ली मेज़ पर कूद गई।
They walked through the park.||彼らは公園を通り抜けました।|वे पार्क से होकर गुज़रे।
She moved to a new city.||彼女は新しい街に引っ越しました।|वह नए शहर में चली गई।
He drove along the river.||彼は川沿いを運転しました।|वह नदी के किनारे गाड़ी चलाता रहा।
The plane flew across the ocean.||飛行機は海を渡って飛びました।|हवाई जहाज़ समुद्र पार उड़ा।
Come into the kitchen.||台所に入ってきてください।|रसोई में आओ।
She stepped out of the car.||彼女は車から降りました।|वह कार से बाहर निकली।
We ran to the bus stop.||私たちはバス停まで走りました।|हम बस स्टॉप तक भागे।
The ball rolled under the sofa.||ボールはソファの下に転がりました।|गेंद सोफ़े के नीचे लुढ़क गई।
He fell off the bike.||彼は自転車から落ちました।|वह साइकिल से गिर गया।
They walked toward the beach.||彼らは浜辺に向かって歩きました।|वे समुद्र तट की ओर चले।
She pushed the box across the floor.||彼女は箱を床の向こうへ押しました।|उसने डिब्बा फर्श पर धकेला।
The river flows into the sea.||川は海に流れ込みます।|नदी समुद्र में मिलती है।
We climbed to the top of the mountain.||私たちは山の頂上まで登りました।|हम पहाड़ की चोटी तक चढ़े।
He jumped into the pool.||彼はプールに飛び込みました।|वह पूल में कूद गया।
The bus goes through the city center.||バスは市内を通ります।|बस शहर के केंद्र से होकर जाती है।
She ran across the street.||彼女は通りを走って渡りました।|वह सड़क पार भागी।"""),

        eg("eg25", "a / an / the — articles", "冠詞（a / an / the）", "A1",
            "USAGE: 'a' and 'an' introduce one thing that is new or not specific; 'the' points to something specific or already known.\\nWHEN: 'a' before consonant sounds (a book), 'an' before vowel sounds (an apple). 'the' when both speaker and listener know which one (the sun, the door). We use 'a/an' only with singular countable nouns.\\nFORM: a / an + singular noun; the + singular or plural noun.\\nTIP: 'an' depends on the SOUND, not the letter: an hour (silent h), a university (yu sound).",
            "उपयोग: 'a'/'an' किसी नई या अनिश्चित चीज़ का परिचय देते हैं; 'the' किसी विशेष या ज्ञात चीज़ की ओर इशारा करता है।\\nकब: 'a' व्यंजन ध्वनि से पहले (a book), 'an' स्वर ध्वनि से पहले (an apple)। 'the' जब दोनों जानते हों कि कौन-सी चीज़।\\nरूप: a / an + एकवचन संज्ञा; the + एकवचन या बहुवचन संज्ञा।\\nटिप: 'an' अक्षर से नहीं, ध्वनि से तय होता है: an hour, a university।",
            """I have a car.||私は車を持っています。|मेरे पास एक कार है।
She bought a dress.||彼女はドレスを買いました।|उसने एक ड्रेस खरीदी।
He is a teacher.||彼は教師です।|वह एक शिक्षक है।
We saw an elephant at the zoo.||動物園でゾウを見ました।|हमने चिड़ियाघर में एक हाथी देखा।
She ate an orange.||彼女はオレンジを食べました।|उसने एक संतरा खाया।
It is an interesting book.||それは面白い本です।|यह एक दिलचस्प किताब है।
I waited an hour.||私は一時間待ちました।|मैंने एक घंटा इंतज़ार किया।
He works in an office.||彼は事務所で働いています।|वह एक कार्यालय में काम करता है।
The sun is bright today.||今日は太陽が明るいです।|आज सूरज तेज़ है।
The moon is beautiful.||月は美しいです।|चाँद सुंदर है।
Please close the door.||ドアを閉めてください।|कृपया दरवाज़ा बंद करो।
Where is the station?||駅はどこですか।|स्टेशन कहाँ है?
The cat is under the table.||猫はテーブルの下にいます।|बिल्ली मेज़ के नीचे है।
I met a man at the party.||パーティーで男性に会いました।|मैं पार्टी में एक आदमी से मिला।
The man was very kind.||その男性はとても親切でした।|वह आदमी बहुत दयालु था।
She plays the piano.||彼女はピアノを弾きます।|वह पियानो बजाती है।
He went to the market.||彼は市場へ行きました।|वह बाज़ार गया।
I need an umbrella.||傘が必要です।|मुझे एक छाता चाहिए।
The children are in the garden.||子どもたちは庭にいます।|बच्चे बगीचे में हैं।
We live in a small town.||私たちは小さな町に住んでいます।|हम एक छोटे शहर में रहते हैं।
The town is very quiet.||その町はとても静かです।|वह शहर बहुत शांत है।
She has a dog and a cat.||彼女は犬と猫を飼っています।|उसके पास एक कुत्ता और एक बिल्ली है।
The dog is black.||その犬は黒いです।|वह कुत्ता काला है。
He bought a new phone.||彼は新しい携帯を買いました।|उसने एक नया फ़ोन खरीदा।
The phone was expensive.||その携帯は高かったです।|वह फ़ोन महँगा था।
This is an easy question.||これは簡単な質問です।|यह एक आसान सवाल है।
The sky is blue.||空は青いです।|आसमान नीला है।
She is the best student.||彼女は一番の生徒です।|वह सबसे अच्छी छात्रा है।
I read the newspaper every day.||私は毎日新聞を読みます।|मैं हर दिन अख़बार पढ़ता हूँ।
The food at this place is great.||この店の料理は素晴らしいです।|इस जगह का खाना बहुत बढ़िया है।"""),
        eg("eg26", "some / any — a few", "some / any（いくつか）", "A1",
            "USAGE: 'some' and 'any' talk about an indefinite amount or number.\\nWHEN: 'some' in positive sentences (I have some friends) and polite offers/questions (Would you like some tea?). 'any' in negatives (I don't have any) and questions (Do you have any?). We also use 'any' to mean 'it doesn't matter which' (Take any seat).\\nFORM: some/any + countable plural or uncountable noun.\\nTIP: 'Would you like some...?' and 'Can I have some...?' are polite even in question form.",
            "उपयोग: 'some' और 'any' अनिश्चित मात्रा या संख्या बताते हैं।\\nकब: सकारात्मक में 'some' (मेरे कुछ दोस्त हैं); नकारात्मक में 'any' (मेरे पास कोई नहीं); प्रश्न में 'any'। 'any' का अर्थ 'कोई भी' भी होता है (कोई भी सीट लो)।\\nरूप: some/any + बहुवचन या अगणनीय संज्ञा।\\nटिप: 'Would you like some...?' और 'Can I have some...?' प्रश्न होते हुए भी विनम्र हैं।",
            """I have some friends in Tokyo.||東京に友達が何人かいます。|टोक्यो में मेरे कुछ दोस्त हैं।
She has some money.||彼女はお金をいくらか持っています।|उसके पास कुछ पैसे हैं।
We need some milk.||牛乳が少し必要です।|हमें कुछ दूध चाहिए।
There are some apples on the table.||テーブルの上にりんごがいくつかあります।|मेज़ पर कुछ सेब हैं।
I don't have any money.||私はお金がありません।|मेरे पास कोई पैसे नहीं हैं।
She doesn't have any time.||彼女には時間がありません।|उसके पास समय नहीं है।
We don't have any questions.||質問はありません。|हमारे पास कोई सवाल नहीं है।
Do you have any brothers?||兄弟はいますか।|क्या तुम्हारे कोई भाई हैं?
Do you want any tea?||お茶はいかがですか।|क्या तुम्हें कुछ चाय चाहिए?
Is there any sugar?||砂糖はありますか।|क्या कोई चीनी है?
Would you like some coffee?||コーヒーはいかがですか।|क्या आप कुछ कॉफ़ी लेंगे?
Can I have some water?||水をいただけますか।|क्या मुझे कुछ पानी मिल सकता है?
Take any seat you like.||お好きな席にどうぞ।|जो सीट चाहो ले लो।
You can call me any time.||いつでも電話してください。|तुम मुझे कभी भी फ़ोन कर सकते हो।
Choose any color.||どれでも好きな色を選んでください।|कोई भी रंग चुनो।
There aren't any eggs in the fridge.||冷蔵庫に卵がありません।|फ्रिज में कोई अंडे नहीं हैं।
Do you have any news?||何かニュースはありますか।|क्या कोई ख़बर है?
I ate some rice for lunch.||昼食にご飯を食べました।|मैंने दोपहर में कुछ चावल खाए।
She bought some flowers.||彼女は花を買いました।|उसने कुछ फूल खरीदे।
We saw some birds in the sky.||空に鳥が何羽か見えました।|हमने आसमान में कुछ पक्षी देखे।
Any student can answer this.||どの生徒でもこれに答えられます。|कोई भी विद्यार्थी इसका उत्तर दे सकता है।
I don't want any trouble.||トラブルはごめんです।|मुझे कोई परेशानी नहीं चाहिए।
Is there any bread left?||パンはまだありますか।|क्या कुछ रोटी बची है?
He didn't eat any vegetables.||彼は野菜を全然食べませんでした।|उसने कोई सब्ज़ी नहीं खाई।
We have some good news.||良い知らせがあります。|हमारे पास कुछ अच्छी ख़बर है।
She made some cookies.||彼女はクッキーを焼きました।|उसने कुछ कुकीज़ बनाईं।
Do you have any idea?||何か心当たりはありますか।|क्या तुम्हें कुछ अंदाज़ा है?
There's some juice in the fridge.||冷蔵庫にジュースが少しあります।|फ्रिज में कुछ जूस है।
I need some help.||助けが少し必要です।|मुझे कुछ मदद चाहिए।
Do you have any questions?||何か質問はありますか।|क्या तुम्हारे कोई सवाल हैं?"""),

        eg("eg27", "much / many / a lot of — quantity", "much / many / a lot of（量）", "A1",
            "USAGE: 'much', 'many' and 'a lot of' say how much or how many.\\nWHEN: 'many' with countable plural nouns (many books); 'much' with uncountable nouns (much water); 'a lot of' works with both. 'much'/'many' are most natural in negatives and questions; 'a lot of' is common in positives.\\nFORM: many + plural noun; much + uncountable noun; a lot of + plural or uncountable noun.\\nTIP: in positive sentences we usually say 'a lot of' instead of 'much': I have a lot of work (not I have much work).",
            "उपयोग: 'much', 'many' और 'a lot of' मात्रा बताते हैं।\\nकब: 'many' गिनती की संज्ञाओं के साथ (कई किताबें); 'much' अगणनीय संज्ञाओं के साथ (बहुत पानी); 'a lot of' दोनों के साथ। नकारात्मक और प्रश्न में 'much'/'many' आम हैं।\\nरूप: many + बहुवचन संज्ञा; much + अगणनीय; a lot of + दोनों।\\nटिप: सकारात्मक वाक्यों में 'much' की जगह आमतौर पर 'a lot of' आता है।",
            """How many books do you have?||本を何冊持っていますか।|तुम्हारे पास कितनी किताबें हैं?
How many people came?||何人来ましたか।|कितने लोग आए?
She has many friends.||彼女は友達がたくさんいます।|उसके कई दोस्त हैं।
We saw many birds.||私たちはたくさんの鳥を見ました।|हमने कई पक्षी देखे।
There aren't many chairs.||椅子が多くありません。|ज़्यादा कुर्सियाँ नहीं हैं।
I don't have many questions.||質問は多くありません。|मेरे पास ज़्यादा सवाल नहीं हैं।
How much money do you need?||お金はいくら必要ですか।|तुम्हें कितना पैसा चाहिए?
How much water is there?||水はどのくらいありますか।|कितना पानी है?
I don't have much time.||時間があまりありません।|मेरे पास ज़्यादा समय नहीं है।
She doesn't drink much coffee.||彼女はコーヒーをあまり飲みません।|वह ज़्यादा कॉफ़ी नहीं पीती।
There isn't much sugar left.||砂糖があまり残っていません।|ज़्यादा चीनी नहीं बची है।
He doesn't earn much money.||彼はあまりお金を稼いでいません।|वह ज़्यादा पैसे नहीं कमाता।
I have a lot of homework.||宿題がたくさんあります।|मेरे पास बहुत होमवर्क है।
She has a lot of clothes.||彼女は服をたくさん持っています।|उसके पास बहुत कपड़े हैं।
We need a lot of water.||水がたくさん必要です।|हमें बहुत पानी चाहिए।
There are a lot of cars on the road.||道に車がたくさんあります।|सड़क पर बहुत सारी गाड़ियाँ हैं।
He eats a lot of rice.||彼はご飯をたくさん食べます।|वह बहुत चावल खाता है।
Too much sugar is bad.||砂糖の取りすぎは良くないです।|बहुत ज़्यादा चीनी बुरी है।
Too many people were there.||そこには人が多すぎました।|वहाँ बहुत ज़्यादा लोग थे।
How much is this shirt?||このシャツはいくらですか।|यह शर्ट कितने की है?
How much does it cost?||それはいくらですか।|इसकी कीमत कितनी है?
I don't have much experience.||経験があまりありません।|मेरे पास ज़्यादा अनुभव नहीं है।
We have many things to do.||やることがたくさんあります।|हमारे पास करने को बहुत कुछ है।
How many days will you stay?||何日滞在しますか।|तुम कितने दिन रहोगे?
There are many shops in this street.||この通りには店がたくさんあります।|इस गली में कई दुकानें हैं।
I drank too much coffee.||コーヒーを飲みすぎました।|मैंने बहुत ज़्यादा कॉफ़ी पी।
She spent a lot of money.||彼女はたくさんお金を使いました।|उसने बहुत पैसे खर्च किए।
How much time do we have?||時間はどのくらいありますか।|हमारे पास कितना समय है?
There isn't much milk.||牛乳があまりありません।|ज़्यादा दूध नहीं है।
We had a lot of fun.||私たちはとても楽しかったです।|हमें बहुत मज़ा आया।"""),
        eg("eg28", "comparatives & superlatives — -er / -est / more / most", "比較級・最上級", "A2",
            "USAGE: comparatives compare two things (-er/more); superlatives pick the one out of three or more (-est/most).\\nWHEN: short adjectives take -er/-est (tall → taller → tallest); long adjectives use more/most (beautiful → more beautiful → most beautiful); irregular: good → better → best, bad → worse → worst, far → farther/further → farthest/furthest.\\nFORM: adjective + -er than... | the + adjective + -est | more/most + adjective.\\nTIP: use 'than' after a comparative (taller than), and 'the' before a superlative (the tallest).",
            "उपयोग: तुलनात्मक (-er/more) दो चीज़ों की तुलना करते हैं; अतिशयोक्ति (-est/most) तीन या अधिक में से एक को चुनते हैं।\\nकब: छोटे विशेषण -er/-est लेते हैं (tall → taller → tallest); लंबे विशेषण more/most (beautiful → more beautiful); अनियमित: good → better → best, bad → worse → worst।\\nरूप: विशेषण + -er than... | the + विशेषण + -est | more/most + विशेषण।\\nटिप: तुलनात्मक के बाद 'than', अतिशयोक्ति से पहले 'the'।",
            """This bag is heavier than that one.||このかばんはあれより重いです।|यह बैग उससे भारी है।
My brother is taller than me.||私の兄は私より背が高いです।|मेरा भाई मुझसे लंबा है।
Today is colder than yesterday.||今日は昨日より寒いです।|आज कल से ठंडा है।
This movie is better than that one.||この映画はあれより良いです।|यह फ़िल्म उससे बेहतर है।
Her room is cleaner than mine.||彼女の部屋は私のよりきれいです।|उसका कमरा मेरे से साफ़ है।
The train is faster than the bus.||電車はバスより速いです।|ट्रेन बस से तेज़ है।
He is more careful than his friend.||彼は友達より注意深いです।|वह अपने दोस्त से ज़्यादा सावधान है।
This book is more interesting than that one.||この本はあれより面白いです।|यह किताब उससे ज़्यादा दिलचस्प है।
She is the tallest in her class.||彼女はクラスで一番背が高いです।|वह अपनी कक्षा में सबसे लंबी है।
This is the best day of my life.||これは私の人生で一番良い日です।|यह मेरे जीवन का सबसे अच्छा दिन है।
Mount Everest is the highest mountain.||エベレストは一番高い山です।|एवरेस्ट सबसे ऊँचा पर्वत है।
He is the youngest in the family.||彼は家族で一番若いです।|वह परिवार में सबसे छोटा है।
This is the most beautiful place I know.||これは私が知る中で一番美しい場所です।|यह मेरी जानकारी में सबसे सुंदर जगह है।
That was the worst meal I've had.||それは今までで一番ひどい食事でした।|वह मेरा सबसे खराब भोजन था।
My house is bigger than yours.||私の家はあなたのより大きいです।|मेरा घर तुम्हारे से बड़ा है।
Winter is the coldest season.||冬は一番寒い季節です।|सर्दी सबसे ठंडा मौसम है।
She runs faster than me.||彼女は私より速く走ります।|वह मुझसे तेज़ दौड़ती है।
This coffee is hotter than that one.||このコーヒーはあれより熱いです।|यह कॉफ़ी उससे ज़्यादा गरम है।
He is smarter than he looks.||彼は見た目より賢いです।|वह दिखने से ज़्यादा समझदार है।
This is the easiest question.||これは一番簡単な質問です।|यह सबसे आसान सवाल है।
The Nile is the longest river.||ナイル川は一番長い川です।|नील सबसे लंबी नदी है।
Your answer is more accurate than mine.||あなたの答えは私のより正確です।|तुम्हारा उत्तर मेरे से ज़्यादा सटीक है।
The city is noisier than the village.||都会は村より騒がしいです।|शहर गाँव से ज़्यादा शोरगुल वाला है।
This is the most expensive hotel.||これは一番高いホテルです।|यह सबसे महँगा होटल है।
He is older than me.||彼は私より年上です।|वह मुझसे बड़ा है।
Today is the hottest day of the year.||今日は一年で一番暑い日です।|आज साल का सबसे गरम दिन है।
My English is getting better.||私の英語は上達しています।|मेरी अंग्रेज़ी बेहतर हो रही है।
She sings more beautifully than him.||彼女は彼より美しく歌います।|वह उससे ज़्यादा सुंदर गाती है।
This room is smaller than the kitchen.||この部屋は台所より小さいです।|यह कमरा रसोई से छोटा है।
He is the most hardworking student.||彼は一番勤勉な生徒です।|वह सबसे मेहनती विद्यार्थी है।"""),

        eg("eg29", "passive voice — is done / was done", "受動態", "B1",
            "USAGE: the passive focuses on the action or the object, not on who does it.\\nWHEN: use it when the doer is unknown, unimportant, or obvious: The window was broken (by someone). Common with news and reports: The bridge was built in 1990.\\nFORM: be (am/is/are/was/were) + past participle. Present: is done; past: was done; future: will be done. Add 'by + doer' if you want to name who.\\nTIP: the passive is less direct than the active. 'Someone broke the window' vs 'The window was broken'.",
            "उपयोग: कर्मवाच्य क्रिया या कर्म पर ध्यान देता है, कर्ता पर नहीं।\\nकब: जब कर्ता अज्ञात, महत्वहीन या स्पष्ट हो: खिड़की टूट गई थी। समाचार में आम: पुल 1990 में बना था।\\nरूप: be + भूतकालिक कृदंत। वर्तमान: is done; भूतकाल: was done; भविष्य: will be done।\\nटिप: कर्मवाच्य कर्तृवाच्य से कम सीधा है।",
            """The window was broken.||窓は割られました।|खिड़की टूट गई थी।
This bridge was built in 1990.||この橋は一九九〇年に建設されました।|यह पुल 1990 में बना था।
English is spoken all over the world.||英語は世界中で話されています।|दुनिया भर में अंग्रेज़ी बोली जाती है।
The letter was written by her.||その手紙は彼女によって書かれました।|पत्र उसके द्वारा लिखा गया था।
My car was stolen last night.||昨夜、私の車が盗まれました।|कल रात मेरी गाड़ी चोरी हो गई।
The food is cooked by my mother.||料理は母によって作られます।|खाना मेरी माँ द्वारा बनाया जाता है।
This song is sung by many people.||この歌は多くの人に歌われています।|यह गाना कई लोग गाते हैं।
The house was cleaned yesterday.||家は昨日掃除されました।|घर कल साफ़ किया गया।
The meeting will be held on Monday.||会議は月曜日に開かれます।|बैठक सोमवार को होगी।
The book was written in 1950.||その本は一九五〇年に書かれました।|किताब 1950 में लिखी गई थी。
The window was broken by a ball.||窓はボールで割られました।|खिड़की गेंद से टूटी।
Coffee is grown in Brazil.||コーヒーはブラジルで栽培されています।|कॉफ़ी ब्राज़ील में उगाई जाती है।
The problem was solved.||問題は解決されました।|समस्या हल हो गई।
The tickets were sold out.||チケットは売り切れました。|टिकट बिक गए।
He was given a reward.||彼は報酬を与えられました।|उसे इनाम दिया गया।
The room was filled with smoke.||部屋は煙でいっぱいでした।|कमरा धुएँ से भरा था।
The news was reported on TV.||そのニュースはテレビで報道されました।|ख़बर टीवी पर दिखाई गई।
The cake was made by my sister.||ケーキは妹によって作られました।|केक मेरी बहन ने बनाया।
Rules are made to be broken.||規則は破るためにある。|नियम तोड़ने के लिए बनते हैं।
This building was designed by a famous architect.||この建物は有名な建築家によって設計されました।|यह इमारत एक मशहूर वास्तुकार ने डिज़ाइन की।
The show was watched by millions.||その番組は何百万人に見られました。|वह शो लाखों लोगों ने देखा।
My wallet was found on the street.||財布は路上で見つかりました।|मेरा बटुआ सड़क पर मिल गया।
The project will be finished soon.||プロジェクトはまもなく完成します।|परियोजना जल्द पूरी हो जाएगी。
The floor was mopped by the cleaner.||床は清掃員によって拭かれました।|फर्श सफाईकर्मी ने पोंछा।
Rice is eaten in many countries.||米は多くの国で食べられています।|कई देशों में चावल खाया जाता है।
The message was sent at noon.||メッセージは正午に送られました।|संदेश दोपहर में भेजा गया।
The painting was sold for a million.||その絵は百万で売れました।|वह पेंटिंग दस लाख में बिकी।
He was invited to the party.||彼はパーティーに招待されました।|उसे पार्टी में बुलाया गया।
The bridge was damaged by the flood.||橋は洪水で損傷しました।|पुल बाढ़ से क्षतिग्रस्त हो गया।
This word is used every day.||この言葉は毎日使われています।|यह शब्द हर दिन इस्तेमाल होता है।"""),
        eg("eg30", "-ing vs to — gerunds and infinitives", "動名詞とto不定詞", "B1",
            "USAGE: some verbs are followed by the -ing form, others by 'to + verb'.\\nWHEN: -ing after enjoy, finish, mind, avoid, keep, consider, suggest, and after prepositions (good at cooking). 'to + verb' after want, need, decide, hope, plan, promise, learn, agree.\\nFORM: verb + -ing | verb + to + base verb. Some verbs take both with a change in meaning: stop smoking (quit) vs stop to smoke (pause).\\nTIP: 'enjoy to read' is WRONG — say 'enjoy reading'. 'want going' is WRONG — say 'want to go'.",
            "उपयोग: कुछ क्रियाओं के बाद -ing आता है, कुछ के बाद 'to + क्रिया'।\\nकब: enjoy, finish, mind, avoid, suggest के बाद -ing; want, need, decide, hope, plan, promise, learn के बाद to + क्रिया।\\nरूप: क्रिया + -ing | क्रिया + to + मूल क्रिया।\\nटिप: 'enjoy to read' गलत है — 'enjoy reading' कहें; 'want going' गलत है — 'want to go'।",
            """I enjoy reading books.||私は本を読むのが好きです।|मुझे किताबें पढ़ना अच्छा लगता है।
She finished cooking dinner.||彼女は夕食の準備を終えました।|उसने खाना बनाना खत्म किया।
Do you mind waiting a moment?||少し待っていただけますか।|क्या आपको एक पल इंतज़ार करने में आपत्ति है?
He avoids eating junk food.||彼はジャンクフードを避けます।|वह जंक फ़ूड खाने से बचता है।
I want to learn Japanese.||日本語を学びたいです।|मैं जापानी सीखना चाहता हूँ।
She needs to rest.||彼女は休む必要があります।|उसे आराम करने की ज़रूरत है।
We decided to stay home.||私たちは家にいることにしました।|हमने घर पर रहने का फ़ैसला किया।
I hope to see you soon.||またすぐ会えるといいですね।|मुझे उम्मीद है जल्द मिलूँगा।
They plan to travel next month.||彼らは来月旅行する予定です।|वे अगले महीने यात्रा की योजना बना रहे हैं।
She promised to call me.||彼女は電話すると約束しました।|उसने फ़ोन करने का वादा किया।
I am learning to drive.||私は運転を習っています।|मैं गाड़ी चलाना सीख रहा हूँ।
He agreed to help us.||彼は手伝うことに同意しました।|वह मदद करने पर सहमत हुआ।
She is good at cooking.||彼女は料理が上手です।|वह खाना बनाने में अच्छी है।
I'm interested in learning languages.||私は言語を学ぶことに興味があります।|मुझे भाषाएँ सीखने में दिलचस्पी है।
Thank you for helping me.||手伝ってくれてありがとう。|मदद करने के लिए धन्यवाद।
He kept talking during class.||彼は授業中ずっと話していました।|वह कक्षा के दौरान बात करता रहा।
Please stop making noise.||騒ぐのをやめてください।|कृपया शोर करना बंद करो।
We considered moving to another city.||私たちは別の街に引っ越すことを考えました।|हमने दूसरे शहर जाने पर विचार किया।
She suggested going to the park.||彼女は公園に行くことを提案しました।|उसने पार्क जाने का सुझाव दिया।
I can't afford to buy a car.||車を買う余裕がありません।|मैं गाड़ी खरीदने का खर्च नहीं उठा सकता।
He forgot to lock the door.||彼は鍵をかけるのを忘れました।|वह दरवाज़ा बंद करना भूल गया।
She remembered to bring the tickets.||彼女はチケットを持ってくるのを忘れませんでした।|उसे टिकट लाना याद रहा।
I enjoy listening to music.||私は音楽を聴くのが好きです।|मुझे संगीत सुनना अच्छा लगता है।
He stopped to buy some water.||彼は水を買うために立ち止まりました।|वह पानी खरीदने रुका।
They started to rain.||雨が降り始めました।|बारिश शुरू हो गई। (They started raining.)
I like swimming in the sea.||海で泳ぐのが好きです।|मुझे समुद्र में तैरना पसंद है।
She hates waking up early.||彼女は早起きが嫌いです।|उसे जल्दी उठना पसंद नहीं है।
We want to see the museum.||私たちは博物館を見たいです।|हम संग्रहालय देखना चाहते हैं।
He tried to open the window.||彼は窓を開けようとしました।|उसने खिड़की खोलने की कोशिश की।
I look forward to meeting you.||お会いできるのを楽しみにしています।|मैं आपसे मिलने का इंतज़ार कर रहा हूँ।"""),

        eg("eg31", "wh-questions — what / where / when / who / why / how", "疑問詞", "A1",
            "USAGE: wh-questions ask for information, not just yes or no.\\nWHEN: what = thing (What is this?), where = place (Where is the station?), when = time (When does it start?), who = person (Who is she?), why = reason (Why are you sad?), how = manner (How are you?), how many/much = quantity.\\nFORM: question word + (auxiliary) + subject + verb? e.g. Where do you live? What are you doing?\\nTIP: 'How are you?' asks about health; 'What are you?' asks about your job — a common confusion for learners.",
            "उपयोग: प्रश्नवाचक शब्द जानकारी माँगते हैं, सिर्फ़ हाँ/नहीं नहीं।\\nकब: what = चीज़, where = स्थान, when = समय, who = व्यक्ति, why = कारण, how = तरीका।\\nरूप: प्रश्नवाचक शब्द + (सहायक क्रिया) + कर्ता + क्रिया?\\nटिप: 'How are you?' = स्वास्थ्य; 'What are you?' = पेशा।",
            """What is your name?||お名前は何ですか।|आपका नाम क्या है?
What is this?||これは何ですか।|यह क्या है?
What are you doing?||何をしていますか।|तुम क्या कर रहे हो?
Where is the station?||駅はどこですか।|स्टेशन कहाँ है?
Where do you live?||どこに住んでいますか।|तुम कहाँ रहते हो?
Where are you from?||出身はどこですか।|तुम कहाँ से हो?
When does the train leave?||電車はいつ出発しますか।|ट्रेन कब निकलती है?
When is your birthday?||誕生日はいつですか।|तुम्हारा जन्मदिन कब है?
When did you arrive?||いつ着きましたか।|तुम कब पहुँचे?
Who is she?||彼女は誰ですか।|वह कौन है?
Who called you?||誰が電話しましたか।|तुम्हें किसने फ़ोन किया?
Who is your teacher?||あなたの先生は誰ですか।|तुम्हारे शिक्षक कौन हैं?
Why are you sad?||なぜ悲しいのですか।|तुम उदास क्यों हो?
Why did you leave early?||なぜ早く帰ったのですか।|तुम जल्दी क्यों चले गए?
Why is the sky blue?||空はなぜ青いのですか।|आसमान नीला क्यों है?
How are you?||お元気ですか।|आप कैसे हैं?
How do you go to school?||どうやって学校に行きますか।|तुम स्कूल कैसे जाते हो?
How old are you?||何歳ですか。|तुम्हारी उम्र कितनी है?
How much is this?||これはいくらですか।|यह कितने का है?
How many brothers do you have?||兄弟は何人いますか।|तुम्हारे कितने भाई हैं?
How long does it take?||どれくらいかかりますか।|इसमें कितना समय लगता है?
What time is it?||今何時ですか।|अभी कितने बजे हैं?
What do you want to eat?||何を食べたいですか।|तुम क्या खाना चाहते हो?
Where are you going?||どこへ行くのですか।|तुम कहाँ जा रहे हो?
When is the meeting?||会議はいつですか।|बैठक कब है?
Who made this cake?||誰がこのケーキを作りましたか।|यह केक किसने बनाया?
Why do you study English?||なぜ英語を勉強するのですか।|तुम अंग्रेज़ी क्यों पढ़ते हो?
How did you fix it?||どうやって直したのですか।|तुमने यह कैसे ठीक किया?
What color do you like?||何色が好きですか।|तुम्हें कौन-सा रंग पसंद है?
Where can I buy tickets?||どこでチケットを買えますか।|मैं टिकट कहाँ खरीद सकता हूँ?"""),
        eg("eg32", "reported speech — he said that...", "間接話法", "B2",
            "USAGE: reported speech repeats what someone said without using their exact words.\\nWHEN: after 'say' or 'tell': He said (that) he was tired. Tenses usually move back one step: am/is → was, will → would, have → had, can → could. Time and place words change: today → that day, here → there, tomorrow → the next day.\\nFORM: subject + said/told + (that) + clause. Use 'told' with an object (He told me), 'said' without (He said).\\nTIP: 'He said me' is WRONG — say 'He told me' or 'He said to me'.",
            "उपयोग: परोक्ष कथन किसी की बात उसके शब्दों में दोहराए बिना बताता है।\\nकब: said/told के बाद: He said (that) he was tired। काल एक कदम पीछे जाता है: am → was, will → would, have → had।\\nरूप: कर्ता + said/told + (that) + उपवाक्य। told के बाद कर्म आता है (He told me), said के बाद नहीं।\\nटिप: 'He said me' गलत है — 'He told me' कहें।",
            """He said he was tired.||彼は疲れたと言いました。|उसने कहा वह थका हुआ था।
She said she would call me.||彼女は電話すると言いました।|उसने कहा वह मुझे फ़ोन करेगी।
They said they were happy.||彼らは幸せだと言いました।|उन्होंने कहा वे खुश थे।
I told him I didn't know.||私は知らないと彼に言いました।|मैंने उसे बताया मुझे नहीं पता।
She said she had finished the work.||彼女は仕事を終えたと言いました।|उसने कहा उसने काम खत्म कर लिया था।
He told me to wait.||彼は私に待つように言いました।|उसने मुझे इंतज़ार करने को कहा।
They asked where the station was.||彼らは駅はどこかと尋ねました।|उन्होंने पूछा स्टेशन कहाँ था।
She asked if I was okay.||彼女は大丈夫かどうか尋ねました।|उसने पूछा क्या मैं ठीक था।
He said that he would come tomorrow.||彼は明日来ると言いました。|उसने कहा वह कल आएगा।
I said I was going home.||私は家に帰ると言いました।|मैंने कहा मैं घर जा रहा था।
She told me that she loved me.||彼女は私を愛していると言いました।|उसने मुझसे कहा वह मुझसे प्यार करती है।
They said they had seen the movie.||彼らはその映画を見たと言いました।|उन्होंने कहा उन्होंने वह फ़िल्म देखी थी।
He asked me to help him.||彼は私に助けてと頼みました।|उसने मुझसे मदद माँगी।
She said it was raining outside.||彼女は外は雨が降っていると言いました।|उसने कहा बाहर बारिश हो रही थी।
I told them I would be late.||私は遅れると彼らに伝えました।|मैंने उन्हें बताया मुझे देर होगी।
He said he had lost his keys.||彼は鍵をなくしたと言いました।|उसने कहा उसकी चाबियाँ खो गई थीं।
She said she could swim.||彼女は泳げると言いました।|उसने कहा वह तैर सकती है।
They said they would help.||彼らは手伝うと言いました।|उन्होंने कहा वे मदद करेंगे।
He told me the truth.||彼は私に真実を話しました।|उसने मुझे सच बताया।
She said the food was delicious.||彼女は料理がおいしいと言いました।|उसने कहा खाना स्वादिष्ट था।
He asked me where I lived.||彼は私にどこに住んでいるか尋ねました।|उसने पूछा मैं कहाँ रहता हूँ।
I said I would help her.||私は彼女を手伝うと言いました।|मैंने कहा मैं उसकी मदद करूँगा।
She told me not to worry.||彼女は私に心配しないように言いました।|उसने मुझसे कहा चिंता मत करो।
They said the train was late.||彼らは電車が遅れていると言いました।|उन्होंने कहा ट्रेन देर से थी।
He said he was very busy.||彼はとても忙しいと言いました।|उसने कहा वह बहुत व्यस्त था।
She asked if I wanted coffee.||彼女はコーヒーが欲しいかどうか尋ねました।|उसने पूछा क्या मुझे कॉफ़ी चाहिए।
I told her the good news.||私は彼女に良い知らせを伝えました।|मैंने उसे अच्छी ख़बर सुनाई।
He said he had never been there.||彼はそこに行ったことがないと言いました।|उसने कहा वह वहाँ कभी नहीं गया।
She said she was learning English.||彼女は英語を勉強していると言いました।|उसने कहा वह अंग्रेज़ी सीख रही है।
They told us to wait outside.||彼らは私たちに外で待つように言いました।|उन्होंने हमसे कहा बाहर इंतज़ार करो।""")

    )
}
