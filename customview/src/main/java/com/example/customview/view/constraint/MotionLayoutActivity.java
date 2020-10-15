package com.example.customview.view.constraint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * MotionLayoutActivity简介
 * 官方 example
 * https://github.com/android/views-widgets-samples/tree/master/ConstraintLayoutExamples
 * 官方文档
 * https://developer.android.com/training/constraint-layout/motionlayout
 * 学习
 * https://blog.csdn.net/knight1996/article/details/108015536
 * @author ext.zhouchao3
 * @date 2020-10-13 10:18
 */
public class MotionLayoutActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_motion_layout);

	}
}
