package com.library.recycler.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.library.recycler.adapter.module.DefaultAdapterModule;

import java.util.ArrayList;
import java.util.List;

/**
 * 多布局的另一种实现方式，好处是可以将多布局的逻辑拆分到多个类中，对代码进行解耦
 * 使用方法：
 * 1. 继承{@link AdapterModule}，并将多布局的逻辑写在其中
 * 2. 继承该Adapter，调用{@link #addModule(AdapterModule)}方法，来增加多布局
 *
 */
public class MultiModuleAdapter<T> extends MultiItemAdapter<T> {
    private static final int DEFAULT_TYPE = -1;

    private List<AdapterModule<T>> mModules = new ArrayList<>();

    private AdapterModule mDefaultModule;

    @SuppressWarnings("unchecked")
    public MultiModuleAdapter(@Nullable List<T> data) {
        super(data);

        setOnItemClickListener(new OnItemClick());
        setOnItemLongClickListener(new OnItemLongClick());

        setDefaultModule(DefaultAdapterModule.instance());
    }

    @SuppressWarnings("unchecked")
    public void addModule(AdapterModule module) {
        addViewType(mModules.size(), module.getLayoutId());

        mModules.add(module);
    }

    public void setDefaultModule(AdapterModule<T> module) {
        this.mDefaultModule = module;

        addViewType(DEFAULT_TYPE, mDefaultModule.getLayoutId());
    }

    @Override
    protected int getViewType(T entity) {
        for (int i = 0; i < mModules.size(); i++) {
            if (mModules.get(i).match(entity)) {
                return i;
            }
        }
        return DEFAULT_TYPE;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void convert(ViewHolder helper, T item) {
        int type = helper.getItemViewType();
        if (type == DEFAULT_TYPE) {
            mDefaultModule.convert(helper, item);
        } else {
            mModules.get(type).convert(helper, item);
        }
    }

    private class OnItemClick implements OnItemClickListener<T> {

        @Override
        public void onItemClick(View view, @NonNull T item, int position) {
            for (AdapterModule<T> module : mModules) {
                if (module.match(item)) {
                    module.onItemClick(view, item, position);
                    return;
                }
            }
        }
    }

    private class OnItemLongClick implements OnItemLongClickListener<T> {

        @Override
        public boolean onItemLongClick(View view, @NonNull T item, int position) {
            for (AdapterModule<T> module : mModules) {
                if (module.match(item)) {
                    module.onItemLongClick(view, item, position);
                    return true;
                }
            }
            return false;
        }
    }



}
