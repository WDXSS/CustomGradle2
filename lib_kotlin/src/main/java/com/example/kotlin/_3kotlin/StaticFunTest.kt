package com.example.kotlin._3kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("定义 静态方法 ")
class StaticFunTest {
    //Kotlin 很难实现 静态方法，但是提供了 两种方式和静态方法功能相似
    //1. 单利类  使用 object 关键字修饰
    //2. 伴生类  使用 companion object 关键修饰  伴生类
    //单利类 和 伴生类 都不是真正的 静态方法

    //kotlin 提供了两种真正的静态方法 ：
    //1. 注解：@JvmStatic     注意：@JvmStatic 只能添加到 单利类或者伴生类 的方法上，普通方法不能使用
    //2. 顶层方法          顶层方法值得是没有定义在任何类中的方法 如： staticFun()
}

fun main() {
    Util.doSomething3()
    Utils.doSomething2()

}

object Util {
    //单利模式
    fun doSomething3() {
    }
    @JvmStatic  //Kotlin 实现真正静态方法
    fun doSomething4() {
    }
}

class Utils {
//    @JvmStatic 普通方法不能使用 @JvmStatic
    fun doSomething() {
    }

    companion object {
        //        伴生类
        fun doSomething2() {
        }
        @JvmStatic
        fun doSomething5() {
        }
    }
}

fun staticFun(){
    //Kotlin 的静态方法
    //顶层方法 没有定义在任何类中的方法
}