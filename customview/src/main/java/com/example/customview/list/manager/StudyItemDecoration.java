package com.example.customview.list.manager;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.util.ScreenUtils;

class StudyItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "zhou";

    public StudyItemDecoration() {
        super();
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int viewCount = parent.getChildCount();
        for (int i = 0; i <viewCount ; i++) {
            View view = parent.getChildAt(i);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = 100;
        outRect.top = 50;
        Log.d(TAG, "getItemOffsets: left = ");
    }
}
