package com.example.customview.book.custom._7paint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.jetpack.DevDescribe;

@DevDescribe("RadialGradient 是Shader的另一种实现，它的含义是放射渐变，" +
        "它像一个放射源一样从一个点开始向外发散，从一种颜色渐变成另一种颜色")
public class RadialGradientActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_seven_radial_gradient);

    }
}
