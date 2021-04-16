package com.example.book._02matrix;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_custom_view2.databinding.ActivityPolyTopPolyLayoutBinding;

public class PolyToPolySampleActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityPolyTopPolyLayoutBinding binding = ActivityPolyTopPolyLayoutBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
	}
}
