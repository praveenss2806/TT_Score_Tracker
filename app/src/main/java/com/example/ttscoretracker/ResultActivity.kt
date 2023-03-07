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

        val p1Ace = intent.getIntExtra("ace1",0)
        val p2Ace = intent.getIntExtra("ace2",0)
        val p1Fault = intent.getIntExtra("fault1",0)
        val p2Fault = intent.getIntExtra("fault2",0)
        val p1Winner = intent.getIntExtra("winner1",0)
        val p2Winner = intent.getIntExtra("winner2",0)
        val p1FhError = intent.getIntExtra("fhError1",0)
        val p2FhError = intent.getIntExtra("fhError2",0)
        val p1BhError = intent.getIntExtra("bhError1",0)
        val p2BhError = intent.getIntExtra("bhError2",0)
        val p1ReturnError = intent.getIntExtra("returnError1",0)
        val p2ReturnError = intent.getIntExtra("returnError2",0)

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

        val p1ToAce = findViewById<TextView>(R.id.P1_Ace).apply {
            text = p1Ace.toString()
        }
        val p2ToAce = findViewById<TextView>(R.id.P2_Ace).apply {
            text = p2Ace.toString()
        }
        val p1ToFault = findViewById<TextView>(R.id.P1_Fault).apply {
            text = p1Fault.toString()
        }
        val p2ToFault = findViewById<TextView>(R.id.P2_Fault).apply {
            text = p2Fault.toString()
        }

        val p1ToWinner = findViewById<TextView>(R.id.P1_Winner).apply {
            text = p1Winner.toString()
        }
        val p2ToWinner = findViewById<TextView>(R.id.P2_Winner).apply {
            text = p2Winner.toString()
        }
        val p1ToFhError = findViewById<TextView>(R.id.P1_FhError).apply {
            text = p1FhError.toString()
        }
        val p2ToFhError = findViewById<TextView>(R.id.P2_FhError).apply {
            text = p2FhError.toString()
        }
        val p1ToBhError = findViewById<TextView>(R.id.P1_BhError).apply {
            text = p1BhError.toString()
        }
        val p2ToBhError = findViewById<TextView>(R.id.P2_BhError).apply {
            text = p2BhError.toString()
        }
        val p1ToReturnError = findViewById<TextView>(R.id.P1_ReturnError).apply {
            text = p1ReturnError.toString()
        }
        val p2ToReturnError = findViewById<TextView>(R.id.P2_ReturnError).apply {
            text = p2ReturnError.toString()
        }
    }
}