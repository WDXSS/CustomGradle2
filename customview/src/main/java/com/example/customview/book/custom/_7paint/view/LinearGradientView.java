package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("Shader 的派生类 LinearGradient 实现渐变效果")
public class LinearGradientView extends View {

    private Paint mPaint;

    private Paint mPaintPath;
    private Paint mPaintColors;//多色渐变

    public LinearGradientView(Context context) {
        this(context, null);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);//去掉硬件加速
        mPaint = new Paint();

        mPaintPath = new Paint();
        mPaintPath.setColor(Color.BLUE);

        mPaintColors = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        float x0, float y0, float x1, float y1,
//        @ColorInt int color0, @ColorInt int color1,
//        @NonNull Shader.TileMode tile
        //参数：x0,y0渐变点的起始坐标，x1，y1 渐变点结束坐标
        //     color0 启始颜色，color1 结束颜色
        float x0 = (float) getWidth() / 2;
        float y0 = 0;

        float x1 = getWidth();
        float y1 = (float) getHeight() / 3;

        int color0 = 0xffff0000;
        int color1 = 0xff00ff00;

//        /**
//         * 双色渐变
//         */
//        @SuppressLint("DrawAllocation")
//        LinearGradient linearGradient = new LinearGradient(x0, y0, x1, y1, color0, color1, Shader.TileMode.CLAMP);
//        mPaint.setShader(linearGradient);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        /**
         * 多色渐变
         */
        //参数：x0,y0渐变点的起始坐标，x1，y1 渐变点结束坐标  x0,y0 和 x1，y1 设置不同的值渐变效果不同
        //colors[]用于指定渐变颜色值的数组，颜色值同样必须使用0xffff0000 的十六进制
        //positions[] 与渐变颜色值 对应，取值范围 0~1 float 类型，表示每种颜色在整条渐变线中的百分比位置
        int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff};
        float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
        @SuppressLint("DrawAllocation")
        LinearGradient multiGradient = new LinearGradient(0, 0, getWidth()/2, getHeight()/2, colors, pos, Shader.TileMode.MIRROR);
        mPaint.setShader(multiGradient);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

//        /**
//         * 多色渐变文字
//         */
//        int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff};
//        float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
//        LinearGradient multiGradient = new LinearGradient(0, 0, getWidth()/2, getHeight()/2, colors, pos, Shader.TileMode.MIRROR);
//        mPaint.setShader(multiGradient);
//        mPaint.setTextSize(50);
//        canvas.drawText("欢迎关注启舰的blog", 0, getHeight()/2, mPaint);
    }


}
