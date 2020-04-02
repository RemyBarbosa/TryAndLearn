package com.rocketskill.interface_adapter.weather.model

import android.text.format.DateUtils
import com.rocketskill.entity.weather.Weather
import java.util.*

data class WeatherUIModel(
    val date: String,
    val imageUrl: String,
    val description: String
) {
    class Mapper {
        fun fromEntity(weather: Weather) = WeatherUIModel(
            date = DateUtils.getRelativeTimeSpanString(weather.dateTime * 1000, Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS).toString(),
            imageUrl = weather.kind.imageUrl,
            description = weather.description
        )
    }
}
