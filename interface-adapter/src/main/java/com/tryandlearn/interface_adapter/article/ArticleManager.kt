package com.tryandlearn.interface_adapter.article

import com.tryandlearn.interface_adapter.article.model.ArticleUIModel
import com.tryandlearn.use_case.article.GetArticleListUseCase
import io.reactivex.Flowable


class ArticleManager(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val mapper: ArticleUIModel.Mapper
) {
    fun getArticleList(): Flowable<List<ArticleUIModel>> {
        return getArticleListUseCase.execute().map { list ->
            list.map { mapper.fromEntity(it) }
        }
    }
}
