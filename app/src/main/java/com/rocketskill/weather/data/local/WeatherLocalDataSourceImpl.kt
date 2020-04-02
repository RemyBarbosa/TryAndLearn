package com.rocketskill.weather.data.local

import com.rocketskill.entity.weather.Weather
import com.rocketskill.entity.weather.WeatherKind
import com.rocketskill.use_case.weather.data.source.WeatherLocalDataSource
import io.reactivex.Flowable
import java.util.*

class WeatherLocalDataSourceImpl : WeatherLocalDataSource {

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
