package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinDateUtil.printlnAndTime
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@DevKotlin("suspend 关键字 声明 挂起函数 ")
class KotlinSuspend {
    //1. 在非协程域中 调用挂起函数 报错了
    //2. 在 挂起函数中不能 创建子协程 即：不能调用 launch函数， 解决方法 ：coroutineScope 函数
}


fun main() {

}

suspend fun printDot() {
   printlnAndTime("suspend  挂起 函数 start")
    delay(5000)
    printlnAndTime("suspend  挂起 函数  延迟 5秒 end" )
    //调用失败，launch 函数必须再 协程的作用域中才能调用
//    launch{
//
//    }
}

suspend fun printDot2() = coroutineScope {
    printlnAndTime("suspend + coroutineScope 挂起 函数 start")
    delay(5000)
    printlnAndTime("suspend + coroutineScope 外层  延迟5秒 ")
    launch {
        printlnAndTime("suspend + coroutineScope  launch  start ")
        delay(5000)
        printlnAndTime("suspend + coroutineScope  launch  延迟 5 秒输出 end")
    }
    printlnAndTime("suspend + coroutineScope 挂起 函数 end")
}

suspend fun printDot3() {
    printlnAndTime("suspend  挂起 函数 start")
    delay(5000)
    printlnAndTime("suspend  挂起 函数  延迟 5秒 end" )

    coroutineScope{
        launch {

        }
    }
}

