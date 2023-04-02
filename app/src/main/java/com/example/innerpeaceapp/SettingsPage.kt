package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsPage : AppCompatActivity() {
    var lanSpinner: Spinner? = null
    var voiceSpinner: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_page)
        lanSpinner = findViewById(R.id.language_spinner)
        val adapter = ArrayAdapter.createFromResource(this,R.array.language,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        lanSpinner?.adapter=adapter
        voiceSpinner = findViewById(R.id.voice_spinner)
        val adapter2 = ArrayAdapter.createFromResource(this,R.array.voice,android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)
        voiceSpinner?.adapter = adapter2
        var navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_dashboard ->{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_home ->{
                    val intent = Intent(this, SettingsPage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_notifications ->{
                    val intent = Intent(this, SummaryPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}