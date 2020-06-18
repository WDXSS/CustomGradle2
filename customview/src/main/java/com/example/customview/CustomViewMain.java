package com.example.customview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.codingending.uisystemdemo.MainActivity;
import com.example.android_hs_library.HuangShuMainActivity;
import com.example.customview.book.BookMainActivity;
import com.example.customview.fragment.FragmentMainActivity;
import com.example.customview.list.ListMainActivity;
import com.example.customview.notify.NotifyMain;
import com.example.customview.other.CoordinatorLayoutMainActivity;
import com.example.customview.other.ImmersionActivity;
import com.example.customview.regex.RegexMainActivity;
import com.example.customview.util.NumberUtil;
import com.example.customview.view.IncludeMainActivity;
import com.example.firelibrary.FireMainActivity;
import com.example.jetpack.JetpackMainActivity;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;


public class CustomViewMain extends AppCompatActivity {
    private static final String TAG = "CustomViewMain";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //蜘蛛网
        setContentView(R.layout.layout_spider);
//        setContentView(R.layout.contraint09);
        notification();
        getSupperClass();
        verifyStoragePermissions(this);
//        LogCollector.getInstance(getApplication()).start();
        GifImageView gifImageView = findViewById(R.id.main_balance_img);
    }

    private void generateNum5() {
        Random random = new Random();
        //生成5位的随机数
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        double dou = random.nextDouble() * 90000 + 10000;
        Log.d(TAG, "startBookMain() random.nextDouble() = [" + dou + "]");
        Log.d(TAG, "startBookMain() random.nextDouble() = [" + (99999 - 10000 + 1) + "]");
        Log.d(TAG, "startBookMain() rannum = [" + rannum + "]");
        Log.d(TAG, "startBookMain() Math.random()*100 = [" + Math.random() * 100 + "]");

        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "startBookMain() random.nextDouble() *100 = [" + random.nextDouble() * 100000 + "]");
        }
    }

    private void luhnTest() {
        EditText editText = findViewById(R.id.luhn);
        String cardNo = editText.getText().toString();
        boolean b = NumberUtil.LuhnCheck(cardNo);
        Log.d(TAG, "onCreate: Luhn 算法 的结果 ：b = " + b);
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

    public void startBookMain(View view) {
        startActivity(new Intent(CustomViewMain.this, BookMainActivity.class));
//        luhnTest();
//        generateNum5();
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
        Log.i(TAG, "onRequestPermissionsResult: requestCode = " + requestCode);
        for (String permission : permissions) {
            Log.i(TAG, "onRequestPermissionsResult: permission = " + permission);
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

    public void lifecycle(View view) {
//        startActivity(new Intent(this, LifecycleActivity.class));
//        startActivity(new Intent(this, LiveDataMainActivity.class));
        startActivity(new Intent(this, JetpackMainActivity.class));
    }

    public void startInclude(View view) {
        startActivity(new Intent(CustomViewMain.this, IncludeMainActivity.class));
    }

    public void startWeb(View view) {
        startActivity(new Intent(CustomViewMain.this, WebViewActivity.class));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d(TAG, "onWindowFocusChanged() called with: hasFocus = [" + hasFocus + "]");
    }


    public void coordinator(View view) {
        startActivity(new Intent(CustomViewMain.this, CoordinatorActivity.class));
    }

    public void immerisive(View view) {
        //c沉浸式
        startActivity(new Intent(CustomViewMain.this, ImmersionActivity.class));
    }

    public void startCoordinatorLayout(View view) {
        startActivity(new Intent(CustomViewMain.this, CoordinatorLayoutMainActivity.class));
    }

    private boolean isCall = false;

    public void callPhone(View view) {

        if (checkReadPermission(Manifest.permission.CALL_PHONE, 10111)) {
//            Intent intents [] = new Intent[2];
//            Intent intent = new Intent(this,ImmersionActivity.class);
//            intents[0] = intent;
            //拨打电话
            Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 12345566));
            startActivityForResult(intent1, 9999);
            isCall = true;
//
//            intents[1] = intent1;
//            startActivities(intents);
        }

    }

    public boolean checkReadPermission(String string_permission, int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }


    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent() called with: intent = [" + intent + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
        if (isCall) {
            isCall = false;
            Intent intent = new Intent(this, ImmersionActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }


    public void startRegexActivity(View view) {
        Intent intent = new Intent(this, RegexMainActivity.class);
        startActivity(intent);
    }
}
