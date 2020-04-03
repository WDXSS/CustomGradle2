package com.example.customview.book.custom._10canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.book.custom._10canvas.view.CustomDrawable;
import com.example.jetpack.DevDescribe;

@DevDescribe("自定义 Drawable  ")
public class CustomDrawableActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_custom_drawable);
        //setBounds与 Imagview 的scaleType有关系
        //总结: setImageDrawable(drawable)
        //原图片的显示大小会根据 scaleType 的值进行缩放图片，然后通过 setBounds() 设置给 CustomDrawable
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        CustomDrawable drawable = new CustomDrawable(bitmap);

        CustomDrawable drawable2 = new CustomDrawable(bitmap);

        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageDrawable(drawable);

        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageDrawable(drawable);

        ImageView iv3 = (ImageView) findViewById(R.id.img3);
        iv3.setImageDrawable(drawable);

        ImageView iv4 = (ImageView) findViewById(R.id.img4);
        iv4.setImageDrawable(drawable);

        ImageView iv5 = (ImageView) findViewById(R.id.img5);
        iv5.setImageDrawable(drawable);

        ImageView iv6 = (ImageView) findViewById(R.id.img6);
        iv6.setImageDrawable(drawable);

        ImageView iv7 = (ImageView) findViewById(R.id.img7);
        iv7.setImageDrawable(drawable2);


//        TextView textView = findViewById(R.id.test);
//        textView.setBackground(drawable2);
    }
}