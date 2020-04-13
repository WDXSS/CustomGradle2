package com.example.customview.book.custom._8xfermode.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过xfermode 中的 src_in 源图像显示模式：公式[Sa*Da,Sc*Dc] 当目标图像的透明时，源图像不显示，原理实现圆角")
public class RoundImageView_SRCIN extends View {

    private Bitmap mDstBtm;
    private Bitmap mSrcBtm;
    private Paint mPaint;

    public RoundImageView_SRCIN(Context context) {
        this(context, null);
    }

    public RoundImageView_SRCIN(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView_SRCIN(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //取消硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mDstBtm = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_shade);
        mSrcBtm = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);
        //绘制 目标图像
        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(mDstBtm, null, rectF, mPaint);
        //创建 Xfermode
        @SuppressLint("DrawAllocation")
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(porterDuffXfermode);
        //绘制 源图像
        canvas.drawBitmap(mSrcBtm, null, rectF, mPaint);

        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);

    }
}
