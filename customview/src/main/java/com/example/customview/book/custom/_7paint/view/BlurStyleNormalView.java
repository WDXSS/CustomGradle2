package com.example.customview.book.custom._7paint.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("BlurMaskFilter -- 发光的样式")
public class BlurStyleNormalView extends View {
    private Paint mPaint;

    public BlurStyleNormalView(Context context) {
        this(context, null);
    }

    public BlurStyleNormalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurStyleNormalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL);
        mPaint.setMaskFilter(blurMaskFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,200,100,mPaint);
    }
}
