package com.example.kotlin._12kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin.startActivity

@DevKotlin("最佳的UI体验，Material Design ")
class MaterialDesignMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_12_material_design_main_activity)
    }

    fun startToolbarActivity(view: View) {
        startActivity<ToolbarActivity>(this)
    }
}