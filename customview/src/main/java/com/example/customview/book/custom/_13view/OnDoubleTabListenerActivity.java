package com.example.customview.book.custom._13view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;


@SuppressLint("LongLogTag")
@DevDescribe("GestureDetector.OnDoubleTapListener 的实现")
public class OnDoubleTabListenerActivity extends AppCompatActivity {
    private static final String TAG = "OnDoubleTabListenerActivity";
    private OnGestureListenerImpl mOnGestureListener;
    private OnDoubleTapListenerImpl mOnDoubleTapListener;
    private GestureDetector mGestureDetector;
    private View mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coustom_book_13_gesture_detector_double_tap);


        init();
    }

    private void init() {
        mOnGestureListener = new OnGestureListenerImpl();
        mOnDoubleTapListener = new OnDoubleTapListenerImpl();
        //构造方法中必须传入一个 OnGestureListener
        mGestureDetector = new GestureDetector(this, mOnGestureListener);
        mGestureDetector.setOnDoubleTapListener(mOnDoubleTapListener);

        mTextView = findViewById(R.id._13_gesture_detector_tv);
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

    private static class OnGestureListenerImpl implements GestureDetector.OnGestureListener {


        @Override
        public boolean onDown(MotionEvent e) {
            //当用户按下屏幕就会触发该函数
            Log.v(TAG, "onDown: 当用户按下屏幕就会触发该函数");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.v(TAG, "onShowPress: 按下的时间超过瞬间，并且没有拖动或者滑动，触发该函数");
            //按下的时间超过瞬间，并且没有拖动或者滑动，触发该函数
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.v(TAG, "onLongPress: 长按屏幕，超过一定时长，就会触发该函数.   ");
            //长按屏幕，超过一定时长，就会触发该函数
            // 执行顺序：onDown()--->onShowPress()---->onLongPress()
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.v(TAG, "onSingleTapUp: 点击一下屏幕，立刻抬起来，才会触发该函数。如果除了down 以外还有其他操作，如滑动等  ");
            //点击一下屏幕，立刻抬起来，才会触发该函数。如果除了down 以外还有其他操作，如滑动等
            // 执行顺序：onDown()--->onSingleTapUp()
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.v(TAG, "onScroll: 在屏幕上拖动事件，无论是手拖动view，还是以抛的形式滚动，都会多次触发这个函数 ");
            //在屏幕上拖动事件，无论是手拖动view，还是以抛的形式滚动，都会多次触发这个函数
            // 拖动执行顺序：onDown()---> onScroll()---->onScroll()------>onFling();
            //无论滑屏还是拖动，影响的只是中间 onScroll() 的数量，最终都会调用到 onFling() 函数
            return true;
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.v(TAG, "onFling: 滑屏 用户按下屏幕，快速移动后松开");
            //滑屏 用户按下屏幕，快速移动后松开，有一个 MotionEvent.ACTION_DOWN ,多个MotionEvent.ACTION_MOVE, 一个 MotionEvent.ACTION_UP 触发
            // 滑屏执行顺序：onDown()---> onScroll()......onScroll()------>onFling();
            return true;
        }
    }


    private static class OnDoubleTapListenerImpl implements GestureDetector.OnDoubleTapListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.v(TAG, "OnDoubleTapListener.onSingleTapConfirmed: 单击事件 " +
                    "执行顺序：OnGestureListener.onDown() ---> OnGestureListener.onSingleTapUp() ---> OnDoubleTapListener.onSingleTapConfirmed()");
            //单击事件
            //执行顺序：OnGestureListener.onDown() ---> OnGestureListener.onSingleTapUp() ---> OnDoubleTapListener.onSingleTapConfirmed()

            // OnGestureListener.onSingleTapUp() 和 OnDoubleTapListener.onSingleTapConfirmed() 区别
            // OnGestureListener.onSingleTapUp() 只要抬手就会触发
            // OnDoubleTapListener.onSingleTapConfirmed()  如果双击，就不会触发
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.v(TAG, "OnDoubleTapListener.onDoubleTap:  双击事件 ");


            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.v(TAG, "OnDoubleTapListener.onDoubleTapEvent:  双击间隔中发生的 --- 动作   指的是在触发 onDoubleTap() 以后，在双击之间发生的其他动作，包含：down, up move 事件");
            //双击间隔中发生的 --- 动作   指的是在触发 onDoubleTap() 以后，在双击之间发生的其他动作，包含：down, up move 事件
            //
            return true;
        }
    }
}
