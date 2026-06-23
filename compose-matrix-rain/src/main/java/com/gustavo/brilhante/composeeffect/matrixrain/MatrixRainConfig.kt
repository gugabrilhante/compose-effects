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
    val frameDelayMillis: Long = 80L,
    val speedRange: ClosedFloatingPointRange<Float> = 2f..5f,
    val trailLengthRange: IntRange = 4..14,
    val densityFactor: Float = 0.8f,
    val shuffleRate: Float = 0.1f,
)
