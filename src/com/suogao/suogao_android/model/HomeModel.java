package com.suogao.suogao_android.model;

import java.util.List;

import netlib.model.BaseModel;

public class HomeModel extends BaseModel {
	private List<HomeItemModel> dataList;

	public List<HomeItemModel> getDataList() {
		return dataList;
	}

	public void setDataList(List<HomeItemModel> dataList) {
		this.dataList = dataList;
	}
}
