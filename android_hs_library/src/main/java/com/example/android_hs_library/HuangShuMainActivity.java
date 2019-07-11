package com.example.android_hs_library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_hs_library.cardview.CardViewActivity;

public class HuangShuMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void startCardView(View view) {
        startActivity(new Intent(HuangShuMainActivity.this, CardViewActivity.class));
    }
}
