package com.tryandlearn.application.di

import com.google.gson.Gson
import com.tryandlearn.weather.data.remote.WeatherRetrofitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModuleHilt {

    @Provides
    fun provideRetrofit(
        gson: Gson,
        factory: CallAdapter.Factory,
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(factory)
        .client(okHttpClient)
        .build().create(WeatherRetrofitDataSource::class.java)
}

