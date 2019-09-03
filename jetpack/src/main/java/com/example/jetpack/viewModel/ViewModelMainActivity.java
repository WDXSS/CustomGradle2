package com.example.jetpack.viewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.jetpack.R;
import com.example.jetpack.viewModel.step5.Activity_step5;

/**
 * https://blog.csdn.net/qq_17766199/article/details/80732836
 */
public class ViewModelMainActivity extends AppCompatActivity {
    private static final String TAG = "ViewModelMainActivity";
    private ViewModelProvider mOf;

    private LiveDataTimerViewModel mLiveDataTimerViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chrono_activity_3);
        //TODO viewModel 创建
        mOf = ViewModelProviders.of(this);
        MyViewModel myViewModel = mOf.get(MyViewModel.class);

        //TODO ViewModel 简单使用
        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        subscribe();

        Log.i(TAG, "onCreate: " + ViewModelMainActivity.class.getCanonicalName());
        //log  com.example.jetpack.viewModel.ViewModelMainActivity
        Log.i(TAG, "onCreate: " + ViewModelMainActivity.class.getSimpleName());
        //log   ViewModelMainActivity

        //TODO ViewModel Fragment 共享数据
        //1.ViewModel的生命周期

    }

    private void subscribe() {

        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                String newText = ViewModelMainActivity.this.getResources().getString(R.string.seconds, aLong);
                ((TextView) findViewById(R.id.timer_textview)).setText(newText);
                Log.d("ViewModelMainActivity", "Updating timer");
            }
        };

        LiveData<Long> liveData =  mLiveDataTimerViewModel.getElapsedTime();
        // TODO 添加数据监听
        liveData.observe(this, elapsedTimeObserver);
    }

    public void onShareData(View view) {
        startActivity(new Intent(this, Activity_step5.class));
    }
}
