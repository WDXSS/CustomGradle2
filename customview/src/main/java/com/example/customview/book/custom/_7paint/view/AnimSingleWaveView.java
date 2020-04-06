package com.example.customview.book.custom._7paint.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("动态 波浪线：二阶贝济埃曲线 + 属性动画 画一个波长")
public class AnimSingleWaveView extends View {

    private Paint mPaint;
    private Path mPath;
    private int mItemWaveLength = 400;
    private int mDx;

    public AnimSingleWaveView(Context context) {
        this(context, null);
    }

    public AnimSingleWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimSingleWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);
        mPath = new Path();
        createAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        //重置路径
        mPath.reset();
        int halfWaveWith = mItemWaveLength / 2;
        int quarter = halfWaveWith / 2;
        mPath.moveTo(mDx, 200);
        mPath.rQuadTo(quarter, -quarter, halfWaveWith, 0);
        mPath.rQuadTo(quarter, quarter, halfWaveWith, 0);
//        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    private void createAnim(){
        //通过path.moveTo()函数移动起始点位置，实现动画
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
