package com.example.customview.book.custom._10canvas.view;

import android.graphics.*;
import android.graphics.drawable.Drawable;

/**
 * Created by qijian on 16/9/19.
 */
public class CustomDrawableBackground extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader bitmapShader;
    private RectF mBound;

    public CustomDrawableBackground(Bitmap bitmap) {
        mBitmap = bitmap;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mBound, 20, 20, mPaint);
    }


    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);

        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(mBitmap, right - left, bottom - top, true), Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        mBound = new RectF(left, top, right, bottom);
    }

//    @Override
//    public int getIntrinsicWidth() {
//        return mBitmap.getWidth();
//    }
//
//    @Override
//    public int getIntrinsicHeight() {
//        return mBitmap.getHeight();
//    }
}
