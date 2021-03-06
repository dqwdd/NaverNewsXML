package kr.co.mbest.navernewsxml

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.box.retrofit_custom.NetworkResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kr.co.mbest.navernewsxml.data.Item
import kr.co.mbest.navernewsxml.data.RssFeed
import kr.co.mbest.navernewsxml.databinding.ActivityMainBinding
import kr.co.mbest.navernewsxml.web.NetworkInterface
import kr.co.mbest.navernewsxml.web.RetrofitClient
import retrofit2.*

class MainActivity : AppCompatActivity() {

    val clientId = "JKYo0rymvqruwdnb5Rge"
    val clientSecret = "uWTGgkfh0R"
    val hostURL = "https://openapi.naver.com/v1/"

    lateinit var binding: ActivityMainBinding

    private lateinit var retrofit: Retrofit
    lateinit var apiService: NetworkInterface

    val mItemList = ArrayList<Item>()

    lateinit var mRecyclerAdapter: MainNewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        retrofit = RetrofitClient.getInstance()
        apiService = retrofit.create()



        mRecyclerAdapter = MainNewsRecyclerAdapter(this, mItemList)
        binding.recyclerNews.adapter = mRecyclerAdapter

        binding.recyclerNews.layoutManager = LinearLayoutManager(this)

        binding.buttonSearch.setOnClickListener {
//            lifecycleScope.launch {
//                getNewsInformation()
//            }
            aa(binding.editSearch.text.toString())
        }//클릭버튼

    }

    fun aa(str: String) {
        lifecycleScope.launch {
            when( val tt = apiService.getRequestNewsList(clientId, clientSecret, str) ) {
                is NetworkResponse.Success -> Log.e("Main", "search: api success")
                is NetworkResponse.ApiError -> Log.e("Main", "search: api error")
                is NetworkResponse.NetworkError -> Log.e("Main", "search: network error")
                is NetworkResponse.UnknownError -> Log.e("Main", "search: UnknownError")
            }
        }
    }

//    private suspend fun getNewsInformation() {
//        var inputKeyword = binding.editSearch.text.toString()
//        apiService.getRequestNewsList(clientId, clientSecret, inputKeyword)!!.enqueue(object : Callback<RssFeed?> {
//                override fun onResponse(
//                    call: Call<RssFeed?>,
//                    response: Response<RssFeed?>
//                ) {
//                    if (response.isSuccessful) {
//
//                        Log.d("응답 성공", response.body()!!.toString())
//                        val basicResponse = response.body()!!
//                        mItemList.clear()
//                        mItemList.addAll(basicResponse.channel?.item!!)
//
//                        mRecyclerAdapter.notifyDataSetChanged()
//
//                    } else {
//                        Log.d("응답 실패", "${call.isCanceled.toString()}")
//                    }
//                }
//
//                override fun onFailure(call: Call<RssFeed?>, t: Throwable) {
//                    Log.d("연결 실패", call.toString())
//                    Log.d("연결 실패2", t.message.toString())
//                }
//            })
//    }

}