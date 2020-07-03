package com.tryandlearn.weather.data.remote

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tryandlearn.interface_adapter.weather.model.WeatherRemoteList
import com.tryandlearn.util.GsonBuilder.gson
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherRetrofitDataSource {

    @GET("forecast/daily")
    fun getDailyWeatherList(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("cnt") count: Int,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): Flowable<WeatherRemoteList>

    @GET("forecast/hourly")
    fun getHourlyWeatherList(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("cnt") count: Int,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): Flowable<WeatherRemoteList>

    object Creator {

        fun newWeatherRetrofitDataSource(): WeatherRetrofitDataSource {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addNetworkInterceptor(StethoInterceptor())
                        .build())
                .build()
            return retrofit.create(WeatherRetrofitDataSource::class.java)
        }
    }
}
