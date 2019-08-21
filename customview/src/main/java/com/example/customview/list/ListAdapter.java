package com.example.customview.list;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.customview.R;
import com.library.recycler.adapter.CommonAdapter;
import com.library.recycler.adapter.ViewHolder;

import java.util.List;

public class ListAdapter extends CommonAdapter<ListEngty> {
    public ListAdapter(@Nullable List<ListEngty> data) {
        super(R.layout.layout_item, data);
    }

    @Override
    protected void convert(ViewHolder helper, ListEngty item) {
        TextView textView = helper.getView(R.id.item_text);
        textView.setText(item.name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "name :" + item.name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
