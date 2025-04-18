package com.rudroid.newsapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import com.rudroid.newsapp.util.Constants
import com.rudroid.newsapp.util.Constants.Companion.BASE_URL
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    //companion object means whatever we write inside it will remain static or fixed values.
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}