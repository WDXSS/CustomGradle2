package com.example.kotlin._09kotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_09_notification_main_activity.*

@DevKotlin("创建 一个 Notification")
class NotificationMainActivity() : AppCompatActivity() {
    lateinit var manager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_09_notification_main_activity)
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //創建channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
            val channel2 = NotificationChannel("important", "Important", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }

        sendNotice.setOnClickListener {
            createNotify()
        }
        sendNotice2.setOnClickListener {
            createNotify2()
        }
        sendNotice3.setOnClickListener {
            createNotify3()
        }
    }

    fun createNotify() {
        val intent = Intent(this, NotificationMainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
//                .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.mipmap.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.large_icon))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
        manager.notify(1, notification)
    }

    fun createNotify2() {
        val intent = Intent(this, NotificationMainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
//                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                //显示 完整的 内容
                .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setSmallIcon(R.mipmap.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.large_icon))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
        manager.notify(1, notification)
    }


    fun createNotify3() {
        val intent = Intent(this, NotificationMainActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
//                .setContentText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android.")
                //显示 完整的 内容
                .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.mipmap.big_image)))
                .setSmallIcon(R.mipmap.small_icon)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.large_icon))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
        manager.notify(1, notification)
    }
}