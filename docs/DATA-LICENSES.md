# Bundled data & licences

Kotoba ships a few megabytes of language data in `app/src/main/assets/`. All of it
is either authored for this project or comes from a source that allows free
redistribution. This file records what each asset is and where it came from.

## `sentences.tsv` — extra example sentences

* **What it is:** a two-column TSV (`<japanese>\t<english>`) of short sentence
  pairs, bundled so that the "More examples" feature works fully offline — no
  network, no API key, no on-device model.
* **Source:** the Japanese–English sentence pairs published by
  [www.manythings.org/anki](https://www.manythings.org/anki/) (`jpn-eng.zip`),
  which is a mirror of the [Tatoeba](https://tatoeba.org/) corpus.
* **Licence:** [CC-BY 2.0 FR](https://creativecommons.org/licenses/by/2.0/fr/)
  (Creative Commons Attribution 2.0 France). Tatoeba asks that the attribution
  be kept with the data, hence this file and the credit in the app's About
  section.
* **Rebuild:** `node tools/build-sentences.mjs` (see the script header for the
  filters; it re-downloads the source zip and rewrites `sentences.tsv`).

The other assets in `app/src/main/assets/` (`gloss_*.tsv`, `ja_en.tsv`,
`en_hi.tsv`, `kanji.tsv`, `verbs.tsv`) are vocabulary tables authored for this
project, except where a file's own header says otherwise.

## Optional build-time AI examples

`tools/build-ai-examples.mjs` can append machine-written sentences to
`sentences.tsv` before a build. It is opt-in, reads its API key only from the
environment, and the key is never committed or shipped. See
[EXTRA-EXAMPLES.md](EXTRA-EXAMPLES.md).

## Licences of optional runtime downloads

The optional on-device AI models are **not** bundled in the APK; the user
downloads one from Hugging Face the first time they enable the feature. Both are
Apache-2.0:

* `litert-community/SmolLM2-135M-Instruct`
* `litert-community/Qwen2.5-0.5B-Instruct`

The MediaPipe LLM Inference runtime (`com.google.mediapipe:tasks-genai`) is also
Apache-2.0.
