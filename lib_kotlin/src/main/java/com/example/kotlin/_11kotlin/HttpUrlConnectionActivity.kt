package com.example.kotlin._11kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

@DevKotlin("使用 httpUrlConnection 请求网络数据")
class HttpUrlConnectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.kotlin_http_url_connection_activity)

        //1.use Kotlin 内置扩展函数 P276
    }

    fun doRequest(view: View) {

        thread {
            val responseText = StringBuilder()
            //配置 connection
            val url = URL("https://www.baidu.com/")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.connectTimeout = 8000
            httpURLConnection.readTimeout = 8000

            val input = httpURLConnection.inputStream
            //读取 input
            val reader = BufferedReader(InputStreamReader(input))

            reader.use {
                reader.forEachLine {
                    responseText.append(it)
                }
            }

            showResponseText(responseText.toString())
        }
    }

    private fun showResponseText(text: String) {
        runOnUiThread {
            //转到 主线程
            ResponseText.text = text
        }
    }
}