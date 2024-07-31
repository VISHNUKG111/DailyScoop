package com.example.dailyscoop.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.Resource
import com.example.dailyscoop.model.NewsResponse
import com.example.dailyscoop.repository.NewsRepository
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
    }



}