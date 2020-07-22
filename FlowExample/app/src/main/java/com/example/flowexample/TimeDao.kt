package com.example.flowexample

import androidx.room.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
@Dao
abstract class TimeDao {

    @Query("SELECT * FROM Time")
    abstract fun getTimes(): Flow<List<Time>>

    @Query("SELECT COUNT(*) FROM TIME WHERE hour = :hour AND minute =:minute")
    abstract suspend fun _checkWhetherTimeExistsForWeekday(hour: Int, minute: Int): Int

    @Insert
    suspend fun insertTime(time: Time): Long {
        val timeAlreadyExists = _checkWhetherTimeExistsForWeekday(time.hour, time.minute)
        if(timeAlreadyExists == 1) return -1 //if there exists another time for notification with the same id
        return _insertTime(time)
    }

    @Insert
    abstract suspend fun _insertTime(time: Time): Long

    @Transaction
    open suspend fun updateTime(hour: Int, minute: Int, timeToUpdate: Time): Long {
        if(hour == timeToUpdate.hour && timeToUpdate.minute == minute) {
            return -1;
        }
        val timeExists = _checkWhetherTimeExistsForWeekday(hour, minute)
        if(timeExists != 1) { //if timeExists it will be 1 otherwise 0
            deleteTime(timeToUpdate)
            return insertTime(timeToUpdate.apply {
                this.hour = hour
                this.minute = minute
            })
        }
        return -1;
    }

//    @Update
//    abstract suspend fun updateTime(hour: Int, minute: Int, timeToUpdate: Time): Long

    @Delete
    abstract suspend fun deleteTime(time: Time)
}