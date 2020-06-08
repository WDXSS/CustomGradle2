package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.customview.R;

import java.io.File;

/**
 * Created by qijian on 16/9/25.
 * <p/>
 * 两点注意:
 * 1\在AndroidManifest中添加网络使用权限
 * 2\请求网络,必须在子线程中,不能在主线程中,不然直接报错
 */
public class BitmapFactoryOptionsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap_bitmapfactory_options_activity);

        //测试inJustDecodeBounds属性,获取图片宽高
        findViewById(R.id.injust_decode_bounds_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInJustDecodeBounds();
            }
        });

        //采样率
        findViewById(R.id.in_sample_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInSample();
            }
        });

        //7.5.3.4 inScaled
        findViewById(R.id.in_scaled_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInScaled();
            }
        });


        //7.5.3.4 inDensity、inTargetDensity
        findViewById(R.id.in_density_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInDensity();
            }
        });

        //7.5.3.5 inPreferredConfig
        findViewById(R.id.in_preferred_config_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInPreferredConfig();
            }
        });

    }


    //测试inJustDecodeBounds属性,获取图片宽高
    private void testInJustDecodeBounds() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);
        Log.d("qijian", "bitmap:" + bitmap);
        Log.d("qijian", "realwidth:" + options.outWidth + "   realheight:" + options.outHeight + "    mimeType:" + options.outMimeType);
        Toast.makeText(BitmapFactoryOptionsActivity.this, "realwidth:" + options.outWidth + "   realheight:" + options.outHeight + " mimeType:" + options.outMimeType
                , Toast.LENGTH_SHORT).show();
    }

    //测试采样率函数
    private void testInSample() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.scenery, options);

        ImageView iv = (ImageView) findViewById(R.id.img);
        int sampleSize = calSampleSize(options, iv.getWidth(), iv.getHeight());
        Toast.makeText(BitmapFactoryOptionsActivity.this, "sampleSize" + sampleSize, Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = sampleSize;
        try {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery, options2);
            iv.setImageBitmap(bmp);
        } catch (OutOfMemoryError err) {
            //TODO OOM
        }
    }


    //dstWidth和dstHeight分别为目标ImageView的宽高
    public static int calSampleSize(BitmapFactory.Options options, int dstWidth, int dstHeight) {
        int rawWidth = options.outWidth;
        int rawHeight = options.outHeight;
        int inSampleSize = 1;
        if (rawWidth > dstWidth || rawHeight > dstHeight) {
            float ratioHeight = (float) rawHeight / dstHeight;
            float ratioWidth = (float) rawWidth / dstHeight;
            inSampleSize = (int) Math.min(ratioWidth, ratioHeight);
        }
        return inSampleSize;
    }

    //7.5.3.5 inPreferredConfig
    public void testInPreferredConfig() {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery);
        String LogStr = "ARGB888_width:" + bmp.getWidth() + "  height:" + bmp.getHeight() + " 内存:" + bmp.getByteCount();
        Log.d("qijian", LogStr);
        Toast.makeText(BitmapFactoryOptionsActivity.this, LogStr, Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery, options);
        String LogStr2 = "ARGB565_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount();
        Log.d("qijian", LogStr2);
        Toast.makeText(BitmapFactoryOptionsActivity.this, LogStr2, Toast.LENGTH_SHORT).show();
    }


    public void testInScaled() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery);
        Log.d("qijian", "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount());
        Toast.makeText(BitmapFactoryOptionsActivity.this, "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount(),
                Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap noScaleBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery, options);
        Log.d("qijian", "drawableBmp_width:" + noScaleBmp.getWidth() + "  height:" + noScaleBmp.getHeight() + " 内存:" + noScaleBmp.getByteCount());
        Toast.makeText(BitmapFactoryOptionsActivity.this, "drawableBmp_width:" + noScaleBmp.getWidth() + "  height:" + noScaleBmp.getHeight() + " 内存:" + noScaleBmp.getByteCount(), Toast.LENGTH_SHORT).show();
    }


    public void testInDensity() {
        //从Drawable里读取
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 1;
        options.inTargetDensity = 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.scenery, options);
        Log.d("qijian", "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount());

        //直接从文件中读取
        File file = Environment.getExternalStorageDirectory();
        String path = file.getAbsolutePath() + "/scenery.png";
        Bitmap bmp = BitmapFactory.decodeFile(path, options);
        if (bmp == null) {
            Toast.makeText(BitmapFactoryOptionsActivity.this, "请确保SD卡根目录存在scenery.png", Toast.LENGTH_SHORT).show();
        } else {
            String toastStr = "fileBmp_width:" + bmp.getWidth() + "  height:" + bmp.getHeight() + " 内存:" + bmp.getByteCount();
            Log.d("qijian", toastStr);
            Toast.makeText(BitmapFactoryOptionsActivity.this, toastStr, Toast.LENGTH_SHORT).show();
        }

    }

}
