package com.example.customview.book.custom._10canvas;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("点击动态变圆角")
public class ShapeInstanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_shape_instance);

        final TextView tv = (TextView)findViewById(R.id.shape_tv);

        findViewById(R.id.add_shape_corner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xml 中的 shape 对应的类是GradientDrawable 不是 ShapeDrawable
                GradientDrawable drawable = (GradientDrawable) tv.getBackground();
                drawable.setCornerRadius(20);
                //注意点：
                //再次打开activity 时 textView 的背景还是圆角
                //重新运行应用 后恢复成直角
            }
        });
    }
}
