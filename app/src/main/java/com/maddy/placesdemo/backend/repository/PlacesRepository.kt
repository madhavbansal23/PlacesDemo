package com.maddy.placesdemo.backend.repository

import com.maddy.placesdemo.Appcontroller
import com.maddy.placesdemo.backend.api.PlacesApi
import com.maddy.placesdemo.di.ApiComponent
import javax.inject.Inject

class PlacesRepository {

    init {
        val apiComponent: ApiComponent = Appcontroller.app.mApiComponent
        apiComponent.inject(this)
    }

    @Inject
    lateinit var placeApi: PlacesApi

    suspend fun getPlaces(query: String, city: String) = placeApi.getPlaces(query, city)

}