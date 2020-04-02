package com.rocketskill.interface_adapter.di

import org.koin.dsl.module.module
import com.rocketskill.interface_adapter.weather.model.WeatherRemote
import com.rocketskill.interface_adapter.weather.model.WeatherUIModel
import com.rocketskill.use_case.weather.data.WeatherRepository

val mapperModule = module {
    single { WeatherUIModel.Mapper() }
    single { WeatherRemote.Mapper() }


}
