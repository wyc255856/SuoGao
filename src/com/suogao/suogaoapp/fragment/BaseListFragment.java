package com.suogao.suogaoapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.suogao.suogao_android.view.HeadView;
import com.suogao.suogao_android.widget.XListView;
import com.suogao.suogaoapp.R;

public abstract class BaseListFragment extends BaseFragment {
	protected XListView listView;
	protected HeadView headView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		initData();
		View view = initView(inflater, container, savedInstanceState);
		initView(view);
		initAction();
		return view;
	}

	protected void initData() {
		// TODO Auto-generated method stub

	}

	protected void initView(View view) {
		// TODO Auto-generated method stub

		listView = (XListView) view.findViewById(R.id.listView);
		listView.setPullLoadEnable(false);
		listView.setPullRefreshEnable(false);
		headView = (HeadView) view.findViewById(R.id.headView);
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

	abstract protected View initView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);
}