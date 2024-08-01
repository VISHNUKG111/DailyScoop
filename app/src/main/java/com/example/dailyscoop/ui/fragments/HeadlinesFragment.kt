package com.example.dailyscoop.ui.fragments

import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.dailyscoop.adaptors.NewsAdapter
import com.example.dailyscoop.ui.NewsViewModel
import java.lang.Error

class HeadlinesFragment : Fragment() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var retryButton: Button
    lateinit var errorText: TextView
    lateinit var itemHeadlinesError: CardView
}