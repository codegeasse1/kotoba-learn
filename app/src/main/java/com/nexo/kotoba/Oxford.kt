package com.nexo.kotoba

object Oxford {
    private var oid = 0
    private fun ow(raw: String): List<Word> = raw.trim().lineSequence()
        .filter { it.isNotBlank() }
        .map { line ->
            val l = line.trim()
            val c = l.split("|")
            Word("o${oid++}", "•", "", "", "", c[0], c.getOrElse(1) { "" }, c.getOrElse(2) { "" })
        }.toList()

    val lessons: List<Lesson> = listOf(

        Lesson("ox-a1", "🐣 Oxford 5000 · A1", "🐣", "821 official Oxford words", ow("""
a|indefinite article|एक
about|adverb|के बारे में
above|adverb|ऊपर
across|adverb|पार
action|noun|कार्य
activity|noun|गतिविधि
actor|noun|कर्ता; अभिनेता; कलाकार
actress|noun|अभिनेत्री
add|verb|जोड़ना
address|noun|पता
advice|noun|सलाह
afraid|adjective|डरा हुआ
afternoon|noun|दोपहर
again|adverb|फिर
age|noun|उम्र
ago|adverb|पहले
agree|verb|सहमत होना
air|noun|हवा
airport|noun|हवाई अड्डा
also|adverb|भी
always|adverb|हमेशा
amazing|adjective|चमत्कार; आश्चर्यजनक; विस्मयकारी
and|conjunction|और
angry|adjective|गुस्सा
animal|noun|जानवर
another|determiner|भिन्न; दूसरा; एक अन्य
answer|noun|जवाब
anyone|pronoun|किसी को; कोई भी; कोई
anything|pronoun|कुछ; कुछ भी
apartment|noun|अपार्टमेंट
apple|noun|सेब
April|noun|अप्रेल माह; अप्रैल
area|noun|क्षेत्र
arm|noun|बाँह
around|adverb|आस पास; लगभग; तक
arrive|verb|पहुँचना
art|noun|कला
article|noun|सामान; वस्तु; दफ़ा/धारा
artist|noun|कलाकार; कलाकार/चित्रकार; फ़नकार
ask|verb|पूछना
at|preposition|पर
August|noun|महत्वपूर्ण; अगस्त; गरिमापूर्ण
aunt|noun|चाची
autumn|noun|पतझड़
away|adverb|दूर
baby|noun|शिशु
bad|adjective|बुरा
bag|noun|थैला
ball|noun|गेंद
banana|noun|केला
band|noun|जत्था; दल; संघ
bank|noun|बैंक
bath|noun|स्नान
bathroom|noun|स्नानघर
be|verb|होना
beach|noun|समुद्र तट
beautiful|adjective|सुंदर
because|conjunction|क्योंकि
become|verb|बनना
bed|noun|बिस्तर
bedroom|noun|शयन कक्ष
beer|noun|शराब; बियर{एक प्रकार की मदिरा}; बियर
begin|verb|शुरू करना
beginning|noun|शुरुआत
behind|adverb|पीछे
believe|verb|विश्वास करना
below|adverb|नीचे
best|adjective|सर्वश्रेष्ठ
better|adjective|बेहतर
bicycle|noun|साइकिल; साइकिल चलाना
big|adjective|बड़ा
bike|noun|साइकिल
bill|noun|घोषित; घोषित करना; बिल
bird|noun|पक्षी
birthday|noun|जन्मदिन
black|adjective|काला
blog|noun|चिट्ठा; ब्लौग
blonde|adjective|सुनहरे बालों; सुनहरा भूरा; गोरे शरीर व नीली आँख वाली स्त्री
blue|adjective|नीला
boat|noun|नाव
body|noun|शरीर
book|noun|किताब
boot|noun|टटोलना; लाभ; मदद
bored|adjective|ऊबा हुआ; जी उबनेवाला
boring|adjective|उबाऊ; उबाऊ/नीरस; कुपछेदन
born|verb|उपजना; जन्म लेना; जन्मजात
both|determiner|दोनों
bottle|noun|बोतल
box|noun|डिब्बा
boy|noun|लड़का
boyfriend|noun|सनम; प्रेमी; पुरूष मित्र
bread|noun|रोटी
break|noun|तोड़ना
breakfast|noun|नाश्ता
bring|verb|लाना
brother|noun|भाई
brown|adjective|भूरा
build|verb|बनाना
building|noun|इमारत
bus|noun|बस
business|noun|व्यापार
busy|adjective|व्यस्त
but|conjunction|लेकिन
butter|noun|मक्खन
buy|verb|खरीदना
bye|exclamation|अलविदा; शुभ विदाई; बाईई
cafe|noun|कहवाघर; कैफ़े
cake|noun|केक
call|noun|बुलाना
camera|noun|कैमरा
cannot|modal verb|
capital|adjective|उत्कृष्ठ; शिखर; प्रमुख
car|noun|कार
card|noun|कार्ड
career|noun|जीवन; वेग; विकास
carrot|noun|गाजर; प्रलोभन
carry|verb|ले जाना
cat|noun|बिल्ली
CD|noun|सी डी; सी डीई; सी
cent|noun|शत; सिक्का
centre|noun|जड़; लगाना; ठीक करना
century|noun|शताब्दी; शैली; सौ गज की दौड़
chair|noun|कुर्सी
change|noun|बदलना
chart|noun|तालिका; स्थिति अंकित करना; स्थिति अंकित
cheap|adjective|सस्ता
cheese|noun|पनीर
chicken|noun|मुर्गी
child|noun|बच्चा
chocolate|noun|चॉकलेट
choose|verb|चुनना
cinema|noun|चलचित्र; सिनेमा; सिनेमाघर
city|noun|शहर
class|noun|कक्षा
classroom|noun|कक्षा
clean|adjective|साफ
clock|noun|घड़ी
clothes|noun|कपड़े
club|noun|मिलना; संघ; एकट्र करना
coat|noun|परत; लगाना; खराब
coffee|noun|कॉफी
cold|adjective|ठंडा
college|noun|कॉलेज
colour|noun|रंगीन; दिखावा; बहाना
come|verb|आना
common|adjective|सामान्य
company|noun|कंपनी
compare|verb|वर्णन करना; तुलना करना; विचार विनिमय करना
complete|adjective|पूरा
computer|noun|कंप्यूटर
concert|noun|तालमेल; संगीत गोष्ठी; संगीत
conversation|noun|बातचीत; नाजायज़; नाजायज़ ताल्लुकात
cooking|noun|खाना; पाकविधि; पकाने योग्य
cool|adjective|ठंडा
correct|adjective|सही
cost|noun|कीमत
could|modal verb|सकना; सका/कर सकता; {प्रश्नवाचक}क्या
country|noun|देश
course|noun|पाठ्यक्रम
cousin|noun|चचेरा भाई
cow|noun|गाय
create|verb|बनाना
culture|noun|समूह; संवर्धन; शिष्टता
cup|noun|प्याला
customer|noun|ग्राहक; असामी; खरीदनेवाला
dad|noun|पिता; पापा; पिता/बाप
dance|noun|नाचना
dancer|noun|नर्तक; नर्तकी
dancing|noun|नृत्य
dangerous|adjective|घमासान; खतरनाक; डरावना
dark|adjective|अंधेरा
date|noun|तारीख
daughter|noun|बेटी
day|noun|दिन
dear|adjective|प्रिय
December|noun|दिसम्बर
decide|verb|निर्णय लेना
delicious|adjective|स्वादिष्ट
describe|verb|वर्णन करना
description|noun|प्रकार; विवरण; कहानी
design|noun|नमूना; बनावट; योजना बनाना
desk|noun|मेज़
detail|noun|जानकारी; विस्तार; नियुक्त करना
dialogue|noun|विचार; बातचीत; संवाद
dictionary|noun|शब्दकोष
die|verb|मरना
diet|noun|अल्पाहार; भोजन; आहार
difference|noun|झगड़ा; शेष; असमानता
different|adjective|अलग
difficult|adjective|कठिन
dinner|noun|रात का खाना
dirty|adjective|गंदा
discuss|verb|विचार करना; विचार; बहस करना
dish|noun|भोजन; सुन्दर लड़की; परोसना
do|verb|करना
doctor|noun|डॉक्टर
dog|noun|कुत्ता
dollar|noun|अमरीकी; डौलर; अमरीकी मुद्रा
door|noun|दरवाज़ा
down|adverb|नीचे
draw|verb|चित्र बनाना
dress|noun|पोशाक
drink|noun|पीना
driver|noun|चालक/गाड़ीवान/कोचवान; चालक; वाहनचालक
during|preposition|के दौरान
DVD|noun|डी वी डी
each|adverb|प्रत्येक
ear|noun|कान
early|adjective|जल्दी
east|adjective|पूर्व
easy|adjective|आसान
eat|verb|खाना
egg|noun|अंडा
eight|number|आठ
eighteen|number|अठारह
eighty|number|अस्सी
elephant|noun|हाथी
eleven|number|ग्यारह
else|adverb|और
email|noun|विपत्र; इमेल
end|noun|अंत
enjoy|verb|आनंद लेना
enough|adverb|पर्याप्त
euro|noun|यूरो
evening|noun|शाम
event|noun|घटना; वारदात; प्रतियोगिता
ever|adverb|कभी
every|determiner|हर
everybody|pronoun|सभ लोग; प्रत्येक व्यक्ति; हर कोई
everyone|pronoun|हर कोई
everything|pronoun|सब कुछ
exam|noun|परीक्षा
example|noun|उदाहरण
excited|adjective|उत्तेजित; उतेजित; उद्दीप्त
exciting|adjective|रोमांचक
exercise|noun|व्यायाम
expensive|adjective|महंगा
explain|verb|बताना; विवरण देना; व्यक्त
extra|adjective|अधिक; अतिरिक्त; अतिरिक्त वस्तु
eye|noun|आँख
face|noun|चेहरा
fact|noun|तथ्य
false|adjective|विश्वासघाती; मिथ्या; बेवफ़ा
family|adjective|परिवार
famous|adjective|उत्कृष्ट; जाना; विख्यात
fantastic|adjective|बहुत अच्छा; शानदार; अत्यधिक
farm|noun|खेत
farmer|noun|किसान
fast|adjective|तेज़
fat|adjective|मोटा
father|noun|पिता
favourite|adjective|प्रिय व्यक्ति; प्रिय; कृपापाट्र
February|noun|फरवरी माह; फ़रवरी
feeling|noun|भावना
festival|noun|समारोह; त्योहार; त्यौहार/उत्सव
few|adjective|अल्प; थोड़ा; कई
fifteen|number|पंद्रह
fifth|ordinal number|पंचमांग; पंचम स्वर; पंचम
fifty|number|पचास
fill|verb|भरना
film|noun|फ़िल्म
final|adjective|अंतिम; अन्तिम; अंतिम चरण
find|verb|ढूँढना
fine|adjective|ठीक
fire|noun|आग
first|adverb|पहला
fish|noun|मछली
five|number|पाँच
flight|noun|उड़ान; पलायन; कल्पना की उड़ान
floor|noun|फर्श
flower|noun|फूल
follow|verb|पीछा करना
food|noun|खाना
foot|noun|पैर
football|noun|फुटबॉल
for|preposition|के लिए
forget|verb|भूलना
form|noun|दर्जा; प्रकार; विचार करना
forty|number|चालीस
four|number|चार
fourteen|number|चौदह
fourth|ordinal number|चौथा
free|adjective|मुक्त
Friday|noun|शुक्रवार
friend|noun|दोस्त
friendly|adjective|सहायक; अनुकूल; मित्रवत
from|preposition|से
front|adjective|सामने
fruit|noun|फल
full|adjective|भरा
funny|adjective|मज़ेदार
game|noun|खेल
garden|noun|बगीचा
geography|noun|भूगोल
get|verb|पाना
girl|noun|लड़की
girlfriend|noun|संगिनी; सखी; सहेली
give|verb|देना
glass|noun|गिलास
good|adjective|अच्छा
goodbye|exclamation|अलविदा; शुभ विदाई
grandfather|noun|दादा
grandmother|noun|दादी
grandparent|noun|दादा दादी; नाना नानी
great|adjective|महान
green|adjective|हरा
grey|adjective|नीरस; भूरा; दुःखी
group|noun|समूह
grow|verb|उगना
guess|noun|अनुमान लगाना
guitar|noun|गिटार; गिटार{वाद्य यंत्र)
gym|noun|व्यायामशाला
hair|noun|बाल
hand|noun|हाथ
happen|verb|घटित होना
happy|adjective|खुश
hard|adjective|कठिन
hat|noun|टोपी
have|verb|रखना
have to|modal verb|अकेले भोग करना; संबन्ध रखना
he|pronoun|वह
head|noun|सिर
health|noun|स्वास्थ्य
healthy|adjective|स्वस्थ; स्वस्त; स्वस्थ्यवऋद्धक
hear|verb|सुनना
hello|exclamation|नमस्ते
help|noun|मदद
her|determiner|उसका
here|adverb|यहाँ
hey|exclamation|अरे/ए; ए!
hi|exclamation|हइ
high|adjective|ऊँचा
him|pronoun|उसे
his|determiner|उसका
history|noun|इतिहास
hobby|noun|अभिरुचि; शौक; दोलन घोड़ा
holiday|noun|छुट्टी
homework|noun|गृहकार्य
horse|noun|घोड़ा
hospital|noun|अस्पताल
hot|adjective|गर्म
hotel|noun|होटल
hour|noun|घंटा
house|noun|घर
how|adverb|कैसे
however|adverb|फिर भी; तब भी; जैसे भी
hundred|number|सौ
hungry|adjective|भूखा
husband|noun|पति
I|pronoun|मैं
ice|noun|बर्फ
ice cream|noun|मलाई बर्फ
idea|noun|विचार
if|conjunction|अगर
imagine|verb|विचार करना; कल्पना करना; सोचना
important|adjective|महत्वपूर्ण
improve|verb|बेहतर बनाना; सुधरना; सुधारना
in|adverb|में
include|verb|दर्ज़ करना; शामिल होना; मिलाना
information|noun|जानकारी
interest|noun|रुचि
interested|adjective|रुचि रखनेवाला; रुचि; संबद्ध
interesting|adjective|दिलचस्प
internet|noun|इंटरनेट; अन्तरजाल; अंतर्जाल/अन्तर्जाल
interview|noun|इंटरव्यू लेना; बातचीत; साक्षात्कार
into|preposition|में
introduce|verb|लगाना; प्रस्तुत करना; पेश करना
island|noun|द्वीप
its|determiner|इसका
jacket|noun|जैकेट; धातु; दंत टोप
January|noun|जनवरी
jeans|noun|सूती कपड़ा
job|noun|नौकरी
join|verb|शामिल होना
journey|noun|प्रवास; प्रवास करना; यात्रा
juice|noun|शक्ति; रस; गपशप
July|noun|जुलाई
June|noun|जून; जून{साल का छटा महीना}; जूनअ
keep|verb|रखना
key|adjective|चाबी
kilometre|noun|किलोमीटर
kitchen|noun|रसोई
know|verb|जानना
land|noun|ज़मीन
language|noun|भाषा
large|adjective|बड़ा
late|adjective|देर
laugh|noun|हँसना
learn|verb|सीखना
left|adjective|बायाँ
leg|noun|पैर
lesson|noun|पाठ
let|verb|देना
letter|noun|पत्र
library|noun|पुस्तकालय
life|noun|जीवन
light|adjective|रोशनी
line|noun|रेखा
lion|noun|शेर
list|noun|किनारा; मेंड़; झुकना
listen|verb|सुनना
little|adjective|छोटा
local|adjective|स्थानीय निवासी; सीमित; स्थानिक
long|adjective|लंबा
lose|verb|खोना
lot|adverb|बहुत
love|noun|प्यार
lunch|noun|दोपहर का खाना
machine|noun|मशीन
magazine|noun|पत्रिका
main|adjective|प्रमुख; कुलमिलाकर; मुख्य
man|noun|आदमी
many|determiner|कई
map|noun|नक्शा
March|noun|प्रयाण गीत; चलना; सीमा प्रान्त
market|noun|बाज़ार
married|adjective|विवाहित; ब्याहता
match|noun|मिलना; जोड़िदार; जोड़ा बन्ना
May|noun|लेना; सम्भवतः; संभवतः
maybe|adverb|शायद
me|pronoun|मुझे
meal|noun|भोजन
mean|verb|मतलब
meaning|noun|उद्देश्य; अर्थपूर्ण; मतलब
meat|noun|मांस
meet|verb|मिलना
meeting|noun|बैठक
member|noun|सदस्य
menu|noun|मेनू/आहारिका; मेन्यू; व्यंजन सूची
message|noun|संदेश
metre|noun|छंद; माप; मीटर
midnight|noun|मध्यरात्री; आधी रात; अर्द्धरात्री
mile|noun|समुद्री मील; मील; समुद्री
milk|noun|दूध
million|number|असंख्य; बेहिसाब; दस
miss|verb|चूकना
mistake|noun|गलती
model|noun|नमूना; मडल; तैयार करना
modern|adjective|आधुनिक; नया; वर्तमान
moment|noun|महत्व; क्षण; पल
Monday|noun|सोमवार
money|noun|पैसा
month|noun|महीना
more|adverb|अधिक
morning|noun|सुबह
most|adverb|सबसे अधिक
mother|noun|माँ
mountain|noun|पहाड़
mouse|noun|चुहिया मारना; चोट पहुँचाने; चोरी छिपे जाना
mouth|noun|मुँह
movie|noun|फ़िल्म
much|adverb|बहुत
mum|noun|शांत; माता
museum|noun|संग्रहालय; अजायबघर
music|noun|संगीत
must|modal verb|चाहिए
my|determiner|मेरा
name|noun|नाम
natural|adjective|सहज; स्वाभाविक; प्राकृतिक
near|adjective|पास
negative|adjective|निगेटिव{फोटो का}; प्रतिकूल; रृणात्मक
neighbour|noun|पड़ोसी
never|adverb|कभी नहीं
new|adjective|नया
news|noun|समाचार
newspaper|noun|कला और विज्ञापन; विज्ञापन; कागज़
next|adjective|अगला
next to|preposition|लगभग; के बाद; के सामने
nice|adjective|अच्छा
night|noun|रात
nine|number|नौ
nineteen|number|उन्नीस
ninety|number|नब्बे
no|determiner|नहीं
no one|pronoun|कोई भी नहीं; कोई व्यक्ति नहीं; कोई नहीं
nobody|pronoun|मामूली आदमी; मामूली; कोईनहीं
north|adjective|उत्तर
nose|noun|नाक
not|adverb|नहीं
note|noun|ध्यान; कीर्ति; ध्यान देना
nothing|pronoun|कुछ नहीं
November|noun|नवम्बर; नवंबरअ
now|adverb|अब
number|noun|संख्या
nurse|noun|नर्स
o'clock|adverb|बजे
object|noun|पिण्ड; विरोध करना; आपत्ति
October|noun|अक्तूबर; अक्तुबर
of|preposition|के बारे में; से; का
off|adverb|उदास; रूखा; दूर
office|noun|कार्यालय
often|adverb|अक्सर
oh|exclamation|आह; ओह
OK|adjective|ठीक
old|adjective|पुराना
on|adverb|पर
once|adverb|एक बार
one|determiner|एक
onion|noun|प्याज का पौधा; प्याज़; कांदा
online|adjective|ऑन लाइन; ऑनलाइन
only|adjective|केवल
open|adjective|खोलना
opinion|noun|विचार; मत; अनुमान
opposite|adjective|उल्टा; के सामने; विरोधी
or|conjunction|अन्यथा; या/अथवा; या
orange|adjective|संतरा
order|noun|आदेश
other|adjective|अन्य
our|determiner|हमारा
out|adverb|बाहर
over|adverb|ऊपर
own|adjective|अपना
page|noun|पृष्ठ
paint|noun|रंग
painting|noun|चित्र; चित्रकारी; चित्रकला
pair|noun|मिलाना; जोड़ो में किस्त होना; जोड़ा लगाना
paper|noun|कागज़
paragraph|noun|समाचार; परिच्छेद; अनुच्छेद
parent|noun|माता-पिता
park|noun|पार्क
part|noun|भाग
partner|noun|साथी; पत्नी; सहयोगी
party|noun|पार्टी
passport|noun|निश्चित्तम विधि; पासपोर्ट; पारपत्र
past|adjective|अतीत
pen|noun|कलम
pencil|noun|पेंसिल
people|noun|लोग
pepper|noun|मीरचा; मीर्च; डालना
perfect|adjective|उतम; निर्दोष; निपुण बनाना
period|noun|दौर; काल; युग
person|noun|व्यक्ति
personal|adjective|स्वयं; व्यक्तित्व; अपना
phone|noun|फ़ोन
photo|noun|तस्वीर
photograph|noun|चित्र; छायाचित्र; फ़ोटो लेना
phrase|noun|वचन; व्यक्त करना; कहना
piano|noun|धीमा; धीमे से; पियानो/महावाद्य
picture|noun|तस्वीर
piece|noun|टुकड़ा
pig|noun|सूअर; खाना; सुअर
pink|adjective|बहुत अच्छा; गुलाबी; सजाना
place|noun|स्थान
plan|noun|योजना
plane|noun|हवाई जहाज़
plant|noun|पौधा
play|noun|खेलना
player|noun|अभिनेता; वादक; खिलाडी
please|exclamation|कृपया
point|noun|बिंदु
police|noun|पुलिस
policeman|noun|सिपाही
pool|noun|ताल; पोखरी; तालाब
poor|adjective|गरीब
popular|adjective|लोकप्रिय
positive|adjective|सत्य; स्पष्ट; पूर्ण
possible|adjective|संभव
post|noun|पद; केन्द्र; प्रचार करना
potato|noun|आलू
pound|noun|बाड़ा; गोलाबारी करना; धम धम दौडना
practice|noun|अभ्यास; कार्यप्रणाली; वकालत करना
practise|verb|कार्यप्रणाली; वकालत करना; अभ्यास करना
prefer|verb|पसन्द करना; तरक्की देना; पसंद करना
prepare|verb|तैयार करना
present|adjective|उपहार
pretty|adjective|सुंदर
price|noun|कीमत
probably|adverb|सम्भवतः; शायद; संभवतः
problem|noun|समस्या
product|noun|परिणाम; गुणन; माल
programme|noun|प्रोग्राम; प्रोग्राम लिखना; योजना
project|noun|योजना बनाना; डालना; योजना
purple|adjective|धर्माचार्य का पद; प्रतापी; बैंगनी
put|verb|रखना
quarter|noun|आवास; निवास; दिशा
question|noun|प्रश्न
quick|adjective|तेज़
quickly|adverb|तुरंत; शीघ्रता से; सरसरी तौर पर
quiet|adjective|शांत
quite|adverb|पूर्णतया; नितान्त; अत्यन्त
radio|noun|सन्देश आकाशवणी द्वरा भेजना; रेडियो; बेतार का तार
rain|noun|बारिश
read|verb|पढ़ना
reader|noun|पेशकार; प्रूफ संशोधक; रीडर
reading|noun|पढ़ना; व्याख्या; अध्ययन
ready|adjective|तैयार
real|adjective|असली
really|adverb|वास्तव में
reason|noun|कारण
red|adjective|लाल
relax|verb|आराम करना; कम करना; ढिलाई देना
remember|verb|याद रखना
report|noun|बताना; विवरण; सूचना
restaurant|noun|रेस्तराँ
result|noun|परिणाम; जीत; परिणाम निकालना
return|noun|लौटना
rice|noun|चावल
rich|adjective|अमीर
right|adjective|सही
river|noun|नदी
road|noun|सड़क
room|noun|कमरा
rule|noun|निर्णय कर; आधिपत्य; फुट्टा{पैमाना}
sad|adjective|उदास
salad|noun|सलाद
salt|noun|नमक
same|adjective|समान
sandwich|noun|कचौड़ी; मेवा
Saturday|noun|शनिवार
school|noun|विद्यालय
science|noun|प्रक्रिया; कौशल; विषय
scientist|noun|वैज्ञानिक
sea|noun|समुद्र
section|noun|वर्ग; दल; काटना
see|verb|देखना
sell|verb|बेचना
send|verb|भेजना
sentence|noun|वाक्य
September|noun|सितम्बर
seven|number|सात
seventeen|number|सत्रह
seventy|number|सत्तर
she|pronoun|वह
sheep|noun|भेड़
shirt|noun|कमीज़
shoe|noun|जूता
shop|noun|दुकान
shopping|noun|खरीदारी
short|adjective|छोटा
should|modal verb|चाहिए
show|noun|दिखाना
shower|noun|गिरना; बौछार; फुहार स्नान
sick|adjective|बीमार
similar|adjective|सम; समान; समरूप
sing|verb|गाना
singer|noun|गायक; गायिका; गवैया
sister|noun|बहन
sit|verb|बैठना
situation|noun|समस्या; दृश्य; स्थिति
six|number|छह
sixteen|number|सोलह
sixty|number|साठ
skill|noun|कौशल; योग्यता; प्रवीणता
skirt|noun|किनारा; किनारे पर रखना; घेरना
slow|adjective|धीमा
small|adjective|छोटा
snake|noun|नाग; रेंगना; सर्प
snow|noun|बर्फ
so|adverb|तो
some|determiner|कुछ
somebody|pronoun|कोई; कोई{व्यक्ति}
someone|pronoun|कोई
something|pronoun|कुछ
sometimes|adverb|कभी-कभी
son|noun|बेटा
song|noun|गाना
soon|adverb|जल्द ही
sorry|adjective|माफ़ करना
soup|noun|सूप
south|adjective|दक्षिण
space|noun|आकाशीय; आकाश; अन्तरिक्ष
speak|verb|बोलना
special|adjective|विशेष
spelling|noun|वर्तनी; अक्षर विन्यास; वर्ण विन्यास
spend|verb|खर्च करना
sport|noun|खेल
spring|noun|वसंत
star|noun|तारा
statement|noun|विवरण; अभिव्यक्ति; सारणी
station|noun|स्टेशन
stop|noun|रुकना
story|noun|कहानी
street|noun|गली
strong|adjective|मजबूत
student|noun|छात्र
study|noun|पढ़ाई
style|noun|प्रकार; बनावट; बनाना
success|noun|सफल व्यक्ति; सौभाग्य; सफलता
sugar|noun|चीनी
summer|noun|गर्मी
sun|noun|सूरज
Sunday|noun|रविवार
supermarket|noun|सुपर बाज़ार; सुपर
sure|adjective|ज़रूर
sweater|noun|स्वेटर; जर्सी
swimming|noun|तैराकी
T-shirt|noun|
table|noun|मेज़
take|verb|लेना
tall|adjective|लंबा
taxi|noun|टैक्सी
tea|noun|चाय
teach|verb|पढ़ाना
teacher|noun|शिक्षक
team|noun|टीम
teenager|noun|किशोर; तेरह से उन्नीस वर्ष की आयु का व्यक्ति
telephone|noun|दूरभाष करना; फोन करना; दूरभाष
television|noun|दूरदर्शन; चित्रपटल; दूर वीक्षण
tell|verb|बताना
ten|number|दस
tennis|noun|टेनिस; टेनिस[एक प्रकार का खेल].
terrible|adjective|भयानक
test|noun|परीक्षा
text|noun|अवतरण; पाठ्य; पाठ्य पुस्तक
than|conjunction|से
thank|verb|धन्यवाद
thanks|exclamation|के कारण; धन्यवाद; शुक्रगुजार
the|definite article|यह
theatre|noun|युद्ध क्षेत्र; नाटक; शल्यक्रिया कक्ष
their|determiner|उनका
them|pronoun|उन्हें
then|adverb|फिर
there|adverb|वहाँ
they|pronoun|वे
thing|noun|चीज़
think|verb|सोचना
thirsty|adjective|प्यासा
thirteen|number|तेरह
thirty|number|तीस
thousand|number|हज़ार
three|number|तीन
through|adverb|के माध्यम से
Thursday|noun|गुरुवार
ticket|noun|टिकट
time|noun|समय
tired|adjective|थका हुआ
title|noun|पद; उपाधि; नाम
to|infinitive marker|को
today|adverb|आज
together|adverb|साथ
toilet|noun|शौचालय
tomato|noun|टमाटर
tomorrow|adverb|कल
tonight|adverb|आज रात
too|adverb|भी
tooth|noun|दाँत
topic|noun|विषय; प्रसंग
tourist|noun|सैलानी; पर्यटक; पर्यटकी
town|noun|कस्बा
traffic|noun|ग़ैरकानूनी व्यापार करना; परिवहन; माल ढोने का व्यापार
train|noun|रेलगाड़ी
travel|noun|यात्रा
tree|noun|पेड़
trip|noun|यात्रा
trousers|noun|पतलून; पाजामा
true|adjective|सच्चा
Tuesday|noun|मंगलवार
turn|noun|मोड़ना
TV|noun|टी वी; टी; दूरदर्शन
twelve|number|बारह
twenty|number|बीस
twice|adverb|दुगुना; दो बार; दुगना
two|number|दो
type|noun|प्रकार; नमूना; वर्ग
umbrella|noun|छाता
uncle|noun|चाचा
under|adverb|नीचे
understand|verb|समझना
university|noun|विश्वविद्यालय; किसी विश्वविद्यालय का दल; किसी विश्वविद्यालय का
until|conjunction|जब तक
up|adverb|ऊपर
us|pronoun|हमें
useful|adjective|उपयोगी
usually|adverb|आमतौर पर
vacation|noun|अवकाश; छुट्टी; छुट्टी बिताना
vegetable|noun|सब्ज़ी
video|noun|वीडियो; वीडियो बनाना; वीडियो{दृश्य}
village|noun|गाँव
visit|noun|दौरा करना
visitor|noun|पर्यटक; मिलनेवाला; दर्शक
waiter|noun|बैरा; इंतज़ार करने; वेटर
wake|verb|जागना
walk|noun|चलना
wall|noun|दीवार
want|verb|चाहना
warm|adjective|गर्म
watch|noun|देखना
water|noun|पानी
we|pronoun|हम
wear|verb|पहनना
weather|noun|मौसम
website|noun|संचार प्रौद्योगिकी; वेब साइट; वेब स्थल
Wednesday|noun|बुधवार
week|noun|सप्ताह
weekend|noun|सप्ताहांत
welcome|adjective|स्वागत
well|adjective|अच्छी तरह
west|adjective|पश्चिम
what|determiner|क्या
when|adverb|कब
where|adverb|कहाँ
which|determiner|कौन सा
white|adjective|सफेद
who|pronoun|कौन
why|adverb|क्यों
wife|noun|पत्नी
window|noun|खिड़की
wine|noun|शराब पीना; मदिरा; शराब
winter|noun|सर्दी
with|preposition|साथ
without|preposition|के बिना; छोड़कर; न
woman|noun|महिला
wonderful|adjective|अनोखा; आश्चर्यजनक; अद्भुत
word|noun|शब्द
work|noun|काम
worker|noun|कर्मचारी; श्रमजीवी; कर्ता
world|noun|दुनिया
would|modal verb|होगा
write|verb|लिखना
writer|noun|साक्षर; लेखक; रचयिता
writing|noun|लिखने का काम; लिखना; लेखन
wrong|adjective|गलत
yeah|exclamation|हाँ
year|noun|साल
yellow|adjective|पीला
yes|exclamation|हाँ
yesterday|adverb|कल
you|pronoun|तुम
young|adjective|जवान
your|determiner|तुम्हारा
yourself|pronoun|आप; आप स्वयं; तुम
"""), "en", "A1", "oxford"),

        Lesson("ox-a2", "🐥 Oxford 5000 · A2", "🐥", "790 official Oxford words", ow("""
ability|noun|प्रतिभा; योग्यता; सामर्थ्य
able|adjective|सक्षम
abroad|adverb|बाहरी; प्रचलित; बाहर
accept|verb|स्वीकार करना
accident|noun|दुर्घटना
according to|preposition|के अनुसार; के अनुरूप
achieve|verb|पाना; प्राप्त करना; पूरा कर देना
active|adjective|सक्रिय
actually|adverb|वास्तव में; वस्तु; सचमुच
adult|adjective|वयस्क
advantage|noun|एडवांटेज{टैनिस के केल में ड्युस उपरांत अर्जित पहला प्वाइंट}; सहायता करना; लाभ
adventure|noun|अभियान; जोखिम; साहस
advertise|verb|बताना; कहना; घोषित करना
advertisement|noun|विज्ञापन
advertising|noun|विज्ञापन; विज्ञापन की प्रणाली
affect|verb|बदलना; प्रभावित करना; ढोंग करना
after|adverb|बाद
against|preposition|से अलग; के सहारे; विरूद्व
ah|exclamation|विस्मय
airline|noun|हवाई कंपनी; हवाई कम्पनी; हवाई
alive|adjective|जीवित
all|adverb|सब
all right|adjective|ठीक; स्वस्थ; निःसन्देह
allow|verb|स्वीकार करना; मिलना; देना
almost|adverb|लगभग
alone|adjective|अकेला
along|adverb|साथ
already|adverb|पहले ही
although|conjunction|यद्यपि; हालाँकि
among|preposition|में; में से; के बीच
amount|noun|कुछ हद तक; मात्रा; राशि
ancient|adjective|पुराना; प्राचीन; बहुत पुराना
ankle|noun|टखना
any|adverb|कोई
any more|adverb|इसके बाद; अब
anybody|pronoun|कोई व्यक्ति; कोई; कोई भी
anyway|adverb|फिर भी; भी; चाहे जैसे
anywhere|adverb|कहीं भी; कहीं
app|noun|आधुनिक संगणक एप्लीकेशन
appear|verb|दिखना
appearance|noun|उपस्थिति; पेशी; रूप रंग
apply|verb|लगाना; लागू होना; काम में
architect|noun|शिल्पकार; वास्तुकार; निर्माता
architecture|noun|संरचना; शिल्प; वास्तुकला
argue|verb|प्रमाणित करना; सूचित करना; झगड़ना
argument|noun|तर्क; झगड़ा; विषय
army|noun|सेना
arrange|verb|निश्चित करना; तय करना; तैयार करना
arrangement|noun|सजावट; प्रक्रिया; व्यवस्थापन
as|adverb|जैसा
asleep|adjective|मृत; सुन्न; सोया हुआ
assistant|adjective|सहायक
athlete|noun|व्यायामी
attack|noun|हमला
attend|verb|ध्यान केंद्रित करना; साथ जाना; पर ध्यान देना
attention|exclamation|ध्यान
attractive|adjective|मनोहर; मनोरम; आकर्षक
audience|noun|श्रोतागण; श्रोता; औपचारिक बैठक
author|noun|जड़; लिखना; प्रवर्तक
available|adjective|उपलब्ध; खाली; मिलता है
average|adjective|सामान्य; औसत; औसत निकालना
avoid|verb|रोकना; दूर रहना; टालना
award|noun|अनुदान; पुरस्कार; सावधान
awful|adjective|नृशंस; भद्दा; डरावना
back|adjective|पीठ
background|noun|वर्ग; आधार; ज्ञान
badly|adverb|बहुत अधिक; बहुत ही; असफ़लतापूर्वक
bar|noun|रोकना; अदालत; सिटकिनी
baseball|noun|बेस बल; बेस
based|adjective|आधारित
basketball|noun|एक प्रकार का खेल; बास्किट बल; बास्किट
bean|noun|सिक्का; कुछ; पैसा
bear|noun|भालू
beef|noun|गोमांस
before|adverb|पहले
behave|verb|व्यवहार करना; चलना; बर्ताव करना
behaviour|noun|आचरण; ढंग; बर्ताव
belong|verb|होना; रखना; सम्बन्ध रखना
belt|noun|प्रहार; क्षेत्र; इलाका
benefit|noun|गुण; लाभ; सुविधा
between|adverb|के बीच
billion|number|असंख्य; बेहिसाब; एक अरब
bin|noun|डिब्बा; बिन; फेंक देना
biology|noun|जीव विज्ञान; जीवविज्ञान
birth|noun|जन्म
biscuit|noun|बिस्कुट; हल्का बादामी रंग; पकाये हुए
bit|noun|थोड़ा; छोटा सिक्का; फलक
blank|adjective|खाली; भावशून्य; शून्य
blood|noun|खून
board|noun|किनारा; में चढना; तख्ता
boil|verb|गुस्सा; उबालना; गरम करना
bone|noun|शरीर; हड़्डी; देहावशेष
borrow|verb|उधार लेना
boss|noun|मालिक; आदेश देना; आदेश
bottom|adjective|पता; निम्नतम; नितम्ब
bowl|noun|प्राप्त करना; प्याला; आउट
brain|noun|दिमाग
bridge|noun|पुल
bright|adjective|चमकीला
brilliant|adjective|मेधावी; चमकीला; उत्कृष्ट
broken|adjective|खंडित; निराश; टूटा हुआ
brush|noun|खरोंच; झगड़ा; रगड़ना
businessman|noun|व्यापारी; व्यवसायी; सौदागरअ
button|noun|बंद करना; कुकुरमुत्ता; कली
camp|noun|डेरा डालना; शिविर लगाना; कैंप
camping|noun|शिविर लगा कर रहना
can|noun|सकना
care|noun|देखभाल
careful|adjective|सावधान
carefully|adverb|सावधानी से; विचारपूर्वक; विचारिततः
carpet|noun|परत; ढाँक देना; पर दरी बिछाना
cartoon|noun|व्यंग्यचित्र; हास्योत्पादक चित्र; कार्टून फ़िल्म
case|noun|घटना; समस्या; नमूना
cash|noun|नक़दी; रोकड़ में बदलना; रोकड़
castle|noun|भवन; रूख से शह; रूख से शह देना
cause|noun|करना; कारण बनना; देना
celebrate|verb|मनाना; पादरी का कार्य; प्रचार करना
celebrity|noun|प्रतिष्ठा; प्रशंसा; ख्यातिई
certain|adjective|अनिवार्य; विश्वसनीय; नियत
certainly|adverb|निश्चित रूप से; निःसन्देह; अवश्य
chance|noun|अवसर; आकस्मिक; मौका
character|noun|दर्जा; प्रतिष्ठा; गुण
charity|noun|उदारता; दया; दान
chat|noun|बात; बातचीत; गपशप
check|noun|जाँच
chef|noun|प्रधान रसोइया; प्रधान
chemistry|noun|प्रक्रिया; रसायन शास्त्र; रहस्यमय
chip|noun|चिप्स काटना; किनारे से चिप्पी उतरना; चिप्स
choice|noun|प्रकार; चारा; चुनाव
church|noun|गिरजाघर
cigarette|noun|सिगरेट
circle|noun|वृत्त; पंक्ति; घेरना
classical|adjective|पारम्परिक; प्राचीन; मनमोहक
clear|adjective|स्पष्ट
clearly|adverb|साफ साफ; नि: सन्देह
clever|adjective|बुद्धिमान; योग्य; निपुण
climate|noun|जलवायु; वातावरण; आबोहवा
close|adjective|बंद करना
closed|adjective|सीमित; बंद; संकीर्ण
clothing|noun|पहनावा; परिधान; वस्त्र
cloud|noun|बादल
coach|noun|शिक्षक; शिक्षा देना; प्राइवेट ट्यूटर
coast|noun|किनारा; चलाना; व्यापार
code|noun|नियमावली; गुप्त भाषा; कूट संकेत में लिखना
colleague|noun|सहकार्यकर्ता; सहकर्मी
collect|verb|इकट्ठा करना
column|noun|पंक्ति; कलम; दंड
comedy|noun|हास्यप्रधान नाटक; विनोदप्रियता; कमेडी
comfortable|adjective|आरामदायक
comment|noun|टीका टिप्पणी करना; टिप्पणी; आलोचना
communicate|verb|फैलाना; व्यक्त करना; पहुँचाना
community|noun|जाति; समुदाय; समाज
compete|verb|मुक़ाबला; प्रतिस्पर्धा करना; प्रयत्न करना
competition|noun|स्पर्ध्दा; प्रतियोगिता; प्रतिस्पर्ध्दी
complain|verb|शिकायत करना; शिकायत; दुखड़ा रोना
completely|adverb|भरपूर; पूरी तरह से; पूरी तरह
condition|noun|निश्चित करना; उपाधि; ठीक करना
conference|noun|सम्मेलन; अधिवेशन
connect|verb|मिलाना; जुड़ा; लगना
connected|adjective|आनुषंगिक
consider|verb|विचार करना; समझना; ग़ौर
contain|verb|होना; रोकना; घेरना
context|noun|परिस्थिति; प्रसंग; सन्दर्भ
continent|noun|संयमी; आत्मसंयमी; महाद्वीप
continue|verb|होना; शुरू; रखना
control|noun|शासन; संचालन करना; निपुणता
cook|noun|पकाना
cooker|noun|कुकर
copy|noun|प्रति; कपी; अनुकरण
corner|noun|कोना
correctly|adverb|सही ढंग से; सही ढंग
couple|noun|संलग्न; संलग्न करना; कुछ
crazy|adjective|पागल
creative|adjective|सृजनात्मक निर्माण करने की शक्ति वाला; सृजनात्मक; सृजनशील
credit|noun|विश्वास दिलाना; जमा; मान्यता
crime|noun|अपराध; पाप; जुर्म
cross|noun|पार करना
crowd|noun|भीड़
crowded|adjective|सघन; भरा हुआ; भरा
cupboard|noun|अलमारी
curly|adjective|घुँघराला; घूंघर बाल
cycle|noun|वृत्त; दौर; चक्कर
daily|adjective|दिन; दैनिक; हमेशा
danger|noun|खतरा
data|noun|आँकड़े; बातें{दी हुई या जानी हुई}/निर्दिष्ट; डेटा
dead|adjective|मृत
death|noun|मृत्यु; मृत्यु/मरण; आकस्मिक
decision|noun|निर्णय; निर्णय करना; निर्णय शक्ति
deep|adjective|गहरा
definitely|adverb|निश्चित रूप से; पक्का करना; स्पष्टता से
degree|noun|कोटि; उपाधि; अंश
dentist|noun|दाँतों का डाक्टर; दन्त चिकित्सक; दंतकार
department|noun|विभाग
depend|verb|निर्भर; निर्भर होना; भरोसा रखना
desert|noun|त्याग देना; निर्जन; सेना से
designer|noun|रूप बनानेवाला; डिजाइनर; रूपकार
destroy|verb|दूर; हराना; नष्ट करना
detective|noun|खूफिया; गुप्तचर; जासूसी
develop|verb|होना; फैलाना; दिखलाना
device|noun|उपकरण; योजना; साहित्य में पाठक पर प्रभाव छोड़ने वाली लेखन शैली
diary|noun|डायरी; दैनिक वृत्त की पुस्तिका; पाकेट
differently|adverb|अलग प्रकार से; अलग
digital|adjective|डिजिटल; अंकीय; आंगुलिक
direct|adjective|सरल; सीधा; ठीक
direction|noun|दिशा
director|noun|प्रबंधक; संचालक; अध्यक्ष
disagree|verb|भिन्न होना; असहमत होना; असहमत
disappear|verb|खो; अदृश्य होना; खो जाना
disaster|noun|असफलता; भीषण दुर्घटना; मुसीबत
discover|verb|पता; समझना; पता लगाना
discovery|noun|आविष्कार; खोज; रहस्य
discussion|noun|चर्चा; बहस; आलोचनाआ
disease|noun|रोग; बीमारी; व्याधि
distance|noun|प्रक्रिया; दूर रखना; दूर
divorced|adjective|विवाह सम्बन्ध विछैध
document|noun|लिखना; प्रपत्र; वृत्तचित्रित
double|adjective|दुगुना; आना; दोहरा
download|noun|कम्प्यूटर मे डेटा ट्रांसवर करना; डाउनलोड करना; इन्टरनेट से किसी सामग्री को अपने पास संकलित कर लेना
downstairs|adjective|सीढी के नीचे; निचला; निचली मंजील पर
drama|noun|नाटक; नाटक/स्वांग; नाट्य रचना
drawing|noun|चित्रकारी; चिट्रंकनअ; चिट्रकारी
dream|noun|सपना
drive|noun|चलाना
drug|noun|दवा देना; ड्रग; पिलानाना
dry|adjective|सूखा
earn|verb|पाना; हासिल करना; कमाना
earth|noun|पृथ्वी
easily|adverb|निःसन्देह; आसानी से; तुरन्त
education|noun|शिक्षा; शिक्षण; पढाई
effect|noun|प्रभाव; पैदा करना; पैदा
either|adverb|दोनों में से
electric|adjective|बिजली; बिजली से; बिजली का
electrical|adjective|विद्युत; बिजली का
electricity|noun|विद्युत; उत्तेजना; बिजली
electronic|adjective|इलैक्ट्रोन की क्रिया पर निर्भर साधन; इलेक्ट्रनिक
employ|verb|नियुक्त करना; नौकर; नौकरी
employee|noun|कर्मचारी
employer|noun|मालिक; प्रवर्तक
empty|adjective|खाली
ending|noun|समाप्ति; प्रत्यय; विभक्ति
energy|noun|ऊर्जा
engine|noun|इंजन
engineer|noun|इंजीनियर
enormous|adjective|बहुत; विशाल; बड़ा
enter|verb|प्रवेश करना
environment|noun|पर्यावरण; वातावरण; परिमंडल
equipment|noun|उपकरण; तैयारी
error|noun|भूल; गलती; गलतियाँ
especially|adverb|खास तौर पर; विशेष रूप से; विशेषतः/विशेष रूप से
essay|noun|कोशिश करना; लेख; प्रयत्न करना/परिश्रम करना/जाँचना
everyday|adjective|साधारण; प्रतिदिन; एक
everywhere|adverb|सर्वट्र; सभी; सर्वत्र
evidence|noun|प्रमाण; साबित करना; साक्ष्य
exact|adjective|खरा; सतर्क; निर्दोष
exactly|adverb|वास्तव में; ठीक ठीक/यथार्थतः; वास्तव
excellent|adjective|उत्कृष्ट
exist|verb|होना; रहना; जीवित रहना
expect|verb|आशा करना; आसरा देखना; रख लेना
experience|noun|अनुभव करना; अनुभव; अनुभूति
experiment|noun|परीक्षा; परीक्षण करना; प्रयोग
expert|adjective|धुरंधर; विशेषज्ञ; निपुण
explanation|noun|स्पष्टीकरण; व्याख्या; सफ़ाई
express|verb|बताना; प्रकट; प्रकट करना
expression|noun|वचन; पदसंहति; अभिव्यक्ति
extreme|adjective|कठोर; समशीतोष्ण; तीव्र
extremely|adverb|अत्यधिक; बहुत ही; बहुत
factor|noun|कारण; घटक; गुणक
factory|noun|कारखाना
fail|verb|असफल होना
fair|adjective|न्याय; सुन्दर; सीधा
fall|noun|गिरना
fan|noun|उत्तेजित करना; पंखा; फटकना
farming|noun|कृषि; खेती
fashion|noun|आचरण; तैयार; बनावट
fear|noun|डर
feature|noun|दिखाना; प्रकट करना; विशेषता
female|adjective|महिला; औरत; स्त्री जाति
fiction|noun|कल्पना; कथा; परिकल्पना
field|noun|कार्य क्षेत्र; आधार; खेलनेवाल दल
fight|noun|लड़ना
figure|noun|नमूना; विचार करना; कल्पना करना
finally|adverb|अंत में; आखिरकार; अंततोगत्वा
finger|noun|उंगली
finish|noun|खत्म करना
firstly|adverb|आरम्भ में; सबसे पहला; सबसे
fishing|noun|मछली पकड़ना; मछली; मछली मारना
fit|adjective|संगत; स्वस्थ; उचित
flat|adjective|नीरस; सितारा मछली; सपाट
flu|noun|फ़्लू; फ्लू{बीमारी}
fly|noun|उड़ना
flying|adjective|लहरात हुआ; उड़ने वाला; हवाई यात्रा
focus|noun|ध्यान केंद्रित करना; देखने योग्य; केन्द्रित करना
following|adjective|सहायक; अनुगामी; निम्नलिखित
foreign|adjective|विदेशी
forest|noun|जंगल
fork|noun|काँटा से खाना; द्विशाखित हो; खाने का काँटा
formal|adjective|शिष्टाचार के अनुकूल; सुव्यवस्थित; औपचारिक
fortunately|adverb|भाग्य से; सौभाग्यवश
fresh|adjective|ताज़ा
fridge|noun|फ्रिज
frog|noun|मेढक; दादुर
fun|adjective|मज़ा
furniture|noun|उपस्कर; फर्नीचर
further|adjective|वृद्धि करना; अधिक; सहायता करना
future|adjective|भविष्य
gallery|noun|मकानो के भीतर जाने का मार्ग; भवन; बरामदा
gap|noun|कमी; अन्तर; दरार
gas|noun|बकवास; ज़हरीली गैस; बकवास करना
gate|noun|द्वार
general|adjective|साधारण; आम; सामान्य
gift|noun|आसान बात; गुण; प्रतिभा
goal|noun|गोल; उद्देश्य; लक्ष्य
god|noun|भगवान
gold|adjective|सोना
golf|noun|गोल्फ़{एक प्रकार का खेल}; गोल्फ
government|noun|सरकार
grass|noun|घास
greet|verb|मिलना; स्वागत; अभिवादन
ground|noun|ज़मीन
guest|noun|मेहमान
guide|noun|संचालन करना; राह दिखाना; अधिकारक
gun|noun|बंदूक
guy|noun|हँसी उड़ाना; मजाक; आदमी
habit|noun|प्रवृत्ति; पोशाक; स्वभाव
half|adverb|आधा
hall|noun|घर; सभागृह; शयनशाला
happily|adverb|सुखपूर्वक/संयोग से; खुशीपुर्वक
headache|noun|सिरदर्द; सिर दर्द
heart|noun|दिल
heat|noun|गर्मी
heavy|adjective|भारी
height|noun|शिखर; चरम; पराकाष्ठा
helpful|adjective|सहायक; लाभदायक
hero|noun|अभिनेता; नायक; वीर
hers|pronoun|उस स्त्री का; उसकी
herself|pronoun|स्वयं; वह स्वयं[स्त्री]
hide|verb|गुप्त रखना; छिपने की जगह; छिपा देना
hill|noun|पहाड़ी
himself|pronoun|स्वयं
hit|noun|मारना
hockey|noun|हकी; हाकी/एक प्रकार का खेल
hole|noun|छेद
home|adjective|घर
hope|noun|आशा
huge|adjective|बहुत अधिक; बहुत; विशाल
human|adjective|अच्छा; मानव; इंसान
hurt|adjective|दर्द पहुँचाना; चोट; ज़ख़्मी
ideal|adjective|आदर्श; अनुकूल; उपयुक्त
identify|verb|समझना; पहचानना; शिनाख्त
ill|adjective|बीमार
illness|noun|रोग; बीमारी; अस्वास्थ्य
image|noun|कल्पना करना; चित्र; धारणा
immediately|adverb|ठीक; उसी समय; तत्काल
impossible|adjective|अशिष्ट; निराशाजनक; असंभव
included|adjective|अंगीभूत; अंतर्गत; अंतःपाती
including|preposition|सम्मिलित करते हुए; सहित
increase|noun|वृद्धि करना; बढ़ाना; विस्तार
incredible|adjective|अविश्वसनीय; अच्छा; असाधारण
independent|adjective|स्वतंत्र; अलग; निष्पक्ष
individual|adjective|विशिष्ट; व्यक्ति; अलग अलग
industry|noun|उद्योग; परिश्रम; मेहनत
informal|adjective|अनौपचारिक; सदा; अनाधिकारिक
injury|noun|घाव; क्षति; आकस्मिक चोट
insect|noun|कीड़ा; कीट; तुच्छ आदमी
inside|adjective|अंदर
instead|adverb|उसके स्थान पर; बजाय; बदल में
instruction|noun|सूचना; शिक्षा; जानकारी
instructor|noun|उपदेशक; प्रसिक्षकअ; अनुदेशक
instrument|noun|मानव यंत्र; प्रपत्र; लिखित
intelligent|adjective|बुद्धिमान; सुधिरस; तरसेम
international|adjective|अंतर्राष्ट्रीय श्रमजीवी संघ; अंतर्राष्ट्रीय संघ; अन्तर्राष्ट्रीय संघटन
introduction|noun|प्रारंभ; प्रस्तावना; समावेशन
invent|verb|बनाना; आविष्कार करना; गढना
invention|noun|प्रतिभा; आविष्कार; काल्पनिक कथा
invitation|noun|संदेश पत्र; दावत; उपहार
invite|verb|आमंत्रित करना
involve|verb|शामिल होना; शामिल करना; खतरे में पडना
item|noun|अंश; विषय; समाचार
itself|pronoun|स्वयं; अपने आप; स्वयम्
jam|noun|मुरब्बा; दबाना; जाम
jazz|noun|व्यर्थ की बात; गीतनाट्य; जाज
jewellery|noun|जेवर; गहना; आभूषण
joke|noun|हँसी खेल; चुटकुला; हँसी मज़ाक
journalist|noun|पत्रकार; पट्रकार; संवावदाता
jump|noun|कूदना
kid|noun|परेशान करना; बहानेबाजी करना; धोखा देना
kill|verb|मारना
king|noun|राजा
knee|noun|घुटना
knife|noun|चाकू से काटना; छुरी; चाकू से
knowledge|noun|जानकारी; अवबोधन; ज्ञान
lab|noun|प्रयोगशाला
lady|noun|प्रेमिका; महिला; कुलीन महिला
lake|noun|झील
lamp|noun|लालटेन; टेबल; कंदील
laptop|noun|एक छोटा गणक
last|adverb|आखिरी
later|adjective|बाद में; बाद; अधिक देर
laughter|noun|ह्ँसी; क़हक़हा; खिलखिलाहट
law|noun|कानून
lawyer|noun|कानून का पंडित; वकील; अधिवक्ता
lazy|adjective|आलसी
leader|noun|नेता; नेताआ
learning|noun|ज्ञान; अधिगम; ज्ञान/विद्या
least|adverb|कम से कम; कम; सब से
lecture|noun|फटकारना; आलोचना करना; व्याख्यान
lemon|noun|नींबू का शर्बत; हल्का पीला रंग; नींबुई रंग
lend|verb|देना; प्रदान करना; किराये पर देना
less|adverb|छोटा; कम माऋआ मे़; कम
lifestyle|noun|जीवन शैली; जीवनचर्या
lift|noun|धुंध हटना; उठाना; खोदना
likely|adjective|सम्भव; आशाजनक; संभावित
link|noun|सम्पर्क; सम्बन्ध; शृंखला
listener|noun|श्रोता
lock|noun|घोड़ा; गुच्छा; बंद करना
look|noun|देखना
lorry|noun|लारी; लरी
lost|adjective|गुम; गुमराह; डूबा हुआ
loud|adjective|तीव्र; ऊँचा; प्रबल
loudly|adverb|ज्ॅओर से; ऊँचे स्वर में; ज्ॅओर
lovely|adjective|मधुर; सुहावना; मनोहर
low|adjective|नीचा
luck|noun|भाग्य; नसीब या किस्मत; भाग्य होना
lucky|adjective|भाग्यशाली
mail|noun|डाक; डाक करना; डाक प्रेषण करना
major|adjective|प्रमुख; मुख्य; महत्वपूर्ण
male|adjective|पुलिंग; पुरुष; प्रेमी
manage|verb|देखभाल करना; रखना; लेना
manager|noun|व्यस्थापक; प्रबंधक; मैनेजर
manner|noun|आचरण; प्रक्रिया; शैली
mark|noun|लिखना; संकेत; छाप
marry|verb|शादी करना
mathematics|noun|गणित; गणितकार
maths|noun|गणित; हिसाब
matter|noun|मामला
media|noun|माध्यम; संचार माध्यम; मीडिया
medical|adjective|चिकित्सीय परीक्षा; चिकित्सीय; चिकित्सा
medicine|noun|दवा
memory|noun|स्मरण शक्ति; याद; याददाश्त
metal|noun|धातु; रेल की पटरी; पिघला
method|noun|क्रमबद्ध्ता; पद्धति; प्रणाली/तरीका
middle|adjective|बीच
might|modal verb|बल; प्रभाव; शक्ति
mind|noun|मन
mirror|noun|दर्पण; शीशा; प्रतिबिम्बित करना
missing|adjective|अनुपस्थित; लापता; खोया
mobile|adjective|घुमंतू; अस्थिर; चंचल
monkey|noun|बंदर
moon|noun|चाँद
mostly|adverb|प्रायः; मूख्य रुप से
motorcycle|noun|
movement|noun|लय; झुकाव; गति
musical|adjective|मधुर; संगीत; संगीत नाटिका
musician|noun|संगीतकार; वादक; रसिक
myself|pronoun|खुद; स्वतः
narrow|adjective|संकरा
national|adjective|राष्ट्रजन; देशभक्त; रजवंशी
nature|noun|प्रकार; गुण; वर्ग
nearly|adverb|लगभग; सब; घनिष्ठ रूप से
necessary|adjective|आवश्यक
neck|noun|गर्दन
need|noun|ज़रूरत
nervous|adjective|अशांत; उदास; बेचैन
network|noun|नमूना; समूह; फैलाव
noise|noun|शोर
noisy|adjective|कोलाहलपूर्ण; कोलाहल कारी; भड़कीला
none|pronoun|बिल्कुल भी नहीं; कोई भी नहीं; कोई
normal|adjective|सितारा मछली; साधारण; सामान्य
normally|adverb|सामान्यतः; आसानी से; सामान्य रुपे
notice|noun|सूचना; चेतावनी; देखना
nowhere|adverb|सुदूर; कहीं नहीं; सुदूरवर्ती स्थान
nut|noun|पागल; सिर; एकट्र करना
ocean|noun|दक्षिण ध्रुव; अत्यधिक; अत्यधिक फैलाव
offer|noun|देना; अर्पण करना; बलि देना
officer|noun|अधिकारी; पदाधिकारी; सिपाही
oil|noun|तेल
onto|preposition|पर
opportunity|noun|अवसर; मौका; सुअवसर
option|noun|अभिरुचि; चाह; चुनने का अधिकार
ordinary|adjective|साधारण; स्वाभाविक; सामान्य
organization|noun|बनावट; संघ; संरचना
organize|verb|आयोजित करना; योजना बनाना; संगठित करना
original|adjective|असली; प्रारंभिक; मूल
ourselves|pronoun|हम स्वंय; स्वयम्; हम
outside|adjective|बाहर
oven|noun|चूल्हा; तंदूर; भट्टी
owner|noun|मालिक; स्तामी
pain|noun|दर्द
painter|noun|रस्सी; चित्रकार; पागर
palace|noun|राजमहल; महल; राजभवन
pants|noun|पतलून; चड्ढी
parking|noun|पार्कींग; गाड़ी स्थान; पड़ाव
particular|adjective|निराला; सतर्क; विस्तृत
passenger|noun|कर्मी दल; याट्री; पथिक
pattern|noun|नमूना; चित्र; उदाहरण
pay|noun|भुगतान करना
peace|noun|शांति
penny|noun|in for a pound,जिसको शुरू करो; सिक्का; पेनी{ब्रिटिश करेंसी}
per|preposition|प्रति
per cent|adjective|सितारा मछली; प्रतिशत; प्रति सैकड़ों में एक भाग.
perform|verb|करना; दिखाना; गाना
perhaps|adverb|हो; शायद; संभवतः
permission|noun|अनुमति देना; आज्ञा; मंजूर
personality|noun|व्यक्तित्व; चरिट्र; विशेष चरित्र
pet|noun|दुलारा; दुलारना; प्रिय व्यक्ति
petrol|noun|पेट्रोल; भू तेल
physical|adjective|शरीर; वास्तविक; शारीरिक
physics|noun|भौतिक; भौतिक विज्ञान
pilot|noun|चलाना; विमान चालक; प्रयोग करना
planet|noun|ग्रह
plastic|adjective|लचीला; नरम; ढलनशील
plate|noun|थाली
platform|noun|ऊँची एड़ी का; मंच; प्लेटफार्म
pleased|adjective|प्रसन्न; प्रफुल्ल; खुश
pocket|noun|जेब
polite|adjective|शिष्ट; विनम्र; सभ्य
pollution|noun|प्रदूषण
pop|adjective|पाप संगीत; फक्क की ध्वनि; पोप्
population|noun|लोग; जन; जनता
position|noun|दृष्टिकोण; प्रतिष्ठा; पद
possession|noun|आधिपत्य; अधिकार; सम्पत्ति
possibility|noun|संभावना; सम्भवता; घटनीयता
poster|noun|सूचनापत्रक; विज्ञापन; विज्ञापन/इश्तहार
power|noun|शक्ति
predict|verb|पूर्वानुमान करना; भविष्यवाणी करना; भविष्य बतलाना
president|noun|प्रधान; अध्यक्ष; कार्यकारी व्यवस्थापक
prevent|verb|रोकना; बचाना; मना करना
printer|noun|मुद्रण यंट; मुद्रकअ; छपाई यन्त्र
prison|noun|जेल में डालना; बन्दी; जेल
prize|noun|पुरस्कार; इनाम; धन
process|noun|विधि; बढोत्तरी; तैयार करना
professional|adjective|व्यावसायिक; अनुभवी व्यक्ति; पेशेवर
professor|noun|प्राध्यापक; प्रोफ़ेसर
profile|noun|रूपरेखा; खाका; छापना
program|noun|कार्यक्रम
progress|noun|आगे बढना; विकास करना; चलना
promise|noun|वादा
pronounce|verb|निर्णय देना; घोषित करना; उच्चारण करना
protect|verb|रक्षा करना
provide|verb|करना; देना; भरण पोषण करना
pub|noun|शराबखाना; मयखाना
public|adjective|प्रजा; लोग; आम
publish|verb|लिखना; प्रकाशित होना; पेश करना
purpose|noun|अभिप्राय; प्रयोजन; उद्देश्य
quality|noun|प्रकार; कोटि; गुण
quantity|noun|परिमाण; मात्रा; संख्या
queen|noun|रानी
quietly|adverb|शांतिपूर्वक; शांतिपूर्ण ढंग से; शांति से
race|noun|प्रजाति; स्वाद; दौड़
railway|noun|रेल पथ; रेलवे; रेल की पटरी
raise|verb|करना; निकालना; उत्तेजित करना
rate|noun|इसी रफ्तार से; दर्जा; कोटि
rather|adverb|अधिक; निःसन्देह; अपेक्षाकृत
react|verb|अभिक्रिया उत्पन्न करना; प्रतिक्रिया करना; विरूद्ध प्रतिक्रिया करना
realize|verb|प्राप्त करना; समझना; रूपये में परिवर्तित करना
receive|verb|प्राप्त करना
recent|adjective|आजकल का; आधुनिक; नया
recently|adverb|हाल ही में; अभी अभी; हाल मेँ
reception|noun|स्वीकृति; स्वागत; स्वागत समारोह
recipe|noun|नुस्खा; व्यंजन विधि; खाना बनाने की विधि
recognize|verb|स्वीकार करना; प्रकट करना; पहचानना
recommend|verb|सिफारिश; प्रशंसा करना; आकर्षक बनाना
record|noun|अभिलेखबद्ध; लिखित प्रमाण; जीवन इतिहास
recording|noun|ध्वन्यालेखन; अभिलेकन
recycle|verb|पुनः चक्रित करना; पुनः चक्रित; प्रयोग की गयी वस्तु का पुनः प्रयोग
reduce|verb|घटना; कम करना; पराजित करना
refer|verb|सौंपना; संकेत करना; इशारा करना
refuse|verb|अग्राह्य; अस्वीकार करना; इंकार
region|noun|क्षेत्र; प्रदेश; प्रदेश क्षेत्र
regular|adjective|रोज का ग्राहक; योग्य; मठजीवी
relationship|noun|नाता; संबंध; सम्बन्ध
remove|verb|निकालना; हटाना; श्रेणी
replace|verb|बदलना; हटाना; बदले मेँ रखना
reply|noun|उत्तर देना; जवाब देना; उत्तर
reporter|noun|सम्वाददाता; संवाददाता
request|noun|विनती करना; अनुरोध करना; आवेदन
research|noun|फिर खोज करना; अनुसन्धान; खोज करना
researcher|noun|शोधार्थी; शोधक; गवेक्षक
respond|verb|प्रत्युत्तर देना; बदले मे कुछ करना या कहना; उत्तर देना
response|noun|प्रतिक्रिया; ईसाइयों मे प्रार्थना  पाठ के उत्तर मे गाया जाने वाला भजन; धार्मिक
rest|noun|आराम
review|noun|परखना; सर्वेक्षण; पुनःपरीक्षण
ride|noun|चलाना; घुड़सवारी करना; चढना
ring|noun|गोला बनाना; बजना; टेलीफोन करना
rock|noun|कड़ी; हिलना; पत्थर
role|noun|कर्तव्य; भूमिका
roof|noun|छत; छाना; शीर्ष
round|adjective|वृत्त; दौर; समाप्त करना
route|noun|मार्ग; रास्ता; भेज देना
rubbish|noun|कटु आलोचना करना; मल; रद्दी
rude|adjective|कच्चा; असभ्य; भद्दा
run|noun|दौड़ना
runner|noun|तस्कर; दौड़ने वाला; धावक
running|noun|एक के बाद एक; लगातार; दौड़
sadly|adverb|दुर्भाग्यवश; उदासी; बुरी तरह से
safe|adjective|सुरक्षित
sailing|noun|जलयात्रा; पाल नौकायन; पाल
salary|noun|मेहनताना; वेतन; वेतन/तनखाह
sale|noun|बेचना; विक्रय; नीलामी
sauce|noun|ढिठाई; चटनी; रूखा व्यवहार
save|verb|बचाना
scared|adjective|डर; डरावन्
scary|adjective|डरावना; दहशतपूर्ण
scene|noun|घटना; तमाशा; मौका
schedule|noun|अनुसूची; योजना लेख; सूची
score|noun|प्राप्त करना; खरोंचना; खरोंच
screen|noun|बचाना; जाली; दिखाया जाना
search|noun|टटोलना; परीक्षण; घुसना
season|noun|मौसम
seat|noun|सीट
second|adverb|दूसरा
secondly|adverb|दूसरा; दूसरे
secret|adjective|गुप्त; गोपनीय; रहस्यमय
secretary|noun|डेस्क; अध्यक्ष; सचिव
seem|linking verb|लगना; प्रतीत होना/लगना/जान पड़ना
sense|noun|दिशा; होश; ज्ञान
separate|adjective|रोकना; निकालना; भिन्न
series|noun|शृंखला; सीरीज; प्रक्रम
serious|adjective|जटिल; महत्वपूर्ण; रहस्यमय
serve|verb|बदला लेना; देना; सहायता करना
service|noun|कार्य; कर्मचारी; सहायता
several|determiner|कई
shall|modal verb|सितारा मछली; गा,गे,गी
shape|noun|नमूना; अनुकूल बनाना; बनावट
sheet|noun|परत; विस्तार; फलक
ship|noun|जहाज़
shoulder|noun|कन्धा; आगे बढना; पहाड़
shout|noun|बुलाना; चीखना; चिल्लाना
shut|adjective|निकाल देना; अटकाना; बन्द करना
side|noun|किनारा
sign|noun|देना; सौंपना; संकेत
silver|adjective|चमकीला; चाँदी; चाँदी के
simple|adjective|सरल
singing|noun|मधुर; गाना; गाना गाना
single|adjective|ऐकल; अकेला; एक
sir|noun|श्रीमान्; श्रीमान; सर
site|noun|बनाना; घटनास्थल; स्थान
size|noun|लगाना; विस्तार; सरेस लगाना
ski|adjective|स्कीइंग का; स्की करना; स्की
skiing|noun|स्कीइंग
skin|noun|छिलना; छिलका निकालना; छिलका
sky|noun|आसमान
sleep|noun|सोना
slowly|adverb|आहिस्ता; विलंबित में; विलंबित
smartphone|noun|
smell|noun|गंध
smile|noun|मुस्कान
smoke|noun|तम्बाकू; असफलता; धूम्रपान
smoking|noun|धूम्रपान; धुम्रपान
soap|noun|साबुन से रगड़ना; साबुन; साबुन लगाना
soccer|noun|फुटबाल
social|adjective|सामाजिक; समाजपरक; सम्मिलित
society|noun|वर्ग; साथ; सभा
sock|noun|प्रहार करना; पीटना; ज़ोर से मारना
soft|adjective|बिखरा हुआ; मुलायम; धीमा
soldier|noun|सैनिक; सिपाहगिरी; प्रचारक
solution|noun|उपाय; समस्या का समाधान करने का तरीका; घोल
solve|verb|हल करना; किसी प्रश्न को हल करना; सुलझ्जाना
somewhere|adverb|कहीं भी; कहिं; कहीं
sort|noun|प्रकार; वर्गीकृत करना; पसन्द करना
source|noun|सूत्र; जड़; स्रोत
speaker|noun|अध्यक्ष; बोलने वाला; वक्ता
specific|adjective|विशिष्ट; विशेष; निश्चित
speech|noun|पंक्ति; भाषा; बोली
speed|noun|चलाना; जल्दी करना; भगाना
spider|noun|मकड़ी; लोहे का हत्थेदार तवा; मकडा
spoon|noun|चम्मच
square|adjective|खरा; बराबर करना; वर्गाकार
stage|noun|कार्य क्षेत्र; प्रस्तुत करना; चरण
stair|noun|सीढ़ी; सीढी
stamp|noun|प्रकार; छाप; पैर घसीट कर चलना
start|noun|शुरू करना
stay|noun|रुकना
steal|verb|चुराना
step|noun|कार्य; कदम; पद
stomach|noun|इच्छा; सहना; उदर
stone|noun|पत्थर
store|noun|दुकान
storm|noun|तूफान
straight|adjective|सीधा; सीधे; लगातार
strange|adjective|निराला; अनोखा; आश्चर्यजनक
strategy|noun|उपाय; युद्ध कला; कूटनीति
stress|noun|दबाव; महत्त्व; जोर
structure|noun|नमूना; संरचना; बनाना
stupid|adjective|मूर्ख; बेवकूफ़; फालतू
succeed|verb|कामयाबी हासिल करना; का जगह; कामयाब होना
successful|adjective|सौभाग्यशाली; सम्पन्न; कामयाब
such|determiner|ऐसा
suddenly|adverb|अचानक
suggest|verb|बताना; प्रस्ताव रखना; संकेत करना
suggestion|noun|संकेत; सुझाव
suit|noun|प्रणय निवेदन; सूट; के लिये ठीक होना
support|noun|प्रमाणित करना; भरण पोषण; भरण पोषण करना
suppose|verb|समझना; लगना; सोचना
surprise|noun|अचम्भा; आश्चर्य; चकित करना
surprised|adjective|आश्चर्यचकित; विस्मित; हैरान
surprising|adjective|आश्चर्यजनक
survey|noun|दर्शाना; सर्वेक्षण; सर्वेक्षण करना
sweet|adjective|मीठा
symbol|noun|चिन्ह; संकेताक्षर; चिह्न
system|noun|शरीर; व्यवस्था; पद्धति
tablet|noun|गोली; टिकिया; बट्टी
talk|noun|बात करना
target|noun|निशाना; क्षेत्र; लक्ष्य
task|noun|काम; हद पार करना; भार
taste|noun|स्वाद
teaching|noun|शिक्षा; शिक्षण; अध्यापन
technology|noun|तकनीकी; तकनीक; प्रौद्योगिकी
teenage|adjective|तेरह से उन्नीस वर्ष की आयु का; तेरह
temperature|noun|ताप; तापमान
term|noun|पद; अवधि; शब्द
themselves|pronoun|स्वयं; खुद
thick|adjective|घनिष्ठ; भारी; बहुत अधिक
thief|noun|चोर; चौर
thin|adjective|पतला
thinking|noun|विचारशील; विचारणा; सोच
third|noun|तीसरा
thought|noun|विचार; मत; इरादा
throw|verb|फेंकना
tidy|adjective|मान्य; स्वच्छ; सजाना
tie|noun|मिलाना; संबंध; लटकाना
tip|noun|गिरना; झुकना; सुझाव
tool|noun|औज़ार
top|adjective|ऊपर
tour|noun|दौर; सैर; याट्रा करना
tourism|noun|पर्यटन
towards|preposition|की तरफ़ से; में; की तरफ़
towel|noun|तौलिये से पोंछना; तौलिया; अंगपोछा
tower|noun|मीनार; कर्षण नौका; हावी होना
toy|adjective|खिलौना
track|noun|पंक्ति; तय करना; फ़ासला
tradition|noun|प्रथा; परम्परा; परंपरा
traditional|adjective|पारंपरिक; परम्परागत; रूढिगत
trainer|noun|प्रशिक्षक; अभ्यास के दौरान पहना जाने वाला जूता
training|noun|प्रशिक्षण; शारीरिक प्रशिक्षण
transport|noun|पहुँचाना; परिवहन; सवारी
traveller|noun|पर्यटक; यात्री; मुसाफिर
trouble|noun|परेशानी
truck|noun|ट्रक; हथठेला; ट्रक से पहुँचाना
twin|adjective|एक सा; समरूप होना; अनुलिपि
typical|adjective|विशिष्ट; आदर्श रूप; प्रतीकात्मक
underground|adjective|गुप्त; भूमिगत; सुरंग रेल
understanding|noun|सहमति; तालमेल; समझदार
unfortunately|adverb|सितारा मछली; दुर्भाग्य से; दुर्भाग्य
unhappy|adjective|उदास; अनुचित; दुःखी
uniform|noun|एक समान; एकसमान त्वरण; बराबर
unit|noun|एक; विभाग; ईकाई
united|adjective|मिश्रित; संगठित; मिश्र
unusual|adjective|अपूर्व; असाधारण; असामान्य
upstairs|adjective|ऊपरी मंज़िल; दिमाग से; ऊपरी
use|noun|उपयोग
used to|modal verb|अभ्यस्त; आदी
user|noun|नशीली दवाओं का आदी; उपभोक्ता; नशीली
usual|adjective|हमेशा; हमेशा का; आम
valley|noun|दर्रा; घाटी; निम्नभूमि
van|noun|अग्रगामी सैन्य टुकड़ी; कारवाँ; अपने क्षेत्र में अग्रणी समूह
variety|noun|प्रजाति; प्रकार; विविधता
vehicle|noun|वाहक; माध्यम; संवाहक
view|noun|दृष्टिकोण; विचार करना; समझना
virus|noun|वाइरस; छूत के रोगों का विष; विषाणु
voice|noun|आवाज़
wait|noun|इंतज़ार करना
war|noun|युद्ध
wash|noun|धोना
washing|noun|धुलाई; धुलाई के कपड़े
wave|noun|करना; दल; घुमाना
weak|adjective|कमज़ोर
web|noun|संचार; जाल बनाना; जाल
wedding|noun|विवाह; ब्याह
weight|noun|लगाना; प्रभाव; महत्व
wet|adjective|नीरस; गीला; निर्जीव
wheel|noun|घुमाना; मोड़ना; पनचक्की
while|conjunction|काल; समय; यद्यपि
whole|adjective|पूरी तरह से; पूर्णतया; पूरा
whose|determiner|जिसक्; किसके; किसका
wide|adjective|चौड़ा
wild|adjective|कर्कश; असभ्य; अविवेचित
wind|noun|हवा
winner|noun|सफल व्यक्ति; विजेता; हासिल करने वाला
wish|noun|इच्छा
wood|noun|पीपा; वन; काष्ठ
wooden|adjective|भद्दा; भावशून्य; लकड़ी
working|adjective|कार्य; कामचलाऊ; तर्कसंगत
worried|adjective|चिंतित; परेशान; आशंकावान
worse|adjective|बहुत तेज़; ज्यादा; बदतर
worst|adjective|जीतना; बुरी तरह से पछाड़ देना; सबसे
wow|exclamation|ज़बर्दस्त मज़ाक; बहुत प्रभावित करना
yet|adverb|अभी तक
yours|pronoun|आपका; तुम्हारा; तुम्हारी
zero|number|शून्य
"""), "en", "A2", "oxford"),

        Lesson("ox-b1", "🦆 Oxford 5000 · B1", "🦆", "730 official Oxford words", ow("""
absolutely|adverb|पूरी तरह से; पूर्णतया; नितान्त
academic|adjective|विद्वान; पण्डिताऊ; अव्यावहारिक
access|noun|दाखिला; खोलना; पैठ
accommodation|noun|सहायता; आवास; समझौता
account|noun|खाता
accounting|noun|लेखा जोखा; लेखा प्रणाली; लेखाविधि
achievement|noun|कार्यसिद्धि; उपलब्धि; निष्पादन
act|noun|काम करना
ad|noun|विज्ञापन; ऐडी
addition|noun|अनुवृद्धि; वृद्धि; जोड़
admire|verb|समादर करना; प्रशंसा करना; सराहना करना
admit|verb|स्वीकार करना; अनुमति देना; अंदर आने की अनुमति देना
advanced|adjective|विकसित; उन्नत; प्रगतिशील
advise|verb|सूचित करना; सूचना देना; सुझाव देना
afford|verb|देना; जुटा पाना{धन}; ख़र्च करना
aged|adjective|बूढा; वृद्ध; आयु का
agent|noun|कर्ता; पदार्थ; कारण
agreement|noun|वचन; सहमति; करार
ahead|adverb|आगे; पहले से; पहले
aim|noun|करना; लगाना; लक्ष्य
alarm|noun|भयभीत करना; घंटी; खतरे का
album|noun|एलबम; एलबम/संग्रहपुस्तक
alcohol|noun|अल्कोहल; मद्य; मद्यसार{अलकोहल}
alcoholic|adjective|पियक्कड़; शराबी; मादक
alternative|adjective|एवजी; विकल्प; वैकल्पिक
amazed|adjective|आश्चर्यचकित; अचम्भित
ambition|noun|महत्वाकांक्षा; अभिलाषा; उमङ्ग
ambitious|adjective|उच्चाकांक्षी; महत्वाकांक्षी
analyse|verb|मनोविश्लेषण; विश्लेषण करना; विश्लेशण करना
analysis|noun|विश्लेषण; समीक्षा
angrily|adverb|क्रोध से; गुस्से
announce|verb|घोषणा; उद्घोषणा करना; घोषित
announcement|noun|सूचना; घोषणा; विज्ञापन
annoy|verb|परेशान करना; चिढ़ाना/सताना; खीजाना
annoyed|adjective|नाराज़
annoying|adjective|खीझ दिलाने वाला; खिझाऊ; खीझ दिलाने
apart|adverb|दूर; अलग; अलग अलग
apologize|verb|क्षमा मांगना
application|noun|संबंध; लागू; परिश्रम
appointment|noun|वचन; नियुक्ति; नौकरी
appreciate|verb|क़दर करना; प्रशंसा करना; महसूस करना
approximately|adverb|लगभग; करीब करीब; तकरीबन रूप से
arrest|noun|रोकना; अवरोध; आकर्षित करना
arrival|noun|आने वाला; आगमन; जन्म
assignment|noun|नियुक्ति; काम; सौंपा हुआ कार्य
assist|verb|मदद करना; सहायता देना; सुविधा देना
atmosphere|noun|वायुमण्डल; परिमण्डल; वातावरण
attach|verb|लगाना; देना; संलग्न
attitude|noun|मुद्रा; रवैया; प्रवृति
attract|verb|आकर्षित करना; आकर्षित; आकृष्ट करना
attraction|noun|आकर्षण
authority|noun|अधिकारी; विशेषज्ञ; अधिकार
aware|adjective|अवगत; परिचित; सचेत
backwards|adverb|पीछे; पीछे की; उल्टे
bake|verb|गर्म करना; तैयार; तैयार करना
balance|noun|बराबर करना; हिचकिचाना; सँभालना
ban|noun|मना करना; निषेध; निषेध करना
base|noun|आधार
basic|adjective|मूल; मूलभूत; बेसिक
basis|noun|आधार
battery|noun|समूह; तोपखाना; संग्रह
battle|noun|लड़ाई/युध्द; सामना करना; कोशिश करना
beauty|noun|सुन्दरता; अच्छी चीज़; सौंदर्य
bee|noun|मधुमक्खी
belief|noun|भावना; भरोसा; दृढ विश्वास
bell|noun|बो बो करना; घंटी; घंटी लगाना
bend|noun|झुकाना; बदलना; खराब
bite|noun|परेशान करना; स्वीकार करना; व्यक्त करना
block|noun|रोकना; कील; बाधा
bomb|noun|असफल होना; बम; बम फेंकना
border|noun|किनारा; सीमा; पट्टी
bother|verb|परेशान करना; कष्ट देना; परेशानी
branch|noun|ज्ञान विषय; बेलबूटे; बेलबूटे काढना
brand|noun|प्रकार; छाप; लुआठा
brave|adjective|ललकार; ललकारना; सामना करना
breath|noun|विराम; संकेत; झोंका
breathe|verb|आराम करना; बहना; साँस लेना
breathing|noun|श्वसन; अंतःश्वसन
bride|noun|नववधू/दुल्हन; दुल्हन; नववधू
bubble|noun|धोखा; धोखा देना; खदबदाना
bury|verb|अंत्योष्टि क्रिया करना; डालना; जमीन में गाड़ देना
by|adverb|द्वारा
calm|adjective|शांत करना; ठहराव; निश्चलता
campaign|noun|अभियान; अभियान्; अभियान चलाना
campus|noun|परिसर
candidate|noun|व्यक्ति; अभ्यर्थी/उम्मीदवार/पदान्वेषी/पदाभिलाषी/परीक्षार्थी/प्रत्याशी/प्रवेशार्थी/प्रार्थक; उम्मीदवार
cap|noun|शिखर; टोपी पहनाना; कुकुरमुत्ता
captain|noun|प्रमुख; जहाज़अ; संचालन करना
careless|adjective|कच्चा; आलसी; लापरवाह
category|noun|वर्ग; वर्गीकृत ,वर्गीकरण
ceiling|noun|छत
celebration|noun|समारोह; उत्सव; उत्सव/खुशी मनाना
central|adjective|प्रमुख; मुख्य; प्रधान
ceremony|noun|अवसर; अतिशयोक्ति; विधि
chain|noun|बंधन; क्रम; नापना
challenge|noun|टोकना; दावा करना; ललकार
champion|noun|सर्वोत्तम; लड़ने; शूरवीर
channel|noun|पहुं़चाया; पहुं़चाया जाना; नहर
chapter|noun|सभा; याजक सभा; अध्याय
charge|noun|आक्रमण; लगाना; उत्तरदायी
cheat|noun|कपटी; ठग; धोखा
cheerful|adjective|चमकीला; आनन्दित; प्रसन्न
chemical|adjective|रासायनिक पदार्थ; रसायनिक द्रव्य; रासायन संबंधी
chest|noun|कोष; तिजोरी; छाती
childhood|noun|बाल्यावस्था; बचपन
claim|noun|दावा करना; का पात्र होना; लेना
clause|noun|परिच्छेद; अनुच्छेद; उपवाक्य
cleaning|noun|सफाई
click|noun|घुल मिल; खट खट; अचानक समझ
client|noun|उपभोगता; ग्राहक; असामी
climb|noun|चढ़ना
cloth|noun|पादरी; वस्ट्र; मेज़पोश
clue|noun|सूत्र; सुराग; संकेत
coal|noun|कोयला भरना; कोयला उपलब्ध करना; अंगार
coin|noun|बनाना; मुद्रा; गढ़ना
collection|noun|जमाव; समूह; ढेर
coloured|adjective|रंगीन; रंजित
combine|verb|मिलना[मिलाना]; जत्था; मिलाना
commercial|adjective|विज्ञापन; मामूली; व्यावसायिक रूप से
commit|verb|करना; लिखना; वचनबद्ध होना
communication|noun|सूचना; संचार; सम्पर्क
comparison|noun|तुलनात्मक; समानता; तुलना
competitive|adjective|प्रतियोगिता संबन्धी; प्रतिस्पर्धात्मक; प्रतिस्पर्धापूर्ण
competitor|noun|प्रतिद्वंदी; प्रतिस्पर्ध्दी; प्रतियोगी
complaint|noun|शिकायत; झगड़ा; रोग
complex|adjective|जटिल; पेचीदा; ग्रन्थ्
concentrate|verb|ध्यान; ध्यान केन्द्रित करना; ध्यान देना
conclude|verb|निश्चित करना; तय करना; समाप्त होना
conclusion|noun|समाप्ति; निष्कर्ष; अंतिम निर्णय
confident|adjective|निडर; कभी न; विश्वासपूर्ण
confirm|verb|निश्चित करना; पक्का करना; पक्का ईसाई बनाना
confuse|verb|मिलाना; उलझा देना; गड़बड़ा देना
confused|adjective|असंगत; अस्पष्ट; हैरान
connection|noun|नाता; संबन्ध; संपर्क
consequence|noun|परिणाम; नतीजा; सामाजिक
consist|verb|होना; शामिल होना; युक्त हो
consume|verb|खाना; जलाना; काम में लाना/व्यय करना
consumer|noun|उपभोगता; उपभोक्ता
contact|noun|सम्पर्क; सम्बन्ध; रोग
container|noun|आधान; पात्र; धारक/पात्र
continuous|adjective|सतत; लगातार; लागातार
contrast|noun|फर्क; विरोध; फर्क दिखाना
convenient|adjective|सरल; सुविधा; उचित
convince|verb|दृढ़ मत होना; विश्वास; समझा देना
costume|noun|पोशाक; पहनावा; कस्टयूम
cottage|noun|झोपड़ी; कुटी; मड़ई
cotton|noun|धागा; सूती; सूती कपड़ा
count|noun|गिनना
countryside|noun|देहात; ग्रामीण क्षेत्र
court|noun|चाहना; अदालत; बुलाना
cover|noun|ढकना
covered|adjective|आच्छादित; आवृत; बाँधा गया
cream|adjective|हराना; स्वादिष्ट; पराजित करना
criminal|adjective|पापी; अपराधी; दण्ड
cruel|adjective|कठोर; निर्दय; निर्दयता से
cultural|adjective|सांस्कृतिक
currency|noun|मुद्रा; लोकप्रियता; व्यापकता
current|adjective|प्रवृत्ति; प्रवाह; धारा
currently|adverb|इस समय; आजकल; वर्तमान में
curtain|noun|बाधा; नाटक; पर्दा
custom|noun|दर्ज़ी से सिली हुई; रीति; प्रथा
cut|noun|काटना
damage|noun|क्षति; क्षति पहुँजाना; बिगाड़ना
deal|noun|चलाना; देना; बहुत सारा
decade|noun|दशक
decorate|verb|पदक प्रदान करना; सजाना; दीवारी कागज़
define|verb|बताना; सीमांकन करना; स्पष्ट करना
definite|adjective|स्पष्ट; निश्चित
definition|noun|रूपरेखा की; स्पष्ट; व्याख्या
deliver|verb|बताना; करना; प्रकट करना
departure|noun|हट; रवानगी; प्रस्थान
despite|preposition|के; के बावजूद; होने पर भी
destination|noun|अंतिम लक्ष्य; अभिप्राय; अंतिम
determine|verb|निश्चित करना; तय करना; निर्धारित करना
determined|adjective|निर्धारित; दृढ संकल्पी; दृढ
development|noun|सुधार; विस्तार; आविष्कार
diagram|noun|चित्र; आकृति; आकृतिय़ा
diamond|noun|हीरा; ईंट का पत्ता; बेसबल
difficulty|noun|समस्या; कठिनता; कठिनाई
directly|adverb|सीधे; जल्दी; तुरन्त
dirt|noun|पखाना; मिट्टी; कचरा
disadvantage|noun|प्रतिकूल; नुक्सान; प्रतिकूल परिस्थिति
disappointed|adjective|निराश; हताश; दुख्ःई
disappointing|adjective|निराशाजनक
discount|noun|कम करना; खंडन करना; छूट
dislike|noun|घृणा; नापसंद करना; द्वेष
documentary|noun|लिखित; डॉक्यूमेन्टरी; वृत्त चित्र
donate|verb|दान करना; दान देना; दान
doubt|noun|संदेह करना; पर संदेह करना; पर शंका होना
dressed|adjective|तैयार; पहना; पहना हुआ
drop|noun|गिराना
drum|noun|पीपा; थपथपाना; पीटना
drunk|adjective|नशे में; नशे में धुत्त; पियक्कड़
due|adjective|सीधे; उचित; उप्युक्त
dust|noun|पोंछना; लाश; मिट्टी
duty|noun|काम; कर्तव्य; कर
earthquake|noun|भूचाल; भूकम्प; भुकम्प
eastern|adjective|पूर्व की ओर; पूर्वी; पूर्व
economic|adjective|अर्थशास्त्रीय; आर्थिक
economy|noun|अर्थ प्रबन्धन; अर्थव्यवस्था; कमखर्ची
edge|noun|किनारा; उकसाना; किनारा लगाना
editor|noun|संपादक; सम्पादक
educate|verb|सिक्षा देना; शिक्षा देना; सिखना
educated|adjective|शिष्ट; शिक्षित
educational|adjective|शैक्षणिक; शैक्षिक
effective|adjective|प्रभावशाली; वास्तविक; कार्यकारी
effectively|adverb|असल में; सफलतापूर्वक; प्रभावपूर्ण ढंग से
effort|noun|प्रयास; प्रयत्न; सफलता
election|noun|चुनाव
element|noun|तत्व; अंश; लोग
embarrassed|adjective|लज्जित; शर्मिंदा
embarrassing|adjective|लज्जाजनक
emergency|noun|एमर्जेंसी; आपात; आपात काल
emotion|noun|भावना; उमङ्ग; जज़्बा
employment|noun|काम; आजीविका; नौकरी
encourage|verb|प्रोत्साहित; उत्तेजित करना; उकसाना
enemy|noun|दुश्मन
engaged|adjective|व्यस्त; विवाह हेतु वचनबद्ध
engineering|noun|अभियान्त्रिकी; कल बनाने की विद्या; अभियांत्रिकी
entertain|verb|सुनना; विचार करना; विचार
entertainment|noun|तमाशा; मनोरंजन; मौज
entrance|noun|प्रवेश द्वार
entry|noun|दहलीज; प्रवेशाधिकार; द्वार
environmental|adjective|वातावरण; वातावरण सम्बन्धी; प्राक्रतिक वातावरण से संबंधित
episode|noun|वृतान्त; घटनाअना; कड़ी
equal|adjective|की बराबरी; समान; सक्षम
equally|adverb|समान रूप से; समान रूप; साथ ही साथ
escape|noun|राहत; बचाव; भाग जाना
essential|adjective|अनिवार्य; महत्वपूर्ण; प्रधान
eventually|adverb|अंत में; आखिरकार; अंततोगत्वा
examine|verb|समझना; परखना; पूछना
except|conjunction|सिवाय
exchange|noun|करना; बदल देना; केन्द्र
excitement|noun|बेक़रारी; उत्तेजना; उतावलापन
exhibition|noun|प्रदर्शनी; प्रदरशनी; नुमाइश
expand|verb|फैलना; फैलाना; फैल जाना
expected|adjective|अपेक्षित; इंतज़ार
expedition|noun|अभियान; अभियान दल
experienced|adjective|अनुभवी
explode|verb|बताना; नष्ट करना; विस्फोटित होना
explore|verb|अन्वेषण; खोज करना; अन्वेषण करना
explosion|noun|विस्फोट; धमाका; अचानक वृद्धि
export|noun|निर्यात करना; निर्यात
fairly|adverb|पूरी तरह से; ठीक से; कामचलाऊ ढंग से
familiar|adjective|घनिष्ठ; साधारण; शिष्ठाचार
fancy|adjective|चाहना; कल्पना करना; अनोखा
far|adjective|दूर
fascinating|adjective|दिलचस्प; आकर्षक
fashionable|adjective|प्रचलित; फैशन परस्त; आधुनिक प्रणाली के
fasten|verb|थोपना; अटकाना; निर्धारित करना
favour|noun|पसन्द करना; साथ देना; साथ
feeding|noun|
fence|noun|बाड़ा; उत्तर देने से बचना; घेरना
fighting|noun|युद्धरत; मारपीट; लड़ाई
file|noun|रेती; पंक्ति; चिकना करना
financial|adjective|वित्तीय; आर्थिक
fitness|noun|योग्यता; स्वस्थ होना; दुरुस्ती
fixed|adjective|स्थिर; निर्धारित; स्थायी
flag|noun|लम्बे बालों वाला शिकारी कुत्ता; कमज्ॅओर पड़ जाना; कम होना
flood|noun|सैलाब; ज्वार; भरना
flour|noun|पीस; पीसना; आटा
flow|noun|बहना; प्रवाह; चलना
folk|adjective|लोग; जनता; लोक परम्परानुसार
force|noun|बल; गुण; दल
forever|adverb|हमेशा; हमेशा के लिए; सदैव
frame|noun|किनारा; तैयार; बनावट
freeze|verb|जमना; ठंढा करके सुरक्षित रखना; स्थिर रखना
frequently|adverb|बहुधा; प्रायः
friendship|noun|मैत्री; दोस्ती
frighten|verb|भयभीत करना; डराना; भयभीत
frightened|adjective|आतंकित; भयभीत; भयग्रस्त
frightening|adjective|डरावना; भयानक
frozen|adjective|स्तंभित; जमी हुई; जमा
fry|verb|तलना; मछली के बहुत छोटे छोटे बच्चे; झुलसा देना
fuel|noun|ईंधन; डालना; उत्तेजक
function|noun|कार्य; प्रकार्य; कार्य करना
fur|noun|लोमदार जानवरों की; रोएँदार; बीमारी में जिह्वा पर होने वाली तह
garage|noun|गैरज में; गाड़ीखाना में; गैरेज
gather|verb|प्राप्त करना; समझना; काटना
generally|adverb|अक्सर; प्रा; व्यापक रुप से
generation|noun|युग; प्रजनन; युगअ
generous|adjective|बहुत; उदारता; तीक्ष्ण
gentle|adjective|धीमा; हल्की; हल्का
gentleman|noun|रईस व्यक्ति; सज्जन; कुलीन व्यक्ति
ghost|noun|भूत; प्रेतात्मा; फीकी
giant|adjective|दैत्य; विशाल; देव
glad|adjective|खुश
global|adjective|व्यापक; सार्वभौम; विश्वव्यापी
glove|noun|दस्ताना
go|noun|जाना
goods|noun|गोदाम; सामान; वस्तु
grade|noun|कोटि; पद; वर्गीकृत करना
graduate|noun|स्नातक; डीग्री प्रप्त; स्नातकोत्तर
grain|noun|कण; स्वभाव; बीज
grateful|adjective|आभारी; सुखद; कृतज्ञ
growth|noun|पौधा; सूजन; वृध्दि
guard|noun|पहरेदार; बचाव; रक्षण करना
guilty|adjective|अपराधी; दोषी; गुनहगार
hang|verb|लटकना; टाम्गना; छाना
happiness|noun|सौभाग्य; सुख शान्ति; खुशी
hardly|adverb|मुश्किल; शायद ही; मुश्किल से
hate|noun|घृणा करना; घृणा; द्वेष
headline|noun|शीर्षक; मुख्य शीर्ष में; मुख्य शीर्ष में देना
heating|noun|ताप; गरम करने की पद्धति; तापक
heavily|adverb|बहुत अधिक; बहुत
helicopter|noun|हेलिकोप्टर
highlight|noun|चमक; चिन्हांकित करना; विशिष्टता
highly|adverb|अत्यधिक; बहुत अधिक; प्रशंसापूर्वक
historic|adjective|ऐतिहासिक; इतिहास  प्रसिध्द
historical|adjective|ऐतिहासिक; इतिहास सम्बन्धी; इतिहास वादी
honest|adjective|खरा; निष्कपट; ईमानदार
horrible|adjective|डरावना; भयानक; खराब
horror|noun|डर; दहशत; विभीषिका
host|noun|आयोजित करना; आयोजित; समूह
hurricane|noun|तूफान
hurry|noun|जल्दी करना
identity|noun|पहचान; तादात्म्य; ऐक्य
ignore|verb|ध्यान न देना; अनसुनी करना; अनदेखा
illegal|adjective|अवैध; नियम विरुद्ध; अवैध,गैरकानूनी
imaginary|adjective|झूठा; अधिकल्पित; काल्पनिक
immediate|adjective|मूल; सन्निहित; तत्काल
immigrant|noun|अप्रवासी; देशांतर में बसनेवाला
impact|noun|प्रभाव; टक्कर; धक्का
import|noun|महत्व; आयात; बुलाया जानाना
importance|noun|प्रतिष्ठा; महत्व; गुरुत्व
impression|noun|प्रभाव; दिखावा; धारणा
impressive|adjective|प्रभावशाली
improvement|noun|सुधार; प्रगति; उन्नति
incredibly|adverb|बहुत ही; बहुत; आश्चर्यजन्क रूप से
indeed|adverb|वास्तव में; निश्चित; सचमुच
indicate|verb|दिखाना; सूचित करना; संकेत
indirect|adjective|चक्करदार; अपरोक्ष; परोक्ष
indoor|adjective|भीतरी; आंतरिक; घर
indoors|adverb|घर के; घर के भीतर; घर के अंदर
influence|noun|प्रभाव; प्रभावित करना; प्रेरित करना
ingredient|noun|उपादान; घटक; संघटक
injure|verb|घायल; नुकसान पहुच्ना; ज़ख़्मी करना
injured|adjective|घायल; आहत; दोषित
innocent|adjective|निर्दोष; अहानिकर; निष्कपट
intelligence|noun|सूचना; ज्ञान; गुप्त समाचार
intend|verb|चाहना; विचार होना; रखना
intention|noun|धारणा; विचार; अंतिम लक्ष्य
invest|verb|धन लगाना; लगाना; देना
investigate|verb|पता लगाना; अनुसंधान करना; सोच विचार करना
involved|adjective|जटिल; पेचीदा; संबद्ध
iron|noun|कर्कश; कठोर; निर्दय
issue|noun|मिलना; देना; प्रकाशन
IT|noun|यह
journal|noun|पत्रिका; डायरी; समाचार पत्र{साप्ताहिक या मासिक}
judge|noun|निर्णायक; अस्थाई न्यायाधिकारी; फ़ैसला सुनाना
keen|adjective|अत्यधिक; नुकीला; तीव्र
keyboard|noun|कुंजी पटल; स्वर पटल; कीबोरड
kick|noun|परेशान करना; चलाना; निकालना
killing|noun|घातक; हत्या; थकाऊ
kind|adjective|दयालु
kiss|noun|चूम्मा लेना; उड़ता; रसगुल्ला
knock|noun|खटखटाना; प्रहार करना; टक्कर
label|noun|नाम; वर्गीकरण करना; उपनाम
laboratory|noun|प्रयोगशाला; प्रयोगस्थल
lack|noun|कमी; अभाव; कमी के कारण
latest|adjective|नया; नवीनतम; आधुनिकतम
lay|verb|करना; गिरा देना; देना
layer|noun|परत; अण्डा देने वाली मुर्गी; मुर्गी
lead|noun|नमूना; प्रमुख; राय देना
leading|adjective|प्रमुख; प्रथम; मुख्य
leaf|noun|पत्ते निकलना; पन्ना; पत्ता
leather|noun|फुटबाल; मूर्ख; सख्त
legal|adjective|कानूनी; वैग; विधिक
leisure|noun|खाली समय/फुरसत; फुरसत
length|noun|बढ्ना; विस्तार; हद
level|adjective|परत; सपाट; समतल
lie|noun|झूठ
like|noun|पसंद करना
limit|noun|मर्यादा; हद; सीमा
lip|noun|होंठ
liquid|adjective|स्पष्ट; स्वच्छ; प्रवाही
literature|noun|साहित्यिक; साहित्यिक सामग्री; रचना
live|adjective|जीना
living|adjective|जीवित; आजीविका; क्रियाशील
locate|verb|पता लगाना; अवस्थित होना; स्थापित करना
located|adjective|स्थित
location|noun|ठिकाना; स्थान; स्थापन
lonely|adjective|शान्त; अकेला; एकांत
loss|noun|नष्ट करना; असफल; हानि
luxury|adjective|आराम; आनन्द; समृद्धि
mad|adjective|पागल
magic|adjective|जादुई; माया; जादू करना
mainly|adverb|मुख्य रूप से; प्रमुख रूप से
mall|noun|माल; माल{एक बड़ी बिल्डिंग जिसके अन्दर पूरा बाजार हो}
management|noun|व्यवस्था; प्रबंध; प्रबन्धन
marketing|noun|दुकानदारी; विपणन
marriage|noun|शादी; विवाह; पाणि ग्रहन् संस्कार
meanwhile|adverb|इस बीच; इसी दौरान
measure|noun|ताल; मर्यादा; काफ़ी
medium|adjective|मध्य स्थान; मध्य; माध्यमअ
mental|adjective|पागल; दिमागी; मनोवृति
mention|noun|चर्चा; कहना; उल्लेख करना
mess|noun|गंदगी; भोजनालय; झंझट
mild|adjective|हल्का; सुहावना; विनम्र
mine|noun|खान खोदना; सुरंग लगना; खान
mix|noun|मिलना; मिश्रण; मिलाना
mixture|noun|मिश्रण; घोल; मिलावट
mood|noun|मुद्रा; मनोदशा; अवस्था
move|noun|हिलना
mud|noun|कीचड्ॅअ में; कीचड्ॅअ पोतना; मिट्टी
murder|noun|टेढ़ी; बरबाद करना; हत्या करना
muscle|noun|ताकत; जबरदस्ती करना; पेशी
mystery|noun|रहस्यवादी; रहस्यमय; रहस्य
nail|noun|लगाना; कील; बंद करना
narrative|adjective|कथा; विवरणात्मक; वर्णात्मक कहानी
nation|noun|जाति; राज्य; राष्ट्र
native|adjective|मूल; जन्मजात; देशी
naturally|adverb|प्राकृतिक रुप से; बेशक; स्वभाविक रूप से
necessarily|adverb|आवश्यक रूप; आवश्यक रूप से; अनिवार्य रूप से
needle|noun|सीलाई करना; स्फटिक; चोटी
neighbourhood|noun|क्षेत्र; इलाका; पड़ोस
neither|adverb|कोई भी नहीं; न; नहीं
nor|adverb|न; और; और न
northern|adjective|उत्तरदेशी; उत्तरी; उत्तर देशी
nuclear|adjective|आणविक; नाभिकीय
obvious|adjective|सुस्पष्ट; स्पष्ट; साक्षात्
obviously|adverb|स्पष्ट रुप से; स्पष्टः
occasion|noun|घटना; अवसर; कारण बनना
occur|verb|घटना; होना; घटित होना
odd|adjective|विषम; असंगत; असामयिक
official|adjective|प्रामाणिक; अधिकारी; सरकारी
old-fashioned|adjective|
operation|noun|कार्य; आपरेशन; काम
organized|adjective|एकीकृत; सुनियोजित; संगठित
organizer|noun|आयोजक; व्यवस्थित; प्रबंधक
originally|adverb|स्पष्टतः; आदि में; शुरु शुरु में
ought|modal verb|कर्तव्य; चाहिये
ours|pronoun|हमारा/अपना; हमाराआ
outdoor|adjective|बाहरी; बाह्य; खुली हवा में
outdoors|adverb|बाहर; खुले मैदान; गाँव का माहौल
pack|noun|समूह; दल; वृंद
package|noun|भरना; पैकेज; पैकेट
painful|adjective|भद्दा; कठिन; दर्दीला
pale|adjective|बाल्टी; मुरझाया; घेरना
pan|noun|मालपुआ; सितारा मछली; घुमाना
participate|verb|भाग लेना; भागीदार होना; शरीक होना
particularly|adverb|विशेष रुप; खास तौर पर; विशेष रुप से
pass|noun|पास करना
passion|noun|इश्क; क्रोध; धुन
path|noun|मार्ग; कार्यप्रणाली; रास्ता
payment|noun|इनाम; भुगतान; प्रतिकार
peaceful|adjective|शांतिप्रिय; शांतिपूर्ण
percentage|noun|अंश; अनुपात; प्रतिशतता
perfectly|adverb|सितारा मछली; पूर्णतः; अच्छी तरह से
performance|noun|कार्य; प्रदर्शन; क्रिया
personally|adverb|स्वयं; खुद; व्यक्तिगत रूप से
persuade|verb|विश्वास दिलाना; मनाना; समझाना
photographer|noun|छायाकार; सितारा मछली; फोटोग्राफर
photography|noun|चायाचिट्रण; फ़ोटोग्राफी; छायाचित्रण
pin|noun|कील; छेदना; भरोसा करना
pipe|noun|बोलना; बाँसुरी; गाना
planning|noun|आयोजन; योजना; नगर योजना
pleasant|adjective|हँसमुख; सुखद; मज़ेदार
pleasure|noun|खुशी; हर्ष; सूख
plenty|pronoun|बहुत; अनेक; अधिक मात्रा में
plot|noun|कथानक; भूभाग; षड्यंत्र
poem|noun|कविता; कृति; रचना
poet|noun|पद्यकार; शायर; कवि
poetry|noun|कविता; शायरी; काव्य
poison|noun|ज़हर देना; घातक; दूषित आहार
poisonous|adjective|विद्वेषपूर्ण; विषैला; जहरीला
policy|noun|नीति; बीमा पत्र; शासन की चाल
political|adjective|शासन विषयक; राजनैतिक; शासन
politician|noun|नीतिज्ञ; राजनेता; राजनीतिज्ञ
politics|noun|कूटनीति; राजनीति विज्ञान; राजनीति
port|noun|चिमनी; बंदरगाह; पोर्ट
portrait|noun|छायाचित्र; रूपचित्र; वर्णन
possibly|adverb|संभव हो सकना; सम्भवतः; शायद
pot|noun|सितारा मछली; बरतन; रखना
pour|verb|बहना; निकालना; देना
poverty|noun|कमी; अभाव; अनुवर्रता
powder|noun|पाउडार; पीसना; चूर्ण
powerful|adjective|प्रभावशाली; सशक्त; शक्तिशाली
practical|adjective|व्यावहारिक; अभ्यास; उपयोगी
pray|verb|प्रार्थना करना
prayer|noun|पूजारी; मांग; आराधक
prediction|noun|भविष्य कथन; भविष्यवाणी
prepared|adjective|बना; तैयार किया हुआ; तैयार
presentation|noun|प्रदर्शन; व्याख्यान; उपहारअ
press|noun|दबाव; प्रोत्साहित करना; घबराहट
pressure|noun|बल; प्रभाव; दबाव
pretend|verb|दावा करना; अभिनय करना; मान लेना
previous|adjective|पिछला; पूर्व; पूर्ववर्ती
previously|adverb|पहले
priest|noun|पादरी; पुजारी; पुरोहित
primary|adjective|मुख्य; मूल; प्रधान
prince|noun|युवराज; सामन्त; राजा
princess|noun|राजकुमारी; राजपत्नी
printing|noun|छपाई; संसकरण
prisoner|noun|कैदी; राजबन्दी; बन्दी
private|adjective|गुप्त; साधारण; आत्मीय
producer|noun|उत्पादक; निर्माता; सूट्रधार
production|noun|प्रदर्शन; निर्माण; प्रोग्राम क सँयोजन
profession|noun|वचन; घोषणा; धंधा
profit|noun|योग्य; लाभ; मुनाफ़ा
promote|verb|सहायता करना; प्रचार करना; विक्री करना
proper|adjective|ठीक; उचित; व्यक्ति वाचक
properly|adverb|ठीक से; उचित ढंग से
property|noun|गुण; स्वभाव; अधिकार
protest|noun|विरोध करना; विरोध; प्रतिवाद
proud|adjective|गर्वित
prove|verb|प्रमाणित करना; परखना; परीक्षण करना
pull|noun|खींचना
punish|verb|दण्ड देना; धावा बोलना; सजा देना
punishment|noun|शासन; दंड; ताड़ना
push|noun|धकेलना
qualification|noun|प्रतिबन्ध; अर्हता; योग्यता
qualified|adjective|सीमित; योग्यता; परिमित
qualify|verb|सुधारना; अधिकार देना; योग्य ठहराना
queue|noun|पंक्ति; लाइन; चोटी
quit|verb|छोड़ देना
quotation|noun|भाव विवरणअ; अवतरण; भाव
quote|noun|प्रस्तुत करना; उद्धृत करना; उद्घृत करना
racing|noun|दौड़ में भाग; दौड़ में भाग लेनेवाला
range|noun|प्रकार; पंक्ति; श्रेणी
rare|adjective|निराला; असामान्य; दुर्लभ
rarely|adverb|कभी; कदाचित; कभी कभार
reaction|noun|प्रभाव; पदार्थों का एक दूसरे पर रासायनिक प्रभाव; प्रगति मे बाधा
reality|noun|असलियत; ह्कीकत; वास्तविकता
receipt|noun|पाना; प्राप्ति; पावती
recommendation|noun|विशेषता; समझौता; सिफ़ारिश
reference|noun|सम्बन्ध; निर्देश; टिप्पणी
reflect|verb|विचार करना; दर्शाना; प्रतिबिंबित करना
regularly|adverb|नियमित रूप से
reject|verb|अस्वीकार करना; निकाल देना; बेकार
relate|verb|बताना; वर्णन करना; संबंध रखना
related|adjective|जुड़ा हुआ; सम्बद्धित; संबंधी
relation|noun|नाता; संबंध; रिश्तेदारी
relative|adjective|अनुरूप; तुलनात्मक; सगा
relaxed|adjective|आरामदेह; शिथिल; नरम
relaxing|adjective|आरामदेह
release|noun|बताना; प्रदर्शन; निकालना
reliable|adjective|भरोसेमंद; विश्वसनीय; अच्छा
religion|noun|भक्ति; परमात्मा के अस्तित्व में विश्वास; धर्म
religious|adjective|धार्मिक; दार्मिक; ईमानदार
remain|verb|रहना; बाकी रहना; भग्नावशेष
remind|verb|याद; चेताना; याद दिलाना
remote|adjective|अल्प; दूरवर्ती; अलग
rent|noun|किराया
repair|noun|जमाव; मरम्मत; सुधार
repeat|noun|पुनराव्रत्ति; पहले के समान भेजा हुआ नया; पुनरावृत्ति
repeated|adjective|आवर्ती; पुनरावर्ती; दोहराया गया।
represent|verb|प्रदर्शन करना; प्रस्तुत करना; रखना
require|verb|चाहना; आदेश देना; इच्छा करना
reservation|noun|रक्षण खंडअ; कारण; आरक्षित भूमि
resource|noun|सहारा; स्रोत; साधन
respect|noun|ध्यान; ध्यान रखना; प्रशंसा करना
responsibility|noun|उत्तरदायित्व; ज़िम्मेदारी; दाय
responsible|adjective|उत्तरदायी; उत्तरदायित्वपुर्ण; व्यक्तिगत जिम्मेदारी
retire|verb|बाहर निकल; अवकाश लेना; पीछे हटना
retired|adjective|अवकाश प्राप्त; सेवानिवृत्त
revise|verb|संशोधित करना; बदलना; सुधारना
rise|noun|उदय होना; निकलना; चढना
risk|noun|जोखिम; ख़तरा; जोखिम उठाना
robot|noun|यंत्रमानव; यंत्रवत काम करनेवाला
roll|noun|बराबर करना; पिण्ड; तरंगित होना
romantic|adjective|अवास्तविक; रोमानी; अव्यावहारिक
rope|noun|रस्सी; डोरी; रस्सी से बाँधना
rough|adjective|कच्चा; कर्कश; कठोर
row|noun|चलाना; झिड़की; पंक्ति
royal|adjective|राजसी; बहुत बड़ा पाल; राजपरिवार का
rugby|noun|रग्बी फुटबाल; रग्बी
safety|noun|सुरक्षा; अहानिकारकता; सुरक्षित स्थान
sail|noun|चलाना; समुद्री यात्रा; निकल जाना
sailor|noun|नाविक; पनामा टोपी; नौसैनिक
sample|noun|नमूना; प्रति रूप; प्रतिदर्श
sand|noun|रेत
scan|verb|नज़र दौड़ाना; चारों तरफ़ घूमना; पर्यवेक्षण करना
scientific|adjective|वैज्ञानिक; विज्ञान संबंधी; विज्ञान
script|noun|आलेख; उत्तर पुस्तिका; हस्तलिपि
sculpture|noun|मूर्तिकला; मूर्ति बनाना; मूर्ति
secondary|adjective|अप्रधान; मुख्य; दूसरे क्रम का
security|noun|सुरक्षा; सुरक्षा उपाय; प्रतिभूति
seed|noun|बीज; छाँटना; दाना
sensible|adjective|विवेकपूर्ण; सतर्क; व्यावहारिक
seriously|adverb|गंभीर मसला; गंभीरता से; गंभीर रुप से
servant|noun|कर्मचारी; नौकर; सेवक
set|noun|घटना; करना; अटल
setting|noun|जड़ा; समायोजन; स्थान
sex|noun|उत्तेजित करना; वर्ग; काम
sexual|adjective|कामुक; लैंगिक; मैथुनिक
shake|noun|झटका; घुमाना; मिलाना
share|noun|साझा करना
sharp|adjective|उच्च; कटु; विषम
shelf|noun|खाना; पट्टी; सेल्फ
shell|noun|गोलाबारी करना; खोल; सीप
shift|noun|कार्य पाली; परिवर्तन; लगाना
shine|verb|चमकाना; चमक; प्रकाशित होना
shiny|adjective|चमकीला; चमकदार; धूपदार
shy|adjective|दूर; कम; शर्मीला
sight|noun|दृश्य; दिखाई देना; दर्शन
signal|noun|संकेत; उत्कृष्ट; चिन्ह
silent|adjective|निष्क्रिय; अनुच्चरित; शांत
silly|adjective|मूर्ख; मूष्ख; नासमझ
similarity|noun|समानता; समनता; सादृश्य/समानता
similarly|adverb|एक जैसे; समान रूप से/उसी प्रकार से; उसी तरह
simply|adverb|पूरी तरह से; आसानी से; केवल
since|adverb|से
sink|verb|घटना; होना; निकालना
slice|noun|हिस्सा; अंशअ; टुकड़ा
slightly|adverb|कुछ हद तक; दुबले ढंग से; थोड़ा सा
smart|adjective|बुद्धिमान; अच्छा; स्वच्छ/सुव्यवस्थित
smooth|adjective|शिष्ट; मुलायम; समटल करना
software|noun|सफ़्टवेयर; सॉफ्टवेयर
soil|noun|मैला करना; कलंकित करना; दूषित करना
solid|adjective|असली; वास्तविक; सच्चा
southern|adjective|दक्षिन की ओर जाने वाला; दक्षिन की ओर; दक्षिणी
specifically|adverb|खास तौर पर; विशेष रूप से; खास
spending|noun|लागत; खर्च
spicy|adjective|मसालेदार; उत्तेजक; रोचक
spirit|noun|भावना; जोश; प्रेतात्मा
spoken|adjective|मौखिक; बोला जाने वाला
spot|noun|पाना; हल्का; दाग
stadium|noun|स्टेडियम्/मैदान; स्टेडियम
staff|noun|कर्मचारी; शिक्षक; भरा हुआ होना
standard|adjective|दर्जा; शिष्ट; मान
state|adjective|बताना; व्यक्त करना; अभिव्यक्त करना
statistic|noun|आँकड़ा
statue|noun|मूर्ति
stick|noun|सथापित करना; टेक लगाना; रखना
still|adjective|फिर भी
stranger|noun|परदेशी; अपरिचित; परदेसी
strength|noun|बल; गुण; ताकत
string|noun|रस्सी; धागा; श्रृंखला
strongly|adverb|काफ़ी; प्रभावशाली ढंग से; शक्तिशाली ढंग से
studio|noun|शिल्पशाला; प्रसार; गृह
stuff|noun|करना; मिलाना; सामान
substance|noun|सार; वस्तु; पदार्थ
successfully|adverb|सफलतापूर्वक
sudden|adjective|आकस्मिक; अचानक; शीघ्र
suffer|verb|सहना; उठाना; सहन करना
suitable|adjective|योग्य; ठीक; उपयुक्त
summarize|verb|सार होना; सार प्रस्तुत; सार प्रस्तुत करना
summary|noun|संक्षिप्त; सारांश; सरसरी
supply|noun|आपूर्ति करना; की; पूर्ति
supporter|noun|सहायक; समर्थक; इलास्टिक बंद
surely|adverb|निश्चित रूप से; अवश्य; निश्चय ही
surface|noun|प्रकट होना; दिखाई देना; भू सतह का
survive|verb|जीवित रहना; से बच जाना; से बच
swim|noun|तैरना
symptom|noun|लक्षण; सूचक; रोगलक्षण
tail|noun|काटना; पिछला हिस्सा; पिछला
talent|noun|गुण; प्रतिभा; प्रतिभावान
talented|adjective|प्रवीण; प्रतिभावान
tape|noun|लगाना; दौड समाप्ति का फीता; पट्टी
tax|noun|शुल्क लगाना; दाम; शुल्क
technical|adjective|तकनीकी; कानूनी; पारिभाषिक
technique|noun|निपुणता; तकनीक
tend|verb|होना; देना; देखभाल करना
tent|noun|तंबू लगाना; छोलदारी; डेरा लगा
that|adverb|वह
theirs|pronoun|उन्लोंगो का; उनकी आवश्यकता
theme|noun|लाक्षणिक; विषय; धुन
theory|noun|सिद्धांत; सिद्धान्त; परिकल्पना
therefore|adverb|अतः; इसलिए; इस तरह से
this|adverb|यह
though|adverb|यद्यपि; भले ही; मगर
throat|noun|कंठ; मार्ग; गला
throughout|adverb|में; पूर्णतया; भर में
tight|adjective|कठिन; तंग; कंजूस
till|conjunction|तक; खेत जोतना; गोलक
tin|noun|टिन प्लेट; टिन कि पन्नी; टिन में सुरक्षित रखना
tiny|adjective|छोटा; बहुत छोटा; कुछ
toe|noun|मारना; खुर; ठोकर मारना
tongue|noun|लौ; भाषा; बोली
total|adjective|कुल; पूर्ण; जोड़ लगाना
totally|adverb|पूरी तरह से; हर तरह से; पूर्ण रूप से
touch|noun|छूना
trade|noun|उद्योग; व्यापार करना; कारोबार
translate|verb|समझना; बदलना; ले जाना
translation|noun|स्थानांतरण; परिक्रमणहीन एक समान गतिविधि; भाषांतर
treat|verb|देना; व्यवहार करना; विवेचन करना
treatment|noun|निरूपण; बर्ताव; बहस
trend|noun|दौर; प्रवृत्ति; प्रवाह
trick|noun|शरारत; बहकाना; धोखा
truth|noun|वास्त्विकता; सत्यता; वास्तविकता
tube|noun|नाली; नल; ट्यूब
typically|adverb|विशिष्ट रूप से; विशिष्ट
tyre|noun|टायर; हाल
ugly|adjective|बदसूरत
unable|adjective|अशक्त; अयोग्य; असमर्थ
uncomfortable|adjective|बेचैन; तकलीफ़देह; अप्रिय
underwear|noun|नीचे पहनने के कपड़े; अंतर्वस्त्र
unemployed|adjective|बेरोजगार; बेरोज़गार/बेकार/बैठा हुआ/निरुद्यम; बेकार
unemployment|noun|बेरोजगारी/बेकारी/अनुद्योग; बेरोज़गारी; अवृति
unfair|adjective|अनुचित; गलत; बेढंगा
union|noun|संयोग; संघ; ग्रेट ब्रिटेन
unless|conjunction|यदि नहीं/जो नहीं/बिना/जबतक नहीं; जब तक नहीं; यदि नहीं
unlike|preposition|असमान; प्रतिकूल; के विपरीत
unlikely|adjective|अविश्वसनीय; असंभाव्य; असम्भव
unnecessary|adjective|अनावश्यक/व्यर्थ; अनावश्यक; फ़ुजूल
unpleasant|adjective|बुरा; अप्रिय; अप्रिय/नापसन्द/अरूचिकर
update|noun|नवीनीकरण करना; अवगत कराना; अब तक का समाचारअ
upon|preposition|पर; नज़दीक; के ऊपर/ऊँचा/पर
upset|adjective|परेशान करना; उल्टा; उलट देना
used|adjective|पुराना; आदी; प्रयुक्त
valuable|adjective|बहुमूल्य; जेवर; अनमोल
value|noun|परिमाण; गुण; मान
various|adjective|भिन्न; कई; अनेक
version|noun|संस्करण; रूप; आवृत्ति
victim|noun|शिकार व्यक्ति; पीड़ित; बलि
viewer|noun|दर्शक; व्यूअर
violent|adjective|तीव्र; उग्र; प्रबल
volunteer|noun|अपने आप; कहना; स्वेच्छा से काम करना
vote|noun|राय देना; प्रस्ताव करना; घोषित करना
warn|verb|सावधान करना; चेतावनी देना; बतलाना
warning|noun|चेतावनीपूर्ण; चेतावनी; धमकी
waste|adjective|व्यर्थ; बंजर भूमि; नष्ट करना
weapon|noun|हथियार; हस्तास्त्र; अस्त्र
weigh|verb|विचार करना; उठाना; नापना
western|adjective|अमरीकी पश्चिमी सम्बधी फिल्म; पश्चिम में स्थित; पश्चिमी हवा का
whenever|conjunction|कब; जब भी; जिस समय भी
whether|conjunction|चाहें; कि
will|noun|theres a way,जहाँ चाह है वहाँ राह है,Noun; इच्छा; चाहना
win|noun|जीतना
wing|noun|करना; पंख; पर
within|preposition|में; भीतर; अंदर
wonder|noun|आश्चर्य; विस्मय; भटकना
wool|noun|ऊनी कपड़ा; ऊनी; बाल
worldwide|adjective|पूरे; विश्व व्यापक; विश्वव्यापी
worry|noun|चिंता
worth|adjective|महत्व; योग्य; लायक
written|adjective|लिखित; लिखा हुआ
yard|noun|बाड़ा; रंगभूमि; अहाता
youth|noun|ताज़गी; नवयुवक; युवावस्था
"""), "en", "B1", "oxford"),

        Lesson("ox-b2", "🦅 Oxford 5000 · B2", "🦅", "1323 official Oxford words", ow("""
abandon|verb|रोक देना; खाली करना; रोक
absolute|adjective|पूर्णतया; परम; पूर्ण
absorb|verb|कम करना; अवशोषण करना; आत्मसात
abstract|adjective|निकालना; निकाल देना; संक्षिप्त करना
accent|noun|स्वराघात; उच्चारण; भाषा
acceptable|adjective|योग्य; ठीक; काफ़ी
accidentally|adverb|अचानक; संयोगवश; अचानक ही
accommodate|verb|देना; सहायता करना; मिलाना
accompany|verb|साथ देना; साथ साथ होना; साथ
accomplish|verb|पाना; प्राप्त करना; पूरा
accountant|noun|लेखाकार; मुनीम; लेखापाल
accuracy|noun|शुद्धता; सत्यता; यथार्थता
accurate|adjective|ठीक; अचूक; सही
accurately|adverb|सही; सही ढंग से; सही सही
accuse|verb|अभियोग; दोष लगाना; अभियोग लगाना
acknowledge|verb|स्वीकार करना; माना जा; पसंद करना
acquire|verb|प्राप्त करना; लाना; अर्जित
activate|verb|सक्रिय; सक्रिय करना; क्रियाशील बना देना
actual|adjective|वास्तविक; सही; चालू
adapt|verb|अनुकूल बनाना; के अनुरूप बनाना; बदलना
addiction|noun|लत; व्यसन; अविरति
additional|adjective|अतिरिक्त
additionally|adverb|इसके; इसके अतिरिक्त्त; इसके अतिरिक्त
adequate|adjective|योग्य; पर्याप्त; समुचित
adequately|adverb|पर्याप्त रूप से; पर्याप्त रूप में; पर्याप्त
adjust|verb|बराबर करना; अनुकूल बनाना; ठीक करना
administration|noun|देना; दवा; दवा देना
adopt|verb|स्वीकार करना; चुनना; मानना
advance|adjective|अग्रसर होना; आगे बढना; प्रयास
affair|noun|घटना; समस्या; झगड़ा
affordable|adjective|वहन करने योग्य; वहन; वहनयोग्य
afterwards|adverb|तत्पश्चात; बाद में; बाद
agency|noun|माध्यम; संस्था; संस्था {कर्तृत्व}
agenda|noun|करने वाली कार्यवाही; कार्यसूची
aggressive|adjective|उग्र; तेज़ी से फैलनेवाला; अति महत्वाकांक्षी
agriculture|noun|कृषि; कृषि वर्ग; कृषि उद्योग
aid|noun|सहायता; मदद; मदद करना
AIDS|noun|एड्स; एड्स{बीमारी}
aircraft|noun|विमान या वायुयान
alongside|preposition|के निकट; के पास; के
alter|verb|बदल देना; बदल जाना
altogether|adverb|पूर्णतया; सब मिलाकर; कुल मिलाकर
ambulance|noun|अस्पताल गाड़ी; ऐम्बुलेंस
amusing|adjective|मनोरंजक; विनोदी/मनोरंजक
analyst|noun|विश्लेषक; मनोविश्लेषक
ancestor|noun|पूर्वज; रूप
anger|noun|गुस्सा; गुस्सा दिलाना; प्रकोप
angle|noun|दृष्टिकोण; कोण; कोना
animation|noun|अनुप्राणन; जीवनक्षमता; सजीवता
anniversary|noun|श्राद्ध; वर्ष गाँठ; वर्षगाँठ
annual|adjective|सालाना; वार्षिक पुस्तिका; वार्षिक
annually|adverb|सालाना; हर साल; प्रति वर्ष
anticipate|verb|करना; सोच; उम्मीद करना
anxiety|noun|उत्सुकता; चिंता; चिन्ता/व्याकुलता
anxious|adjective|चिन्ताजनक; उत्सुक; चिन्तित
apology|noun|क्षमा प्रार्थना; स्पष्टीकरण; माफ़ी मांगना
apparent|adjective|प्रकट; स्पष्ट; साफ
apparently|adverb|स्पष्ट रूप; बिल्कुल; स्पष्ट रूप से
appeal|noun|आग्रह करना; अपील करना/याचना करना; संकेत करना
applicant|noun|प्रयोग; प्रार्थी/आवेदक; आवेदक
approach|noun|पद्धति; सन्निकर्ष; समीप आना
appropriate|adjective|ठीक; उचित; उपयुक्त
appropriately|adverb|उचित रूप से; उपयुक्त रूप से; उपयुक्त रूप
approval|noun|स्वीकृति; पसंदगी; समर्थन
approve|verb|स्वीकार करना; पसन्द करना; पसंद करना
arise|verb|उदय होना; उत्पन्न होना; निकलना
armed|adjective|लैस; सशस्त्र; शस्त्रधारी
arms|noun|हथियार; हस्तास्त्र; शस्त्र
arrow|noun|तीर; शर; `  > चिह्न
artificial|adjective|कृत्रिम; झूठा; बनावटी
artistic|adjective|कलाप्रेमी; कलात्मक; कलाकारों जैसा विशिष्ट
artwork|noun|शिल्पकृति; चित्रकला
ashamed|adjective|लज्जित; शर्मिन्दा
aside|adverb|अलग; छोड़कर; एक
aspect|noun|दृष्टिकोण; गुण; रूप
assess|verb|मूल्यांकन करना; निर्धारित करना; आँका जाना
assessment|noun|निर्धारण; राय; आँकलन/मूल्यांकन
asset|noun|गुण; सम्पत्ति; खूबी।
assign|verb|निश्चित करना; देना; नियुक्त करना
assistance|noun|सहायता; मदद
associate|verb|मिलना; मिलाना; सहयोगी
associated|adjective|संयुक्त; संबंधित
association|noun|संबंध; संघ; समिति
assume|verb|समझना; रूप धारण करना; मानना
assumption|noun|मान्यता; पुर्वानुमान; कल्पना
assure|verb|निश्चित करना; आश्वासन देना; निश्चित
astonishing|adjective|चौंका देने वाला
attachment|noun|लगाव; आसक्ति; संलग्न वस्तु
attempt|noun|प्रयास; प्रयत्न; कोशिश करना
auction|noun|नीलामी करना; नीलामी
audio|adjective|श्रव्य
automatic|adjective|सहज; अविवेचित; अपने आप
automatically|adverb|अपने आप
awareness|noun|जानकारी; जागरूकता; जानकारी/अभिज्ञता
awkward|adjective|अनुपयुक्त; भद्दा; तकलीफ़देह
bacteria|noun|जीवाणु; बैक्टीरिया; किटाणु
badge|noun|चिन्ह; लक्षण; बिल्ल् पहन
balanced|adjective|संतुलित
ballet|noun|बैले समूह; बैले; नृत्य नाटिका
balloon|noun|गोलक; गुब्बारा
barely|adverb|मुश्किल; साफ़ साफ़; केवल
bargain|noun|सौदा करना; लेन देन; समझौता करना
barrier|noun|अवरौध; बाधा; अवरोध
basement|noun|तहखाना
basically|adverb|मूल रूप से; मूलतः; स्वभावतः
basket|noun|अंक; डलिया; टोकरी
bat|noun|बल्लेबाजी; बल्ले से मारना; बल्ला
beat|noun|खटखटाना; ताल; परास्त कर देना
beg|verb|विनती करना; प्रार्थना करना; बैठना
being|noun|जीवन; स्वभाव; प्राणी
beneficial|adjective|लाभप्रद; गुणकारक
bent|adjective|प्रवृत्ति; टेढ़ा; झुकाव
beside|preposition|पास; अलग; समीप
besides|adverb|को छोड़कर; इसके अलावा; के अतिरिक्त
bet|noun|शर्त लगाना; विचार; से शर्त
beyond|adverb|के बाद; आगे; के
bias|noun|पक्षपात; झुकाव; दबाव डालना
bid|noun|दाम; प्रयास; आमंट्रित करना
biological|adjective|जीव विज्ञान; जीव विज्ञान संबंधी; जैविक
bitter|adjective|कटु; कठोर; कड़ुवा करना
blame|noun|आरोप; दोष; दोष लगाना
blanket|noun|परत; आवरण; व्यापक
blind|adjective|गुप्त; झिलमिली; अविवेचित
blow|noun|प्रस्थान करना; बहना; फैलाना
bold|adjective|धृष्ट; सुस्पष्ट; स्पष्ट
bombing|noun|बमबारी
bond|noun|बंधन; अनुबंध पट्र; बन्धन
booking|noun|बुकिंग
boost|noun|बढ़ाना; बढ़ा देना; बढ़ावा देना
bound|adjective|सीमित; सीमित करना; उछलते हुए
breast|noun|टकराना; आगे का; झोंका
brick|noun|इष्टिका; खिलौना; मदत करने वाला
brief|adjective|छोटा; सूचना; संक्षिप्त
briefly|adverb|संक्षेप में; कुछ समय; संक्षेप
broad|adjective|प्रभावशाली; साधारण; मुख्य
broadcast|noun|फैलाना; गाना; प्रचार करना
broadcaster|noun|प्रसारक
broadly|adverb|विस्तीर्णता से; खुल कर; मोटे तौर पर
budget|noun|सस्ता; बचाना; राजस्व
bug|noun|परेशान करना; नशा; तंग करना
bullet|noun|बड़ा निशान; गोली; इक्का
bunch|noun|समूह; ढेर; गुच्छा
burn|noun|करना; दाग; ख़र्च करना
bush|noun|अस्तर; छल्ला; घने घुँघराले बाल
cabin|noun|कोठरी; कक्ष; झोंपड़ी
cable|noun|तार का रस्साआ; तार दना; केबल
calculate|verb|निश्चित करना; समझना; गिनती करना
canal|noun|नहर; नलिका; कुल्या
cancel|verb|रद्द; काटना; रद्द करना
cancer|noun|कैन्सर; बुराई; कैन्सर का टयूमर
candle|noun|बत्ती; शमा; ज्योतोर्मयता का एकक
capable|adjective|योग्य; उपयुक्त; सक्षम
capacity|noun|सामर्थ्य; क्षमता; धारण शक्ति
capture|noun|आकर्षित करना; पकड़; बन्दी
carbon|noun|कोयला/कार्बन; प्रंगार; कार्बन
cast|noun|ढालना; डालना; नाटक या फिल्म के कलाकार
casual|adjective|आकस्मिक; लापरवाह; बेढंगा
catch|noun|पकड़ना
cave|noun|बैठ जाना; गउफा खोदना; गउफा
cell|noun|तहखाना; खाना; टोली
certainty|noun|निश्चय; निश्चितता
certificate|noun|प्रमाण पट्र; प्रमाण; प्रमाणपत्र
chairman|noun|अध्यक्ष; सभापति
challenging|adjective|
championship|noun|चैम्पियनशिप; सर्वोपरित्व; जोरदार समर्थन
characteristic|adjective|विशिष्ट लक्षण; लक्षण; विशिष्टता
charming|adjective|रुशील; जादुई; मनोरम
chase|noun|आखेट; पाना; लंबी
cheek|noun|घमंडी; गाल; जबड़ा
cheer|noun|सलामती का जाम; धीरज; हर्षित करना
chief|adjective|मालिक; प्रमुख; मुख्य
choir|noun|गिरजाघर गायन स्थल; संगीत वाद्यों का संग्रह; भजन गाने वालों का समूह
chop|verb|चोट; हाथ; ठप्प
circuit|noun|चक्कर; घूमना; परिपथ
circumstance|noun|दशा/अवस्था; स्थिति; परिस्थिति
cite|verb|तलब; हवाला देना; उल्लेख करना
citizen|noun|स्थानिक; नागरिक; निवासी
civil|adjective|सभ्य; नम्र; नागरिक
civilization|noun|शिष्टता; सामाजिक; संस्कृत्
clarify|verb|शुद्ध करना; स्पष्टीकरण देना; स्पष्ट करना
classic|adjective|उत्कृष्ट; अनलंकृत; आदर्श
classify|verb|वर्गीकृत करना; वर्गीकरण करना; वर्गीकृत होना
clerk|noun|पादरी; विद्वान; पेशकार
cliff|noun|खड़ी चट्टान; प्रपात; खड़ी
clinic|noun|क्लीनिक; चिकित्सालय
clip|noun|प्रहार; तेजी से प्रहार करना; कारतूस की पेटी
closely|adverb|ध्यानपूर्वक; घनिष्ठ रूप से; निकट से
coincidence|noun|संयोग; संपात; अनुरूपता
collapse|noun|असफलता; गिरना; गिरावट
collector|noun|संकलनकर्ता; जिलाधिकारी; जिलाधीश
colony|noun|बस्ती; उपनगर; उपनिवेश
colourful|adjective|रंग बिरंगा
combination|noun|संगत; संचय; संमिश्रण
comfort|noun|आराम; सुविधा; सान्त्वना
comic|adjective|हास्यप्रद; हास्यजनक; चित्रकथा
command|noun|पाना; प्राप्त करना; देना
commander|noun|सेनापति; नायक; कमांडर
commission|noun|करना; अधिकार; कमीशन
commitment|noun|सुपुर्दगी; वादा; वचनबद्धता
committee|noun|कमेटी; समिति; संसद
commonly|adverb|अक्सर; सामान्यतः; साधारणतः
comparative|adjective|तुलनात्मक; अपेक्षाकृत; उत्तरावस्था
completion|noun|समाप्ति; समापन; पूरा
complicated|adjective|जटिल; कठिन; पेचीदा
component|noun|अंश; घटक; आंशिक
compose|verb|लिखना; बनाना; शान्त करना
composer|noun|रचयिता; संगीतकार
compound|noun|सामासिक; मिश्रण; मिलाना
comprehensive|adjective|विशद; विस्तृत; व्यापक
comprise|verb|समाविष्ट करना; सम्मिलित करना; बने हुए होना
compulsory|adjective|अनिवार्य
concentration|noun|जमाव; तन्मयता; एकाग्रता
concept|noun|विचार; प्रत्यय; संकल्पना
concern|noun|अभिरुचि; दिलचस्पी; संबंध
concerned|adjective|चिन्तित; संबन्धित/विषय में
concrete|adjective|रोड़ा; मूर्त; कंक्रीट से भरना
conduct|noun|चलाना; आचरण; संचालन करना
confess|verb|मानना; कबूल करना; अंगीकार करना
confidence|noun|भरोसा; दृढ विश्वास; दृढ
conflict|noun|विरोध करना; सामना करना; मेल न खाना
confusing|adjective|पेचीदा; अस्पष्ट
confusion|noun|अस्तव्यस्तता; संभ्रम; भान्ति
conscious|adjective|सतर्क; जागरूक; साभिप्राय
consequently|adverb|परिणामस्वरूप; इसके; अतः/इसलिये
conservation|noun|संरक्षण; प्राकृतिक संरक्षण; संरक्षन
conservative|adjective|सतर्क; ब्रिटेन; दकियानूसी
considerable|adjective|बहुत अधिक; महत्वपूर्ण; बहुत
considerably|adverb|अत्याधिक; बहुत अधिकता से
consideration|noun|ध्यान; विचार; मुआवजा
consistent|adjective|अनुरूप; अटल; एक सा
consistently|adverb|लगातार
conspiracy|noun|षड्यंत्र; साजिश; षडयंत्र
constant|adjective|स्थिर; निरन्तर; नित्य
constantly|adverb|लगातार; सदा
construct|verb|बनाना; रचना; खींचना
construction|noun|संरचना; निर्माण; अभिप्राय
consult|verb|विचार विमर्श करना; राय; राय लेना
consultant|noun|चिकित्सक; सलाहकार; परामर्श चिकित्सक
consumption|noun|खपत; मिलाना; संयोग
contemporary|adjective|आधुनिक; समकालीन; समकालीन व्यक्ति
contest|noun|बहस करना; प्रतियोगिता; संघर्ष
contract|noun|करना; होना; प्राप्त करना
contribute|verb|मदद करना; भाग देना; सहयोग देना
contribution|noun|सहायता; चंदा; लेख
controversial|adjective|विवादास्पद; विवादस्पद
controversy|noun|विवाद
convenience|noun|सुविधा; शौचालय; मशीन
convention|noun|करार; चलन; समझौता
conventional|adjective|पारम्परिक; परमाणु रहित; रूढ़िगत/परम्परागत
convert|verb|बदलना; गोल; परिवर्तित
convey|verb|प्रकट करना; ले; पहुँचाना
convinced|adjective|कायल
convincing|adjective|विश्वसनीय; विश्वासोत्पादक; युक्तियुक्त
cope|verb|सामना करना; पूराअना; पादरियों का
core|adjective|बीजकोष; किसी चीज का मुख्य भाग; सब से महत्वपूर्ण भागा
corporate|adjective|निगम से; संगठित; निगम से सम्बन्धित
corporation|noun|संस्था; निकाय; महापालिका
corridor|noun|सीमांत; गलियारा; सीमांत गलियारा
council|noun|परिषद; सभा; समिति
counter|noun|विरोध करना; गिनने का यंत्र; काउंटर
county|noun|अभिजात; जिला; अभिजात वर्गीय
courage|noun|साहस; वीरता; धैर्य
coverage|noun|क्षेत्र; राशि; घटना आदि की रिपोर्ट
crack|noun|करना; पता; मौका
craft|noun|धूर्तता; नौका; चालाकी
crash|noun|छोटा; अल्प; गिरना
creation|noun|निर्माण; सृजन; आधुनिक
creativity|noun|रचनात्मकता; सर्जनात्मकता
creature|noun|व्यक्ति; शराब; आदमी
crew|noun|कर्मी दल; कर्मी; समूह
crisis|noun|चरम बिन्दु; संकट; चरम
criterion|noun|मानदण्ड/जाँच/कसौटी; कसौटी
critic|noun|आलोचक/समीक्षक; समालोचक; समीक्षक
critical|adjective|ठीक; शोचनीय; सूक्ष्म
critically|adverb|
criticism|noun|आलोचना; समीक्षा; आलोचना/समीक्षा
criticize|verb|मीन; समीक्षा करना; मीन मेख निकालना
crop|noun|कतरना; लगाना; समूह
crucial|adjective|निर्णायक; संकटपूर्ण; अत्यंत महत्वपूर्ण
cruise|noun|यौन सुख के लिये; चलना; समुद्री यात्रा
cry|noun|रोना
cue|noun|संकेत; डंडा; संकेत शब्द
cure|noun|दूर; पादरी; ठीक करना
curious|adjective|अनोखा; उत्सुक; विचित्र
curriculum|noun|पाठ्यक्रम
curve|noun|आलेख; झुकाना; मुड़ जाना
curved|adjective|वक्र; अंचित
cute|adjective|चालाक; आकर्षक; अति सुन्दर
dairy|adjective|दूध का बना; दुग्धोत्पादक; दूध
dare|verb|ललकार; ललकारना; सामना करना
darkness|noun|अंधकार/धुंधलापन/अज्ञानता; अनैतिकता; अँधेरा
database|noun|डेटाबेस; डाटाबेस; आंकड़ाकोष
deadline|noun|सीमारेखा; अंतिम तिथि
deadly|adjective|अत्यधिक; घातक; अत्यन्त
dealer|noun|व्यापारी; व्यापारी/लेन देन करनेवाला; पत्ता बांटने
debate|noun|सोचना; वाद विवाद करना/बहस करना; बहस
debt|noun|आभार; उधार/ऋण; कर्ज
decent|adjective|अच्छा; उचित; शालीन
deck|noun|छत; ताश की गड्डी; सजाना
declare|verb|बताना; प्रकट करना; कहना
decline|noun|घटना; गिरावट; कम
decoration|noun|सजावट; अलंकरण; सम्मान
decrease|noun|घटना; कम करना; घटाना
deeply|adverb|बहुत अधिक; बहुत; बहुत ही
defeat|noun|विफल कर देना; रोकना; हराना
defence|noun|बचाव; सुरक्षा; प्रतिरक्षा
defend|verb|चलाना; बचाना; प्रतिवाद
defender|noun|समर्थक; रक्षक; प्रतिरक्षक
delay|noun|रोकना; रोक देना; रोक
delete|verb|निकाल देना; हटा देना; मिटा देना
deliberate|adjective|विचार करना; ध्यानपूर्वक; सावधान
deliberately|adverb|जानबूझकर; जान बूझ कर; जानबूझ कर
delight|noun|हर्षित करना; हर्षोल्लास; खुशी
delighted|adjective|आनन्दित; प्रसन्न
delivery|noun|वितरण; सुपुर्दगी; प्रसव
demand|noun|दावा करना; मांग; चाह
democracy|noun|समानता; जनतन्ट्र; संचालन
democratic|adjective|प्रजातान्त्रिक; प्रजातांत्रिक; लोकतान्त्रिक
demonstrate|verb|प्रमाणित करना; प्रदर्शन करना; दिखाना
demonstration|noun|प्रदर्शन; नमूना; प्रमाण देना
deny|verb|प्रतिवाड करना; इन्कार करना; वंचित करना
depart|verb|से हटना; प्रस्ठान करना; छूटना
dependent|adjective|निर्भर; निर्भर करना; आश्रित
deposit|noun|जमा; रखना; जमा करना
depressed|adjective|उदास; अवसाद ग्रस्त
depressing|adjective|निराशाजनक; अवसादी
depression|noun|दबाव; अवसाद; गड्ढा
depth|noun|गहनता; गहराई; मध्य
derive|verb|उत्पन्न होना; प्राप्त करना; प्राप्त
deserve|verb|योग्य होना; पात्र; लायक होना
desire|noun|इच्छा; चाहना; तृष्णा
desperate|adjective|निराशाजनक; निराश; खतरनाक
desperately|adverb|आशाहीन हो कर दुःसाहसपूर्वक; अत्यावश्यकतापूर्वक; आशाहीन
destruction|noun|विनाश का कारण; विनाश; ध्वंस
detailed|adjective|विस्तृत; व्यौरेवार
detect|verb|पता; पता लगाना; पकड़ना
determination|noun|निर्णायक; विचार; इरादा
devote|verb|समर्पित होना; समर्पित करना; समर्पित
differ|verb|एकमत न होना; भिन्न होना; भिन्न
dig|verb|करना; समझना; ढकेलना
disability|noun|विकलांगता; असामर्थ्यता; निर्योग्यता
disabled|adjective|विकलांग
disagreement|noun|मतभेद; असहमति
disappoint|verb|निष्फल् कर देना; निराश करना; निष्फल
disappointment|noun|आशाभंग; निराशा; क्षोभ
disc|noun|मण्डल; चक्रिका; चकती
discipline|noun|व्यवस्था; अनुशासित करना; नियंट्रित करना
discourage|verb|रोकना; समर्थन से इनकार करना; निराश करना
dishonest|adjective|कपटी; ठग; धोखा देना
disk|noun|मण्डल; चकती; डिस्क
dismiss|verb|अस्वीकार करना; निकाल देना; बरखास्त करना
disorder|noun|विकार; परेशानी; अव्यवस्था
display|noun|बताना; प्रदर्शन; दिखाना
distant|adjective|उदासीन; दूर; सुदूर
distinct|adjective|सुस्पष्ट; स्पष्ट; अलग अलग
distinguish|verb|अलग करना; पहचानना; पहचान्ना
distract|verb|ध्यान; ध्यान भंग करना; ध्यान खींचना
distribute|verb|फैलना; वितरण करना; वितरण
distribution|noun|वितरण; विभाजन; वितरनअ
district|noun|इलाका; जिला/मंडल; जनपद
disturb|verb|परेशान; बाधा; छेड़ना/सताना
dive|noun|जल्दी से भागना; डुबकी; गोता लगाना
diverse|adjective|भिन्न; असमान; विविधतापूर्ण
diversity|noun|विविधता; भिन्नता; विभिन्नता/विभेद
divide|noun|विभाजित; फैल जाना; अलग करना
division|noun|वर्ग; हिस्सा; श्रेणी
divorce|noun|पार्थक्य; अलग करना; विवाह विच्छेद
domestic|adjective|घरेलू नौकर; पालतू; चाकर/घर का नौकर
dominant|adjective|प्रमुख; प्रभावशाली; प्रबल/प्रधान
dominate|verb|अधिकार रखना; अधिकार; शासन करना
donation|noun|दान; इमदाद; अवदान
dot|noun|चिन्ह; बनाना; परिवहन विभाग
downtown|adjective|केंद्रस्थल
downwards|adverb|नीचे की ओर
dozen|determiner|दर्जन/बारह; दर्जन
draft|noun|झोंका; अनिवार्य भर्ती होना; भरती करना
drag|verb|बाहर निकालना; बाधा; अवरोध
dramatic|adjective|आकस्मिक; प्रभावशाली; नाटकीय
dramatically|adverb|नाटकीय ढंग से; प्रभावशाली तरीके; नाटकीय ढंग
drought|noun|सुखा; सूखा/अकाल; अनावृष्टि
dull|adjective|मंदबुद्धि; नीरस; कम करना
dump|verb|डंप; ढेर; डालना
duration|noun|अवधि; कालावधि
dynamic|adjective|गति; सक्रिय; गति बोधक
economics|noun|अर्थव्यवस्था; अर्थशास्त्र; अर्थशास्ट्र
economist|noun|अर्थशास्त्री
edit|verb|संपादन करना
edition|noun|संस्करण; भाग
editorial|adjective|सम्पादकीय लेख; सम्पादकीय; संपादकीय
efficient|adjective|प्रभावशाली; दक्ष; कुशल
efficiently|adverb|निपूणता से; निपूणता
elbow|noun|चीर कर जाना; कोना; कोहनी
elderly|adjective|वयोवृद्ध; बुज़ुर्ग सा
elect|verb|मनोनीत; निर्वाचित करना; चुनना
electronics|noun|इलेक्ट्रानिकी; इलैक्ट्रानिक्स
elegant|adjective|सुन्दर; सहज; सुरुचिपूर्ण
elementary|adjective|साधारण; प्रारंभिक; आरंभिक स्तर की
eliminate|verb|निकालना; हटाना; हटा देना
elsewhere|adverb|और कहीं; अन्यत्र; अनत
embrace|verb|आलिंगन; समाविष्ट करना; आलिंगन करना
emerge|verb|प्रकट होना; निकलना; प्रकट
emission|noun|स्राव; उत्सर्जन
emotional|adjective|उत्तेजित; भावुक; भावात्मक
emotionally|adverb|भावात्मक ढंग से; भावुक हो कर; भावात्मक ढंग
emphasis|noun|बल; महत्व; जोर
emphasize|verb|महत्त्व; महत्त्व देना; बल देना
empire|noun|प्रभुत्व; साम्राज्य
enable|verb|प्राप्त करना; अधिकार; अधिकार देना
encounter|noun|सामना करना; मुठभेड़; मुठभेड़ करना
engage|verb|नियुक्त करना; आकर्षित करना; आक्रमण करना
enhance|verb|बढ़ाना
enjoyable|adjective|सुखदायक; सुखद; आनन्ददायक
enquiry|noun|पूछताछ
ensure|verb|सुनिश्चित करना; सुनिश्चित; आश्वस्त करना
entertaining|adjective|दिलचस्प
enthusiasm|noun|उत्साह
enthusiastic|adjective|उत्साहपूर्ण; उत्साही; उत्साहयुक्त
entire|adjective|कुल; पूरा; संपूर्ण
entirely|adverb|पूरी तरह से; पूरी तरह; सम्पूर्णतया
entrepreneur|noun|उद्यमी, उद्योगपति; ठेकदार
envelope|noun|थैला; लिफ़ाफ़ा; एनवलप
equip|verb|समर्थ बनाना; समर्थ; सज्जित करना
equivalent|adjective|बराबर; समतुल्य; तुल्य
era|noun|कालअ; युग; युग/संवत कल्प
erupt|verb|निकल आना; फट पड़ना; फूट पड़ना
essentially|adverb|अनिवार्य रूप से; तत्त्वतः
establish|verb|प्रमाणित करना; स्थापित; बनाना
estate|noun|भूमि; रियासत; जागीर
estimate|noun|अंदाज़ लगाना; आकलन; मूल्य का अनुमान
ethic|noun|नीतिशास्त्रीय/आचार संबन्धी; नीतिशास्त्र; सदाचार
ethical|adjective|नैतिक; नीतिपरक; नीति विषयक
ethnic|adjective|जातीय; मानवजातीय; प्रजातीय
evaluate|verb|मूल्यांकन करना; मूल्यांकन
evaluation|noun|मूल्यांकन; आंकलन
even|adjective|यहाँ तक
evident|adjective|प्रकट; स्पष्ट; प्रत्यक्ष
evil|adjective|दुष्ट; बुरा; दुष्टता
evolution|noun|विकासक्रम; विकास; विकास,उद्भेद
evolve|verb|विकसित होना; विकसित करना; विकसित
examination|noun|परीक्षण; जाँच; परीक्षा
exceed|verb|अधिक होना; पार कर जाना; अतिक्रमण करना
exception|noun|अपवाद; कोई व्यक्ति या चीज को छोड़ना
excessive|adjective|अधिक; अत्यधिकआ; बेहद
exclude|verb|निकालना; छोड़ना; छोड़ देना
excuse|noun|क्षमा
executive|adjective|प्रबंधक; विशेष; कार्यकारी
exhibit|noun|प्रदर्शन; प्रदर्शन करना; दिखाना
existence|noun|सत्ता; जीवन; ज़िन्दगी
exit|noun|निकास
exotic|adjective|असाधारण; आकर्षक; विदेशज
expansion|noun|विस्तार; प्रसार
expectation|noun|उम्मीद; चाह; कफोत्सारक
expense|noun|लागत; खर्च
expertise|noun|दक्षता
exploit|verb|कारनामा; वीरता का काम; काम में लगाना
exploration|noun|खोज; गवेक्षण
expose|verb|दिखाना; विवरण; प्रकट करना
exposure|noun|प्रदर्शन; विवरण; दिशा
extend|verb|फैलना; फैलाना; देना
extension|noun|विस्तार; फैलाव; शिक्षा
extensive|adjective|विस्तृत; व्यापक; बड़ा/व्यापक
extensively|adverb|व्यापक रूप से; बहुत विस्तृत; बहुत विस्तृत रूप से
extent|noun|हद; सीमा; आयति
external|adjective|बाहरी; बाह्य
extract|noun|निकालना; सार; अवतरण
extraordinary|adjective|असाधारण; विशेष; अनोखी
fabric|noun|एक प्रकार का कपड़ा; संरचना; कपड़ा
fabulous|adjective|शानदार; ढेर सारा; ढेर
facility|noun|सुविधा; कौशल; सुगमता
failed|adjective|असफल; फेल; अनुत्तीर्ण
failure|noun|असफलता; गिरना; गिरावट
faith|noun|भरोसेमंद; भरोसा; विचारधारा
fake|adjective|ढोंगी; जाली; ढोंग करना
fame|noun|प्रतिष्ठा; मान; नाम
fantasy|noun|कल्पना; कोरी कल्पना; स्वैर
fare|noun|खाना; किराया; भोजन
fault|noun|त्रुटि; अवगुण; शिकार खो बैठना
feather|noun|पंख; पर; पिच्छ
federal|adjective|केंद्रीय शासन से संबन्धित; संघीय; संघी
fee|noun|शुल्क; फीस
feed|noun|खिलाना
feedback|noun|फीडबैक; पुनर्निवेशन; जानकारी देना
feel|noun|महसूस करना
fellow|adjective|सभासद; व्यक्ति; आदमी
fever|noun|उत्तेजना; ताप; ज्वर
finance|noun|आर्थिक; आर्थिक प्रबन्ध; वित्तीय
finding|noun|निष्कर्ष; निर्णय; जाँच परिणाम
firefighter|noun|
firework|noun|शोरशराबा; आतिशबाज़ी; पटाखे
firm|adjective|स्थिर; अटल; मजबूत
firmly|adverb|मज़बूती; मज़बूती से
fix|noun|बदला लेना; लगाना; निश्चित करना
flame|noun|प्रेमिका; चमकना; आग की ज्वाला
flash|noun|दिखाना; चमकाना; चमक
flavour|noun|स्वाद; रंग; अनुमान
flexible|adjective|लचीला; नरम; स्थिति के अनुरूप ढालना
float|verb|बहना; चलाना; फैलाना
fold|noun|मिलाना; मोड़ना; भेड़ों का बाड़ा
folding|adjective|
fond|adjective|प्रेमी; शौक; प्रिय
fool|noun|मूर्ख; धोखा; फल के रस का शर्बत
forbid|verb|रोकना; मना करना; वर्जित करना
forecast|noun|बताना; पूर्वानुमान करना; पूर्वानुमान
forgive|verb|ऋण मुक्त कर; क्षमा करना; माफ
format|noun|फरमैट; बाह्य रूप; प्रबन्ध
formation|noun|बनावट; निर्माण; रचना
former|adjective|अब तक; पुराना; भूतपूर्व
formerly|adverb|विगत काल में; पहले; बीते हुए समय में
fortunate|adjective|अनुकूल; सौभाग्यशाली; भाग्यशाली
fortune|noun|संयोग; सौभाग्य; भाग्य
forum|noun|गोष्ठी; चौक; मंच
forward|adjective|अग्रसर होना; आगे; प्रस्तुत करना
fossil|noun|जीवाश्म; जीवावशेष; रूढ़िवादि व्यक्ति
found|verb|स्थापित; निर्माण करना; आधारित करना
foundation|noun|आधार; प्रतिष्ठान; संस्था
founder|noun|डूब; संस्थापक; असफल हो जाना
fraction|noun|भिन्न; थोड़ा; खंड
fragment|noun|टुकड़े टुकड़े होना; टुकड़े; तोड़ना
framework|noun|रूपरेखा; संरचना; प्राधारिक
fraud|noun|धोखा; ढोंगी; कपट
freedom|noun|स्वतंत्रता; आजादी; छूट
freely|adverb|स्वतंत्रतापूर्वक; बिना रोक टोक के; इच्छा से
frequency|noun|फ्रिक्वेन्सि; आवृति; आवृत्ति
frequent|adjective|अक्सर; तीव्र; नित्य
fulfil|verb|पालन करना; पूरा; कार्यान्वित करना
full-time|adjective|
fully|adverb|पूर्ण रूप से; पूर्ण रूप
fund|noun|भण्डार; धन; नियत ब्याज पर स्थायी ऋण में परावर्तित कर देना
fundamental|adjective|प्रमुख; मुख्य; मूल
fundamentally|adverb|आधारभूत रूप से; मूल; मूलतः
funding|noun|निधिकरण; निधीकरण
furious|adjective|उग्र; भीषण; प्रचण्ड
furthermore|adverb|इसके; इसके अलावा; ऊपर से
gain|noun|पाना; प्राप्त करना; मिलना
gaming|noun|जुआ
gang|noun|दल; टोली; गिरोह
gay|adjective|खुश मिजाज; खुश; समलैंगिक
gender|noun|लिंग
gene|noun|प्त्रैक; जीन; आनुवंशिकता की मूल भौतिक इकाई
generate|verb|पैदा करना; पैदा; कमाना
genetic|adjective|आनुवांशिकी विषयक; उत्पत्ति सम्बन्धी; आनुवांशिकी
genius|noun|प्रतिभा; प्रवीण; निपुण
genre|noun|शैली; विधा
genuine|adjective|असली; सच्चा; अमिश्रित/वास्तविक
genuinely|adverb|सचमुच; सचमुच में
gesture|noun|मुद्रा; इशारा करना; भाव
gig|noun|हल्की गाड़ी जो एक घोड़े द्वारा खींची जाती है; संगीतमय प्रस्तुति
globalization|noun|सार्वभौमिकता; वैश्विकरण
globe|noun|गोला; भूमण्ड़ल; पिंड
golden|adjective|महतपूर्ण; अच्छा; शुभ
goodness|noun|गुण; भगवान; दयालुता
gorgeous|adjective|सुन्दर; सुहावना; भड़कीला
govern|verb|प्रभावित करना; संचालन करना; निर्धारित करना
governor|noun|मालिक; राज्यपाल; गवर्नर
grab|verb|झपट लेना; खा; झपटना
gradually|adverb|धीरे धीरे; अल्पाशः
grand|adjective|बहुत अच्छा; अभिमानी; कुल
grant|noun|स्वीकार करना; देना; अनुदान
graphic|adjective|सुस्पष्ट; लिखित; सजीव
graphics|noun|चित्रमुद्रण
greatly|adverb|अत्यन्त; बहुत ही; बहुत
greenhouse|noun|छोटे पेड़ों को हरा रखने का घर; काँच का घरअ
grocery|noun|किराने के सामान का; किराना; किराने की दुकान
guarantee|noun|आशा करना; निश्चिंत होना; वचन
guideline|noun|मार्गदर्शन; मुख्य बात्
habitat|noun|पशु व पौधों का प्राकृतिक वास; निवास् स्थान; प्राकृतिक
handle|noun|स्पर्श करना; व्यवहार करना; उपाधि
harbour|noun|बंदरगाह; मन में रखना; शरण देना
harm|noun|अनिष्ट; क्षति; हानि
harmful|adjective|हानिकारक; अहितकर; हानिप्रदता
headquarters|noun|मुख्यालय
heal|verb|भरना; स्वस्थ होना
healthcare|noun|
hearing|noun|सुनवाई; सुनने की शक्ति; सुनने की
heaven|noun|स्वर्ग; वायुमंडल; भगवान
heel|noun|एड़ी; कमीना आदमी; पिछला
hell|noun|नरक; नर्क; खराब
helmet|noun|हैल्मेट; शिरस्त्राण
hence|adverb|अतः; इस कारण से
herb|noun|जड़ी बूटी
hesitate|verb|हिचकिचाना; संकोच करना; संकोच
hidden|adjective|गुप्त; ओझल; अंतर्गत
highway|noun|राजमार्ग; प्रमुख मार्ग
hilarious|adjective|हर्ष भरा; हास्यप्रद
hip|noun|नितम्ब; जंगली गुलाब का लाल फल; गुलाब का फल
hire|noun|किराया/भाड़ा; भाड़ेपर देना; मजदूरी पर रखना/किराये पर लेना
historian|noun|इतिहासकार
hold|noun|पकड़ना
hollow|adjective|मन्द; मिथ्या; निरर्थक
holy|adjective|पवित्र; पावन; पुण्यात्मा
homeless|adjective|घरहीन; बेघर का; बेघर
honesty|noun|सत्यनिष्ठा; सच्चरित्रता; ईमानदारी
honour|noun|सम्मानित करना; सम्मान; मानना
hook|noun|फँसाना; मोड़ना; मरना
hopefully|adverb|भरोसे से; आशा से; आशापूर्वक
household|noun|घर के सभी लोग; परिवार; घरेलु
housing|noun|घर; गृह; घोड़े का साज़ सामान
humorous|adjective|विनोदी; हास्यकर
humour|noun|हास्य; शक्तिअ; हास्यकला
hunger|noun|तीव्र इच्छा; भूख
hunt|noun|शिकार; शिकार करना; शिकारी दल
hunting|noun|आखेट; शिकार; शिकार करना
hypothesis|noun|अनुमान; परिकल्पना; अवधारणा
icon|noun|चित्र; प्रतिमा; मूर्ति
ID|noun|कामतत्व; पहचान पत्र
identical|adjective|जैसा; वैसा ही; बिलकुल् वही
illusion|noun|मरीचिका; भ्रान्ति; भ्रांति
illustrate|verb|व्याख्या करना; स्पष्ट; स्पष्ट करना
illustration|noun|स्पष्टीकरण; व्यख्या; उदाहरन
imagination|noun|भावना; कल्पना; उपाय कुशलता
immigration|noun|आप्रवासी; आप्रवासन; आव्रजन
immune|adjective|प्रभावशून्य; उन्मुक्त; असंक्राम्य
impatient|adjective|उतसुक; बेचैन; उत्सुक
implement|verb|साधन; हथियार; उपकरण
implication|noun|उलझाव; उलझन; निहितार्थ
imply|verb|समझना; सूचित करना; सूचित
impose|verb|लगाना; थोपना; लागू करना
impress|verb|प्रभावित करना; प्रभाव; सूत को रंगना
impressed|adjective|
incentive|noun|प्रेरणादायक; प्रेरणा
inch|noun|सरकना; इंचअ; बाल
incident|noun|घटना; वारदात; घट्
income|noun|फ़ायदा; आय; कमाई
incorporate|verb|समाविष्ट; समाविष्ट करना; सम्मिलित करना
incorrect|adjective|अनुचित; गलत; अशुद्ध
increasingly|adverb|लगातार; बहुत ही; अधिक मात्रा में
independence|noun|स्वतंत्र; स्वतंत्रता; स्वाधीनता
index|noun|तालिका; सूचक; के अनुरूप बढ़ाना
indication|noun|संकेत; लक्षण; सुझाव
industrial|adjective|उद्योग संबंधी; उद्योगी; औद्योगिक
inevitable|adjective|अनिवार्य; निश्चित; अपरिहार्य/अनिवार्य
inevitably|adverb|अवश्य; निस्सन्देह
infection|noun|स्वर; संक्रामक रोग; छूत
infer|verb|अनुमान करना; अनुमान लगाना; साबित करना
inflation|noun|मुद्रा स्फिति; मंहगाई; मुद्रास्फीति
info|noun|जानकारी
inform|verb|बताना; सूचित करना; प्रेरित करना
infrastructure|noun|आधारभूत संरचना; आधारिक संरचना; आधारभूत
inhabitant|noun|निवासी
inherit|verb|पाना; उत्तराधिकार में प्राप्त करना; उत्तराधिकार में पाना
initial|adjective|प्रारंभिक; प्रारम्भिक; प्रथमाक्षर
initially|adverb|शुरू में
initiative|noun|अवसर; अगुआई; कदम
ink|noun|में स्याही भरना; पर दस्तखत करना; रोशनाई
inner|adjective|भीतरी; आंतरिक; गुप्त
innovation|noun|नवीनीकरण; नवीनता; नवाचार
innovative|adjective|नवीन; अभिनव; नवप्रवर्तनशील
input|noun|डालना; निवेश; सहयोग
inquiry|noun|जाँच; सर्वेक्षण; अन्वेषण
insert|verb|निवेशन; सम्मलित करना; प्रविष्ट करना
insight|noun|अन्तर्दृष्टि; अंत्ःदृर्टि पूर्ण विचार
insist|verb|अड़े रहना; जोर डालना; दृढ़ रहना
inspector|noun|निरीक्षक; इंस्पेक्टर; इन्स्पेक्टर
inspire|verb|उत्पन्न होना; प्रेरित करना; भर देना
install|verb|बैठाना; लगाना[यन्त्र]; पदारुढ़ होना
installation|noun|लगाना; नियुक्ति; प्रतिष्ठापन
instance|noun|घटना; अवसर; वारदात
instant|adjective|तुरंत; क्षण; क्षणिक
instantly|adverb|तुरंत; तत्काल; शीघ्र
institute|noun|लगाना; संस्थान; संस्था भवन
institution|noun|संस्थान; संसथा भवन; संस्थापन
insurance|noun|सुरक्षा; बीमा क़िश्त; बीमा पालिसी
integrate|verb|समाहित करना; एकीकरण करना; संघटित होना
intellectual|adjective|बुद्धिजीवी व्यक्ति; दिमागी; बुद्धिगत
intended|adjective|भावी; नियत; अभीष्ट
intense|adjective|अत्यधिक; तीव्र; भावुक
interact|verb|बातचीत करना; एक दूसरे को प्रभावित करना
interaction|noun|पारस्परिक प्रभाव; पारस्परिक क्रिया; पारस्परिक व्यवहार
internal|adjective|भीतरी; आंतरिक; गोपनीय
interpret|verb|अदा करना; अर्थ लगाना; वर्णन करना
interpretation|noun|स्पष्टीकरण; व्याख्या; अर्थ
interrupt|verb|रोकना; टोकना; रोक देना
interval|noun|विराम; अंतराल; अन्तराल
invade|verb|आक्रमण करना; चढाई करना; घुस जाना
invasion|noun|आक्रमण; हस्तक्षेप; धावा
investigation|noun|अनुसन्धान; जाँच; अन्वेषण
investment|noun|निवेशन; निवेश; विनीयुक्त धन
investor|noun|धन लगाना; निवेशक
isolate|verb|समाधान करना; अलग रखना; अलग रख् करना
isolated|adjective|अकेला; एकान्त; अलग
jail|noun|जेल में डालना; जेल; जेल् हो जाना
jet|noun|फुहार; धारा; फूट निकलना
joint|adjective|मिलाना; संभेद; चूल
journalism|noun|पत्रकारिता
joy|noun|सफलता; प्रसन्न होना; आनन्द
judgement|noun|धारणा; परख; पहचान
junior|adjective|छोटा; क्निष्ठ; उम्र में छोटा
jury|noun|जूरी; निर्णायक समिति
justice|noun|न्यायाधीश; औचित्य; कार्रवाई
justify|verb|कारण दिखाना; ब्यौरा देना; न्यायसंगत सिद्ध
kit|noun|उपकरण समूह; किट
labour|noun|जी तोड़ कोशिश करना; मजदूर वर्ग; श्रमजीवी वर्ग
ladder|noun|सीढी से; चडना; उधड़न
landing|noun|अवतरण; घाट{अवतरणस्थान}; लैंडिंग{सीढ़ियों के खत्म होने की जगह}
landscape|noun|प्राकृतिक दृश्य; रूचिकर; भूदृश्य
lane|noun|गली; लेन
largely|adverb|व्यापक रुप से; पुर्णतया; मुख्य रुप से
lately|adverb|हाल में; हाल ही में
launch|noun|प्रारंभ करना; छोडना; आरम्भ करना
leadership|noun|नेतृत्व; नेतालोग
leaflet|noun|पुस्तिका; पर्चा; पर्णिका
league|noun|संघ; स्तर; लीग
lean|verb|थोड़ा; खाली; दुबला
leave|noun|छोड़ना
legend|noun|आलेख; अपूर्व कहानी; दन्तकथा
lens|noun|लेंस; लेन्स; तेजोजल
licence|noun|अतिशयोक्ति; स्वच्छंदता; लाइसेंस
lifetime|noun|जीवन काल; जीवनकाल
lighting|noun|बत्ती; प्रकाश; प्रकाश व्यवस्था
likewise|adverb|इसी तरह; वैसे ही; तुलनीय
limitation|noun|कमी; हद; सीमा
limited|adjective|सीमित; मर्यादित
literally|adverb|पूरी तरह से; यथाशब्द; वस्तुत
literary|adjective|साहित्यिक; साहित्य
litre|noun|इकाई; लीटर
litter|noun|गंदगी; बिखेरना; पालकी
lively|adjective|फुर्तीला; सक्रिय; प्रफुल्ल
load|noun|भारी; मिश्रण; भरना
loan|noun|रृण; ऋण पर देना; रृण देना
logical|adjective|तार्किक; तर्क संगत
logo|noun|चिन्ह; चिह्न; लोगो
long-term|adjective|
loose|adjective|कामुक; खोलना; लापरवाह
lord|noun|मालिक; सासक; सामन्त
lottery|noun|लटरी; लाटरी
lower|verb|छोटा; कम करना; गिरना
loyal|adjective|सच्चा; ईमानदार; देशभक्त
lung|noun|फेफड़ा; श्वासी; फेपड़ा
lyric|noun|बोल; गीतात्मक; भावसूचक
magnificent|adjective|शानदार; भव्य
maintain|verb|भरण पोषण करना; मरम्मत करना; निश्चयपूर्वक कहना
majority|noun|बहुमत; अधिकांश; वयस्कता
make|noun|बनाना
make-up|noun|
making|noun|निर्माण
manufacture|verb|बनाना; उत्पादन; गढना
manufacturing|noun|निर्माण; उत्पादन; विनिर्माण
marathon|noun|बहुत लम्बा; मैराथन; लंबी दौड़
margin|noun|हद; हाशिया; अतिरिक्त राशि
marker|noun|निशान
martial|adjective|सामरिक; वीर; युद्ध संबंधी
mass|adjective|परिमाण; समूह; ढेर
massive|adjective|भारी; भीमकाय; विशाल
master|noun|मालिक; विशारद; शिक्षक
matching|adjective|
mate|noun|साथी; सहायक; मिलाना
material|adjective|सामान; महत्वपूर्ण; मूर्त
maximum|adjective|अधिकतम; उच्चतम; महत्तम
mayor|noun|मेयर्; महापोर; महापौर
means|noun|उपाय; आय; साधन
measurement|noun|नाप; लम्बाई; मापन
mechanic|noun|प्रक्रिया; मैकैनिक/कारीगर; यंत्रविज्ञान
mechanical|adjective|यंत्रवत्; यांत्रिक
mechanism|noun|प्रक्रिया; यंत्रविन्यास; तरीका
medal|noun|पदक; तमगा
medication|noun|औषधि; दवा का प्रयोग
melt|verb|कम होना; पिघलाना[पिघलना]; पिघलना
membership|noun|सदस्य संख्या; सदस्य वर्ग; सदस्यता
memorable|adjective|स्मरणीय; अविस्मरणीय
metaphor|noun|रूपकालंकार; अलंकार
military|adjective|सेना; सैनिक; फौज
miner|noun|खनिक; खदान में काम करने वाला
mineral|noun|धातु; प्राकृतिक; पदार्थ
minimum|adjective|निम्नतम; कम से कम; अल्पतम
minister|noun|पादरी; पुरोहित; उपराजदूत
minor|adjective|लघु; अवयस्क; गौण
minority|noun|अल्पसंख्यक; अल्पमत; अल्पवयस्कता
miserable|adjective|तुच्छ; दयनीय; दरिद्र
mission|noun|कार्य; लक्ष्य; मिशन
mixed|adjective|मिश्रित; मिश्रित नस्ल का; मिश्र
mode|noun|ढंग; तरीका; प्रणाली
modest|adjective|साधारण; विनम्र; दिखावा रहित
modify|verb|सुधारना; विशेषता बतलाना; परिवर्तन करना
monitor|noun|दिखाना; दर्शाना; निरीक्षण
monster|noun|दैत्य; भीमकाय; अति क्रूर
monthly|adjective|मासिक; प्रतिमास; मसिक
monument|noun|स्मारक
moral|adjective|नैतिक; नैतिकअ; नीतिशास्ट्र
moreover|adverb|इसके; इसके अलावा
mortgage|noun|ऋण; गिरवी रखना; बन्धक रखना
mosque|noun|मस्जिद
motion|noun|गति; प्रस्ताव; इशारा
motivate|verb|प्रेरित करना; उत्प्रेरक; प्रेरित होना
motivation|noun|कारण; प्रेरणा; प्रेरण
motor|adjective|मोटर; चालक; मोटर से
mount|verb|घोड़ा; आयोजित करना; चढना
moving|adjective|गतिमान; मर्मस्पर्शी; हृदय स्पर्शी
multiple|adjective|बहुत; विविध; गुणज
multiply|verb|वृद्धि करना; बढ्ना; जनन करना
mysterious|adjective|रहस्यपूर्ण; रहश्यमय; गूढ
myth|noun|पौराणिक कथा; कल्पित कथा; कल्पणिक कथ
naked|adjective|स्पष्ट; निर्वस्त्र; निरा
nasty|adjective|मैला; भारी; कठोर
navigation|noun|दिशाज्ञान; नौपरिवहन; नौसंचालन
nearby|adjective|पास ही; पास में; पास वाला
neat|adjective|अमिश्रित; योग्य; संक्षिप्त
necessity|noun|आवश्यकता; आवश्यक वस्तु; आवश्यक
negotiate|verb|बातचीत करना; व्यवस्था करना; पार करना
negotiation|noun|समझौता; मोल तोल
nerve|noun|बल; नस; शक्ति
neutral|adjective|तटस्थ राष्ट्र; निष्पक्ष; तटस्थ
nevertheless|adverb|फिर भी; तथापि; तब भी
newly|adverb|नया; नया नया
nightmare|noun|भयावह; द; दुःस्वप्न
norm|noun|प्रकृत; कसौटी; मानदंड
notebook|noun|नोट बुक; नोटबुक; बुक
notion|noun|इच्छा; धारणा; विचार
novelist|noun|उपन्यासकार
nowadays|adverb|आजकल
numerous|adjective|बहुत से; बहुत ज्यादा
nursing|noun|परिचर्या
nutrition|noun|पोषणअ
obesity|noun|मुटापा; मोटापा
obey|verb|पालन करना; निभाना; कहना
objective|adjective|सामान्य; उद्देश्य; लक्ष्य
obligation|noun|अनुबंध पट्र; एहसान; आभार
observation|noun|विचार; कथन; देखरेख
observe|verb|अनुपालन करना; कहना; देखना
observer|noun|प्रेक्षक; पर्यवेक्षक; परिदर्शक
obstacle|noun|अवरोध; रुकावट; अवरोध/अटकाव
obtain|verb|पाना; प्राप्त करना; हाशिल करना
occasionally|adverb|कभीकभी
occupation|noun|आक्रमण; धंधा; अधिकार
occupy|verb|रहना; ग्रहण करना; कब्जा
offence|noun|अपराध; आक्रमण; दोष
offend|verb|अपराध करना; अपराध; उल्लंघन करना
offender|noun|अपराधी; उल्लंघन करने वाला
offensive|adjective|अपमानजनक; अप्रिय; घृणास्पद
ongoing|adjective|चालु; चलता आ रहा; जारी
opening|noun|मौका; शुरुआत; प्रारंभ
openly|adverb|प्रकट रूप से; खुल्लमखुल्ला; खुले तौर पर
opera|noun|संगीतिका; ओपेरा; गीतिनाट्य
operate|verb|चलाना; चलना; काम करना
operator|noun|संचालक; चापलूस; चालक
opponent|noun|दुश्मन; विरोधी; प्रतिद्वंदी
oppose|verb|रोकना; मुकाबले पर रखना; विरोध करना
opposed|adjective|विरोधी; खिलाफ़
opposition|noun|बाधा; विरोध; प्रतिद्वंदी
optimistic|adjective|आशावादी
orchestra|noun|आर्केस्ट्र; वाद्यवृन्द; वादक समूह
organ|noun|संस्थान; प्रकाशन; बाजा
organic|adjective|जैविक खाद; मूलभूत; जैव
origin|noun|मूल; आरम्भ; उद्गम
otherwise|adverb|अन्यथा; नहीं तो; दूसरे प्रकार
outcome|noun|परिणाम; नतीजा; निष्कर्ष
outer|adjective|बाहरी; सुदूर; बाह्य
outfit|noun|संस्थान; पोशाक; हथियार
outline|noun|रूपरेखा; दर्शाना; खाका
output|noun|उत्पादन; आउटपुट देना; प्रक्षेपण
outstanding|adjective|उत्कृष्ट; अपूर्ण; अप्रतिम
overall|adjective|कुल; सभी; सामान्य
overcome|verb|हराना; पराजित करना; वशीभूत कर लेना
overnight|adverb|सहसा; रात का; एक रात में
overseas|adjective|बाहरी; विदेशी; समुद्र पार
owe|verb|चाहना; देनदार होना; एहसानमंद होना
ownership|noun|स्वामित्व
oxygen|noun|प्राणवायु; आक्सीजन
pace|noun|की अनुमति से; कदम; प्रगति
packet|noun|बहुत; डाकनाव; पोटली
palm|noun|हाथ में; करतल; हाथ में छिपाना
panel|noun|दल; फलक; पट्टी
panic|noun|घबराहट; घबड़ाना; खलबली
parade|noun|दिखाना; इकठ्ठा; दिखावा करना
parallel|adjective|अनुरूप; मिलना; बराबर करना
parliament|noun|संसद भवन; संसद; कानून
part-time|adjective|
participant|noun|भागग्राही; सहभागी
participation|noun|सहभागिता; सहयोग
partly|adverb|कुछ हद तक; कुछ; कुछ अंश
partnership|noun|साझा; साझेदारी; भागीदारी
passage|noun|परिवर्तन; स्वीकृति; किराया
passionate|adjective|कामुक; भावुक
password|noun|कोड; संकेत शब्द; पासवर्ड
patience|noun|संयम; धैर्य; सहनशीलता
patient|adjective|सहनशील; रोगी; सबर
pause|noun|विराम; रूकना; ठहराव
peer|noun|देखना; ताकना; जोड़
penalty|noun|दंड; जुर्माना; दण्ड/सज़ा
pension|noun|पेंशन देना; बोर्डींग; पेंशन
perceive|verb|अर्थ लगाना; देखना; महसूस करना
perception|noun|अवबोधन; अभिज्ञता; अनुभूति
permanent|adjective|स्थायी; सदा के लिए; कृत्रिम
permanently|adverb|स्थायी रूप से
permit|noun|परमिट; अनुमति देना; अनुमति
perspective|noun|दृष्टिकोण; दृश्य; यथार्थ
phase|noun|चरण; योजना बनाना; स्थिति
phenomenon|noun|तथ्य; अजिबोगरीब; अद्भुत
philosophy|noun|धारणा; सिद्धांत; दर्शन शास्त्र
pick|noun|उकसाना; खाना; हटाना
pile|noun|ढेर लगना; बहुत सारा; समूह
pill|noun|गोली; टिकिया; गर्भनिरोधक गोली
pitch|noun|लगाना; गिरना; उचनिचाव
pity|noun|दया; खैद का विषय; स्नेह
placement|noun|व्यवस्था; नियोजन; स्थापन
plain|adjective|सरल; समतल; सीधा
plus|adjective|इसके अतिरिक्त्त; धन; और
pointed|adjective|नुकीला; सुस्पष्ट; अंकित
popularity|noun|लोकप्रियता; सर्वमान्यता
portion|noun|हिस्सा; भाग; खुराक
pose|verb|दिखावा; दावा करना; प्रस्तुत करना
possess|verb|आक्रान्त करना; रखना; आविष्ट करना
potential|adjective|सामर्थ्य; संभावना; अन्तर्निहित शक्ति
potentially|adverb|संभवतः; सशक्त रूप से
praise|noun|प्रशंसा; स्तुति; कीर्ति
precede|verb|आगे करना; आगे; से पहले आना या घटित होना
precious|adjective|बहुमूल्य; उत्कृष्ट; नितान्त
precise|adjective|ठीक; स्पष्ट; नियत
precisely|adverb|शुद्ध; स्वभाववश; ठिक ठिक
predictable|adjective|पूर्वानुमेय होने के कारण; पूर्वानुमेय; पूर्वानुमेय होने के कारण नीरस
preference|noun|प्राथमिकता; पसंद; वरीयता
pregnant|adjective|सारगर्भित; अर्थपूर्ण; उर्वर
preparation|noun|खाना; सम्पाक; अभ्यासकार्य
presence|noun|के सामने; सामना; व्यक्तित्व
preserve|verb|मुरब्बा; सम्भाल कर; बचाना
pride|noun|प्रतिष्ठा; आत्माभिमान; गौरव
primarily|adverb|मुख्य रुप; मुख्यतः; मुख्य रुप से
prime|adjective|मुख्य; उत्कृष्ट; महत्वपूर्ण
principal|adjective|मालिक; प्रमुख; मुख्य
principle|noun|मर्यादा; विधि; सूट्र
print|noun|लगाना; प्रति; प्रभावित करना
prior|adjective|पूर्व; पूर्ववर्ती; मठाधिकारी
priority|noun|प्राथमिकता; प्रथमता; पूर्वाधिकार
privacy|noun|गोपनीयता; एकान्तता
probability|noun|सम्भाविकी; सम्भावना; सम्भाव्यता
probable|adjective|संभावित; प्रत्याशी; संभाव्य
procedure|noun|प्रक्रिया; पद्धति; कार्यप्रणाली
proceed|verb|आगे आना; आगे बढना; चलना
produce|noun|उत्पादन करना
programming|noun|कार्यरचना; घटनाक्रम नियोजन; प्रोग्रामिंग
progressive|adjective|तेजी; सुधारवादी; प्रगतिशील
prohibit|verb|रोकना; मना करना; निषेध करना
promising|adjective|आशाजनक; होनहार
promotion|noun|पदोन्नति; समृद्धि; प्रचार
prompt|verb|सितारा मछली; तुरंत; उकसाना
proof|noun|प्रमाण; जाँच; अभेद्य
proportion|noun|अंश; अनुपात; समानुपात
proposal|noun|सुझाव; प्रस्ताव; विवाह
propose|verb|प्रस्ताव रखना; प्रस्तुत करना; सुझाव देना
prospect|noun|दृश्य; खोज़ना; खोज करना
protection|noun|संरक्षण; बचाव; घूस
protein|noun|प्रोटीन; प्रोटिन; प्रोभूजिन
protester|noun|प्रदर्शनकारी; विरोधकर्ता; विरोधक
psychological|adjective|मनोवैज्ञानिक संबन्धी; मनोवैज्ञानिक
psychologist|noun|मनोचिकित्सक; मनोवैज्ञानिक; मनोविज्ञानी
psychology|noun|मनोवृति; मनोविज्ञान
publication|noun|प्रकाशन; प्रकाशनअ; प्रख्यापन
publicity|noun|प्रख्याति; विज्ञापन; प्रचार
publishing|noun|प्रकाशन
punk|noun|घटिया; पंक संगीत; उग्र व्यक्ति
pupil|noun|आँख की; पुतली; किशोर
purchase|noun|खरीद; खरीदी हुई बस्तु; खरीदी हुई
pure|adjective|प्रांजल; असली; अमिश्रित
purely|adverb|केवल; पूर्ण रुप से; पूर्ण
pursue|verb|पाने की कोशिश करना; लगे रहना; पीछा करना
pursuit|noun|पीछा; धंधा; शौक
puzzle|noun|समस्या; हैरान करना; पहेली
questionnaire|noun|प्रश्नावली
racial|adjective|जातीय; जातिगत; प्रजातीय
racism|noun|नस्लभेद; जातीयता; जातिवाद
racist|adjective|जातिवादी
radiation|noun|विकिरण चिकित्सा; प्रस्फुरण; विकिरण
rail|noun|रेलवे; निंदा करना; रेल पटरी
random|adjective|निरुद्देश्य; बेतरतीब; सहसा उत्पन्न
rank|noun|समादर करना; जत्था; पद
rapid|adjective|द्रुतगामी; त्वरित; तत्काल
rapidly|adverb|शीघ्रता से; तेज़ी से
rat|noun|कमीना आदमी; हड़तालभंजक; चूहा
rating|noun|श्रेणी नर्धारण
raw|adjective|अनुचित व्यवहार; कच्चा; फूहड़
reach|noun|पाना; फैलना; फैलाना
realistic|adjective|उचित; यथार्थवादी; सजीव
reasonable|adjective|उचित; विवेकी; पर्याप्त
reasonably|adverb|कामचलाऊ ढंग से; कामचलाऊ; पर्याप्त माट्रा
rebuild|verb|पुनर्निर्माण करना; फिर बनाना; फिर से
recall|verb|स्मरण; वापस लेना; वापस बुलाना
receiver|noun|चोर हटिया; पाने वाला; ग्राहक
recession|noun|घटाव; लौटा लेना; मन्दी
reckon|verb|आशा करना; समझना; निर्भर होना
recognition|noun|मान्यता; पहचान; स्वीकार
recover|verb|अच्छा हो; ठीक होना; अपने पर काबू पाना
recovery|noun|स्वाथ्य; प्रतिलाभ; स्वास्थ्यलाभ
recruit|noun|नया; रंगरूटों की भरती; भरती करना
recruitment|noun|भरती; नये सिपाहियों की भर्ती
reduction|noun|कमी; घटाव; पदावनति
referee|noun|निर्णायक; मध्यस्थ; रेफरी का कार्य
refugee|noun|शरणागत; शरणार्थी
regard|noun|ध्यान; समझना; संबंध
regional|adjective|क्षेत्रीय; क्षेट्रीय; क्ष॓त्रीय
register|noun|बताना; प्रकट करना; पंजीकृत कराना
registration|noun|पंजीकृत करना; रजिस्ट्री; पंजीकरण
regret|noun|दुःखी होना; खेद होना; पश्चाताप करना
regulate|verb|ठीक करना; नियन्ट्रित करना; नियंत्रित करना
regulation|noun|नियम; अधिनियम; नियन्त्रण
reinforce|verb|बढ़ाना; समर्थन करना; मजबूत बनाना
relatively|adverb|पूर्णतया; अपेक्षाकृत; तुलनात्मक रूप से
relevant|adjective|उपयुक्त; संबद्ध; प्रासंगिक
relief|noun|उभार; राहत; मुक्ति
relieve|verb|कम करना; सहायता करना; उठाना
relieved|adjective|चिंतामुक्त; सह्य; चिन्ता मुक्त
rely|verb|निर्भर होना; निर्भर करना; विश्वास करना
remark|noun|करना; ध्यान; प्रतिक्रिया
remarkable|adjective|विलक्षण; विशिष्ट; उल्लेखनीय
remarkably|adverb|उल्लेखनीयता से; आश्चर्यजनक ढंग से; आश्चर्यजनक
reporting|noun|सूचना; प्रतिवेदन
representative|adjective|नमूना; नमूने के तौर पर; प्रतिरूप
reputation|noun|प्रतिष्ठा; मर्यादा; मान
requirement|noun|जरुरत; आवश्यक्ता; आवश्यकता
rescue|noun|राहत; बचाना; बचाव
reserve|noun|संचय; अलग छोड़; प्रतिबंध
resident|adjective|निवासी; आवासी
resign|verb|इस्तीफा देना; सुपुर्द करना; छोड़ देना
resist|verb|रोकना; निवारण; विरोध करना
resolution|noun|विश्लेषण; इरादा/संकल्प; प्रस्ताव
resolve|verb|निश्चय करना; समाधान करना; हल करना
resort|noun|आश्रय; शरण; सहारा
restore|verb|पुनः स्थापित करना; मरम्मत करना; वापस लौटाना
restrict|verb|बाधित करना; सीमित करना; परिमित/सीमित करना
restriction|noun|सीमा; रोक; प्रतिबन्ध
retail|noun|परचून; फुटकर बेचना; फुटकर
retain|verb|रोकना; रहने देना; सुरक्षित रखना
retirement|noun|सेवा निवृत्ति; सेवानिवृत्ति; सेवानिवृत्ति के बाद का समय
reveal|verb|बताना; दिखाना; प्रकट करना
revenue|noun|राजस्व; कर
revision|noun|सुधार; पुनर्लेखन; दोहराई
revolution|noun|नक्षत्र का परिभ्रमण; आमूल परिवर्तन; पूरा चक्कर/परिभ्रमण
reward|noun|पुरस्कार; पुरस्कृत करना; पारितोषिक देना
rhythm|noun|ताल; तालमेल; आवर्तन
rid|verb|मुक्त करना; छुटकारा पाना; छुटकारा देना
ridiculous|adjective|बेतुका; हास्यास्पद; मूर्खतापूर्ण
risky|adjective|जोखिम भरा; ख़तरनाक
rival|adjective|प्रतियोगी; बराबरी करना; प्रतिस्पर्धी
rob|verb|छीनना; छीन लेना; वंचित करना
robbery|noun|लूट पाट; डकैती
rocket|noun|बहुत तेज़ी से बढना; बहुत तेज़ी से चलना; बाण हवाई
romance|noun|प्रेम लीला; रोमांचक कहानी सुनाना; रोमांच
root|noun|धातु; खोदना; मूल
rose|noun|सर्वोत्तम; गुलाब का पौधा; सर्वोत्तम सुंदरी
roughly|adverb|लगभग; रुखाई से; अशिष्टता से
routine|adjective|नीरस; साधारण; नित्य
rub|verb|बाधा; रगड़ना; मिटाना
rubber|adjective|रेती; मार्जनी; रगड़ से चलनेवाला मशीन का पुर्जा
ruin|noun|नष्ट करना; नष्ट कर; बिगाड़ना
rural|adjective|देहाती; ग्रामीण; ग्राम्य
rush|noun|सोने की खानो के नए क्षेट्रों में प्रवास; अत्यावश्यक; धावा बोलकर हथिया लेना
satellite|noun|अनुगामी; उपाश्रित देश; उपग्रह
satisfaction|noun|स्पष्टीकरण; पूर्ति; संतोष
satisfied|adjective|संतुष्ट
satisfy|verb|शांत करना; आपूर्ति करना; पूरा करना
saving|noun|बचाव; बचत
scale|noun|परत; मान; पलड़ा
scandal|noun|बहुत खराब बात; कलंकपूर्ण कृत्य; मिथ्या लांछन
scare|noun|भय; डराना; डरना
scenario|noun|दृश्य; दृश्य लेख; पटकथा
scheme|noun|पद्धति; योजना बनाना; योजना
scholar|noun|विद्वान; शोध छात्र; शोध
scholarship|noun|छात्रवृत्ति; विद्वत्ता; पाण्डित्य
scratch|noun|खरोंचना; खरोंच; वापस लेना
scream|noun|चीखना; चिल्लाना; ज़बर्दस्त मज़ाक
screening|noun|प्रदर्शन; जाँच; आवरण
sector|noun|क्षेत्र; कार्यक्षेत्र; संस्था
secure|adjective|प्राप्त करना; निश्चित; सुरक्षित
seek|verb|कोशिश करना; की कोशिश करना; पतालगाना
seeker|noun|खोज करने वाला; जिज्ञासु; खोज करने
select|verb|विशिष्ट; चुनना; चुनना/छाँटना
selection|noun|चुनाव; चयन; संकलन
self|noun|स्वयं; अहम्; व्यक्तित्व
seminar|noun|परिसंवाद; सेमिनार; अध्ययन गोष्ठी
senior|adjective|वरिष्ठ; ज्येष्ठ; अपर
sensitive|adjective|निजी; दिल को छूने वाला; कोमल
sequence|noun|दृश्य; क्रम; अनुक्रम
session|noun|शैक्षिक सत्र; आत्मा आह्वान बैठक; बैठक
settle|verb|रोकना; देना; रहना
settler|noun|मध्यस्थ; अधिवासी; उपनिवेशी
severe|adjective|भारी; सरल; कठोर
severely|adverb|कठोरता से; सादे ढंग से; गंभीर रूप से
sexy|adjective|कामोत्तेजक; उतेजक , मादक
shade|noun|छाँव; गहराई; प्रेतात्मा
shadow|noun|सितारा मछली; सूट्र; शरण
shallow|adjective|हल्की; उथला; उथला करना
shame|noun|कम दिखाना; बाध्य करना; बदनाम करना
shaped|adjective|गढ़ा
shelter|noun|सहायता करना; आश्रय; शरण
shock|noun|झटका; टक्कर; सदमा पहुँचाना
shocked|adjective|स्तबध होना
shocking|adjective|शर्मनाक; बहुत खराब; दहलानेवाला
shooting|noun|शिकार; गोलीबारी
shore|noun|किनारा; टेक लगाना; उठाना
short-term|adjective|
shortage|noun|कमी
shortly|adverb|कुछ समय; रुखाई से; शीघ्र
shot|noun|घाव; चित्र; दृश्य
sibling|noun|सहोदर भाई या बहन; सहोदर; सहोदर्
signature|noun|अंकित अंक; हस्ताक्षर; दस्तखत
significance|noun|महत्व; महत्त्व; मतलब
significant|adjective|महत्त्वपूर्ण; महत्वपूर्ण; अर्थपूर्ण
significantly|adverb|सारगर्भित ढंग से; अर्थपूर्ण ढंग से; अर्थपूर्णतासे
silence|noun|शांत करना; चुप्पी; निस्तब्धता
silk|noun|रेशम; रेशमी; रेशा
sincere|adjective|वास्तविक; सच्चा; निष्कपट
skilled|adjective|कुशल; प्रशिक्षित; कौशलपूर्ण
skull|noun|खोपड़ी; दिमाग; खोपड़ी/कपाल
slave|noun|नौकर; काम करना; दासअ
slide|noun|खीसकाना; फिसलना; फिसलन
slight|adjective|छोटा; तुच्छ; साधारण
slip|verb|निकालना; गिरना; जाना
slogan|noun|नारा; प्रचार वाक्य; प्रचार
slope|noun|झुकाना; समतल; झुकना
so-called|adjective|
solar|adjective|सूर्य; सौर
somehow|adverb|किसी भी तरह; किसी कारण से; जैसे तैसे
sometime|adverb|कुछ समय
somewhat|adverb|कुछ; किंचित; थोड़ा बहुत
sophisticated|adjective|जटिल; प्रगतिशील; विवेकी
soul|noun|व्यक्ति; प्रेतात्मा; जीवन
spare|adjective|देना; बचाना; खाली
specialist|adjective|विशेषज्ञ; विशेष जानकार; विशेष
specialize|verb|विशेषज्ञता प्राप्त करना; विशेषज्ञ बनना/विशेष अध्ययन करना
species|noun|प्रजाति; प्रकार; वर्ग
specify|verb|विस्तृत विवरण देना; स्पष्ट रूप से; साफ़ तौर पर सामने रखना
spectacular|adjective|प्रभावशाली; असाधारण; अच्छी प्रदर्शन/शानदार
spectator|noun|प्रेक्षक; दर्शक; स्पेक्टेटर
speculate|verb|अनुमान लगाना; अंदाज़; सट्टा लगाना
speculation|noun|सट्टेबाज़ी; विचार; चिंतन
spice|noun|कुछ नई चीज़ मिलाना; मसाला; मसाले मिलाना
spill|verb|छलकना; फैल जाना; गिर जाना
spiritual|adjective|धार्मिक; धार्मिक गीत; आध्यात्मिक
spite|noun|तंग करना; द्वेष; विद्वेष
split|noun|चीरा; चम्पत; बंटना
spoil|verb|लाभ; दूषित करना; बिगाड़ देना
spokesman|noun|वक्ता; प्रवक्ता
spokesperson|noun|प्रवक्ता
spokeswoman|noun|महिला प्रवक्ता
sponsor|noun|प्रायोजक; उत्तरदायी; आर्थिक संरक्षण देना
sponsorship|noun|प्रायोजक; आर्थिक संरक्षण; प्रायोजकता
sporting|adjective|खेल भावनायुक्त; न्यायसंगत; खेल संबन्धी
spread|noun|फैलना; प्रकार; फैलाना
stable|adjective|स्थिर; स्थायी; अश्वशाला
stall|noun|रोकना; दुकान; टालना
stance|noun|मुद्रा; रवैया; जागरूकता एवं बुद्दिमत्ता भरा तरीका
stand|noun|खड़ा होना
stare|verb|आँख गड़ाकर देखना; नज़र; घूरना
starve|verb|भूखा मरना; भूख लगना; भूखा होना
status|noun|दर्जा; ओहदा; स्थिति
steadily|adverb|निरंतर; स्थिरतापूर्वक
steady|adjective|स्थिर; धीमा; अविचल
steam|noun|भाप शक्ति से याट्रा; भाप शक्ति; वाष्प
steel|noun|तैयार करना; इस्पात से निर्मित शस्त्र; स्टील
steep|adjective|अत्यधिक; बेतुका; भिगोना
sticky|adjective|कठिन; कंजूस; चिपचिपा
stiff|adjective|कठोर; कठिन; रूखा
stimulate|verb|उत्तेजित करना; प्रोत्साहित करना; प्रेरित करना
stock|noun|प्रतिष्ठा; लगाना; नाम
stream|noun|बहना; वर्ग; प्रवाह
strengthen|verb|शक्ति बढ़ना; मजबूत करना; मजबूत होना
stretch|noun|फैलाना; फैल जाना; पंक्ति
strict|adjective|सही; पक्का; सख्त
strictly|adverb|पूरी तरह से; कड़ाई से; केवल
strike|noun|बजना; आक्रमण; निकालना
stroke|noun|प्रहार करना; अघात; प्रहार
struggle|noun|आगे बढना; मुश्किल; प्रयत्न
stunning|adjective|शानदार; विलक्षण; आश्चर्यजनक
subject|adjective|विषय
submit|verb|सामने रखना; जमा; पेश करना
subsequent|adjective|अनुगामी; बाद का; के बादवाला
subsequently|adverb|बाद में
suburb|noun|उपनगर; उपनगर{शहर के समीपवर्ति आबादी क्षेत्र}
suffering|noun|पीड़ा; अत्यंत दुखी; कष्ट
sufficient|adjective|काफ़ी; पर्याप्त; यथेष्ट
sufficiently|adverb|काफ़ी; पर्याप्त मात्रा में; पर्याप्त रूप से
sum|noun|प्रश्न; राशि; निष्कर्ष
super|adjective|अधिक; शानदार; उत्कृष्ट
surgeon|noun|शल्यचिकित्सक; शल्य चिकित्सक
surgery|noun|शल्यचिकिस्तालय में मिलने का समय; शल्य कक्ष; शल्यचिकित्सा शास्त्र
surround|verb|किनारा; भरा होना; चारों ओर होना
surrounding|adjective|आस पास का; आस पास
survival|noun|प्रथा; उत्तरजीविता; [मृत्यु] से बच जाना{उत्तरजीवन}
survivor|noun|उत्तरजीवी
suspect|noun|समझना; लगना; क्षतिग्रस्त
suspend|verb|लटकाना; स्थगित करना; निलम्बित करना
sustainable|adjective|संपोषणीय; पोषणीय; कायम रहने
swallow|verb|निगल लेना; समाप्त करना; दबाना
swear|verb|गाली देना; कसम; वचन देना
sweep|verb|फैलना; आसानी से चड़ना; घुमाव
switch|noun|बदलना; भारी; अदला बदली करना
sympathetic|adjective|कारुणिक; अनुकंपी; सहानुभूतिशील
sympathy|noun|संवेदना; सहमति; सहानुभूति
tag|noun|लगाना; आंशिक प्रश्न; उपनाम देना
tale|noun|झूठ; कहानी; किस्सा
tank|noun|टंकी में संसाधित करना; टैंक; टंकी में भरना
tap|noun|खटखटाना; निकालना; क्षार निकालना
tear|noun|करना; आँसू; खींच लेना
technological|adjective|शिल्प विज्ञानीय; तकनीकी; तकनीकी सम्बन्धी
teens|noun|किशोरावस्था; तेरह से उन्नीस तक की आयु
temple|noun|कनपटी; मोहरा; दिवगृह
temporarily|adverb|अस्थायी रूप से; थोड़े दिन
temporary|adjective|अल्पकालीन; अस्थायी कर्मचारी; अस्थायी
tendency|noun|झुकाव; प्रकृति; रूझान
tension|noun|दबाव; तानना; तनावग्रस्त
terms|noun|संबंध; शब्दावली; शर्त्
terribly|adverb|भद्दा; बहुत ज़्यादा; बहुत
terrify|verb|डराना; डरना
territory|noun|अधिकार क्षेट्र; क्षेत्र; इलाका
terror|noun|भय; उपद्रवी; दहशत
terrorism|noun|आतंकवाद
terrorist|noun|आतंकवादी; त्रास द्वारा शासन करने वाला
testing|noun|परीक्षण; जाँच; परीक्षा
textbook|noun|पाठ्यपुस्तकीय; पाठ्य पुस्तक; पाठ्य
theft|noun|चोर; चोरी
therapist|noun|चिकित्सक
therapy|noun|रोगोपचार; मनश्चिकित्सा
thesis|noun|शोध प्रबन्ध; शोध प्रबंध; अभिधारणा
thorough|adjective|पूर्ण; पूरा; संपूर्ण
thoroughly|adverb|पूर्ण; अच्छी तरह से; पूर्ण रूप से
threat|noun|डर; भय; धमकी देना
threaten|verb|धमकाना; घटित होना; सूचना देना
thumb|noun|दबाना; देखना; अंगूठा लगाकर पलटना{गन्दा करना}
thus|adverb|इसलिये; इस प्रकार; इस
timing|noun|ताल; समय; समय निर्धारण
tissue|noun|ऊतक; महीन कागज़; तंतु
ton|noun|टन
tone|noun|स्वराघात; ध्वनि; सरगम के दो सुरों का अंतराल
tonne|noun|टन
tough|adjective|कठोर; कठिन; उद्दण्ड
tournament|noun|खेल प्रतियोगिता; टूर्नामेंट
trading|noun|लेन देन; व्यापार
tragedy|noun|थियेटर की; दुखान्त; दुःखद घटना
tragic|adjective|द; दुःखद; दुर्भाग्यपूर्ण
trait|noun|विशेषता
transfer|noun|सौंपना; स्थानान्तरित करना; स्थानान्तरण
transform|verb|बदल देना; बढ़ाना; घटाना
transition|noun|परिवर्तन; परिवर्तन होना; पारगमन
transmit|verb|फैलना; देना; प्रसारित करना
transportation|noun|किराया; परिवहन विभाग; परिवहन
trap|noun|चाल; फंदा; डालना
treasure|noun|बहुमूल्य; संजोए रखना; खजाना
trial|noun|पूर्व परीक्षण; परीक्षण; विचार
tribe|noun|वर्ग; जाति; समुदाय
trillion|number|दस खरब; लाखों; दस शंख
troop|noun|दल; स्काउट; टुकड़ी
tropical|adjective|उष्णकटिबन्धी; उष्णकटिबन्ध; उष्ण कटिबन्ध प्रदेश
truly|adverb|वास्तव में; सचमुच; सही अर्थों में
trust|noun|आशा करना; सहारा; ईमानदारी से
try|noun|कोशिश करना
tsunami|noun|सुनामी
tune|noun|ठीक करना; ठिक करना; तालमेल
tunnel|noun|सुरंग खोदना; बिल; सुरंग
ultimate|adjective|परम; सर्वश्रेष्ठ; अंतिम
ultimately|adverb|मूलभूत रूप से; अन्त में; अंत में
unacceptable|adjective|अग्राह्य; अस्वीकार्य; अस्वीकार्य/अवांछनीय
uncertainty|noun|अस्थिरता; अनिश्चय; संदिग्धता
unconscious|adjective|अचेतन मन; अन्जान; अनजान
undergo|verb|करना; अनुभव करना; झेलना
undertake|verb|उत्तरदायित्व लेना; वादा करना; बीड़ा उठाना
unexpected|adjective|अविचारित; अनिवार्य; अप्रत्याशित
unfold|verb|फैलाना; प्रकट करना; खोलना
unfortunate|adjective|दुःखद; दुर्भाग्य; खेदजनक
unique|adjective|अनोखा; अद्वितीय; अपूर्व
unite|verb|मिलना; मिलाना; मिल कर काम
unity|noun|एक; एकात्मकता; इकाई
universal|adjective|सामान्य; मशीन का सर्वक्षम; सामान्य प्रत्यय
universe|noun|ब्रहमाण्ड; संसार; सृष्टि/संसार/विश्व/जगत
unknown|adjective|अज्ञात; अपरिचित; अज्ञात बात्
upper|adjective|उपरी भाग; उपरी; उच्च
upwards|adverb|ऊपर; महँगाई की ओर; ऊर्ध्वमुखी
urban|adjective|शहरी; नगरीय; शहरी/नगर का/नागरिक
urge|verb|उत्तेजित करना; उकसाना; विवश करना
urgent|adjective|तुरंत; अत्यावश्यक; ताकीदी
usage|noun|खपत; उपयोग; व्यवहार/बर्ताव/रीति/चलन/चाल
useless|adjective|व्यर्थ; सामान्य; निकम्मा
valid|adjective|प्रभावशाली; मान्य; वैध
variation|noun|परिवर्तन; भिन्नता; विभिन्नता
vary|verb|बदलना; भिन्न होना; परिवर्तित करना
vast|adjective|बृहत; बहु; विशाल
venue|noun|घटनास्थल; स्थान; मुकदमे का
vertical|adjective|सीधा; लम्बरूप; लम्ब
very|adjective|बहुत
via|preposition|से होकर; के द्वारा; की राह से
victory|noun|विजय; संजय; जीता
viewpoint|noun|दृष्टिकोण; विचार; नज़रिया
violence|noun|निरादर; प्रचण्डता; वेग
virtual|adjective|वास्तविक; आभासी
visa|noun|आधिकारिक रुप से स्वीकृत करना; वीसा देना; वीसा
visible|adjective|दृश्य; प्रत्यक्ष; उन्मेष
vision|noun|दृश्य; झलक; दृष्टि
visual|adjective|दृश्य; तस्वीर; शैक्षिक कार्य में सहायक सामग्री
vital|adjective|महत्वपूर्ण; अत्यावश्यक; अत्याधिक
vitamin|noun|विटामिन
volume|noun|प्रबलता; घनफल; अंक
voluntary|adjective|स्वैच्छिक; स्वयंसेवी; अवैतनिक
voting|noun|मतदान
wage|noun|करना; किराया करना; तनखाह
wander|verb|घुमावदार मार्ग से हो कर आगे बढ़ना; घूमना; भटकना
warming|noun|ऊष्मोत्पादक; तापक; गरमाहट
way|adverb|रास्ता
weakness|noun|दोष; शौक; असामर्थ्य
wealth|noun|संपत्ति; बहुलता; धन
wealthy|adjective|समृद्ध; संपन्न; धनवान
weekly|adjective|साप्ताहिक पत्र; साप्ताहिक समाचार पत्र; साप्ताहिक
weird|adjective|निराला; अनोखा; भयानक
welfare|noun|मंगल; सुख; कल्याणकारी पद्वति
wheat|noun|गेहूँ
whereas|conjunction|जबकि; चूँकि; क्योंकि[प्रतिकूलता]
wherever|conjunction|कहीं भी; जिधर; जब जब
whisper|noun|काना फूसी; कानाफूसी; सरसराहट
whoever|pronoun|कौन; जो कोई; जो
whom|pronoun|जो; किससे; किसे
widely|adverb|बहुत से लोगों; बहुत अधिक; विशाल क्षेत्र में
widespread|adjective|व्यापक; दूर दूर तक फैला हुआ; विस्तीर्ण
wildlife|noun|वन्य; वन्य जीवन
willing|adjective|इच्छा; स्वैच्छिक; उद्यत
wire|noun|लाइन; तार लगाना; फीता
wisdom|noun|ज्ञान; बुद्धिमत्ता; प्रज्ञा
wise|adjective|बुद्धिमान; सूचना देना; विद्वान
withdraw|verb|हटाना; अलग करना; हटा लेना
witness|noun|करना; गवाह; प्रमाण
workforce|noun|मजदूर समुदाय{जिनको कम्पनी में किसी कार्य विशेष हेतु रखा जाता है}; जनबल; श्रमिक
workplace|noun|कार्य स्थल; कार्यस्थल
workshop|noun|शिल्पशाला; कार्य शिविर; कारखाना{मरम्मत का}
worm|noun|कमीना; दवा देना; कीड़ा
wound|noun|घाव; चोट; ज़ख़्मी
wrap|verb|समाप्त करना; गाउन; लपेटना
wrist|noun|कलाई; पहुँचा
zone|noun|क्षेत्र; मेखला; कटिबंध
"""), "en", "B2", "oxford"),

        Lesson("ox-c1", "🦉 Oxford 5000 · C1", "🦉", "1294 official Oxford words", ow("""
abolish|verb|हटाना; मिटा देना; उन्मूलन करना
abortion|noun|निष्फल; गर्भपात
absence|noun|अनुपस्थिति; अभाव; मृदु अपस्मार
absent|adjective|अनुपस्थित; नहीं; अनुपस्थित होना
absurd|adjective|निरर्थक; बेतुका; असंगत
abundance|noun|बहुलता; प्रचुरता; अधिकता/अपार
abuse|noun|गाली; दुर्व्यवहार; बरबाद करना
academy|noun|शिक्षा या शोध संस्थान; विद्यालय; प्रशिक्षण शाला
accelerate|verb|चाल बढ़ाना; तेज़ी से बढ़ाना; तेज़ करना
acceptance|noun|स्वीकृति; स्वीकार; स्वीकरण
accessible|adjective|उपलब्ध; सुगम्य; गमनीय
accomplishment|noun|समापन; कार्यसिद्धि; कौशल
accordance|noun|अनुरूप; सहमति; अधिकार अनुदान
accordingly|adverb|फलस्वरूप; परिस्थिति के अनुसार; तदनुसार
accountability|noun|उत्तरदायित्व; जवाबदेही
accountable|adjective|उत्तरदायी; असंख्य; जिम्मेदार
accumulate|verb|ढेर लगना; जमा करना; जमा होना
accumulation|noun|जमाव; संचयन; संग्रहण
accusation|noun|अभियोजन; दोषारोपण; अभियोग
accused|noun|मुलज़िम; अभियुक्त; दोषी
acid|adjective|कटु; ऐसिड; खट्टा
acquisition|noun|संपत्ति; प्राप्ति; अभिग्रहण
acre|noun|4840 वर्ग गज भूमि; एकड़; एकर
activation|noun|उत्प्रेरण; सक्रियण; क्रियान्वन
activist|noun|सक्रियतावादी
acute|adjective|अत्यधिक; नुकीला; कुशाग्र
adaptation|noun|रूपांतरण; अनुकूलन
adhere|verb|पालन करना; समर्थन करना; पालन
adjacent|adjective|निकटवर्ती; लगा हुआ; पास
adjustment|noun|सुधार; तालमेल; अनुकूलन
administer|verb|करना; देना; व्यवस्था करना
administrative|adjective|प्रशासकीय; प्रशासनीय; प्रशासनिक
administrator|noun|प्रबंधक; शासक; प्रशासक
admission|noun|स्वीकृति; दाखिला; पैठ
adolescent|noun|तेरह से उन्नीस वर्ष की आयु का; बचकाना; किशोर
adoption|noun|स्वीकार करना[होना]; स्वीकार; अंगीकार करना
adverse|adjective|प्रतिकूल; हानिकर; विपरीत
advocate|noun|समर्थन करना; वकील; अधिवक्ता
aesthetic|adjective|सुरुचिपूर्ण; सौंदर्य सिद्धांत; कलात्मक
affection|noun|स्नेह; लगाव; ममता
aftermath|noun|परिणाम
aggression|noun|आक्रमण; आघात; आक्रामकता
agricultural|adjective|कृषि; कृषिक; खेती बारी का
aide|noun|सहायक; सहायक सैनिक अधिकारी
albeit|conjunction|यद्यपि
alert|adjective|सतर्क; चौकस; जागरूक
alien|adjective|अपर देशीय; प्रतिकूल; पराया
align|verb|एक सीध में; सम्मिलित करना; एक सीध में रखना
alignment|noun|एकत्रीकरण; एकरेखन; सम्मिलित
alike|adjective|एक जैसे; एक समान; समान रूप से
allegation|noun|शिकायत; आरोप; अभिकथन
allege|verb|बिना सबूत के आरोप लगाना; आरोप लगाना; आरोप
allegedly|adverb|कथित रूप से; कथित रूप
alliance|noun|समझौता; मैत्रीपूर्ण संबंध; गठबंधन
allocate|verb|निर्धारित करना; नियत; नियत करना
allocation|noun|निर्धारण; निर्धारित; आवंटन
allowance|noun|छूट; भत्ता; वृति
ally|noun|मिलाना; मित्रपक्ष; मित्र
aluminium|noun|अल्युमिनियम; ऐल्युमीनियम
amateur|adjective|अव्यवसायी; नौसिखुआ; शौकिया
ambassador|noun|राजदूत; दूत
amend|verb|सुधारना; संशोधन करना
amendment|noun|सुधार; संशोधन; संशौधन्
amid|preposition|के बीच; बीच में ही
analogy|noun|समानता
anchor|noun|सहारा; समाचार; नींव
angel|noun|सुन्दर; देवदूत; पटी
anonymous|adjective|गुमनाम; अस्पष्ट; बेनाम
apparatus|noun|सामान; उपकरण; जंतर
appealing|adjective|आकर्षक; याचना करते हुए; जनप्रिय
appetite|noun|इच्छा; रुचि; भूख
applaud|verb|ताली बजा कर प्रशंसा करना; सराहना; ताली बजाना
applicable|adjective|लागू होना; उचित; लागू
appoint|verb|बनाना; नियुक्त करना; निर्धारित करना
appreciation|noun|समालोचना; वृद्धि; आभार
arbitrary|adjective|स्वेच्छाचारी; निर्गुण; मनमाना
architectural|adjective|वास्तुकला संबधी; वास्तुशिल्पीय
archive|noun|ऐतिहासिक अभिलेख; लेखागार; किसी एक फाइल के अन्दर बहुत फाइल्स को रखने की तकनीकी
arena|noun|रंगभूमि; कार्यक्षेत्र; अखाडा
arguably|adverb|विवादास्पद रूप से; विवादास्पद रूप
array|noun|क्रम; पोशाक; प्रभावशाली प्रदर्शन
articulate|verb|जुड़ा; सुस्पष्ट; व्यक्त करना
ash|noun|ऐश वृक्ष; ऐश वृक्ष की लकड़ी; राख
aspiration|noun|अभिलाषा/चाह; महत्वाकांक्षा; महाप्राण
aspire|verb|चाहना; आकांक्षा; आकांक्षा करना
assassination|noun|हत्या
assault|noun|प्रयास; धावा; हमला करना
assemble|verb|एकत्रित होना; जमा; इकट्ठा
assembly|noun|जमघट; सभा; फिटिंग
assert|verb|दिखाना; जोर देना; दृढतापूर्वक कहना
assertion|noun|दावा; दृढ़कथन
assurance|noun|आश्वासन; गारन्टी; विश्वास
asylum|noun|आश्रय; शरण; पागलखाना
atrocity|noun|अत्याचार; नृशंसता
attain|verb|पाना; प्राप्त करना; सिद्ध करना
attendance|noun|उपस्थिति; संख्या
attorney|noun|वकील; अधिवक्ता; मुख्त्यार
attribute|noun|विशेषता; लक्ष्ण; सहजगुण
audit|noun|परीक्षण; लेखा परीक्षण करना; अंकेक्षण
authentic|adjective|असली; प्रामाणिक; विशुद्ध
authorize|verb|अधिकार; अधिकार देना; प्राधिकृत
auto|noun|कार
autonomy|noun|स्वायत्तता; स्वशासन
availability|noun|उपलब्धता; प्राप्यता
await|verb|आसरा देखना; बाट जोहना; शलभ
backdrop|noun|
backing|noun|संगत; सहायता; सहारा
backup|noun|संगत; मदद; पीछे हटना
bail|noun|पनी उलीचना; जामिन; हत्था
ballot|noun|मत; मतदान; मत देना
banner|noun|झंडा; पताका; फलक पत्र
bare|adjective|अल्प; दिखाना; प्रकट करना
barrel|noun|पीपा; पीपे मेँ भरना; तेज़ चलाना
bass|noun|बास; मंद्र; पुमंद्रक
battlefield|noun|युध्द्भूमि; रण भूमि; रणभूमि
bay|noun|भोंक; रोना; कुत्तों की एक विशेष प्रकार की भौँक
beam|noun|चमक; झलक; प्रकाश विकिरण
beast|noun|जंगली; असभ्य व्यक्ति; जानवर
behalf|noun|हेतु
beloved|adjective|प्रेमिका; सनम; प्यारा
bench|noun|न्यायपीठ; न्यायाधीश; तख्त
benchmark|noun|मानदण्ड
beneath|preposition|नीचे की और; के योग्य; के नीचे
beneficiary|noun|लाभभोगी; हितग्राही
betray|verb|दिखाना; प्रकट करना; धोखा देना
bind|verb|लगाना; चिन्ह; भरना
biography|noun|जीवनचरित; जीवनी; जीवनी साहित्य
bishop|noun|धर्माध्यक्ष; बिशप; उंट
bizarre|adjective|अनोखा; विचित्र; अजीब
blade|noun|दल; विनोदी व्यक्ति; जिव्हाग्र
blast|noun|विस्फोट; झोंका; विनाश करना
bleed|verb|निकालना; ऐंठना; निकल जाना
blend|noun|मिलना; मिश्रण; मिलाना
bless|verb|सुखसमृध्दिसंपन्न करना; आराधना करना; वरदान
blessing|noun|सुखकर; अनुमति; आशीष
boast|verb|डींग मारना; डींग; गौरव
bonus|noun|सुखकर घटना; बोनस; सुखकर
boom|noun|गरजना; धमाका; पालदंड
bounce|verb|उछालना; उछलना; उत्साह
boundary|noun|सीमा; बाउन्डरी; सीमा/घेरा/मेढ़
bow|noun|झुकाना; सिर; गलही
breach|noun|दरार; विच्छेद; भंग
breakdown|noun|विकार; विश्लेषण; खराबी
breakthrough|noun|महत्वपूर्ण खोज; भेदन; महत्वपूर्ण
breed|noun|कुल; पैदा करना; पैदा
broadband|noun|उच्च गति डाटा संचरण तकनीकी
browser|noun|ब्राउज़र
brutal|adjective|कटु; पशुवत; निर्दयी
buck|noun|रोकना; गिरा देना; हिरन
buddy|noun|यार
buffer|noun|मूर्ख; प्रतिरोध करना; मध्यवर्ती
bulk|noun|शरीर; रेशेदार; दिखना
burden|noun|कष्ट देना; पर भार; भार
bureaucracy|noun|अधिकारी वर्ग; नौकरशाही; दफ़्तरशाही
burial|noun|कब्र; समाधि; शवाधान
burst|verb|विस्फोट; कूट कूट कर भर देना; टूट जाना
cabinet|noun|अलमारी; सन्दूकचा; कैबिनेट
calculation|noun|चाल; गणना; परिकल्पना
canvas|noun|चित्र; कैनवास; विलायती
capability|noun|योग्यता; सामर्थ्य; क्षमता
capitalism|noun|पूॅंजीवाद; पूँजीवाद
capitalist|adjective|पूँजीवादी; पूँजीपति; पूँजीवाद पर आधारित
cargo|noun|माल; जहाज मे लदा; जहाज़ का बोझ/खेप
carriage|noun|बच्चा गाड़ी; आचरण; चाल
carve|verb|काट कर चित्र बनाना; नक्काशी करना; तराशना
casino|noun|जुआघर
casualty|noun|शिकार; घायल; दुर्घटनाग्रस्त व्यक्ति
catalogue|noun|तालिका; नामावली/नामसूची; सूची बनाना
cater|verb|खान पान का प्रबंध करना; आवश्यकताओं का ध्यान रखना; खिलाना/पिलाना
cattle|noun|ढोर; पशु/मवेशी; गाय बैल
caution|noun|सावधान करना; चेतावनी; आगाह करना
cautious|adjective|सतर्क; चौकन्ना; सावधान
cease|verb|बन्द करना; बन्द; अन्त होना
cemetery|noun|समाधि स्थल; कब्रिस्तान
chamber|noun|सभा; सदन; कमरा
chaos|noun|अव्यवस्था; कोलाहल; विशृंखलता
characterize|verb|की विशेषता होना; चरित्र चित्रण करना; विशेषता होना
charm|noun|बहकाना; मनोहरता; आकर्षित करना
charter|noun|शासनपत्र; निज प्रयोग के लिये किराये पर लेना; किराये पर
chronic|adjective|पुराना; दीर्घकालिक; चिरकालिक
chunk|noun|टुकड़ा
circulate|verb|फैलना; फैलाना; घूमना
circulation|noun|खपत; गर्दिश; प्रचलन
citizenship|noun|नागरिकता; नागरिक स्वत्व/पौराधिकार
civic|adjective|नागरिक; नगर संबंधी; नगर का
civilian|adjective|असैनिक कर्मचारी; असैनिक; असैनिक नागरिक
clarity|noun|स्पष्टता
clash|noun|टक्कर; टकराना; अनबन
classification|noun|वर्गीकरण; श्रेणीविभाजन
cling|verb|चिपक; टिके रहना; लिपट जाना
clinical|adjective|भावशून्य; सादगी; नैदानिक
closure|noun|मतादेश दे कर समापन; समापन; बंद होना
cluster|noun|गुच्छा; जमा; झुण्ड
coalition|noun|अस्थायी संगठन्; संगठन; मिला
coastal|adjective|तटीय; तटस्थ
cocktail|noun|ककटेल; मद्यपान की दावत; मधपान की
cognitive|adjective|बोध; संज्ञानात्मक
coincide|verb|मेल खाना; मेल; एक ही समय में होना
collaborate|verb|शत्रु से मिल; देशद्रोह करना; सहयोग करना
collaboration|noun|सहयोग
collective|adjective|समूह; सामूहिक; संगठन
collision|noun|टक्कर; विचारों में टक्कर; संघर्ष
colonial|adjective|उपनिवेशी; औपनिवेशिक
columnist|noun|स्तंभलेखक
combat|noun|विरोध करना; युद्ध; युद्ध करना
commence|verb|शुरू; शुरू करना; आरम्भ होना
commentary|noun|कमेंट्री; टिप्पणी; भाष्य
commentator|noun|समालोचक; विवरण प्रसारक; भाष्यकार
commerce|noun|वाणिज्य
commissioner|noun|अधिकारी; कमिश्नर; आयुक्त
commodity|noun|माल; उपयोगी; सामग्री
communist|adjective|साम्यवादी; साम्यवाद; साम्यवाद संबंधी
companion|noun|साथी; छोटी पुस्तक; मिट्र
comparable|adjective|तूलनीय; तुलनीय
compassion|noun|सहानुभूति; दया; अनुकम्पा
compel|verb|मजबूर; जबरदस्ती कराना; विवश करना
compelling|adjective|undefined; अकाट्य
compensate|verb|क्षतिपूर्ति; क्षतिपूर्ति करना; हरजाना देना
compensation|noun|मुआवजा; हरजाना; हर्जाना
competence|noun|सामर्थ्यता; योग्यता
competent|adjective|सक्षम; समर्थ; क्षमताशाली
compile|verb|जमा करना; संग्रह करना; इकट्ठा करना
complement|verb|पूरक; समपूरक; विधेयार्थ
complexity|noun|जटिलता
compliance|noun|समर्पण; अनुकूलता; अनुपालन
complication|noun|जटिलता; परेशानी; उलझन
comply|verb|पालन करना; स्वीकार करना; आज्ञा मानना
composition|noun|बनावट; लेखन; संरचना
compromise|noun|समझौता; जोखिम में डालना; समझौता करना
compute|verb|गणना करना; परिकलन करना; परिकलन
conceal|verb|छिपाना
concede|verb|मानना; मान लेना; झुक जाना
conceive|verb|कल्पना करना; अनुमान; सोचना
conception|noun|धारणा; समझ; गर्भाधान
concession|noun|स्वीकृति; सुविधा; छूट
condemn|verb|घोषित करना; दोष लगाना; निंदा करना
confer|verb|प्रदान करना; प्रदान; परामर्श करना
confession|noun|स्वीकृति; धर्म सिद्धांतों की; धर्म सिद्धांतों की स्वीकृति
configuration|noun|समाकृति; कंप्यूटर की व्यवस्था का प्रारूप
confine|verb|कैद रखना; सीमा; सीमीत रखना
confirmation|noun|सत्यापन; पुष्टीकरण; पुष्टिकरण
confront|verb|सामना होना; सामना; सामना करना
confrontation|noun|सामना
congratulate|verb|बधाई देना; बधाई
congregation|noun|मण्डली; सभा; एकत्रीकरण
congressional|adjective|कंग्रेस संबंधी; सम्मेलन संबंधी; सम्मेलन
conquer|verb|जीतना; परास्त करना; विजय प्राप्त कर
conscience|noun|अच्छे बुरे की समझ; विवेक; अच्छे बुरे की
consciousness|noun|जानकारी; होश; चेतना , होश
consecutive|adjective|लगातार
consensus|noun|सहमति; तालमेल; अनुकूलता
consent|noun|स्वीकृति; सहमति; अनुमति देना
conserve|verb|संरक्षित; मुरब्बा; सुरक्षित रखना
consistency|noun|तालमेल; सामंजस्य; संगतता
consolidate|verb|मजबूत; मजबूत बनाना; मिल जाना
constituency|noun|मतदाता वर्ग; निर्वाचन क्षेत्र; मतदान
constitute|verb|होना; बनाना; निर्माण करना
constitution|noun|बनावट; गठन; शारीरिक गठन
constitutional|adjective|स्वास्थ्य के लिए; स्वास्थ्य के लिए सैर; संविधानी
constraint|noun|दबाव; अवरोध; प्रतिबंध
consultation|noun|परामर्श; विचार विमर्श सभा; संमत्रण
contemplate|verb|विचार करना; विचार; ध्यान
contempt|noun|निन्दनीय; तिरस्कार; अवमानना
contend|verb|विवाद करना; संघर्ष; दावे
contender|noun|प्रतियोगी; मुकाबला करने वाला
content|adjective|मात्रा; सन्तुष्ट; सन्तुष्ट करना
contention|noun|तर्क; विवाद/झगड़ा; दावा
continually|adverb|लगातार; निरंतर
contractor|noun|ठेकदार; ठेकेदार
contradiction|noun|प्रतिवाद; विरोधाभास; अन्तर्विरोध
contrary|adjective|प्रतिकूल; उलटा; विपरीत
contributor|noun|सहयोगी; अंशदाता; अंश दाता
conversion|noun|परिवर्तन; सुधार; रूपांतरण
convict|verb|अपराधी; अपराधी ठहराना; दोषी
conviction|noun|अपराध सिद्धि; दोषसिद्धि; दृढ
cooperate|verb|मदद करना; सहयोग; सहयोग देना
cooperative|adjective|सहयोगी; सहकारी; सहकारी समिति
coordinate|verb|समन्वयीकरण; समन्वित करना; समन्वयीकरण करना
coordination|noun|समन्वयीकरण; ताल मेल; समन्वयन
coordinator|noun|ताल मेल बैठाने वाला; समन्वयक
cop|noun|लगना; चुराना; पकड़ना
copper|noun|पुलिस; पुलिसमैन; लाल भूरा रंग
copyright|noun|रचना स्वत्व सुरक्षित; प्रतिलिप्यधिकार द्वारा सुरक्षित; प्रकाशनाधिकृत
correction|noun|संशोधन; शोधन/सुधार/शुद्धि; जाँचना
correlate|verb|सहसंबंधित होना; सहसंबंधी वस्तु; परस्पर संबंधित करना
correlation|noun|पारस्परिक सम्बन्ध; सहसंबंध
correspond|verb|एकमत होना; मेल खाना; मेल
correspondence|noun|लिखा; समानता; लिखा पढी
correspondent|noun|लिखनेवाला; चिट्ठी लिखने वाला; संवाददाता
corresponding|adjective|समरूपी; चिट्ठी/पत्री; जो समतुल्य हो
corrupt|adjective|भ्रष्ट; बिगड़ी हुई भाषा/लेख/डेटा आदि; विकृत
corruption|noun|भ्रष्टाचार; भ्रष्टाचार्
costly|adjective|भारी; कड़े संघर्ष से प्राप्त; महँगा/बड़े मोल का/बहुमूल्य
councillor|noun|पार्षद्; सभासद/{सभा का} सदस्य
counselling|noun|सलाह देना; सलाह
counsellor|noun|वकीळ; ग्रीष्म शिविर संचालक; परामर्शदाता
counterpart|noun|प्रतिरूप; प्रतिस्थानी
countless|adjective|असंख्य; असंख्य/अनगणित; बीसों
coup|noun|आकस्मिक शासन परितर्तन; आकस्मिक शासन; आघात
courtesy|noun|शालीनता; कृपा; विनय
crawl|verb|क्राल; रेंगना; रेंगने वाली चीजों से भरा होना
creator|noun|सृष्टिकर्त्ता; रचयिता; जन्मदाता
credibility|noun|विश्वसनीयता; विश्वस्नीयता
credible|adjective|विश्वसनीय; विश्वास करने योग्य; सत्याभासी
creep|verb|जाना; डर; छिपकर घुसना
critique|noun|प्रत्यालोचना; समीक्षा
crown|noun|शिखर; सिर पर मारना; सिर
crude|adjective|अश्लील; अशिष्ट; अपरिष्कृत
crush|verb|चूर चूर; दबाना; जमघट
crystal|noun|स्फटिक; घड़ी का काँच; स्फटिक कांच पात्र
cult|adjective|उपासना; सनक; मत
cultivate|verb|करना; तैयार; तैयार करना
curiosity|noun|असामान्य; जिज्ञासा; अपूर्व वस्तु
custody|noun|संरक्षण; रक्षा; हिरासत
cutting|noun|कटु; तीखा; कलम
cynical|adjective|स्वार्थी; दोषदर्षी; चिड़चिड़ा आदमी
dam|noun|बाँध बनाना; बाँध; बाँध बाँधना
damaging|adjective|अहितकर
dawn|noun|होना; निकलना; सामने आना
debris|noun|रोड़ा; मलबा; कचरा
debut|noun|शुरुआत; प्रारंभ; पेश करना
decision-making|noun|
decisive|adjective|निर्णायक; त्रुअन्त निर्णय लेने; सोचा समझा
declaration|noun|वचन; घोषणा; घोषण पत्र
dedicated|adjective|समर्पित; एक ही; एक ही कार्य करने में सक्षम
dedication|noun|समर्पण वचन; समर्पण; अर्पण
deed|noun|कार्य; काम; विलेख
deem|verb|समझना; उचित; मानना
default|noun|चूकना; अनुपस्थिति; भुगतान न करना
defect|noun|दोष; खराबी; छोड़्कर शामील हो जाना
defensive|adjective|सतर्क; रक्षात्मक; रक्षक
deficiency|noun|कमी; दोष
deficit|noun|कमी; घाटा
defy|verb|विरोध करना; सामना करना; चुनौती देना
delegate|noun|सौंपना; नियुक्त करना; कर्नव्यों की व्याख्या करना
delegation|noun|प्रतिनिधि; प्रतिनिधि मंडल; कर्तव्यो की व्याख्या
delicate|adjective|स्वादिष्ट; लिहाज रखनेवाला; उत्कृष्ट
demon|noun|भूत; दैत्य; शैतान
denial|noun|इंकार; निषेध; परित्याग
denounce|verb|समाप्त करना; भर्त्सना करना; दोषी ठहराना
dense|adjective|सघन; मूर्ख; घना
density|noun|घनत्व; सघनता
dependence|noun|सहारा; निर्भर्ता; विश्वास
depict|verb|दर्शाना; चित्रित; चित्रित करना
deploy|verb|फैलाना; तैनात करना; असरदार तरीके से इस्तेमाल करना
deployment|noun|परिनियोजन; तैनाती
deprive|verb|वंचित; वंचित करना
deputy|noun|प्रतिनिधि; स्थानापन्न प्रतिनिधि
descend|verb|उतरना; उतारना; नीचे उतरना
descent|noun|कुल; वंश; वंशज
designate|verb|दिखाना; निर्दिष्ट; मनोनीत करना
desirable|adjective|योग्य; वांछित; वांछनीय
desktop|noun|मेज़ की उपरी सतह; डेस्कटप; डेस्क्टप
destructive|adjective|हानिकर; हानिकारक; विध्वंशकारी
detain|verb|रोकना; फँस जाना; फँस
detection|noun|खोज
detention|noun|अवरोध; कैद; अवरोधन दंड
deteriorate|verb|बिगड़ना
devastate|verb|उजाड़ना; बरबाद कर देना; सर्वनाश करना
devil|noun|शरारती; दुष्ट; व्यक्ति
devise|verb|विचार करना; योजना बनाना; आविष्कार करना
diagnose|verb|लक्षण देखकर{रोग}निर्णय करना; निदान करना
diagnosis|noun|लक्षण; रोग; रोग की पहचान
dictate|verb|आज्ञा; आज्ञा देना; लिखवाना
dictator|noun|तानाशाह
differentiate|verb|अलग करना; भेद भाव करना; अंतर करना
dignity|noun|प्रतिष्ठा; मर्यादा; गौरव
dilemma|noun|दुविधा; उहापोह; असमंजस
dimension|noun|परिमाण; पहलू; आयाम
diminish|verb|कम करना; घटाना; कम हो जाना
dip|verb|झुकाना; कम करना; निकालना
diplomat|noun|कूटनीतिज्ञ; राजदूत; व्यवहार कुशल
diplomatic|adjective|कूटनीतिज्ञ; व्यवहारकुशल; राजनयिक
directory|noun|डाइरेक्टरी; डायरेक्टरी; निर्देशिका
disastrous|adjective|विनाशकारी; दुर्घटनापूर्ण; नाशक
discard|verb|निकाल देना; डाल देना; डाल
discharge|verb|गिरना; स्राव; प्रवाह
disclose|verb|बताना; दिखाना; प्रकट करना
disclosure|noun|प्रकटीकरण
discourse|noun|उपदेश; चर्चा; भाषण देना
discretion|noun|समझदारी; विचार; विवेक
discrimination|noun|पक्षपात; विवेक; भेदभाव
dismissal|noun|उपेक्षा करना; बरख़ास्तगी
displace|verb|हटाना; निकाल देना; दूसरों का स्थान लेना
disposal|noun|निष्कासन; छुटकारा; बिक्री
dispose|verb|सजाना; ठीक रखना; ठिकाने लगाना
dispute|noun|विवाद करना; झगड़ना; झगड़ा
disrupt|verb|भंग करना; भंग; तितर बितर करना
disruption|noun|विघटन; हंगामा; विघ्न
dissolve|verb|घुलना; भंग करना; भंग
distinction|noun|प्रतिष्ठा; पार्थक्य; अन्तर
distinctive|adjective|विशिष्ट; विशेष/भेद बतानेवाला/सविशेष/विशेषक
distort|verb|तोड़ मरोड़ करना; रूप बिगाड़ना; विकृत
distress|noun|दुःख; कठिनाई; दुःख होना
disturbing|adjective|अशांत; तकलीफ़देह; विक्षोभकारी
divert|verb|मनोरंजन करना; दूसरे; फेरना
divine|adjective|सुन्दर; भविष्यवाणी; पवित्र
doctrine|noun|सिद्धांत; मत; विश्वास योग्य नीति
documentation|noun|लिखित प्रमाण; क़ानूनी; लिखित
domain|noun|क्षेत्र; प्रांत; कार्यक्षेत्र
dominance|noun|प्रभुत्व
donor|noun|दाता
dose|noun|यौन रोग; खुराक; औषधि की मात्रा
drain|verb|बहना; नाली; खाली करना
drift|verb|बहना; ढेर; धारा
driving|adjective|प्रबल; मूसलाधार; चालन
drown|verb|डुबा; जलमग्न कर देना; डुबा कर मारना
dual|adjective|दोहरा; द्विक/दोनों; द्वैध
dub|verb|उपाधि देना; नाम देना; थाप
dumb|adjective|मूर्ख; मूक; मौन
duo|noun|
eager|adjective|उत्साही; उत्सुक; इच्छुक
earnings|noun|तनखाह; कमाई
ease|noun|शांत करना; आराम; हल्का करना
echo|noun|हाँ में हाँ मिलाना; गूँज; छाया झलकना
ecological|adjective|परिस्थिति विज्ञान; पारिस्थितिक; पर्यावरणीय
educator|noun|शिक्षक; शिक्षाविशारद्
effectiveness|noun|प्रभावकारिता; फल साधना
efficiency|noun|दक्षता; कार्यक्षमता; चुस्ती
ego|noun|अहम्; खुद्दार
elaborate|adjective|विस्तार से बनाना; व्याख्या; व्यापक
electoral|adjective|निर्वाचक; निर्वाचकीय
elevate|verb|उठाना; बुलन्द करना; ऊचाँ उठाना
eligible|adjective|योग्य; वांछनीय
elite|noun|विशिष्ट; अभिजात वर्ग; विशिष्ट वर्ग
embark|verb|जाने का साहस करना; जहाज़ पर चढ़ना; चढ़ना[चढ़ाना]
embarrassment|noun|घबराहट; उलझन
embassy|noun|राजदूत; राजदूतावास
embed|verb|बैठ जाना; बैठ
embody|verb|सम्मिलित करना; साकार करना; मूर्त रूप देना
emergence|noun|आविर्भाव
empirical|adjective|अनुभवजन्य
empower|verb|अधिकार; अधिकार देना; समर्थ बनाना
enact|verb|कानून बनाना; अभिनय करना; कानून
encompass|verb|घेरना; शामिल करना; सम्मिलित करना
encouragement|noun|हौसला; प्रोत्साहन
encouraging|adjective|प्रोत्साहक
endeavour|noun|प्रयत्न; प्रयत्न करना; यत्न करना
endless|adjective|अनंत; बेहद; निःसीम
endorse|verb|समर्थन करना; विज्ञापन करना; पृष्ठांकन
endorsement|noun|विज्ञापन; अंकन; समर्थन
endure|verb|सहना; सहन करना; टिके रहना
enforce|verb|लागू; लागू करना
enforcement|noun|प्रवर्तन
engagement|noun|वचन; सगाई; वाग्दान
engaging|adjective|रमणीय; दिलचस्प; आकर्षक
enquire|verb|पता; पूछना; पता लगाना
enrich|verb|उपजाऊ बनाना; उपजाऊ बनानाधनीधुनाड्य करना; समृद्ध बनाना
enrol|verb|नाम लिखाना
ensue|verb|पीछा करना; परिणामस्वरूप; परिणामस्वरूप होना
enterprise|noun|उद्योग; उद्यम; साहसिक कार्य
enthusiast|noun|समर्थक; उत्साही; उत्साह या अति श्रद्धापूर्ण व्यक्ति
entitle|verb|उपाधि देना; अधिकार देना; हकदार होना
entity|noun|हस्तीस्थिति; तत्त्व; सत्व
epidemic|noun|महामारी; संक्रामक रोग के; संक्रामक रोग के समान
equality|noun|समानता
equation|noun|समीकरण; समता
erect|verb|निर्माण करना; निर्माण; खड़ा करना
escalate|verb|ब्ढाना; बढ़
essence|noun|सार; तत्व/गुण; इत्र
establishment|noun|स्थान; संस्था; नींव
eternal|adjective|निरन्तर; नित्य; अविनाशी
evacuate|verb|मलोत्सर्ग; सुरक्षित स्थान पर ले जाना{असुरक्षित जगह से}; खाली
evoke|verb|आह्वान करना; ताज़ा करना
evolutionary|adjective|विकासमूलक
exaggerate|verb|बढा चढा कर कहना; बढ़ा चढ़ाकर कहना; बढा चढा कर
excellence|noun|प्रतिष्ठा; विशिष्टता; श्रेष्ठता
exceptional|adjective|विशिष्ट; असाधारण; असामान्य
excess|adjective|बहुत अधिक; अधिशेष; अधिकता
exclusion|noun|बहिष्कार; बहिष्करण; अपवर्जन
exclusive|adjective|निवारक; विशिष्ट; अखंडित
exclusively|adverb|पूरी तरह से; केवल
execute|verb|पूरा; कार्यान्वित करना; संचालन करना
execution|noun|फाँसी; सम्पादन करना; कार्यान्वयन
exert|verb|जोर; काम में लाना; बल लगाना
exile|noun|प्रवास; निर्वासन; देशनिकाला देना
expenditure|noun|खर्च; व्यय
experimental|adjective|प्रायोगिक
expire|verb|समाप्त; समाप्त होना; स्वर्गवास होना
explicit|adjective|सुस्पष्ट; स्पष्ट; सुनिश्चित
explicitly|adverb|स्पष्टता से; स्पष्टतया
exploitation|noun|उपयोग; शोषण; दोहन
explosive|adjective|विदारणशील; विदारणशील पदाष्थ; बारूद
extremist|noun|अतिवादी; उग्रवादी; गरम दल का
facilitate|verb|सुकर; सरल बनाना; सरल
faction|noun|गुट; दलबंदी; उपद्रवी दल
faculty|noun|शक्ति; संकाय; योग्यता
fade|verb|धुंधला पड़; कम होना; मुरझाना
fairness|noun|
fatal|adjective|जीवघातक; घातक; प्राणांतक
fate|noun|विधि; भाग्य; निर्धारित करना
favourable|adjective|हितकारी; अनुकूल; स्विकाराट्मक
feat|noun|वीरता का काम; कमाल
feminist|adjective|नारीवादी{स्त्री के अधिकारों के पक्ष का व्यक्ति}; नारी अधिकारवादी
fibre|noun|प्रकृति; मोटा चारा; रेशा
fierce|adjective|भारी; घमासान; उत्तेजित
film-maker|noun|
filter|noun|छानना; छलनी; यातायात बत्ती पर बाँएँ मुड़ना
firearm|noun|असला; अग्न्यस्ट्र
fixture|noun|स्थाई; निर्धारण; जोड़ा गया उपकरण
flaw|noun|त्रुटि; कमज़ोरी; दोष
flawed|adjective|
flee|verb|भाग जाना; फरार; भाग
fleet|noun|फुर्तीला; तेज़; नौसेना
flesh|noun|प्रोत्साहित; उत्तेजित करना; प्रोत्साहित करना
flexibility|noun|लचीलापन; सुनम्यता
flourish|verb|अलंकरण; हाव भाव से; फलना फूल् होना
fluid|noun|लचीला; अस्थिर; प्रवाही
footage|noun|फुटमान; फ़िल्म का हिस्सा; फ़िल्म का
foreigner|noun|परदेशी; विदेशी
forge|verb|ढालना; विकसित करना; तपाकर गढ़ना/बनाना
formula|noun|सूत्र; विधि; नुस्खा
formulate|verb|निरूपित; निरूपित करना; प्रतिपादित करना
forth|adverb|आगे; आगे की ओर; बाहर
forthcoming|adjective|स्पष्टवादी; आगामी; आसन्न
foster|verb|प्रोत्साहित; प्रोत्साहित करना; प्रोत्साहन
fragile|adjective|दुर्बल; भंगुर; सुकुमार
franchise|noun|मताधिकार; मतदान का अधिकार; सरकार से किसी विशेष की आज्ञा
frankly|adverb|ईमानदारी; ईमानदारी से; स्पष्ट रूप से
frustrated|adjective|असंतुष्ट; हताश; हतोत्साहित
frustrating|adjective|निराश युक्त; कुंठाकारी; अवसादी
frustration|noun|नैराश्य; निराशा; कुंठा
functional|adjective|व्यावहारिक; क्रियाशील; काम में आने लायक
fundraising|noun|
funeral|noun|दफन; क्रिया कर्म; अन्त्येष्टि
gallon|noun|गैलन{लगभग 4.5 लीटर}; गैलन
gambling|noun|जुआ खेलना; द्युत
gathering|noun|सभा; संग्रहण; सभाआ
gaze|noun|एक्टक देखने; टकटकी; घूरना
gear|noun|मशीन के इंजन को पहियों से जोड़ने वाला यंत्र; सामान; गति
generic|adjective|सामान्य; जाति का; प्रजातिगत
genocide|noun|जातिसंहार; जनसंहार; रक्त पात
glance|noun|चमकना; ग्लांस करना; नजर डालना
glimpse|noun|झलक; झाँकी; जल्दी से एक नज़र ड़ालना
glorious|adjective|शानदार; सुहावना; तेजस्वी
glory|noun|अप्रतिम सुन्दरता; अप्रतिम; स्वर्ग
governance|noun|शासन; संचालन
grace|noun|मनोहरता; अदा; दया
grasp|noun|समझना; पाने का प्रयत्न; समझ
grave|adjective|महत्त्वपूर्ण; महत्वपूर्ण; खोदना
gravity|noun|गुरुत्व; गंभीरता; गुरुत्वाकर्षण
grid|noun|जाली; विद्युत् वितरण तंत्र; ग्रिड
grief|noun|गहरा दुःख; गहरा; दुख
grin|noun|ठहाका लगाना; मुस्कराहट; दाँत दिखाते हुए मुस्कुराना
grind|verb|रगड़ना; चक्की; रगड़ देना
grip|noun|मजबुत पकड़; थैला; समझ
gross|adjective|घटिया; भद्दा; अश्लील
guerrilla|noun|छापामारअ; गुरिल्ला
guidance|noun|नेतृत्व; मार्गदर्शन; मार्ग दर्शन
guilt|noun|अपराध; दोष; पाप
gut|noun|सार; साहस; तहस नहस
hail|verb|ओलावृष्टि; बुलाना; अभिवादन
halfway|adverb|बीच में; आधा; आधे रास्ते का
halt|noun|पड़्व; रूकना; रुकना
handful|noun|मुट्ठी; मुट्ठी भर; अंजलि भर
handling|noun|चलाना; उठाना धरना; प्रबंधन
handy|adjective|पास; निपुण; आसान
harassment|noun|परेशानी; कष्ट; उत्पीड़न
hardware|noun|हार्डवेयर; भारी शस्ट्र सामग्री; लोहे व अन्य धातु का सामान
harmony|noun|मधुर सम्बन्ध; तालमेल; समानता
harsh|adjective|कटु; कर्कश; निर्दयी
harvest|noun|फसल कटाई का समय; फसल; फसल एकत्र
hatred|noun|घृणा; द्वेष; नङरतअ
haunt|verb|प्रेत के रूप में जाते रहना; याद आना; भूत बन कर घूमना
hazard|noun|खतरे में डालना; अनुमान लगाने की कोशिश करना; अनुमान लगाने
heighten|verb|बढ़; बढ़ा देना; बढ़ जाना
heritage|noun|उत्तराधिकार; पैतृक संपत्ति; विरासत
hierarchy|noun|वर्गीकरण; पदानुक्रम
high-profile|adjective|
hint|noun|झलक; संकेत; सुझाव
homeland|noun|जन्मभूमि; स्वदेश
hopeful|adjective|आशाजनक; आशामय; आशावान
horizon|noun|सीमा; क्षितिज
horn|noun|सींग से मारना; भोंपू; सींग का बना हुआ
hostage|noun|बंधक; बंधक व्यक्ति
hostile|adjective|शत्रुतापूर्ण; शत्रु का; विरोधी
hostility|noun|शत्रुता; द्वेष; दुश्मनी
humanitarian|adjective|परोपकारी; मानवतावादी
humanity|noun|मानवता; मानव जाति; इंसानियत
humble|adjective|विनम्र; नीचा दिखाना; नम्र
hydrogen|noun|हाइड्रोजन; उदजन
identification|noun|पहचान; समीकर
ideological|adjective|आदर्शपूर्ण; वैचारिक; सैद्धांतिक
ideology|noun|विचारधारा; एक सर्वमान्य विचार
idiot|noun|जड़; मूर्ख; गधा
ignorance|noun|अज्ञानता; अज्ञान
imagery|noun|अलंकृत भाषा; आकृति; अलंकृत
immense|adjective|असीम; अमित; विपल
imminent|adjective|आसन्न; सन्निकटत; घटित  होने वाला
implementation|noun|लागू; लागू करना; परिपालन
imprison|verb|कैद; बंदी बनाना; क़ैद करना
imprisonment|noun|अवरोधन; कारावास; क़ैद
inability|noun|असमर्थता; अयोग्यता; असामर्थ्य
inadequate|adjective|अयोग्य; अपर्याप्त
inappropriate|adjective|अनुपयुक्त; असंगत
incidence|noun|आपतन{भार}; आपतन
inclined|adjective|तैयार; प्रवृत्त; झुका
inclusion|noun|समावेशन
incur|verb|नुक्सान उठाना; अपने; अपने ऊपर लेना
indicator|noun|सूचक; संकेतक
indictment|noun|कलंक; अभ्यारोपण; अभियोगपत्र
indigenous|adjective|मूल निवासी; स्वदेशीय/देशज; देशज
induce|verb|लाना; प्रेरित करना; प्रवृत
indulge|verb|लिप्त होना; प्रसन्न करना; खुश करना
inequality|noun|असमानता; असमानता/विषमता; असमता
infamous|adjective|कुख्यात
infant|noun|बच्चा; लाल; शिशु
infect|verb|इनफेक्ट करना; दूषित करना; प्रभावित करना
inflict|verb|डालना; पहुँचाना; दंड देना
influential|adjective|प्रभावशाली; दबदबेवाला
inherent|adjective|अन्तर्निहित; जन्मजात; स्वाभविक
inhibit|verb|रोकना; निरोध करना; बाधा डालना
initiate|verb|आरम्भ करना; शुरू करना; दीक्षित
inject|verb|लगाना; भर देना; सुई लगाना
injection|noun|सितारा मछली; इंजेक्शन; अंतःक्षेप
injustice|noun|जफा; अन्याय
inmate|noun|कैदी; निवासी; वासी
insertion|noun|डालना; अन्त; निवेशन
insider|noun|घनिष्ठ व्यक्ति; अंतरंग; अंदर वाला व्यक्ति
inspect|verb|परीक्षण करना; जांच करना; निरीक्षण करना
inspection|noun|निरीक्षण
inspiration|noun|उत्प्रेरणा; प्रेरणा; शानदार विचार
instinct|noun|प्रकृति; प्रवृति; सुझ भुज
institutional|adjective|संस्थानिक; संस्थागत
instruct|verb|बताना; उपदेश देना; सूचित करना
instrumental|adjective|सहायक; वाद्य संगीत; वाद्य संगीत संबंधी
insufficient|adjective|अपर्याप्त
insult|noun|अपमान होना; अपमान; अपमान करना
intact|adjective|अक्षत; अखण्ड
intake|noun|भरती; ग्रहण करना; वायुगवाक्ष
integral|adjective|अनिवार्य; पूर्ण; संपूर्ण
integrated|adjective|समाकलित
integration|noun|एकीकरण; समाकलन
integrity|noun|सत्यनिष्ठा; अखंडता; ईमानदारी
intensify|verb|बढ़ा देना; सशक्त करना; बढ़ जाना
intensity|noun|प्रबलता; उग्रता; प्रचंडता
intensive|adjective|तीव्र; वृद्धिकर; गहन
intent|noun|स्थिर; डूबा; उद्देश्य
interactive|adjective|पारस्परिक; इंटरैक्टिव; एक दूसरे को प्रभावित करने वाला
interface|noun|विद्युत् परिपथ अंतराफलक; इंटरफ़ेस द्वारा जुड़ा होना; इंटरफ़ेस
interfere|verb|बीच मेँ पड़ना; बाधा डालना; दखल देना
interference|noun|बाधा; हस्तक्षेप; व्यतिकरण
interim|adjective|अंतरिम; अन्तरिम अवधि; अल्पकालीन
interior|adjective|भीतरी; भीतर; तटवर्ती
intermediate|adjective|मध्यवर्ती; माध्यमिक; अन्ट्रवर्ती
intervene|verb|हस्तक्षेप करना; बीच मेँ आना; बीचबचाव करना , हस्तक्षेप करना
intervention|noun|हस्तक्षेप; मध्यवर्त
intimate|adjective|बताना; घनिष्ठ; आत्मीय
intriguing|adjective|लुभावना; पहेलीनुमा
investigator|noun|जाँच करने वाला; जाँच कर्ता; गवेक्षक
invisible|adjective|अलक्ष्य; अप्रकट; अदृश्य
invoke|verb|बुलाना; आह्वान करना; उपयोग करना
involvement|noun|हस्तक्षेप; संबन्ध; सहभागिता
ironic|adjective|व्यंग्यात्मक; व्यंग्यपूर्ण; विडंबनात्मक
ironically|adverb|विडंबनात्मक रूप से; व्यंग्यपूर्वक; व्यंग्यपूर्ण ढंग से
irony|noun|व्यंग्योक्ति; विडंबना; व्याजोक्ति
irrelevant|adjective|असंबद्ध; बेमतलब; अप्रासंगिक
isolation|noun|सितारा मछली; एकांत; अलगाव
judicial|adjective|न्यायिक
junction|noun|जंक्शन; रेलमार्गसंयोग; संधिस्थल
jurisdiction|noun|न्याय अधिकार; अधिकार क्षेत्र; न्याय करने का अधिकार
just|adjective|बस
justification|noun|प्रामाणिकता; औचित्य
kidnap|verb|अपहरण करना[होना]; अपहरन करना; अपहरण
kidney|noun|गुर्दा; गुरदा; वृक्क
kingdom|noun|शासित; प्रभुत्व; राज्य
lad|noun|लडका/नवयुवक; लड़का
landlord|noun|शराबखाने का मालिक; शराबखाने; मकान मालिक
landmark|noun|सीमाचिह्न; थल चिह्न; युगांतकारी घटना
lap|noun|आगे बढना; टकराना; क्रोड़
large-scale|adjective|
laser|noun|लेजर
latter|adjective|अनुवर्ती; दूसरा
lawn|noun|मैदान; लॉन/दूर्वाक्षेत्र; मलमल
lawsuit|noun|मुकदमा; नालिश
layout|noun|खाका; अभिन्यास; नक्शा
leak|noun|बूँद; रहस्योद्घाटन; रहस्योदघाटन
leap|noun|छलांग मारना; उछलना; कूदना
legacy|noun|पैत्रिक सम्पत्ति; पैतृक संपत्ति; परम्परा में प्राप्त
legendary|adjective|प्रसिद्ध; पौराणिक
legislation|noun|विधि; विधान; कानून
legislative|adjective|विधि संबंधी; विधि; वैधानिक
legislature|noun|विधानमण्डल; विधानमंडल
legitimate|adjective|कानूनी; वैध; उचित
lengthy|adjective|लम्बा; बहुत लंबा; बहुत
lesbian|adjective|समलिंग कामी महिला
lesser|adjective|न्यूनतर
lethal|adjective|घातक; हानिकारक
liable|adjective|उत्तरदायी; उत्तरदायित्व; आदी
liberal|adjective|उदार; दान शील; उदारचरित
liberation|noun|मुक्ति; आज़ादी
liberty|noun|स्वतंत्रता; आजादी; रिहाई
license|verb|स्वच्छंदता; लाइसेंस; अनुज्ञा प्रदान
lifelong|adjective|आजीवन
likelihood|noun|संभावना
limb|noun|शरारती; शाखा; अंग
line-up|noun|
linear|adjective|रेखागत; लंबाई; रेखीय
linger|verb|रुका रहना; ठहराना; टिका रहना
listing|noun|सूची; नामांकन सूची; नामांकन
literacy|noun|साक्षरता
liver|noun|जिगर; लीवर; यकृत
lobby|noun|प्रचार करना; दबाव; दबाव डालने वाला दल्गोष्ठ
log|noun|आगे बढना; तय करना; काटना
logic|noun|तर्क; तर्क शास्ट्र; गणितीय तर्क
long-standing|adjective|
long-time|adjective|
loom|verb|अस्पष्ट छाया दीखना; हावी होना; सम्भावना होना
loop|noun|फंदा; परिपथ; फन्दा
loyalty|noun|स्वामिभक्ति; ईमानदार; ईमानदारी
machinery|noun|उपकरण; यंट्र औजार; प्रशासन
magical|adjective|शानदार; जादुई; मायिक
magistrate|noun|दण्डाधिकारी; मैजिस्ट्रेट/दण्डाधिकारी; मजिस्ट्रेट
magnetic|adjective|चुम्बकीय; चुंबकीय
magnitude|noun|परिमाण; जटिलता; विस्तार
mainland|noun|मुख्य भू भाग; मुख्य भूभाग
mainstream|adjective|मुख्यधारा; मुख्य विचारधारा; मुख्यधारा विषयक
maintenance|noun|अनुरक्षण; निर्वाह; रख
mandate|noun|सौंपना; आदेश देना; आदेश
mandatory|adjective|अनिवार्य; आवश्यक
manifest|verb|सुस्पष्ट; व्यक्त करना; स्पष्ट
manipulate|verb|चलाना; हड्डी बिठाना; हेरफेर करना
manipulation|noun|काम; हस्त कौशल; काम निकालना
manuscript|noun|हस्तलिपि; पांडुलिपि; हस्तलिखित
marginal|adjective|बहुत कम; अत्यल्प; हाशिये का
marine|adjective|समुद्री; नौसैनिक; समुद्रीय
marketplace|noun|
mask|noun|छिपाना; परदा; मुखौटा
massacre|noun|नरसंहार; हत्याकाण्ड; कड़ी पराजय देना
mathematical|adjective|गणित सम्बन्धी; गणित; गणित का
mature|adjective|पका हुआ; पूर्ण विकसित; परिपक्व
maximize|verb|अधिकतम लाभ उठाना; उच्चतम सीमा तक बढ़ाना
meaningful|adjective|महत्वपूर्ण; अर्थपूर्ण; बोधगम्य
meantime|noun|इस बीच; इस; इसी बीच
medieval|adjective|मध्यकालीन; मध्ययुगीन
meditation|noun|ध्यान; विचार; चिंतन
melody|noun|मधुर गीत; मधुर संगीत
memo|noun|मेमो; ज्ञापन; पुर्ज़ा
memoir|noun|संसमरण; जीवनी
memorial|noun|स्मारक
mentor|noun|अनुभवी परामर्शदाता; विश्वसनीय सलाहकार; अनुभवी
merchant|noun|व्यापारी; सौदागर; पणिता
mercy|noun|दया; करुणा; कृपा
mere|adjective|केवल; मात्र; झील
merely|adverb|केवल; मात्र
merge|verb|मिलाना; विलय; विलय हो जाना
merger|noun|विलयन; विलय; मिलावट
merit|noun|विशेषता; योग्यता; सराहना
methodology|noun|प्रणाली; प्रविधि; प्रणाली विज्ञान
midst|noun|बीच
migration|noun|प्रवास; प्रवसन; प्रवर्जन
militant|adjective|युद्धरत; युद्धकारी; आक्रामक
militia|noun|नागरिक सेना
mill|noun|चक्की; पीसना; मिल
minimal|adjective|अल्पतम; छोटे से छोटे
minimize|verb|कम करना; कम कर; कम करके बताना
mining|noun|खनन
ministry|noun|प्रबंध; मंत्रालय; मंत्री मंडल
minute|adjective|मिनट
miracle|noun|काशिफ; चमत्कार
misery|noun|etc,बहुत ही दुःखी दिखाई देना,Verb; विपत्ति; दुखअ
misleading|adjective|भ्रामक; गलतफहमी पैदा करनेवाला; बरगलाना
missile|noun|अस्त्र; प्रक्षेपास्ट्र; मिसाइल{फेंक कर मारने योग्य चीज}
mob|noun|घेर लेना; टोली; गिरोह
mobility|noun|गतिशीलता; गतिशिलता
mobilize|verb|संघटित; युद्ध की तैयारी करना; तैयार रखना
moderate|adjective|औसत दर्जे; कम; कम होना
modification|noun|सुधार; उपांतरण
momentum|noun|बल; गति
monk|noun|भिक्षु; संन्यासी
monopoly|noun|एकाधिपत्य; एकाधिकार; पूर्ण नियंट्रन
morality|noun|नीति; नैतिकता
motive|noun|प्रेरक; प्रयोजन; उद्देश्य
motorist|noun|कार चालक; मोटर यात्री
municipal|adjective|नगरीय; नागर
mutual|adjective|पारस्परिक; आपसी; परस्पर
namely|adverb|जैसे; जैसे कि; यथा
nationwide|adjective|देश भर में; देशव्यापी; देश
naval|adjective|जहा़जी; समुद्री; सामुद्रिक
neglect|noun|उपेक्षा करना; लापरवाही; उपेक्षा
neighbouring|adjective|निकटवर्ती; प्रतिवेशी; पड़ोस का
nest|noun|समूह; नियल बनाना; जमा करना
net|adjective|पाना; निर्धारित; दाम
newsletter|noun|सूचना पत्र; एक प्रकार का समाचार पत्र
niche|noun|मौका; आला; आवास
noble|adjective|बहुत अच्छा; उतम; शानदार
nod|verb|ऊँघना; झूमना; सिर हिलाना
nominate|verb|मनोनीत करना; नियुक्त करना; मनोनीत
nomination|noun|नियुक्ति; नामांकन; नामकरण
nominee|noun|नामांकित व्यक्ति; मनोनीत व्यक्ति; मनोनीत
non-profit|adjective|
nonetheless|adverb|फिर भी; तब भी
nonsense|noun|बकवास; निरर्थक; बेतुका
noon|noun|मध्याह्न; दोपहर
notable|adjective|महत्वपूर्ण; उल्लेखनीय; प्रसिद्ध
notably|adverb|विशेषकर; विशेषतः
notify|verb|सूचित करना; सूचना देना
notorious|adjective|कुख्यात; बदनाम
novel|adjective|नया; उपन्यास; अनूठा
nursery|noun|नर्सरी; संवर्धन; संवर्धन स्थान
objection|noun|विरोध; आपत्ति; एतराज़
oblige|verb|नैतिक नियमों से मज़बूर करना; काम करना; सहायता देना
obsess|verb|हरदम सोच्**अना; ड़ूबे रहना; ग्रस्त करना
obsession|noun|सनक; ज़ुनून; जुनुन
occasional|adjective|प्रासंगिक; असाम्यिक
occurrence|noun|घटना; उपस्थिति
odds|noun|कठिनाई; संभावना; अनुपात
offering|noun|बलि; भेंट; अर्पित
offspring|noun|परिणाम; सन्तान; शावक
operational|adjective|परिचालन का; सामरिक; क्रियाशील
opt|verb|चुनना; का फ़ैसला; का फ़ैसला करना
optical|adjective|प्रकाश संबंधी; दृक्; दृष्टि संबंधी
optimism|noun|आशावाद
oral|adjective|मौखिक; मौखिक परीक्षा; मुख
organizational|adjective|संगठन संबंधी; व्यवस्थापन; व्यवस्थापन संबंधी
orientation|noun|निर्देशन; अनुकूलन; दिग्विन्यास
originate|verb|उत्पन्न होना; आरम्भ करना; आरंभ होना या करना
outbreak|noun|प्रकोप; प्रादुर्भाव
outing|noun|भाग लेना; सैर
outlet|noun|सकेट; द्वार; दुकान
outlook|noun|दृष्टिकोन; दृष्टिकोण; दृश्य
outrage|noun|नाराज़ होना; बहुत खराब बात; संक्षुब्ध करना
outsider|noun|पराया; बाहर का; बाहर का आदमी
overlook|verb|के उपर से दिखना; अन्देकी करना; क्षमा
overly|adverb|बहुत ज़्यादा; बहुत
oversee|verb|निरीक्षण करना; का निरीक्षण करना; का निरीक्षण
overturn|verb|उलट देना; के विरुद्ध निर्णय देना; के
overwhelm|verb|पराजित करना; वश में करना; विह्वल होना
overwhelming|adjective|अत्यधिक; ज़बर्दस्त; अत्यधिक तीव्र
pad|noun|गद्दी; पैर घसीट कर चलना; भर देना
parameter|noun|गणित में स्थिर राशी; मापदण्ड; प्राचल
parental|adjective|अभिभावकीय
parish|noun|चर्च; पादरी का; पादरी का इलाका
parliamentary|adjective|संसदीय; संसद संसदीय्
partial|adjective|पक्षपाती; पक्षपातपूर्ण; आंशिक
partially|adverb|आंशिक रूप से; आंशिक
passing|noun|समाप्ति; मृत्यु; क्षणिक
passive|adjective|कर्मवाच्य; निष्क्रीय; कर्मप्रधन
pastor|noun|पादरी
patch|noun|पट्टी; धब्बा; चकती
patent|noun|एकस्व अधिकार प्राप्तअना; एकस्व प्राप्त; एकस्व अधिकार
pathway|noun|पथ
patrol|noun|बालचर; बालचर गश्ती दल; आवारागर्दी करना
patron|noun|संरक्षक; दर्शक; ग्राहक
peak|noun|चोटी; अधिकतम; चोटी पर पहुँचना
peasant|noun|असभ्य; देहाती; किसान
peculiar|adjective|निराला; असामान्य; विशेष
persist|verb|डटे रहना; बना रहना; डटे
persistent|adjective|सतत; लगातार; शाश्वत
personnel|noun|विभाग; कर्मचारी संबंधी; कर्मचारी संबन्धी
petition|noun|आवेदन पट्रअ; याचिका; निवेदन करना
philosopher|noun|दार्शनिक/तत्त्वज्ञ; दार्शनिक; दर्शनशास्त्री
philosophical|adjective|शांतचित्त; दार्शनिक
physician|noun|चिकित्सकअ; चिकित्सक/वैद्य; डाक्टरअ
pioneer|noun|मार्ग प्रशस्त करना; आरंभिक; अग्रगामी/पथप्रदर्शक
pipeline|noun|पाइप लाइन; पाइप
pirate|noun|अपहरण करना; साहित्यिक चोरी; समुद्री डाकू
pit|noun|गड्ढा; दाग; बीज निकालना
plea|noun|तर्क; अनुनय; सफ़ाई
plead|verb|वकालत करना; समर्थन में; सप़ाई पेश करना
pledge|noun|वचन; वादा करना; वादा
plug|noun|चुटकी; बंद करना; अवरोधक
plunge|verb|उछाल आना; फँसाना; प्रवेश करना
pole|noun|चलाना; ठेलना; ध्रुव
poll|noun|मिलना; मत; मतदान
pond|noun|ताल; पोखरी; तालाब
portfolio|noun|वर्ग; श्रेणी; विभाग
portray|verb|प्रस्तुत करना; दर्शाना; अभिनय करना
post-war|adjective|
postpone|verb|आगे बढाना; स्थगित करना
practitioner|noun|चिकित्सक; कलाकार; व्यवसायी
preach|verb|उपदेश देना; प्रवचन देना; सलाह देना
precedent|noun|नमूना; उदाहरण; पूर्ववर्ती
precision|noun|यथार्थता; सूक्ष्मतामापी; परिशुद्धता/यथार्थता
predator|noun|लूट मार करने वाला; परभक्षी; लुटेरा
predecessor|noun|पूर्वज; पूर्ववर्ती; पूर्व अधिकारी
predominantly|adverb|प्रबलता; प्रबलता से; मुख्यतः
pregnancy|noun|गर्भावस्था; गर्भ
prejudice|noun|प्रतिकूल; पूर्वाग्रह; पूर्वागह
preliminary|adjective|प्रारंभिक; प्रारंभिक दौर; प्रारंभिक तैयारी
premier|adjective|प्रमुख; प्रधानमंट्री; प्रधान
premise|noun|प्रतिज्ञा; आधार; प्राक्कल्पना
premium|noun|किस्त; बीमा किस्त; लाभांश
prescribe|verb|निर्धारित करना; नुस्खा लिखना
prescription|noun|नुस्खा; निर्धारित औषधि; चश्मे के लिये निर्देश
presently|adverb|अभी; शीघ्र ही; संप्रति
preservation|noun|संरक्षण; परिरक्षित फल या सुरक्षित स्थान; परिरक्षण
preside|verb|संचालन करना; सभापति बनना; अध्यासीन होना
presidency|noun|अध्यक्ष; अध्यक्ष पद; अध्यक्षता
presidential|adjective|अध्यक्षीय; राष्ट्रपति पद का; राष्ट्रपति पद
prestigious|adjective|प्रतिष्ठित; गौरवमय; ख्याति प्राप्त
presumably|adverb|सम्भवतः; संभाव्यतः
presume|verb|मान लेना; चुनौती देना; साहस करना
prevail|verb|प्रचलित होना; जीत लेना
prevalence|noun|प्रचलन; व्यापकता
prevention|noun|रोकथाम; रोक थाम
prey|noun|शिकार; शिकार करना; अनुचित लाभ उठाना
privatization|noun|निजीकरण
privilege|noun|सौभाग्य; सुविधा; विशेषाधिकार
probe|noun|जाँच; तहक़ीकात; सलाई
problematic|adjective|सन्देहास्पद; जटिल; समस्यात्मक
proceeding|noun|
proceeds|noun|लाभ; फ़ायदा; मुनाफ़ा
processing|noun|संसाधन; प्रसंस्करण
processor|noun|संसाधित करने का यन्त्र; प्रोसेसर; संसाधक
proclaim|verb|प्रमाणित करना; प्रशंसा करना; घोषित करना
productive|adjective|उपयोगी; लाभकारी; उत्पादक
productivity|noun|उत्पादकता; उर्वरता
profitable|adjective|लाभदायक; फायदेमंद
profound|adjective|गहन; गहरा; पारंगत
projection|noun|झुकाव; प्रक्षेपण; चित्र प्रदर्शन
prominent|adjective|प्रमुख; दृश्य; सुस्पष्ट
pronounced|adjective|सुस्पष्ठ; उच्चारित
propaganda|noun|अधिप्रचार; प्रचार
proposition|noun|समस्या; वचन; सुझाव
prosecute|verb|अभियोग लगाना; मुकदमा चलाना; अभियोग करना
prosecution|noun|अभियोजन; अभियोग पक्ष; अभियोग
prosecutor|noun|अभियोगपक्ष का वकील; अभियोक्ता; अभियोजक
prospective|adjective|भावी; प्रत्याशित
prosperity|noun|समृद्धि; दौलत; ऋद्धि
protective|adjective|रक्षा; संरक्षक; रक्षात्मक
protocol|noun|सितारा मछली; विज्ञप्ति; नयाचार
province|noun|प्रदेश; कार्यक्षेत्र; ज्ञानक्षेत्र्
provincial|adjective|गँवार; प्रान्तीय; संकीर्ण
provision|noun|खाद्य सामग्री; व्यवस्था; विधान
provoke|verb|उत्तेजित करना; उत्पन्न करना; गुस्सा होना
psychiatric|adjective|मनोविकृति; मनोविकृति संबंधी; मनश्चिकित्सीय
pulse|noun|दाल; नाडी; पल्स
pump|noun|उठाना; पम्प/दमकल; भरना
punch|noun|मुक्का मारना; उत्तेजना; दबाना
query|noun|के बारे में पूछताछ करना; पूछना; प्रश्न
quest|noun|तलाशना; रोना; खोज
quota|noun|हिस्सा; कोटा; नियतांश
radar|noun|रडार; रेडार
radical|adjective|अतिवादी; विलक्षण; सुधारवादी
rage|noun|ज़ोर से चलना; रोष व्यक्त; प्रकोप
raid|noun|धावा; छापा; पुलिस की कार्यवाही
rally|noun|सुधार; रैली; शक्ति प्रदर्शन के लिये जमाव
ranking|noun|क्रम सूची; स्थान; वरिष्ठतम
rape|noun|लूटना; बलात्कार करना; पीले रंग के फूलों वाला पौधा
ratio|noun|संबन्ध; अनुपात
rational|adjective|विवेकपूर्ण; चैतन्य; उचित
ray|noun|किरण; शंकुश; ऋषभ
readily|adverb|तरन्त ही; सरलता से; सरलता
realization|noun|बोध; प्राप्ति; वास्तविकताबोधक
realm|noun|क्षेत्र; राज्य
rear|adjective|पीछे का भाग; उठाना; पिछला
reasoning|noun|तर्कसम्गत विचार्; तर्क संबंधी; तर्क वितर्क
reassure|verb|आश्वासन देना; फिर हिम्मत दिलाना; आश्वासन
rebel|noun|राज विरोधी; विद्रोही; विद्रोह करना
rebellion|noun|विद्रोह; बगावत
recipient|noun|पाने वाला; प्राप्तकर्ता; लेने वाला
reconstruction|noun|पुनर्निर्माण; पुनर्रचना
recount|verb|बयान करना; पुनर्गणना; सुनाअना
referendum|noun|किसी प्रश्न को जनता के सामने उसकी सम्मति लेने के लिये रखना; जनमत संग्रह
reflection|noun|झलक; परछाई; आरोप
reform|noun|सुधार; सुधारना; फिर बनाना
refuge|noun|आश्रय; शरण; सहारा
refusal|noun|अस्वीकृति; असम्मति; अस्वीकरणाधिकार
regain|verb|पुनः प्राप्त करना
regardless|adverb|बेपरवाह; ध्यान दिए बिना
regime|noun|दौर; शासन; शासन पद्वति
regulator|noun|नियामक; प्रबन्ध कर्ता
regulatory|adjective|नियामक; नियंत्रक
rehabilitation|noun|परती; परती ज़मीन का कृषीकरण; पुनः
reign|noun|शासन; आधिपत्य करना; शासन करना
rejection|noun|अस्वीकृति; इनकार; नामंजूरी
relevance|noun|संबद्ध; अनुकूलता; प्रासंगिकता
reliability|noun|विश्वसनीयता; विश्वासयोग्य,विश्वसनीयता,
reluctant|adjective|अनिच्छुक; असम्मत
remainder|noun|शेष; बचा; सस्ते में
remains|noun|अवशेष; बचा खुचा; लाश
remedy|noun|ठीक करना; उपाय; सुधारना
reminder|noun|स्मरण पत्र; तकाज़ा; अनुस्मारक
removal|noun|स्थानांतरण; निष्कासन; सरकाव
render|verb|देना; अर्पण करना; पैदा करना
renew|verb|नवीनीकरण करना; बदलना; नया रूप देना
renowned|adjective|विशिष्ट; नामी/प्रसिध्द
rental|noun|किराया; किराये; किराये का
replacement|noun|बदलाव; पुनः स्थापन; एवज
reportedly|adverb|सुनते; खबरों के अनुसार; सुनते हैं
representation|noun|अभ्यावेदन; मूर्ति; चिट्रण
reproduce|verb|प्रतिलिपि तैयार; उत्पन्न करना; फिर से दिखाई देना
reproduction|noun|प्रतिरूप; प्रजनन; प्रतिकृति
republic|noun|गणतन्त्र; समाज; लोकतन्त्र
resemble|verb|सदृश होना; सदृश
reside|verb|होना; रहना
residence|noun|निवास; निवास स्थान; निवास की अनुमति
residential|adjective|निवास योग्य; आवासिक; निवास संबंधी
residue|noun|शेष; अवशिष्ट; बची हुई संपत्ति
resignation|noun|स्वेच्छा; इश्तीफा; इस्तीफा
resistance|noun|बाधा; विरोधी संस्था; विरोध
respective|adjective|निजी; विशेष; अपना अपना
respectively|adverb|क्रमानुसार; क्रम से; क्रमशः
restoration|noun|मरम्मत; पुनःस्थापन; नवीनीकरण
restraint|noun|संयम; अवरोध; रोक
resume|verb|फिर आरम्भ करना; सार; पुनः प्राप्त करना
retreat|noun|गिरना; पीछे हटना; भागना
retrieve|verb|सुधारना; पता लगाना; पुनः प्राप्त करना
revelation|noun|प्रकटीकरण; रहस्योद्घाटन; ईश्वरोक्ति
revenge|noun|बदला लेना; प्रतिशोध; बदला
reverse|adjective|बदल देना; उल्टा; विपत्ति
revival|noun|पुनः प्रदर्शन; पुनरुत्थान; पुनः प्राप्ति
revive|verb|पुनः उत्पन्न; फिर जीवित करना; पुनरुज्जीवित होना
revolutionary|adjective|क्रान्तिकारी; क्रांतिकारी; क्रान्तिकारी मनुष्य
rhetoric|noun|व्याख्यान विद्या; शब्दाडम्बर; वाक्पटुता
rifle|noun|एक प्रकार की बन्दूक; तलाशी लेना; तलाशी
riot|noun|विनोदी व्यक्ति; ज़बर्दस्त मज़ाक; दंगा करना
rip|verb|चीरा; चीर; अशांत जल क्षेत्र
ritual|noun|संस्कार; धार्मिक कृत्य; रस्म संबंधी
robust|adjective|असभ्य; ज़बर्दस्त; स्वस्थ
rod|noun|दण्ड; दंड; जाति
rotate|verb|घुमाना; घूमना
rotation|noun|चक्कर; गर्दिश; आवर्तन
ruling|noun|प्रबल; शासक; न्यायालय का निर्णय
rumour|noun|गप उड़ाना; चर्चा; अफ़वाह
sack|verb|निकाल देना; बोरा; लूटना
sacred|adjective|धार्मिक; पवित्र; सम्मानजनक
sacrifice|noun|त्याग; बलि; कुर्बानी
saint|noun|आदर्श; संत; साधु/सन्त
sake|noun|के लिये; साके{चावलों की बनी जापानी शराब}; साकी
sanction|noun|स्वीकृति; दण्ड; संस्वीकृत
say|noun|कहना
scattered|adjective|बिखरा हुआ; अस्त व्यस्त; फैला हुआ
sceptical|adjective|अविश्वासपूर्ण; संशयशील; अविश्वासी/संशयात्मा
scope|noun|विस्तार; क्षेत्र; दोलन दर्शी
screw|noun|मोड़ना; संभोग करना; कंजूस
scrutiny|noun|सूक्ष्म; सूक्ष्म परीक्षण
seal|noun|मुद्रांकित; छाप; सील मछली
secular|adjective|असांप्रदायिक; शतवार्षिक; चिरकालिक
seemingly|adverb|प्रकटतः; प्रकट रूप से; प्रतीयमानतः
segment|noun|हिस्सा; विभाजित करना; फाँक
seize|verb|समझना; झपट लेना; पकड़ना
seldom|adverb|बिरले ही/कभी कभार; शायद; कभी कभार
selective|adjective|चयनात्मक; चयनशील
senator|noun|सीनेटर
sensation|noun|संवेदना; उत्तेजना; जोश
sensitivity|noun|भावुकता; संवेदनशीलता; सूक्ष्मग्राहिता
sentiment|noun|भावना; विचार; मनोभाव
separation|noun|वियुक्ति/विच्छेद; पृथक्करण; अलगाव
serial|adjective|क्रम; धारावाहिक; आनुक्रमिक
set-up|noun|
settlement|noun|निपटारा; समझौता; भुगतान
sexuality|noun|कामुकता; लैंगिकता
shareholder|noun|हिस्सेदार
shatter|verb|नष्ट करना या हो जाना; टुकड़े टुकड़े कर देना या हो जाना; धक्का देना
shed|verb|फैलाना; निकालना; घटाना
sheer|adjective|पूर्णतया; विशुद्ध; नितान्त
shipping|noun|नौपरिवहन; पोत परिवहन; पोत समूह
shoot|noun|फ़ोटो लेना/फ़िल्म बनाना/चलचित्रित करना; चलाना; फैलाना
shrink|verb|घटना; पीछे हटना; सिकोड़ना
shrug|verb|कंधे; कंधे उचकाना; कँधा उचकाना या झाड़ना
sigh|noun|साँस लेना; तरसना; आह भरना
simulate|verb|दिखावा करना; अनुरूपता; अनुरूपता बनाना
simulation|noun|अनुकरण; अनुरूपण; मिथ्याभास
simultaneously|adverb|एक साथ
sin|noun|अपराध; पाप; पाप करना
situated|adjective|स्थित
sketch|noun|खाका; संक्षिप्त विवरण; व्यंग्यचित्र
skip|verb|रस्सी कूदना; भाग जाना; चूक
slam|verb|ज़ोर से बंद हो; ज़ोर से बंद करना; धम्म से बंद करना
slap|verb|सीधे; ठीक; तमाचा मारना
slash|verb|चीरा; काटना; तिर्यक निशान
slavery|noun|दासता; गुलामगिरी; गुलामी
slot|noun|स्लट; स्थान; पदचिह्नित मार्ग
smash|verb|टक्कर; टकराना; प्रहार
snap|verb|प्रेस बटन; टूटना; काट लेना
soak|verb|फैल जाना; डुबाव; भिगोना
soar|verb|उड़ना; तेज़ि से बढ़ना; बहुत
socialist|adjective|समाजवादी
sole|adjective|तल्ला; पूरा; कुकुरजीभी
solely|adverb|पूरी तरह से; पूरी तरह
solicitor|noun|याचक; वकील; प्रतिवक्ता/न्यायाभिकर्ता
solidarity|noun|पूर्ण एकता; एकता
solo|adjective|एकल गायन या वादन; अकेले; एकल
sound|adjective|आवाज़
sovereignty|noun|आधिपत्य; स्वतंत्रता; प्रभुसत्ता
spam|noun|स्पैम
span|noun|फैलाव; विविधता; अवधि
spark|verb|कारण बनना; जोश; चिनगारी
specialized|adjective|विशेष तरह का; विशेषीकृत
specification|noun|विशेष विवरण
specimen|noun|नमूना; आदर्श; अजीब आदमी
spectacle|noun|प्रदर्शन; तमाशा; दृश्य
spectrum|noun|वर्णक्रम; विस्तृत श्रेणी; तरंग
spell|noun|बताना; सूचित करना; माया
sphere|noun|वृत्त; गोला; क्षेत्र
spin|noun|घुमाना; घुमाव; चक्कर
spine|noun|मेरुदण्ड; रीढ़; रीढ की
spotlight|noun|चर्चा; स्पॉट लाइट; लोगों की नज़र में लाना
spouse|noun|पत्नी; पति; जीवनसाथी
spy|noun|ध्यान रखना; गुप्तचर; जासूस
squad|noun|जत्था; दल; दस्ता
squeeze|verb|दबाव; दबाना; ऐंठना
stab|verb|घाव; प्रहार करना; दबाना
stability|noun|स्थिरता; नियमितता
stabilize|verb|स्थिर करना; मज़बूत होना
stake|noun|दाँव पर लगाना; सहारा देना; बाजी की
standing|adjective|प्रतिष्ठा; आधार; अवधि
stark|adjective|एकदम भिन्न; कठोर; कड़ा/कठोर
statistical|adjective|सांख्यिकीय
steer|verb|चलाना; मार्ग दिखाना; बधिया बैल
stem|noun|रोकना; उत्पन्न होना; धातु
stereotype|noun|रूढिवादी; रूढिबद्ध धारणा; रूढिबद्ध
stimulus|noun|उत्तेजना; प्रोत्साहन; उद्दीपन
stir|verb|चलाना; उत्तेजित करना; मिलाना
storage|noun|संचयन; भखाई का खार्चा; संग्रहअ
straightforward|adjective|सरल; सीधा; सच्चा
strain|noun|थकाना; गाना; मोच
strand|noun|किनारा; लट; पहलू
strategic|adjective|कूटनीतिक; सामरिक; युद्ध कौशल सम्बन्धी
striking|adjective|असाधारण; आश्चर्यजनक; ध्यान आकर्षित करनेवाली
strip|noun|पोशाक; निकाल देना; पट्टी
strive|verb|कठोर परिश्रम करना; प्रयास करना; संघर्ष करना
structural|adjective|संरचनात्मक
stumble|verb|गिरना; ठोकर; भूल करना
stun|verb|सिर पर मारना; अचेत कर देना; चकित होना
submission|noun|जमा करना; आत्मसमर्पण; समर्पण
subscriber|noun|अनुमोदनकर्ता; ग्राहक; भुगतानकर्ता
subscription|noun|चंदा; शुल्क; चंदा/अंशदान
subsidy|noun|अनुदान; आर्थिक सहायता
substantial|adjective|वास्तविक; बहुत अधिक; संतोषजनक
substantially|adverb|मूल रूप से; मज़बूती; मज़बूती से
substitute|noun|स्थानापन्न व्यक्ति; स्थानापन्न; एवजी
substitution|noun|स्थानापन्नता; प्रतिस्थापन
subtle|adjective|हल्का; जटिल; कुशाग्र
suburban|adjective|उबाऊ; संकीर्ण; उपनगर संबंधी
succession|noun|उत्तराधिकार; सिलसिला; ताँता
successive|adjective|एक; लगातार; एक के बाद एक आने वाला
successor|noun|उत्तराधिकारी; वारिस
suck|verb|खींच लेना; दूध पिलाना; सोखना
sue|verb|औपचारिक रूप से निवेदन करना; नालिश करना; नालिश
suicide|noun|आत्मघातक; आत्महत्या; खुदखुशी
suite|noun|होटल का कमरा; अनुगामी; परिजन
summit|noun|शीर्ष सम्मेलन; शिखर; सम्मेलन
superb|adjective|शानदार; उत्कृष्ट
superior|adjective|उत्कृष्ट; अच्छा; श्रेष्ठ
supervise|verb|पर्यवेक्षणा करना; निरीक्षण करना
supervision|noun|निरीक्षण; पर्यवेक्षण; जिम्मेदारी
supervisor|noun|संचालक प्रोगाम; पर्यवेक्षक; निरीक्षक
supplement|noun|वृद्धि करना; पूरक; पूरा करना
supportive|adjective|मददगार; सहयोग देनेवाला
supposedly|adverb|कथित रूप से; कथित
suppress|verb|रोकना; समाप्त करना; दबाना/दमन करना
supreme|adjective|परम; उच्चतम; सर्वोच्च
surge|noun|तेज़ि से बढ़ना; आवेश; लहर
surgical|adjective|शल्य चिकित्सा सम्बन्धी; शल्यक; सुनिश्चितता के साथ संपादित
surplus|noun|आवश्यकता से अधिक; अधिशेष; अतिरिक्त
surrender|verb|त्याग देना; आत्मसमर्पण; आत्मसमर्पण करना
surveillance|noun|निगरानी
suspension|noun|स्थगन; निलम्बन; थोड़े समय के लिये रुकावट
suspicion|noun|खटका; अविश्वास; पुट
suspicious|adjective|संदेहशील; सन्देह जनक; संदेहास्पद
sustain|verb|खाना; उठाना; शक्ति देना
swing|noun|परिवर्तन; लटकना; बदलना
sword|noun|तलवार; खङ्ग; शमशीर
symbolic|adjective|प्रतीकात्मक
syndrome|noun|लक्षण; रोगलक्षण; परिस्थिति का लक्षण
synthesis|noun|संमिश्रण; संश्लेषण; मिलावट
systematic|adjective|सुनियोजित; नियमित; सुव्यवस्थित
tackle|noun|रोकना; सामना करना; मछली पकड़ने का साज सामान
tactic|noun|तिकड़म; रणनीति; युक्ति
tactical|adjective|सुनियोजित; नीतिगत; सामरिक
taxpayer|noun|करदाता; कर दाता
tempt|verb|लुभाना; आकर्षित करना; ललचाना
tenant|noun|किराएदार की हैसियत से रहना; किरायेदार; किराये पर होना
tender|adjective|मुलायम; देना; हल्का
tenure|noun|कार्यकाल; पट्टा; काश्तकारी
terminal|adjective|आखिरी स्थान; अंतिम; सीमावर्ती
terminate|verb|समाप्त करना; तक जाना; नौकरी से निकाल देना
terrain|noun|भूभाग
terrific|adjective|बहुत सारा; शानदार; ज़बर्दस्त
testify|verb|सिद्ध करना; प्रमाण प्रस्तुत करना; विश्वास प्रकट
testimony|noun|प्रमाण; गवाही
texture|noun|संरचना; बुनावट; प्रकृति
thankfully|adverb|कृतज्ञता के साथ
theatrical|adjective|नाटकीय; नाटक संबंधी; नाट्यशाला का
theology|noun|ब्रह्मविद्या; धर्मशास्त्र; वेदान्त
theoretical|adjective|अनुमानित; सैद्धांतिक; सैद्धान्तिक
thereafter|adverb|तब से; उसके बाद; उस के बाद
thereby|adverb|उससे; फलस्वरूप; उसके कारण
thought-provoking|adjective|
thoughtful|adjective|परवाह करने वाला; सावधान; विचारमग्न
thread|noun|निकालना; घुमावदार मार्ग से हो कर आगे बढ़ना; वस्ट्र
threshold|noun|दहलीज; द्वार; सीमा
thrilled|adjective|बहुत खुश
thrive|verb|फलना फूलना; पनपना; समृद्ध होना
tide|noun|प्रवृत्ति; समय; बहाव
tighten|verb|सीमित करना; तनना; कसना
timber|noun|वन; काष्ठ; इमारती
timely|adjective|समयोचित; ठीक समय पर; सही समय पर
tobacco|noun|तम्बाकू; तंबाकू; तंबाकू का पौधा
tolerance|noun|उदारता; सहिष्णुता; सहनशीलता
tolerate|verb|सहना; सहन करना; बर्दाश्त करना
toll|noun|क्षति; संख्या; कर[मार्गकर]
torture|noun|घोर यातना देना; अति कष्ट देना; यातना
toss|verb|हिलाना; हिलाना[मिलाना]; उपर उठाना
toxic|adjective|विषाक्त; विषैला
trace|noun|सुराग; संकेत; अवशेष
trademark|noun|विशिष्टता; व्यापार चिह्न
trail|noun|पीछे होना; हारना; चरण
trailer|noun|अनुयान; ट्रेलर; सुस्त आदमी
transaction|noun|लेन देन; कार्रवाई; सौदा
transcript|noun|प्रतिलिपि; लिखित प्रतिलिपि
transformation|noun|परिवर्तन; सुधार; रूपांतरण
transit|noun|पारगमन; संक्रमण; परागमन
transmission|noun|संचार; प्रसारण; प्रसार
transparency|noun|खोखलापन; स्पष्टता; पारदर्शिता
transparent|adjective|सुस्पष्ट; सच्चा; स्पष्ट
trauma|noun|चोट; कटु अनुभव; मानसिक आघात
treaty|noun|सन्धि; समझौता; वार्ता
tremendous|adjective|बहुत अच्छा; ज़बर्दस्त; असीम
tribal|adjective|जनजातीय; कबायली
tribunal|noun|न्यायाधिकरण; प्राधिकरण; ट्रिब्यूनल
tribute|noun|शुल्क; श्रद्धांजलि; श्रधांजलि
trigger|noun|घोड़ा; झट प्रतिक्रिया; प्रेरित करना
trio|noun|तिकड़ी; गायकों की तिकड़ी; त्रिवाद्य संगीत
triumph|noun|जीतना; सफलता; विजय प्राप्त करना
trophy|noun|विजयोपहार; विजयस्मारक; विजय चिन्ह
troubled|adjective|अशांत; परेशान; कष्टमय
trustee|noun|समिति; न्यासी; ट्रस्टी
tuition|noun|शिक्षण; शिक्षा शुल्क; अध्यापन
turnout|noun|पहनावा; सफ़ाई; भीड़
turnover|noun|उलटना; बिक्री; फलमिश्रित
twist|noun|झटका; मुड़ जाना; मोड़ना
undergraduate|noun|पूर्वस्नातक
underlying|adjective|अंतर्निहित; मूलभूत; अधःस्थ
undermine|verb|खोखला कर देना; दुर्बल बना देना; सुरंग खोद
undoubtedly|adverb|बिना किसी संदेह के; निस्संदेह; बिना
unify|verb|एक करना; एक रूप बना/जोड़
unprecedented|adjective|बेमिसाल/अपूर्व/अनोखा; अभूतपूर्व; अश्रुत
unveil|verb|बताना; दिखाना; परदा उठाना
upcoming|adjective|आने वाला; घटित
upgrade|noun|सुधार; सुधार करना; उन्नति करना
uphold|verb|परिपुष्ट करना; समर्थन करना; बनाए रखना
utility|noun|उपयोगिता; शुद्ध; उपादेयता
utilize|verb|उपयोग करना; निवेश न्यास से इकाई न्यास में परिवर्तित करना; लाभ उठा/काम मे ला/प्रयोग मे ला
utterly|adverb|नितान्त; पूर्ण रूप से; सम्पूर्ण रूप से
vacuum|noun|खाली जगह; शून्य; खालीपन
vague|adjective|अज्ञात; हल्का; अनिश्चित
validity|noun|वैधता; मान्यता
vanish|verb|ओझल हो जाना; समाप्त हो; लुप्त होना
variable|adjective|परिवर्ती राशि; अस्थिर; परिवर्ती
varied|adjective|विभिन्न; विविध प्रकार का
vein|noun|शैली; मनोदशा; धारी
venture|noun|जाने का साहस करना; करने का साहस; उपक्रम
verbal|adjective|शाब्दिक; मौखिक; वाचिक
verdict|noun|अभिनिर्णय; निर्णय; फैसला
verify|verb|प्रमाणित करना; सत्यापित करना; जाँचना
verse|noun|कविता; छंद; पद्य
versus|preposition|विपरीत; विरुद्ध; के मुकाबले
vessel|noun|नस; नलिका; बर्तन
veteran|noun|अनुभवी व्यक्ति; सेवानिवृत्त सैनिक; अनुभवी
viable|adjective|व्यवहार्य; सुकर; साध्य
vibrant|adjective|चमकीला; जोशपूर्ण; गुंजायमान
vice|noun|अवगुण; दुराचार; शिकंजा
vicious|adjective|उग्र; निन्दनीय; अनैतिक
villager|noun|ग्रामीण; गाँव वाला; गांववाला
violate|verb|अनादर करना; अपवित्र करना; उल्लंघन करना
violation|noun|अपराध; उल्लंघन; अतिक्रमण
virtue|noun|गुण; सद्गुण; नैतिकता
vocal|adjective|स्पष्टवादी; वाचिक; गीत
vow|verb|प्रतिज्ञा; वादा; प्रतिज्ञा करना
vulnerability|noun|अतिसंवेदनशीलता; दोष पूर्णता; अरक्षितता
vulnerable|adjective|असुरक्षित; अतिसंवेदनशील; आघात
ward|noun|संरक्षित; रोगीकक्ष; रक्षा करना
warehouse|noun|गोदाम; गोदाम में माल रखना; गोदाम में माल
warfare|noun|युद्ध; संघर्ष; युद्धकला
warrant|noun|आश्वासन देना; न्यायसंगत ठहराना; अधिपत्र
warrior|noun|सैनिक; प्रयुत्सु
weaken|verb|शिथिल होना; कमजोर हो जाना; कमजोर बना देना
weave|verb|करना; घुमावदार मार्ग से हो कर आगे बढ़ना; मुड़ जाना
weed|noun|तम्बाकू; चरस; शैवाल
well-being|noun|
whatever|adverb|कुछ भी; जो भी; जो कुछ भी
whatsoever|adverb|जो कुछ; कुछ भी; कुछ
whereby|adverb|जिससे; जिसके द्वारा
whilst|conjunction|जब तक
whip|verb|मिठाई; बुरी तरह से पछाड़ देना; चुराना
wholly|adverb|पूरी तरह से; पूरी तरह
widen|verb|बढ़ाना; ढीला करना; चौड़ा होना
widow|noun|विधुर; विधवा; विधवा होना
width|noun|उदारता; चौड़ाई
willingness|noun|तत्परता; स्वेच्छा; सम्मति
wipe|verb|गिरना; हटाना; पौंछा लगाना
wit|noun|समझ; विवेक; वाकपटुता
withdrawal|noun|निकालना; प्रत्याहार; वापसी
workout|noun|व्यायाम; कसरत; अभ्यास
worship|noun|समादर करना; पूजा करना; सम्मान करना
worthwhile|adjective|उपयुक्त; लाभप्रद; लाभकर
worthy|adjective|योग्य; ईमानदार; उपयुक्त
yell|verb|चीखना; चिल्लाना; चिल्लाहट
yield|noun|बताना; स्वीकार करना; देना
youngster|noun|बच्चा; लड़का
"""), "en", "C1", "oxford"),

    )
}
