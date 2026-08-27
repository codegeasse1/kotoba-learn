package com.nexo.kotoba

object EnA2 {

    val lessons = listOf(
        L.en("e2-01", "Daily routine", "🌅", "Your day from morning to night.", "A2", """
            wake up|/weɪk ʌp/|जागना
            get up|/ɡet ʌp/|उठना
            shower|/ˈʃaʊər/|स्नान
            breakfast|/ˈbrekfəst/|नाश्ता
            leave|/liːv/|निकलना / छोड़ना
            arrive|/əˈraɪv/|पहुँचना
            lunch|/lʌntʃ/|दोपहर का भोजन
            dinner|/ˈdɪnər/|रात का भोजन
            sleep|/sliːp/|सोना
            work|/wɜːrk/|काम
        """),
        L.en("e2-02", "Weather & seasons", "🌦️", "Describe the weather outside.", "A2", """
            sunny|/ˈsʌni/|धूपदार
            rainy|/ˈreɪni/|बरसाती
            cloudy|/ˈklaʊdi/|बादलदार
            snowy|/ˈsnoʊi/|बर्फीला
            hot|/hɒt/|गर्म
            cold|/koʊld/|ठंडा
            warm|/wɔːrm/|गुनगुना
            cool|/kuːl/|ठंडा-ठंडा
            windy|/ˈwɪndi/|हवादार
            foggy|/ˈfɒɡi/|कोहरेदार
        """),
        L.en("e2-03", "Shopping", "🛒", "Money, sizes and buying things.", "A2", """
            buy|/baɪ/|ख़रीदना
            sell|/sel/|बेचना
            price|/praɪs/|क़ीमत
            cheap|/tʃiːp/|सस्ता
            expensive|/ɪkˈspensɪv/|महँगा
            money|/ˈmʌni/|पैसा
            shop|/ʃɒp/|दुकान
            supermarket|/ˈsuːpərmɑːrkɪt/|सुपरमार्केट
            size|/saɪz/|साइज़
            pay|/peɪ/|भुगतान करना
        """),
        L.en("e2-04", "Feelings", "🎭", "How do you feel right now?", "A2", """
            happy|/ˈhæpi/|खुश
            sad|/sæd/|उदास
            angry|/ˈæŋɡri/|गुस्सा
            tired|/ˈtaɪərd/|थका हुआ
            hungry|/ˈhʌŋɡri/|भूखा
            thirsty|/ˈθɜːrsti/|प्यासा
            worried|/ˈwʌrid/|चिंतित
            excited|/ɪkˈsaɪtɪd/|उत्साहित
            bored|/bɔːrd/|ऊबा हुआ
            scared|/skeərd/|डरा हुआ
        """),
        L.en("e2-05", "Hobbies & free time", "🎨", "What you do for fun.", "A2", """
            music|/ˈmjuːzɪk/|संगीत
            movie|/ˈmuːvi/|फ़िल्म
            sport|/spɔːrt/|खेल
            game|/ɡeɪm/|खेल (गेम)
            reading|/ˈriːdɪŋ/|पढ़ना
            painting|/ˈpeɪntɪŋ/|चित्रकला
            dancing|/ˈdænsɪŋ/|नृत्य
            singing|/ˈsɪŋɪŋ/|गायन
            cooking|/ˈkʊkɪŋ/|खाना बनाना
            travel|/ˈtrævəl/|यात्रा
        """),
        L.en("e2-06", "Health", "🩺", "Doctor visits and how you feel.", "A2", """
            doctor|/ˈdɒktər/|डॉक्टर
            medicine|/ˈmedɪsən/|दवा
            hospital|/ˈhɒspɪtəl/|अस्पताल
            pain|/peɪn/|दर्द
            headache|/ˈhedeɪk/|सिरदर्द
            fever|/ˈfiːvər/|बुखार
            cough|/kɒf/|खाँसी
            rest|/rest/|आराम
            healthy|/ˈhelθi/|स्वस्थ
            sick|/sɪk/|बीमार
        """),
        L.en("e2-07", "Places in town", "🏙️", "Find your way around a city.", "A2", """
            bank|/bæŋk/|बैंक
            post office|/poʊst ˈɒfɪs/|डाकघर
            library|/ˈlaɪbreri/|पुस्तकालय
            museum|/mjuˈziːəm/|संग्रहालय
            park|/pɑːrk/|पार्क
            station|/ˈsteɪʃən/|स्टेशन
            airport|/ˈeəpɔːrt/|हवाई अड्डा
            market|/ˈmɑːrkɪt/|बाज़ार
            street|/striːt/|गली
            bridge|/brɪdʒ/|पुल
        """),
        L.en("e2-08", "Transport", "🚌", "How you get around.", "A2", """
            bus|/bʌs/|बस
            train|/treɪn/|रेलगाड़ी
            car|/kɑːr/|कार
            bike|/baɪk/|साइकिल
            taxi|/ˈtæksi/|टैक्सी
            plane|/pleɪn/|हवाई जहाज़
            boat|/boʊt/|नाव
            ticket|/ˈtɪkɪt/|टिकट
            station|/ˈsteɪʃən/|स्टेशन
            journey|/ˈdʒɜːrni/|यात्रा
        """)
    )

