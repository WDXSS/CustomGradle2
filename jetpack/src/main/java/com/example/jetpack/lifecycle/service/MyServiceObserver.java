package com.example.jetpack.lifecycle.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.util.Log;

public class MyServiceObserver implements LifecycleObserver {
    private String TAG = this.getClass().getName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetLocation() {
        Log.d(TAG, "startGetLocation()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetLocation() {
        Log.d(TAG, "stopGetLocation()");
    }
}
