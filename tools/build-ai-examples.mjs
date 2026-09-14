#!/usr/bin/env node
/**
 * Build-time AI example sentences. Generated sentences are written into the
 * bundled corpora *before* the APK is built — the shipped app stays key-free,
 * account-free and fully offline.
 *
 * Two modes, chosen per input item:
 *
 *  1. "corpus top-up" (the mode the checked-in `sentences_gen_<lang>.tsv` files
 *     were produced with). For an item like
 *
 *         { "lang": "ta", "en": "butterfly", "words": ["வண்ணத்துப்பூச்சி"] }
 *
 *     the model is asked for two short Tamil sentences that use the Tamil word,
 *     each with an English meaning, and the good lines are appended to
 *     `app/src/main/assets/sentences_gen_ta.tsv`. A generated line is dropped
 *     unless it passes a mechanical guard-rail (`validPair`): it must contain
 *     the word, be written in the target language's own script with no letters
 *     from any other writing system, contain no brackets or stray `|`, not
 *     duplicate an existing row, and its English side must read as a finished
 *     sentence (a missing full stop is repaired; a truncated gloss such as
 *     "Save for the" is thrown away).
 *
 *  2. "legacy append" (kept for compatibility). Items without `en` append plain
 *     sentences to `sentences.tsv` — the Japanese/English corpus.
 *
 * Usage:
 *   cp tools/ai-words.example.json tools/ai-words.json     # then edit it
 *   AI_API_KEY=xxx node tools/build-ai-examples.mjs
 *   AI_API_KEY=xxx AI_BASE_URL=https://api.groq.com/openai/v1 AI_MODEL=llama-3.1-8b-instant \
 *     node tools/build-ai-examples.mjs
 *
 * It talks to any OpenAI-compatible /chat/completions endpoint, so the free tiers
 * of Groq, Google AI Studio (Gemini), OpenRouter (`:free` models), Cerebras or
 * Mistral all work — see docs/EXTRA-EXAMPLES.md.
 *
 * The key is only ever read from the environment: never committed, never shipped.
 */

