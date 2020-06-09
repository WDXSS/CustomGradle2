package com.example.customview.other;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/6/9
 * https://blog.csdn.net/u010629285/article/details/102993431
 */
public class ImmersionActivity extends AppCompatActivity {
    private static final String TAG = "ImmersionActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set no title bar 需要在setContentView之前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //如果上面的不起作用，可以换成下面的。
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        if (getActionBar() != null) getActionBar().hide();
        //no status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.immersion_activity);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent() called with: intent = [" + intent + "]");
    }
}
