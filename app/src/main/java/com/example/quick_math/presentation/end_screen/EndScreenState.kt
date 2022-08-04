package com.example.quick_math.presentation.end_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class EndScreenState(
    var currentScore: Int = 0,
    var bestScore: Int = 0
)
