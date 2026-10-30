# CLAUDE.md

Guidance for Claude Code (and humans) working in this repository.

## Project

Pitada is an offline kitchen utility for Android and iOS: recipe scaling, Brazilian kitchen
measure conversion (xícara, colheres, copo americano) per ingredient, substitutions, pantry
matching and rule-based "lighter versions". See [README.md](README.md),
[ROADMAP.md](ROADMAP.md) and [docs/REQUIREMENTS.md](docs/REQUIREMENTS.md).

Hard constraints (from the requirements):

- **Offline and private.** No network permission for core features, no accounts, no analytics,
  no remote AI services. Suggestions come from versioned rule datasets in `data/`.
- **Explainable.** Every density, substitution and swap entry in `data/` cites a source.
- **Shared logic.** Conversion, parsing, scaling and rules live in `shared/` so Android and iOS
  produce identical results. Target ≥ 90% test coverage for conversion and parser code.
- Nutrition numbers are estimates only; never add diet tracking or health advice.

## Stack

- Kotlin Multiplatform, Compose Multiplatform (Android + iOS)
- SQLDelight (local database), kotlinx.serialization (import/export, bundled datasets)
- Koin (dependency injection)
- `kotlin.test` + golden-file tests
- Versions are pinned in [gradle/libs.versions.toml](gradle/libs.versions.toml).

## Module layout

```
composeApp/   Compose Multiplatform UI; Android application + iOS framework (ComposeApp)
iosApp/       Xcode host that embeds the ComposeApp framework
shared/       Platform-independent logic (KMP library: android, iosArm64, iosSimulatorArm64)
  src/commonMain/kotlin/dev/pitada/shared/
    data/       SQLDelight database factory and repositories
    di/         Koin modules
  src/commonMain/sqldelight/   .sq schema files (database name: PitadaDatabase)
data/         JSON datasets (densities, substitutions, lighter swaps) — planned
```

Planned `shared` packages: `units`, `parser`, `scaling`, `rules`, `nutrition`, `pantry`, `data`.
Keep them as packages inside `shared` until there is a real reason to split modules.

Base package: `dev.pitada` (`dev.pitada.app` for the UI, `dev.pitada.shared` for logic).

## Build and test

Requirements: JDK 17+, Android SDK (compileSdk 36), Xcode 16+ for iOS.

```bash
./gradlew :composeApp:assembleDebug      # build the Android app
./gradlew :composeApp:installDebug       # install on a device/emulator
./gradlew :shared:allTests               # shared tests (Android unit + iOS simulator)
./gradlew :shared:testDebugUnitTest      # shared tests, JVM only (fast)
./gradlew :composeApp:linkDebugFrameworkIosSimulatorArm64   # iOS framework
open iosApp/iosApp.xcodeproj             # run on iOS
```

## Conventions

- Docs, code, identifiers and commit messages in **English**. UI strings in pt-BR and English.
- Small, focused commits. Reference issues in the message (`Closes #N`) when a commit finishes one.
- Put logic in `shared/commonMain`; platform code only behind `expect`/`actual` or Koin bindings.
- Pure functions for conversion/scaling/parsing; test them in `shared/src/commonTest`.
- New dependencies go through the version catalog; avoid anything that needs network access.
- Never commit secrets, signing keys or `local.properties` (see `.gitignore`).
- Datasets in `data/` must cite a source per entry.
