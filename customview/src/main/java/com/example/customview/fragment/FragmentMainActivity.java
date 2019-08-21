package com.example.customview.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.customview.R;

/**
 * Fragment 生命周期整理
 *
 * 结论：
 * 1.生命周期执行过程：
 * 启动activity---
 * Activity: onCreate
 * Fragment01: onCreate
 * Fragment01: onCreateView:
 * Fragment01: onViewCreated
 * Fragment01: onActivityCreated:
 * Fragment01: onStart:
 * Activity: onStart:
 * Activity: onResume:
 * Fragment01: onResume:
 *
 * 返回建---
 * Fragment01: onPause:
 * Activity: onPause:
 * Fragment01: onStop:
 * Activity: onStop:
 * Fragment01: onDestroyView:
 * Fragment01: onDestroy:
 * Fragment01: onDetach:
 * Activity: onDestroy:
 *
 * home 键 ---
 * Fragment01: onPause:
 * Activity: onPause:
 * Fragment01: onStop:
 * Activity: onStop:
 *
 * 再次显示----
 * Activity: onRestart:
 * Fragment01: onStart:
 * Activity: onStart:
 * Activity: onResume:
 * Fragment01: onResume
 *
 * 2. Fragment01和 Fragment02 show 和 hide 操作：
 *    fragment 不会执行 onStop();
 *    执行 onHiddenChanged();
 *
 * 3.在Activity的onCreate() 中调用 Fragment hide() 注意 onHiddenChanged()执行时机：
 * Activity: onCreate:
 * Fragment02: onCreate:
 * Fragment02: onCreateView:
 * Fragment02: onViewCreated:
 * Fragment02: onActivityCreated:
 * Fragment02: onHiddenChanged:
 * Fragment02: onStart:
 */
public class FragmentMainActivity extends AppCompatActivity {
    private static final String TAG = "FragmentMainActivity";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        Log.d(TAG, "onCreate: ");

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment fragment1 = Fragment01.newFragment();
        Fragment fragment2 = Fragment02.newFragment();
        transaction.add(R.id.layout_contain1, fragment1, "fragment01");
        transaction.add(R.id.layout_contain1, fragment2, "fragment02");
        transaction.show(fragment1);
        transaction.hide(fragment2);

        transaction.commitAllowingStateLoss();

        findViewById(R.id.btn).setOnClickListener(v -> {
            FragmentTransaction transaction12 = mFragmentManager.beginTransaction();
            //显示2
            transaction12.hide(fragment1);
            transaction12.show(fragment2);
            transaction12.commitAllowingStateLoss();
        });
        findViewById(R.id.btn1).setOnClickListener(v -> {

            FragmentTransaction transaction1 = mFragmentManager.beginTransaction();
            //显示1
            transaction1.hide(fragment2);
            transaction1.show(fragment1);
            transaction1.commitAllowingStateLoss();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

}
