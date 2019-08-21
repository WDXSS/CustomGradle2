package com.library.recycler.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;

/**
 * DividerItemDecoration is a {@link RecyclerView.ItemDecoration} that can be used as a divider
 * between items of a {@link LinearLayoutManager}. It supports both {@link #HORIZONTAL} and
 * {@link #VERTICAL} orientations.
 *
 * <pre>
 *     mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
 *             mLayoutManager.getOrientation());
 *     recyclerView.addItemDecoration(mDividerItemDecoration);
 * </pre>
 *
 * <p> 可以通过{@link #setOnFilterListener(OnFilterListener)}来对分割线进行过滤，默认已经添加了{@link HeaderAndFooterFilter}，
 *     对Header和Footer进行了隐藏。可以再掉调用该方法，来覆盖默认的Listener，也可以通过继承{@link HeaderAndFooterFilter}，
 *     在隐藏Header和Footer的基础上实现自己的逻辑。
 *
 * <p> {@link RecyclerView.ItemDecoration}
 *
 *
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
    public static final int VERTICAL = LinearLayout.VERTICAL;

    private static final int[] ATTRS = new int[] { android.R.attr.listDivider };

    private static final int DEFAULT_DIVIDER_SIZE = (int) (0.5f + 0.5f * Resources.getSystem().getDisplayMetrics().density);

    private Context mContext;
    private Drawable mDivider;
    private int mDividerSize;
    private int mMarginStart, mMarginEnd;

    /**
     * Current orientation. Either {@link #HORIZONTAL} or {@link #VERTICAL}.
     */
    private int mOrientation;

    private final Rect mBounds = new Rect();

    public DividerItemDecoration(Context context) {
        this(context, VERTICAL);
    }

    public DividerItemDecoration(Context context, int orientation) {
        // 默认隐藏Header和Footer
        this(context, orientation, false);
    }

    /**
     * Creates a divider {@link RecyclerView.ItemDecoration} that can be used with a
     * {@link LinearLayoutManager}.
     *
     * @param context Current context, it will be used to access resources.
     * @param orientation Divider orientation. Should be {@link #HORIZONTAL} or {@link #VERTICAL}.
     */
    public DividerItemDecoration(Context context, int orientation, boolean showHeaderAndFooter) {
        this.mContext = context;

        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();

        setOrientation(orientation);

        if (!showHeaderAndFooter) {
            setOnFilterListener(new HeaderAndFooterFilter());
        }
    }

    /**
     * Sets the orientation for this divider. This should be called if
     * {@link RecyclerView.LayoutManager} changes orientation.
     *
     * @param orientation {@link #HORIZONTAL} or {@link #VERTICAL}
     */
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw new IllegalArgumentException(
                    "Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        mOrientation = orientation;
    }

    /**
     * Sets the {@link Drawable} for this divider.
     *
     * @param drawable Drawable that should be used as a divider.
     */
    public DividerItemDecoration setDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        mDivider = drawable;
        return this;
    }

    public DividerItemDecoration setColor(@ColorInt int color) {
        return setDrawable(createColorDrawable(color));
    }

    public DividerItemDecoration setColorRes(@ColorRes int colorRes) {
        return setDrawable(createColorDrawable(ContextCompat.getColor(mContext, colorRes)));
    }

    private ColorDrawable createColorDrawable(@ColorInt int color) {
        return new ColorDrawable(color);
    }

    /**
     * if (VERTICAL) { dividerHeight = size }
     * else if (HORIZONTAL) { dividerWidth = size }
     */
    public DividerItemDecoration setDividerSize(@Px int size) {
        this.mDividerSize = size;
        return this;
    }

    public DividerItemDecoration setMarginStart(int margin) {
        this.mMarginStart = margin;
        return this;
    }

    public DividerItemDecoration setMarginEnd(int margin) {
        this.mMarginEnd = margin;
        return this;
    }

    public DividerItemDecoration setMargin(int margin) {
        setMarginStart(margin);
        setMarginEnd(margin);
        return this;
    }

    private int mActualDividerSize;

    /**
     * <p> 获取真正的分隔线高度
     * <p> 1. 优先获取Drawable的宽或者高
     * <p> 2. 然后获取mDividerSize
     * <p> 3. 最后设置为默认高度{@link #DEFAULT_DIVIDER_SIZE}
     */
    private int getActualDividerSize() {
        if (mActualDividerSize > 0) {
            return mActualDividerSize;
        }
        int size = mOrientation == VERTICAL ? mDivider.getIntrinsicHeight() : mDivider.getIntrinsicWidth();
        if (size <= 0) {
            size = mDividerSize <= 0 ? DEFAULT_DIVIDER_SIZE : mDividerSize;
        }
        mActualDividerSize = size;
        return size;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if (mOrientation == VERTICAL) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int left;
        int right;
        // 当版本为Build.VERSION_CODES.LOLLIPOP 5.0以上版本
        if (Build.VERSION.SDK_INT >= 21 && parent.getClipToPadding()) {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
            canvas.clipRect(left, parent.getPaddingTop(), right,
                    parent.getHeight() - parent.getPaddingBottom());
        } else {
            left = 0;
            right = parent.getWidth();
        }

        left += mMarginStart;
        right -= mMarginEnd;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final int position = parent.getChildAdapterPosition(child);
            final boolean filter = isFilter(parent, child, position);
            // 判断是否过滤掉该分割线
            if (filter) {
                continue;
            }
            parent.getDecoratedBoundsWithMargins(child, mBounds);

            final int top = mBounds.top + Math.round(ViewCompat.getTranslationY(child));
            final int bottom = top + getActualDividerSize();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);

            // 绘制最后一条线，绘制于最后一个View下侧
            if (i == childCount - 1 && parent.getAdapter() != null
                    && !isFilter(parent, null, parent.getAdapter().getItemCount())) {
                final int lastBottom = mBounds.bottom + Math.round(ViewCompat.getTranslationY(child));
                final int lastTop = bottom - getActualDividerSize();
                mDivider.setBounds(left, lastTop, right, lastBottom);
                mDivider.draw(canvas);
            }
        }
        canvas.restore();
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        canvas.save();
        int top;
        int bottom;
        // 当版本为Build.VERSION_CODES.LOLLIPOP 5.0以上版本
        if (Build.VERSION.SDK_INT >= 21 && parent.getClipToPadding()) {
            top = parent.getPaddingTop();
            bottom = parent.getHeight() - parent.getPaddingBottom();
            canvas.clipRect(parent.getPaddingLeft(), top,
                    parent.getWidth() - parent.getPaddingRight(), bottom);
        } else {
            top = 0;
            bottom = parent.getHeight();
        }

        top += mMarginStart;
        bottom -= mMarginEnd;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final int position = parent.getChildAdapterPosition(child);
            final boolean filter = isFilter(parent, child, position);
            // 判断是否过滤掉该分割线
            if (filter) {
                continue;
            }
            parent.getLayoutManager().getDecoratedBoundsWithMargins(child, mBounds);

            final int left = mBounds.left + Math.round(ViewCompat.getTranslationY(child));
            final int right = left + getActualDividerSize();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);

            // 绘制最后一条线，绘制于最后一个View右侧
            if (i == childCount - 1 && parent.getAdapter() != null
                    && !isFilter(parent, null, parent.getAdapter().getItemCount())) {
                final int lastRight = mBounds.right + Math.round(ViewCompat.getTranslationX(child));
                final int lastLeft = right - getActualDividerSize();
                mDivider.setBounds(lastLeft, top, lastRight, bottom);
                mDivider.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        boolean filter = isFilter(parent, view, position);
        if (filter) {
            return;
        }
        if (mOrientation == VERTICAL) {
            outRect.set(0, getActualDividerSize(), 0, 0);
        } else {
            outRect.set(getActualDividerSize(), 0, 0, 0);
        }

        // 计算最后一条线位置
        if (parent.getAdapter() != null && position == parent.getAdapter().getItemCount() - 1
                && !isFilter(parent, null, parent.getAdapter().getItemCount())) {
            if (mOrientation == VERTICAL) {
                outRect.bottom = getActualDividerSize();
            } else {
                outRect.right = getActualDividerSize();
            }
        }
    }

    private boolean isFilter(RecyclerView parent, View view, int position) {
        return mOnFilterListener != null && mOnFilterListener.filter(parent, view, position);
    }

    private OnFilterListener mOnFilterListener;

    public DividerItemDecoration setOnFilterListener(OnFilterListener onFilterListener) {
        this.mOnFilterListener = onFilterListener;
        return this;
    }

    /**
     * 对分割线进行过滤
     */
    public interface OnFilterListener {
        /**
         * 需要注意的是，分割线总共有size + 1个，结构如下
         *
         * |------divider index = 0
         * | item index = 0
         * |------divider index = 1
         * |item index = 1
         * ......
         * |------divider index = size - 1
         * |item index = size - 1 (最后一个item)
         * |------divider index = size
         *
         * 假如需要隐藏header的分割线，需要在position == 0时return true；
         * 假如需要隐藏footer下面的，判断position == size
         *
         * @param parent RecyclerView
         * @param view 当前item view，假如是最后一条分割线，view == null
         * @param position item的position
         * @return true 隐藏item上方的分割线；false则正常显示
         */
        boolean filter(RecyclerView parent, @Nullable View view, int position);
    }

    /**
     * 隐藏Header和Footer
     */
    public static class HeaderAndFooterFilter implements OnFilterListener {

        @Override
        public boolean filter(RecyclerView parent, @Nullable View view, int position) {
            return position == 0 ||
                    (parent.getAdapter() != null && position == parent.getAdapter().getItemCount());
        }
    }
}

