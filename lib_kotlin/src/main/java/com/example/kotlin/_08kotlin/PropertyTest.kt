package com.example.kotlin._08kotlin

import com.example.kotlin._2kotlin.DevKotlin
import kotlin.reflect.KProperty

@DevKotlin("委托属性")
class PropertyTest {
    // 1.属性委托 指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。

    //    val/var <属性名>: <类型> by <表达式>
//    var/val：属性类型(可变/只读)
    var p by Delegate()

}

@DevKotlin("委托 属性，必须实行 getValue 或者 setValue 方法")
class Delegate {
    var property: Any? = null
    operator fun getValue(propertyTest: PropertyTest, property: KProperty<*>): Any {
        // 第一个参数：声明 委托功能在可以在那些类中使用
        // 第二个参数：KProperty 是kotlin中的一个属性操作类；<*> 是泛型的一种写法，表示不关心类型
        return property
    }

    operator fun setValue(propertyTest: PropertyTest, property: KProperty<*>, any: Any) {
        //第三个参数，表示委托属性的类型，必须和 getValue() 返回值一样
    }
}

@DevKotlin("模仿 kotlin 中的 lazy 函数  这里定义成了 类 ")
class LaterTest<T>(val block: () -> T) {
    var value : T? = null
    operator fun getValue(any: Any?, property: KProperty<*>): T? {
        println("getValue")
//        if(block() == null){
        if(value == null){
            //这里的判断 条件 是 value == null
            value = block()
        }
        return value
    }
    operator fun setValue(any: Any?, property: KProperty<*>, t: T) {
        //第三个参数，表示委托属性的类型，必须和 getValue() 返回值一样
        println("setValue")
    }
}
@DevKotlin("模仿 kotlin 中的 lazy 函数  这里定义一个顶层方法 ")
fun <T>laterMethod( block: () -> T) = LaterTest(block)

fun main() {
    println("模仿 kotlin 中的 lazy 函数")
    val p2 by LaterTest<String> {
        println("str  p2 中的 lambda 表达式  laterMethod")
        var str = StringBuffer()
        str.append("22222222")
        str.toString()
    }

    println("str  p2 = $p2")

    //var 编译不通过
    val p3 by laterMethod {
        println("str  p3 中的 lambda 表达式  laterMethod")
        var str = StringBuffer()
        str.append("33333333")
        str.toString()
    }
    println("str  p3 = $p3")
    println("第二次调用  p3 = $p3")


    // kotlin 中的 lazy 懒加载  当第一次掉用时初始化，
    val p4 by lazy {
        println("str  p4 中的 lambda 表达式  lazy")
        "4444444444"
    }
    println("str  p3 = $p4")
    println("第二次调用  p4 = $p4")
}


