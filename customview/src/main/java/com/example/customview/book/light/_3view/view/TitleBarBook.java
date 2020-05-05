package com.example.customview.book.light._3view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.customview.R;

public class TitleBarBook extends RelativeLayout {
    private ImageView iv_titlebar_left;
    private ImageView iv_titlebar_right;
    private TextView tv_titlebar_title;
    private RelativeLayout layout_titlebar_rootlayout;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titlename;

    public TitleBarBook(Context context) {
        super(context);
        initView(context);
    }

    public TitleBarBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypedArray(context, attrs);
        initView(context);
    }


    public TitleBarBook(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypedArray(context, attrs);
        initView(context);
    }

    private void initTypedArray(Context context, AttributeSet attrs) {
        @SuppressLint("CustomViewStyleable")
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        mColor = mTypedArray.getColor(R.styleable.TitleBar_title_bg, Color.BLUE);
        mTextColor = mTypedArray.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE);
        titlename = mTypedArray.getString(R.styleable.TitleBar_title_text);
        //获取资源后要及时回收
        mTypedArray.recycle();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.advanced_light_book_3view_customtitle, this, true);
        iv_titlebar_left = (ImageView) findViewById(R.id.iv_titlebar_left);
        iv_titlebar_right = (ImageView) findViewById(R.id.iv_titlebar_right);
        tv_titlebar_title = (TextView) findViewById(R.id.tv_titlebar_title);
        layout_titlebar_rootlayout = (RelativeLayout) findViewById(R.id.layout_titlebar_rootlayout);
        //设置背景颜色
        layout_titlebar_rootlayout.setBackgroundColor(mColor);
        //设置标题文字颜色
        tv_titlebar_title.setTextColor(mTextColor);
        setTitle(titlename);
    }

    public void setTitle(String titlename) {
        if (!TextUtils.isEmpty(titlename)) {
            tv_titlebar_title.setText(titlename);
        }
    }

    public void setLeftListener(OnClickListener onClickListener) {
        iv_titlebar_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        iv_titlebar_right.setOnClickListener(onClickListener);
    }
}
