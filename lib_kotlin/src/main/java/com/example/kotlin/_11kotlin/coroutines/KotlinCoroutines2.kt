package com.example.kotlin._11kotlin.coroutines

import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.util.KotlinDateUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DevKotlin("协程 的补充")
fun main() {
    println("star  main   ")
   val job =  GlobalScope.launch {
        KotlinDateUtil.printlnAndTime("GlobalScope codes run in coroutine scope")

       val job2 = launch {
           KotlinDateUtil.printlnAndTime("GlobalScope.launch 和 launch 都会返回一个 Job 对象，" +
                   "调用 job 的 cancel() 取消 协程")
       }
    }
//job.cancel()
//job.start()
    Thread.sleep(1000)//需要将线程 否则 GlobalScope.launch 执行不了

}

