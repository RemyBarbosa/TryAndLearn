package com.rocketskill.application.di

import com.rocketskill.interface_adapter.di.interfaceAdapterModule
import com.rocketskill.interface_adapter.di.mapperModule
import com.rocketskill.use_case.di.useCaseModule
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import com.rocketskill.weather.data.remote.WeatherRetrofitDataSource
import com.rocketskill.interface_adapter.weather.DailyWeatherViewModel
import com.rocketskill.interface_adapter.weather.HourlyWeatherViewModel
import com.rocketskill.use_case.weather.data.source.WeatherLocalDataSource
import com.rocketskill.use_case.weather.data.source.WeatherRemoteDataSource
import com.rocketskill.weather.data.local.WeatherLocalDataSourceImpl
import com.rocketskill.weather.data.remote.WeatherRemoteDataSourceImpl

val applicationModule = module {
    viewModel { DailyWeatherViewModel(get()) }
    viewModel { HourlyWeatherViewModel(get()) }

    single { WeatherRetrofitDataSource.Creator.newWeatherRetrofitDataSource() }
    single { WeatherRemoteDataSourceImpl(get(), get()) as WeatherRemoteDataSource }
    single { WeatherLocalDataSourceImpl() as WeatherLocalDataSource }
}

val applicationInjectionsModules = listOf(
    applicationModule,
    interfaceAdapterModule,
    useCaseModule,
    mapperModule
)
