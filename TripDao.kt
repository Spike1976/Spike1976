package com.example.mileagetracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TripDao {
    @Insert
    suspend fun insert(trip: Trip)

    @Query("SELECT * FROM trips ORDER BY startDate DESC")
    fun getAllTrips(): LiveData<List<Trip>>

    @Query("SELECT * FROM trips WHERE category = :category ORDER BY startDate DESC")
    fun getTripsByCategory(category: String): LiveData<List<Trip>>
}
