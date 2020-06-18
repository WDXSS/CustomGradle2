package com.example.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhouchao
 * @date 2019/11/5
 */
public class WebViewActivity extends AppCompatActivity {
    private static final String TAG = "WebViewActivity";
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private boolean loadingFailed = true;
    private boolean loadingFinish = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = findViewById(R.id.web_view);
        mProgressBar = findViewById(R.id.progressBar1);
        mWebView.loadUrl("https://my.oschina.net/xsjayz/blog/138447");

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished() , url = [" + url + "]");
                loadingFinish = true;
                mHandler.sendEmptyMessage(1);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingFailed = false;
                loadingFinish = false;
                Log.d(TAG, "onPageStarted()  url = [" + url + "], favicon = [" + favicon + "]");
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.d(TAG, "onReceivedError() called with:, request = [" + request + "], error = [" + error + "]");
                //加载失败 执行在 onPageFinished 之前

                loadingFailed = true;
                mHandler.sendEmptyMessage(1);
            }

        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //当进度走到100的时候做自己的操作，我这边是弹出dialog
                Log.d(TAG, "onProgressChanged  progress = [" + progress + "]");
                if (progress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(progress);
                }
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onLoad(View view) {
//        mWebView.reload();
    }


    private  Handler mHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Log.d(TAG, "handleMessage: msg loadingFailed  = "+ loadingFailed + ",loadingFinish = " + loadingFinish);
                    break;
            }
            return false;
        }
    });
}
