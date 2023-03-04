package com.example.ttscoretracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class RallyFragment:Fragment(R.layout.rally_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val winner1Button = view.findViewById<Button>(R.id.winner1)
        val winner2Button = view.findViewById<Button>(R.id.winner2)
        val fhError1Button = view.findViewById<Button>(R.id.fhError1)
        val fhError2Button = view.findViewById<Button>(R.id.fhError2)
        val bhError1Button = view.findViewById<Button>(R.id.bhError1)
        val bhError2Button = view.findViewById<Button>(R.id.bhError2)

        val myInterface = activity as MyInterface

        winner1Button.setOnClickListener {
            myInterface.transferredMessage("winner1")
        }
        winner2Button.setOnClickListener {
            myInterface.transferredMessage("winner2")
        }

        fhError1Button.setOnClickListener {
            myInterface.transferredMessage("fhError1")
        }
        fhError2Button.setOnClickListener {
            myInterface.transferredMessage("fhError2")
        }

        bhError1Button.setOnClickListener {
            myInterface.transferredMessage("bhError1")
        }
        bhError2Button.setOnClickListener {
            myInterface.transferredMessage("bhError2")
        }
    }
}