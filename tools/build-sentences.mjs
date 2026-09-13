#!/usr/bin/env node
/**
 * Regenerates `app/src/main/assets/sentences.tsv` — the offline "extra examples"
 * corpus that ships inside the APK.
 *
 * Source: the Tatoeba sentence pairs published by www.manythings.org/anki
 * (licence: CC-BY 2.0 FR — see docs/DATA-LICENSES.md). No API key, no model and
 * no network access is needed on the phone; only this build step downloads
 * anything.
 *
 * Usage:
 *   node tools/build-sentences.mjs
 *   node tools/build-sentences.mjs --max-ja 34 --max-en 64
 *
 * Output format: two columns, tab separated, no header:
 *   <japanese>\t<english>
 *
 * The app (Corpus.kt) scans this file when a learner taps "More examples".
 */

import { execFileSync } from "node:child_process";
import { mkdtempSync, writeFileSync, readFileSync, existsSync } from "node:fs";
import { tmpdir } from "node:os";
import { join, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const ROOT = join(dirname(fileURLToPath(import.meta.url)), "..");
const OUT = join(ROOT, "app", "src", "main", "assets", "sentences.tsv");
const ZIP_URL = "https://www.manythings.org/anki/jpn-eng.zip";

function arg(name, fallback) {
  const i = process.argv.indexOf(name);
  return i >= 0 && process.argv[i + 1] ? Number(process.argv[i + 1]) : fallback;
}

const MAX_JA = arg("--max-ja", 34);
const MAX_EN = arg("--max-en", 64);

async function main() {
  const work = mkdtempSync(join(tmpdir(), "kotoba-"));
  const zipPath = join(work, "jpn-eng.zip");

  console.log(`Downloading ${ZIP_URL} …`);
  const res = await fetch(ZIP_URL);
  if (!res.ok) throw new Error(`Download failed: HTTP ${res.status}`);
  writeFileSync(zipPath, Buffer.from(await res.arrayBuffer()));

  // The archive holds a single tab separated file: english \t japanese \t attribution
  const txt = execFileSync("unzip", ["-p", zipPath, "jpn.txt"], {
    maxBuffer: 512 * 1024 * 1024,
  }).toString("utf8");

  // One japanese sentence -> best (shortest) english translation.
  const best = new Map();
  for (const line of txt.split("\n")) {
    const parts = line.split("\t");
    if (parts.length < 2) continue;
    const en = parts[0].trim();
    const ja = parts[1].trim();
    if (!en || !ja) continue;
    if (ja.length > MAX_JA || en.length > MAX_EN) continue;
    // Keep only rows whose "japanese" column really is Japanese.
    if (!/[\u3040-\u30ff\u4e00-\u9faf]/.test(ja)) continue;
    const cur = best.get(ja);
    if (cur === undefined || en.length < cur.length) best.set(ja, en);
  }

  const rows = [...best.entries()].sort((a, b) => a[0].localeCompare(b[0], "ja"));
  let out = "";
  for (const [ja, en] of rows) out += ja + "\t" + en + "\n";
  writeFileSync(OUT, out, "utf8");

  const kb = (Buffer.byteLength(out, "utf8") / 1024).toFixed(0);
  console.log(`Wrote ${rows.length} sentence pairs (${kb} KB) to ${OUT}`);
}

main().catch((e) => {
  console.error(e);
  process.exit(1);
});
