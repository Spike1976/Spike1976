package com.example.mileagetracker.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mileagetracker.data.AppDatabase
import com.example.mileagetracker.data.Trip
import com.example.mileagetracker.data.TripDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TripViewModel(application: Application) : AndroidViewModel(application) {

    private val tripDao: TripDao = AppDatabase.getDatabase(application).tripDao()
    val allTrips: LiveData<List<Trip>> = tripDao.getAllTrips()

    fun insert(trip: Trip) = viewModelScope.launch(Dispatchers.IO) {
        tripDao.insert(trip)
    }

    fun getTripsByCategory(category: String): LiveData<List<Trip>> {
        return tripDao.getTripsByCategory(category)
    }
}
