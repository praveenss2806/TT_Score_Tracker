package com.example.ttscoretracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val inputButton = findViewById<Button>(R.id.inputButton)

        inputButton.setOnClickListener {
            callActivity()
        }
    }

    private fun callActivity() {
        val editText1 = findViewById<EditText>(R.id.editTextPlayer1)
        val player1 = editText1.text.toString()

        val editText2 = findViewById<EditText>(R.id.editTextPlayer2)
        val player2 = editText2.text.toString()

        if(editText1.text.isEmpty() || editText2.text.isEmpty()) {
            if(editText1.text.isEmpty()) {
                editText1.error = "This field is required"
            }
            if(editText2.text.isEmpty()) {
                editText2.error = "This field is required"
            }
        }
        else {
            val intent = Intent(this, MainActivity::class.java).also {
                val newPlayer1 = player1.mapIndexed { index, c ->
                    if (index == 0) c.uppercaseChar() else c
                }.joinToString("")

                val newPlayer2 = player2.mapIndexed { index, c ->
                    if (index == 0) c.uppercaseChar() else c
                }.joinToString("")

                it.putExtra("player1",newPlayer1)
                it.putExtra("player2",newPlayer2)
                startActivity(it)
            }
        }
    }
}