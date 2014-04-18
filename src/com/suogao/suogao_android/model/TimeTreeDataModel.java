package com.suogao.suogao_android.model;

import netlib.model.BaseModel;

public class TimeTreeDataModel extends BaseModel {
	private String text;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
