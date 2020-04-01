package com.example.customview.book.custom._10canvas;

import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过创建Drawable对象，将画好的Drawable 对象画到 画布上 ")
public class ShapeConstructorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_shape_constructor);

        //通过 ShapeDrawable 画到画布上，ShapeDrawable 需要Shape画出图案

//        Shape 已知的子类有：
//        RectShape  构造一个矩形 shape
//        ArcShape    构造一个扇形 shape
//        OvalShape    构造一个椭圆 shape
//        RoundRectShape    构造一个圆角 shape， 可以带有镂空矩形效果
//        PathShape    构造一个根据路径绘制 shape
    }
}
