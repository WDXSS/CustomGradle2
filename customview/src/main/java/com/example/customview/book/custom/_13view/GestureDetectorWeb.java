package com.example.customview.book.custom._13view;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("手势检测 两个接口的总结")
public class GestureDetectorWeb extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coustom_book_13_gesture_detector_web);

        WebView webView = findViewById(R.id.web_13_gesture_detector);
        String url = "file:///android_asset/custom/_13_gestureDetector.html";
        webView.loadUrl(url);
    }
}
