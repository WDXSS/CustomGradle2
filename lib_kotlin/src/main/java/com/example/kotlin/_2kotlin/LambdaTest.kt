package com.example.kotlin._2kotlin

import android.annotation.SuppressLint

@DevKotlin("函数式API")
@SuppressLint("DefaultLocale")
fun main() {
    lambdaTest()
    upperCase()
    testFilter()
    testAnyAndAll()
    testLambda()
}

fun lambdaTest() {
    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
    val lambda = { fruit: String -> fruit.length }
//    val maxlengthFruit = list.maxBy({ fruit: String -> fruit.length })
//    val maxlengthFruit = list.maxBy(){ fruit: String -> fruit.length }
//    val maxlengthFruit = list.maxBy{ fruit: String -> fruit.length }
    //最终简化成  list.maxBy{ fruit: String -> fruit.length }
    val maxlengthFruit = list.maxBy(lambda)

    println(maxlengthFruit)
    if (maxlengthFruit != null) {
        println(maxlengthFruit.length)
    }
}

fun upperCase() {
    //将小写转成大写，
    val list = listOf("apple", "banana", "orange", "pear", "grape")
    //map{lambda 表达式 }
    val newList = list.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
}

fun testFilter() {
    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
    //.filter { it.length <= 5 } 也可以单独使用
    val newList = list.filter { it.length <= 5 }
            .map { it.toUpperCase() }
    println("filter:")
    for (fruit in newList) {
        println(fruit)
    }
}

fun testAnyAndAll() {
    //any 判断是否 有至少一个满足条件的
    //all 判断所有的是否满足条件
    val list = listOf("apple", "banana", "orange", "pear", "grape", "watermelon")
    val anyResult = list.any { it.length <= 5 }
    val allResult = list.all { it.length <= 5 }

    println("anyResult = " + anyResult + ", allResult = " + allResult)
}

fun testLambda(){
    val str = {str:String->
        str +"sdss"
    }
    print(str.invoke("0000000"))
}