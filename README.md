# Compose Effects

A collection of high-quality, reusable Jetpack Compose animations and effects.

## Modules

### [Matrix Rain](./compose-matrix-rain)
A configurable Matrix-style rain animation.

# Installation

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

```kotlin
dependencies {
    implementation("com.github.gugabrilhante:compose-matrix-rain:0.1.0")
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

# Local Testing

Explain how another Android project can consume the library using:

```bash
./gradlew :compose-matrix-rain:publishToMavenLocal
```

and:

```kotlin
repositories {
    mavenLocal()
}
```

## Demo App
The `:app` module contains a gallery to preview all available effects.

## License
MIT
