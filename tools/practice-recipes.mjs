// Practice drill recipes.
//
// This module is the single source of truth for the generative grammar drills
// shown in the app's Practice section. `buildAsset()` renders it to the compact
// DSL that ships as `app/src/main/assets/practice_drills.txt`; `generate()` is a
// reference implementation of the interpreter that Kotlin runs at runtime, so the
// drills can be checked here (counts, answers, Hindi) without a device build.
//
// DSL (one directive per line, TAB separated):
//   #l  name   v1 | v2 | v3           global library of slot values
//   #c  id                            start a category
//   #s  slot   @LIB | inline values   slot used by the category's templates
//   #t  enTemplate   hiTemplate       a sentence template ({slot} refs, ___ = gap)
//   #b  slot                          the slot whose value supplies the gap
//   #a  answer   wrongs   gapHi       template-level gap (when no #b)
//
// A slot value is:  en ~ hi ~ gapHi ~ answer ~ wrongs   (trailing fields optional)
//   en      text substituted for {slot} in the English template
//   hi      text substituted for {slot} in the Hindi template
//   gapHi   Hindi of the missing word (used by {gap})
//   answer  correct choice for the blank (when this slot supplies the gap)
//   wrongs  comma separated distractors

// ---------------------------------------------------------------- values ----

const V = (en, hi) => [en, hi, "", "", ""];
const VA = (en, hi, gap, ans, wrongs) => [en, hi, gap, ans, wrongs];

// ------------------------------------------------------------- libraries ----

const L = {};
const lib = (name, values) => {
  L[name] = values;
  return "@" + name;
};

// Subjects. Classes share Hindi verb agreement, so each template uses one class.
lib("S_I", [V("I", "मैं")]);
lib("S_WE", [V("we", "हम"), V("my friend and I", "मैं और मेरा दोस्त")]);
lib("S_YOU", [V("you", "तुम")]);
lib("S_3SM", [
  V("he", "वह"), V("my brother", "मेरा भाई"), V("my father", "मेरे पिता"),
  V("Ravi", "रवि"), V("the teacher", "शिक्षक"), V("my friend", "मेरा दोस्त"),
  V("the boy", "लड़का"), V("Mr Sharma", "श्री शर्मा"), V("the doctor", "डॉक्टर"),
  V("my uncle", "मेरे चाचा")
]);
lib("S_3SF", [
  V("she", "वह"), V("my sister", "मेरी बहन"), V("my mother", "मेरी माँ"),
  V("Priya", "प्रिया"), V("the teacher", "शिक्षिका"), V("the girl", "लड़की"),
  V("Mrs Sharma", "श्रीमती शर्मा"), V("my daughter", "मेरी बेटी"), V("the nurse", "नर्स"),
  V("my aunt", "मेरी चाची")
]);
lib("S_3P", [
  V("they", "वे"), V("we", "हम"), V("my parents", "मेरे माता-पिता"),
  V("the students", "छात्र"), V("my friends", "मेरे दोस्त"), V("the children", "बच्चे"),
  V("the boys", "लड़के"), V("my brothers", "मेरे भाई"), V("the teachers", "शिक्षक"),
  V("my cousins", "मेरे चचेरे भाई")
]);

// Ergative (ने) subjects, for the perfective tenses.
lib("N_I", [V("I", "मैंने")]);
lib("N_WE", [V("we", "हमने"), V("my friend and I", "मैं और मेरे दोस्त ने")]);
lib("N_YOU", [V("you", "तुमने")]);
lib("N_3SM", [
  V("he", "उसने"), V("my brother", "मेरे भाई ने"), V("my father", "मेरे पिता ने"),
  V("Ravi", "रवि ने"), V("the teacher", "शिक्षक ने"), V("my friend", "मेरे दोस्त ने"),
  V("the boy", "लड़के ने"), V("Mr Sharma", "श्री शर्मा ने"), V("the doctor", "डॉक्टर ने"),
  V("my uncle", "मेरे चाचा ने")
]);
lib("N_3SF", [
  V("she", "उसने"), V("my sister", "मेरी बहन ने"), V("my mother", "मेरी माँ ने"),
  V("Priya", "प्रिया ने"), V("the teacher", "शिक्षिका ने"), V("the girl", "लड़की ने"),
  V("Mrs Sharma", "श्रीमती शर्मा ने"), V("my daughter", "मेरी बेटी ने"), V("the nurse", "नर्स ने"),
  V("my aunt", "मेरी चाची ने")
]);
lib("N_3P", [
  V("they", "उन्होंने"), V("my parents", "मेरे माता-पिता ने"), V("the students", "छात्रों ने"),
  V("my friends", "मेरे दोस्तों ने"), V("the children", "बच्चों ने"), V("the boys", "लड़कों ने"),
  V("my brothers", "मेरे भाइयों ने"), V("the teachers", "शिक्षकों ने"), V("my cousins", "मेरे चचेरे भाइयों ने")
]);

// Dative (के पास) subjects, for possession.
lib("P_I", [V("I", "मेरे पास")]);
lib("P_WE", [V("we", "हमारे पास")]);
lib("P_YOU", [V("you", "तुम्हारे पास")]);
lib("P_3SM", [
  V("he", "उसके पास"), V("my brother", "मेरे भाई के पास"), V("my father", "मेरे पिता के पास"),
  V("Ravi", "रवि के पास"), V("the teacher", "शिक्षक के पास"), V("my friend", "मेरे दोस्त के पास"),
  V("the boy", "लड़के के पास"), V("Mr Sharma", "श्री शर्मा के पास"), V("the doctor", "डॉक्टर के पास"),
  V("my uncle", "मेरे चाचा के पास")
]);
lib("P_3SF", [
  V("she", "उसके पास"), V("my sister", "मेरी बहन के पास"), V("my mother", "मेरी माँ के पास"),
  V("Priya", "प्रिया के पास"), V("the teacher", "शिक्षिका के पास"), V("the girl", "लड़की के पास"),
  V("Mrs Sharma", "श्रीमती शर्मा के पास"), V("my daughter", "मेरी बेटी के पास"),
  V("the nurse", "नर्स के पास"), V("my aunt", "मेरी चाची के पास")
]);
lib("P_3P", [
  V("they", "उनके पास"), V("my parents", "मेरे माता-पिता के पास"), V("the students", "छात्रों के पास"),
  V("my friends", "मेरे दोस्तों के पास"), V("the children", "बच्चों के पास"), V("the boys", "लड़कों के पास"),
  V("my brothers", "मेरे भाइयों के पास"), V("the teachers", "शिक्षकों के पास")
]);

// Time / frequency phrases.
lib("WHEN", [
  V("now", "अब"), V("right now", "अभी"), V("today", "आज"), V("this morning", "आज सुबह"),
  V("tonight", "आज रात"), V("this evening", "आज शाम"), V("this week", "इस हफ़्ते"),
  V("these days", "इन दिनों")
]);
lib("FREQ", [
  V("every day", "हर रोज़"), V("every morning", "हर सुबह"), V("every night", "हर रात"),
  V("every Sunday", "हर रविवार"), V("usually", "आमतौर पर"), V("often", "अक्सर"),
  V("sometimes", "कभी-कभी"), V("always", "हमेशा"), V("rarely", "शायद ही कभी"),
  V("twice a week", "हफ़्ते में दो बार")
]);
lib("PAST", [
  V("yesterday", "कल"), V("last night", "कल रात"), V("last week", "पिछले हफ़्ते"),
  V("last month", "पिछले महीने"), V("last year", "पिछले साल"), V("this morning", "आज सुबह"),
  V("two days ago", "दो दिन पहले"), V("last Sunday", "पिछले रविवार"), V("on Monday", "सोमवार को"),
  V("yesterday evening", "कल शाम")
]);
lib("FUT", [
  V("tomorrow", "कल"), V("tomorrow morning", "कल सुबह"), V("next week", "अगले हफ़्ते"),
  V("next month", "अगले महीने"), V("next year", "अगले साल"), V("tonight", "आज रात"),
  V("on Sunday", "रविवार को"), V("this evening", "आज शाम"), V("on Friday", "शुक्रवार को"),
  V("after the exam", "परीक्षा के बाद")
]);
lib("DUR", [
  V("for two hours", "दो घंटे"), V("since morning", "सुबह"), V("for three days", "तीन दिन"),
  V("all week", "पूरे हफ़्ते"), V("since Monday", "सोमवार"), V("for a long time", "बहुत देर")
]);

// Places, for copula / preposition drills (gender split keeps Hindi agreement right).
lib("PLACE_M", [
  V("at home", "घर पर"), V("at school", "स्कूल में"), V("at work", "काम पर"),
  V("in the garden", "बगीचे में"), V("at the station", "स्टेशन पर"), V("in the office", "दफ़्तर में"),
  V("at the market", "बाज़ार में"), V("in the park", "पार्क में"), V("on the bus", "बस में"),
  V("in the kitchen", "रसोई में")
]);
lib("PLACE_F", [
  V("at home", "घर पर"), V("in class", "कक्षा में"), V("in the city", "शहर में"),
  V("at the airport", "हवाई अड्डे पर"), V("in the library", "पुस्तकालय में"), V("in the shop", "दुकान में"),
  V("at the hotel", "होटल में"), V("in the village", "गाँव में"), V("at the doctor's", "डॉक्टर के पास"),
  V("at my desk", "अपनी मेज़ पर")
]);

// ------------------------------------------------------- nouns / phrases ----

const NOUNS = [
  { en: "phone", hi: "फ़ोन", g: "m", pl: "phones", plHi: "फ़ोन" },
  { en: "house", hi: "घर", g: "m", pl: "houses", plHi: "घर" },
  { en: "car", hi: "कार", g: "f", pl: "cars", plHi: "कारें" },
  { en: "dog", hi: "कुत्ता", g: "m", pl: "dogs", plHi: "कुत्ते" },
  { en: "bag", hi: "बस्ता", g: "m", pl: "bags", plHi: "बस्ते" },
  { en: "book", hi: "किताब", g: "f", pl: "books", plHi: "किताबें" },
  { en: "bike", hi: "बाइक", g: "f", pl: "bikes", plHi: "बाइक" },
  { en: "laptop", hi: "लैपटॉप", g: "m", pl: "laptops", plHi: "लैपटॉप" },
  { en: "watch", hi: "घड़ी", g: "f", pl: "watches", plHi: "घड़ियाँ" },
  { en: "camera", hi: "कैमरा", g: "m", pl: "cameras", plHi: "कैमरे" },
  { en: "umbrella", hi: "छाता", g: "m", pl: "umbrellas", plHi: "छाते" },
  { en: "bottle", hi: "बोतल", g: "f", pl: "bottles", plHi: "बोतलें" },
  { en: "chair", hi: "कुर्सी", g: "f", pl: "chairs", plHi: "कुर्सियाँ" },
  { en: "table", hi: "मेज़", g: "f", pl: "tables", plHi: "मेज़ें" },
  { en: "garden", hi: "बगीचा", g: "m", pl: "gardens", plHi: "बगीचे" },
  { en: "letter", hi: "चिट्ठी", g: "f", pl: "letters", plHi: "चिट्ठियाँ" },
  { en: "flower", hi: "फूल", g: "m", pl: "flowers", plHi: "फूल" },
  { en: "window", hi: "खिड़की", g: "f", pl: "windows", plHi: "खिड़कियाँ" },
  { en: "shop", hi: "दुकान", g: "f", pl: "shops", plHi: "दुकानें" },
  { en: "apple", hi: "सेब", g: "m", pl: "apples", plHi: "सेब" },
  { en: "pen", hi: "कलम", g: "f", pl: "pens", plHi: "कलमें" },
  { en: "key", hi: "चाबी", g: "f", pl: "keys", plHi: "चाबियाँ" },
  { en: "ball", hi: "गेंद", g: "f", pl: "balls", plHi: "गेंदें" },
  { en: "cup", hi: "कप", g: "m", pl: "cups", plHi: "कप" },
  { en: "box", hi: "डिब्बा", g: "m", pl: "boxes", plHi: "डिब्बे" },
  { en: "shirt", hi: "कमीज़", g: "f", pl: "shirts", plHi: "कमीज़ें" },
  { en: "shoe", hi: "जूता", g: "m", pl: "shoes", plHi: "जूते" },
  { en: "tree", hi: "पेड़", g: "m", pl: "trees", plHi: "पेड़" },
  { en: "road", hi: "सड़क", g: "f", pl: "roads", plHi: "सड़कें" },
  { en: "village", hi: "गाँव", g: "m", pl: "villages", plHi: "गाँव" }
];

const ADJS = [
  { en: "new", m: "नया", f: "नई" },
  { en: "old", m: "पुराना", f: "पुरानी" },
  { en: "big", m: "बड़ा", f: "बड़ी" },
  { en: "small", m: "छोटा", f: "छोटी" },
  { en: "nice", m: "अच्छा", f: "अच्छी" },
  { en: "expensive", m: "महँगा", f: "महँगी" }
];

const anOf = (word) => (/^[aeiou]/i.test(word) ? "an" : "a");
const adjHi = (n, a) => (n.g === "f" ? a.f : a.m);

// A big pool of bilingual noun phrases, reused by many categories.
const PHRASES = (() => {
  const out = [];
  for (const n of NOUNS) {
    out.push(VA(n.en, n.hi, "", "", ""));
    for (const a of ADJS) out.push(VA(anOf(a.en) + " " + a.en + " " + n.en, "एक " + adjHi(n, a) + " " + n.hi, "", "", ""));
  }
  return out;
})();

// The same phrases, but each value carries the article as its own gap.
const ARTICLE_PHRASES = (() => {
  const out = [];
  for (const n of NOUNS) {
    const art = anOf(n.en);
    out.push(VA(n.en, n.hi, "", art, wrongsFor(art, ["a", "an", "the", "some"])));
    for (const a of ADJS) {
      const ar = anOf(a.en);
      out.push(VA(a.en + " " + n.en, adjHi(n, a) + " " + n.hi, "", ar, wrongsFor(ar, ["a", "an", "the", "some"])));
    }
  }
  return out;
})();

// ------------------------------------------------------------ verb table ----

// stem  = Hindi bare stem (present habitual / continuous)
// perf  = Hindi perfective form, agreeing with this verb's object
// fut   = Hindi future: 1sg, 3sg (m), 3sg (f)
const VERBS = [
  { en: "tea", hi: "चाय", base: "drink", s3: "drinks", past: "drank", pp: "drunk", ing: "drinking", stem: "पी", perf: "पी", fut: ["पिऊँगा", "पिएगा", "पिएगी"] },
  { en: "a book", hi: "किताब", base: "read", s3: "reads", past: "read", pp: "read", ing: "reading", stem: "पढ़", perf: "पढ़ी", fut: ["पढ़ूँगा", "पढ़ेगा", "पढ़ेगी"] },
  { en: "a letter", hi: "चिट्ठी", base: "write", s3: "writes", past: "wrote", pp: "written", ing: "writing", stem: "लिख", perf: "लिखी", fut: ["लिखूँगा", "लिखेगा", "लिखेगी"] },
  { en: "an apple", hi: "सेब", base: "eat", s3: "eats", past: "ate", pp: "eaten", ing: "eating", stem: "खा", perf: "खाया", fut: ["खाऊँगा", "खाएगा", "खाएगी"] },
  { en: "a film", hi: "फ़िल्म", base: "watch", s3: "watches", past: "watched", pp: "watched", ing: "watching", stem: "देख", perf: "देखी", fut: ["देखूँगा", "देखेगा", "देखेगी"] },
  { en: "football", hi: "फ़ुटबॉल", base: "play", s3: "plays", past: "played", pp: "played", ing: "playing", stem: "खेल", perf: "खेला", fut: ["खेलूँगा", "खेलेगा", "खेलेगी"] },
  { en: "dinner", hi: "रात का खाना", base: "cook", s3: "cooks", past: "cooked", pp: "cooked", ing: "cooking", stem: "बना", perf: "बनाया", fut: ["बनाऊँगा", "बनाएगा", "बनाएगी"] },
  { en: "vegetables", hi: "सब्ज़ियाँ", base: "buy", s3: "buys", past: "bought", pp: "bought", ing: "buying", stem: "ख़रीद", perf: "ख़रीदीं", fut: ["ख़रीदूँगा", "ख़रीदेगा", "ख़रीदेगी"] },
  { en: "English", hi: "अंग्रेज़ी", base: "learn", s3: "learns", past: "learned", pp: "learned", ing: "learning", stem: "सीख", perf: "सीखी", fut: ["सीखूँगा", "सीखेगा", "सीखेगी"] },
  { en: "my room", hi: "अपना कमरा", base: "clean", s3: "cleans", past: "cleaned", pp: "cleaned", ing: "cleaning", stem: "साफ़ कर", perf: "साफ़ किया", fut: ["साफ़ करूँगा", "साफ़ करेगा", "साफ़ करेगी"] }
];