    val patterns = listOf(
        L.ep("epA2-a", "was / were — past of 'be'", "be動詞の過去",
            "A2", "Past of am/is/are: I/he/she/it → was; you/we/they → were. Negative: wasn't / weren't.",
            "am/is/are का भूतकाल: I/he/she/it के साथ was, you/we/they के साथ were।",
            """
                I was at home yesterday.||I was at home yesterday.|मैं कल घर पर था।
                They were very happy.||They were very happy.|वे बहुत खुश थे।
                She wasn't at the meeting.||She wasn't at the meeting.|वह बैठक में नहीं थी।
            """),
        L.ep("epA2-b", "Past simple — regular verbs (-ed)", "過去形（規則動詞）",
            "A2", "Add -ed to regular verbs for the past: work → worked, play → played. Negative: didn't + base verb.",
            "नियमित क्रियाओं में -ed जोड़कर भूतकाल। नकारात्मक: didn't + मूल क्रिया।",
            """
                I worked late last night.||I worked late last night.|मैंने कल रात देर तक काम किया।
                We played football yesterday.||We played football yesterday.|हमने कल फ़ुटबॉल खेला।
                She didn't watch TV.||She didn't watch TV.|उसने टीवी नहीं देखा।
            """),
        L.ep("epA2-c", "Past simple — irregular verbs", "過去形（不規則動詞）",
            "A2", "Many common verbs are irregular: go → went, eat → ate, see → saw, have → had, come → came.",
            "कई आम क्रियाएँ अनियमित हैं: go→went, eat→ate, see→saw, have→had।",
            """
                I went to the market.||I went to the market.|मैं बाज़ार गया।
                She ate an apple.||She ate an apple.|उसने एक सेब खाया।
                We saw a great movie.||We saw a great movie.|हमने बढ़िया फ़िल्म देखी।
                He came home late.||He came home late.|वह देर से घर आया।
            """),
        L.ep("epA2-d", "Present continuous — am/is/are + -ing", "現在進行形",
            "A2", "For actions happening right now: am/is/are + verb-ing. She is reading now.",
            "अभी चल रहे काम के लिए: am/is/are + क्रिया-ing।",
            """
                I am studying now.||I am studying now.|मैं अभी पढ़ रहा हूँ।
                She is cooking dinner.||She is cooking dinner.|वह रात का खाना बना रही है।
                They are playing in the park.||They are playing in the park.|वे पार्क में खेल रहे हैं।
            """),
        L.ep("epA2-e", "going to — future plans", "going to（未来の予定）",
            "A2", "For plans and intentions: am/is/are + going to + verb. Also for predictions with clear evidence.",
            "योजना/इरादे के लिए: going to + क्रिया।",
            """
                I am going to visit my grandparents.||I am going to visit my grandparents.|मैं अपने दादा-दादी से मिलने जाऊँगा।
                She is going to buy a new phone.||She is going to buy a new phone.|वह नया फ़ोन ख़रीदने वाली है।
                Look at the clouds! It's going to rain.||Look at the clouds! It's going to rain.|बादल देखो! बारिश होने वाली है।
            """),
        L.ep("epA2-f", "can / can't — ability", "can / can't（能力）",
            "A2", "can + base verb for ability or permission. Negative: can't (cannot).",
            "क्षमता/अनुमति के लिए: can + क्रिया। नकारात्मक: can't।",
            """
                I can swim very well.||I can swim very well.|मैं बहुत अच्छे से तैर सकता हूँ।
                She can speak three languages.||She can speak three languages.|वह तीन भाषाएँ बोल सकती है।
                He can't come today.||He can't come today.|वह आज नहीं आ सकता।
            """),
        L.ep("epA2-g", "Comparatives — -er / more", "比較級 -er / more",
            "A2", "Short words take -er (big → bigger), long words take 'more' (expensive → more expensive). Use than: X is bigger than Y.",
            "छोटे शब्दों में -er, लंबे शब्दों में more। than = से (तुलना)।",
            """
                My house is bigger than yours.||My house is bigger than yours.|मेरा घर तुम्हारे से बड़ा है।
                This phone is more expensive.||This phone is more expensive.|यह फ़ोन ज़्यादा महँगा है।
                Today is hotter than yesterday.||Today is hotter than yesterday.|आज कल से ज़्यादा गर्म है।
            """),
        L.ep("epA2-h", "Superlatives — the -est / most", "最上級 the -est / most",
            "A2", "Short words take -est (biggest), long words take 'most' (most expensive). Use the: the biggest city.",
            "सबसे ज़्यादा के लिए: छोटे शब्दों में -est, लंबे में most। the के साथ।",
            """
                This is the biggest city in India.||This is the biggest city in India.|यह भारत का सबसे बड़ा शहर है।
                She is the most talented student.||She is the most talented student.|वह सबसे प्रतिभाशाली छात्रा है।
                It was the best day of my life.||It was the best day of my life.|यह मेरे जीवन का सबसे अच्छा दिन था।
            """),
        L.ep("epA2-i", "some / any — how much or how many", "some / any",
            "A2", "Use 'some' in positive sentences and 'any' in questions and negatives.",
            "सकारात्मक में some, प्रश्न व नकारात्मक में any।",
            """
                I have some money.||I have some money.|मेरे पास कुछ पैसे हैं।
                Do you have any questions?||Do you have any questions?|क्या आपके कोई प्रश्न हैं?
                There isn't any milk left.||There isn't any milk left.|दूध बिल्कुल नहीं बचा।
            """),
        L.ep("epA2-j", "must / have to — obligation", "must / have to（義務）",
            "A2", "Both mean it is necessary. have to is more common in everyday speech; must is stronger and more formal.",
            "अनिवार्यता के लिए: must और have to।",
            """
                You must wear a helmet.||You must wear a helmet.|आपको हेलमेट पहनना चाहिए।
                I have to finish this today.||I have to finish this today.|मुझे यह आज ख़त्म करना है।
                She has to wake up early.||She has to wake up early.|उसे जल्दी उठना पड़ता है।
            """)
    )
}
