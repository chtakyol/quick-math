package com.example.quick_math.presentation.end_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EndScreenViewModel: ViewModel() {

    val state by mutableStateOf(EndScreenState())

    init {
        // TODO get scores from data layer
    }
}