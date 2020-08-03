package com.example.customview.view.constraint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * @author zhouchao
 * @date 2020/8/3
 */
public class ConstrainGuidelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain_layout_guide_line);

//        android:orientation 属性指定 Guideline 的样式，vertical  是垂直线，horizontal 是水平线。
//        此外它还有三个属性用来设置定位方式，定位的方式是与父布局 ConstraintLayout 边距。在同一个 Guideline 中三个属性只有
//        app:layout_constraintGuide_begin="20dp" 依据开始位置定位。水平线是上边距，垂直线是左边距。
//        app:layout_constraintGuide_end="20dp" 依据结束位置定位。水平线是下边距，垂直线是右边距。
//        app:layout_constraintGuide_percent="0.2" 依据父布局百分比定位。水平线依据屏幕高度的百分比，垂直线是屏幕宽度的百分比。取值范围是 0~1，0.2 即  20%。
    }
}

