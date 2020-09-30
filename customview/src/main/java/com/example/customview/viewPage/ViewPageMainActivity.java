package com.example.customview.viewPage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.databinding.ActivityViewPageMainBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewPageMainActivity extends AppCompatActivity {

	private ImageAdapter mImageAdapter;
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
		mImageAdapter = new ImageAdapter(url);
		binding.ViewPager.setAdapter(mImageAdapter);

	}
}
