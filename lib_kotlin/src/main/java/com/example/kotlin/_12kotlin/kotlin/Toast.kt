package com.example.kotlin._12kotlin.kotlin

import android.content.Context
import android.widget.Toast

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    //在参数中 使用 默认值的写法，两个入参变一个入参
    Toast.makeText(context, this, duration).show()
}