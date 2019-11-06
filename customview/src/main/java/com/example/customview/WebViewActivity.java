package com.example.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
    private PopupWindow mPopWindow;
    private View mPopView;
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = findViewById(R.id.web_view);
        mWebView.loadUrl("https://my.oschina.net/xsjayz/blog/138447");
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //当进度走到100的时候做自己的操作，我这边是弹出dialog
                Log.d(TAG, "onProgressChanged  progress = [" + progress + "]");
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished() , url = [" + url + "]");
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "onPageStarted()  url = [" + url + "], favicon = [" + favicon + "]");
            }

        });

        mEditText = findViewById(R.id.edit);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: eeeeeeeeee  = " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: dddddddd = " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: aaaaaaaaa = " + s);
            }
        });
        Button button = findViewById(R.id.btn);
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = button.isEnabled();
//                button.setClickable(!b);
                button.setEnabled(!b);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onLoad(View view) {
        showPopCallPhone("dddddddddddddd");
    }

    private void showPopCallPhone(final String phoneNumber) {

        if (mPopWindow != null && mPopWindow.isShowing()) {
            return;
        }
        if (mPopWindow == null) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            mPopView = inflater.inflate(R.layout.pop_phone, null, false);

            TextView tvPhone = mPopView.findViewById(R.id.text_tel_phone);
            tvPhone.setText(phoneNumber);

            mPopWindow = new PopupWindow(mPopView,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            mPopWindow.setFocusable(false);
            mPopWindow.setOutsideTouchable(false);
            mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    WindowManager.LayoutParams lp = getWindow().getAttributes();
                    lp.alpha = 1f;
                    getWindow().setAttributes(lp);
                }
            });
            mPopView.findViewById(R.id.text_tel_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopWindow.dismiss();
                }
            });
            mPopView.findViewById(R.id.text_tel_call).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());

//        mPopWindow.showAtLocation();
        mPopWindow.showAsDropDown(mEditText,100,0);
    }

    @Override
    public void onBackPressed() {
        if (mPopWindow != null && mPopWindow.isShowing()) {
            mPopWindow.dismiss();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mPopWindow != null && mPopWindow.isShowing()) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

}
