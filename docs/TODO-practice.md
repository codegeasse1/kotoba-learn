# TODO — practice/quiz randomisation (v1.18.0)

User asks:
1. Practice always shows the same 10 questions -> randomise; ~1000 drills per topic.
2. Same for the vocab quiz.
3. "Practice random grammar" only showed one category's questions -> mix categories.
4. "Load 10 more" button in practice and quiz too.
5. Works for all native languages / all learning languages.

Plan:
- [ ] `tools/practice-recipes.mjs` — bilingual recipe data + reference generator.
- [ ] `tools/build-practice.mjs` — writes `assets/practice_drills.txt` (DSL).
- [ ] `app/src/main/assets/practice_drills.txt` — generated DSL, shipped offline.
- [ ] `Practice.kt` — interpreter + pooled pools + Load 10 more + mixed session.
- [ ] `Grammar.kt` — random grammar opens a mixed session.
- [ ] `Learn.kt` — quiz draws from a bigger pool; "10 more questions".
- [ ] version bump + docs.
