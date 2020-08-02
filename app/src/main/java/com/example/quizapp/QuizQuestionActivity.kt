package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionsList = Constants.getQuestions()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion(){

        val curQuestion = mQuestionsList!![mCurrentPosition - 1]

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        defaultOptionsView()
        pb_progress.progress = mCurrentPosition
        tv_progress.text = """$mCurrentPosition/${pb_progress.max}"""

        tv_question.text = curQuestion.question
        iv_image.setImageResource(curQuestion.image)
        tv_option_one.text = curQuestion.options[0]
        tv_option_two.text = curQuestion.options[1]
        tv_option_three.text = curQuestion.options[2]
        tv_option_four.text = curQuestion.options[3]
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->
                selectedOptionView(tv_option_one, 1)
            R.id.tv_option_two ->
                selectedOptionView(tv_option_two, 2)
            R.id.tv_option_three ->
                selectedOptionView(tv_option_three, 3)
            R.id.tv_option_four ->
                selectedOptionView(tv_option_four, 4)
            R.id.btn_submit ->
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        (mCurrentPosition) <= mQuestionsList!!.size -> {
                            setQuestion()
                        }else -> {
                            Toast.makeText(this, "You have successfully completed the quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctOption != mSelectedOptionPosition){
                        answerview(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerview(question.correctOption, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList?.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
        }
    }

    private fun answerview(answer: Int, drawableView: Int){
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNumber: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}
