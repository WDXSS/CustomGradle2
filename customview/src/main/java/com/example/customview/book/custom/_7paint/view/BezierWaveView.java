package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("绘制贝济埃曲线 二街曲线")
public class BezierWaveView extends View {
    private Paint mPaint;
    private Path mPath;

    public BezierWaveView(Context context) {
        this(context, null);
    }

    public BezierWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mPath = new Path();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //path 绘制二阶贝济埃曲线的方法1. path.quadTo(); 2.rQuadTo();
        //path.quadTo() 参数表示是 控制点和终点的坐标

        //path.rQuadTo() 参数表示是:现对于上一个终点x坐标的位移坐标，
        // 例如 :上一个终点的坐标(300,400),利用path.rQuadTo(100,-100,200,100);
        // 得到的控制点(300+100,400-100), 终点坐标(300+200,400+100)

//        //moveTo 移动起始点位置 （View 中的相对位置）
//        path.moveTo(100,300);
//        //quadTo()参数：x1, y1, x2, y2 （x1,y1）是控制点，（x2,y2）终点坐标
//        path.quadTo(200,200,300,300);
//        path.quadTo(400, 400, 500, 300);
//        canvas.drawPath(path, mPaint);


        mPath.moveTo(100, 300);
        mPath.rQuadTo(100, -100, 200, 0);
        mPath.rQuadTo(100, 100, 200, 0);
        canvas.drawPath(mPath, mPaint);
    }
}
