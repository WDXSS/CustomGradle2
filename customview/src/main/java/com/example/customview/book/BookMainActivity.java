package com.example.customview.book;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.book.custom.CustomBookMain;

public class BookMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_main);
    }

    public void startCustomBook(View view) {
        //打开自定义控件入门和实战
        Intent intent = new Intent();
        intent.setClass(this, CustomBookMain.class);
        startActivity(intent);
    }


}
