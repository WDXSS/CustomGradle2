package com.example.book._7view.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book._7view.LinearItemDecoration;
import com.example.book._7view.RecyclerAdapter;
import com.example.book._7view.layoutmanager.CustomLayoutManager;
import com.example.lib_custom_view2.R;

import java.util.ArrayList;

/**
 * 不考虑回收 自定义layoutManager
 * CustomLayoutManager 会将 所有的Item 都初始化，添加到列表中
 * 从 onCreateViewHolder() 和 onBindViewHolder() 打印的条数可以看出
 */
public class LayoutManagerActivity1 extends AppCompatActivity {
    private ArrayList<String> mDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration_activity);

        generateDatas();
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycler_view);

        //自定义的LayoutManager
        CustomLayoutManager linearLayoutManager = new CustomLayoutManager();
        mRecyclerView.setLayoutManager(linearLayoutManager);

//        mRecyclerView.addItemDecoration(new LinearItemDecoration());

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void generateDatas() {
        for (int i = 0; i < 20; i++) {
            mDatas.add("第 " + i + " 个item");
        }
    }
    private class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private Context mContext;
        private ArrayList<String> mDatas;
        private int mCreatedHolder=0;

        public MyRecyclerAdapter(Context context, ArrayList<String> datas) {
            mContext = context;
            mDatas = datas;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mCreatedHolder++;
        Log.d("zhouc", "onCreateViewHolder num:"+mCreatedHolder);
            LayoutInflater inflater = LayoutInflater.from(mContext);
            return new NormalHolder(inflater.inflate(R.layout.item_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("zhouc", "onBindViewHolder");
           NormalHolder normalHolder = (NormalHolder) holder;
            normalHolder.mTV.setText(mDatas.get(position));
        }



        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public class NormalHolder extends RecyclerView.ViewHolder {
            public TextView mTV;

            public NormalHolder(View itemView) {
                super(itemView);

                mTV = (TextView) itemView.findViewById(R.id.item_tv);
                mTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, mTV.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
