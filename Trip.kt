package com.example.mileagetracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "trips")
data class Trip(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val startDate: Date,
    val endDate: Date,
    val startOdometer: Float,
    val endOdometer: Float,
    val distance: Float,
    val category: String,
    val notes: String?
)
