package com.example.moonphases

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MoonPhaseService: Service() {

    private lateinit var channelId: String
    private val notificationId = 5
    private lateinit var notificationManager: NotificationManager
    private val handler = Handler(Looper.getMainLooper())
    private val notificationRunnable = object: Runnable {
            override fun run() {
                showNotification()
                handler.postDelayed(this, 20000)
            }
        }

    companion object {
        var currentMoonPhase: MoonPhase? = null
        var serviceIsOn = false
    }

    override fun onCreate() {
        serviceIsOn = true
        notificationManager = getSystemService(android.content.Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
        channelId = getString(R.string.notification_channel)
        createNotificationChannel()
        handler.post(notificationRunnable)
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        serviceIsOn = false
        super.onDestroy()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            val name = getString(R.string.notification_channel)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance)
            // Register the channel with the system
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val notificationBuilder =
            if(Build.VERSION.SDK_INT >= 26)
                Notification.Builder(this, channelId)
            else
                Notification.Builder(this)
                    .setPriority(Notification.PRIORITY_DEFAULT)

        val currentRandomMoonPhase = MoonPhase.findByValue((0..7).random())!!
        currentMoonPhase = currentRandomMoonPhase
        notificationBuilder
            .setSmallIcon(currentRandomMoonPhase.drawableRes)
            .setOngoing(true)
            .setContentText("Today's moon phase is ${currentRandomMoonPhase.phase}")

        notificationManager.notify(notificationId, notificationBuilder.build())

        LocalBroadcastManager.getInstance(this).sendBroadcast(
            Intent("notificationAction").apply {
                putExtra("CurrentMoonPhase", currentRandomMoonPhase)
            }
        )
    }
}