package com.example.customview.book.custom._9canvas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("Canvas 与图层 ")
public class NineMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_main);
    }

    public void startCanvasMatrixActivity(View view) {
        startActivity(new Intent(this, SaveFlagMatrixActivity.class));
    }

    public void startClipSaveFlagActivity(View view) {


    }
}
