package com.intprog.vscan.ui.home

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.intprog.vscan.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileNameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var contactNumberEditText: EditText
    private lateinit var emailAddressEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var logoutButton: Button
    private lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initializeViews()

        loadProfileData()

        setupClickListeners()
    }

    /**
     * Find all UI elements by their IDs and assign them to our properties
     */
    private fun initializeViews() {
        profileNameEditText = findViewById(R.id.profileNameEditText)
        addressEditText = findViewById(R.id.addressEditText)
        contactNumberEditText = findViewById(R.id.contactNumberEditText)
        emailAddressEditText = findViewById(R.id.emailAddressEditText)

        saveButton = findViewById(R.id.saveButton)
        logoutButton = findViewById(R.id.logoutButton)

        backArrow = findViewById(R.id.ivBackArrow)
    }

    /**
     * Set up all click listeners for interactive UI elements
     */
    private fun setupClickListeners() {
        saveButton.setOnClickListener {
            saveProfileData()

            Toast.makeText(this, "Profile information saved successfully", Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            finish()
        }

        backArrow.setOnClickListener {
            onBackPressed()
        }
    }

    /**
     * Load profile data from SharedPreferences storage
     */
    private fun loadProfileData() {
        val sharedPreferences = getSharedPreferences("UserProfileData", Context.MODE_PRIVATE)

        val savedName = sharedPreferences.getString("name", "")
        val savedAddress = sharedPreferences.getString("address", "")
        val savedContactNumber = sharedPreferences.getString("contactNumber", "")
        val savedEmail = sharedPreferences.getString("email", "")

        if (!savedName.isNullOrEmpty()) {
            profileNameEditText.setText(savedName)
        }

        if (!savedAddress.isNullOrEmpty()) {
            addressEditText.setText(savedAddress)
        }

        if (!savedContactNumber.isNullOrEmpty()) {
            contactNumberEditText.setText(savedContactNumber)
        }

        if (!savedEmail.isNullOrEmpty()) {
            emailAddressEditText.setText(savedEmail)
        }
    }

    /**
     * Save all profile data to SharedPreferences storage
     */
    private fun saveProfileData() {
        val sharedPreferences = getSharedPreferences("UserProfileData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("name", profileNameEditText.text.toString())
        editor.putString("address", addressEditText.text.toString())
        editor.putString("contactNumber", contactNumberEditText.text.toString())
        editor.putString("email", emailAddressEditText.text.toString())

        editor.apply()
    }
}