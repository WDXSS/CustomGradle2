package com.example.customview.book.custom._10canvas;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.customview.R;
import com.example.customview.book.custom._10canvas.view.CustomDrawableBackground;
import com.example.jetpack.DevDescribe;

/**
 * Created by qijian on 16/9/19.
 */
@DevDescribe("设置 textView 的背景为 图片时，如何使图片包裹 适应内容的大小")
public class BackgroundDrawableActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_background_drawable);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        CustomDrawableBackground drawable = new CustomDrawableBackground(bitmap);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setBackground(drawable);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setBackground(getDrawable(R.mipmap.avator));
    }
}
