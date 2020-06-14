package com.example.kotlin._11kotlin.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin._2kotlin.DevKotlin
import kotlinx.android.synthetic.main.kotlin_11_retorfit_main2.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.*
import kotlinx.android.synthetic.main.kotlin_http_url_connection_activity.ResponseText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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
                if(list != null){
                    str.append("没有使用泛型 ： ")
                    for (app in list){
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
        val service = ServiceCreator.create<AppService>()
        service.getAppDate().enqueue(object : Callback<List<AppData>> {
            override fun onFailure(call: Call<List<AppData>>, t: Throwable) {
                Log.v(TAG, " Retrofit  onFailure ${t.toString()}")
            }
            override fun onResponse(call: Call<List<AppData>>, response: Response<List<AppData>>) {
                Log.v(TAG, " Retrofit  onResponse")
                val list = response.body()
                if(list != null){
                    str.append("使用泛型 ： ")
                    for (app in list){
                        str.append(" app is id = ${app.id} ")
                        str.append(" app is name = ${app.name} ")
                        str.append(" app is version = ${app.version} ")
                    }
                }
                ResponseText.text = str.toString()
            }
        })
    }

}