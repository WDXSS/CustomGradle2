package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin._08kotlin._08MainActivity
import com.example.kotlin._09kotlin.NotificationMainActivity
import com.example.kotlin._11kotlin.HttpUrlConnectionActivity
import com.example.kotlin._11kotlin.OkHttpActivity
import com.example.kotlin._11kotlin.retrofit.Retrofit2Activity
import com.example.kotlin._11kotlin.retrofit.RetrofitMainActivity
import com.example.kotlin._12kotlin.MaterialDesignMainActivity
import com.example.kotlin._13kotlin.JetpackMainActivity
import com.example.kotlin._3kotlin.FirstActivity
import com.example.kotlin._4kotlin.ChatActivity
import com.example.kotlin._4kotlin.CustomTitleLayoutActivity
import com.example.kotlin._4kotlin.ListViewActivity
import com.example.kotlin._4kotlin.RecyclerViewFruitActivity
import com.example.kotlin._5kotlin.NewsMainActivity

class KotlinMainActivity : AppCompatActivity() {
    val TAG = "KotlinMainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_main_activity)
        supportActionBar?.hide()//隐藏 activeBar
        Log.d(TAG, "onCreate  KotlinMainActivity")
    }

    fun startFirstActivity(view: View) {
        Log.d(TAG, "onCreate  startFirstActivity")
        startActivity(Intent(this, FirstActivity::class.java))
    }

    fun startCustomTitleActivity(view: View) {
        Log.d(TAG, "onCreate  startCustomTitleActivity")
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

    fun start08MainActivity(view: View) {
        startActivity(Intent(this, _08MainActivity::class.java))
    }

    fun startNotificationMainActivity(view: View) {
//        startActivity(Intent(this, NotificationMainActivity::class.java))
//        startActivity<NotificationMainActivity>(this)
        startActivity<NotificationMainActivity>(this){
            val intent = Intent()
            intent.putExtra("ActivityName","NotificationMainActivity")
            intent
        }
    }

    fun startUrlConnection(view: View) {
        startActivity<HttpUrlConnectionActivity>(this)
    }

    fun startOkHttp(view: View) {
        startActivity<OkHttpActivity>(this)
    }

    fun startRetrofit(view: View) {
        startActivity<RetrofitMainActivity>(this)
    }

    fun startRetrofitBest(view: View) {
        startActivity<Retrofit2Activity>(this)
    }

    fun startMaterialDesign(view: View) {
        startActivity<MaterialDesignMainActivity>(this)
    }

    fun startJetpackMain(view: View) {
        startActivity<JetpackMainActivity>(this)
    }
}