package com.tryandlearn.article.data.remote

import com.tryandlearn.entity.article.Article
import com.tryandlearn.interface_adapter.article.model.ArticleRemote
import com.tryandlearn.use_case.article.data.source.ArticleRemoteDataSource
import io.reactivex.Flowable

class ArticleRemoteDataSourceImpl(
    private val mapper: ArticleRemote.Mapper,
    private val articleRetrofitDataSource: ArticleRetrofitDataSource
) : ArticleRemoteDataSource {

    override fun getArticleList(): Flowable<List<Article>> {
        return articleRetrofitDataSource.getArticleList().map { articleRemoteList ->
            articleRemoteList.elements.mapNotNull {
                mapper.toEntity(it)
            }
        }
    }
}
