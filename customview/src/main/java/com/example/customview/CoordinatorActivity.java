package com.example.customview;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

/**
 * @author zhouchao
 * @date 2019/11/12
 */
public class CoordinatorActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_uibase);
    }
}
