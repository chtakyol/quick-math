package com.example.quick_math

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quick_math.presentation.game_screen.GameScreen
import com.example.quick_math.presentation.start_screen.StartScreen
import com.example.quick_math.ui.theme.QuickmathTheme
import com.example.quick_math.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            QuickmathTheme() {
                NavHost(
                    navController = navController,
                    startDestination = Screen.StartScreen.route
                ) {
                    composable(
                        route = Screen.SplashScreen.route
                    ) {
                        // TODO add splash screen
                    }

                    composable(
                        route = Screen.StartScreen.route
                    ) {
                        StartScreen(
                            navController = navController
                        )
                    }

                    composable(
                        route = Screen.GameScreen.route
                    ) {
                        GameScreen(
                            navController = navController
                        )
                    }

                    composable(
                        route = Screen.EndScreen.route
                    ) {

                    }
                }
            }
        }
    }
}
