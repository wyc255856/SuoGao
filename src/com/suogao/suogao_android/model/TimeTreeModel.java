package com.suogao.suogao_android.model;

import java.util.List;

import netlib.model.BaseModel;

public class TimeTreeModel extends BaseModel {
	private List<TimeTreeItemModel> list;

	public List<TimeTreeItemModel> getList() {
		return list;
	}

	public void setList(List<TimeTreeItemModel> list) {
		this.list = list;
	}
}
