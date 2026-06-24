# Matrix Rain Animation (Jetpack Compose)

A highly configurable Matrix-style rain animation for Jetpack Compose, supporting various shapes and custom configurations.

## Preview

| Demo 01                                                          | Demo 03                                                             |
|------------------------------------------------------------------|---------------------------------------------------------------------|
| <img src="docs/matrix_demo_01.gif" width="100%" alt="fast rain"> | <img src="docs/matrix_demo_02.gif" width="100%" alt="Typing usage"> |

| List reminders — Light Mode                                        |
|--------------------------------------------------------------------|
| <img src="docs/matrix_demo_03.gif" width="100%" alt="Colors rain"> |


## Installation

Add the dependency to your `build.gradle.kts`:

```kotlin
implementation("com.github.gugabrilhante.compose-effects:compose-matrix-rain:v0.1.0")
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

### MatrixRainShape
* `Full`: Fills the entire available space.
* `Triangle`: Fills in a triangular pattern.
* `InvertedTriangle`: Fills in an inverted triangular pattern.
* `CenterDiamond`: Fills in a diamond pattern from the center.
* `Custom`: Define your own logic based on `(x, y, width, height)`.

## License

MIT
