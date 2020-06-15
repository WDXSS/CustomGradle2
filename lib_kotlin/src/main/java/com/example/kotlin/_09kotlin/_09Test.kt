package com.example.kotlin._09kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("使用 infix 函数构建更可读的语法")
class _09Test {
    //关键字 infix  用 infix 修饰的函数，就是 infix 函数
    fun test1() {
        //例如：String 类中有一个 startWith() 函数
        if ("Hello Kotlin".startsWith("Hello")) {
        }
    }

    //借助于 infix 关键字，修饰 函数, String 添加扩展函数
    //注意
    //1. infix函数 必须是定义成 某个类的成员函数，：如 String 的扩展方法
    //2. infix函数 必须接受一个 入参，参数类型可以随意
    infix fun String.beginWith(prefix: String) = startsWith(prefix)
}

//借助于 infix 关键字，修饰 函数, String 添加扩展函数    (可以將函數，放在 一個 kt 文件中，如：Infix.kt)
infix fun String.beginWith(prefix: String) = startsWith(prefix)

fun main() {
    val b = "Kotlin".beginWith("hello")
    val b2 = "Kotlin".beginWith2("hello")

    //去掉 点 和括号
    val b3 = "Kotlin"  beginWith "hello"
    // beginWith2 函数 是 Infix.kt 中的方法
    val b4 = "Kotlin"  beginWith2 "hello"

    //模仿 to() 函数 构建自己的键值对
    val map = mapOf("AAA" to "aaa", "BBB" to "bbb", "CCC" to "ccc")
    val map2 = mapOf("AAA2" with  "aaa2", "BBB2" with "bbb2", "CCC2" with "ccc2")

    println("map1 = $map")
    println("map2 = $map2")


}