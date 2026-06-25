# Matrix Rain Animation (Jetpack Compose)

A highly configurable Matrix-style rain animation for Jetpack Compose, supporting various shapes and custom configurations.

## Installation

### 1. Add JitPack to your `settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### 2. Add the dependency

#### Using Version Catalog (`libs.versions.toml` - Recommended)

Replace `vX.Y.Z` with the latest tag from [Releases](https://github.com/gugabrilhante/compose-effects/releases):

```toml
[versions]
matrix-rain = "vX.Y.Z"

[libraries]
matrix-rain = { module = "com.github.gugabrilhante:compose-effects", version.ref = "matrix-rain" }
```

Then in your `build.gradle.kts`:

```kotlin
dependencies {
    implementation(libs.matrix.rain)
}
```

#### Direct implementation

Replace `vX.Y.Z` with the latest tag from [Releases](https://github.com/gugabrilhante/compose-effects/releases):

```kotlin
dependencies {
    implementation("com.github.gugabrilhante:compose-effects:vX.Y.Z")
}
```

## Usage

### Basic Usage

```kotlin
MatrixRainAnimation(modifier = Modifier.fillMaxSize())
```

### Custom Configuration

```kotlin
MatrixRainAnimation(
    modifier = Modifier.fillMaxSize(),
    config = MatrixRainConfig(
        color = Color.Green,
        charSize = 16.sp,
        speedRange = 0.1f..0.4f
    ),
    shape = MatrixRainShape.Triangle
)
```

## Features

* **Configurable API**: Adjust colors, characters, speed, density, and more via `MatrixRainConfig`.
* **Shape Strategies**: Choose from built-in shapes (`Full`, `Triangle`, `InvertedTriangle`, `CenterDiamond`) or provide a `Custom` shape logic.
* **Lightweight**: Optimized for performance using Compose Canvas.

## API Reference

### MatrixRainConfig
| Property | Type | Default |
| --- | --- | --- |
| `chars` | `String` | "ABCDEFGHIJKLMNOPQRSTUVWXYZ..." |
| `color` | `Color` | `Color(0xFF4DFFEE)` |
| `headColor` | `Color` | `Color.White` |
| `charSize` | `TextUnit` | `14.sp` |
| `frameDelayMillis` | `Long` | `16L` |
| `speedRange` | `ClosedFloatingPointRange<Float>` | `0.1f..0.4f` |
| `trailLengthRange` | `IntRange` | `4..14` |
| `densityFactor` | `Float` | `0.8f` |
| `shuffleRate` | `Float` | `0.1f` |

### MatrixRainShape
* `Full`: Fills the entire available space.
* `Triangle`: Fills in a triangular pattern.
* `InvertedTriangle`: Fills in an inverted triangular pattern.
* `CenterDiamond`: Fills in a diamond pattern from the center.
* `Custom`: Define your own logic based on `(x, y, width, height)`.

## License

MIT
