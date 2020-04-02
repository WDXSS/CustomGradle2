package com.example.customview.book.custom._7paint.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("不规则头像 通过 shader 和 canvas配合画图不规则头像")
public class AuthorView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private BitmapShader mBitmapShader;
    private Matrix mMatrix;

    public AuthorView(Context context) {
        this(context, null);
    }

    public AuthorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AuthorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mMatrix = new Matrix();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.avator);
        mPaint = new Paint();
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float scale = (float) getWidth() / mBitmap.getWidth();
        mMatrix.setScale(scale, scale);
        mBitmapShader.setLocalMatrix(mMatrix);
        mPaint.setShader(mBitmapShader);
        float half = (float) getWidth() / 2;
//        canvas.drawCircle(half, half, (float) getWidth() / 2, mPaint);
        canvas.drawRoundRect(0,0,getWidth(),getHeight(),100,100,mPaint);
    }
}
