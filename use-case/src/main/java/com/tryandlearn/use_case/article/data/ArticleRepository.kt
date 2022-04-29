package com.tryandlearn.use_case.article.data

import com.tryandlearn.entity.article.Article
import com.tryandlearn.use_case.article.data.source.ArticleLocalDataSource
import com.tryandlearn.use_case.article.data.source.ArticleRemoteDataSource
import io.reactivex.Flowable

class ArticleRepository(
    private val ArticleRemoteDataSource: ArticleRemoteDataSource,
    private val ArticleLocalDataSource: ArticleLocalDataSource
) {
    fun getArticleList(): Flowable<List<Article>> =
        ArticleRemoteDataSource.getArticleList().startWith(ArticleLocalDataSource.getArticleList())
}
