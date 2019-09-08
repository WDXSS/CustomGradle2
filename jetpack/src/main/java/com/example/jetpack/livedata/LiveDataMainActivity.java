package com.example.jetpack.livedata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.jetpack.R;

public class LiveDataMainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LiveDataMainActivity";
    private TextView mTextView;
    private Button mButton;
    private MutableLiveData<String> mLiveData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_main);

        mButton = findViewById(R.id.live_data_btn);
        mButton.setOnClickListener(this);
        mTextView = findViewById(R.id.live_data_text);
        mLiveData = new MutableLiveData<>();
        mLiveData.setValue("start");
        mLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i(TAG, "onChanged: s = " + s);
                mTextView.setText(s);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.live_data_btn) {
            mLiveData.setValue("onClick");
        }
    }
}
