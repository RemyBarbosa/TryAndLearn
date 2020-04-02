package com.rocketskill.weather.data.remote

import com.rocketskill.entity.weather.Weather
import com.rocketskill.interface_adapter.weather.model.WeatherRemote
import com.rocketskill.use_case.weather.data.source.WeatherRemoteDataSource
import io.reactivex.Flowable

class WeatherRemoteDataSourceImpl(
    private val mapper: WeatherRemote.Mapper,
    private val weatherRetrofitDataSource: WeatherRetrofitDataSource
) : WeatherRemoteDataSource {

    override fun getDailyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> {
        return  weatherRetrofitDataSource.getDailyWeatherList(latitude, longitude, count, units, appId).map { dailyWeatherRemoteList ->
            dailyWeatherRemoteList.list.map {
                mapper.toEntity(it)
            }
        }
    }

    override fun getHourlyWeatherList(latitude: Float, longitude: Float, count: Int, units: String, appId: String): Flowable<List<Weather>> {
        return  weatherRetrofitDataSource.getHourlyWeatherList(latitude, longitude, count, units, appId).map { dailyWeatherRemoteList ->
            dailyWeatherRemoteList.list.map {
                mapper.toEntity(it)
            }
        }
    }
}
