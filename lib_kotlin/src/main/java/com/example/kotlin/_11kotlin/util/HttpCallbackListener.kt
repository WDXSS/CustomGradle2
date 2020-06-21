package com.example.kotlin._11kotlin.util

import java.lang.Exception

interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)
}