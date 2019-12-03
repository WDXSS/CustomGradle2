package com.example.customview.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2019/11/13
 */
public class WebActivity extends CoordinatorActivity {
    private static final String TAG = "WebActivity";
    WebView mWebView;
    @Override
    protected View getContentLayout() {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_webview,null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams( FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        mWebView = view.findViewById(R.id.web_view);
        mWebView.loadUrl("https://www.jianshu.com/p/06c0ae8d9a96");

        //代码中
//        mNestedScrollView.setFillViewport(false);
        return view;
    }

    @Override
    public void test() {
        Log.d(TAG, "test() called");
    }

    @Override
    public void onBackPressed() {
        //1
        super.onBackPressed();
    }
}
