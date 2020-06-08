package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.customview.R;

/**
 * Created by qijian on 16/9/30.
 */
public class BitmapPixelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_book_10_bitmap_bmp_pixel_activity);

        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageBitmap(srcBmp);

        Bitmap desBmp = srcBmp.copy(Bitmap.Config.ARGB_8888, true);
        for (int h = 0; h < srcBmp.getHeight(); h++) {
            for (int w = 0; w < srcBmp.getWidth(); w++) {
                int originColor = srcBmp.getPixel(w, h);


                int red = (Color.red(originColor));
                int alpha = Color.alpha(originColor);
                int green = Color.green(originColor);
                int blue = Color.blue(originColor);

                if (green < 200) {
                    green += 30;
                }

                desBmp.setPixel(w, h, Color.argb(alpha, red, green, blue));

            }
        }

        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageBitmap(desBmp);
    }

}
