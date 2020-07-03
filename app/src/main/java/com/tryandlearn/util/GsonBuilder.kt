package com.tryandlearn.util

import com.google.gson.Gson

object GsonBuilder {

    val gson: Gson
        get() = com.google.gson.GsonBuilder()
            .create()

}