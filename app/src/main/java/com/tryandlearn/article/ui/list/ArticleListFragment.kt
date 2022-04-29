package com.tryandlearn.article.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tryandlearn.R
import com.tryandlearn.article.ui.adapter.ArticleListAdapter
import com.tryandlearn.interface_adapter.article.ArticleListViewModel
import com.tryandlearn.interface_adapter.article.model.ArticleUIModel
import com.tryandlearn.interface_adapter.base.ErrorState
import com.tryandlearn.interface_adapter.base.LoadingState
import com.tryandlearn.util.hide
import com.tryandlearn.util.show
import kotlinx.android.synthetic.main.fragment_article_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ArticleListFragment : Fragment() {

    private val viewModel by viewModel<ArticleListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.observeArticleList()
    }


    private fun observeViewModel() {
        viewModel.states.observe(viewLifecycleOwner) { state ->
            state?.let {
                when (state) {
                    is LoadingState -> showLoader()
                    is ErrorState -> showError(state.error)
                    is ArticleListViewModel.ArticleListState -> showDailyWeatherList(state.articleUIModelList)
                }
            }
        }
    }

    private fun showDailyWeatherList(articleUIModelList: List<ArticleUIModel>) {
        if (article_list.adapter == null) {
            article_list.adapter = ArticleListAdapter { html ->
                val action =
                    html?.let {
                        ArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment(
                            it
                        )
                    }
                action?.let { findNavController().navigate(it) } ?: showNullHtmlMessage()
            }
        }
        (article_list.adapter as ArticleListAdapter).articleList =
            articleUIModelList.toMutableList()
        progress_bar.hide()

    }

    private fun showNullHtmlMessage() {
        Toast.makeText(context, "NO HTML HERE", Toast.LENGTH_SHORT).show()
    }

    private fun showError(error: Throwable) {
        progress_bar.hide()
        article_error.show()
        article_error.text = error.toString()
    }

    private fun showLoader() {
        progress_bar.show()
    }
}
