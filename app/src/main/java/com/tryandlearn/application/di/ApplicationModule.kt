package com.tryandlearn.application.di

import com.tryandlearn.interface_adapter.di.interfaceAdapterModule
import com.tryandlearn.interface_adapter.di.mapperModule
import com.tryandlearn.interface_adapter.weather.DailyWeatherViewModel
import com.tryandlearn.interface_adapter.weather.HourlyWeatherViewModel
import com.tryandlearn.use_case.di.useCaseModule
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import com.tryandlearn.weather.data.local.WeatherLocalDataSourceImpl
import com.tryandlearn.weather.data.remote.WeatherRemoteDataSourceImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { DailyWeatherViewModel(get()) }
    viewModel { HourlyWeatherViewModel(get()) }

    single { WeatherRemoteDataSourceImpl(get(), get()) as WeatherRemoteDataSource }
    single { WeatherLocalDataSourceImpl() as WeatherLocalDataSource }
}

val applicationInjectionsModules = listOf(
        applicationModule,
        retrofitModule,
        retrofitDependenciesModule,
        interfaceAdapterModule,
        useCaseModule,
        mapperModule
)

val applicationTestInjectionsModules = listOf(
        applicationModule,
        retrofitTestModule,
        retrofitDependenciesModule,
        interfaceAdapterModule,
        useCaseModule,
        mapperModule
)
