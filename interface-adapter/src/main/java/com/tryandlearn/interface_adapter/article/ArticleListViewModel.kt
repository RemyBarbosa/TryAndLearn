package com.tryandlearn.interface_adapter.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tryandlearn.interface_adapter.article.model.ArticleUIModel
import com.tryandlearn.interface_adapter.base.ErrorState
import com.tryandlearn.interface_adapter.base.LoadingState
import com.tryandlearn.interface_adapter.base.RxViewModel
import com.tryandlearn.interface_adapter.base.State
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticleListViewModel(
    private val articleManager: ArticleManager
) : RxViewModel() {

    private val mStates = MutableLiveData<State>()
    val states: LiveData<State>
        get() = mStates

    fun observeArticleList() {
        mStates.value = LoadingState
        launch {
            articleManager.getArticleList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(this::onArticleListReceive, this::onError)
        }
    }

    private fun onArticleListReceive(articleUiModelList: List<ArticleUIModel>) {
        mStates.value = ArticleListState(articleUiModelList)
    }

    private fun onError(error: Throwable) {
        mStates.value = ErrorState(error)
    }

    data class ArticleListState(val articleUIModelList: List<ArticleUIModel>) : State()
}