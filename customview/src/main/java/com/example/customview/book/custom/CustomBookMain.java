package com.example.customview.book.custom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.book.custom._10canvas.TenMainActivity;
import com.example.customview.book.custom._7paint.SevenMainActivity;

public class CustomBookMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_custom_book);
    }

    public void start10Canvas(View view) {
        //打开 10 android 画布
        Intent intent = new Intent();
        intent.setClass(this, TenMainActivity.class);
        startActivity(intent);
    }
    public void startSevenPaint(View view) {
        //打开 第7 绘图进阶
        Intent intent = new Intent();
        intent.setClass(this, SevenMainActivity.class);
        startActivity(intent);

    }
}
