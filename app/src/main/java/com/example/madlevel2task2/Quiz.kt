package com.example.madlevel2task2

import androidx.annotation.DrawableRes

data class Quiz(
    var question: String,
    var answer: Boolean
) {
    companion object {
        val QUIZ_QUESTIONS = arrayOf(
            "A \"var\" and a val are the same.",
            "Mobile Application Development grants 12 ECTS.",
            "A Unit in Kotlin corresponds to a void in Java.",
            "In Kotlin \"when\" replaces the \"switch\" operator in Java."
        )

        val QUIZ_ANSWERS = arrayOf(
            false,
            false,
            true,
            true
        )
    }
}