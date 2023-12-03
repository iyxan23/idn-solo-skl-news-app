package com.iyxan.newz.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyxan.newz.NewsViewModel
import com.iyxan.newz.adapter.NewsAdapter
import com.iyxan.newz.data.NewsResponse
import com.iyxan.newz.databinding.FragmentAboutAlQuranBinding

class AboutAlQuranFragment : BaseNewsFragment<FragmentAboutAlQuranBinding>(FragmentAboutAlQuranBinding::inflate) {
    override fun getObservableNews(newsViewModel: NewsViewModel): LiveData<NewsResponse> = newsViewModel.aboutAlQuranNews
    override fun retrieveNews(newsViewModel: NewsViewModel) = newsViewModel.retrieveAboutAlQuranNews()

    override fun bindViews(
        binding: FragmentAboutAlQuranBinding,
        adapter: NewsAdapter,
        response: NewsResponse
    ) {
        binding.rvAlquraan.layoutManager = LinearLayoutManager(this@AboutAlQuranFragment.context)
        binding.rvAlquraan.adapter = adapter;

        binding.loadingView.root.visibility = View.GONE
    }
}
