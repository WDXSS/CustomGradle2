package com.example.customview.book.custom._8xfermode.view.src;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PorterDuffXfermodeViewSrcIn extends View {
    private int width = 200;
    private int heigth = 200;
    private Paint mPaint;
    private Bitmap mDstBtm;
    private Bitmap mSrcBtm;
    private Paint mPaintText;

    public PorterDuffXfermodeViewSrcIn(Context context) {
        this(context, null);
    }

    public PorterDuffXfermodeViewSrcIn(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PorterDuffXfermodeViewSrcIn(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mDstBtm = markDst();
        mSrcBtm = markSrc();

        mPaintText = new Paint();
        mPaintText.setTextSize(30);
    }

    private Bitmap markDst() {
        //创建 目标图像
        Bitmap bitmap = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);

        Canvas canvas = new Canvas(bitmap);
        //绘制椭圆
        canvas.drawOval(new RectF(0, 0, width, heigth), paint);
        return bitmap;
    }

    private Bitmap markSrc() {
        //创建矩形 源图像
        Bitmap bitmap = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);
        //Paint.ANTI_ALIAS_FLAG 抗锯齿效果
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);

        Canvas canvas = new Canvas(bitmap);
        //绘制矩形
        canvas.drawRect(0, 0, width, heigth, paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("PorterDuff.Mode.SRC_IN ",  10, heigth + 50, mPaintText);
        //保存状态
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        //设置目标图像 （圆形图）
        canvas.drawBitmap(mDstBtm, 0, 0, mPaint);

        //设置混合 xfermode
        @SuppressLint("DrawAllocation")
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(porterDuffXfermode);
        //设置源图（矩形图）
        canvas.drawBitmap(mSrcBtm, width / 2, heigth / 2, mPaint);
        mPaint.setXfermode(null);//paint 设置Xfermode为空

        canvas.restoreToCount(layerId);

//        //説明：
//        在Xfermode 设置之前画出的图像叫做 目标图像，即给谁应用xfermode;
//        在xfermode 设置之后画出的图像叫作 源图像，即拿什么应用xfermode；
    }
}
