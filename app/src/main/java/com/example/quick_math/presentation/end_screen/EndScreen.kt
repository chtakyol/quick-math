package com.example.quick_math.presentation.end_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

    Column {
        ScoreBoard(
            currentScore = viewModel.state.currentScore,
            highScore = viewModel.highScore
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