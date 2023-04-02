package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SummaryPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_page)
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