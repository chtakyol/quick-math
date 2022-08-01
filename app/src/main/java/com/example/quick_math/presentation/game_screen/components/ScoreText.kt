package com.example.quick_math.presentation.game_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ScoreText(
    score: Int = 4
) {
    val textColor = Color(0xFFBFA2DB)

    Text(
        text = "Score: $score",
        color = textColor,
        fontSize = 24.sp
    )
}

@Composable
@Preview
fun PreviewScoreText() {
    ScoreText()
}