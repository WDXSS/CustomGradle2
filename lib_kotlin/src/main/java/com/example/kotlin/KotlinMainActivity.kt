package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin._3kotlin.FirstActivity
import com.example.kotlin._4kotlin.CustomTitleLayoutActivity

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
}