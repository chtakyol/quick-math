package com.example.quick_math.utils

import kotlin.random.Random

object QuestionCreator {

    var firstNumber: Int? = null
    var secondNumber: Int? = null

    fun getQuestion(): String {
        firstNumber = Random.nextInt(0, 10)
        secondNumber = Random.nextInt(0, 10)
        val operator = "+"

        return "$firstNumber $operator $secondNumber"
    }

    fun getRightAnswer(): String {
        val answer = firstNumber!! + secondNumber!!
        return "= $answer"
    }

    fun getWrongAnswer(): String {
        return "= ${Random.nextInt(0, 19)}"
    }
}