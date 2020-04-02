package com.rocketskill.use_case.weather.data

import com.rocketskill.entity.weather.Weather
import com.rocketskill.use_case.weather.data.source.WeatherLocalDataSource
import com.rocketskill.use_case.weather.data.source.WeatherRemoteDataSource
import io.reactivex.Flowable

class WeatherRepository(
    private val WeatherRemoteDataSource: WeatherRemoteDataSource,
    private val WeatherLocalDataSource: WeatherLocalDataSource
) {
    fun getDailyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        WeatherRemoteDataSource.getDailyWeatherList(latitude, longitude, count, units, appId).startWith(WeatherLocalDataSource.getDailyWeatherList())


    fun getHourlyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        WeatherRemoteDataSource.getHourlyWeatherList(latitude, longitude, count, units, appId).startWith(WeatherLocalDataSource.getDailyWeatherList())
}
