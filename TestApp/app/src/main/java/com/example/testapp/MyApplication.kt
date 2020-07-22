package com.example.testapp

import android.app.Application
import com.example.testapp.di.common.Di

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Di.appComponent =
            DaggerAppComponent
                .factory()
                .create(applicationContext)
    }
}