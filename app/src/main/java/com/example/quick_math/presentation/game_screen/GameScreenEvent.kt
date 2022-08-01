package com.example.quick_math.presentation.game_screen

sealed class GameScreenEvent {
    data class OnKeyPressed(val data: Boolean): GameScreenEvent()
}
