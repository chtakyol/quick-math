package com.example.quick_math.presentation.end_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreBoard(
    currentScore: Int = 4,
    highScore: Int = 16,
    modifier: Modifier = Modifier
) {
    val scoreBoardBackgroundColor = Color(0xFFF0D9FF)
    val scoreBoardBorderColor = Color(0xFF7F7C82)
    val textColor = Color(0xFFBFA2DB)

    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
                .size(width = 344.dp, height = 381.dp)
        ) {
            drawRoundRect(
                color = scoreBoardBackgroundColor,
                cornerRadius = CornerRadius(64f),
                size = size
            )
            drawRoundRect(
                color = scoreBoardBorderColor,
                cornerRadius = CornerRadius(64f),
                style = Stroke(
                    width = 4f,
                ),
                size = size
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "current score:",
                color = textColor,
                fontSize = 32.sp
            )
            Text(
                text = "$currentScore",
                color = textColor,
                fontSize = 64.sp
            )
            Text(
                text = "high score:",
                color = textColor,
                fontSize = 32.sp
            )
            Text(
                text = "$highScore",
                color = textColor,
                fontSize = 64.sp
            )
        }
    }
}

@Composable
@Preview
fun PreviewScoreBoard() {
    ScoreBoard()
}