package com.nexo.kotoba

/**
 * Hand-written extra example sentences for the English grammar patterns whose
 * own list (or a close relative) can't reach ten sentences. Each line is:
 *
 *     emoji|english sentence||english sentence|hindi translation
 *
 * `GrammarPacks.parse` splits on `|`, so the empty third field is the (unused)
 * romaji slot. Keep one entry per pattern id.
 */
internal object GrammarExtraEn {
    val raw: Map<String, String> = mapOf(

        "en3" to """
            🍎|I have three apples.| | |मेरे पास तीन सेब हैं।
            🐈|There are two cats in the garden.| | |बगीचे में दो बिल्लियाँ हैं।
            📚|She reads many books every year.| | |वह हर साल बहुत सी किताबें पढ़ती है।
            🚌|The buses arrive every ten minutes.| | |बसें हर दस मिनट में आती हैं।
            🧒|The children are playing outside.| | |बच्चे बाहर खेल रहे हैं।
            🏠|Those houses are very old.| | |वे घर बहुत पुराने हैं।
            🗂️|I bought two boxes of pencils.| | |मैंने पेंसिल के दो डिब्बे खरीदे।
        """,

        "en9" to """
            🪑|There is a chair in the corner.| | |कोने में एक कुर्सी है।
            🍶|There is some water in the bottle.| | |बोतल में थोड़ा पानी है।
            🪟|There are four windows in my room.| | |मेरे कमरे में चार खिड़कियाँ हैं।
            🐕|There is a dog in the yard.| | |आँगन में एक कुत्ता है।
            🏪|There are many shops on this street.| | |इस सड़क पर बहुत सी दुकानें हैं।
            ❓|Is there a hospital near here?| | |क्या यहाँ पास में अस्पताल है?
            ❌|There aren't any eggs in the fridge.| | |फ्रिज में कोई अंडे नहीं हैं।
            🚉|There was a big crowd at the station.| | |स्टेशन पर बहुत भीड़ थी।
        """,

        "en27" to """
            ☕|This coffee is too hot to drink.| | |यह कॉफ़ी पीने के लिए बहुत गर्म है।
            🎒|This bag is too heavy for me.| | |यह बैग मेरे लिए बहुत भारी है।
            👕|The shirt is not big enough.| | |कमीज़ काफ़ी बड़ी नहीं है।
            🚗|He is old enough to drive.| | |वह गाड़ी चलाने के लिए काफ़ी बड़ा है।
            🍲|There is too much salt in the soup.| | |सूप में बहुत ज़्यादा नमक है।
            👥|There were too many people on the bus.| | |बस में बहुत ज़्यादा लोग थे।
            💰|I don't have enough money for a ticket.| | |मेरे पास टिकट के लिए काफ़ी पैसे नहीं हैं।
            🕐|She woke up too late this morning.| | |वह आज सुबह बहुत देर से उठी।
        """,

        "en28" to """
            🏃|I used to run every morning.| | |मैं हर सुबह दौड़ता था।
            🚬|He used to smoke, but he stopped.| | |वह पहले धूम्रपान करता था, पर छोड़ दिया।
            🏡|We used to live in a small village.| | |हम पहले एक छोटे गाँव में रहते थे।
            🎸|She used to play the guitar.| | |वह पहले गिटार बजाती थी।
            🚌|There used to be a bus stop here.| | |यहाँ पहले एक बस स्टॉप हुआ करता था।
            🍬|I didn't use to like sweets.| | |मुझे पहले मिठाई पसंद नहीं थी।
            ❓|Did you use to work in a bank?| | |क्या आप पहले बैंक में काम करते थे?
            📞|We used to talk for hours.| | |हम पहले घंटों बातें करते थे।
        """,

        "en29" to """
            ☀️|It's a lovely day, isn't it?| | |आज सुंदर दिन है, है ना?
            🚪|You closed the door, didn't you?| | |तुमने दरवाज़ा बंद किया, नहीं किया?
            🐟|She doesn't eat fish, does she?| | |वह मछली नहीं खाती, है ना?
            🎓|They are students, aren't they?| | |वे विद्यार्थी हैं, है ना?
            🕰️|You haven't seen this film, have you?| | |तुमने यह फ़िल्म नहीं देखी, है ना?
            🚗|He can drive, can't he?| | |वह गाड़ी चला सकता है, है ना?
            🌧️|It wasn't raining, was it?| | |बारिश नहीं हो रही थी, है ना?
            ✈️|We should leave now, shouldn't we?| | |हमें अब निकलना चाहिए, है ना?
        """,

        "en30" to """
            👩|The woman who lives next door is a doctor.| | |अगले घर में रहने वाली महिला डॉक्टर है।
            📱|This is the phone that I bought yesterday.| | |यह वह फ़ोन है जो मैंने कल खरीदा।
            🏠|The house which we visited was beautiful.| | |जिस घर में हम गए थे वह सुंदर था।
            🐕|The dog that bit me ran away.| | |जिस कुत्ते ने मुझे काटा वह भाग गया।
            🧑|I know a man whose son plays cricket.| | |मैं एक आदमी को जानता हूँ जिसका बेटा क्रिकेट खेलता है।
            🍜|The food that she cooked was delicious.| | |उसने जो खाना बनाया वह स्वादिष्ट था।
            🚂|The train which goes to Delhi is late.| | |जो ट्रेन दिल्ली जाती है वह देर से है।
            📖|That's the book I told you about.| | |यही वह किताब है जिसके बारे में मैंने बताया।
        """,

        "epA1-c" to """
            🚗|We have two cars.| | |हमारे पास दो कारें हैं।
            🍊|She bought three oranges.| | |उसने तीन संतरे खरीदे।
            🐦|The birds are singing.| | |पक्षी गा रहे हैं।
            🏫|There are many schools in the city.| | |शहर में बहुत से स्कूल हैं।
            👟|These shoes are new.| | |ये जूते नए हैं।
            🧺|I washed the dishes after dinner.| | |मैंने रात के खाने के बाद बर्तन धोए।
            📦|He carried six boxes upstairs.| | |वह छह डिब्बे ऊपर ले गया।
        """,

        "epA1-e" to """
            🐘|There is an elephant in the zoo.| | |चिड़ियाघर में एक हाथी है।
            🌳|There are many trees in the park.| | |पार्क में बहुत से पेड़ हैं।
            💧|There is some milk in the glass.| | |गिलास में थोड़ा दूध है।
            🏥|Is there a hospital near your house?| | |क्या तुम्हारे घर के पास अस्पताल है?
            🍰|There are two cakes on the table.| | |मेज़ पर दो केक हैं।
            🎒|There is a pen in my bag.| | |मेरे बैग में एक कलम है।
            🚌|There are no buses today.| | |आज कोई बस नहीं है।
        """,

        "epA1-f" to """
            📕|This book is very interesting.| | |यह किताब बहुत रोचक है।
            🖼️|That picture on the wall is old.| | |दीवार पर वह तस्वीर पुरानी है।
            🥭|These mangoes are sweet.| | |ये आम मीठे हैं।
            🌲|Those trees are very tall.| | |वे पेड़ बहुत ऊँचे हैं।
            📱|This is my new phone.| | |यह मेरा नया फ़ोन है।
            👞|Those shoes are too small.| | |वे जूते बहुत छोटे हैं।
            🍪|These cookies taste great.| | |ये कुकीज़ बहुत स्वादिष्ट हैं।
        """,

        "epA1-h" to """
            🎒|This is my school bag.| | |यह मेरा स्कूल बैग है।
            🚲|Your bicycle is outside.| | |तुम्हारी साइकिल बाहर है।
            📗|His notebook is on the desk.| | |उसकी कॉपी मेज़ पर है।
            🧣|Her scarf is very colourful.| | |उसका स्कार्फ़ बहुत रंगीन है।
            🐕|Our dog loves to play.| | |हमारा कुत्ता खेलना पसंद करता है।
            🏠|Their house is near the market.| | |उनका घर बाज़ार के पास है।
            📞|Can I use your phone, please?| | |क्या मैं तुम्हारा फ़ोन इस्तेमाल कर सकता हूँ?
        """,

        "epA1-j" to """
            🚪|Close the window, please.| | |कृपया खिड़की बंद करें।
            🪑|Sit down and relax.| | |बैठ जाओ और आराम करो।
            🚭|Don't smoke here.| | |यहाँ धूम्रपान न करें।
            📖|Open your books to page ten.| | |अपनी किताबें दसवें पन्ने पर खोलें।
            🤫|Please be quiet in the library.| | |कृपया पुस्तकालय में चुप रहें।
            🚦|Turn left at the traffic light.| | |ट्रैफ़िक लाइट पर बाएँ मुड़ें।
        """,

        "epA2-a" to """
            🧒|I was at home all day.| | |मैं सारा दिन घर पर था।
            ☀️|The weather was beautiful yesterday.| | |कल मौसम सुंदर था।
            👥|They were very tired after the trip.| | |यात्रा के बाद वे बहुत थके थे।
            🍽️|We were at the restaurant last night.| | |हम कल रात रेस्तराँ में थे।
            📚|She was a teacher before.| | |वह पहले शिक्षिका थी।
            ❓|Were you at the party?| | |क्या तुम पार्टी में थे?
            ❌|He was not happy with the result.| | |वह नतीजे से खुश नहीं था।
        """,

        "epB1-h" to """
            👨|The man who called you is my uncle.| | |जिस आदमी ने तुम्हें फ़ोन किया वह मेरा चाचा है।
            🏔️|This is the mountain that we climbed.| | |यह वह पहाड़ है जिस पर हम चढ़े।
            🎁|The gift which she gave me was lovely.| | |उसने जो उपहार दिया वह सुंदर था।
            🧑|I met a girl whose father is a pilot.| | |मैं एक लड़की से मिला जिसके पिता पायलट हैं।
            🚌|The bus that goes to the airport is late.| | |जो बस हवाई अड्डे जाती है वह देर से है।
            🐈|The cat which was sleeping is mine.| | |जो बिल्ली सो रही थी वह मेरी है।
            🍛|This is the dish that my mother makes.| | |यह वह व्यंजन है जो मेरी माँ बनाती हैं।
        """,

        "epB1-j" to """
            🏫|I used to walk to school.| | |मैं पहले पैदल स्कूल जाता था।
            🎮|He used to play video games all night.| | |वह पहले सारी रात वीडियो गेम खेलता था।
            🏖️|We used to go to the beach every summer.| | |हम हर गर्मी समुद्र तट जाते थे।
            🏦|She used to work in a bank.| | |वह पहले बैंक में काम करती थी।
            ❌|I didn't use to drink coffee.| | |मैं पहले कॉफ़ी नहीं पीता था।
            ❓|Did you use to live here?| | |क्या आप पहले यहाँ रहते थे?
            🐕|There used to be a dog in this house.| | |इस घर में पहले एक कुत्ता हुआ करता था।
        """,

        "epB2-a" to """
            🚌|If I had left earlier, I would have caught the bus.| | |अगर मैं जल्दी निकलता, तो बस पकड़ लेता।
            📖|If she had studied, she would have passed.| | |अगर उसने पढ़ाई की होती, तो पास हो जाती।
            ☂️|If we had taken an umbrella, we wouldn't have got wet.| | |अगर हम छाता लेते, तो भीगते नहीं।
            ☎️|If you had called me, I would have helped.| | |अगर तुमने फ़ोन किया होता, तो मैं मदद करता।
            🎫|They would have come if they had known.| | |अगर उन्हें पता होता तो वे आते।
            💰|If he had saved money, he would have bought a car.| | |अगर उसने पैसे बचाए होते, तो कार खरीद लेता।
            🌧️|I wouldn't have gone out if it had rained.| | |अगर बारिश होती तो मैं बाहर नहीं जाता।
        """,

        "epB2-b" to """
            😴|If I had slept earlier, I wouldn't be tired now.| | |अगर मैं जल्दी सोया होता, तो अब थका न होता।
            💼|If she had taken the job, she would be in London now.| | |अगर उसने नौकरी ली होती, तो अब लंदन में होती।
            🏡|If I were rich, I would have bought that house.| | |अगर मैं अमीर होता, तो वह घर खरीद लेता।
            🗣️|If he spoke English, he would have got the job.| | |अगर उसे अंग्रेज़ी आती, तो उसे नौकरी मिल जाती।
            📚|If you had studied medicine, you would be a doctor now.| | |अगर तुमने मेडिसिन पढ़ी होती, तो अब डॉक्टर होते।
            🚗|If we had left earlier, we would be there by now.| | |अगर हम जल्दी निकलते, तो अब तक वहाँ होते।
            🍔|If I weren't so busy, I would have joined you.| | |अगर मैं इतना व्यस्त न होता, तो तुम्हारे साथ आ जाता।
            🎓|If they had studied harder, they would be at university now.| | |अगर उन्होंने कड़ी मेहनत की होती, तो अब वे विश्वविद्यालय में होते।
        """,

        "epB2-f" to """
            📄|The form must be signed by the applicant.| | |फ़ॉर्म आवेदक द्वारा हस्ताक्षरित होना चाहिए।
            🍽️|Dinner can be served at eight.| | |रात का खाना आठ बजे परोसा जा सकता है।
            📦|The parcel should be delivered tomorrow.| | |पार्सल कल पहुँचाया जाना चाहिए।
            🔧|The car has to be repaired.| | |कार की मरम्मत करनी होगी।
            🏠|The house might be sold soon.| | |घर जल्द ही बिक सकता है।
            📱|This app can be downloaded for free.| | |यह ऐप मुफ़्त डाउनलोड किया जा सकता है।
            ✉️|The letter ought to be sent today.| | |पत्र आज भेजा जाना चाहिए।
        """,

        "epB2-g" to """
            💇|I had my hair cut yesterday.| | |मैंने कल बाल कटवाए।
            🚗|She got her car repaired.| | |उसने अपनी कार ठीक करवाई।
            🏠|We had our house painted last month.| | |हमने पिछले महीने घर रंगवाया।
            📱|He got his phone fixed.| | |उसने अपना फ़ोन ठीक करवाया।
            🦷|I need to have my teeth checked.| | |मुझे अपने दाँत जाँच करवाने हैं।
            👓|She got new glasses made.| | |उसने नए चश्मे बनवाए।
            🖥️|They had the computer repaired.| | |उन्होंने कंप्यूटर ठीक करवाया।
        """,

        "epB2-h" to """
            🌧️|I wish it would stop raining.| | |काश बारिश रुक जाए।
            💰|I wish I had more money.| | |काश मेरे पास ज़्यादा पैसे होते।
            🗣️|If only I spoke French fluently.| | |काश मैं धाराप्रवाह फ़्रेंच बोलता।
            ⏰|I wish I had woken up earlier.| | |काश मैं जल्दी उठा होता।
            🏖️|If only we could go on holiday.| | |काश हम छुट्टी पर जा सकते।
            😔|She wishes she hadn't said that.| | |उसे अफ़सोस है कि उसने ऐसा कहा।
            🎓|I wish I were younger.| | |काश मैं छोटा होता।
        """,

        "epB2-i" to """
            🌅|Never have I seen such a beautiful sunset.| | |मैंने कभी ऐसा सुंदर सूर्यास्त नहीं देखा।
            🔇|Rarely does he speak in public.| | |वह शायद ही सार्वजनिक रूप से बोलता है।
            🚪|No sooner had I arrived than she left.| | |मैं पहुँचा ही था कि वह चली गई।
            🏃|Not only did he win, but he also broke the record.| | |उसने न केवल जीता, बल्कि रिकॉर्ड भी तोड़ा।
            📚|Little did I know what would happen.| | |मुझे क्या पता था कि क्या होगा।
            🌧️|Seldom does it rain here in summer.| | |यहाँ गर्मियों में शायद ही बारिश होती है।
            🎤|Only then did I understand the problem.| | |तभी मुझे समस्या समझ आई।
        """,

        "epB2-j" to """
            🚶|Walking down the street, I met an old friend.| | |सड़क पर चलते हुए मैं एक पुराने दोस्त से मिला।
            😴|Tired after work, she went straight to bed.| | |काम के बाद थकी हुई, वह सीधे बिस्तर पर चली गई।
            ✍️|Written in 1920, the book is still popular.| | |1920 में लिखी गई, यह किताब आज भी लोकप्रिय है।
            🍳|Having finished dinner, we watched a film.| | |रात का खाना खत्म करके हमने फ़िल्म देखी।
            🎓|Excited about the trip, the children couldn't sleep.| | |यात्रा से उत्साहित बच्चे सो नहीं पाए।
            🏃|Running to catch the train, he dropped his bag.| | |ट्रेन पकड़ने के लिए दौड़ते हुए उसका बैग गिर गया।
            💡|Surprised by the news, she called her mother.| | |ख़बर से हैरान होकर उसने अपनी माँ को फ़ोन किया।
        """,

        "epC1-a" to """
            🎤|It was Maria who sang at the concert.| | |कॉन्सर्ट में मारिया ने ही गाया।
            📅|It was last Monday that we met.| | |हम पिछले सोमवार ही मिले थे।
            🍰|It was the cake that everyone loved.| | |केक ही था जो सबको पसंद आया।
            🚗|What I need is a good car.| | |मुझे जो चाहिए वह एक अच्छी कार है।
            🗣️|What she said was completely true.| | |उसने जो कहा वह पूरी तरह सच था।
            🧑|It is John who runs the shop.| | |दुकान जॉन ही चलाता है।
            🎯|The reason I left was the noise.| | |मेरे जाने की वजह शोर थी।
        """,

        "epC1-b" to """
            📊|It could be argued that the plan is too costly.| | |यह तर्क दिया जा सकता है कि योजना बहुत महँगी है।
            🌍|It seems that the climate is changing rapidly.| | |ऐसा लगता है कि जलवायु तेज़ी से बदल रही है।
            🧪|There is some evidence to suggest that this works.| | |कुछ प्रमाण यह सुझाते हैं कि यह काम करता है।
            🗳️|One might argue that the policy is unfair.| | |कोई तर्क दे सकता है कि नीति अनुचित है।
            📉|It appears that sales have fallen slightly.| | |ऐसा प्रतीत होता है कि बिक्री थोड़ी घटी है।
            🩺|This may possibly be the best treatment.| | |यह संभवतः सबसे अच्छा इलाज हो सकता है।
            📚|It is generally believed that reading helps.| | |सामान्यतः माना जाता है कि पढ़ना मदद करता है।
        """,

        "epC1-c" to """
            🎲|Were I to win the lottery, I would travel the world.| | |अगर मैं लॉटरी जीतता, तो दुनिया घूमता।
            ⚠️|Had I known, I would have warned you.| | |अगर मुझे पता होता, तो मैं तुम्हें चेतावनी देता।
            🌍|Should you need help, please call me.| | |अगर आपको मदद चाहिए तो मुझे फ़ोन करें।
            🏢|Were the company to fail, many would lose jobs.| | |अगर कंपनी बंद हो जाए तो बहुतों की नौकरी जाएगी।
            ☂️|Had it not rained, we would have gone out.| | |अगर बारिश न होती तो हम बाहर जाते।
            📝|Should you have any questions, ask now.| | |अगर आपके कोई प्रश्न हों तो अभी पूछें।
            🚀|Were they to invest more, the project would succeed.| | |अगर वे और निवेश करते तो परियोजना सफल होती।
        """,

        "epC1-d" to """
            📈|The growth of the economy surprised everyone.| | |अर्थव्यवस्था की वृद्धि ने सबको चौंकाया।
            🔬|Her research into climate change is famous.| | |जलवायु परिवर्तन पर उसका शोध प्रसिद्ध है।
            📋|The decision to leave was difficult.| | |जाने का निर्णय कठिन था।
            🏗️|The construction of the bridge took two years.| | |पुल के निर्माण में दो साल लगे।
            🧠|His understanding of the topic is deep.| | |विषय पर उसकी समझ गहरी है।
            🎓|The introduction of new rules caused anger.| | |नए नियमों की शुरुआत से गुस्सा हुआ।
            🗣️|Their refusal to negotiate made things worse.| | |बातचीत से इनकार ने हालात बिगाड़े।
        """,

        "epC1-e" to """
            🗳️|I suggest that he be present at the meeting.| | |मेरा सुझाव है कि वह बैठक में उपस्थित रहे।
            📌|It is essential that she arrive on time.| | |यह ज़रूरी है कि वह समय पर पहुँचे।
            🧑‍⚖️|The judge demanded that the witness be silent.| | |न्यायाधीश ने माँग की कि गवाह चुप रहे।
            🏢|They insisted that he resign immediately.| | |उन्होंने ज़ोर दिया कि वह तुरंत इस्तीफ़ा दे।
            🩺|The doctor recommended that she rest for a week.| | |डॉक्टर ने सलाह दी कि वह एक सप्ताह आराम करे।
            📚|It is important that every student be treated fairly.| | |यह महत्वपूर्ण है कि हर विद्यार्थी के साथ न्याय हो।
            🎯|I propose that we begin at once.| | |मेरा प्रस्ताव है कि हम तुरंत शुरू करें।
        """,

        "epC1-f" to """
            🤝|She is good at solving problems.| | |वह समस्याएँ हल करने में अच्छी है।
            😟|He is afraid of heights.| | |उसे ऊँचाई से डर लगता है।
            🎯|We depend on our team.| | |हम अपनी टीम पर निर्भर हैं।
            🧐|I'm interested in learning Japanese.| | |मुझे जापानी सीखने में रुचि है।
            🙏|Thank you for your help.| | |आपकी मदद के लिए धन्यवाद।
            🧑|She is married to a doctor.| | |उसकी शादी एक डॉक्टर से हुई है।
            💭|I'm thinking about changing jobs.| | |मैं नौकरी बदलने के बारे में सोच रहा हूँ।
        """,

        "epC1-g" to """
            ☕|I'd like a coffee, please — and she'd like one too.| | |मुझे एक कॉफ़ी चाहिए — और उसे भी एक।
            📱|Do you have a phone? Yes, I have one.| | |क्या तुम्हारे पास फ़ोन है? हाँ, मेरे पास है।
            🌧️|It may rain later, but I hope not.| | |बाद में बारिश हो सकती है, पर मुझे उम्मीद नहीं।
            🚗|She drives faster than I do.| | |वह मुझसे तेज़ गाड़ी चलाती है।
            📚|I finished the book; he didn't.| | |मैंने किताब पूरी कर ली; उसने नहीं।
            🎬|Neither of us enjoyed the film.| | |हम दोनों में से किसी को फ़िल्म पसंद नहीं आई।
            🍽️|We ordered pizza and they did too.| | |हमने पिज़्ज़ा ऑर्डर किया और उन्होंने भी।
        """,

        "epC1-h" to """
            🗣️|That, I simply cannot believe.| | |यह मैं मान ही नहीं सकता।
            🏔️|Beautiful, the view certainly was.| | |सुंदर, नज़ारा निश्चित रूप से था।
            💰|Money, we have none.| | |पैसे, हमारे पास कोई नहीं।
            🧘|Relaxed, she was not.| | |शांत, वह नहीं थी।
            📖|This book, I have read twice.| | |यह किताब मैंने दो बार पढ़ी है।
            😤|Angry, he certainly seemed.| | |गुस्से में, वह निश्चित रूप से लग रहा था।
            🌟|Rare, such talent is.| | |दुर्लभ, ऐसी प्रतिभा होती है।
        """,

        "epC2-a" to """
            📅|We met in front of the station.| | |हम स्टेशन के सामने मिले।
            📊|In spite of the rain, we went out.| | |बारिश के बावजूद हम बाहर गए।
            🎯|They arrived on time, contrary to expectations.| | |उम्मीद के विपरीत वे समय पर पहुँचे।
            📚|According to the report, prices are rising.| | |रिपोर्ट के अनुसार कीमतें बढ़ रही हैं।
            🤝|She acted on behalf of the company.| | |उसने कंपनी की ओर से काम किया।
            🏫|In addition to English, he speaks French.| | |अंग्रेज़ी के अलावा वह फ़्रेंच बोलता है।
            🌧️|Due to heavy rain, the match was cancelled.| | |भारी बारिश के कारण मैच रद्द हो गया।
        """,

        "epC2-b" to """
            ⏳|Not until midnight did he finish work.| | |आधी रात तक ही उसने काम पूरा किया।
            🌅|Never before had I seen such a crowd.| | |पहले कभी मैंने ऐसी भीड़ नहीं देखी।
            🚪|Hardly had I sat down when the phone rang.| | |मैं बैठा ही था कि फ़ोन बजा।
            🚫|Under no circumstances should you open it.| | |किसी भी हालत में इसे न खोलें।
            🏆|Not only did she pass, she topped the class.| | |उसने न केवल पास किया, कक्षा में अव्वल रही।
            🌧️|At no time did they complain.| | |उन्होंने कभी शिकायत नहीं की।
            🗣️|Only later did we realise the truth.| | |बाद में ही हमें सच पता चला।
        """,

        "epC2-c" to """
            📄|The documents kept in this drawer are old.| | |इस दराज़ में रखे दस्तावेज़ पुराने हैं।
            👥|The people waiting outside are students.| | |बाहर इंतज़ार कर रहे लोग विद्यार्थी हैं।
            🏠|The house built last year is beautiful.| | |पिछले साल बना घर सुंदर है।
            🎬|The film shown yesterday was boring.| | |कल दिखाई गई फ़िल्म उबाऊ थी।
            🧑|Anyone wishing to join should sign here.| | |जो भी शामिल होना चाहे वह यहाँ हस्ताक्षर करे।
            📚|The books written by him are popular.| | |उनकी लिखी किताबें लोकप्रिय हैं।
            🚗|The car parked outside is mine.| | |बाहर खड़ी कार मेरी है।
        """,

        "epC2-d" to """
            📝|The results were surprising, and the conclusions clear.| | |नतीजे चौंकाने वाले थे, और निष्कर्ष स्पष्ट।
            📊|Sales rose in June and again in July.| | |जून में बिक्री बढ़ी और जुलाई में फिर।
            🏢|The company must act, and quickly.| | |कंपनी को कार्रवाई करनी चाहिए, और जल्दी।
            📄|As expected, the plan was approved.| | |जैसा अपेक्षित था, योजना मंज़ूर हो गई।
            🗳️|The proposal, if accepted, will help many.| | |प्रस्ताव, यदि स्वीकृत हो, बहुतों की मदद करेगा।
            📚|She reads more novels than I do.| | |वह मुझसे ज़्यादा उपन्यास पढ़ती है।
            🧪|The experiment failed, and badly.| | |प्रयोग विफल रहा, और बुरी तरह।
            🎯|When finished, submit the form.| | |पूरा होने पर फ़ॉर्म जमा करें।
        """,

        "epC2-e" to """
            🏛️|The committee recommends that the policy be revised.| | |समिति की सिफ़ारिश है कि नीति संशोधित की जाए।
            📋|It is imperative that all staff attend.| | |यह अत्यावश्यक है कि सभी कर्मचारी उपस्थित हों।
            🩺|The board proposed that Dr. Rao be appointed.| | |बोर्ड ने प्रस्ताव दिया कि डॉ. राव को नियुक्त किया जाए।
            🗳️|We recommend that the meeting be postponed.| | |हम सिफ़ारिश करते हैं कि बैठक स्थगित की जाए।
            📌|It is vital that the report be submitted today.| | |यह आवश्यक है कि रिपोर्ट आज जमा हो।
            🏢|Management insisted that he be informed.| | |प्रबंधन ने ज़ोर दिया कि उसे सूचित किया जाए।
            🎓|The professor suggested that we write a paper.| | |प्रोफ़ेसर ने सुझाव दिया कि हम एक पेपर लिखें।
            ⚖️|It is required that every applicant be interviewed.| | |यह आवश्यक है कि हर आवेदक का साक्षात्कार हो।
        """,

        "epC2-f" to """
            📈|The project succeeded, albeit slowly.| | |परियोजना सफल रही, हालाँकि धीरे-धीरे।
            🌧️|Notwithstanding the rain, the event went ahead.| | |बारिश के बावजूद कार्यक्रम चला।
            💼|The job is interesting, albeit poorly paid.| | |नौकरी दिलचस्प है, हालाँकि कम वेतन वाली।
            🎓|Notwithstanding his age, he passed the exam.| | |उम्र के बावजूद उसने परीक्षा पास की।
            🏔️|The climb was hard, albeit rewarding.| | |चढ़ाई कठिन थी, फिर भी फलदायी।
            📉|The results, albeit disappointing, were expected.| | |नतीजे, फिर भी निराशाजनक, अपेक्षित थे।
            🤝|Whatever the cost, we must continue.| | |चाहे जो भी कीमत हो, हमें जारी रखना चाहिए।
        """,

        "epC2-g" to """
            🏙️|Firstly, cities offer more jobs; moreover, they have better schools.| | |पहला, शहरों में ज़्यादा नौकरियाँ हैं; इसके अलावा, बेहतर स्कूल हैं।
            🌍|Consequently, pollution has increased rapidly.| | |नतीजतन, प्रदूषण तेज़ी से बढ़ा है।
            📚|Furthermore, reading improves vocabulary.| | |इसके अतिरिक्त, पढ़ना शब्दावली सुधारता है।
            🚗|In contrast, rural areas face fewer problems.| | |इसके विपरीत, ग्रामीण क्षेत्रों में कम समस्याएँ हैं।
            ⚖️|Nevertheless, the benefits outweigh the risks.| | |फिर भी, लाभ जोखिमों से अधिक हैं।
            🎯|In conclusion, both views have merit.| | |निष्कर्ष में, दोनों विचारों में दम है।
            📊|For instance, many young people prefer online study.| | |उदाहरण के लिए, कई युवा ऑनलाइन पढ़ाई पसंद करते हैं।
        """
    )
}
