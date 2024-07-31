package com.example.dailyscoop.repository

import com.example.dailyscoop.db.ArticleDatabase
import com.example.dailyscoop.api.RetrofitInstance
import com.example.dailyscoop.model.Article

class NewsRepository (val db: ArticleDatabase) {

     suspend fun getHeadlines(countryCode: String,pageNumber: Int) =
         RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

     suspend fun searchNews(searchQuery:String,pageNumber: Int) =
         RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

     suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}