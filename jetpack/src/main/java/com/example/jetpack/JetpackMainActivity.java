package com.example.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jetpack.lifecycle.LifecycleActivity;
import com.example.jetpack.livedata.ui.LiveDataMainActivity;
import com.example.jetpack.livedata.ui.LiveDataMapActivity;
import com.example.jetpack.navigation.NavigationMainActivity;
import com.example.jetpack.viewModel.ViewModelMainActivity;

public class JetpackMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack_main);
    }

    public void onStartLifeCycle(View view) {
        startActivity(new Intent(JetpackMainActivity.this, LifecycleActivity.class));
    }

    public void onStartLiveData(View view) {
        startActivity(new Intent(JetpackMainActivity.this, LiveDataMainActivity.class));
    }

    public void onStartNavigation(View view) {
        startActivity(new Intent(JetpackMainActivity.this, NavigationMainActivity.class));
    }

    public void onStartLiveData2(View view) {
        startActivity(new Intent(JetpackMainActivity.this, LiveDataMapActivity.class));

    }

    public void onStartViewModel(View view) {
        startActivity(new Intent(JetpackMainActivity.this, ViewModelMainActivity.class));
    }
}
