package com.gustavo.brilhante.composeeffect.matrixrain

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun MatrixRainAnimation(
    modifier: Modifier = Modifier,
    config: MatrixRainConfig = MatrixRainConfig(),
    shape: MatrixRainShape = MatrixRainShape.Full,
) {
    val density = LocalDensity.current
    val charSizePx = with(density) { config.charSize.toPx() }
    
    var size by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }
    val columns = remember(size.width, charSizePx) {
        if (size.width > 0) (size.width / charSizePx).toInt() else 0
    }
    
    val columnStates = remember(columns, config) {
        List(columns) { 
            MatrixColumnState(config) 
        }
    }

    LaunchedEffect(config.frameDelayMillis, columnStates, size.height) {
        if (size.height <= 0) return@LaunchedEffect
        val maxCharOffset = size.height / charSizePx
        while (true) {
            columnStates.forEach { it.tick(maxCharOffset) }
            delay(config.frameDelayMillis)
        }
    }

    Canvas(modifier = modifier) {
        size = this.size
        if (columns > 0) {
            drawIntoCanvas { canvas ->
                val paint = Paint().apply {
                    textSize = charSizePx
                    isAntiAlias = true
                    typeface = Typeface.MONOSPACE
                }

                columnStates.forEachIndexed { columnIndex, state ->
                    // Apply density factor
                    if (Random(columnIndex).nextFloat() > config.densityFactor) return@forEachIndexed

                    val x = columnIndex * charSizePx
                    state.chars.forEachIndexed { charIndex, char ->
                        val y = (state.yOffset + charIndex) * charSizePx
                        
                        if ((y > 0) && (y < (size.height + charSizePx)) && shape.contains(x, y, size.width, size.height)) {
                            paint.color = if (charIndex == state.chars.lastIndex) {
                                config.headColor.toArgb()
                            } else {
                                val alpha = (charIndex.toFloat() / state.chars.size).coerceIn(0.1f, 1f)
                                config.color.copy(alpha = alpha).toArgb()
                            }
                            canvas.nativeCanvas.drawText(char.toString(), x, y, paint)
                        }
                    }
                }
            }
        }
    }
}

private class MatrixColumnState(val config: MatrixRainConfig) {
    var chars by mutableStateOf(emptyList<Char>())
    var yOffset by mutableFloatStateOf(0f)
    private var speed = Random.nextFloat() * (config.speedRange.endInclusive - config.speedRange.start) + config.speedRange.start
    private var trailLength = Random.nextInt(config.trailLengthRange.first, config.trailLengthRange.last + 1)

    init {
        reset(initial = true)
    }

    private fun reset(initial: Boolean = false) {
        yOffset = if (initial) Random.nextFloat() * -100f else -trailLength.toFloat()
        chars = List(trailLength) { config.chars.random() }
        speed = Random.nextFloat() * (config.speedRange.endInclusive - config.speedRange.start) + config.speedRange.start
        trailLength = Random.nextInt(config.trailLengthRange.first, config.trailLengthRange.last + 1)
    }

    fun tick(maxHeight: Float) {
        yOffset += speed
        if (yOffset > maxHeight) {
             if (Random.nextFloat() < 0.01f) {
                 reset()
             }
        }
        // Occasionally change characters for the flickering effect
        if (Random.nextFloat() < config.shuffleRate) {
            chars = chars.map { if (Random.nextFloat() < config.shuffleRate) config.chars.random() else it }
        }
    }
}
