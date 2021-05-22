package com.example.book._01cammera;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_custom_view2.databinding.Custom01MainActivityBinding;

public class _01MainActivityJava extends AppCompatActivity {
    Custom01MainActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = Custom01MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.seekBarY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.translateY.setProcess(progress);
                binding.title.setText("Y轴移动 "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.translateY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_01MainActivityJava.this,"点击图片 的范围测试",Toast.LENGTH_LONG).show();
            }
        });
    }
}
