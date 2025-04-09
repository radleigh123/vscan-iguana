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

   /* private fun setupClickListeners() {
        loginButton.setOnClickListener {
            attemptLogin()
        }

        forgotPasswordTextView.setOnClickListener {
            handleForgotPasswordClick()
        }

        registerButton.setOnClickListener {
            Log.i("LoginActivity", "Register Button is clicked")
            val i = Intent(this, RegisterFragment::class.java)
            startActivity(i)
        }

        forgotPasswordTextView.setOnClickListener {
            Log.i("LoginActivity", "Forgot Password Text Button is clicked")
            val i = Intent(this, ForgotPassword::class.java)
            startActivity(i)
        }
    }

    private fun attemptLogin() {
        // TODO: Logic implementations to be separated later

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        // TEMP: For now login directly for debugging
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                Log.d("LoginActivity", "email: $email, password: $password")
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(this, "Welcome, ${user?.email}!", Toast.LENGTH_LONG).show()
//                    updateUI(user) // TODO: Implement updateUI method
                    Log.d("LoginActivity", "Login successful")
                    startActivity(Intent(this, LandingActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Authentication failed: Account does not exist", Toast.LENGTH_LONG).show()
                }
            }

//        Toast.makeText(this, "Login attempt with Email: $email", Toast.LENGTH_SHORT).show()
    }

    private fun handleForgotPasswordClick() {

        Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show()
    }

    private fun attemptLogout() {
        auth.signOut()
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
    }*/

}