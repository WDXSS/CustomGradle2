package com.example.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;

/**
 * @author zhouchao
 * @date 2019/11/5
 */
public class BtnEnableActivity extends AppCompatActivity {
    private static final String TAG = "WebViewActivity";
    private PopupWindow mPopWindow;
    private View mPopView;
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_enable);
        mEditText = findViewById(R.id.edit);
        Button button = findViewById(R.id.btn);

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
