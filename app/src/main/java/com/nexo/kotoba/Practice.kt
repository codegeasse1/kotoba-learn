package com.nexo.kotoba

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * One grammar drill. [sentence] holds a single `___` gap, [answer] is the word or
 * phrase that fills it, and [wrong] are three competing forms of the *same* slot
 * so every option is a near-identical sentence differing only in the grammar
 * point being tested. [hi] is the hand-written Hindi rendering of the correct
 * sentence (other native languages fall back to [Examples.sentenceGloss]).
 */
data class Drill(
    val category: String,
    val sentence: String,
    val answer: String,
    val wrong: List<String>,
    val hi: String = ""
) {
    fun filledWith(word: String): String = sentence.replace("___", word)
    fun full(): String = filledWith(answer)
    fun options(): List<String> = (wrong + answer).distinct()
    fun translation(native: String): String {
        if (native.isBlank() || native == "en") return ""
        if (native == "hi") return hi
        return Examples.sentenceGloss(full(), native)
    }
}

data class DrillCategory(
    val id: String,
    val title: String,
    val emoji: String,
    val group: String,
    val blurb: String,
    val matchKeys: List<String>
)

/**
 * The offline grammar-drill library behind the Practice section.
 *
 * Every category is a hand-written set of [Drill]s. Unlike the old pattern quiz
 * (which showed four unrelated sentences, making the answer obvious), all four
 * options here differ only in the grammar form being practised — e.g.
 * "I am a boy / I was a boy / I is a boy / I are a boy" — so the learner has to
 * actually know the rule and the meaning.
 *
 * Categories are keyed to the grammar patterns by [categoryForPattern] so the
 * 🎯 Practice button on any pattern opens a matching drill set when one exists.
 */
object Practice {