const BE = { i: "am", sm: "is", sf: "is", p: "are", you: "are" };
const BE_END = { i: "हूँ", sm: "है", sf: "है", p: "हैं", you: "हो" };
const BE_PAST_END = { i: "था", sm: "था", sf: "थी", p: "थे", you: "थे" };
const PS_SUF = { i: "ता हूँ", sm: "ता है", sf: "ती है", p: "ते हैं", you: "ते हो" };
const PC_SUF = { i: "रहा हूँ", sm: "रहा है", sf: "रही है", p: "रहे हैं", you: "रहे हो" };
const PCW_SUF = { i: "रहा था", sm: "रहा था", sf: "रही थी", p: "रहे थे", you: "रहे थे" };
const GO_SUF = { i: "वाला हूँ", sm: "वाला है", sf: "वाली है", p: "वाले हैं", you: "वाले हो" };
const haveOf = (p) => (p === "sm" || p === "sf" ? "has" : "have");

const PERSONS = ["i", "sm", "sf", "p"];
const SUBJ_SLOT = { i: "si", sm: "ssm", sf: "ssf", p: "sp" };

function wrongsFor(ans, pool) {
  const out = [];
  for (const w of pool) if (w !== ans && !out.includes(w)) out.push(w);
  return out.slice(0, 3).join(",");
}

// present simple: the gap is the main verb
const actPS = (p, name) => lib(name, VERBS.map((v) => {
  const ans = p === "sm" || p === "sf" ? v.s3 : v.base;
  return VA(v.en, v.hi, v.stem + PS_SUF[p], ans, wrongsFor(ans, [v.base, v.s3, v.past, v.ing]));
}));
// continuous tenses: the gap is the auxiliary, the -ing verb rides along
const actPC = (p, name, suf) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + suf[p], "", "")));
// perfect tenses: the gap is the auxiliary, the participle rides along
const actPP = (p, name, aux) => lib(name, VERBS.map((v) => VA(v.pp + " " + v.en, v.hi, v.perf + " " + aux[p], "", "")));
// past simple: the gap is the main verb in its past form
const actPST = (name) => lib(name, VERBS.map((v) => VA(v.en, v.hi, v.perf, v.past, wrongsFor(v.past, [v.base, v.s3, v.ing]))));
// future: the gap is the auxiliary, the base verb rides along
const actBase = (name, prefix) => lib(name, VERBS.map((v) => VA((prefix ? prefix + " " : "") + v.base + " " + v.en, v.hi, "", "", "")));
// future in Hindi: the verb form carries the person
const actFut = (name) => lib(name, VERBS.map((v) => VA(v.base + " " + v.en, v.hi, v.fut[0], "", "")));
const actGo = (name) => lib(name, VERBS.map((v) => VA(v.base + " " + v.en, v.hi, v.stem + "ने " + GO_SUF.i, "", "")));

const CATS = [];
const cat = (id, slots, tpls) => CATS.push({ id, slots, tpls });
const T = (en, hi, opts = {}) => ({ en, hi, ...opts });

// Per-person helper forms, used by the tense categories below.
const SUBJ = { i: "S_I", sm: "S_3SM", sf: "S_3SF", p: "S_3P" };
const NSUBJ = { i: "N_I", sm: "N_3SM", sf: "N_3SF", p: "N_3P" };
const PSUBJ = { i: "P_I", sm: "P_3SM", sf: "P_3SF", p: "P_3P" };
const FCS = { i: "रहा होऊँगा", sm: "रहा होगा", sf: "रही होगी", p: "रहे होंगे" };
const FPS = { i: "चुका होऊँगा", sm: "चुका होगा", sf: "चुकी होगी", p: "चुके होंगे" };
const FUT_IX = { i: 0, sm: 1, sf: 2, p: 3 };
const FUT_PL = { "पी": "पिएँगे", "पढ़": "पढ़ेंगे", "लिख": "लिखेंगे", "खा": "खाएँगे", "देख": "देखेंगे", "खेल": "खेलेंगे", "बना": "बनाएँगे", "ख़रीद": "ख़रीदेंगे", "सीख": "सीखेंगे", "साफ़ कर": "साफ़ करेंगे" };
const futOf = (v, p) => (p === "p" ? FUT_PL[v.stem] : v.fut[FUT_IX[p]]);
const actFutP = (p, name) => lib(name, VERBS.map((v) => VA(v.base + " " + v.en, v.hi, futOf(v, p), "will", "would,am,is,have")));
const actPresCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + PC_SUF[p], BE[p], "am,is,are,was,were")));
const actPastCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + PCW_SUF[p], p === "i" || p === "sm" || p === "sf" ? "was" : "were", "was,were,am,is")));
const actGoP = (p, name) => lib(name, VERBS.map((v) => VA(v.base + " " + v.en, v.hi, v.stem + "ने " + GO_SUF[p], BE[p], "am,is,are,will")));
const actFutCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + FCS[p], "will", "would,am,is,have")));
const actFutPerf = (p, name) => lib(name, VERBS.map((v) => VA(v.pp + " " + v.en, v.hi, v.stem + " " + FPS[p], "will", "would,has,have,had")));
const actFutPerfCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + FCS[p], "will", "would,has,have,had")));
// Object-agreement for the Hindi past auxiliary (ergative perfect: "चाय पी थी", "सेब खाया था").
const PAST_BE = { "पी": "थी", "पढ़ी": "थी", "लिखी": "थी", "खाया": "था", "देखी": "थी", "खेला": "था", "बनाया": "था", "ख़रीदीं": "थीं", "सीखी": "थी", "साफ़ किया": "था" };
const pastAux = (v) => PAST_BE[v.perf] || "था";
const actPresPerf = (p, name) => lib(name, VERBS.map((v) => VA(v.pp + " " + v.en, v.hi, v.perf + " है", haveOf(p), "have,has,had,is")));
const actPastPerf = (p, name) => lib(name, VERBS.map((v) => VA(v.pp + " " + v.en, v.hi, v.perf + " " + pastAux(v), "had", "have,has,was,were")));
const actPresPerfCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + PC_SUF[p], haveOf(p), "have,has,had,is")));
const actPastPerfCont = (p, name) => lib(name, VERBS.map((v) => VA(v.ing + " " + v.en, v.hi, v.stem + " " + PCW_SUF[p], "had", "have,has,was,were")));
lib("RECENT", [V("today", "आज"), V("this morning", "आज सुबह"), V("this week", "इस हफ़्ते"), V("already", "पहले से ही"), V("recently", "हाल ही में"), V("just now", "अभी-अभी"), V("twice today", "आज दो बार"), V("before", "पहले")]);
lib("BY", [V("by tomorrow", "कल तक"), V("by next week", "अगले हफ़्ते तक"), V("by Monday", "सोमवार तक"), V("by tonight", "आज रात तक"), V("by 5 o'clock", "पाँच बजे तक"), V("by the end of the day", "दिन के अंत तक"), V("by next month", "अगले महीने तक"), V("by Sunday", "रविवार तक")]);
// Dative subjects for obligation ("मुझे ... करना है / चाहिए").
lib("D_I", [V("I", "मुझे")]);
lib("D_3SM", [V("he", "उसे"), V("my brother", "मेरे भाई को"), V("my father", "मेरे पिता को"), V("Ravi", "रवि को"), V("the teacher", "शिक्षक को"), V("my friend", "मेरे दोस्त को"), V("the boy", "लड़के को"), V("Mr Sharma", "श्री शर्मा को"), V("the doctor", "डॉक्टर को"), V("my uncle", "मेरे चाचा को")]);
lib("D_3SF", [V("she", "उसे"), V("my sister", "मेरी बहन को"), V("my mother", "मेरी माँ को"), V("Priya", "प्रिया को"), V("the teacher", "शिक्षिका को"), V("the girl", "लड़की को"), V("Mrs Sharma", "श्रीमती शर्मा को"), V("my daughter", "मेरी बेटी को"), V("the nurse", "नर्स को"), V("my aunt", "मेरी चाची को")]);
lib("D_3P", [V("they", "उन्हें"), V("my parents", "मेरे माता-पिता को"), V("the students", "छात्रों को"), V("my friends", "मेरे दोस्तों को"), V("the children", "बच्चों को"), V("the boys", "लड़कों को"), V("my brothers", "मेरे भाइयों को"), V("the teachers", "शिक्षकों को")]);
const DOBJ = { i: "D_I", sm: "D_3SM", sf: "D_3SF", p: "D_3P" };
const placeOf = (p) => (p === "sf" ? "@PLACE_F" : "@PLACE_M");
const SB = (p) => SUBJ_SLOT[p];

// =====================================================================
// Tenses
// =====================================================================

// am / is / are — the verb "to be"
{
  const slots = { t: "@WHEN" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["pl_" + p] = placeOf(p);
    tpls.push(T(`{${SB(p)}} ___ {pl_${p}} {t}.`, `{${SB(p)}} {t} {pl_${p}} {gap}।`, { ans: BE[p], wrongs: "am,is,are,was,were", gapHi: BE_END[p] }));
  }
  cat("be", slots, tpls);
}

// was / were
{
  const slots = { t: "@PAST" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["pl_" + p] = placeOf(p);
    tpls.push(T(`{${SB(p)}} ___ {pl_${p}} {t}.`, `{${SB(p)}} {t} {pl_${p}} {gap}।`, { ans: p === "i" || p === "sm" || p === "sf" ? "was" : "were", wrongs: "was,were,am,is", gapHi: BE_PAST_END[p] }));
  }
  cat("be-past", slots, tpls);
}

// present simple
{
  const slots = { t: "@FREQ" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["a_" + p] = actPS(p, "a_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "S_I" : p === "sm" ? "S_3SM" : p === "sf" ? "S_3SF" : "S_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ {a_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} {a_${p}} {gap}।`, { blank: "a_" + p }));
  }
  cat("present-simple", slots, tpls);
}

// present continuous
{
  const slots = { s: "@S_3SM", t: "@WHEN" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["c_" + p] = actPresCont(p, "c_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "S_I" : p === "sm" ? "S_3SM" : p === "sf" ? "S_3SF" : "S_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ {c_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} {c_${p}} {gap}।`, { blank: "c_" + p }));
  }
  cat("present-continuous", slots, tpls);
}

// past simple
{
  const slots = { t: "@PAST" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + NSUBJ[p];
    slots["st_" + p] = actPST("st_" + p);
    tpls.push(T(`{${SB(p)}} ___ {st_${p}} {t}.`, `{${SB(p)}} {t} {st_${p}} {gap}।`, { blank: "st_" + p }));
  }
  cat("past-simple", slots, tpls);
}

// past continuous
{
  const slots = { t: "@PAST" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["d_" + p] = actPastCont(p, "d_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "S_I" : p === "sm" ? "S_3SM" : p === "sf" ? "S_3SF" : "S_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ {d_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} {d_${p}} {gap}।`, { blank: "d_" + p }));
  }
  cat("past-continuous", slots, tpls);
}

// present perfect
{
  const slots = { t: "@RECENT" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["h_" + p] = actPresPerf(p, "h_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "N_I" : p === "sm" ? "N_3SM" : p === "sf" ? "N_3SF" : "N_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ {h_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} {h_${p}} {gap}।`, { blank: "h_" + p }));
  }
  cat("present-perfect", slots, tpls);
}

// past perfect
{
  const slots = { t: "@PAST" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["p_" + p] = actPastPerf(p, "p_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "N_I" : p === "sm" ? "N_3SM" : p === "sf" ? "N_3SF" : "N_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ {p_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} {p_${p}} {gap}।`, { blank: "p_" + p }));
  }
  cat("past-perfect", slots, tpls);
}

// present perfect continuous
{
  const slots = { t: "@DUR" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["pc_" + p] = actPresPerfCont(p, "pc_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "S_I" : p === "sm" ? "S_3SM" : p === "sf" ? "S_3SF" : "S_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ been {pc_${p}} {t}.`, `{${SUBJ_SLOT[p]}} {t} से {pc_${p}} {gap}।`, { blank: "pc_" + p }));
  }
  cat("present-perfect-continuous", slots, tpls);
}

// past perfect continuous
{
  const slots = { t: "@DUR" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["qc_" + p] = actPastPerfCont(p, "qc_" + p);
    slots[SUBJ_SLOT[p]] = "@" + (p === "i" ? "S_I" : p === "sm" ? "S_3SM" : p === "sf" ? "S_3SF" : "S_3P");
    tpls.push(T(`{${SUBJ_SLOT[p]}} ___ been {qc_${p}} {t} when you called.`, `{${SUBJ_SLOT[p]}} {t} से {qc_${p}} {gap} जब तुमने फ़ोन किया।`, { blank: "qc_" + p }));
  }
  cat("past-perfect-continuous", slots, tpls);
}

// will — future
{
  const slots = { t: "@FUT" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["f_" + p] = actFutP(p, "f_" + p);
    tpls.push(T(`{${SB(p)}} ___ {f_${p}} {t}.`, `{${SB(p)}} {t} {f_${p}} {gap}।`, { blank: "f_" + p }));
  }
  cat("future-will", slots, tpls);
}

// going to — plans
{
  const slots = { t: "@FUT" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["g_" + p] = actGoP(p, "g_" + p);
    tpls.push(T(`{${SB(p)}} ___ going to {g_${p}} {t}.`, `{${SB(p)}} {t} {g_${p}} {gap}।`, { blank: "g_" + p }));
  }
  cat("going-to", slots, tpls);
}

// future continuous
{
  const slots = { t: "@FUT" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["fc_" + p] = actFutCont(p, "fc_" + p);
    tpls.push(T(`{${SB(p)}} ___ be {fc_${p}} {t}.`, `{${SB(p)}} {t} {fc_${p}} {gap}।`, { blank: "fc_" + p }));
  }
  cat("future-continuous", slots, tpls);
}

// future perfect
{
  const slots = { t: "@BY" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["fp_" + p] = actFutPerf(p, "fp_" + p);
    tpls.push(T(`{${SB(p)}} ___ have {fp_${p}} {t}.`, `{${SB(p)}} {t} {fp_${p}} {gap}।`, { blank: "fp_" + p }));
  }
  cat("future-perfect", slots, tpls);
}

// future perfect continuous
{
  const slots = { t: "@DUR" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + SUBJ[p];
    slots["fx_" + p] = actFutPerfCont(p, "fx_" + p);
    tpls.push(T(`{${SB(p)}} ___ have been {fx_${p}} {t}.`, `{${SB(p)}} {t} से {fx_${p}} {gap}।`, { blank: "fx_" + p }));
  }
  cat("future-perfect-continuous", slots, tpls);
}

// =====================================================================
// Verbs & modals
// =====================================================================

// have / has — possession
{
  const slots = {
    s: "@P_3SM",
    o: PHRASES,
    t: "@WHEN"
  };
  const tpls = ["i", "sm", "sf", "p"].map((p) =>
    T(`{${p === "i" ? "si" : p === "sm" ? "ssm" : p === "sf" ? "ssf" : "sp"}} ___ {${"o"}} {${"t"}}.`,
      `{${p === "i" ? "si" : p === "sm" ? "ssm" : p === "sf" ? "ssf" : "sp"}} {${"o"}} {${"t"}} {gap}।`,
      { ans: p === "sm" || p === "sf" ? "has" : "have", wrongs: "have,has,had,is", gapHi: "है" })
  );
  slots.si = "@P_I"; slots.ssm = "@P_3SM"; slots.ssf = "@P_3SF"; slots.sp = "@P_3P";
  cat("have-has", slots, tpls);
}

