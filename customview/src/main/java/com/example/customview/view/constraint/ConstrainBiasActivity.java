package com.example.customview.view.constraint;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainBiasActivity extends AppCompatActivity {

    private String biasString = "在两个冲突约束出现时，可以设置 Bias 属性来控制控件在两个约束间的位置，取范围是 0 ~ 1 之间，可以使用小数，最终按设置值的百分比来进行位置定位。" +
            "如 0.2 就是两个冲突约束的 20% 的位置，0.375 就是两个冲突约束的 37.5% 的位置。 ";

    private TextView mTextView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_bias);
        mTextView = findViewById(R.id.text);
        mTextView.setText(biasString);
    }
}

