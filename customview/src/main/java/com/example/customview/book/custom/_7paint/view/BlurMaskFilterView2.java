package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("")
public class BlurMaskFilterView2 extends View {

    private int margin = 50;

    private Paint mRectPaint;

    public BlurMaskFilterView2(Context context) {
        this(context, null);
    }

    public BlurMaskFilterView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurMaskFilterView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mRectPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置双色渐变
        int color0 = 0xffff0000;
        int color1 = 0xff00ff00;
        @SuppressLint("DrawAllocation")
        int x0 = 0;
        int y0 = getHeight()/2;

        @SuppressLint("DrawAllocation")
        LinearGradient linearGradient = new LinearGradient(x0, y0, (float) getWidth(), (float)getHeight()/2, color0, color1, Shader.TileMode.CLAMP);
        mRectPaint.setShader(linearGradient);

        //设置模糊
        @SuppressLint("DrawAllocation")
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(20, BlurMaskFilter.Blur.SOLID);
        mRectPaint.setMaskFilter(blurMaskFilter);

        canvas.drawRect(margin, margin, getWidth() - margin, getHeight() - margin, mRectPaint);
    }
}
