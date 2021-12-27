package kr.co.mbest.navernewsxml.web

import kr.co.mbest.navernewsxml.data.RssFeed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkInterface {

    @GET("search/news.xml")
    fun getRequestNewsList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String
    ): Call<RssFeed?>?

}