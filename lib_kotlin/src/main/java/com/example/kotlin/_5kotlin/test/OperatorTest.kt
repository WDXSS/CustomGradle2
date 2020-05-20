package com.example.kotlin._5kotlin.test

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("运算符重载 ：关键字 operator")
class OperatorTest {
//语法糖表达式和实际调用函数对照表

//    语法糖表达式                   实际调用的函数
//      a + b                         a.plus(b)
//      a - b                         a.minus(b)
//      a * b                         a.times(b)
//      a / b                         a.div(b)
//      a % b                         a.rem(b)
//      a ++                          a.inc()
//      a --                          a.dec()
//      +a                            a.unaryPlus()
//      -a                            a.unaryMinus()
//      !a                            a.not()

//      a == b                        a.compareTo(b)
//      a > b
//      a < b
//      a >= b
//      a <= b

//      a .. b                        a.rangeTo(b)
//      a [b]                         a.get(b)
//      a [b] = c                     a.set(b,c)
//      a in b                        b.contain(a)


    //可以参考 https://blog.csdn.net/usagoole/article/details/90417101

    operator fun plus(b: Int) {
        //运算符重载

    }
}


fun main() {
    val money1 = Money(5)
    val money2 = Money(6)
    val money = money1 + money2

    println("money 对象可以相加了 = ${money.value}")
}

class Money(val value: Int) {
    operator fun plus(b: Int): Money {
        //运算符重载
        var sum = value + b
        return Money(sum)
    }

    operator fun plus(m :Money) :Money{
        //运算符重载   可以多次重载
        var sum = value + m.value
        return Money(sum)
    }
}

