package com.example.customview.book.custom._9canvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.jetpack.DevDescribe;

@DevDescribe("canvas save 函数的 flag")
public class Matrix_save_flag_View extends View {
    private Paint mPaint;
    public Matrix_save_flag_View(Context context) {
        this(context, null);
    }

    public Matrix_save_flag_View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Matrix_save_flag_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

        mPaint.setColor(Color.GREEN);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //新的api 不支持
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
//        canvas.saveLayer()
    }
}
