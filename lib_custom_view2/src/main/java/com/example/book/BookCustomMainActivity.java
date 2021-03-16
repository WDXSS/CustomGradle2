/**
 * Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.
 */

package com.example.book;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_custom_view2.databinding.BookCustomMainBinding;

/**
 * I am test
 * 1.viewBinding 和 dataBinding
 */
public class BookCustomMainActivity extends AppCompatActivity {
	private BookCustomMainBinding mBookCustomMainBinding;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		mBookCustomMainBinding = DataBindingUtil.setContentView(this, R.layout.book_custom_main);
		mBookCustomMainBinding = BookCustomMainBinding.inflate(getLayoutInflater());
		setContentView(mBookCustomMainBinding.getRoot());

	}
}
