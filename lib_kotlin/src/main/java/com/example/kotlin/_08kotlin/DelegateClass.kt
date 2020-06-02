package com.example.kotlin._08kotlin

import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("类委托")
class DelegateClass {
    //类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的

    //定义 一个接口 base  , 实现 类 BaseImpl
    //定义 委托 类 Derived  传入 base 实例， 通过 by 关键字 实现 类委托
}

interface Base {
    fun testPrint()
    fun testPrint2(int: Int)
    fun testPrint3()
}

class BaseImpl : Base {
    override fun testPrint() {
        println("Not yet implemented  testPrint")
    }

    override fun testPrint2(int: Int) {
        println("Not yet implemented  testPrint2 $int")
    }

    override fun testPrint3() {
        println("Not yet implemented  testPrint3")
    }

}

@DevKotlin("传入 base 实例， 通过 by 关键字 实现 类委托")
class Derived(private val base: Base) : Base by base {
    //通过类委托，不许要将接口里的方法都实现
    fun helloWorld() {
        println("世界 你好！！")
    }

    //    override fun testPrint() =   base.testPrint()
    override fun testPrint() {
        base.testPrint()
        helloWorld()
    }
}

fun main() {
    val BaseImpl = BaseImpl()
    val derived = Derived(BaseImpl)
//    derived.helloWorld()
    derived.testPrint()
    derived.testPrint2(10)

}