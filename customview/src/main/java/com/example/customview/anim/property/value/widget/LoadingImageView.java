package com.example.customview.anim.property.value.widget;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.example.customview.R;

import static android.content.ContentValues.TAG;

public class LoadingImageView extends AppCompatImageView {

    private ValueAnimator valueAnimator;
    private int mTop;
    private int mRepeatTimes;
    private int[] imgs = {R.mipmap.pic_1, R.mipmap.pic_2, R.mipmap.pic_3};

    public LoadingImageView(Context context) {
        super(context);
        initView();
    }

    public LoadingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ValueAnimator getValueAnimator() {
        return valueAnimator;
    }

    private void initView() {

        valueAnimator = new ValueAnimator();
        //设置属性动画的值，从0~100~0；
        valueAnimator.setIntValues(0, 200, 0);
        //动画时长
        valueAnimator.setDuration(2000);
        //动画开始前的延迟
//        valueAnimator.setStartDelay(2000);

        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        //循环次数
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        //添加属性动画当前进度值的监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取当前显示进度
                int currentValue = (int) animation.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate: 当前的进度 = " + currentValue);
                //这里是 减 去currentValue 因为是向上跳
                setTop(mTop - currentValue);
            }
        });

        //添加属性动画状态的监听
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i(TAG, "onAnimationCancel: 动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(TAG, "onAnimationRepeat: 动画 重复");
                mRepeatTimes++;
                if (mRepeatTimes >= imgs.length) {
                    mRepeatTimes = 0;
                }
                int index = mRepeatTimes % imgs.length;
                setImageResource(imgs[index]);
            }
        });
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //记录空间初始化时的高度
        mTop = top;

    }
}
