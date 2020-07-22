package com.example.flowexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel(application: Application): AndroidViewModel(application) {

    var db = Room.databaseBuilder(
        application.applicationContext,
        AlarmDatabase::class.java, "database-name").build()

    fun getTimes() =
        db.timeDao()
            .getTimes().asLiveData()

    suspend fun addTime(hour: Int, minute: Int): Boolean {
        return db.timeDao().insertTime(Time(hour, minute)) != -1L
    }

    fun deleteTime(time: Time) {
        viewModelScope.launch {
            db.timeDao().deleteTime(time)
        }
    }

    suspend fun updateTime(hour: Int, minute: Int, timeToUpdate: Time): Boolean {
        return db.timeDao().updateTime(hour, minute, timeToUpdate) != -1L
    }
}