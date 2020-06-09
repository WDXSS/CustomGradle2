package com.example.customview.other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class CoordinatorLayoutMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_main);
    }

    public void startDemo1(View view) {
        startActivity(new Intent(CoordinatorLayoutMainActivity.this, CoordinatorLayoutDemo.class));
    }
}
