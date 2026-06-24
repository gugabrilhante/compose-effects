package com.gustavo.brilhante.composeeffect.matrixrain

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class MatrixRainConfig(
    val chars: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&*+-=<>!?",
    val color: Color = Color(0xFF4DFFEE),
    val headColor: Color = Color.White,
    val charSize: TextUnit = 14.sp,
    val fontFamily: FontFamily = FontFamily.Monospace,
    val frameDelayMillis: Long = 16L,
    val speedRange: ClosedFloatingPointRange<Float> = 0.1f..0.4f,
    val trailLengthRange: IntRange = 14..24,
    val densityFactor: Float = 0.8f,
    val shuffleRate: Float = 0.25f,
)
