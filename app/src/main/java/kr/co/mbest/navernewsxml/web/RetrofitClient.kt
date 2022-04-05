package kr.co.mbest.navernewsxml.web

import com.box.retrofit_custom.NetworkResponseAdapterFactory
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitClient {
    private var instance: Retrofit? = null
    fun getInstance(): Retrofit {

        if (instance == null)
            instance = Retrofit.Builder()
                .baseUrl("https://openapi.naver.com/v1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(
                    TikXmlConverterFactory.create(
                        TikXml.Builder().exceptionOnUnreadXml(false).build()
                    )
                )
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .build()
        return instance!!
    }
}