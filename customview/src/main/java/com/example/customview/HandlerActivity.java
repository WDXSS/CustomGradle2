package com.example.customview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.Arrays;

public class HandlerActivity extends AppCompatActivity {
	private static final String TAG = "zhou HandlerActivity" ;
	private  boolean canChange = false;

	public HandlerActivity() {
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_layout);
		//没有 call back
		findViewById(R.id.button1).setOnClickListener(v -> {
			Message message1 = new Message();
			message1.obj = "not callback！！";
			mHandler1.sendMessage(message1);
		});
		//call back is false
		findViewById(R.id.button2).setOnClickListener(v -> {
			Message message = new Message();
			message.obj = "callback is  false";
			mHandler2.sendMessage(message);
			setCanChange(true);
		});
		findViewById(R.id.button3).setOnClickListener(v -> {
			Message message = new Message();
			message.obj = "callback is  true";
			mHandler3.sendMessage(message);
		});
	}

	public void setCanChange(boolean canChange) {
		this.canChange = canChange;
	}

	private final Handler mHandler1 = new Handler(){
		@Override
		public void handleMessage(@NonNull Message msg) {
			super.handleMessage(msg);

			Log.d(TAG, "mHandler1  handleMessage()  with: msg = [" + msg.obj + "]");
		}
	};



	private Handler mHandler2 = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(@NonNull Message msg) {
			Log.d(TAG, "mHandler2  handleMessage() called with: msg = [" + msg.obj + "]");
			return false;
		}
	});


	private Handler mHandler3 = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(@NonNull Message msg) {
			Log.d(TAG, "mHandler3  handleMessage() called with: msg = [" + msg.obj + "]");
			//返回 true 就不会调用 handler 的 handleMessage
			if(canChange){
				Log.d(TAG, "handleMessage() called with: canChange = [" + canChange + "]");
			}
			return true;
		}
	});

	private void test(){
		try {
			Class c = Handler.class;
			Field f  = c.getDeclaredField("FIND_POTENTIAL_LEAKS");
			f.setAccessible(true);
			boolean b = (boolean) f.get(c);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}



	private static class InnerClass{

	}
}
