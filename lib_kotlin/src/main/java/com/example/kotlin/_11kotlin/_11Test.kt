package com.example.kotlin._11kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("使用协程编写高效的并发程序")
class _11Test {
    //官方地址：https://github.com/Kotlin/kotlinx.coroutines
    //1.添加 依赖库
    //2.创建 协程  4中方式
    // GlobalScope.launch
    // runBlocking
    // launch
    // coroutineScope
    // 区别和特点：
    // GlobalScope.launch  runBlocking  可以任意位置调用   runBlocking阻塞当前线程
    // launch 函数只能在协程的作用域中调用
    // coroutineScope 协程的作用域 和 挂起函数中调用        coroutineScope 阻塞当前协程的作用域


    //delay() 函数只能在协程或者挂起函数中调用
    //suspend 关键字 声明挂起函数
    // coroutineScope 特点 会继承外部协程的作用域，并创建一个子协程
    // coroutineScope 可以保证在 其作用域的所有代码和子协程在全部执行完成之前阻塞当前协程
    //async 函數 创建一个子协程
    // withContext 函数
}

fun main() {

}