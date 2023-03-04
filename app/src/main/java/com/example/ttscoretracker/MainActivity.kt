package com.example.ttscoretracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ttscoretracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyInterface {
    private lateinit var P1PointScore: TextView
    private lateinit var P2PointScore: TextView
    private lateinit var P1GameScore: TextView
    private lateinit var P2GameScore: TextView
    lateinit var binding: ActivityMainBinding

    var P1TotalPoints = 0
    var P2TotalPoints = 0
    var P1GameWon = 0
    var P2GameWon = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        P1PointScore = findViewById(R.id.pointScore1)
        P2PointScore = findViewById(R.id.pointScore2)
        P1GameScore = findViewById(R.id.gameScore)
        P2GameScore = findViewById(R.id.gameScore2)

        val message1 = intent.getStringExtra("player1")
        val message2 = intent.getStringExtra("player2")

        //for putting the names of the players
        val p1Name = findViewById<TextView>(R.id.textViewPlayer1).apply {
            text = message1
        }
        val p2Name = findViewById<TextView>(R.id.textViewPlayer2).apply {
            text = message2
        }
        val p1NameBut = findViewById<TextView>(R.id.player1Name).apply {
            text = message1
        }
        val p2NameBut = findViewById<TextView>(R.id.player2Name).apply {
            text = message2
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContaner, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun addPlayer1Point() {
        P1TotalPoints += 1

        val currentPoint1 = P1PointScore.text.toString()
        var newPoint1 = currentPoint1.toInt().inc()

        val currentPoint2 = P2PointScore.text.toString()
        var newPoint2 = currentPoint2.toInt()

        val currentGame1 = P1GameScore.text.toString()
        var newGame1 = currentGame1.toInt()

        if(newPoint1 >= 11 && (newPoint1 - newPoint2 >= 2) ) {
            P1GameWon += 1
            newGame1 += 1
            newPoint1 = 0
            newPoint2 = 0
        }

        if(newGame1 == 2) {
            resultIntent()
        }

        P1PointScore.text = newPoint1.toString()
        P2PointScore.text = newPoint2.toString()
        P1GameScore.text = newGame1.toString()
    }

    fun addPlayer2Point() {
        P2TotalPoints += 1

        val currentPoint1 = P1PointScore.text.toString()
        var newPoint1 = currentPoint1.toInt()

        val currentPoint2 = P2PointScore.text.toString()
        var newPoint2 = currentPoint2.toInt().inc()

        val currentGame2 = P2GameScore.text.toString()
        var newGame2 = currentGame2.toInt()

        if(newPoint2 >= 11 && (newPoint2 - newPoint1 >= 2) ) {
            P2GameWon += 1
            newGame2 += 1
            newPoint1 = 0
            newPoint2 = 0
        }

        if(newGame2 == 2) {
            resultIntent()
        }

        P1PointScore.text = newPoint1.toString()
        P2PointScore.text = newPoint2.toString()
        P2GameScore.text = newGame2.toString()
    }

    fun resultIntent() {
        val intent = Intent(this, ResultActivity::class.java).also {
            val message1 = intent.getStringExtra("player1")
            val message2 = intent.getStringExtra("player2")
            it.putExtra("player1",message1)
            it.putExtra("player2",message2)
            it.putExtra("p1TotalPoints",P1TotalPoints)
            it.putExtra("p2TotalPoints",P2TotalPoints)
            it.putExtra("p1GameWon", P1GameWon)
            it.putExtra("p2GameWon", P2GameWon)
            startActivity(it)
        }
    }

    override fun transferredMessage(msg: String) {
        if(msg == "p1Won") {
            replaceFragment(ServeFragment())
        }
        else if(msg == "p2Won") {
            replaceFragment(ServeP2Fragment())
        }
        else if(msg == "inPlay") {
            replaceFragment(RallyFragment())

        }
        else if(msg == "ace1" || msg == "fault2" || msg == "fhError2" || msg == "bhError2" || msg == "winner1") {
            addPlayer1Point()
        }
        else if(msg == "ace2" || msg == "fault1" || msg == "fhError1" || msg == "bhError1" || msg == "winner2") {
            addPlayer2Point()
        }
    }
}