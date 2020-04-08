package com.example.customview.book.custom._7paint;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("设置边缘模糊效果")
public class BlurMaskFilterActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_seven_blur_mask_filter);
        //设置文字，图像，图片的边缘模糊效果
    }
}
