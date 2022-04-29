package com.tryandlearn.article.ui.list

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.tryandlearn.R
import com.tryandlearn.application.HomeActivity
import com.tryandlearn.util.FileReader
import com.tryandlearn.util.atPosition
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ArticleListFragmentTest {

    @get:Rule
    val myActivityTestRule: ActivityTestRule<HomeActivity> =
        ActivityTestRule<HomeActivity>(HomeActivity::class.java, false, false)

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        IdlingRegistry.getInstance().register(
            OkHttp3IdlingResource.create(
                "okhttp",
                OkHttpClient.Builder().build()
            ))
    }

    @After
    fun teardown() {
       mockWebServer.shutdown()
    }

    @Test
    fun testEventFragment() {
        mockWebServer.setDispatcher(object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(FileReader.readStringFromFile("body_files/dailyWeather.json"))
            }
        })
        reloadActivity()
        onView(withId(R.id.article_list))
            .check(matches(atPosition(0, hasDescendant(withText("scattered clouds")))))
    }

    private fun reloadActivity() {
        val intent = Intent()
        myActivityTestRule.launchActivity(intent)
    }
}