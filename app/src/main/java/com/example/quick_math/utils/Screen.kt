package com.example.quick_math.utils

sealed class Screen(
    val route: String
) {
    object SplashScreen: Screen("splash_screen")
    object StartScreen: Screen("start_screen")
    object GameScreen: Screen("game_screen")
    object EndScreen: Screen("end_screen")
}