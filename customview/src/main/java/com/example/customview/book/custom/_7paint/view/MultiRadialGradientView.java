package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MultiRadialGradientView extends View {

    private Paint mPaint;

    public MultiRadialGradientView(Context context) {
        this(context, null);
    }

    public MultiRadialGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiRadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);//去掉硬件加速
        mPaint = new Paint();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //双色渐变
////        float centerX, 渐变中心点X坐标
////        float centerY, 渐变中心点Y坐标
////        float radius,  渐变半径
////        @ColorInt int centerColor, 渐变的起始颜色，即渐变中心的颜色，取值类型必须是8位的 0xAARRGGBB
////        @ColorInt int edgeColor, 渐变的结束颜色，即 渐变边缘的颜色
////        @NonNull Shader.TileMode tileMode
//        float centerX = (float) getWidth() / 2;
//        float centerY = (float) getHeight() / 2;
//        float radius = (float) getWidth() / 2;
//        int centerColor = 0xffff0000;
//        int edgeColor = 0xff00ff00;
//
//        @SuppressLint("DrawAllocation")
//        RadialGradient radialGradient = new RadialGradient(centerX,centerY,radius,centerColor,edgeColor,Shader.TileMode.CLAMP);
//        mPaint.setShader(radialGradient);
//        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);


        //多色渐变
//        @NonNull @ColorInt int colors[] 渐变颜色数组
//        @Nullable float stops[], 每种颜色渐变位置的百分点  取值范围 0~1
        float centerX = (float) getWidth() / 2;
        float centerY = (float) getHeight() / 2;
        float radius = (float) getWidth() / 2;

        int[] colors = new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00};
        float[] stops = new float[]{0f, 0.2f, 0.5f, 1f};
        RadialGradient multiShader = new RadialGradient(centerX, centerY, radius, colors, stops, Shader.TileMode.REPEAT);
        mPaint.setShader(multiShader);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
