# Compose Effects

A collection of high-quality, reusable Jetpack Compose animations and effects.

## Demo

| Demo 01                                                          | Demo 03                                                             |
|------------------------------------------------------------------|---------------------------------------------------------------------|
| <img src="docs/matrix_demo_01.gif" width="100%" alt="fast rain"> | <img src="docs/matrix_demo_02.gif" width="100%" alt="Typing usage"> |

| List reminders — Light Mode                                        |
|--------------------------------------------------------------------|
| <img src="docs/matrix_demo_03.gif" width="100%" alt="Colors rain"> |


## Modules

### [Matrix Rain](./compose-matrix-rain)
A configurable Matrix-style rain animation.

# Installation

To use this library in your project, add the JitPack repository to your `settings.gradle` or root `build.gradle`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

Then, add the dependency to your module's `build.gradle` (Replace `vX.Y.Z` with the latest tag from [Releases](https://github.com/gugabrilhante/compose-effects/releases)):

```kotlin
dependencies {
    implementation("com.github.gugabrilhante:compose-effects:vX.Y.Z")
}
```

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
