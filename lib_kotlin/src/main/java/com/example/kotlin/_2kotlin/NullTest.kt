package com.example.kotlin

fun main() {
    // null 相关的操作符
    // ? 可以为空
    // ?.  不为空时调用相应方法
    // ?:   不为空时返回左边表达式结果，为空时返回右边表达式结果
    // !!   非空断言工具
    // let  是kotlin 标准函数； 会将 原始对象作为参数传递到 lambda 表达式中
    printUpperCase()

    val study = Study()
    testLet(study)//let 函数 配合 ?. 使用

    //字符串 内嵌表达式 当 {} 大括号中只有一变量时，{}可以省略
    val brand ="sam sung"
    val price = 1299.99
    println("brand = ${brand} , price = $price")
}

fun enableNull(s: String?) {
//    ? 可以为空

    //?.  不为空时调用相应方法
    s?.length

}

fun disableNull(s: String?) {
    // ?:   不为空时返回左边表达式结果，为空时返回右边表达式结果
    val length = s ?: ""
    //效果同上
    val str = if (s != null) {
        s
    } else {
        ""
    }
}

var content: String? = "hello"
fun printUpperCase() {
    //!!   非空断言工具  强制不判空
    val upperCase = content!!.toUpperCase()
    println(upperCase)
}

var mStudy :Study? = Study()
fun testLet(study: Study?){
    study?.doHomeWork()
    study?.readBook()

    //效果同上 ?. ;  let 函数配合 ?. 使用 减少对 study 为空的判断，
    //study 和 stu 是同一个对象，为了防止变量重命名，改为stu
    study?.let { stu ->
        stu.doHomeWork()
        stu.readBook()
    }
    //---------------------------------------------------
    // if 不能对全局变量进行判空，而let 可以
    // 原因：全局变量可能被其他线程访问，并且置为null
    if(mStudy != null){
//        mStudy.readBook() //编译不通过
//        mStudy.doHomeWork() //编译不通过
    }

    mStudy?.let { mStu ->
        mStu.readBook()
        mStu.doHomeWork()
    }
}


class Study{
    fun readBook(){
        println("readBook")
    }
    fun doHomeWork(){
        println("doHomeWork")
    }
}

