# Matrix Rain Animation (Jetpack Compose)

A highly configurable Matrix-style rain animation for Jetpack Compose, supporting various shapes and custom configurations.

## Preview

(GIF will be added later)

## Installation

Add the module to your project and include it in your `build.gradle.kts`:

```kotlin
implementation(project(":compose-matrix-rain"))
```

## Usage

### Basic Usage

```kotlin
MatrixRain(modifier = Modifier.fillMaxSize())
```

### Custom Configuration

```kotlin
MatrixRain(
    modifier = Modifier.fillMaxSize(),
    config = MatrixRainConfig(
        color = Color.Green,
        charSize = 16.sp,
        speedRange = 3f..7f
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
| `frameDelayMillis` | `Long` | `80L` |
| `speedRange` | `ClosedFloatingPointRange<Float>` | `2f..5f` |
| `trailLengthRange` | `IntRange` | `4..14` |

### MatrixRainShape
* `Full`: Fills the entire available space.
* `Triangle`: Fills in a triangular pattern.
* `InvertedTriangle`: Fills in an inverted triangular pattern.
* `CenterDiamond`: Fills in a diamond pattern from the center.
* `Custom`: Define your own logic based on `(x, y, width, height)`.

## License

MIT
