package com.example.kotlin._09kotlin

import com.example.kotlin._2kotlin.DevKotlin


//注意方法 重名
@DevKotlin("使用 infix 函数构建更可读的语法")
infix fun String.beginWith2(prefix: String) = startsWith(prefix)

infix fun <T> Collection<T>.has(element: T) = contains(element)

@DevKotlin("模仿 to() 函数 构建自己的键值对 ，返回 pair 对象，to() 也是 返回的 Pair 对象")
infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)