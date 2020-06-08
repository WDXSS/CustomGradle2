package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.customview.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by qijian on 16/9/25.
 * <p/>
 * 两点注意:
 * 1\在AndroidManifest中添加网络使用权限
 * 2\请求网络,必须在子线程中,不能在主线程中,不然直接报错
 */
public class decodeByteArrayActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap_decode_byte_array_activity);

        final ImageView iv = (ImageView) findViewById(R.id.img);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "https://upload-images.jianshu.io/upload_images/3512252-0eabde023cdc9469.png";
//                    byte[] data = getImage("http://img.my.csdn.net/uploads/201609/24/1474722758_3389.png");
                    byte[] data = getImage(url);
                    int length = data.length;

                    final Bitmap bitMap = BitmapFactory.decodeByteArray(data, 0, length);

                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitMap);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public static byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpURLconnection = (HttpURLConnection) url.openConnection();
        httpURLconnection.setRequestMethod("GET");
        httpURLconnection.setReadTimeout(6 * 1000);
        InputStream in = null;
        if (httpURLconnection.getResponseCode() == 200) {
            in = httpURLconnection.getInputStream();
            byte[] result = readStream(in);
            in.close();
            return result;

        }
        return null;
    }

    public static byte[] readStream(InputStream in) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        in.close();
        return outputStream.toByteArray();
    }

}
