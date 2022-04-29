package com.tryandlearn.interface_adapter.article.model

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(DataProviderRunner::class)
class ArticleRemoteMapperTest {

    private val mapper = ArticleRemote.Mapper()

    companion object {
        @DataProvider
        @JvmStatic
        @Suppress("unused")
        fun parameters(): Array<Array<Any?>> {
            return arrayOf(
                arrayOf<Any?>("Rain", WeatherKind.RAIN),
                arrayOf<Any?>("Clouds", WeatherKind.CLOUDS),
                arrayOf<Any?>("Snow", WeatherKind.SNOW),
                arrayOf<Any?>("Clear", WeatherKind.CLEAR)
            )
        }
    }

    @Test
    @UseDataProvider("parameters")
    fun map(remoteKind: String?, expectedWeatherKind: WeatherKind) {
        // Given
        val weatherRemote = ArticleRemote(
            dt = 3,
            weather = listOf(
                WeatherRemoteInfo(
                    main = remoteKind,
                    description = "description",
                    icon = "04d"
                )
            )
        )


        // When
        val weather = mapper.toEntity(weatherRemote)

        // Then

        with(weather) {
            assertThat(dateTime).isEqualTo(3)
            assertThat(kind).isEqualTo(expectedWeatherKind)
            assertThat(description).isEqualTo("description")
            assertThat(description).isEqualTo("04d")
        }
    }
}