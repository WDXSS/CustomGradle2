package com.example.book._7view.ui;

import android.content.Context;
import android.os.Bundle;
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
import com.example.lib_custom_view2.R;

import java.util.ArrayList;

public class ItemDecorationActivity extends AppCompatActivity {
    private ArrayList<String> mDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration_activity);

        generateDatas();
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycler_view);

        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.addItemDecoration(new LinearItemDecoration());

        RecyclerAdapter adapter = new RecyclerAdapter(this, mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void generateDatas() {
        for (int i = 0; i < 10; i++) {
            mDatas.add("第 " + i + " 个item");
        }
    }

}
