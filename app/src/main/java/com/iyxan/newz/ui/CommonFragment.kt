package com.iyxan.newz.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyxan.newz.NewsViewModel
import com.iyxan.newz.adapter.NewsAdapter
import com.iyxan.newz.data.NewsResponse
import com.iyxan.newz.databinding.FragmentCommonBinding

class CommonFragment : BaseNewsFragment<FragmentCommonBinding>(FragmentCommonBinding::inflate) {
    override fun getObservableNews(newsViewModel: NewsViewModel): LiveData<NewsResponse> = newsViewModel.commonMuslimNews
    override fun retrieveNews(newsViewModel: NewsViewModel) = newsViewModel.retrieveCommonMuslimNews()

    override fun bindViews(binding: FragmentCommonBinding, adapter: NewsAdapter, response: NewsResponse) {
        binding.rvCommonNews.layoutManager = LinearLayoutManager(this@CommonFragment.context)
        binding.rvCommonNews.adapter = adapter;

        binding.loadingView.root.visibility = View.GONE
    }
}