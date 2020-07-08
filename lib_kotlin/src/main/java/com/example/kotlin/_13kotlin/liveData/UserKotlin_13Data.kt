package com.example.kotlin._13kotlin.liveData


data class UserKotlin_13Data(val firstName: String, val age: Int) {
    var lastName: String
        get() {
            return lastName
        }
        set(value) {
            this.lastName = value
        }

    var address: String
        get() {
            return address
        }
        set(value) {
            this.address = value
        }

    //参考 ：https://www.kotlincn.net/docs/reference/data-classes.html

    //    编译器自动从主构造函数中声明的所有属性导出以下成员
    constructor() : this("周", 1)

    //1.    在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。 （参见构造函数）。
    //    data class User(val name: String = "", val age: Int = 0)

    //2. 在类体中声明的属性

}