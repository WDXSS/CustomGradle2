package com.example.customview.book.custom._7paint.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("setShadowLayer 只对文字绘制阴影支持硬件加速，其他的都不支持硬件加速")
public class ShadowLayerView extends View {
    private Paint mPaint = new Paint();
    private Bitmap mDogBmp;
    private int mRadius = 1, mDx = 10, mDy = 10;
    private boolean mSetShadow = true;

    public ShadowLayerView(Context context) {
        super(context);
        init();
    }

    public ShadowLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowLayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(25);
        mDogBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
    }


    public void changeRadius() {
        mRadius++;
        postInvalidate();
    }

    public void changeDx() {
        mDx += 5;
        postInvalidate();
    }

    public void changeDy() {
        mDy += 5;
        postInvalidate();
    }

    public void setShadow(boolean showShadow) {
        mSetShadow = showShadow;
        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if (mSetShadow) {
            //参数：
//            float radius,模糊半径
//            float dx, 模糊横向偏移距离
//            float dy,
//            int shadowColor  //绘制阴影的颜色， 对图片无效，因为图片是将图片复制出来一份，模糊复制出来图片的边缘
            mPaint.setShadowLayer(mRadius, mDx, mDy, Color.GRAY);
        } else {
            //清除阴影
            mPaint.clearShadowLayer();
        }
        canvas.drawText("启舰", 100, 100, mPaint);
        canvas.drawCircle(200, 200, 50, mPaint);

        canvas.drawBitmap(mDogBmp, null, new Rect(200, 300, 200 + mDogBmp.getWidth(), 300 + mDogBmp.getHeight()), mPaint);
    }
}
