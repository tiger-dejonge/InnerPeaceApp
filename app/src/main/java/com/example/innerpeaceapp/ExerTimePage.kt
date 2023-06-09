package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class ExerTimePage : AppCompatActivity() {
    var spinner: Spinner? = null
    var spinnermood: Spinner? = null
    var startButton: Button? = null
    var returnButton: Button? = null
    fun openNewActivity() {
        val selected_time = spinner!!.selectedItem as String
        if ("5 mins" == selected_time) {
            val intent = Intent(this, ExerPage::class.java)
            startActivity(intent)
        } else if ("10 mins" == selected_time) {
            val intent = Intent(this, ExerPage10Mins::class.java)
            startActivity(intent)
        } else if ("15 mins" == selected_time) {
            val intent = Intent(this, ExerPage15Mins::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, ExerPage20Mins::class.java)
            startActivity(intent)
        }
    }

    fun returnToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exer_time_page)
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
        spinner?.adapter = adapter
        startButton = findViewById(R.id.button2)
        startButton?.setOnClickListener(View.OnClickListener { openNewActivity() })
        returnButton = findViewById(R.id.button3)
        returnButton?.setOnClickListener(View.OnClickListener { returnToMain() })
    }
}