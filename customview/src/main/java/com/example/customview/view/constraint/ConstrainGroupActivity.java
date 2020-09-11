package com.example.customview.view.constraint;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainGroupActivity extends AppCompatActivity {
    private static final String TAG = "ConstrainGroupActivity";
    private Group mGroup;
    private TextView mTextView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_constrain_layout_group);

//        组的作用是可将多个控件一起隐藏或显示 。如下有三个 TextView

        mGroup = findViewById(R.id.group);
        mTextView1 = findViewById(R.id.textView1);
       LinearLayout linearLayout =  findViewById(R.id.include);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGroup.getVisibility() == View.VISIBLE) {
                    mGroup.setVisibility(View.INVISIBLE);
                    Log.i(TAG, "onClick: mGroup if");
                } else {
                    mGroup.setVisibility(View.VISIBLE);
                    Log.i(TAG, "onClick: mGroup else ");
                }
                //代码中设置隐藏显示，一定记得 调用 requestLayout()函数
                mGroup.requestLayout();

            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTextView1.getVisibility() == View.VISIBLE) {
                    Log.i(TAG, "mTextView1:  if ");
                    mTextView1.setVisibility(View.INVISIBLE);
                } else {
                    mTextView1.setVisibility(View.VISIBLE);
                    Log.i(TAG, "mTextView1:  else ");
                }

                if (linearLayout.getVisibility() == View.VISIBLE) {
                    Log.i(TAG, "linearLayout:  if ");
                    linearLayout.setVisibility(View.INVISIBLE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                    Log.i(TAG, "linearLayout:  else ");
                }
            }
        });

    }
}

