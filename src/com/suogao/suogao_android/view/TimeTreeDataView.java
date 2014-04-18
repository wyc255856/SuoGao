package com.suogao.suogao_android.view;

import com.suogao.suogao_android.model.TimeTreeDataModel;
import com.suogao.suogaoapp.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TimeTreeDataView extends LinearLayout {
	private Activity mContext;
	private TextView title, time;

	public TimeTreeDataView(Context context) {
		super(context);
		initView(context);
	}

	public TimeTreeDataView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		this.mContext = (Activity) context;
		LayoutInflater.from(context).inflate(R.layout.item_time_tree_data,
				this, true);
		title = (TextView) findViewById(R.id.text);
		time = (TextView) findViewById(R.id.time);
	}

	public void setData(TimeTreeDataModel data, int i) {
		title.setText(data.getText());
		time.setText(data.getTime());
	}
}
