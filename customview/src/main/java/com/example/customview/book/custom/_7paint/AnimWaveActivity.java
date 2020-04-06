package com.example.customview.book.custom._7paint;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("动态的波浪曲线")
public class AnimWaveActivity extends AppCompatActivity {
    TextView mTextView1;
    TextView mTextView2;
    private String info1 = "绘制一个波长的曲线，添加移动动画，来说明波浪动画的实现原理:" +
            "\n 通过path.moveTo()移动绘制曲线的起始点 实现移动，\n 注意在onDraw()绘制是将路径重置，path.reset()";
    private String info2 = "绘制波浪曲线，在屏幕的左侧绘制出额外的一个波长的曲线，然后\n通过path.moveTo()移动绘制曲线的起始点 实现移动";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_bezier_anim_wave);
        mTextView1 = findViewById(R.id.text1);
        mTextView1.setText(info1);

        mTextView2 = findViewById(R.id.text2);
        mTextView2.setText(info2);
    }
}
