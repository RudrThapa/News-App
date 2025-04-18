package com.rudroid.newsapp.repository

import com.rudroid.newsapp.api.RetrofitInstance
import com.rudroid.newsapp.db.ArticleDatabase
import com.rudroid.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int) =  RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteAtricle(article: Article) = db.getArticleDao().deleteArticle(article)

}