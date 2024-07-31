package com.example.dailyscoop.model

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)