// do / does / did — the helper verb
{
  const slots = {
    s: "@S_3SM", t: "@FREQ",
    v: VERBS.map((x) => VA(x.base + " " + x.en, x.hi, "", "", ""))
  };
  cat("do-does-did", slots, [
    T("___ {s} {v} {t}?", "क्या {s} {t} {v} {gap}?", { ans: "Does", wrongs: "Do,Did,Is", gapHi: "" }),
    T("{s} ___ not {v} {t}.", "{s} {t} {v} {gap} नहीं।", { ans: "does", wrongs: "do,did,is", gapHi: "" }),
    T("I ___ not {v} {t}.", "मैं {t} {v} {gap} नहीं।", { ans: "do", wrongs: "does,did,am", gapHi: "" }),
    T("They ___ not {v} {t}.", "वे {t} {v} {gap} नहीं।", { ans: "do", wrongs: "does,did,are", gapHi: "" })
  ]);
}

// can / could — ability and permission
{
  const slots = {
    s: "@S_3SM", t: "@FREQ",
    v: VERBS.map((x) => VA(x.base + " " + x.en, x.hi, x.stem + " सकता है", "", ""))
  };
  cat("can-could", slots, [
    T("{s} ___ {v} {t}.", "{s} {t} {v} {gap}।", { ans: "can", wrongs: "cans,can to,could to,is can", gapHi: "सकता है" }),
    T("{s} ___ {v} when {s} was young.", "{s} जवान था तब {v} {gap}।", { ans: "could", wrongs: "can,could to,cans,is could", gapHi: "सकता था" }),
    T("___ you {v}?", "क्या तुम {v} {gap}?", { ans: "Can", wrongs: "Cans,Could to,Are can,Do can", gapHi: "सकते हो" })
  ]);
}

// must / might / can't — deduction
{
  const slots = {
    s: "@S_3SM", t: "@WHEN", x: "@PLACE_M"
  };
  cat("modals-deduction", slots, [
    T("{s} ___ be {x} {t}.", "{s} शायद {t} {x} {gap}।", { ans: "might", wrongs: "might to,mights,must to,can to", gapHi: "हो सकता है" }),
    T("{s} ___ be {x} {t} — I am sure.", "{s} ज़रूर {t} {x} {gap}।", { ans: "must", wrongs: "must to,musts,might to,can to", gapHi: "ही होगा" }),
    T("{s} ___ be {x} {t} — that is impossible.", "{s} {t} {x} {gap} नहीं हो सकता।", { ans: "can't", wrongs: "can not to,must not,might not,doesn't", gapHi: "नहीं हो सकता" })
  ]);
}

// must / have to — obligation
{
  const slots = { t: "@WHEN", f: "@FREQ" };
  const tpls = [];
  for (const p of PERSONS) {
    slots["m_" + p] = lib("m_" + p, VERBS.map((v) => VA(v.base + " " + v.en, "", v.hi + " " + v.stem + "ना है", "must", "must to,musts,have to,has to")));
    slots["h_" + p] = lib("h_" + p, VERBS.map((v) => VA(v.base + " " + v.en, "", v.hi + " " + v.stem + "ना है", p === "sm" || p === "sf" ? "has to" : "have to", "have,having to,must to,has to")));
    slots["d_" + p] = "@" + DOBJ[p];
    const m = "m_" + p, h = "h_" + p, d = "d_" + p;
    tpls.push(T(`{${d}} ___ {${m}} {t}.`, `{${d}} {t} {gap}।`, { blank: m }));
    tpls.push(T(`{${d}} ___ {${h}} {t}.`, `{${d}} {t} {gap}।`, { blank: h }));
    tpls.push(T(`{${d}} ___ {${m}} {f}.`, `{${d}} {f} {gap}।`, { blank: m }));
    tpls.push(T(`{${d}} ___ {${h}} {f}.`, `{${d}} {f} {gap}।`, { blank: h }));
  }
  cat("must-have-to", slots, tpls);
}

// should — advice
{
  const slots = { t: "@WHEN" };
  const tpls = [];
  for (const p of PERSONS) {
    slots[SB(p)] = "@" + DOBJ[p];
    slots["ds_" + p] = lib("ds_" + p, VERBS.map((v) => VA(v.base + " " + v.en, v.hi, v.stem + "ना चाहिए", "should", "should to,shoulds,would to,must to")));
    tpls.push(T(`{${SB(p)}} ___ {ds_${p}} {t}.`, `{${SB(p)}} {t} {ds_${p}} {gap}।`, { blank: "ds_" + p }));
  }
  cat("should", slots, tpls);
}

// would — politeness and past habits
{
  const wants = [
    V("a cup of tea", "एक कप चाय"), V("a glass of water", "एक गिलास पानी"), V("some help", "थोड़ी मदद"),
    V("a new phone", "नया फ़ोन"), V("a quiet room", "शांत कमरा"), V("your number", "तुम्हारा नंबर"),
    V("the bill", "बिल"), V("a taxi", "टैक्सी"), V("some time", "थोड़ा समय"), V("a receipt", "रसीद"),
    V("a bigger bag", "बड़ा बस्ता"), V("two tickets", "दो टिकट"), V("a window seat", "खिड़की वाली सीट"),
    V("an umbrella", "एक छाता"), V("some water", "थोड़ा पानी"), V("a pen", "एक कलम")
  ];
  const habits = [
    V("sit by the window", "खिड़की के पास बैठने"), V("walk to school", "स्कूल पैदल जाने"),
    V("tell us stories", "हमें कहानियाँ सुनाने"), V("play here", "यहाँ खेलने"),
    V("sing in the morning", "सुबह गाने"), V("drink tea at four", "चार बजे चाय पीने"),
    V("visit us", "हमसे मिलने"), V("read to me", "मुझे पढ़कर सुनाने"),
    V("help my mother", "मेरी माँ की मदद करने"), V("wait at the gate", "गेट पर इंतज़ार करने"),
    V("eat with us", "हमारे साथ खाने"), V("call every night", "हर रात फ़ोन करने"),
    V("cycle to work", "साइकिल से काम पर जाने"), V("study in the library", "पुस्तकालय में पढ़ने"),
    V("borrow my bike", "मेरी बाइक उधार लेने"), V("cook on Sunday", "रविवार को खाना बनाने")
  ];
  const slots = {
    w: wants.map((v) => VA(v[0], v[1], "चाहिए", "would", "will,would to,am,did")),
    h: habits.map((v) => VA(v[0], v[1], "की आदत थी", "would", "will,would to,is,did")),
    s: "@S_3SM", t: "@FREQ"
  };
  cat("would", slots, [
    T("I ___ like {w}, please.", "मुझे {w} {gap}, कृपया।", { blank: "w" }),
    T("Would you like {w}?", "क्या तुम्हें {w} {gap}?", { blank: "w" }),
    T("{s} ___ {h} {t}.", "{s} को {t} {h} {gap}।", { blank: "h" })
  ]);
}

// used to — past habits
{
  const slots = {
    s: "@S_3SM", t: "@FREQ",
    v: VERBS.map((x) => VA(x.base + " " + x.en, x.hi, x.stem + "ता था", "", ""))
  };
  cat("used-to", slots, [
    T("{s} ___ {v} {t}.", "{s} {t} {v} {gap}, पर अब नहीं।", { ans: "used to", wrongs: "use to,uses to,used,using to", gapHi: "करता था" }),
    T("I ___ {v} {t}.", "मैं {t} {v} {gap}, पर अब नहीं।", { ans: "used to", wrongs: "use to,uses to,used,using to", gapHi: "करता था" }),
    T("We ___ {v} {t}.", "हम {t} {v} {gap}, पर अब नहीं।", { ans: "used to", wrongs: "use to,uses to,used,using to", gapHi: "करते थे" })
  ]);
}

// gerund vs infinitive
{
  const slots = { t: "@FREQ" };
  const gWrong = (x) => wrongsFor(x.ing + " " + x.en, [x.base + " " + x.en, "to " + x.base + " " + x.en, x.s3 + " " + x.en]);
  const iWrong = (x) => wrongsFor("to " + x.base + " " + x.en, [x.base + " " + x.en, x.ing + " " + x.en, x.s3 + " " + x.en]);
  const eWrong = (x) => wrongsFor("to " + x.base + " " + x.en, [x.ing + " " + x.en, x.base + " " + x.en, x.s3 + " " + x.en]);
  slots.g = lib("g", VERBS.map((x) => VA(x.ing + " " + x.en, x.hi, "", x.ing + " " + x.en, gWrong(x))));
  slots.i = lib("i", VERBS.map((x) => VA("to " + x.base + " " + x.en, x.hi, "", "to " + x.base + " " + x.en, iWrong(x))));
  slots.e = lib("e", VERBS.map((x) => VA("to " + x.base + " " + x.en, x.hi, "", "to " + x.base + " " + x.en, eWrong(x))));
  cat("gerund-infinitive", slots, [
    T("I enjoy ___ {t}.", "मुझे {t} {g} अच्छा लगता है।", { blank: "g" }),
    T("He finished ___ {t}.", "उसने {t} {g} ख़त्म किया।", { blank: "g" }),
    T("We avoided ___ {t}.", "हमने {t} {g} से बचा।", { blank: "g" }),
    T("She loves ___ {t}.", "उसे {t} {g} बहुत पसंद है।", { blank: "g" }),
    T("They kept ___ {t}.", "वे {t} {g} करते रहे।", { blank: "g" }),
    T("I hate ___ {t}.", "मुझे {t} {g} पसंद नहीं है।", { blank: "g" }),
    T("He dislikes ___ {t}.", "उसे {t} {g} पसंद नहीं है।", { blank: "g" }),
    T("We practise ___ {t}.", "हम {t} {g} का अभ्यास करते हैं।", { blank: "g" }),
    T("She wants ___ {t}.", "वह {t} {i} चाहती है।", { blank: "i" }),
    T("They decided ___ {t}.", "उन्होंने {t} {i} का फ़ैसला किया।", { blank: "i" }),
    T("I plan ___ {t}.", "मैं {t} {i} की योजना बनाता हूँ।", { blank: "i" }),
    T("We hope ___ {t}.", "हम {t} {i} की उम्मीद करते हैं।", { blank: "i" }),
    T("He needs ___ {t}.", "उसे {t} {i} की ज़रूरत है।", { blank: "i" }),
    T("Don't forget ___ {t}.", "{t} {e} मत भूलो।", { blank: "e" }),
    T("I would like ___ {t}.", "मैं {t} {i} चाहूँगा।", { blank: "i" }),
    T("They chose ___ {t}.", "उन्होंने {t} {i} चुना।", { blank: "i" })
  ]);
}

// =====================================================================
// Nouns & pronouns
// =====================================================================

// a / an / the
{
  const slots = { n: ARTICLE_PHRASES, t: "@PAST" };
  cat("articles", slots, [
    T("I saw ___ {n} {t}.", "मैंने {t} {n} देखा।", { blank: "n" }),
    T("She bought ___ {n} {t}.", "उसने {t} {n} ख़रीदा।", { blank: "n" }),
    T("We need ___ {n} today.", "हमें आज {n} चाहिए।", { blank: "n" })
  ]);
}

// plurals
{
  const slots = {
    n: NOUNS.map((x) => VA(x.pl, x.plHi, x.plHi, x.pl, wrongsFor(x.pl, [x.en, x.en + "s", x.en + "es", x.pl + "'s"]))),
    q: [V("two", "दो"), V("three", "तीन"), V("four", "चार"), V("five", "पाँच"), V("six", "छह"), V("ten", "दस"), V("many", "बहुत"), V("some", "कुछ"), V("a few", "कुछ"), V("twenty", "बीस")]
  };
  cat("plurals", slots, [
    T("I have {q} ___ here.", "मेरे पास {q} {gap} हैं।", { blank: "n" }),
    T("She has {q} ___ at home.", "उसके पास {q} {gap} हैं।", { blank: "n" }),
    T("There are {q} ___ in the shop.", "दुकान में {q} {gap} हैं।", { blank: "n" }),
    T("My brother bought {q} ___ .", "मेरे भाई ने {q} {gap} ख़रीदे।", { blank: "n" }),
    T("We need {q} ___ for the office.", "हमें दफ़्तर के लिए {q} {gap} चाहिए।", { blank: "n" }),
    T("The teacher wants {q} ___ today.", "शिक्षक को आज {q} {gap} चाहिए।", { blank: "n" }),
    T("I can see {q} ___ in the photo.", "मुझे फ़ोटो में {q} {gap} दिख रहे हैं।", { blank: "n" }),
    T("They sold {q} ___ last week.", "उन्होंने पिछले हफ़्ते {q} {gap} बेचे।", { blank: "n" })
  ]);
}

// this / that / these / those
{
  const phrases = (g) => NOUNS.filter((x) => x.g === g).flatMap((x) => [V(x.en, x.hi), ...ADJS.map((a) => V(a.en + " " + x.en, adjHi(x, a) + " " + x.hi))]);
  const pls = (g) => NOUNS.filter((x) => x.g === g).map((x) => V(x.pl, x.plHi));
  const slots = { nm: phrases("m"), nf: phrases("f"), pm: pls("m"), pf: pls("f") };
  cat("this-that", slots, [
    T("___ {nm} is mine.", "यह {nm} मेरा है।", { ans: "This", wrongs: "That,These,Those" }),
    T("___ {nm} over there is mine.", "वह {nm} मेरा है।", { ans: "That", wrongs: "This,These,Those" }),
    T("___ {nf} is mine.", "यह {nf} मेरी है।", { ans: "This", wrongs: "That,These,Those" }),
    T("___ {nf} over there is mine.", "वह {nf} मेरी है।", { ans: "That", wrongs: "This,These,Those" }),
    T("___ {pm} are mine.", "ये {pm} मेरे हैं।", { ans: "These", wrongs: "This,That,Those" }),
    T("___ {pm} over there are mine.", "वे {pm} मेरे हैं।", { ans: "Those", wrongs: "This,That,These" }),
    T("___ {pf} are mine.", "ये {pf} मेरी हैं।", { ans: "These", wrongs: "This,That,Those" }),
    T("___ {pf} over there are mine.", "वे {pf} मेरी हैं।", { ans: "Those", wrongs: "This,That,These" }),
    T("Is ___ {nm} yours?", "क्या यह {nm} तुम्हारा है?", { ans: "This", wrongs: "That,These,Those" }),
    T("Is ___ {nf} yours?", "क्या यह {nf} तुम्हारी है?", { ans: "This", wrongs: "That,These,Those" }),
    T("___ {nm} is not mine.", "यह {nm} मेरा नहीं है।", { ans: "This", wrongs: "That,These,Those" }),
    T("___ {nf} is not mine.", "यह {nf} मेरी नहीं है।", { ans: "This", wrongs: "That,These,Those" }),
    T("___ {pm} are not mine.", "ये {pm} मेरे नहीं हैं।", { ans: "These", wrongs: "This,That,Those" }),
    T("___ {pf} are not mine.", "ये {pf} मेरी नहीं हैं।", { ans: "These", wrongs: "This,That,Those" }),
    T("Do you like ___ {pm}?", "क्या तुम्हें ये {pm} पसंद हैं?", { ans: "These", wrongs: "This,That,Those" }),
    T("Do you like ___ {pf}?", "क्या तुम्हें ये {pf} पसंद हैं?", { ans: "These", wrongs: "This,That,Those" }),
    T("I like ___ {nm}.", "मुझे यह {nm} पसंद है।", { ans: "This", wrongs: "That,These,Those" }),
    T("I want ___ {nm}.", "मुझे यह {nm} चाहिए।", { ans: "This", wrongs: "That,These,Those" }),
    T("I like ___ {nf}.", "मुझे यह {nf} पसंद है।", { ans: "This", wrongs: "That,These,Those" }),
    T("I want ___ {nf}.", "मुझे यह {nf} चाहिए।", { ans: "This", wrongs: "That,These,Those" })
  ]);
}

// there is / there are
{
  const slots = {
    n: NOUNS.map((x) => VA(x.en, x.hi, "", "is", "are,was,were")),
    np: NOUNS.map((x) => VA(x.en, x.hi, "", "was", "is,are,were")),
    p: NOUNS.map((x) => VA(x.pl, x.plHi, "", "are", "is,was,were")),
    pp: NOUNS.map((x) => VA(x.pl, x.plHi, "", "were", "is,are,was")),
    q: [V("two", "दो"), V("three", "तीन"), V("four", "चार"), V("five", "पाँच"), V("six", "छह"), V("ten", "दस"), V("many", "बहुत"), V("some", "कुछ")],
    x: "@PLACE_M",
    t: "@PAST"
  };
  cat("there-is-are", slots, [
    T("There ___ a {n} {x}.", "{x} एक {n} है।", { blank: "n" }),
    T("There ___ no {n} {x}.", "{x} कोई {n} नहीं है।", { blank: "n" }),
    T("There ___ a {n} {x} {t}.", "{x} {t} एक {n} था।", { blank: "np" }),
    T("There ___ {q} {p} {x}.", "{x} {q} {p} हैं।", { blank: "p" }),
    T("There ___ no {p} {x}.", "{x} कोई {p} नहीं हैं।", { blank: "p" }),
    T("There ___ {q} {p} {x} {t}.", "{x} {t} {q} {p} थे।", { blank: "pp" })
  ]);
}

