package com.example.customview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.customview.R;

public class LayoutInflateView extends LinearLayout {
	public LayoutInflateView(Context context) {
		super(context);
		initView();
	}

	public LayoutInflateView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public LayoutInflateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}


	private void initView(){
		View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_inflater_learn_view,this,true);
//		addView(view);
	}
}
