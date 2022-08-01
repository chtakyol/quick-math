package com.example.quick_math.presentation.start_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quick_math.components.PlayButton
import com.example.quick_math.presentation.start_screen.components.TitleText
import com.example.quick_math.utils.Screen

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val backgroundColor = Color(0xFFF0D9FF)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TODO add app logo

        TitleText(
            title = "Quick Math"
        )
        
        Spacer(
            modifier = modifier.size(
                width = 0.dp, height = 36.dp
            )
        )

        PlayButton() {
            navController.navigate(Screen.GameScreen.route)
            Log.d("StartScreen", "Button clicked!")
        }
    }
}

@Composable
@Preview
fun PreviewStartScreen() {
    StartScreen()
}