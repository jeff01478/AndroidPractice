package com.example.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var downloadBinder: MyService.DownloadBinder

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startServiceBtn: Button = findViewById(R.id.startServiceBtn)
        val stopServiceBtn: Button = findViewById(R.id.stopServiceBtn)
        val bindServiceBtn: Button = findViewById(R.id.bindServiceBtn)
        val unbindServiceBtn: Button = findViewById(R.id.unbindServiceBtn)
        startServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent) // 啟動Service
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
        bindServiceBtn.setOnClickListener {
            val intnet = Intent(this, MyService::class.java)
            bindService(intnet, connection, Context.BIND_AUTO_CREATE) // 綁定Service
        }
        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
    }
}