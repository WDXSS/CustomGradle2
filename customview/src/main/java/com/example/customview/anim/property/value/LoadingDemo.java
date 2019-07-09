package com.example.customview.anim.property.value;

import android.animation.ValueAnimator;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.customview.R;
import com.example.customview.anim.property.value.widget.LoadingImageView;

/**
 * 弹跳加载效果
 */
public class LoadingDemo extends AppCompatActivity {

    private Button btnStart;
    private Button btnCancel;
    private LoadingImageView imgLoading;

    private ValueAnimator valueAnimator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_loading);

        btnStart = findViewById(R.id.btn_start);
        btnCancel = findViewById(R.id.btn_cancel);
        imgLoading = findViewById(R.id.img_loading);
        valueAnimator = imgLoading.getValueAnimator();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.start();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.cancel();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //因为动画设置的是无限循环，所以Activity 退出时需要停止动画
        if (valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }
}
