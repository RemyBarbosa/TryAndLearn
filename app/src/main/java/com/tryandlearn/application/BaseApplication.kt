package com.tryandlearn.application

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import com.tryandlearn.application.di.applicationInjectionsModules

open class BaseApplication : Application() {

    open val koinApplicationInjectionsModules = applicationInjectionsModules
    override fun onCreate() {
        super.onCreate()

        startKoin(this, koinApplicationInjectionsModules)
        Stetho.initializeWithDefaults(this)
    }


}