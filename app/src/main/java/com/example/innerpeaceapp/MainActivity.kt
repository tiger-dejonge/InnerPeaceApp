package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity



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
    }
}