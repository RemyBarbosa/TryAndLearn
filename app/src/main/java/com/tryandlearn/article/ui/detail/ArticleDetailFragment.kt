package com.tryandlearn.article.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tryandlearn.R
import com.tryandlearn.interface_adapter.article.ArticleListViewModel
import kotlinx.android.synthetic.main.fragment_article_detail.*
import org.koin.android.viewmodel.ext.android.viewModel


class ArticleDetailFragment : Fragment() {

    private val args: ArticleDetailFragmentArgs by navArgs()

    private val viewModel by viewModel<ArticleListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mimeType = "text/html"
        val encoding = "UTF-8"
        article_detail_web_view.loadDataWithBaseURL("", args.html, mimeType, encoding, "")
    }
}
