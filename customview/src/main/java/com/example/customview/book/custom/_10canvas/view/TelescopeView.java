package com.example.customview.book.custom._10canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;

public class TelescopeView extends View {


    private Bitmap mSrcBitmap;
    private Bitmap mBitmap;
    // 放大镜的半径
    private static final int RADIUS = 160;
    // 放大倍数
    private static final int FACTOR = 3;
    private ShapeDrawable mShapeDrawable;
    private Matrix mMatrix = new Matrix();//matrix 将

    public TelescopeView(Context context) {
        this(context, null);
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        init();
        canvas.drawBitmap(mBitmap, 0, 0, null);
        mShapeDrawable.draw(canvas);
    }

    private void init() {
        if (mSrcBitmap == null) {
            mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_telescope);
            //参数：filter 是否给图像添加滤波效果。true 能够减少图像中由于噪声引起的突兀的孤立像素点或像素块
            //将图片设置成和控件相同大小
            //构造方法时获取不到 getWidth()
            mBitmap = Bitmap.createScaledBitmap(mSrcBitmap, getWidth(), getHeight(), false);

            //将原图放大 3倍 ，用于bitmapShader
            Bitmap scaleBitmap = Bitmap.createScaledBitmap(mSrcBitmap, getWidth() * FACTOR, getHeight() * FACTOR, true);
            BitmapShader bitmapShader = new BitmapShader(scaleBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

            //构建椭圆的放大镜
            OvalShape ovalShape = new OvalShape();
            mShapeDrawable = new ShapeDrawable(ovalShape);

            mShapeDrawable.setBounds(getWidth()-RADIUS * 2, getHeight()-RADIUS * 2, getWidth(), getHeight());

            //获取ShapeDrawable 中的 paint 设置 shader； Shader 是从ShapeDrawable 的左上角开始绘制的，这个很重要
            mShapeDrawable.getPaint().setShader(bitmapShader);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        int scaleX = x * FACTOR;//屏幕上点击的坐标是 (x,y) 通过缩放因子对应在shader的位置是(x*FACTOR, y*FACTOR)
        int scaleY = y * FACTOR;

        //移动 bitmapShader 到(scaleX,scaleY), 因为 shader 绘制是从 ShapeDrawable 的左上角开始，
        //为了是放大后的bitmapShader的中心点位于，手指点击的位置，需要移动bitmapShader
        //1. 为了将点击的点作为中心（x,y）需要将 bitmapShader 向左上方向移动 ,因为bitmapShader 移动的方向是左，上所以是负值 -scaleX，-scaleY 点击的位于shapeDrawable 的座上角
        //2在向右下移动 一个半径的距离
        int shaderX = -scaleX + RADIUS;
        int shaderY = -scaleY + RADIUS;
        //绘制的起始位置
        mMatrix.setTranslate(shaderX, shaderY);
        mShapeDrawable.getPaint().getShader().setLocalMatrix(mMatrix);

        //设置ShapeDrawable 边距
        mShapeDrawable.setBounds(x - RADIUS, y - RADIUS, x + RADIUS, y + RADIUS);
        invalidate();

        return true;
    }
}
