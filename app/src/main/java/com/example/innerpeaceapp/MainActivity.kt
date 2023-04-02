package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val medbuttonClick = findViewById<RelativeLayout>(R.id.meditation_card)
        val exbuttonClick = findViewById<RelativeLayout>(R.id.exercise_card)
        val otbuttonClick = findViewById<RelativeLayout>(R.id.other_card)
        medbuttonClick.setOnClickListener{
            val intent = Intent(this, MeditationTimePage::class.java)
            startActivity(intent)
        }
        exbuttonClick.setOnClickListener{
            val intent = Intent(this, ExerTimePage::class.java)
            startActivity(intent)
        }
        otbuttonClick.setOnClickListener{
            val intent = Intent(this, OtherTimePage::class.java)
            startActivity(intent)
        }
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_dashboard ->{

                    val intent2 = Intent(this, MainActivity::class.java)
                    startActivity(intent2)
                    true
                }
                R.id.navigation_home ->{
                    val intent2 = Intent(this, SettingsPage::class.java)
                    startActivity(intent2)
                    true
            }
                R.id.navigation_notifications ->{
                    val intent2 = Intent(this, SummaryPage::class.java)
                    startActivity(intent2)
                    true
                }
                else -> false
        }
    }
}
}