// pronouns
{
  const obj = (hi) => [
    VA("him", hi, hi, "him", "he,his,himself"),
    VA("her", hi, hi, "her", "she,hers,herself"),
    VA("them", hi, hi, "them", "they,their,themselves"),
    VA("me", hi, hi, "me", "I,my,myself"),
    VA("us", hi, hi, "us", "we,our,ourselves"),
    VA("it", hi, hi, "it", "its,it's,they"),
    VA("you", hi, hi, "you", "your,yours,yourself")
  ];
  const withS = [
    VA("him", "उसे", "उससे", "him", "he,his,himself"),
    VA("her", "उसे", "उससे", "her", "she,hers,herself"),
    VA("them", "उन्हें", "उनसे", "them", "they,their,themselves"),
    VA("me", "मुझे", "मुझसे", "me", "I,my,myself"),
    VA("us", "हमें", "हमसे", "us", "we,our,ourselves"),
    VA("it", "उसे", "उससे", "it", "its,it's,they"),
    VA("you", "तुम्हें", "तुमसे", "you", "your,yours,yourself")
  ];
  const slots = {
    o: obj("उसे"), oy: obj("तुम्हें"), z: withS,
    s: "@S_3SM", nz: "@N_3SM", t: "@PAST"
  };
  cat("pronouns", slots, [
    T("I saw ___ {t}.", "मैंने {t} {gap} देखा।", { blank: "o" }),
    T("She called ___ last night.", "उसने कल रात {gap} फ़ोन किया।", { blank: "o" }),
    T("Please help ___ .", "कृपया {gap} मदद करो।", { blank: "o" }),
    T("I gave the letter to ___ {t}.", "मैंने {t} चिट्ठी {gap} दी।", { blank: "oy" }),
    T("{nz} spoke to ___ {t}.", "{nz} {t} {gap} बात की।", { blank: "z" }),
    T("{s} will meet ___ tomorrow.", "{s} कल {gap} मिलेगा।", { blank: "z" }),
    T("{nz} was waiting for ___ {t}.", "{nz} {t} {gap} इंतज़ार कर रहा था।", { blank: "z" }),
    T("I told ___ {t}.", "मैंने {t} {gap} बताया।", { blank: "o" }),
    T("We can see ___ {t}.", "हम {t} {gap} देख सकते हैं।", { blank: "o" })
  ]);
}

// possessives
{
  const pos = (f) => [
    VA("my", f.my, f.my, "my", "me,mine,myself"),
    VA("your", f.your, f.your, "your", "you,yours,yourself"),
    VA("his", f.his, f.his, "his", "he,him,himself"),
    VA("her", f.her, f.her, "her", "she,hers,herself"),
    VA("our", f.our, f.our, "our", "us,ours,ourselves"),
    VA("their", f.their, f.their, "their", "they,them,theirs")
  ];
  const phrases = (g) => NOUNS.filter((x) => x.g === g).flatMap((x) => [V(x.en, x.hi), ...ADJS.map((a) => V(a.en + " " + x.en, adjHi(x, a) + " " + x.hi))]);
  const pls = (g) => NOUNS.filter((x) => x.g === g).map((x) => V(x.pl, x.plHi));
  const slots = {
    nm: phrases("m"),
    nf: phrases("f"),
    nmpl: pls("m"),
    nfpl: pls("f"),
    pm: pos({ my: "मेरा", your: "तुम्हारा", his: "उसका", her: "उसका", our: "हमारा", their: "उनका" }),
    pf: pos({ my: "मेरी", your: "तुम्हारी", his: "उसकी", her: "उसकी", our: "हमारी", their: "उनकी" }),
    pmpl: pos({ my: "मेरे", your: "तुम्हारे", his: "उसके", her: "उसके", our: "हमारे", their: "उनके" })
  };
  cat("possessives", slots, [
    T("This is ___ {nm}.", "यह {gap} {nm} है।", { blank: "pm" }),
    T("This is ___ {nf}.", "यह {gap} {nf} है।", { blank: "pf" }),
    T("I like ___ {nm}.", "मुझे {gap} {nm} पसंद है।", { blank: "pm" }),
    T("I like ___ {nf}.", "मुझे {gap} {nf} पसंद है।", { blank: "pf" }),
    T("Where is ___ {nm}?", "{gap} {nm} कहाँ है?", { blank: "pm" }),
    T("Where is ___ {nf}?", "{gap} {nf} कहाँ है?", { blank: "pf" }),
    T("He sold ___ {nm} yesterday.", "उसने कल {gap} {nm} बेचा।", { blank: "pm" }),
    T("She sold ___ {nf} yesterday.", "उसने कल {gap} {nf} बेची।", { blank: "pf" }),
    T("I forgot ___ {nm} at home.", "मैं {gap} {nm} घर भूल गया।", { blank: "pm" }),
    T("I forgot ___ {nf} at home.", "मैं {gap} {nf} घर भूल गया।", { blank: "pf" }),
    T("Please bring ___ {nm} here.", "कृपया {gap} {nm} यहाँ लाओ।", { blank: "pm" }),
    T("Please bring ___ {nf} here.", "कृपया {gap} {nf} यहाँ लाओ।", { blank: "pf" }),
    T("I saw ___ {nmpl} yesterday.", "मैंने कल {gap} {nmpl} देखे।", { blank: "pmpl" }),
    T("I saw ___ {nfpl} yesterday.", "मैंने कल {gap} {nfpl} देखीं।", { blank: "pf" }),
    T("Please bring ___ {nmpl} here.", "कृपया {gap} {nmpl} यहाँ लाओ।", { blank: "pmpl" }),
    T("Please bring ___ {nfpl} here.", "कृपया {gap} {nfpl} यहाँ लाओ।", { blank: "pf" })
  ]);
}

// much / many
{
  const unc = [
    V("water", "पानी"), V("sugar", "चीनी"), V("milk", "दूध"), V("rice", "चावल"),
    V("money", "पैसा"), V("time", "समय"), V("work", "काम"), V("tea", "चाय"),
    V("salt", "नमक"), V("bread", "रोटी"), V("oil", "तेल"), V("juice", "जूस"),
    V("homework", "होमवर्क"), V("rain", "बारिश"), V("music", "संगीत"), V("help", "मदद"),
    V("information", "जानकारी"), V("electricity", "बिजली"), V("furniture", "फ़र्नीचर"), V("traffic", "ट्रैफ़िक"),
    V("space", "जगह"), V("luck", "किस्मत"), V("advice", "सलाह"), V("paper", "काग़ज़"),
    V("wood", "लकड़ी"), V("garbage", "कचरा"), V("sand", "रेत"), V("petrol", "पेट्रोल"),
    V("noise", "शोर"), V("food", "खाना")
  ];
  const cnt = [
    V("books", "किताबें"), V("apples", "सेब"), V("friends", "दोस्त"), V("chairs", "कुर्सियाँ"),
    V("students", "छात्र"), V("questions", "सवाल"), V("mistakes", "गलतियाँ"), V("coins", "सिक्के"),
    V("flowers", "फूल"), V("tickets", "टिकट"), V("letters", "चिट्ठियाँ"), V("photos", "फ़ोटो"),
    V("cars", "कारें"), V("bottles", "बोतलें"), V("shops", "दुकानें"), V("phones", "फ़ोन"),
    V("windows", "खिड़कियाँ"), V("gardens", "बगीचे"), V("doctors", "डॉक्टर"), V("lessons", "पाठ"),
    V("cities", "शहर"), V("languages", "भाषाएँ"), V("plans", "योजनाएँ"), V("trees", "पेड़"),
    V("birds", "पक्षी"), V("roads", "सड़कें"), V("rooms", "कमरे"), V("fans", "पंखे"),
    V("papers", "काग़ज़"), V("countries", "देश")
  ];
  const slots = {
    u: unc.map((v) => VA(v[0], v[1], "", "much", "many,more,most,lots")),
    c: cnt.map((v) => VA(v[0], v[1], "", "many", "much,more,most,lots")),
    t: "@PAST"
  };
  cat("much-many", slots, [
    T("How ___ {u} do you need?", "तुम्हें कितना {u} चाहिए?", { blank: "u" }),
    T("How ___ {c} do you need?", "तुम्हें कितने {c} चाहिए?", { blank: "c" }),
    T("There is not ___ {u} left.", "बहुत कम {u} बचा है।", { blank: "u" }),
    T("There are not ___ {c} left.", "बहुत कम {c} बचे हैं।", { blank: "c" }),
    T("We did not buy ___ {u} {t}.", "हमने {t} ज़्यादा {u} नहीं लिया।", { blank: "u" }),
    T("We did not buy ___ {c} {t}.", "हमने {t} ज़्यादा {c} नहीं ख़रीदे।", { blank: "c" }),
    T("She does not want ___ {u} today.", "वह आज ज़्यादा {u} नहीं चाहती।", { blank: "u" }),
    T("She does not want ___ {c} today.", "वह आज ज़्यादा {c} नहीं चाहती।", { blank: "c" }),
    T("Do you have ___ {u} at home?", "क्या तुम्हारे घर {u} है?", { blank: "u" }),
    T("Do you have ___ {c} at home?", "क्या तुम्हारे घर {c} हैं?", { blank: "c" }),
    T("He does not have ___ {u} left.", "उसके पास ज़्यादा {u} नहीं बचा।", { blank: "u" }),
    T("He does not have ___ {c} left.", "उसके पास ज़्यादा {c} नहीं बचे।", { blank: "c" }),
    T("How ___ {u} is there?", "कितना {u} है?", { blank: "u" }),
    T("How ___ {c} are there?", "कितने {c} हैं?", { blank: "c" }),
    T("I do not have ___ {u} today.", "मेरे पास आज ज़्यादा {u} नहीं है।", { blank: "u" }),
    T("I do not have ___ {c} today.", "मेरे पास आज ज़्यादा {c} नहीं हैं।", { blank: "c" })
  ]);
}

// some / any
{
  const slots = {
    n: NOUNS.map((x) => VA(x.pl, x.plHi, "", "any", "some,every,each,much")),
    m: NOUNS.map((x) => VA(x.pl, x.plHi, "", "some", "any,every,each,many")),
    t: "@PAST"
  };
  cat("some-any", slots, [
    T("I don't have ___ {n}.", "मेरे पास {n} नहीं हैं।", { blank: "n" }),
    T("Do you have ___ {n}?", "क्या तुम्हारे पास {n} हैं?", { blank: "n" }),
    T("Did you see ___ {n}?", "क्या तुमने {n} देखीं?", { blank: "n" }),
    T("Do you want ___ {n}?", "क्या तुम {n} चाहते हो?", { blank: "n" }),
    T("Have you got ___ {n}?", "क्या तुम्हारे पास {n} हैं?", { blank: "n" }),
    T("Can I get ___ {n}?", "क्या मुझे {n} मिल सकती हैं?", { blank: "n" }),
    T("Did she buy ___ {n}?", "क्या उसने {n} ख़रीदीं?", { blank: "n" }),
    T("Are there ___ {n} left?", "क्या {n} बची हैं?", { blank: "n" }),
    T("Do they need ___ {n}?", "क्या उन्हें {n} चाहिए?", { blank: "n" }),
    T("We didn't see ___ {n} {t}.", "हमने {t} {n} नहीं देखीं।", { blank: "n" }),
    T("Did you buy ___ {n} {t}?", "क्या तुमने {t} {n} ख़रीदीं?", { blank: "n" }),
    T("There aren't ___ {n} in the shop.", "दुकान में {n} नहीं हैं।", { blank: "n" }),
    T("He didn't answer ___ {n}.", "उसने {n} का जवाब नहीं दिया।", { blank: "n" }),
    T("I have ___ {m} for you.", "मेरे पास तुम्हारे लिए {m} हैं।", { blank: "m" }),
    T("Would you like ___ {m}?", "क्या तुम {m} लोगे?", { blank: "m" }),
    T("I need ___ {m} today.", "मुझे आज {m} चाहिए।", { blank: "m" }),
    T("We found ___ {m} for the trip.", "हमें यात्रा के लिए {m} मिलीं।", { blank: "m" }),
    T("Give me ___ {m}, please.", "कृपया मुझे {m} दो।", { blank: "m" }),
    T("There are ___ {m} on the table.", "मेज़ पर {m} हैं।", { blank: "m" }),
    T("She bought ___ {m} {t}.", "उसने {t} {m} ख़रीदीं।", { blank: "m" }),
    T("I bought ___ {m} {t}.", "मैंने {t} {m} ख़रीदीं।", { blank: "m" }),
    T("Let's buy ___ {m} for the party.", "चलो पार्टी के लिए {m} ख़रीदते हैं।", { blank: "m" }),
    T("He gave me ___ {m}.", "उसने मुझे {m} दीं।", { blank: "m" })
  ]);
}

// =====================================================================
// Prepositions
// =====================================================================

// prepositions of place
{
  const things = [
    ["book", "किताब"], ["phone", "फ़ोन"], ["bag", "बस्ता"], ["cat", "बिल्ली"],
    ["dog", "कुत्ता"], ["cup", "कप"], ["ball", "गेंद"], ["pen", "कलम"],
    ["key", "चाबी"], ["bottle", "बोतल"], ["shoes", "जूते"], ["hat", "टोपी"],
    ["watch", "घड़ी"], ["camera", "कैमरा"], ["umbrella", "छाता"], ["laptop", "लैपटॉप"]
  ].map((x) => V(x[0], x[1]));
  const places = [
    ["table", "मेज़"], ["chair", "कुर्सी"], ["door", "दरवाज़ा"], ["house", "घर"],
    ["station", "स्टेशन"], ["mirror", "आईना"], ["box", "डिब्बा"], ["shelf", "ताक"],
    ["wall", "दीवार"], ["floor", "फ़र्श"], ["window", "खिड़की"], ["car", "कार"],
    ["tree", "पेड़"], ["roof", "छत"], ["gate", "गेट"], ["bridge", "पुल"],
    ["shop", "दुकान"], ["garden", "बगीचा"]
  ].map((x) => V("the " + x[0], x[1]));
  const preps = [
    VA("on", "पर", "पर", "on", "in,at,under,behind,near"),
    VA("under", "के नीचे", "के नीचे", "under", "on,above,in,behind,near"),
    VA("above", "के ऊपर", "के ऊपर", "above", "on,under,in,behind,near"),
    VA("behind", "के पीछे", "के पीछे", "behind", "on,under,in,above,near"),
    VA("near", "के पास", "के पास", "near", "on,under,in,behind,above"),
    VA("in front of", "के सामने", "के सामने", "in front of", "on,under,behind,above,near"),
    VA("beside", "के बग़ल में", "के बग़ल में", "beside", "on,under,behind,above,near"),
    VA("inside", "के अंदर", "के अंदर", "inside", "on,under,behind,outside,near"),
    VA("outside", "के बाहर", "के बाहर", "outside", "on,under,inside,behind,near"),
    VA("over", "के ऊपर", "के ऊपर", "over", "under,on,in,behind,near"),
    VA("next to", "के पास", "के पास", "next to", "on,under,in,behind,above"),
    VA("on top of", "के ऊपर", "के ऊपर", "on top of", "under,on,in,behind,near")
  ];
  const slots = { t: things, p: places, q: preps };
  cat("prep-place", slots, [
    T("The {t} is ___ {p}.", "{t} {p} {gap} है।", { blank: "q" }),
    T("The {t} is not ___ {p}.", "{t} {p} {gap} नहीं है।", { blank: "q" }),
    T("Is the {t} ___ {p}?", "क्या {t} {p} {gap} है?", { blank: "q" }),
    T("I think the {t} is ___ {p}.", "मुझे लगता है {t} {p} {gap} है।", { blank: "q" })
  ]);
}

