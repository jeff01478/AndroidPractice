package com.example.playvideotest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var play: Button
    lateinit var pause: Button
    lateinit var replay: Button
    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObject()
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoView.setVideoURI(uri)
        play.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
            }
        }
        pause.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            }
        }
        replay.setOnClickListener {
            videoView.resume()
            videoView.start()
        }
    }

    private fun initObject() {
        play = findViewById(R.id.play)
        pause = findViewById(R.id.pause)
        replay = findViewById(R.id.replay)
        videoView = findViewById(R.id.videoView)
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}