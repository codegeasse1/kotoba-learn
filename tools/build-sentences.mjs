#!/usr/bin/env node
/**
 * Regenerates the offline "extra examples" corpora that ship inside the APK:
 *
 *   app/src/main/assets/sentences.tsv        `<japanese>\t<english>`   (~89k rows)
 *   app/src/main/assets/sentences_<lang>.tsv `<target>\t<english>`     (one per non-Japanese target)
 *
 * Source: the sentence-pair archives published by www.manythings.org/anki
 * (licence: CC-BY 2.0 FR — see docs/DATA-LICENSES.md). No API key, no model and
 * no network access is needed on the phone; only this build step downloads
 * anything.
 *
 * Usage:
 *   node tools/build-sentences.mjs                 # rebuild every language
 *   node tools/build-sentences.mjs --only ja,de    # just these
 *   node tools/build-sentences.mjs --max-ja 34 --max-en 64 --max-rows 45000
 *
 * Nothing here runs at app runtime: the app (Corpus.kt) just scans the bundled
 * file when a learner taps "More examples". The AI-written top-up files
 * (`sentences_gen_<lang>.tsv`, two sentences per taught word) are checked in
 * separately — see tools/build-ai-examples.mjs and docs/EXTRA-EXAMPLES.md.
 */

import { execFileSync } from "node:child_process";
import { mkdtempSync, writeFileSync } from "node:fs";
import { tmpdir } from "node:os";
import { join, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const ROOT = join(dirname(fileURLToPath(import.meta.url)), "..");
const ASSETS = join(ROOT, "app", "src", "main", "assets");

/**
 * `code` is the ISO 639-2 code www.manythings.org/anki uses in the archive name
 * (`<code>-eng.zip`) and inside it (`<code>.txt`).
 *
 * `script` rejects rows whose target column is not written in that language's own
 * script — the archives contain a few mis-tagged lines.
 */
const LANGS = {
  ja: { code: "jpn", script: /[\u3040-\u30ff\u4e00-\u9faf]/, maxTarget: 34, maxEn: 64, ja: true },
  hi: { code: "hin", script: /[\u0900-\u097f]/, maxTarget: 45, maxEn: 70 },
  es: { code: "spa", script: /^[\x20-\x7e\u00a0-\u024f]*$/, maxTarget: 45, maxEn: 70 },
  ar: { code: "ara", script: /[\u0600-\u06ff]/, maxTarget: 45, maxEn: 70 },
  fr: { code: "fra", script: /^[\x20-\x7e\u00a0-\u024f]*$/, maxTarget: 45, maxEn: 70 },
  de: { code: "deu", script: /^[\x20-\x7e\u00a0-\u024f]*$/, maxTarget: 45, maxEn: 70 },
  bn: { code: "ben", script: /[\u0980-\u09ff]/, maxTarget: 45, maxEn: 70 },
  ta: { code: "tam", script: /[\u0b80-\u0bff]/, maxTarget: 45, maxEn: 70 },
  te: { code: "tel", script: /[\u0c00-\u0c7f]/, maxTarget: 45, maxEn: 70 },
  ur: { code: "urd", script: /[\u0600-\u06ff]/, maxTarget: 45, maxEn: 70 },
  kn: { code: "kan", script: /[\u0c80-\u0cff]/, maxTarget: 45, maxEn: 70 },
};

function arg(name, fallback) {
  const i = process.argv.indexOf(name);
  return i >= 0 && process.argv[i + 1] ? process.argv[i + 1] : fallback;
}

const ONLY = arg("--only", "");
const MAX_ROWS = Number(arg("--max-rows", 45000));

async function build(lang, cfg) {
  if (cfg.ja) {
    cfg = { ...cfg, maxTarget: Number(arg("--max-ja", cfg.maxTarget)), maxEn: Number(arg("--max-en", cfg.maxEn)) };
  } else {
    cfg = { ...cfg, maxEn: Number(arg("--max-en", cfg.maxEn)) };
  }
  const work = mkdtempSync(join(tmpdir(), "kotoba-"));
  const zipPath = join(work, `${cfg.code}-eng.zip`);
  const url = `https://www.manythings.org/anki/${cfg.code}-eng.zip`;

  console.log(`[${lang}] downloading ${url} …`);
  const res = await fetch(url);
  if (!res.ok) throw new Error(`[${lang}] download failed: HTTP ${res.status}`);
  writeFileSync(zipPath, Buffer.from(await res.arrayBuffer()));

  // The archive holds `<code>.txt` (+ a _about.txt): english \t target \t attribution
  const txt = execFileSync("unzip", ["-p", zipPath, `${cfg.code}.txt`], {
    maxBuffer: 1024 * 1024 * 1024,
  }).toString("utf8");

  // One target sentence -> best (shortest) english translation.
  const best = new Map();
  for (const line of txt.split("\n")) {
    const parts = line.split("\t");
    if (parts.length < 2) continue;
    const en = parts[0].trim();
    const target = parts[1].trim();
    if (!en || !target) continue;
    if (target.length > cfg.maxTarget || en.length > cfg.maxEn) continue;
    if (!cfg.script.test(target)) continue;
    // Rows that carry a translator's parenthesis or a stray delimiter are
    // annotations, not sentences ("Tom forgot to pay the bill (at the shop)").
    if (/[|()]/.test(en) || /[|()]/.test(target)) continue;
    if (en.toLowerCase() === target.toLowerCase()) continue;
    const cur = best.get(target);
    if (cur === undefined || en.length < cur.length) best.set(target, en);
  }

  // Shortest sentences first, so "Load 10 more" starts with the easiest ones.
  let rows = [...best.entries()].sort((a, b) => a[0].length - b[0].length || a[0].localeCompare(b[0]));
  if (rows.length > MAX_ROWS) rows = rows.slice(0, MAX_ROWS);

  const file = cfg.ja ? "sentences.tsv" : `sentences_${lang}.tsv`;
  const body = rows.map(([target, en]) => target + "\t" + en + "\n").join("");
  writeFileSync(join(ASSETS, file), body, "utf8");
  console.log(`[${lang}] wrote ${rows.length} pairs (${(Buffer.byteLength(body) / 1024).toFixed(0)} KB) to ${file}`);
}

async function main() {
  const only = ONLY ? ONLY.split(",").map((s) => s.trim()).filter(Boolean) : Object.keys(LANGS);
  for (const lang of only) {
    const cfg = LANGS[lang];
    if (!cfg) {
      console.warn(`[${lang}] unknown language — skipping`);
      continue;
    }
    try {
      await build(lang, cfg);
    } catch (e) {
      console.error(`[${lang}] ${e.message}`);
    }
  }
  console.log("done — remember to keep docs/DATA-LICENSES.md in sync.");
}

main().catch((e) => {
  console.error(e);
  process.exit(1);
});