// prepositions of time
{
  const x = [
    VA("Monday", "सोमवार", "को", "on", "in,at,for,since"),
    VA("Friday morning", "शुक्रवार की सुबह", "", "on", "in,at,for,since"),
    VA("the 5th of May", "पाँच मई", "को", "on", "in,at,for,since"),
    VA("my birthday", "मेरे जन्मदिन", "को", "on", "in,at,for,since"),
    VA("Sunday", "रविवार", "को", "on", "in,at,for,since"),
    VA("New Year's Day", "नए साल के दिन", "को", "on", "in,at,for,since"),
    VA("5 o'clock", "पाँच बजे", "", "at", "in,on,for,since"),
    VA("night", "रात", "", "at", "in,on,for,since"),
    VA("noon", "दोपहर", "", "at", "in,on,for,since"),
    VA("midnight", "आधी रात", "", "at", "in,on,for,since"),
    VA("lunchtime", "दोपहर के खाने के समय", "", "at", "in,on,for,since"),
    VA("6:30", "साढ़े छह बजे", "", "at", "in,on,for,since"),
    VA("1998", "1998", "में", "in", "on,at,for,since"),
    VA("December", "दिसंबर", "में", "in", "on,at,for,since"),
    VA("summer", "गर्मियों", "में", "in", "on,at,for,since"),
    VA("the morning", "सुबह", "", "in", "on,at,for,since"),
    VA("the evening", "शाम", "", "in", "on,at,for,since"),
    VA("the afternoon", "दोपहर", "", "in", "on,at,for,since"),
    VA("winter", "सर्दियों", "में", "in", "on,at,for,since"),
    VA("1947", "1947", "में", "in", "on,at,for,since"),
    VA("the 1990s", "1990 के दशक", "में", "in", "on,at,for,since"),
    VA("April", "अप्रैल", "में", "in", "on,at,for,since")
  ];
  const ev = [
    ["The meeting", "मीटिंग"], ["The party", "पार्टी"], ["The exam", "परीक्षा"],
    ["The interview", "इंटरव्यू"], ["The concert", "कॉन्सर्ट"], ["The match", "मैच"],
    ["The class", "क्लास"], ["The wedding", "शादी"], ["The conference", "सम्मेलन"],
    ["The doctor's appointment", "डॉक्टर का अपॉइंटमेंट"]
  ].map((v) => V(v[0], v[1]));
  const d = [
    VA("two hours", "दो घंटे", "", "for", "since,in,on,at"),
    VA("three days", "तीन दिन", "", "for", "since,in,on,at"),
    VA("a week", "एक हफ़्ता", "", "for", "since,in,on,at"),
    VA("many years", "कई साल", "", "for", "since,in,on,at"),
    VA("a long time", "बहुत देर", "", "for", "since,in,on,at"),
    VA("ten minutes", "दस मिनट", "", "for", "since,in,on,at"),
    VA("six months", "छह महीने", "", "for", "since,in,on,at"),
    VA("2015", "2015", "से", "since", "for,in,on,at"),
    VA("Monday", "सोमवार", "से", "since", "for,in,on,at"),
    VA("last year", "पिछले साल", "से", "since", "for,in,on,at"),
    VA("morning", "सुबह", "से", "since", "for,in,on,at"),
    VA("childhood", "बचपन", "से", "since", "for,in,on,at")
  ];
  const slots = { x, ev, d };
  cat("prep-time", slots, [
    T("{ev} is ___ {x}.", "{ev} {x} {gap} है।", { blank: "x" }),
    T("I will call you ___ {x}.", "मैं तुम्हें {x} {gap} फ़ोन करूँगा।", { blank: "x" }),
    T("We will meet ___ {x}.", "हम {x} {gap} मिलेंगे।", { blank: "x" }),
    T("They arrived ___ {x}.", "वे {x} {gap} पहुँचे।", { blank: "x" }),
    T("He works ___ {x}.", "वह {x} {gap} काम करता है।", { blank: "x" }),
    T("The train leaves ___ {x}.", "ट्रेन {x} {gap} निकलती है।", { blank: "x" }),
    T("I have lived here ___ {d}.", "मैं {d} {gap} यहाँ रहता हूँ।", { blank: "d" }),
    T("She has worked here ___ {d}.", "वह {d} {gap} यहाँ काम करती है।", { blank: "d" }),
    T("We have known each other ___ {d}.", "हम {d} {gap} एक-दूसरे को जानते हैं।", { blank: "d" }),
    T("He has been waiting ___ {d}.", "वह {d} {gap} इंतज़ार कर रहा है।", { blank: "d" }),
    T("I have been studying ___ {d}.", "मैं {d} {gap} पढ़ाई कर रहा हूँ।", { blank: "d" }),
    T("They have lived here ___ {d}.", "वे {d} {gap} यहाँ रहते हैं।", { blank: "d" }),
    T("I will see you ___ {x}.", "मैं तुम्हें {x} {gap} मिलूँगा।", { blank: "x" }),
    T("We arrived ___ {x}.", "हम {x} {gap} पहुँचे।", { blank: "x" }),
    T("The class starts ___ {x}.", "क्लास {x} {gap} शुरू होती है।", { blank: "x" }),
    T("She was born ___ {x}.", "वह {x} {gap} पैदा हुई।", { blank: "x" }),
    T("He left ___ {x}.", "वह {x} {gap} निकल गया।", { blank: "x" }),
    T("The shop closes ___ {x}.", "दुकान {x} {gap} बंद होती है।", { blank: "x" }),
    T("We met ___ {x}.", "हम {x} {gap} मिले।", { blank: "x" }),
    T("I have an exam ___ {x}.", "मेरी परीक्षा {x} {gap} है।", { blank: "x" }),
    T("Please be ready ___ {x} for {ev}.", "कृपया {ev} के लिए {x} {gap} तैयार रहें।", { blank: "x" }),
    T("We talked about {ev} ___ {x}.", "हमने {x} {gap} {ev} के बारे में बात की।", { blank: "x" })
  ]);
}

// prepositions of movement
{
  const subj = [
    ["she walked", "वह", "चली गई"], ["he walked", "वह", "चला गया"], ["they walked", "वे", "चले गए"],
    ["she ran", "वह", "दौड़ी"], ["he ran", "वह", "दौड़ा"], ["we ran", "हम", "दौड़े"],
    ["the dog ran", "कुत्ता", "भागा"], ["the cat jumped", "बिल्ली", "कूदी"],
    ["the boy walked", "लड़का", "चला गया"], ["the girl ran", "लड़की", "दौड़ी"],
    ["my friend walked", "मेरा दोस्त", "चला गया"], ["the children ran", "बच्चे", "दौड़े"],
    ["we walked", "हम", "चले"], ["they ran", "वे", "दौड़े"], ["the horse jumped", "घोड़ा", "कूदा"]
  ];
  const dest = [
    ["___ the room", "कमरे में", "में", "into", "in,on,at,of"],
    ["___ the house", "घर में", "में", "into", "in,on,at,of"],
    ["___ the water", "पानी में", "में", "into", "in,on,at,of"],
    ["___ the kitchen", "रसोई में", "में", "into", "in,on,at,of"],
    ["___ the park", "पार्क से होकर", "से होकर", "through", "in,of,on,at"],
    ["___ the forest", "जंगल से होकर", "से होकर", "through", "in,of,on,at"],
    ["___ the tunnel", "सुरंग से होकर", "से होकर", "through", "in,of,on,at"],
    ["___ the crowd", "भीड़ से होकर", "से होकर", "through", "in,of,on,at"],
    ["___ the bridge", "पुल के पार", "के पार", "across", "in,of,on,for"],
    ["___ the road", "सड़क के पार", "के पार", "across", "in,of,on,for"],
    ["___ the river", "नदी के पार", "के पार", "across", "in,of,on,for"],
    ["___ the field", "मैदान के पार", "के पार", "across", "in,of,on,for"],
    ["___ the river", "नदी के किनारे", "के किनारे", "along", "in,of,on,at"],
    ["___ the beach", "समुद्र तट के किनारे", "के किनारे", "along", "in,of,on,at"],
    ["___ the street", "सड़क के किनारे", "के किनारे", "along", "in,of,on,at"],
    ["___ the wall", "दीवार के किनारे", "के किनारे", "along", "in,of,on,at"],
    ["___ the office", "दफ़्तर से बाहर", "से बाहर", "out of", "in,on,of,at"],
    ["___ the shop", "दुकान से बाहर", "से बाहर", "out of", "in,on,of,at"],
    ["___ the car", "कार से बाहर", "से बाहर", "out of", "in,on,of,at"],
    ["___ the building", "इमारत से बाहर", "से बाहर", "out of", "in,on,of,at"],
    ["___ the station", "स्टेशन की ओर", "की ओर", "toward", "to,of,on,at"],
    ["___ the gate", "गेट की ओर", "की ओर", "toward", "to,of,on,at"],
    ["___ the hill", "पहाड़ी की ओर", "की ओर", "toward", "to,of,on,at"],
    ["___ the door", "दरवाज़े की ओर", "की ओर", "toward", "to,of,on,at"],
    ["___ the hill", "पहाड़ी पर", "पर", "up", "on,down,of,at"],
    ["___ the stairs", "सीढ़ियों पर", "पर", "up", "on,down,of,at"],
    ["___ the tree", "पेड़ के नीचे", "के नीचे", "under", "on,over,of,at"],
    ["___ the bridge", "पुल के नीचे", "के नीचे", "under", "on,over,of,at"],
    ["___ the lake", "झील के चारों ओर", "के चारों ओर", "around", "in,on,of,at"],
    ["___ the garden", "बगीचे के चारों ओर", "के चारों ओर", "around", "in,on,of,at"],
    ["___ the market", "बाज़ार के चारों ओर", "के चारों ओर", "around", "in,on,of,at"],
    ["___ the shop", "दुकान के पास से", "के पास से", "past", "to,in,of,at"],
    ["___ the school", "स्कूल के पास से", "के पास से", "past", "to,in,of,at"],
    ["___ the hospital", "अस्पताल के पास से", "के पास से", "past", "to,in,of,at"],
    ["___ the gate", "गेट के पास से", "के पास से", "past", "to,in,of,at"],
    ["___ the mountain", "पहाड़ के ऊपर", "के ऊपर", "over", "under,on,in,of"],
    ["___ the wall", "दीवार के ऊपर", "के ऊपर", "over", "under,on,in,of"],
    ["___ the hill", "पहाड़ी से नीचे", "से नीचे", "down", "up,on,of,at"],
    ["___ the stairs", "सीढ़ियों से नीचे", "से नीचे", "down", "up,on,of,at"]
  ];
  const vals = [];
  for (const s of subj) {
    for (const d of dest) {
      vals.push(VA(s[0] + " " + d[0], s[1] + " " + d[1] + " " + s[2], "", d[3], d[4]));
    }
  }
  cat("prep-movement", { c: vals }, [
    T("{c}.", "{c}।", { blank: "c" }),
    T("I think {c}.", "मुझे लगता है कि {c}।", { blank: "c" }),
    T("Did you see that {c}?", "क्या तुमने देखा कि {c}?", { blank: "c" }),
    T("Everyone saw that {c}.", "सबने देखा कि {c}।", { blank: "c" })
  ]);
}

// dependent prepositions
{
  const pairs = [
    ["proud ___ my son", "अपने बेटे पर गर्व", "पर", "of", "for,at,on"],
    ["afraid ___ dogs", "कुत्तों से डर", "से", "of", "from,with,at"],
    ["good ___ English", "अंग्रेज़ी में अच्छा", "में", "at", "in,on,for"],
    ["interested ___ music", "संगीत में रुचि", "में", "in", "on,at,for"],
    ["ready ___ the exam", "परीक्षा के लिए तैयार", "के लिए", "for", "to,at,on"],
    ["worried ___ my health", "अपनी सेहत की चिंता", "की", "about", "for,on,at"],
    ["married ___ Priya", "प्रिया से शादीशुदा", "से", "to", "with,for,at"],
    ["famous ___ its food", "अपने खाने के लिए प्रसिद्ध", "के लिए", "for", "of,at,in"],
    ["different ___ mine", "मेरे से अलग", "से", "from", "of,than,to"],
    ["dependent ___ my parents", "अपने माता-पिता पर निर्भर", "पर", "on", "in,of,at"],
    ["full ___ water", "पानी से भरा", "से", "of", "with,from,at"],
    ["late ___ school", "स्कूल से देर", "से", "for", "to,of,at"],
    ["sorry ___ the mistake", "गलती के लिए माफ़ी", "के लिए", "for", "of,at,to"],
    ["angry ___ me", "मुझ पर गुस्सा", "पर", "with", "on,at,for"],
    ["pleased ___ my work", "अपने काम से ख़ुश", "से", "with", "of,on,at"],
    ["bad ___ maths", "गणित में कमज़ोर", "में", "at", "in,of,on"],
    ["keen ___ sports", "खेलों के शौक़ीन", "के", "on", "in,of,at"],
    ["similar ___ yours", "तुम्हारे जैसा", "जैसा", "to", "with,like,of"],
    ["responsible ___ the money", "पैसों के लिए ज़िम्मेदार", "के लिए", "for", "of,to,at"],
    ["surprised ___ the news", "ख़बर से हैरान", "से", "by", "with,of,at"],
    ["good ___ drawing", "चित्र बनाने में अच्छा", "में", "at", "in,on,for"],
    ["proud ___ my work", "अपने काम पर गर्व", "पर", "of", "for,at,on"],
    ["afraid ___ the dark", "अंधेरे से डर", "से", "of", "from,with,at"],
    ["interested ___ English", "अंग्रेज़ी में रुचि", "में", "in", "on,at,for"],
    ["worried ___ the result", "नतीजे की चिंता", "की", "about", "for,on,at"],
    ["excited ___ the trip", "यात्रा के लिए उत्साहित", "के लिए", "about", "for,of,on"],
    ["famous ___ his songs", "अपने गानों के लिए प्रसिद्ध", "के लिए", "for", "of,at,in"],
    ["ready ___ the interview", "इंटरव्यू के लिए तैयार", "के लिए", "for", "to,at,on"],
    ["angry ___ my brother", "अपने भाई पर गुस्सा", "पर", "with", "on,at,for"],
    ["pleased ___ the result", "नतीजे से ख़ुश", "से", "with", "of,on,at"],
    ["good ___ cricket", "क्रिकेट में अच्छा", "में", "at", "in,on,for"],
    ["dependent ___ my family", "अपने परिवार पर निर्भर", "पर", "on", "in,of,at"],
    ["different ___ yours", "तुम्हारे से अलग", "से", "from", "of,than,to"],
    ["full ___ people", "लोगों से भरा", "से", "of", "with,from,at"],
    ["late ___ work", "काम से देर", "से", "for", "to,of,at"],
    ["sorry ___ the delay", "देरी के लिए माफ़ी", "के लिए", "for", "of,at,to"],
    ["keen ___ music", "संगीत के शौक़ीन", "के", "on", "in,of,at"],
    ["similar ___ his", "उसके जैसा", "जैसा", "to", "with,like,of"],
    ["responsible ___ the team", "टीम के लिए ज़िम्मेदार", "के लिए", "for", "of,to,at"],
    ["proud ___ my country", "अपने देश पर गर्व", "पर", "of", "for,at,on"],
    ["afraid ___ heights", "ऊँचाई से डर", "से", "of", "from,with,at"],
    ["good ___ cooking", "खाना बनाने में अच्छा", "में", "at", "in,on,for"],
    ["interested ___ history", "इतिहास में रुचि", "में", "in", "on,at,for"],
    ["famous ___ its tea", "अपनी चाय के लिए प्रसिद्ध", "के लिए", "for", "of,at,in"]
  ];
  const subjects = [
    V("I am", "मुझे"), V("He is", "उसे"), V("She is", "उसे"), V("We are", "हमें"),
    V("They are", "उन्हें"), V("My brother is", "मेरे भाई को"), V("My sister is", "मेरी बहन को"),
    V("Ravi is", "रवि को"), V("The teacher is", "शिक्षक को"), V("My parents are", "मेरे माता-पिता को"),
    V("My friends are", "मेरे दोस्तों को"), V("Everyone is", "सबको")
  ];
  const slots = {
    s: subjects,
    p: pairs.map((x) => VA(x[0], x[1], x[2], x[3], x[4]))
  };
  cat("prep-dependent", slots, [
    T("{s} {p}.", "{s} {p} है।", { blank: "p" }),
    T("{s} not {p}.", "{s} {p} नहीं है।", { blank: "p" })
  ]);
}

