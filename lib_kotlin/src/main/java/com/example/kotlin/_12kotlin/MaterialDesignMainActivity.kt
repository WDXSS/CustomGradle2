package com.example.kotlin._12kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.startActivity
import kotlinx.android.synthetic.main.kotlin_12_material_design_main_activity.*

@DevKotlin("最佳的UI体验，Material Design ")
class MaterialDesignMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_material_design_main_activity)
        Toolbar.setOnClickListener {
            starToolbar2Activity()
        }

        DrawerLayout.setOnClickListener {
            startActivity<DrawerLayoutActivity>(this)
        }
    }

    fun startToolbarActivity(view: View) {
        startActivity<ToolbarActivity>(this)
    }

    fun starToolbar2Activity(){
        startActivity<Toolbar2Activity>(this)
    }
}