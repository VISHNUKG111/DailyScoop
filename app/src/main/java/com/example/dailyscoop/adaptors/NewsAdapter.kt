package com.example.dailyscoop.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyscoop.R
import com.example.dailyscoop.model.Article

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    lateinit var articleImage: ImageView
    lateinit var articlesource: TextView
    lateinit var articleDescription: TextView
    lateinit var articleDateTime: TextView


      private val differCallback = object : DiffUtil.ItemCallback<Article>(){
          override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
              return oldItem.url == newItem.url
          }

          override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
             return oldItem == newItem
          }

      }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}