package com.library.recycler.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * <p> 1. {@link #autoRefresh()} / {@link #finishRefresh()} 开始/结束刷新
 * <p> 2. {@link #autoLoadMore()} / {@link #finishLoadmore()} 开始/结束加载
 * <p> 3. {@link #setEnableRefresh(boolean)} / {@link #setEnableLoadMore(boolean)} 禁用/启用刷新和加载更多
 * <p> <a href="https://github.com/scwang90/SmartRefreshLayout">reference<a/>
 *
 */
public class RefreshLayout extends SmartRefreshLayout {
    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RefreshLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (getRefreshHeader() == null) {
            setRefreshHeader(new ClassicsHeader(getContext())
                    .setSpinnerStyle(SpinnerStyle.Translate));
        }
        if (getRefreshFooter() == null) {
            setRefreshFooter(new ClassicsFooter(getContext()));
        }
        setEnableOverScrollDrag(false);
        setEnableOverScrollBounce(false);
    }

    @Override
    public boolean autoRefresh() {
        return autoRefresh(0);
    }

    @Override
    public boolean autoLoadMore() {
        return autoLoadMore(0);
    }

    @Override
    public SmartRefreshLayout finishLoadMore() {
        return finishLoadMore(0);
    }

    @Override
    public SmartRefreshLayout finishRefresh() {
        return finishRefresh(0);
    }

    public void finishLoading() {
        if (isRefreshing()) {
            finishRefresh();
        }
        if (isLoading()) {
            finishLoadMore();
        }
    }

    // ---------------------------- RefreshListener start ---------------------------- //

    private RefreshListener mRefreshListener;

    public RefreshListener getRefreshListener() {
        return mRefreshListener;
    }

    public void setRefreshListener(RefreshListener l) {
        this.mRefreshListener = l;
        if (mRefreshListener == null) {
            super.setOnRefreshLoadMoreListener(null);
        } else {
            super.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {

                @Override
                public void onLoadMore(com.scwang.smartrefresh.layout.api.RefreshLayout refreshlayout) {
                    mRefreshListener.onLoadMore(RefreshLayout.this);
                }

                @Override
                public void onRefresh(com.scwang.smartrefresh.layout.api.RefreshLayout refreshlayout) {
                    mRefreshListener.onRefresh(RefreshLayout.this);
                }
            });
        }
    }

    @Override
    @Deprecated
    public SmartRefreshLayout setOnRefreshListener(OnRefreshListener listener) {
        return super.setOnRefreshListener(listener);
    }

    @Override
    @Deprecated
    public SmartRefreshLayout setOnLoadMoreListener(OnLoadMoreListener listener) {
        return super.setOnLoadMoreListener(listener);
    }

    @Override
    @Deprecated
    public SmartRefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener listener) {
        return super.setOnRefreshLoadMoreListener(listener);
    }

    public interface RefreshListener {
        void onRefresh(RefreshLayout refreshLayout);

        void onLoadMore(RefreshLayout refreshLayout);
    }

    // ---------------------------- RefreshListener end ---------------------------- //
}
