package com.example.book._5view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 多点触控 实例：追踪第2根手指
 */
public class MultiTouchViewJava extends View {

    private static final String TAG = "MultiTouchViewJava";
    //用于判断第二个手指是否存在
    private boolean hasSecondPoint = false;
    //用于记录第二根手指位置
    private PointF mPointF = new PointF(0, 0);
    private Paint mDefaultPaint = new Paint();

    public MultiTouchViewJava(Context context) {
        super(context);
        init();
    }

    public MultiTouchViewJava(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiTouchViewJava(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDefaultPaint.setColor(Color.WHITE);
        mDefaultPaint.setAntiAlias(true);
        mDefaultPaint.setTextAlign(Paint.Align.CENTER);
        mDefaultPaint.setTextSize(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();// 获取当前活动 手指的index
        // event.getActionMasked() 多点触摸 用event.getActionMasked() 获取事件
        Log.d(TAG, "onTouchEvent: index = " + index);

        for (int i = 0; i < event.getPointerCount(); i++) {
            Log.d(TAG, "onTouchEvent: 每个手指的 id = " + event.getPointerId(i));
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //手指1按下时会触发
                Log.d(TAG, "onTouchEvent: 第一根手指按下");

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                //手指 2,3....按下时会触发
                Log.d(TAG, "onTouchEvent: 又一根手指按下");
                if (event.getPointerId(index) == 1) {
                    //通过 index 获取到 手指的id 如果等于 1 说明是 第2个手指, index 是变化的，PointId 是不变的
                    hasSecondPoint = true;
                    mPointF.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //非最后一个手指抬起
                Log.d(TAG, "onTouchEvent: 又一个手指抬起");
                if (event.getPointerId(index) == 1) {
                    hasSecondPoint = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                //最后一个手指抬起时触发
                Log.d(TAG, "onTouchEvent: 最后一个手指抬起");
                hasSecondPoint = false;
                break;

            case MotionEvent.ACTION_MOVE:
                try {
                    if (hasSecondPoint) {
                        int twoPointIndex = event.findPointerIndex(1);
                        mPointF.set(event.getX(twoPointIndex), event.getY(twoPointIndex));
                    }
                } catch (Exception e) {
                    hasSecondPoint = false;
                }

                break;
        }
        invalidate();//重新绘制view
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        if (hasSecondPoint) {
            canvas.drawCircle(mPointF.x, mPointF.y, 50, mDefaultPaint);
        }
        canvas.save();
        canvas.translate(getMeasuredWidth()/2,getMeasuredHeight()/2);
        canvas.drawText("追踪第二个手指的位置",0,0,mDefaultPaint);
        canvas.restore();
    }
}
