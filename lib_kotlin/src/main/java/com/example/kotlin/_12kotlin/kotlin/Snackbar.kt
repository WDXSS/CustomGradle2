package com.example.kotlin._12kotlin.kotlin

import android.view.View
import com.example.kotlin._2kotlin.DevKotlin
import com.google.android.material.snackbar.Snackbar

@DevKotlin("没有 setAction ")
fun View.showSnackBar(msg: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, duration).show()
}

@DevKotlin("通过 高阶函数 的方式 回调到 setAction 的点击事件 ")
fun View.showSnackBar2(msg: String, actionText: String? = null,
                      duration: Int = Snackbar.LENGTH_SHORT, block: () -> Unit) {
    Snackbar.make(this, msg, duration).setAction(actionText) {
        block()
    }.show()
}

@DevKotlin("在 showSnackbar2 基础上在改一版，" +
        "你妈妈的，惊艳到我了， block() 也也设置 默认值了 ")
fun View.showSnackBar3(msg: String, actionText: String? = null,
                       duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null) {
    val snackBar = Snackbar.make(this, msg, duration)
    if (actionText != null && block != null) {
        snackBar.setAction(actionText) {
            block()
        }
    }
    snackBar.show()
}
//id 的写法
fun View.showSnackBarInt(msgId: Int, actionTextId: Int? = null,
                       duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null) {
    // Unit类型是一个object对象类型
    val snackBar = Snackbar.make(this, msgId, duration)
    if (actionTextId != null && block != null) {
        snackBar.setAction(actionTextId) {
            block()
        }
    }
    snackBar.show()
}


