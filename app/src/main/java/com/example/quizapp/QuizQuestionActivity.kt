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
        Log.i("Questions Size", "${questionsList.size}")

        val curPos = 1
        val curQuestion: Question? = questionsList[curPos - 1]

        pb_progress.progress = curPos
        tv_progress.text = "$curPos" + "/" + "${pb_progress.max}"

        tv_question.text = curQuestion!!.question
        iv_image.setImageResource(curQuestion.image)
        tv_option_one.text = curQuestion.options[0]
        tv_option_two.text = curQuestion.options[1]
        tv_option_three.text = curQuestion.options[2]
        tv_option_four.text = curQuestion.options[3]
    }
}