// =====================================================================
// Sentences & style
// =====================================================================

// comparatives
{
  const adj = [
    ["heavier", "heavy", "heaviest", "भारी"], ["taller", "tall", "tallest", "लंबा"], ["warmer", "warm", "warmest", "गर्म"],
    ["cheaper", "cheap", "cheapest", "सस्ता"], ["faster", "fast", "fastest", "तेज़"], ["older", "old", "oldest", "पुराना"],
    ["younger", "young", "youngest", "छोटा"], ["bigger", "big", "biggest", "बड़ा"], ["stronger", "strong", "strongest", "मज़बूत"],
    ["cleaner", "clean", "cleanest", "साफ़"], ["easier", "easy", "easiest", "आसान"], ["happier", "happy", "happiest", "ख़ुश"],
    ["smaller", "small", "smallest", "छोटा"], ["newer", "new", "newest", "नया"], ["safer", "safe", "safest", "सुरक्षित"],
    ["slower", "slow", "slowest", "धीमा"], ["busier", "busy", "busiest", "व्यस्त"], ["dirtier", "dirty", "dirtiest", "गंदा"],
    ["more beautiful", "beautiful", "most beautiful", "सुंदर"], ["more expensive", "expensive", "most expensive", "महँगा"],
    ["more interesting", "interesting", "most interesting", "रोचक"], ["more difficult", "difficult", "most difficult", "मुश्किल"],
    ["more comfortable", "comfortable", "most comfortable", "आरामदायक"], ["more popular", "popular", "most popular", "लोकप्रिय"],
    ["more careful", "careful", "most careful", "सावधान"], ["better", "good", "best", "अच्छा"], ["worse", "bad", "worst", "ख़राब"],
    ["further", "far", "furthest", "दूर"]
  ];
  const slots = {
    a: adj.map((x) => VA(x[0], x[3], x[3], x[0], [x[1], x[2], "more " + x[1]].join(","))),
    n: NOUNS.map((x) => V(x.en, x.hi))
  };
  cat("comparatives", slots, [
    T("This {n} is ___ than that one.", "यह {n} उससे ज़्यादा {gap} है।", { blank: "a" }),
    T("My {n} is ___ than yours.", "मेरा {n} तुम्हारे से ज़्यादा {gap} है।", { blank: "a" }),
    T("Today is ___ than yesterday.", "आज कल से ज़्यादा {gap} है।", { blank: "a" }),
    T("This {n} looks ___ than the old one.", "यह {n} पुराने से ज़्यादा {gap} लगता है।", { blank: "a" }),
    T("I think this {n} is ___ than that one.", "मुझे लगता है यह {n} उससे ज़्यादा {gap} है।", { blank: "a" }),
    T("This {n} is much ___ than I thought.", "यह {n} मेरी सोच से कहीं ज़्यादा {gap} है।", { blank: "a" }),
    T("Her {n} is ___ than mine.", "उसका {n} मेरे से ज़्यादा {gap} है।", { blank: "a" })
  ]);
}

// superlatives
{
  const adj = [
    ["the heaviest", "heavy", "heavier", "सबसे भारी"], ["the tallest", "tall", "taller", "सबसे लंबा"],
    ["the cheapest", "cheap", "cheaper", "सबसे सस्ता"], ["the fastest", "fast", "faster", "सबसे तेज़"],
    ["the oldest", "old", "older", "सबसे पुराना"], ["the youngest", "young", "younger", "सबसे छोटा"],
    ["the biggest", "big", "bigger", "सबसे बड़ा"], ["the strongest", "strong", "stronger", "सबसे मज़बूत"],
    ["the cleanest", "clean", "cleaner", "सबसे साफ़"], ["the easiest", "easy", "easier", "सबसे आसान"],
    ["the happiest", "happy", "happier", "सबसे ख़ुश"], ["the smallest", "small", "smaller", "सबसे छोटा"],
    ["the newest", "new", "newer", "सबसे नया"], ["the safest", "safe", "safer", "सबसे सुरक्षित"],
    ["the slowest", "slow", "slower", "सबसे धीमा"], ["the busiest", "busy", "busier", "सबसे व्यस्त"],
    ["the most beautiful", "beautiful", "more beautiful", "सबसे सुंदर"],
    ["the most expensive", "expensive", "more expensive", "सबसे महँगा"],
    ["the most interesting", "interesting", "more interesting", "सबसे रोचक"],
    ["the most difficult", "difficult", "more difficult", "सबसे मुश्किल"],
    ["the most comfortable", "comfortable", "more comfortable", "सबसे आरामदायक"],
    ["the most popular", "popular", "more popular", "सबसे लोकप्रिय"],
    ["the best", "good", "better", "सबसे अच्छा"], ["the worst", "bad", "worse", "सबसे ख़राब"]
  ];
  const slots = {
    a: adj.map((x) => VA(x[0], x[3], x[3], x[0], [x[2], x[1], "most " + x[1]].join(","))),
    n: NOUNS.map((x) => V(x.en, x.hi))
  };
  cat("superlatives", slots, [
    T("This is ___ {n} in the shop.", "यह दुकान का {gap} {n} है।", { blank: "a" }),
    T("He is ___ {n} in the class.", "वह कक्षा का {gap} {n} है।", { blank: "a" }),
    T("It was ___ day of my life.", "वह मेरी ज़िंदगी का {gap} दिन था।", { blank: "a" }),
    T("This is ___ {n} I have ever seen.", "यह अब तक देखा {gap} {n} है।", { blank: "a" }),
    T("She is ___ girl in the family.", "वह परिवार की {gap} लड़की है।", { blank: "a" }),
    T("That was ___ {n} of the trip.", "वह यात्रा का {gap} {n} था।", { blank: "a" })
  ]);
}

// wh-questions
{
  const x = [
    ["station", "स्टेशन"], ["market", "बाज़ार"], ["office", "दफ़्तर"], ["park", "पार्क"],
    ["shop", "दुकान"], ["school", "स्कूल"], ["hospital", "अस्पताल"], ["airport", "हवाई अड्डा"],
    ["library", "पुस्तकालय"], ["temple", "मंदिर"], ["bus stop", "बस स्टॉप"]
  ].map((v) => V(v[0], v[1]));
  const people = [
    ["the teacher", "शिक्षक"], ["the doctor", "डॉक्टर"], ["the boy", "लड़का"], ["the girl", "लड़की"],
    ["your father", "तुम्हारे पिता"], ["your mother", "तुम्हारी माँ"], ["your brother", "तुम्हारा भाई"],
    ["your sister", "तुम्हारी बहन"], ["Ravi", "रवि"], ["Priya", "प्रिया"], ["the driver", "ड्राइवर"],
    ["the farmer", "किसान"], ["the shopkeeper", "दुकानदार"], ["the student", "छात्र"], ["the nurse", "नर्स"],
    ["the policeman", "पुलिसकर्मी"]
  ].map((v) => V(v[0], v[1]));
  const n = NOUNS.map((v) => V(v.en, v.hi));
  const np = NOUNS.map((v) => V(v.pl, v.plHi));
  const na = NOUNS.slice(0, 10).map((v) => V(v.en, v.hi));
  const nb = NOUNS.slice(10).map((v) => V(v.en, v.hi));
  const slots = { x, pp: people, n, np, na, nb };
  cat("wh-questions", slots, [
    T("___ is the {x}?", "{x} कहाँ है?", { ans: "Where", wrongs: "What,Who,When" }),
    T("___ can I find the {x}?", "मुझे {x} कहाँ मिलेगा?", { ans: "Where", wrongs: "What,Who,Why" }),
    T("___ will you go to the {x}?", "तुम {x} कब जाओगे?", { ans: "When", wrongs: "What,Who,Where" }),
    T("___ long does it take to get to the {x}?", "{x} पहुँचने में कितना समय लगता है?", { ans: "How long", wrongs: "How many,How much,How far" }),
    T("___ often do you go to the {x}?", "तुम {x} कितनी बार जाते हो?", { ans: "How often", wrongs: "How many,How much,How long" }),
    T("___ far is the {x} from here?", "यहाँ से {x} कितना दूर है?", { ans: "How far", wrongs: "How long,How many,How much" }),
    T("___ do you go to the {x}?", "तुम {x} कैसे जाते हो?", { ans: "How", wrongs: "What,Who,Where" }),
    T("___ is {pp}?", "वह {pp} कौन है?", { ans: "Who", wrongs: "What,Where,Whose" }),
    T("___ does {pp} live?", "{pp} कहाँ रहते हैं?", { ans: "Where", wrongs: "What,Who,When" }),
    T("___ is {pp} crying?", "{pp} क्यों रो रहे हैं?", { ans: "Why", wrongs: "What,Who,Where" }),
    T("___ did {pp} come late?", "{pp} देर से क्यों आए?", { ans: "Why", wrongs: "What,Who,How" }),
    T("___ old is {pp}?", "{pp} कितने साल के हैं?", { ans: "How", wrongs: "What,Who,When" }),
    T("___ will {pp} arrive?", "{pp} कब आएँगे?", { ans: "When", wrongs: "What,Who,Where" }),
    T("___ did {pp} say that?", "{pp} ने ऐसा क्यों कहा?", { ans: "Why", wrongs: "What,Who,When" }),
    T("___ is {pp} from?", "{pp} कहाँ से हैं?", { ans: "Where", wrongs: "What,Who,When" }),
    T("___ do you know {pp}?", "तुम {pp} को कैसे जानते हो?", { ans: "How", wrongs: "What,Who,Where" }),
    T("___ do you like about {pp}?", "तुम्हें {pp} में क्या पसंद है?", { ans: "What", wrongs: "Who,Which,Where" }),
    T("___ is the {n}?", "{n} कहाँ है?", { ans: "Where", wrongs: "What,Who,When" }),
    T("___ does this {n} cost?", "यह {n} कितने का है?", { ans: "How much", wrongs: "How many,How,What" }),
    T("___ did you buy this {n}?", "तुमने यह {n} क्यों ख़रीदा?", { ans: "Why", wrongs: "What,Who,How" }),
    T("___ is the price of this {n}?", "इस {n} की कीमत क्या है?", { ans: "What", wrongs: "Who,Where,Whose" }),
    T("___ do you use this {n} for?", "तुम इस {n} का इस्तेमाल किसलिए करते हो?", { ans: "What", wrongs: "Who,Which,Where" }),
    T("___ is this {n} made of?", "इस {n} को किस चीज़ से बनाया जाता है?", { ans: "What", wrongs: "Who,Which,Where" }),
    T("___ {np} do you have?", "तुम्हारे पास कितने {np} हैं?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} are there on the table?", "मेज़ पर कितने {np} हैं?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} do you want?", "तुम्हें कितने {np} चाहिए?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} did you buy?", "तुमने कितने {np} ख़रीदे?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} are in the box?", "डिब्बे में कितने {np} हैं?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} does she have?", "उसके पास कितने {np} हैं?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ {np} are left?", "कितने {np} बचे हैं?", { ans: "How many", wrongs: "How much,How,What" }),
    T("___ one do you want, the {na} or the {nb}?", "तुम कौन-सा चाहते हो, {na} या {nb}?", { ans: "Which", wrongs: "What,Who,Whose" }),
    T("___ do you like, the {na} or the {nb}?", "तुम्हें कौन-सा पसंद है, {na} या {nb}?", { ans: "Which", wrongs: "What,Who,Whose" }),
    T("___ is your name?", "तुम्हारा नाम क्या है?", { ans: "What", wrongs: "Who,Where,When" }),
    T("___ do you live?", "तुम कहाँ रहते हो?", { ans: "Where", wrongs: "What,Who,Why" }),
    T("___ are you crying?", "तुम क्यों रो रहे हो?", { ans: "Why", wrongs: "What,Who,How" }),
    T("___ do you go to school?", "तुम स्कूल कैसे जाते हो?", { ans: "How", wrongs: "What,Who,Where" }),
    T("___ is your birthday?", "तुम्हारा जन्मदिन कब है?", { ans: "When", wrongs: "What,Who,Where" }),
    T("___ old are you?", "तुम कितने साल के हो?", { ans: "How", wrongs: "What,Who,When" }),
    T("___ book is this?", "यह किसकी किताब है?", { ans: "Whose", wrongs: "Who,Which,What" }),
    T("___ pen is this?", "यह किसकी कलम है?", { ans: "Whose", wrongs: "Who,Which,What" }),
    T("___ colour do you like?", "तुम्हें कौन-सा रंग पसंद है?", { ans: "Which", wrongs: "What,Who,Whose" }),
    T("___ are you doing?", "तुम क्या कर रहे हो?", { ans: "What", wrongs: "Who,Where,When" }),
    T("___ time is it?", "कितने बजे हैं?", { ans: "What", wrongs: "Which,Who,When" }),
    T("___ is your teacher?", "तुम्हारे शिक्षक कौन हैं?", { ans: "Who", wrongs: "What,Where,Whose" }),
    T("___ do you get up?", "तुम कितने बजे उठते हो?", { ans: "When", wrongs: "What,Who,Where" }),
    T("___ do you live with?", "तुम किसके साथ रहते हो?", { ans: "Who", wrongs: "What,Where,Which" }),
    T("___ did you come here?", "तुम यहाँ क्यों आए?", { ans: "Why", wrongs: "What,Who,When" }),
    T("___ will you finish?", "तुम कब ख़त्म करोगे?", { ans: "When", wrongs: "What,Who,Where" }),
    T("___ can I help you?", "मैं तुम्हारी कैसे मदद कर सकता हूँ?", { ans: "How", wrongs: "What,Who,Why" })
  ]);
}

// conjunctions
{
  const a = [
    ["I was tired", "मैं थका था"], ["it was raining", "बारिश हो रही थी"], ["she studied hard", "उसने कड़ी मेहनत की"],
    ["I waited for an hour", "मैंने एक घंटा इंतज़ार किया"], ["he was late", "वह देर से आया"], ["the shop was closed", "दुकान बंद थी"],
    ["I was hungry", "मुझे भूख लगी थी"], ["she was sad", "वह उदास थी"], ["it was very late", "बहुत देर हो गई थी"],
    ["I called him twice", "मैंने उसे दो बार फ़ोन किया"], ["he works hard", "वह मेहनत करता है"], ["the food was cold", "खाना ठंडा था"],
    ["I had no money", "मेरे पास पैसे नहीं थे"], ["she speaks softly", "वह धीरे बोलती है"], ["we reached early", "हम जल्दी पहुँचे"],
    ["the bus was full", "बस भरी हुई थी"], ["my head was hurting", "मेरा सिर दुख रहा था"], ["he had no ticket", "उसके पास टिकट नहीं था"],
    ["the teacher was strict", "शिक्षक सख़्त थे"], ["I forgot my keys", "मैं अपनी चाबियाँ भूल गया"]
  ];
  const b = [
    ["I went to bed", "मैं सो गया"], ["we stayed home", "हम घर रहे"], ["he passed the exam", "वह परीक्षा पास हुआ"],
    ["he never came", "वह कभी नहीं आया"], ["I missed the bus", "मैं बस से चूक गया"], ["I found another one", "मुझे दूसरी मिल गई"],
    ["I made dinner", "मैंने खाना बनाया"], ["she kept working", "वह काम करती रही"], ["we went home", "हम घर गए"],
    ["he did not answer", "उसने जवाब नहीं दिया"], ["we waited outside", "हम बाहर इंतज़ार करते रहे"], ["I finished it later", "मैंने इसे बाद में पूरा किया"],
    ["she smiled", "वह मुस्कुराई"], ["we took a taxi", "हमने टैक्सी ली"], ["nobody complained", "किसी ने शिकायत नहीं की"],
    ["we walked home", "हम पैदल घर गए"], ["I took some medicine", "मैंने दवा ली"], ["he bought a new one", "उसने नई ख़रीदी"],
    ["we studied together", "हमने साथ पढ़ाई की"], ["she found them", "उसे वे मिल गईं"]
  ];
  const slots = {
    a: a.map((v) => V(v[0], v[1])),
    b: b.map((v) => V(v[0], v[1])),
    c: [
      VA("so", "इसलिए", "इसलिए", "so", "because,but,although,or"),
      VA("but", "लेकिन", "लेकिन", "but", "because,so,although,or"),
      VA("because", "क्योंकि", "क्योंकि", "because", "but,so,although,or"),
      VA("although", "हालाँकि", "हालाँकि", "although", "because,but,so,or"),
      VA("or", "या", "या", "or", "because,but,so,and"),
      VA("and", "और", "और", "and", "because,but,so,or")
    ],
    cf: [
      VA("Because", "क्योंकि", "क्योंकि", "Because", "Although,So,But,Or"),
      VA("Although", "हालाँकि", "हालाँकि", "Although", "Because,So,But,Or")
    ]
  };
  cat("conjunctions", slots, [
    T("{a}, ___ {b}.", "{a}, {gap} {b}।", { blank: "c" }),
    T("___ {a}, {b}.", "{gap} {a}, {b}।", { blank: "cf" })
  ]);
}

