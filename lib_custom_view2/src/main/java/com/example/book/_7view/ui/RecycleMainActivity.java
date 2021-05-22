package com.example.book._7view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.book.BookCustomMainActivity;
import com.example.lib_custom_view2.R;

public class RecycleMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_07_main_activity);
    }

    public void itemDecoration1(View view) {
        startActivity(new Intent(RecycleMainActivity.this, ItemDecorationActivity.class));
    }

    public void itemDecoration2(View view) {
        startActivity(new Intent(RecycleMainActivity.this, ItemDecoration2Activity.class));
    }

    public void customLayoutManager(View view) {
        startActivity(new Intent(RecycleMainActivity.this, LayoutManagerActivity1.class));
    }
}
