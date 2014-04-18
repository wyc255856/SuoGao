package com.suogao.suogaoapp;

import com.suogao.suogao_android.view.HeadView;
import com.suogao.suogao_android.widget.XListView;

import android.os.Bundle;

public abstract class BaseListActivity extends BaseFragmentActivity {
	protected XListView listView;
	protected HeadView headView;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		initData();
		initView();
		initAction();
	}

	protected void initData() {
		// TODO Auto-generated method stub

	}

	protected void initView() {
		// TODO Auto-generated method stub
		
		listView = (XListView) findViewById(R.id.listView);
		listView.setPullLoadEnable(false);
		listView.setPullRefreshEnable(false);
		headView = (HeadView) findViewById(R.id.headView);
		headView.setTitleText(getTitleText());

	}

	protected void initAction() {
		// TODO Auto-generated method stub

	}

	protected abstract String getTitleText();

}
