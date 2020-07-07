package com.example.kotlin._12kotlin.kotlin

import com.example.kotlin._2kotlin.DevKotlin
import kotlin.math.max


@DevKotlin("编写好用的工具方法")
fun main() {
    //1. 求N个数的最大数和最小数
    testIn()
    maxTest(2, 5)
    maxTest2(2, 4, 2, 7, 34, 63, 9)
    maxTest3(2, 4, 2, 7, 34, 63, 9)
     maxTest3(2.2, 4.4, 23.0, 7.4, 3.4, 6.3, 9.0)
//    maxTest3()
}

fun testIn() {
    for (i in 0..10) {
        //输出 0 到 10  包含 0和10
        println("i = $i")
    }
}

fun maxTest(num1: Int, num2: Int) {
    //借助 kotlin 的 内置函数 max()
    val larger = max(num1, num2)
    println("larger = $larger")
}

fun maxTest2(vararg nums: Int) {
    //使用 vararg 关键字，动态个数
    //优化点： larger 赋值 int 的最小值,
    //缺点：只能比较 int 类型
    var larger = 0
//    var larger2 = Int.MIN_VALUE
    for (num in nums) {
        larger = max(num, larger)
    }
    println("larger = $larger")
}

@DevKotlin("java ,kotlin 中 规定 所有类型的数字都是可以比较 的，必须实现 Comparable 接口" +
        "通过 泛型 的方式优化 方法 ")
fun <T : Comparable<T>> maxTest3(vararg nums: T): T {
    if (nums.isEmpty()) {
        //当参数为空时 抛出异常
        throw RuntimeException("Param can not be empty")
    }
    var larger = nums[0]
    for (num in nums) {
        if (num > larger) {
            larger = num
        }
    }
    println("larger = $larger")
    return larger
}