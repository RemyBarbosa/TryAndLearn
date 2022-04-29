package com.tryandlearn.use_case.di

import com.tryandlearn.use_case.article.GetArticleListUseCase
import com.tryandlearn.use_case.article.data.ArticleRepository
import org.koin.dsl.module

val useCaseModule = module {
    single { GetArticleListUseCase(get()) }

    single { ArticleRepository(get(), get()) }
}
