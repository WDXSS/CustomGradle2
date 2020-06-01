package com.example.kotlin._06kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("高阶函数2， 内联函数")
class _06HighetFunTest2 {
    //1.添加扩展函数  _06HighetFunTest.build()

    //2.高价函数 参数 --- addNum: _06HighetFunTest.(a1: Int, b2: Int) 使lambda表达式持有 _06HighetFunTest的上下文，可以直接调用 and()函数

    //3.内联函数 定义高阶函数时加上 关键字 inline
    //4.关键字：noinline  取消内联
    //5.关键字 crossinline 保证内联函数的 lambda 表达式不使用 return
    //  原因：内联函数的lambda 表达式中可以是用 return，  而高价函数的匿名类实现中不允许使用 return
    //       而 crossinline 关键字就像一个契约，用于保证内联函数的 lambda 表达式中一定不会使用 return

    //6. 内联函数中可以使用 return 全局返回 和 return@局部返回 ， 非内联函数 不能使用return 全局返回，可以使用局部返回
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

    num1AndNum3(4, 5) { num1, num2 ->
        num1 - num2
    }
    //取消 内联
//    inlineTest(::inlineBlock1, ::inlineBlock2)
//    inlineTest2(::inlineBlock1, ::inlineBlock2)

    //关键字 crossinline
    inlineTest2(block1 = {
        println("  block1 return before  测试关键字 crossinline 保证 内联函数的 lambda 表达式 中不能用有return  但是可以是使用 局部返回 return@ ")
//        return
        return@inlineTest2
        println("  block1 return after")
    }, block2 = {
        println("  block2 return before")
        println("  block2 return before  非内联（noinline） 函数中 不可以是用 return , 但是可以是使用 局部返回 return@ ")
        return@inlineTest2
        println("  block2 return after   第二个 内联函数 lambda 表达式")
    },block3 = {
        println("  block3 return before")
        println("  block3 return before  内联函数中可以是 return , 也可使用 局部返回 return@  ")
//        return
        return@inlineTest2
        println("  block3 return after  第3个 内联函数 lambda 表达式")
    })
}


//内联函数
inline fun num1AndNum3(num1: Int, num2: Int, operation: (num1: Int, num2: Int) -> Int) {
    //定义为内联函数
    val value = operation(num1, num2)
    println("num1AndNum3  value = $value")
}

//函数类型参数，取消内联  noinline
inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {
    //使用inline 关键字声明的函数 inlineTest() 原本 block1 和 block2 这两个函数类型的参数，在使用 lambda 表达式时都将会内联，
    //但是 将block2 添加关键在 noinline ,block2 将不会被内联
    block1()
    block2()
}

fun inlineBlock1() {
    println("  函数 参数 方法 inlineBlock1  return before")
    return
    println("  函数 参数 方法inlineBlock1  return after")
}

fun inlineBlock2() {
    println("  函数 参数 方法  inlineBlock2")
}

//关键字 crossinline
inline fun inlineTest2(crossinline block1: () -> Unit,  noinline block2: () -> Unit, block3: () -> Unit) {
    println("  inlineTest2  block1 函数 调用 begin")
    block1()
    println("  inlineTest2  block1 函数 调用 end")
    println()

    println("  inlineTest2  block2 函数 调用 begin")
    block2()
    println("  inlineTest2  block2 函数 调用 end")
    println()

    println("  inlineTest2  block3 函数 调用 begin")
    block3()
    println("  inlineTest2  block3 函数 调用 end")
}

