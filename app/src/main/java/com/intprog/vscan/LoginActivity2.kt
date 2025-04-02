package com.intprog.vscan

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

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
    }

    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            attemptLogin()
        }

        forgotPasswordTextView.setOnClickListener {
            handleForgotPasswordClick()
        }
    }

    private fun attemptLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Login attempt with Email: $email", Toast.LENGTH_SHORT).show()
    }

    private fun handleForgotPasswordClick() {

        Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show()
    }

}