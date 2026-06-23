package com.gustavo.brilhante.compose_effects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.gustavo.brilhante.compose_effects.ui.screens.MainScreen
import com.gustavo.brilhante.compose_effects.ui.screens.MatrixRainPlayground
import com.gustavo.brilhante.compose_effects.ui.theme.ComposeeffectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeeffectsTheme {
                var currentScreen by remember { mutableStateOf("main") }
                
                when (currentScreen) {
                    "main" -> MainScreen(onNavigateToMatrixRain = { currentScreen = "matrix_rain" })
                    "matrix_rain" -> MatrixRainPlayground()
                }
            }
        }
    }
}
