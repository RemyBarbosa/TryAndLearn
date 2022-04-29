package com.tryandlearn.interface_adapter.di

import com.tryandlearn.interface_adapter.article.ArticleManager
import org.koin.dsl.module

val interfaceAdapterModule = module {
    single { ArticleManager(get(), get()) }
}
