package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.article.model.ArticleRemote
import com.tryandlearn.interface_adapter.article.model.ArticleUIModel
import org.koin.dsl.module

val mapperModule = module {
    single { ArticleUIModel.Mapper() }
    single { ArticleRemote.Mapper() }


}
