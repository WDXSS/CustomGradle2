package com.example.jetpack.lifecycle.service;

import androidx.lifecycle.LifecycleService;

/**
 * lifecycleService 继承自Service 并且实现了 lifecycleOwner 接口
 */
public class MyService extends LifecycleService {
    private MyServiceObserver myServiceObserver;

    public MyService() {
        myServiceObserver = new MyServiceObserver();
        getLifecycle().addObserver(myServiceObserver);//添加观察者
    }
}
