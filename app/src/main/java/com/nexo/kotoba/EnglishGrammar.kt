package com.nexo.kotoba

object EnglishGrammar {

    private fun eg(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "en", ruleEn, "", gex(raw), ruleHi, level, "english")

    private fun gex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("||")
            val d = c.getOrElse(1) { "" }.split("|")
            PatternExample("💬", c[0], d.getOrElse(0) { "" }, d.getOrElse(0) { "" }, d.getOrElse(1) { "" })
        }.toList()

    val patterns: List<Pattern> = listOf(

        eg("eg1", "am / is / are — the verb 'to be'", "be動詞（現在）", "A1",
            "I am, you/we/they are, he/she/it is. Use it to say what or how something is. Negative: am not / isn't / aren't. Question: Am I? / Is he? / Are you?",
            "I → am, you/we/they → are, he/she/it → is। नकारात्मक: isn't/aren't। प्रश्न: Is he? Are you?",
            """I am a student.||わたしは学生です。|मैं विद्यार्थी हूँ।
You are very kind.||あなたはとても親切です。|तुम बहुत दयालु हो।
She is my teacher.||彼女は私の先生です。|वह मेरी शिक्षिका है।
He is from India.||彼はインド出身です।|वह भारत से है।
It is a beautiful day.||今日はいい天気です।|आज बहुत अच्छा दिन है।
We are happy.||私たちは幸せです。|हम खुश हैं।
They are my friends.||彼らは私の友達です।|वे मेरे दोस्त हैं।
This is my phone.||これは私の携帯です।|यह मेरा फोन है।
That is your bag.||それはあなたのかばんです।|वह तुम्हारा बैग है।
I am not tired.||私は疲れていません।|मैं थका नहीं हूँ।
You are not late.||あなたは遅れていません。|तुम देर से नहीं आए।
She is not angry.||彼女は怒っていません。|वह गुस्से में नहीं है।
They are not at home.||彼らは家にいません।|वे घर पर नहीं हैं।
Am I early?||早すぎますか?|क्या मैं जल्दी आ गया?
Is he your brother?||彼はあなたの兄ですか?|क्या वह तुम्हारा भाई है?
Are you ready?||準備はいいですか?|क्या तुम तैयार हो?
Are they here?||彼らはここにいますか?|क्या वे यहाँ हैं?
It isn't expensive.||それは高くないです।|वह महँगा नहीं है।
We aren't sure.||私たちは確信がありません।|हमें यकीन नहीं है।
The cat is on the sofa.||猫はソファの上にいます।|बिल्ली सोफ़े पर है।
My shoes are new.||私の靴は新しいです।|मेरे जूते नए हैं।
The children are in the park.||子どもたちは公園にいます।|बच्चे पार्क में हैं।
I am twenty years old.||私は二十歳です。|मैं बीस साल का हूँ।
You are my best friend.||あなたは私の親友です।|तुम मेरे सबसे अच्छे दोस्त हो।
The food is delicious.||その料理はおいしいです।|खाना स्वादिष्ट है।"""),

        eg("eg2", "have / has — possession", "have / has（所有）", "A1",
            "I/you/we/they have, he/she/it has. Negative: don't have / doesn't have. Question: Do you have...? / Does he have...?",
            "I/you/we/they → have, he/she/it → has। नकारात्मक: don't/doesn't have। प्रश्न: Do you have...?",
            """I have a car.||私は車を持っています।|मेरे पास एक कार है।
You have blue eyes.||あなたは青い目をしています।|तुम्हारी आँखें नीली हैं।
She has two sisters.||彼女には姉妹が二人います。|उसकी दो बहनें हैं।
He has a new job.||彼は新しい仕事があります।|उसकी नई नौकरी है।
We have a big house.||私たちは大きな家があります。|हमारा बड़ा घर है।
They have three children.||彼らには子どもが三人います。|उनके तीन बच्चे हैं।
It has four wheels.||それには車輪が四つあります।|उसके चार पहिये हैं।
I don't have any money.||私はお金がありません。|मेरे पास पैसे नहीं हैं।
She doesn't have time.||彼女には時間がありません。|उसके पास समय नहीं है।
We don't have a pet.||私たちはペットがいません।|हमारे पास पालतू जानवर नहीं है।
Do you have a pen?||ペンを持っていますか?|क्या तुम्हारे पास कलम है?
Does he have a car?||彼は車を持っていますか?|क्या उसके पास कार है?
Do they have any questions?||彼らに質問はありますか?|क्या उनके पास कोई प्रश्न है?
I have a headache.||頭が痛いです।|मेरे सिर में दर्द है।
She has a dog named Max.||彼女はマックスという犬を飼っています।|उसके पास मैक्स नाम का कुत्ता है।
We have class at nine.||私たちは九時に授業があります。|हमारी नौ बजे कक्षा है।
He has breakfast at seven.||彼は七時に朝食をとります。|वह सात बजे नाश्ता करता है।
I have an idea.||アイデアがあります।|मेरे पास एक विचार है।
They have a problem.||彼らには問題があります।|उनके सामने एक समस्या है।
You have a nice smile.||あなたは素敵な笑顔をしています।|तुम्हारी मुस्कान बहुत अच्छी है।"""),

        eg("eg3", "Present simple — habits & facts", "現在形（習慣・事実）", "A1",
            "Base verb for I/you/we/they (I work), add -s for he/she/it (she works). For facts and routines. Negatives use don't/doesn't. Questions: Do/Does + subject + verb.",
            "I/you/we/they के साथ क्रिया का मूल रूप, he/she/it के साथ -s जोड़ें। आदतों और तथ्यों के लिए। नकारात्मक: don't/doesn't।",
            """I work in an office.||私はオフィスで働いています।|मैं ऑफिस में काम करता हूँ।
You speak English well.||あなたは英語が上手です।|तुम अच्छी अंग्रेज़ी बोलते हो।
She lives in Delhi.||彼女はデリーに住んでいます।|वह दिल्ली में रहती है।
He plays cricket every Sunday.||彼は毎週日曜日にクリケットをします।|वह हर रविवार क्रिकेट खेलता है।
It rains a lot here.||ここはよく雨が降ります।|यहाँ बहुत बारिश होती है।
We go to the gym twice a week.||私たちは週に二回ジムに行きます।|हम हफ्ते में दो बार जिम जाते हैं।
They eat rice every day.||彼らは毎日ごはんを食べます।|वे हर दिन चावल खाते हैं。
I get up at six.||私は六時に起きます।|मैं छह बजे उठता हूँ।
She drinks tea in the morning.||彼女は朝にお茶を飲みます।|वह सुबह चाय पीती है।
The sun rises in the east.||太陽は東から昇ります。|सूरज पूरब में निकलता है।
Water boils at 100 degrees.||水は百度で沸騰します।|पानी सौ डिग्री पर उबलता है।
I don't like coffee.||私はコーヒーが好きではありません。|मुझे कॉफ़ी पसंद नहीं है।
She doesn't watch TV.||彼女はテレビを見ません。|वह टीवी नहीं देखती।
We don't work on Sundays.||私たちは日曜日には働きません।|हम रविवार को काम नहीं करते।
Do you play the guitar?||ギターを弾きますか?|क्या तुम गिटार बजाते हो?
Does she speak Hindi?||彼女はヒンディー語を話しますか?|क्या वह हिंदी बोलती है?
Where do you live?||どこに住んでいますか?|तुम कहाँ रहते हो?
What does he do?||彼は何をしていますか?|वह क्या करता है?
He always walks to work.||彼はいつも歩いて仕事に行きます।|वह हमेशा पैदल काम पर जाता है।
I sometimes cook dinner.||私は時々夕食を作ります।|मैं कभी-कभी रात का खाना बनाता हूँ।
She never eats meat.||彼女は肉を決して食べません。|वह कभी मांस नहीं खाती।
The shop opens at nine.||店は九時に開きます।|दुकान नौ बजे खुलती है।
My father works in a bank.||父は銀行で働いています।|मेरे पिता बैंक में काम करते हैं।
Cats like fish.||猫は魚が好きです।|बिल्लियों को मछली पसंद है।
We speak Japanese at home.||私たちは家で日本語を話します।|हम घर पर जापानी बोलते हैं।
It snows in winter.||冬は雪が降ります।|सर्दियों में बर्फ़ गिरती है।"""),

        eg("eg4", "Present continuous — happening now", "現在進行形", "A1",
            "am/is/are + verb-ing: I am eating. Use for things happening right now, or temporary situations. Negative: am not/isn't/aren't + -ing. Question: Are you + -ing?",
            "am/is/are + क्रिया+ing। अभी हो रहे कामों के लिए। नकारात्मक: not + ing। प्रश्न: Are you...?",
            """I am eating lunch now.||今昼ごはんを食べています。|मैं अभी दोपहर का खाना खा रहा हूँ।
You are studying English.||あなたは英語を勉強しています।|तुम अंग्रेज़ी पढ़ रहे हो।
She is reading a book.||彼女は本を読んでいます।|वह किताब पढ़ रही है।
He is playing football.||彼はサッカーをしています।|वह फ़ुटबॉल खेल रहा है।
It is raining outside.||外は雨が降っています।|बाहर बारिश हो रही है।
We are watching a movie.||私たちは映画を見ています।|हम फ़िल्म देख रहे हैं।
They are working hard.||彼らは一生懸命働いています।|वे कड़ी मेहनत कर रहे हैं।
I am not sleeping.||私は寝ていません。|मैं सो नहीं रहा हूँ।
She is not listening.||彼女は聞いていません。|वह सुन नहीं रही है।
They are not coming today.||彼らは今日来ていません。|वे आज नहीं आ रहे हैं।
Are you waiting for me?||私を待っていますか?|क्या तुम मेरा इंतज़ार कर रहे हो?
What are you doing?||何をしていますか?|तुम क्या कर रहे हो?
Why is he crying?||彼はなぜ泣いていますか?|वह क्यों रो रहा है?
I am learning Japanese.||私は日本語を学んでいます।|मैं जापानी सीख रहा हूँ।
The children are playing outside.||子どもたちは外で遊んでいます।|बच्चे बाहर खेल रहे हैं।
She is cooking dinner.||彼女は夕食を作っています।|वह रात का खाना बना रही है।
He is wearing a blue shirt.||彼は青いシャツを着ています।|उसने नीली कमीज़ पहनी है।
We are staying at a hotel.||私たちはホテルに泊まっています।|हम होटल में रह रहे हैं।
I am writing an email.||私はメールを書いています।|मैं ईमेल लिख रहा हूँ।
The phone is ringing.||電話が鳴っています।|फ़ोन बज रहा है।
My sister is talking on the phone.||妹は電話で話しています।|मेरी बहन फ़ोन पर बात कर रही है।
The bus is coming.||バスが来ています。|बस आ रही है।
I'm feeling better today.||今日は気分が良くなっています。|आज मैं बेहतर महसूस कर रहा हूँ।
They are building a new house.||彼らは新しい家を建てています。|वे नया घर बना रहे हैं।"""),

        eg("eg5", "do / does / did — helping verbs", "do / does / did（助動詞）", "A1",
            "do/does make present questions and negatives (Do you like...? / She doesn't work). did makes past questions and negatives (Did you go? / I didn't go). After do/does/did the main verb is always base form.",
            "do/does वर्तमान के प्रश्न और नकारात्मक बनाते हैं; did भूतकाल के। do/does/did के बाद क्रिया हमेशा मूल रूप में।",
            """Do you like music?||音楽は好きですか?|क्या तुम्हें संगीत पसंद है?
Do they live here?||彼らはここに住んでいますか?|क्या वे यहाँ रहते हैं?
Does she work on Fridays?||彼女は金曜日に働きますか?|क्या वह शुक्रवार को काम करती है?
Does he speak French?||彼はフランス語を話しますか?|क्या वह फ़्रेंच बोलता है?
I don't understand.||わかりません。|मुझे समझ नहीं आया।
She doesn't like spicy food.||彼女は辛い食べ物が好きではありません。|उसे तीखा खाना पसंद नहीं है।
We don't have a car.||私たちは車を持っていません।|हमारे पास कार नहीं है।
Did you eat breakfast?||朝食を食べましたか?|क्या तुमने नाश्ता किया?
Did she call you?||彼女はあなたに電話しましたか?|क्या उसने तुम्हें फ़ोन किया?
Did they win the game?||彼らは試合に勝ちましたか?|क्या वे मैच जीते?
I didn't go to work yesterday.||昨日は仕事に行きませんでした।|मैं कल काम पर नहीं गया।
He didn't answer my question.||彼は私の質問に答えませんでした।|उसने मेरे सवाल का जवाब नहीं दिया।
We didn't watch the film.||私たちはその映画を見ませんでした।|हमने वह फ़िल्म नहीं देखी।
Where do you come from?||どこの出身ですか?|तुम कहाँ से आए हो?
What does this word mean?||この言葉はどういう意味ですか?|इस शब्द का क्या अर्थ है?
When did she arrive?||彼女はいつ着きましたか?|वह कब आई?
Why didn't you come?||どうして来なかったのですか?|तुम क्यों नहीं आए?
How does this machine work?||この機械はどう動きますか?|यह मशीन कैसे चलती है?
Do you want some tea?||お茶はいかがですか?|क्या तुम चाय लोगे?
Does it hurt?||痛みますか?|क्या दर्द हो रहा है?
I don't know the answer.||答えがわかりません।|मुझे जवाब नहीं पता।
She didn't say anything.||彼女は何も言いませんでした।|उसने कुछ नहीं कहा।"""),

        eg("eg6", "Past simple — was/were & regular verbs", "過去形（was/were・規則動詞）", "A1",
            "Regular verbs add -ed (work → worked). Irregular verbs change (go → went, eat → ate). was = I/he/she/it, were = you/we/they. For finished actions in the past.",
            "नियमित क्रिया में -ed जोड़ें (worked)। अनियमित रूप बदलते हैं (went, ate)। I/he/she/it → was; you/we/they → were।",
            """I was at home yesterday.||昨日は家にいました।|मैं कल घर पर था।
She was very happy.||彼女はとても幸せでした।|वह बहुत खुश थी।
It was a cold night.||寒い夜でした।|ठंडी रात थी।
We were tired after work.||仕事の後で疲れていました।|काम के बाद हम थके हुए थे।
They were at the station.||彼らは駅にいました।|वे स्टेशन पर थे।
I worked in Tokyo for two years.||私は東京で二年間働きました।|मैंने टोक्यो में दो साल काम किया।
She studied all night.||彼女は一晩中勉強しました।|उसने पूरी रात पढ़ाई की।
He played tennis last Sunday.||彼は先週日曜日にテニスをしました।|उसने पिछले रविवार टेनिस खेला।
We watched a movie last night.||昨夜映画を見ました。|हमने कल रात फ़िल्म देखी।
I went to the market yesterday.||昨日市場に行きました।|मैं कल बाज़ार गया।
She ate an apple.||彼女はりんごを食べました।|उसने एक सेब खाया।
He came home late.||彼は遅く帰ってきました。|वह देर से घर आया।
They took a taxi.||彼らはタクシーに乗りました।|उन्होंने टैक्सी ली।
I didn't watch TV last night.||昨夜はテレビを見ませんでした।|मैंने कल रात टीवी नहीं देखा।
She didn't come to the party.||彼女はパーティーに来ませんでした।|वह पार्टी में नहीं आई।
We didn't have enough time.||私たちには十分な時間がありませんでした।|हमारे पास काफ़ी समय नहीं था।
Did you enjoy the trip?||旅行は楽しかったですか?|क्या तुम्हें यात्रा अच्छी लगी?
Did he finish the work?||彼は仕事を終えましたか?|क्या उसने काम खत्म किया?
Was it hot yesterday?||昨日は暑かったですか?|क्या कल गरमी थी?
Were you at school today?||今日は学校にいましたか?|क्या तुम आज स्कूल में थे?
The movie started at eight.||映画は八時に始まりました。|फ़िल्म आठ बजे शुरू हुई।
I met my friend yesterday.||昨日友達に会いました。|मैं कल अपने दोस्त से मिला।
She made a cake.||彼女はケーキを作りました।|उसने केक बनाया।
We lived in Mumbai before.||私たちは以前ムンバイに住んでいました。|हम पहले मुंबई में रहते थे।"""),

        eg("eg7", "Past continuous — was doing", "過去進行形", "A2",
            "was/were + verb-ing: I was eating. Describes an action in progress at a past moment. Often combines with past simple: While I was eating, the phone rang.",
            "was/were + क्रिया+ing। भूतकाल के किसी क्षण में चल रही क्रिया के लिए। साथ में past simple भी आता है।",
            """I was cooking when you called.||あなたが電話したとき私は料理していました。|जब तुमने फ़ोन किया मैं खाना बना रहा था।
She was reading when I arrived.||私が着いたとき彼女は本を読んでいました।|जब मैं पहुँचा वह किताब पढ़ रही थी।
He was sleeping at midnight.||彼は真夜中に寝ていました。|वह आधी रात को सो रहा था।
We were walking in the park.||私たちは公園を歩いていました।|हम पार्क में चल रहे थे।
They were playing music.||彼らは音楽を演奏していました।|वे संगीत बजा रहे थे।
It was raining all morning.||午前中ずっと雨が降っていました।|पूरी सुबह बारिश हो रही थी।
I was watching TV when the light went out.||電気が消えたときテレビを見ていました।|जब बत्ती गई मैं टीवी देख रहा था।
She was talking on the phone.||彼女は電話で話していました।|वह फ़ोन पर बात कर रही थी।
The children were playing outside.||子どもたちは外で遊んでいました।|बच्चे बाहर खेल रहे थे।
While I was driving, I saw an accident.||運転中に事故を見ました।|गाड़ी चलाते समय मैंने एक दुर्घटना देखी।
He was wearing a red jacket.||彼は赤いジャケットを着ていました।|उसने लाल जैकेट पहन रखी थी।
We were having dinner at nine.||私たちは九時に夕食をとっていました।|हम नौ बजे रात का खाना खा रहे थे।
I wasn't listening carefully.||私は注意して聞いていませんでした।|मैं ध्यान से नहीं सुन रहा था।
She wasn't feeling well.||彼女は体調が悪かったです।|उसकी तबीयत ठीक नहीं थी।
They weren't paying attention.||彼らは注意を払っていませんでした।|वे ध्यान नहीं दे रहे थे।
Were you sleeping when I called?||私が電話したとき寝ていましたか?|जब मैंने फ़ोन किया क्या तुम सो रहे थे?
What were you doing at eight?||八時に何をしていましたか?|आठ बजे तुम क्या कर रहे थे?
The sun was shining.||太陽が輝いていました।|सूरज चमक रहा था।
I was thinking about you.||あなたのことを考えていました।|मैं तुम्हारे बारे में सोच रहा था।
She was waiting for the bus.||彼女はバスを待っていました।|वह बस का इंतज़ार कर रही थी।"""),

        eg("eg8", "Present perfect — have done", "現在完了", "A2",
            "have/has + past participle: I have eaten. Use for past actions with a connection to now — result now, or life experience, or 'up to now'. Just finished: I've just... Not finished period: this week.",
            "have/has + past participle। अतीत के उन कामों के लिए जिनका अभी से संबंध है — अनुभव, परिणाम, 'अभी तक'।",
            """I have finished my homework.||宿題を終えました।|मैंने अपना होमवर्क खत्म कर लिया है।
She has lost her keys.||彼女は鍵をなくしました।|उसकी चाबियाँ खो गई हैं।
He has gone to Delhi.||彼はデリーに行きました。|वह दिल्ली गया है।
We have seen that movie.||私たちはその映画を見たことがあります।|हम वह फ़िल्म देख चुके हैं।
They have bought a new house.||彼らは新しい家を買いました।|उन्होंने नया घर खरीदा है।
I have lived here for five years.||私はここに五年間住んでいます।|मैं यहाँ पाँच साल से रह रहा हूँ।
She has worked here since 2020.||彼女は二〇二〇年からここで働いています।|वह 2020 से यहाँ काम कर रही है।
Have you ever been to Japan?||日本に行ったことがありますか?|क्या तुम कभी जापान गए हो?
Has she eaten yet?||彼女はもう食べましたか?|क्या उसने खाना खा लिया?
I haven't seen him today.||今日彼に会っていません।|मैंने आज उसे नहीं देखा।
We haven't finished yet.||まだ終わっていません。|हमने अभी खत्म नहीं किया।
They have just arrived.||彼らはちょうど着きました。|वे अभी-अभी आए हैं।
I have already eaten lunch.||もう昼ごはんを食べました।|मैंने दोपहर का खाना खा लिया है।
Have you ever tried sushi?||寿司を食べたことがありますか?|क्या तुमने कभी सुशी खाई है?
He has never been abroad.||彼は海外に行ったことがありません।|वह कभी विदेश नहीं गया।
The train has already left.||電車はもう出発しました।|ट्रेन जा चुकी है।
I have known her for ten years.||私は彼女と十年の知り合いです।|मैं उसे दस साल से जानता हूँ।
We have talked about it.||それについて話しました।|हमने इस बारे में बात की है।
She has written three books.||彼女は本を三冊書いています।|उसने तीन किताबें लिखी हैं।
I have lost weight this month.||今月やせました。|इस महीने मेरा वज़न कम हुआ है।"""),

        eg("eg9", "Present perfect continuous — have been doing", "現在完了進行形", "B2",
            "have/has been + verb-ing: I have been working. Emphasizes the duration or ongoing nature of an action up to now.",
            "have/has been + क्रिया+ing। अभी तक जारी क्रिया की अवधि दिखाने के लिए।",
            """I have been working all day.||一日中働いています。|मैं पूरे दिन काम कर रहा हूँ।
She has been studying for three hours.||彼女は三時間勉強しています。|वह तीन घंटे से पढ़ाई कर रही है।
It has been raining since morning.||朝から雨が降っています।|सुबह से बारिश हो रही है।
We have been waiting for you.||あなたを待っていました。|हम तुम्हारा इंतज़ार कर रहे हैं।
They have been playing for an hour.||彼らは一時間遊んでいます।|वे एक घंटे से खेल रहे हैं।
I have been learning English for two years.||英語を二年間学んでいます。|मैं दो साल से अंग्रेज़ी सीख रहा हूँ।
He has been living in Japan since March.||彼は三月から日本に住んでいます।|वह मार्च से जापान में रह रहा है।
How long have you been driving?||どのくらい運転していますか?|तुम कितनी देर से गाड़ी चला रहे हो?
My phone has been ringing all morning.||午前中ずっと電話が鳴っています।|मेरा फ़ोन पूरी सुबह बज रहा है।
We have been planning this trip for months.||私たちは何ヶ月もこの旅行を計画しています。|हम महीनों से इस यात्रा की योजना बना रहे हैं।
She has been feeling tired lately.||彼女は最近疲れを感じています।|उसे हाल में थकान महसूस हो रही है।
I have been reading this book all week.||一週間ずっとこの本を読んでいます।|मैं पूरे हफ्ते यह किताब पढ़ रहा हूँ।"""),

        eg("eg10", "Past perfect — had done", "過去完了", "B1",
            "had + past participle: I had finished before she came. Shows the earlier of two past actions.",
            "had + past participle। दो भूतकाल की क्रियाओं में से पहले वाली के लिए।",
            """When I arrived, the train had left.||私が着いたとき電車は出発していました।|जब मैं पहुँचा ट्रेन जा चुकी थी।
She had finished her work before lunch.||彼女は昼食前に仕事を終えていました।|उसने दोपहर के खाने से पहले काम खत्म कर लिया था।
He had never seen the sea before.||彼は海を見たことがありませんでした।|उसने पहले कभी समुद्र नहीं देखा था।
We had eaten before they arrived.||彼らが着く前に私たちは食べていました।|उनके आने से पहले हम खा चुके थे।
I had forgotten my password.||パスワードを忘れていました।|मैं अपना पासवर्ड भूल चुका था।
The movie had already started.||映画はもう始まっていました।|फ़िल्म शुरू हो चुकी थी।
She said she had seen the report.||彼女は報告書を見たと言いました।|उसने कहा वह रिपोर्ट देख चुकी थी।
By 2020, I had lived in three cities.||二〇二〇年までに三つの都市に住んでいました।|2020 तक मैं तीन शहरों में रह चुका था।
Had you ever flown before that trip?||その旅行の前に飛行機に乗ったことがありましたか?|क्या उस यात्रा से पहले तुमने कभी हवाई जहाज़ से सफ़र किया था?
They had not met before.||彼らは以前会ったことがありませんでした।|वे पहले कभी नहीं मिले थे।
The shop had closed when we got there.||私たちが着いたとき店は閉まっていました।|जब हम पहुँचे दुकान बंद हो चुकी थी।
I realized I had made a mistake.||間違いを犯したことに気づきました।|मुझे एहसास हुआ कि मैंने गलती की थी।"""),

        eg("eg11", "Future with will", "未来形（will）", "A1",
            "will + base verb: I will go. For predictions, decisions made now, and promises. Negative: won't. Question: Will you...?",
            "will + क्रिया का मूल रूप। भविष्यवाणी, अभी लिया गया निर्णय, वादे के लिए। नकारात्मक: won't।",
            """I will call you tomorrow.||明日電話します。|मैं कल तुम्हें फ़ोन करूँगा।
She will come to the party.||彼女はパーティーに来るでしょう।|वह पार्टी में आएगी।
It will rain tonight.||今夜雨が降るでしょう।|आज रात बारिश होगी।
We will meet at the station.||駅で会いましょう।|हम स्टेशन पर मिलेंगे।
They will arrive at six.||彼らは六時に着くでしょう।|वे छह बजे पहुँचेंगे।
I think he will win.||彼は勝つと思います।|मुझे लगता है वह जीतेगा।
Don't worry, I will help you.||心配しないで、手伝います।|चिंता मत करो, मैं मदद करूँगा।
I will be there soon.||すぐに行きます।|मैं जल्दी पहुँचूँगा।
She won't be late again.||彼女はもう遅れないでしょう।|वह फिर देर से नहीं आएगी।
We won't forget you.||私たちはあなたを忘れません।|हम तुम्हें नहीं भूलेंगे।
Will you come with me?||一緒に来ますか?|क्या तुम मेरे साथ आओगे?
What will you do this weekend?||今週末は何をしますか?|इस सप्ताहांत तुम क्या करोगे?
I'll open the window.||窓を開けます。|मैं खिड़की खोलूँगा।
It won't hurt.||痛くありませんよ।|दर्द नहीं होगा।
The train will arrive in five minutes.||電車は五分で着きます。|ट्रेन पाँच मिनट में आएगी।
Maybe she will call later.||たぶん彼女は後で電話するでしょう।|शायद वह बाद में फ़ोन करेगी।"""),

        eg("eg12", "Future with going to", "未来形（be going to）", "A1",
            "am/is/are going to + verb: I'm going to study. For plans already made, and predictions with present evidence.",
            "am/is/are going to + क्रिया। पहले से तय योजनाओं और पुख्ता अंदाज़े के लिए।",
            """I am going to study tonight.||今夜勉強するつもりです।|मैं आज रात पढ़ाई करने वाला हूँ।
She is going to visit her parents.||彼女は両親を訪ねるつもりです।|वह अपने माता-पिता से मिलने जा रही है।
We are going to buy a car.||私たちは車を買うつもりです।|हम कार खरीदने वाले हैं।
It's going to rain — look at the clouds.||雲を見て、雨が降りそうです।|बादल देखो, बारिश होने वाली है।
They are going to get married.||彼らは結婚するつもりです।|वे शादी करने वाले हैं।
I'm going to cook dinner tonight.||今夜は夕食を作るつもりです।|आज रात मैं खाना बनाने वाला हूँ।
He is going to quit his job.||彼は仕事を辞めるつもりです।|वह नौकरी छोड़ने वाला है।
What are you going to do today?||今日は何をするつもりですか?|आज तुम क्या करने वाले हो?
We are not going to go out tonight.||今夜は外出しません。|आज रात हम बाहर नहीं जाने वाले।
Is she going to call us?||彼女は私たちに電話するつもりですか?|क्या वह हमें फ़ोन करने वाली है?
I'm going to learn to swim.||泳ぎを習うつもりです।|मैं तैरना सीखने वाला हूँ।
They are going to move to a new city.||彼らは新しい街に引っ越すつもりです।|वे नए शहर में जाने वाले हैं।
Watch out! You're going to fall.||気をつけて! 落ちますよ।|सावधान! तुम गिरने वाले हो।
She's going to have a baby.||彼女は赤ちゃんを産む予定です।|वह बच्चा पैदा करने वाली है।"""),

        eg("eg13", "Future continuous — will be doing", "未来進行形", "B1",
            "will be + verb-ing: I will be waiting. For actions in progress at a future time.",
            "will be + क्रिया+ing। भविष्य के किसी समय पर चल रही क्रिया के लिए।",
            """This time tomorrow I will be flying to Japan.||明日の今頃は日本へ飛行機で行っています。|कल इस समय मैं जापान के लिए उड़ान भर रहा होऊँगा।
She will be working at six.||彼女は六時に働いているでしょう।|वह छह बजे काम कर रही होगी।
We will be waiting for you at the airport.||空港であなたを待っています。|हम तुम्हारा हवाई अड्डे पर इंतज़ार कर रहे होंगे।
They will be having dinner at eight.||彼らは八時に夕食をとっているでしょう।|वे आठ बजे रात का खाना खा रहे होंगे।
I will be sleeping when you arrive.||あなたが着くとき私は寝ているでしょう।|जब तुम पहुँचोगे मैं सो रहा होऊँगा।
Don't call at noon — I will be studying.||昼に電話しないでください。勉強していますから।|दोपहर में फ़ोन मत करना — मैं पढ़ रहा होऊँगा।
Will you be using the car tonight?||今夜車を使いますか?|क्या तुम आज रात कार इस्तेमाल कर रहे होगे?
This time next week we will be on vacation.||来週の今頃は休暇中です。|अगले हफ्ते इस समय हम छुट्टी पर होंगे।"""),

        eg("eg14", "Future perfect — will have done", "未来完了", "C1",
            "will have + past participle: I will have finished by 5. Shows an action completed before a future time.",
            "will have + past participle। भविष्य के किसी समय तक पूरा हो चुका काम दिखाने के लिए।",
            """I will have finished the report by five.||五時までに報告書を終えているでしょう।|मैं पाँच बजे तक रिपोर्ट खत्म कर चुका होऊँगा।
She will have left by the time you get there.||あなたが着く頃には彼女は出発しているでしょう।|जब तुम वहाँ पहुँचोगे वह जा चुकी होगी।
By next year, we will have saved enough money.||来年までに十分なお金を貯めているでしょう।|अगले साल तक हम काफ़ी पैसे बचा चुके होंगे।
They will have built the bridge by 2030.||二〇三〇年までに橋を建設しているでしょう।|2030 तक वे पुल बना चुके होंगे।
Will you have eaten before the party?||パーティーの前に食べていますか?|क्या तुम पार्टी से पहले खा चुके होगे?
He will have learned to drive by summer.||夏までに運転を覚えているでしょう।|गर्मियों तक वह गाड़ी चलाना सीख चुका होगा।
By the time you read this, I will have arrived.||これを読む頃には私は着いているでしょう।|जब तक तुम यह पढ़ोगे मैं पहुँच चुका होऊँगा।"""),

        eg("eg15", "can / could — ability & permission", "can / could（可能・許可）", "A2",
            "can = present ability or permission (I can swim / Can I go?). could = past ability or polite permission (I could swim when I was five / Could I borrow this?). Followed by the base verb.",
            "can = वर्तमान क्षमता/अनुमति; could = भूतकाल की क्षमता या विनम्र अनुरोध। दोनों के बाद क्रिया का मूल रूप।",
            """I can swim.||私は泳げます।|मैं तैर सकता हूँ।
She can speak three languages.||彼女は三か国語話せます。|वह तीन भाषाएँ बोल सकती है।
He can run very fast.||彼はとても速く走れます。|वह बहुत तेज़ दौड़ सकता है।
We can see the mountains from here.||ここから山が見えます।|हम यहाँ से पहाड़ देख सकते हैं।
Can you help me?||手伝ってもらえますか?|क्या तुम मेरी मदद कर सकते हो?
Can I open the window?||窓を開けてもいいですか?|क्या मैं खिड़की खोल सकता हूँ?
I can't find my keys.||鍵が見つかりません।|मुझे मेरी चाबियाँ नहीं मिल रहीं।
She can't come today.||彼女は今日来られません।|वह आज नहीं आ सकती।
I could swim when I was six.||六歳のとき泳げました।|मैं छह साल की उम्र में तैर सकता था।
He could speak French as a child.||彼は子どもの頃フランス語が話せました।|वह बचपन में फ़्रेंच बोल सकता था।
Could you help me, please?||手伝っていただけますか?|क्या आप मेरी मदद कर सकते हैं?
Could I use your phone?||電話を使ってもいいですか?|क्या मैं तुम्हारा फ़ोन इस्तेमाल कर सकता हूँ?
I could hear the music from outside.||外から音楽が聞こえました।|मुझे बाहर से संगीत सुनाई दे रहा था।
We couldn't find the hotel.||ホテルが見つかりませんでした।|हमें होटल नहीं मिल सका।
Could you speak more slowly?||もう少しゆっくり話してもらえますか?|क्या आप धीरे बोल सकते हैं?
You can take a break now.||休憩してもいいですよ।|अब तुम आराम कर सकते हो।
I can't hear you well.||よく聞こえません。|मैं तुम्हें ठीक से सुन नहीं सकता।
Can anyone solve this problem?||この問題を解ける人はいますか?|क्या कोई यह समस्या हल कर सकता है?"""),

        eg("eg16", "may / might — possibility", "may / might（可能性）", "A2",
            "may/might + base verb: It might rain. Both express possibility; might is more uncertain. May also asks/grants permission (May I...?).",
            "may/might + क्रिया। संभावना के लिए; might अधिक अनिश्चित। May I...? अनुमति माँगने के लिए।",
            """It might rain tomorrow.||明日は雨が降るかもしれません।|कल बारिश हो सकती है।
She may be at home.||彼女は家にいるかもしれません।|वह शायद घर पर हो।
He might come to the party.||彼はパーティーに来るかもしれません।|वह शायद पार्टी में आए।
We may go to the beach this weekend.||今週末は海に行くかもしれません。|हम शायद इस सप्ताहांत समुद्र तट जाएँ।
They might be sleeping.||彼らは寝ているかもしれません।|वे शायद सो रहे हों।
This might take a while.||これには時間がかかるかもしれません।|इसमें थोड़ा समय लग सकता है।
I may not come tomorrow.||明日来られないかもしれません。|मैं कल नहीं आ सकता।
You may feel a little pain.||少し痛みを感じるかもしれません।|तुम्हें थोड़ा दर्द महसूस हो सकता है।
May I ask a question?||質問してもいいですか?|क्या मैं एक सवाल पूछ सकता हूँ?
May I come in?||入ってもいいですか?|क्या मैं अंदर आ सकता हूँ?
She might be right.||彼女の言うことが正しいかもしれません।|वह शायद सही हो।
It may snow tonight.||今夜は雪が降るかもしれません。|आज रात बर्फ़ गिर सकती है।
He might have missed the bus.||彼はバスに乗り遅れたかもしれません。|वह शायद बस चूक गया हो।
There may be a delay.||遅延があるかもしれません।|शायद देरी हो सकती है।"""),

        eg("eg17", "must / have to — obligation", "must / have to（義務）", "A2",
            "must + base verb and have to + base verb both mean obligation. must is stronger/personal; have to is external (rules). Negative: must not = forbidden; don't have to = not necessary.",
            "must और have to दोनों अनिवार्यता बताते हैं। must नहीं = मना; don't have to = ज़रूरी नहीं।",
            """You must wear a seatbelt.||シートベルトを着用しなければなりません।|तुम्हें सीटबेल्ट पहनना ज़रूरी है।
I must finish this today.||今日これを終えなければなりません。|मुझे यह आज खत्म करना है।
She must see a doctor.||彼女は医者に診てもらわなければなりません।|उसे डॉक्टर से मिलना ज़रूरी है।
We must leave now.||今出発しなければなりません।|हमें अभी निकलना होगा।
You must not smoke here.||ここで喫煙してはいけません।|यहाँ धूम्रपान करना मना है।
I have to get up early.||早く起きなければなりません।|मुझे जल्दी उठना है।
She has to work on Saturday.||彼女は土曜日に働かなければなりません।|उसे शनिवार को काम करना है।
We have to pay the bill.||私たちは請求書を支払わなければなりません।|हमें बिल चुकाना है।
Do you have to wear a uniform?||制服を着なければなりませんか?|क्या तुम्हें वर्दी पहननी है?
You don't have to come if you're busy.||忙しければ来なくていいですよ।|अगर तुम व्यस्त हो तो तुम्हें आने की ज़रूरत नहीं है।
I don't have to work tomorrow.||明日は働かなくていいです।|मुझे कल काम नहीं करना है।
Visitors must show their ID.||来館者は身分証明書を見せなければなりません।|आगंतुकों को पहचान पत्र दिखाना अनिवार्य है।
You must be careful with fire.||火には注意しなければなりません।|तुम्हें आग से सावधान रहना चाहिए।
He had to wait an hour.||彼は一時間待たなければなりませんでした।|उसे एक घंटे इंतज़ार करना पड़ा।"""),

        eg("eg18", "should — advice", "should（助言）", "A2",
            "should + base verb: You should rest. For advice and suggestions. Negative: shouldn't. Question: Should I...?",
            "should + क्रिया। सलाह के लिए। नकारात्मक: shouldn't। प्रश्न: Should I...?",
            """You should rest.||休むべきです।|तुम्हें आराम करना चाहिए।
You should drink more water.||もっと水を飲むべきです।|तुम्हें और पानी पीना चाहिए।
He should apologize.||彼は謝るべきです।|उसे माफ़ी माँगनी चाहिए।
She should eat healthier food.||彼女はもっと健康的な食べ物を食べるべきです।|उसे स्वस्थ भोजन खाना चाहिए।
We should leave early.||早く出発すべきです।|हमें जल्दी निकलना चाहिए।
They should see that movie.||彼らはその映画を見るべきです।|उन्हें वह फ़िल्म देखनी चाहिए।
I should call my mother.||母に電話すべきです。|मुझे अपनी माँ को फ़ोन करना चाहिए।
You shouldn't worry so much.||そんなに心配すべきではありません।|तुम्हें इतनी चिंता नहीं करनी चाहिए।
He shouldn't drive so fast.||彼はそんなに速く運転すべきではありません।|उसे इतनी तेज़ गाड़ी नहीं चलानी चाहिए।
We shouldn't waste food.||食べ物を無駄にすべきではありません।|हमें खाना बर्बाद नहीं करना चाहिए।
Should I wear a jacket?||ジャケットを着るべきですか?|क्या मुझे जैकेट पहननी चाहिए?
What should we do now?||今何をすべきですか?|अब हमें क्या करना चाहिए?
You should try the local food.||地元の料理を試すべきです।|तुम्हें स्थानीय खाना ज़रूर आज़माना चाहिए।
I think you should take the job.||その仕事を引き受けるべきだと思います।|मुझे लगता है तुम्हें नौकरी ले लेनी चाहिए।
Students should do their homework.||生徒は宿題をすべきです।|विद्यार्थियों को होमवर्क करना चाहिए।"""),

        eg("eg19", "would — polite requests & past habits", "would（丁寧・習慣）", "B1",
            "Would you...? = polite request or invitation. I would like... = polite want. Would = also the past of will (He said he would come), and 'would often' = past habits.",
            "Would you...? = विनम्र अनुरोध। I would like = विनम्र इच्छा। would अतीत में will का रूप भी है।",
            """Would you like some tea?||お茶はいかがですか?|क्या आप चाय लेंगे?
Would you open the window, please?||窓を開けていただけますか?|क्या आप खिड़की खोल देंगे?
I would like a coffee.||コーヒーをください。|मुझे एक कॉफ़ी चाहिए।
She would love to join us.||彼女はぜひ参加したいでしょう。|वह हमारे साथ आना पसंद करेगी।
We would prefer to leave early.||早く出発したいです。|हम जल्दी निकलना पसंद करेंगे।
He said he would call me.||彼は電話すると言いました।|उसने कहा वह मुझे फ़ोन करेगा।
Would you mind waiting a moment?||少し待っていただけますか?|क्या आप एक पल इंतज़ार कर सकते हैं?
I would go with you, but I'm busy.||一緒に行きたいですが忙しいです।|मैं तुम्हारे साथ चलता, पर मैं व्यस्त हूँ।
When we were kids, we would play every day.||子どもの頃、毎日遊んでいました。|जब हम बच्चे थे, रोज़ खेलते थे।
On Sundays she would visit her grandmother.||日曜日に彼女は祖母を訪ねたものでした।|रविवार को वह अपनी दादी से मिलने जाती थी।
Would you like to come to dinner?||夕食に来ませんか?|क्या आप रात के खाने पर चलेंगे?
That would be great.||それは素晴らしいですね।|वह बहुत अच्छा होगा।
I wouldn't do that if I were you.||私ならそんなことはしません。|अगर मैं तुम होता तो ऐसा नहीं करता।
Would you like anything else?||ほかには何かありますか?|क्या आपको और कुछ चाहिए?
He would often go fishing.||彼はよく釣りに行ったものでした।|वह अक्सर मछली पकड़ने जाता था।"""),

        eg("eg20", "Imaginary situations — 'If I were...'", "仮定法", "B1",
            "For unreal/imaginary present situations: 'If + subject + were/past, subject + would/could + verb'. Example: If I were a bird, I could fly high. were is used for all subjects in imaginary sentences.",
            "अवास्तविक/काल्पनिक स्थितियों के लिए: If I were... / I could...। काल्पनिक वाक्यों में सबके साथ were प्रयोग होता है।",
            """If I were a bird, I could fly high.||もし鳥なら、高く飛べるのに。|अगर मैं पक्षी होता तो ऊँचा उड़ सकता।
If I were you, I would take the job.||もし私があなたなら、その仕事を引き受けます。|अगर मैं तुम होता तो नौकरी ले लेता।
If I had more time, I would travel more.||もっと時間があれば、もっと旅行します。|अगर मेरे पास और समय होता तो मैं और यात्रा करता।
If she were here, she would help us.||彼女がいれば、助けてくれるのに。|अगर वह यहाँ होती तो हमारी मदद करती।
If I were rich, I would buy a big house.||お金持ちなら、大きな家を買います。|अगर मैं अमीर होता तो बड़ा घर खरीदता।
If he were taller, he could play basketball.||彼がもっと背が高ければ、バスケができるのに।|अगर वह लंबा होता तो बास्केटबॉल खेल सकता।
If I could fly, I would visit every country.||飛べるなら、すべての国を訪れます。|अगर मैं उड़ सकता तो हर देश घूमता।
If we had a car, we could drive there.||車があれば、そこへ運転して行けるのに।|अगर हमारे पास कार होती तो वहाँ गाड़ी से जा सकते।
If I were the president, I would help the poor.||私が大統領なら、貧しい人を助けます。|अगर मैं राष्ट्रपति होता तो गरीबों की मदद करता।
I wish I were taller.||もっと背が高ければいいのに。|काश मैं लंबा होता।
I wish I could speak English fluently.||英語が流暢に話せればいいのに।|काश मैं धाराप्रवाह अंग्रेज़ी बोल पाता।
If it weren't so expensive, I would buy it.||そんなに高くなければ買うのに।|अगर यह इतना महँगा न होता तो मैं इसे खरीदता।
She talks as if she were the boss.||彼女はまるで上司のように話します。|वह ऐसे बोलती है जैसे वह बॉस हो।
If I were a king, I would be kind.||王なら、優しいでしょう।|अगर मैं राजा होता तो दयालु होता।
I would be happy if I passed the exam.||試験に合格すればうれしいのに।|अगर मैं परीक्षा पास कर लूँ तो खुश होऊँगा।"""),

        eg("eg21", "Conditionals — if... then...", "条件文（if）", "B1",
            "Zero (facts): If you heat ice, it melts. First (real future): If it rains, I will stay home. Second (unreal): If I had time, I would help. Third (past unreal): If I had known, I would have come.",
            "Zero = तथ्य; First = वास्तविक भविष्य (if... will); Second = काल्पनिक (if... would); Third = अतीत की कल्पना (had... would have)।",
            """If you heat ice, it melts.||氷を熱すると溶けます।|अगर बर्फ़ गरम करो तो वह पिघलती है।
If it rains, we will stay home.||雨が降れば家にいます。|अगर बारिश हुई तो हम घर पर रहेंगे।
If you study hard, you will pass.||一生懸命勉強すれば合格します।|अगर तुम मेहनत से पढ़ोगे तो पास हो जाओगे।
If she comes, tell me.||彼女が来たら教えてください।|अगर वह आए तो मुझे बताना।
If I have time, I will call you.||時間があれば電話します。|अगर मेरे पास समय होगा तो फ़ोन करूँगा।
If you don't hurry, you will miss the bus.||急がないとバスに乗り遅れます。|अगर तुमने जल्दी नहीं की तो बस छूट जाएगी।
If I had time, I would help you.||時間があれば手伝うのに।|अगर मेरे पास समय होता तो मदद करता।
If he asked me, I would say yes.||彼が聞いてくれれば、はいと言うのに।|अगर वह मुझसे पूछे तो मैं हाँ कहूँगा।
If I had known, I would have come.||知っていたら来ていたのに।|अगर मुझे पता होता तो आ जाता।
If we had left earlier, we wouldn't have been late.||もっと早く出発していれば遅れなかったのに।|अगर हम जल्दी निकले होते तो देर नहीं होती।
If you touch fire, you get burned.||火に触れるとやけどします。|अगर आग छुओ तो जल जाते हो।
If I were you, I would apologize.||私なら謝ります।|अगर मैं तुम होता तो माफ़ी माँगता।
Unless you work hard, you won't succeed.||努力しないと成功しません。|जब तक मेहनत नहीं करोगे सफल नहीं होगे।
If the weather is nice, we will go out.||天気が良ければ出かけます।|अगर मौसम अच्छा रहा तो हम बाहर जाएँगे।
If you mix red and blue, you get purple.||赤と青を混ぜると紫になります।|लाल और नीला मिलाओ तो बैंगनी बनता है।"""),

        eg("eg22", "Prepositions of place — in / on / at / under / above...", "場所の前置詞", "A1",
            "in = inside a space (in the box, in Delhi); on = touching a surface (on the table); at = a point (at the station, at home); under = below; above = higher than; below = lower than; next to = beside; between = in the middle of two.",
            "in = के अंदर; on = की सतह पर; at = किसी बिंदु पर; under = नीचे; above = ऊपर; next to = बगल में; between = दोनों के बीच।",
            """The book is in the bag.||本はかばんの中にあります。|किताब बैग में है।
The keys are on the table.||鍵はテーブルの上にあります।|चाबियाँ मेज़ पर हैं।
She lives in Delhi.||彼女はデリーに住んでいます।|वह दिल्ली में रहती है।
He is at the station.||彼は駅にいます।|वह स्टेशन पर है।
The cat is under the chair.||猫は椅子の下にいます।|बिल्ली कुर्सी के नीचे है।
The lamp is above the table.||ランプはテーブルの上にあります।|लैंप मेज़ के ऊपर है।
The picture is on the wall.||絵は壁にかかっています।|तस्वीर दीवार पर है।
There is a bank next to the station.||駅の隣に銀行があります।|स्टेशन के बगल में बैंक है।
The shop is between the school and the park.||店は学校と公園の間にあります।|दुकान स्कूल और पार्क के बीच है।
My phone is in my pocket.||携帯はポケットにあります।|मेरा फ़ोन जेब में है।
The birds are flying above the trees.||鳥が木の上を飛んでいます।|पक्षी पेड़ों के ऊपर उड़ रहे हैं।
The temperature is below zero.||気温は零度以下です।|तापमान शून्य से नीचे है।
She is sitting in front of me.||彼女は私の前に座っています।|वह मेरे सामने बैठी है।
He is standing behind the door.||彼はドアの後ろに立っています।|वह दरवाज़े के पीछे खड़ा है।
The water is inside the bottle.||水はびんの中にあります。|पानी बोतल के अंदर है।
The restaurant is on the corner.||レストランは角にあります।|रेस्तराँ कोने पर है।
I live near the park.||私は公園の近くに住んでいます।|मैं पार्क के पास रहता हूँ।
The school is far from here.||学校はここから遠いです।|स्कूल यहाँ से दूर है।
The map is on the wall.||地図は壁にあります।|नक्शा दीवार पर है।
The river flows through the city.||川は街の中を流れています।|नदी शहर के बीच बहती है।"""),

        eg("eg23", "Prepositions of time — at / on / in / for / since", "時間の前置詞", "A1",
            "at + exact time (at 5 o'clock, at noon); on + days/dates (on Monday, on May 5th); in + months/years/seasons/parts of day (in July, in 2024, in the morning); for + duration (for 2 hours); since + starting point (since 2020).",
            "at + ठीक समय; on + दिन/तारीख; in + महीना/साल/मौसम; for + अवधि; since + शुरुआती बिंदु।",
            """The meeting is at 3 o'clock.||会議は三時です।|मीटिंग तीन बजे है।
I wake up at six.||私は六時に起きます।|मैं छह बजे उठता हूँ।
We have lunch at noon.||昼に昼食をとります।|हम दोपहर में खाना खाते हैं।
She goes to bed at midnight.||彼女は真夜中に寝ます।|वह आधी रात को सोती है।
I play football on Sundays.||日曜日にサッカーをします।|मैं रविवार को फ़ुटबॉल खेलता हूँ।
My birthday is on May 5th.||私の誕生日は五月五日です।|मेरा जन्मदिन पाँच मई को है।
We met on a rainy day.||雨の日に会いました।|हम बरसात के दिन मिले थे।
He was born in 1998.||彼は一九九八年生まれです।|उसका जन्म 1998 में हुआ।
The flowers bloom in spring.||花は春に咲きます।|फूल वसंत में खिलते हैं।
I drink coffee in the morning.||朝にコーヒーを飲みます।|मैं सुबह कॉफ़ी पीता हूँ।
We go on vacation in July.||七月に休暇に行きます।|हम जुलाई में छुट्टी पर जाते हैं।
I have lived here for five years.||ここに五年住んでいます।|मैं यहाँ पाँच साल से रह रहा हूँ।
She waited for an hour.||彼女は一時間待ちました।|उसने एक घंटे इंतज़ार किया।
I have known him since 2015.||二〇一五年から彼を知っています।|मैं उसे 2015 से जानता हूँ।
The store opens at 9 and closes at 9.||店は九時に開き、九時に閉まります।|दुकान नौ बजे खुलती और नौ बजे बंद होती है।
We are going to the beach on Saturday.||土曜日に海に行きます।|हम शनिवार को समुद्र तट जा रहे हैं।
It snows in winter.||冬は雪が降ります।|सर्दियों में बर्फ़ गिरती है।
The train leaves in ten minutes.||電車は十分後に出発します।|ट्रेन दस मिनट में निकलेगी।"""),

        eg("eg24", "Prepositions of movement — to / into / through / across...", "移動の前置詞", "A2",
            "to = towards a place (go to school); into = entering (walked into the room); out of = leaving (came out of the house); through = from one side to the other (through the tunnel); across = to the other side (across the road); over = above and across (jump over); up/down = vertical movement.",
            "to = की ओर; into = के अंदर जाना; out of = से बाहर; through = के आर-पार; across = के उस पार; over = के ऊपर से; up/down = ऊपर/नीचे।",
            """I go to school by bus.||学校へバスで行きます।|मैं बस से स्कूल जाता हूँ।
She walked into the room.||彼女は部屋に入りました।|वह कमरे में दाखिल हुई।
He came out of the house.||彼は家から出てきました।|वह घर से बाहर आया।
We drove through the tunnel.||トンネルを通りました。|हम सुरंग से गुज़रे।
They ran across the road.||彼らは道路を走って渡りました।|वे सड़क के उस पार भागे।
The cat jumped over the wall.||猫は壁を飛び越えました।|बिल्ली दीवार के ऊपर कूद गई।
We walked up the hill.||丘を登りました。|हम पहाड़ी पर चढ़े।
She ran down the stairs.||彼女は階段を駆け下りました।|वह सीढ़ियों से भागकर नीचे गई।
Please come to my office.||私のオフィスに来てください।|कृपया मेरे कार्यालय आइए।
The ball rolled under the bed.||ボールはベッドの下に転がりました।|गेंद बिस्तर के नीचे लुढ़क गई।
We flew from Delhi to Tokyo.||デリーから東京まで飛行機で行きました।|हम दिल्ली से टोक्यो उड़े।
He threw the ball into the river.||彼はボールを川に投げ入れました।|उसने गेंद नदी में फेंकी।
She fell off the bike.||彼女は自転車から落ちました।|वह साइकिल से गिर गई।
The dog ran towards me.||犬が私に向かって走ってきました।|कुत्ता मेरी ओर भागा।
Water flows down the mountain.||水は山から流れ落ちます。|पानी पहाड़ से नीचे बहता है।
He looked out of the window.||彼は窓の外を見ました।|उसने खिड़की से बाहर देखा।"""),

        eg("eg25", "a / an / the — articles", "冠詞（a / an / the）", "A1",
            "a/an = one of something, not specific (I saw a dog). an before vowel sounds (an apple). the = specific or already known (The dog I saw was black). No article for general plurals (I like dogs).",
            "a/an = कोई एक, अनिश्चित; an स्वर ध्वनि से पहले; the = विशिष्ट/ज्ञात। सामान्य बहुवचन से पहले कोई article नहीं।",
            """I have a car.||私は車を持っています।|मेरे पास एक कार है।
She is eating an apple.||彼女はりんごを食べています।|वह एक सेब खा रही है।
He bought an umbrella.||彼は傘を買いました।|उसने एक छाता खरीदा।
I saw a movie last night.||昨夜映画を見ました।|मैंने कल रात एक फ़िल्म देखी।
There is a cat on the roof.||屋根の上に猫がいます।|छत पर एक बिल्ली है।
The cat is black.||その猫は黒いです।|वह बिल्ली काली है।
The sun is very bright.||太陽はとても明るいです।|सूरज बहुत चमकीला है।
Please close the door.||ドアを閉めてください।|कृपया दरवाज़ा बंद करो।
She is the best student in class.||彼女はクラスで一番の生徒です।|वह कक्षा की सबसे अच्छी विद्यार्थी है।
I like dogs.||犬が好きです।|मुझे कुत्ते पसंद हैं।
We went to the beach yesterday.||昨日海に行きました।|हम कल समुद्र तट गए।
He is an engineer.||彼はエンジニアです।|वह एक इंजीनियर है।
I need a pen.||ペンが必要です।|मुझे एक कलम चाहिए।
The Earth goes around the Sun.||地球は太陽の周りを回ります।|पृथ्वी सूरज के चारों ओर घूमती है।
Can you pass me the salt?||塩を取ってくれますか?|क्या तुम मुझे नमक दोगे?
She plays the guitar.||彼女はギターを弾きます।|वह गिटार बजाती है।
There's a restaurant near my house.||家の近くにレストランがあります।|मेरे घर के पास एक रेस्तराँ है।
The restaurant is very good.||そのレストランはとてもいいです।|वह रेस्तराँ बहुत अच्छा है।"""),

        eg("eg26", "some / any — a few", "some / any（いくつか）", "A1",
            "some = positive sentences (I have some friends); any = negatives and questions (I don't have any money / Do you have any questions?). Both work with plural and uncountable nouns.",
            "some सकारात्मक में; any नकारात्मक और प्रश्न में। दोनों बहुवचन और अगणनीय संज्ञा के साथ।",
            """I have some friends in Japan.||日本に友達が何人かいます।|जापान में मेरे कुछ दोस्त हैं।
She wants some water.||彼女は水をいくらか欲しがっています।|उसे थोड़ा पानी चाहिए।
We bought some apples.||私たちはりんごをいくつか買いました।|हमने कुछ सेब खरीदे।
There is some milk in the fridge.||冷蔵庫に牛乳がいくらかあります।|फ्रिज में कुछ दूध है।
I need some help.||少し手伝いが必要です।|मुझे कुछ मदद चाहिए।
He gave me some advice.||彼は私に助言をくれました।|उसने मुझे कुछ सलाह दी।
Do you have any questions?||質問はありますか?|क्या आपके पास कोई प्रश्न है?
I don't have any money.||お金がありません।|मेरे पास कोई पैसे नहीं हैं।
She doesn't have any friends here.||彼女にはここに友達がいません।|यहाँ उसका कोई दोस्त नहीं है।
Is there any sugar?||砂糖はありますか?|क्या कुछ चीनी है?
We don't have any time.||時間がありません।|हमारे पास समय नहीं है।
Are there any restaurants nearby?||近くにレストランはありますか?|क्या पास में कोई रेस्तराँ है?
I haven't seen any birds today.||今日は鳥を一羽も見ていません।|मैंने आज कोई पक्षी नहीं देखा।
Would you like some coffee?||コーヒーはいかがですか?|क्या तुम कुछ कॉफ़ी लोगे?
Can I have some rice, please?||ごはんを少しください。|क्या मुझे कुछ चावल मिल सकते हैं?
There aren't any seats left.||席が残っていません।|कोई सीट नहीं बची है।"""),

        eg("eg27", "much / many / a lot of — quantity", "much / many / a lot of（量）", "A1",
            "many + countable plural (many books); much + uncountable (much water); a lot of + both (a lot of friends / a lot of money). much/many usually in questions and negatives; a lot of in positive statements.",
            "many + गिनती योग्य बहुवचन; much + अगणनीय; a lot of + दोनों। सकारात्मक वाक्यों में आमतौर पर a lot of।",
            """How many books do you have?||本を何冊持っていますか?|तुम्हारे पास कितनी किताबें हैं?
How much water do you drink?||水をどのくらい飲みますか?|तुम कितना पानी पीते हो?
There are many people here.||ここにはたくさんの人がいます।|यहाँ बहुत से लोग हैं।
I don't have much time.||時間があまりありません。|मेरे पास ज़्यादा समय नहीं है।
She doesn't have many friends.||彼女には友達があまりいません।|उसके ज़्यादा दोस्त नहीं हैं।
We have a lot of work today.||今日は仕事がたくさんあります।|आज हमारे पास बहुत काम है।
He ate a lot of rice.||彼はごはんをたくさん食べました।|उसने बहुत चावल खाए।
There is a lot of traffic today.||今日は渋滞が多いです।|आज बहुत ट्रैफ़िक है।
How much does it cost?||それはいくらですか?|इसकी कीमत कितनी है?
I don't eat much sugar.||砂糖はあまり食べません。|मैं ज़्यादा चीनी नहीं खाता।
She has many beautiful dresses.||彼女は美しいドレスをたくさん持っています।|उसके पास बहुत सुंदर कपड़े हैं।
We drank much water after the run.||走った後で水をたくさん飲みました।|दौड़ने के बाद हमने बहुत पानी पिया।
There aren't many seats.||席が多くありません।|ज़्यादा सीटें नहीं हैं।
Do you have much homework?||宿題は多いですか?|क्या तुम्हारे पास बहुत होमवर्क है?
A lot of people like music.||多くの人が音楽が好きです।|बहुत से लोगों को संगीत पसंद है।"""),

        eg("eg28", "Comparatives & superlatives — -er / -est / more / most", "比較級・最上級", "A2",
            "Short adjectives add -er/-est (big, bigger, biggest). Long adjectives use more/most (more beautiful). Irregular: good-better-best, bad-worse-worst. than = comparison word. the + superlative.",
            "छोटे विशेषण: -er/-est (bigger, biggest)। लंबे: more/most। अनियमित: good-better-best, bad-worse-worst। तुलना के लिए than।",
            """This book is better than that one.||この本はあの本よりいいです।|यह किताब उससे बेहतर है।
My house is bigger than yours.||私の家はあなたの家より大きいです।|मेरा घर तुम्हारे घर से बड़ा है।
She is taller than her brother.||彼女は兄より背が高いです।|वह अपने भाई से लंबी है।
This test is easier than the last one.||このテストは前より簡単です।|यह परीक्षा पिछली से आसान है।
Mount Everest is the highest mountain.||エベレストは一番高い山です।|माउंट एवरेस्ट सबसे ऊँचा पर्वत है।
He is the best player in the team.||彼はチームで一番の選手です।|वह टीम का सबसे अच्छा खिलाड़ी है।
This is the most beautiful place I know.||これは私が知る中で一番美しい場所です।|यह मेरी जानी सबसे सुंदर जगह है।
Mumbai is bigger than Pune.||ムンバイはプネーより大きいです।|मुंबई पुणे से बड़ा है।
My English is getting better.||英語が上達しています。|मेरी अंग्रेज़ी बेहतर हो रही है।
This coffee is worse than yesterday's.||このコーヒーは昨日よりまずいです।|यह कॉफ़ी कल से ख़राब है।
It is hotter today than yesterday.||今日は昨日より暑いです।|आज कल से ज़्यादा गरम है।
She is the smartest student here.||彼女はここで一番賢い生徒です।|वह यहाँ की सबसे बुद्धिमान विद्यार्थी है।
Trains are faster than buses.||電車はバスより速いです।|ट्रेनें बसों से तेज़ हैं।
This phone is more expensive than mine.||この携帯は私のより高いです।|यह फ़ोन मेरे से ज़्यादा महँगा है।
Which is the cheapest option?||一番安い選択肢はどれですか?|सबसे सस्ता विकल्प कौन सा है?
The older I get, the wiser I become.||年を取るほど賢くなります।|जितना बड़ा होता हूँ उतना समझदार होता हूँ।"""),

        eg("eg29", "Passive voice — is done / was done", "受動態", "B1",
            "be + past participle: The house was built. Focus on the action/object, not who does it. 'by' shows the doer when needed. Tense of 'be' changes: is built, was built, will be built.",
            "be + past participle। क्रिया/वस्तु पर ध्यान देने के लिए। doer दिखाने के लिए by।",
            """English is spoken all over the world.||英語は世界中で話されています।|अंग्रेज़ी दुनिया भर में बोली जाती है।
The house was built in 1990.||その家は一九九〇年に建てられました।|वह घर 1990 में बनाया गया था।
This movie was made in India.||この映画はインドで作られました।|यह फ़िल्म भारत में बनाई गई थी।
The letter was written by my sister.||その手紙は妹が書きました。|पत्र मेरी बहन ने लिखा था।
Rice is grown in this area.||この地域では米が栽培されています।|इस इलाके में चावल उगाया जाता है।
The window was broken last night.||昨夜窓が割られました।|कल रात खिड़की टूट गई थी।
My car was stolen yesterday.||昨日車を盗まれました।|कल मेरी कार चोरी हो गई।
The meeting will be held on Monday.||会議は月曜日に開かれます।|मीटिंग सोमवार को होगी।
These cookies are made by my mother.||このクッキーは母が作ります।|ये कुकीज़ मेरी माँ बनाती हैं।
The rules must be followed.||規則に従わなければなりません।|नियमों का पालन करना ज़रूरी है।
The work has been finished.||仕事は終わりました。|काम खत्म हो चुका है।
He was given a prize.||彼は賞をもらいました।|उसे पुरस्कार दिया गया।
The food was eaten quickly.||食べ物はすぐに食べられました।|खाना जल्दी खा लिया गया।
Smoking is not allowed here.||ここでは喫煙は禁止されています।|यहाँ धूम्रपान की अनुमति नहीं है।
The bridge is being repaired.||橋は修理されています।|पुल की मरम्मत हो रही है।"""),

        eg("eg30", "-ing vs to — gerunds and infinitives", "動名詞とto不定詞", "B1",
            "Some verbs take -ing (I enjoy reading; I finished working). Some take to (I want to go; I decided to stay). Some change meaning (I stopped smoking = quit; I stopped to smoke = took a break to smoke).",
            "कुछ क्रियाओं के बाद -ing (enjoy reading), कुछ के बाद to (want to go)।",
            """I enjoy reading books.||私は本を読むのが好きです।|मुझे किताबें पढ़ना अच्छा लगता है।
She finished cleaning the house.||彼女は家の掃除を終えました।|उसने घर की सफ़ाई खत्म की।
He quit smoking last year.||彼は去年たばこをやめました।|उसने पिछले साल धूम्रपान छोड़ा।
We started learning Spanish.||私たちはスペイン語を学び始めました।|हमने स्पेनिश सीखना शुरू किया।
I want to go home.||家に帰りたいです।|मैं घर जाना चाहता हूँ।
She decided to stay.||彼女は留まることにしました।|उसने रुकने का फैसला किया।
He needs to buy some food.||彼は食べ物を買う必要があります।|उसे कुछ खाना खरीदना है।
We hope to see you soon.||また会えるのを楽しみにしています。|हमें उम्मीद है जल्द मिलेंगे।
I like swimming in the sea.||海で泳ぐのが好きです।|मुझे समुद्र में तैरना पसंद है।
She keeps talking all the time.||彼女はいつも話し続けています।|वह हर समय बोलती रहती है।
They agreed to help us.||彼らは助けることに同意しました।|वे हमारी मदद करने को राज़ी हुए।
I stopped to rest.||私は休むために立ち止まりました।|मैं आराम करने के लिए रुका।
I stopped smoking last year.||去年たばこをやめました।|मैंने पिछले साल धूम्रपान छोड़ दिया।
He avoids eating junk food.||彼はジャンクフードを避けています।|वह जंक फ़ूड खाने से बचता है।
Would you mind closing the door?||ドアを閉めてもらえますか?|क्या तुम दरवाज़ा बंद करोगे?
It started to rain.||雨が降り始めました।|बारिश शुरू हो गई।"""),

        eg("eg31", "Wh-questions — what / where / when / who / why / how", "疑問詞", "A1",
            "what = thing (What is this?); where = place (Where do you live?); when = time (When is the party?); who = person (Who is she?); why = reason (Why are you sad?); how = manner/way (How are you? / How does it work?).",
            "what = क्या/कौन सी चीज़; where = कहाँ; when = कब; who = कौन; why = क्यों; how = कैसे।",
            """What is your name?||お名前は何ですか?|तुम्हारा नाम क्या है?
What do you do?||何の仕事をしていますか?|तुम क्या करते हो?
Where do you live?||どこに住んでいますか?|तुम कहाँ रहते हो?
Where is the station?||駅はどこですか?|स्टेशन कहाँ है?
When is your birthday?||誕生日はいつですか?|तुम्हारा जन्मदिन कब है?
When does the train leave?||電車はいつ出発しますか?|ट्रेन कब निकलती है?
Who is that man?||あの男の人は誰ですか?|वह आदमी कौन है?
Who called you?||誰があなたに電話しましたか?|तुम्हें किसने फ़ोन किया?
Why are you late?||なぜ遅れたのですか?|तुम देर से क्यों आए?
Why is the sky blue?||空はなぜ青いのですか?|आसमान नीला क्यों है?
How are you?||お元気ですか?|आप कैसे हैं?
How do you get to work?||どうやって仕事に行きますか?|तुम काम पर कैसे जाते हो?
How much is this?||これはいくらですか?|यह कितने का है?
How many people are coming?||何人来ますか?|कितने लोग आ रहे हैं?
Which one do you want?||どれが欲しいですか?|तुम्हें कौन सा चाहिए?
Whose bag is this?||これは誰のかばんですか?|यह किसका बैग है?
What time is it?||今何時ですか?|कितने बजे हैं?
How long does it take?||どのくらいかかりますか?|कितना समय लगता है?
Where are you from?||どこの出身ですか?|तुम कहाँ से हो?
What kind of music do you like?||どんな音楽が好きですか?|तुम्हें कैसा संगीत पसंद है?"""),

        eg("eg32", "Reported speech — he said that...", "間接話法", "B2",
            "Report someone's words: He said (that) he was tired. Tenses move back one step: 'I am' → he was; 'I will' → he would; 'I have' → he had. 'today' → that day, 'here' → there.",
            "किसी की बात दोहराने के लिए: He said (that)...। काल एक कदम पीछे खिसक जाता है: am → was, will → would।",
            """He said he was tired.||彼は疲れたと言いました。|उसने कहा वह थका हुआ था।
She said she would call me.||彼女は電話すると言いました।|उसने कहा वह मुझे फ़ोन करेगी।
They said they were happy.||彼らは幸せだと言いました।|उन्होंने कहा वे खुश थे।
I told him I didn't know.||私は知らないと彼に言いました।|मैंने उसे बताया मुझे नहीं पता।
She said she had finished the work.||彼女は仕事を終えたと言いました।|उसने कहा उसने काम खत्म कर लिया था।
He told me to wait.||彼は私に待つように言いました।|उसने मुझे इंतज़ार करने को कहा।
They asked where the station was.||彼らは駅はどこかと尋ねました।|उन्होंने पूछा स्टेशन कहाँ था।
She asked if I was okay.||彼女は大丈夫かどうか尋ねました।|उसने पूछा क्या मैं ठीक था।
He said that he would come tomorrow.||彼は明日来ると言いました।|उसने कहा वह कल आएगा।
I said I was going home.||私は家に帰ると言いました।|मैंने कहा मैं घर जा रहा था।
She told me that she loved me.||彼女は私を愛していると言いました।|उसने मुझसे कहा वह मुझसे प्यार करती है।
They said they had seen the movie.||彼らはその映画を見たと言いました।|उन्होंने कहा उन्होंने वह फ़िल्म देखी थी।
He asked me to help him.||彼は私に助けてと頼みました।|उसने मुझसे मदद माँगी।
She said it was raining outside.||彼女は外は雨が降っていると言いました।|उसने कहा बाहर बारिश हो रही थी।
I told them I would be late.||私は遅れると彼らに伝えました।|मैंने उन्हें बताया मुझे देर होगी।""")
    )
}
