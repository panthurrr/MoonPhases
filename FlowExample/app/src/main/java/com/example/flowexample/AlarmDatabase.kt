package com.example.flowexample

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Database(entities = [Time::class], version = 6, exportSchema = false)
abstract class AlarmDatabase: RoomDatabase() {
    abstract fun timeDao(): TimeDao
}