package com.tryandlearn.application

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import com.tryandlearn.application.di.applicationInjectionsModules
import com.tryandlearn.application.di.applicationTestInjectionsModules
import org.koin.dsl.module.Module

class TestApplication : BaseApplication() {
    override val koinApplicationInjectionsModules = applicationTestInjectionsModules
}