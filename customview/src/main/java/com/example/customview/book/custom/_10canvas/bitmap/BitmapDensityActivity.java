package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过设置 inDensity 实现 bitmap的缩放")
public class BitmapDensityActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap__density_activity);
//        "inDensity 资源文件的分辨率
//        inTargetDensity 真实屏幕的分辨率
//        缩放比例 scale = inTargetDensity/inDensity"
        //效果，通过将Density 放大两倍，在屏幕分辨率不变的情况向，使显示出来的图片缩小一半
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);

        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageBitmap(bitmap);
        int density = bitmap.getDensity();
        Log.d("qijian", "density:" + density + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());

        int scaledDensity = density * 2;
        bitmap.setDensity(scaledDensity);
        Log.d("qijian", "density:" + bitmap.getDensity() + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());
        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageBitmap(bitmap);
    }
}
