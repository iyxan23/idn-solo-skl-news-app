package com.iyxan.newz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iyxan.newz.data.NewsResponse
import com.iyxan.newz.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>

    fun retrieveCommonMuslimNews() {
        ApiClient.provideApiService().getCommonNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _commonMuslimNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    private var _aboutAlQuranNews = MutableLiveData<NewsResponse>()
    val aboutAlQuranNews get() = _aboutAlQuranNews as LiveData<NewsResponse>

    fun retrieveAboutAlQuranNews() {
        ApiClient.provideApiService().getAlQuranNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _aboutAlQuranNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    private var _alJazeeraNews = MutableLiveData<NewsResponse>()
    val alJazeeraNews get() = _alJazeeraNews as LiveData<NewsResponse>

    fun retrieveAlJazeeraNews() {
        ApiClient.provideApiService().getAlJazeeraNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _alJazeeraNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    private var _warningForMuslimNews = MutableLiveData<NewsResponse>()
    val warningForMuslimNews get() = _warningForMuslimNews as LiveData<NewsResponse>

    fun retrieveWarningForMuslimNews() {
        ApiClient.provideApiService().getWarningforMuslimNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _warningForMuslimNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    private var _searchedNews = MutableLiveData<NewsResponse>()
    val searchedNews get() = _searchedNews as LiveData<NewsResponse>

    fun performSearch(query: String) {
        ApiClient.provideApiService().getSearchNews(query)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _searchedNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

}