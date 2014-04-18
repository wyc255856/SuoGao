package com.suogao.suogaoapp;

import com.suogao.suogao_android.adapter.TimeTreeAdapter;
import com.suogao.suogao_android.helper.MenuHelper;

import android.os.Bundle;

public class MainActivity extends BaseListActivity {
	private MenuHelper help;
	private TimeTreeAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub

		super.onCreate(arg0);

	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		super.initData();
		help = new MenuHelper(this);

	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		super.initView();
		adapter = new TimeTreeAdapter(this);
		adapter.refresh(help.getTimeTreeModel().getList());
		listView.setAdapter(adapter);
	}

	@Override
	protected void initAction() {
		// TODO Auto-generated method stub
		super.initAction();
	}

	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return getString(R.string.title_time_tree);
	}

}
