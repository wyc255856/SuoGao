package com.suogao.suogao_android.model;

import java.util.List;

import netlib.model.BaseModel;

public class TabMenuModel extends BaseModel {
private List<TabMenuItemModel> dataList;
private List<TabMenuItemModel> zcList;
	private List<TabMenuItemModel> xfList;

	public List<TabMenuItemModel> getDataList() {
		return dataList;
	}

	public void setDataList(List<TabMenuItemModel> dataList) {
		this.dataList = dataList;
	}

	public List<TabMenuItemModel> getZcList() {
		return zcList;
	}

	public void setZcList(List<TabMenuItemModel> zcList) {
		this.zcList = zcList;
	}

	public List<TabMenuItemModel> getXfList() {
		return xfList;
	}

	public void setXfList(List<TabMenuItemModel> xfList) {
		this.xfList = xfList;
	}
}
