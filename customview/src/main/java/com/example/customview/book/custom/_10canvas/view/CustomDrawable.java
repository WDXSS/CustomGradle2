package com.example.customview.book.custom._10canvas.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomDrawable extends Drawable {
    private static final String TAG = "CustomDrawable";
    private Bitmap mBitmapBg;
    private Paint mPaint;
    private BitmapShader bitmapShader;
    private RectF mBound;

    public CustomDrawable(Bitmap bitmapBg) {
        mBitmapBg = bitmapBg;
        mPaint = new Paint();
    }

    @Override
    public void setAlpha(int alpha) {
        //将 参数alpha 传个 Drawable 的Paint
        this.mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        //将colorFilter 传个 Drawable 的Paint
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        //当外部需要知道自定义Drawable 的显示模式时调用，
        //有4中模式
        //@IntDef({UNKNOWN, TRANSLUCENT, TRANSPARENT, OPAQUE})
        //TRANSLUCENT 半透明
        //TRANSPARENT 完全透明
        //OPAQUE  表示没有透明通道
        return PixelFormat.TRANSLUCENT;//返回 TRANSLUCENT 是最常用的
    }
    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(mBound,50,50,mPaint);
    }
    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);


        Log.d(TAG, "getIntrinsicWidth() called = " +mBitmapBg.getWidth());
        Log.d(TAG, "getIntrinsicHeight() called = "+ mBitmapBg.getHeight());
        Log.d(TAG, "setBounds() called with: left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");

        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(mBitmapBg, right - left, bottom - top, true), Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        mBound = new RectF(left, top, right, bottom);
    }

    @Override
    public int getIntrinsicWidth() {
        Log.d(TAG, "getIntrinsicWidth() called = " +mBitmapBg.getWidth());
        return mBitmapBg.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        Log.d(TAG, "getIntrinsicHeight() called = "+ mBitmapBg.getHeight());
        return mBitmapBg.getHeight();
    }
}
