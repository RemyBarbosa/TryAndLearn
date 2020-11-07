package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.weather.WeatherManager
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import com.tryandlearn.use_case.weather.GetDailyWeatherUseCase
import com.tryandlearn.use_case.weather.GetHourlyWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object InterfaceAdapterModuleHilt {

    @Provides
    fun provideWeatherManager(
        getDailyWeatherUseCase: GetDailyWeatherUseCase,
        getHourlyWeatherUseCase: GetHourlyWeatherUseCase,
        mapper: WeatherUIModel.Mapper
    ) = WeatherManager(
        getDailyWeatherUseCase,
                getHourlyWeatherUseCase,
                mapper
    )
}
