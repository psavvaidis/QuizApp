package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        action_btn.setOnClickListener{
            if(player_name.text.toString().isEmpty()){
                Toast.makeText(
                    this,
                    "You must enter your name to play",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, player_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
