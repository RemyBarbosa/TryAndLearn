package com.tryandlearn.use_case.weather.data.source

import com.tryandlearn.entity.weather.Weather
import io.reactivex.Flowable

interface WeatherLocalDataSource {
    fun getDailyWeatherList(): Flowable<List<Weather>>
    fun getHourlyWeatherList(): Flowable<List<Weather>>
}
