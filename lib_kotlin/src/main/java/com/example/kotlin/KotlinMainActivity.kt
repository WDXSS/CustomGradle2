package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin._3kotlin.FirstActivity
import com.example.kotlin._4kotlin.ChatActivity
import com.example.kotlin._4kotlin.CustomTitleLayoutActivity
import com.example.kotlin._4kotlin.ListViewActivity
import com.example.kotlin._4kotlin.RecyclerViewFruitActivity
import com.example.kotlin._5kotlin.NewsMainActivity

class KotlinMainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_main_activity)
        supportActionBar?.hide()//隐藏title
    }

    fun startFirstActivity(view: View) {
        startActivity(Intent(this, FirstActivity::class.java))
    }

    fun startCustomTitleActivity(view: View) {
        startActivity(Intent(this, CustomTitleLayoutActivity::class.java))
    }

    fun startListViewActivity(view: View) {
        startActivity(Intent(this, ListViewActivity::class.java))
    }

    fun startRecyclerActivity(view: View) {
        startActivity(Intent(this, RecyclerViewFruitActivity::class.java))
    }

    fun startChatActivity(view: View) {
        startActivity(Intent(this, ChatActivity::class.java))
    }

    fun startNewsMainActivity(view: View) {
        startActivity(Intent(this, NewsMainActivity::class.java))
    }
}