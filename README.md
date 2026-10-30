# Pitada

**An offline kitchen companion.** Scale recipes, convert Brazilian kitchen measures, find ingredient substitutions, see what you can cook with what's in your pantry, and get a lighter version of a recipe — all on your phone, without an account or internet connection.

> 🇧🇷 *Utilitário de cozinha offline: escalonar receitas, converter medidas (xícara, colher, copo americano), substituir ingredientes, improvisar com o que tem em casa e gerar uma versão mais leve.*

> **Status:** early development. See [ROADMAP.md](ROADMAP.md).

## Why

Recipe apps are mostly online catalogs with ads and accounts. The everyday problems in the kitchen are smaller and more practical:

- "This recipe serves 4, I need 10."
- "How many grams is 1 xícara of flour? And a copo americano of milk?"
- "I'm out of buttermilk — what can I use?"
- "What can I make with eggs, rice, tomato and cheese?"
- "Can I make this lighter without ruining it?"

Pitada answers these instantly, offline, with **Brazilian measures** as first-class citizens.

## Features (planned)

| Feature | Details |
|---|---|
| **Recipe scaling** | Scale by servings or by an ingredient you have a fixed amount of; smart rounding ("3 ovos", not "2,67 ovos"); pan-size scaling (round ↔ rectangular) |
| **Unit conversion** | Volume ↔ weight per ingredient density (1 xícara de farinha ≈ 120 g vs. 1 xícara de açúcar ≈ 180 g); xícara, colher de sopa/chá/café, copo americano, ml, g, oz, cups; oven temperature (°C, °F, gas mark) |
| **Substitutions** | Curated, explainable substitution rules with ratios and notes ("1 xícara de leitelho = 1 xícara de leite + 1 colher de sopa de limão, descansar 10 min") |
| **Cook with what you have** | Mark pantry items; get matching recipes from your collection, ranked by how few items are missing |
| **Lighter version** | Rule-based swaps (e.g. cream → yogurt, frying → air fryer/oven, sugar reduction ranges) with before/after nutrition estimates per serving |
| **Recipe box** | Save your own recipes; paste text and Pitada parses quantities and units; import/export JSON |
| **Cooking mode** | Step-by-step, screen stays on, timers per step |

Everything runs **on-device**. No AI service calls: substitutions and lighter versions come from a transparent, versioned rules dataset in this repository, so every suggestion can be explained and tested.

## Who it's for

Home cooks in Brazil (and Portuguese/English speakers in general) who want a fast, private, no-nonsense kitchen tool.

## Built with

- **Kotlin Multiplatform** + **Compose Multiplatform** (Android and iOS)
- **SQLDelight** — local database (recipes, pantry, rules)
- **kotlinx.serialization** — import/export, bundled datasets
- **Koin** — dependency injection
- Ingredient parser: hand-written tokenizer for pt-BR and English quantity phrases ("1 e 1/2 xícara (chá) de farinha de trigo")
- Nutrition data: **USDA FoodData Central** (public domain, CC0), bundled as a compact subset
- CI: GitHub Actions; `kotlin.test` + golden-file tests for the parser and conversions

## Architecture

```
composeApp/        Compose Multiplatform UI
iosApp/            Xcode host
shared/
  units/           Units, densities, conversion engine
  parser/          Ingredient-line parser (pt-BR / en)
  scaling/         Scaling + smart rounding
  rules/           Substitution and "lighter version" rules engine
  nutrition/       Nutrient lookup and per-serving estimates
  pantry/          Pantry and recipe matching
  data/            SQLDelight schema, import/export
data/
  densities.json   Ingredient densities (g per ml), with sources
  substitutions.json
  lighter-swaps.json
```

## Getting started

Requirements: JDK 17+, Android Studio, Xcode 16+ (iOS, macOS only).

```bash
git clone https://github.com/isaquefontinele/pitada.git
cd pitada
./gradlew :composeApp:installDebug   # Android
open iosApp/iosApp.xcodeproj         # iOS
./gradlew :shared:allTests           # shared tests
```

## A note on nutrition

Nutrition numbers are **estimates** for general information, derived from public food composition data. Pitada is not a diet app, does not track what you eat, and does not give medical or dietary advice.

## Data sources & attribution

- Nutrient data: U.S. Department of Agriculture, Agricultural Research Service. *FoodData Central*, https://fdc.nal.usda.gov/ (CC0 1.0).
- Densities and substitutions: compiled by the author; sources listed per entry in `data/`.
- Sample recipes in the repository are written by the author.

## Contributing

Corrections to densities and substitutions are especially welcome — every entry should cite a source. See [ROADMAP.md](ROADMAP.md) and [docs/REQUIREMENTS.md](docs/REQUIREMENTS.md).

## License

Code: [MIT](LICENSE) © 2026 Isaque Sales Domingos Fontinele.
