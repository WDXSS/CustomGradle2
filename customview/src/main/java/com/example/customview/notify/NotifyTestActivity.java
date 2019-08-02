package com.example.customview.notify;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class NotifyTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(true){
//            finish();
//            return;
//        }
        setContentView(R.layout.activity_test_notify);
    }
}
