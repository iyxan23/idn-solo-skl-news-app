package com.iyxan.newz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.iyxan.newz.NewsViewModel
import com.iyxan.newz.adapter.NewsAdapter
import com.iyxan.newz.data.NewsResponse

/**
 * Hehe I felt like the original code is less DRY so I did this myself
 */
abstract class BaseNewsFragment<ViewBindingType: ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> ViewBindingType
) : Fragment() {
    private val newsViewModel: NewsViewModel by activityViewModels()

    private lateinit var binding: ViewBindingType
    private val rvAdapter: NewsAdapter by lazy { NewsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflateMethod(inflater, container, false)

        this.getObservableNews(newsViewModel).observe(viewLifecycleOwner) { news ->
            rvAdapter.setData(news.articles)

            bindViews(binding, rvAdapter, news)
        }

        this.retrieveNews(newsViewModel)

        return binding.root
    }

    abstract fun getObservableNews(newsViewModel: NewsViewModel): LiveData<NewsResponse>
    abstract fun retrieveNews(newsViewModel: NewsViewModel)
    abstract fun bindViews(binding: ViewBindingType, adapter: NewsAdapter, response: NewsResponse)
}