    private const val RAW = """
# id|sentence with ___|answer|wrong1;wrong2;wrong3|hindi
# --- Tenses ---
be|I ___ a boy.|am|is;was;are|मैं एक लड़का हूँ।
be|She ___ a teacher.|is|am;are;was|वह एक शिक्षिका है।
be|They ___ at home now.|are|is;am;were|वे अब घर पर हैं।
be|He ___ my brother.|is|are;am;were|वह मेरा भाई है।
be|We ___ students.|are|is;am;were|हम छात्र हैं।
be|It ___ very cold today.|is|are;am;was|आज बहुत ठंड है।
be|You ___ a good friend.|are|is;am;were|तुम एक अच्छे दोस्त हो।
be|My name ___ Ravi.|is|am;are;were|मेरा नाम रवि है।
be|I ___ not ready yet.|am|is;are;was|मैं अभी तैयार नहीं हूँ।
be|The books ___ on the table.|are|is;am;were|किताबें मेज़ पर हैं।

be-past|I ___ at home yesterday.|was|were;am;is|मैं कल घर पर था।
be-past|They ___ very tired last night.|were|was;are;is|वे कल रात बहुत थके थे।
be-past|She ___ my teacher last year.|was|were;is;are|वह पिछले साल मेरी शिक्षिका थी।
be-past|We ___ in Delhi last week.|were|was;are;is|हम पिछले हफ़्ते दिल्ली में थे।
be-past|He ___ not at school yesterday.|was|were;is;are|वह कल स्कूल में नहीं था।
be-past|The shops ___ closed yesterday.|were|was;are;is|कल दुकानें बंद थीं।
be-past|It ___ raining all night.|was|were;is;are|रात भर बारिश हो रही थी।
be-past|You ___ right about that.|were|was;are;is|उस बारे में तुम सही थे।
be-past|The movie ___ very boring.|was|were;is;are|फ़िल्म बहुत उबाऊ थी।
be-past|My friends ___ here on Sunday.|were|was;are;is|मेरे दोस्त रविवार को यहाँ थे।

present-simple|I ___ tea every morning.|drink|drinks;drank;drinking|मैं हर सुबह चाय पीता हूँ।
present-simple|She ___ at a hospital.|works|work;worked;working|वह अस्पताल में काम करती है।
present-simple|We ___ to the gym twice a week.|go|goes;went;going|हम हफ़्ते में दो बार जिम जाते हैं।
present-simple|He ___ not eat meat.|does|do;did;is|वह मांस नहीं खाता।
present-simple|The sun ___ in the east.|rises|rise;rose;rising|सूरज पूर्व से उगता है।
present-simple|My father ___ to work every day.|drives|drive;drove;driving|मेरे पिता हर दिन काम पर गाड़ी चलाते हैं।
present-simple|They ___ football on Sundays.|play|plays;played;playing|वे रविवार को फ़ुटबॉल खेलते हैं।
present-simple|Water ___ at 100 degrees.|boils|boil;boiled;boiling|पानी 100 डिग्री पर उबलता है।
present-simple|I ___ not understand this question.|do|does;did;am|मुझे यह सवाल समझ नहीं आता।

present-continuous|I ___ reading a good book now.|am|is;was;are|मैं अभी एक अच्छी किताब पढ़ रहा हूँ।
present-continuous|She ___ cooking dinner at the moment.|is|am;was;are|वह इस समय रात का खाना बना रही है।
present-continuous|They ___ playing football in the park.|are|is;was;am|वे पार्क में फ़ुटबॉल खेल रहे हैं।
present-continuous|Look! The baby ___ crying.|is|are;am;was|देखो! बच्चा रो रहा है।
present-continuous|We ___ staying at a hotel this week.|are|is;am;were|हम इस हफ़्ते होटल में ठहर रहे हैं।
present-continuous|He ___ not working today.|is|are;am;was|वह आज काम नहीं कर रहा है।
present-continuous|What ___ you doing right now?|are|is;am;were|तुम अभी क्या कर रहे हो?
present-continuous|The weather ___ getting colder.|is|are;am;was|मौसम ठंडा होता जा रहा है।
present-continuous|I ___ meeting my friend tomorrow.|am|is;are;was|मैं कल अपने दोस्त से मिल रहा हूँ।
present-continuous|Listen! It ___ starting to rain.|is|are;am;was|सुनो! बारिश शुरू हो रही है।

past-simple|I ___ my grandmother last weekend.|visited|visit;visits;visiting|मैं पिछले सप्ताहांत अपनी दादी से मिलने गया।
past-simple|She ___ me two hours ago.|called|call;calls;calling|उसने दो घंटे पहले मुझे फ़ोन किया।
past-simple|We ___ a great movie yesterday.|watched|watch;watches;watching|हमने कल एक बढ़िया फ़िल्म देखी।
past-simple|He ___ not come to the party.|did|does;do;is|वह पार्टी में नहीं आया।
past-simple|They ___ to Spain in 2019.|went|go;goes;going|वे 2019 में स्पेन गए थे।
past-simple|She ___ a new phone last week.|bought|buy;buys;buying|उसने पिछले हफ़्ते नया फ़ोन ख़रीदा।
past-simple|The meeting ___ at nine o'clock.|started|start;starts;starting|मीटिंग नौ बजे शुरू हुई।
past-simple|What ___ you do last night?|did|do;does;are|तुमने कल रात क्या किया?
past-simple|I ___ him at the station yesterday.|met|meet;meets;meeting|कल मैं उससे स्टेशन पर मिला।
past-simple|When I was young, I ___ the piano.|played|play;plays;playing|जब मैं छोटा था, मैं पियानो बजाता था।

past-continuous|I ___ watching TV when you called.|was|were;am;is|जब तुमने फ़ोन किया, मैं टीवी देख रहा था।
past-continuous|She ___ cooking dinner at eight o'clock.|was|were;is;are|आठ बजे वह रात का खाना बना रही थी।
past-continuous|They ___ playing outside all afternoon.|were|was;are;is|वे पूरी दोपहर बाहर खेल रहे थे।
past-continuous|It ___ raining when we left the house.|was|were;is;are|जब हम घर से निकले तो बारिश हो रही थी।
past-continuous|He ___ not listening to the teacher.|was|were;is;are|वह शिक्षक की बात नहीं सुन रहा था।
past-continuous|While I ___ studying, my brother was playing.|was|were;am;is|जब मैं पढ़ रहा था, मेरा भाई खेल रहा था।
past-continuous|What ___ you doing at ten last night?|were|was;are;is|कल रात दस बजे तुम क्या कर रहे थे?
past-continuous|The children ___ sleeping when we arrived.|were|was;are;is|जब हम पहुँचे, बच्चे सो रहे थे।

present-perfect|I ___ finished my homework.|have|has;had;am|मैंने अपना होमवर्क पूरा कर लिया है।
present-perfect|She ___ just left the office.|has|have;had;is|वह अभी-अभी दफ़्तर से निकली है।
present-perfect|___ you ever been to Japan?|Have|Has;Did;Are|क्या तुम कभी जापान गए हो?
present-perfect|We ___ lived here for ten years.|have|has;had;are|हम यहाँ दस साल से रह रहे हैं।
present-perfect|He ___ never eaten sushi.|has|have;had;is|उसने कभी सुशी नहीं खाई।
present-perfect|I ___ not seen that movie yet.|have|has;had;am|मैंने वह फ़िल्म अभी तक नहीं देखी।
present-perfect|She ___ worked here since 2019.|has|have;had;is|वह 2019 से यहाँ काम कर रही है।
present-perfect|They ___ already gone home.|have|has;had;are|वे पहले ही घर जा चुके हैं।
present-perfect|The train ___ just arrived.|has|have;had;is|ट्रेन अभी-अभी पहुँची है।
present-perfect|I ___ lost my keys.|have|has;had;am|मैंने अपनी चाबियाँ खो दी हैं।

present-perfect-continuous|I ___ been waiting for you for an hour.|have|has;had;am|मैं एक घंटे से तुम्हारा इंतज़ार कर रहा हूँ।
present-perfect-continuous|She ___ been studying English since she was ten.|has|have;had;is|वह दस साल की उम्र से अंग्रेज़ी पढ़ रही है।
present-perfect-continuous|It ___ been raining all morning.|has|have;had;is|सुबह से बारिश हो रही है।
present-perfect-continuous|How long ___ you been working here?|have|has;had;are|तुम यहाँ कितने समय से काम कर रहे हो?
present-perfect-continuous|They ___ been talking for two hours.|have|has;had;are|वे दो घंटे से बात कर रहे हैं।
present-perfect-continuous|My eyes are tired because I ___ been reading.|have|has;had;am|दिन भर पढ़ने से मेरी आँखें थक गई हैं।
present-perfect-continuous|The children ___ been playing outside since noon.|have|has;had;are|बच्चे दोपहर से बाहर खेल रहे हैं।
present-perfect-continuous|We ___ been living here for six years.|have|has;had;are|हम यहाँ छह साल से रह रहे हैं।

past-perfect|The train ___ already left when we arrived.|had|has;have;was|जब हम पहुँचे, ट्रेन पहले ही निकल चुकी थी।
past-perfect|She ___ finished her homework before dinner.|had|has;have;was|उसने रात के खाने से पहले होमवर्क पूरा कर लिया था।
past-perfect|I ___ never seen snow before that trip.|had|have;has;was|उस यात्रा से पहले मैंने कभी बर्फ़ नहीं देखी थी।
past-perfect|By the time he called, I ___ gone to bed.|had|have;has;was|जब उसने फ़ोन किया, तब तक मैं सो चुका था।
past-perfect|They ___ lived in Paris before moving here.|had|have;has;were|यहाँ आने से पहले वे पेरिस में रहे थे।
past-perfect|He ___ already eaten, so he was not hungry.|had|has;have;was|वह पहले ही खा चुका था, इसलिए भूखा नहीं था।
past-perfect|I realized that I ___ forgotten my keys.|had|have;has;was|मुझे एहसास हुआ कि मैं अपनी चाबियाँ भूल गया था।
past-perfect|We ___ not eaten all day, so we were hungry.|had|have;has;were|हमने दिन भर कुछ नहीं खाया था, इसलिए भूखे थे।

past-perfect-continuous|I ___ been waiting for an hour when the bus came.|had|have;has;was|जब बस आई, मैं एक घंटे से इंतज़ार कर रहा था।
past-perfect-continuous|She ___ been working there for ten years before she quit.|had|have;has;was|नौकरी छोड़ने से पहले वह दस साल वहाँ काम कर रही थी।
past-perfect-continuous|They ___ been arguing for hours by the time I arrived.|had|have;has;were|मेरे पहुँचने तक वे घंटों बहस कर रहे थे।
past-perfect-continuous|It ___ been raining all night, so the roads were wet.|had|have;has;was|रात भर बारिश हो रही थी, इसलिए सड़कें गीली थीं।
past-perfect-continuous|He was tired because he ___ been running.|had|have;has;was|वह दौड़ रहा था, इसलिए थका हुआ था।
past-perfect-continuous|We ___ been driving for three hours when we stopped.|had|have;has;were|जब हम रुके, हम तीन घंटे से गाड़ी चला रहे थे।
past-perfect-continuous|The ground was wet because it ___ been raining.|had|have;has;was|बारिश हो रही थी, इसलिए ज़मीन गीली थी।

future-will|I ___ call you tomorrow.|will|would;am;did|मैं कल तुम्हें फ़ोन करूँगा।
future-will|She ___ be twenty next month.|will|would;is;was|वह अगले महीने बीस साल की हो जाएगी।
future-will|It ___ rain this evening.|will|would;is;was|आज शाम बारिश होगी।
future-will|I ___ help you with that.|will|would;am;did|मैं उसमें तुम्हारी मदद करूँगा।
future-will|They ___ not arrive before noon.|will|would;are;were|वे दोपहर से पहले नहीं पहुँचेंगे।
future-will|___ you come to my party?|Will|Would;Do;Did|क्या तुम मेरी पार्टी में आओगे?
future-will|I think she ___ pass the exam.|will|would;is;was|मुझे लगता है वह परीक्षा पास करेगी।
future-will|The shops ___ be closed tomorrow.|will|would;are;were|कल दुकानें बंद रहेंगी।
future-will|Do not worry, I ___ pay for dinner.|will|would;am;did|चिंता मत करो, रात का खाना मैं चुकाऊँगा।
future-will|We ___ meet again soon.|will|would;are;were|हम जल्द फिर मिलेंगे।

going-to|I ___ going to call her tonight.|am|is;was;are|मैं आज रात उसे फ़ोन करने वाला हूँ।
going-to|She ___ going to study medicine.|is|are;am;was|वह दवा की पढ़ाई करने वाली है।
going-to|They ___ going to move to Mumbai.|are|is;am;were|वे मुंबई जाने वाले हैं।
going-to|We are going to ___ a new house.|buy|bought;buying;buys|हम एक नया घर खरीदने वाले हैं।
going-to|He is going to ___ his grandparents.|visit|visited;visiting;visits|वह अपने दादा-दादी से मिलने वाला है।
going-to|It is going to ___ tomorrow.|rain|rained;raining;rains|कल बारिश होने वाली है।
going-to|I am going to ___ hard for the exam.|study|studied;studying;studies|मैं परीक्षा के लिए कड़ी मेहनत करने वाला हूँ।
going-to|They are going to ___ a party on Sunday.|have|had;having;has|वे रविवार को पार्टी करने वाले हैं।

future-continuous|This time tomorrow I ___ flying to Tokyo.|will be|was;am;were|कल इसी समय मैं टोक्यो जा रहा हूँगा।
future-continuous|She ___ working late tonight.|will be|was;is;were|वह आज रात देर तक काम कर रही होगी।
future-continuous|At eight o'clock we ___ having dinner.|will be|were;are;was|आठ बजे हम रात का खाना खा रहे होंगे।
future-continuous|Do not call at nine, I ___ sleeping.|will be|was;am;were|नौ बजे मत फ़ोन करना, मैं सो रहा हूँगा।
future-continuous|___ you be using your laptop this afternoon?|Will|Did;Are;Were|क्या तुम आज दोपहर अपना लैपटॉप इस्तेमाल करोगे?
future-continuous|They ___ traveling all next week.|will be|were;are;was|वे अगले पूरे हफ़्ते यात्रा कर रहे होंगे।
future-continuous|When you arrive, I ___ waiting at the gate.|will be|was;am;were|जब तुम पहुँचोगे, मैं गेट पर इंतज़ार कर रहा हूँगा।
future-continuous|At midnight we ___ still driving.|will be|were;are;was|आधी रात को हम अब भी गाड़ी चला रहे होंगे।

future-perfect|By tomorrow I ___ finished the report.|will have|would have;have;had|कल तक मैं रिपोर्ट पूरी कर चुका होऊँगा।
future-perfect|She ___ left by the time you arrive.|will have|would have;has;had|तुम्हारे पहुँचने तक वह निकल चुकी होगी।
future-perfect|By 2030 they ___ built the new bridge.|will have|would have;have;had|2030 तक वे नया पुल बना चुके होंगे।
future-perfect|We ___ lived here for ten years next June.|will have|would have;have;had|अगले जून तक हम यहाँ दस साल रह चुके होंगे।
future-perfect|He ___ not have arrived by noon.|will|would;has;did|वह दोपहर तक नहीं पहुँच चुका होगा।
future-perfect|By next month, I ___ saved enough money.|will have|would have;have;had|अगले महीने तक मैं काफ़ी पैसे बचा चुका होऊँगा।
future-perfect|They ___ eaten before the guests come.|will have|would have;have;had|मेहमानों के आने से पहले वे खा चुके होंगे।
future-perfect|I ___ read the whole book by Sunday.|will have|would have;have;had|रविवार तक मैं पूरी किताब पढ़ चुका होऊँगा।

future-perfect-continuous|By May I ___ learning Spanish for two years.|will have been|had been;have been;was|मई तक मैं दो साल से स्पेनिश सीख रहा होऊँगा।
future-perfect-continuous|Next week she ___ working here for a year.|will have been|had been;has been;was|अगले हफ़्ते वह यहाँ एक साल से काम कर रही होगी।
future-perfect-continuous|By the time you arrive, I ___ waiting for three hours.|will have been|had been;have been;was|तुम्हारे आने तक मैं तीन घंटे से इंतज़ार कर रहा होऊँगा।
future-perfect-continuous|In June they ___ married for twenty years.|will have been|had been;have been;were|जून में उन्हें शादी किए बीस साल हो जाएँगे।
future-perfect-continuous|He ___ driving for eight hours by then.|will have been|had been;has been;was|तब तक वह आठ घंटे से गाड़ी चला रहा होगा।
future-perfect-continuous|By next month, I ___ living here for five years.|will have been|had been;have been;was|अगले महीने तक मैं यहाँ पाँच साल से रह रहा होऊँगा।

# --- Verbs & modals ---
have-has|I ___ a car.|have|has;had;having|मेरे पास एक कार है।
have-has|She ___ two sisters.|has|have;had;having|उसकी दो बहनें हैं।
have-has|We ___ a meeting at noon.|have|has;had;having|हमारी दोपहर में मीटिंग है।
have-has|He ___ blue eyes.|has|have;had;having|उसकी नीली आँखें हैं।
have-has|They ___ a big house.|have|has;had;having|उनके पास एक बड़ा घर है।
have-has|She ___ not have any money.|does|do;did;is|उसके पास कोई पैसा नहीं है।
have-has|___ you have a pen?|Do|Does;Did;Are|क्या तुम्हारे पास कलम है?
have-has|My brother ___ a new bike.|has|have;had;having|मेरे भाई के पास नई साइकिल है।
have-has|I ___ a headache today.|have|has;had;having|आज मुझे सिरदर्द है।
have-has|The house ___ a big garden.|has|have;had;having|घर में एक बड़ा बगीचा है।

do-does-did|___ you like coffee?|Do|Does;Did;Are|क्या तुम्हें कॉफ़ी पसंद है?
do-does-did|___ she live near here?|Does|Do;Did;Is|क्या वह यहाँ पास में रहती है?
do-does-did|___ they come yesterday?|Did|Do;Does;Were|क्या वे कल आए थे?
do-does-did|I ___ not know the answer.|do|does;did;am|मुझे जवाब नहीं पता।
do-does-did|He ___ not work on Sundays.|does|do;did;is|वह रविवार को काम नहीं करता।
do-does-did|We ___ not see the film.|did|do;does;were|हमने फ़िल्म नहीं देखी।
do-does-did|What ___ you do for a living?|do|does;did;are|तुम काम क्या करते हो?
do-does-did|Where ___ she go last night?|did|do;does;was|वह कल रात कहाँ गई?
do-does-did|___ he speak English?|Does|Do;Did;Is|क्या वह अंग्रेज़ी बोलता है?

can-could|I ___ speak a little Spanish.|can|could;will;am|मैं थोड़ी स्पेनिश बोल सकता हूँ।
can-could|She ___ play the piano very well.|can|could;will;is|वह बहुत अच्छी तरह पियानो बजा सकती है।
can-could|When I was young, I ___ run very fast.|could|can;will;am|जब मैं छोटा था, मैं बहुत तेज़ दौड़ सकता था।
can-could|I ___ not find my keys yesterday.|could|can;will;am|मुझे कल अपनी चाबियाँ नहीं मिलीं।
can-could|They ___ speak three languages.|can|could;will;are|वे तीन भाषाएँ बोल सकते हैं।
can-could|I ___ swim very well when I was a child.|could|can;will;am|बचपन में मैं बहुत अच्छा तैर सकता था।
can-could|He ___ not come to the phone right now.|can|could;will;is|वह अभी फ़ोन पर नहीं आ सकता।
can-could|___ you swim when you were five?|Could|Can;Will;Are|क्या तुम पाँच साल के थे तब तैर सकते थे?

modals-deduction|He has three cars, so he ___ be rich.|must|might;can't;should|उसके पास तीन कारें हैं, तो वह ज़रूर अमीर होगा।
modals-deduction|I am not sure, but it ___ snow tonight.|might|must;can't;should|मुझे यकीन नहीं, पर आज रात बर्फ़ पड़ सकती है।
modals-deduction|That ___ be true, I do not believe it.|can't|must;might;should|यह सच नहीं हो सकता, मुझे विश्वास नहीं।
modals-deduction|She ___ be at home, her car is outside.|must|might;can't;should|वह घर पर ज़रूर होगी, उसकी कार बाहर है।
modals-deduction|The keys are not here, so I ___ have left them at home.|must|might;can't;should|चाबियाँ यहाँ नहीं हैं, तो मैंने उन्हें घर छोड़ा ही होगा।
modals-deduction|This ___ be the wrong key, it does not fit.|might|must;can't;should|यह गलत चाबी हो सकती है, यह फ़िट नहीं होती।
modals-deduction|He ___ have taken the train, but I am not sure.|might|must;can't;should|उसने ट्रेन ली हो सकती है, पर मुझे यकीन नहीं।

must-have-to|You ___ wear a seatbelt in a car, it is the law.|must|might;can;would|गाड़ी में सीटबेल्ट पहनना ज़रूरी है, यह कानून है।
must-have-to|I ___ finish this report by Friday.|must|might;can;would|मुझे शुक्रवार तक यह रिपोर्ट पूरी करनी है।
must-have-to|She ___ leave early today.|has to|have to;had to;having to|उसे आज जल्दी निकलना है।
must-have-to|You ___ not smoke here.|must|can;would;might|यहाँ धूम्रपान नहीं करना चाहिए।
must-have-to|We ___ wear a uniform at school.|have to|has to;had to;having to|हमें स्कूल में यूनिफ़ॉर्म पहनना पड़ता है।
must-have-to|He ___ work late yesterday.|had to|have to;has to;having to|उसे कल देर तक काम करना पड़ा।
must-have-to|Do we ___ bring our own books?|have to|has to;had to;having to|क्या हमें अपनी किताबें लानी हैं?

should|You look tired, you ___ get some rest.|should|must;can;would|तुम थके लग रहे हो, तुम्हें थोड़ा आराम करना चाहिए।
should|He ___ apologize for being rude.|should|must;can;would|उसे रूखा होने के लिए माफ़ी माँगनी चाहिए।
should|We ___ not be late for the meeting.|should|must;can;would|हमें मीटिंग के लिए देर नहीं होनी चाहिए।
should|___ I call her now?|Should|Must;Would;Could|क्या मुझे अब उसे फ़ोन करना चाहिए?
should|You ___ drink more water in summer.|should|must;can;would|गर्मियों में तुम्हें ज़्यादा पानी पीना चाहिए।
should|Students ___ respect their teachers.|should|must;can;would|विद्यार्थियों को अपने शिक्षकों का सम्मान करना चाहिए।

would|___ you like some tea?|Would|Will;Do;Did|क्या तुम थोड़ी चाय लेना चाहोगे?
would|I ___ like to book a table, please.|would|will;do;did|मैं एक टेबल बुक करना चाहूँगा।
would|When I was a child, we ___ visit my grandmother every summer.|would|will;did;were|जब मैं बच्चा था, हम हर गर्मियों में दादी के पास जाते थे।
would|If I had money, I ___ buy a car.|would|will;did;am|अगर मेरे पास पैसे होते, मैं कार खरीदता।
would|She said she ___ call me later.|would|will;did;was|उसने कहा कि वह बाद में फ़ोन करेगी।
would|___ you mind closing the window?|Would|Will;Do;Did|क्या आप खिड़की बंद करने की कृपा करेंगे?
would|He ___ always tell us funny stories.|would|will;did;was|वह हमें हमेशा मज़ेदार कहानियाँ सुनाता था।

used-to|I ___ play the piano when I was young.|used to|use to;used;using to|जब मैं छोटा था, मैं पियानो बजाता था।
used-to|She ___ live in London.|used to|use to;used;using to|वह पहले लंदन में रहती थी।
used-to|We ___ go to the beach every summer.|used to|use to;used;using to|हम हर गर्मियों में समुद्र तट जाते थे।
used-to|He ___ smoke, but he quit last year.|used to|use to;used;using to|वह पहले धूम्रपान करता था, पर पिछले साल छोड़ दिया।
used-to|I did not ___ like coffee.|use to|used to;using to;used|मुझे पहले कॉफ़ी पसंद नहीं थी।
used-to|Did you ___ work in a bank?|use to|used to;using to;used|क्या तुम पहले बैंक में काम करते थे?
used-to|There ___ be a cinema here.|used to|use to;used;using to|यहाँ पहले एक सिनेमा हुआ करता था।

gerund-infinitive|I enjoy ___ books in the evening.|reading|to read;read;reads|मुझे शाम को किताबें पढ़ना अच्छा लगता है।
gerund-infinitive|She wants ___ a doctor.|to be|being;be;is|वह डॉक्टर बनना चाहती है।
gerund-infinitive|They decided ___ to the party.|to go|going;go;gone|उन्होंने पार्टी में जाने का फ़ैसला किया।
gerund-infinitive|I finished ___ my homework.|doing|to do;do;did|मैंने अपना होमवर्क कर लिया।
gerund-infinitive|He avoids ___ fast food.|eating|to eat;eat;ate|वह फास्ट फ़ूड खाने से बचता है।
gerund-infinitive|We hope ___ you soon.|to see|seeing;see;saw|हम जल्द तुम्हें देखने की उम्मीद करते हैं।
gerund-infinitive|She is good at ___ .|swimming|to swim;swim;swam|वह तैरने में अच्छी है।
gerund-infinitive|Let me ___ you with that.|help|to help;helping;helped|मुझे उसमें तुम्हारी मदद करने दो।
gerund-infinitive|I look forward to ___ from you.|hearing|hear;heard;to hear|मुझे तुमसे सुनने का इंतज़ार है।

# --- Nouns, articles & pronouns ---
articles|I saw ___ elephant at the zoo.|an|a;the;some|मैंने चिड़ियाघर में एक हाथी देखा।
articles|She is ___ doctor.|a|an;the;some|वह एक डॉक्टर है।
articles|___ sun rises in the east.|The|A;An;Some|सूरज पूर्व से उगता है।
articles|He ate ___ apple for breakfast.|an|a;the;some|उसने नाश्ते में एक सेब खाया।
articles|I need ___ umbrella, it is raining.|an|a;the;some|मुझे एक छाता चाहिए, बारिश हो रही है।
articles|This is ___ best movie I have seen.|the|a;an;some|यह मेरी देखी सबसे अच्छी फ़िल्म है।
articles|We waited for ___ hour.|an|a;the;some|हम एक घंटे इंतज़ार करते रहे।
articles|She bought ___ new car yesterday.|a|an;the;some|उसने कल एक नई कार ख़रीदी।
articles|Can you pass me ___ salt?|the|a;an;some|क्या तुम मुझे नमक दे सकते हो?
articles|He is ___ honest man.|an|a;the;some|वह एक ईमानदार आदमी है।

plurals|I bought two ___ at the market.|apples|apple;apple's;applies|मैंने बाज़ार में दो सेब ख़रीदे।
plurals|There are three ___ in the garden.|cats|cat;cat's;cates|बगीचे में तीन बिल्लियाँ हैं।
plurals|She has many ___ .|books|book;book's;bookes|उसके पास बहुत सी किताबें हैं।
plurals|He washed the ___ after dinner.|dishes|dish;dish's;dishs|उसने रात के खाने के बाद बर्तन धोए।
plurals|The ___ are singing in the tree.|birds|bird;bird's;birdes|पेड़ पर पक्षी गा रहे हैं।
plurals|We need two ___ of milk.|bottles|bottle;bottle's;bottlees|हमें दो बोतल दूध चाहिए।
plurals|There are five ___ in the class.|children|child;child's;childs|कक्षा में पाँच बच्चे हैं।
plurals|I have three ___ .|sisters|sister;sister's;sisteres|मेरी तीन बहनें हैं।
plurals|The ___ are very old.|houses|house;house's;houseses|घर बहुत पुराने हैं।

this-that|___ book in my hand is very interesting.|This|That;These;Those|मेरे हाथ में यह किताब बहुत रोचक है।
this-that|___ shoes over there are mine.|Those|These;This;That|वे जूते वहाँ मेरे हैं।
this-that|___ house here is very old.|This|That;These;Those|यहाँ यह घर बहुत पुराना है।
this-that|___ trees in the park are very tall.|These|Those;This;That|पार्क में ये पेड़ बहुत ऊँचे हैं।
this-that|___ picture on the wall is old.|That|This;These;Those|दीवार पर वह तस्वीर पुरानी है।
this-that|___ mangoes here are sweet.|These|Those;This;That|यहाँ ये आम मीठे हैं।
this-that|___ clouds in the sky look dark.|Those|These;This;That|आसमान में वे बादल काले लग रहे हैं।
this-that|___ is my brother standing next to me.|This|That;These;Those|मेरे बगल में खड़ा यह मेरा भाई है।

there-is-are|___ a cat on the roof.|There is|There are;There was;There were|छत पर एक बिल्ली है।
there-is-are|___ two apples on the table.|There are|There is;There was;There were|मेज़ पर दो सेब हैं।
there-is-are|___ many shops on this street.|There are|There is;There was;There were|इस सड़क पर बहुत सी दुकानें हैं।
there-is-are|___ some milk in the glass.|There is|There are;There was;There were|गिलास में थोड़ा दूध है।
there-is-are|___ a hospital near your house?|Is there|Are there;Was there;Were there|क्या तुम्हारे घर के पास अस्पताल है?
there-is-are|___ any eggs in the fridge.|There aren't|There isn't;There wasn't;There weren't|फ्रिज में कोई अंडे नहीं हैं।
there-is-are|___ a big crowd at the station yesterday.|There was|There were;There is;There are|कल स्टेशन पर बहुत भीड़ थी।
there-is-are|___ four windows in my room.|There are|There is;There was;There were|मेरे कमरे में चार खिड़कियाँ हैं।

pronouns|___ am going to the market.|I|Me;My;Mine|मैं बाज़ार जा रहा हूँ।
pronouns|Can you help ___ with this?|me|I;my;mine|क्या तुम इसमें मेरी मदद कर सकते हो?
pronouns|___ is my best friend.|She|Her;Hers;Herself|वह मेरी सबसे अच्छी दोस्त है।
pronouns|I gave ___ the book yesterday.|him|he;his;himself|मैंने उसे कल किताब दी।
pronouns|___ are playing football in the park.|They|Them;Their;Theirs|वे पार्क में फ़ुटबॉल खेल रहे हैं।
pronouns|Please call ___ tomorrow.|us|we;our;ours|कृपया हमें कल फ़ोन करें।
pronouns|She looked at ___ in the mirror.|herself|her;hers;she|उसने आईने में खुद को देखा।
pronouns|This gift is for ___ .|them|they;their;theirs|यह तोहफ़ा उनके लिए है।

possessives|This is ___ school bag.|my|me;I;mine|यह मेरा स्कूल बैग है।
possessives|___ bicycle is outside.|Your|You;Yours;Yourselves|तुम्हारी साइकिल बाहर है।
possessives|___ notebook is on the desk.|His|He;Him;Himself|उसकी कॉपी मेज़ पर है।
possessives|___ scarf is very colourful.|Her|She;Hers;Herself|उसका स्कार्फ़ बहुत रंगीन है।
possessives|___ dog loves to play.|Our|Us;Ours;We|हमारा कुत्ता खेलना पसंद करता है।
possessives|___ house is near the market.|Their|Them;Theirs;They|उनका घर बाज़ार के पास है।
possessives|This pen is ___ .|mine|my;me;I|यह कलम मेरी है।
possessives|The red car is ___ .|his|he;him;himself|लाल कार उसकी है।
possessives|Is this book ___ ?|yours|your;you;yourself|क्या यह किताब तुम्हारी है?

much-many|How ___ apples do you want?|many|much;lots;few|तुम कितने सेब चाहते हो?
much-many|How ___ sugar do you need?|much|many;lots;few|तुम्हें कितनी चीनी चाहिए?
much-many|There is not ___ water in the bottle.|much|many;few;lots|बोतल में ज़्यादा पानी नहीं है।
much-many|She does not have ___ friends.|many|much;few;lots|उसके बहुत ज़्यादा दोस्त नहीं हैं।
much-many|I do not have ___ time today.|much|many;few;lots|आज मेरे पास ज़्यादा समय नहीं है।
much-many|How ___ people were at the party?|many|much;lots;few|पार्टी में कितने लोग थे?
much-many|There are too ___ cars on the road.|many|much;few;lots|सड़क पर बहुत ज़्यादा कारें हैं।
much-many|We do not have ___ money left.|much|many;few;lots|हमारे पास ज़्यादा पैसे नहीं बचे।

some-any|I have ___ milk in the fridge.|some|any;much;many|मेरे पास फ्रिज में थोड़ा दूध है।
some-any|Do you have ___ questions?|any|some;much;many|क्या तुम्हारे कोई सवाल हैं?
some-any|There is not ___ bread left.|any|some;much;many|कोई ब्रेड नहीं बची है।
some-any|She bought ___ oranges at the market.|some|any;much;many|उसने बाज़ार में कुछ संतरे ख़रीदे।
some-any|Would you like ___ tea?|some|any;much;many|क्या तुम थोड़ी चाय लेना चाहोगे?
some-any|I do not need ___ help.|any|some;much;many|मुझे किसी मदद की ज़रूरत नहीं है।
some-any|There are ___ good restaurants here.|some|any;much;many|यहाँ कुछ अच्छे रेस्तराँ हैं।

# --- Prepositions ---
prep-place|The book is ___ the table.|on|in;under;between|किताब मेज़ पर है।
prep-place|The cat is hiding ___ the bed.|under|on;in;above|बिल्ली पलंग के नीचे छिपी है।
prep-place|The keys are ___ my bag.|in|on;under;above|चाबियाँ मेरे बैग में हैं।
prep-place|There is a lamp ___ the desk.|above|on;in;under|मेज़ के ऊपर एक लैंप है।
prep-place|The bank is ___ the post office and the school.|between|among;on;under|बैंक डाकघर और स्कूल के बीच है।
prep-place|He is sitting ___ the chair.|on|in;under;above|वह कुर्सी पर बैठा है।
prep-place|The picture is ___ the wall.|on|in;under;above|तस्वीर दीवार पर है।
prep-place|The bridge goes ___ the river.|over|on;in;under|पुल नदी के ऊपर से जाता है।
prep-place|She is waiting ___ the bus stop.|at|on;in;under|वह बस स्टॉप पर इंतज़ार कर रही है।
prep-place|The cat sat ___ the sofa.|on|in;under;above|बिल्ली सोफ़े पर बैठी।

prep-time|The meeting is ___ Monday.|on|in;at;for|मीटिंग सोमवार को है।
prep-time|I was born ___ 1995.|in|on;at;for|मैं 1995 में पैदा हुआ था।
prep-time|The class starts ___ nine o'clock.|at|on;in;for|कक्षा नौ बजे शुरू होती है।
prep-time|We will meet ___ the evening.|in|on;at;for|हम शाम को मिलेंगे।
prep-time|She has worked here ___ three years.|for|since;in;at|वह तीन साल से यहाँ काम कर रही है।
prep-time|I have known him ___ 2010.|since|for;in;at|मैं उसे 2010 से जानता हूँ।
prep-time|He will come back ___ a week.|in|on;at;for|वह एक हफ़्ते में वापस आएगा।
prep-time|My birthday is ___ 5th May.|on|in;at;for|मेरा जन्मदिन 5 मई को है।
prep-time|We usually rest ___ the afternoon.|in|on;at;for|हम आमतौर पर दोपहर में आराम करते हैं।
prep-time|The shop opens ___ eight a.m.|at|on;in;for|दुकान सुबह आठ बजे खुलती है।

prep-movement|She walked ___ the room.|into|on;at;under|वह कमरे में चली गई।
prep-movement|We drove ___ the tunnel.|through|on;at;in|हम सुरंग से होकर गाड़ी चलाए।
prep-movement|He ran ___ the street.|across|through;on;at|वह सड़क के आर-पार दौड़ा।
prep-movement|The cat jumped ___ the table.|onto|into;through;at|बिल्ली मेज़ पर कूदी।
prep-movement|They went ___ the park.|to|at;in;on|वे पार्क गए।
prep-movement|The train arrived ___ the station.|at|to;in;on|ट्रेन स्टेशन पहुँची।
prep-movement|He fell ___ the stairs.|down|up;across;through|वह सीढ़ियों से नीचे गिरा।
prep-movement|We walked ___ the river.|along|across;through;at|हम नदी के किनारे-किनारे चले।

prep-dependent|She is very good ___ maths.|at|in;on;for|वह गणित में बहुत अच्छी है।
prep-dependent|It depends ___ the weather.|on|at;in;for|यह मौसम पर निर्भर करता है।
prep-dependent|I am afraid ___ dogs.|of|from;at;in|मुझे कुत्तों से डर लगता है।
prep-dependent|He is interested ___ art.|in|on;at;for|उसे कला में दिलचस्पी है।
prep-dependent|Thank you ___ your help.|for|of;to;at|तुम्हारी मदद के लिए धन्यवाद।
prep-dependent|She is married ___ a doctor.|to|with;for;at|वह एक डॉक्टर से शादीशुदा है।
prep-dependent|This is different ___ that.|from|than;to;of|यह उससे अलग है।
prep-dependent|We are waiting ___ the bus.|for|on;at;to|हम बस का इंतज़ार कर रहे हैं।
prep-dependent|He is responsible ___ the team.|for|of;to;at|वह टीम का ज़िम्मेदार है।
prep-dependent|I am proud ___ my son.|of|for;at;on|मुझे अपने बेटे पर गर्व है।

# --- Sentences & style ---
comparatives|This box is ___ than that one.|heavier|heavy;heaviest;more heavy|यह डिब्बा उससे भारी है।
comparatives|She is ___ than her sister.|taller|tall;tallest;more tall|वह अपनी बहन से लंबी है।
comparatives|Today is ___ than yesterday.|warmer|warm;warmest;more warm|आज कल से ज़्यादा गर्म है।
comparatives|This book is ___ than that one.|more interesting|most interesting;interesting;interestinger|यह किताब उससे ज़्यादा रोचक है।
comparatives|My car is ___ than yours.|faster|fast;fastest;more fast|मेरी कार तुम्हारी से तेज़ है।
comparatives|English is ___ than I thought.|easier|easy;easiest;more easy|अंग्रेज़ी मेरी सोच से आसान है।
comparatives|He is ___ than his brother.|younger|young;youngest;more young|वह अपने भाई से छोटा है।
comparatives|This road is ___ than the other one.|wider|wide;widest;more wide|यह सड़क दूसरी से चौड़ी है।

superlatives|This is the ___ building in the city.|tallest|taller;tall;most tall|यह शहर की सबसे ऊँची इमारत है।
superlatives|She is the ___ student in the class.|smartest|smarter;smart;most smart|वह कक्षा की सबसे होशियार छात्रा है।
superlatives|It was the ___ day of my life.|best|better;good;most good|यह मेरे जीवन का सबसे अच्छा दिन था।
superlatives|This is the ___ movie I have seen.|most interesting|more interesting;interesting;interestingest|यह मेरी देखी सबसे रोचक फ़िल्म है।
superlatives|He is the ___ runner on the team.|fastest|faster;fast;most fast|वह टीम का सबसे तेज़ धावक है।
superlatives|That was the ___ meal of the trip.|worst|worse;bad;most bad|वह यात्रा का सबसे बुरा खाना था।
superlatives|This is the ___ shop in town.|cheapest|cheaper;cheap;most cheap|यह शहर की सबसे सस्ती दुकान है।
superlatives|She has the ___ voice in the choir.|most beautiful|more beautiful;beautiful;beautifulest|उसकी आवाज़ कोरस में सबसे सुंदर है।

wh-questions|___ is your name?|What|Who;Where;When|तुम्हारा नाम क्या है?
wh-questions|___ do you live?|Where|What;Who;Why|तुम कहाँ रहते हो?
wh-questions|___ is that man?|Who|What;Where;How|वह आदमी कौन है?
wh-questions|___ are you crying?|Why|What;Where;Who|तुम क्यों रो रहे हो?
wh-questions|___ old are you?|How|What;Who;Where|तुम कितने साल के हो?
wh-questions|___ time does the train leave?|What|Which;Who;How|ट्रेन कितने बजे निकलती है?
wh-questions|___ book is this?|Whose|Who;Which;What|यह किसकी किताब है?
wh-questions|___ do you go to school?|How|What;Who;Where|तुम स्कूल कैसे जाते हो?
wh-questions|___ is your birthday?|When|What;Who;Where|तुम्हारा जन्मदिन कब है?
wh-questions|___ one do you want, tea or coffee?|Which|What;Who;Whose|तुम कौन-सा चाहते हो, चाय या कॉफ़ी?

conjunctions|I was tired, ___ I went to bed.|so|because;but;or|मैं थका था, इसलिए सो गया।
conjunctions|She was sad ___ she lost her keys.|because|so;but;or|वह उदास थी क्योंकि उसकी चाबियाँ खो गईं।
conjunctions|I like tea, ___ my brother prefers coffee.|but|and;so;or|मुझे चाय पसंद है, पर मेरे भाई को कॉफ़ी।
conjunctions|Would you like tea ___ coffee?|or|and;but;so|तुम चाय या कॉफ़ी लेना चाहोगे?
conjunctions|He studied hard, ___ he passed the exam.|so|because;although;or|उसने कड़ी मेहनत की, इसलिए परीक्षा पास हुई।
conjunctions|___ it was raining, we went out.|Although|Because;So;And|बारिश हो रही थी, फिर भी हम बाहर गए।
conjunctions|She can sing ___ dance.|and|but;or;so|वह गा भी सकती है और नाच भी।
conjunctions|I waited, ___ he never came.|but|so;because;and|मैंने इंतज़ार किया, पर वह कभी नहीं आया।

conditionals|If it ___ tomorrow, we will stay home.|rains|rain;rained;will rain|अगर कल बारिश होगी, हम घर रहेंगे।
conditionals|If it rains tomorrow, we ___ stay home.|will|would;did;are|अगर कल बारिश होगी, हम घर रहेंगे।
conditionals|If I ___ you, I would take the job.|were|am;was;will be|अगर मैं तुम्हारी जगह होता, नौकरी ले लेता।
conditionals|If I had studied, I ___ passed the exam.|would have|will have;would;had|अगर मैंने पढ़ाई की होती, परीक्षा पास कर लेता।
conditionals|If she ___ earlier, she would have caught the train.|had left|left;has left;leaves|अगर वह जल्दी निकली होती, ट्रेन पकड़ लेती।
conditionals|I would buy a house if I ___ enough money.|had|have;has;will have|अगर मेरे पास काफ़ी पैसे होते, मैं घर खरीदता।
conditionals|She will call you if she ___ any news.|gets|get;got;will get|अगर उसे कोई ख़बर मिलेगी, वह तुम्हें फ़ोन करेगी।

passive|The letter ___ by Tom yesterday.|was written|wrote;is written;has written|पत्र कल टॉम द्वारा लिखा गया था।
passive|English ___ all over the world.|is spoken|speaks;spoke;is speaking|अंग्रेज़ी पूरी दुनिया में बोली जाती है।
passive|The house ___ last year.|was built|built;is building;has built|घर पिछले साल बनाया गया था।
passive|These cakes ___ fresh every morning.|are baked|bake;baked;are baking|ये केक हर सुबह ताज़े बनाए जाते हैं।
passive|The window ___ by the storm.|was broken|broke;is breaking;has broken|खिड़की तूफ़ान से टूट गई थी।
passive|The results ___ tomorrow.|will be announced|will announce;announce;announced|नतीजे कल घोषित किए जाएँगे।
passive|The thief ___ by the police last night.|was caught|caught;is caught;has caught|चोर कल रात पुलिस द्वारा पकड़ा गया।

reported-speech|He said that he ___ tired.|was|is;will be;be|उसने कहा कि वह थका था।
reported-speech|She said she ___ call me later.|would|will;would have;did|उसने कहा कि वह बाद में फ़ोन करेगी।
reported-speech|They told us they ___ finished the work.|had|have;has;were|उन्होंने हमें बताया कि उन्होंने काम पूरा कर लिया था।
reported-speech|He asked me ___ I was busy.|if|that;what;when|उसने मुझसे पूछा कि क्या मैं व्यस्त था।
reported-speech|She said she ___ to the party the day before.|had gone|went;has gone;goes|उसने कहा कि वह पिछले दिन पार्टी गई थी।
reported-speech|He told me he ___ a doctor.|was|is;will be;be|उसने मुझे बताया कि वह डॉक्टर था।

relative-clauses|The woman ___ lives next door is a doctor.|who|which;whose;whom|अगले घर में रहने वाली महिला डॉक्टर है।
relative-clauses|This is the phone ___ I bought yesterday.|that|who;whose;whom|यह वह फ़ोन है जो मैंने कल ख़रीदा।
relative-clauses|The dog ___ bit me ran away.|that|who;whose;whom|जिस कुत्ते ने मुझे काटा वह भाग गया।
relative-clauses|I know a man ___ son plays cricket.|whose|who;which;whom|मैं एक आदमी को जानता हूँ जिसका बेटा क्रिकेट खेलता है।
relative-clauses|The house ___ we visited was beautiful.|which|who;whose;whom|जिस घर में हम गए थे वह सुंदर था।
relative-clauses|The film ___ we watched was boring.|that|who;whose;whom|जो फ़िल्म हमने देखी वह उबाऊ थी।

adverbs-frequency|I ___ wake up early.|always|never;rarely;ever|मैं हमेशा जल्दी उठता हूँ।
adverbs-frequency|She ___ drinks coffee at night.|never|always;often;usually|वह रात में कभी कॉफ़ी नहीं पीती।
adverbs-frequency|We ___ go to the gym twice a week.|usually|never;rarely;seldom|हम आमतौर पर हफ़्ते में दो बार जिम जाते हैं।
adverbs-frequency|He is ___ late for work.|often|ever;never;rarely|वह अक्सर काम पर देर करता है।
adverbs-frequency|I ___ eat meat, I am vegetarian.|never|always;often;usually|मैं कभी मांस नहीं खाता, मैं शाकाहारी हूँ।
adverbs-frequency|They ___ visit us on Sundays.|sometimes|never;always;rarely|वे कभी-कभी रविवार को हमसे मिलने आते हैं।

imperatives|___ the door, please.|Close|Closes;Closing;Closed|कृपया दरवाज़ा बंद करें।
imperatives|___ down and relax.|Sit|Sits;Sitting;Sat|बैठ जाओ और आराम करो।
imperatives|___ smoke here.|Don't|Doesn't;Not;No|यहाँ धूम्रपान न करें।
imperatives|___ your books to page ten.|Open|Opens;Opening;Opened|अपनी किताबें दसवें पन्ने पर खोलें।
imperatives|Please ___ quiet in the library.|be|is;are;being|कृपया पुस्तकालय में चुप रहें।
imperatives|___ left at the traffic light.|Turn|Turns;Turning;Turned|ट्रैफ़िक लाइट पर बाएँ मुड़ें।
imperatives|___ forget to lock the door.|Don't|Doesn't;No;Not|दरवाज़ा बंद करना मत भूलो।

wish|I ___ I could fly.|wish|hope;want;wished|काश मैं उड़ सकता।
wish|She ___ she had more free time.|wishes|wish;hopes;wanted|काश उसके पास ज़्यादा खाली समय होता।
wish|I ___ I had studied harder.|wish|wished;hope;want|काश मैंने ज़्यादा मेहनत से पढ़ाई की होती।
wish|He ___ he were taller.|wishes|wish;hopes;wanted|काश वह लंबा होता।
wish|We ___ we could stay longer.|wish|wishes;hoped;want|काश हम और ज़्यादा रुक सकते।
wish|I ___ you good luck!|wish|wishes;hope;want|मैं तुम्हें शुभकामनाएँ देता हूँ!
"""

