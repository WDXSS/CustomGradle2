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
public class SaveFlags_ClipView2 extends View {
    private Paint mPaint;
    public SaveFlags_ClipView2(Context context) {
        this(context, null);
    }

    public SaveFlags_ClipView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public SaveFlags_ClipView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        canvas.drawText("理解Canvas.CLIP_SAVE_FLAG", 250,100,mPaint);

        mPaint.setColor(Color.GRAY);
        //首先在固定位置绘制灰色的矩形，
        canvas.drawRect(100,0,200,100,mPaint);
        //保存画布并设置flag 为 clip_save_flag
        canvas.save(Canvas.CLIP_SAVE_FLAG);
        //将画布旋转 40
        canvas.rotate(40);
        //恢复画布，
        canvas.restore();
        //重新设置画笔颜色为黑色，相同的位置绘制黑色矩形
        mPaint.setColor(Color.RED);
        canvas.drawRect(100,0,200,100,mPaint);
        canvas.drawText("理解Canvas.CLIP_SAVE_FLAG", 250,100,mPaint);
    }
}
