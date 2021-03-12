package com.example.customview.widget;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.customview.R;
import com.example.customview.view.ExpandableTextView;
import com.example.customview.view.ExpandableTextView.ExpandableClickListener;

import java.util.Random;

public class TextViewMainActivity extends AppCompatActivity implements View.OnClickListener {


	private TextView mTVComparison;
	private Button mBtnUpdateText;
	private Button mBtnToListView;

	private ExpandableTextView mETV;
	private ExpandableTextView expandClick;
	private CharSequence[] mPoems = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_textview_mainv2);
		underLine();
		mPoems = getResources().getStringArray(R.array.poems);

		mTVComparison = (TextView) this.findViewById(R.id.tv_comparison);
		mBtnUpdateText = (Button) this.findViewById(R.id.button_update_text);
		mBtnToListView = (Button) this.findViewById(R.id.button_to_list_view);
		mETV = (ExpandableTextView) this.findViewById(R.id.etv);
		expandClick = (ExpandableTextView) this.findViewById(R.id.expand_click);

		mBtnUpdateText.setOnClickListener(this);
		mBtnToListView.setOnClickListener(this);

		// 测试添加OnClickListener的情况，功能正常。添加外部的onClick事件后，原来的点击toggle功能自动屏蔽，
		// 点击尾部的ClickableSpan仍然有效 有效的原因是:
		// 1.外部添加onClick 后 hasOnClickListeners() == true
		// 2.(getOnClickListener(ExpandableTextView.this) instanceof ExpandableClickListener) == false
		//   所以调到了 TouchableSpan 中的 onClick
//        mETV.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                switch (mETV.getExpandState()){
//                    case ExpandableTextView.STATE_SHRINK:
//                        Toast.makeText(getApplicationContext(),"ExpandableTextView clicked, STATE_SHRINK",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                    case ExpandableTextView.STATE_EXPAND:
//                        Toast.makeText(getApplicationContext(),"ExpandableTextView clicked, STATE_EXPAND",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
//        mETV.setText(mPoems[0]);//在ExpandableTextView在创建完成之前改变文字，功能正常

		expandClick.setExpandListener(new ExpandableTextView.OnExpandListener() {
			@Override
			public void onExpand(ExpandableTextView view) {
				Toast.makeText(getApplicationContext(),"onExpand",
                                Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onShrink(ExpandableTextView view) {
				Toast.makeText(getApplicationContext(),"onShrink",
						Toast.LENGTH_SHORT).show();
			}
		});
		expandClick.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (expandClick.getExpandState()){
                    case ExpandableTextView.STATE_SHRINK:
                        Toast.makeText(getApplicationContext(),"ExpandableTextView clicked, STATE_SHRINK",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case ExpandableTextView.STATE_EXPAND:
                        Toast.makeText(getApplicationContext(),"ExpandableTextView clicked, STATE_EXPAND",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
			}
		});



	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.button_to_list_view:
				gotoCheckInListView();
				break;
			case R.id.button_update_text:
				updateText();
				break;
		}
	}

	private void gotoCheckInListView() {
		Intent intent = new Intent(this, ActivityListView.class);
		startActivity(intent);
	}

	private Random mRandom = new Random();
	private int prevRandomInt = -1;
	private int currRandomInt = -1;

	private void updateText() {
		currRandomInt = mRandom.nextInt(mPoems.length);
		while (prevRandomInt == currRandomInt) {
			currRandomInt = mRandom.nextInt(mPoems.length);
		}
		prevRandomInt = currRandomInt;
		CharSequence newCS = mPoems[currRandomInt];

		mTVComparison.setText(newCS);//作为对比示例
		mETV.setText(newCS);//效果显示
	}


	private void underLine() {
		String wText = "W : ";
		String underlineText = "email@address.com";

		SpannableStringBuilder ssb = new SpannableStringBuilder();
		ssb.append(wText);
		ssb.append(underlineText);
		ssb.setSpan(new UnderlineSpan(), ssb.length() - underlineText.length(), ssb.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TextAppearanceSpan("normal", android.R.style.TextAppearance_Medium, 14,
						ColorStateList.valueOf(Color.RED), ColorStateList.valueOf(Color.RED)),
				ssb.length() - underlineText.length(), ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		TextView tv1 = (TextView) findViewById(R.id.spannable_text1);
		tv1.setText(ssb);

		TextView tv2 = (TextView) findViewById(R.id.spannable_text2);
		tv2.setText(Html.fromHtml(wText + "<u><font color=\"#FF0000\">" + underlineText + "</font></u>"));


		TextView t3 = (TextView) findViewById(R.id.spannable_text3);
		SpannableString content = new SpannableString(underlineText);
		UnderlineSpan us = new UnderlineSpan();
		TextPaint tp = new TextPaint();
		tp.setColor(ContextCompat.getColor(TextViewMainActivity.this, R.color.white));
		us.updateDrawState(tp);
		content.setSpan(us, 0, underlineText.length(), 0);
		t3.setText(content);
	}
}
