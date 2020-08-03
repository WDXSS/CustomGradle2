package com.example.customview.view.constraint;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainBarrierActivity2 extends AppCompatActivity {

    private EditText mEditTextA;
    private EditText mEditTextB;
    private TextView mTextViewA;
    private TextView mTextViewB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_barrier2);

//        屏障一般用在下面的场景：控件A，控件B的宽度都是自适应的，
//        在程序运行期间有可能 控件A 的宽度比 控件B 的宽度大，也有可能比 控件B 宽度小，
//        此时 控件C 需要一直显示在 控件A 和 控件B 的右边。这时可以为 控件A 和 控件B 添加屏障，
//        让 控件C 约束在屏障的右边，即可实现效果。

//        Barrier 有主要的两个属性
//        app:constraint_referenced_ids（设置屏障与哪些控件建立约束，填写控件id，多个 id 使用逗号 "," 分割）
//        app:barrierDirection (设置 Barrier 显示在约束控件的方向：top，left，bottom，right 以及 start【同left】，end【同right】)

        mEditTextA = findViewById(R.id.edit1);
        mEditTextB = findViewById(R.id.edit2);
        mTextViewA = findViewById(R.id.textView1);
        mTextViewB = findViewById(R.id.textView2);

        mEditTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTextViewA.setText(s);
            }
        });
        mEditTextB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTextViewB.setText(s);
            }
        });
    }
}

