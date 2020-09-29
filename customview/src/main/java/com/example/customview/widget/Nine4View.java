package com.example.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Nine4View extends FrameLayout {
	private static final String TAG = "BookListView";
	private int bgColor;
	private float parentRadius = 4;
	private int childRadius = 4;
	private final int childSize = 4;
	private List<ImageView> mImageViewList;
	private int topBottomMargin = 8;
	private int leftRightMargin = 8;

	private int defaultColor = 0xFFC3C6CE;

	public Nine4View(@NonNull Context context) {
		super(context);
		initView(context, null);
	}

	public Nine4View(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		initView(context, attrs);
	}

	private void initView(Context context, AttributeSet attrs) {
//
//		if (attrs != null) {
//			final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BookListView);
//			childRadius = a.getDimensionPixelSize(R.styleable.BookListView_book_corner_radius, 4);
//			leftRightMargin = a.getDimensionPixelSize(R.styleable.BookListView_book_left_right_margin, 8);
//			topBottomMargin = a.getDimensionPixelSize(R.styleable.BookListView_book_top_bottom_margin, 8);
//			parentRadius = a.getDimensionPixelSize(R.styleable.BookListView_book_parent_radius, 4);
//			bgColor = a.getColor(R.styleable.BookListView_book_parent_color, Color.BLACK);
//			a.recycle();
//			setRadiusBgColor(bgColor, parentRadius);
//		}parentRadius

		if (mImageViewList == null) {
			mImageViewList = new ArrayList<>(4);
		}
		removeAllViews();
		mImageViewList.clear();

		for (int i = 0; i < childSize; i++) {
			ImageView roundedImageView = new ImageView(context);
			roundedImageView.setImageDrawable(new ColorDrawable(defaultColor));
			roundedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
			mImageViewList.add(roundedImageView);
			addView(roundedImageView);
		}
	}

	public void setChildImageUrl(String... urls) {
		if (urls != null && urls.length > 0) {
			for (int i = 0; i < childSize; i++) {
				if (i < urls.length) {
					Glide.with(getContext()).load(urls[i]).into(mImageViewList.get(i));
				} else {
					mImageViewList.get(i).setImageDrawable(new ColorDrawable(defaultColor));
				}
			}
		} else {
			for (int i = 0; i < childSize; i++) {
				mImageViewList.get(i).setImageDrawable(new ColorDrawable(defaultColor));
			}
		}
	}

	public void setRadiusBgColor(int bgColor, float r) {
		this.bgColor = bgColor;
		this.parentRadius = r;
		// 外部矩形弧度
		float[] outerR = new float[]{r, r, r, r, r, r, r, r};
		// 内部矩形与外部矩形的距离
		RectF inset = new RectF(0, 0, 0, 0);
		RoundRectShape rr = new RoundRectShape(outerR, inset, null);
		ShapeDrawable drawable = new ShapeDrawable(rr);
		drawable.getPaint().setColor(bgColor);
		drawable.getPaint().setStyle(Paint.Style.FILL);
		setBackground(drawable);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}


	//通过调整 activity 中 btn 和 View 的上下位置，观察打印的值，得出，left ，top， right ，bottom 的值都是到 view 到父类的距离
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		Log.d(TAG, "onLayout() called with: changed = [" + changed + "], left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "]");
		if (mImageViewList == null || mImageViewList.size() != childSize) {
			super.onLayout(changed, left, top, right, bottom);
			return;
		}
		int w = right - left; //控件的宽度
		int h = bottom - top; //控件的高度
		for (int i = 0; i < childSize; i++) {
			ImageView roundedImageView = mImageViewList.get(i);
			int l = 0, t = 0, r = 0, b = 0;
			switch (i) {
				case 0:
					l = leftRightMargin;
					t = topBottomMargin;
					r = Math.max(w / 2 - leftRightMargin / 2, l);
					b = Math.max(h / 2 - topBottomMargin / 2, t);
					break;
				case 1:
					l = w / 2 + leftRightMargin / 2;
					t = topBottomMargin;
					r = Math.max(w - leftRightMargin, l);
					b = Math.max(h / 2 - topBottomMargin / 2, t);
					break;
				case 2:
					l = leftRightMargin;
					t = h / 2 + topBottomMargin / 2;
					r = Math.max(w / 2 - leftRightMargin / 2, l);
					b = Math.max(h - topBottomMargin, t);
					break;
				case 3:
					l = w / 2 + leftRightMargin / 2;
					t = h / 2 + topBottomMargin / 2;
					r = Math.max(w - leftRightMargin, l);
					b = Math.max(h - topBottomMargin, t);
					break;
			}
			roundedImageView.layout(l, t, r, b);
		}
	}
}
