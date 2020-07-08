package com.example.kotlin._2kotlin

fun main() {
    //参考 ：https://www.kotlincn.net/docs/reference/data-classes.html

    //1.    在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。 （参见构造函数）。
    //    data class User(val name: String = "", val age: Int = 0)

    //2. 在类体中声明的属性
    //    data class Person(val name: String) {
    //        var age: Int = 0
    //    }
}