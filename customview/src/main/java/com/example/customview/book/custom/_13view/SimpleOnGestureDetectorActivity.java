package com.example.customview.book.custom._13view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@SuppressLint("LongLogTag")
@DevDescribe("通过 SimpleOnGestureDetector 理解 onFling() 的用法")
public class SimpleOnGestureDetectorActivity extends AppCompatActivity {
    private static final String TAG = "SimpleOnGestureDetectorActivity";
    private final int fling_min_velocity = 100;
    private TextView mTextView;
    private GestureDetector mGestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coustom_book_13_gesture_detector_simple);
        //要实现的功能：当用户向左滑动的距离超过100像素，且滑动的速度超过 100 像素/秒，即判断向左滑动，同理向右滑动

        //核心代码：在 onFling() 函数中判定当前滑动的方向和滑动速度是否到达 指定的值
        mGestureDetector = new GestureDetector(this, new SimpleOnGestureDetectorImpl(this));

        mTextView = findViewById(R.id.gesture_detector_tv);
        //在OnTouch 事件中进行拦截
        mTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mGestureDetector.onTouchEvent(event);
            }
        });
        mTextView.setFocusable(true);
        mTextView.setClickable(true);
        mTextView.setLongClickable(true);
    }

    private static class SimpleOnGestureDetectorImpl extends GestureDetector.SimpleOnGestureListener {
        final int fling_min_distance = 100;
        final int fling_min_velocity = 100;
        private Context mContext;

        public SimpleOnGestureDetectorImpl(Context context) {
            mContext = context;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //e1  第一次 down 时的位置
            //e2  最后一次 move 的位置
            //velocityX  X轴的速度，单位 100 像素/秒
            //velocityY  Y 轴的速度 单位 100 像素/秒

            if (e1.getX() - e2.getX() > fling_min_distance && Math.abs(velocityX) > fling_min_velocity) {
                //向左滑动
                Log.i(TAG, "onFling: 向左滑动");
                Toast.makeText(mContext,"向左滑动",Toast.LENGTH_SHORT).show();

            } else if (e2.getX() - e1.getX() > fling_min_distance && Math.abs(velocityX) > fling_min_velocity) {
                //向右滑动
                Log.i(TAG, "onFling: 向右滑动");
                Toast.makeText(mContext,"向右滑动",Toast.LENGTH_SHORT).show();
            }

            return true;
        }
    }
}
