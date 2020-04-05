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

@DevDescribe("使用二阶贝济埃曲线绘制手势轨迹")
public class BezierGestureTrackView extends View {
    private Paint mPaint;
    private Path mPath;
    private float mPreX;
    private float mPreY;

    public BezierGestureTrackView(Context context) {
        this(context, null);
    }

    public BezierGestureTrackView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierGestureTrackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                float endX = (mPreX + event.getX()) / 2;
                float endY = (mPreY + event.getY()) / 2;
                //上一个点作为控制点
                mPath.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
            }
            break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);
    }
}
