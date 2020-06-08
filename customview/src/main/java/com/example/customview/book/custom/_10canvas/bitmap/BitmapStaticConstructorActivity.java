package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.customview.R;

/**
 * Created by qijian on 16/9/27.
 */
public class BitmapStaticConstructorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap_bmp_static_constructor_activity);

        //7.5.4.1 创建白色透明渐变图像
        findViewById(R.id.bitmap_blank_gradient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BitmapStaticConstructorActivity.this, BmpBlankGradientActivity.class));
            }
        });

        //7.5.4.3 裁剪图像
        findViewById(R.id.bitmap_crop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cutImage();
            }
        });

        //7.5.4.4 裁剪图像并用Matrix
        findViewById(R.id.bitmap_crop_matrix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cutImageMatrix();
            }
        });

        //7.5.4.5 指定色彩创建图像
        findViewById(R.id.bitmap_colors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBmpByColors();
            }
        });

        //7.5.4.6 createScaledBitmap
        findViewById(R.id.bitmap_scaled).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createScaledBitmap();
            }
        });
    }


    //7.5.4.3 裁剪图像
    private void cutImage() {
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        Bitmap cutedBmp = Bitmap.createBitmap(src, src.getWidth() / 3, src.getHeight() / 3, src.getWidth() / 3, src
                .getHeight() / 3);
        ImageView iv = (ImageView) findViewById(R.id.bmp_img);
        ImageView bmp_img2 = (ImageView) findViewById(R.id.bmp_img2);
        iv.setImageBitmap(src);
        bmp_img2.setImageBitmap(cutedBmp);
    }

    //7.5.4.4 裁剪图像并用Matrix
    private void cutImageMatrix() {
        Matrix matrix = new Matrix();
        matrix.setScale(2, 1);

        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        Bitmap cutedBmp = Bitmap.createBitmap(src, src.getWidth() / 3, src.getHeight() / 3, src.getWidth() / 3, src
                .getHeight() / 3, matrix, true);

        ImageView iv =  findViewById(R.id.bmp_img);
        ImageView bmp_img2 =  findViewById(R.id.bmp_img2);
        iv.setImageBitmap(src);
        bmp_img2.setImageBitmap(cutedBmp);
    }

    //7.5.4.5 指定色彩创建图像
    private void createBmpByColors() {
        int width = 300, height = 200;
        int[] colors = initColors(width, height);
        Bitmap bmp = Bitmap.createBitmap(colors, width, height, Bitmap.Config.ARGB_8888);

        ImageView iv = (ImageView) findViewById(R.id.bmp_img);
        iv.setImageBitmap(bmp);
    }

    private int[] initColors(int width, int height) {
        int[] colors = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = x * 255 / (width - 1);
                int g = y * 255 / (width - 1);
                int b = 255 - Math.min(r, g);
                int a = Math.max(r, g);
                colors[y * width + x] = Color.argb(a, r, g, b);
            }
        }
        return colors;
    }

    private void createScaledBitmap() {
        try {
            Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery);
            Bitmap bitmap = Bitmap.createScaledBitmap(src, 300, 200, true);

            ImageView iv =  findViewById(R.id.bmp_img);
            ImageView bmp_img2 =  findViewById(R.id.bmp_img2);
            iv.setImageBitmap(src);
            bmp_img2.setImageBitmap(bitmap);
        }catch (OutOfMemoryError error){
            error.printStackTrace();
        }
    }

}
