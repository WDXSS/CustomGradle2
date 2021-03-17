package com.example.customview.viewPage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.databinding.ActivityViewPageMainBinding;
import com.example.customview.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewPageMainActivity extends AppCompatActivity {

	private ImageAdapter mImageAdapter;
	private ImageAdapter2 mImageAdapter2;
	private List<String> url = new ArrayList<>();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityViewPageMainBinding binding = ActivityViewPageMainBinding.inflate(getLayoutInflater());
		View view = binding.getRoot();
		setContentView(view);
		String url1 = "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=204471953,2683458197&fm=26&gp=0.jpg";
		String url2 = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2567670815,24101428&fm=26&gp=0.jpg";
		String url3 = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1000551505,2077899926&fm=26&gp=0.jpg";
		url.add(url1);
		url.add(url2);
		url.add(url3);
		mImageAdapter = new ImageAdapter(this, url);
		binding.ViewPager.setAdapter(mImageAdapter);



		//注意 ViewPager 和 ViewPager2 的区别
		//1.ViewPager2 多追加了一个父类
		//2. ImageAdapter2 没有重新 getPageWidth() 方法，
		//3. setPageMargin 设置viewPage 两个item直接的边距，可有可无
		mImageAdapter2 = new ImageAdapter2(this, url);
		//设置Page间间距
//		binding.ViewPager2.setPageMargin(ScreenUtils.dip2px(this, 20));
		//设置缓存的页面数量
		binding.ViewPager2.setOffscreenPageLimit(3);
		binding.ViewPager2.setAdapter(mImageAdapter2);

	}
}
