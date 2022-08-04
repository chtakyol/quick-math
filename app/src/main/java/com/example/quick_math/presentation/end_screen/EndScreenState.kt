package com.example.quick_math.presentation.end_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class EndScreenState(
    var currentScore: MutableState<Int> =  mutableStateOf(0),
    var bestScore: MutableState<Int> =  mutableStateOf(0)
)
