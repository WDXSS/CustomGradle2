package com.example.customview.book.custom._7paint.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("Shader 是从控件的左上角开始，和绘图函数（canvas.drawRect()）设置的位置大小无关")
public class BitmapShaderView extends View {
    private static final String TAG = "BitmapShaderView";
    private Paint mPaint;
    private Bitmap mBitmap;

    public BitmapShaderView(Context context) {
        this(context, null);
    }


    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_edge);
//        new BitmapShader( Bitmap bitmap,  TileMode tileX,  TileMode tileY)
//        参数：
//        TileMode tileX  X轴的复用策略
//        TileMode tileY  Y轴的复用策略
//        复用策略：先绘制Y轴，再绘制X轴
//        Shader.TileMode.CLAMP;复用策略使用边缘填充
//        Shader.TileMode.REPEAT ; 复用原图填充
//        Shader.TileMode.MIRROR; 镜像模式来填充多余空间
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mPaint.setShader(bitmapShader);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: getWidth() =" + getWidth() + ",getHeight() = " + getHeight());
        //绘图取view相同的大小
//        canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), mPaint);

        //getWidth()用于获取控件宽度，getHeight()用于获取控件高度

        //在绘图时，不完全覆盖控件大小，取控件中间位置的1/3 区域开始绘制
        //结论:
        // 1.无论利用绘图函数(canvas.drawRect())绘制多大的图，在哪里绘制 都与Shader无关，
        // 2.Shader 总是是控件的左上角开始，而我们绘制的只是显示出来的一部分，没有绘制的部分已经存在，只是没有显示出来
        float left = getWidth() / 3;
        float top = getHeight() / 3;
        float right = getWidth() * 2 / 3;
        float bottom = getHeight() * 2 / 3;
        //
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
