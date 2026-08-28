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
import androidx.compose.ui.text.font.FontWeight
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
            t("いらっしゃいませ。ご予約はお持ちですか。", "🧑‍💼", "स्वागत है। क्या आपके पास आरक्षण है?",
                o("いいえ、予約していません。今日、部屋はありますか。", "नहीं, मैंने आरक्षण नहीं किया। आज कमरा है?", "はい、空きがございます。", "हाँ, कमरा उपलब्ध है।", 1),
                o("はい、スミスという名前で予約しています。", "हाँ, मैंने स्मिथ नाम से आरक्षण किया है।", "少々お待ちください。…はい、二泊でご予約されています。", "एक क्षण रुकिए… हाँ, दो रातों का आरक्षण है।", 1)),
            t("何泊されますか。", "🧑‍💼", "कितनी रातें रुकेंगे?",
                o("二泊お願いします。", "दो रातें, कृपया।", "かしこまりました。シングルのお部屋でよろしいですか。", "ठीक है। सिंगल कमरा चलेगा?", 2),
                o("一泊だけです。", "सिर्फ एक रात।", "承知しました。シングルでご用意します。", "समझ गया। सिंगल तैयार करता हूँ।", 2)),
            t("シングルで一泊五千円です。", "🧑‍💼", "सिंगल एक रात 5000 येन है।",
                o("いいですね。お願いします。", "ठीक है, ले लूँगा।", "ありがとうございます。こちらが鍵です。お部屋は三階の三〇一です。", "धन्यवाद। यह रही चाबी। कमरा 301, तीसरी मंज़िल।", 3),
                o("ちょっと高いですね。安い部屋はありますか。", "थोड़ा महँगा है। सस्ता कमरा है?", "四千円のお部屋もありますよ。ご覧になりますか。", "4000 येन का भी है। देखना चाहेंगे?", 3)),
            t("朝食は七時から九時までです。", "🧑‍💼", "नाश्ता सुबह 7 से 9 बजे तक है।",
                o("朝食はどこで食べられますか。", "नाश्ता कहाँ मिलेगा?", "一階のレストランでどうぞ。バイキングです。", "पहली मंज़िल के रेस्तराँ में। बुफे है।", 4),
                o("チェックアウトは何時ですか。", "चेकआउट कितने बजे?", "十時までにお願いします。", "10 बजे तक, कृपया।", 4)),
            t("Wi-Fiのパスワードはこちらです。", "🧑‍💼", "Wi-Fi का पासवर्ड यह रहा।",
                o("Wi-Fiは無料ですか。", "क्या Wi-Fi मुफ्त है?", "はい、無料です。客室で使えます。", "हाँ, मुफ्त है। कमरे में चलेगा।", 5),
                o("近くにレストランはありますか。", "पास में रेस्तराँ है?", "すぐ隣にいいお店がありますよ。", "बगल में ही अच्छी दुकान है।", 5)),
            t("ありがとうございました。良いご滞在を。", "🧑‍💼", "धन्यवाद। आपका प्रवास शुभ हो।",
                o("ありがとうございます。", "धन्यवाद।", "どうぞごゆっくり。", "आराम से रहिए।", -1),
                o("どうもありがとうございました。", "बहुत धन्यवाद।", "またのお越しをお待ちしております。", "फिर आने के लिए स्वागत है।", -1))),
        rp("rp-ja-restaurant", "Restaurant", "🍜", "Order food, ask for recommendations, pay the bill", "ja",
            t("いらっしゃいませ。何名様ですか。", "👩‍🍳", "स्वागत है। कितने लोग?",
                o("一人です。", "अकेला हूँ।", "こちらへどうぞ。メニューです。", "इधर आइए। यह मेन्यू है।", 1),
                o("二人です。", "दो लोग।", "こちらにどうぞ。お席へご案内します。", "इधर बैठिए।", 1)),
            t("ご注文はお決まりですか。", "👩‍🍳", "क्या ऑर्डर करने के लिए तैयार हैं?",
                o("おすすめは何ですか。", "आपकी सिफारिश?", "ラーメンが一番人気です。", "रामेन सबसे लोकप्रिय है।", 2),
                o("ラーメンを一つください。", "एक रामेन, कृपया।", "はい、ラーメンですね。", "हाँ, रामेन।", 2)),
            t("お飲み物は何にしますか。", "👩‍🍳", "पीने को क्या लेंगे?",
                o("水をください。", "पानी, कृपया।", "かしこまりました。少々お待ちください。", "बिल्कुल। थोड़ा रुकिए।", 3),
                o("ビールを一つください。", "एक बीयर, कृपया।", "はい。少々お待ちください。", "हाँ, एक क्षण रुकिए।", 3)),
            t("お待たせしました。ラーメンです。", "👩‍🍳", "इंतज़ार के लिए धन्यवाद। यह रहा रामेन।",
                o("おいしそうですね。いただきます。", "अच्छा लग रहा है। मैं खाता हूँ।", "ごゆっくりどうぞ。", "आराम से खाइए।", 4),
                o("辛いのを少しください。", "थोड़ा तीखा दीजिए।", "はい、どうぞ。お気をつけて。", "हाँ, लीजिए। सावधान रहिए।", 4)),
            t("おかわりはいかがですか。", "👩‍🍳", "और लेंगे?",
                o("結構です。お会計をお願いします。", "नहीं, बस। बिल लाइए।", "はい。お会計は二千円です。", "हाँ, बिल 2000 येन।", 5),
                o("餃子を一つください。", "एक ग्योज़ा, कृपया।", "はい、少々お待ちください。", "हाँ, एक क्षण।", 5)),
            t("お会計は二千円です。", "👩‍🍳", "बिल 2000 येन है।",
                o("カードで払えますか。", "कार्ड से भुगतान होगा?", "もちろんです。カードリーダーはこちらです。", "बिल्कुल। कार्ड मशीन यहाँ है।", -1),
                o("ごちそうさまでした。", "भोजन के लिए धन्यवाद।", "ありがとうございました。またお越しください。", "धन्यवाद। फिर आइए।", -1))),
        rp("rp-ja-directions", "Asking Directions", "🗺️", "Find the station and navigate the streets", "ja",
            t("ああ、駅ですか。まっすぐ行ってください。", "🧑", "आह, स्टेशन? सीधे जाइए।",
                o("どのくらいかかりますか。", "कितना समय लगेगा?", "歩いて十分ぐらいです。", "पैदल लगभग 10 मिनट।", 1),
                o("ここで合っていますか。", "क्या यह सही रास्ता है?", "はい、この道をまっすぐです。", "हाँ, इसी रास्ते सीधे।", 1)),
            t("信号を右に曲がってください。", "🧑", "ट्रैफिक लाइट पर दाएँ मुड़िए।",
                o("右ですね。駅はすぐそこですか。", "दाएँ? स्टेशन पास है?", "はい、右に曲がるとすぐ見えます。", "हाँ, दाएँ मुड़ते ही दिख जाएगा।", 2),
                o("バスでも行けますか。", "क्या बस से भी जा सकता हूँ?", "バスの方が楽ですよ。駅前のバス停から二番のバスです。", "बस आसान है। स्टेशन के पास बस स्टॉप से बस नंबर 2।", 2)),
            t("あの高いビルが見えますか。", "🧑", "वह ऊँची इमारत दिख रही है?",
                o("はい、見えます。", "हाँ, दिख रही है।", "その前に駅があります。", "उसके आगे स्टेशन है।", 3),
                o("すみません、よく見えません。", "माफ़ कीजिए, साफ़ नहीं दिख रहा।", "じゃあ、この道を五分歩いてください。", "तो इस रास्ते पाँच मिनट चलिए।", 3)),
            t("駅はあの白い建物の隣です。", "🧑", "स्टेशन उस सफ़ेद इमारत के बगल में है।",
                o("ありがとうございます。", "धन्यवाद।", "どういたしまして。気をつけて。", "कोई बात नहीं। ध्यान रखना।", 4),
                o("切符はどこで買えますか。", "टिकट कहाँ मिलेगा?", "駅の中の券売機で買えますよ。", "स्टेशन के अंदर टिकट मशीन से।", 4)),
            t("分かりましたか。もう一度案内しましょうか。", "🧑", "समझ में आया? फिर से बताऊँ?",
                o("大丈夫です。ありがとうございました。", "ठीक है। धन्यवाद।", "いいえ。良い一日を。", "कोई बात नहीं। शुभ दिन।", -1),
                o("もう一度お願いします。", "एक बार फिर, कृपया।", "駅までまっすぐ、信号を右、白い建物の隣です。", "स्टेशन तक सीधे, लाइट पर दाएँ, सफ़ेद इमारत के बगल।", -1))),
        rp("rp-ja-taxi", "Taxi Ride", "🚕", "Tell the driver where to go and pay the fare", "ja",
            t("お乗りください。どちらまでですか。", "👨‍✈️", "बैठिए। कहाँ चलना है?",
                o("駅までお願いします。", "स्टेशन, कृपया।", "はい。十分ぐらいかかります。", "हाँ। लगभग 10 मिनट।", 1),
                o("このホテルまでお願いします。", "इस होटल तक, कृपया।", "はい、承知しました。", "हाँ, समझ गया।", 1)),
            t("シートベルトをしてください。", "👨‍✈️", "सीट बेल्ट बाँधिए।",
                o("はい、わかりました。", "हाँ, ठीक है।", "ありがとうございます。", "धन्यवाद।", 2),
                o("今、右に曲がりますか。", "क्या अब दाएँ मुड़ेंगे?", "いいえ、このまままっすぐです。", "नहीं, सीधे जाएँगे।", 2)),
            t("このあたりで渋滞していますね。", "👨‍✈️", "यहाँ ट्रैफिक है।",
                o("急いでいます。別の道はありますか。", "जल्दी है। कोई और रास्ता?", "そうですね。裏道を行きましょう。", "हाँ, पीछे वाले रास्ते से चलें।", 3),
                o("大丈夫です。急ぎません。", "कोई बात नहीं, जल्दी नहीं है।", "ありがとうございます。", "धन्यवाद।", 3)),
            t("着きました。ここでよろしいですか。", "👨‍✈️", "पहुँच गए। यहाँ ठीक है?",
                o("はい。いくらですか。", "हाँ। कितना हुआ?", "二千円です。", "2000 येन।", 4),
                o("もう少し先でお願いします。", "थोड़ा आगे, कृपया।", "ここですか。", "यहाँ?", 4)),
            t("お会計は二千円です。", "👨‍✈️", "किराया 2000 येन है।",
                o("千円札でお願いします。", "1000 के नोट से चलिए।", "すみません、お釣りがありません。", "माफ़ कीजिए, छुट्टा नहीं है।", -1),
                o("どうぞ。ありがとうございます。", "लीजिए। धन्यवाद।", "ありがとうございます。気をつけて。", "धन्यवाद। ध्यान रखना।", -1))),
        rp("rp-ja-shopping", "Shopping", "🛍️", "Find a souvenir, ask the price and pay", "ja",
            t("いらっしゃいませ。何かお探しですか。", "🧑‍💼", "स्वागत है। कुछ ढूँढ रहे हैं?",
                o("お土産を探しています。", "स्मृति-चिह्न देख रहा हूँ।", "こちらにたくさんありますよ。", "यहाँ बहुत सारे हैं।", 1),
                o("大きいサイズはありますか。", "बड़ा साइज़ है?", "はい、ございます。こちらです。", "हाँ, है। यह देखिए।", 1)),
            t("このTシャツはいかがですか。", "🧑‍💼", "यह टी-शर्ट कैसी है?",
                o("いくらですか。", "कितने की?", "千五百円です。", "1500 येन।", 2),
                o("色は何色ありますか。", "कौन-कौन से रंग हैं?", "白、黒、青があります。", "सफ़ेद, काला, नीला।", 2)),
            t("こちらはどうですか。オススメですよ。", "🧑‍💼", "यह कैसा है? यह अच्छा है।",
                o("じゃあ、それをください。", "तो यही दे दीजिए।", "ありがとうございます。サイズはMでよろしいですか。", "धन्यवाद। साइज़ M ठीक है?", 3),
                o("もっと安いのはありますか。", "सस्ता वाला?", "こちらのマグカップは八百円です。", "यह मग 800 येन का है।", 3)),
            t("サイズはMでよろしいですか。", "🧑‍💼", "साइज़ M ठीक है?",
                o("はい、Mでお願いします。", "हाँ, M, कृपया।", "かしこまりました。袋に入れますか。", "ठीक है। बैग में रखूँ?", 4),
                o("Lはありますか。", "L है?", "はい、こちらになります。", "हाँ, यह लीजिए।", 4)),
            t("袋に入れますか。", "🧑‍💼", "बैग में रखूँ?",
                o("お願いします。カードで払えますか。", "हाँ। कार्ड से होगा?", "もちろんです。カードはこちらでどうぞ。", "बिल्कुल। कार्ड यहाँ।", -1),
                o("現金で払います。", "नकद दूँगा।", "ありがとうございます。お釣りはこちらです。", "धन्यवाद। आपका बदला।", -1))),
        rp("rp-ja-doctor", "At the Doctor", "🩺", "Describe symptoms and get medicine", "ja",
            t("どうしましたか。", "👨‍⚕️", "क्या हुआ?",
                o("頭が痛いです。", "सिर दर्द है।", "いつからですか。", "कब से?", 1),
                o("熱があります。", "बुखार है।", "熱は何度ですか。", "बुखार कितना है?", 1)),
            t("食欲はありますか。", "👨‍⚕️", "भूख लगती है?",
                o("あまりありません。", "ज़्यादा नहीं।", "そうですか。少し見せてください。", "ठीक है। ज़रा देखता हूँ।", 2),
                o("はい、あります。", "हाँ, लगती है।", "良かったです。", "अच्छा है।", 2)),
            t("のどを診せてください。あー。", "👨‍⚕️", "गला दिखाइए। आ…",
                o("あー。", "आ…", "はい、分かりました。風邪ですね。", "हाँ, समझ गया। ज़ुकाम है।", 3),
                o("痛いです。", "दर्द है।", "少し赤くなっていますね。", "थोड़ा लाल हुआ है।", 3)),
            t("お薬を出しますね。", "👨‍⚕️", "दवा लिख देता हूँ।",
                o("一日何回飲みますか。", "दिन में कितनी बार?", "一日三回、食後に飲んでください。", "दिन में तीन बार, खाने के बाद।", 4),
                o("ひどいですか。", "गंभीर है?", "心配いりませんよ。三日でよくなります。", "चिंता मत करो। तीन दिन में ठीक होगा।", 4)),
            t("お薬は隣の薬局でもらえます。", "👨‍⚕️", "दवा बगल की फ़ार्मेसी से मिलेगी।",
                o("分かりました。ありがとうございます。", "समझ गया। धन्यवाद।", "ゆっくり休んでください。", "आराम कीजिए।", 5),
                o("いつ治りますか。", "कब ठीक होगा?", "二、三日でよくなりますよ。", "दो-तीन दिन में।", 5)),
            t("ゆっくり休んでください。", "👨‍⚕️", "आराम से रहिए।",
                o("分かりました。ありがとうございました。", "समझ गया। धन्यवाद।", "お大事に。", "जल्दी ठीक हों।", -1),
                o("仕事は休んだほうがいいですか。", "काम से छुट्टी लूँ?", "今日は休んでください。", "आज आराम कीजिए।", -1))),
        rp("rp-ja-cafe", "At the Cafe", "☕", "Order a drink and choose to stay or take out", "ja",
            t("いらっしゃいませ。ご注文はどうされましたか。", "👩‍💼", "स्वागत है। क्या लेंगे?",
                o("コーヒーを一つください。", "एक कॉफ़ी, कृपया।", "ホットですか、アイスですか。", "गरम या ठंडी?", 1),
                o("抹茶ラテをお願いします。", "माचा लट्टे, कृपया।", "かしこまりました。", "बिल्कुल। यहीं खाएँगे?", 2)),
            t("ホットですか、アイスですか。", "👩‍💼", "गरम या ठंडी?",
                o("ホットでお願いします。", "गरम, कृपया।", "かしこまりました。", "बिल्कुल। यहीं खाएँगे?", 2),
                o("アイスでお願いします。", "ठंडी, कृपया।", "かしこまりました。", "बिल्कुल। यहीं खाएँगे?", 2)),
            t("お席でお召し上がりですか。", "👩‍💼", "यहीं खाएँगे?",
                o("ここで飲みます。", "यहीं पीऊँगा।", "はい、どうぞ。お席へお掛けください。", "हाँ, लीजिए। बैठिए।", 3),
                o("テイクアウトです。", "टेकअवे है।", "少々お待ちください。すぐお持ちします。", "थोड़ा रुकिए। अभी लाता हूँ।", 3)),
            t("お待たせしました。コーヒーです。", "👩‍💼", "इंतज़ार के लिए खेद। यह रही कॉफ़ी।",
                o("ありがとうございます。", "धन्यवाद।", "ごゆっくりどうぞ。", "आराम से लीजिए।", 4),
                o("砂糖とミルクはどこですか。", "चीनी और दूध कहाँ है?", "あちらのテーブルにあります。", "उस टेबल पर है।", 4)),
            t("お味はいかがですか。", "👩‍💼", "स्वाद कैसा है?",
                o("とてもおいしいです。", "बहुत अच्छा है।", "ありがとうございます。", "धन्यवाद।", 5),
                o("もうちょっと温かいほうが好きです。", "थोड़ा और गरम पसंद है।", "すみません。作り直します。", "माफ़ कीजिए। फिर से बनाता हूँ।", 5)),
            t("おかわりはいかがですか。", "👩‍💼", "और चाहिए?",
                o("結構です。ありがとう。", "नहीं, बस। धन्यवाद।", "どうぞまたお越しください。", "फिर आइए।", -1),
                o("おかわりください。", "एक और, कृपया।", "はい、少々お待ちください。", "हाँ, एक क्षण।", -1))),
        rp("rp-ja-airport", "At the Airport", "✈️", "Check in, hand over baggage and find the gate", "ja",
            t("おはようございます。パスポートと搭乗券を見せてください。", "🧑‍✈️", "सुप्रभात। पासपोर्ट और बोर्डिंग पास दिखाइए।",
                o("はい、どうぞ。", "हाँ, लीजिए।", "ありがとうございます。ゲートは十二番です。", "धन्यवाद। गेट 12।", 1),
                o("搭乗券をなくしました。", "बोर्डिंग पास खो दिया।", "ご心配なく。こちらで再発行できます。", "चिंता न करें। यहाँ फिर से मिलेगा।", 1)),
            t("お荷物はお預けになりますか。", "🧑‍✈️", "सामान चेक करवाएँगे?",
                o("はい、このスーツケースをお願いします。", "हाँ, यह सूटकेस, कृपया।", "こちらに置いてください。", "यहाँ रखिए।", 2),
                o("機内に持ち込みます。", "साथ ले जाऊँगा।", "かしこまりました。お荷物の重さを確認します。", "बिल्कुल। सामान का वज़न देखता हूँ।", 2)),
            t("搭乗は三十分前からです。", "🧑‍✈️", "बोर्डिंग 30 मिनट पहले शुरू।",
                o("ゲートはどこですか。", "गेट कहाँ है?", "二階へ上がって、左に曲がってください。", "दूसरी मंज़िल, बाएँ मुड़िए।", 3),
                o("搭乗までに何をすればいいですか。", "बोर्डिंग से पहले क्या करूँ?", "お土産屋やカフェがありますよ。", "स्मृति-चिह्न की दुकानें और कैफ़े हैं।", 3)),
            t("お時間になったらお呼びします。", "🧑‍✈️", "समय होने पर बुलाएँगे।",
                o("ありがとうございます。", "धन्यवाद।", "よい旅を！", "शुभ यात्रा!", 4),
                o("搭乗券をもう一度見せますか。", "बोर्डिंग पास फिर दिखाऊँ?", "いいえ、大丈夫です。", "नहीं, ज़रूरत नहीं।", 4)),
            t("ご搭乗のお時間です。", "🧑‍✈️", "बोर्डिंग का समय हो गया।",
                o("どうもありがとうございました。", "बहुत धन्यवाद।", "よいご旅行を！", "शुभ यात्रा!", -1),
                o("分かりました。行ってきます。", "समझ गया। चलता हूँ।", "お気をつけて！", "सावधान रहिए!", -1))),

        // ================= ENGLISH =================
        rp("rp-en-hotel", "Hotel Check-In", "🏨", "Check in, ask about breakfast and checkout time", "en",
            t("Good evening! Welcome to the Grand Hotel. Do you have a reservation?", "🧑‍💼", "शुभ संध्या! ग्रैंड होटल में स्वागत है। क्या आपके पास आरक्षण है?",
                o("Yes, under the name Smith.", "हाँ, स्मिथ नाम से।", "Let me check... Yes, here it is. Two nights.", "ज़रा देखूँ… हाँ, मिल गया। दो रातें।", 1),
                o("No, I'm afraid not. Do you have any rooms?", "नहीं। क्या कमरे हैं?", "Let me see... Yes, we have a single room available.", "देखता हूँ… हाँ, सिंगल कमरा उपलब्ध है।", 1)),
            t("That'll be 5000 yen per night. How many nights?", "🧑‍💼", "5000 येन प्रति रात। कितनी रातें?",
                o("Two nights, please.", "दो रातें, कृपया।", "Certainly. Here's your key. Room 301, third floor.", "बिल्कुल। यह रही चाबी। कमरा 301, तीसरी मंज़िल।", 2),
                o("Just one night.", "सिर्फ एक रात।", "Of course. Here's your key. Room 301, third floor.", "बिल्कुल। यह रही चाबी। कमरा 301।", 2)),
            t("Breakfast is served from 7 to 9 in the first-floor restaurant.", "🧑‍💼", "नाश्ता 7 से 9 बजे पहली मंज़िल के रेस्तराँ में मिलेगा।",
                o("Is breakfast included in the price?", "क्या नाश्ता कीमत में शामिल है?", "Yes, it's complimentary for all guests.", "हाँ, सभी मेहमानों के लिए मुफ्त।", 3),
                o("What time is checkout?", "चेकआउट कितने बजे?", "Checkout is at 10 am. You can leave your bags at the desk.", "चेकआउट सुबह 10 बजे। सामान डेस्क पर रख सकते हैं।", 3)),
            t("May I ask how you'll be paying?", "🧑‍💼", "भुगतान कैसे करेंगे?",
                o("By card, please.", "कार्ड से, कृपया।", "Certainly. The machine is right here.", "बिल्कुल। मशीन यहाँ है।", 4),
                o("Cash, please.", "नकद, कृपया।", "That's fine. Payment is due at checkout.", "ठीक है। भुगतान चेकआउट पर होगा।", 4)),
            t("Is there anything else I can help you with?", "🧑‍💼", "और कुछ मदद चाहिए?",
                o("Is there Wi-Fi in the room?", "कमरे में Wi-Fi है?", "Yes, it's free. The password is on your key card.", "हाँ, मुफ्त है। पासवर्ड चाबी कार्ड पर है।", 5),
                o("Can you call a taxi for me in the morning?", "सुबह टैक्सी बुला सकते हैं?", "Of course. Just ask at the front desk.", "ज़रूर, फ्रंट डेस्क पर बताइए।", 5)),
            t("Enjoy your stay!", "🧑‍💼", "आपका प्रवास शुभ हो!",
                o("Thank you very much.", "बहुत धन्यवाद।", "You're welcome. Have a great night.", "स्वागत है। शुभ रात्रि।", -1),
                o("Thanks, I will!", "धन्यवाद!", "If you need anything, call the front desk.", "कुछ चाहिए तो फ्रंट डेस्क बुलाइए।", -1))),
        rp("rp-en-restaurant", "At the Restaurant", "🍽️", "Order a meal, get recommendations, pay the bill", "en",
            t("Good evening! Table for how many?", "👩‍🍳", "शुभ संध्या! कितने लोगों के लिए?",
                o("Just one, please.", "सिर्फ एक के लिए।", "Right this way. Here's the menu.", "इधर आइए। यह मेन्यू है।", 1),
                o("Two, please.", "दो के लिए।", "Right this way. I'll bring the menus.", "इधर आइए। मेन्यू लाता हूँ।", 1)),
            t("Are you ready to order?", "👩‍🍳", "क्या आप ऑर्डर करने के लिए तैयार हैं?",
                o("What do you recommend?", "आप क्या सुझाते हैं?", "Our fried rice is very popular, and so is the noodles.", "फ्राइड राइस बहुत लोकप्रिय है, और नूडल्स भी।", 2),
                o("I'll have the fried rice, please.", "फ्राइड राइस, कृपया।", "Great choice! Anything to drink?", "बढ़िया! पीने को कुछ?", 2)),
            t("Would you like anything to drink?", "👩‍🍳", "पीने को कुछ चाहिए?",
                o("Just water, please.", "सिर्फ पानी।", "Still or sparkling?", "सादा या सोडा?", 3),
                o("A lemonade, please.", "नींबू पानी।", "Sure. I'll bring that right away.", "ज़रूर। अभी लाता हूँ।", 3)),
            t("Here's your fried rice. Enjoy!", "👩‍🍳", "यह रहा फ्राइड राइस। आनंद लीजिए!",
                o("It smells delicious. Thank you!", "खुशबू बढ़िया है। धन्यवाद!", "You're welcome! Let me know if you need anything.", "स्वागत है! कुछ चाहिए तो बताइए।", 4),
                o("Could I get some chili flakes?", "थोड़ी चिली मिलेगी?", "Of course, right away.", "बिल्कुल, अभी लाता हूँ।", 4)),
            t("Would you like anything else?", "👩‍🍳", "और कुछ चाहिए?",
                o("Just the bill, please.", "सिर्फ बिल, कृपया।", "Here you are. That's 12 dollars.", "यह लीजिए। 12 डॉलर।", 5),
                o("A dessert menu, please.", "मिठाई का मेन्यू, कृपया।", "Here you are. The cheesecake is our specialty.", "यह लीजिए। चीज़केक हमारी खासियत है।", 5)),
            t("That'll be 12 dollars. Cash or card?", "👩‍🍳", "12 डॉलर। नकद या कार्ड?",
                o("Card, please.", "कार्ड, कृपया।", "Perfect. The terminal is right here.", "बढ़िया। मशीन यहाँ है।", -1),
                o("Cash.", "नकद।", "Here's your change. Thanks for coming!", "बदला लीजिए। आने के लिए धन्यवाद!", -1))),
        rp("rp-en-directions", "Asking for Directions", "🗺️", "Find the museum and navigate the streets", "en",
            t("The museum? Sure, just go straight and turn left at the bank.", "🧑", "म्यूज़ियम? सीधे जाइए और बैंक पर बाएँ मुड़िए।",
                o("Is it far from here?", "क्या दूर है?", "No, about ten minutes on foot.", "नहीं, पैदल दस मिनट।", 1),
                o("Sorry, could you say that again?", "माफ़ कीजिए, फिर से बताएँगे?", "Go straight down this road. At the bank, turn left.", "इस रास्ते सीधे जाइए। बैंक पर बाएँ।", 1)),
            t("After the bank, go past the park. The museum is on your right.", "🧑", "बैंक के बाद पार्क पार करें। म्यूज़ियम दाएँ है।",
                o("Got it. Turn left at the bank and keep walking.", "समझ गया। बैंक पर बाएँ और चलते रहें।", "Exactly. You can't miss it — it's a big white building.", "बिल्कुल। चूकना नामुमकिन — बड़ी सफ़ेद इमारत।", 2),
                o("Could I go by bus instead?", "बस से जा सकता हूँ?", "Sure, bus 21 stops right outside the museum.", "ज़रूर, बस 21 म्यूज़ियम के बाहर रुकती है।", 2)),
            t("The museum is that big white building with the red sign.", "🧑", "म्यूज़ियम वह बड़ी सफ़ेद इमारत है, लाल साइन के साथ।",
                o("How long does the bus take?", "बस में कितना समय?", "About five minutes from here.", "यहाँ से पाँच मिनट।", 3),
                o("I think I see it. Thank you!", "दिख गई। धन्यवाद!", "You're welcome. Have a nice day!", "स्वागत है। शुभ दिन!", 3)),
            t("It's open until 5 pm today.", "🧑", "आज 5 बजे तक खुला है।",
                o("What's the entrance fee?", "प्रवेश शुल्क क्या है?", "Adults are 8 dollars, students get a discount.", "वयस्क 8 डॉलर, छात्रों को छूट।", 4),
                o("Great, thanks for your help!", "बढ़िया, मदद के लिए धन्यवाद!", "Anytime! Enjoy the museum.", "कभी भी! म्यूज़ियम का आनंद लें।", 4)),
            t("Enjoy your visit!", "🧑", "अपनी यात्रा का आनंद लें।",
                o("Thanks so much!", "बहुत धन्यवाद!", "You're very welcome.", "आपका स्वागत है।", -1),
                o("I will. Goodbye!", "ज़रूर। अलविदा!", "Goodbye!", "अलविदा!", -1))),
        rp("rp-en-taxi", "Taking a Taxi", "🚕", "Tell the driver the destination and pay the fare", "en",
            t("Where to, sir?", "👨‍✈️", "कहाँ चलें, महोदय?",
                o("The airport, please.", "हवाई अड्डे, कृपया।", "Sure. That'll take about 30 minutes.", "ठीक है। लगभग 30 मिनट।", 1),
                o("This hotel, please.", "इस होटल, कृपया।", "Got it. It's not far.", "समझ गया। दूर नहीं है।", 1)),
            t("Please fasten your seatbelt.", "👨‍✈️", "कृपया सीट बेल्ट बाँधिए।",
                o("Sure, no problem.", "ज़रूर, कोई बात नहीं।", "Thanks. Is this your first time in the city?", "धन्यवाद। पहली बार शहर में?", 2),
                o("How long will it take to get there?", "पहुँचने में कितना समय?", "About 30 minutes with this traffic.", "इस ट्रैफिक में लगभग 30 मिनट।", 2)),
            t("The traffic is a bit heavy today.", "👨‍✈️", "आज ट्रैफिक थोड़ा ज़्यादा है।",
                o("Is there a faster way?", "कोई तेज़ रास्ता?", "I'll take the side streets. It should be quicker.", "मैं छोटी गलियों से जाऊँगा। तेज़ होगा।", 3),
                o("That's fine, I'm not in a hurry.", "कोई बात नहीं, जल्दी नहीं है।", "Good to hear. There was an accident on the highway.", "अच्छा। हाईवे पर हादसा हुआ था।", 3)),
            t("Here we are. The airport!", "👨‍✈️", "हम पहुँच गए। हवाई अड्डा!",
                o("How much is the fare?", "किराया कितना?", "That'll be 25 dollars.", "25 डॉलर।", 4),
                o("Can I pay by card?", "कार्ड से भुगतान?", "Yes, the machine is right here.", "हाँ, मशीन यहाँ है।", 4)),
            t("That's 25 dollars.", "👨‍✈️", "25 डॉलर हुए।",
                o("Keep the change.", "बदला रख लीजिए।", "Thank you very much! Have a safe flight!", "बहुत धन्यवाद! उड़ान सुरक्षित रहे!", -1),
                o("Here you go.", "यह लीजिए।", "Thanks. Have a great trip!", "धन्यवाद। शुभ यात्रा!", -1))),
        rp("rp-en-shopping", "Shopping for a Gift", "🛍️", "Find a gift, ask the price, pay at the counter", "en",
            t("Hi there! Can I help you find something?", "🧑‍💼", "नमस्ते! कुछ ढूँढने में मदद करूँ?",
                o("I'm looking for a gift for my sister.", "बहन के लिए तोहफ़ा ढूँढ रहा हूँ।", "These scarves are lovely and very popular.", "ये स्कार्फ़ बहुत अच्छे और लोकप्रिय हैं।", 1),
                o("Just browsing, thanks.", "बस देख रहा हूँ, धन्यवाद।", "Take your time! Let me know if you need help.", "समय लीजिए! मदद चाहिए तो बताइए।", 1)),
            t("How about this scarf? It comes in many colors.", "🧑‍💼", "यह स्कार्फ़ कैसा है? कई रंगों में मिलता है।",
                o("How much is this one?", "यह कितने का?", "This one is 15 dollars.", "यह 15 डॉलर।", 2),
                o("What colors are available?", "कौन-कौन से रंग हैं?", "We have blue, red, and green.", "नीला, लाल और हरा।", 2)),
            t("Which color would you like?", "🧑‍💼", "कौन सा रंग चाहिए?",
                o("The blue one, please.", "नीला, कृपया।", "Great choice! Would you like it wrapped?", "बढ़िया! लपेटवाना चाहेंगे?", 3),
                o("Actually, what about this mug?", "वैसे यह मग कितने का?", "That's 8 dollars. It's a nice gift too.", "8 डॉलर। यह भी अच्छा तोहफ़ा है।", 3)),
            t("Would you like it wrapped as a gift?", "🧑‍💼", "तोहफ़े की तरह लपेटवाएँगे?",
                o("Yes, please.", "हाँ, कृपया।", "Of course. I'll wrap it up for you. Anything else?", "बिल्कुल। लपेट देता हूँ। और कुछ?", 4),
                o("No thanks, that's all.", "नहीं, बस।", "Alright. The counter is over there.", "ठीक है। काउंटर वहाँ है।", 4)),
            t("That's 15 dollars, please. Cash or card?", "🧑‍💼", "15 डॉलर। नकद या कार्ड?",
                o("Card, please.", "कार्ड, कृपया।", "Done! Here's your receipt and your gift.", "हो गया! रसीद और तोहफ़ा, यह लीजिए।", -1),
                o("Cash.", "नकद।", "Perfect. Here's your change.", "बढ़िया। बदला लीजिए।", -1))),
        rp("rp-en-doctor", "At the Doctor's Office", "🩺", "Explain your symptoms and get a prescription", "en",
            t("Hello, please take a seat. What seems to be the problem?", "👨‍⚕️", "नमस्ते, बैठिए। क्या समस्या है?",
                o("I have a headache and a fever.", "सिर दर्द और बुखार है।", "I see. How long have you felt this way?", "समझा। कब से महसूस कर रहे हैं?", 1),
                o("My throat hurts when I swallow.", "निगलते समय गले में दर्द।", "Let me take a look. Open wide.", "देखता हूँ। मुँह खोलिए।", 1)),
            t("Have you taken anything for the fever?", "👨‍⚕️", "बुखार के लिए कुछ लिया है?",
                o("Yes, I took some medicine this morning.", "हाँ, सुबह दवा ली।", "Good. Has it helped at all?", "अच्छा। कोई फ़र्क पड़ा?", 2),
                o("No, nothing yet.", "नहीं, अभी कुछ नहीं।", "Okay, let's check your temperature first.", "ठीक है, पहले तापमान देखते हैं।", 2)),
            t("It looks like a mild infection.", "👨‍⚕️", "हल्का संक्रमण लग रहा है।",
                o("Is it serious?", "गंभीर है?", "Nothing to worry about. Rest and fluids will help.", "चिंता नहीं। आराम और तरल पदार्थ से ठीक होगा।", 3),
                o("Will I need antibiotics?", "एंटीबायोटिक चाहिए?", "I'll prescribe some medicine. Take it after meals.", "दवा लिखता हूँ। खाने के बाद लें।", 3)),
            t("I'll prescribe some medicine for you.", "👨‍⚕️", "आपके लिए दवा लिख देता हूँ।",
                o("How many times a day should I take it?", "दिन में कितनी बार लूँ?", "Three times a day, after meals.", "दिन में तीन बार, खाने के बाद।", 4),
                o("Are there any side effects?", "कोई दुष्प्रभाव?", "You might feel a little sleepy. That's normal.", "थोड़ी नींद आ सकती है। यह सामान्य है।", 4)),
            t("You can pick up the medicine at the pharmacy next door.", "👨‍⚕️", "दवा बगल की फ़ार्मेसी से ले सकते हैं।",
                o("Thank you, doctor.", "धन्यवाद, डॉक्टर।", "Get well soon!", "जल्दी ठीक हों!", 5),
                o("Should I stay home from work?", "क्या काम से छुट्टी लूँ?", "Yes, take a day or two to rest.", "हाँ, एक-दो दिन आराम करें।", 5)),
            t("Drink lots of water and get some rest.", "👨‍⚕️", "खूब पानी पीजिए और आराम कीजिए।",
                o("I will. Thank you!", "ज़रूर। धन्यवाद!", "Take care. Come back if it doesn't improve.", "ख्याल रखिए। सुधार न हो तो आ जाइए।", -1),
                o("See you next week for a check-up.", "अगले हफ़्ते जाँच के लिए मिलते हैं।", "Sounds good. I'll see you then.", "ठीक है। फिर मिलते हैं।", -1))),
        rp("rp-en-cafe", "Ordering at a Cafe", "☕", "Order a drink and decide to stay or take away", "en",
            t("Hi! What can I get for you today?", "👩‍💼", "नमस्ते! आज क्या लाऊँ?",
                o("A cappuccino, please.", "एक कैपुचीनो, कृपया।", "Would you like it hot or iced?", "गरम या ठंडा?", 1),
                o("An iced latte, please.", "आइस्ड लट्टे, कृपया।", "Coming right up! Would you like anything to eat?", "अभी आया! खाने में कुछ?", 2)),
            t("Would you like it hot or iced?", "👩‍💼", "गरम या ठंडा?",
                o("Hot, please.", "गरम, कृपया।", "Anything else with that?", "और कुछ?", 2),
                o("Iced, please.", "ठंडा, कृपया।", "Anything else with that?", "और कुछ?", 2)),
            t("Anything to eat with that?", "👩‍💼", "साथ में कुछ खाना?",
                o("A blueberry muffin, please.", "ब्लूबेरी मफिन, कृपया।", "Great! For here or to go?", "बढ़िया! यहीं या पैक?", 3),
                o("No thanks, just the drink.", "नहीं, सिर्फ़ ड्रिंक।", "No problem. For here or to go?", "कोई बात नहीं। यहीं या पैक?", 3)),
            t("For here or to go?", "👩‍💼", "यहीं या पैक?",
                o("For here, please.", "यहीं, कृपया।", "Take a seat and I'll bring it over.", "बैठिए, मैं लाता हूँ।", 4),
                o("To go, please.", "पैक, कृपया।", "Sure, it'll be ready in a minute.", "ज़रूर, एक मिनट में तैयार।", 4)),
            t("Here's your cappuccino and muffin. Enjoy!", "👩‍💼", "यह रहा कैपुचीनो और मफिन। आनंद लीजिए!",
                o("Thank you! It looks great.", "धन्यवाद! बहुत अच्छा लग रहा है।", "Is everything okay? Need anything else?", "सब ठीक? और कुछ?", 5),
                o("Could I get some extra napkins?", "थोड़े नैपकिन मिलेंगे?", "Of course, here you go.", "बिल्कुल, यह लीजिए।", 5)),
            t("That's 8 dollars, whenever you're ready.", "👩‍💼", "8 डॉलर, जब तैयार हों।",
                o("Here you go. Thanks!", "यह लीजिए। धन्यवाद!", "Thank you! Have a wonderful day!", "धन्यवाद! आपका दिन शुभ हो!", -1),
                o("Can I pay by card?", "कार्ड से दूँ?", "Yes, the terminal is right here.", "हाँ, मशीन यहाँ है।", -1))),
        rp("rp-en-airport", "Airport Check-In", "✈️", "Show your documents, check your baggage, find your gate", "en",
            t("Good morning! May I see your passport and boarding pass?", "🧑‍✈️", "सुप्रभात! पासपोर्ट और बोर्डिंग पास दिखाइए।",
                o("Here you go.", "यह लीजिए।", "Thank you. Your gate is 12.", "धन्यवाद। आपका गेट 12 है।", 1),
                o("I lost my boarding pass.", "बोर्डिंग पास खो दिया।", "No worries, I can reprint it for you.", "चिंता नहीं, फिर से छाप देता हूँ।", 1)),
            t("Are you checking any bags today?", "🧑‍✈️", "आज कोई सामान चेक करवा रहे हैं?",
                o("Yes, this one bag, please.", "हाँ, यह एक बैग।", "Sure, just put it on the scale.", "ज़रूर, तराज़ू पर रखिए।", 2),
                o("I'll carry it on board.", "साथ ले जाऊँगा।", "That's fine. It's under the size limit.", "ठीक है। साइज़ सीमा के अंदर है।", 2)),
            t("Your bag is 2 kilos overweight.", "🧑‍✈️", "आपका बैग 2 किलो भारी है।",
                o("Can I move some things to my carry-on?", "क्या कुछ सामान हाथ के बैग में रखूँ?", "Of course, take your time.", "ज़रूर, समय लीजिए।", 3),
                o("How much is the excess fee?", "अतिरिक्त शुल्क कितना?", "It's 20 dollars per kilo.", "20 डॉलर प्रति किलो।", 3)),
            t("Here's your boarding pass. Boarding starts at 9:30.", "🧑‍✈️", "यह रहा बोर्डिंग पास। बोर्डिंग 9:30 बजे शुरू।",
                o("Which gate do I need?", "किस गेट पर जाना है?", "Gate 12, to your left after security.", "गेट 12, सिक्योरिटी के बाद बाएँ।", 4),
                o("How long is the walk to the gate?", "गेट तक चलने में कितना समय?", "About 10 minutes. You have plenty of time.", "लगभग 10 मिनट। समय काफ़ी है।", 4)),
            t("Have a great flight!", "🧑‍✈️", "उड़ान शुभ हो!",
                o("Thank you very much!", "बहुत धन्यवाद!", "You're welcome. Safe travels!", "स्वागत है। यात्रा सुरक्षित रहे!", -1),
                o("Thanks, see you next time!", "धन्यवाद!", "See you next time!", "फिर मिलेंगे!", -1))))
}

@Composable
fun RoleplayScreen(rp: Roleplay, store: Store, speaker: Speaker, modifier: Modifier = Modifier, onClose: () -> Unit) {
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
        modifier
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
                Spacer(Modifier.height(8.dp))
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
                                if (opt.next < 0) {
                                    msgs = msgs + RpMsg(rp.title, rp.turns.last().npcEmoji, opt.feedback, opt.feedbackHi, false)
                                    finished = true
                                } else {
                                    val nt = rp.turns[opt.next]
                                    msgs = msgs + RpMsg(rp.title, nt.npcEmoji, opt.feedback, opt.feedbackHi, false)
                                    msgs = msgs + RpMsg(rp.title, nt.npcEmoji, nt.npc, nt.npcHi, false)
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
                Spacer(Modifier.height(8.dp))
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
