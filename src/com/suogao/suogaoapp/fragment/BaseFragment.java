package com.suogao.suogaoapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author wangyc E-mail:327250924@qq.com
 * @version 创建时间：2013-12-19 上午10:06:36
 * TODO fragment基类
 */
public class BaseFragment extends Fragment {
	protected Context mContext;

	protected String TAG;

	protected final static String INTENT = "intent";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initBaseData();
		initBaseViews();
	}
	
	protected void initBaseData() {
		TAG = toString();
	}

	protected void initBaseViews() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mContext = getActivity();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
