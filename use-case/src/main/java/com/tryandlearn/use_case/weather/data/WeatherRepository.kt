package com.tryandlearn.use_case.weather.data

import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import io.reactivex.Flowable

class WeatherRepository(
    private val WeatherRemoteDataSource: WeatherRemoteDataSource,
    private val WeatherLocalDataSource: WeatherLocalDataSource
) {
    fun getDailyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        WeatherRemoteDataSource.getDailyWeatherList(latitude, longitude, count, units, appId)


    fun getHourlyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        WeatherRemoteDataSource.getHourlyWeatherList(latitude, longitude, count, units, appId).startWith(WeatherLocalDataSource.getDailyWeatherList())
}
