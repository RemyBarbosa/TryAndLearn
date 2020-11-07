package com.tryandlearn.use_case.weather


import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.use_case.weather.data.WeatherRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetHourlyWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    fun execute(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<Weather>> {
        return weatherRepository.getHourlyWeatherList(latitude, longitude, count, units, appId)
    }
}
