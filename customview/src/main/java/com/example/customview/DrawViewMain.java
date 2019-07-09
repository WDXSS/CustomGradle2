package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.anim.property.value.LoadingDemo;
import com.example.customview.anim.view.tween.ScannerDome;
import com.example.customview.view.SpiderActivity;

public class DrawViewMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_view_main);
    }

    public void startSpider(View view) {
        startActivity(new Intent(DrawViewMain.this, SpiderActivity.class));

    }

    public void startScannerDome(View view) {
        startActivity(new Intent(DrawViewMain.this, ScannerDome.class));
    }

    public void startLoadingDemo(View view) {

        startActivity(new Intent(DrawViewMain.this, LoadingDemo.class));
    }
}
