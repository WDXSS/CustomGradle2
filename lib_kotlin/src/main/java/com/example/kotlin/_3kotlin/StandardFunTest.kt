package com.example.kotlin._3kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("Kotlin 的标准函数")
class StandardFunTest {
    // let 函数：配合 ?. 使用
    // with 函数： with函数接收两个参数：第一个可以任意类型的对象，第二个参数 是 lambda表达式; lambda 表达式中的上下文是 第一个参数；lambda 表达式的最后一条语句作为返回值返回
    // run  函数： run 函数接收一个参数：参数是 lambda ; run 函数需要 对象进行调用，lambda表达式中的上下文是调用对象; lambda 表达式的最后一条语句作为返回值返回
    // apply 函数：apply 和 run 相似； 区别：apply 返回的是 调用者对象 ，run 是将 lambda 表达式最后一条语句作为返回值返回
    // repeat 函数： 传入 一个数值 n ，然后会将lambda 表达式的内容执行 n 次

}

fun main() {
    println("kotlin 标准函数之 with 函数")
    withTest()
    println("kotlin 标准函数之 run 函数")
    runTest()
    println("kotlin 标准函数之 apply 函数")
    applyTest()
    println("kotlin 标准函数之 repeat 函数")
    repeatTest()
}

fun letTest(study: Study?) {
    //?. 表达式表示，stu 不为空是执行 let 函数
    study?.let { stu ->
        stu.readBook()
        stu.doHomeWork()
    }
}

fun withTest() {

    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
//    //未使用 with 函数 写法
//    val stringBuffer = StringBuffer()
//    stringBuffer.append("Start eating fruits \n")
//    for (str in list) {
//        stringBuffer.append(str + "\n")
//    }
//    stringBuffer.append("ate all fruits.")
//    println(stringBuffer.toString())


//    with函数接收两个参数：第一个可以任意类型的对象，第二个参数 是 lambda表达式;
//    lambda 表达式中的上下文是 第一个参数；lambda 表达式的最后一条语句作为返回值返回
    val strBuffer = StringBuffer()

    val strResult = with(strBuffer) {
        append("Start eating fruits \n")
        for (str in list) {
            append(str + "\n")

        }
        append("ate all fruits.")
        toString()
    }
    println(strResult)
}

fun runTest() {
    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
    val strBuffer = StringBuffer()
    val strResult = strBuffer.run {
        append("Start eating fruits \n")
        for (str in list) {
            append(str + "\n")
        }
        append("ate all fruits.")
        toString()
    }
    println(strResult)
}

fun applyTest() {
    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
    val strBuffer = StringBuffer()
    val strResultBuffer = strBuffer.apply {
        append("Start eating fruits \n")
        for (str in list) {
            append(str + "\n")
        }
        append("ate all fruits.")

    }
    println(strResultBuffer.toString())
}

fun repeatTest(){
    repeat(3){
        println("repeat 函数：传入 一个数值 n ，然后会将lambda 表达式的内容执行 n 次")
    }
}

class Study {
    fun readBook() {
        println("readBook")
    }

    fun doHomeWork() {
        println("doHomeWork")
    }
}