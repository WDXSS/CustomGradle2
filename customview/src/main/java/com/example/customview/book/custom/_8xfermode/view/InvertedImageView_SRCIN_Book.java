package com.example.customview.book.custom._8xfermode.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

/**
 * Created by qijian on 17/2/9.
 */
public class InvertedImageView_SRCIN_Book extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST, BmpSRC, BmpRevert;

    public InvertedImageView_SRCIN_Book(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_invert_shade, null);
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.mipmap.dog, null);

        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        // 生成倒影图
        BmpRevert = Bitmap.createBitmap(BmpSRC, 0, 0, BmpSRC.getWidth(), BmpSRC.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth() * 2 / 3;
        int height = width * BmpDST.getHeight() / BmpDST.getWidth();

        //先画出小狗图片
        canvas.drawBitmap(BmpSRC, null, new RectF(0, 0, width, height), mBitPaint);

        //再画出倒影
        canvas.save();
        canvas.translate(0, height);

        canvas.drawBitmap(BmpDST, null, new RectF(0, 0, width, height), mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BmpRevert, null, new RectF(0, 0, width, height), mBitPaint);

        mBitPaint.setXfermode(null);

        canvas.restore();
    }
}