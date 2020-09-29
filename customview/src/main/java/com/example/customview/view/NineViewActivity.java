package com.example.customview.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.widget.Nine4View;

import java.util.ArrayList;
import java.util.List;

/**
 * NineViewActivity简介
 *
 * @author ext.zhouchao3
 * @date 2020-09-29 14:29
 */
public class NineViewActivity extends AppCompatActivity {
	private Nine4View mBookListView;
	private List<String> urls = new ArrayList<>();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nine_view);
		mBookListView = findViewById(R.id.book_list);

		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mBookListView.setChildImageUrl("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=204471953,2683458197&fm=26&gp=0.jpg",
						"https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2567670815,24101428&fm=26&gp=0.jpg",
						"https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1000551505,2077899926&fm=26&gp=0.jpg");
			}
		});
	}
}
