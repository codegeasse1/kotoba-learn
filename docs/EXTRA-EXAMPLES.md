# Extra example sentences

Kotoba's hand-authored example sentences are deliberately small — about ten per
word. Some learners want more, so the app can show extra examples from three
sources. All three are free, and none of them needs an account or an API key on
the phone.

The whole feature lives in `MoreExamples.kt`, which is the *single*
implementation used by every screen that shows a word:

* the word-detail sheet and the three word browsers (`LessonExplore.kt`),
* the lesson quiz, after the answer is revealed (`Learn.kt`),
* spaced-repetition reviews (`Review.kt`),
* dictionary results (`Dictionary.kt`),
* the 4,400-verb trainer (`Verbs.kt`).

Screens without room for examples show a small **💬 More examples** button that
expands into the block in place. The **Load 10 more** / **✨ Generate more**
buttons are rendered *below* the lines they add, so newly loaded examples appear
directly above the button instead of pushing it off screen.

## Option 4 — bundled corpus (default, always offline)

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

## Option 3 — build-time AI top-up (opt-in, needs a free key on the build machine)

`tools/build-ai-examples.mjs` asks any OpenAI-compatible endpoint for sentences
and appends the good ones to the corpus **at build time**. The key is read from
the environment and is never written to the repo or the APK, so the shipped app
stays key-free and offline.

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

## Option 1 — on-device language model (optional, experimental)

**Advanced → On-device AI examples** enables a small LLM that runs entirely on the
phone through MediaPipe LLM Inference. There is no key and, after the one-time
download, no network traffic at all. The learner picks one of:

| Model | Size | Download |
| --- | --- | --- |
| Qwen2.5 0.5B Instruct (`.task`, q8) | ~521 MB | default |
| Qwen2.5 1.5B Instruct (`.task`, q8) | ~1.5 GB | better sentences |

Both are MediaPipe **`.task`** bundles from `litert-community`. This matters: the
LiteRT-LM `.litertlm` files look similar but `LlmInference` cannot load them —
they fail with *"SentencePiece tokenizer is not found in the model"*. Don't add
one to `OnDeviceAi.MODELS`.

`OnDeviceAi.kt` downloads the model into the app's private files directory
(`files/ai-models/`), keeps it warm between calls, serialises generation behind a
`Mutex`, and turns a load failure into a plain-English message pointing the
learner back at **Profile → Advanced**. `MoreExamples.kt` prompts it for short
sentences plus English meanings, then cleans up the output.

**Honest expectations:** these are 0.5B–1.5B parameter models. They are decent at
short sentences in well-resourced languages (English, Spanish, German, Japanese)
and noticeably weaker in Tamil, Telugu or Kannada. The UI labels the feature
"experimental" for that reason — and that is exactly why the bundled corpus above
exists, so every language has good examples with no model at all. It never sends
anything to a server.

### Device requirements

MediaPipe LLM Inference needs a reasonably modern ARM64 (or 32-bit ARM) device
with several hundred MB of free RAM, and it does **not** run on emulators. The
APK therefore ships only `arm64-v8a` and `armeabi-v7a` native code (see the
`ndk { abiFilters }` block in `app/build.gradle.kts`) — this also keeps the APK
from carrying ~60 MB of x86 emulator libraries that no phone would ever use.
