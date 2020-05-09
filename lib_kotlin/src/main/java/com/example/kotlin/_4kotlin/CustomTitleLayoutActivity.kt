package com.example.kotlin._4kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin

@DevKotlin("自定title 继承自 linearlayout")
class CustomTitleLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_custom_title_layout_activity)
        supportActionBar?.hide()//隐藏title
    }
}
