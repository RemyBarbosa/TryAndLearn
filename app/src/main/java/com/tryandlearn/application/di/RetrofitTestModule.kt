package com.tryandlearn.application.di

import com.tryandlearn.article.data.remote.ArticleRetrofitDataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitTestModule = module {

    single {
        Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(get())
                .client(get())
                .build().create(ArticleRetrofitDataSource::class.java)
    }
}

