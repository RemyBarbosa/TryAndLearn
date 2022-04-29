package com.tryandlearn.use_case.di

import com.tryandlearn.use_case.weather.GetDailyWeatherUseCase
import com.tryandlearn.use_case.weather.GetHourlyWeatherUseCase
import com.tryandlearn.use_case.weather.data.WeatherRepository
import org.koin.dsl.module

val useCaseModule = module {
    single { GetDailyWeatherUseCase(get()) }
    single { GetHourlyWeatherUseCase(get()) }

    single { WeatherRepository(get(), get()) }
}
