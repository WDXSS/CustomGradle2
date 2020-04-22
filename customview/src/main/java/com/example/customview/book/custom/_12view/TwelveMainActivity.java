package com.example.customview.book.custom._12view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("第12章 ：封装控件")
public class TwelveMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve_main);
    }

    public void startDeclareStyleableActivity(View view) {
        startActivity(new Intent(this, DeclareStyleableActivity.class));
    }
}
