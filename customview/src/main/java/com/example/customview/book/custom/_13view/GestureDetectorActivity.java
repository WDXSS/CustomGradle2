package com.example.customview.book.custom._13view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("手势 GestureDetector 只設置了 OnGestureListener ")
public class GestureDetectorActivity extends AppCompatActivity {
    private static final String TAG = "GestureDetectorActivity";
    private TextView mTvContent;
    private TextView mTextView;
    private GestureDetector mGestureDetector;
    private OnGestureListenerImpl mOnGestureListenerImpl;


    private StringBuffer mStringBuffer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coustom_book_13_gesture_detector);
        mStringBuffer = new StringBuffer();
        init();
//        GestureDetector 类提供了两个接口 OnGestureListener 和 OnDoubleTapListener 和 一个外部实现类 SimpleOnGestureListener.
//        mTextView 添加 手势监听

    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {

        mTvContent = findViewById(R.id.tv_gesture_detector);

        mOnGestureListenerImpl = new OnGestureListenerImpl();
        mGestureDetector = new GestureDetector(this, mOnGestureListenerImpl);

        mTextView = findViewById(R.id.gesture_detector_tv);
        //在OnTouch 事件中进行拦截
        mTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                printlnMsg();
                return mGestureDetector.onTouchEvent(event);
            }
        });
        mTextView.setFocusable(true);
        mTextView.setClickable(true);
        mTextView.setLongClickable(true);

    }

    private void printlnMsg() {
        mTvContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTvContent.setText(mOnGestureListenerImpl.getMsg());
            }
        }, 1000);
    }

    private static class OnGestureListenerImpl implements GestureDetector.OnGestureListener {

        private final StringBuffer mStringBuffer;

        public OnGestureListenerImpl() {
            mStringBuffer = new StringBuffer();
        }

        @Override
        public boolean onDown(MotionEvent e) {
            //当用户按下屏幕就会触发该函数
            mStringBuffer.delete(0, mStringBuffer.length());
            String msg = "onDown: 当用户按下屏幕就会触发该函数";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            String msg = "onShowPress: 按下的时间超过瞬间，并且没有拖动或者滑动，触发该函数";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            //按下的时间超过瞬间，并且没有拖动或者滑动，触发该函数
        }

        @Override
        public void onLongPress(MotionEvent e) {
            String msg = "onLongPress: 长按屏幕，超过一定时长，就会触发该函数.    执行顺序：onDown()--->onShowPress()---->onLongPress()";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            //长按屏幕，超过一定时长，就会触发该函数
            // 执行顺序：onDown()--->onShowPress()---->onLongPress()
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            String msg = "onSingleTapUp: 点击一下屏幕，立刻抬起来，才会触发该函数。如果除了down 以外沒有其他操作，如滑动等     执行顺序：onDown()--->onSingleTapUp()";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            //点击一下屏幕，立刻抬起来，才会触发该函数。如果除了down 以外还有其他操作，如滑动等
            // 执行顺序：onDown()--->onSingleTapUp()
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            String msg = "onScroll: 在屏幕上拖动事件，无论是手拖动view，还是以抛的形式滚动，都会多次触发这个函数      拖动执行顺序：onDown()---> onScroll()---->onScroll()------>onFling()";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            //在屏幕上拖动事件，无论是手拖动view，还是以抛的形式滚动，都会多次触发这个函数
            // 拖动执行顺序：onDown()---> onScroll()---->onScroll()------>onFling();
            //无论滑屏还是拖动，影响的只是中间 onScroll() 的数量，最终都会调用到 onFling() 函数
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            String msg = "onFling: 滑屏 用户按下屏幕，快速移动后松开，有一个 MotionEvent.ACTION_DOWN ,多个MotionEvent.ACTION_MOVE, 一个 MotionEvent.ACTION_UP 触发 " +
                    "      滑屏执行顺序：onDown()---> onScroll()......onScroll()------>onFling()";
            mStringBuffer.append(msg);
            mStringBuffer.append("\n");
            Log.v(TAG, msg);
            ;
            //滑屏 用户按下屏幕，快速移动后松开，有一个 MotionEvent.ACTION_DOWN ,多个MotionEvent.ACTION_MOVE, 一个 MotionEvent.ACTION_UP 触发
            // 滑屏执行顺序：onDown()---> onScroll()......onScroll()------>onFling();
            //e1 : 第一个 ACTION_DOWN 事件
            //e2 : 最后一个 ACTION_MOVE 事件
            //velocityX : x轴上的移动速度，单位为 像素 / 秒
            //velocityY : y 轴上的移动速度，单位为 像素 / 秒
            return true;
        }

        public String getMsg() {
            return mStringBuffer.toString();
        }
    }
}
