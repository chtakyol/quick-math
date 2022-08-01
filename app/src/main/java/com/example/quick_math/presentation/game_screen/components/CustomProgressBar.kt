package com.example.quick_math.presentation.game_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomProgressBar(
    progress: Float = 1f
) {
    val progressBarForegroundColor = Color(0xFFBFA2DB)
    val progressBarOutlineColor = Color(0xFFBFA2DB)
    val progressBarBackgroundColor = Color(0xFFF0D9FF)

    Canvas(
        modifier = Modifier
            .size(width = 344.dp, height = 16.dp)
    ) {
        drawRect(
            color = progressBarBackgroundColor,
            size = size
        )

        drawRect(
            color = progressBarOutlineColor,
            style = Stroke(
                width = 4f
            ),
            size = size
        )

        drawRect(
            color = progressBarForegroundColor,
            size = Size(width = size.width * progress, height = size.height)
        )
    }
}

@Composable
@Preview
fun PreviewProgressBar() {
    CustomProgressBar(.4f)
}