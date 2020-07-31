package com.example.customview.bitmap;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * 设置图片的饱和度
 * @author zhouchao
 * @date 2020/6/8
 */
public class ImgFilterActivity extends AppCompatActivity {
    private static final String TAG = "ImgFilterActivity";
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private ColorMatrix mCm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.img_filter_activity);
        mImageView = findViewById(R.id.img);
        mSeekBar = findViewById(R.id.sb_1);

        mCm = new ColorMatrix();
        mCm.setSaturation(0.0f); // 设置饱和度:0为纯黑白，饱和度为0；1为饱和度为100，即原图；
        ColorMatrixColorFilter grayColorFilter = new ColorMatrixColorFilter(mCm);
        mImageView.setColorFilter(grayColorFilter);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float filter = ((float) progress /100);
                Log.d(TAG, "onProgressChanged() called with: seekBar = [" + seekBar + "], progress = [" + filter + "], fromUser = [" + fromUser + "]");
                mCm.setSaturation(filter);
                ColorMatrixColorFilter grayColorFilter = new ColorMatrixColorFilter(mCm);
                mImageView.setColorFilter(grayColorFilter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
