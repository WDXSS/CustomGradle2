package com.library.recycler.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

import com.library.recycler.R;


/**
 * RecyclerView的一个简单封装,并增加了一些自定义参数。
 * 等同于
 * <com.library.recycler.widget.RefreshLayout
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent">
 *     <android.support.v7.widget.RecyclerView
 *         android:layout_width="match_parent"
 *         android:layout_height="match_parent" />
 * </com.library.recycler.widget.RefreshLayout>
 *
 * <ul>
 * 自定义属性
 * <li> recyclerEnableRefresh：是否可以刷新
 * <li> recyclerEnableLoadMore：是否可以加载更多
 * <li> recyclerLayoutManager：LayoutManager类型，枚举型 vertical、horizontal或grid（设置horizontal时，刷新会存在问题）
 * <li> recyclerGridSpans：Grid列数
 * <li> recyclerGridBorder：Grid的最外层分割线是否显示，{@link GridItemDecoration#setBorder(int)}
 * <li> recyclerEnableDivider：是否显示分割线
 * <li> recyclerDivider：分割线drawable
 * <li> recyclerDividerColor：分割线颜色，和refreshRecyclerDivider互斥
 * <li> recyclerDividerSize：分割线大小（高度）
 * </ul>
 *
 *
 */
public class RefreshRecyclerView extends RefreshLayout {
    private boolean mEnableRefresh, mEnableLoadMore;
    private int mLayoutManagerType;
    private int mGridSpans = 0;
    private boolean mEnableDivider;
    private int mGridBorder;
    private Drawable mDivider;
    private int mDividerColor, mDividerSize, mDividerMarginStart, mDividerMarginEnd;
    private RecyclerView mLayoutRecycler;

    public RefreshRecyclerView(Context context) {
        super(context);
        init(null);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RecyclerView getRecyclerView() {
        return mLayoutRecycler;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mLayoutRecycler.setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter() {
        return mLayoutRecycler.getAdapter();
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
        mEnableRefresh = typedArray.getBoolean(R.styleable.RecyclerListView_recyclerEnableRefresh, true);
        mEnableLoadMore = typedArray.getBoolean(R.styleable.RecyclerListView_recyclerEnableLoadMore, true);
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
        setEnableRefresh(mEnableRefresh);
        setEnableLoadMore(mEnableLoadMore);

        mLayoutRecycler = new RecyclerView(getContext());
        mLayoutRecycler.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        new RecyclerBuilder().layoutManager(mLayoutManagerType)
                .divider(mDivider)
                .dividerColor(mDividerColor)
                .dividerSize(mDividerSize)
                .dividerMargin(mDividerMarginStart, mDividerMarginEnd)
                .enableDivider(mEnableDivider)
                .gridBorder(mGridBorder)
                .gridSpans(mGridSpans)
                .build(getContext(), mLayoutRecycler);
        addView(mLayoutRecycler);
    }
}
