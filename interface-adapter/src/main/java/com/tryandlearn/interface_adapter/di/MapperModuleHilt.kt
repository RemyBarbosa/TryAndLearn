package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.weather.model.WeatherRemote
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object MapperModuleHilt {

    @Provides
    fun provideWeatherUIModelMapper() = WeatherUIModel.Mapper()
    @Provides
    fun provideWeatherRemoteMapper() = WeatherRemote.Mapper()
}
