package com.suogao.suogaoapp.fragment;

import com.suogao.suogao_android.adapter.TimeTreeAdapter;
import com.suogao.suogao_android.helper.MenuHelper;
import com.suogao.suogaoapp.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TimeTreeFragment extends BaseListFragment {
	private MenuHelper help;
	private TimeTreeAdapter adapter;

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		super.initData();
		help = new MenuHelper(mContext);

	}

	@Override
	protected void initView(View view) {
		// TODO Auto-generated method stub
		super.initView(view);
		adapter = new TimeTreeAdapter(mContext);
		listView.setAdapter(adapter);
	}

	@Override
	protected void initAction() {
		// TODO Auto-generated method stub
		super.initAction();
		adapter.refresh(help.getTimeTreeModel().getList());
	}

	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return getString(R.string.title_time_tree);
	}

	@Override
	protected void clickItem(View view, int position, long id) {
		// TODO Auto-generated method stub

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_time_tree, container, false);
	}

}
