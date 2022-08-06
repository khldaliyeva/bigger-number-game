package com.example.biggernumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout = findViewById(R.id.constraintLayout)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)

        assignNumbersToButtons()
        btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonClicked: Boolean) {
        val numLeft = btnLeft.text.toString().toInt()
        val numRight = btnRight.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonClicked) numLeft > numRight else numRight > numLeft

        constraintLayout.setBackgroundColor(if(isAnswerCorrect) Color.GREEN else Color.RED)
        Toast.makeText(this, if(isAnswerCorrect) "Correct!" else "Wrong!", Toast.LENGTH_SHORT).show()
    }

    private fun assignNumbersToButtons() {
        val numLeft = (1..10).random()
        var numRight = numLeft

        while (numRight == numLeft)
            numRight = (1..10).random()

        btnLeft.text = numLeft.toString()
        btnRight.text = numRight.toString()
    }
}