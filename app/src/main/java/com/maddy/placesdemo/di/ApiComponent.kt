package com.maddy.placesdemo.di

import com.maddy.placesdemo.backend.api.PlacesApi
import com.maddy.placesdemo.backend.repository.PlacesRepository
import com.maddy.placesdemo.viewmodel.PlacesViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiHelper::class, AppModule::class])
interface ApiComponent {

    val placeApi: PlacesApi
    fun inject(repo: PlacesRepository)
    fun inject(placesVM: PlacesViewModel)
}