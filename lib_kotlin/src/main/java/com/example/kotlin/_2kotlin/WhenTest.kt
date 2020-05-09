package com.example.kotlin._2kotlin

// 条件语句 when 相当于 java 中的 switch 语句
fun main(){
// when 语句 允许传入任意对象  格式： 匹配值-> {执行语句}
    whenTest("Lily")
}
fun whenTest(name :String){
    val result = when (name){
        "Tom"->89
        "Jim"->77
        "Lily"->60
        else->0
    }
    println("匹配的结果= $result")
}