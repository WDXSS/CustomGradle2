package com.example.customview.book.custom._12view.view;

import android.content.Context;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpack.DevDescribe;

@DevDescribe("通过自定义ViewGroup 理解，onMeasure 和 onLayout, 自定义ViewGroup支持 layout_margin ")
public class MyLinLayout extends ViewGroup {
    private static final String TAG = "MyLinLayout";

    public MyLinLayout(Context context) {
        this(context, null);
    }

    public MyLinLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //onLayout()函数 在ViewGroup 中是抽象函数
        //在onLayout() 函数数中对所有的子控件进行布局，注意 是子控件

        //getMeasuredWidth()和getWidth() 的区别
        //1.getMeasuredWidth()函数是在 measure()过程结束后可以获得到宽度值；而getWidth()函数是要在layout()过程结束后才能获得到值；
        //2. getMeasureWidth()函数得到的值是通过 setMeasuredDimension()函数进行设置的，而 getWidth()得到的值是通过layout(left,top,right,bottom)函数进行设置的

        //首先 如果自定义ViewGroup 支持 子控件的 layout_margin 属性，则自定义ViewGroup
        // 必须重写 generateLayoutParams() 函数并且在该函数中返回一个ViewGroup.MarginLayoutParams 对象；
        //其次 在测量 onMeasure() 函数中 计算 margin值
        //接着 在布局子控件是 将margin 值设置到 layout() 函数中
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //1.首先是通过父类传过来的建议宽度和高度值：widthMeasureSpec 和 heightMeasureSpec
        //利用 MeasureSpec 获取到 模式和值
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);//模式
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);//值
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

        //2.通过测量它所有的子控件来决定它所占位置的大小
        int count = getChildCount();
        int height = 0;
        int width = 0;
        for (int i = 0; i < count; i++) {
            //测量子控件
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);

            //获取 子控件的margin 值
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            int childBottomMargin = marginLayoutParams.bottomMargin;
            int childLeftMargin = marginLayoutParams.leftMargin;
            int childRightMargin = marginLayoutParams.rightMargin;
            int childTopMargin = marginLayoutParams.topMargin;
            Log.v(TAG, "测量 宽 和 高 onMeasure: childBottomMargin = " + childBottomMargin + ", childTopMargin =" + childTopMargin);
            //获得子类的测量结果  如果存在 margin 值需要加上margin 值
            int childHeight = view.getMeasuredHeight();
            int childWidth = view.getMeasuredWidth();

            //将高度累加，获得最大宽度 如果存在 margin 值需要加上margin 值
            height = height + childHeight + childBottomMargin + childTopMargin;
            width = Math.max(childWidth, width);

            Log.v(TAG, "测量 宽 和 高 onMeasure: height = " + height + ", width =" + width);
        }
        //3.通过用户的设置（wrap_content / match_parent）来判断是否将我们的测量结果设置到onMeasure()中
        setMeasuredDimension(measureWidthMode == MeasureSpec.EXACTLY ? measureWidth : width,
                measureHeightMode == MeasureSpec.EXACTLY ? measureHeight : height);
//        wrap_content----MeasureSpec.AT_MOST;
//        match_parent----MeasureSpec.EXACTLY;
//        具体值       ----MeasureSpec.EXACTLY;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //onLayout()函数 在ViewGroup 中是抽象函数
        //在onLayout() 函数数中对所有的子控件进行布局，注意 是子控件
        //根据自己的意愿，将container内部的控件排列起来，这里我们垂直排列

        int top = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            //获取 子控件的margin 值
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) child.getLayoutParams();
            int childBottomMargin = marginLayoutParams.bottomMargin;
            int childLeftMargin = marginLayoutParams.leftMargin;
            int childRightMargin = marginLayoutParams.rightMargin;
            int childTopMargin = marginLayoutParams.topMargin;

            //得到view测量的宽高  如果存在 margin 值需要加上margin 值
            int childWidth = child.getMeasuredWidth() + childLeftMargin + childRightMargin;
            int childHeight = child.getMeasuredHeight();
            Log.i(TAG, "onLayout: childWidth = " + childWidth + ", childHeight = " + childHeight);
            //设置 layout() 函数的参数
            int childTop = top + childTopMargin;
            int childLeft = l;
            int childRight = childWidth;
            int childBottom = childTop + childHeight + childBottomMargin;

            //使用 layout() 函数来布局控件 ，实现垂直布局
            child.layout(childLeft, childTop, childRight, childBottom);

            top += childHeight + childTopMargin + childBottomMargin;//将top 的值 加上控件的高度
            Log.d(TAG, "onLayout() called with: changed = [" + changed + "], "
                    + "i = [" + i + "]，" +
                    "l = [" + childLeft + "], " +
                    "t = [" + childTop + "], " +
                    "r = [" + childRight + "], " +
                    "b = [" + childBottom + "]");
        }
    }

    // 自定义ViewGroup支持 layout_margin
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
}
