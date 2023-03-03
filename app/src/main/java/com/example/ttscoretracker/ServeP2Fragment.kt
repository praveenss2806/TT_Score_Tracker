package com.example.ttscoretracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class ServeP2Fragment:Fragment(R.layout.servep2_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myPlayButton = view.findViewById<Button>(R.id.play2)

        val myInterface = activity as MyInterface

        myPlayButton.setOnClickListener {
            myInterface.transferredMessage("inPlay")
        }
    }
}