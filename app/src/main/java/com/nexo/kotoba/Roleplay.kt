package com.nexo.kotoba

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class RpMsg(val speaker: String, val emoji: String, val text: String, val hi: String, val isUser: Boolean)
data class RpOption(val text: String, val textHi: String, val feedback: String, val feedbackHi: String, val next: Int)
data class RpTurn(val npc: String, val npcEmoji: String, val npcHi: String, val options: List<RpOption>)
data class Roleplay(val id: String, val title: String, val emoji: String, val desc: String, val lang: String, val turns: List<RpTurn>)

private fun rp(id: String, title: String, emoji: String, desc: String, lang: String, vararg turns: RpTurn) =
    Roleplay(id, title, emoji, desc, lang, turns.toList())

private fun t(npc: String, npcEmoji: String, npcHi: String, vararg options: RpOption) =
    RpTurn(npc, npcEmoji, npcHi, options.toList())

private fun o(text: String, textHi: String, feedback: String, feedbackHi: String, next: Int) =
    RpOption(text, textHi, feedback, feedbackHi, next)

object Roleplays {
    val all: List<Roleplay> = listOf(
        // ================= JAPANESE =================
        rp("rp-ja-hotel", "Hotel Booking", "🏨", "Reserve a room, ask prices, get your key", "ja",
            t("いらっしゃいませ。何泊ですか。", "🧑‍💼", "स्वागत है। कितनी रातें?",
                o("二泊お願いします。", "दो रातें, कृपया।", "かしこまりました。シングルルームでよろしいですか。", "ठीक है। सिंगल कमरा चाहिए?", 1),
                o("一泊だけです。", "सिर्फ एक रात।", "はい、承知しました。", "हाँ, समझ गया।", 1)),
            t("シングルで一泊五千円です。", "🧑‍💼", "सिंगल एक रात 5000 येन है।",
                o("いいですね。お願いします。", "ठीक है, चलो।", "ありがとうございます。こちらが鍵です。", "धन्यवाद। ये रही आपकी चाबी।", 2),
                o("ちょっと高いですね。安い部屋はありますか。", "थोड़ा महँगा है। सस्ता कमरा है?", "四千円の部屋もありますよ。", "4000 येन का कमरा भी है।", 2)),
            t("朝食は七時から九時までです。", "🧑‍💼", "नाश्ता सुबह 7 से 9 बजे तक है।",
                o("ありがとうございます。", "धन्यवाद।", "どうぞごゆっくり。", "आनंद लीजिए।", -1),
                o("チェックアウトは何時ですか。", "चेकआउट कितने बजे है?", "十時です。", "10 बजे।", -1))),
        rp("rp-ja-restaurant", "Restaurant", "🍜", "Order food, ask for recommendations, pay the bill", "ja",
            t("ご注文はお決まりですか。", "👩‍🍳", "क्या आप ऑर्डर करने के लिए तैयार हैं?",
                o("おすすめは何ですか。", "आपकी सिफारिश क्या है?", "ラーメンが一番人気です。", "रामेन सबसे लोकप्रिय है।", 1),
                o("ラーメンを一つください。", "एक रामेन, कृपया।", "はい、ラーメンですね。", "हाँ, रामेन।", 1)),
            t("お飲み物は何にしますか。", "👩‍🍳", "पीने के लिए क्या लेंगे?",
                o("水をください。", "पानी, कृपया।", "かしこまりました。", "बिल्कुल।", 2),
                o("ビールを一つください。", "एक बीयर, कृपया।", "はい、少々お待ちください。", "हाँ, एक क्षण।", 2)),
            t("お会計は二千円です。", "👩‍🍳", "बिल 2000 येन है।",
                o("ごちそうさまでした。", "भोजन के लिए धन्यवाद।", "ありがとうございました。またお越しください。", "धन्यवाद। फिर आइए।", -1),
                o("カードで払えますか。", "क्या मैं कार्ड से भुगतान कर सकता हूँ?", "もちろんです。どうぞ。", "बिल्कुल, यहाँ।", -1))),
        rp("rp-ja-directions", "Asking Directions", "🗺️", "Find the station and navigate the streets", "ja",
            t("ああ、駅ですか。まっすぐ行ってください。", "🧑", "आह, स्टेशन? सीधे जाइए।",
                o("遠いですか。", "क्या दूर है?", "十分ぐらい歩きますよ。", "लगभग 10 मिनट पैदल।", 1),
                o("ありがとうございます。", "धन्यवाद।", "どういたしまして。", "कोई बात नहीं।", 1)),
            t("信号を右に曲がってください。", "🧑", "ट्रैफिक लाइट पर दाएँ मुड़िए।",
                o("右ですね。ありがとう。", "दाएँ, समझ गया। धन्यवाद।", "はい、右です。駅はすぐです。", "हाँ, दाएँ। स्टेशन पास है।", 2),
                o("バスでも行けますか。", "क्या बस से भी जा सकता हूँ?", "バスの方が楽ですよ。", "बस अधिक आसान है।", 2)),
            t("駅はすぐそこです。", "🧑", "स्टेशन वहीं पास में है।",
                o("助かりました！", "बहुत मदद मिली!", "いいえ。気をつけて。", "कुछ नहीं। ध्यान रखना।", -1))),
        rp("rp-ja-taxi", "Taxi Ride", "🚕", "Tell the driver where to go and pay the fare", "ja",
            t("どちらまで行かれますか。", "👨‍✈️", "कहाँ चलना है?",
                o("駅までお願いします。", "स्टेशन तक, कृपया।", "はい。十分ぐらいかかります。", "हाँ, लगभग 10 मिनट लगेंगे।", 1),
                o("このホテルまでお願いします。", "इस होटल तक, कृपया।", "かしこまりました。", "बिल्कुल।", 1)),
            t("ここでよろしいですか。", "👨‍✈️", "क्या यहाँ ठीक है?",
                o("はい。いくらですか。", "हाँ। कितना हुआ?", "二千円です。", "2000 येन।", 2),
                o("もう少し先でお願いします。", "थोड़ा आगे, कृपया।", "ここですか。", "यहाँ?", 2)),
            t("お会計は二千円です。", "👨‍✈️", "किराया 2000 येन है।",
                o("どうぞ。ありがとう。", "लो। धन्यवाद।", "ありがとうございます。気をつけて。", "धन्यवाद। ध्यान रखना।", -1),
                o("お釣りをください。", "बदला चाहिए, कृपया।", "はい、どうぞ。", "हाँ, यह लीजिए।", -1))),
        rp("rp-ja-shopping", "Shopping", "🛍️", "Find a souvenir, ask the price and pay", "ja",
            t("いらっしゃいませ。何かお探しですか。", "🧑‍💼", "स्वागत है। कुछ ढूँढ रहे हैं?",
                o("お土産を探しています。", "मैं स्मृति-चिह्न देख रहा हूँ।", "こちらにありますよ。", "यहाँ हैं।", 1),
                o("大きいサイズはありますか。", "बड़ा साइज़ है?", "はい、ございます。", "हाँ, है।", 1)),
            t("このTシャツはいかがですか。", "🧑‍💼", "यह टी-शर्ट कैसी है?",
                o("いくらですか。", "कितने का है?", "千五百円です。", "1500 येन।", 2),
                o("もっと安いのはありますか。", "सस्ता वाला है?", "こちらは千円です。", "यह 1000 येन का है।", 2)),
            t("袋に入れますか。", "🧑‍💼", "बैग में रखूँ?",
                o("お願いします。カードで払えますか。", "हाँ, कृपया। कार्ड से दे सकता हूँ?", "もちろんです。", "बिल्कुल।", -1),
                o("現金で払います。", "मैं नकद दूँगा।", "ありがとうございます。", "धन्यवाद।", -1))),
        rp("rp-ja-doctor", "At the Doctor", "🩺", "Describe symptoms and get medicine", "ja",
            t("どうしましたか。", "👨‍⚕️", "क्या हुआ है?",
                o("頭が痛いです。", "मेरे सिर में दर्द है।", "いつからですか。", "कब से?", 1),
                o("熱があります。", "मुझे बुखार है।", "そうですか。体を休めてください。", "ठीक है। आराम कीजिए।", 1)),
            t("お薬を出しますね。", "👨‍⚕️", "मैं दवा लिख देता हूँ।",
                o("一日何回飲みますか。", "दिन में कितनी बार लूँ?", "一日三回です。", "दिन में तीन बार।", 2),
                o("ひどいですか。", "क्या गंभीर है?", "心配いりませんよ。", "चिंता मत कीजिए।", 2)),
            t("ゆっくり休んでください。", "👨‍⚕️", "आराम से रहिए।",
                o("分かりました。ありがとうございました。", "समझ गया। धन्यवाद।", "お大事に。", "जल्दी ठीक हों।", -1),
                o("いつ治りますか。", "कब ठीक होगा?", "二、三日でよくなりますよ。", "दो-तीन दिन में ठीक हो जाएगा।", -1))),
        rp("rp-ja-cafe", "At the Cafe", "☕", "Order a drink and choose to stay or take out", "ja",
            t("ご注文はどうされますか。", "👩‍💼", "आप क्या लेंगे?",
                o("コーヒーを一つください。", "एक कॉफ़ी, कृपया।", "ホットですか、アイスですか。", "गरम या ठंडी?", 1),
                o("抹茶ラテをお願いします。", "माचा लट्टे, कृपया।", "かしこまりました。", "बिल्कुल।", 1)),
            t("お席でお召し上がりですか。", "👩‍💼", "यहीं खाएँगे?",
                o("ここで飲みます。", "यहीं पीऊँगा।", "はい、どうぞ。", "हाँ, लीजिए।", 2),
                o("テイクアウトです。", "टेकअवे है।", "少々お待ちください。", "थोड़ा रुकिए।", 2)),
            t("お待たせしました。どうぞ。", "👩‍💼", "आपका इंतज़ार हुआ। लीजिए।",
                o("ありがとうございます。", "धन्यवाद।", "ごゆっくりどうぞ。", "आराम से लीजिए।", -1))),
        rp("rp-ja-airport", "At the Airport", "✈️", "Check in, hand over baggage and find the gate", "ja",
            t("パスポートと搭乗券を見せてください。", "🧑‍✈️", "पासपोर्ट और बोर्डिंग पास दिखाइए।",
                o("はい、どうぞ。", "हाँ, लीजिए।", "ありがとうございます。ゲートは十二番です。", "धन्यवाद। गेट 12 है।", 1),
                o("搭乗券をなくしました。", "मैंने बोर्डिंग पास खो दिया।", "こちらで再発行できますよ。", "यहाँ दोबारा जारी हो सकता है।", 1)),
            t("お荷物はお預けになりますか。", "🧑‍✈️", "सामान चेक करवाएँगे?",
                o("はい、お願いします。", "हाँ, कृपया।", "何個ですか。", "कितने हैं?", 2),
                o("機内に持ち込みます。", "मैं साथ ले जाऊँगा।", "かしこまりました。", "बिल्कुल।", 2)),
            t("搭乗は三十分前からです。", "🧑‍✈️", "बोर्डिंग 30 मिनट पहले शुरू होगी।",
                o("ありがとうございます。", "धन्यवाद।", "よい旅を！", "शुभ यात्रा!", -1),
                o("どのゲートですか。", "कौन सा गेट है?", "十二番ゲートです。", "गेट 12।", -1))),

        // ================= ENGLISH =================
        rp("rp-en-hotel", "Hotel Check-In", "🏨", "Check in, ask about breakfast and checkout time", "en",
            t("Welcome! How can I help you?", "🧑‍💼", "स्वागत है! मैं आपकी कैसे मदद करूँ?",
                o("I have a reservation under the name Smith.", "मेरा आरक्षण स्मिथ नाम से है।", "Let me check... Yes, here it is. Two nights.", "ज़रा देखूँ... हाँ, यह रहा। दो रातें।", 1),
                o("I'd like a room for two nights, please.", "मुझे दो रात के लिए कमरा चाहिए, कृपया।", "Certainly. A single room is 5000 yen per night.", "बिल्कुल। सिंगल कमरा 5000 येन प्रति रात है।", 1)),
            t("Here is your key. Room 301 on the third floor.", "🧑‍💼", "यह रही आपकी चाबी। कमरा 301, तीसरी मंज़िल पर।",
                o("What time is breakfast?", "नाश्ता किस समय है?", "From 7 to 9 in the morning.", "सुबह 7 से 9 बजे तक।", 2),
                o("What time is checkout?", "चेकआउट किस समय है?", "Checkout is at 10 am.", "चेकआउट सुबह 10 बजे है।", 2)),
            t("Enjoy your stay!", "🧑‍💼", "आपका प्रवास शुभ हो!",
                o("Thank you very much.", "बहुत धन्यवाद।", "You're welcome. Have a nice day.", "आपका स्वागत है। आपका दिन शुभ हो।", -1))),
        rp("rp-en-restaurant", "At the Restaurant", "🍽️", "Order a meal, get recommendations, pay the bill", "en",
            t("Good evening! Are you ready to order?", "👩‍🍳", "शुभ संध्या! क्या आप ऑर्डर करने के लिए तैयार हैं?",
                o("What do you recommend?", "आप क्या सुझाती हैं?", "Our fried rice is very popular.", "हमारा फ्राइड राइस बहुत लोकप्रिय है।", 1),
                o("I'll have the fried rice, please.", "मुझे फ्राइड राइस दीजिए, कृपया।", "Great choice! Anything to drink?", "बढ़िया चुनाव! पीने के लिए कुछ?", 1)),
            t("Would you like anything to drink?", "👩‍🍳", "क्या आप कुछ पीना चाहेंगे?",
                o("Just water, please.", "सिर्फ पानी, कृपया।", "Sure. Coming right up.", "जी, अभी आया।", 2),
                o("A lemonade, please.", "एक नींबू पानी, कृपया।", "Of course.", "बिल्कुल।", 2)),
            t("Here's your bill. That'll be 12 dollars.", "👩‍🍳", "यह रहा आपका बिल। 12 डॉलर हुए।",
                o("Can I pay by card?", "क्या मैं कार्ड से भुगतान कर सकता हूँ?", "Yes, of course.", "हाँ, बिल्कुल।", -1),
                o("Thank you, that was delicious.", "धन्यवाद, बहुत स्वादिष्ट था।", "Thank you! Come again soon.", "धन्यवाद! फिर आइए।", -1))),
        rp("rp-en-directions", "Asking for Directions", "🗺️", "Find the museum and navigate the streets", "en",
            t("The museum? Just go straight and turn left at the bank.", "🧑", "म्यूज़ियम? सीधे जाइए और बैंक पर बाएँ मुड़िए।",
                o("Is it far from here?", "क्या यह यहाँ से दूर है?", "No, about ten minutes on foot.", "नहीं, लगभग दस मिनट पैदल।", 1),
                o("Thank you so much!", "बहुत धन्यवाद!", "No problem at all.", "कोई बात नहीं।", 1)),
            t("After the bank, go past the park. The museum is on your right.", "🧑", "बैंक के बाद पार्क पार करें। म्यूज़ियम आपके दाएँ है।",
                o("Could I go by bus instead?", "क्या मैं इसके बजाय बस से जा सकता हूँ?", "Sure, bus 21 stops right outside.", "ज़रूर, बस 21 ठीक बाहर रुकती है।", 2),
                o("Turn left at the bank. Got it, thanks!", "बैंक पर बाएँ। समझ गया, धन्यवाद!", "Exactly. Have a nice day!", "बिल्कुल। आपका दिन शुभ हो!", 2)),
            t("You can see it from here — the big white building.", "🧑", "आप इसे यहाँ से देख सकते हैं — बड़ी सफ़ेद इमारत।",
                o("I see it. Thanks for your help!", "दिख गया। मदद के लिए धन्यवाद!", "Anytime! Enjoy the museum.", "कभी भी! म्यूज़ियम का आनंद लें।", -1))),
        rp("rp-en-taxi", "Taking a Taxi", "🚕", "Tell the driver the destination and pay the fare", "en",
            t("Where to, sir?", "👨‍✈️", "कहाँ चलना है, महोदय?",
                o("The airport, please.", "हवाई अड्डे, कृपया।", "Sure. That'll take about 30 minutes.", "ठीक है। इसमें लगभग 30 मिनट लगेंगे।", 1),
                o("This hotel, please.", "इस होटल, कृपया।", "Got it.", "समझ गया।", 1)),
            t("Here we are. That's 25 dollars.", "👨‍✈️", "हम पहुँच गए। 25 डॉलर हुए।",
                o("Can I pay by card?", "क्या मैं कार्ड से भुगतान कर सकता हूँ?", "Yes, the machine is right there.", "हाँ, मशीन वहीं है।", 2),
                o("Keep the change.", "बदला रख लीजिए।", "Thank you very much!", "बहुत धन्यवाद!", 2)),
            t("Have a great trip!", "👨‍✈️", "आपकी यात्रा शुभ हो!",
                o("Thanks, you too!", "धन्यवाद, आपका भी!", "Thanks!", "धन्यवाद!", -1))),
        rp("rp-en-shopping", "Shopping for a Gift", "🛍️", "Find a gift, ask the price, pay at the counter", "en",
            t("Hi there! Can I help you find something?", "🧑‍💼", "नमस्ते! क्या मैं आपको कुछ ढूँढने में मदद करूँ?",
                o("I'm looking for a gift for my sister.", "मैं अपनी बहन के लिए तोहफ़ा ढूँढ रहा हूँ।", "These scarves are lovely and popular.", "ये स्कार्फ़ बहुत अच्छे और लोकप्रिय हैं।", 1),
                o("How much is this scarf?", "यह स्कार्फ़ कितने का है?", "This one is 15 dollars.", "यह 15 डॉलर का है।", 1)),
            t("Would you like it wrapped as a gift?", "🧑‍💼", "क्या आप इसे उपहार के रूप में लपेटवाना चाहेंगे?",
                o("Yes, please. That would be great.", "हाँ, कृपया। बहुत अच्छा रहेगा।", "Of course. Anything else?", "बिल्कुल। और कुछ?", 2),
                o("No thanks, that's all.", "नहीं धन्यवाद, बस इतना ही।", "Alright. The counter is over there.", "ठीक है। काउंटर वहाँ है।", 2)),
            t("That's 15 dollars, please. Cash or card?", "🧑‍💼", "15 डॉलर हुए, कृपया। नकद या कार्ड?",
                o("Card, please.", "कार्ड, कृपया।", "Done! Here's your receipt.", "हो गया! यह रही आपकी रसीद।", -1),
                o("Cash.", "नकद।", "Perfect. Here's your change.", "बढ़िया। यह रहा आपका बदला।", -1))),
        rp("rp-en-doctor", "At the Doctor's Office", "🩺", "Explain your symptoms and get a prescription", "en",
            t("Hello, what seems to be the problem?", "👨‍⚕️", "नमस्ते, क्या समस्या है?",
                o("I have a headache and a fever.", "मेरे सिर में दर्द है और बुखार है।", "I see. How long have you felt this way?", "समझा। ऐसा कब से महसूस कर रहे हैं?", 1),
                o("My throat hurts when I swallow.", "निगलते समय मेरे गले में दर्द होता है।", "Let me take a look. Open wide.", "मुझे देखने दीजिए। मुँह खोलिए।", 1)),
            t("It looks like a mild infection. I'll prescribe some medicine.", "👨‍⚕️", "हल्का संक्रमण लग रहा है। मैं कुछ दवा लिख देता हूँ।",
                o("How many times a day should I take it?", "दिन में कितनी बार लेनी है?", "Three times a day, after meals.", "दिन में तीन बार, खाने के बाद।", 2),
                o("Is it serious?", "क्या यह गंभीर है?", "Nothing to worry about. Rest and you'll be fine.", "चिंता की कोई बात नहीं। आराम करेंगे तो ठीक हो जाएँगे।", 2)),
            t("Drink lots of water and get some rest.", "👨‍⚕️", "खूब पानी पीजिए और आराम कीजिए।",
                o("Thank you, doctor.", "धन्यवाद, डॉक्टर।", "Get well soon!", "जल्दी ठीक हो जाइए!", -1))),
        rp("rp-en-cafe", "Ordering at a Cafe", "☕", "Order a drink and decide to stay or take away", "en",
            t("Hi! What can I get for you today?", "👩‍💼", "नमस्ते! आज आपके लिए क्या लाऊँ?",
                o("A cappuccino, please.", "एक कैपुचीनो, कृपया।", "Would you like it hot or iced?", "गरम या ठंडा?", 1),
                o("An iced latte, please.", "एक आइस्ड लट्टे, कृपया।", "Coming right up!", "अभी आया!", 1)),
            t("Anything to eat with that?", "👩‍💼", "साथ में कुछ खाने के लिए?",
                o("A blueberry muffin, please.", "एक ब्लूबेरी मफिन, कृपया।", "Great! For here or to go?", "बढ़िया! यहीं या पैक?", 2),
                o("No thanks, just the drink.", "नहीं धन्यवाद, सिर्फ़ ड्रिंक।", "No problem. For here or to go?", "कोई बात नहीं। यहीं या पैक?", 2)),
            t("That's 8 dollars. Here's your order!", "👩‍💼", "8 डॉलर हुए। यह रहा आपका ऑर्डर!",
                o("Thank you!", "धन्यवाद!", "Enjoy your coffee!", "कॉफ़ी का आनंद लीजिए!", -1))),
        rp("rp-en-airport", "Airport Check-In", "✈️", "Show your documents, check your baggage, find your gate", "en",
            t("Good morning! May I see your passport and boarding pass?", "🧑‍✈️", "सुप्रभात! क्या मैं आपका पासपोर्ट और बोर्डिंग पास देख सकता हूँ?",
                o("Here you go.", "यह लीजिए।", "Thank you. Your gate is 12.", "धन्यवाद। आपका गेट 12 है।", 1),
                o("I lost my boarding pass.", "मैंने अपना बोर्डिंग पास खो दिया।", "No worries, I can reprint it for you.", "चिंता न करें, मैं इसे फिर से छाप सकता हूँ।", 1)),
            t("Are you checking any bags today?", "🧑‍✈️", "क्या आज आप कोई सामान चेक करवा रहे हैं?",
                o("Yes, this one bag, please.", "हाँ, यह एक बैग, कृपया।", "Sure, just put it on the scale.", "ज़रूर, इसे तराज़ू पर रखिए।", 2),
                o("I'll carry it on board.", "मैं इसे साथ ले जाऊँगा।", "That's fine. Remember, liquids must be under 100ml.", "ठीक है। याद रखें, तरल 100 मिली से कम हो।", 2)),
            t("Boarding starts 30 minutes before departure.", "🧑‍✈️", "बोर्डिंग प्रस्थान से 30 मिनट पहले शुरू होगी।",
                o("Which gate do I need?", "मुझे किस गेट पर जाना है?", "Gate 12, to your left.", "गेट 12, आपके बाएँ।", -1),
                o("Thank you very much!", "बहुत धन्यवाद!", "Have a great flight!", "आपकी उड़ान शुभ हो!", -1))))
}

