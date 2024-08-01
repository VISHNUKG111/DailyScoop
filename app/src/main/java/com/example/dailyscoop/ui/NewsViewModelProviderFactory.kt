package com.example.dailyscoop.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.dailyscoop.repository.NewsRepository

class NewsViewModelProviderFactory(val app: Application, val newsRepository: NewsRepository): ViewModelProvider {
}