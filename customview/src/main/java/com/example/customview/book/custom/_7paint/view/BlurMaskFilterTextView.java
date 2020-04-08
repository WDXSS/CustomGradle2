package com.example.customview.book.custom._7paint.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class BlurMaskFilterTextView extends androidx.appcompat.widget.AppCompatTextView {

  private Paint mPaint;

    public BlurMaskFilterTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = getPaint();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        @SuppressLint("DrawAllocation")
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID);
        mPaint.setMaskFilter(blurMaskFilter);
        super.onDraw(canvas);

    }
}
