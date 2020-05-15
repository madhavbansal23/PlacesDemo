package com.maddy.placesdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.maddy.placesdemo.Appcontroller
import com.maddy.placesdemo.backend.repository.PlacesRepository
import com.maddy.placesdemo.model.BaseModel
import com.maddy.placesdemo.model.PlacesData
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PlacesViewModel : ViewModel() {
    @Inject
    lateinit var mRepository: PlacesRepository

    init {
        Appcontroller.app.mApiComponent.inject(this)
    }

    fun getPlaces(query: String, city: String) = liveData(Dispatchers.IO) {
        try {
            emit(mRepository.getPlaces(query, city))
        } catch (exception: Exception) {
            emit(BaseModel<PlacesData>(0))
        }
    }

}