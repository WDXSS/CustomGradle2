package com.example.customview.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.customview.CustomViewMain;
import com.example.customview.R;
import com.example.customview.list.manager.FlowLayoutManager;
import com.example.customview.list.manager.SpaceItemDecoration;
import com.example.customview.list.viewpage.RecycleViewGalleryActivity;
import com.library.recycler.widget.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.scwang.smartrefresh.layout.util.DensityUtil.dp2px;

public class ListMainActivity extends AppCompatActivity {
    private RefreshRecyclerView mRefreshRecyclerView;
    private RecyclerView mRecyclerView;
    private List<ListEngty> mList;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRefreshRecyclerView = findViewById(R.id.recycler_view);
        mList = new ArrayList<>();
        initFragment();
        initData();
    }

    private void initFragment() {
        mAdapter = new ListAdapter(mList);
        mRefreshRecyclerView.setEnableRefresh(false);
        mRefreshRecyclerView.setEnableLoadMore(false);

        mRecyclerView = mRefreshRecyclerView.getRecyclerView();
        //layout的方向
//        mRecyclerView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4,
//                StaggeredGridLayoutManager.VERTICAL);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(ListMainActivity.this,
//                LinearLayoutManager.VERTICAL, false);

//        FlowLayoutManager layoutManager = new FlowLayoutManager(ListMainActivity.this,
//                false);
        com.example.customview.list.manager.v2.FlowLayoutManager layoutManager =
                new com.example.customview.list.manager.v2.FlowLayoutManager();


        mRecyclerView.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        mRecyclerView.setLayoutManager(layoutManager);
        mRefreshRecyclerView.setAdapter(mAdapter);
    }


    private void initData() {

        ListEngty engty = new ListEngty();
        engty.name = "-----> ";
        mList.add(engty);
        ListEngty engty2 = new ListEngty();
        engty2.name = "djfdsjsdjfos ";
        mList.add(engty2);
        ListEngty engty3 = new ListEngty();
        engty3.name = "ooooooo ";
        mList.add(engty3);
        ListEngty engty4 = new ListEngty();
        engty4.name = "444444444444444444444 ";
        mList.add(engty4);
        ListEngty engty5 = new ListEngty();
        engty5.name = "内容4内容1内";
        mList.add(engty5);

        ListEngty engty6 = new ListEngty();
        engty6.name = "内容333 ";
        mList.add(engty6);
        ListEngty engty7 = new ListEngty();
        engty7.name = "内容 ";
        mList.add(engty7);
        ListEngty engty8 = new ListEngty();
        engty8.name = "内容166 ";
        mList.add(engty8);
        ListEngty engty9 = new ListEngty();
        engty9.name = "内容12222 ";
        mList.add(engty9);


    }

    public void starRecycleGalley(View view) {
        startActivity(new Intent(this, RecycleViewGalleryActivity.class));
    }
}
