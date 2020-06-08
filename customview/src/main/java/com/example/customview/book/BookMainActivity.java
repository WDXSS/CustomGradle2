package com.example.customview.book;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.book.custom.CustomBookMain;
import com.example.customview.book.light.AdvancedLightBookMain;
import com.example.kotlin.KotlinMainActivity;

public class BookMainActivity extends AppCompatActivity{
    private static final String TAG = "BookMainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_main);
        Log.i(TAG, "onCreate: BookMainActivity");
    }

    public void startCustomBook(View view) {
        Log.i(TAG, "startCustomBook: ");
        //打开自定义控件入门和实战
        Intent intent = new Intent();
        intent.setClass(this, CustomBookMain.class);
        startActivity(intent);
    }


    public void startAdvancedLightActivity(View view) {
        Log.i(TAG, "startAdvancedLightActivity: ");
        //打开android 进阶之光
        Intent intent = new Intent();
        intent.setClass(this, AdvancedLightBookMain.class);
        startActivity(intent);
    }

    public void startKotlinMainActivity(View view) {
        Log.i(TAG, "startKotlinMainActivity: ");
        Intent intent = new Intent();
        intent.setClass(this, KotlinMainActivity.class);
        startActivity(intent);
    }
    private void test(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }
}
