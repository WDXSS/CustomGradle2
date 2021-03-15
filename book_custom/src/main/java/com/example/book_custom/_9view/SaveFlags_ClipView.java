package com.example.book_custom._9view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.book_custom.DevDescribe;

@DevDescribe("SaveFlags 中的 ")
public class SaveFlags_ClipView extends View {
    private Paint mPaint;
    public SaveFlags_ClipView(Context context) {
        this(context, null);
    }

    public SaveFlags_ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public SaveFlags_ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        //保存画布并设置flag 为 clip_save_flag
        canvas.save();
        //裁剪画布
        canvas.clipRect(100,0,200,100);
        //恢复画布，
        canvas.restore();
        //将画布染成黄色
        canvas.drawColor(Color.YELLOW);
    }
}
