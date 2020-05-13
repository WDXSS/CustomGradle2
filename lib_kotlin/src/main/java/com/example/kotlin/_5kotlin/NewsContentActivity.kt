package com.example.kotlin._5kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_05_news_content_activity.*
import java.security.AccessControlContext


class NewsContentActivity : AppCompatActivity() {
    companion object {
        //使用伴生类 ，模拟 静态方法
        fun startActivity(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("content", content)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_05_news_content_activity)
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        if (title != null && content != null) {
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title, content)
        }
    }
}
