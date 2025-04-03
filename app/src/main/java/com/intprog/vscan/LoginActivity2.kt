package com.intprog.vscan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class LoginActivity2 : AppCompatActivity() {

    private lateinit var topRelativeLayout: LinearLayout
    private lateinit var mainRelativeLayout: RelativeLayout
    private lateinit var logoImageView: ImageView
    private lateinit var loginCardView: CardView
    private lateinit var loginTextView: TextView
    private lateinit var inputCardView: CardView
    private lateinit var inputLinearLayout: LinearLayout
    private lateinit var welcomeTextView: TextView
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        auth = FirebaseAuth.getInstance()

        setupUIElements()
        setupClickListeners()
    }

    private fun setupUIElements() {
        topRelativeLayout = findViewById(R.id.topRelativeLayout)
        mainRelativeLayout = findViewById(R.id.mainRelativeLayout)
        logoImageView = findViewById(R.id.logoImageView)
        loginCardView = findViewById(R.id.loginCardView)
        loginTextView = findViewById(R.id.loginTextView)
        inputCardView = findViewById(R.id.inputCardView)
        inputLinearLayout = findViewById(R.id.inputLinearLayout)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        emailTextInputLayout = findViewById(R.id.emailTextInputLayout)
        emailEditText = findViewById(R.id.emailEditText)
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout)
        passwordEditText = findViewById(R.id.passwordEditText)
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)
    }

    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            attemptLogin()
        }

        forgotPasswordTextView.setOnClickListener {
            handleForgotPasswordClick()
        }

        registerButton.setOnClickListener {
            Log.i("LoginActivity", "Register Button is clicked")
            val i = Intent(this, RegisterActivity::class.java)
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
    }

}