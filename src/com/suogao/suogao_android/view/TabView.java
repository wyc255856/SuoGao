package com.suogao.suogao_android.view;


import com.suogao.suogaoapp.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;


public class TabView extends LinearLayout {

	private Activity mContext;
	private RadioButton home, myLegalCloud, product, risk;

	public TabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public TabView(Context context) {
		super(context);
		initView(context);
	}

	private void initView(Context context) {
		// TODO Auto-generated method stub
		this.mContext = (Activity) context;
		LayoutInflater.from(context).inflate(R.layout.tab_view,
				this, true);
		home = (RadioButton) findViewById(R.id.cook);
		myLegalCloud = (RadioButton) findViewById(R.id.life);
		product = (RadioButton) findViewById(R.id.makeup);
		risk = (RadioButton) findViewById(R.id.doctor);
		home.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lisetener.onHomeClickCallBack(home.getId() + "");
			}
		});
		myLegalCloud.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lisetener.onMyLeaglCloudClickCallBack(myLegalCloud.getId() + "");
			}
		});
		product.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lisetener.onProductClickCallBack(product.getId() + "");
			}
		});
		risk.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lisetener.onRiskClickCallBack(risk.getId() + "");
			}
		});
	}

	private TabOnClickListener lisetener;

	public void setTabOnClickListener(TabOnClickListener lisetener) {
		this.lisetener = lisetener;
	}

	public int getHomeID() {
		return home.getId();
	}
	public int getMyLegalCloudID() {
		return myLegalCloud.getId();
	}
	public int getProductID() {
		return product.getId();
	}
	public int getRiskID() {
		return risk.getId();
	}
	public void selectTab(String tag) {
		if (tag.equals("" + getHomeID())) {
			home.setChecked(true);
		} else if (tag.equals("" + getMyLegalCloudID())) {
			myLegalCloud.setChecked(true);
		} else if (tag.equals("" + getProductID())) {
			product.setChecked(true);
		} else if (tag.equals("" + getRiskID())) {
			risk.setChecked(true);
		}
	}

	public interface TabOnClickListener {
		public void onHomeClickCallBack(String tag);

		public void onMyLeaglCloudClickCallBack(String tag);

		public void onProductClickCallBack(String tag);

		public void onRiskClickCallBack(String tag);
	}

}
