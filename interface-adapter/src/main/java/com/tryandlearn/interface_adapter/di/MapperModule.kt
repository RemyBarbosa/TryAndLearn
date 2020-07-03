package com.tryandlearn.interface_adapter.di

import org.koin.dsl.module.module
import com.tryandlearn.interface_adapter.weather.model.WeatherRemote
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel

val mapperModule = module {
    single { WeatherUIModel.Mapper() }
    single { WeatherRemote.Mapper() }


}
