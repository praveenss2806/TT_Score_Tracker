package com.example.ttscoretracker

import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var P1PointScore: TextView;
    private lateinit var P2PointScore: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        P1PointScore = findViewById(R.id.pointScore1);
        P2PointScore = findViewById(R.id.pointScore2);
    }

    fun addPlayer1Point(view: View) {
        val currentPoint = P1PointScore.text.toString();
        val newPoint = currentPoint.toInt().inc();
        P1PointScore.text = newPoint.toString();
    }

    fun addPlayer2Point(view: View) {
        val currentPoint = P2PointScore.text.toString();
        val newPoint = currentPoint.toInt().inc();
        P2PointScore.text = newPoint.toString();
    }
}