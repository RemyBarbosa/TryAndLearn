package com.tryandlearn.util

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.tryandlearn.application.TestApplication

class MockTestRunner : AndroidJUnitRunner() {

  override fun newApplication(cl: ClassLoader?, className: String?,
                              context: Context?): Application {
    return super.newApplication(cl, TestApplication::class.java.name, context)
  }
}