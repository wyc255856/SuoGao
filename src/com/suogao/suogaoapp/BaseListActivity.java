package com.suogao.suogaoapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.suogao.suogao_android.view.HeadView;
import com.suogao.suogao_android.widget.XListView;

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

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				clickItem(view, position, id);
			}
		});
	}

	protected abstract String getTitleText();

	protected abstract void clickItem(View view, int position, long id);

}
