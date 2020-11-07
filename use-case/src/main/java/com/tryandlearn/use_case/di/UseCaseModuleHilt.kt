package com.tryandlearn.use_case.di

import com.tryandlearn.use_case.weather.GetDailyWeatherUseCase
import com.tryandlearn.use_case.weather.GetHourlyWeatherUseCase
import com.tryandlearn.use_case.weather.data.WeatherRepository
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModuleHilt {

    @Provides
    fun provideGetDailyWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = GetDailyWeatherUseCase(
        weatherRepository
    )

    @Provides
    fun provideGetHourlyWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = GetHourlyWeatherUseCase(
        weatherRepository
    )

    @Provides
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource,
        weatherLocalDataSource: WeatherLocalDataSource
    ) = WeatherRepository(
        weatherRemoteDataSource,
        weatherLocalDataSource
    )
}
