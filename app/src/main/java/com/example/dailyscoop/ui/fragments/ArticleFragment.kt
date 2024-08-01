package com.example.dailyscoop.ui.fragments

import javax.naming.Binding
import

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewmodel: NewsViewsModel
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