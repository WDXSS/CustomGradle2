package com.example.customview.view.constraint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * https://blog.csdn.net/xiaojinlai123/article/details/103331504
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstraintLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constrain_layout);
    }
    //1. Bias 属性
    public void biasActivity(View view) {
        startActivity(new Intent(this,ConstrainBiasActivity.class));
    }


    public void circleActivity(View view) {
        startActivity(new Intent(this,ConstrainCircleActivity.class));
    }
}
