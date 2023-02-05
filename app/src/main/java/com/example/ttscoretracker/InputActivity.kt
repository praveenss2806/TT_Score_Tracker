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

        val intent = Intent(this, MainActivity::class.java).also {
            it.putExtra("player1",player1)
            it.putExtra("player2",player2)
            startActivity(it)
        }
    }
}