package com.example.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sendNotice: Button = findViewById(R.id.sendNotice)
        val intent = Intent(this, NotificationActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal", NotificationManager.
                    IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
            val channel2 = NotificationChannel("important", "Important",
                    NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
        sendNotice.setOnClickListener {
            val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setSmallIcon(R.drawable.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
                .setContentIntent(pi)
                .setStyle(NotificationCompat.BigTextStyle().bigText("This is content text"))
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(
                    BitmapFactory.decodeResource(resources, R.drawable.big_image)
                ))
                .setAutoCancel(true)
                .build()
            manager.notify(1, notification)
        }
    }
}