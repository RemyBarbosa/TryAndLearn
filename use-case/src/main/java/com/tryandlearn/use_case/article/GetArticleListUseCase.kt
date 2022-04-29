package com.tryandlearn.use_case.article


import com.tryandlearn.entity.article.Article
import com.tryandlearn.use_case.article.data.ArticleRepository
import io.reactivex.Flowable

class GetArticleListUseCase(
    private val articleRepository: ArticleRepository
) {
    fun execute( ): Flowable<List<Article>> {
        return articleRepository.getArticleList()
    }
}
