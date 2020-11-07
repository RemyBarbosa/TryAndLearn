package com.tryandlearn.weather.data.remote

import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.interface_adapter.weather.model.WeatherRemote
import com.tryandlearn.use_case.weather.data.source.WeatherRemoteDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
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
