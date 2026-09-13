package com.nexo.kotoba

/**
 * Sentence frames used to give every vocabulary word ten example sentences in
 * the language being learned.
 *
 * Each frame contains the placeholder `XKEYX`, which callers replace with the
 * translated word. The frames are authored in English and translated into every
 * supported language (Hindi and Japanese are hand-written; the rest come from
 * machine translation of the same English source), so every track shows the same
 * structure and the same number of examples.
 */
object TargetExamples {
    private val FRAMES: Map<String, Map<String, List<String>>> = mapOf(
        "en" to enFrames(),
        "hi" to hiFrames(),
        "ja" to jaFrames(),
        "es" to esFrames(),
        "ar" to arFrames(),
        "fr" to frFrames(),
        "de" to deFrames(),
        "bn" to bnFrames(),
        "ta" to taFrames(),
        "te" to teFrames(),
        "ur" to urFrames(),
        "kn" to knFrames()

    )

    /**
     * Special sentence frames for conversational phrases ("phrase") that are
     * already complete utterances — e.g. "good evening", "thank you", "see you
     * later" — so they are shown inside natural, real-life dialogue instead of
     * the generic vocabulary frames.
     */
    private val SPECIAL: Map<String, Map<String, List<String>>> = mapOf(
        "en" to enSpecial(),
        "hi" to hiSpecial(),
        "ja" to jaSpecial(),
        "es" to esSpecial(),
        "ar" to arSpecial(),
        "fr" to frSpecial(),
        "de" to deSpecial(),
        "bn" to bnSpecial(),
        "ta" to taSpecial(),
        "te" to teSpecial(),
        "ur" to urSpecial(),
        "kn" to knSpecial()
    )

