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

import com.example.jetpack.DevDescribe;

@DevDescribe("xfermode 模式中的 atop 它的图像和 src_in 一样 ;" +
        "atop计算公式：  [Da, Sc*Da + (1-Sa)*Dc] " +
        "src_in计算公式：[Sa*Da, Sc*Da]")
public class PorterDuffXfermodeViewSrcAtop extends View {

    private int width = 200;
    private int height = 200;
    private Bitmap mDstBtm;
    private Bitmap mSrcBtm;
    private Paint mPaint;
    private Paint mPaintText;

    public PorterDuffXfermodeViewSrcAtop(Context context) {
        this(context, null);
    }

    public PorterDuffXfermodeViewSrcAtop(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PorterDuffXfermodeViewSrcAtop(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setTextSize(30);

        mDstBtm = maskDst();
        mSrcBtm = maskSrc();

    }

    private Bitmap maskDst(){
        //绘制目标图像(带有透明度的bitmap)
        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(bitmap);
        //创建画笔，准备作画
        Paint paint = new Paint();
        paint.setColor(0xFFFFCC44);//黄色
        //开始作画 ,圆形
        canvas.drawOval(new RectF(0,0,width,height),paint);
        return bitmap;
    }
    private Bitmap maskSrc(){
        //绘制源图像(带有透明度的bitmap)
        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(bitmap);
        //创建画笔，准备作画
        Paint paint = new Paint();
        paint.setColor(0xFF66AAFF);//蓝色
        //绘制矩形
        canvas.drawRect(0, 0, width, height, paint);
        return bitmap;
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文字
        canvas.drawText("PorterDuff.Mode.SRC_ATOP ", 10, height * 2, mPaintText);
        int layerId = canvas.saveLayer(0,0,getWidth(),getHeight(),null);
        //将目标图像绘制到画布上
        canvas.drawBitmap(mDstBtm,0,0,mPaint);

        //画笔添加 xfermode
        PorterDuffXfermode porterDuffXfermode =new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        mPaint.setXfermode(porterDuffXfermode);

        //将 源图像绘制到画布上
        canvas.drawBitmap(mSrcBtm,width>>1,height>>1,mPaint);

        //将Paint的xfermode设置为Null
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
