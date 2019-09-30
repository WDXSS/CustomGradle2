package com.example.jetpack.navigation;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.jetpack.R;
import com.example.jetpack.navigation.fragment.OneFragment;
import com.example.jetpack.navigation.fragment.TwoFragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationMainActivity extends AppCompatActivity implements
        OneFragment.OnFragmentInteractionListener, TwoFragment.OnFragmentInteractionListener {
    private static final String TAG = "NavigationMainActivity";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "onFragmentInteraction: ");
    }
}