@Composable
fun RoleplayScreen(rp: Roleplay, store: Store, speaker: Speaker, onClose: () -> Unit) {
    BackHandler(onBack = onClose)
    val isJa = rp.lang != "en"
    val listState = rememberLazyListState()
    var turn by remember { mutableStateOf(0) }
    var msgs by remember { mutableStateOf(listOf<RpMsg>()) }
    var finished by remember { mutableStateOf(false) }
    var revealed by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(rp.id) {
        turn = 0
        finished = false
        msgs = listOf(RpMsg(rp.title, rp.turns[0].npcEmoji, rp.turns[0].npc, rp.turns[0].npcHi, false))
    }
    LaunchedEffect(msgs.size) {
        if (msgs.isNotEmpty()) listState.animateScrollToItem(msgs.size - 1)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column(Modifier.weight(1f)) {
                Text(rp.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.ExtraBold)
                Text(
                    "Roleplay · " + rp.turns.size + " stages · tap bubbles for translations",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }
            Text(rp.emoji, fontSize = 26.sp)
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(msgs.size) { i ->
                val m = msgs[i]
                MessageBubble(
                    m = m,
                    isJa = isJa,
                    store = store,
                    speaker = speaker,
                    revealed = revealed == i,
                    onClick = { revealed = if (revealed == i) null else i }
                )
                Spacer(Modifier.height(8.dp))
            }
        }

        if (finished) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("🎉 Conversation complete!", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Button(
                    onClick = {
                        turn = 0
                        finished = false
                        msgs = listOf(RpMsg(rp.title, rp.turns[0].npcEmoji, rp.turns[0].npc, rp.turns[0].npcHi, false))
                        revealed = null
                    },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Start over") }
            }
        } else {
            val cur = rp.turns[turn]
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("💬 ", fontSize = 16.sp)
                    Text("Your turn — choose a reply", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(6.dp))
                cur.options.forEach { opt ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                msgs = msgs + RpMsg("You", "🙂", opt.text, opt.textHi, true)
                                msgs = msgs + RpMsg(rp.title, if (opt.next < 0) "🧑‍💼" else rp.turns[opt.next].npcEmoji, opt.feedback, opt.feedbackHi, false)
                                if (opt.next < 0) {
                                    finished = true
                                } else {
                                    turn = opt.next
                                }
                                revealed = null
                            },
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text(opt.text, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Text(
                                opt.textHi,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MessageBubble(
    m: RpMsg,
    isJa: Boolean,
    store: Store,
    speaker: Speaker,
    revealed: Boolean,
    onClick: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = if (m.isUser) Arrangement.End else Arrangement.Start
    ) {
        Column(
            horizontalAlignment = if (m.isUser) Alignment.End else Alignment.Start,
            modifier = Modifier.widthIn(max = 300.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(m.emoji, fontSize = 18.sp)
                Spacer(Modifier.width(6.dp))
                Text(
                    if (m.isUser) "You" else m.speaker,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (!m.isUser) {
                    Spacer(Modifier.width(4.dp))
                    FilledIconButton(
                        onClick = { speak(store, speaker, m.text, isJa) },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(Icons.Filled.VolumeUp, contentDescription = "Hear", modifier = Modifier.size(16.dp))
                    }
                }
            }
            Card(
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .padding(top = 3.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (m.isUser) MaterialTheme.colorScheme.primaryContainer
                    else MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
                    Text(m.text, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    if (revealed) {
                        Spacer(Modifier.height(4.dp))
                        Text(
                            m.hi,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

