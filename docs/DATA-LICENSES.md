# Bundled data & licences

Kotoba ships its language data inside `app/src/main/assets/`, so the dictionary,
the gloss tables, the example corpora and every course work offline. All of it is
either authored for this project or comes from a source that allows free
redistribution. This file records what each asset is and where it came from.

## Example sentence corpora

| Asset | Columns | Rows | Source |
| --- | --- | --- | --- |
| `sentences.tsv` | `<japanese>` `\t` `<english>` | ~89k | Tatoeba (via manythings.org/anki `jpn-eng`) |
| `sentences_<lang>.tsv` | `<target>` `\t` `<english>` | see below | Tatoeba (via manythings.org/anki `<code>-eng`) |
| `sentences_gen_<lang>.tsv` | `<target>` `\t` `<english>` | ~1.3–9.5k | written for this project (build-time AI top-up) |

`<lang>` is one of `hi es ar fr de bn ta te ur kn` — the ten targets that are not
hand-authored. `sentences.tsv` also backs the English track (its English column).

* **Tatoeba** — the sentence pairs published by
  [www.manythings.org/anki](https://www.manythings.org/anki/), a mirror of the
  [Tatoeba](https://tatoeba.org/) corpus. **Licence:**
  [CC-BY 2.0 FR](https://creativecommons.org/licenses/by/2.0/fr/) (Creative
  Commons Attribution 2.0 France). Tatoeba asks that the attribution be kept with
  the data, hence this file and the credit in the app's About section. Each
  archive row carries its own `CC-BY 2.0 (France) Attribution: tatoeba.org #…`
  column, which is dropped when the pairs are converted to TSV.
  **Rebuild:** `node tools/build-sentences.mjs` (see the script header for the
  per-language filters and row caps; it re-downloads the source archives and
  rewrites these files).
* **`sentences_gen_*` — project-generated.** Two short sentences per taught word,
  written by a large language model at build time and then filtered
  mechanically: the target sentence must contain the word the learner is studying,
  must be written in the target language's own script (no Latin letters for
  Arabic/Bengali/Devanagari/Tamil/Telugu/Urdu/Kannada), and must be at most 60
  (target) / 70 (English) characters. Duplicates are removed and the files are
  checked in. They are our own data, not a third-party corpus, so no attribution
  is required — they are simply redistributable under this project's MIT licence.
  Every one of them can be regenerated (or topped up) with
  `tools/build-ai-examples.mjs` — see [EXTRA-EXAMPLES.md](EXTRA-EXAMPLES.md).
  The Hindi file was topped up to 9,470 pairs so that every English course word
  has a real, curated Hindi translation to draw on (see EXTRA-EXAMPLES.md).

Coverage is verified mechanically: **99–100 % of the taught words in every one of
the ten generated tracks have at least one bundled example**, averaging 2.5–4.3
sentences per word (Tatoeba + generated combined).

## Vocabulary tables

* `gloss_<lang>.tsv` — English → that language, used both for meanings in the
  learner's native language and to build the whole course for a track that isn't
  hand-authored. Authored/vendored for this project.
* `en_hi.tsv` — English → Hindi (`en`, `hi`, part of speech). Authored for this
  project, then machine-audited: the Hindi column's `{}`/`[]` usage notes are
  normalised to `(…)`, `_` space-holders became spaces, and glued compound verbs
  were split only where a Hindi word list confirms every resulting word
  (`छोड़देना` → `छोड़ देना`). Unverifiable tokens are left as they are rather than
  guessed at. See [EXTRA-EXAMPLES.md](EXTRA-EXAMPLES.md#corpus-audit-the-checked-in-data).
* `ja_en.tsv`, `kanji.tsv`, `verbs.tsv` — Japanese dictionary, kanji and verb
  tables authored/vendored for this project.

## Optional build-time AI examples

`tools/build-ai-examples.mjs` can write more sentences into
`sentences_gen_<lang>.tsv` (or `sentences.tsv`) before a build. It is opt-in,
reads its API key only from the environment, and the key is never committed or
shipped. See [EXTRA-EXAMPLES.md](EXTRA-EXAMPLES.md).

## Runtime downloads

The app ships no optional runtime model downloads. Everything the learner can
reach — the corpus examples, the grammar patterns and the Practice drills — is
bundled in the APK or authored in Kotlin, so the app stays fully offline.
