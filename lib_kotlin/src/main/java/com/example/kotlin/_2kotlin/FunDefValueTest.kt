package com.example.kotlin._2kotlin
//函数默认值设置

fun main() {
    //num 和 name 重新赋值
    println("num 和 name 重新赋值")
    printParams(123, "hello world")
    //使用 name 的默认值
    println("使用 name 的默认值")
    printParams(123)

    println("num 和 name 重新赋值")
    printParams2(num = 456, name = "name 重新赋值")
    println("使用 num 的默认值,name 重新赋值")
    printParams2(name = "name 重新赋值")
}


fun printParams(num: Int, name: String = "hello") {
    println("num = $num , name = $name")
}

fun printParams2(num: Int = 999, name: String = "hello") {
    println("num = $num , name = $name")
}
