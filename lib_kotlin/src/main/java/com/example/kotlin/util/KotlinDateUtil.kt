package com.example.kotlin.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author zhouchao
 * @date 2020/6/18
 */
object KotlinDateUtil {

    @SuppressLint("SimpleDateFormat")
    fun getTime(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
    }

    fun printlnAndTime(msg: String?) {
        println(getTime() + ": $msg")
    }
}