package com.example.quick_math.presentation.end_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quick_math.domain.IStatisticsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EndScreenViewModel @Inject constructor(
    private val userStatisticsRepository: IStatisticsRepository
) : ViewModel() {

    val state by mutableStateOf(EndScreenState())
    var highScore = 0

    init {
        viewModelScope.launch {
            userStatisticsRepository.getStatistics(
                onSuccess = {
                    highScore = it.highScore
                },
                onError = {}
            )
        }
    }
}