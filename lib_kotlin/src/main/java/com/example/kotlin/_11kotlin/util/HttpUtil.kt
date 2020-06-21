package com.example.kotlin._11kotlin.util

import android.view.View
import com.example.kotlin._2kotlin.DevKotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

object HttpUtil {
    @DevKotlin("网络请求 添加回调 ")
    fun sendHttpRequest(address: String, callback: HttpCallbackListener) {
        var httpURLConnection: HttpURLConnection? = null
        try {
            val responseText = StringBuilder()
            //配置 connection
            val url = URL(address)
            httpURLConnection = url.openConnection() as HttpURLConnection
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
            callback.onFinish(responseText.toString())

        } catch (e: Exception) {
            callback.onError(e)
        } finally {
            httpURLConnection?.disconnect()
        }

    }
}