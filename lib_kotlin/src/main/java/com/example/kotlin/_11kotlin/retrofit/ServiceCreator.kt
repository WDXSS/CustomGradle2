package com.example.kotlin._11kotlin.retrofit

import com.example.kotlin._2kotlin.DevKotlin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@DevKotlin("Retrofit 的最佳写法")
object ServiceCreator {
    //Android中，默认将我们本地电脑的地址映射为10.0.2.2，
    // 因此，只需要将原先的localhost或者127.0.0.1换成10.0.2.2，就可以在模拟器上访问本地计算机上的Web资源了。
//    常量的关键字 ，const 关键字 只能用在 单利类 顶层方法，companion object 伴生类
    private const val baseUrl = "http://10.0.2.2/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> create(service: Class<T>):T = retrofit.create(service)

    //通过 泛型 优化 上面的方法的调用
    inline fun<reified T> create():T = create(T::class.java)
}