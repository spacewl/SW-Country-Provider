package com.spacewl.countryprovider

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlin.system.measureTimeMillis

class TestViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Log.w("TestViewModel", "init")
    }

    val countriesLD = liveData(Dispatchers.IO) {
        val countries: List<Country>
        val duration = measureTimeMillis {
            countries = CountryProvider.fetchCountries(application)
        }
        Log.w("Measure time", "measure time: $duration")
        emit(countries)
    }
}