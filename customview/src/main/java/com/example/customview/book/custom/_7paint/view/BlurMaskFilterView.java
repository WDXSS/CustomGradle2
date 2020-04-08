package com.example.customview.book.custom._7paint.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BlurMaskFilterView extends View {

    private int margin = 50;

    private Paint mRectPaint;

    public BlurMaskFilterView(Context context) {
        this(context, null);
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mRectPaint = new Paint();
//        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.GREEN);
        //参数：
//        float radius, 模糊半径，使用高斯模糊算法
//        Blur style  发光模式 Blur.INNER(内部发光)， Blur.SOLID(外部发光)，Blur.NORMAL(内外发光)，Blur.OUTER(仅显示发光效果)
        BlurMaskFilter rectBlurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL);
        mRectPaint.setMaskFilter(rectBlurMaskFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(margin, margin, 250, 250, mRectPaint);
    }
}
