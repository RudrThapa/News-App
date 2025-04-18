package com.rudroid.newsapp.api

import com.google.android.material.textfield.TextInputLayout.LengthCounter
import com.rudroid.newsapp.models.NewsResponse
import com.rudroid.newsapp.util.Constants.Companion.API_KEY
import com.rudroid.newsapp.util.Constants.Companion.QUERY_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(

        @Query("country")
        countryCode: String = "us",

        @Query("page")
        pageNumber: Int = 1,

        @Query("api")
        apiKey: String = API_KEY

    ): Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(

        //"q" Keywords or phrases to *search* for in the article title and body.
        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1,

        @Query("api")
        apiKey: String = API_KEY

    ): Response<NewsResponse>

}