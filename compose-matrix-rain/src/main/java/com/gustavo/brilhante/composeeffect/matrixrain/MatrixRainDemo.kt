package com.gustavo.brilhante.composeeffect.matrixrain

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MatrixRainDemo() {
    var selectedShape by remember { mutableStateOf<MatrixRainShape>(MatrixRainShape.Full) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        MatrixRain(
            modifier = Modifier.fillMaxSize(),
            shape = selectedShape
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Select Shape", color = Color.White, style = MaterialTheme.typography.titleMedium)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { selectedShape = MatrixRainShape.Full }) { Text("Full") }
                Button(onClick = { selectedShape = MatrixRainShape.Triangle }) { Text("Triangle") }
                Button(onClick = { selectedShape = MatrixRainShape.InvertedTriangle }) { Text("Inverted") }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { selectedShape = MatrixRainShape.CenterDiamond }) { Text("Diamond") }
            }
        }
    }
}
