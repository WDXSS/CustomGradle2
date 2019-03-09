package com.example.customview.anim.view.tween;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.customview.R;

/**
 * <a href="http://download.broadview.com.cn/Original/1702283fe85cd96c0310">效果</a>
 */
public class ScannerDome extends AppCompatActivity {

    private Button startBtn;
    private ImageView scannerImg;
    private ImageView scannerImg2;
    private ImageView scannerImg3;
    private ImageView scannerImg4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scanner);
        startBtn = findViewById(R.id.start);
        scannerImg = findViewById(R.id.scannerImg1);
        scannerImg2 = findViewById(R.id.scannerImg2);
        scannerImg3 = findViewById(R.id.scannerImg3);
        scannerImg4 = findViewById(R.id.scannerImg4);

        final Animation animation1 = AnimationUtils.loadAnimation(ScannerDome.this,R.anim.scanner_anim);
        final Animation animation2 = AnimationUtils.loadAnimation(ScannerDome.this,R.anim.scanner_anim);
        final Animation animation3 = AnimationUtils.loadAnimation(ScannerDome.this,R.anim.scanner_anim);
        final Animation animation4 = AnimationUtils.loadAnimation(ScannerDome.this,R.anim.scanner_anim);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scannerImg.startAnimation(animation1);

                animation2.setStartOffset(600);
                scannerImg2.startAnimation(animation2);

                animation3.setStartOffset(1200);
                scannerImg3.startAnimation(animation3);

                animation4.setStartOffset(1800);
                scannerImg4.startAnimation(animation4);
            }
        });

    }

}
