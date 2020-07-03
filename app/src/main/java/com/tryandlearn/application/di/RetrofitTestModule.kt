package com.tryandlearn.application.di

import com.tryandlearn.weather.data.remote.WeatherRetrofitDataSource
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitTestModule = module {

    single {
        Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(get())
                .client(get())
                .build().create(WeatherRetrofitDataSource::class.java)
    }
}

