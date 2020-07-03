package com.rocketskill.weather.ui.list

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.rocketskill.R
import com.rocketskill.application.HomeActivity
import com.rocketskill.weather.ui.util.atPosition
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class WeatherListFragmentTest {

    @get:Rule
    val myActivityTestRule: ActivityTestRule<HomeActivity> =
        ActivityTestRule<HomeActivity>(HomeActivity::class.java, false, false)

//    private val mockWebServer = MockWebServer()

//    @Before
//    fun setup() {
//        mockWebServer.start(8080)
//        IdlingRegistry.getInstance().register(
//            OkHttp3IdlingResource.create(
//                "okhttp",
//                OkHttpClient.Builder().build()
//            ))
//    }

//    @After
//    fun teardown() {
//       mockWebServer.shutdown()
//    }

    @Test
    fun testEventFragment() {
//        mockWebServer.dispatcher = object : Dispatcher() {
//            override fun dispatch(request: RecordedRequest): MockResponse {
//                return MockResponse()
//                    .setResponseCode(200)
//                    .setBody(FileReader.readStringFromFile("response.json"))
//            }
//        }
        reloadActivity()
        onView(withId(R.id.hourly_weather_list))
            .check(matches(atPosition(0, withText("Test Text"))))
    }

    private fun reloadActivity() {
        val intent = Intent()
        myActivityTestRule.launchActivity(intent)
    }
}