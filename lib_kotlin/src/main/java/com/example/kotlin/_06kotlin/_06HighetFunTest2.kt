package com.example.kotlin._06kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("高阶函数2， 内联函数")
class _06HighetFunTest2 {
    //1.添加扩展函数  _06HighetFunTest.build()

    //2.高价函数 参数 --- addNum: _06HighetFunTest.(a1: Int, b2: Int) 使lambda表达式持有 _06HighetFunTest的上下文，可以直接调用 and()函数

    //3.内联函数 定义高阶函数时加上 关键字 inline
}

//fun _06HighetFunTest.build(a: Int, b: Int, addNum: _06HighetFunTest.(a1: Int, b2: Int) -> Unit) {
fun _06HighetFunTest.build(a: Int, b: Int, addNum: _06HighetFunTest.(a1: Int) -> Unit) {
//    addNum(a, b)
    addNum(b)
    addNum(a)
    val value = and(15, 10)
    println("build  value = $value")
}

fun main() {
    val test = _06HighetFunTest()
    test.build(10, 7) { num1 ->
        val value = num1 * 1
        println("main  value = $value")
    }

    num1AndNum3(4,5){num1, num2 ->
        num1-num2
    }
}


//内联函数
inline fun num1AndNum3(num1: Int, num2: Int, operation: (num1: Int, num2: Int) -> Int) {
    //定义为内联函数
    val value = operation(num1, num2)
    println("num1AndNum3  value = $value")
}
