package com.suogao.suogaoapp;

import netlib.helper.DataServiceHelper;
import netlib.net.DataAsyncTaskPool;
import netlib.net.DataJsonAsyncTask;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.suogao.suogao_android.helper.ModelHelper;
import com.suogao.suogao_android.view.HeadView;
import com.suogao.suogao_android.widget.LoadingDialog;

public abstract class BaseEditTextActivity extends BaseFragmentActivity {
	protected HeadView headView;
	protected ModelHelper jsonHelper;
	protected int begin = 0;
	protected final static int LIMIT = 10;
	protected DataJsonAsyncTask asyncTask;
	protected DataAsyncTaskPool dataPool;
	protected DataServiceHelper dataServiceHelper;
	protected LoadingDialog loadingDialog;
    protected String id;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		initData();
		initView();
		initAction();
	}

	// 一些准备数据
	protected void initData() {
		Intent intent=getIntent();
		if(intent!=null){
			id=intent.getStringExtra("id");
		}
		// 数据加载框
		loadingDialog = new LoadingDialog(this, R.style.my_dialog);
		loadingDialog.setCancelable(false);
		loadingDialog.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					if(loadingDialog!=null)
					loadingDialog.cancel();
				}
				return true;
			}
		});
		dataPool = new DataAsyncTaskPool();
		dataServiceHelper = new DataServiceHelper() {

			@Override
			public void preExecute() {
				if (loadingDialog != null && !loadingDialog.isShowing()) {
					loadingDialog.show();
				}
			}

			@Override
			public void postExecute(String TAG, Object result, Object... params) {
				int mode = (Integer) params[0];
				Log.e("tag", "mode = " + mode);
				Log.e("tag", "result = " + result);
				updateView(result, mode);
			}

			@Override
			public Object doInBackground(Object... params) {
				return null;
			}
		};
		jsonHelper = new ModelHelper(this);
	}
	protected  void initView(){
		headView=(HeadView)findViewById(R.id.headView);
		headView.setTitleText(getTitleText());
	}
	protected abstract void initAction();
	protected abstract String getTitleText();
	protected abstract void updateView(Object object, int mode);
}