import { readFileSync, writeFileSync, existsSync } from "node:fs";
import { join, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const ROOT = join(dirname(fileURLToPath(import.meta.url)), "..");
const ASSETS = join(ROOT, "app", "src", "main", "assets");
const WORDS = join(ROOT, "tools", "ai-words.json");

const KEY = process.env.AI_API_KEY;
const BASE = (process.env.AI_BASE_URL || "https://api.openai.com/v1").replace(/\/$/, "");
const MODEL = process.env.AI_MODEL || "gpt-4o-mini";
const PER_WORD = Number(process.env.AI_PER_WORD || 2);

const NAME = {
  ja: "Japanese", en: "English", es: "Spanish", fr: "French", de: "German",
  hi: "Hindi", ar: "Arabic", bn: "Bengali", ta: "Tamil", te: "Telugu",
  ur: "Urdu", kn: "Kannada",
};
const NATIVE = {
  ja: "日本語", en: "English", es: "español", fr: "français", de: "Deutsch",
  hi: "हिन्दी", ar: "العربية", bn: "বাংলা", ta: "தமிழ்", te: "తెలుగు",
  ur: "اردو", kn: "ಕನ್ನಡ",
};
const SCRIPT = {
  hi: /[\u0900-\u097f]/, ar: /[\u0600-\u06ff]/, bn: /[\u0980-\u09ff]/,
  ta: /[\u0b80-\u0bff]/, te: /[\u0c00-\u0c7f]/, ur: /[\u0600-\u06ff]/,
  kn: /[\u0c80-\u0cff]/,
};

const NONLATIN_RE = /[A-Za-z]/;

// Every non-Latin script we might accidentally get back from a model. A target
// sentence may only use the script of its own language (plus the usual
// punctuation), so e.g. a Kannada example that picks up a Cyrillic or Hebrew
// word is rejected. The Devanagari range excludes the danda (U+0964/5) because
// that terminator legitimately appears in Tamil/Bengali text too.
const FOREIGN_SCRIPTS = [
  /[\u0400-\u04ff]/,                                     // Cyrillic
  /[\u0370-\u03ff]/,                                     // Greek
  /[\u0590-\u05ff]/,                                     // Hebrew
  /[\u0600-\u06ff]/,                                     // Arabic
  /[\u0900-\u0963\u0966-\u097f]/,                        // Devanagari
  /[\u0980-\u09ff]/,                                     // Bengali
  /[\u0b80-\u0bff]/,                                     // Tamil
  /[\u0c00-\u0c7f]/,                                     // Telugu
  /[\u0c80-\u0cff]/,                                     // Kannada
  /[\u3040-\u30ff\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]/, // CJK / kana
  /[\uac00-\ud7af]/,                                     // Hangul
];
// Index into FOREIGN_SCRIPTS of the script that `lang` is allowed to use.
const OWN_SCRIPT = { ar: 3, hi: 4, bn: 5, ta: 6, te: 7, kn: 8, ja: 9 };

const TERMINAL_RE = /[.!?]$/;
// A gloss that ends on one of these was cut off mid-sentence by the model.
const DANGLING_RE =
  /\b(a|an|the|of|to|in|on|at|for|with|and|or|but|is|are|was|were|be|been|being|am|do|does|did|will|would|can|could|shall|should|may|might|must|has|have|had|it|its|he|she|they|them|we|you|i|my|your|his|her|our|their|this|that|these|those|very|so|too|then|than|there|here|when|where|who|what|how|why|which|some|any|all|more|most|much|many|few|little|one|two|three|not|no|if|as|by|from|into|over|under|about|after|before|up|down|out|off)$/;

/** Mechanical guard-rail shared by both modes: is this pair worth keeping? */
function validPair(target, gloss, lang, word) {
  if (!target || !gloss) return null;
  if (target.length < 4 || target.length > 60) return null;
  if (gloss.length > 70) return null;
  if (/[|()[\]{}]/.test(target)) return null;
  if (/[|()[\]{}]/.test(gloss)) return null;
  if (target.toLowerCase() === gloss.toLowerCase()) return null;
  if (!/[\p{L}]/u.test(gloss)) return null;
  if (word && !target.includes(word)) return null;

  const script = SCRIPT[lang];
  if (script) {
    if (!script.test(target)) return null;
    if (NONLATIN_RE.test(target)) return null;
  }
  // Script purity: no letters from an unrelated writing system.
  for (let i = 0; i < FOREIGN_SCRIPTS.length; i++) {
    if (OWN_SCRIPT[lang] === i) continue;
    if (FOREIGN_SCRIPTS[i].test(target)) return null;
  }

  // The English side of a row is shown to English-track learners, so it must
  // read as a finished sentence: repair a missing full stop, drop truncated ones.
  let en = gloss;
  if (!TERMINAL_RE.test(en)) en += ".";
  if (DANGLING_RE.test(en.slice(0, -1).toLowerCase().trim())) return null;
  if (en.split(/\s+/).length < 3) return null;
  return { target, gloss: en };
}

function readLines(file) {
  const seen = new Set();
  const rows = [];
  if (existsSync(file)) {
    for (const line of readFileSync(file, "utf8").split("\n")) {
      if (!line.includes("\t")) continue;
      rows.push(line);
      seen.add(line.split("\t")[0].trim().toLowerCase());
    }
  }
  return { seen, rows };
}

async function chat(system, user) {
  const res = await fetch(`${BASE}/chat/completions`, {
    method: "POST",
    headers: { "Content-Type": "application/json", Authorization: `Bearer ${KEY}` },
    body: JSON.stringify({
      model: MODEL,
      temperature: 0.9,
      messages: [{ role: "system", content: system }, { role: "user", content: user }],
    }),
  });
  if (!res.ok) throw new Error(`HTTP ${res.status}: ${(await res.text()).slice(0, 200)}`);
  const data = await res.json();
  return data.choices?.[0]?.message?.content || "";
}

const strip = (s) =>
  s.trim().replace(/^[-*\u2022\d.)\s]+/, "").trim().replace(/^["'\u201c\u201d\s]+|["'\u201c\u201d\s]+$/g, "");

/** Mode 1: `<target>\t<english>` lines for sentences_gen_<lang>.tsv. */
async function topUp(item) {
  const lang = item.lang;
  const word = item.words?.[0] || item.word;
  const en = item.en || item.mean || "";
  const file = join(ASSETS, `sentences_gen_${lang}.tsv`);
  const script = SCRIPT[lang];
  const { seen, rows } = readLines(file);

  const system =
    `You are an experienced ${NAME[lang]} teacher preparing practice sentences for a ` +
    `complete beginner. Reply with the sentences only — one per line, no numbering, ` +
    `no commentary, no headings.`;
  const user =
    `Write ${PER_WORD} short, natural ${NATIVE[lang]} sentences that each use the ` +
    `${NAME[lang]} word "${word}". Keep each sentence simple, at most 8 words. ` +
    (script ? `Write only in ${NATIVE[lang]} script, never Latin letters. ` : "") +
    `After each sentence write "|" and then a natural English translation of it. ` +
    `Output exactly one line per sentence in the format: ${NATIVE[lang]} sentence|English translation.\n` +
    `The word "${word}" means "${en}" in English.`;

  const text = await chat(system, user);
  let added = 0;
  const fresh = [];
  for (const raw of text.split("\n")) {
    const bar = raw.indexOf("|");
    if (bar <= 0) continue;
    const target = strip(raw.slice(0, bar));
    const gloss = strip(raw.slice(bar + 1)).replace(/^["'\u201c\u201d\s]+|["'\u201c\u201d\s]+$/g, "");
    // validPair enforces script purity, rejects bracketed/duplicated junk,
    // repairs or rejects a truncated English side, etc. — see above.
    const pair = validPair(target, gloss, lang, word);
    if (!pair) continue;
    const key = pair.target.toLowerCase();
    if (seen.has(key)) continue;
    seen.add(key);
    fresh.push(pair.target + "\t" + pair.gloss);
    added++;
  }
  if (fresh.length) writeFileSync(file, (rows.join("\n") ? rows.join("\n") + "\n" : "") + fresh.join("\n") + "\n", "utf8");
  console.log(`${lang} ${word}: +${added}`);
}

/** Mode 2: plain sentences appended to sentences.tsv (the Japanese corpus). */
async function legacy(item) {
  const word = item.words?.[0] || item.word;
  const lang = item.lang || "en";
  const file = join(ASSETS, "sentences.tsv");
  const { seen, rows } = readLines(file);
  const text = await chat(
    "You write example sentences for a language-learning app. Reply with the sentences only — one per line, no numbering, no commentary.",
    `Write ${PER_WORD} short, natural ${NAME[lang]} sentences that each use the word "${word}". ` +
      `Everyday situations only, max 12 words per sentence.`
  );
  let added = 0;
  for (const raw of text.split("\n")) {
    const s = strip(raw);
    if (s.length < 3 || s.length > 120) continue;
    const line = lang === "ja" ? `${s}\t${word}` : `${word}\t${s}`;
    if (seen.has(line.split("\t")[0].trim().toLowerCase())) continue;
    seen.add(line.split("\t")[0].trim().toLowerCase());
    rows.push(line);
    added++;
  }
  if (added) writeFileSync(file, rows.join("\n") + "\n", "utf8");
  console.log(`${word}: +${added}`);
}

async function main() {
  if (!KEY) {
    console.log("AI_API_KEY is not set — nothing to do. (The bundled corpus needs no key.)");
    return;
  }
  if (!existsSync(WORDS)) {
    console.log(`No ${WORDS} — copy tools/ai-words.example.json and edit it.`);
    return;
  }
  for (const item of JSON.parse(readFileSync(WORDS, "utf8"))) {
    try {
      const target = item.lang && item.lang !== "ja" && item.lang !== "en";
      if (item.en && target && item.words?.length) await topUp(item);
      else await legacy(item);
    } catch (e) {
      console.error(`${item.lang || ""} ${item.words?.[0] || item.word}: ${e.message}`);
    }
    await new Promise((r) => setTimeout(r, 400)); // be kind to free tiers
  }
  console.log("done — review the diff, then commit the assets.");
}

main().catch((e) => {
  console.error(e);
  process.exit(1);
});
