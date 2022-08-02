package com.example.quick_math.presentation.game_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class GameScreenState(
    var score: MutableState<Int> = mutableStateOf(0),
    var progress: MutableState<Float> = mutableStateOf(1f),
    val firstNumberAsText: String = "",
    val secondNumberAsText: String = "",
    var isStarted: MutableState<Boolean> = mutableStateOf(false)
)
