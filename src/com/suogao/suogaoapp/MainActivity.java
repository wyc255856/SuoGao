package com.suogao.suogaoapp;

import android.content.Intent;
import android.view.View;

import com.suogao.suogao_android.adapter.HomeListAdapter;
import com.suogao.suogao_android.helper.MenuHelper;
import com.suogao.suogao_android.view.TabView;

public class MainActivity extends BaseListActivity {
	private MenuHelper help;
	private HomeListAdapter adapter;
	private TabView tab;

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
		tab=new TabView(this);
		adapter = new HomeListAdapter(this);
		adapter.refresh(help.getHomeModel().getDataList());
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

	@Override
	protected void clickItem(View view, int position, long id) {
		Intent intent = new Intent(this, TabChangActivity.class);
		intent.putExtra("tag", tab.getMyLegalCloudID() + "");
		startActivity(intent);
	}

}
