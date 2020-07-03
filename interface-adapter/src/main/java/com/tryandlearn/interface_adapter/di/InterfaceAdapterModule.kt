package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.weather.WeatherManager
import org.koin.dsl.module.module

val interfaceAdapterModule = module {
    single { WeatherManager(get(), get(), get()) }
}
