package com.rocketskill.interface_adapter.di

import com.rocketskill.interface_adapter.weather.WeatherManager
import org.koin.dsl.module.module

val interfaceAdapterModule = module {
    single { WeatherManager(get(), get(), get()) }
}
