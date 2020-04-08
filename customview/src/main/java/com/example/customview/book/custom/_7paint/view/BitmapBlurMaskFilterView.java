package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("给图片添加纯色阴影 原理：1.生成和原图一样大小的灰色副本，2.然后使用BlurMaskFilter 使其内外发光，3.然后偏移一定的距离形成阴影效果")
public class BitmapBlurMaskFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap, mAlphaBmp;

    private Paint mTextPaint;

    public BitmapBlurMaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat_dog);
        //抽出图片的 透明度
        mAlphaBmp = mBitmap.extractAlpha();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(20);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStrokeWidth(3);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = 300;
        int height = width * mAlphaBmp.getWidth() / mAlphaBmp.getHeight();

        //绘制阴影颜色
        mPaint.setColor(Color.GRAY);
        //参数：
//        float radius, 模糊半径，使用高斯模糊算法
//        Blur style  发光模式 Blur.INNER(内部发光)， Blur.SOLID(外部发光)，Blur.NORMAL(内外发光)，Blur.OUTER(仅显示发光效果)
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL);
        mPaint.setMaskFilter(blurMaskFilter);
        //绘制灰色副本
        canvas.drawBitmap(mAlphaBmp, null, new Rect(10, 10, width, height), mPaint);


        canvas.drawText("绘制的副本", 10, height + 50, mTextPaint);

        canvas.drawBitmap(mAlphaBmp, null, new Rect(10, height + 150, width, height + height + 150), mPaint);
        //绘制原图像
        canvas.translate(-5, -5);
        //把
        mPaint.setMaskFilter(null);
        canvas.drawBitmap(mBitmap, null, new Rect(0, 0, width, height), mPaint);
    }


}
