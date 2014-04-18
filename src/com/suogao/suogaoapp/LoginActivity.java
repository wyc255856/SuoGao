package com.suogao.suogaoapp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginActivity extends BaseEditTextActivity {
private View login,register;
	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_login);
		super.initView();
		login=findViewById(R.id.login);
		register=findViewById(R.id.register);
	}

	@Override
	protected void initAction() {
		// TODO Auto-generated method stub
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(LoginActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
		headView.hideLeftMenu();
	}

	@Override
	protected void updateView(Object object, int mode) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return getString(R.string.login_text);
	}

}
