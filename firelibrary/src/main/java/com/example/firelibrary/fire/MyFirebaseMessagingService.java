package com.example.firelibrary.fire;

import android.content.Intent;
import android.util.Log;

import androidx.core.view.ViewCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingServ";

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        System.out.println("onNewToken = " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "收到推送 From: " + remoteMessage.getNotification());
        Log.d(TAG, "收到推送 From: " + remoteMessage.getFrom());
        Intent intent = remoteMessage.toIntent();
        for (String key : intent.getExtras().keySet()) {
//            Log.i(TAG, "printlnMessage: key = "+ key);
            Object value = intent.getExtras().getString(key);
            if (value instanceof Long) {
                Log.i(TAG, "printlnMessage: key = " + key + ": value = " + (Long) value);
            } else if (value instanceof Integer) {
                Log.i(TAG, "printlnMessage: key = " + key + ": value = " + (Integer) value);
            } else {
                Log.i(TAG, "printlnMessage: key = " + key + ": value = " + value);
            }
        }

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "收到推送 Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "收到通知 Message Notification Body: "
                    + remoteMessage.getNotification().getBody());
            Log.d(TAG, "收到通知 Message Notification getClickAction: "
                    + remoteMessage.getNotification().getClickAction());
        }
    }
}
