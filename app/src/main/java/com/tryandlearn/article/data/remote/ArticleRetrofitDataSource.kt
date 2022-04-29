package com.tryandlearn.article.data.remote

import com.tryandlearn.interface_adapter.article.model.ArticleRemoteList
import io.reactivex.Flowable
import retrofit2.http.GET


interface ArticleRetrofitDataSource {

    @GET("ws/8/mobile/www/android-phone/en_continu/index.json")
    fun getArticleList(): Flowable<ArticleRemoteList>
}
