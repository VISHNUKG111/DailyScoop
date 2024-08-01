package com.example.dailyscoop.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.dailyscoop.model.Article
import com.example.dailyscoop.model.NewsResponse
import com.example.dailyscoop.repository.NewsRepository
import kotlinx.coroutines.launch
import okhttp3.Response

class NewsViewModel(app: Application, val newsRepository: NewsRepository): AndroidViewModel(app) {

    val headlines : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var headlinesPage = 1
    var headlinesResponse : NewsResponse? =null
    val searchNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse : NewsResponse? = null
    var newSearchQuery : String? = null
    var oldSearchQuery : String? = null

    private fun handleHeadlinesResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if( response.isSuccessful){
            response.body()?.let { resultResponse ->
                headlinesPage++
                if (headlinesResponse == null) {
                    headlinesResponse = resultResponse
                }else{
                    val oldArticles = headlinesResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success( headlinesResponse ?: resultResponse)

            }
        }
        return Resource.Error(response.message())
    }
    private fun handleHeadlinesResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if( response.isSuccessful){
            response.body()?.let { resultResponse ->
                if (searchNewsResponse == null) || newSearchQuery != oldSearchQuery){
                    searchNewsPage =1
                    oldSearchQuery = newSearchQuery
                    searchNewsResponse =resultResponse

                }else{
                    searchNewsPage++
                    val oldArticles =searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success( searchNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(response.message())
    }

    fun addToFavorites(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }





}