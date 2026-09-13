#!/usr/bin/env node
/**
 * OPTION 3 of the "extra examples" feature: generate more example sentences at
 * BUILD TIME (never on the user's phone) and append them to the bundled corpus.
 *
 * This is entirely optional and needs a free API key. It talks to any
 * OpenAI-compatible /chat/completions endpoint, so the free tiers of Groq,
 * Google AI Studio (Gemini), OpenRouter (`:free` models), Cerebras or Mistral
 * all work — see docs/EXTRA-EXAMPLES.md.
 *
 * Usage:
 *   AI_API_KEY=xxx node tools/build-ai-examples.mjs
 *   AI_API_KEY=xxx AI_BASE_URL=https://api.groq.com/openai/v1 AI_MODEL=llama-3.1-8b-instant \
 *     node tools/build-ai-examples.mjs
 *
 * Reads  tools/ai-words.json   (see tools/ai-words.example.json)
 * Writes app/src/main/assets/sentences.tsv   (appended to, de-duplicated)
 *
 * Nothing here runs unless you ask for it, and the key is only ever read from
 * the environment — never committed and never shipped in the APK.
 */

import { readFileSync, writeFileSync, existsSync } from "node:fs";
import { join, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const ROOT = join(dirname(fileURLToPath(import.meta.url)), "..");
const WORDS = join(ROOT, "tools", "ai-words.json");
const TSV = join(ROOT, "app", "src", "main", "assets", "sentences.tsv");

const KEY = process.env.AI_API_KEY;
const BASE = (process.env.AI_BASE_URL || "https://api.openai.com/v1").replace(/\/$/, "");
const MODEL = process.env.AI_MODEL || "gpt-4o-mini";
const PER_WORD = Number(process.env.AI_PER_WORD || 5);

function loadTsv() {
  const seen = new Set();
  const rows = [];
  if (existsSync(TSV)) {
    for (const line of readFileSync(TSV, "utf8").split("\n")) {
      if (!line.includes("\t")) continue;
      rows.push(line);
      seen.add(line);
    }
  }
  return { seen, rows };
}

async function ask(word, lang, native) {
  const langName = { ja: "Japanese", en: "English", es: "Spanish", fr: "French",
    de: "German", hi: "Hindi", ar: "Arabic", bn: "Bengali", ta: "Tamil",
    te: "Telugu", ur: "Urdu", kn: "Kannada" }[lang] || lang;
  const res = await fetch(`${BASE}/chat/completions`, {
    method: "POST",
    headers: { "Content-Type": "application/json", Authorization: `Bearer ${KEY}` },
    body: JSON.stringify({
      model: MODEL,
      temperature: 0.9,
      messages: [
        {
          role: "system",
          content:
            "You write example sentences for a language-learning app. Reply with the " +
            "sentences only — one per line, no numbering, no commentary.",
        },
        {
          role: "user",
          content:
            `Write ${PER_WORD} short, natural ${langName} sentences that each use the word ` +
            `"${word}". Everyday situations only, max 12 words per sentence.`,
        },
      ],
    }),
  });
  if (!res.ok) throw new Error(`HTTP ${res.status}: ${(await res.text()).slice(0, 200)}`);
  const data = await res.json();
  return (data.choices?.[0]?.message?.content || "")
    .split("\n")
    .map((s) => s.trim().replace(/^[-*\d.)\s]+/, "").trim())
    .filter((s) => s.length > 2 && s.length < 120);
}

async function main() {
  if (!KEY) {
    console.log("AI_API_KEY is not set — nothing to do. (Option 4 alone needs no key.)");
    return;
  }
  if (!existsSync(WORDS)) {
    console.log(`No ${WORDS} — copy tools/ai-words.example.json and edit it.`);
    return;
  }
  const list = JSON.parse(readFileSync(WORDS, "utf8"));
  const { seen, rows } = loadTsv();
  let added = 0;

  for (const item of list) {
    const word = item.words?.[0] || item.word;
    const lang = item.lang || "en";
    const native = item.native || "en";
    try {
      const sentences = await ask(word, lang, native);
      for (const s of sentences) {
        // Corpus is always stored japanese-first / english-second.
        const line = lang === "ja" ? `${s}\t${word}` : `${word}\t${s}`;
        if (seen.has(line)) continue;
        seen.add(line);
        rows.push(line);
        added++;
      }
      console.log(`${word}: +${sentences.length}`);
    } catch (e) {
      console.error(`${word}: ${e.message}`);
    }
    await new Promise((r) => setTimeout(r, 400)); // be kind to free tiers
  }

  writeFileSync(TSV, rows.join("\n") + "\n", "utf8");
  console.log(`Added ${added} sentences to ${TSV}`);
}

main().catch((e) => {
  console.error(e);
  process.exit(1);
});
