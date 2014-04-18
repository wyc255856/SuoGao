package com.suogao.suogao_android.model;

import java.util.List;

import netlib.model.BaseModel;

public class TimeTreeItemModel extends BaseModel {
	private String title;
	private String date;
	private List<TimeTreeDataModel> dataList;
	private boolean open;

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<TimeTreeDataModel> getDataList() {
		return dataList;
	}

	public void setDataList(List<TimeTreeDataModel> dataList) {
		this.dataList = dataList;
	}
}
