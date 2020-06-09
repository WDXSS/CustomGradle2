package com.example.kotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("泛型 实例化 打开activity ")
inline fun <reified T : Any> startActivity(context: Context) {
    //设置为顶层方法
    //1.关键字 inline
    //2.关键字 reified 修饰 T
    context.startActivity(Intent(context, T::class.java))
}

@DevKotlin("泛型 实例化 打开activity , 第二个 参数为高解涵 ，通过高阶函数传值")
inline fun <reified T : Activity> startActivity(context: Context, block: () -> Intent) {
    val intent = block()
    intent.setClass(context, T::class.java)
    context.startActivity(intent)
}


