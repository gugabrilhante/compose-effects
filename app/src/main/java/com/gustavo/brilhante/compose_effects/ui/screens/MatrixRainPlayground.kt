package com.gustavo.brilhante.compose_effects.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.gustavo.brilhante.compose_effects.ui.theme.MatrixDemoColors
import com.gustavo.brilhante.compose_effects.ui.theme.MatrixDemoTheme
import com.gustavo.brilhante.composeeffect.matrixrain.MatrixRain
import com.gustavo.brilhante.composeeffect.matrixrain.MatrixRainConfig
import com.gustavo.brilhante.composeeffect.matrixrain.MatrixRainShape
import java.util.Locale

@Composable
fun MatrixRainPlayground() {
    var config by remember { mutableStateOf(MatrixRainConfig()) }
    var selectedShape by remember { mutableStateOf<MatrixRainShape>(MatrixRainShape.Full) }
    var isSettingsOpen by remember { mutableStateOf(false) }

    MatrixDemoTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MatrixDemoColors.Background)
        ) {
            MatrixRain(
                modifier = Modifier.fillMaxSize(),
                config = config,
                shape = selectedShape
            )

            // Top Bar
            MatrixTopBar(
                onSettingsClick = { isSettingsOpen = true }
            )

            // Bottom Selector
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 48.dp)
            ) {
                GeometrySelector(
                    selectedShape = selectedShape,
                    onShapeSelected = { selectedShape = it }
                )
            }

            if (isSettingsOpen) {
                SettingsOverlay(
                    config = config,
                    onConfigChange = { config = it },
                    onClose = { isSettingsOpen = false },
                    onReset = { config = MatrixRainConfig() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatrixTopBar(onSettingsClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black.copy(alpha = 0.7f),
            titleContentColor = MatrixDemoColors.OnBackground
        ),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(36.dp),
                    color = MatrixDemoColors.SurfaceVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(4.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MatrixDemoColors.OutlineVariant.copy(alpha = 0.3f))
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Terminal,
                            contentDescription = null,
                            tint = MatrixDemoColors.Cyan,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        "MATRIX RAIN",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                    )
                    Text(
                        "COMPOSE UI EFFECT",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            color = MatrixDemoColors.OnSurfaceVariant,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = MatrixDemoColors.OnBackground
                )
            }
        }
    )
}

@Composable
fun GeometrySelector(
    selectedShape: MatrixRainShape,
    onShapeSelected: (MatrixRainShape) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "SELECT GEOMETRY",
            style = MaterialTheme.typography.labelMedium,
            color = MatrixDemoColors.OnSurfaceVariant.copy(alpha = 0.8f),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MatrixDemoColors.GlassBackground)
                .border(1.dp, MatrixDemoColors.GlassBorder, RoundedCornerShape(8.dp))
                .padding(6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ShapeOption("Full", MatrixRainShape.Full, selectedShape == MatrixRainShape.Full) { onShapeSelected(it) }
            ShapeOption("Triangle", MatrixRainShape.Triangle, selectedShape == MatrixRainShape.Triangle) { onShapeSelected(it) }
            ShapeOption("Inverted", MatrixRainShape.InvertedTriangle, selectedShape == MatrixRainShape.InvertedTriangle) { onShapeSelected(it) }
            ShapeOption("Diamond", MatrixRainShape.CenterDiamond, selectedShape == MatrixRainShape.CenterDiamond) { onShapeSelected(it) }
        }
    }
}

@Composable
fun ShapeOption(
    label: String,
    shape: MatrixRainShape,
    isSelected: Boolean,
    onClick: (MatrixRainShape) -> Unit
) {
    val borderColor = if (isSelected) MatrixDemoColors.Cyan else Color.Transparent
    val backgroundColor = if (isSelected) MatrixDemoColors.Cyan.copy(alpha = 0.15f) else Color.Transparent
    
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(4.dp))
            .then(
                if (isSelected) Modifier.shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(4.dp),
                    ambientColor = MatrixDemoColors.Cyan,
                    spotColor = MatrixDemoColors.Cyan
                ) else Modifier
            )
            .clickable { onClick(shape) }
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            color = if (isSelected) MatrixDemoColors.Cyan else MatrixDemoColors.OnSurfaceVariant,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
        )
    }
}

