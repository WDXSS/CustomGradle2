package com.example.customview.view.constraint;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import com.example.customview.R;

/**
 * Placeholder(占位符)
 *
 * @author zhouchao
 * @date 2020/8/4
 */
public class ConstrainPlaceholderActivity extends AppCompatActivity {
    private Placeholder mPlaceholder;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_placeholder);

        mPlaceholder = findViewById(R.id.placeholder);
        mConstraintLayout = findViewById(R.id.constraint);
//        如果添加动画需要在 setContent(id) 前为根布局 ConstraintLayout 设置动画即可
         findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //设置动画
                 TransitionManager.beginDelayedTransition(mConstraintLayout);
                 mPlaceholder.setContentId(R.id.imageView1);

             }
         });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置动画
                TransitionManager.beginDelayedTransition(mConstraintLayout);
                mPlaceholder.setContentId(R.id.imageView2);
            }
        });
    }
}
