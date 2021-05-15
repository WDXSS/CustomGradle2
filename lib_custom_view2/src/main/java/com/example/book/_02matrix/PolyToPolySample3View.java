package com.example.book._02matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.lib_custom_view2.R;

/**
 * PolyToPolySample3View简介
 * 画出向上倾斜的部分
 *
 * @author ext.zhouchao3
 * @date 2021-04-22 18:50
 */
public class PolyToPolySample3View extends View {

	private Matrix mMatrix1;
	private Matrix mMatrix2;
	private Bitmap mBitmap;
	private static int sTransHeight = 100;//简单的 偏移100
	private static int sFoldsNum = 8;
	private int mBitmapWidth;
	private int mBitmapHeight;
	private int mFoldsWidth;

	public PolyToPolySample3View(Context context) {
		super(context);
		initView2();
	}

	public PolyToPolySample3View(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		initView2();
	}

	public PolyToPolySample3View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView2();
	}

	private void initView1() {
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.sample);
		mMatrix1 = new Matrix();
		mBitmapWidth = mBitmap.getWidth();
		mBitmapHeight = mBitmap.getHeight();
		mFoldsWidth = mBitmapWidth / sFoldsNum;
		//原图坐标
		float[] src = {0, 0, mBitmapWidth, 0, mBitmapWidth, mBitmapHeight, 0, mBitmapHeight};
		float[] dst = {0, 0, mBitmapWidth, sTransHeight, mBitmapWidth, mBitmapHeight + sTransHeight, 0, mBitmapHeight};
		mMatrix1.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
	}

	private void initView2() {
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.sample);
		mMatrix2 = new Matrix();
		mBitmapWidth = mBitmap.getWidth();
		mBitmapHeight = mBitmap.getHeight();
		mFoldsWidth = mBitmapWidth / sFoldsNum;

		float[] src = {0, 0, mBitmapWidth, 0, mBitmapWidth, mBitmapHeight, 0, mBitmapHeight};
		float[] dst = {0, sTransHeight, mBitmapWidth, - sTransHeight, mBitmapWidth, mBitmapHeight - sTransHeight, 0, mBitmapHeight + sTransHeight};
		mMatrix2.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		canvas.setMatrix(mMatrix2);
		Rect rect = new Rect();
		canvas.drawBitmap(mBitmap, 0, 0, null);
		canvas.restore();
	}
}
