package com.example.customview.book.custom._12view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("第12章 ：封装控件")
public class TwelveMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve_main);
    }

    public void startDeclareStyleableActivity(View view) {
        startActivity(new Intent(this, DeclareStyleableActivity.class));
    }

    public void startMeasureActivity(View view) {
        startActivity(new Intent(this, OnMeasureActivity.class));
    }

    public void startGetMarginActivity(View view) {
        startActivity(new Intent(this, GetMarginActivity.class));
    }

    public void startMyLinLayoutActivity(View view) {
        startActivity(new Intent(this, MyLinLayoutActivity.class));

    }

    public void startFlowLayoutActivity(View view) {
        startActivity(new Intent(this,FlowLayoutActivity.class));
    }
}
