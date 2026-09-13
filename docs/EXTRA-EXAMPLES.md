# Extra example sentences

Kotoba's built-in example sentences are hand-authored and deliberately small —
about ten per word. Some learners want more. This document describes the three
ways the app can show extra examples, all of which are free and none of which
require an account or an API key on the phone.

Everything lives behind **Profile → Advanced** and is off (or, for the corpus,
on but out of the way) until the learner asks for it.

## Option 4 — bundled Tatoeba corpus (default, always offline)

`app/src/main/assets/sentences.tsv` holds ~89,000 short Japanese↔English pairs
taken from the Tatoeba corpus (CC-BY 2.0 FR — see [DATA-LICENSES.md](DATA-LICENSES.md)).

* `Corpus.kt` lazily loads the file the first time someone taps **More examples**
  in a word's example sheet, then streams matching sentences 10 at a time.
* Matching is whole-word for English and substring-on-kanji/kana for Japanese,
  so the example really does contain the word.
* For languages other than English, the English side is turned into a
  native-language gist by `Examples.sentenceGloss()` (a greedy phrase-by-phrase
  lookup in the same gloss tables the rest of the app uses).

Toggle: **Advanced → More example sentences**. No download, no setup, works in
airplane mode.

## Option 3 — build-time AI examples (opt-in, needs a free key on the build machine)

`tools/build-ai-examples.mjs` asks any OpenAI-compatible endpoint for a handful
of new sentences per word and appends them to `sentences.tsv` **at build time**.
The key is read from the environment and is never written to the repo or the APK,
so the shipped app stays key-free and offline.

```sh
cp tools/ai-words.example.json tools/ai-words.json     # then edit it
AI_API_KEY=xxx AI_BASE_URL=https://api.groq.com/openai/v1 AI_MODEL=llama-3.1-8b-instant \
  node tools/build-ai-examples.mjs
node tools/build-sentences.mjs                          # verify the corpus still builds
```

Free tiers that work out of the box: Groq, Google AI Studio (Gemini),
OpenRouter (`:free` models), Cerebras, Mistral. Any of them is fine — the script
only needs a `/chat/completions` endpoint.

## Option 1 — on-device language model (optional, experimental)

**Advanced → On-device AI examples** enables a small LLM that runs entirely on the
phone through MediaPipe LLM Inference. There is no key and, after the one-time
download, no network traffic at all. The learner picks one of:

| Model | Size | Download |
| --- | --- | --- |
| SmolLM2 135M Instruct (`.litertlm`) | ~136 MB | default, smallest |
| Qwen2.5 0.5B Instruct (`.task`, q8) | ~547 MB | more multilingual |

`OnDeviceAi.kt` downloads the model into the app's private files directory
(`files/ai-models/`), keeps it warm between calls, and serialises generation
behind a `Mutex`. `LessonExplore.kt` prompts it for five short sentences plus
English meanings, then cleans the output.

**Honest expectations:** these are 135M–0.5B parameter models. They are fine at
short English sentences and weak at Japanese. The UI labels the feature
"experimental" for that reason. It never sends anything to a server.

### Device requirements

MediaPipe LLM Inference needs a reasonably modern ARM64 (or 32-bit ARM) device
with several hundred MB of free RAM, and it does **not** run on emulators. The
APK therefore ships only `arm64-v8a` and `armeabi-v7a` native code (see the
`ndk { abiFilters }` block in `app/build.gradle.kts`) — this also keeps the APK
from carrying ~60 MB of x86 emulator libraries that no phone would ever use.
