package com.example.kotlin._11kotlin.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_11_retorfit_main.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.ResponseText
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import kotlin.concurrent.thread

@DevKotlin("retrofit 简单实用")
class RetrofitMainActivity : AppCompatActivity() {
    val TAG = "OkHttpActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_11_retorfit_main)
        //1.搭建 apache 服务器  本地url http://127.0.0.1/get_data.json
        //1.添加依赖 implementation 'com.squareup.retrofit2:retrofit:2.0.2'
        //2.json 的解析库 implementation 'com.squareup.retrofit2:converter-gson:2.0.2'

        OkHttpRequest.setOnClickListener {
            senRequestWithOkHttp()
        }

        RetrofitRequest.setOnClickListener {
            senRequestWithRetrofit()
        }
    }

    private fun showResponseText(text: String) {
        runOnUiThread {
            //转到 主线程
            ResponseText.text = text
        }
    }

    private fun senRequestWithOkHttp() {
        ResponseText.text = ""
        //带有callback
        val httpClient = OkHttpClient()
        val request2 = Request.Builder()
                .url("http://127.0.0.1/get_data.json")
                .build()

        val response = httpClient.newCall(request2).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.v(TAG, "OkHttp  onFailure")
                showResponseText("请求失败")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                Log.v(TAG, "OkHttp  onResponse")
                val result = response.body?.string()
                showResponseText(result ?: "response body is null")
            }

        })
    }

    private fun senRequestWithRetrofit() {
        ResponseText.text = ""
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(AppService::class.java)
        service.getAppDate().enqueue(object : Callback<List<AppData>> {
            override fun onFailure(call: Call<List<AppData>>, t: Throwable) {
                Log.v(TAG, " Retrofit  onFailure")

            }

            override fun onResponse(call: Call<List<AppData>>, response: Response<List<AppData>>) {
                Log.v(TAG, " Retrofit  onResponse")
                val list = response.body()
                if(list != null){
                    for (app in list){
                        Log.v(TAG, " app is id = ${app.id} ")
                        Log.v(TAG, " app is name = ${app.name} ")
                        Log.v(TAG, " app is version = ${app.version} ")
                    }
                }
            }

        })

    }
}