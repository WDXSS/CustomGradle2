package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.anim.property.value.LoadingDemo;
import com.example.customview.anim.view.tween.ScannerDome;
import com.example.customview.list.viewpage.v2.ui.GalleryRecyclerViewActivity;
import com.example.customview.view.NineViewActivity;
import com.example.customview.view.SpiderActivity;
import com.example.customview.viewPage.ViewPageMainActivity;
import com.example.customview.viewPage.ViewPageRecycleActivity;
import com.example.customview.widget.TextViewMainActivity;


public class DrawViewMain extends AppCompatActivity {
    private static final String TAG = "DrawViewMain";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_view_main);
        LogWriteUtil.writeLogtoFile("v","TAG","1234566");

    }

    public void startSpider(View view) {
        startActivity(new Intent(DrawViewMain.this, SpiderActivity.class));

    }

    public void startScannerDome(View view) {
        startActivity(new Intent(DrawViewMain.this, ScannerDome.class));
    }

    public void startLoadingDemo(View view) {

        startActivity(new Intent(DrawViewMain.this, LoadingDemo.class));
    }

    public void threadBlock(View view) {

        for (;;){
            Log.d(TAG, "threadBlock: ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    public void startNine(View view) {
        startActivity(new Intent(DrawViewMain.this, NineViewActivity.class));
    }
    public void startViewPage(View view) {
        startActivity(new Intent(DrawViewMain.this, ViewPageMainActivity.class));
    }
    public void startViewPageRecycle(View view) {
        startActivity(new Intent(DrawViewMain.this, ViewPageRecycleActivity.class));
    }
    public void startViewPageRecycle2(View view) {
        startActivity(new Intent(DrawViewMain.this, GalleryRecyclerViewActivity.class));
    }
    public void startExpandableTextView(View view) {
        startActivity(new Intent(DrawViewMain.this, TextViewMainActivity.class));
    }
}
