package com.example.jetpack

import android.content.Context
import android.content.Intent

inline fun <reified T : Any> startActivity(context: Context) {
    context.startActivity(Intent(context, T::class.java))
}

inline fun <reified T : Any> startActivity(context: Context, block: () -> Intent) {
    val intent = block()
    intent.setClass(context, T::class.java)
    context.startActivity(intent)
}

inline fun <reified T : Any> startActivity2(context: Context, block: Intent.() -> Unit) {
    var intent = Intent()
    intent.setClass(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}