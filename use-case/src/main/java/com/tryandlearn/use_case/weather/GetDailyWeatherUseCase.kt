package com.tryandlearn.use_case.weather


import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.use_case.weather.data.WeatherRepository
import io.reactivex.Flowable

class GetDailyWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    fun execute(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<Weather>> {
        return weatherRepository.getDailyWeatherList(latitude, longitude, count, units, appId)
    }
}
