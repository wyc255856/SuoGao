package com.suogao.suogaoapp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class RegisterActivity extends BaseEditTextActivity {
	private View register;

	@Override
	protected void initView() {
		setContentView(R.layout.activity_register);
		super.initView();
		register = findViewById(R.id.register);
	}

	@Override
	protected void initAction() {
		// TODO Auto-generated method stub
		register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(RegisterActivity.this,
						MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();

			}
		});
	}

	@Override
	protected void updateView(Object object, int mode) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return getString(R.string.register_text);
	}

}
