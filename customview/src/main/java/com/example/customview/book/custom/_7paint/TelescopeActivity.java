package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("望远镜效果，放大镜效果(第十章)是望远镜效果的进阶")
public class TelescopeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_shader_telescope_7);

//        原理:原图 srcBitmap
//            缩放BitmapShader 到View相同大小，方法： 1.可以通过创建和view相同大小的bitmap，2.也可以使用Matrix
//            通过paint 设置BitmapShader，将图案绘制出来，并通过 shapeDrawable 显示指定的位置，大小，形状
    }
}
