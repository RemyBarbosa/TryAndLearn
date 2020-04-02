package com.rocketskill.use_case.weather.data.source

import com.rocketskill.entity.weather.Weather
import io.reactivex.Flowable

interface WeatherRemoteDataSource {
    fun getDailyWeatherList(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<Weather>>

    fun getHourlyWeatherList(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<Weather>>

}
