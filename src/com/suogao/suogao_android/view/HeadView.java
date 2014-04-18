package com.suogao.suogao_android.view;

import com.suogao.suogao_android.util.TouchUtil;
import com.suogao.suogaoapp.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeadView extends LinearLayout {

	private FragmentActivity mContext;

	private View backBut, rightMenuButton;

	private TextView top_bar_title_text;

	public HeadView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public HeadView(Context context) {
		super(context);
		initView(context);
	}

	private void initView(Context context) {
		this.mContext = (FragmentActivity) context;
		LayoutInflater.from(context).inflate(R.layout.head_view, this, true);
		top_bar_title_text = (TextView) findViewById(R.id.top_bar_title_text);
		backBut = findViewById(R.id.backBut);
		rightMenuButton = findViewById(R.id.rightMenuButton);
		TouchUtil.createTouchDelegate(backBut, 40);
		TouchUtil.createTouchDelegate(rightMenuButton, 40);
		backBut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 左侧menu点击后事件
				mContext.finish();
			}
		});
	}

	public void hideRightMenu() {
		rightMenuButton.setVisibility(View.GONE);
	}

	public void setRightButtonOnClickListener(OnClickListener onClick) {
		rightMenuButton.setOnClickListener(onClick);
	}
	public void hideLeftMenu() {
		rightMenuButton.setVisibility(View.GONE);
	}

	public void setLeftButtonOnClickListener(OnClickListener onClick) {
		rightMenuButton.setOnClickListener(onClick);
	}

	public void setTitleText(String text) {
		if (text != null) {
			top_bar_title_text.setText(text);
		}
	}
}
