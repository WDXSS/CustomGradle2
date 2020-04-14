package com.example.customview.book.custom._8xfermode.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

/**
 * Created by qijian on 17/2/8.
 */
public class LightBookViewBook extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST, BmpSRC;

    public LightBookViewBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.mipmap.book_bg, null);
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.mipmap.book_light, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = BmpDST.getWidth();
        int height = BmpDST.getHeight();
        RectF rectF = new RectF(0, 0, width, height);
        canvas.save();

        canvas.drawBitmap(BmpDST, null, rectF, mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        canvas.drawBitmap(BmpSRC, null, rectF, mBitPaint);

        mBitPaint.setXfermode(null);
        canvas.restore();

//        canvas.drawBitmap(BmpSRC, null, rectF, null);
    }
}