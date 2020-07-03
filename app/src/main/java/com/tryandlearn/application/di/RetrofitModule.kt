package com.tryandlearn.application.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tryandlearn.interface_adapter.di.interfaceAdapterModule
import com.tryandlearn.interface_adapter.di.mapperModule
import com.tryandlearn.use_case.di.useCaseModule
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import com.tryandlearn.weather.data.remote.WeatherRetrofitDataSource
import com.tryandlearn.interface_adapter.weather.DailyWeatherViewModel
import com.tryandlearn.interface_adapter.weather.HourlyWeatherViewModel
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import com.tryandlearn.weather.data.local.WeatherLocalDataSourceImpl
import com.tryandlearn.weather.data.remote.WeatherRemoteDataSourceImpl
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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

