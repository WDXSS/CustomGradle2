package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._11kotlin.util.HttpCallbackListener
import com.example.kotlin._11kotlin.util.HttpUtil
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@DevKotlin("使用协程简化回调的写法")
fun main() {
    // 借用 suspendCoroutine 函数 简化回调写法
    //1. suspendCoroutine 必须执行在 协程作用域中 或者 挂起方法中
    //2. suspendCoroutine 接收一个lambda 表达式，主要作用是将当前协程挂起，然后在一个普通的线程中执行 lambda 表达式
    //3. lambda 表达式表达式 参数中回传入一个 Continuation ，
    //   调用他的 it.resume() 和 resumeWithException() 就会回到当前协程中
    println("main Thread name = " + Thread.currentThread().name)
    runBlocking {
        println("runBlocking Thread name =  " + Thread.currentThread().name)
       val response =  request("https://www.baidu.com/")
        println("runBlocking Thread response =  $response")
    }
}


@DevKotlin("使用suspendCoroutine 函数 简化回调的写法")
suspend fun request(address: String): String {
    return suspendCoroutine {

        println("suspendCoroutine  Thread name =  " + Thread.currentThread().name)
        HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
            override fun onFinish(response: String) {
                it.resume(response)
            }

            override fun onError(e: Exception) {
                it.resumeWithException(e)
            }
        })
    }
}