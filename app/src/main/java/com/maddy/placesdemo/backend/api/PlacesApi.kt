package com.maddy.placesdemo.backend.api

import com.maddy.placesdemo.model.BaseModel
import com.maddy.placesdemo.model.PlacesData
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {

    @GET("compassLocation/rest/address/autocomplete")
    suspend fun getPlaces(@Query("queryString") query: String, @Query("city") city: String): BaseModel<PlacesData>

}