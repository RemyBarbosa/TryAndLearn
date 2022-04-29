package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.weather.model.WeatherRemote
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import org.koin.dsl.module

val mapperModule = module {
    single { WeatherUIModel.Mapper() }
    single { WeatherRemote.Mapper() }


}
