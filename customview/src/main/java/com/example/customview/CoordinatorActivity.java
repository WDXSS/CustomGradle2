package com.example.customview;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.jetpack.DevDescribe;

/**
 *
 * 参考：https://www.jianshu.com/p/4bb9ee0e0177
 *      https://www.jianshu.com/p/06c0ae8d9a96
 * @author zhouchao
 * @date 2019/11/12
 */
@DevDescribe("折叠整理")
public class CoordinatorActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_uibase);

        mWebView = findViewById(R.id.web_view);
        mWebView.loadUrl("https://www.jianshu.com/p/06c0ae8d9a96");
//        1.CoordinatorLayout
//        2.AppBarLayout
//        3.CollapsingToolbarLayout
//        4.Toolbar
//        5.layout_behavior
//        6.FloatingActionButton
    }
}
