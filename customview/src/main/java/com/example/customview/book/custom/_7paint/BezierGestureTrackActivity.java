package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("使用二阶贝济埃曲线绘制手势轨迹")
public class BezierGestureTrackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_bezier_gesture_track);
    }
}
