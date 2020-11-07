package com.tryandlearn.application

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class BaseApplication : Application() {

//    open val koinApplicationInjectionsModules = applicationInjectionsModules
    override fun onCreate() {
        super.onCreate()

       // startKoin(this, koinApplicationInjectionsModules)
        Stetho.initializeWithDefaults(this)
    }
}