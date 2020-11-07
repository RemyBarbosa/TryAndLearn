package com.tryandlearn.interface_adapter.weather.model

import android.text.format.DateUtils
import com.tryandlearn.entity.weather.Weather
import com.tryandlearn.entity.weather.WeatherKind
import com.tryandlearn.interface_adapter.R
import java.util.*
import javax.inject.Inject

data class WeatherUIModel(
    val date: String,
    val imageRes: Int,
    val description: String
) {
    class Mapper @Inject constructor() {
        fun fromEntity(weather: Weather) = WeatherUIModel(
            date = DateUtils.getRelativeTimeSpanString(
                weather.dateTime * 1000,
                Calendar.getInstance().timeInMillis,
                DateUtils.MINUTE_IN_MILLIS
            ).toString(),
            imageRes = getImageFromKind(weather.kind),
            description = weather.description
        )

        private fun getImageFromKind(kind: WeatherKind) = when (kind) {
            WeatherKind.RAIN -> R.drawable.ic_wb_rainny
            WeatherKind.CLEAR -> R.drawable.ic_wb_sunny
            WeatherKind.CLOUDS -> R.drawable.ic_wb_cloudy
            WeatherKind.BROKEN_CLOUDS -> R.drawable.ic_wb_light_sunny
            WeatherKind.SNOW -> R.drawable.ic_wb_snowy
        }
    }
}
