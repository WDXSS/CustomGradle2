package com.example.kotlin._5kotlin.test

import com.example.kotlin._2kotlin.DevKotlin


@DevKotlin("扩展函数和")
fun main(){
    val classNameTest = ClassNameTest()
    classNameTest.methodName()
}


@DevKotlin("扩展函数写法 className.方法")
fun ClassNameTest.methodName(){
    // 相比定义一个普通的函数，扩展函数只需要在函数名的前面添加上 类名. 语法结构 ，就是表示将该函数添加到指定的类中
    println("ClassNameTest 类中 添加 扩展函数")

}

