package com.example.customview.other;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

/**
 * https://blog.csdn.net/u010629285/article/details/102993431
 */
@DevDescribe("沉浸式")
public class ImmersionActivity extends AppCompatActivity {
    private static final String TAG = "ImmersionActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //set no title bar 需要在setContentView之前调用
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //如果上面的不起作用，可以换成下面的。
//        if (getSupportActionBar() != null) getSupportActionBar().hide();
//        if (getActionBar() != null) getActionBar().hide();
//        //no status bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.immersion_activity);
//        hideSystemUI();
        setTest();
        findViewById(R.id.topBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              hideSystemUI();
            }
        });
        findViewById(R.id.bottomBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSystemUI();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent() called with: intent = [" + intent + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }


    private  void setTest(){
        View decorView = getWindow().getDecorView();

        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        System.out.println("zhou visibility = " + visibility);
                        Log.d(TAG, "onSystemUiVisibilityChange: visibility = "+visibility);
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            // TODO: The system bars are visible. Make any desired
                            System.out.println("zhou 显示  00 = " + visibility);
                            Log.d(TAG, "onSystemUiVisibilityChange: zhou 显示  00 =");
                        } else {
                            // TODO: The system bars are NOT visible. Make any desired
                            System.out.println("zhou 不显示  00 = " + visibility);
                            Log.d(TAG, "onSystemUiVisibilityChange: zhou 不显示  00 =");
                        }
                    }
                });

    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        int height = decorView.getHeight();
        Log.d(TAG, "hideSystemUI: height = "+ height);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int useableScreenHeight = dm.heightPixels;
        Log.d(TAG, "hideSystemUI: useableScreenHeight = "+ useableScreenHeight);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN

                     );

//                SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                SYSTEM_UI_FLAG_HIDE_NAVIGATION

//                SYSTEM_UI_FLAG_LAYOUT_STABLE  来帮助您的应用保持稳定布局
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        int height = decorView.getHeight();
        Log.d(TAG, "showSystemUI: height = "+ height);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int useableScreenHeight = dm.heightPixels;
        Log.d(TAG, "showSystemUI: useableScreenHeight = "+ useableScreenHeight);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
