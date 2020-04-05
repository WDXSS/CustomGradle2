package com.example.customview.book.custom._7paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("通过path画手势轨迹")
public class NormalGestureTrackView extends View {

    private Paint mPaint;
    private Path mPath;

    public NormalGestureTrackView(Context context) {
        this(context, null);
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布颜色
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mPath.moveTo(event.getX(), event.getY());
                //注意：MotionEvent.ACTION_DOWN 返回true ，表示down事件消费掉事件
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                postInvalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
