package com.nexo.kotoba

/**
 * The complete English tense system, written for learners.
 *
 * Every tense is one [Pattern] with a detailed rule (usage, when to use it,
 * form, negative, question and a tip about the classic mistake) plus twelve
 * example sentences carrying a Japanese and a Hindi translation. The Grammar
 * screen shows these under the "Tenses" section whenever English is the
 * language being learned.
 */
object Tenses {

    private fun tp(id: String, titleEn: String, titleJa: String, level: String, ruleEn: String, ruleHi: String, raw: String): Pattern =
        Pattern(id, titleEn, titleJa, "en", ruleEn, "", gex(raw), ruleHi, level, "english")

    private fun gex(raw: String): List<PatternExample> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val c = line.split("||")
            val d = c.getOrElse(1) { "" }.split("|")
            PatternExample("💤", c[0], d.getOrElse(0) { "" }, d.getOrElse(0) { "" }, d.getOrElse(1) { "" })
        }.toList()

    val patterns: List<Pattern> = listOf(
        tp("t1", "Present Simple — facts, habits & routines", "現在形（事実・習慣）", "A1",
            "USAGE: The present simple describes things that are always or generally true, and actions you do again and again — habits, routines and fixed schedules. It is the tense you use to talk about your daily life, your job, your likes and your opinions.\nWHEN: Use it with always, usually, often, sometimes, never, every day, every morning, once a week, on Mondays. Facts: Water boils at 100 degrees. Habits: I walk to work. Timetables: The train leaves at six.\nFORM: Subject + base verb. With he / she / it add -s or -es: I work, you work, he works, she watches, it rains. After a consonant + y change to -ies: study → studies, carry → carries.\nNEGATIVE: do not / don't + base verb; he / she / it → does not / doesn't + base verb: I don't like coffee. She doesn't eat meat.\nQUESTION: Do / Does + subject + base verb? Do you speak English? Does he live here?\nTIP: After does / doesn't the verb loses its -s. Say \"She doesn't like it\", never \"She doesn't likes it\". After he / she / it, don't forget the -s — \"He work here\" is wrong.",
            "उपयोग: सामान्य वर्तमान काल उन बातों के लिए है जो हमेशा सच होती हैं, और उन कामों के लिए जो बार-बार होते हैं — आदतें, दिनचर्या और निश्चित समय-सारणी। इसी काल से हम अपनी रोज़मर्रा की ज़िंदगी, काम, पसंद और राय बताते हैं।\nकब: always, usually, often, sometimes, never, every day, once a week, on Mondays के साथ। सच्चाई: Water boils at 100 degrees. आदत: I walk to work. समय-सारणी: The train leaves at six.\nरूप: Subject + क्रिया का मूल रूप। he / she / it के साथ -s या -es जोड़ें: I work, he works, she watches, it rains। consonant + y हो तो -ies: study → studies।\nनकारात्मक: do not / don't + मूल क्रिया; he / she / it → does not / doesn't + मूल क्रिया: I don't like coffee. She doesn't eat meat.\nप्रश्न: Do / Does + subject + मूल क्रिया? Do you speak English? Does he live here?\nटिप: does / doesn't के बाद क्रिया से -s हट जाता है। \"She doesn't likes\" गलत है। he / she / it के बाद -s भूलें नहीं — \"He work here\" गलत है।",
            """I drink tea every morning.||私は毎朝お茶を飲みます。|मैं हर सुबह चाय पीता हूँ।
She works at a hospital.||彼女は病院で働いています。|वह अस्पताल में काम करती है।
We go to the gym twice a week.||私たちは週に二回ジムに行きます।|हम हफ़्ते में दो बार जिम जाते हैं।
He doesn't eat meat.||彼は肉を食べません।|वह मांस नहीं खाता।
Do you speak English?||英語を話しますか।|क्या तुम अंग्रेज़ी बोलते हो?
The sun rises in the east.||太陽は東から昇ります।|सूरज पूर्व से उगता है।
My father usually drives to work.||父はたいてい車で仕事に行きます।|मेरे पिता आमतौर पर कार से काम पर जाते हैं।
She never drinks coffee at night.||彼女は夜にコーヒーを飲みません।|वह रात में कभी कॉफ़ी नहीं पीती।
Does he live near here?||彼はこの近くに住んでいますか।|क्या वह यहाँ पास में रहता है?
I don't understand this question.||私はこの質問がわかりません।|मुझे यह सवाल समझ नहीं आता।
Water boils at 100 degrees.||水は100度で沸騰します।|पानी 100 डिग्री पर उबलता है।
The train leaves at six in the morning.||電車は朝六時に出発します।|ट्रेन सुबह छह बजे निकलती है।"""),

        tp("t2", "Present Continuous — happening right now", "現在進行形", "A1",
            "USAGE: Describe an action happening at this exact moment, around now, or a temporary situation that will not last. It is also used for definite future arrangements and for situations that are slowly changing.\nWHEN: now, right now, at the moment, currently, today, this week, look!, listen!. Future arrangements: I'm meeting her tomorrow.\nFORM: am / is / are + verb-ing. I am studying. She is cooking. They are playing. Drop a silent e: write → writing. Double the final consonant after one vowel: run → running, sit → sitting.\nNEGATIVE: am / is / are + not + verb-ing. He isn't sleeping.\nQUESTION: Am / Is / Are + subject + verb-ing? Are you listening to me?\nTIP: State verbs like know, like, want, need, believe and understand are almost never used in the continuous. Say \"I know the answer\", not \"I am knowing\".",
            "उपयोग: किसी ऐसे काम के लिए जो ठीक इसी समय हो रहा है, आसपास के समय में हो रहा है, या कुछ समय का अस्थायी हाल है। यह निश्चित भविष्य की योजनाओं और धीरे-धीरे बदलती स्थितियों के लिए भी आता है।\nकब: now, right now, at the moment, currently, today, this week, look!, listen!। भविष्य की योजना: I'm meeting her tomorrow.\nरूप: am / is / are + verb-ing। I am studying. She is cooking. silent e हटाएँ: write → writing। एक स्वर के बाद अंतिम व्यंजन दोहराएँ: run → running.\nनकारात्मक: am / is / are + not + verb-ing। He isn't sleeping.\nप्रश्न: Am / Is / Are + subject + verb-ing? Are you listening to me?\nटिप: know, like, want, need, believe जैसी अवस्था बताने वाली क्रियाएँ continuous में नहीं आती। \"I am knowing\" गलत है, \"I know the answer\" सही है।",
            """I am reading a good book right now.||今、いい本を読んでいます。|मैं अभी एक अच्छी किताब पढ़ रहा हूँ।
She is cooking dinner at the moment.||彼女は今夕食を作っています।|वह इस समय रात का खाना बना रही है।
They are playing football in the park.||彼らは公園でサッカーをしています।|वे पार्क में फ़ुटबॉल खेल रहे हैं।
Listen! The baby is crying.||聞いて！赤ちゃんが泣いています।|सुनो! बच्चा रो रहा है।
He isn't working today.||彼は今日働いていません।|वह आज काम नहीं कर रहा है।
Are you listening to me?||私の話を聞いていますか।|क्या तुम मेरी बात सुन रहे हो?
We are staying at a hotel this week.||私たちは今週ホテルに泊まっています।|हम इस हफ़्ते होटल में ठहर रहे हैं।
The weather is getting colder.||天気が寒くなってきています।|मौसम ठंडा होता जा रहा है।
I am meeting my friend tomorrow.||明日友達に会います।|मैं कल अपने दोस्त से मिल रहा हूँ।
What are you doing right now?||今何をしていますか।|तुम अभी क्या कर रहे हो?
She is wearing a red dress today.||彼女は今日赤いドレスを着ています।|वह आज लाल कपड़े पहनी हुई है।
Look! It is starting to rain.||見て！雨が降り始めています।|देखो! बारिश शुरू हो रही है।"""),

        tp("t3", "Present Perfect — have / has + past participle", "現在完了", "A2",
            "USAGE: The present perfect connects the past to the present. Use it for experiences when you do not say when, for actions that finished but whose result matters now, and for situations that began in the past and are still true.\nWHEN: just, already, yet, ever, never, so far, recently, lately, this week, since 2019, for three years.\nFORM: have / has + past participle (3rd form). I have finished. She has eaten. Regular verbs end in -ed; irregular verbs have their own form: go → gone, see → seen, do → done.\nNEGATIVE: have / has + not + 3rd form. I haven't seen it.\nQUESTION: Have / Has + subject + 3rd form? Have you ever been to Japan?\nTIP: Never use a finished past time with it. Say \"I have visited Paris\" (experience, no time) but \"I visited Paris in 2019\" (finished time). \"I have visited Paris last year\" is wrong.",
            "उपयोग: present perfect भूत को वर्तमान से जोड़ता है। इसका प्रयोग अनुभव बताने के लिए (समय बताए बिना), उन कामों के लिए जो हो चुके पर उनका नतीजा अब मायने रखता है, और उन स्थितियों के लिए जो भूतकाल में शुरू होकर अब भी चल रही हैं।\nकब: just, already, yet, ever, never, so far, recently, lately, this week, since 2019, for three years.\nरूप: have / has + क्रिया का तीसरा रूप (V3)। I have finished. She has eaten. नियमित क्रियाओं में -ed; अनियमित का अपना रूप: go → gone, see → seen, do → done.\nनकारात्मक: have / has + not + V3। I haven't seen it.\nप्रश्न: Have / Has + subject + V3? Have you ever been to Japan?\nटिप: इसके साथ बीते हुए समय का ज़िक्र कभी न करें। \"I have visited Paris\" (अनुभव) सही है, पर \"I visited Paris in 2019\" (निश्चित बीता समय) सही है। \"I have visited Paris last year\" गलत है।",
            """I have finished my homework.||宿題を終えました。|मैंने अपना होमवर्क पूरा कर लिया है।
She has just left the office.||彼女はちょうどオフィスを出ました।|वह अभी-अभी दफ़्तर से निकली है।
Have you ever been to Japan?||日本に行ったことがありますか।|क्या तुम कभी जापान गए हो?
We have lived here for ten years.||私たちはここに十年住んでいます।|हम यहाँ दस साल से रह रहे हैं।
He has never eaten sushi.||彼は寿司を食べたことがありません।|उसने कभी सुशी नहीं खाई।
I haven't seen that movie yet.||私はまだその映画を見ていません।|मैंने वह फ़िल्म अभी तक नहीं देखी।
She has worked here since 2019.||彼女は2019年からここで働いています।|वह 2019 से यहाँ काम कर रही है।
They have already gone home.||彼らはもう家に帰りました।|वे पहले ही घर जा चुके हैं।
The train has just arrived.||電車がちょうど着きました।|ट्रेन अभी-अभी पहुँची है।
How long have you known him?||彼とどのくらい知り合いですか।|तुम उसे कितने समय से जानते हो?
I have lost my keys.||鍵をなくしてしまいました。|मैंने अपनी चाबियाँ खो दी हैं।
She has never been late before.||彼女は今まで一度も遅刻したことがありません।|वह पहले कभी देर से नहीं आई।"""),

        tp("t4", "Present Perfect Continuous — have been doing", "現在完了進行形", "B1",
            "USAGE: Focuses on how long an action has been happening, or on the fact that it has been going on right up to now and may still continue. The length of time or the ongoing activity matters more than the finished result.\nWHEN: for two hours, since morning, all day, all week, how long...?, lately, recently.\nFORM: have / has + been + verb-ing. I have been waiting. She has been studying.\nNEGATIVE: haven't / hasn't + been + verb-ing. I haven't been sleeping well.\nQUESTION: Have / Has + subject + been + verb-ing? How long have you been waiting?\nTIP: Use it when the duration matters: \"I have been learning English for two years\" (and I still am). Compare with \"I have learned 500 words\" (a result or a count).",
            "उपयोग: यह बताता है कि कोई काम कितने समय से हो रहा है, या वह अब तक चलता आ रहा है और आगे भी चल सकता है। यहाँ समय की अवधि या जारी रहना ज़्यादा मायने रखता है, पूरा हो चुका नतीजा नहीं।\nकब: for two hours, since morning, all day, all week, how long...?, lately, recently.\nरूप: have / has + been + verb-ing। I have been waiting. She has been studying.\nनकारात्मक: haven't / hasn't + been + verb-ing। I haven't been sleeping well.\nप्रश्न: Have / Has + subject + been + verb-ing? How long have you been waiting?\nटिप: जब अवधि मायने रखती है तब इसका प्रयोग करें: \"I have been learning English for two years\" (और अभी भी सीख रहा हूँ)। तुलना करें: \"I have learned 500 words\" (नतीजा/गिनती)।",
            """I have been waiting for you for an hour.||私は一時間あなたを待っています。|मैं एक घंटे से तुम्हारा इंतज़ार कर रहा हूँ।
She has been studying English since she was ten.||彼女は十歳から英語を勉強しています।|वह दस साल की उम्र से अंग्रेज़ी पढ़ रही है।
It has been raining all morning.||午前中ずっと雨が降っています।|सुबह से बारिश हो रही है।
How long have you been working here?||ここでどのくらい働いていますか।|तुम यहाँ कितने समय से काम कर रहे हो?
They have been talking on the phone for two hours.||彼らは二時間電話で話しています।|वे दो घंटे से फ़ोन पर बात कर रहे हैं।
My eyes are tired because I have been reading all day.||一日中読書していたので目が疲れました।|दिन भर पढ़ने से मेरी आँखें थक गई हैं।
He hasn't been feeling well lately.||彼は最近体調が良くありません।|वह हाल ही में ठीक महसूस नहीं कर रहा।
The children have been playing outside since noon.||子供たちは正午から外で遊んでいます।|बच्चे दोपहर से बाहर खेल रहे हैं।
I have been learning to cook this year.||今年は料理を習っています।|मैं इस साल खाना बनाना सीख रहा हूँ।
She has been working on this project all week.||彼女は一週間ずっとこのプロジェクトに取り組んでいます।|वह पूरे हफ़्ते इस प्रोजेक्ट पर काम कर रही है।
We have been living in this city for six years.||私たちはこの街に六年住んでいます।|हम इस शहर में छह साल से रह रहे हैं।
The dog has been barking since you left.||あなたが出てから犬が吠え続けています।|तुम्हारे जाने के बाद से कुत्ता भौंक रहा है।"""),

        tp("t5", "Past Simple — finished actions", "過去形", "A1",
            "USAGE: For actions and situations that started and finished in the past, especially when you say when they happened. It is the main tense for telling a story or reporting what happened.\nWHEN: yesterday, last night, last week, two days ago, in 2010, then, when I was young.\nFORM: Regular verbs add -ed (work → worked, love → loved, carry → carried, stop → stopped). Irregular verbs have their own form: go → went, see → saw, have → had, come → came.\nNEGATIVE: did not / didn't + base verb. I didn't go.\nQUESTION: Did + subject + base verb? Did you see him?\nTIP: After did / didn't use the base form, never the past form. \"Did you went?\" is wrong — say \"Did you go?\".",
            "उपयोग: उन कामों और स्थितियों के लिए जो भूतकाल में शुरू हुए और ख़त्म हो गए, ख़ासकर जब आप बताएँ कि वे कब हुए। कहानी सुनाने या हुई घटना बताने का यह मुख्य काल है।\nकब: yesterday, last night, last week, two days ago, in 2010, then, when I was young.\nरूप: नियमित क्रियाओं में -ed (work → worked, carry → carried, stop → stopped)। अनियमित क्रियाओं का अपना रूप: go → went, see → saw, have → had, come → came.\nनकारात्मक: did not / didn't + मूल क्रिया। I didn't go.\nप्रश्न: Did + subject + मूल क्रिया? Did you see him?\nटिप: did / didn't के बाद मूल रूप आता है, कभी भूतकाल नहीं। \"Did you went?\" गलत है — \"Did you go?\" सही है।",
            """I visited my grandmother last weekend.||先週末、祖母を訪ねました。|मैं पिछले सप्ताहांत अपनी दादी से मिलने गया।
She called me two hours ago.||彼女は二時間前に電話してきました।|उसने दो घंटे पहले मुझे फ़ोन किया।
We watched a great movie yesterday.||昨日、素晴らしい映画を見ました।|हमने कल एक बढ़िया फ़िल्म देखी।
He didn't come to the party.||彼はパーティーに来ませんでした।|वह पार्टी में नहीं आया।
Did you finish your work?||仕事を終えましたか।|क्या तुमने अपना काम पूरा किया?
They went to Spain in 2019.||彼らは2019年にスペインへ行きました।|वे 2019 में स्पेन गए थे।
I was very tired last night.||昨夜はとても疲れていました।|मैं कल रात बहुत थका हुआ था।
She bought a new phone last week.||彼女は先週新しい携帯を買いました।|उसने पिछले हफ़्ते नया फ़ोन ख़रीदा।
When I was young, I played the piano.||子供の頃、ピアノを弾いていました।|जब मैं छोटा था, मैं पियानो बजाता था।
What did you do last night?||昨夜何をしましたか।|तुमने कल रात क्या किया?
The meeting started at nine o'clock.||会議は九時に始まりました।|मीटिंग नौ बजे शुरू हुई।
I met him at the station yesterday.||昨日駅で彼に会いました।|कल मैं उससे स्टेशन पर मिला।"""),

        tp("t6", "Past Continuous — was / were doing", "過去進行形", "A2",
            "USAGE: An action that was in progress at a particular moment in the past, often interrupted by another action. It sets the scene, describing the background of a story.\nWHEN: at 8 o'clock last night, while, when, at that time, all day yesterday.\nFORM: was / were + verb-ing. I was sleeping. They were waiting.\nNEGATIVE: wasn't / weren't + verb-ing. He wasn't listening.\nQUESTION: Was / Were + subject + verb-ing? Were you sleeping?\nTIP: Use the past continuous for the longer background action and the past simple for the short action that interrupts it: \"I was cooking when the phone rang.\"",
            "उपयोग: कोई काम जो भूतकाल के किसी ख़ास पल में चल रहा था, अक्सर किसी दूसरे काम से टूट जाता है। यह कहानी की पृष्ठभूमि बनाता है।\nकब: at 8 o'clock last night, while, when, at that time, all day yesterday.\nरूप: was / were + verb-ing। I was sleeping. They were waiting.\nनकारात्मक: wasn't / weren't + verb-ing। He wasn't listening.\nप्रश्न: Was / Were + subject + verb-ing? Were you sleeping?\nटिप: लंबे चलने वाले काम के लिए past continuous और उसे बाधित करने वाले छोटे काम के लिए past simple रखें: \"I was cooking when the phone rang.\"",
            """I was watching TV when you called.||あなたが電話したとき、テレビを見ていました。|जब तुमने फ़ोन किया, मैं टीवी देख रहा था।
She was cooking dinner at eight o'clock.||八時に彼女は夕食を作っていました।|आठ बजे वह रात का खाना बना रही थी।
They were playing outside all afternoon.||彼らは午後中ずっと外で遊んでいました।|वे पूरी दोपहर बाहर खेल रहे थे।
It was raining when we left the house.||私たちが家を出たとき雨が降っていました।|जब हम घर से निकले तो बारिश हो रही थी।
He wasn't listening to the teacher.||彼は先生の話を聞いていませんでした।|वह शिक्षक की बात नहीं सुन रहा था।
Were you sleeping when I called?||私が電話したとき寝ていましたか।|जब मैंने फ़ोन किया, तुम सो रहे थे?
While I was studying, my brother was playing games.||私が勉強している間、弟はゲームをしていました।|जब मैं पढ़ रहा था, मेरा भाई गेम खेल रहा था।
The sun was shining and the birds were singing.||太陽が輝き、鳥が鳴いていました।|सूरज चमक रहा था और पक्षी गा रहे थे।
What were you doing at ten last night?||昨夜十時に何をしていましたか।|तुम कल रात दस बजे क्या कर रहे थे?
She was walking home when she saw the accident.||事故を見たとき、彼女は歩いて家に帰っていました।|जब उसने दुर्घटना देखी, वह पैदल घर जा रही थी।
I was taking a shower when the bell rang.||ベルが鳴ったとき、私はシャワーを浴びていました。|जब घंटी बजी, मैं नहा रहा था।
They were talking quietly in the corner.||彼らは隅で静かに話していました।|वे कोने में चुपचाप बात कर रहे थे।"""),

        tp("t7", "Past Perfect — had + past participle", "過去完了", "B1",
            "USAGE: The \"past of the past\". Use it for the earlier of two past actions, or for something that had already happened before a moment in the past. It makes the order of past events crystal clear.\nWHEN: before, after, already, by the time, when (for the earlier event), never ... before.\nFORM: had + past participle (3rd form) for every subject. I had finished. She had left.\nNEGATIVE: had not / hadn't + 3rd form. We hadn't eaten.\nQUESTION: Had + subject + 3rd form? Had you eaten before you came?\nTIP: Use had + V3 for the action that happened first. \"When I arrived, the train had left\" — the train left first, then I arrived.",
            "उपयोग: यह \"भूतकाल का भूतकाल\" है। दो भूतकालीन कामों में से पहले वाले के लिए, या भूतकाल के किसी पल से पहले पूरा हो चुके काम के लिए। इससे घटनाओं का क्रम साफ़ हो जाता है।\nकब: before, after, already, by the time, when (पहली घटना के लिए), never ... before.\nरूप: हर subject के लिए had + क्रिया का तीसरा रूप (V3)। I had finished. She had left.\nनकारात्मक: had not / hadn't + V3। We hadn't eaten.\nप्रश्न: Had + subject + V3? Had you eaten before you came?\nटिप: जो काम पहले हुआ उसके लिए had + V3 रखें। \"When I arrived, the train had left\" — पहले ट्रेन गई, फिर मैं पहुँचा।",
            """The train had already left when we arrived.||私たちが着いたとき、電車はもう出ていました。|जब हम पहुँचे, ट्रेन पहले ही निकल चुकी थी।
She had finished her homework before dinner.||彼女は夕食前に宿題を終えていました।|उसने रात के खाने से पहले होमवर्क पूरा कर लिया था।
I had never seen snow before that trip.||その旅行の前に雪を見たことがありませんでした।|उस यात्रा से पहले मैंने कभी बर्फ़ नहीं देखी थी।
By the time he called, I had gone to bed.||彼が電話したときには、私は寝ていました。|जब उसने फ़ोन किया, तब तक मैं सो चुका था।
They had lived in Paris for five years before moving here.||ここに引っ越す前、彼らは五年間パリに住んでいました।|यहाँ आने से पहले वे पाँच साल पेरिस में रहे थे।
He had already eaten, so he wasn't hungry.||彼はもう食べていたのでお腹が空いていませんでした।|वह पहले ही खा चुका था, इसलिए भूखा नहीं था।
I realized that I had forgotten my keys.||鍵を忘れたことに気づきました।|मुझे एहसास हुआ कि मैं अपनी चाबियाँ भूल गया था।
Had you met him before the meeting?||会議の前に彼に会ったことがありましたか।|क्या तुम मीटिंग से पहले उससे मिले थे?
She had just started working when the lights went out.||明かりが消えたとき、彼女は働き始めたばかりでした।|जब बत्तियाँ बुझीं, वह अभी-अभी काम शुरू कर चुकी थी।
We hadn't eaten all day, so we were starving.||一日中何も食べていなかったので、お腹がぺこぺこでした।|हमने दिन भर कुछ नहीं खाया था, इसलिए बहुत भूखे थे।
Everything was quiet because the guests had left.||客が帰ったので、すべてが静かでした。|मेहमान जा चुके थे, इसलिए सब शांत था।
I knew the film had started before we sat down.||座る前に映画が始まっていたのはわかっていました。|मुझे पता था कि हमारे बैठने से पहले फ़िल्म शुरू हो चुकी थी।"""),

        tp("t8", "Past Perfect Continuous — had been doing", "過去完了進行形", "B2",
            "USAGE: Shows how long an action had been going on before another past moment or action. It emphasises the duration or the continuous activity leading up to a past event.\nWHEN: for two hours, since morning, all day, before, when, by the time.\nFORM: had + been + verb-ing (the same for every subject). I had been waiting.\nNEGATIVE: hadn't been + verb-ing. She hadn't been feeling well.\nQUESTION: Had + subject + been + verb-ing? How long had you been waiting?\nTIP: Compare \"I had been waiting for an hour when the bus came\" (duration before a past event) with \"I had waited\" (simply finished). The continuous form makes the waiting itself the point.",
            "उपयोग: यह बताता है कि कोई काम भूतकाल के किसी दूसरे पल या घटना से पहले कितने समय से चल रहा था। यह अवधि या लगातार चलते आ रहे काम पर ज़ोर देता है।\nकब: for two hours, since morning, all day, before, when, by the time.\nरूप: had + been + verb-ing (हर subject के लिए समान)। I had been waiting.\nनकारात्मक: hadn't been + verb-ing। She hadn't been feeling well.\nप्रश्न: Had + subject + been + verb-ing? How long had you been waiting?\nटिप: \"I had been waiting for an hour when the bus came\" (घटना से पहले अवधि) और \"I had waited\" (बस पूरा होना) की तुलना करें।",
            """I had been waiting for an hour when the bus finally came.||バスがやっと来たとき、私は一時間待っていました。|जब बस आख़िरकार आई, मैं एक घंटे से इंतज़ार कर रहा था।
She had been working there for ten years before she quit.||彼女は辞める前に十年間そこで働いていました।|नौकरी छोड़ने से पहले वह दस साल वहाँ काम कर रही थी।
They had been arguing for hours by the time I arrived.||私が着いたときには、彼らは何時間も口論していました。|मेरे पहुँचने तक वे घंटों बहस कर रहे थे।
It had been raining all night, so the roads were wet.||一晩中雨が降っていたので、道路は濡れていました।|रात भर बारिश हो रही थी, इसलिए सड़कें गीली थीं।
He was tired because he had been running.||彼は走っていたので疲れていました।|वह दौड़ रहा था, इसलिए थका हुआ था।
How long had you been studying before the exam?||試験前にどのくらい勉強していましたか।|परीक्षा से पहले तुम कितनी देर पढ़ रहे थे?
We had been driving for three hours when we stopped for lunch.||昼食のために止まったとき、私たちは三時間運転していました।|जब हम दोपहर के खाने के लिए रुके, हम तीन घंटे से गाड़ी चला रहे थे।
She hadn't been feeling well, so she went home early.||彼女は体調が良くなかったので早く帰りました।|वह ठीक महसूस नहीं कर रही थी, इसलिए जल्दी घर चली गई।
The children had been playing in the mud before they came inside.||子供たちは中に入る前、泥で遊んでいました।|अंदर आने से पहले बच्चे कीचड़ में खेल रहे थे।
I had been thinking about it all week before I decided.||決める前に一週間ずっと考えていました।|फ़ैसला करने से पहले मैं पूरे हफ़्ते इसके बारे में सोच रहा था।
The ground was wet because it had been raining.||雨が降り続いていたので地面は濡れていました।|बारिश हो रही थी, इसलिए ज़मीन गीली थी।
He had been learning Japanese for two years before he moved there.||彼は引っ越す前に二年間日本語を学んでいました।|वहाँ जाने से पहले वह दो साल जापानी सीख रहा था।"""),

        tp("t9", "Future Simple — will + base verb", "未来形（will）", "A1",
            "USAGE: For predictions, promises, offers, quick decisions made at the moment of speaking, and general facts about the future.\nWHEN: tomorrow, next week, in 2050, soon, later, I think..., probably, maybe, one day.\nFORM: will + base verb (the same for every subject). I will call. She will come. Short forms: I'll, she'll, we'll.\nNEGATIVE: will not / won't + base verb. He won't come.\nQUESTION: Will + subject + base verb? Will you help me?\nTIP: Use \"will\" for a decision you make now (\"I'll have the tea\") and \"going to\" for a plan made earlier. After when, before, as soon as and until, use the present simple, not will: \"When I get home, I'll call you.\"",
            "उपयोग: भविष्यवाणी, वादे, प्रस्ताव, बोलते समय किए गए तुरंत फ़ैसलों और भविष्य के सामान्य तथ्यों के लिए।\nकब: tomorrow, next week, in 2050, soon, later, I think..., probably, maybe, one day.\nरूप: will + क्रिया का मूल रूप (हर subject के लिए समान)। I will call. She will come. छोटा रूप: I'll, she'll, we'll.\nनकारात्मक: will not / won't + मूल क्रिया। He won't come.\nप्रश्न: Will + subject + मूल क्रिया? Will you help me?\nटिप: अभी का फ़ैसला \"will\" से (\"I'll have the tea\") और पहले से बनी योजना \"going to\" से। when, before, as soon as, until के बाद will नहीं, present simple आता है: \"When I get home, I'll call you.\"",
            """I will call you tomorrow.||明日電話します。|मैं कल तुम्हें फ़ोन करूँगा।
She will be twenty next month.||彼女は来月二十歳になります。|वह अगले महीने बीस साल की हो जाएगी।
It will rain this evening.||今晩雨が降るでしょう।|आज शाम बारिश होगी।
I will help you with that.||それを手伝いますよ।|मैं उसमें तुम्हारी मदद करूँगा।
They won't arrive before noon.||彼らは正午前に着きません।|वे दोपहर से पहले नहीं पहुँचेंगे।
Will you come to my party?||私のパーティーに来ますか।|क्या तुम मेरी पार्टी में आओगे?
Don't worry — I'll pay for dinner.||心配しないで、夕食は私が払います।|चिंता मत करो — रात का खाना मैं चुकाऊँगा।
I think she will pass the exam.||彼女は試験に合格すると思います।|मुझे लगता है वह परीक्षा पास करेगी।
We will meet again soon.||またすぐ会いましょう।|हम जल्द फिर मिलेंगे।
He will never forget this day.||彼はこの日を決して忘れません।|वह इस दिन को कभी नहीं भूलेगा।
I'll send you the details later.||後で詳細を送ります。|मैं तुम्हें बाद में जानकारी भेज दूँगा।
The shops will be closed tomorrow.||明日店は閉まっています。|कल दुकानें बंद रहेंगी।"""),

        tp("t10", "Future Continuous — will be doing", "未来進行形", "B1",
            "USAGE: An action that will be in progress at a certain time in the future. It is also used for arrangements and for polite questions about someone's plans.\nWHEN: at 8 o'clock tomorrow, this time next week, when you arrive, all day tomorrow.\nFORM: will be + verb-ing (the same for every subject). I will be working.\nNEGATIVE: won't be + verb-ing. He won't be joining us.\nQUESTION: Will + subject + be + verb-ing? Will you be using the car?\nTIP: \"This time tomorrow I will be flying to Tokyo\" means the action will be happening then. It is also a very polite way to ask about plans: \"Will you be joining us for dinner?\"",
            "उपयोग: कोई काम जो भविष्य के किसी ख़ास समय पर चल रहा होगा। यह निश्चित कार्यक्रमों और किसी की योजना के बारे में विनम्र प्रश्नों के लिए भी आता है।\nकब: at 8 o'clock tomorrow, this time next week, when you arrive, all day tomorrow.\nरूप: will be + verb-ing (हर subject के लिए समान)। I will be working.\nनकारात्मक: won't be + verb-ing। He won't be joining us.\nप्रश्न: Will + subject + be + verb-ing? Will you be using the car?\nटिप: \"This time tomorrow I will be flying to Tokyo\" का अर्थ है उस समय वह काम चल रहा होगा। योजना पूछने का बहुत विनम्र तरीका: \"Will you be joining us for dinner?\"",
            """This time tomorrow I will be flying to Tokyo.||明日の今頃、私は東京へ飛んでいます。|कल इसी समय मैं टोक्यो जा रहा हूँगा।
She will be working late tonight.||彼女は今夜遅くまで働いています。|वह आज रात देर तक काम कर रही होगी।
At eight o'clock we will be having dinner.||八時に私たちは夕食を食べています।|आठ बजे हम रात का खाना खा रहे होंगे।
Don't call at nine — I will be sleeping.||九時に電話しないで、寝ていますから।|नौ बजे मत फ़ोन करना — मैं सो रहा हूँगा।
Will you be using your laptop this afternoon?||今日の午後、ノートパソコンを使いますか।|क्या तुम आज दोपहर अपना लैपटॉप इस्तेमाल करोगे?
They will be traveling all next week.||彼らは来週ずっと旅行しています।|वे अगले पूरे हफ़्ते यात्रा कर रहे होंगे।
When you arrive, I will be waiting at the gate.||あなたが着くとき、私は門で待っています।|जब तुम पहुँचोगे, मैं गेट पर इंतज़ार कर रहा हूँगा।
He won't be joining us for lunch.||彼は昼食に参加しません।|वह दोपहर के खाने में शामिल नहीं होगा।
At midnight we will still be driving.||真夜中に私たちはまだ運転しています।|आधी रात को हम अब भी गाड़ी चला रहे होंगे।
What will you be doing at this time next year?||来年の今頃何をしていますか।|अगले साल इस समय तुम क्या कर रहे होगे?
I will be teaching all morning.||午前中ずっと教えています।|मैं पूरी सुबह पढ़ा रहा हूँगा।
They will be waiting for us at the airport.||彼らは空港で私たちを待っています।|वे हमारा इंतज़ार एयरपोर्ट पर कर रहे होंगे।"""),

        tp("t11", "Future Perfect — will have done", "未来完了", "B2",
            "USAGE: An action that will be finished before a certain time in the future. It looks back from a future point and says that something will already be complete.\nWHEN: by tomorrow, by the time ..., by 2030, before you come, by then.\nFORM: will have + past participle (3rd form). I will have finished.\nNEGATIVE: won't have + 3rd form. He won't have arrived.\nQUESTION: Will + subject + have + 3rd form? Will you have finished by then?\nTIP: Always pair it with by or by the time: \"By Friday I will have sent all the reports.\" Without a deadline the future perfect sounds incomplete.",
            "उपयोग: कोई काम जो भविष्य के किसी निश्चित समय से पहले पूरा हो चुका होगा। यह भविष्य से पीछे देखकर बताता है कि काम पूरा हो चुका होगा।\nकब: by tomorrow, by the time ..., by 2030, before you come, by then.\nरूप: will have + क्रिया का तीसरा रूप (V3)। I will have finished.\nनकारात्मक: won't have + V3। He won't have arrived.\nप्रश्न: Will + subject + have + V3? Will you have finished by then?\nटिप: इसे हमेशा by या by the time के साथ रखें: \"By Friday I will have sent all the reports.\" बिना समय-सीमा के यह अधूरा लगता है।",
            """By tomorrow I will have finished the report.||明日までに報告書を終えているでしょう。|कल तक मैं रिपोर्ट पूरी कर चुका होऊँगा।
She will have left by the time you arrive.||あなたが着くころには彼女は出発しているでしょう।|तुम्हारे पहुँचने तक वह निकल चुकी होगी।
By 2030 they will have built the new bridge.||2030年までに新しい橋を架け終えているでしょう।|2030 तक वे नया पुल बना चुके होंगे।
We will have lived here for ten years next June.||来年六月でここに十年住んだことになります।|अगले जून तक हम यहाँ दस साल रह चुके होंगे।
Will you have finished your exams by then?||その時までに試験は終わっていますか।|क्या तब तक तुम्हारी परीक्षाएँ ख़त्म हो चुकी होंगी?
He won't have arrived by noon.||彼は正午までには着いていないでしょう।|वह दोपहर तक नहीं पहुँच चुका होगा।
By the time you read this, I will have gone.||あなたがこれを読むころには、私は去っています।|जब तुम यह पढ़ोगे, तब तक मैं जा चुका होऊँगा।
By next month, I will have saved enough money.||来月までに十分なお金を貯めているでしょう।|अगले महीने तक मैं काफ़ी पैसे बचा चुका होऊँगा।
They will have eaten before the guests come.||客が来る前に彼らは食べ終わっているでしょう।|मेहमानों के आने से पहले वे खा चुके होंगे।
By the end of the year, she will have visited ten countries.||年末までに彼女は十か国を訪れているでしょう।|साल के अंत तक वह दस देश घूम चुकी होगी।
I will have read the whole book by Sunday.||日曜日までに本を全部読んでいます。|रविवार तक मैं पूरी किताब पढ़ चुका होऊँगा।
The builders will have completed the road by June.||六月までに建設業者は道路を完成させているでしょう।|जून तक मज़दूर सड़क पूरी कर चुके होंगे।"""),

        tp("t12", "Future Perfect Continuous — will have been doing", "未来完了進行形", "B2",
            "USAGE: Emphasises how long an action will have been going on by a certain future time. It is less common but very useful when the duration matters.\nWHEN: by next year, for five years by then, by the time ..., in June.\nFORM: will have been + verb-ing. I will have been working.\nNEGATIVE: won't have been + verb-ing. She won't have been working long.\nQUESTION: Will + subject + have been + verb-ing? How long will you have been living there?\nTIP: Use it for a duration measured up to a future point: \"By May I will have been learning Spanish for two years.\"",
            "उपयोग: यह बताता है कि भविष्य के किसी समय तक कोई काम कितने समय से चल रहा होगा। यह कम आम है पर जब अवधि मायने रखती है तब बहुत उपयोगी है।\nकब: by next year, for five years by then, by the time ..., in June.\nरूप: will have been + verb-ing। I will have been working.\nनकारात्मक: won't have been + verb-ing। She won't have been working long.\nप्रश्न: Will + subject + have been + verb-ing? How long will you have been living there?\nटिप: भविष्य के किसी बिंदु तक की अवधि के लिए: \"By May I will have been learning Spanish for two years.\"",
            """By May I will have been learning Spanish for two years.||五月でスペイン語を二年間学んでいることになります。|मई तक मैं दो साल से स्पेनिश सीख रहा होऊँगा।
Next week she will have been working here for a year.||来週で彼女はここで一年働いたことになります।|अगले हफ़्ते वह यहाँ एक साल से काम कर रही होगी।
By the time you arrive, I will have been waiting for three hours.||あなたが着くころには三時間待っていることになります।|तुम्हारे आने तक मैं तीन घंटे से इंतज़ार कर रहा होऊँगा।
In June they will have been married for twenty years.||六月で彼らは結婚二十年になります।|जून में उन्हें शादी किए बीस साल हो जाएँगे।
He will have been driving for eight hours by then.||その時までに彼は八時間運転していることになります।|तब तक वह आठ घंटे से गाड़ी चला रहा होगा।
By next month, I will have been living here for five years.||来月でここに五年住んでいることになります।|अगले महीने तक मैं यहाँ पाँच साल से रह रहा होऊँगा।
Will you have been studying for long when the exam starts?||試験が始まるとき、長く勉強していますか।|परीक्षा शुरू होते समय तुम लंबे समय से पढ़ रहे होगे?
By ten o'clock we will have been walking for six hours.||十時までに私たちは六時間歩いていることになります।|दस बजे तक हम छह घंटे से चल रहे होंगे।
She won't have been working here long by December.||十二月までに彼女はここで長く働いていることはないでしょう।|दिसंबर तक वह यहाँ ज़्यादा समय से काम नहीं कर रही होगी।
By the end of the trip, we will have been traveling for a month.||旅行の終わりまでに一か月旅行していることになります।|यात्रा के अंत तक हम एक महीने से यात्रा कर रहे होंगे।
In September I will have been teaching for ten years.||九月で教えて十年になります。|सितंबर में मुझे पढ़ाते हुए दस साल हो जाएँगे।
By dinner time they will have been playing for four hours.||夕食時までに彼らは四時間遊んでいることになります।|रात के खाने तक वे चार घंटे से खेल रहे होंगे।"""),

        tp("t13", "Future plans — be going to", "going to（予定）", "A1",
            "USAGE: For plans and intentions you decided before speaking, and for predictions based on something you can see or know right now.\nWHEN: tomorrow, next weekend, soon, I've decided..., look at those clouds!\nFORM: am / is / are + going to + base verb. I am going to study. They are going to move.\nNEGATIVE: am / is / are + not + going to + base verb. They are not going to come.\nQUESTION: Am / Is / Are + subject + going to + base verb? Are you going to come?\nTIP: \"will\" = a decision made now; \"going to\" = a plan already made. For a prediction based on evidence, use \"going to\": \"Look — it's going to rain!\"",
            "उपयोग: उन योजनाओं और इरादों के लिए जो बोलने से पहले तय हो चुके हैं, और उन भविष्यवाणियों के लिए जो अभी दिख रही या ज्ञात बात पर आधारित हैं।\nकब: tomorrow, next weekend, soon, I've decided..., look at those clouds!\nरूप: am / is / are + going to + मूल क्रिया। I am going to study. They are going to move.\nनकारात्मक: am / is / are + not + going to + मूल क्रिया। They are not going to come.\nप्रश्न: Am / Is / Are + subject + going to + मूल क्रिया? Are you going to come?\nटिप: \"will\" = अभी का फ़ैसला; \"going to\" = पहले से बनी योजना। सबूत पर आधारित भविष्यवाणी के लिए \"going to\": \"Look — it's going to rain!\"",
            """I am going to visit my parents this weekend.||今週末、両親を訪ねるつもりです。|मैं इस सप्ताहांत अपने माता-पिता से मिलने जा रहा हूँ।
She is going to start a new job next month.||彼女は来月新しい仕事を始める予定です।|वह अगले महीने नई नौकरी शुरू करने जा रही है।
We are going to buy a house next year.||私たちは来年家を買うつもりです।|हम अगले साल घर ख़रीदने जा रहे हैं।
Look at those clouds — it is going to rain.||あの雲を見て、雨が降りそうだ।|उन बादलों को देखो — बारिश होने वाली है।
They are not going to come tonight.||彼らは今夜来るつもりはありません।|वे आज रात आने वाले नहीं हैं।
Are you going to tell him the truth?||彼に真実を話すつもりですか।|क्या तुम उसे सच बताने जा रहे हो?
He is going to study medicine at university.||彼は大学で医学を勉強するつもりです।|वह विश्वविद्यालय में चिकित्सा पढ़ने जा रहा है।
I am going to cook something special tonight.||今夜は特別な料理を作るつもりです।|आज रात मैं कुछ ख़ास बनाने जा रहा हूँ।
What are you going to do after graduation?||卒業後は何をするつもりですか।|स्नातक के बाद तुम क्या करने जा रहे हो?
We are going to meet at the station at six.||六時に駅で会う予定です।|हम छह बजे स्टेशन पर मिलने जा रहे हैं।
She is going to learn to drive this summer.||彼女はこの夏に運転を習うつもりです।|वह इस गर्मी में गाड़ी चलाना सीखने जा रही है।
I am going to save money for a new laptop.||新しいノートパソコンのためにお金を貯めるつもりです।|मैं नए लैपटॉप के लिए पैसे बचाने जा रहा हूँ।""")
    )
}
