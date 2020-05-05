package com.example.customview.book.light._3view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class ThreeMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_light_book_3view);
    }

    public void startTitleBarActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TitleBarActivity.class);
        startActivity(intent);
    }
}
