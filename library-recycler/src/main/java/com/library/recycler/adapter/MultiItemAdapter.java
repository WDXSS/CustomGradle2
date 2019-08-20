package com.library.recycler.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.util.MultiTypeDelegate;

import java.util.List;

/**
 * <p> 多布局通过的Adapter
 * <p> 1. 通过{@link #addViewType(int, int)}增加多布局
 * <p> 2. 重写{@link #getViewType(Object)}，用来判断entity属于哪个viewType
 * <p> 3. 重写{@link #convert(ViewHolder, Object)}来为指定布局填充数据，可以使用{@link ViewHolder#getItemViewType()}获取到当前的viewType
 *
 */
public abstract class MultiItemAdapter<T> extends CommonAdapter<T> {

    public MultiItemAdapter(@Nullable List<T> data) {
        super(data);

        setMultiTypeDelegate(new MultiTypeDelegate<T>() {

            @Override
            protected int getItemType(T entity) {
                return MultiItemAdapter.this.getViewType(entity);
            }
        });
    }

    /**
     * 增加多布局
     */
    protected void addViewType(int viewType, @LayoutRes int layoutResId) {
        getMultiTypeDelegate().registerItemType(viewType, layoutResId);
    }

    /**
     * 根据entity获取viewType
     */
    protected abstract int getViewType(T entity);

    /**
     * 可以通过{@link ViewHolder#getItemViewType()}获取到当前的viewType
     */
    @Override
    protected abstract void convert(ViewHolder helper, T item);
}
