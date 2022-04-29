package com.tryandlearn.use_case.article.data.source

import com.tryandlearn.entity.article.Article
import io.reactivex.Flowable

interface ArticleLocalDataSource {
    fun getArticleList(): Flowable<List<Article>>
}
