package com.example.customview.book.light;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.book.light._3view.ThreeMainActivity;
import com.example.jetpack.DevDescribe;

@DevDescribe("android 进阶之光")
public class AdvancedLightBookMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_light_book);
    }

    public void startThreeMainActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ThreeMainActivity.class);
        startActivity(intent);
    }
}
