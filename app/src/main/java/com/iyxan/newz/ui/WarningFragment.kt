package com.iyxan.newz.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyxan.newz.NewsViewModel
import com.iyxan.newz.adapter.NewsAdapter
import com.iyxan.newz.data.NewsResponse
import com.iyxan.newz.databinding.FragmentWarningBinding

class WarningFragment : BaseNewsFragment<FragmentWarningBinding>(FragmentWarningBinding::inflate) {
    override fun getObservableNews(newsViewModel: NewsViewModel): LiveData<NewsResponse> = newsViewModel.warningForMuslimNews
    override fun retrieveNews(newsViewModel: NewsViewModel) = newsViewModel.retrieveWarningForMuslimNews()

    override fun bindViews(binding: FragmentWarningBinding, adapter: NewsAdapter, response: NewsResponse) {
        binding.rvWarningNews.layoutManager = LinearLayoutManager(this@WarningFragment.context)
        binding.rvWarningNews.adapter = adapter;

        binding.loadingView.root.visibility = View.GONE
    }
}
