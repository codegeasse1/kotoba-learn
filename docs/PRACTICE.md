# Grammar practice

The **Practice** section turns the grammar patterns into active drills. It lives
on the Grammar screen behind a **Patterns / Practice** toggle (the toggle only
appears when English is the language being learned — the drills are English
grammar). Everything is offline and hand-authored; there is no model and no
download.

## Where it is

* **Grammar → Practice** — the full topic list, grouped into Tenses, Verbs &
  modals, Nouns & pronouns, Prepositions, and Sentences & style.
* **Grammar → any pattern → 🎯 Practice** — opens the drill set that best matches
  that pattern (see `Practice.categoryForPattern`). Patterns with no close match
  fall back to the old example-based quiz (`PatternQuiz`).
* **Grammar → 🎯 Practice random grammar** — opens a random drill topic.

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
* `Practice.RAW` — the drill library, one drill per line:
  `category|sentence with ___|answer|wrong1;wrong2;wrong3|hindi`
  (lines starting with `#` are comments).
* `Practice.categoryForPattern(p)` — maps a grammar `Pattern` to a drill topic by
  matching the longest `matchKey` against the pattern's English title.

Translations are authored in Hindi. Other native languages fall back to
`Examples.sentenceGloss`, the same greedy phrase-by-phrase gloss the rest of the
app uses for corpus sentences — so those renderings are a gist, not a polished
translation.

## Adding a topic

1. Add drills to `Practice.RAW` using the line format above. Keep every option a
   form of the *same* word or phrase so the choices are genuinely confusable, and
   make sure exactly one option is correct for the given translation.
2. Add a `DrillCategory` in `Practice.categories`, choosing `matchKeys` that pick
   up the matching grammar patterns (longest key wins).
3. A topic with no drills simply never appears in the hub, and its patterns fall
   back to `PatternQuiz`.

## Grammar example pages

The pattern detail page shows ten example sentences and a **Load 10 more**
button. The pool behind it is `GrammarPacks.pool(pattern)`, which gathers the
pattern's own examples, the hand-written extras (`GrammarExtraEn` /
`GrammarExtraJa`), closely-related patterns, and finally a rich pattern in the
same language — de-duplicated and capped at 60.
