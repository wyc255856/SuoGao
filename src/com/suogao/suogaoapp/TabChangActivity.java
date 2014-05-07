package com.suogao.suogaoapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.suogao.suogao_android.view.TabView;
import com.suogao.suogao_android.view.TabView.TabOnClickListener;
import com.suogao.suogaoapp.fragment.BaseFragment;
import com.suogao.suogaoapp.fragment.JuBenFragment;
import com.suogao.suogaoapp.fragment.TimeTreeFragment;
import com.suogao.suogaoapp.fragment.XuanFaFragment;
import com.suogao.suogaoapp.fragment.ZhuChuangFragment;

public class TabChangActivity extends BaseFragmentActivity {
	private String currentFragmentTag = "";
	private BaseFragment currentFragment;
	private TabView tab;
	private String currentTag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_tab);
		initData();
		initView();
		initAction();

		changeTabs(currentFragmentTag);

	}

	public void changeTabs(String tag) {

		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		if (currentFragment != null && !currentTag.equals(tag)) {
			Log.e("tag", "currentTag=tag");
			BaseFragment subViewFragment = null;
			if (fm.findFragmentByTag(tag) != null) {
				subViewFragment = (BaseFragment) fm.findFragmentByTag(tag);
				ft.hide(currentFragment).show(subViewFragment)
						.commitAllowingStateLoss();
				currentTag = tag;
				currentFragment = subViewFragment;
			} else {
				if (tag.equals(tab.getHomeID() + "")) {
					subViewFragment = new JuBenFragment();
				} else if (tag.equals(tab.getMyLegalCloudID() + "")) {
					subViewFragment = new ZhuChuangFragment();
				} else if (tag.equals(tab.getProductID() + "")) {
					subViewFragment = new XuanFaFragment();
				} else if (tag.equals(tab.getRiskID() + "")) {
					subViewFragment = new TimeTreeFragment();
				}

				if (subViewFragment != null) {
					ft.hide(currentFragment)
							.add(R.id.container, subViewFragment, tag)
							.commitAllowingStateLoss();
					currentTag = tag;
					currentFragment = subViewFragment;
				}
			}
		} else if (currentFragment == null) {
			Log.e("tag", "currentTag!=" + currentFragmentTag);
			if (currentTag != null && currentTag.equals(tag)) {

			} else {
				BaseFragment subViewFragment = null;
				if (tag.equals(tab.getHomeID() + "")) {
					subViewFragment = new JuBenFragment();
				} else if (tag.equals(tab.getMyLegalCloudID() + "")) {
					subViewFragment = new ZhuChuangFragment();
				} else if (tag.equals(tab.getProductID() + "")) {
					subViewFragment = new XuanFaFragment();
				} else if (tag.equals(tab.getRiskID() + "")) {
					subViewFragment = new TimeTreeFragment();
				}
				if (subViewFragment != null) {
					ft.replace(R.id.container, subViewFragment, tag);
					ft.commit();// 提交
					currentTag = tag;
					currentFragment = subViewFragment;
				}
			}
		}

	}

	private void initAction() {

		tab.setTabOnClickListener(new TabOnClickListener() {

			public void onHomeClickCallBack(String tag) {
				changeTabs(tag);
			}

			@Override
			public void onMyLeaglCloudClickCallBack(String tag) {
				changeTabs(tag);
			}

			@Override
			public void onProductClickCallBack(String tag) {
				changeTabs(tag);
			}

			@Override
			public void onRiskClickCallBack(String tag) {
				changeTabs(tag);
			}
		});
	}

	private void initData() {
		currentFragmentTag = getIntent().getStringExtra("tag");
	}

	private void initView() {
		tab = (TabView) findViewById(R.id.tab);
		changeSelect(currentFragmentTag);
		tab.selectTab(currentFragmentTag);
	}

	public void changeSelect(String tag) {
		tab.selectTab(tag);
	}

}
