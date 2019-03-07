package com.example.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 绘制蜘蛛网
 *<img width="640" height="310" src="mipmap-xxxhdpi/spider_view.png">
 * 注意点：
 * 1.角度，是弧度
 */
public class SpiderView extends View {

    private Paint mTextPaint;
    private Paint mPolygonPaint;//多边形
    private int centerX;
    private int centerY;
    private float radius;//网格的最大半径，取值为 宽|高 的 90%
    private int polygonCount = 6;//绘制6个顶点
    private int strataCount = 5;//雷达网的层数
    //    private int angle = 60;
    //弧度，不是角度
    private float angle = (float) (Math.PI * 2 / polygonCount);

    private Paint mLinePaint;//链接线
    private Paint mRegionPaint;//数据区的画笔


    public SpiderView(Context context) {
        super(context);
    }

    public SpiderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SpiderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStrokeWidth(3);
        mTextPaint.setTextSize(40);

        mPolygonPaint = new Paint();
        mPolygonPaint.setColor(Color.WHITE);
        mPolygonPaint.setStyle(Paint.Style.STROKE);
        mPolygonPaint.setStrokeWidth(3);

        mLinePaint = new Paint();
        mLinePaint.setColor(Color.YELLOW);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(3);


        mRegionPaint = new Paint();
        mRegionPaint.setColor(Color.GRAY);
        mRegionPaint.setAlpha(127);
        mRegionPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mRegionPaint.setStrokeWidth(3);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //修改布局中心点
        centerX = w / 2;
        centerY = h / 2;
        radius = (float) (Math.min(centerX, centerY) * 0.9);
        postInvalidate();
        super.onSizeChanged(centerX, centerY, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);//多层多边形
        drawLine(canvas);//链接中心点和顶点
        drawRegion(canvas);//数据区
    }

    //绘制六边形 绘制五个六变形
    private void drawPolygon(Canvas canvas) {
        //画出中心点
        canvas.drawPoint(centerX, centerY, mPolygonPaint);
        Path path = new Path();//划线

        for (int j = 1; j <= strataCount; j++) {
            float radius = (this.radius * j) / strataCount; //计算半径
            for (int i = 0; i < polygonCount; i++) {
                //Math.cos(弧度，不是角度)
                float x = (float) (radius * Math.cos(angle * i)) + centerX; //第一个点的x坐标
                float y = (float) (radius * Math.sin(angle * i)) + centerY; //第一个点的y坐标
//            canvas.drawPoint(x, y, mPolygonPaint);
                if (i == 0) {
                    path.moveTo(x, y);//设置起点
                    canvas.drawText(j + "", x, y, mTextPaint);
                } else {
                    path.lineTo(x, y);//下一个点
                }

                if (j == strataCount) {
                    canvas.drawText("努力 " + i, x, y, mTextPaint);
                }
            }
            path.close();//闭合链接点
        }
        canvas.drawPath(path, mPolygonPaint);
    }

    private void drawLine(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < polygonCount; i++) {
            //Math.cos(弧度，不是角度)
            path.reset();//清空数据
            path.moveTo(centerX, centerY);
            float x = (float) (radius * Math.cos(angle * i)) + centerX; //第一个点的x坐标
            float y = (float) (radius * Math.sin(angle * i)) + centerY; //第一个点的y坐标
            path.lineTo(x, y);//下一个点
            path.close();
            canvas.drawPath(path, mLinePaint);
        }
    }

    //绘制数据区域：六个方向取值范围是1-6；

    private void drawRegion(Canvas canvas) {
        int[] data = {4, 4, 5, 3, 6, 1};

        Path path = new Path();
        for (int i = 0; i < polygonCount; i++) {
            float radius = this.radius * data[i] / 6;//计算半径
            //计算x点
            float x = (float) (radius * Math.cos(angle * i)) + centerX;
            float y = (float) (radius * Math.sin(angle * i)) + centerY;
            if (i == 0) {
                path.moveTo(x, y); //起点
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 10, mRegionPaint);
        }
        path.close();
        canvas.drawPath(path, mRegionPaint);
    }
}
