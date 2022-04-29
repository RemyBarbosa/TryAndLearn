package com.tryandlearn.application

import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.tryandlearn.application.di.applicationInjectionsModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class BaseApplication : MultiDexApplication() {

    open val koinApplicationInjectionsModules = applicationInjectionsModules
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare Android context
            androidContext(this@BaseApplication)
            // declare modules to use
            modules(applicationInjectionsModules)
        }
        Stetho.initializeWithDefaults(this)
    }


}