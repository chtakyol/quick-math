package com.example.quick_math.presentation.game_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

sealed class AnswerButtonType {
    object AnswerButtonWithCheckIcon: AnswerButtonType()
    object AnswerButtonWithCloseIcon: AnswerButtonType()
}

@Composable
fun AnswerButton(
    type: AnswerButtonType = AnswerButtonType.AnswerButtonWithCheckIcon,
    onClick: () -> Unit
) {
    val buttonBackgroundColor = Color(0xFFBFA2DB)
    val buttonBorderColor = Color(0xFF7F7C82)
    val textColor = Color(0xFFF3F1F5)
    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(width = 146.dp, height = 114.dp)
                .clickable { onClick() }
        ) {
            drawRoundRect(
                color = buttonBackgroundColor,
                cornerRadius = CornerRadius(64f),
                size = size
            )
            drawRoundRect(
                color = buttonBorderColor,
                cornerRadius = CornerRadius(64f),
                style = Stroke(
                    width = 4f,
                ),
                size = size
            )
        }

        val icon = when (type) {
            is AnswerButtonType.AnswerButtonWithCheckIcon -> {
                Icons.Default.Check
            }
            AnswerButtonType.AnswerButtonWithCloseIcon -> {
                Icons.Default.Close
            }
        }

        Icon(
            imageVector = icon,
            contentDescription = "Button Icon",
            modifier = Modifier.size(96.dp),
            tint = textColor
        )
    }
}

@Composable
@Preview
fun PreviewAnswerButton() {
    AnswerButton {

    }
}