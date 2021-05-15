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
 * PolyToPolySample2View简介
 * 将图分为 8 分，画出第一份
 * 在PolyToPolySample1View 的基础上切割第一部分
 *
 * @author ext.zhouchao3
 * @date 2021-04-19 11:31
 */
public class PolyToPolySample2View extends View {
	private Matrix mMatrix;
	private static int sTransHeight = 100;//简单的 偏移100
	private static int sFoldsNum = 8;
	private int mFoldsWidth;
	private Bitmap mBitmap;
	private int mBitmapHeight;
	private int mBitmapWidth;

	public PolyToPolySample2View(Context context) {
		super(context);
		init();
	}

	public PolyToPolySample2View(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PolyToPolySample2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mMatrix = new Matrix();
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.sample);
		mBitmapWidth = mBitmap.getWidth();
		mBitmapHeight = mBitmap.getHeight();
		mFoldsWidth = mBitmapWidth / sFoldsNum;
		//原图坐标
		float[] src = {0, 0, mBitmapWidth, 0, mBitmapWidth, mBitmapHeight, 0, mBitmapHeight};
		float[] dst = {0, 0, mBitmapWidth, sTransHeight, mBitmapWidth, mBitmapHeight + sTransHeight, 0, mBitmapHeight};

		mMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		Rect rect = new Rect(0, 0, mFoldsWidth, mBitmapHeight);
		canvas.setMatrix(mMatrix);
		canvas.clipRect(rect);
		canvas.drawBitmap(mBitmap, 0, 0, null);
		canvas.restore();
	}
}
