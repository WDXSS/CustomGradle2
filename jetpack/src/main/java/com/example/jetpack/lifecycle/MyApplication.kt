package com.example.jetpack.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.jetpack.lifecycle.imp.ApplicationObserver

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()


//        ApplicationObserver 继承自 LifecycleObserver
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}