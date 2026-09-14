# Extra example sentences

The word sheet shows the bundled corpus of real sentences directly: open a word
and you get sentences that genuinely use it, each with its own real translation,
entirely offline — no account, no API key. **Load 10 more** pages through the
rest. Nothing on the sheet is built from a fixed "sentence frame" with the taught
word dropped into the blank, so no two words read alike.

The word-example feature lives in `MoreExamples.kt`, which is the *single*
implementation used by every screen that shows a word:

* the word-detail sheet and the three word browsers (`LessonExplore.kt`),
* the lesson quiz, after the answer is revealed (`Learn.kt`),
* spaced-repetition reviews (`Review.kt`),
* dictionary results (`Dictionary.kt`),
* the 4,400-verb trainer (`Verbs.kt`).

Screens without room for examples show a small **💬 More examples** button that
expands into the block in place. The **Load 10 more** button is rendered *below*
the lines it adds, so newly loaded examples appear directly above the button
instead of pushing it off screen.

The grammar screens follow the same model: every pattern shows ten example
sentences and a **Load 10 more** button (backed by `GrammarPacks.pool`), and the
**Practice** section drills each grammar topic with hand-written questions — see
[PRACTICE.md](PRACTICE.md). A pattern's pool is its own examples plus hand-written
extras plus, only if it is still short, the examples of a pattern that teaches the
**same** grammar point (`relatives`); nothing is ever borrowed from an unrelated
topic, so a *past perfect continuous* sheet can no longer show "I am a teacher".

## Bundled corpus (always offline)

`app/src/main/assets/` holds one corpus per target language:

| File | What it is |
| --- | --- |
| `sentences.tsv` | ~89,000 Tatoeba Japanese↔English pairs (also backs the English track) |
| `sentences_gen_<lang>.tsv` | AI-written top-up: two sentences per taught word, in the learner's target language |
| `sentences_<lang>.tsv` | Tatoeba pairs for that language, where the corpus is big enough to matter |
| `gloss_<lang>.tsv` | meaning table (English → `<lang>`). Only its single-word/sense rows are shown in the UI; its machine-translated full-sentence rows are used to look a translation up, never displayed as an example |

`<lang>` is `hi es ar fr de bn ta te ur kn` — every target the app can teach
besides Japanese and English. Coverage was checked mechanically: **99–100 % of
taught words in every generated track have at least one bundled example**,
averaging 2.5–4.3 sentences per word.

* `Corpus.kt` lazily loads a language's files the first time someone taps **More
  examples**, keeps one language in memory at a time, and streams matches 10 at a
  time.
* Matching matches on the word the learner is studying plus every other
  dictionary sense in the gloss table, is accent-insensitive (`trafico` finds
  `tráfico`), tolerates inflection (`madre` finds `madres`), and treats an
  apostrophe as a word boundary so elided Spanish/French forms work (`l'économie`).
* Japanese is matched as a substring with a kanji-boundary rule, so 母 no longer
  matches 母国 ("motherland") and a one-mora kana reading (日 → ひ) only counts
  when the whole sentence is that word — this is what makes the Japanese sheet
  show real, on-topic sentences instead of the near-empty list a whole-word match
  produced.

### Every shown translation is a real one

An example card is only ever rendered when the bundle genuinely contains a
translation for *that exact sentence*. Earlier builds composed a gloss
word-by-word out of the dictionary tables, which produced confident nonsense for
anything idiomatic — the reported example was

> "Let's give Tom a surprise welcome party." → "देना ए आश्चर्य स्वागत है पार्टी"

That path is gone. `Corpus.extra` now draws every card from one of two sources:

* **English track** (`target = en`): the sentence is the English half of a
  curated pair in the learner's *native* language file
  (`sentences_gen_<native>.tsv` / `sentences_<native>.tsv`), and the gloss is the
  other half of the same row — sentence and translation come from the same
  hand-checked line. The machine-translated full-sentence rows of
  `gloss_<native>.tsv` are never shown as examples (they are still consulted to
  translate a sentence, but a card's text always comes from a curated pair).
* **Any other track**: the sentence comes from the language being learned and the
  other column of that row is its real English translation. If the native
  language isn't English, that English sentence is looked up in the native
  tables (`Examples.exactGloss`, then the native pair map); when the bundle has no
  native rendering, the real English translation is shown as the fallback (the
  same fallback the authored examples use) rather than no card at all.

Bare words and `sense; list; rows` never appear as "sentences": every card is
de-duplicated punctuation- and case-insensitively (`Good night`, `Good night!`
and `Good night.` collapse to one), a row that is just the headword repeated is
dropped, English cards must end in terminal punctuation, and non-English cards
must be a real sentence (three or more words, or a non-space-joining script of
reasonable length). `Examples.sentenceGloss()` no longer exists; the only gloss
helper left is `Examples.exactGloss(sentence, native)`, which returns a
translation or `null` — it never guesses.

The Hindi pairs were also topped up from 3,320 to **9,470** real Hindi↔English
pairs (the AI-written, word-verified rows in `sentences_gen_hi.tsv`). After the
quality filters, **99.2 % of single-word entries (5,312 words) have at least one
real English example, 42 % have three or more and 10 % have ten or more**; the
handful with none simply show "No bundled examples for this word yet." instead of
invented text.

Toggle: **Advanced → More example sentences**. No download, no setup, works in
airplane mode. Licences: [DATA-LICENSES.md](DATA-LICENSES.md).

### Regenerating the corpus

```sh
node tools/build-sentences.mjs              # Tatoeba pairs, all languages
node tools/build-sentences.mjs --only ta,kn # just these
```

`tools/build-sentences.mjs` downloads the Tatoeba mirrors published by
www.manythings.org/anki, applies the per-language length/script filters and row
caps, and rewrites `sentences.tsv` + `sentences_<lang>.tsv`. Nothing else needs
the network — `sentences_gen_<lang>.tsv` is checked in.

## Build-time AI top-up (development tool, opt-in)

`tools/build-ai-examples.mjs` asks any OpenAI-compatible endpoint for sentences
and appends the good ones to the corpus **at build time**. The key is read from
the environment and is never written to the repo or the APK, so the shipped app
stays key-free and offline. This is a maintainer script, not a feature inside the
app — the app itself has no AI and no download.

```sh
cp tools/ai-words.example.json tools/ai-words.json     # then edit it
AI_API_KEY=xxx AI_BASE_URL=https://api.groq.com/openai/v1 AI_MODEL=llama-3.1-8b-instant \
  node tools/build-ai-examples.mjs
```

An item like

```json
{ "lang": "ta", "en": "butterfly", "words": ["வண்ணத்துப்பூச்சி"] }
```

asks for two short Tamil sentences that use that word, each with an English
meaning, and keeps only lines that actually contain the word and are written in
the target script — which is exactly how the checked-in
`sentences_gen_<lang>.tsv` files were produced. Items without `en` keep the
original behaviour (plain sentences appended to `sentences.tsv`).

Free tiers that work out of the box: Groq, Google AI Studio (Gemini),
OpenRouter (`:free` models), Cerebras, Mistral. Any of them is fine — the script
only needs a `/chat/completions` endpoint.

