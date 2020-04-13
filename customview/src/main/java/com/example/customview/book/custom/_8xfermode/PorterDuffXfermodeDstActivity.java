package com.example.customview.book.custom._8xfermode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("以目标图像显示为主的模式，可以在源图像模式中，将源图像和目标图像调换一下实现相同效果" +
        "目标图像模式有：" +
        "Mode.DST;" +
        "Mode.DST_IN;" +
        "DST_OUT;" +
        "DST_OVER;" +
        "DST_ATOP")
public class PorterDuffXfermodeDstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_porter_duff_xfermode_dst);
    }
}
