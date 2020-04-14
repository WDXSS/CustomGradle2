package com.example.customview.book.custom._8xfermode.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("Src_in 公式：[Sa*Da, Sc*Da] 当目标图像为透明时，源图像不显示")
public class InvertedImageView_Src_In extends View {
    private Bitmap mBitDog;
    private Bitmap mBitSrc;
    private Bitmap mBitDst;
    private Paint mPaint;
    private Paint mPaintText;

    public InvertedImageView_Src_In(Context context) {
        this(context, null);
    }

    public InvertedImageView_Src_In(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        //原理：逐渐改变目标图像的透明度，来控制源图像的显示状态
    }

    public InvertedImageView_Src_In(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mBitDog = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        //将照片旋转180度 得到源图像
        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        mBitSrc = Bitmap.createBitmap(mBitDog, 0, 0, mBitDog.getWidth(), mBitDog.getHeight(), matrix, true);
        //目标图像
        mBitDst = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_invert_shade);

        mPaint = new Paint();
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setTextSize(20);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = mBitDog.getWidth();
        int height = mBitDog.getHeight();

        //画出正向的照片
        Rect rect = new Rect(0, 0, width, height);
        canvas.drawBitmap(mBitDog, null, rect, null);
        //移动一个图片的高度
        canvas.translate(0, height);

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);

        canvas.drawBitmap(mBitDst, 0, 0, mPaint);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(mBitSrc, 0, 0, mPaint);

        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
        //绘制 使用 RectF 和不使用的区别
        doDraw2(width, height, canvas);
    }

    private void doDraw2(int width, int height, Canvas canvas) {
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);
        canvas.translate(width, 0);
        //使用 new RectF(0, 0, width, height)和不使用在效果是有区别的
        canvas.drawBitmap(mBitDst, null, new RectF(0, 0, width, height), mPaint);
        PorterDuffXfermode porterDuffXfermode2 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mPaint.setXfermode(porterDuffXfermode2);
        canvas.drawBitmap(mBitSrc, null, new RectF(0, 0, width, height), mPaint);

        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
