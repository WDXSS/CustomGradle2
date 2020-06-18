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