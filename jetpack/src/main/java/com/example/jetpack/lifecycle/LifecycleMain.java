package com.example.jetpack.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

public class LifecycleMain {
    //简单使用 LifecycleActivity

    //源码分析
    //Lifecycle.java 两个生命周期相关的枚举：Event 和 State
//    Lifecycle
//    MutableLiveData  继承自LiveData
    //1.Lifecycle.Event.ON_ANY 方法最多两个参数，参考LifecycleActivity.MyObserver 中的实现

    //2. processLifeOwner ： LifeCycle 提供了一个 ProcessLifecycleOwner的类，监听应用的生命周期
    //3. LifecycleService  继承自Service 并且实现了 LifecycleOwner 接口
}
