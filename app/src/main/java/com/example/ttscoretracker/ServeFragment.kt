package com.example.ttscoretracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class ServeFragment:Fragment(R.layout.serve_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myPlayButton = view.findViewById<Button>(R.id.play1)
        val aceButton = view.findViewById<Button>(R.id.ace1)
        val faultButton = view.findViewById<Button>(R.id.fault1)

        val myInterface = activity as MyInterface

        myPlayButton.setOnClickListener {
            myInterface.transferredMessage("inPlay")
        }

        aceButton.setOnClickListener {
            myInterface.transferredMessage("ace1")
        }

        faultButton.setOnClickListener {
            myInterface.transferredMessage("fault1")
        }
    }
}