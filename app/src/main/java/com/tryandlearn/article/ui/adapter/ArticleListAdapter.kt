package com.tryandlearn.article.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tryandlearn.R
import com.tryandlearn.interface_adapter.article.model.ArticleUIModel
import com.tryandlearn.util.inflateFromParent
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleListAdapter(
    private val onArticleClicked: (html: String?) -> Unit
) : RecyclerView.Adapter<ArticleListAdapter.ArticleListViewHolder>() {

    var articleList: MutableList<ArticleUIModel> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListViewHolder {
        return ArticleListViewHolder(parent, onArticleClicked)
    }

    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int) {
        val dailyWeatherView = articleList[position]
        holder.bind(dailyWeatherView)
    }

    override fun getItemCount(): Int = articleList.size

    class ArticleListViewHolder(
        itemView: ViewGroup,
        private val onArticleClicked: (html: String?) -> Unit
    ) : RecyclerView.ViewHolder(itemView.inflateFromParent(R.layout.article_item)) {
        fun bind(articleUIModel: ArticleUIModel) = with(itemView) {
            article_title.text = articleUIModel.title
            itemView.setOnClickListener {
                onArticleClicked.invoke(articleUIModel.html)
            }
        }
    }
}
