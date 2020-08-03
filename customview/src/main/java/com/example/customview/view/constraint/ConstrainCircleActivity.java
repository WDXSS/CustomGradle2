package com.example.customview.view.constraint;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainCircleActivity extends AppCompatActivity {

//    圆形定位比较好理解，即以一个控件为圆心，让其他控件以此控件为中心点进行圆形摆放，相关属性有三个
//    layout_constraintCircle ：引用圆心部件的ID
//    layout_constraintCircleRadius ：到圆心部件中心的距离
//    layout_constraintCircleAngle ：当前部件相对圆心部件的角度（以度为单位，从0到360）
// 设置了两个布局文件，有一个 有 约束关系一个没有约束关系
    private TextView mTextView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_circle);

    }
}

