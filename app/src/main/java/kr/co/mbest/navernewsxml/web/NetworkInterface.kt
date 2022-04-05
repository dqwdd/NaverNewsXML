package kr.co.mbest.navernewsxml.web

import android.sax.Element
import com.box.retrofit_custom.NetworkResponse
import com.box.retrofit_custom.NetworkResponseAdapterFactory
import kr.co.mbest.navernewsxml.data.RssFeed
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkInterface {

    @GET("search/news.xml")
    suspend fun getRequestNewsList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String
    ):
            NetworkResponse<RssFeed, Error>
//            Call<RssFeed?>?

}