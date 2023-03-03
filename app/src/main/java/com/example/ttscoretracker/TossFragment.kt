package com.example.ttscoretracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class TossFragment:Fragment(R.layout.toss_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myLeftButton = view.findViewById<Button>(R.id.left_toss_button)
        val myRightButton = view.findViewById<Button>(R.id.right_toss_button)

        val myInterface = activity as MyInterface

        myLeftButton.setOnClickListener {
            myInterface.transferredMessage("p1Won")
        }

        myRightButton.setOnClickListener {
            myInterface.transferredMessage("p2Won")
        }
    }
}