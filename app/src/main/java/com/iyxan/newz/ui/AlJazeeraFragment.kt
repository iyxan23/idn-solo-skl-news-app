package com.iyxan.newz.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyxan.newz.NewsViewModel
import com.iyxan.newz.adapter.NewsAdapter
import com.iyxan.newz.data.NewsResponse
import com.iyxan.newz.databinding.FragmentAlJazeeraBinding

class AlJazeeraFragment : BaseNewsFragment<FragmentAlJazeeraBinding>(FragmentAlJazeeraBinding::inflate) {
    override fun getObservableNews(newsViewModel: NewsViewModel): LiveData<NewsResponse> = newsViewModel.alJazeeraNews
    override fun retrieveNews(newsViewModel: NewsViewModel) = newsViewModel.retrieveAlJazeeraNews()

    override fun bindViews(binding: FragmentAlJazeeraBinding, adapter: NewsAdapter, response: NewsResponse) {
        binding.rvAljazeera.layoutManager = LinearLayoutManager(this@AlJazeeraFragment.context)
        binding.rvAljazeera.adapter = adapter;

        binding.loadingView.root.visibility = View.GONE
    }
}
