package com.example.customview.book.light._3view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codingending.uisystemdemo.MainActivity;
import com.example.customview.R;
import com.example.customview.book.light._3view.view.TitleBarBook;

public class TitleBarActivity extends AppCompatActivity {
    private TitleBarBook mTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_light_book_3view_title_bar);

        mTitleBar = (TitleBarBook) this.findViewById(R.id.title);
//      mTitleBar.setTitle("自定义组合控件");

        mTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TitleBarActivity.this, "点击左键", Toast.LENGTH_SHORT).show();
            }
        });

        mTitleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TitleBarActivity.this, "点击右键", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
