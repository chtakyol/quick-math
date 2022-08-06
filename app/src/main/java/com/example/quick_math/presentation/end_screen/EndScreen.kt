package com.example.quick_math.presentation.end_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quick_math.components.PlayButton
import com.example.quick_math.presentation.end_screen.components.ScoreBoard
import com.example.quick_math.utils.Screen

@Composable
fun EndScreen(
    viewModel: EndScreenViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    val backgroundColor = Color(0xFFF0D9FF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScoreBoard(
            currentScore = viewModel.state.currentScore.value,
            highScore = viewModel.state.bestScore.value
        )
        
        Spacer(
            modifier = Modifier
                .size(16.dp)
        )

        PlayButton() {
            navController.navigate(Screen.GameScreen.route)
        }
    }
}

@Composable
@Preview
fun PreviewEndScreen() {
    EndScreen()
}