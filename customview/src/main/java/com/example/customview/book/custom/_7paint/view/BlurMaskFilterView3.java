package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("绘制图片的模糊效果")
public class BlurMaskFilterView3 extends View {

    private int margin = 50;

    private Paint mRectPaint;
    private Bitmap mBitmap;

    public BlurMaskFilterView3(Context context) {
        this(context, null);
    }

    public BlurMaskFilterView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurMaskFilterView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mRectPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        @SuppressLint("DrawAllocation")
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(20, BlurMaskFilter.Blur.SOLID);
        mRectPaint.setMaskFilter(blurMaskFilter);

        canvas.drawBitmap(mBitmap, 40, 40, mRectPaint);
    }
}
