package com.example.customview.book.custom._8xfermode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("xfermode 之 clear 模式：公式[0,0] 源图像所在区域变成空白像素，起到清空源图像所在区域图像的作用")
public class PorterDuffXfermodeClearActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_porter_duff_xfermode_clear);
    }
}
