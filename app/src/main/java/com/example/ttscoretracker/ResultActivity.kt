package com.example.ttscoretracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val message1 = intent.getStringExtra("player1")
        val message2 = intent.getStringExtra("player2")
        val p1Points = intent.getIntExtra("p1TotalPoints",0)
        val p2Points = intent.getIntExtra("p2TotalPoints",0)
        val p1Game = intent.getIntExtra("p1GameWon",0)
        val p2Game = intent.getIntExtra("p2GameWon",0)

        val p1Name = findViewById<TextView>(R.id.RA_Name1).apply {
            text = message1
        }
        val p2Name = findViewById<TextView>(R.id.RA_Name2).apply {
            text = message2
        }
        val p1TotPoint = findViewById<TextView>(R.id.P1_Points).apply {
            text = p1Points.toString()
        }
        val p2TotPoint = findViewById<TextView>(R.id.P2_Points).apply {
            text = p2Points.toString()
        }
        val p1TotGame = findViewById<TextView>(R.id.P1_Game).apply {
            text = p1Game.toString()
        }
        val p2TotGame = findViewById<TextView>(R.id.P2_Game).apply {
            text = p2Game.toString()
        }
    }
}