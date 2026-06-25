<h1 align="center">✨ Compose Effects</h1>

<p align="center">
  <b><i>Build high-quality Jetpack Compose UI with stunning animations.</i></b>
</p>

<p align="center">
  A collection of high-quality, reusable Jetpack Compose animations and effects designed to be simple to integrate and highly configurable.
</p>

<p align="center">
  <a href="https://jitpack.io/#gugabrilhante/compose-effects">
    <img src="https://jitpack.io/v/gugabrilhante/compose-effects.svg" alt="JitPack Release">
  </a>
  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/license-MIT-green.svg" alt="License MIT">
  </a>
</p>

---

## Demo

| Demo 01 | Demo 02 |
| :---: | :---: |
| <img src="docs/matrix_demo_01.gif" width="100%" alt="fast rain"> | <img src="docs/matrix_demo_02.gif" width="100%" alt="Typing usage"> |


## Modules

### [Matrix Rain](./compose-matrix-rain)
A highly configurable Matrix-style rain animation.

# Installation

To use this library in your project, add the JitPack repository to your `settings.gradle` or root `build.gradle`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Then, add the dependency to your module's `build.gradle` (Replace `vX.Y.Z` with the latest tag from [Releases](https://github.com/gugabrilhante/compose-effects/releases)):

```kotlin
dependencies {
    implementation("com.github.gugabrilhante:compose-effects:vX.Y.Z")
}
```

## 🤖 AI Assistant Prompt

If you are using an AI coding assistant (like Cursor, Windsurf, or GitHub Copilot), you can use this prompt to automate the installation:

> "Please install the `compose-effects` library in this project. Add the JitPack repository to `settings.gradle.kts` and add the dependency `com.github.gugabrilhante:compose-effects:vX.Y.Z` to my app's `build.gradle.kts`. Use the latest version from the project's releases."

# Usage

```kotlin
MatrixRainAnimation(
    modifier = Modifier.fillMaxSize(),
    config = MatrixRainConfig(),
    shape = MatrixRainShape.Full
)
```

## Demo App
The `:app` module contains a gallery to preview all available effects.

## License
MIT
