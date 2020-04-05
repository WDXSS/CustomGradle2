package com.example.customview.book.custom._7paint.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class ShimmerView extends AppCompatTextView {

    private static final String TAG = "ShimmerView";
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private float mTextLength;
    private int mDx;
    private Matrix mMatrix;

    public ShimmerView(Context context) {
        this(context, null);
    }

    public ShimmerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShimmerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取打TextView 的paint对象
        mPaint = getPaint();
        mMatrix = new Matrix();
        createLinearGradient();
        createAnim();
    }

    private void createLinearGradient() {
        //获取 显示文字的长度
        mTextLength = mPaint.measureText(getText().toString());
        Log.d(TAG, "createLinearGradient() called textLength = " + mTextLength);
        int textColor = getCurrentTextColor();
        float x0 = -mTextLength;
        float y0 = 0;
        float x1 = 0;
        float y1 = 0;
        int[] colors = new int[]{textColor, 0xff00ff00, textColor};
        float[] positions = new float[]{0, 0.5f, 1};
        mLinearGradient = new LinearGradient(x0, y0, x1, y1, colors, positions, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mMatrix.setTranslate(mDx, 0);
        mLinearGradient.setLocalMatrix(mMatrix);
        mPaint.setShader(mLinearGradient);

        super.onDraw(canvas);


    }

    private void createAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, (int) (2 * mTextLength));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }
}
