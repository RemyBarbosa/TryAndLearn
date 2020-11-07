package com.tryandlearn.application.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitDependenciesModuleHilt {

    @Provides
    fun provideCallAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideHourlyWeatherViewModel() = GsonBuilder().create()

    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()
}