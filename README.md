# Kotoba — Japanese ⇄ English Language Learning

Learn Japanese and English together — **no bridge language required**. Anyone who speaks neither language can start from zero: sounds first (kana with picture mnemonics), then picture-based vocabulary, then real sentences. The app works **bilingual in both directions** — Japanese speakers can learn English and English speakers can learn Japanese, from the same word pack.

Built on well-established language-learning research:

- **Spaced Repetition (SM-2)** — every word gets its own schedule (10 min → 1 day → 6 days → …). Wrong answers return quickly, right answers stretch out. This "forgetting curve" timing is the highest-leverage technique for long-term retention.
- **Picture association over translation** — every word is taught with an emoji and an image-first prompt, so learners map *meaning directly to sound*, the way native speakers and children do, instead of translating through a third language.
- **Chunking / sentence patterns** — learners study whole high-frequency sentences ("I like ~", "please ~") rather than isolated words, matching how fluency is actually built.
- **Kana before kanji, with mnemonics** — the 46 kana characters (×2 scripts, plus voiced variants) each get a picture mnemonic, because connecting sounds to memorable images is the fastest proven route to literacy.
- **Input-first, low-stakes quizzing** — tapping, listening and repeating; every interaction is graded gently into the SRS.
- **Audio from day one** — native TextToSpeech pronunciation for every word, phrase and sentence, with adjustable speed.

## Features

- 🌸 **Kana mastery** — Hiragana + Katakana with picture mnemonics, audio, a "mark learned" tracker, and a 10-question listening/reading quiz.
- 📚 **12 bilingual lessons** — 135+ high-frequency words across greetings, numbers, colors, family, food, animals, actions, adjectives, time, places, weather and a survival kit — each with romaji, kanji where useful, IPA for English, audio, and an image-first quiz.
- 🧠 **Spaced-repetition reviews** — SM-2 scheduler with Again / Hard / Good / Easy grading, progress bars, and XP rewards.
- 🗣️ **Phrase bank** — 12 real-world chunked sentences with word-by-word breakdowns.
- 📐 **24 grammar patterns** (14 Japanese + 10 English) — taught as *patterns with audio examples*, explained in *both* languages so either kind of learner benefits.
- 🎮 **Gamification** — XP, levels, daily streaks, stats, and progress tracking that make daily practice a habit.
- 🌍 **Direction-independent** — switch between learning Japanese, English, or both; toggle romaji and translations to taper off scaffolding.

## Screens

Home (progress & streak) · Learn (kana module + lessons + chunks) · Review (SRS) · Grammar (patterns) · Profile (settings)

## Building

```bash
./gradlew assembleDebug
```

Output APK: `app/build/outputs/apk/debug/app-debug.apk`

## CI

Every push to `main` triggers [`.github/workflows/build.yml`](.github/workflows/build.yml), which compiles the app and uploads the APK as a GitHub Actions artifact.

## Tech

Kotlin · Jetpack Compose (Material 3) · Android Gradle Plugin 8.5 · Kotlin 2.0 · minSdk 26 (Android 8.0+)
