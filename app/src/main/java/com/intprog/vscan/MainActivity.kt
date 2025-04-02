package com.intprog.vscan

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Simulates a splash screen
        var i = 3
        val textView: TextView = findViewById(R.id.tv_test1)
        lifecycleScope.launch{
            while (i > 0) {
                i.toString().also { textView.text = it }
                delay(500)
                i--
            }
            startActivity(Intent(this@MainActivity, LoginActivity2::class.java))
            finish()
        }
    }
}