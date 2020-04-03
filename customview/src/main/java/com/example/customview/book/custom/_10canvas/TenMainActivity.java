package com.example.customview.book.custom._10canvas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class TenMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_main);
    }

    public void startShapeInstanceActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ShapeInstanceActivity.class);
        startActivity(intent);
    }

    public void startShapeConstructorActivity(View view) {
        //通过创建Drawable对象，将画好的Drawable 对象画到 画布上
        // 调用 Drawable 的draw() 方法将其画到画布上
        Intent intent = new Intent();
        intent.setClass(this, ShapeConstructorActivity.class);
        startActivity(intent);
    }
    public void startTelescopeActivity(View view) {
        //通过创建Drawable对象，将画好的Drawable 对象画到 画布上
        // 调用 Drawable 的draw() 方法将其画到画布上
        Intent intent = new Intent();
        intent.setClass(this, TelescopeActivity.class);
        startActivity(intent);
    }

    public void startCustomDrawableActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CustomDrawableActivity.class);
        startActivity(intent);
    }

    public void startBackgroundDrawableActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, BackgroundDrawableActivity.class);
        startActivity(intent);
    }
}
