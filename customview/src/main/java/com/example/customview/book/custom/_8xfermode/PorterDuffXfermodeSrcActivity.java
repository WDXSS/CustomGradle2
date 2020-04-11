package com.example.customview.book.custom._8xfermode;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("porterXfermode之源图像模式")
public class PorterDuffXfermodeSrcActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_porter_duff_xfermode_src);
        //源图像摸式共 5中模式，分别通过 5个自定义View说明
//         PorterDuffXfermodeViewSrc，
//         PorterDuffXfermodeViewSrcAtop，
//        PorterDuffXfermodeViewSrcIn
//        PorterDuffXfermodeViewSrcOut
//        PorterDuffxfermodeViewSrcOver

    }
}
