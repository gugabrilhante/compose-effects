package com.gustavo.brilhante.compose_effects.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = MatrixDemoColors.Primary,
    onPrimary = MatrixDemoColors.OnPrimary,
    primaryContainer = MatrixDemoColors.PrimaryContainer,
    onPrimaryContainer = MatrixDemoColors.OnPrimaryContainer,
    secondary = MatrixDemoColors.Secondary,
    onSecondary = MatrixDemoColors.OnSecondary,
    secondaryContainer = MatrixDemoColors.SecondaryContainer,
    onSecondaryContainer = MatrixDemoColors.OnSecondaryContainer,
    tertiary = MatrixDemoColors.Tertiary,
    onTertiary = MatrixDemoColors.OnTertiary,
    background = MatrixDemoColors.Background,
    onBackground = MatrixDemoColors.OnBackground,
    surface = MatrixDemoColors.Surface,
    onSurface = MatrixDemoColors.OnSurface,
    surfaceVariant = MatrixDemoColors.SurfaceVariant,
    onSurfaceVariant = MatrixDemoColors.OnSurfaceVariant,
    outline = MatrixDemoColors.Outline,
    outlineVariant = MatrixDemoColors.OutlineVariant,
    error = MatrixDemoColors.Error,
    onError = MatrixDemoColors.OnError,
)

@Composable
fun MatrixDemoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = MatrixDemoTypography,
        content = content
    )
}
