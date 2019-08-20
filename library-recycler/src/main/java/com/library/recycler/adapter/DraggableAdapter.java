package com.library.recycler.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.library.recycler.listener.OnDragListener;

import java.util.List;

/**
 * 可以进行拖动排序的Adapter<br/>
 * 默认是不可以进行拖动的，可以调用{@link #setDraggable(boolean)}设置为可以拖动，默认通过长按item拖动。<br/>
 * 更多配置：<br/>
 * 1. {@link #setDraggableViewId(int)} 设置拖动的viewId<br/>
 * 2. {@link #setDragOnLongPress(boolean)} 设置长按拖动<br/>
 * 3. {@link #setOnDragListener(OnDragListener)} 对拖动过程进行监听<br/>
 *
 */
public abstract class DraggableAdapter<T> extends BaseItemDraggableAdapter<T, ViewHolder> {
    private RecyclerView mRecyclerView;
    private int mDraggableViewId = 0;
    private boolean mDragOnLongPress = true;

    public DraggableAdapter(RecyclerView recyclerView, int layoutResId, List<T> data) {
        super(layoutResId, data);

        this.mRecyclerView = recyclerView;
    }

    /**
     * 设置按住可以进行拖动的viewId<br/>
     * 设置后则只能按住view进行拖动，按住item不能拖动；如果不设置，则按住item进行拖动
     */
    public void setDraggableViewId(int draggableViewId) {
        this.mDraggableViewId = draggableViewId;
    }

    /**
     * true 长按进行拖动；false 按住即可拖动
     */
    public void setDragOnLongPress(boolean dragOnLongPress) {
        this.mDragOnLongPress = dragOnLongPress;
    }

    public boolean isDraggedItemDraggable(int position) {
        return true;
    }

    /**
     * 设置是否可以进行拖动
     */
    public void setDraggable(boolean draggable) {
        if (draggable) {
            DragAndSwipeCallback itemDragAndSwipeCallback = new DragAndSwipeCallback(this);
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
            itemTouchHelper.attachToRecyclerView(mRecyclerView);
            enableDragItem(itemTouchHelper, mDraggableViewId, mDragOnLongPress);
        } else {
            disableDragItem();
        }
    }

    /**
     * use {@link #setOnDragListener(OnDragListener)}
     */
    @Deprecated
    @Override
    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        super.setOnItemDragListener(onItemDragListener);
    }

    public void setOnDragListener(OnDragListener l) {
        super.setOnItemDragListener(l);
    }

    private class DragAndSwipeCallback extends ItemDragAndSwipeCallback {

        DragAndSwipeCallback(BaseItemDraggableAdapter adapter) {
            super(adapter);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            if (!isDraggedItemDraggable(source.getLayoutPosition()) || !isDraggedItemDraggable(target.getLayoutPosition())) {
                return false;
            }
            return super.onMove(recyclerView, source, target);
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (!isDraggedItemDraggable(viewHolder.getLayoutPosition())) {
                return makeMovementFlags(0, 0);
            }
            return super.getMovementFlags(recyclerView, viewHolder);
        }
    }

    /**
     * 使用{@link #setOnItemClickListener(CommonAdapter.OnItemClickListener)}
     */
    @Override
    @Deprecated
    public void setOnItemClickListener(@Nullable BaseQuickAdapter.OnItemClickListener listener) {
        super.setOnItemClickListener(listener);
    }

    public void setOnItemClickListener(CommonAdapter.OnItemClickListener<T> listener) {
        super.setOnItemClickListener(new CommonAdapter.OnItemClickAdapter<>(listener));
    }

    /**
     * 使用{@link #setOnItemLongClickListener(CommonAdapter.OnItemLongClickListener)}
     */
    @Override
    @Deprecated
    public void setOnItemLongClickListener(BaseQuickAdapter.OnItemLongClickListener listener) {
        super.setOnItemLongClickListener(listener);
    }

    public void setOnItemLongClickListener(@Nullable CommonAdapter.OnItemLongClickListener<T> listener) {
        super.setOnItemLongClickListener(new CommonAdapter.OnItemLongClickAdapter<>(listener));
    }
}
