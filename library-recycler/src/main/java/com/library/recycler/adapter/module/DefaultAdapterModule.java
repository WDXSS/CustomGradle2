package com.library.recycler.adapter.module;

import android.view.View;


import com.library.recycler.R;
import com.library.recycler.adapter.AdapterModule;
import com.library.recycler.adapter.ViewHolder;

/**
 * <p> Created by RenTao on 2018/8/9.
 */
public class DefaultAdapterModule extends AdapterModule<Object> {
    private static AdapterModule defaultModule;

    public static AdapterModule instance() {
        if (defaultModule == null) {
            defaultModule = new DefaultAdapterModule();
        }
        return defaultModule;
    }

    @Override
    public boolean match(Object obj) {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycler_item_default_module;
    }

    @Override
    public void convert(ViewHolder holder, Object data) {}

    @Override
    public void onItemClick(View v, Object data, int position) {}

    @Override
    public void onItemLongClick(View v, Object data, int position) {}
}
