package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("闪烁的TextView")
public class ShimmerTextActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_seven_shimmer_text);

//        原理：在自定义TextView 中在 通过Shader 的派生类LinearGradient,构建一个是内容相同长度shader，
//               然后通过动画无限循环从开始位置移动到结束位置
    }
}
