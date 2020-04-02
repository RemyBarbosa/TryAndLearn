package com.rocketskill.interface_adapter.weather.model

import com.rocketskill.entity.weather.Weather
import com.rocketskill.entity.weather.WeatherKind

data class WeatherRemote(
    val dt: Long?,
    val weather: List<WeatherRemoteInfo>
) {
    companion object {
        private const val DEFAULT_DESCRIPTION = "let the sunshine in"
    }

    class Mapper {
        fun toEntity(weatherRemote: WeatherRemote) = Weather(
            dateTime = weatherRemote.dt ?: 0,
            kind = getKind(weatherRemote.weather.get(0)?.main),
            description = weatherRemote.weather.get(0)?.description ?: DEFAULT_DESCRIPTION
        )

        private fun getKind(main: String?): WeatherKind {
            return when (main) {
                "Rain" -> WeatherKind.RAIN
                "Clouds" -> WeatherKind.CLOUDS
                "Snow" -> WeatherKind.SNOW
                "Clear" -> WeatherKind.CLEAR
                else -> WeatherKind.CLEAR // i'm an optimistic dude ^
            }
        }
    }
}
