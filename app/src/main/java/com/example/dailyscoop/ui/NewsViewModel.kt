package com.example.dailyscoop.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dailyscoop.model.Article
import com.example.dailyscoop.model.NewsResponse
import com.example.dailyscoop.repository.NewsRepository
import kotlinx.coroutines.launch
import okhttp3.Response
import com.example.dailyscoop.util.Resource

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
                } else{
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

                } else{
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

    fun addToBookmark(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun getBookmarkNews() = newsRepository.getBookmarkNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun internetConnection(context:Context):Boolean{
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            return getNetworkCapabilities(activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false

                }
            } ?: false
        }

        private suspend fun headlinesInternet(countryCode:String){
            headlines.postValue(Resource.Loading())
            try {
                if (internetConnection(this.getApplication())) {
            }

        }

    }







}