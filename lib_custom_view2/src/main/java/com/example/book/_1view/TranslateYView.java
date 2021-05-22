package com.example.book._1view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.lib_custom_view2.R;

@SuppressLint("AppCompatCustomView")
public class TranslateYView extends ImageView {

	private Bitmap mBitmap;
	private Paint mPaint;
	private Camera mCamera;
	private Matrix mMatrix;

	private int process;
	public TranslateYView(Context context) {
		super(context);
		init();
	}

	public TranslateYView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TranslateYView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public TranslateYView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init(){
		mCamera = new Camera();
		mMatrix = new Matrix();
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.save();
		mCamera.save();

		mPaint.setAlpha(100);
		canvas.drawBitmap(mBitmap,0,0,mPaint);//绘制对比图

		mCamera.rotateY(process);//旋转
		mCamera.getMatrix(mMatrix);

		canvas.setMatrix(mMatrix);
		mCamera.restore();
		super.onDraw(canvas);
		canvas.restore();
	}

	public void setProcess(int process) {
		this.process = process;
		postInvalidate();
	}
}
