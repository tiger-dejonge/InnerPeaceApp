package com.example.innerpeaceapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MeditationPage10Mins : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var seekbar: SeekBar? = null
    var textView_timer: TextView? = null
    var handler = Handler()
    fun backToTimePage() {
        val intent = Intent(this, MeditationTimePage::class.java)
        startActivity(intent)
        mediaPlayer!!.stop()
    }

    fun play(view: View?) {
        mediaPlayer!!.start()
        updateSeekBar()
    }

    fun pause(view: View?) {
        mediaPlayer!!.pause()
    }

    fun stop(view: View?) {
        mediaPlayer!!.stop()
        mediaPlayer!!.reset()
        textView_timer!!.text = convertMilliToTime(0)
        seekbar!!.progress = 0
    }

    var button: Button? = null
    private fun convertMilliToTime(target: Int): String {
        val seconds = target / 1000 % 60
        val minutes = target / 1000 / 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation_page10_mins)
        textView_timer = findViewById(R.id.textView_timer)
        seekbar = findViewById(R.id.seekBar)
        mediaPlayer = MediaPlayer.create(this, R.raw.himym)
        button = findViewById<View>(R.id.button3) as Button
        button!!.setOnClickListener { backToTimePage() }
        seekbar?.max = mediaPlayer!!.duration
        seekbar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer!!.seekTo(i)
                    textView_timer!!.text = convertMilliToTime(i)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun updateSeekBar() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                val currentPosition = mediaPlayer!!.currentPosition
                seekbar!!.progress = currentPosition
                textView_timer!!.text = convertMilliToTime(currentPosition)
                handler.postDelayed(this, 1000)
            }
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer!!.release()
        handler.removeCallbacksAndMessages(null)
    }
}