package com.azamovhudstc.tradingapp.app

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class App : Application() {
    companion object{
        lateinit var instance:App
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
        FirebaseApp.initializeApp(this)
    }
}