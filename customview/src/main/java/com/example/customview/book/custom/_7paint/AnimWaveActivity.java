package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("动态的波浪曲线")
public class AnimWaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_bezier_anim_wave);
    }
}
