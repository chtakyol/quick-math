package com.example.quick_math.presentation.game_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quick_math.data.LocalUserStatisticsRepositoryImpl
import com.example.quick_math.presentation.game_screen.components.AnswerButton
import com.example.quick_math.presentation.game_screen.components.AnswerButtonType
import com.example.quick_math.presentation.game_screen.components.CustomProgressBar
import com.example.quick_math.presentation.game_screen.components.ScoreText
import com.example.quick_math.utils.Screen

@Composable
fun GameScreen(
    viewModel: GameScreenViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    val backgroundColor = Color(0xFFF0D9FF)
    var x by remember { mutableStateOf(true) }
    if (viewModel.state.progress.value == 0f && x) {
        navController.navigate(Screen.EndScreen.route)
        x = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(
            modifier = Modifier
                .size(width = 0.dp, height = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ScoreText(
                score = viewModel.state.score.value
            )
        }

        Spacer(
            modifier = Modifier
                .size(width = 0.dp, height = 36.dp)
        )

        CustomProgressBar(
            progress = viewModel.state.progress.value
        )

        Spacer(
            modifier = Modifier
                .size(width = 0.dp, height = 36.dp)
        )

        QuestionText(
            text = viewModel.state.firstNumberAsText
        )

        Spacer(
            modifier = Modifier
                .size(width = 0.dp, height = 36.dp)
        )

        QuestionText(
            text = viewModel.state.secondNumberAsText
        )

        Spacer(
            modifier = Modifier
                .size(width = 0.dp, height = 56.dp)
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AnswerButton(
                type = AnswerButtonType.AnswerButtonWithCheckIcon
            ) {
                viewModel.onEvent(GameScreenEvent.OnKeyPressed(true))
            }
            Spacer(
                modifier = Modifier
                    .size(width = 16.dp, height = 0.dp)
            )
            AnswerButton(
                type = AnswerButtonType.AnswerButtonWithCloseIcon
            ) {
                viewModel.onEvent(GameScreenEvent.OnKeyPressed(false))
            }
        }

    }
}

@Composable
@Preview
fun PreviewGameScreen() {
    GameScreen()
}