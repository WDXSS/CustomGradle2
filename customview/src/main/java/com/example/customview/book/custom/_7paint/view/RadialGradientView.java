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

public class RadialGradientView extends View {

    private Paint mPaint;

    public RadialGradientView(Context context) {
        this(context, null);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);//去掉硬件加速
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //双色渐变
//        float centerX, 渐变中心点X坐标
//        float centerY, 渐变中心点Y坐标
//        float radius,  渐变半径
//        @ColorInt int centerColor, 渐变的起始颜色，即渐变中心的颜色，取值类型必须是8位的 0xAARRGGBB
//        @ColorInt int edgeColor, 渐变的结束颜色，即 渐变边缘的颜色
//        @NonNull Shader.TileMode tileMode
        float centerX = (float) getWidth() / 2;
        float centerY = (float) getHeight() / 2;
        float radius = (float) getWidth() / 2;
        int centerColor = 0xffff0000;
        int edgeColor = 0xff00ff00;

        @SuppressLint("DrawAllocation")
        RadialGradient radialGradient = new RadialGradient(centerX,centerY,radius,centerColor,edgeColor,Shader.TileMode.CLAMP);
        mPaint.setShader(radialGradient);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }
}
