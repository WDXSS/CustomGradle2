package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinDateUtil
import kotlinx.coroutines.*

@DevKotlin("withContext 函数,1，2,3 有三点")
fun main() {
    println("main Thread name =  " + Thread.currentThread().name)
    // 通常创建一个 协程域
    val job = Job()
    val scope = CoroutineScope(job)
    println("main Thread name =  " + Thread.currentThread().name)
    KotlinDateUtil.printlnAndTime("main  -start------")
    scope.launch {
        println("CoroutineScope Thread name =  " + Thread.currentThread().name)
        val result = async {
            KotlinDateUtil.printlnAndTime("async  start")
            delay(2000)
            KotlinDateUtil.printlnAndTime("async  延迟2秒")
            5 + 5
        }
//       .await() //1. await() 调用后如果代码块没有执行完，会阻塞当前协程

        //调用 withContext 函数 也是一个挂起函数
        // withContext() 函数 会立即执行 代码块 的代码
        val result2 = withContext(Dispatchers.Default){
            println("withContext Thread name =  " + Thread.currentThread().name)
            KotlinDateUtil.printlnAndTime("withContext  start")
            delay(1000)
            KotlinDateUtil.printlnAndTime("withContext  延迟1秒")
            5 + 5
        }
        println("result2 = $result2 +, 修改 await 的调用位置 ${result.await()}，" +
                "2.根据打印日志证明 withContext 创建一个新协程")
    }
    //3.线程不睡5000，CoroutineScope 创建的协程没有机会执行
    Thread.sleep(5000)
    KotlinDateUtil.printlnAndTime("main  ----end---")

    //4. withContext() 函数强制指定 线程参数
    // Dispatchers.Default，低并发线程
    // Dispatchers.Main，   不会开启子线程
    // Dispatchers.IO      IO线程
}
