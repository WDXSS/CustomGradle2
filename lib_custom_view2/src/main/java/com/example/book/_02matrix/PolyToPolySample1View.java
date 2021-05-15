package com.example.book._02matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.lib_custom_view2.R;


/**
 * PolyToPolySample1View简介
 * 倾斜整张图
 * @author ext.zhouchao3
 * @date 2021-04-19 11:30
 */
public class PolyToPolySample1View extends View {
	private static final String TAG = "PolyToPolySample1View";
	private Bitmap mBitmap;
	private static int sTransHeight = 100;//简单的 偏移100
	private Matrix mMatrix;

	public PolyToPolySample1View(Context context) {
		super(context);
		init();
	}

	public PolyToPolySample1View(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PolyToPolySample1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.sample);
		mMatrix = new Matrix();
		int bitmapWidth = mBitmap.getWidth();
		int bitmapHeight = mBitmap.getHeight();
		//原始的四个点的坐标
		float[] src = {0, 0, bitmapWidth, 0, bitmapWidth, bitmapHeight, 0, bitmapHeight};
		//错切 后的四个点的坐标
		float[] dst = {0, 0, bitmapWidth, sTransHeight, bitmapWidth, bitmapHeight + sTransHeight, 0, bitmapHeight};
		Log.d(TAG, "init() called src.length = " + src.length);
		mMatrix.setPolyToPoly(src, 0, dst, 0, src.length >> 1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		canvas.setMatrix(mMatrix);
		canvas.drawBitmap(mBitmap, 0, 0, null);
		canvas.restore();

	}
}
