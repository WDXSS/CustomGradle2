package com.example.kotlin._4kotlin.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlin.R
import kotlinx.android.synthetic.main.kotlin_title_layout.view.*

class CustomTitleLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.kotlin_title_layout, this)

        titleBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }

        titleEdit.setOnClickListener {
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }
    }

}