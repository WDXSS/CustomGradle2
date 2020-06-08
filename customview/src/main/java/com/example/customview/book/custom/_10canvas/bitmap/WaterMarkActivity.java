package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.customview.R;

/**
 * Created by qijian on 16/10/3.
 */
public class WaterMarkActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap_watermark_activity);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        Bitmap watermark = BitmapFactory.decodeResource(getResources(), R.mipmap.watermark);
        Bitmap result = createBitmap(bitmap, watermark);

        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageBitmap(result);
    }

    private Bitmap createBitmap(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }

        int w = src.getWidth();
        int h = src.getHeight();
        int ww = watermark.getWidth();
        int wh = watermark.getHeight();
        //创建空白图像
        Bitmap newb = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);//创建一个新的和SRC长度宽度一样的位图
        Canvas cv = new Canvas(newb);
        //画原图
        cv.drawBitmap(src, 0, 0, null);//在 0，0坐标开始画入src
        //在src的右下角画入水印
        cv.drawBitmap(watermark, w - ww + 5, h - wh + 5, null);
        return newb;
    }
}
