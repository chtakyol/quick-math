package com.example.quick_math.presentation.start_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    title: String = "Title"
) {

    val textColor = Color(0xFFBFA2DB)
    val textOutlineColor = Color(0xFF7F7C82)

    Text(
        text = title,
        fontSize = 64.sp,
        color = textColor
    )
}

@Composable
@Preview
fun PreviewTitleText() {
    TitleText()
}