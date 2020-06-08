package com.example.kotlin._08kotlin

import com.example.kotlin._2kotlin.DevKotlin
import java.lang.StringBuilder

@DevKotlin("泛型和委托")
class _08Test {
    //1.泛型
    //2.委托 ：类委托 (DelegateClass.kt)和 委托属性
    //2.1 类委托：//通过类委托，不需要将接口里的方法都实现
    //2.2 委托属性：实现对该类的属性统一管理
    //委托的关键字  by
    //3.懒加载技术  by lazy ,by 和 lazy 是两独立的 ， by 是关键字 ， lazy 是高价函数


}


//泛型类和方法
class MyTest<T> {
    fun method(param: T): T {
        return param
    }
}

// 不定义泛型类，只定义泛型方法
class MyTest1 {
    //1. 泛型方法
    fun <T> method(): T? {
        var t: T? = null
        return t
    }

    fun <T> method(param: T): T {
        return param
    }

    //2. 通过指定 上界 来对泛型进行约束
    //这里的上界是 Number 所以只能传入 Int, Flout ,Double 等类型
    fun <T : Number> method3(param: T): T {
        return param
    }


}

//3.在 6.5.1 小节中 高阶函数时，编写 build 函数
fun StringBuffer.build(block: StringBuffer.() -> Unit): StringBuffer {
    block()
    return this
}

//3.2 通过泛型 改造 build ，可以像 kotlin标准函数 一样使用
fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //这里是 StringBuffer
    val result = StringBuffer().build {
        for (str in list) {
            append(str).append("\n")
        }
    }
    println("编写高阶build 函数 \n" +result.toString())

    //这里是 StringBuilder
    val result2 = StringBuilder().build {
        for (str in list) {
            append(str).append("\n")
        }
    }
    println("模仿 kotlin中 标准函数 ：\n"+result.toString())


}