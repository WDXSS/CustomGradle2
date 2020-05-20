package com.example.kotlin._06kotlin

import android.service.autofill.Validators.and
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("高阶函数：")
class _06HighetFunTest {

    //1.高阶函数
    //2.   ::add 是一种函数引用的写法，表示将and()函数作为参数值传递给num1AndNum2()函数

    //普通函数
    fun commonFun(int: Int) {
    }

    //高阶函数
    fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int) {
        val value = operation(num1, num2)
        println("value = $value")
    }
}


fun main() {
    val num1: Int = 100
    val num2: Int = 80
    val test = _06HighetFunTest()
    //::add 是一种函数引用的写法，表示将and()函数作为参数值传递给num1AndNum2()函数
    test.num1AndNum2(num1, num2, ::and)

    //简化: 对上面的简化 lambda 表达式作为最后一个参数时可以写在外面
    test.num1AndNum2(num1, num2) { num1, num2 ->
        num1 + num2
    }
}

fun and(num1: Int, num2: Int): Int {
    return num1 + num2
}