package com.example.customview.book.custom._10canvas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("放大镜：通过 BitmapShader 在ShapeDrawable 画出图案. ")
public class TelescopeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_shader_telescope);

//        原理:原图 srcBitmap
//            放大后的 scaleBitmap,
//            通过paint 设置BitmapShader，讲放大的图案绘制出来，并通过 shapeDrawable 显示指定的位置，大小，形状
    }
}
