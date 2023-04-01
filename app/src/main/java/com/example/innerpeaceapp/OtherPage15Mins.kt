package com.example.innerpeaceapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat

class OtherPage15Mins : AppCompatActivity() {
    var textView_timer: TextView? = null
    var countDownTimer: MyCountDownTimer? = null
    fun backToTimePage() {
        val intent = Intent(this, OtherTimePage::class.java)
        startActivity(intent)
        countDownTimer!!.cancel()
    }

    inner class MyCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            val f: NumberFormat = DecimalFormat("00")
            val min = millisUntilFinished / 60000 % 60
            val sec = millisUntilFinished / 1000 % 60
            textView_timer!!.text = f.format(min) + ":" + f.format(sec)
        }

        override fun onFinish() {}
    }

    fun play(view: View?) {
        countDownTimer = MyCountDownTimer(900000, 1000)
        countDownTimer!!.start()
    }

    fun pause(view: View?) {}
    fun stop(view: View?) {
        countDownTimer!!.cancel()
        textView_timer!!.text = "15:00"
    }

    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exer_and_other_page15_mins)
        textView_timer = findViewById(R.id.textView_timer)
        button = findViewById<View>(R.id.button3) as Button
        button!!.setOnClickListener { backToTimePage() }
    }
}