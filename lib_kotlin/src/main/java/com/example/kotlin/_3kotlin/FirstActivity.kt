package com.example.kotlin._3kotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.printUpperCase
import kotlinx.android.synthetic.main.kotlin_first_activity.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_first_activity)

        kotlin_btn_first_activity.setOnClickListener {
            Toast.makeText(this, "Kotlin 中的第一 btn", Toast.LENGTH_LONG).show()
        }
        staticFun()//静态方法
    }

    //添加 menu 菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.first_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.first_menu_add -> Toast.makeText(this, "Kotlin menu add", Toast.LENGTH_LONG).show()
            R.id.first_menu_remove -> Toast.makeText(this, "Kotlin menu remove", Toast.LENGTH_LONG).show()
        }
        return true
    }
}