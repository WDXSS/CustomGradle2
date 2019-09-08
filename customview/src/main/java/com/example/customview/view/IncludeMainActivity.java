package com.example.customview.view;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class IncludeMainActivity extends AppCompatActivity {
    private static final String TAG = "IncludeMainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include_main);

        //TODO include 的layout只有一个 TextView 时
        TextView layout = findViewById(R.id.layout1);
        TextView layout2 = findViewById(R.id.layout2);
        //TODO include 的layout是一个 ViewGroup 时
//        TextView tv1= layout.findViewById(R.id.item_text);
//        TextView tv2= layout2.findViewById(R.id.item_text);
        Log.d(TAG, "onCreate: tv1 = " + layout);
        Log.d(TAG, "onCreate: tv2 = " + layout2);

        layout.setText("layout1");
        layout2.setText("layout2");
    }
}
