package com.example.moonphases

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ServiceStarter: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent("com.example.moonphases.MoonPhaseService")
        i.setClass(context!!, MoonPhaseService::class.java)
        context.startService(i)
    }
}