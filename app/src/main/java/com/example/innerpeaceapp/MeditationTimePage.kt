package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MeditationTimePage : AppCompatActivity() {
    fun backToTimePage() {
        val selected_time = spinner!!.selectedItem as String
        if ("5 mins" == selected_time) {
            val intent = Intent(this, MeditationPage::class.java)
            startActivity(intent)
        } else if ("10 mins" == selected_time) {
            val intent = Intent(this, MeditationPage10Mins::class.java)
            startActivity(intent)
        } else if ("15 mins" == selected_time) {
            val intent = Intent(this, MeditationPage15Mins::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MeditationPage20Mins::class.java)
            startActivity(intent)
        }
    }

    fun returnToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    var spinner: Spinner? = null
    var spinnermood: Spinner? = null
    var startButton: Button? = null
    var returnButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation_time_page)
        spinnermood = findViewById(R.id.moodSpinner)
        val adapter2= ArrayAdapter.createFromResource(
            this,R.array.mood,android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnermood?.adapter=adapter2
        spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.time,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner?.setAdapter(adapter)
        startButton = findViewById(R.id.button2)
        startButton?.setOnClickListener(View.OnClickListener { backToTimePage() })
        returnButton = findViewById(R.id.button3)
        returnButton?.setOnClickListener(View.OnClickListener { returnToMain() })
    }
}