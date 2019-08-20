package com.library.recycler.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.library.recycler.R;

/**
 * RecyclerView的一个简单封装,可以在xml对分割线、LayoutManager等进行配置。
 *
 * <ul>
 * 自定义属性
 * <li> recyclerLayoutManager：LayoutManager类型，枚举型vertical、horizontal或grid（设置horizontal时，刷新会存在问题）
 * <li> recyclerGridSpans：Grid列数
 * <li> recyclerGridBorder：Grid的最外层分割线是否显示，{@link GridItemDecoration#setBorder(int)}
 * <li> recyclerEnableDivider：是否显示分割线
 * <li> recyclerDivider：分割线drawable
 * <li> recyclerDividerColor：分割线颜色，和refreshRecyclerDivider互斥
 * <li> recyclerDividerSize：分割线大小（高度）
 * <li> recyclerDividerMarginStart：分割线marginLeft/marginTop
 * <li> recyclerDividerMarginEnd：分割线marginRight/marginBottom
 * </ul>
 */
public class RecyclerListView extends RecyclerView {
    private int mLayoutManagerType;
    private int mGridSpans = 0;
    private boolean mEnableDivider = true;
    private int mGridBorder;
    private Drawable mDivider;
    private int mDividerColor, mDividerSize, mDividerMarginStart, mDividerMarginEnd;

    public RecyclerListView(Context context) {
        super(context);
        init(null);
    }

    public RecyclerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RecyclerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        parseAttrs(attrs);
        initViews();
    }

    private void parseAttrs(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RecyclerListView);
        mLayoutManagerType = typedArray.getInteger(R.styleable.RecyclerListView_recyclerLayoutManager, 0);
        mGridSpans = typedArray.getInteger(R.styleable.RecyclerListView_recyclerGridSpans, 0);
        mEnableDivider = typedArray.getBoolean(R.styleable.RecyclerListView_recyclerEnableDivider, true);
        mGridBorder = typedArray.getInteger(R.styleable.RecyclerListView_recyclerGridBorder, 0);
        mDivider = typedArray.getDrawable(R.styleable.RecyclerListView_recyclerDivider);
        mDividerColor = DensityUtil.getColor(getContext(), typedArray, R.styleable.RecyclerListView_recyclerDividerColor, -1);
        mDividerSize = DensityUtil.getDimension(getContext(), typedArray, R.styleable.RecyclerListView_recyclerDividerSize, 0);
        mDividerMarginStart = DensityUtil.getDimension(getContext(), typedArray, R.styleable.RecyclerListView_recyclerDividerMarginStart, 0);
        mDividerMarginEnd = DensityUtil.getDimension(getContext(), typedArray, R.styleable.RecyclerListView_recyclerDividerMarginEnd, 0);
        typedArray.recycle();
    }

    private void initViews() {
        new RecyclerBuilder().layoutManager(mLayoutManagerType)
                .divider(mDivider)
                .dividerColor(mDividerColor)
                .dividerSize(mDividerSize)
                .dividerMargin(mDividerMarginStart, mDividerMarginEnd)
                .enableDivider(mEnableDivider)
                .gridBorder(mGridBorder)
                .gridSpans(mGridSpans)
                .build(getContext(), this);
    }


}
