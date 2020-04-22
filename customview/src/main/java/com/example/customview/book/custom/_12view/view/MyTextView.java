package com.example.customview.book.custom._12view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("自定义属性")
public class MyTextView extends AppCompatTextView {
    private static final String TAG = "MyTextView";

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("Recycle")
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //MyTextView.xml 文件是在， res/values 目录下
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        String headerName = typedArray.getString(R.styleable.MyTextView_header_name);
        float headerHeight = typedArray.getDimension(R.styleable.MyTextView_header_height, 0f);
        int age = typedArray.getInt(R.styleable.MyTextView_age, 0);
        int orientation = typedArray.getInt(R.styleable.MyTextView_orientation, 0);

        //注意使用完后，必须调用 typedArray.recycle();
        typedArray.recycle();

        Log.d(TAG, "MyTextView() called with: headerName = [" + headerName + "], headerHeight = [" + headerHeight + "], age = [" + age + "]");
        Log.d(TAG, "MyTextView() called with: orientation = " + orientation);
        //flag 和枚举 的区别
//        app:age="child|yang|old"  flag
//        app:orientation="vertical" enum
    }


}
