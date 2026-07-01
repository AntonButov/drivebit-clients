# AGENTS.md

## Cursor Cloud specific instructions

Drivebit Clients is a Kotlin Multiplatform / Compose Multiplatform front-end (no backend in this repo)
delivering one product as three clients from `:composeApp`:

- **Web** (`js(IR)`, Compose-for-Web / DOM) — the only client testable headlessly in this VM.
- **Android** — buildable here (SDK installed), needs an emulator/device to actually run.
- **iOS** — requires macOS + Xcode; cannot be built or run in this Linux VM.

Standard commands live in `README.md` and `.cursorrules`; run/lint/test/build commands are not duplicated here.
Note: `README.md`/`.cursorrules` say the web target is `wasmJs` — that is outdated. The real web target is
`js(IR)`, so the correct dev command is `./gradlew :composeApp:jsBrowserDevelopmentRun` (serves on
`http://localhost:8080`), and the production build is `./gradlew :composeApp:jsBrowserDistribution`.

### Environment (already provisioned in the VM snapshot)

- **JDK 17** is used for all Gradle builds (matches CI). It is pinned via `~/.gradle/gradle.properties`
  (`org.gradle.java.home`), so `./gradlew` uses JDK 17 even though the system default `java` is JDK 21.
  Do not rely on `JAVA_HOME` from the shell.
- **Android SDK** is installed at `~/android-sdk`. Gradle finds it via `/workspace/local.properties`
  (`sdk.dir=...`), which is git-ignored and persists in the snapshot. The `:composeApp` module applies the
  Android application plugin, so the SDK must be resolvable to configure/build *any* target (including web).
- These are one-off setup steps; a fresh shell needs no `export`s to run Gradle.

### Non-obvious caveats

- **Web app crashes on canvas re-render in headless Chrome.** The web app renders via Skiko/WebGL
  (`skiko.wasm`, ~8MB). In this VM's software WebGL (SwiftShader), a Compose canvas re-render after an
  interaction (e.g. selecting a filter) can crash the renderer ("Aw, Snap!" / Compose crash screen). The
  initial load and a first interaction render correctly. This is an environment GPU limitation, not an app
  bug — expect this when demoing the web UI headlessly and capture evidence from the first render/interaction.
- **Images load from GitHub Pages** (`https://antonbutov.github.io/drivebit-clients/images`) at runtime;
  without internet, the logo/hero images show as broken placeholders but the UI still works.
- `ktlint` runs with `ignoreFailures = true`, so `ktlintCheck` reports style warnings but still passes.
- Do not run `./gradlew clean` without explicit permission (per `.cursorrules`).
