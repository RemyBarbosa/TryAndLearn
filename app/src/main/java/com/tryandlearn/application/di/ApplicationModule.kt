package com.tryandlearn.application.di

import com.tryandlearn.article.data.local.ArticleLocalDataSourceImpl
import com.tryandlearn.article.data.remote.ArticleRemoteDataSourceImpl
import com.tryandlearn.interface_adapter.article.ArticleListViewModel
import com.tryandlearn.interface_adapter.di.interfaceAdapterModule
import com.tryandlearn.interface_adapter.di.mapperModule
import com.tryandlearn.use_case.article.data.source.ArticleLocalDataSource
import com.tryandlearn.use_case.article.data.source.ArticleRemoteDataSource
import com.tryandlearn.use_case.di.useCaseModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { ArticleListViewModel(get()) }

    single { ArticleRemoteDataSourceImpl(get(), get()) as ArticleRemoteDataSource}
    single { ArticleLocalDataSourceImpl() as ArticleLocalDataSource}
}

val applicationInjectionsModules = listOf(
        applicationModule,
        retrofitModule,
        retrofitDependenciesModule,
        interfaceAdapterModule,
        useCaseModule,
        mapperModule
)

val applicationTestInjectionsModules = listOf(
        applicationModule,
        retrofitTestModule,
        retrofitDependenciesModule,
        interfaceAdapterModule,
        useCaseModule,
        mapperModule
)
