package com.example.ttscoretracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class ServeP2Fragment:Fragment(R.layout.servep2_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myPlayButton = view.findViewById<Button>(R.id.play2)
        val aceButton = view.findViewById<Button>(R.id.ace2)
        val faultButton = view.findViewById<Button>(R.id.fault2)
        val returnErrorButton = view.findViewById<Button>(R.id.returnError2)

        val myInterface = activity as MyInterface

        myPlayButton.setOnClickListener {
            myInterface.transferredMessage("inPlay")
        }

        aceButton.setOnClickListener {
            myInterface.transferredMessage("ace2")
        }

        faultButton.setOnClickListener {
            myInterface.transferredMessage("fault2")
        }

        returnErrorButton.setOnClickListener {
            myInterface.transferredMessage("returnError1")
        }
    }
}