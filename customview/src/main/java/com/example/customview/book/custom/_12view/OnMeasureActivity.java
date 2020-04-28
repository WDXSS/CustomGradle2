package com.example.customview.book.custom._12view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("自定义View 中的 测量 介绍")
public class OnMeasureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coustom_book_12_measure_activity);
    }

    //11 000000000000000000000000000000 共32位，前2位是1
    int mode_mask = 0xc0000000;
    private void getMode(int spec){
        int mode = mode_mask & spec;//提取模式
    }
    private void getSize(int spec){
        //11 000000000000000000000000000000 共32位，前2位是1
        int size = ~mode_mask & spec;//提取数值
    }
}
