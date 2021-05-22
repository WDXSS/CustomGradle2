package com.example.book._7view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "zhouc "+ LinearItemDecoration.class.getCanonicalName();

    private Paint mPaint;
    public LinearItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //绘制 outRect
        int viewCount = parent.getChildCount();
        for (int i = 0; i < viewCount; i++) {
            View child = parent.getChildAt(i);
           int top = child.getTop();//当前item 到父类Top的距离 ，包含 outRect.top 的高度；
                                    // 例如：如outRect.top = 50  第一个item 到父类Top的高度就是50 item.getTop = 50
                                    // 所以 item 不包括 ourRect
           int left = child.getLeft();
            Log.d(TAG, "onDraw: i=  "+ i + ",top = "+ top +", left = "+ left );
            //canvas 就是 ourRect 画布的区域
            //在 item 的左边 画⚪
            int cx = left/2;
            int cy = top + child.getHeight()/2;
            c.drawCircle(cx,cy,20,mPaint);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Log.d(TAG, "getItemOffsets: ");
        outRect.top= 50;
        outRect.left = 100;
        outRect.bottom = 1;
        outRect.right = 50;
    }
}
