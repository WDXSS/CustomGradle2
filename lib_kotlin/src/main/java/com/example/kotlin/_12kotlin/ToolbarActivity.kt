package com.example.kotlin._12kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_12_toolbar_activity.*

@DevKotlin("最佳的UI体验，Material Design -- Toolbar ")
class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_toolbar_activity)

        TextContent.text = "activity 单独设置 actionBar 的主题颜色， 修改 标题， 下一步使用 Toolbar 替换actionBar"
    }

}