package com.tryandlearn.interface_adapter.weather

import io.reactivex.Flowable
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import com.tryandlearn.use_case.weather.GetDailyWeatherUseCase
import com.tryandlearn.use_case.weather.GetHourlyWeatherUseCase
import java.util.*


class WeatherManager(
    private val getDailyWeatherUseCase: GetDailyWeatherUseCase,
    private val getHourlyWeatherUseCase: GetHourlyWeatherUseCase,
    private val mapper: WeatherUIModel.Mapper
) {
    fun getDailyWeatherList(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<WeatherUIModel>> {
        val fiveDaysInMillis = 5 * 24 * 60 * 60 * 1000
        return getDailyWeatherUseCase.execute(latitude, longitude, count, units, appId).map { list ->
            list.filter {
                it.dateTime * 1000 < Calendar.getInstance().timeInMillis + fiveDaysInMillis
            }.map { mapper.fromEntity(it) }
        }
    }

    fun getHourlyWeatherList(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ): Flowable<List<WeatherUIModel>> {
        return getHourlyWeatherUseCase.execute(latitude, longitude, count, units, appId).map { list ->
            list.map { mapper.fromEntity(it) }
        }
    }
}
