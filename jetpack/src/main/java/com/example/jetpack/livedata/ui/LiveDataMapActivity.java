package com.example.jetpack.livedata.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.example.jetpack.R;

public class LiveDataMapActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";
	MutableLiveData<String> mutableLiveData1;
	MutableLiveData<String> mutableLiveData2;
	MutableLiveData<Boolean> liveDataSwitch;
	private boolean mBoolean = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_live_data_main);
		mutableLiveData1 = new MutableLiveData<>();
		mutableLiveData2 = new MutableLiveData<>();
		liveDataSwitch = new MutableLiveData<Boolean>();//1

		LiveData transformedLiveData = Transformations.switchMap(liveDataSwitch, new Function<Boolean, LiveData<String>>() {
			@Override
			public LiveData<String> apply(Boolean input) {
				if (input) {
					return mutableLiveData1;
				} else {
					return mutableLiveData2;
				}
			}
		});

		transformedLiveData.observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable final String s) {
				Log.d(TAG, "onChanged:" + s);
			}
		});
		liveDataSwitch.postValue(mBoolean);//2
		mutableLiveData1.postValue("Android进阶之光");
		mutableLiveData2.postValue("Android进阶解密");

		findViewById(R.id.live_data_btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				liveDataSwitch.postValue(!mBoolean);
				mBoolean = !mBoolean;
			}
		});

		mediatorLiveDataTest();
	}
	/**
	 * 测试 MediatorLiveData
	 */
	private void mediatorLiveDataTest(){
		MutableLiveData<String> mutableLiveData1  = new MutableLiveData<>();
		MutableLiveData<String> mutableLiveData2  = new MutableLiveData<>();
		MediatorLiveData liveDataMerger = new MediatorLiveData<String>();
		liveDataMerger.addSource(mutableLiveData1, new Observer() {
			@Override
			public void onChanged(@Nullable Object o) {
				Log.d(TAG, "mediatorLiveDataTest onChanged1:"+o.toString());
			}
		});

		liveDataMerger.addSource(mutableLiveData2, new Observer() {
			@Override
			public void onChanged(@Nullable Object o) {
				Log.d(TAG, "mediatorLiveDataTest onChanged2:"+o.toString());
			}
		});
		liveDataMerger.observe(this, new Observer() {
			@Override
			public void onChanged(@Nullable Object o) {
				Log.d(TAG, "mediatorLiveDataTest onChanged:"+o.toString());
			}
		});
		mutableLiveData1.postValue("Android进阶之光");
		liveDataMerger.postValue("");
	}

}
