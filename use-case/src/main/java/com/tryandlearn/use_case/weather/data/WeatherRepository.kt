package com.tryandlearn.use_case.weather.data

import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource
) {
    fun getDailyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        weatherRemoteDataSource.getDailyWeatherList(latitude, longitude, count, units, appId)


    fun getHourlyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> =
        weatherRemoteDataSource.getHourlyWeatherList(latitude, longitude, count, units, appId).startWith(weatherLocalDataSource.getDailyWeatherList())
}
