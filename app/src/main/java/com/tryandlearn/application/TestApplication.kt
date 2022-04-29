package com.tryandlearn.application

import com.tryandlearn.application.di.applicationTestInjectionsModules

class TestApplication : BaseApplication() {
    override val koinApplicationInjectionsModules = applicationTestInjectionsModules
}