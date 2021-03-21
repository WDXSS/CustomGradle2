package com.example.customview.viewPage.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.customview.R;
import com.example.customview.util.ScreenUtils;

import java.util.List;

/**
 * ImageAdapter简介
 *  设置 ViewPage 中 下一个 item 显示一部分
 * @author ext.zhouchao3
 * @date 2020-09-30 15:38
 */
public class ImageAdapter extends PagerAdapter {
	private static final String TAG = "ImageAdapter";
	private List<String> urls;
	private Context mContext;

	public ImageAdapter(Context context,List<String> urls) {
		this.urls = urls;
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return urls.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		Log.d(TAG, "instantiateItem() called with: container = [" + container + "], position = [" + position + "]");
		View view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_page_imgage_item, container, false);
		ImageView img = view.findViewById(R.id.img);
		Glide.with(container.getContext()).load(urls.get(position)).into(img);
		container.addView(view);
		return view;
	}

	// PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
	@Override
	public void destroyItem(ViewGroup view, int position, Object object) {
		view.removeView((View) object);
	}

	@Override
	public float getPageWidth(int position) {
		return  0.8560F;
	}


}




















