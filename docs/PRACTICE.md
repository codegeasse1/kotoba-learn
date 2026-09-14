# Grammar practice

The **Practice** section turns the grammar patterns into active drills. It lives
on the Grammar screen behind a **Patterns / Practice** toggle (the toggle only
appears when English is the language being learned — the drills are English
grammar). Everything is offline and hand-authored; there is no model and no
download.

## Where it is

* **Grammar → Practice** — the full topic list, grouped into Tenses, Verbs &
  modals, Nouns & pronouns, Prepositions, and Sentences & style. A **🎲 Random
  mix of every topic** card sits at the top of the list.
* **Grammar → any pattern → 🎯 Practice** — opens the drill set that best matches
  that pattern (see `Practice.categoryForPattern`). Patterns with no close match
  fall back to the old example-based quiz (`PatternQuiz`).
* **Grammar → 🎯 Practice random grammar** — opens the **mixed** drill set: a
  fresh sample drawn from *every* topic, so consecutive opens give completely
  different kinds of question (a `has/have` item, then a `must` item, then a
  preposition item, …). This is what stops the old "same category every time"
  behaviour.

## How questions are chosen

Every topic has **1000+ drills** and a session shows a **fresh random sample of
10** each time it is opened, so the same ten questions never come back:

* `Practice.forCategory(id)` returns the topic's pool (curated + generated).
* `DrillSession` shuffles that pool and takes the first 10.
* **+10 more** in the header (and **Practise 10 more questions** on the results
  card) reveals the next ten from the same shuffled deck without repeating what
  has already been shown.
* **Practise again** reshuffles the whole pool for a new set.
* The answer options are shuffled too, so the correct option is not always in the
  same position.

The mixed set (`Practice.MIXED_ID`) is rebuilt on every open: it samples ~12
random topics × up to 60 drills, dedupes and shuffles, and returns up to 600.
Because it touches every topic, it does **not** expand each topic in full — it
goes through `Practice.sampleFor`, which reuses an already-cached topic or expands
it with a much smaller budget (`MIXED_TPL_CAP` / `MIXED_TARGET`). Expanding twelve
topics in full on the composition thread is what used to freeze the 🎲 button and,
on slower phones, kill the app.

`DrillSession` also builds the pool **off the main thread**
(`withContext(Dispatchers.Default)` behind a "Building your questions…" spinner),
so even the largest topic can never block the UI.

## The two drill modes

Both modes are built from the *same* dataset, so a topic is always a coherent
minimal-pair set:

* **Fill the gap** — the sentence is shown with a gap plus the native-language
  translation ("I ___ a boy" / "मैं एक लड़का हूँ"), and the learner picks the word
  that fits (am / is / was / are).
* **Choose the sentence** — only the native translation is shown, and the learner
  picks the matching English sentence ("I am a boy" / "I was a boy" / "I is a
  boy" / "I are a boy").

The important difference from the old quiz: **all four options are near-identical
sentences that differ only in the grammar point being tested**. The old quiz
mixed four unrelated sentences, so the answer was obvious without knowing any
grammar. Here the learner has to know both the rule and the meaning.

## Data model

`Practice.kt` holds everything:

* `Drill(category, sentence, answer, wrong, hi)` — one question. `sentence`
  contains a `___` gap, `wrong` are three competing forms of the same slot, and
  `hi` is the hand-written Hindi translation of the correct sentence.
* `DrillCategory(id, title, emoji, group, blurb, matchKeys)` — a topic.
* `Practice.RAW` — a small hand-written drill library, one drill per line:
  `category|sentence with ___|answer|wrong1;wrong2;wrong3|hindi`
  (lines starting with `#` are comments). These curated drills are kept because
  they are the best-quality examples for their topics.
* **`app/src/main/assets/practice_drills.txt`** — the generated drill pack: 47
  topics, ~206,000 recipe combinations (every topic ≥ 1018 drills), shipped
  offline. It is a bilingual template DSL (see below) and is interpreted at
  runtime by the generator in `Practice.kt` (`loadGeneratedAsset` / `generate`).
  Generation is lazy and LRU-cached per topic, and each topic is uniformly
  reservoir-sampled down to `GEN_CAP = 1500` drills so memory stays bounded while
  a fresh random sample is always available.
* `Practice.categoryForPattern(p)` — maps a grammar `Pattern` to a drill topic by
  matching the longest `matchKey` against the pattern's English title.

### Rebuilding `practice_drills.txt`

The pack is produced from **`tools/practice-recipes.mjs`** — a self-contained
recipe library with a bilingual template per topic and a reference generator. Run
it to regenerate the asset:

```
node tools/practice-recipes.mjs > app/src/main/assets/practice_drills.txt
```

(The module also exports `buildAsset()`, `parseAsset(text)`, `generate(cat, cap)`
and `counts(cap)` for testing. The Kotlin interpreter mirrors the JS reference
generator exactly, including per-template dedupe and reservoir sampling.)

The DSL is tab-separated; `~` separates a value's fields, ` | ` separates values,
and `,` separates wrong answers:

| line | meaning |
| --- | --- |
| `#n <catId> <count>` | how many distinct drills the recipe expands to |
| `#l <lib> <v1 \| v2 …>` | a shared value library (a value is `en~hi~gapHi~answer~wrongs`) |
| `#c <catId>` | start a category |
| `#s <slot> <@LIB \| inline>` | fill a slot (repeatable — values accumulate) |
| `#t <en> <hi>` | a template (`{slot}` placeholders, `___` gap, `{gap}` in Hindi) |
| `#a <ans> <wrongs> <gapHi>` | the template's own answer / wrongs / Hindi gap word |
| `#b <slot>` | which slot gets blanked (its value supplies the answer) |

### Adding a topic

1. Add a recipe to `tools/practice-recipes.mjs` (see the `cat(...)` calls) and
   regenerate the asset, or add curated drills to `Practice.RAW`.
2. Add a `DrillCategory` in `Practice.categories`, choosing `matchKeys` that pick
   up the matching grammar patterns (longest key wins).
3. A topic with no drills simply never appears in the hub, and its patterns fall
   back to the example-based quiz.

Translations are authored in Hindi (`Drill.hi`, always present). Other native
languages use `Examples.exactGloss(full(), native)` — the bundled meaning table's
real translation of that exact sentence — and show no translation when the table
has none, so a drill never displays a guessed gloss. (The drills themselves are
English-only, so a non-English *target* falls back to the pattern quiz entirely.)

## The vocabulary quiz

The lesson quiz (`Learn.kt`) draws its questions the same way: a lesson's ten
words are asked first, then the rest of that language's vocabulary, never
repeating a word. **+10** in the header and **10 more questions** on the results
card append ten fresh questions. "Practice again" starts a new random set. This
replaces the old fixed ten-question quiz that repeated identically every time.
