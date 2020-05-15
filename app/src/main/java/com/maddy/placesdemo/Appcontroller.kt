package com.maddy.placesdemo

import android.app.Application
import com.maddy.placesdemo.di.*

class Appcontroller : Application()
{

    lateinit var mApiComponent:ApiComponent

    override fun onCreate() {
        super.onCreate()
        app = this

        mApiComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .apiHelper(ApiHelper())
            .build()

    }

    companion object {
        lateinit var app: Appcontroller
            private set
    }

}