    private fun cat(id: String, title: String, emoji: String, group: String, blurb: String, vararg keys: String) =
        DrillCategory(id, title, emoji, group, blurb, keys.toList())

    val categories: List<DrillCategory> = listOf(
        cat("be", "am / is / are — the verb 'to be'", "🟢", "Tenses", "The present forms of 'be'", "am / is / are", "verb 'to be'", "verb 'be'"),
        cat("be-past", "was / were — past of 'be'", "🟢", "Tenses", "Talking about the past with 'be'", "was / were"),
        cat("present-simple", "Present simple", "🔁", "Tenses", "Habits, facts and routines", "present simple"),
        cat("present-continuous", "Present continuous", "⏳", "Tenses", "Happening right now", "present continuous"),
        cat("past-simple", "Past simple", "⏪", "Tenses", "Finished actions in the past", "past simple"),
        cat("past-continuous", "Past continuous", "⏪", "Tenses", "Actions in progress in the past", "past continuous"),
        cat("present-perfect", "Present perfect", "✅", "Tenses", "have / has + past participle", "present perfect"),
        cat("present-perfect-continuous", "Present perfect continuous", "✅", "Tenses", "have been doing — how long", "present perfect continuous"),
        cat("past-perfect", "Past perfect", "⏮️", "Tenses", "The past of the past — had + V3", "past perfect"),
        cat("past-perfect-continuous", "Past perfect continuous", "⏮️", "Tenses", "had been doing — duration before a past event", "past perfect continuous"),
        cat("future-will", "will — future", "🔮", "Tenses", "Predictions, promises and decisions", "future simple", "will —", "future predictions", "will vs going to"),
        cat("going-to", "going to — plans", "🔮", "Tenses", "Plans and intentions", "going to"),
        cat("future-continuous", "Future continuous", "🔮", "Tenses", "will be doing", "future continuous"),
        cat("future-perfect", "Future perfect", "🔮", "Tenses", "will have done", "future perfect"),
        cat("future-perfect-continuous", "Future perfect continuous", "🔮", "Tenses", "will have been doing", "future perfect continuous"),

        cat("have-has", "have / has", "🤲", "Verbs & modals", "Possession and ownership", "have / has"),
        cat("do-does-did", "do / does / did", "🔧", "Verbs & modals", "The helper verb", "do / does / did", "do / does"),
        cat("can-could", "can / could", "💪", "Verbs & modals", "Ability and permission", "can / could", "can / can't"),
        cat("modals-deduction", "must / might / can't — deduction", "🤔", "Verbs & modals", "Guessing how sure you are", "may / might"),
        cat("must-have-to", "must / have to", "❗", "Verbs & modals", "Obligation and rules", "must / have to"),
        cat("should", "should — advice", "💡", "Verbs & modals", "Giving advice", "should —", "should"),
        cat("would", "would", "🙏", "Verbs & modals", "Polite requests and past habits", "would —"),
        cat("used-to", "used to", "🕰️", "Verbs & modals", "Past habits that stopped", "used to"),
        cat("gerund-infinitive", "gerund vs infinitive", "🧩", "Verbs & modals", "-ing or to + verb?", "-ing vs to", "gerund"),

        cat("articles", "a / an / the", "📰", "Nouns & pronouns", "Articles", "a / an / the", "articles"),
        cat("plurals", "plurals", "🔢", "Nouns & pronouns", "One apple, two apples", "-s plural", "plurals"),
        cat("this-that", "this / that / these / those", "👉", "Nouns & pronouns", "Near and far", "this / that"),
        cat("there-is-are", "there is / there are", "📍", "Nouns & pronouns", "Saying something exists", "there is"),
        cat("pronouns", "pronouns", "🙋", "Nouns & pronouns", "I, me, she, him, they…", "pronoun"),
        cat("possessives", "possessives", "🔑", "Nouns & pronouns", "my, your, his, her, mine…", "possessive"),
        cat("much-many", "much / many", "⚖️", "Nouns & pronouns", "How much or how many", "much / many"),
        cat("some-any", "some / any", "🥛", "Nouns & pronouns", "A few, or none", "some / any"),

        cat("prep-place", "prepositions of place", "📦", "Prepositions", "in, on, at, under, above…", "prepositions of place", "in / on / at"),
        cat("prep-time", "prepositions of time", "⏰", "Prepositions", "at, on, in, for, since", "prepositions of time"),
        cat("prep-movement", "prepositions of movement", "🚶", "Prepositions", "to, into, through, across…", "prepositions of movement"),
        cat("prep-dependent", "dependent prepositions", "🔗", "Prepositions", "good at, depend on, afraid of…", "dependent prepositions", "complex prepositions"),

        cat("comparatives", "comparatives", "📈", "Sentences & style", "-er / more than", "comparatives & superlatives", "comparative"),
        cat("superlatives", "superlatives", "🏆", "Sentences & style", "the -est / most", "superlative"),
        cat("wh-questions", "wh-questions", "❓", "Sentences & style", "what, who, where, when, why, how", "wh-question", "question words"),
        cat("conjunctions", "conjunctions", "🪢", "Sentences & style", "and, but, because, so, although", "conjunction"),
        cat("conditionals", "conditionals", "🔀", "Sentences & style", "if… then…", "conditional", "imaginary situations"),
        cat("passive", "passive voice", "🔄", "Sentences & style", "is done / was done", "passive"),
        cat("reported-speech", "reported speech", "🗣️", "Sentences & style", "he said that…", "reported speech"),
        cat("relative-clauses", "relative clauses", "🔎", "Sentences & style", "who, which, that, whose", "relative clause"),
        cat("adverbs-frequency", "adverbs of frequency", "📊", "Sentences & style", "always, often, never…", "adverb"),
        cat("imperatives", "imperatives", "☝️", "Sentences & style", "Commands and requests", "imperative"),
        cat("wish", "wish / if only", "🌠", "Sentences & style", "Regrets and desires", "wish")
    )

