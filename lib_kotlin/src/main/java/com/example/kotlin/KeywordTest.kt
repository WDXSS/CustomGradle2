package com.example.kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("关键字总结")
class KeywordTest {

    //1. 内联函数 ： inline                   参考：_06HighetFunTest2
    //2. 取消内联 ： noinline
    //3. 标记内联 crossinline   标记内联函数中的 lambda 表达式中 不使用 return  （lambda 表达式代替匿名类 时 中不可以使用 return）
    //4. return@  表示局部返回
    //5. 委托 ： by

    //6. reified 关键子 ，修饰 泛型 T 泛型实化 配合内联函数使用简化 startActivity
    //7. const 定义为 常量的关键字 ，const 关键字 只能用在 单利类 顶层方法，companion object 伴生类
}