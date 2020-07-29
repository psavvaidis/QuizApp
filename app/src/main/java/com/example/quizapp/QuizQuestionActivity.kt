package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionsList = Constants.getQuestions()
        questionsnum.text = "Questions Size ${questionsList.size}"
        Log.i("Questions Size", "${questionsList.size}")
    }
}
