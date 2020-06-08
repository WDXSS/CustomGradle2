package com.example.customview.book.custom._10canvas.bitmap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.example.customview.R;

import java.io.*;

/**
 * Created by qijian on 16/10/1.
 */
public class BitmapCompressActivity extends Activity {
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_book_10_bitmap_bmp_compress_activity);

        ImageView iv_1 = (ImageView) findViewById(R.id.img1);
        ImageView iv_2 = (ImageView) findViewById(R.id.img2);

        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.mipmap.cat);
        iv_1.setImageBitmap(bmp);

        //压缩图像后,显示
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 1, bos);
        byte[] bytes = bos.toByteArray();
        Bitmap bmp1 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        iv_2.setImageBitmap(bmp1);


        ImageView iv_3 = (ImageView) findViewById(R.id.img3);
        ImageView iv_4 = (ImageView) findViewById(R.id.img4);


        ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 1, bos3);

        byte[] bytes3 = bos3.toByteArray();
        Bitmap bmp3 = BitmapFactory.decodeByteArray(bytes3, 0, bytes3.length);

        iv_3.setImageBitmap(bmp3);


        ByteArrayOutputStream bos4 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.WEBP, 1, bos4);

        byte[] bytes4 = bos4.toByteArray();
        Bitmap bmp4 = BitmapFactory.decodeByteArray(bytes4, 0, bytes4.length);

        iv_4.setImageBitmap(bmp4);

    }


    /**
     * 保存文件到手机SD卡根目录中
     * @param bitmap
     */
    private void saveBmp(Bitmap bitmap) {
        File fileDir = Environment.getExternalStorageDirectory();
        String path = fileDir.getAbsolutePath() + "/lavor.webp";

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.WEBP, 10, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
