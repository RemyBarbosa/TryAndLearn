package com.rocketskill.application

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import com.rocketskill.application.di.applicationInjectionsModules

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, applicationInjectionsModules)
        Stetho.initializeWithDefaults(this)
    }
}