    private val parsed: List<Drill> by lazy { parse(RAW) }
    private val byCat: Map<String, List<Drill>> by lazy { parsed.groupBy { it.category } }

    fun forCategory(id: String): List<Drill> = byCat[id].orEmpty()
    fun count(id: String): Int = byCat[id]?.size ?: 0
    fun category(id: String): DrillCategory? = categories.firstOrNull { it.id == id }

    /** The drill set that matches a grammar [p], or null when none is close enough. */
    fun categoryForPattern(p: Pattern): DrillCategory? {
        val title = p.titleEn.lowercase()
        return categories
            .mapNotNull { c ->
                val key = c.matchKeys.filter { title.contains(it) }.maxByOrNull { it.length }
                if (key == null) null else c to key
            }
            .maxByOrNull { it.second.length }
            ?.first
    }

    private fun parse(raw: String): List<Drill> = raw.trim().lineSequence()
        .map { it.trim() }
        .filter { it.isNotEmpty() && !it.startsWith("#") }
        .mapNotNull { line ->
            val c = line.split("|")
            if (c.size < 4) return@mapNotNull null
            val cat = c[0].trim()
            val sentence = c[1].trim()
            val answer = c[2].trim()
            val wrong = c[3].split(";").map { it.trim() }.filter { it.isNotEmpty() }
            if (cat.isEmpty() || !sentence.contains("___") || answer.isEmpty() || wrong.isEmpty()) {
                return@mapNotNull null
            }
            Drill(cat, sentence, answer, wrong, c.getOrElse(4) { "" }.trim())
        }.toList()
}

