# Compose Effects

A collection of high-quality, reusable Jetpack Compose animations and effects.

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

Then, add the dependency to your module's `build.gradle`:

```kotlin
dependencies {
    // Replace 'v0.1.6' with the latest release tag
    implementation("com.github.gugabrilhante:compose-effects:v0.1.6")
}
```

> **Note:** If you get a **401 Unauthorized** error, it means the repository is private. You need to log in to [JitPack](https://jitpack.io), get your API token, and add it to your `settings.gradle`:
> ```kotlin
> maven {
>     url = uri("https://jitpack.io")
>     credentials { username = "YOUR_JITPACK_TOKEN" }
> }
> ```

# Usage

```kotlin
MatrixRainAnimation(
    modifier = Modifier.fillMaxSize(),
    config = MatrixRainConfig(),
    shape = MatrixRainShape.Full
)
```

# Local Testing

If you want to test changes locally before publishing to JitPack:

1. In this project, run:
   ```bash
   ./gradlew :compose-matrix-rain:publishToMavenLocal
   ```

2. In your consumer project (e.g., Espiral7), add `mavenLocal()` to your repositories:
   ```kotlin
   repositories {
       mavenLocal()
       google()
       mavenCentral()
   }
   ```

3. Use the local version (make sure the version matches what is in `build.gradle.kts`):
   ```kotlin
   implementation("com.github.gugabrilhante:compose-effects:0.1.6")
   ```

## Demo App
The `:app` module contains a gallery to preview all available effects.

## License
MIT
