package com.tryandlearn.article.data.local

import com.tryandlearn.entity.article.Article
import com.tryandlearn.use_case.article.data.source.ArticleLocalDataSource
import io.reactivex.Flowable

class ArticleLocalDataSourceImpl : ArticleLocalDataSource {

    override fun getArticleList(): Flowable<List<Article>> {
        return Flowable.just(
            listOf(
                Article(
                    title = "Cache articles",
                    html = "some html",
                )
            )
        )
    }
}
