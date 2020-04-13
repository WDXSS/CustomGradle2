package com.example.customview.book.custom._8xfermode.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("通过src_out 实行橡皮擦效果：" +
        "原理：目标图像的透明度等于100%，与源图相交的区域显示空白即背景颜色" +
        "src_out 公式：[Sa*(1 - Da), Sc*(1 - Da)]")

public class EraserSrcOutViewV2 extends View {

    private Path mPath;
    private Paint mPathPaint;
    private float mPreX;
    private float mPreY;
    private Bitmap mDstBitmap;
    private Bitmap mSrcBitmap;
    private Bitmap mTextBitmap;
    private Canvas mDstCanvas;

    private Paint mCanvasPaint;

    public EraserSrcOutViewV2(Context context) {
        this(context, null);
    }

    public EraserSrcOutViewV2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EraserSrcOutViewV2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        //原理：根据手势的轨迹将对应的位置小狗图像进行隐藏，所以小狗图像是源图像，
        // 将手势做的图像作为目标图像
        mCanvasPaint = new Paint();
        //设置手势的画笔
        mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPathPaint.setColor(Color.RED);
        mPathPaint.setStyle(Paint.Style.STROKE);
        mPathPaint.setStrokeWidth(45);
        //手势的轨迹
        mPath = new Path();

        //创建源图像和目标图像
//        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
//        mSrcBitmap = maskSrc();//等比例放大图片，到和view一样高
//        //绘制空白目标图像
//        mDstBitmap = Bitmap.createBitmap(mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
//        //设置目标图像的画布
//        mDstCanvas = new Canvas(mDstBitmap);

    }

    private Bitmap maskSrc() {
        //创建源图像和目标图像
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        int w = bitmap.getWidth() * getHeight()/ bitmap.getHeight();
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, w, getHeight(), false);
        return bitmap1;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //将路径的开始位置定位到点击的位置
                mPreX = event.getX();
                mPreY = event.getY();
                mPath.moveTo(mPreX, mPreY);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                //对于橡皮擦效果是非必须，因为在activity中使用了NestedScrollView，有滑动事件冲突
                getParent().requestDisallowInterceptTouchEvent(true);//屏蔽父控件拦截onTouch事件
                //找到控制点和终点
                float endX = (mPreX + event.getX()) / 2;
                float endY = (mPreY + event.getY()) / 2;

                mPath.quadTo(mPreX, mPreY, endX, endY);

                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mDstBitmap == null){
            mSrcBitmap = maskSrc();//等比例放大图片，到和view一样高
            mTextBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.guaguaka_text);
            //绘制空白目标图像
            mDstBitmap = Bitmap.createBitmap(mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            //设置目标图像的画布
            mDstCanvas = new Canvas(mDstBitmap);
        }
        //绘制底图 实现刮刮乐效果
        canvas.drawBitmap(mTextBitmap, null, new RectF(0, 0, mSrcBitmap.getWidth(), mSrcBitmap.getHeight()), mCanvasPaint);

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);
        //将轨迹画到目标图像上
        mDstCanvas.drawPath(mPath, mPathPaint);
        canvas.drawBitmap(mDstBitmap, 0, 0, mCanvasPaint);

        @SuppressLint("DrawAllocation")
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        //Paint 设置xfermode
        mCanvasPaint.setXfermode(porterDuffXfermode);

        canvas.drawBitmap(mSrcBitmap, 0, 0, mCanvasPaint);


        mCanvasPaint.setXfermode(null);

        canvas.restoreToCount(layerId);

    }
}
