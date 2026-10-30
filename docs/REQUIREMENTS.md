# Requirements — Pitada

## 1. Goal
A fast, offline, private kitchen utility for Android and iOS focused on scaling, conversions, substitutions and cooking with what's available.

## 2. Functional requirements

| ID | Requirement |
|---|---|
| FR-01 | Convert between mass and volume units per ingredient, including Brazilian kitchen measures. |
| FR-02 | Convert oven temperatures (°C, °F, gas mark). |
| FR-03 | Parse free-text ingredient lines in pt-BR and English into quantity, unit, ingredient and notes. |
| FR-04 | Save, edit, delete recipes locally; import/export JSON. |
| FR-05 | Scale a recipe by servings or by a fixed amount of one ingredient, with smart rounding. |
| FR-06 | Scale between pan sizes and shapes. |
| FR-07 | Suggest substitutions for an ingredient, each with ratio, notes and source. |
| FR-08 | Maintain a pantry list and rank saved recipes by ingredient coverage. |
| FR-09 | Estimate nutrition per serving from bundled public data. |
| FR-10 | Generate a "lighter version" of a recipe from transparent swap rules, showing what changed. |
| FR-11 | Cooking mode with step timers and screen kept awake. |
| FR-12 | UI in Portuguese (pt-BR) and English. |

## 3. Non-functional requirements

| ID | Requirement |
|---|---|
| NFR-01 | Fully functional offline; no network permission needed for core features. |
| NFR-02 | No accounts, analytics or remote AI services; all suggestions are rule-based and explainable. |
| NFR-03 | All data stays on the device; export is user-initiated. |
| NFR-04 | Conversion and parser logic in shared code with ≥ 90% test coverage. |
| NFR-05 | Every density, substitution and swap entry in `data/` cites a source; CI validates the schema. |
| NFR-06 | App size < 25 MB; cold start < 1.5 s on mid-range devices. |
| NFR-07 | Accessibility: screen reader labels, dynamic type, sufficient contrast. |

## 4. Out of scope
- Food diaries, calorie targets, weight tracking or any health/diet advice.
- Online recipe catalog or scraping third-party recipe sites.
- Accounts or cloud sync (may be revisited via user-owned files).

## 5. Data & licensing
- FoodData Central: CC0 1.0, attribution given in README and About screen.
- Author-written datasets and sample recipes are MIT along with the code.

## 6. Acceptance criteria for v1.0
- 80+ ingredient densities, 60+ substitutions, 25+ lighter swaps, all sourced.
- Parser passes the golden corpus; scaling and conversion verified by unit tests.
- App runs on Android and iOS with identical results from shared logic.
