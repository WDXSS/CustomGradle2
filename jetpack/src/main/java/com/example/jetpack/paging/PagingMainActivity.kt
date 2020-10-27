package com.example.jetpack.paging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpack.R
import com.example.jetpack.startActivity
import kotlinx.android.synthetic.main.jetpack_paging_main_activity.*

class PagingMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jetpack_paging_main_activity)

        mBtnBasicUsage.setOnClickListener {
//            startActivity(Intent(this, BasicUsageActivity::class.java))
            startActivity<BasicUsageActivity>(this)
        }
        mBtnHeaderMultiType.setOnClickListener {

        }
    }
}