package com.example.kotlin._08kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin.R
import com.example.kotlin._08kotlin.book.later

class _08MainActivity : AppCompatActivity() {
    val p by lazy {
        println("str  p4 中的 lambda 表达式  lazy")
        "4444444444"
    }

    val p2 by LaterTest {
        println("自定义 Later 中的 lambda 表达式  Later")
        "55555555"
    }
    val p3 by later {
        println("自定义 Later 中的 lambda 表达式  Later")
        "55555555"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_08_main_activity)
    }

    fun testLazy(view: View) {
        println(" 测试 属性 懒加载  lazy  $p")
    }

    fun testLazy2(view: View) {
        println(" 测试 属性 自定义懒加载  Later  $p2")

    }

    fun testLazy3(view: View) {
        println(" 测试 属性 书中 的 自定义懒加载  Later  $p3")
    }
}
