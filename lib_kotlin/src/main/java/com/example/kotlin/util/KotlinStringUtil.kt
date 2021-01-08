package com.example.kotlin.util

/**
 * @author zhouchao
 * @date 2020/6/18
 */
object KotlinStringUtil {
    fun printlnAndTime(msg: String?) {
        println(KotlinDateUtil.getTime() + ": $msg")
    }
}

fun sum(a: Int, b: Int) = a + b

//fun main() {
//    println("sum of 19 and 23 is ${sum(19, 23)}")
//}
fun main() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}