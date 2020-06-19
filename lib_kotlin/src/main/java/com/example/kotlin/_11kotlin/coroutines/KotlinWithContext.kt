package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.coroutines.*

@DevKotlin("withContext 函数")
fun main() {
    // 通常创建一个 协程域
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        val result = async {
            delay(1000)
            5 + 5
        }.await()


        //调用 withContext 函数 也是一个挂起函数
        // withContext() 函数 会立即执行 代码块 的代码
        val result2 = withContext(Dispatchers.Default){
            delay(1000)
            5 + 5
        }
        println("result2 = $result2")
    }
}
