package com.intprog.vscan.ui.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.intprog.vscan.databinding.ActivityMainAccountBinding

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainAccountBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        binding = ActivityMainAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}