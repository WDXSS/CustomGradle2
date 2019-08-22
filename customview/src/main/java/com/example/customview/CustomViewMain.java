package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codingending.uisystemdemo.MainActivity;
import com.example.android_hs_library.HuangShuMainActivity;
import com.example.customview.fragment.FragmentMainActivity;
import com.example.customview.list.ListMainActivity;
import com.example.customview.notify.NotifyMain;
import com.example.firelibrary.FireMainActivity;



public class CustomViewMain extends AppCompatActivity {
    private static final String TAG = "CustomViewMain";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //蜘蛛网
        setContentView(R.layout.layout_spider);
        notification();
        getSupperClass();
    }

    private void notification() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            String title = (String) getIntent().getExtras().get("title");
            String body = (String) getIntent().getExtras().get("body");
            System.out.println("title = " + title + ", body = " + body);
            System.out.println("shuju = " + getIntent().getExtras());
            System.out.println("actionClick = " + getIntent().getExtras().getString("click_action"));
        }

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Log.i(TAG, "printlnMessage: key = " + key + ",value = " + getIntent().getExtras().get(key));
            }
        }
    }

    public void startUISystem(View view) {
        startActivity(new Intent(CustomViewMain.this, MainActivity.class));
    }

    public void startDrawMain(View view) {
        startActivity(new Intent(CustomViewMain.this, DrawViewMain.class));
    }

    public void startHuangShu(View view) {
        startActivity(new Intent(CustomViewMain.this, HuangShuMainActivity.class));
    }

    public void startNotify(View view) {
        startActivity(new Intent(CustomViewMain.this, NotifyMain.class));
    }

    public void startFireBase(View view) {
        startActivity(new Intent(CustomViewMain.this, FireMainActivity.class));
    }


    private void getSupperClass() {


    }

    public void startFragment(View view) {
        startActivity(new Intent(CustomViewMain.this, FragmentMainActivity.class));
    }

    public void startListView(View view) {
        startActivity(new Intent(CustomViewMain.this, ListMainActivity.class));
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.i(TAG, "onRequestPermissionsResult: requestCode = "+ requestCode);
        for (String permission : permissions) {
            Log.i(TAG, "onRequestPermissionsResult: permission = "+ permission);
        }
        for (int grantResult : grantResults) {
            Log.i(TAG, "onRequestPermissionsResult: grantResult = " + grantResult);
        }
    }

    public void reqPermission(View view) {
        DeviceInfo.reqPermission(CustomViewMain.this);
    }

    public void checkPermission(View view) {
        DeviceInfo.getImeiNew(CustomViewMain.this);
    }
}
