package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.os.Bundle;

import com.example.customview.R;

/**
 * Created by qijian on 16/9/27.
 * 7.5.4.1 创建白色透明渐变图像
 */
public class BmpBlankGradientActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); 通过Bitmap的静态方法
//        createBitmap() 创建一个空白透明的的bitmap
        setContentView(R.layout.custom_book_10_bitmap_bmp_blank_gradient_activity);
    }
}
