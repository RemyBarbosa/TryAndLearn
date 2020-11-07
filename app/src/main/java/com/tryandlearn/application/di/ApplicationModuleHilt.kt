package com.tryandlearn.application.di

import com.tryandlearn.interface_adapter.weather.model.WeatherRemote
import com.tryandlearn.weather.data.local.WeatherLocalDataSourceImpl
import com.tryandlearn.weather.data.remote.WeatherRemoteDataSourceImpl
import com.tryandlearn.weather.data.remote.WeatherRetrofitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Provides
    fun provideWeatherRemoteDataSource(
        mapper: WeatherRemote.Mapper,
        weatherRetrofitDataSource: WeatherRetrofitDataSource
    ) = WeatherRemoteDataSourceImpl(
        mapper,
        weatherRetrofitDataSource
    )

    @Provides
    fun provideWeatherLocalDataSource() = WeatherLocalDataSourceImpl()
}