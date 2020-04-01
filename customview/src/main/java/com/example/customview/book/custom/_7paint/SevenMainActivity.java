package com.example.customview.book.custom._7paint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class SevenMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_main);
    }

    public void startBitmapShaderActivity(View view) {
        //BitmapShader 的基本用法
        startActivity(new Intent(this, BitmapShaderActivity.class));
    }
}
