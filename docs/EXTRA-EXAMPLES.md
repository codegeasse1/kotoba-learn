# Extra example sentences

Kotoba's hand-authored example sentences are deliberately small — about ten per
word. Learners who want more page through a bundled corpus of real sentences,
entirely offline, with no account and no API key on the phone.

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
[PRACTICE.md](PRACTICE.md).

## Bundled corpus (always offline)

`app/src/main/assets/` holds one corpus per target language:

| File | What it is |
| --- | --- |
| `sentences.tsv` | ~89,000 Tatoeba Japanese↔English pairs (also backs the English track) |
| `sentences_gen_<lang>.tsv` | AI-written top-up: two sentences per taught word, in the learner's target language |
| `sentences_<lang>.tsv` | Tatoeba pairs for that language, where the corpus is big enough to matter |

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
* For languages other than English, the English side is turned into a
  native-language gist by `Examples.sentenceGloss()` — a greedy phrase-by-phrase
  lookup in the same gloss tables the rest of the app uses.

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

