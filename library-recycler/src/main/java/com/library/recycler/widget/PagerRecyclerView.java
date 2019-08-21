package com.library.recycler.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 使用PagerSnapHelper + RecyclerView实现的类似ViewPager的控件，实现了基础的一些功能
 * 1. {@link #setCurrentItem(int)}、{@link #getCurrentItem()}
 * 2. {@link #setOnPageChangeListener(OnPageChangeListener)}
 *
 */
public class PagerRecyclerView extends RecyclerView {
    private int mCurrentItem;
    private OnPageChangeListener mOnPageChangeListener;

    public PagerRecyclerView(Context context) {
        this(context, null);
    }

    public PagerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        new PagerHelper().attachToRecyclerView(this);
    }

    public int getCurrentItem() {
        return mCurrentItem;
    }

    public void setCurrentItem(int position) {
        if (getAdapter() == null) {
            return;
        }
        position = Math.min(position, getAdapter().getItemCount() - 1);
        smoothScrollToPosition(position);
        onPageChange(position);
    }

    private void onPageChange(int position) {
        this.mCurrentItem = position;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(position);
        }
    }

    public OnPageChangeListener getOnPageChangeListener() {
        return mOnPageChangeListener;
    }

    public void setOnPageChangeListener(OnPageChangeListener l) {
        this.mOnPageChangeListener = l;
    }

    private static class PagerHelper extends PagerSnapHelper {
        PagerRecyclerView mPagerRecyclerView;

        @Override
        public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
            super.attachToRecyclerView(recyclerView);
            mPagerRecyclerView = (PagerRecyclerView) recyclerView;
        }

        @Override
        public int findTargetSnapPosition(LayoutManager layoutManager, int velocityX, int velocityY) {
            int position = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
            mPagerRecyclerView.onPageChange(position);
            return position;
        }
    }

    public interface OnPageChangeListener {
        void onPageSelected(int position);
    }
}
