package com.example.kotlin._11kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

@DevKotlin("okhttp")
class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_ok_http_activity)
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


}
