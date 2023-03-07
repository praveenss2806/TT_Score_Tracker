package com.example.ttscoretracker

import android.content.Intent
import android.os.Build.VERSION_CODES.S
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
    var P1Ace = 0
    var P2Ace = 0
    var P1Fault = 0
    var P2Fault = 0
    var P1Winner = 0
    var P2Winner = 0
    var P1FhError = 0
    var P2FhError = 0
    var P1BhError = 0
    var P2BhError = 0
    var P1ReturnError = 0
    var P2ReturnError = 0
    var serveSwitch = ""

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
            it.putExtra("ace1",P1Ace)
            it.putExtra("ace2",P2Ace)
            it.putExtra("fault1",P1Fault)
            it.putExtra("fault2",P2Fault)
            it.putExtra("winner1", P1Winner)
            it.putExtra("winner2", P2Winner)
            it.putExtra("fhError1",P1FhError)
            it.putExtra("fhError2",P2FhError)
            it.putExtra("bhError1", P1BhError)
            it.putExtra("bhError2", P2BhError)
            it.putExtra("returnError1", P1ReturnError)
            it.putExtra("returnError2", P2ReturnError)

            startActivity(it)
        }
    }

    override fun transferredMessage(msg: String) {
        if(msg == "p1Won") {
            serveSwitch = "p11"
            replaceFragment(ServeFragment())
        }
        else if(msg == "p2Won") {
            serveSwitch = "p21"
            replaceFragment(ServeP2Fragment())
        }
        else if(msg == "inPlay") {
            replaceFragment(RallyFragment())
        }
        else if(msg == "ace1" || msg == "fault2" || msg == "fhError2" || msg == "bhError2" || msg == "winner1" || msg == "returnError2") {
            addPlayer1Point()
            updateStats(msg)
            changeServe()
        }
        else if(msg == "ace2" || msg == "fault1" || msg == "fhError1" || msg == "bhError1" || msg == "winner2" || msg == "returnError1") {
            addPlayer2Point()
            updateStats(msg)
            changeServe()
        }
    }

    //function to change serve every 2 points
    fun changeServe() {
        if(serveSwitch == "p11") {
            serveSwitch = "p12"
            replaceFragment(ServeFragment())
        }
        else if(serveSwitch == "p12") {
            serveSwitch = "p21"
            replaceFragment(ServeP2Fragment())
        }
        else if(serveSwitch == "p21") {
            serveSwitch = "p22"
            replaceFragment(ServeP2Fragment())
        }
        else if(serveSwitch == "p22") {
            serveSwitch = "p11"
            replaceFragment(ServeFragment())
        }
    }

    //function to update the stats of the match
    fun updateStats(msg: String) {
        if(msg == "ace1") {
            P1Ace += 1;
        }
        else if(msg == "ace2") {
            P2Ace += 1;
        }
        else if(msg == "fault1") {
            P1Fault += 1
        }
        else if(msg == "fault2") {
            P2Fault += 1
        }
        else if(msg == "winner1") {
            P1Winner += 1
        }
        else if(msg == "winner2") {
            P2Winner += 1
        }
        else if(msg == "fhError1") {
            P1FhError += 1
        }
        else if(msg == "fhError2") {
            P2FhError += 1
        }
        else if(msg == "bhError1") {
            P1BhError += 1
        }
        else if(msg == "bhError2") {
            P2BhError += 1
        }
        else if(msg == "returnError1") {
            P1ReturnError += 1
        }
        else if(msg == "returnError2") {
            P2ReturnError += 1
        }
    }
}