private enum class DrillMode { FILL, MEANING }

/**
 * The Practice tab: every drill category, grouped, with the number of questions
 * in each. Non-scrolling — the caller supplies the scroll container.
 */
@Composable
fun PracticeHub(
    store: Store,
    speaker: Speaker,
    modifier: Modifier = Modifier,
    onOpen: (DrillCategory) -> Unit
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            "Practice",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            "Pick a topic and drill it. Every option is a near-identical sentence, so you really have to know the rule.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(14.dp))
        Practice.categories.map { it.group }.distinct().forEach { group ->
            val cats = Practice.categories.filter { it.group == group && Practice.count(it.id) > 0 }
            if (cats.isEmpty()) return@forEach
            Text(
                group,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(6.dp))
            cats.forEach { c ->
                DrillCategoryCard(c, onClick = { onOpen(c) })
                Spacer(Modifier.height(8.dp))
            }
            Spacer(Modifier.height(8.dp))
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun DrillCategoryCard(c: DrillCategory, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(c.emoji, fontSize = 24.sp)
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(c.title, fontWeight = FontWeight.Bold)
                if (c.blurb.isNotBlank()) {
                    Text(
                        c.blurb,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Text(
                "${Practice.count(c.id)}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * A multiple-choice drill session for one [category].
 *
 * Two modes, both built from the same minimal-pair options:
 *  - [DrillMode.FILL] shows the sentence with a gap ("I ___ a boy") plus the
 *    native translation, and the learner picks the word that fits.
 *  - [DrillMode.MEANING] shows only the native translation and the learner picks
 *    the matching sentence ("I am a boy" vs "I was a boy" vs "I have a boy").
 */
@Composable
fun DrillSession(
    category: DrillCategory,
    store: Store,
    speaker: Speaker,
    modifier: Modifier = Modifier,
    questionLimit: Int = 10,
    onClose: () -> Unit
) {
    BackHandler(onBack = onClose)
    val native = store.nativeLang
    val pool = remember(category.id) { Practice.forCategory(category.id) }
    var round by remember(category.id) { mutableStateOf(0) }
    val questions = remember(category.id, native, round) { pool.shuffled().take(questionLimit) }
    var qi by remember(category.id, native, round) { mutableStateOf(0) }
    var score by remember(category.id, native, round) { mutableStateOf(0) }
    var picked by remember(category.id, native, round) { mutableStateOf<String?>(null) }
    var mode by remember(category.id) { mutableStateOf(DrillMode.FILL) }

    Column(
        modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column {
                Text("Practice", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(
                    "${category.emoji} ${category.title}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            FilterChip(
                selected = mode == DrillMode.FILL,
                onClick = { mode = DrillMode.FILL; picked = null },
                label = { Text("Fill the gap") }
            )
            Spacer(Modifier.width(8.dp))
            FilterChip(
                selected = mode == DrillMode.MEANING,
                onClick = { mode = DrillMode.MEANING; picked = null },
                label = { Text("Choose the sentence") }
            )
        }
        Spacer(Modifier.height(8.dp))

        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            if (questions.isEmpty()) {
                Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                    Text(
                        "This topic has no drills yet.",
                        modifier = Modifier.padding(18.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.height(12.dp))
                OutlinedButton(onClick = onClose, modifier = Modifier.fillMaxWidth()) {
                    Text("Go back")
                }
                Spacer(Modifier.height(24.dp))
                return@Column
            }

            if (qi >= questions.size) {
                val perfect = score == questions.size
                Card(
                    Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (perfect) MaterialTheme.colorScheme.tertiaryContainer
                        else MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(Modifier.fillMaxWidth().padding(22.dp)) {
                        Text(
                            if (perfect) "Perfect score! 🎉" else "Nice work!",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            "You got $score out of ${questions.size} correct.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(Modifier.height(14.dp))
                Button(
                    onClick = { round += 1; picked = null },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Practise again")
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = onClose, modifier = Modifier.fillMaxWidth()) {
                    Text("Back to topics")
                }
                Spacer(Modifier.height(24.dp))
                return@Column
            }

            val q = questions[qi]
            val tr = q.translation(native)
            val prompt = if (mode == DrillMode.FILL) q.sentence else tr.ifBlank { q.sentence }
            val choices = if (mode == DrillMode.FILL) q.options() else q.options().map { q.filledWith(it) }
            val correct = if (mode == DrillMode.FILL) q.answer else q.full()

            Text(
                "Question ${qi + 1} of ${questions.size}",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                "Score: $score",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))

            Card(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text(
                        if (mode == DrillMode.FILL) "Fill in the blank:" else "Choose the sentence that means:",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(prompt, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    if (mode == DrillMode.FILL && tr.isNotBlank()) {
                        Spacer(Modifier.height(8.dp))
                        Text(
                            tr,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            Spacer(Modifier.height(14.dp))

            val revealed = picked != null
            choices.forEach { opt ->
                val isAnswer = opt == correct
                val bg = when {
                    !revealed -> MaterialTheme.colorScheme.surfaceVariant
                    isAnswer -> MaterialTheme.colorScheme.tertiaryContainer
                    opt == picked -> MaterialTheme.colorScheme.errorContainer
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable(enabled = !revealed) {
                            picked = opt
                            if (isAnswer) score += 1
                        },
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = bg)
                ) {
                    Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(opt, modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
                        if (revealed && isAnswer) {
                            Text("✓", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                        } else if (revealed && opt == picked) {
                            Text("✗", color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(Modifier.height(10.dp))
            if (revealed) {
                if (mode == DrillMode.MEANING && tr.isNotBlank()) {
                    Text(
                        tr,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(10.dp))
                }
                FilledIconButton(onClick = { speak(store, speaker, q.full(), true) }) {
                    Icon(Icons.Filled.VolumeUp, contentDescription = "Hear")
                }
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {
                        if (qi < questions.size - 1) {
                            qi += 1
                            picked = null
                        } else {
                            qi = questions.size
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (qi < questions.size - 1) "Next question" else "See results")
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
