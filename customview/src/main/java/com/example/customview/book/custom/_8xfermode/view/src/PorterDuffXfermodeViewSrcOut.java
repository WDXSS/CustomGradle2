package com.example.customview.book.custom._8xfermode.view.src;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PorterDuffXfermodeViewSrcOut extends View {
    private int width = 200;
    private int height = 200;
    private Paint mPaint;
    private Bitmap mDstBtm;//目标图像
    private Bitmap mSrcBtm; //源图像
    private Paint mPaintText;

    public PorterDuffXfermodeViewSrcOut(Context context) {
        this(context, null);
    }

    public PorterDuffXfermodeViewSrcOut(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PorterDuffXfermodeViewSrcOut(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mDstBtm = markDst();
        mSrcBtm = markSrc();

        mPaintText = new Paint();
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(30);
    }

    private Bitmap markDst() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);//黄色
        //绘制椭圆
        canvas.drawOval(new RectF(0, 0, width, height), paint);
        return bitmap;
    }

    private Bitmap markSrc() {
        //创建矩形 源图像
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //Paint.ANTI_ALIAS_FLAG 抗锯齿效果
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);//蓝色

        Canvas canvas = new Canvas(bitmap);
        //绘制矩形
        canvas.drawRect(0, 0, width, height, paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("PorterDuff.Mode.SRC_OUT ",  10, height *2, mPaintText);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //画出 目标图
        canvas.drawBitmap(mDstBtm, 0, 0, mPaint);
        //设置混合图像 xfermode
        @SuppressLint("DrawAllocation")
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        mPaint.setXfermode(porterDuffXfermode);

        //画出 源图像
        canvas.drawBitmap(mSrcBtm,  width / 2, height / 2, mPaint);
        //讲Paint 的xfermode设置为null
        mPaint.setXfermode(null);

        //恢复
        canvas.restoreToCount(layerId);


    }
}
