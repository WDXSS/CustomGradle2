package com.library.recycler.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.library.recycler.R;


/**
 *
 */
public class ViewHolder extends BaseViewHolder {

    public ViewHolder(View view) {
        super(view);
    }

    public Object getBinding() {
        return itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
    }
}
