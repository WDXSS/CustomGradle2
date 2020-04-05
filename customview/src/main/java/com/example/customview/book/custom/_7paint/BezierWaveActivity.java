package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过path 绘制 二阶贝济埃曲线 ")
public class BezierWaveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_path_bezier);
    }
}
