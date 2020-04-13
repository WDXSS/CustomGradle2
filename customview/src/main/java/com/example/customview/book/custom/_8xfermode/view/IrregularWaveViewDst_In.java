package com.example.customview.book.custom._8xfermode.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("区域不规则波纹 通过DST_IN 模式来实现")
public class IrregularWaveViewDst_In extends View {
    private int mItemWaveLength;//设置目标图像移动的长度
    private Bitmap mBtmSrc;
    private Bitmap mBtmDst;
    private Paint mPaint;
    private int mDx;

    public IrregularWaveViewDst_In(Context context) {
        this(context, null);
    }

    public IrregularWaveViewDst_In(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        //原理：
        // 1. [Sa*Da, Sa*Dc] 根据公式可以得出，当源图不透明时，则目标图像显示；反之源图像透明时，目标图像不显示;
        // 2. 绘制圆形遮罩（源图像）
        // 3. 将波纹图片从左向右移动(目标图像)
        // 4. 根据xfermode 合成模式选用 DST_IN 模式
        // 5. 截取指定位置的图像，放在指定的位置上 ---- canvas.drawBitmap(mBtmDst, src, dst, mPaint);
    }

    public IrregularWaveViewDst_In(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //取消硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //源图像
        mBtmSrc = BitmapFactory.decodeResource(getResources(), R.mipmap.circle_shape);
        //目标图像
        mBtmDst = BitmapFactory.decodeResource(getResources(), R.mipmap.wave_bg);
        //减去一个 源图像的长度
        mItemWaveLength = mBtmDst.getWidth() - mBtmSrc.getWidth();
        createAnim();
    }

    private void createAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength );
        animator.setDuration(4000);
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

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //先画上圆形
        canvas.drawBitmap(mBtmSrc, 0, 0, mPaint);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);
        //绘制 目标图像 设置开始的位置
        //截取波纹上 new Rect(mDx, 0, mDx + mBtmSrc.getWidth(), mBtmSrc.getHeight()) 这个矩形的位置，将其画在 mBtmSrc 的位置 new Rect(0, 0, mBtmSrc.getWidth(), mBtmSrc.getHeight())
        Rect src = new Rect(mDx, 0, mDx + mBtmSrc.getWidth(), mBtmSrc.getHeight());
        Rect dst = new Rect(0, 0, mBtmSrc.getWidth(), mBtmSrc.getHeight());
        //截取波纹图像上 src 位置的矩形，将其放在 btmSrc 图像的dst矩形位置上
        canvas.drawBitmap(mBtmDst, src, dst, mPaint);
        //[Sa*Da, Sa*Dc]  当源图像不透明，显示目标图像
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(mBtmSrc, 0, 0, mPaint);

        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
