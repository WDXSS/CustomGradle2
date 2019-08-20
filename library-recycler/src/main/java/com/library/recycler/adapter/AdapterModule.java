package com.library.recycler.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 *
 */
public abstract class AdapterModule<T> {
    /**
     * 检查obj是否属于当前AdapterModule
     */
    public abstract boolean match(T obj);

    /**
     * 布局resId
     */
    public abstract int getLayoutId();

    /**
     * 同{@link CommonAdapter#convert(BaseViewHolder, Object)}
     */
    public abstract void convert(ViewHolder holder, T data);

    /**
     * 点击当前类型item的事件
     */
    public abstract void onItemClick(View v, T data, int position);

    /**
     * 长按当前类型item的事件
     */
    public abstract void onItemLongClick(View v, T data, int position);
}
