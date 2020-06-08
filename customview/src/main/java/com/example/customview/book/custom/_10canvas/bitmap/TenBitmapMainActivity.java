package com.example.customview.book.custom._10canvas.bitmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.customview.R;

public class TenBitmapMainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_10_bitmap_main);

        findViewById(R.id.decode_byte_array_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, decodeByteArrayActivity.class));
            }
        });

        findViewById(R.id.decode_stream_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, decodeStreamActivity.class));
            }
        });

        findViewById(R.id.bitmap_factory_option_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, BitmapFactoryOptionsActivity.class));
            }
        });

        findViewById(R.id.bitmap_static_constructor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, BitmapStaticConstructorActivity.class));
            }
        });

        findViewById(R.id.bitmap_extract_alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, ExtraAlphaActivity.class));
            }
        });

        findViewById(R.id.bitmap_density).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, BitmapDensityActivity.class));
            }
        });

        findViewById(R.id.bitmap_pixel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, BitmapPixelActivity.class));
            }
        });

        findViewById(R.id.bitmap_compress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, BitmapCompressActivity.class));
            }
        });

        findViewById(R.id.bitmap_watermark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenBitmapMainActivity.this, WaterMarkActivity.class));
            }
        });
    }




}
