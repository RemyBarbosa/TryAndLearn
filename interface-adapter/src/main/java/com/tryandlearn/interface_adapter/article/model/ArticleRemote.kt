package com.tryandlearn.interface_adapter.article.model

import com.tryandlearn.entity.article.Article

data class ArticleRemote(
    val titre: String?,
    val html: String?,
) {

    class Mapper {
        fun toEntity(articleRemote: ArticleRemote): Article? {
            return articleRemote.titre?.let {
                Article(
                    title = it,
                    html = articleRemote.html,
                )
            }
        }
    }
}
