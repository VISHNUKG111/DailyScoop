package com.example.dailyscoop.adaptors

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ArticleviewHolder>() {

    inner class ArticleviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    lateinit var articleImage: ImageView
    lateinit var articlesource:TextView
    lateinit var articleDescription:TextView
    lateinit var articleDateTime:TextView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleviewHolder {
       return ArticleviewHolder(
         LayoutInflater.from((parent.context).
       )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArticleviewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}