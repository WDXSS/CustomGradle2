package com.example.customview.book.custom._8xfermode.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.customview.R;

/**
 * Created by qijian on 17/2/13.
 */
public class IrregularWaveViewBook extends View {

    private Paint mPaint;
    private int mItemWaveLength = 0;
    private int dx = 0;

    private Bitmap BmpSRC, BmpDST;

    public IrregularWaveViewBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        BmpDST = BitmapFactory.decodeResource(getResources(), R.mipmap.wave_bg, null);
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.mipmap.circle_shape, null);
        mItemWaveLength = BmpDST.getWidth();

        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        //先画上圆形
        canvas.drawBitmap(BmpSRC, 0, 0, mPaint);
        //再画上结果
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(BmpDST, new Rect(dx, 0, dx + BmpSRC.getWidth(), BmpSRC.getHeight()), new Rect(0, 0, BmpSRC.getWidth(), BmpSRC.getHeight()), mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(BmpSRC, 0, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }


    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(4000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}

