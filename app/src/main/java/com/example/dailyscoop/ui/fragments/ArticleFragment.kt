package com.example.dailyscoop.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.dailyscoop.R
import com.example.dailyscoop.databinding.FragmentArticleBinding
import com.example.dailyscoop.ui.NewsActivity
import com.example.dailyscoop.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var newsViewModel: NewsViewModel
    private val args by navArgs<ArticleFragmentArgs>()
    private lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }


        binding.fab.setOnClickListener{
            newsViewModel.addToBookmark(article)
            Snackbar.make(view, "Added to Bookmark", Snackbar.LENGTH_SHORT).show()
        }
    }

}