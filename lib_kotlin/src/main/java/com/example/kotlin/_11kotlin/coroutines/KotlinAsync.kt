package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinDateUtil
import kotlinx.coroutines.*

@DevKotlin("获取协程的 返回值 --- async 函数")
fun main() {

    runBlocking {
        //async 会创建一个子协程，并返回结果
        //1. async 函数返回一个 Deferred 对象，
        //2. 调用 async 函数 代码块 会被立即执行
        //3. await() 在调用时如果，作用域的代码未执行完成，会阻塞作用域
        //4. Deferred 对象调用 await() 函数就会得到 执行结果
        //5. 修改 await 调用时机
        val result = async {
            5 + 5
        }.await()
        KotlinDateUtil.printlnAndTime(result.toString())

        asyncTest()
        asyncTest2()
    }
//    asyncTest()//挂起方法必须在作用域中调用或者挂起方法
}

suspend fun asyncTest() = coroutineScope {
    launch {
        val start = System.currentTimeMillis()
        val result = async {
            delay(1000)
            5 + 5
        }.await()

        val result2 = async {
            delay(1000)
            10 + 10
        }.await()


        println("result1 = $result , result2 = $result2")
        val end = System.currentTimeMillis()
        println("time = ${end - start} ")
    }
}
@DevKotlin("和 asyncTest() 函数相比，修改 await() 调用时机")
suspend fun asyncTest2() = coroutineScope {
    launch {
        val start = System.currentTimeMillis()
        val result = async {
            println("asyncTest2  start111 ")
            delay(1000)
            println("asyncTest2  end111 ")
            5 + 5
        }

        val result2 = async {
            println("asyncTest2  start 222 第二个延迟 ")
            delay(1000)
            println("asyncTest2   end 第二个延迟 ")
            10 + 10
        }
        //延迟5秒 确定
        delay(5000)
        // 验证 await() 在调用时如果，作用域的代码未执行完成，会阻塞作用域
        println("asyncTest2   延迟5秒再 调用 await() ")
        println("result1 = ${result.await()} , result2 = ${result2.await()}")
        val end = System.currentTimeMillis()
        println("time = ${end - start} ")
    }
}

