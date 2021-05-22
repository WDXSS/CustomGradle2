package com.example.book._7view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lib_custom_view2.R;

/**
 * onDrawOver
 * item 和 ItemDecoration onDraw();调用顺序
 * ItemDecoration.onDraw()， item.Draw() ; itemDecoration.onDrawOver
 */
public class LinearItemDecoration2 extends RecyclerView.ItemDecoration {
    private static final String TAG = "zhouc " + LinearItemDecoration2.class.getCanonicalName();

    private Bitmap mBitmap;
    private Paint mPaint;

    public LinearItemDecoration2(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_custom_2_launcher_round, options);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //绘制 outRect
        int viewCount = parent.getChildCount();
        Log.d(TAG, "onDraw: viewCount = "+ viewCount);

        for (int i = 0; i < viewCount; i++) {
            View child = parent.getChildAt(i);
            int top = child.getTop();//当前item 到父类Top的距离 ，包含 outRect.top 的高度；
            // 例如：如outRect.top = 50  第一个item 到父类Top的高度就是50 item.getTop = 50
            // 所以 item 不包括 ourRect
            int left = child.getLeft();
            Log.d(TAG, "onDraw: i=  " + i + ",top = " + top + ", left = " + left);
            //canvas 就是 ourRect 画布的区域
            //在 item 的左边 画⚪
            int cx = left / 2;
            int cy = top + child.getHeight() / 2;
            c.drawCircle(cx, cy, 20, mPaint);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        //每5个画出一个勋章 （使用android icon 代替）
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            //同过 layoutManager 来获取 ourRect 的边距
            assert layoutManager != null;
            int left = layoutManager.getLeftDecorationWidth(child);
            int top = layoutManager.getTopDecorationHeight(child);
            int right = layoutManager.getRightDecorationWidth(child);
            int bottom = layoutManager.getBottomDecorationHeight(child);
            int index = parent.getChildLayoutPosition(child);
            if (index % 5 == 0) {
                c.drawBitmap(mBitmap, left - mBitmap.getWidth() / 2, child.getTop(), mPaint);
            }

        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Log.d(TAG, "getItemOffsets: ");
        outRect.top = 50;
        outRect.left = 100;
        outRect.bottom = 1;
        outRect.right = 50;
    }
}
