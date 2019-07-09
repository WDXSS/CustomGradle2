package com.codingending.uisystemdemo.base;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 演示控件的基础Activity
 * Created by CodingEnding on 2018/2/12.
 */

public abstract class BaseWidgetDemoActivity extends AppCompatActivity{
    public static final String KEY_WIDGET_TYPE="widget_type";

    /**
     * 从Intent中解析出type，并根据type加载Fragment
     */
    protected abstract void loadFragment();
}
