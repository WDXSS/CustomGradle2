package com.example.customview.book.custom._8xfermode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("不规则区域波纹")
public class IrregularWaveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_8_irregular_wave_dst_in);
    }
}