// conditionals
{
  const a = [
    ["it rains", "बारिश होती है"], ["you study hard", "तुम मेहनत करते हो"], ["she comes early", "वह जल्दी आती है"],
    ["we leave now", "हम अब निकलते हैं"], ["he calls me", "वह मुझे फ़ोन करता है"], ["they help us", "वे हमारी मदद करते हैं"],
    ["I get time", "मुझे समय मिलता है"], ["the bus is late", "बस देर से आती है"], ["you are free", "तुम ख़ाली हो"],
    ["it is sunny", "धूप होती है"], ["he tries again", "वह फिर कोशिश करता है"], ["we save money", "हम पैसे बचाते हैं"],
    ["she reads daily", "वह रोज़ पढ़ती है"], ["the shop opens", "दुकान खुलती है"], ["you ask nicely", "तुम प्यार से माँगते हो"],
    ["I find a job", "मुझे नौकरी मिलती है"], ["they arrive today", "वे आज पहुँचते हैं"], ["he works harder", "वह ज़्यादा मेहनत करता है"],
    ["we start early", "हम जल्दी शुरू करते हैं"], ["it stops raining", "बारिश रुकती है"]
  ];
  const b = [
    ["stay home", "घर रहेंगे"], ["pass the exam", "परीक्षा पास करेंगे"], ["start early", "जल्दी शुरू करेंगे"],
    ["go to the park", "पार्क जाएँगे"], ["call you", "तुम्हें फ़ोन करेंगे"], ["finish the work", "काम ख़त्म करेंगे"],
    ["buy a new one", "नया ख़रीदेंगे"], ["come with you", "तुम्हारे साथ आएँगे"], ["watch a film", "फ़िल्म देखेंगे"],
    ["meet you there", "वहाँ मिलेंगे"], ["eat outside", "बाहर खाएँगे"], ["take a taxi", "टैक्सी लेंगे"],
    ["wait here", "यहाँ इंतज़ार करेंगे"], ["help your mother", "तुम्हारी माँ की मदद करेंगे"], ["learn quickly", "जल्दी सीखेंगे"],
    ["save some money", "कुछ पैसे बचाएँगे"], ["visit Delhi", "दिल्ली जाएँगे"], ["study together", "साथ पढ़ेंगे"],
    ["buy tickets", "टिकट ख़रीदेंगे"], ["send you a photo", "तुम्हें फ़ोटो भेजेंगे"]
  ];
  const slots = {
    a: a.map((v) => V(v[0], v[1])),
    b: b.map((v) => V(v[0], v[1]))
  };
  cat("conditionals", slots, [
    T("If {a}, we ___ {b}.", "अगर {a}, तो हम {b}।", { ans: "will", wrongs: "would,are,did,have" }),
    T("If {a}, I ___ {b}.", "अगर {a}, तो मैं {b}।", { ans: "will", wrongs: "would,is,does,have" }),
    T("If {a}, she ___ {b}.", "अगर {a}, तो वह {b}।", { ans: "will", wrongs: "would,is,does,have" }),
    T("If it ___ tomorrow, we will stay home.", "अगर कल बारिश हुई, तो हम घर रहेंगे।", { ans: "rains", wrongs: "rain,rained,will rain" }),
    T("If I ___ you, I would take the job.", "अगर मैं तुम होता, तो नौकरी ले लेता।", { ans: "were", wrongs: "am,was,will be,is" }),
    T("I would buy a house if I ___ enough money.", "अगर मेरे पास काफ़ी पैसे होते, मैं घर ख़रीदता।", { ans: "had", wrongs: "have,has,will have" }),
    T("If she ___ earlier, she would have caught the train.", "अगर वह जल्दी निकली होती, ट्रेन पकड़ लेती।", { ans: "had left", wrongs: "left,has left,leaves" }),
    T("She will call you if she ___ any news.", "अगर उसे कोई ख़बर मिलेगी, वह तुम्हें फ़ोन करेगी।", { ans: "gets", wrongs: "get,got,will get" })
  ]);
}

// passive voice
{
  const objs = [
    ["the letter", "चिट्ठी", "f"], ["the house", "घर", "m"], ["the window", "खिड़की", "f"], ["the car", "कार", "f"],
    ["the book", "किताब", "f"], ["the song", "गाना", "m"], ["the cake", "केक", "m"], ["the door", "दरवाज़ा", "m"],
    ["the photo", "फ़ोटो", "f"], ["the shirt", "कमीज़", "f"], ["the phone", "फ़ोन", "m"], ["the chair", "कुर्सी", "f"],
    ["these books", "ये किताबें", "p"], ["these cakes", "ये केक", "p"], ["the results", "नतीजे", "p"], ["the flowers", "फूल", "p"]
  ];
  const verbs = [
    ["sent", "भेजी", "भेजा", "भेजे"], ["bought", "ख़रीदी", "ख़रीदा", "ख़रीदे"], ["sold", "बेची", "बेचा", "बेचे"],
    ["found", "ढूँढी", "ढूँढा", "ढूँढे"], ["cleaned", "साफ़ की", "साफ़ किया", "साफ़ किए"], ["made", "बनाई", "बनाया", "बनाए"],
    ["opened", "खोली", "खोला", "खोले"], ["watched", "देखी", "देखा", "देखे"]
  ];
  const pastT = [
    ["yesterday", "कल"], ["last week", "पिछले हफ़्ते"], ["last night", "कल रात"], ["two days ago", "दो दिन पहले"],
    ["last month", "पिछले महीने"], ["last year", "पिछले साल"], ["this morning", "आज सुबह"], ["on Monday", "सोमवार को"]
  ];
  const freqT = [
    ["every day", "हर रोज़"], ["every morning", "हर सुबह"], ["every week", "हर हफ़्ते"], ["every year", "हर साल"],
    ["in this shop", "इस दुकान में"], ["at home", "घर पर"], ["on Sundays", "रविवार को"], ["at school", "स्कूल में"]
  ];
  const vals = [];
  for (const o of objs) {
    const vi = o[2] === "p" ? 3 : o[2] === "f" ? 1 : 2;
    for (const v of verbs) {
      for (const t of pastT) {
        vals.push(VA(o[0] + " ___ " + v[0] + " " + t[0], o[1] + " " + t[1] + " " + v[vi] + " " + (o[2] === "p" ? "गए" : o[2] === "f" ? "गई" : "गया") + "।", "", o[2] === "p" ? "were" : "was", "were,is,are,has"));
      }
      for (const t of freqT) {
        vals.push(VA(o[0] + " ___ " + v[0] + " " + t[0], o[1] + " " + t[1] + " " + v[vi] + " " + (o[2] === "p" ? "जाते हैं" : o[2] === "f" ? "जाती है" : "जाता है") + "।", "", o[2] === "p" ? "are" : "is", "is,are,was,were"));
      }
    }
  }
  cat("passive", { p: vals }, [
    T("{p}.", "{p}", { blank: "p" }),
    T("I think {p}.", "मुझे लगता है {p}", { blank: "p" }),
    T("Do you know that {p}?", "क्या तुम जानते हो कि {p}?", { blank: "p" })
  ]);
}

// reported speech
{
  const s = [
    ["He", "उसने"], ["She", "उसने"], ["They", "उन्होंने"], ["Ravi", "रवि ने"],
    ["My father", "मेरे पिता ने"], ["My mother", "मेरी माँ ने"], ["The teacher", "शिक्षक ने"], ["My friend", "मेरे दोस्त ने"]
  ].map((v) => V(v[0], v[1]));
  const rep = [
    VA("he ___ tired", "वह थका", "था", "was", "is,were,am"),
    VA("she ___ busy", "वह व्यस्त", "थी", "was", "is,were,am"),
    VA("they ___ late", "वे देर से", "थे", "were", "was,is,are"),
    VA("he ___ a doctor", "वह डॉक्टर", "था", "was", "is,were,am"),
    VA("she ___ coming", "वह आ रही", "थी", "was", "is,were,am"),
    VA("they ___ at home", "वे घर", "थे", "were", "was,is,are"),
    VA("he ___ finished the work", "उसने काम पूरा किया", "था", "had", "has,have,was"),
    VA("she ___ gone to the party", "वह पार्टी गई", "थी", "had", "has,have,was"),
    VA("they ___ seen the film", "उन्होंने फ़िल्म देखी", "थी", "had", "has,have,were"),
    VA("he ___ call me later", "वह बाद में फ़ोन करेगा", "", "would", "will,would to,is"),
    VA("she ___ help us", "वह हमारी मदद करेगी", "", "would", "will,would to,does"),
    VA("he ___ speak English", "वह अंग्रेज़ी बोल", "सकता", "could", "can,could to,will"),
    VA("she ___ drive a car", "वह गाड़ी चला", "सकती", "could", "can,could to,will"),
    VA("he ___ not come", "वह नहीं आ", "सका", "could", "can,will,does"),
    VA("they ___ win the match", "वे मैच जीत", "सकते", "could", "can,will,would to"),
    VA("he ___ working there", "वह वहाँ काम कर रहा", "था", "was", "is,were,am"),
    VA("she ___ waiting outside", "वह बाहर इंतज़ार कर रही", "थी", "was", "is,were,am"),
    VA("he ___ already left", "वह पहले ही जा चुका", "था", "had", "has,have,was"),
    VA("she ___ never been there", "वह कभी वहाँ नहीं गई", "थी", "had", "has,have,was"),
    VA("they ___ going to come", "वे आने वाले", "थे", "were", "was,is,are"),
    VA("he ___ very happy", "वह बहुत ख़ुश", "था", "was", "is,were,am")
  ];
  const slots = { s, rep };
  cat("reported-speech", slots, [
    T("{s} said {rep}.", "{s} कहा कि {rep} {gap}।", { blank: "rep" }),
    T("{s} told me {rep}.", "{s} मुझे बताया कि {rep} {gap}।", { blank: "rep" }),
    T("Did {s} say {rep}?", "क्या {s} कहा कि {rep} {gap}?", { blank: "rep" }),
    T("I think {rep}.", "मुझे लगता है कि {rep} {gap}।", { blank: "rep" }),
    T("I heard that {rep}.", "मैंने सुना कि {rep} {gap}।", { blank: "rep" }),
    T("Did {s} tell you that {rep}?", "क्या {s} ने तुम्हें बताया कि {rep} {gap}?", { blank: "rep" }),
    T("{s} did not say {rep}.", "{s} ने नहीं कहा कि {rep} {gap}।", { blank: "rep" }),
    T("Everyone knows {rep}.", "सब जानते हैं कि {rep} {gap}।", { blank: "rep" }),
    T("It is true that {rep}.", "यह सच है कि {rep} {gap}।", { blank: "rep" }),
    T("I do not think {rep}.", "मुझे नहीं लगता कि {rep} {gap}।", { blank: "rep" }),
    T("I wonder if {rep}.", "मुझे आश्चर्य है कि {rep} {gap}।", { blank: "rep" }),
    T("{s} said that {rep}.", "{s} ने कहा कि {rep} {gap}।", { blank: "rep" })
  ]);
}

// relative clauses
{
  const mPeople = [["the man", "वह आदमी"], ["the boy", "वह लड़का"], ["my brother", "मेरा भाई"], ["the doctor", "वह डॉक्टर"]];
  const fPeople = [["the woman", "वह महिला"], ["the girl", "वह लड़की"], ["my sister", "मेरी बहन"], ["the teacher", "वह शिक्षिका"]];
  const mPreds = [
    ["___ lives next door is a doctor", "जो पड़ोस में रहता है वह डॉक्टर है", "who", "which,whose,whom"],
    ["___ helped me is my brother", "जिसने मेरी मदद की वह मेरा भाई है", "who", "which,whose,whom"],
    ["___ wrote this letter is a teacher", "जिसने यह चिट्ठी लिखी वह शिक्षक है", "who", "which,whose,whom"],
    ["___ is standing there is my friend", "जो वहाँ खड़ा है वह मेरा दोस्त है", "who", "which,whose,whom"],
    ["___ sold me this car is a driver", "जिसने मुझे यह कार बेची वह ड्राइवर है", "who", "which,whose,whom"],
    ["___ father is a doctor is my friend", "जिसके पिता डॉक्टर हैं वह मेरा दोस्त है", "whose", "who,which,whom"]
  ];
  const fPreds = [
    ["___ lives next door is a doctor", "जो पड़ोस में रहती है वह डॉक्टर है", "who", "which,whose,whom"],
    ["___ helped me is my sister", "जिसने मेरी मदद की वह मेरी बहन है", "who", "which,whose,whom"],
    ["___ wrote this letter is a teacher", "जिसने यह चिट्ठी लिखी वह शिक्षिका है", "who", "which,whose,whom"],
    ["___ is standing there is my friend", "जो वहाँ खड़ी है वह मेरी दोस्त है", "who", "which,whose,whom"],
    ["___ sold me this car is a driver", "जिसने मुझे यह कार बेची वह ड्राइवर है", "who", "which,whose,whom"],
    ["___ father is a doctor is my friend", "जिसके पिता डॉक्टर हैं वह मेरी दोस्त है", "whose", "who,which,whom"]
  ];
  const things = [
    ["this phone", "यह फ़ोन"], ["the book", "किताब"], ["the house", "घर"], ["the film", "फ़िल्म"],
    ["the car", "कार"], ["this letter", "यह चिट्ठी"], ["the shop", "दुकान"]
  ];
  const tPreds = [
    ["___ I bought yesterday is very good", "जो मैंने कल ख़रीदा वह बहुत अच्छा है", "that", "who,whose,whom"],
    ["___ you gave me was expensive", "जो तुमने मुझे दिया वह महँगा था", "that", "who,whose,whom"],
    ["___ we watched was boring", "जो हमने देखी वह उबाऊ थी", "which", "who,whose,whom"],
    ["___ he lives in is very old", "जिसमें वह रहता है वह बहुत पुराना है", "which", "who,whose,whom"],
    ["___ is near the station was closed", "जो स्टेशन के पास है वह बंद था", "which", "who,whose,whom"],
    ["___ she wrote to me was very long", "जो उसने मुझे लिखा वह बहुत लंबा था", "which", "who,whose,whom"]
  ];
  const vals = [];
  for (const p of mPeople) for (const c of mPreds) vals.push(VA(p[0] + " " + c[0], c[1], "", c[2], c[3]));
  for (const p of fPeople) for (const c of fPreds) vals.push(VA(p[0] + " " + c[0], c[1], "", c[2], c[3]));
  for (const p of things) for (const c of tPreds) vals.push(VA(p[0] + " " + c[0], c[1], "", c[2], c[3]));
  cat("relative-clauses", { p: vals }, [
    T("{p}.", "{p}।", { blank: "p" }),
    T("I think {p}.", "मुझे लगता है कि {p}।", { blank: "p" }),
    T("Do you know that {p}?", "क्या तुम जानते हो कि {p}?", { blank: "p" }),
    T("Everyone knows that {p}.", "सब जानते हैं कि {p}।", { blank: "p" }),
    T("I heard that {p}.", "मैंने सुना कि {p}।", { blank: "p" }),
    T("I know that {p}.", "मैं जानता हूँ कि {p}।", { blank: "p" }),
    T("She said that {p}.", "उसने कहा कि {p}।", { blank: "p" }),
    T("It is true that {p}.", "यह सच है कि {p}।", { blank: "p" }),
    T("We all think that {p}.", "हम सब सोचते हैं कि {p}।", { blank: "p" }),
    T("Do you think that {p}?", "क्या तुम्हें लगता है कि {p}?", { blank: "p" }),
    T("I am sure that {p}.", "मुझे यक़ीन है कि {p}।", { blank: "p" }),
    T("Nobody knows that {p}.", "किसी को नहीं पता कि {p}।", { blank: "p" })
  ]);
}

