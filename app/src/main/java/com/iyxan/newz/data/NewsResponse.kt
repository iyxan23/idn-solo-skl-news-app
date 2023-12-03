package com.iyxan.newz.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "totalResults") val totalResults: Int,
    @Json(name = "articles") val articles: List<ArticlesItem>,
    @Json(name = "status") val status: String
)

@JsonClass(generateAdapter = true)
@Parcelize
data class Source(
    @Json(name = "name") val name: String
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ArticlesItem(
    @Json(name = "publishedAt") val publishedAt: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "urlToImage") val urlToImage: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "source") val source: Source?,
    @Json(name = "title") val title: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "content") val content: String?
) : Parcelable
