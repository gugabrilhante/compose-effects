package com.gustavo.brilhante.composeeffect.matrixrain

sealed interface MatrixRainShape {
    data object Full : MatrixRainShape
    data object InvertedTriangle : MatrixRainShape
    data object Triangle : MatrixRainShape
    data object CenterDiamond : MatrixRainShape
    data class Custom(
        val contains: (x: Float, y: Float, width: Float, height: Float) -> Boolean,
    ) : MatrixRainShape
}

internal fun MatrixRainShape.contains(
    x: Float,
    y: Float,
    width: Float,
    height: Float
): Boolean {
    val centerX = width / 2f
    val halfWidth = width / 2f
    val yRatio = (y / height).coerceIn(0f, 1f)

    return when (this) {
        MatrixRainShape.Full -> true

        MatrixRainShape.InvertedTriangle -> {
            val allowedHalfWidth = halfWidth * (1f - yRatio)
            kotlin.math.abs(x - centerX) <= allowedHalfWidth
        }

        MatrixRainShape.Triangle -> {
            val allowedHalfWidth = halfWidth * yRatio
            kotlin.math.abs(x - centerX) <= allowedHalfWidth
        }

        MatrixRainShape.CenterDiamond -> {
            val distanceFromMiddleY = kotlin.math.abs(y - (height / 2f)) / (height / 2f)
            val allowedHalfWidth = halfWidth * (1f - distanceFromMiddleY)
            kotlin.math.abs(x - centerX) <= allowedHalfWidth
        }

        is MatrixRainShape.Custom -> contains(x, y, width, height)
    }
}
