package com.example.customview.book.custom._13view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("13章 高级控件")
public class ThirteenMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_13_main_activity);
    }

    public void startGestureDetectorActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, GestureDetectorActivity.class);
        startActivity(intent);
    }

    public void startOnDoubleTabListenerActivity(View view) {

        Intent intent = new Intent();
        intent.setClass(this, OnDoubleTabListenerActivity.class);
        startActivity(intent);
    }

    public void startGestureDetectorWeb(View view) {
        Intent intent = new Intent();
        intent.setClass(this, GestureDetectorWeb.class);
        startActivity(intent);
    }

    public void startSimpleOnGestureDetectorActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SimpleOnGestureDetectorActivity.class);
        startActivity(intent);
    }

    public void startWindowActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, WindowBookActivity.class);
        startActivity(intent);

    }
}
