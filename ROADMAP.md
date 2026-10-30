# Roadmap

Total planned work to v1.0: **~90–110 hours**.

## Milestone 0 — Foundation (~8h)
- [ ] KMP + Compose Multiplatform skeleton, SQLDelight, Koin
- [ ] GitHub Actions: Android build, iOS framework build, shared tests
- [ ] `data/` folder with JSON schema validation in CI

## Milestone 1 — Units & conversion (~14h)
- [ ] Unit model: mass, volume, count, temperature
- [ ] Brazilian measures: xícara (240 ml), colher de sopa (15 ml), chá (5 ml), café (2.5 ml), copo americano (190 ml)
- [ ] Density dataset (first 80 common ingredients) with sources
- [ ] Converter screen: ingredient + amount + unit → all equivalents

## Milestone 2 — Ingredient parser (~14h)
- [ ] Tokenizer for pt-BR and English: fractions (1/2, ½), "e meia", ranges ("2 a 3"), "a gosto"
- [ ] Unit and ingredient-name extraction, notes in parentheses
- [ ] Golden-file corpus of 300+ ingredient lines

## Milestone 3 — Recipe box & scaling (~16h)
- [ ] Create/edit recipes; paste-to-parse
- [ ] Scale by servings or by a fixed ingredient amount
- [ ] Smart rounding rules (eggs, spoons, packages)
- [ ] Pan-size scaling (area-based)
- [ ] JSON import/export

## Milestone 4 — Substitutions (~12h)
- [ ] Rules engine: ingredient → alternatives with ratio, notes, "works best in"
- [ ] First 60 curated substitutions with sources
- [ ] Inline "substitute" action in recipes, auto-adjusting quantities

## Milestone 5 — Pantry & "cook with what you have" (~10h)
- [ ] Pantry list with quick add
- [ ] Match recipes by coverage, list what's missing
- [ ] Ingredient synonyms (aipim/mandioca/macaxeira)

## Milestone 6 — Nutrition & lighter version (~14h)
- [ ] Bundle a compact FoodData Central subset mapped to the density dataset
- [ ] Per-serving estimates for saved recipes
- [ ] "Lighter version" rules (swaps + cooking method) with before/after comparison

## Milestone 7 — Cooking mode & release (~10h)
- [ ] Step-by-step mode, keep screen on, step timers
- [ ] pt-BR and English UI, accessibility pass
- [ ] Play internal testing + TestFlight

## Later
- Shopping list from missing ingredients
- Share a recipe as a file/QR code (no server)
- Widgets (quick converter)