    /** The ten example frames for [lang] and part-of-speech bucket [pos]. */
    fun frames(lang: String, pos: String): List<String> {
        if (pos == "phrase") {
            val sp = SPECIAL[lang] ?: SPECIAL["en"]!!
            return sp["phrase"]!!
        }
        val m = FRAMES[lang] ?: FRAMES["en"]!!
        return m[pos] ?: m["other"]!!
    }
}
    private fun enFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "I learned the word XKEYX today.",
            "How do you write XKEYX?",
            "How do you pronounce XKEYX?",
            "Let's say XKEYX together.",
            "Please repeat the word XKEYX.",
            "We practiced XKEYX in class today.",
            "I added XKEYX to my vocabulary list.",
            "What does XKEYX mean?",
            "XKEYX — do you know this word?",
            "The word XKEYX is on today's list."
        ),
        "verb" to listOf(
            "I like to XKEYX.",
            "I learn to XKEYX every day.",
            "We learn to XKEYX together.",
            "He will learn to XKEYX tomorrow.",
            "Do you know how to XKEYX?",
            "It is easy to XKEYX.",
            "They like to XKEYX after work.",
            "Let's learn to XKEYX now.",
            "I don't like to XKEYX.",
            "I want to learn to XKEYX today."
        ),
        "adjective" to listOf(
            "It is very XKEYX.",
            "The weather is XKEYX today.",
            "She seems XKEYX today.",
            "I feel XKEYX.",
            "Everything looks XKEYX.",
            "That sounds XKEYX.",
            "It is not XKEYX.",
            "You look XKEYX.",
            "This place is really XKEYX.",
            "The food was XKEYX."
        ),
        "adverb" to listOf(
            "She finished the work XKEYX.",
            "He spoke XKEYX during the meeting.",
            "Please do it XKEYX.",
            "They arrived XKEYX.",
            "I understood it XKEYX.",
            "She always answers XKEYX.",
            "He drives XKEYX.",
            "We solved it XKEYX.",
            "The children played XKEYX.",
            "Everything happened XKEYX."
        ),
        "number" to listOf(
            "The number XKEYX is on the board.",
            "Count from one to XKEYX.",
            "My lucky number is XKEYX.",
            "XKEYX is my favorite number.",
            "There are XKEYX people in the room.",
            "I need XKEYX more minutes.",
            "The answer is XKEYX.",
            "We waited XKEYX hours.",
            "She has XKEYX books.",
            "Page XKEYX is the last one."
        ),
        "other" to listOf(
            "The word XKEYX is common in everyday speech.",
            "We used XKEYX in today's lesson.",
            "Write a sentence with XKEYX.",
            "What does XKEYX mean here?",
            "This lesson shows how to use XKEYX.",
            "I heard XKEYX in a conversation today.",
            "This exercise is about XKEYX.",
            "Can you translate XKEYX?",
            "Remember to use XKEYX correctly.",
            "XKEYX is used every day."
        )
    )

    private fun hiFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "मैंने आज XKEYX शब्द सीखा।",
            "XKEYX कैसे लिखते हैं?",
            "XKEYX का उच्चारण कैसे करते हैं?",
            "आइए XKEYX को एक साथ कहें।",
            "कृपया XKEYX शब्द दोहराएँ।",
            "आज कक्षा में हमने XKEYX का अभ्यास किया।",
            "मैंने XKEYX अपनी शब्द-सूची में जोड़ा।",
            "XKEYX का क्या अर्थ है?",
            "XKEYX — क्या आप यह शब्द जानते हैं?",
            "आज की सूची में XKEYX शब्द है।"
        ),
        "verb" to listOf(
            "मुझे XKEYX पसंद है।",
            "मैं हर रोज़ XKEYX सीखता हूँ।",
            "हम साथ में XKEYX सीखते हैं।",
            "वह कल XKEYX सीखेगा।",
            "क्या आप XKEYX जानते हैं?",
            "XKEYX आसान है।",
            "उन्हें काम के बाद XKEYX पसंद है।",
            "चलो अब XKEYX सीखें।",
            "मुझे XKEYX पसंद नहीं है।",
            "मैं आज XKEYX सीखना चाहता हूँ।"
        ),
        "adjective" to listOf(
            "यह बहुत XKEYX है।",
            "आज मौसम XKEYX है।",
            "वह आज XKEYX लग रही है।",
            "मुझे XKEYX लग रहा है।",
            "सब कुछ XKEYX लग रहा है।",
            "यह XKEYX लगता है।",
            "यह XKEYX नहीं है।",
            "आप XKEYX लग रहे हैं।",
            "यह जगह सचमुच XKEYX है।",
            "खाना XKEYX था।"
        ),
        "adverb" to listOf(
            "उसने काम XKEYX पूरा किया।",
            "उसने बैठक में XKEYX बात की।",
            "कृपया इसे XKEYX करें।",
            "वे XKEYX पहुँचे।",
            "मैंने इसे XKEYX समझा।",
            "वह हमेशा XKEYX जवाब देती है।",
            "वह XKEYX गाड़ी चलाता है।",
            "हमने इसे XKEYX हल किया।",
            "बच्चे XKEYX खेले।",
            "सब कुछ XKEYX हुआ।"
        ),
        "number" to listOf(
            "बोर्ड पर XKEYX संख्या लिखी है।",
            "एक से XKEYX तक गिनें।",
            "मेरा भाग्यशाली अंक XKEYX है।",
            "XKEYX मेरा पसंदीदा अंक है।",
            "कमरे में XKEYX लोग हैं।",
            "मुझे XKEYX और मिनट चाहिए।",
            "उत्तर XKEYX है।",
            "हमने XKEYX घंटे इंतज़ार किया।",
            "उसके पास XKEYX किताबें हैं।",
            "पृष्ठ XKEYX अंतिम है।"
        ),
        "other" to listOf(
            "रोज़मर्रा की बातचीत में XKEYX शब्द आम है।",
            "आज के पाठ में हमने XKEYX का प्रयोग किया।",
            "XKEYX के साथ एक वाक्य लिखें।",
            "यहाँ XKEYX का क्या अर्थ है?",
            "यह पाठ दिखाता है कि XKEYX का उपयोग कैसे करें।",
            "आज बातचीत में मैंने XKEYX सुना।",
            "यह अभ्यास XKEYX के बारे में है।",
            "क्या आप XKEYX का अनुवाद कर सकते हैं?",
            "XKEYX का सही प्रयोग याद रखें।",
            "XKEYX हर दिन प्रयोग होता है।"
        )
    )

    private fun jaFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "今日 XKEYX という言葉を習いました。",
            "XKEYX はどう書きますか。",
            "XKEYX の発音を教えてください。",
            "いっしょに XKEYX と言いましょう。",
            "XKEYX という言葉をもう一度言ってください。",
            "今日の授業で XKEYX を練習しました。",
            "XKEYX を単語帳に追加しました。",
            "XKEYX はどういう意味ですか。",
            "XKEYX — この言葉を知っていますか。",
            "今日のリストに XKEYX があります。"
        ),
        "verb" to listOf(
            "XKEYX ことが好きです。",
            "毎日 XKEYX ことを習います。",
            "一緒に XKEYX ことを習います。",
            "彼は明日 XKEYX ことを習います。",
            "XKEYX の仕方を知っていますか。",
            "XKEYX ことは簡単です。",
            "彼らは仕事の後で XKEYX ことが好きです。",
            "今から XKEYX ことを習いましょう。",
            "XKEYX ことが好きではありません。",
            "今日 XKEYX ことを習いたいです。"
        ),
        "adjective" to listOf(
            "それはとても XKEYX です。",
            "今日は天気が XKEYX です。",
            "彼女は今日 XKEYX そうです。",
            "XKEYX と感じます。",
            "すべてが XKEYX に見えます。",
            "それは XKEYX に聞こえます。",
            "XKEYX ではありません。",
            "あなたは XKEYX に見えます。",
            "この場所は本当に XKEYX です。",
            "食べ物は XKEYX でした。"
        ),
        "adverb" to listOf(
            "彼女は仕事を XKEYX 終えました。",
            "彼は会議で XKEYX 話しました。",
            "どうぞ XKEYX してください。",
            "彼らは XKEYX 到着しました。",
            "私はそれを XKEYX 理解しました。",
            "彼女はいつも XKEYX 答えます。",
            "彼は XKEYX 運転します。",
            "私たちはそれを XKEYX 解決しました。",
            "子供たちは XKEYX 遊びました。",
            "すべては XKEYX 起こりました。"
        ),
        "number" to listOf(
            "ボードに XKEYX という数字があります。",
            "一から XKEYX まで数えてください。",
            "私のラッキーナンバーは XKEYX です。",
            "XKEYX は私の好きな数字です。",
            "部屋に XKEYX 人の人がいます。",
            "あと XKEYX 分必要です。",
            "答えは XKEYX です。",
            "私たちは XKEYX 時間待ちました。",
            "彼女は XKEYX 冊の本を持っています。",
            "XKEYX ページが最後です。"
        ),
        "other" to listOf(
            "XKEYX という言葉は日常会話でよく使われます。",
            "今日の授業で XKEYX を使いました。",
            "XKEYX を使って文を書いてください。",
            "ここでは XKEYX はどういう意味ですか。",
            "このレッスンでは XKEYX の使い方を説明します。",
            "今日の会話で XKEYX を聞きました。",
            "この練習は XKEYX についてです。",
            "XKEYX を翻訳できますか。",
            "XKEYX を正しく使うことを覚えてください。",
            "XKEYX は毎日使われます。"
        )
    )

    private fun esFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "Aprendí la palabra XKEYX hoy.",
            "¿Cómo se escribe XKEYX?",
            "¿Cómo se pronuncia XKEYX?",
            "Digamos XKEYX juntos.",
            "Por favor repita la palabra XKEYX.",
            "Hoy practicamos XKEYX en clase.",
            "Agregué XKEYX a mi lista de vocabulario.",
            "¿Qué significa XKEYX?",
            "XKEYX: ¿conoces esta palabra?",
            "La palabra XKEYX está en la lista de hoy."
        ),
        "verb" to listOf(
            "Me gusta XKEYX.",
            "Aprendo a XKEYX todos los días.",
            "Aprendemos a XKEYX juntos.",
            "Mañana aprenderá a XKEYX.",
            "¿Sabes cómo XKEYX?",
            "Es fácil XKEYX.",
            "Les gusta XKEYX después del trabajo.",
            "Aprendamos a XKEYX ahora.",
            "No me gusta XKEYX.",
            "Quiero aprender a XKEYX hoy."
        ),
        "adjective" to listOf(
            "Es muy XKEYX.",
            "El clima es XKEYX hoy.",
            "Ella parece XKEYX hoy.",
            "Siento XKEYX.",
            "Todo parece XKEYX.",
            "Eso suena XKEYX.",
            "No es XKEYX.",
            "Te ves XKEYX.",
            "Este lugar es realmente XKEYX.",
            "La comida era XKEYX."
        ),
        "adverb" to listOf(
            "Terminó el trabajo XKEYX.",
            "Habló XKEYX durante la reunión.",
            "Por favor hazlo XKEYX.",
            "Llegaron XKEYX.",
            "Lo entendí XKEYX.",
            "Ella siempre responde XKEYX.",
            "Él conduce XKEYX.",
            "Lo solucionamos XKEYX.",
            "Los niños jugaron XKEYX.",
            "Todo pasó XKEYX."
        ),
        "number" to listOf(
            "El número XKEYX está en el tablero.",
            "Cuente desde uno hasta XKEYX.",
            "Mi número de la suerte es XKEYX.",
            "XKEYX es mi número favorito.",
            "Hay personas XKEYX en la sala.",
            "Necesito XKEYX más minutos.",
            "La respuesta es XKEYX.",
            "Esperamos XKEYX horas.",
            "Tiene libros XKEYX.",
            "La página XKEYX es la última."
        ),
        "other" to listOf(
            "La palabra XKEYX es común en el habla cotidiana.",
            "Usamos XKEYX en la lección de hoy.",
            "Escribe una oración con XKEYX.",
            "¿Qué significa XKEYX aquí?",
            "Esta lección muestra cómo usar XKEYX.",
            "Escuché XKEYX en una conversación hoy.",
            "Este ejercicio trata sobre XKEYX.",
            "¿Puedes traducir XKEYX?",
            "Recuerde utilizar XKEYX correctamente.",
            "XKEYX se utiliza todos los días."
        )
    )

    private fun arFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "لقد تعلمت كلمة XKEYX اليوم.",
            "كيف تكتب XKEYX؟",
            "كيف تنطق XKEYX؟",
            "لنقل XKEYX معًا.",
            "الرجاء تكرار كلمة XKEYX.",
            "لقد تدربنا على XKEYX في الفصل اليوم.",
            "أضفت XKEYX إلى قائمة المفردات الخاصة بي.",
            "ماذا يعني XKEYX؟",
            "XKEYX - هل تعرف هذه الكلمة؟",
            "كلمة XKEYX موجودة في قائمة اليوم."
        ),
        "verb" to listOf(
            "أنا أحب XKEYX.",
            "أتعلم XKEYX كل يوم.",
            "نتعلم كيفية استخدام XKEYX معًا.",
            "سوف يتعلم XKEYX غدًا.",
            "هل تعرف كيفية XKEYX؟",
            "فمن السهل أن XKEYX.",
            "إنهم يحبون XKEYX بعد العمل.",
            "دعونا نتعلم XKEYX الآن.",
            "أنا لا أحب XKEYX.",
            "أريد أن أتعلم XKEYX اليوم."
        ),
        "adjective" to listOf(
            "إنه XKEYX جدًا.",
            "الطقس هو XKEYX اليوم.",
            "إنها تبدو XKEYX اليوم.",
            "أشعر بـ XKEYX.",
            "كل شيء يبدو XKEYX.",
            "هذا يبدو XKEYX.",
            "إنه ليس XKEYX.",
            "أنت تبدو XKEYX.",
            "هذا المكان هو حقًا XKEYX.",
            "كان الطعام XKEYX."
        ),
        "adverb" to listOf(
            "أنهت العمل XKEYX.",
            "تحدث عن XKEYX خلال الاجتماع.",
            "يرجى القيام بذلك XKEYX.",
            "وصلوا XKEYX.",
            "لقد فهمت ذلك XKEYX.",
            "إنها تجيب دائمًا على XKEYX.",
            "يقود XKEYX.",
            "لقد حللناها XKEYX.",
            "لعب الأطفال XKEYX.",
            "حدث كل شيء XKEYX."
        ),
        "number" to listOf(
            "الرقم XKEYX موجود على اللوحة.",
            "العد من واحد إلى XKEYX.",
            "رقم الحظ الخاص بي هو XKEYX.",
            "XKEYX هو رقمي المفضل.",
            "يوجد أشخاص XKEYX في الغرفة.",
            "أحتاج إلى XKEYX المزيد من الدقائق.",
            "الجواب هو XKEYX.",
            "انتظرنا ساعات XKEYX.",
            "لديها كتب XKEYX.",
            "صفحة XKEYX هي الأخيرة."
        ),
        "other" to listOf(
            "كلمة XKEYX شائعة في الكلام اليومي.",
            "استخدمنا XKEYX في درس اليوم.",
            "اكتب جملة باستخدام XKEYX.",
            "ماذا يعني XKEYX هنا؟",
            "يوضح هذا الدرس كيفية استخدام XKEYX.",
            "سمعت XKEYX في محادثة اليوم.",
            "هذا التمرين يدور حول XKEYX.",
            "هل يمكنك ترجمة XKEYX؟",
            "تذكر استخدام XKEYX بشكل صحيح.",
            "يتم استخدام XKEYX كل يوم."
        )
    )

    private fun frFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "J'ai appris le mot XKEYX aujourd'hui.",
            "Comment écrivez-vous XKEYX ?",
            "Comment prononcez-vous XKEYX?",
            "Disons XKEYX ensemble.",
            "Veuillez répéter le mot XKEYX.",
            "Nous avons pratiqué XKEYX en classe aujourd'hui.",
            "J'ai ajouté XKEYX à ma liste de vocabulaire.",
            "Que signifie XKEYX ?",
            "XKEYX — connaissez-vous ce mot ?",
            "Le mot XKEYX est sur la liste d'aujourd'hui."
        ),
        "verb" to listOf(
            "J'aime XKEYX.",
            "J'apprends XKEYX tous les jours.",
            "Nous apprenons à XKEYX ensemble.",
            "Il apprendra XKEYX demain.",
            "Savez-vous comment utiliser XKEYX ?",
            "Il est facile d'utiliser XKEYX.",
            "Ils aiment XKEYX après le travail.",
            "Apprenons XKEYX maintenant.",
            "Je n'aime pas XKEYX.",
            "Je veux apprendre XKEYX aujourd'hui."
        ),
        "adjective" to listOf(
            "C'est très XKEYX.",
            "Le temps est XKEYX aujourd’hui.",
            "Elle semble XKEYX aujourd'hui.",
            "Je me sens XKEYX.",
            "Tout ressemble à XKEYX.",
            "Cela ressemble à XKEYX.",
            "Ce n'est pas XKEYX.",
            "Vous avez l'air XKEYX.",
            "Cet endroit est vraiment XKEYX.",
            "La nourriture était XKEYX."
        ),
        "adverb" to listOf(
            "Elle a terminé le travail XKEYX.",
            "Il a parlé XKEYX pendant la réunion.",
            "S'il vous plaît, faites-le XKEYX.",
            "Ils sont arrivés XKEYX.",
            "Je l'ai compris XKEYX.",
            "Elle répond toujours à XKEYX.",
            "Il conduit XKEYX.",
            "Nous l'avons résolu XKEYX.",
            "Les enfants ont joué à XKEYX.",
            "Tout s'est passé XKEYX."
        ),
        "number" to listOf(
            "Le numéro XKEYX est au tableau.",
            "Comptez de un à XKEYX.",
            "Mon numéro porte-bonheur est XKEYX.",
            "XKEYX est mon numéro préféré.",
            "Il y a des personnes XKEYX dans la pièce.",
            "J'ai besoin de plus de minutes XKEYX.",
            "La réponse est XKEYX.",
            "Nous avons attendu les heures XKEYX.",
            "Elle a des livres XKEYX.",
            "La page XKEYX est la dernière."
        ),
        "other" to listOf(
            "Le mot XKEYX est courant dans le langage courant.",
            "Nous avons utilisé XKEYX dans la leçon d'aujourd'hui.",
            "Écrivez une phrase avec XKEYX.",
            "Que signifie XKEYX ici ?",
            "Cette leçon montre comment utiliser XKEYX.",
            "J'ai entendu XKEYX dans une conversation aujourd'hui.",
            "Cet exercice concerne XKEYX.",
            "Pouvez-vous traduire XKEYX ?",
            "N'oubliez pas d'utiliser XKEYX correctement.",
            "XKEYX est utilisé quotidiennement."
        )
    )

    private fun deFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "Ich habe heute das Wort XKEYX gelernt.",
            "Wie schreibt man XKEYX?",
            "Wie spricht man XKEYX aus?",
            "Sagen wir gemeinsam XKEYX.",
            "Bitte wiederholen Sie das Wort XKEYX.",
            "Wir haben heute im Unterricht XKEYX geübt.",
            "Ich habe XKEYX zu meiner Vokabelliste hinzugefügt.",
            "Was bedeutet XKEYX?",
            "XKEYX – kennen Sie dieses Wort?",
            "Das Wort XKEYX steht heute auf der Liste."
        ),
        "verb" to listOf(
            "Ich mag XKEYX.",
            "Ich lerne jeden Tag XKEYX.",
            "Wir lernen gemeinsam XKEYX.",
            "Er wird morgen XKEYX lernen.",
            "Wissen Sie, wie man XKEYX macht?",
            "Es ist einfach zu XKEYX.",
            "Sie mögen XKEYX nach der Arbeit.",
            "Lassen Sie uns jetzt XKEYX lernen.",
            "Ich mag XKEYX nicht.",
            "Ich möchte heute XKEYX lernen."
        ),
        "adjective" to listOf(
            "Es ist sehr XKEYX.",
            "Das Wetter ist heute XKEYX.",
            "Sie scheint heute XKEYX zu sein.",
            "Ich fühle mich XKEYX.",
            "Alles sieht XKEYX aus.",
            "Das klingt XKEYX.",
            "Es ist nicht XKEYX.",
            "Du siehst XKEYX aus.",
            "Dieser Ort ist wirklich XKEYX.",
            "Das Essen war XKEYX."
        ),
        "adverb" to listOf(
            "Sie beendete die Arbeit XKEYX.",
            "Während des Treffens sprach er XKEYX.",
            "Bitte machen Sie es mit XKEYX.",
            "Sie sind angekommen XKEYX.",
            "Ich habe es verstanden XKEYX.",
            "Sie antwortet immer mit XKEYX.",
            "Er fährt XKEYX.",
            "Wir haben es XKEYX gelöst.",
            "Die Kinder spielten XKEYX.",
            "Alles ist XKEYX passiert."
        ),
        "number" to listOf(
            "Auf der Tafel steht die Nummer XKEYX.",
            "Zählen Sie von eins bis XKEYX.",
            "Meine Glückszahl ist XKEYX.",
            "XKEYX ist meine Lieblingsnummer.",
            "Es sind XKEYX-Leute im Raum.",
            "Ich brauche XKEYX mehr Minuten.",
            "Die Antwort ist XKEYX.",
            "Wir haben XKEYX-Stunden gewartet.",
            "Sie hat XKEYX-Bücher.",
            "Seite XKEYX ist die letzte."
        ),
        "other" to listOf(
            "Das Wort XKEYX kommt in der Alltagssprache häufig vor.",
            "In der heutigen Lektion haben wir XKEYX verwendet.",
            "Schreiben Sie einen Satz mit XKEYX.",
            "Was bedeutet hier XKEYX?",
            "Diese Lektion zeigt, wie man XKEYX verwendet.",
            "Ich habe heute in einem Gespräch XKEYX gehört.",
            "In dieser Übung geht es um XKEYX.",
            "Können Sie XKEYX übersetzen?",
            "Denken Sie daran, XKEYX richtig zu verwenden.",
            "XKEYX wird täglich verwendet."
        )
    )

    private fun bnFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "আমি আজকে XKEYX শব্দটি শিখেছি।",
            "আপনি কিভাবে XKEYX লিখবেন?",
            "আপনি কিভাবে XKEYX উচ্চারণ করবেন?",
            "আসুন একসাথে XKEYX বলি।",
            "অনুগ্রহ করে XKEYX শব্দটি পুনরাবৃত্তি করুন।",
            "আমরা আজ ক্লাসে XKEYX অনুশীলন করেছি।",
            "আমি আমার শব্দভান্ডার তালিকায় XKEYX যোগ করেছি।",
            "XKEYX মানে কি?",
            "XKEYX — আপনি কি এই শব্দটি জানেন?",
            "XKEYX শব্দটি আজকের তালিকায় রয়েছে।"
        ),
        "verb" to listOf(
            "আমি XKEYX পছন্দ করি।",
            "আমি প্রতিদিন XKEYX শিখি।",
            "আমরা একসাথে XKEYX শিখি।",
            "সে আগামীকাল XKEYX শিখবে।",
            "আপনি XKEYX কিভাবে জানেন?",
            "XKEYX করা সহজ।",
            "তারা কাজের পরে XKEYX করতে পছন্দ করে।",
            "আসুন এখন XKEYX শিখি।",
            "আমি XKEYX পছন্দ করি না।",
            "আমি আজকে XKEYX শিখতে চাই।"
        ),
        "adjective" to listOf(
            "এটা খুব XKEYX.",
            "আবহাওয়া আজ XKEYX.",
            "সে আজ মনে হচ্ছে XKEYX.",
            "আমি XKEYX অনুভব করি।",
            "সবকিছু XKEYX দেখাচ্ছে।",
            "XKEYX শোনাচ্ছে।",
            "এটা XKEYX নয়।",
            "আপনি দেখতে XKEYX.",
            "এই জায়গাটি সত্যিই XKEYX।",
            "খাবারটি ছিল XKEYX।"
        ),
        "adverb" to listOf(
            "তিনি XKEYX এর কাজ শেষ করেছেন।",
            "তিনি বৈঠকের সময় XKEYX কথা বলেছেন।",
            "এটা XKEYX করুন.",
            "তারা XKEYX এ পৌঁছেছে।",
            "আমি এটা XKEYX বুঝেছি।",
            "সে সবসময় XKEYX এর উত্তর দেয়।",
            "সে XKEYX চালায়।",
            "আমরা এটি XKEYX সমাধান করেছি।",
            "শিশুরা XKEYX খেলেছে।",
            "সবকিছু XKEYX ঘটেছে।"
        ),
        "number" to listOf(
            "XKEYX নম্বরটি বোর্ডে রয়েছে।",
            "এক থেকে XKEYX পর্যন্ত গণনা করুন।",
            "আমার ভাগ্যবান নম্বর হল XKEYX.",
            "XKEYX আমার প্রিয় নম্বর।",
            "রুমে XKEYX লোক আছে।",
            "আমার আরও XKEYX মিনিট দরকার।",
            "উত্তর হল XKEYX.",
            "আমরা XKEYX ঘন্টার জন্য অপেক্ষা করেছি।",
            "তার কাছে XKEYX বই আছে।",
            "XKEYX পৃষ্ঠাটি শেষ।"
        ),
        "other" to listOf(
            "XKEYX শব্দটি দৈনন্দিন বক্তৃতায় সাধারণ।",
            "আমরা আজকের পাঠে XKEYX ব্যবহার করেছি।",
            "XKEYX দিয়ে একটি বাক্য লিখ।",
            "এখানে XKEYX এর মানে কি?",
            "এই পাঠটি দেখায় কিভাবে XKEYX ব্যবহার করতে হয়।",
            "আমি আজ একটি কথোপকথনে XKEYX শুনেছি।",
            "এই অনুশীলনটি XKEYX সম্পর্কে।",
            "আপনি XKEYX অনুবাদ করতে পারেন?",
            "XKEYX সঠিকভাবে ব্যবহার করতে মনে রাখবেন।",
            "XKEYX প্রতিদিন ব্যবহার করা হয়।"
        )
    )

    private fun taFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "XKEYX என்ற வார்த்தையை இன்று கற்றுக்கொண்டேன்.",
            "நீங்கள் எப்படி XKEYX எழுதுகிறீர்கள்?",
            "XKEYX ஐ எப்படி உச்சரிக்கிறீர்கள்?",
            "ஒன்றாக XKEYX என்று சொல்லலாம்.",
            "XKEYX என்ற வார்த்தையை மீண்டும் செய்யவும்.",
            "இன்று வகுப்பில் XKEYX பயிற்சி செய்தோம்.",
            "எனது சொல்லகராதி பட்டியலில் XKEYX ஐச் சேர்த்துள்ளேன்.",
            "XKEYX என்றால் என்ன?",
            "XKEYX - இந்த வார்த்தை உங்களுக்கு தெரியுமா?",
            "XKEYX என்ற வார்த்தை இன்றைய பட்டியலில் உள்ளது."
        ),
        "verb" to listOf(
            "நான் XKEYX ஐ விரும்புகிறேன்.",
            "நான் ஒவ்வொரு நாளும் XKEYX கற்றுக்கொள்கிறேன்.",
            "நாங்கள் ஒன்றாக XKEYX கற்றுக்கொள்கிறோம்.",
            "அவர் நாளை XKEYX க்கு கற்றுக்கொள்வார்.",
            "XKEYX செய்வது எப்படி என்று தெரியுமா?",
            "XKEYX க்கு இது எளிதானது.",
            "அவர்கள் வேலைக்குப் பிறகு XKEYX செய்ய விரும்புகிறார்கள்.",
            "இப்போது XKEYX பற்றி கற்றுக்கொள்வோம்.",
            "எனக்கு XKEYX பிடிக்கவில்லை.",
            "நான் இன்று XKEYX கற்றுக்கொள்ள விரும்புகிறேன்."
        ),
        "adjective" to listOf(
            "இது மிகவும் XKEYX ஆகும்.",
            "வானிலை இன்று XKEYX.",
            "அவள் இன்று XKEYX போல் தெரிகிறது.",
            "நான் XKEYX உணர்கிறேன்.",
            "எல்லாம் XKEYX தெரிகிறது.",
            "அது XKEYX என்று ஒலிக்கிறது.",
            "இது XKEYX அல்ல.",
            "நீங்கள் XKEYX ஆக இருக்கிறீர்கள்.",
            "இந்த இடம் உண்மையில் XKEYX.",
            "உணவு XKEYX."
        ),
        "adverb" to listOf(
            "அவள் XKEYX வேலையை முடித்தாள்.",
            "சந்திப்பின் போது அவர் XKEYX பேசினார்.",
            "தயவுசெய்து அதை XKEYX செய்யுங்கள்.",
            "அவர்கள் XKEYX வந்து சேர்ந்தனர்.",
            "நான் அதை XKEYX புரிந்துகொண்டேன்.",
            "அவள் எப்பொழுதும் XKEYX என்று பதிலளிப்பாள்.",
            "அவர் XKEYX ஐ ஓட்டுகிறார்.",
            "நாங்கள் அதை XKEYX தீர்த்தோம்.",
            "குழந்தைகள் XKEYX விளையாடினர்.",
            "எல்லாம் நடந்தது XKEYX."
        ),
        "number" to listOf(
            "XKEYX என்ற எண் பலகையில் உள்ளது.",
            "ஒன்றிலிருந்து XKEYX வரை எண்ணுங்கள்.",
            "எனது அதிர்ஷ்ட எண் XKEYX.",
            "XKEYX எனக்கு மிகவும் பிடித்த எண்.",
            "அறையில் XKEYX நபர்கள் உள்ளனர்.",
            "எனக்கு இன்னும் XKEYX நிமிடங்கள் தேவை.",
            "பதில் XKEYX.",
            "நாங்கள் XKEYX மணிநேரம் காத்திருந்தோம்.",
            "அவரிடம் XKEYX புத்தகங்கள் உள்ளன.",
            "XKEYX பக்கம் கடைசியாக உள்ளது."
        ),
        "other" to listOf(
            "XKEYX என்ற வார்த்தை அன்றாட பேச்சில் பொதுவானது.",
            "இன்றைய பாடத்தில் XKEYX ஐப் பயன்படுத்தினோம்.",
            "XKEYX உடன் ஒரு வாக்கியத்தை எழுதவும்.",
            "இங்கே XKEYX என்றால் என்ன?",
            "XKEYX ஐ எவ்வாறு பயன்படுத்துவது என்பதை இந்தப் பாடம் காட்டுகிறது.",
            "இன்று ஒரு உரையாடலில் XKEYX ஐக் கேட்டேன்.",
            "இந்தப் பயிற்சி XKEYX பற்றியது.",
            "உங்களால் XKEYX ஐ மொழிபெயர்க்க முடியுமா?",
            "XKEYX ஐ சரியாகப் பயன்படுத்த நினைவில் கொள்ளுங்கள்.",
            "XKEYX ஒவ்வொரு நாளும் பயன்படுத்தப்படுகிறது."
        )
    )

    private fun teFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "నేను ఈ రోజు XKEYX అనే పదాన్ని నేర్చుకున్నాను.",
            "మీరు XKEYX ఎలా వ్రాస్తారు?",
            "మీరు XKEYX ను ఎలా ఉచ్చరిస్తారు?",
            "XKEYXని కలిపి చెప్పుకుందాం.",
            "దయచేసి XKEYX పదాన్ని పునరావృతం చేయండి.",
            "మేము ఈరోజు తరగతిలో XKEYXని అభ్యసించాము.",
            "నేను నా పదజాలం జాబితాకు XKEYXని జోడించాను.",
            "XKEYX అంటే ఏమిటి?",
            "XKEYX — మీకు ఈ పదం తెలుసా?",
            "XKEYX అనే పదం నేటి జాబితాలో ఉంది."
        ),
        "verb" to listOf(
            "నాకు XKEYX అంటే ఇష్టం.",
            "నేను ప్రతిరోజూ XKEYX నేర్చుకుంటాను.",
            "మేము కలిసి XKEYX నేర్చుకుంటాము.",
            "అతను రేపు XKEYX నేర్చుకుంటాడు.",
            "XKEYX ఎలా చేయాలో మీకు తెలుసా?",
            "ఇది XKEYXకి సులభం.",
            "వారు పని తర్వాత XKEYXని ఇష్టపడతారు.",
            "ఇప్పుడు XKEYX నేర్చుకుందాం.",
            "నాకు XKEYX అంటే ఇష్టం లేదు.",
            "నేను ఈ రోజు XKEYX నేర్చుకోవాలనుకుంటున్నాను."
        ),
        "adjective" to listOf(
            "ఇది చాలా XKEYX.",
            "ఈరోజు XKEYX వాతావరణం.",
            "ఆమె ఈరోజు XKEYXగా కనిపిస్తోంది.",
            "నాకు XKEYX అనిపిస్తుంది.",
            "ప్రతిదీ XKEYX కనిపిస్తోంది.",
            "అది XKEYX అనిపిస్తుంది.",
            "ఇది XKEYX కాదు.",
            "మీరు XKEYXగా కనిపిస్తున్నారు.",
            "ఈ స్థలం నిజంగా XKEYX.",
            "ఆహారం XKEYX."
        ),
        "adverb" to listOf(
            "ఆమె XKEYX పనిని పూర్తి చేసింది.",
            "సమావేశంలో ఆయన XKEYX మాట్లాడారు.",
            "దయచేసి దీన్ని XKEYX చేయండి.",
            "వారు XKEYX వచ్చారు.",
            "నేను దానిని XKEYX అర్థం చేసుకున్నాను.",
            "ఆమె ఎల్లప్పుడూ XKEYXకి సమాధానమిస్తుంది.",
            "అతను XKEYXని నడుపుతున్నాడు.",
            "మేము దానిని XKEYX పరిష్కరించాము.",
            "పిల్లలు XKEYX ఆడారు.",
            "అంతా XKEYX జరిగింది."
        ),
        "number" to listOf(
            "XKEYX సంఖ్య బోర్డులో ఉంది.",
            "ఒకటి నుండి XKEYX వరకు కౌంట్ చేయండి.",
            "నా అదృష్ట సంఖ్య XKEYX.",
            "XKEYX నాకు ఇష్టమైన నంబర్.",
            "గదిలో XKEYX వ్యక్తులు ఉన్నారు.",
            "నాకు ఇంకా XKEYX నిమిషాలు కావాలి.",
            "సమాధానం XKEYX.",
            "మేము XKEYX గంటలు వేచి ఉన్నాము.",
            "ఆమె వద్ద XKEYX పుస్తకాలు ఉన్నాయి.",
            "XKEYX పేజీ చివరిది."
        ),
        "other" to listOf(
            "XKEYX అనే పదం రోజువారీ ప్రసంగంలో సాధారణం.",
            "మేము నేటి పాఠంలో XKEYXని ఉపయోగించాము.",
            "XKEYXతో ఒక వాక్యాన్ని వ్రాయండి.",
            "ఇక్కడ XKEYX అంటే ఏమిటి?",
            "ఈ పాఠం XKEYXని ఎలా ఉపయోగించాలో చూపిస్తుంది.",
            "నేను ఈరోజు ఒక సంభాషణలో XKEYX విన్నాను.",
            "ఈ వ్యాయామం XKEYX గురించి.",
            "మీరు XKEYXని అనువదించగలరా?",
            "XKEYXని సరిగ్గా ఉపయోగించాలని గుర్తుంచుకోండి.",
            "XKEYX ప్రతి రోజు ఉపయోగించబడుతుంది."
        )
    )

    private fun urFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "میں نے آج لفظ XKEYX سیکھا۔",
            "آپ XKEYX کیسے لکھتے ہیں؟",
            "آپ XKEYX کو کس طرح تلفظ کرتے ہیں؟",
            "آئیے ایک ساتھ XKEYX کہتے ہیں۔",
            "براہ کرم لفظ XKEYX کو دہرائیں۔",
            "ہم نے آج کلاس میں XKEYX کی مشق کی۔",
            "میں نے اپنی الفاظ کی فہرست میں XKEYX کو شامل کیا۔",
            "XKEYX کا کیا مطلب ہے؟",
            "XKEYX — کیا آپ یہ لفظ جانتے ہیں؟",
            "لفظ XKEYX آج کی فہرست میں ہے۔"
        ),
        "verb" to listOf(
            "مجھے XKEYX پسند ہے۔",
            "میں ہر روز XKEYX سیکھتا ہوں۔",
            "ہم ایک ساتھ XKEYX سیکھتے ہیں۔",
            "وہ کل XKEYX سیکھے گا۔",
            "کیا آپ XKEYX کو جانتے ہیں؟",
            "XKEYX کرنا آسان ہے۔",
            "وہ کام کے بعد XKEYX کرنا پسند کرتے ہیں۔",
            "آئیے اب XKEYX سیکھتے ہیں۔",
            "مجھے XKEYX پسند نہیں ہے۔",
            "میں آج XKEYX سیکھنا چاہتا ہوں۔"
        ),
        "adjective" to listOf(
            "یہ بہت XKEYX ہے۔",
            "آج موسم XKEYX ہے۔",
            "وہ آج XKEYX لگ رہی ہے۔",
            "میں XKEYX محسوس کر رہا ہوں۔",
            "سب کچھ XKEYX لگتا ہے۔",
            "یہ XKEYX لگتا ہے۔",
            "یہ XKEYX نہیں ہے۔",
            "آپ XKEYX نظر آتے ہیں۔",
            "یہ جگہ واقعی XKEYX ہے۔",
            "کھانا XKEYX تھا۔"
        ),
        "adverb" to listOf(
            "اس نے XKEYX کا کام ختم کیا۔",
            "انہوں نے ملاقات کے دوران XKEYX سے بات کی۔",
            "براہ کرم اسے XKEYX کریں۔",
            "وہ XKEYX پہنچے۔",
            "میں اسے XKEYX سمجھ گیا۔",
            "وہ ہمیشہ XKEYX کا جواب دیتی ہے۔",
            "وہ XKEYX چلاتا ہے۔",
            "ہم نے اسے XKEYX حل کیا۔",
            "بچوں نے XKEYX کھیلا۔",
            "سب کچھ XKEYX ہوا۔"
        ),
        "number" to listOf(
            "نمبر XKEYX بورڈ پر ہے۔",
            "ایک سے XKEYX تک شمار کریں۔",
            "میرا خوش قسمت نمبر XKEYX ہے۔",
            "XKEYX میرا پسندیدہ نمبر ہے۔",
            "کمرے میں XKEYX لوگ ہیں۔",
            "مجھے XKEYX مزید منٹ درکار ہیں۔",
            "جواب ہے XKEYX۔",
            "ہم نے XKEYX گھنٹے انتظار کیا۔",
            "اس کے پاس XKEYX کتابیں ہیں۔",
            "صفحہ XKEYX آخری ہے۔"
        ),
        "other" to listOf(
            "لفظ XKEYX روزمرہ کی تقریر میں عام ہے۔",
            "ہم نے آج کے سبق میں XKEYX کا استعمال کیا۔",
            "XKEYX کے ساتھ ایک جملہ لکھیں۔",
            "یہاں XKEYX کا کیا مطلب ہے؟",
            "یہ سبق دکھاتا ہے کہ XKEYX کو کیسے استعمال کیا جائے۔",
            "میں نے آج ایک گفتگو میں XKEYX کو سنا۔",
            "یہ مشق XKEYX کے بارے میں ہے۔",
            "کیا آپ XKEYX کا ترجمہ کر سکتے ہیں؟",
            "XKEYX کو صحیح طریقے سے استعمال کرنا یاد رکھیں۔",
            "XKEYX ہر روز استعمال ہوتا ہے۔"
        )
    )

    private fun knFrames(): Map<String, List<String>> = mapOf(
        "noun" to listOf(
            "ನಾನು ಇಂದು XKEYX ಪದವನ್ನು ಕಲಿತಿದ್ದೇನೆ.",
            "ನೀವು XKEYX ಅನ್ನು ಹೇಗೆ ಬರೆಯುತ್ತೀರಿ?",
            "ನೀವು XKEYX ಅನ್ನು ಹೇಗೆ ಉಚ್ಚರಿಸುತ್ತೀರಿ?",
            "XKEYX ಅನ್ನು ಒಟ್ಟಿಗೆ ಹೇಳೋಣ.",
            "ದಯವಿಟ್ಟು XKEYX ಪದವನ್ನು ಪುನರಾವರ್ತಿಸಿ.",
            "ನಾವು ಇಂದು ತರಗತಿಯಲ್ಲಿ XKEYX ಅನ್ನು ಅಭ್ಯಾಸ ಮಾಡಿದ್ದೇವೆ.",
            "ನಾನು XKEYX ಅನ್ನು ನನ್ನ ಶಬ್ದಕೋಶ ಪಟ್ಟಿಗೆ ಸೇರಿಸಿದ್ದೇನೆ.",
            "XKEYX ಅರ್ಥವೇನು?",
            "XKEYX - ನಿಮಗೆ ಈ ಪದ ತಿಳಿದಿದೆಯೇ?",
            "XKEYX ಪದವು ಇಂದಿನ ಪಟ್ಟಿಯಲ್ಲಿದೆ."
        ),
        "verb" to listOf(
            "ನಾನು XKEYX ಗೆ ಇಷ್ಟಪಡುತ್ತೇನೆ.",
            "ನಾನು ಪ್ರತಿದಿನ XKEYX ಕಲಿಯುತ್ತೇನೆ.",
            "ನಾವು ಒಟ್ಟಿಗೆ XKEYX ಕಲಿಯುತ್ತೇವೆ.",
            "ಅವರು ನಾಳೆ XKEYX ಗೆ ಕಲಿಯುತ್ತಾರೆ.",
            "XKEYX ಮಾಡುವುದು ಹೇಗೆ ಎಂದು ನಿಮಗೆ ತಿಳಿದಿದೆಯೇ?",
            "ಇದು XKEYX ಗೆ ಸುಲಭವಾಗಿದೆ.",
            "ಅವರು ಕೆಲಸದ ನಂತರ XKEYX ಅನ್ನು ಇಷ್ಟಪಡುತ್ತಾರೆ.",
            "ಈಗ XKEYX ಗೆ ಕಲಿಯೋಣ.",
            "ನನಗೆ XKEYX ಇಷ್ಟವಿಲ್ಲ.",
            "ನಾನು ಇಂದು XKEYX ಕಲಿಯಲು ಬಯಸುತ್ತೇನೆ."
        ),
        "adjective" to listOf(
            "ಇದು ತುಂಬಾ XKEYX ಆಗಿದೆ.",
            "ಹವಾಮಾನ ಇಂದು XKEYX ಆಗಿದೆ.",
            "ಅವಳು ಇಂದು XKEYX ಎಂದು ತೋರುತ್ತಾಳೆ.",
            "ನಾನು XKEYX ಎಂದು ಭಾವಿಸುತ್ತೇನೆ.",
            "ಎಲ್ಲವೂ XKEYX ತೋರುತ್ತಿದೆ.",
            "ಅದು XKEYX ಎಂದು ಧ್ವನಿಸುತ್ತದೆ.",
            "ಇದು XKEYX ಅಲ್ಲ.",
            "ನೀವು XKEYX ಆಗಿ ಕಾಣುತ್ತೀರಿ.",
            "ಈ ಸ್ಥಳವು ನಿಜವಾಗಿಯೂ XKEYX ಆಗಿದೆ.",
            "ಆಹಾರ XKEYX ಆಗಿತ್ತು."
        ),
        "adverb" to listOf(
            "ಅವಳು XKEYX ಕೆಲಸವನ್ನು ಮುಗಿಸಿದಳು.",
            "ಸಭೆಯಲ್ಲಿ ಅವರು XKEYX ಮಾತನಾಡಿದರು.",
            "ದಯವಿಟ್ಟು ಇದನ್ನು XKEYX ಮಾಡಿ.",
            "ಅವರು XKEYX ಗೆ ಆಗಮಿಸಿದರು.",
            "ನಾನು ಅದನ್ನು ಅರ್ಥಮಾಡಿಕೊಂಡಿದ್ದೇನೆ XKEYX.",
            "ಅವಳು ಯಾವಾಗಲೂ XKEYX ಗೆ ಉತ್ತರಿಸುತ್ತಾಳೆ.",
            "ಅವರು XKEYX ಅನ್ನು ಓಡಿಸುತ್ತಾರೆ.",
            "ನಾವು XKEYX ಅನ್ನು ಪರಿಹರಿಸಿದ್ದೇವೆ.",
            "ಮಕ್ಕಳು XKEYX ಆಡಿದರು.",
            "ಎಲ್ಲವೂ XKEYX ಸಂಭವಿಸಿತು."
        ),
        "number" to listOf(
            "XKEYX ಸಂಖ್ಯೆಯು ಬೋರ್ಡ್‌ನಲ್ಲಿದೆ.",
            "ಒಂದರಿಂದ XKEYX ವರೆಗೆ ಎಣಿಸಿ.",
            "ನನ್ನ ಅದೃಷ್ಟ ಸಂಖ್ಯೆ XKEYX.",
            "XKEYX ನನ್ನ ನೆಚ್ಚಿನ ಸಂಖ್ಯೆ.",
            "ಕೋಣೆಯಲ್ಲಿ XKEYX ಜನರಿದ್ದಾರೆ.",
            "ನನಗೆ ಇನ್ನೂ XKEYX ನಿಮಿಷಗಳ ಅಗತ್ಯವಿದೆ.",
            "ಉತ್ತರ XKEYX ಆಗಿದೆ.",
            "ನಾವು XKEYX ಗಂಟೆಗಳ ಕಾಲ ಕಾಯುತ್ತಿದ್ದೇವೆ.",
            "ಅವಳು XKEYX ಪುಸ್ತಕಗಳನ್ನು ಹೊಂದಿದ್ದಾಳೆ.",
            "ಪುಟ XKEYX ಕೊನೆಯದು."
        ),
        "other" to listOf(
            "XKEYX ಪದವು ದೈನಂದಿನ ಭಾಷಣದಲ್ಲಿ ಸಾಮಾನ್ಯವಾಗಿದೆ.",
            "ಇಂದಿನ ಪಾಠದಲ್ಲಿ ನಾವು XKEYX ಅನ್ನು ಬಳಸಿದ್ದೇವೆ.",
            "XKEYX ನೊಂದಿಗೆ ವಾಕ್ಯವನ್ನು ಬರೆಯಿರಿ.",
            "ಇಲ್ಲಿ XKEYX ಎಂದರೆ ಏನು?",
            "ಈ ಪಾಠವು XKEYX ಅನ್ನು ಹೇಗೆ ಬಳಸುವುದು ಎಂಬುದನ್ನು ತೋರಿಸುತ್ತದೆ.",
            "ನಾನು ಇಂದು ಸಂಭಾಷಣೆಯಲ್ಲಿ XKEYX ಅನ್ನು ಕೇಳಿದೆ.",
            "ಈ ವ್ಯಾಯಾಮ ಸುಮಾರು XKEYX ಆಗಿದೆ.",
            "ನೀವು XKEYX ಅನ್ನು ಅನುವಾದಿಸಬಹುದೇ?",
            "XKEYX ಅನ್ನು ಸರಿಯಾಗಿ ಬಳಸಲು ಮರೆಯದಿರಿ.",
            "XKEYX ಅನ್ನು ಪ್ರತಿದಿನ ಬಳಸಲಾಗುತ್ತದೆ."
        )
    )

    private fun enSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "I asked him how he was, and he said \"XKEYX\" to me.",
                "She looked up and replied \"XKEYX\" without hesitating.",
                "He turned around and said \"XKEYX\" before he left.",
                "I called her on the phone, and she answered \"XKEYX\" right away.",
                "She waved at me and called out \"XKEYX\" across the street.",
                "When I saw him this morning, he greeted me with \"XKEYX\" and a smile.",
                "I sent her a message, and she texted back \"XKEYX\" a minute later.",
                "He smiled and said \"XKEYX\" to everyone in the room.",
                "She opened the door and said \"XKEYX\" in a quiet voice.",
                "He looked up from his work and said \"XKEYX\" to me."
            )
    )

    private fun hiSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "मैंने उससे पूछा कि वह कैसा है, और उसने मुझसे \"XKEYX\" कहा।",
                "उसने बिना झिझक \"XKEYX\" कहा।",
                "जाने से पहले उसने मुड़कर \"XKEYX\" कहा।",
                "मैंने उसे फ़ोन किया, और उसने तुरंत \"XKEYX\" कहा।",
                "उसने मुझे देखकर सड़क के उस पार से \"XKEYX\" कहा।",
                "आज सुबह जब मैं उससे मिला, तो उसने मुस्कुराकर \"XKEYX\" कहा।",
                "मैंने उसे संदेश भेजा, और उसने एक मिनट बाद \"XKEYX\" लिखा।",
                "वह मुस्कुराया और कमरे में सबसे \"XKEYX\" कहा।",
                "उसने दरवाज़ा खोला और धीमी आवाज़ में \"XKEYX\" कहा।",
                "उसने अपने काम से सिर उठाकर मुझसे \"XKEYX\" कहा।"
            )
    )

    private fun jaSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "彼に元気かと聞いたら、彼は私に「XKEYX」と言いました。",
                "彼女はためらわずに「XKEYX」と答えました。",
                "出かける前に彼は振り返って「XKEYX」と言いました。",
                "私が電話すると、彼女はすぐに「XKEYX」と答えました。",
                "彼女は手を振りながら、通りの向こうから「XKEYX」と呼びました。",
                "今朝会ったとき、彼は笑顔で「XKEYX」と言いました。",
                "私がメッセージを送ると、彼女はすぐに「XKEYX」と返信しました。",
                "彼は笑って、部屋のみんなに「XKEYX」と言いました。",
                "彼女はドアを開けて、小さな声で「XKEYX」と言いました。",
                "彼は仕事の手を止めて、私に「XKEYX」と言いました。"
            )
    )

    private fun esSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "Le pregunté cómo estaba, y me dijo \"XKEYX\".",
                "Ella respondió \"XKEYX\" sin dudar.",
                "Se dio la vuelta y dijo \"XKEYX\" antes de irse.",
                "La llamé por teléfono y contestó \"XKEYX\" enseguida.",
                "Me saludó con la mano y me gritó \"XKEYX\" desde el otro lado de la calle.",
                "Cuando lo vi esta mañana, me recibió con un \"XKEYX\" y una sonrisa.",
                "Le envié un mensaje y me respondió \"XKEYX\" un minuto después.",
                "Sonrió y le dijo \"XKEYX\" a todos en la sala.",
                "Abrió la puerta y dijo \"XKEYX\" en voz baja.",
                "Levantó la vista de su trabajo y me dijo \"XKEYX\"."
            )
    )

    private fun arSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "سألته كيف حاله، فقال لي «XKEYX».",
                "أجابت «XKEYX» دون تردد.",
                "استدار وقال «XKEYX» قبل أن يغادر.",
                "اتصلت بها، فأجابت «XKEYX» على الفور.",
                "لوّحت لي ونادت «XKEYX» من الجهة الأخرى من الشارع.",
                "عندما رأيته هذا الصباح، استقبلني بـ«XKEYX» وابتسامة.",
                "أرسلت لها رسالة، فأجابت «XKEYX» بعد دقيقة.",
                "ابتسم وقال «XKEYX» لكل من في الغرفة.",
                "فتح الباب وقال «XKEYX» بصوت هادئ.",
                "رفع رأسه من عمله وقال لي «XKEYX»."
            )
    )

    private fun frSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "Je lui ai demandé comment il allait, et il m'a dit \"XKEYX\".",
                "Elle a répondu \"XKEYX\" sans hésiter.",
                "Il s'est retourné et a dit \"XKEYX\" avant de partir.",
                "Je l'ai appelée, et elle a répondu \"XKEYX\" tout de suite.",
                "Elle m'a fait un signe et m'a crié \"XKEYX\" depuis l'autre côté de la rue.",
                "Quand je l'ai vu ce matin, il m'a accueilli avec un \"XKEYX\" et un sourire.",
                "Je lui ai envoyé un message, et elle m'a répondu \"XKEYX\" une minute plus tard.",
                "Il a souri et a dit \"XKEYX\" à tout le monde dans la salle.",
                "Elle a ouvert la porte et a dit \"XKEYX\" à voix basse.",
                "Il a levé les yeux de son travail et m'a dit \"XKEYX\"."
            )
    )

    private fun deSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "Ich fragte ihn, wie es ihm geht, und er sagte \"XKEYX\" zu mir.",
                "Sie antwortete \"XKEYX\", ohne zu zögern.",
                "Er drehte sich um und sagte \"XKEYX\", bevor er ging.",
                "Ich rief sie an, und sie antwortete sofort \"XKEYX\".",
                "Sie winkte mir zu und rief \"XKEYX\" von der anderen Straßenseite.",
                "Als ich ihn heute Morgen sah, begrüßte er mich mit einem \"XKEYX\" und einem Lächeln.",
                "Ich schickte ihr eine Nachricht, und sie antwortete eine Minute später \"XKEYX\".",
                "Er lächelte und sagte \"XKEYX\" zu allen im Raum.",
                "Sie öffnete die Tür und sagte \"XKEYX\" mit leiser Stimme.",
                "Er sah von seiner Arbeit auf und sagte \"XKEYX\" zu mir."
            )
    )

    private fun bnSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "আমি তাকে জিজ্ঞাসা করলাম সে কেমন আছে, আর সে আমাকে \"XKEYX\" বলল।",
                "সে দ্বিধা না করে \"XKEYX\" বলে উত্তর দিল।",
                "যাওয়ার আগে সে ঘুরে দাঁড়িয়ে \"XKEYX\" বলল।",
                "আমি তাকে ফোন করলাম, আর সে সঙ্গে সঙ্গে \"XKEYX\" বলল।",
                "সে আমাকে হাত নেড়ে রাস্তার ওপার থেকে \"XKEYX\" বলে ডাকল।",
                "আজ সকালে তাকে দেখে সে হাসিমুখে \"XKEYX\" বলল।",
                "আমি তাকে একটা বার্তা পাঠালাম, আর সে এক মিনিট পরে \"XKEYX\" লিখে পাঠাল।",
                "সে হাসল এবং ঘরের সবাইকে \"XKEYX\" বলল।",
                "সে দরজা খুলে নিচু স্বরে \"XKEYX\" বলল।",
                "সে তার কাজ থেকে মুখ তুলে আমাকে \"XKEYX\" বলল।"
            )
    )

    private fun taSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "நான் அவனிடம் எப்படி இருக்கிறாய் என்று கேட்டேன், அவன் என்னிடம் \"XKEYX\" என்றான்.",
                "அவள் தயங்காமல் \"XKEYX\" என்று பதிலளித்தாள்.",
                "கிளம்பும் முன் அவன் திரும்பி \"XKEYX\" என்றான்.",
                "நான் அவளை அழைத்தேன், அவள் உடனே \"XKEYX\" என்றாள்.",
                "அவள் என்னை நோக்கி கையசைத்து தெருவின் மறுபுறத்திலிருந்து \"XKEYX\" என்று கூப்பிட்டாள்.",
                "இன்று காலையில் அவனைப் பார்த்தபோது, அவன் புன்னகையுடன் \"XKEYX\" என்றான்.",
                "நான் அவளுக்கு ஒரு செய்தி அனுப்பினேன், ஒரு நிமிடத்தில் \"XKEYX\" என்று பதிலளித்தாள்.",
                "அவன் சிரித்துக்கொண்டு அறையில் இருந்த அனைவரிடமும் \"XKEYX\" என்றான்.",
                "அவள் கதவைத் திறந்து மெல்லிய குரலில் \"XKEYX\" என்றாள்.",
                "அவன் தன் வேலையிலிருந்து நிமிர்ந்து என்னிடம் \"XKEYX\" என்றான்."
            )
    )

    private fun teSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "నేను అతన్ని ఎలా ఉన్నావు అని అడిగాను, అతను నాతో \"XKEYX\" అన్నాడు.",
                "ఆమె సందేహించకుండా \"XKEYX\" అని సమాధానమిచ్చింది.",
                "వెళ్లే ముందు అతను తిరిగి \"XKEYX\" అన్నాడు.",
                "నేను ఆమెకు ఫోన్ చేశాను, ఆమె వెంటనే \"XKEYX\" అని పలికింది.",
                "ఆమె నాకు చేయి ఊపి వీధికి అవతలి నుంచి \"XKEYX\" అని పిలిచింది.",
                "ఈ ఉదయం అతన్ని చూసినప్పుడు, అతను నవ్వుతూ \"XKEYX\" అన్నాడు.",
                "నేను ఆమెకు సందేశం పంపాను, ఒక నిమిషంలో \"XKEYX\" అని జవాబిచ్చింది.",
                "అతను నవ్వి గదిలో ఉన్న అందరికీ \"XKEYX\" అన్నాడు.",
                "ఆమె తలుపు తెరిచి మెల్లగా \"XKEYX\" అన్నది.",
                "అతను తన పని నుంచి తలెత్తి నాతో \"XKEYX\" అన్నాడు."
            )
    )

    private fun urSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "میں نے اس سے پوچھا کہ وہ کیسا ہے، اور اس نے مجھ سے \"XKEYX\" کہا۔",
                "اس نے بغیر جھجک \"XKEYX\" کہا۔",
                "جانے سے پہلے وہ مڑا اور \"XKEYX\" کہا۔",
                "میں نے اسے فون کیا، اور اس نے فوراً \"XKEYX\" کہا۔",
                "اس نے مجھے دیکھ کر سڑک کے دوسری طرف سے \"XKEYX\" کہا۔",
                "آج صبح جب میں اس سے ملا، تو اس نے مسکرا کر \"XKEYX\" کہا۔",
                "میں نے اسے پیغام بھیجا، اور اس نے ایک منٹ بعد \"XKEYX\" لکھا۔",
                "وہ مسکرایا اور کمرے میں سب سے \"XKEYX\" کہا۔",
                "اس نے دروازہ کھولا اور آہستہ آواز میں \"XKEYX\" کہا۔",
                "اس نے اپنے کام سے سر اٹھا کر مجھ سے \"XKEYX\" کہا۔"
            )
    )

    private fun knSpecial(): Map<String, List<String>> = mapOf(
        "phrase" to listOf(
                "ಅವನು ಹೇಗಿದ್ದಾನೆ ಎಂದು ನಾನು ಕೇಳಿದೆ, ಅವನು ನನಗೆ \"XKEYX\" ಎಂದನು.",
                "ಅವಳು ಹಿಂಜರಿಯದೆ \"XKEYX\" ಎಂದು ಉತ್ತರಿಸಿದಳು.",
                "ಹೊರಡುವ ಮೊದಲು ಅವನು ತಿರುಗಿ \"XKEYX\" ಎಂದನು.",
                "ನಾನು ಅವಳಿಗೆ ಫೋನ್ ಮಾಡಿದೆ, ಅವಳು ತಕ್ಷಣ \"XKEYX\" ಎಂದಳು.",
                "ಅವಳು ನನಗೆ ಕೈ ಬೀಸಿ ಬೀದಿಯ ಆಚೆಯಿಂದ \"XKEYX\" ಎಂದು ಕೂಗಿದಳು.",
                "ಇಂದು ಬೆಳಿಗ್ಗೆ ಅವನನ್ನು ನೋಡಿದಾಗ, ಅವನು ನಗುತ್ತಾ \"XKEYX\" ಎಂದನು.",
                "ನಾನು ಅವಳಿಗೆ ಸಂದೇಶ ಕಳುಹಿಸಿದೆ, ಒಂದು ನಿಮಿಷದಲ್ಲಿ \"XKEYX\" ಎಂದು ಉತ್ತರಿಸಿದಳು.",
                "ಅವನು ನಗುತ್ತಾ ಕೋಣೆಯ ಎಲ್ಲರಿಗೂ \"XKEYX\" ಎಂದನು.",
                "ಅವಳು ಬಾಗಿಲು ತೆರೆದು ಮೆಲ್ಲಗೆ \"XKEYX\" ಎಂದಳು.",
                "ಅವನು ತನ್ನ ಕೆಲಸದಿಂದ ತಲೆ ಎತ್ತಿ ನನಗೆ \"XKEYX\" ಎಂದನು."
            )
    )
