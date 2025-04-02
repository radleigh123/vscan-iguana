package com.intprog.vscan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = getSharedPreferences("settings", Context.MODE_PRIVATE)

        val isDarkMode = sharedPref.getBoolean("dark_mode", false)
        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )

        setContentView(R.layout.activity_setting)

        val ivBackArrow = findViewById<ImageView>(R.id.ivBackArrow)
        ivBackArrow.setOnClickListener {
            finish()
        }

        val switchGeneralNotifications = findViewById<Switch>(R.id.switchGeneralNotifications)
        val switchTrafficUpdates = findViewById<Switch>(R.id.switchTrafficUpdates)
        val switchSilentMode = findViewById<Switch>(R.id.switchSilentMode)
        val switchDarkMode = findViewById<Switch>(R.id.switchDarkMode)

        switchGeneralNotifications.isChecked = sharedPref.getBoolean("general_notifications", true)
        switchTrafficUpdates.isChecked = sharedPref.getBoolean("traffic_updates", true)
        switchSilentMode.isChecked = sharedPref.getBoolean("silent_mode", false)
        switchDarkMode.isChecked = isDarkMode

        switchGeneralNotifications.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPref.edit()) {
                putBoolean("general_notifications", isChecked)
                apply()
            }
        }

        switchTrafficUpdates.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPref.edit()) {
                putBoolean("traffic_updates", isChecked)
                apply()
            }
        }

        switchSilentMode.setOnCheckedChangeListener { _, isChecked ->
            with(sharedPref.edit()) {
                putBoolean("silent_mode", isChecked)
                apply()
            }
        }

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
            with(sharedPref.edit()) {
                putBoolean("dark_mode", isChecked)
                apply()
            }
        }
    }

}