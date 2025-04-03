package com.intprog.vscan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val email = findViewById<android.widget.EditText>(R.id.etEmail).text.toString()
            val password = findViewById<android.widget.EditText>(R.id.etPassword).text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Log.i("RegisterActivity", "Email or Password must not be empty")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("RegisterActivity", "Registration successful")
                    } else {
                        Log.w("RegisterActivity", "Registration failed", task.exception)
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            Log.i("RegisterActivity", "Invalid email format")
                        } else if (task.exception is FirebaseAuthWeakPasswordException) {
                            Log.i("RegisterActivity", "Weak password")
                        } else {
                            Log.i("RegisterActivity", "Registration failed: ${task.exception?.message}")
                        }
                    }
                }

            startActivity(Intent(this, LoginActivity2::class.java))
            finish()
        }
    }
}