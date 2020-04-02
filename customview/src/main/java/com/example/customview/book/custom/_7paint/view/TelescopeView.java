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
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("放大镜效果")
public class TelescopeView extends View {


    private Matrix mMatrix;
    private BitmapShader mBitmapShader;
    private Paint mPaint;
    private Bitmap mSrcBitmap;
    private int mDx = -1;
    private int mDY = -1;

    public TelescopeView(Context context) {
        this(context, null);
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void init() {

        if (mSrcBitmap == null) {
            mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_edge);
            int srcWidth = mSrcBitmap.getWidth();
            int srcHeight = mSrcBitmap.getHeight();
            float scaleX = (float) getWidth() / srcWidth;
            float scaleY = (float) getHeight() / srcHeight;

            mMatrix = new Matrix();
            mMatrix.setScale(scaleX, scaleY);
            //构建 shader
            mBitmapShader = new BitmapShader(mSrcBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            //缩放BitmapShader 1.可以通过创建和view相同大小的bitmap，2.也可以使用Matrix
            mBitmapShader.setLocalMatrix(mMatrix);

            //构建 paint
            mPaint = new Paint();
            mPaint.setShader(mBitmapShader);
            //--------------------------------------------------------------

//            //缩放BitmapShader  1.可以通过创建和view相同大小的bitmap，
//            Bitmap shaderBitmap = Bitmap.createScaledBitmap(mSrcBitmap, getWidth(), getHeight(), true);
//            mBitmapShader = new BitmapShader(shaderBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//            mPaint = new Paint();
//            mPaint.setShader(mBitmapShader);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        //初始化：因为在构造方法中不能得到  getHeight()和 getWidth()


//        //没有设置和View相同大小 (直接使用 源图)
//        canvas.drawBitmap(mSrcBitmap,0,0,null);

//        绘制显示区域大小和View大小相同 （使用的 bitmapShader）
//        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        //绘制指定大小区域
//        canvas.drawCircle(0, 0, 160, mPaint);

        //绘制 望远镜显示区域
        if (mDx != -1 && mDY != -1) {
            canvas.drawCircle(mDx, mDY, 160, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDx = (int) event.getX();
                mDY = (int) event.getY();
                postInvalidate();
                return true;// ACTION_DOWN 需要返回 true 消费掉事件
//                break;
            case MotionEvent.ACTION_MOVE:
                mDx = (int) event.getX();
                mDY = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mDx = -1;
                mDY = -1;
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
