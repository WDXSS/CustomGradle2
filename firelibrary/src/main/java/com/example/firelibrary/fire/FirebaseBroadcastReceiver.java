package com.example.firelibrary.fire;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.legacy.content.WakefulBroadcastReceiver;

public class FirebaseBroadcastReceiver extends WakefulBroadcastReceiver {
    private static final String TAG = "FirebaseBroadcastReceiv";

    @Override
    public void onReceive(Context context, Intent intent) {
        for (String key : intent.getExtras().keySet()) {
            Log.i(TAG, "printlnMessage: key = " + key);
        }
    }
}