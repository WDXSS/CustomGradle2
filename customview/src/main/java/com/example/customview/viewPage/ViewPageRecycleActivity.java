package com.example.customview.viewPage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;

import com.example.customview.R;
import com.example.customview.databinding.ActivityViewPageRecycleBinding;
import com.example.customview.viewPage.adapter.ImageAdapter2;
import com.example.customview.viewPage.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *  最简单的实现，复杂的实现在 RecycleViewGalleryActivity
 */
public class ViewPageRecycleActivity extends AppCompatActivity {
	private List<String> url = new ArrayList<>();
	private ImageAdapter2 mImageAdapter;
	private List<Integer> mList = new ArrayList<>();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActivityViewPageRecycleBinding binding = ActivityViewPageRecycleBinding.inflate(getLayoutInflater());
		View view = binding.getRoot();
		setContentView(view);
		String url1 = "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=204471953,2683458197&fm=26&gp=0.jpg";
		String url2 = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2567670815,24101428&fm=26&gp=0.jpg";
		String url3 = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1000551505,2077899926&fm=26&gp=0.jpg";
		url.add(url1);
		url.add(url2);
		url.add(url3);

		mImageAdapter = new ImageAdapter2(this, url);
		binding.ViewPager.setOffscreenPageLimit(3);
		binding.ViewPager.setAdapter(mImageAdapter);

		setRecycle(binding);
	}

	private void setRecycle(ActivityViewPageRecycleBinding binding) {
		for (int i = 0; i < 10; i++) {
			mList.add(R.mipmap.pic4);
			mList.add(R.mipmap.pic5);
			mList.add(R.mipmap.pic6);
		}

		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, url);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
				LinearLayoutManager.HORIZONTAL, false);
		binding.recyclerView.setLayoutManager(linearLayoutManager);
		binding.recyclerView.setAdapter(adapter);

		new LinearSnapHelper().attachToRecyclerView(binding.recyclerView);

		adapter.setItemClickListener(new RecyclerViewAdapter.ItemClickListener() {
			@Override
			public void onItemClick(String clickItem) {

			}

			@Override
			public void onItemLongClick(String clickItem) {

			}
		});
	}


}
