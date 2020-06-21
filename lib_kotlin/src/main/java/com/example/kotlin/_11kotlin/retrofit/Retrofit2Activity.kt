package com.example.kotlin._11kotlin.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._11kotlin.coroutines.KotlinAwait
import com.example.kotlin._11kotlin.coroutines.request
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_11_retorfit_main2.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.ResponseText
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

@DevKotlin("Retrofit 的最佳写法")
class Retrofit2Activity : AppCompatActivity() {

    val TAG = "OkHttpActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_11_retorfit_main2)


//        val service1 = ServiceCreator.create<AppService>()
//        val service2 = ServiceCreator.create(AppService::class.java)

        OkHttpRequest.setOnClickListener {
            senRequestWithRetrofit()
        }
        RetrofitRequest.setOnClickListener {
            senRequestWithRetrofit2()
        }
        SuspendCoroutine.setOnClickListener {
            senRequestWithRetrofit3()
        }

    }

    private fun senRequestWithRetrofit() {
        var str = StringBuilder()
        ResponseText.text = ""
        val service = ServiceCreator.create(AppService::class.java)
        service.getAppDate().enqueue(object : Callback<List<AppData>> {
            override fun onFailure(call: Call<List<AppData>>, t: Throwable) {
                ResponseText.text = " Retrofit  onFailure ${t.toString()}"
            }

            override fun onResponse(call: Call<List<AppData>>, response: Response<List<AppData>>) {
                Log.v(TAG, " Retrofit  onResponse")
                val list = response.body()
                if (list != null) {
                    str.append("没有使用泛型 ： ")
                    for (app in list) {
                        str.append(" app is id = ${app.id} ")
                        str.append(" app is name = ${app.name} ")
                        str.append(" app is version = ${app.version} ")
                    }
                }
                ResponseText.text = str.toString()
            }

        })

    }

    private fun senRequestWithRetrofit2() {
        var str = StringBuilder()
        ResponseText.text = ""
        val service = ServiceCreator.createT<AppService>()
        service.getAppDate().enqueue(object : Callback<List<AppData>> {
            override fun onFailure(call: Call<List<AppData>>, t: Throwable) {
                Log.v(TAG, " Retrofit  onFailure ${t.toString()}")
            }

            override fun onResponse(call: Call<List<AppData>>, response: Response<List<AppData>>) {
                Log.v(TAG, " Retrofit  onResponse")
                val list = response.body()
                if (list != null) {
                    str.append("使用泛型 ： ")
                    for (app in list) {
                        str.append(" app is id = ${app.id} ")
                        str.append(" app is name = ${app.name} ")
                        str.append(" app is version = ${app.version} ")
                    }
                }
//                ResponseText.text = str.toString()
            }
        })
    }

    fun senRequestWithRetrofit3() {
        var str = StringBuilder()
        ResponseText.text = ""
        val job = Job()
        val scope = CoroutineScope(job)

        Log.v(TAG, "launch之前  请求之前的  Thread name =  " + Thread.currentThread().name)
        scope.launch {
//            val result2 = withContext(Dispatchers.Default) {
            //居然是非 main 线程
            Log.v(TAG, "launch  请求之前的  Thread name =  " + Thread.currentThread().name)
            val list = ServiceCreator.createT<AppService>().getAppDate().KotlinAwait()
            str.append("没有使用泛型 ： ")
            for (app in list) {
                str.append(" app is id = ${app.id} ")
                str.append(" app is name = ${app.name} ")
                str.append(" app is version = ${app.version} ")
            }
//            }
            Log.v(TAG, "launch  请求之后的  Thread name =  " + Thread.currentThread().name)
            Log.v(TAG, " Retrofit  onResponse ${str.toString()}")
            runOnUiThread {
                ResponseText.text = str.toString()
            }

        }

    }
}