@Composable
fun SettingsOverlay(
    config: MatrixRainConfig,
    onConfigChange: (MatrixRainConfig) -> Unit,
    onClose: () -> Unit,
    onReset: () -> Unit
) {
    Dialog(onDismissRequest = onClose) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .border(1.dp, MatrixDemoColors.OutlineVariant.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = MatrixDemoColors.Surface),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .background(MatrixDemoColors.Cyan)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            "OPTIONS",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp
                            ),
                            color = MatrixDemoColors.OnSurface
                        )
                    }
                    IconButton(onClick = onClose) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = MatrixDemoColors.OnSurfaceVariant)
                    }
                }

                HorizontalDivider(color = MatrixDemoColors.OutlineVariant.copy(alpha = 0.5f))

                // Scrollable content for smaller screens
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SettingSlider(
                        label = "SPEED",
                        value = (160L - config.frameDelayMillis).toFloat(),
                        range = 10f..150f,
                        displayValue = String.format(Locale.ROOT, "%.2f", (160L - config.frameDelayMillis) / 100f),
                        onValueChange = { onConfigChange(config.copy(frameDelayMillis = 160L - it.toLong())) }
                    )

                    SettingSlider(
                        label = "CHARACTER SIZE",
                        value = config.charSize.value,
                        range = 8f..32f,
                        displayValue = "${config.charSize.value.toInt()}px",
                        onValueChange = { onConfigChange(config.copy(charSize = it.sp)) }
                    )

                    SettingSlider(
                        label = "COLUMN DENSITY",
                        value = config.densityFactor,
                        range = 0.2f..1f,
                        displayValue = if (config.densityFactor < 0.5f) "Low" else if (config.densityFactor < 0.8f) "Medium" else "High",
                        onValueChange = { onConfigChange(config.copy(densityFactor = it)) }
                    )

                    SettingSlider(
                        label = "TRAIL LENGTH",
                        value = config.trailLengthRange.last.toFloat(),
                        range = 5f..30f,
                        displayValue = if (config.trailLengthRange.last < 10) "Short" else if (config.trailLengthRange.last < 20) "Medium" else "Long",
                        onValueChange = { 
                            val last = it.toInt()
                            val first = (last / 3).coerceAtLeast(2)
                            onConfigChange(config.copy(trailLengthRange = first..last)) 
                        }
                    )
                    
                    SettingSlider(
                        label = "SHUFFLE RATE",
                        value = config.shuffleRate,
                        range = 0f..1.5f,
                        displayValue = String.format(Locale.ROOT, "%.2fs", config.shuffleRate),
                        onValueChange = { onConfigChange(config.copy(shuffleRate = it)) }
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Colors
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        ColorPickerItem(
                            label = "COLUMN COLOR",
                            selectedColor = config.color,
                            onColorSelect = { onConfigChange(config.copy(color = it)) }
                        )
                        ColorPickerItem(
                            label = "HEAD COLOR",
                            selectedColor = config.headColor,
                            onColorSelect = { onConfigChange(config.copy(headColor = it)) }
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onReset,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MatrixDemoColors.Cyan.copy(alpha = 0.1f),
                            contentColor = MatrixDemoColors.Cyan
                        ),
                        shape = RoundedCornerShape(4.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, MatrixDemoColors.Cyan.copy(alpha = 0.5f))
                    ) {
                        Text(
                            "RESET TO DEFAULT", 
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SettingSlider(
    label: String,
    value: Float,
    range: ClosedFloatingPointRange<Float>,
    displayValue: String,
    onValueChange: (Float) -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, style = MaterialTheme.typography.labelSmall, color = MatrixDemoColors.OnSurfaceVariant)
            Text(displayValue, style = MaterialTheme.typography.labelSmall, color = MatrixDemoColors.OnSurface)
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = range,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = MatrixDemoColors.Cyan,
                inactiveTrackColor = MatrixDemoColors.SurfaceVariant
            )
        )
    }
}

@Composable
fun RowScope.ColorPickerItem(
    label: String,
    selectedColor: Color,
    onColorSelect: (Color) -> Unit
) {
    val colors = listOf(
        MatrixDemoColors.Cyan,
        Color(0xFF00FF41), // Classic Matrix Green
        Color(0xFFD1BCFF), // Neon Purple
        Color(0xFF74F5FF), // Blue
        Color.White
    )

    Column(modifier = Modifier.weight(1f)) {
        Text(label, style = MaterialTheme.typography.labelSmall, color = MatrixDemoColors.OnSurfaceVariant)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MatrixDemoColors.SurfaceVariant.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                .border(1.dp, MatrixDemoColors.OutlineVariant.copy(alpha = 0.2f), RoundedCornerShape(4.dp))
                .clickable { 
                    val nextIndex = (colors.indexOf(selectedColor) + 1) % colors.size
                    onColorSelect(colors[if (nextIndex == -1) 0 else nextIndex])
                }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(selectedColor, RoundedCornerShape(2.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "#${selectedColor.toHex()}",
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                color = MatrixDemoColors.OnSurface
            )
        }
    }
}

fun Color.toHex(): String {
    return Integer.toHexString(this.toArgb()).uppercase().takeLast(6)
}
