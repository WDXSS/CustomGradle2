package com.example.customview.other;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.customview.R;
import com.example.customview.other.behavior.AppBarLayoutOverScrollViewBehavior;
import com.google.android.material.appbar.AppBarLayout;

public class CoordinatorLayoutBehaviorActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activtit_coordinator_layout_behavier);

//		AppBarLayout appBar = (AppBarLayout) findViewById(R.id.appbar);
//		CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//		params.setBehavior(new AppBarLayoutOverScrollViewBehavior());
//		appBar.setLayoutParams(params);
	}
}
