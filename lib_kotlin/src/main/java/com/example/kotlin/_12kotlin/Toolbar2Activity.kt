package com.example.kotlin._12kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_12_toolbar2_activity.*

@DevKotlin("学习 Toolbar")
class Toolbar2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_toolbar2_activity)
        setSupportActionBar(Toolbar)
    }

    @DevKotlin("添加菜单")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        println("onContextItemSelected")
        return super.onContextItemSelected(item)
    }

    @DevKotlin("菜单的点击 事件")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("onOptionsItemSelected")
        when (item.itemId) {
            R.id.backup -> Toast.makeText(this, "you clicked backup", Toast.LENGTH_LONG).show()
            R.id.delete -> Toast.makeText(this, "you click delete", Toast.LENGTH_LONG).show()
            R.id.settings -> Toast.makeText(this, "you click settings", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}