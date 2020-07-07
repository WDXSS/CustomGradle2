package com.example.kotlin._13kotlin.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.kotlin._2kotlin.DevKotlin
import com.example.kotlin._3kotlin.Utils
import com.example.kotlin.util.KotlinDateUtil
import java.lang.StringBuilder

@DevKotlin("监听Activity 的生命周期 ")
class LifecycleMainObserver : LifecycleObserver {

     var str :StringBuilder
    init {
        str = StringBuilder()
    }
    //一共有 7 种状态， 其中 NO_ANY 表示可配 Activity 的任何生命周期
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun activityCreate() {
        KotlinDateUtil.printlnAndTime("activityCreate")
        str.append("activityCreate" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        KotlinDateUtil.printlnAndTime("activityStart")
        str.append("activityStart" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        KotlinDateUtil.printlnAndTime("activityStop")
        str.append("activityStop" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun activityResume() {
        KotlinDateUtil.printlnAndTime("activityResume")
        str.append("activityResume" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun activityDestroy() {
        KotlinDateUtil.printlnAndTime("activityDestroy")
        str.append("activityDestroy" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun activityPause() {
        KotlinDateUtil.printlnAndTime("activityPause")
        str.append("activityPause" +"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun activityNoAny() {
        KotlinDateUtil.printlnAndTime("activityNoAny")
        str.append("activityNoAny" +"\n")
    }
}