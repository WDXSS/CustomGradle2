package com.library.recycler.adapter;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 *
 */
public abstract class CommonAdapter<T> extends BaseQuickAdapter<T, ViewHolder> {

    public CommonAdapter(@Nullable List<T> data) {
        super(data);
    }

    public CommonAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return super.getRecyclerView();
    }

    /**
     * 使用{@link #setOnItemClickListener(OnItemClickListener)}
     */
    @Override
    @Deprecated
    public void setOnItemClickListener(@Nullable BaseQuickAdapter.OnItemClickListener listener) {
        super.setOnItemClickListener(listener);
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        super.setOnItemClickListener(new OnItemClickAdapter<>(listener));
    }

    /**
     * 使用{@link #setOnItemLongClickListener(OnItemLongClickListener)}
     */
    @Override
    @Deprecated
    public void setOnItemLongClickListener(BaseQuickAdapter.OnItemLongClickListener listener) {
        super.setOnItemLongClickListener(listener);
    }

    public void setOnItemLongClickListener(@Nullable OnItemLongClickListener<T> listener) {
        super.setOnItemLongClickListener(new OnItemLongClickAdapter<>(listener));
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, @NonNull T item, int position);
    }

    public interface OnItemLongClickListener<T> {
        boolean onItemLongClick(View view, @NonNull T item, int position);
    }

    static class OnItemClickAdapter<E> implements BaseQuickAdapter.OnItemClickListener {
        private OnItemClickListener<E> mOnItemClickListener;

        OnItemClickAdapter(OnItemClickListener<E> l) {
            this.mOnItemClickListener = l;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            E item = (E) adapter.getItem(position);
            if (item != null && mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, item, position);
            }
        }
    }

    static class OnItemLongClickAdapter<E> implements BaseQuickAdapter.OnItemLongClickListener {
        private OnItemLongClickListener<E> mOnItemLongClickListener;

        OnItemLongClickAdapter(OnItemLongClickListener<E> l) {
            this.mOnItemLongClickListener = l;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
            E item = (E) adapter.getItem(position);
            if (item != null && mOnItemLongClickListener != null) {
                return mOnItemLongClickListener.onItemLongClick(view, item, position);
            }
            return false;
        }
    }
}
