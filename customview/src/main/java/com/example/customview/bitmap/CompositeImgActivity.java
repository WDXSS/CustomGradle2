package com.example.customview.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.customview.R;

/**
 * 合成图片
 *
 * @author zhouchao
 * @date 2020/7/29
 */
public class CompositeImgActivity extends AppCompatActivity {
    private static final String TAG = "CompositeImgActivity";
    private ImageView mImageView;
    private Matrix mMatrix;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.composite_img_activity);
        mImageView = findViewById(R.id.img);

        mMatrix = new Matrix();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compositeImg();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compositeImg2();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compositeImg3();
            }
        });
    }

    //在原图上 添加文字
    private void compositeImg() {
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(this, R.color.white));
        paint.setTextSize(26);

        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_master);
        Bitmap bitmap = src.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText("123456", 100, 100, paint);

        mImageView.setImageBitmap(bitmap);
    }

    // BitmapShader
    private void compositeImg2() {
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        int height = src.getHeight();
        int width = src.getWidth();
        Log.d(TAG, "compositeImg2() called height = " + height + ",  width = " + width);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(src, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        float scale = (float) width / bitmap.getWidth();
        mMatrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(mMatrix);
//        float half = (float) getWidth() / 2;
////        canvas.drawCircle(half, half, (float) getWidth() / 2, mPaint);
        canvas.drawRoundRect(0, 0, bitmap.getWidth(), bitmap.getHeight(), 50, 50, paint);

        Bitmap bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint2 = new Paint();
        paint2.setColor(ContextCompat.getColor(this, R.color.white));
        paint2.setTextSize(49);
        Canvas canvas2 = new Canvas(bitmap2);
        canvas2.drawText("123456", 100, 100, paint2);

        mImageView.setImageBitmap(bitmap2);
    }

    private void compositeImg3() {
        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        int height = src.getHeight();
        int width = src.getWidth();
        Bitmap bitmap = src.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);

        float inner = 40;
        float inset = 26; //矩形的宽度
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        float[] outerR = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
        float[] innerR = new float[]{inner, inner, inner, inner, inner, inner, inner, inner};
        RectF insetR = new RectF(inset, inset, inset, inset);
        RoundRectShape roundRectShape = new RoundRectShape(outerR, insetR, innerR);
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setColor(Color.RED);
        shapeDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());//设置 Draw
//        shapeDrawable.setBounds(0, 0, 100, 100);//设置 Draw
        shapeDrawable.draw(canvas);

        mImageView.setImageBitmap(bitmap);
    }
}
