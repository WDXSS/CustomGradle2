package com.library.recycler.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <shape xmlns:android="http://schemas.android.com/apk/res/android"
 android:tint="?attr/colorForeground">
 <solid android:color="#1f000000" />
 <size
 android:height="1dp"
 android:width="1dp" />
 </shape>
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BORDER_LEFT     = 1 << 0;
    public static final int BORDER_TOP      = 1 << 1;
    public static final int BORDER_RIGHT    = 1 << 2;
    public static final int BORDER_BOTTOM   = 1 << 3;

    private static final int[] ATTRS = new int[]{ android.R.attr.listDivider };

    private static final int DEFAULT_DIVIDER_SIZE = 1;

    private Context mContext;
    private Drawable mDivider;
    private int mDividerSize;
    private int mBorder = BORDER_LEFT | BORDER_TOP | BORDER_RIGHT | BORDER_BOTTOM;

    private final Rect mBounds = new Rect();

    public GridItemDecoration(Context context) {
        this.mContext = context;

        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    /**
     * Sets the {@link Drawable} for this divider.
     *
     * @param drawable Drawable that should be used as a divider.
     */
    public GridItemDecoration setDrawable(@NonNull Drawable drawable) {
        mDivider = drawable;
        return this;
    }

    public GridItemDecoration setColor(@ColorInt int color) {
        return setDrawable(createColorDrawable(color));
    }

    public GridItemDecoration setColorRes(@ColorRes int colorRes) {
        return setDrawable(createColorDrawable(ContextCompat.getColor(mContext, colorRes)));
    }

    private ColorDrawable createColorDrawable(@ColorInt int color) {
        return new ColorDrawable(color);
    }

    /**
     * if (VERTICAL) { dividerHeight = size }
     * else if (HORIZONTAL) { dividerWidth = size }
     */
    public GridItemDecoration setDividerSize(@Px int size) {
        this.mDividerSize = size;
        return this;
    }

    /**
     * 需要画哪一侧的边框，默认四面的边框都会进行绘制
     * @see #BORDER_LEFT
     * @see #BORDER_TOP
     * @see #BORDER_RIGHT
     * @see #BORDER_BOTTOM
     */
    public GridItemDecoration setBorder(int flag) {
        this.mBorder = flag;
        return this;
    }

    private int mActualDividerWidth, mActualDividerHeight;

    /**
     * <p> 获取真正的分隔线高度
     * <p> 1. 优先获取Drawable的宽或者高
     * <p> 2. 然后获取mDividerSize
     * <p> 3. 最后设置为默认高度{@link #DEFAULT_DIVIDER_SIZE}
     */
    private int getActualDividerWidth() {
        if (mActualDividerWidth > 0) {
            return mActualDividerWidth;
        }
        int size = mDivider.getIntrinsicWidth();
        if (size <= 0) {
            size = mDividerSize <= 0 ? DEFAULT_DIVIDER_SIZE : mDividerSize;
        }
        mActualDividerWidth = size;
        return size;
    }

    private int getActualDividerHeight() {
        if (mActualDividerHeight > 0) {
            return mActualDividerHeight;
        }
        int size = mDivider.getIntrinsicHeight();
        if (size <= 0) {
            size = mDividerSize <= 0 ? DEFAULT_DIVIDER_SIZE : mDividerSize;
        }
        mActualDividerHeight = size;
        return size;
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        drawGrid(canvas, parent);
    }

    private int mSpanCount, mLineCount;

    private void drawGrid(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int childCount = parent.getChildCount();
        mSpanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        mLineCount = (childCount + mSpanCount - 1) / mSpanCount;
        
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            parent.getDecoratedBoundsWithMargins(child, mBounds);
            // 1. 每次都画底部和右侧的线
            // 2. 只有第一列画左边的线
            // 3. 只有第一行画顶部的线
            drawLeft(canvas, child, i);
            drawRight(canvas, child, i);
            drawTop(canvas, child, i);
            drawBottom(canvas, child, i);
        }
        canvas.restore();
    }

    private void drawLeft(Canvas canvas, View child, int index) {
        if ((mBorder & BORDER_LEFT) == 0) {
            return;
        }
        // 只有第一列画左边的线
        if (index % mSpanCount != 0) {
            return;
        }
        final int top = mBounds.top;
        final int bottom = top + 2 * getActualDividerHeight() + child.getHeight();
        final int left = mBounds.left;
        final int right = left + getActualDividerWidth();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(canvas);
    }

    private void drawRight(Canvas canvas, View child, int index) {
        // 假如不要右侧的边框，则只有最后一列不画右侧的线
        if ((mBorder & BORDER_RIGHT) == 0 && (index + 1) % mSpanCount == 0) {
            return;
        }
        final int bottom = mBounds.bottom;
        final int top = bottom - 2 * getActualDividerHeight() - child.getHeight();
        final int right = mBounds.right;
        final int left = right - getActualDividerWidth();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(canvas);
    }

    private void drawTop(Canvas canvas, View child, int index) {
        if ((mBorder & BORDER_TOP) == 0) {
            return;
        }
        // 只有第一行画顶部的线
        if (index >= mSpanCount) {
            return;
        }
        final int top = mBounds.top;
        final int bottom = top + getActualDividerHeight();
        final int left = mBounds.left;
        final int right = left + 2 * getActualDividerWidth() + child.getWidth();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(canvas);
    }

    private void drawBottom(Canvas canvas, View child, int index) {
        // 假如不要底部的边框，则只有最后一行不画底部的线
        if ((mBorder & BORDER_BOTTOM) == 0 && index >= (mLineCount - 1) * mSpanCount) {
            return;
        }
        final int bottom = mBounds.bottom + Math.round(ViewCompat.getTranslationY(child));
        final int top = bottom - getActualDividerHeight();
        final int right = mBounds.right + Math.round(ViewCompat.getTranslationX(child));
        final int left = right - 2 * getActualDividerWidth() - child.getWidth();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(canvas);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int width = getActualDividerWidth();
        int height = getActualDividerHeight();
        outRect.set(width, height, width, height);
    }
}

