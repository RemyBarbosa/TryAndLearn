package com.tryandlearn.application.di

import com.tryandlearn.weather.data.remote.WeatherRetrofitDataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single {
        Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(get())
                .client(get())
                .build().create(WeatherRetrofitDataSource::class.java)
    }
}

