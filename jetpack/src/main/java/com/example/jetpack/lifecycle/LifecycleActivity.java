package com.example.jetpack.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.jetpack.DevDescribe;
import com.example.jetpack.R;
import com.example.jetpack.lifecycle.mvp.MyPresenter;

/**
 * http://liuwangshu.cn/application/jetpack/2-lifecycle-use.html
 */
@DevDescribe(value = "lifecycle 的实例")
public class LifecycleActivity extends AppCompatActivity{
    private static final String TAG = "LifecycleActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        //1. TODO 简单使用
//        先实现MyObserver，对ON_CREATE和ON_RESUME事件进行监听。
//        因为在Android Support Library 26.1.0 及其之后的版本，
//        Activity和Fragment已经默认实现了LifecycleOwner接口，
//        所以在注释1处可以直接使用getLifecycle方法获取Lifecycle对象，
//        这样MyObserver就可以观察MainActivity的生命周期变化了，
//        LifecycleOwner可以理解为被观察者，
//        MainActivity默认实现了LifecycleOwner接口，
//        也就是说MainActivity是被观察者
        getLifecycle().addObserver(new MyObserver());//1

        //2 TODO MVP 的例子
        MyPresenter presenter = new MyPresenter();
        getLifecycle().addObserver(presenter);

        //3 TODO 自定义 LifecycleOwner
//        如果想实现自定义 LifecycleOwner，可以使用 LifecycleRegistry，它是Lifecycle的实现类。

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    public class MyObserver implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onResume(){
            Log.d(TAG, "Lifecycle call onResume");
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onPause(){
            Log.d(TAG, "Lifecycle call onPause");
        }
    }
}