// adverbs of frequency
{
  const advs = [
    VA("always", "", "हमेशा", "always", "usually,often,never,sometimes"),
    VA("usually", "", "आमतौर पर", "usually", "always,never,rarely,sometimes"),
    VA("often", "", "अक्सर", "often", "always,never,rarely,usually"),
    VA("sometimes", "", "कभी-कभी", "sometimes", "always,never,often,usually"),
    VA("never", "", "कभी नहीं", "never", "always,usually,often,sometimes"),
    VA("rarely", "", "शायद ही कभी", "rarely", "always,usually,often,sometimes"),
    VA("seldom", "", "कभी-कभार", "seldom", "always,usually,often,never"),
    VA("frequently", "", "बार-बार", "frequently", "always,never,rarely,sometimes")
  ];
  const acts = VERBS.map((x) => VA(x.s3 + " " + x.en, x.hi + " " + x.stem + PS_SUF.sm, "", "", ""));
  const slots = { f: advs, a: acts, s: "@S_3SM" };
  cat("adverbs-frequency", slots, [
    T("{s} ___ {a} on Sundays.", "{s} रविवार को {gap} {a}।", { blank: "f" }),
    T("{s} ___ {a} in the morning.", "{s} सुबह {gap} {a}।", { blank: "f" }),
    T("{s} ___ {a} at home.", "{s} घर पर {gap} {a}।", { blank: "f" }),
    T("{s} ___ {a} with me.", "{s} मेरे साथ {gap} {a}।", { blank: "f" }),
    T("{s} ___ {a} after dinner.", "{s} खाने के बाद {gap} {a}।", { blank: "f" }),
    T("{s} ___ {a} on the weekend.", "{s} हफ़्ते के अंत में {gap} {a}।", { blank: "f" })
  ]);
}

// imperatives
{
  const cmds = [
    ["___ the door", "दरवाज़ा खोलो", "Open"], ["___ the window", "खिड़की बंद करो", "Close"],
    ["___ the gate", "गेट बंद करो", "Shut"], ["___ down", "बैठ जाओ", "Sit"], ["___ up", "खड़े हो जाओ", "Stand"],
    ["___ here", "यहाँ आओ", "Come"], ["___ there", "वहाँ जाओ", "Go"], ["___ for me", "मेरा इंतज़ार करो", "Wait"],
    ["___ carefully", "ध्यान से सुनो", "Listen"], ["___ this page", "यह पन्ना पढ़ो", "Read"],
    ["___ your name", "अपना नाम लिखो", "Write"], ["___ it again", "इसे फिर कहो", "Say"],
    ["___ slowly", "धीरे बोलो", "Speak"], ["___ me the truth", "मुझे सच बताओ", "Tell"],
    ["___ your mother", "अपनी माँ की मदद करो", "Help"], ["___ me water", "मुझे पानी लाओ", "Bring"],
    ["___ this bag", "यह बस्ता लो", "Take"], ["___ me the book", "मुझे किताब दो", "Give"],
    ["___ it on the table", "इसे मेज़ पर रखो", "Put"], ["___ left", "बाएँ मुड़ो", "Turn"],
    ["___ at me", "मेरी ओर देखो", "Look"], ["___ the road", "सड़क देखो", "Watch"],
    ["___ the road", "सड़क पार करो", "Cross"], ["___ the car", "कार पार्क करो", "Park"],
    ["___ slowly", "धीरे चलाओ", "Drive"], ["___ your food", "अपना खाना खाओ", "Eat"],
    ["___ your milk", "अपना दूध पियो", "Drink"], ["___ your hands", "अपने हाथ धोओ", "Wash"],
    ["___ your room", "अपना कमरा साफ़ करो", "Clean"], ["___ off the light", "लाइट बंद करो", "Switch"],
    ["___ on the fan", "पंखा चालू करो", "Turn"], ["___ the door", "दरवाज़ा बंद करो", "Lock"],
    ["___ me later", "मुझे बाद में फ़ोन करो", "Call"], ["___ me at five", "पाँच बजे मुझसे मिलो", "Meet"],
    ["___ some milk", "कुछ दूध ख़रीदो", "Buy"], ["___ the bill", "बिल चुकाओ", "Pay"],
    ["___ this letter", "यह चिट्ठी भेजो", "Send"], ["___ the rice", "चावल बनाओ", "Cook"],
    ["___ the plants", "पौधों को पानी दो", "Water"], ["___ the dog", "कुत्ते को खाना दो", "Feed"],
    ["___ your teeth", "अपने दाँत साफ़ करो", "Brush"], ["___ your shoes", "अपने जूते पहनो", "Wear"],
    ["___ your medicine", "अपनी दवा लो", "Take"], ["___ your homework", "अपना होमवर्क पूरा करो", "Finish"],
    ["___ the work", "काम शुरू करो", "Start"], ["___ the noise", "शोर बंद करो", "Stop"],
    ["___ up", "जल्दी करो", "Hurry"], ["___ careful", "सावधान रहो", "Be"]
  ];
  const answers = cmds.map((c) => c[2]);
  const vals = cmds.map((c, i) => VA(c[0], c[1], c[1], c[2], [answers[(i + 1) % answers.length], answers[(i + 2) % answers.length], answers[(i + 3) % answers.length]].join(",")));
  cat("imperatives", { c: vals }, [
    T("{c}.", "{c}।", { blank: "c" }),
    T("{c}, please.", "{c}, कृपया।", { blank: "c" }),
    T("{c} now.", "{c} अब।", { blank: "c" }),
    T("{c} right now!", "{c} अभी!", { blank: "c" }),
    T("{c} one more time.", "{c} एक बार और।", { blank: "c" }),
    T("{c} before you go.", "{c}, जाने से पहले।", { blank: "c" }),
    T("{c} slowly.", "{c} धीरे।", { blank: "c" }),
    T("{c} carefully.", "{c} ध्यान से।", { blank: "c" }),
    T("{c} again.", "{c} फिर से।", { blank: "c" }),
    T("{c} together.", "{c} सब मिलकर।", { blank: "c" }),
    T("{c}, or we will be late.", "{c}, वरना हम देर कर देंगे।", { blank: "c" }),
    T("{c} tomorrow.", "{c} कल।", { blank: "c" }),
    T("{c} today.", "{c} आज।", { blank: "c" }),
    T("{c} tonight.", "{c} आज रात।", { blank: "c" }),
    T("{c} quickly.", "{c} जल्दी।", { blank: "c" }),
    T("{c} quietly.", "{c} चुपचाप।", { blank: "c" }),
    T("{c} immediately.", "{c} तुरंत।", { blank: "c" }),
    T("{c} at once.", "{c} फ़ौरन।", { blank: "c" }),
    T("{c} in the morning.", "{c} सुबह।", { blank: "c" }),
    T("{c} in the evening.", "{c} शाम को।", { blank: "c" }),
    T("{c} right away.", "{c} इसी वक़्त।", { blank: "c" }),
    T("{c} one by one.", "{c} एक-एक करके।", { blank: "c" })
  ]);
}

// wish / if only
{
  const things = [];
  for (const n of NOUNS) {
    const cop = n.g === "f" ? " होती" : " होता";
    things.push(V(anOf(n.en) + " " + n.en, n.hi + cop));
    for (const a of ADJS) things.push(V(anOf(a.en) + " " + a.en + " " + n.en, adjHi(n, a) + " " + n.hi + cop));
  }
  const ability = [
    ["speak English", "अंग्रेज़ी बोल सकता"], ["speak French", "फ़्रेंच बोल सकता"], ["fly", "उड़ सकता"],
    ["swim", "तैर सकता"], ["drive a car", "गाड़ी चला सकता"], ["play the guitar", "गिटार बजा सकता"],
    ["sing well", "अच्छा गा सकता"], ["dance", "नाच सकता"], ["run fast", "तेज़ दौड़ सकता"],
    ["read Hindi", "हिंदी पढ़ सकता"], ["use a computer", "कंप्यूटर चला सकता"], ["play chess", "शतरंज खेल सकता"],
    ["draw well", "अच्छा चित्र बना सकता"], ["remember names", "नाम याद रख सकता"], ["cook well", "अच्छा खाना बना सकता"],
    ["help you", "तुम्हारी मदद कर सकता"], ["stay longer", "और रुक सकता"], ["meet my friend", "अपने दोस्त से मिल सकता"],
    ["come with you", "तुम्हारे साथ आ सकता"], ["travel the world", "दुनिया घूम सकता"]
  ].map((v) => V(v[0], v[1]));
  const slots = { w: things, k: ability };
  cat("wish", slots, [
    T("I wish I ___ {w}.", "काश मेरे पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("He wishes he ___ {w}.", "काश उसके पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("She wishes she ___ {w}.", "काश उसके पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("We wish we ___ {w}.", "काश हमारे पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("They wish they ___ {w}.", "काश उनके पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("I wish I ___ {w} now.", "काश अब मेरे पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("I wish I ___ {w} at that time.", "काश उस समय मेरे पास {w}।", { ans: "had", wrongs: "have,has,will have" }),
    T("I wish I ___ {k}.", "काश मैं {k}।", { ans: "could", wrongs: "can,will,would to" }),
    T("He wishes he ___ {k}.", "काश वह {k}।", { ans: "could", wrongs: "can,will,would to" }),
    T("She wishes she ___ {k}.", "काश वह {k}।", { ans: "could", wrongs: "can,will,would to" }),
    T("I wish it ___ not raining.", "काश बारिश न हो रही होती।", { ans: "were", wrongs: "was,is,are,will be" }),
    T("I wish I ___ more time.", "काश मेरे पास ज़्यादा समय होता।", { ans: "had", wrongs: "have,has,am,having" }),
    T("I wish you ___ here.", "काश तुम यहाँ होते।", { ans: "were", wrongs: "was,is,are,will be" })
  ]);
}

// =====================================================================
// Emission
// =====================================================================

const ser = (v) => {
  const a = [v[0] || "", v[1] || "", v[2] || "", v[3] || "", v[4] || ""];
  while (a.length > 1 && a[a.length - 1] === "") a.pop();
  return a.join("~");
};
const serValues = (vals) => vals.map(ser).join(" | ");

export function buildAsset() {
  const lines = [];
  const used = new Set();
  for (const c of CATS) {
    for (const s of Object.values(c.slots)) {
      const m = /^@(.+)$/.exec(s);
      if (m) used.add(m[1]);
    }
  }
  for (const name of Object.keys(L)) {
    if (used.has(name)) lines.push(["#l", name, serValues(L[name])].join("	"));
  }
  for (const c of CATS) {
    lines.push(["#c", c.id].join("	"));
    for (const [slot, val] of Object.entries(c.slots)) {
      const v = typeof val === "string" ? val : serValues(val);
      lines.push(["#s", slot, v].join("	"));
    }
    for (const t of c.tpls) {
      lines.push(["#t", t.en, t.hi].join("	"));
      if (t.blank && t.answer === "") lines.push(["#b", t.blank].join("	"));
      if (t.ans) lines.push(["#a", t.ans, t.wrongs || "", t.gapHi || ""].join("	"));
      else if (t.blank && !t.answer) lines.push(["#b", t.blank].join("	"));
    }
  }
  const body = lines.join("\n") + "\n";
  // Counts go at the top so the app can show "N questions" without generating
  // every drill up front. Computed from the round-tripped asset so they match
  // exactly what the runtime generator produces.
  const parsed = parseAsset(body);
  const head = CATS.map((c) => ["#n", c.id, String(generate(parsed[c.id] || { id: c.id, slots: {}, tpls: [] }, 1000000).length)].join("\t"));
  return head.join("\n") + "\n" + body;
}

// ------------------------------------------------- reference generator ----

const SLOT_RE = /{([a-zA-Z0-9_]+)}/g;
const parseValue = (s) => {
  const p = s.split("~");
  return [p[0] || "", p[1] || "", p[2] || "", p[3] || "", p[4] || ""];
};
const parseValues = (s) => s.split("|").map((x) => parseValue(x.trim())).filter((v) => v[0] !== "");

export function parseAsset(text) {
  const cats = {};
  let cat = null, tpl = null;
  for (const line of text.split("\n")) {
    if (!line.trim() || line.startsWith("//")) continue;
    const f = line.split("	");
    if (f[0] === "#l") L[f[1]] = parseValues(f[2] || "");
    else if (f[0] === "#c") { cat = { id: f[1], slots: {}, tpls: [] }; cats[f[1]] = cat; tpl = null; }
    else if (f[0] === "#s") {
      if (!cat) continue;
      const spec = f[2] || "";
      const vals = spec.startsWith("@") ? (L[spec.slice(1)] || []) : parseValues(spec);
      cat.slots[f[1]] = (cat.slots[f[1]] || []).concat(vals);
    } else if (f[0] === "#t") { tpl = { en: f[1] || "", hi: f[2] || "", ans: "", wrongs: "", gapHi: "", blank: null }; cat.tpls.push(tpl); }
    else if (f[0] === "#a" && tpl) { tpl.ans = f[1] || ""; tpl.wrongs = f[2] || ""; tpl.gapHi = f[3] || ""; }
    else if (f[0] === "#b" && tpl) { tpl.blank = f[1] || null; }
  }
  return cats;
}

const refs = (t) => {
  const out = new Set();
  for (const s of [t.en, t.hi]) {
    let m;
    SLOT_RE.lastIndex = 0;
    while ((m = SLOT_RE.exec(s))) if (m[1] !== "gap") out.add(m[1]);
  }
  return [...out];
};

export function generate(cat, cap = 6000) {
  const out = [];
  const seen = new Set();
  for (const t of cat.tpls) {
    const names = refs(t);
    if (t.blank && !names.includes(t.blank)) names.push(t.blank);
    const slots = names.map((n) => ({ n, vals: cat.slots[n] || [] }));
    if (slots.some((s) => s.vals.length === 0)) continue;
    const total = slots.reduce((a, s) => a * s.vals.length, 1);
    const idx = new Array(slots.length).fill(0);
    for (let k = 0; k < total && out.length < cap; k++) {
      const chosen = {};
      for (let i = 0; i < slots.length; i++) chosen[slots[i].n] = slots[i].vals[idx[i]];
      for (let i = slots.length - 1; i >= 0; i--) { if (++idx[i] < slots[i].vals.length) break; idx[i] = 0; }
      const bv = t.blank ? chosen[t.blank] || null : null;
      const answer = (bv && bv[3]) || t.ans;
      const wrongs = ((bv && bv[4]) || t.wrongs || "").split(",").map((x) => x.trim()).filter(Boolean);
      const gapHi = (bv && bv[2]) || t.gapHi || "";
      if (!answer || wrongs.length < 3) continue;
      let en = t.en, hin = t.hi;
      for (const s of slots) {
        en = en.split("{" + s.n + "}").join(chosen[s.n][0]);
        hin = hin.split("{" + s.n + "}").join(chosen[s.n][1]);
      }
      const sentence = en.replace(/ +/g, " ").trim().replace(/^[a-z]/, (c) => c.toUpperCase());
      hin = hin.split("{gap}").join(gapHi).replace(/ +/g, " ").trim();
      const full = sentence.replace("___", answer);
      if (!sentence.includes("___")) continue;
      const key = full + "|" + answer;
      if (seen.has(key)) continue;
      seen.add(key);
      out.push({ cat: cat.id, sentence, answer, wrongs, hi: hin });
    }
  }
  return out;
}

export function counts(cap = 6000) {
  const a = buildAsset();
  const cats = parseAsset(a);
  const res = {};
  for (const id of Object.keys(cats)) res[id] = generate(cats[id], cap).length;
  return res;
}

// CLI: `node tools/practice-recipes.mjs [outFile]` writes the DSL asset
// (default: app/src/main/assets/practice_drills.txt).
if (typeof process !== "undefined" && process.argv && (process.argv[1] || "").endsWith("practice-recipes.mjs")) {
  const { writeFileSync } = await import("node:fs");
  const out = process.argv[2] || new URL("../app/src/main/assets/practice_drills.txt", import.meta.url).pathname;
  writeFileSync(out, buildAsset());
  console.error("wrote " + out);
}
