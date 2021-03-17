package com.example.customview.list.viewpage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.R;
import com.example.customview.list.viewpage.helper.CardScaleHelper;
import com.example.customview.list.viewpage.util.BlurBitmapUtils;
import com.example.customview.list.viewpage.util.ViewSwitchUtils;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewGalleryActivity extends Activity {

	private RecyclerView mRecyclerView;
	private ImageView mBlurView;
	private List<Integer> mList = new ArrayList<>();
	private CardScaleHelper mCardScaleHelper = null;
	private Runnable mBlurRunnable;
	private int mLastPos = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
		setContentView(R.layout.activity_recycler_view_galley);
		init();
	}

	private void init() {
		for (int i = 0; i < 10; i++) {
			mList.add(R.mipmap.pic4);
			mList.add(R.mipmap.pic5);
			mList.add(R.mipmap.pic6);
		}

		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mRecyclerView.setLayoutManager(linearLayoutManager);
		mRecyclerView.setAdapter(new CardAdapter(mList));
		// mRecyclerView绑定scale效果
		mCardScaleHelper = new CardScaleHelper();
		mCardScaleHelper.setCurrentItemPos(2);
		mCardScaleHelper.attachToRecyclerView(mRecyclerView);
		initBlurBackground();
	}

	private void initBlurBackground() {
		mBlurView = (ImageView) findViewById(R.id.blurView);
		mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);
				if (newState == RecyclerView.SCROLL_STATE_IDLE) {
					notifyBackgroundChange();
				}
			}
		});

		notifyBackgroundChange();
	}

	private void notifyBackgroundChange() {
		if (mLastPos == mCardScaleHelper.getCurrentItemPos()) {
			return;
		}
		mLastPos = mCardScaleHelper.getCurrentItemPos();
		final int resId = mList.get(mCardScaleHelper.getCurrentItemPos());
		mBlurView.removeCallbacks(mBlurRunnable);
		mBlurRunnable = new Runnable() {
			@Override
			public void run() {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
				ViewSwitchUtils.startSwitchBackgroundAnim(mBlurView, BlurBitmapUtils.getBlurBitmap(mBlurView.getContext(), bitmap, 15));
			}
		};
		mBlurView.postDelayed(mBlurRunnable, 500);
	}

}
