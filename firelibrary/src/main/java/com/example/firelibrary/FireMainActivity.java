package com.example.firelibrary;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import javax.net.ssl.SSLContext;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class FireMainActivity extends AppCompatActivity {
    //測試 fireBase
    private static final String TAG = "FireMainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_main);
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        test();
        notification();
//        SSLContext
        getString(R.string.fire_base_name_private);//
    }

    private void test(){
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        // Log and toast
                        Log.d(TAG, "token = "+ token);
                        Toast.makeText(FireMainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void notification(){
        if (getIntent() != null && getIntent().getExtras() != null) {
            String title = (String) getIntent().getExtras().get("title");
            String body = (String) getIntent().getExtras().get("body");
            System.out.println("title = "+ title + ", body = "+ body);
            System.out.println("shuju = "+ getIntent().getExtras());
            System.out.println("actionClick = "+ getIntent().getExtras().getString("click_action"));
        }
        printlnMessage();
    }
    private void printlnMessage(){
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Log.i(TAG, "printlnMessage: key = "+ key);
//                Object value = getIntent().getExtras().getString(key);
//                if(value instanceof Long){
//                    Log.i(TAG, "printlnMessage: key = " + key + ": value = " + (Long)value);
//                }else if (value instanceof Integer){
//                    Log.i(TAG, "printlnMessage: key = " + key + ": value = " + (Integer)value);
//                }else{
//                    Log.i(TAG, "printlnMessage: key = " + key + ": value = " + value);
//                }

            }
        }
    }
}