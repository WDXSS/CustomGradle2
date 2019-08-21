package com.library.recycler.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 */
public class RecyclerBuilder {
    private int mLayoutManagerType;
    private int mGridSpans = 0;
    private boolean mEnableDivider = true;
    private int mGridBorder;
    private Drawable mDivider;
    private int mDividerColor, mDividerSize, mDividerMarginStart, mDividerMarginEnd;

    public RecyclerBuilder layoutManager(int mLayoutManagerType) {
        this.mLayoutManagerType = mLayoutManagerType;
        return this;
    }

    public RecyclerBuilder gridSpans(int mGridSpans) {
        this.mGridSpans = mGridSpans;
        return this;
    }

    public RecyclerBuilder enableDivider(boolean mEnableDivider) {
        this.mEnableDivider = mEnableDivider;
        return this;
    }

    public RecyclerBuilder gridBorder(int mGridBorder) {
        this.mGridBorder = mGridBorder;
        return this;
    }

    public RecyclerBuilder divider(Drawable mDivider) {
        this.mDivider = mDivider;
        return this;
    }

    public RecyclerBuilder dividerColor(int mDividerColor) {
        this.mDividerColor = mDividerColor;
        return this;
    }

    public RecyclerBuilder dividerSize(int mDividerSize) {
        this.mDividerSize = mDividerSize;
        return this;
    }

    public RecyclerBuilder dividerMargin(int marginStart, int marginEnd) {
        this.mDividerMarginStart = marginStart;
        this.mDividerMarginEnd = marginEnd;
        return this;
    }

    public void build(Context context, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(createLayoutManager(context, mLayoutManagerType));
        if (mEnableDivider) {
            recyclerView.addItemDecoration(createItemDecoration(context, mLayoutManagerType));
        }
    }

    private RecyclerView.LayoutManager createLayoutManager(Context context, int type) {
        if (type == LayoutManagerType.VERTICAL) {
            return new LinearLayoutManager(context);
        }
        else if (type == LayoutManagerType.HORIZONTAL) {
            return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        }
        else if (type == LayoutManagerType.GRID) {
            return new GridLayoutManager(context, mGridSpans);
        }
        return null;
    }

    private RecyclerView.ItemDecoration createItemDecoration(Context context, int type) {
        if (type == LayoutManagerType.GRID) {
            GridItemDecoration itemDecoration = new GridItemDecoration(context);
            if (mDivider != null) {
                itemDecoration.setDrawable(mDivider);
            } else if (mDividerColor != -1) {
                itemDecoration.setColor(mDividerColor);
            }
            if (mDividerSize > 0) {
                itemDecoration.setDividerSize(mDividerSize);
            }
            if (mGridBorder >= 0) {
                // 这里枚举的值和GridItemDecoration的枚举值配置的是一样的，所以直接set即可
                itemDecoration.setBorder(mGridBorder);
            }
            return itemDecoration;
        } else {
            DividerItemDecoration itemDecoration = new DividerItemDecoration(context);
            if (type == LayoutManagerType.VERTICAL) {
                itemDecoration.setOrientation(DividerItemDecoration.VERTICAL);
            }
            else if (type == LayoutManagerType.HORIZONTAL) {
                itemDecoration.setOrientation(DividerItemDecoration.HORIZONTAL);
            }
            else {
                return null;
            }
            if (mDivider != null) {
                itemDecoration.setDrawable(mDivider);
            } else if (mDividerColor != -1) {
                itemDecoration.setColor(mDividerColor);
            }
            if (mDividerSize > 0) {
                itemDecoration.setDividerSize(mDividerSize);
            }
            itemDecoration.setMarginStart(mDividerMarginStart);
            itemDecoration.setMarginEnd(mDividerMarginEnd);
            return itemDecoration;
        }
    }

    public static class LayoutManagerType {
        static final int VERTICAL = 0;
        static final int HORIZONTAL = 1;
        static final int GRID = 2;
    }
}
