package com.example.dailyscoop.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.dailyscoop.R
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewmodel:
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view, savedInstanceState: bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        NewsViewsModel = (activity as NewsActivity)newsViewModel
        val article = args.article

        binding.webview.apply {
            webViewClient = WebVewClient()
            article.url.let {
                loadurl(it)
            }
        }

        binding.fab.setOnClickListener{
            newsViewmodel.addToFavourites(article)
            Snackbar.make(view, "added to favourites", Snackbar.make(view, text:"added to favourites", Snackbar.LENGTH_SHORT)Show()
        }
    }

}