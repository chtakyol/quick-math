package com.example.quick_math.presentation.game_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun QuestionText(
    text: String = "Text"
) {

    val textColor = Color(0xFFBFA2DB)

    Text(
        text = text,
        color = textColor,
        fontSize = 108.sp
    )
}

@Composable
@Preview
fun PreviewQuestionText() {
    QuestionText()
}