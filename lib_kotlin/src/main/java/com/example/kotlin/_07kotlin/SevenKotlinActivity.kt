package com.example.kotlin._07kotlin
import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import android.util.Log
import androidx.core.content.edit
import com.example.kotlin.R
import kotlinx.android.synthetic.main.kotlin_07_shareprefrence.*


class SevenKotlinActivity : AppCompatActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_07_shareprefrence)

        saveButton.setOnClickListener {
//            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
//                putString("name", "Tom")
//                putInt("age", 28)
//                putBoolean("married", false)
//            }
            getSharedPreferences("data",Context.MODE_PRIVATE).edit {

            }
        }
        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("MainActivity", "name is $name")
            Log.d("MainActivity", "age is $age")
            Log.d("MainActivity", "married is $married")
        }
    }

}