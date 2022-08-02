package com.example.quick_math.presentation.game_screen

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quick_math.utils.QuestionCreator
import kotlin.random.Random

class GameScreenViewModel: ViewModel() {

    var state by mutableStateOf(GameScreenState())

    private var isSecondNumberRight by mutableStateOf(false)

    val durationForEachQuestion = 2500L

    private var countDownTimer: CountDownTimer? = null

    init {
        getNextQuestion()
    }

    fun onEvent(event: GameScreenEvent) {
        when(event) {
            is GameScreenEvent.OnKeyPressed -> {
                val isAnswerTrue = event.data == isSecondNumberRight
                if(isAnswerTrue) {
                    state.score.value++
                    countDownTimer?.cancel()
                    state.isStarted.value = true
                    getNextQuestion()
                } else {
                    Log.d("GameScreen", "Lost")
                    state.progress.value = 0f
                }
            }
        }
    }

    private fun getNextQuestion() {
        QuestionCreator.getQuestion().let {
            state = state.copy(
                firstNumberAsText = it
            )
        }

        val randomBool = Random.nextBoolean()
        if(randomBool) {
            QuestionCreator.getRightAnswer().let {
                state = state.copy(
                    secondNumberAsText = it
                )
            }
            isSecondNumberRight = true
        } else {
            QuestionCreator.getWrongAnswer().let {
                state = state.copy(
                    secondNumberAsText = it
                )
            }
            isSecondNumberRight = false
        }

        startTimer()
    }

    private fun startTimer() {
        if (state.isStarted.value) {
            countDownTimer = object: CountDownTimer(durationForEachQuestion, 50L) {
                override fun onTick(p0: Long) {
                    state.progress.value = p0.toFloat()/durationForEachQuestion.toFloat()
                }

                override fun onFinish() {
                    state.progress.value = 0f
                }
            }.start()
        }
    }
}