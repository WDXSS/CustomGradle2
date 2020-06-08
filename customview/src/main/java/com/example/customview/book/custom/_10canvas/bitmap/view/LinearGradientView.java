package com.example.customview.book.custom._10canvas.bitmap.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 16/9/27.
 */
public class LinearGradientView extends View {
    private Bitmap mDestBmp;
    private Paint mPaint;
    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        mPaint = new Paint();

        int width = 500;
        int height = 300;
        mDestBmp = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(mDestBmp);
        Paint paint = new Paint();
        LinearGradient linearGradient = new LinearGradient(width/2,0,width/2,height,0xffffffff,0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.drawRect(0,0,width,height,paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mDestBmp,0,0,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawRect(0,0,mDestBmp.getWidth(),mDestBmp.getHeight(),mPaint);
    }
}
