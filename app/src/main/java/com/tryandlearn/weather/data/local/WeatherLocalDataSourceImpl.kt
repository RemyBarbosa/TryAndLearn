package com.tryandlearn.weather.data.local

import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.entity.weather.WeatherKind
import com.tryandlearn.use_case.weather.data.source.WeatherLocalDataSource
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor() : WeatherLocalDataSource {

    override fun getDailyWeatherList(): Flowable<List<Weather>> {
        return Flowable.just(
            listOf(
                Weather(
                    dateTime = Date().time,
                    kind = WeatherKind.CLEAR,
                    description = "everythingIsClear"
                )
            )
        )
    }

    override fun getHourlyWeatherList(): Flowable<List<Weather>> {
        return Flowable.just(
            listOf(
                Weather(
                    dateTime = Date().time,
                    kind = WeatherKind.CLEAR,
                    description = "everythingIsClear"
                )
            )
        )
    }
}
