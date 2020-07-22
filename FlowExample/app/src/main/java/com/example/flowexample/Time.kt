package com.example.flowexample

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(indices =
        [Index(value = ["hour", "minute"])]
)
data class Time (
    @ColumnInfo(name = "hour") var hour: Int,
    @ColumnInfo(name = "minute") var minute: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "time_id") var timeId: Long = 0
): Parcelable