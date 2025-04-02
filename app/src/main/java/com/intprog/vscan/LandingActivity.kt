package com.intprog.vscan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val button1 = findViewById<CardView>(R.id.button1)
        val button2 = findViewById<CardView>(R.id.button2)
        val button3 = findViewById<CardView>(R.id.button3)
        val button4 = findViewById<CardView>(R.id.button4)
        val settingsButton = findViewById<CardView>(R.id.settingsButton) // Find settings button

        button1.setOnClickListener {
            Toast.makeText(this, "Monitoring Clicked", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(this, "Guide Clicked", Toast.LENGTH_SHORT).show()
        }
        button3.setOnClickListener {
            Toast.makeText(this, "Tuning Clicked", Toast.LENGTH_SHORT).show()
        }
        button4.setOnClickListener {
            Toast.makeText(this, "Maps Clicked", Toast.LENGTH_SHORT).show()
        }
        settingsButton.setOnClickListener { // Listener for settings button
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}