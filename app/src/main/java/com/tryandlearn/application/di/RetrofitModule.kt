package com.tryandlearn.application.di

import com.tryandlearn.article.data.remote.ArticleRetrofitDataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single {
        Retrofit.Builder()
                .baseUrl("https://aec.lemonde.fr/")
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(get())
                .client(get())
                .build().create(ArticleRetrofitDataSource::class.java)
    }
}

