package com.example.kotlin._11kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.ResponseText
import kotlinx.android.synthetic.main.kotlin_ok_http_activity.*
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

@DevKotlin("okhttp 简单调用")
class OkHttpActivity : AppCompatActivity() {
    val TAG = "OkHttpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_ok_http_activity)

        OkHttpCallBack.setOnClickListener {
            okhttpCreateCallBack()
        }
    }

    fun doRequest(view: View) {
        okhttpCreate1()
    }


    private fun showResponseText(text: String) {
        runOnUiThread {
            //转到 主线程
            ResponseText.text = text
        }
    }

    @DevKotlin("同步方法 ")
    private fun okhttpCreate1() {
        thread {
            //创建一个 OkHttpClient
            val httpClient = OkHttpClient()
            val request2 = Request.Builder()
                    .url("https://www.baidu.com/")
                    .build()

            val response = httpClient.newCall(request2).execute()
            //No.1
            response.body?.let {
                showResponseText(it.string())
            }

//            //No.2
//            val responseData2 = response.body?.string()
//            if(responseData2 != null){
//                showResponseText(responseData2)
//            }

        }
    }

    @DevKotlin("异步方法 + 回调")
    private fun okhttpCreateCallBack() {
        val httpClient = OkHttpClient()
        val request2 = Request.Builder()
                .url("https://www.baidu.com/")
                .build()

        val response = httpClient.newCall(request2).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.v(TAG, " onFailure")
                showResponseText("请求失败")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.v(TAG, " onResponse")
                val result = response.body?.string()
                showResponseText(result ?: "response body is null")
            }

        })
    }
}
