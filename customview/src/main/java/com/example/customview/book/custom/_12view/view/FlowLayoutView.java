package com.example.customview.book.custom._12view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpack.DevDescribe;

@DevDescribe("自定义ViewGroup 包含多个TextView 水平排列，并且能自动换行")
public class FlowLayoutView extends ViewGroup {
    private static final String TAG = "FlowLayoutView";

    public FlowLayoutView(Context context) {
        this(context, null);
    }

    public FlowLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //首先支持 子控件的 margin 属性 重写 generateLayoutParams() 函數

        //其次 onMeasure 根据子控件 测量自身大小

        //再次， onLayout 布局子控件

        //
    }

    //首先支持 子控件的 margin 属性 重写 generateLayoutParams() 函數 start
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
    //首先支持 子控件的 margin 属性 重写 generateLayoutParams() 函數 end


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取模式
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取 值
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);

        int lineWidth = 0; //现有 每行已经占用 的宽度
        int lineHeight = 0;// 每行的高度
        int width = 0;
        int height = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            //测量 子控件
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //得到 childView 的宽和高
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            //1.
            if (childWidth + lineWidth > widthMeasureSize) {
                //当前行不能放下childView 需要换行，所以总高度 = 已有的高度height +　上一行的高度　lineHeight
                height = height + lineHeight;
                //换行了所以把当前行的值清空
                lineWidth = 0;
                lineWidth = childWidth;
                //换行后将 lineHeight 设置为 childView的高度
                lineHeight = childHeight;
            } else {
                //行宽，在原有的基础上 加上childView 的宽度
                lineWidth = lineWidth + childWidth;
                //取出当前行 最高的childView 的高度作为 当前行的高度，  注意 当前行高 还未加到总高度上
                lineHeight = Math.max(lineHeight, childHeight);
            }

            //2.
            if (i == count - 1) {
                //将最后一行的 高度加到总高度上
                height = height + lineHeight;
            }
            //得到最宽的 的值
            width = Math.max(width, lineWidth);

        }
        Log.i(TAG, "onMeasure: width = " + width + ",height= " + height);
        //最后，向系统中 输入 测量的 宽高
        setMeasuredDimension(widthMeasureMode == MeasureSpec.EXACTLY ? widthMeasureSize : width,
                heightMeasureMode == MeasureSpec.EXACTLY ? heightMeasureSize : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //对子控件进行 布局
        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();
        int top = 0;
        int left = 0;
        int right = 0;
        int bottom = 0;

        int lineWidth = 0;
        int lineHeight = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            int measureWidth = childView.getMeasuredWidth();
            int measuredHeight = childView.getMeasuredHeight();
            if (lineWidth + measureWidth > viewWidth) {
                //换行
                top = top + lineHeight;
                left = 0;
                right = left + measureWidth;
                bottom = top + measuredHeight;

                //同样，重新初始化lineHeight和lineWidth
                lineWidth = measureWidth;
                lineHeight = measuredHeight;
            } else {
                left = lineWidth;
                top = top ;
                right = left + measureWidth;
                bottom = top + measuredHeight;

                lineWidth = lineWidth + measureWidth;
                lineHeight = Math.max(lineHeight, measuredHeight);
            }
            //注意：是子控件布局，不是父类控件布局
            childView.layout(left, top, right, bottom);
            Log.i(TAG, "onLayout: top = " + top + ",bottom= " + bottom);
        }
    }
}
