package com.example.kotlin._5kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("通过设置限定符，Fragment 单页和双页 根据设备大小切换")
class NewsMainActivity : AppCompatActivity() {
    var isTwoPane :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_05_news_main_activity)
         isTwoPane = findViewById<View>(R.id.newsContentLayout) != null
        println("NewsMainActivity isTwoPane = $isTwoPane")
        //sw 600
        //kotlin 1.扩展函数写法 2.运算符重载
        // 分页 判断在 NewsTitleFragment 类中 判断是否有 内容的Fragment ---- isTwoPane = activity?.findViewById(R.id.newsContentLayout) != null
    }
}