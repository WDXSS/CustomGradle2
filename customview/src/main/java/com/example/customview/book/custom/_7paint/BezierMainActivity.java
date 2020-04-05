package com.example.customview.book.custom._7paint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过path 绘制 贝济埃曲线 ")
public class BezierMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_path_bezier_main);
    }

    public void startBezierWaveActivity(View view) {
        startActivity(new Intent(this, BezierWaveActivity.class));
    }

    public void startNormalGestureTrackActivity(View view) {
        //通过path 画收拾轨迹
        startActivity(new Intent(this, NormalGestureTrackActivity.class));
    }

    public void startBezierGestureTrackActivity(View view) {
        //通过 贝济埃曲线 绘制轨迹
        startActivity(new Intent(this, BezierGestureTrackActivity.class));
    }
}
