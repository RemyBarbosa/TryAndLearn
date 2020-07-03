package com.tryandlearn.entity.weather

data class Weather(
    val dateTime: Long,
    val kind: WeatherKind,
    val description: String
)