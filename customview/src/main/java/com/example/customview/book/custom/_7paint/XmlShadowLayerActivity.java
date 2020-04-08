package com.example.customview.book.custom._7paint;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class XmlShadowLayerActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_seven_text_shadow_layer);
        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setShadowLayer(2,5,5, Color.GRAY);
    }
}
