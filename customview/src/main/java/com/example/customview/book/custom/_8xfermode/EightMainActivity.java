package com.example.customview.book.custom._8xfermode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("混合模式：Xfermode")
public class EightMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_main);
    }

    public void startAvoidXfermodeColorActivity(View view) {
        //混合模式之替换颜色
        startActivity(new Intent(this, AvoidXfermodeColorActivity.class));
    }

    public void startPorterDuffXfermodeActivity(View view) {
        //混合模式之替换颜色
        startActivity(new Intent(this, PorterDuffXfermodeActivity.class));
    }

    public void starTwitter(View view) {
        startActivity(new Intent(this, TwitterActivity.class));
    }

    public void startPorterDuffXfermodeSrcActivity(View view) {
        startActivity(new Intent(this, PorterDuffXfermodeSrcActivity.class));
    }

    public void startEraserSrcOutActivity(View view) {
        startActivity(new Intent(this, EraserSrcOutActivity.class));
    }

    public void startRoundImageActivity(View view) {
        startActivity(new Intent(this, RoundImageActivity.class));
    }

    public void startPorterDuffXfermodeDstActivity(View view) {
        startActivity(new Intent(this, PorterDuffXfermodeDstActivity.class));

    }

    public void startPorterDuffXfermodeClearActivity(View view) {
        startActivity(new Intent(this, PorterDuffXfermodeClearActivity.class));
    }
}
