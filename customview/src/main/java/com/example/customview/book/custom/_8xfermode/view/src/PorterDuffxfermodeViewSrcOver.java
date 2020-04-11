package com.example.customview.book.custom._8xfermode.view.src;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("源图像模式之Src_Over:当源图像的透明度为100%时，原样显示源图像")
public class PorterDuffxfermodeViewSrcOver extends View {
    private int width = 200;
    private int height = 200;
    private Bitmap mDstBtm;
    private Bitmap mSrcBtm;
    private Paint mPaint;
    private Paint mPaintText;

    public PorterDuffxfermodeViewSrcOver(Context context) {
        this(context, null);
    }

    public PorterDuffxfermodeViewSrcOver(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PorterDuffxfermodeViewSrcOver(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mDstBtm = maskDst();
        mSrcBtm = maskSrc();
        mPaint = new Paint();

        mPaintText = new Paint();
        mPaintText.setTextSize(30);
    }

    private Bitmap maskDst() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //Paint.ANTI_ALIAS_FLAG 抗锯齿效果
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);
        canvas.drawOval(0, 0, width, height, paint);
        return bitmap;
    }

    private Bitmap maskSrc() {
        //创建矩形 源图像
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //Paint.ANTI_ALIAS_FLAG 抗锯齿效果
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);

        Canvas canvas = new Canvas(bitmap);
        //绘制矩形
        canvas.drawRect(0, 0, width, height, paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //输出文字
        canvas.drawText("PorterDuff.Mode.SRC_OVER ", 10, height * 2, mPaintText);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //绘制目标图像
        canvas.drawBitmap(mDstBtm, 0, 0, mPaint);
        //创建Xfermode
        @SuppressLint("DrawAllocation")
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        //paint 设置 xfermode
        mPaint.setXfermode(porterDuffXfermode);
        //设置源图像
        canvas.drawBitmap(mSrcBtm, (float) width / 2, (float) height / 2, mPaint);
        //设置paint 的xfermode为null
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);
    }
}
