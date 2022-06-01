package com.example.customview.anim.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.customview.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * dialog 样式的activity 设置 activity 的切换动画
 */
public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_layout);
        windowColor();
    }

    public void windowColor() {
        Window window = getWindow();
        //取消设置Window半透明的Flag
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏为透明/或者需要的颜色
        window.setStatusBarColor(ContextCompat.getColor(DialogActivity.this, R.color.colorPrimary));

        getWindow().setGravity(Gravity.BOTTOM);//设置显示在底部 默认在中间
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width =WindowManager.LayoutParams.MATCH_PARENT;//设置宽度满屏
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
        setFinishOnTouchOutside(true);//允许点击空白处关闭
    }
}
