package com.tryandlearn.interface_adapter.article.model

import com.tryandlearn.entity.article.Article

data class ArticleUIModel(
    val title: String,
    val html: String?,
) {
    class Mapper {
        fun fromEntity(article: Article) = ArticleUIModel(
            title = article.title,
            html = article.html,
        )
    }
}
