package com.example.customview.book.custom._8xfermode.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("Dst_IN 模式公式：[Sa*Da, Sa*Dc] 根据公式可以得出，当源图不透明时，则目标图像显示；反之源图像透明时，目标图像不显示")
public class TextWaveViewDst_IN extends View {
    //设置一个周期的波长长度
    private int mItemWaveLength = 1000;
    private Path mPath;
    private Paint mPathPaint;
    private int mDx;

    private Bitmap mSrcBtm;
    private Bitmap mDstBit;
    private Paint mPaint;

    public TextWaveViewDst_IN(Context context) {
        this(context, null);
    }

    public TextWaveViewDst_IN(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        //原理：
        // 1. [Sa*Da, Sa*Dc] 根据公式可以得出，当源图不透明时，则目标图像显示；反之源图像透明时，目标图像不显示;
        // 2. 通过贝济埃曲线绘制波纹，、
        // 3. 通过移动波纹起点的位置，实现动画效果
        // 4. 根据xfermode 合成模式选用 DST_IN 模式
        // 5. 注意在绘制 目标图像时，是在同一个bitmap上，注意要清空 bitmap
        // 6. 注意在缓存之前在，画布上绘制出默认文字
    }

    public TextWaveViewDst_IN(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //取消硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPath = new Path();

        mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPathPaint.setColor(Color.GREEN);
        mPathPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        starAnim();
        //[Sa*Da, Sa*Dc] 根据公式可以得出，当源图不透明时，则目标图像显示；反之源图像透明时，目标图像不显示;
        //所以源图像的，除了文字是不透明的，其他都是透明的
        mSrcBtm = BitmapFactory.decodeResource(getResources(), R.mipmap.text_shade);
        //绘制和源图像相同大小的 目标图像
        mDstBit = Bitmap.createBitmap(mSrcBtm.getWidth(), mSrcBtm.getHeight(), Bitmap.Config.ARGB_8888);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @DevDescribe("将生成的波纹画在图像上 绘制的波纹为目标图像")
    private void generateWavePath() {
        mPath.reset();
        //波纹的Y起点，设置为View高度的一半
        int originY = mSrcBtm.getHeight() / 2;
        int halfWaveLen = mItemWaveLength / 2;

        //这里使用二阶贝济埃曲线画出波形
        mPath.moveTo(-mItemWaveLength + mDx, originY);
        for (int i = -mItemWaveLength; i < getWidth() + mItemWaveLength; i += mItemWaveLength) {
            //画出一个波长
            //这里使用贝济埃曲线的 移动距离函数
            mPath.rQuadTo((float) halfWaveLen / 2, 50, halfWaveLen, 0);
            mPath.rQuadTo((float) halfWaveLen / 2, -50, halfWaveLen, 0);
        }

        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
    }

    private void starAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mItemWaveLength);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //动画移动距离
                mDx = (int) animation.getAnimatedValue();
                //重新绘制
                invalidate();
            }
        });
        valueAnimator.start();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将波纹画在空白图像上
        generateWavePath();
        Canvas dstCanvas = new Canvas(mDstBit);
        //由于每次都是在 mDstBit 绘制波纹，所以需要先清空一下
        dstCanvas.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);
        dstCanvas.drawPath(mPath, mPathPaint);

        //将文字绘制到canvas 上
        canvas.drawBitmap(mSrcBtm,null, new RectF(0, 0, getWidth(), getHeight()), mPaint);
//        canvas.drawBitmap(mSrcBtm, 0, 0, mPaint);

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);
        //绘制 目标图像 (大小和View相同大小)
        canvas.drawBitmap(mDstBit, null, new RectF(0, 0, getWidth(), getHeight()), mPaint);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        mPaint.setXfermode(porterDuffXfermode);
        //绘制源图像
        canvas.drawBitmap(mSrcBtm, null, new RectF(0, 0, getWidth(), getHeight()), mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
