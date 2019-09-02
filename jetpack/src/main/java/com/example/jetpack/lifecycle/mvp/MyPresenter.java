package com.example.jetpack.lifecycle.mvp;

import android.util.Log;

import com.example.jetpack.DevDescribe;

@DevDescribe(value = "MVP 的事例")
public class MyPresenter implements IPresenter{
    private static final String TAG = "MyPresenter";

    @Override
    public void onResume() {
        Log.d(TAG, "Lifecycle call onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG, "Lifecycle call onPause");
    }
}
