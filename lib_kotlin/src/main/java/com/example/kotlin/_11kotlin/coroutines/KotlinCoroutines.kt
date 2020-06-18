package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin.util.KotlinDateUtil
import com.example.kotlin.util.KotlinDateUtil.printlnAndTime
import kotlinx.coroutines.*

fun main() {

    //1 .创建 顶层协程： 程序运行结束，协程也会结束
    GlobalScope.launch {
        printlnAndTime("GlobalScope codes run in coroutine scope")
    }

    //2. 创建一个协程，可以保证 协程作用域内的代码和子协程的代码执行完之前 阻塞线程
    runBlocking {
        printlnAndTime("runBlocking codes run in coroutine scope")
        //delay() 函数只能在协程或者挂起函数中调用
        delay(5000)
        printlnAndTime("runBlocking delay  最外层 延迟5 秒")
        // 创建 一个子协程
        val job = launch {
            printlnAndTime("runBlocking  launch 创建一个子 协程  start")
            delay(5000)
            printlnAndTime("runBlocking  launch 创建一个子 协程  延迟5 秒 end")
        }
        //3. 调用 挂起函数  suspend  :
        // 打印结果说明 suspend 挂起函数 不会继承外部作用域，不会创建子协程
        printDot()
        // 4. 通过 coroutineScope 函数 实现挂起函数，
        //    coroutineScope 特点 会继承外部协程的作用域，并创建一个子协程
        //    coroutineScope 可以保证在 其作用域的所有代码和子协程在全部执行完成之前阻塞当前协程
        printDot2()

        //5
        coroutineScope {
            printlnAndTime("runBlocking  coroutineScope start")
            delay(2000)
            printlnAndTime("runBlocking  coroutineScope 延迟2 秒  end")
        }
        //5.2  日志输出 证明 coroutineScope 创建 子协程
        coroutineScope {
            printlnAndTime("runBlocking  coroutineScope5.2  start")
            launch {
                delay(2000)
                printlnAndTime("runBlocking  coroutineScope5.2.1 延迟2 秒  end")
            }
            launch {
                delay(3000)
                printlnAndTime("runBlocking  coroutineScope5.2.2 延迟3 秒  end")
            }
            launch {
                delay(4000)
                printlnAndTime("runBlocking  coroutineScope5.2.3 延迟4 秒  end")
            }
            launch {
                delay(1000)
                printlnAndTime("runBlocking  coroutineScope5.2.4 延迟1 秒  end")
            }
            launch {
                delay(5000)
                printlnAndTime("runBlocking  coroutineScope5.2.5 延迟5 秒  end")
            }
            launch {
                delay(2000)
                printlnAndTime("runBlocking  coroutineScope5.2.6 延迟2 秒  end")
            }
            printlnAndTime("runBlocking  coroutineScope5.2  end")
        }


        printlnAndTime("runBlocking codes run in coroutine scope  finish")
    }

    //3. 在非协程域中 调用挂起函数 报错了
//    printDot()  报错了 挂起函数 只能在协程中调用
    printlnAndTime("main fun   finish")
}

